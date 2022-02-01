package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fmk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.ae;
import com.tencent.mm.wallet_core.model.af;
import com.tencent.mm.wallet_core.model.s;
import com.tencent.mm.wallet_core.model.x;
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
    while (i < com.tencent.mm.pluginsdk.wallet.c.YvP.length)
    {
      cgiFunNameVector.add(com.tencent.mm.pluginsdk.wallet.c.YvP[i]);
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
      Log.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      return;
    }
    com.tencent.mm.wallet_core.model.b.jOG();
    Log.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.model.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.model.b.jOG().init(MMApplicationContext.getContext());
    fmj localfmj = (fmj)c.b.b(this.rr.otB);
    str1 = "";
    String str2 = "";
    if (localfmj.aaFR != null) {
      str1 = new String(localfmj.aaFR.aaxD.Op);
    }
    if (localfmj.abio != null) {
      str2 = new String(localfmj.abio.aaxD.Op);
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    ae.jOT();
    str2 = ae.getCrtNo();
    com.tencent.mm.wallet_core.model.b.jOG();
    if (com.tencent.mm.wallet_core.model.b.isCertExist(str2))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.model.b.jOG();
      String str3 = com.tencent.mm.wallet_core.model.b.genUserSig(str2, str1);
      if (Util.isNullOrNil(str3))
      {
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        com.tencent.mm.wallet_core.model.b.jOG();
        localh.b(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.model.b.getLastError()) });
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      Log.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localfmj.sign = str3;
      localfmj.abMG = str2;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.model.b.jOG();
      Log.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.model.b.getLastError()) });
    }
  }
  
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getCommReqResp();
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new fmj();
      ((c.a)localObject1).otF = new fmk();
      localObject2 = getUri();
      int i = getFuncId();
      ((c.a)localObject1).uri = ((String)localObject2);
      ((c.a)localObject1).funcId = i;
      ((c.a)localObject1).otG = 185;
      ((c.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((c.a)localObject1).bEF();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.am.c)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (fmj)c.b.b(((com.tencent.mm.am.c)localObject1).otB);
      if (paramBoolean1) {
        ((fmj)localObject2).aaFP = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((fmj)localObject2).aaFQ = 1;
      }
      setCommReqResp((com.tencent.mm.am.c)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    this.callback = paramh;
    certSignConfig();
    if (this.isFake)
    {
      int i = doSceneSimulately(this.rr, paramg, paramh);
      if (i != -1) {
        return i;
      }
    }
    if (z.bBi())
    {
      Log.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramh.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.am.c paramc, g paramg, com.tencent.mm.am.h paramh)
  {
    paramg = (fmj)c.b.b(paramc.otB);
    if (paramg.aaFR != null) {
      new String(paramg.aaFR.aaxD.Op);
    }
    if (paramg.abio != null) {
      new String(paramg.abio.aaxD.Op);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    String str = af.jOV();
    if ((str != null) || (this.isFake))
    {
      paramg = (fmk)c.c.b(paramc.otC);
      if (paramg != null) {
        break label221;
      }
      paramg = new fmk();
    }
    label221:
    for (;;)
    {
      if (str == null) {
        paramh = "".getBytes();
      }
      for (;;)
      {
        paramg.aaFS = new gol().df(paramh);
        paramg.aaFV = getPayCgicmd();
        paramg.aaFT = 0;
        try
        {
          paramh = new JSONObject(str);
          paramg.abip = paramh.optInt("TenpayErrType");
          paramg.abiq = paramh.optString("TenpayErrMsg");
          onGYNetEnd(1, 0, 0, "", paramc, null);
          return 1;
          paramh = str.getBytes();
        }
        catch (Exception paramg)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSenceTenPayBase", paramg, "", new Object[0]);
          }
        }
      }
      return -1;
    }
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
  
  public x getRetModel(com.tencent.mm.am.c paramc)
  {
    paramc = (fmk)c.c.b(paramc.otC);
    x localx = new x();
    localx.aaFV = paramc.aaFV;
    localx.aaFU = paramc.aaFU;
    localx.aaFT = paramc.aaFT;
    localx.aaFS = paramc.aaFS;
    localx.ytw = paramc.abiq;
    localx.agTv = paramc.abip;
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
  
  public void putToReqText(com.tencent.mm.am.c paramc, gol paramgol)
  {
    ((fmj)c.b.b(paramc.otB)).aaFR = paramgol;
  }
  
  public void putToWXReqText(com.tencent.mm.am.c paramc, gol paramgol)
  {
    ((fmj)c.b.b(paramc.otB)).abio = paramgol;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */