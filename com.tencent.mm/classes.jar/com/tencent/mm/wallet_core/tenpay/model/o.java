package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import com.tencent.mm.wallet_core.c.i;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends m
  implements i
{
  public String AXZ;
  public String appId;
  public int cCy;
  public String cnI;
  public String cqx;
  public String hxt;
  public int scene;
  public String uAe;
  public cvm uAf;
  
  public o(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(49176);
    this.uAf = new cvm();
    this.scene = paramInt1;
    this.cCy = paramInt3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", URLEncoder.encode(paramString1));
    localHashMap.put("scene", String.valueOf(paramInt2));
    localHashMap.put("a8key_scene", String.valueOf(paramInt1));
    localHashMap.put("channel", String.valueOf(paramInt3));
    ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
    if (paramInt4 < 0)
    {
      ab.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
      localHashMap.put("source_type", "0");
      localHashMap.put("source", "");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      paramString2 = com.tencent.mm.model.c.c.abU().me("100456");
      if (paramString2.isValid()) {
        break;
      }
      ab.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
      AppMethodBeat.o(49176);
      return;
      localHashMap.put("source_type", String.valueOf(paramInt4));
      localHashMap.put("source", paramString2);
    }
    if (bo.getInt((String)paramString2.dvN().get("open"), 0) == 0)
    {
      ab.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
      AppMethodBeat.o(49176);
      return;
    }
    try
    {
      paramString1 = new URI(paramString1).getQuery();
      if (!bo.isNullOrNil(paramString1))
      {
        paramString1 = paramString1.split("&");
        paramInt2 = paramString1.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (paramString1[paramInt1].contains("groupid"))
          {
            paramString2 = paramString1[paramInt1].split("=");
            if (paramString2.length == 2)
            {
              paramInt3 = bo.getInt(paramString2[1], 0);
              ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", new Object[] { Integer.valueOf(paramInt3) });
              getCommReqResp().getReqObj().setRouteInfo(paramInt3);
            }
          }
          paramInt1 += 1;
        }
      }
      AppMethodBeat.o(49176);
      return;
    }
    catch (URISyntaxException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", paramString1, "", new Object[0]);
      AppMethodBeat.o(49176);
    }
  }
  
  public int getFuncId()
  {
    return 1694;
  }
  
  public int getTenpayCgicmd()
  {
    return 127;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49177);
    ab.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[] { paramJSONObject.toString() });
    this.cnI = paramJSONObject.optString("reqkey");
    this.appId = paramJSONObject.optString("appid");
    this.uAe = paramJSONObject.optString("appsource");
    this.cqx = paramJSONObject.optString("productid");
    this.AXZ = paramJSONObject.optString("retcode");
    this.hxt = paramJSONObject.optString("retmsg");
    paramString = paramJSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
    if (paramString != null)
    {
      this.uAf.ydT = paramString.optString("pay_gate_url");
      this.uAf.ydV = paramString.optBoolean("need_dialog");
      this.uAf.ydW = paramString.optString("dialog_text");
      paramString = paramString.optJSONObject("callback_retry_conf");
      if (paramString != null)
      {
        this.uAf.ydU = new nw();
        this.uAf.ydU.wDx = paramString.optInt("inteval_time");
        this.uAf.ydU.wDy = paramString.optInt("max_count");
        this.uAf.ydU.wDz = paramString.optString("default_wording");
      }
      ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", new Object[] { this.uAf.ydT, this.uAf.ydW });
    }
    AppMethodBeat.o(49177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.o
 * JD-Core Version:    0.7.0.1
 */