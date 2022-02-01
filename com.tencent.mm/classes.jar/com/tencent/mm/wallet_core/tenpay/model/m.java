package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
    while (i < c.DGT.length)
    {
      cgiFunNameVector.add(c.DGT[i]);
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
      ac.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      return;
    }
    com.tencent.mm.wallet_core.c.b.fAg();
    ac.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.fAg().init(ai.getContext());
    dgw localdgw = (dgw)this.rr.hvr.hvw;
    str1 = "";
    String str2 = "";
    if (localdgw.EZP != null) {
      str1 = new String(localdgw.EZP.getBufferToBytes());
    }
    if (localdgw.Ftw != null) {
      str2 = new String(localdgw.Ftw.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    ad.fAs();
    str2 = ad.getCrtNo();
    com.tencent.mm.wallet_core.c.b.fAg();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      h.wUl.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.fAg();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      h.wUl.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      ac.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localdgw.sign = str3;
      localdgw.FPZ = str2;
    }
    for (;;)
    {
      ac.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.fAg();
      ac.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
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
      ((b.a)localObject1).hvt = new dgw();
      ((b.a)localObject1).hvu = new dgx();
      localObject2 = getUri();
      int i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).aAz();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.ak.b)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (dgw)((com.tencent.mm.ak.b)localObject1).hvr.hvw;
      if (paramBoolean1) {
        ((dgw)localObject2).EZN = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((dgw)localObject2).EZO = 1;
      }
      setCommReqResp((com.tencent.mm.ak.b)localObject1);
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
    if (u.axL())
    {
      ac.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramg.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.ak.b paramb, e parame, g paramg)
  {
    parame = (dgw)paramb.hvr.hvw;
    if (parame.EZP != null) {
      new String(parame.EZP.getBufferToBytes());
    }
    if (parame.Ftw != null) {
      new String(parame.Ftw.getBufferToBytes());
    }
    ai.getContext();
    getPayCgicmd();
    ae.fAu();
    if (this.isFake)
    {
      paramg = (dgx)paramb.hvs.hvw;
      parame = paramg;
      if (paramg == null) {
        parame = new dgx();
      }
      paramg = "".getBytes();
      parame.EZQ = new SKBuiltinBuffer_t().setBuffer(paramg);
      parame.EZT = getPayCgicmd();
      parame.EZR = 0;
      try
      {
        paramg = new JSONObject(null);
        parame.Ftx = paramg.optInt("TenpayErrType");
        parame.Fty = paramg.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramb, null);
        return 1;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSenceTenPayBase", parame, "", new Object[0]);
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
    paramb = (dgx)paramb.hvs.hvw;
    x localx = new x();
    localx.EZT = paramb.EZT;
    localx.EZS = paramb.EZS;
    localx.EZR = paramb.EZR;
    localx.EZQ = paramb.EZQ;
    localx.pAH = paramb.Fty;
    localx.JFt = paramb.Ftx;
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
    ((dgw)paramb.hvr.hvw).EZP = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(com.tencent.mm.ak.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((dgw)paramb.hvr.hvw).Ftw = paramSKBuiltinBuffer_t;
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