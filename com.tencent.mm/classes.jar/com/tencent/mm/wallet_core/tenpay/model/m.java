package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.b;
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
    while (i < c.KxD.length)
    {
      cgiFunNameVector.add(c.KxD[i]);
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
    b.hhj();
    Log.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(b.getLastError()) });
    long l = System.currentTimeMillis();
    b.hhj().init(MMApplicationContext.getContext());
    eha localeha = (eha)this.rr.iLK.iLR;
    str1 = "";
    String str2 = "";
    if (localeha.MhS != null) {
      str1 = new String(localeha.MhS.getBufferToBytes());
    }
    if (localeha.MGc != null) {
      str2 = new String(localeha.MGc.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    ad.hhv();
    str2 = ad.getCrtNo();
    b.hhj();
    if (b.isCertExist(str2))
    {
      h.CyF.idkeyStat(414L, 20L, 1L, true);
      b.hhj();
      String str3 = b.genUserSig(str2, str1);
      if (Util.isNullOrNil(str3))
      {
        h localh = h.CyF;
        b.hhj();
        localh.a(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(b.getLastError()) });
      }
      h.CyF.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      Log.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localeha.sign = str3;
      localeha.NgK = str2;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      b.hhj();
      Log.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(b.getLastError()) });
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
      ((d.a)localObject1).iLN = new eha();
      ((d.a)localObject1).iLO = new ehb();
      localObject2 = getUri();
      int i = getFuncId();
      ((d.a)localObject1).uri = ((String)localObject2);
      ((d.a)localObject1).funcId = i;
      ((d.a)localObject1).iLP = 185;
      ((d.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((d.a)localObject1).aXF();
      if (!canRetry())
      {
        bool = true;
        ((d)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (eha)((d)localObject1).iLK.iLR;
      if (paramBoolean1) {
        ((eha)localObject2).MhQ = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((eha)localObject2).MhR = 1;
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
    if (z.aUo())
    {
      Log.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      parami.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(d paramd, g paramg, i parami)
  {
    paramg = (eha)paramd.iLK.iLR;
    if (paramg.MhS != null) {
      new String(paramg.MhS.getBufferToBytes());
    }
    if (paramg.MGc != null) {
      new String(paramg.MGc.getBufferToBytes());
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    ae.hhx();
    if (this.isFake)
    {
      parami = (ehb)paramd.iLL.iLR;
      paramg = parami;
      if (parami == null) {
        paramg = new ehb();
      }
      parami = "".getBytes();
      paramg.MhT = new SKBuiltinBuffer_t().setBuffer(parami);
      paramg.MhW = getPayCgicmd();
      paramg.MhU = 0;
      try
      {
        parami = new JSONObject(null);
        paramg.MGd = parami.optInt("TenpayErrType");
        paramg.MGe = parami.optString("TenpayErrMsg");
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
    paramd = (ehb)paramd.iLL.iLR;
    x localx = new x();
    localx.MhW = paramd.MhW;
    localx.MhV = paramd.MhV;
    localx.MhU = paramd.MhU;
    localx.MhT = paramd.MhT;
    localx.rBM = paramd.MGe;
    localx.Ruc = paramd.MGd;
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
  
  public void putToReqText(d paramd, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((eha)paramd.iLK.iLR).MhS = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(d paramd, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((eha)paramd.iLK.iLR).MGc = paramSKBuiltinBuffer_t;
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