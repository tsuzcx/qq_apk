package com.tencent.mm.wallet_core.d.a;

import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.model.af;
import com.tencent.mm.wallet_core.model.s;
import com.tencent.mm.wallet_core.model.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;
import org.json.JSONObject;

public abstract class a
  extends s
{
  public void configRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = getCommReqResp();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new c.a();
      ((c.a)localObject1).otE = new eda();
      ((c.a)localObject1).otF = new edb();
      ((c.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((c.a)localObject1).funcId = 1518;
      ((c.a)localObject1).otG = 0;
      ((c.a)localObject1).respCmdId = 0;
      localObject1 = ((c.a)localObject1).bEF();
      ((c)localObject1).setIsUserCmd(true);
    }
    localObject2 = (eda)c.b.b(((c)localObject1).otB);
    if (paramBoolean1) {
      ((eda)localObject2).aaFP = ihO();
    }
    if (paramBoolean2) {
      ((eda)localObject2).aaFQ = 1;
    }
    setCommReqResp((c)localObject1);
  }
  
  public int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    if (!z.bBi())
    {
      Log.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramh.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int doSceneSimulately(c paramc, g paramg, h paramh)
  {
    paramg = (eda)c.b.b(paramc.otB);
    if (paramg.aaFR != null) {
      new String(paramg.aaFR.aaxD.Op);
    }
    if (paramg.abio != null) {
      new String(paramg.abio.aaxD.Op);
    }
    MMApplicationContext.getContext();
    getPayCgicmd();
    paramh = af.jOV();
    if (paramh != null)
    {
      paramg = (edb)c.c.b(paramc.otC);
      byte[] arrayOfByte = paramh.getBytes();
      paramg.aaFS = new gol().df(arrayOfByte);
      paramg.aaFV = getPayCgicmd();
      paramg.aaFT = 0;
      try
      {
        paramh = new JSONObject(paramh);
        paramg.abip = paramh.optInt("TenpayErrType");
        paramg.abiq = paramh.optString("TenpayErrMsg");
        onGYNetEnd(1, 0, 0, "", paramc, null);
        return 1;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetScenePayUBase", paramg, "", new Object[0]);
        }
      }
    }
    return -1;
  }
  
  public String getEncryptUrl(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int getPayCgicmd()
  {
    return ihO();
  }
  
  public x getRetModel(c paramc)
  {
    paramc = (edb)c.c.b(paramc.otC);
    x localx = new x();
    localx.aaFV = paramc.aaFV;
    localx.aaFU = paramc.aaFU;
    localx.aaFT = paramc.aaFT;
    localx.aaFS = paramc.aaFS;
    localx.ytw = paramc.abiq;
    localx.agTv = paramc.abip;
    return localx;
  }
  
  public int getType()
  {
    return 1518;
  }
  
  public abstract int ihO();
  
  public void putToReqText(c paramc, gol paramgol)
  {
    ((eda)c.b.b(paramc.otB)).aaFR = paramgol;
  }
  
  public void putToRequest(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public void putToWXReqText(c paramc, gol paramgol)
  {
    ((eda)c.b.b(paramc.otB)).abio = paramgol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a.a
 * JD-Core Version:    0.7.0.1
 */