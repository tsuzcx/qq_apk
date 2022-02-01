package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.aj;
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
    while (i < c.CoB.length)
    {
      cgiFunNameVector.add(c.CoB[i]);
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
    com.tencent.mm.wallet_core.c.b.fjR();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.fjR().init(aj.getContext());
    dbk localdbk = (dbk)this.rr.gUS.gUX;
    str1 = "";
    String str2 = "";
    if (localdbk.DEu != null) {
      str1 = new String(localdbk.DEu.getBufferToBytes());
    }
    if (localdbk.DWE != null) {
      str2 = new String(localdbk.DWE.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    com.tencent.mm.wallet_core.c.ad.fkc();
    str2 = com.tencent.mm.wallet_core.c.ad.getCrtNo();
    com.tencent.mm.wallet_core.c.b.fjR();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      h.vKh.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.fjR();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      h.vKh.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localdbk.sign = str3;
      localdbk.EsX = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.fjR();
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
      ((b.a)localObject1).gUU = new dbk();
      ((b.a)localObject1).gUV = new dbl();
      localObject2 = getUri();
      int i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).atI();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.al.b)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (dbk)((com.tencent.mm.al.b)localObject1).gUS.gUX;
      if (paramBoolean1) {
        ((dbk)localObject2).DEs = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((dbk)localObject2).DEt = 1;
      }
      setCommReqResp((com.tencent.mm.al.b)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    certSignConfig();
    if (this.isFake)
    {
      int i = doSceneSimulately(this.rr, parame, paramg);
      if (i != -1) {
        return i;
      }
    }
    if (u.aqV())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramg.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.al.b paramb, e parame, g paramg)
  {
    parame = (dbk)paramb.gUS.gUX;
    if (parame.DEu != null) {
      new String(parame.DEu.getBufferToBytes());
    }
    if (parame.DWE != null) {
      new String(parame.DWE.getBufferToBytes());
    }
    aj.getContext();
    getPayCgicmd();
    ae.fke();
    if (this.isFake)
    {
      paramg = (dbl)paramb.gUT.gUX;
      parame = paramg;
      if (paramg == null) {
        parame = new dbl();
      }
      paramg = "".getBytes();
      parame.DEv = new SKBuiltinBuffer_t().setBuffer(paramg);
      parame.DEy = getPayCgicmd();
      parame.DEw = 0;
      try
      {
        paramg = new JSONObject(null);
        parame.DWF = paramg.optInt("TenpayErrType");
        parame.DWG = paramg.optString("TenpayErrMsg");
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
    paramb = (dbl)paramb.gUT.gUX;
    x localx = new x();
    localx.DEy = paramb.DEy;
    localx.DEx = paramb.DEx;
    localx.DEw = paramb.DEw;
    localx.DEv = paramb.DEv;
    localx.oXw = paramb.DWG;
    localx.IdR = paramb.DWF;
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
    ((dbk)paramb.gUS.gUX).DEu = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(com.tencent.mm.al.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dbk)paramb.gUS.gUX).DWE = paramSKBuiltinBuffer_t;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */