package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ad;
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
    while (i < c.Rzr.length)
    {
      cgiFunNameVector.add(c.Rzr[i]);
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
    com.tencent.mm.wallet_core.c.b.iiL();
    Log.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.iiL().init(MMApplicationContext.getContext());
    erc localerc = (erc)d.b.b(this.rr.lBR);
    str1 = "";
    String str2 = "";
    if (localerc.TrF != null) {
      str1 = new String(localerc.TrF.Tkb.UH);
    }
    if (localerc.TRP != null) {
      str2 = new String(localerc.TRP.Tkb.UH);
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    ad.iiX();
    str2 = ad.getCrtNo();
    com.tencent.mm.wallet_core.c.b.iiL();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      h.IzE.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.iiL();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      if (Util.isNullOrNil(str3))
      {
        h localh = h.IzE;
        com.tencent.mm.wallet_core.c.b.iiL();
        localh.a(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
      }
      h.IzE.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      Log.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localerc.sign = str3;
      localerc.Uto = str2;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.iiL();
      Log.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    }
  }
  
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getCommReqResp();
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = new d.a();
      ((d.a)localObject1).lBU = new erc();
      ((d.a)localObject1).lBV = new erd();
      localObject2 = getUri();
      int i = getFuncId();
      ((d.a)localObject1).uri = ((String)localObject2);
      ((d.a)localObject1).funcId = i;
      ((d.a)localObject1).lBW = 185;
      ((d.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((d.a)localObject1).bgN();
      if (!canRetry())
      {
        bool = true;
        ((d)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (erc)d.b.b(((d)localObject1).lBR);
      if (paramBoolean1) {
        ((erc)localObject2).TrD = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((erc)localObject2).TrE = 1;
      }
      setCommReqResp((d)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    certSignConfig();
    if (this.isFake)
    {
      int i = doSceneSimulately(this.rr, paramg, parami);
      if (i != -1) {
        return i;
      }
    }
    if (z.bdq())
    {
      Log.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      parami.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(d paramd, g paramg, i parami)
  {
    paramg = (erc)d.b.b(paramd.lBR);
    if (paramg.TrF != null) {
      new String(paramg.TrF.Tkb.UH);
    }
    if (paramg.TRP != null) {
      new String(paramg.TRP.Tkb.UH);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    ae.iiZ();
    if (this.isFake)
    {
      parami = (erd)d.c.b(paramd.lBS);
      paramg = parami;
      if (parami == null) {
        paramg = new erd();
      }
      parami = "".getBytes();
      paramg.TrG = new eae().dc(parami);
      paramg.TrJ = getPayCgicmd();
      paramg.TrH = 0;
      try
      {
        parami = new JSONObject(null);
        paramg.TRQ = parami.optInt("TenpayErrType");
        paramg.TRR = parami.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramd, null);
        return 1;
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
  
  public x getRetModel(d paramd)
  {
    paramd = (erd)d.c.b(paramd.lBS);
    x localx = new x();
    localx.TrJ = paramd.TrJ;
    localx.TrI = paramd.TrI;
    localx.TrH = paramd.TrH;
    localx.TrG = paramd.TrG;
    localx.vhu = paramd.TRR;
    localx.YVB = paramd.TRQ;
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
  
  public void putToReqText(d paramd, eae parameae)
  {
    ((erc)d.b.b(paramd.lBR)).TrF = parameae;
  }
  
  public void putToWXReqText(d paramd, eae parameae)
  {
    ((erc)d.b.b(paramd.lBR)).TRP = parameae;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */