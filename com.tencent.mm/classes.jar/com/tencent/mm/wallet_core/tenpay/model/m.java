package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class m
  extends q
{
  public static final boolean IS_SPLIT_CGI = true;
  public static final String TAG = "MicroMsg.NetSenceTenPayBase";
  public static Vector<String> cgiFunNameVector = new Vector();
  protected boolean isFake = false;
  
  static
  {
    int i = 0;
    while (i < com.tencent.mm.pluginsdk.wallet.e.wgE.length)
    {
      cgiFunNameVector.add(com.tencent.mm.pluginsdk.wallet.e.wgE[i]);
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
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      return;
    }
    com.tencent.mm.wallet_core.c.b.dSi();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    long l = System.currentTimeMillis();
    com.tencent.mm.wallet_core.c.b.dSi().init(ah.getContext());
    cjs localcjs = (cjs)this.rr.fsV.fta;
    str1 = "";
    String str2 = "";
    if (localcjs.xkK != null) {
      str1 = new String(localcjs.xkK.getBufferToBytes());
    }
    if (localcjs.xAv != null) {
      str2 = new String(localcjs.xAv.getBufferToBytes());
    }
    str1 = new String((str1 + "&&" + str2).getBytes());
    com.tencent.mm.wallet_core.c.ab.dSv();
    str2 = com.tencent.mm.wallet_core.c.ab.getCrtNo();
    com.tencent.mm.wallet_core.c.b.dSi();
    if (com.tencent.mm.wallet_core.c.b.isCertExist(str2))
    {
      h.qsU.idkeyStat(414L, 20L, 1L, true);
      com.tencent.mm.wallet_core.c.b.dSi();
      String str3 = com.tencent.mm.wallet_core.c.b.genUserSig(str2, str1);
      h.qsU.idkeyStat(414L, 21L, System.currentTimeMillis() - l, true);
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
      localcjs.sign = str3;
      localcjs.xTJ = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
      return;
      com.tencent.mm.wallet_core.c.b.dSi();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
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
      ((b.a)localObject1).fsX = new cjs();
      ((b.a)localObject1).fsY = new cjt();
      localObject2 = getUri();
      int i = getFuncId();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).funcId = i;
      ((b.a)localObject1).reqCmdId = 185;
      ((b.a)localObject1).respCmdId = 1000000185;
      localObject1 = ((b.a)localObject1).ado();
      if (!canRetry())
      {
        bool = true;
        ((com.tencent.mm.ai.b)localObject1).setIsUserCmd(bool);
      }
    }
    for (;;)
    {
      localObject2 = (cjs)((com.tencent.mm.ai.b)localObject1).fsV.fta;
      if (paramBoolean1) {
        ((cjs)localObject2).xkI = getTenpayCgicmd();
      }
      if (paramBoolean2) {
        ((cjs)localObject2).xkJ = 1;
      }
      setCommReqResp((com.tencent.mm.ai.b)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public int doScene(com.tencent.mm.network.e parame, f paramf)
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
    if (r.ZB())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int doSceneSimulately(com.tencent.mm.ai.b paramb, com.tencent.mm.network.e parame, f paramf)
  {
    parame = (cjs)paramb.fsV.fta;
    if (parame.xkK != null) {
      new String(parame.xkK.getBufferToBytes());
    }
    if (parame.xAv != null) {
      new String(parame.xAv.getBufferToBytes());
    }
    ah.getContext();
    getPayCgicmd();
    ac.dSx();
    if (this.isFake)
    {
      paramf = (cjt)paramb.fsW.fta;
      parame = paramf;
      if (paramf == null) {
        parame = new cjt();
      }
      paramf = "".getBytes();
      parame.xkL = new SKBuiltinBuffer_t().setBuffer(paramf);
      parame.xkO = getPayCgicmd();
      parame.xkM = 0;
      try
      {
        paramf = new JSONObject(null);
        parame.xAw = paramf.optInt("TenpayErrType");
        parame.xAx = paramf.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramb, null);
        return 1;
      }
      catch (Exception parame)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSenceTenPayBase", parame, "", new Object[0]);
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
  
  public v getRetModel(com.tencent.mm.ai.b paramb)
  {
    paramb = (cjt)paramb.fsW.fta;
    v localv = new v();
    localv.xkO = paramb.xkO;
    localv.xkN = paramb.xkN;
    localv.xkM = paramb.xkM;
    localv.xkL = paramb.xkL;
    localv.lGL = paramb.xAx;
    localv.AXe = paramb.xAw;
    return localv;
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
  
  public void putToReqText(com.tencent.mm.ai.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cjs)paramb.fsV.fta).xkK = paramSKBuiltinBuffer_t;
  }
  
  public void putToWXReqText(com.tencent.mm.ai.b paramb, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    ((cjs)paramb.fsV.fta).xAv = paramSKBuiltinBuffer_t;
  }
  
  public void setFake()
  {
    this.isFake = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.m
 * JD-Core Version:    0.7.0.1
 */