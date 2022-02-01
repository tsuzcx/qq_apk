package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ad;
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
    while (i < c.FEy.length)
    {
      cgiFunNameVector.add(c.FEy[i]);
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      return;
    }
    com.tencent.mm.wallet_core.c.b.fVM();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.fVM().init(ak.getContext());
    dng localdng = (dng)this.rr.hQD.hQJ;
    str1 = "";
    String str2 = "";
    if (localdng.HcP != null) {
      str1 = new String(localdng.HcP.getBufferToBytes());
    }
    if (localdng.Hxc != null) {
      str2 = new String(localdng.Hxc.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    ad.fVY();
    str2 = ad.getCrtNo();
    com.tencent.mm.wallet_core.c.b.fVM();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      g.yxI.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.fVM();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      if (bu.isNullOrNil(str3))
      {
        g localg = g.yxI;
        com.tencent.mm.wallet_core.c.b.fVM();
        localg.f(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
      }
      g.yxI.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localdng.sign = str3;
      localdng.HUr = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.fVM();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
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
      ((b.a)localObject1).hQF = new dng();
      ((b.a)localObject1).hQG = new dnh();
      localObject2 = getUri();
      int i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).hQH = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).aDS();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.ak.b)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (dng)((com.tencent.mm.ak.b)localObject1).hQD.hQJ;
      if (paramBoolean1) {
        ((dng)localObject2).HcN = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((dng)localObject2).HcO = 1;
      }
      setCommReqResp((com.tencent.mm.ak.b)localObject1);
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
    if (v.aAR())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.ak.b paramb, e parame, f paramf)
  {
    parame = (dng)paramb.hQD.hQJ;
    if (parame.HcP != null) {
      new String(parame.HcP.getBufferToBytes());
    }
    if (parame.Hxc != null) {
      new String(parame.Hxc.getBufferToBytes());
    }
    ak.getContext();
    getPayCgicmd();
    com.tencent.mm.wallet_core.c.ae.fWa();
    if (this.isFake)
    {
      paramf = (dnh)paramb.hQE.hQJ;
      parame = paramf;
      if (paramf == null) {
        parame = new dnh();
      }
      paramf = "".getBytes();
      parame.HcQ = new SKBuiltinBuffer_t().setBuffer(paramf);
      parame.HcT = getPayCgicmd();
      parame.HcR = 0;
      try
      {
        paramf = new JSONObject(null);
        parame.Hxd = paramf.optInt("TenpayErrType");
        parame.Hxe = paramf.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramb, null);
        return 1;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.NetSenceTenPayBase", parame, "", new Object[0]);
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
  
  public x getRetModel(com.tencent.mm.ak.b paramb)
  {
    paramb = (dnh)paramb.hQE.hQJ;
    x localx = new x();
    localx.HcT = paramb.HcT;
    localx.HcS = paramb.HcS;
    localx.HcR = paramb.HcR;
    localx.HcQ = paramb.HcQ;
    localx.qkR = paramb.Hxe;
    localx.LVm = paramb.Hxd;
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
  
  public void putToReqText(com.tencent.mm.ak.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dng)paramb.hQD.hQJ).HcP = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(com.tencent.mm.ak.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dng)paramb.hQD.hQJ).Hxc = paramSKBuiltinBuffer_t;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */