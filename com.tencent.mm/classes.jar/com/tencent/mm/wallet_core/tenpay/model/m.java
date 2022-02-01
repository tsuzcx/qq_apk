package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class m
  extends s
{
  public static final boolean IS_SPLIT_CGI = true;
  public static final String TAG = "MicroMsg.NetSenceTenPayBase";
  public static Vector<String> cgiFunNameVector = new Vector();
  protected boolean isFake = false;
  
  static
  {
    int i = 0;
    while (i < c.Fma.length)
    {
      cgiFunNameVector.add(c.Fma[i]);
      i += 1;
    }
  }
  
  public boolean canRetry()
  {
    return true;
  }
  
  public void certSignConfig()
  {
    String str1 = this.rr.getUri();
    if (cgiFunNameVector.contains(str1))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      return;
    }
    com.tencent.mm.wallet_core.c.b.fRq();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.fRq().init(aj.getContext());
    dmj localdmj = (dmj)this.rr.hNK.hNQ;
    str1 = "";
    String str2 = "";
    if (localdmj.GJo != null) {
      str1 = new String(localdmj.GJo.getBufferToBytes());
    }
    if (localdmj.HdC != null) {
      str2 = new String(localdmj.HdC.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    com.tencent.mm.wallet_core.c.ad.fRC();
    str2 = com.tencent.mm.wallet_core.c.ad.getCrtNo();
    com.tencent.mm.wallet_core.c.b.fRq();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      g.yhR.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.fRq();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      if (bt.isNullOrNil(str3))
      {
        g localg = g.yhR;
        com.tencent.mm.wallet_core.c.b.fRq();
        localg.f(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
      }
      g.yhR.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localdmj.sign = str3;
      localdmj.HAE = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.fRq();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    }
  }
  
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getCommReqResp();
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = new dmj();
      ((b.a)localObject1).hNN = new dmk();
      localObject2 = getUri();
      int i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).hNO = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).aDC();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.al.b)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (dmj)((com.tencent.mm.al.b)localObject1).hNK.hNQ;
      if (paramBoolean1) {
        ((dmj)localObject2).GJm = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((dmj)localObject2).GJn = 1;
      }
      setCommReqResp((com.tencent.mm.al.b)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    certSignConfig();
    if (this.isFake)
    {
      int i = doSceneSimulately(this.rr, parame, paramf);
      if (i != -1) {
        return i;
      }
    }
    if (u.aAB())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.al.b paramb, e parame, f paramf)
  {
    parame = (dmj)paramb.hNK.hNQ;
    if (parame.GJo != null) {
      new String(parame.GJo.getBufferToBytes());
    }
    if (parame.HdC != null) {
      new String(parame.HdC.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fRE();
    if (this.isFake)
    {
      paramf = (dmk)paramb.hNL.hNQ;
      parame = paramf;
      if (paramf == null) {
        parame = new dmk();
      }
      paramf = "".getBytes();
      parame.GJp = new SKBuiltinBuffer_t().setBuffer(paramf);
      parame.GJs = getPayCgicmd();
      parame.GJq = 0;
      try
      {
        paramf = new JSONObject(null);
        parame.HdD = paramf.optInt("TenpayErrType");
        parame.HdE = paramf.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramb, null);
        return 1;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSenceTenPayBase", parame, "", new Object[0]);
        }
      }
    }
    return -1;
  }
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getFuncId()
  {
    return 385;
  }
  
  public int getPayCgicmd()
  {
    return getTenpayCgicmd();
  }
  
  public x getRetModel(com.tencent.mm.al.b paramb)
  {
    paramb = (dmk)paramb.hNL.hNQ;
    x localx = new x();
    localx.GJs = paramb.GJs;
    localx.GJr = paramb.GJr;
    localx.GJq = paramb.GJq;
    localx.GJp = paramb.GJp;
    localx.qem = paramb.HdE;
    localx.Lyx = paramb.HdD;
    return localx;
  }
  
  public abstract int getTenpayCgicmd();
  
  public int getType()
  {
    return 385;
  }
  
  public String getUri()
  {
    return "/cgi-bin/micromsg-bin/tenpay";
  }
  
  public void putToReqText(com.tencent.mm.al.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dmj)paramb.hNK.hNQ).GJo = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(com.tencent.mm.al.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dmj)paramb.hNK.hNQ).HdC = paramSKBuiltinBuffer_t;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */