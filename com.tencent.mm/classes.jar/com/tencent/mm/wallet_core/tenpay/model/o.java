package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.c.j;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends m
  implements j
{
  public String DHy;
  public eda DHz;
  public String LWh;
  public String appId;
  public int channel;
  public String dmw;
  public String dpp;
  public String kuP;
  public int scene;
  
  public o(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(72894);
    this.DHz = new eda();
    this.scene = paramInt1;
    this.channel = paramInt3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", URLEncoder.encode(paramString1));
    localHashMap.put("scene", String.valueOf(paramInt2));
    localHashMap.put("a8key_scene", String.valueOf(paramInt1));
    localHashMap.put("channel", String.valueOf(paramInt3));
    ae.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
    if (paramInt4 < 0)
    {
      ae.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", new Object[] { Integer.valueOf(paramInt4), paramString2 });
      localHashMap.put("source_type", "0");
      localHashMap.put("source", "");
    }
    for (;;)
    {
      setRequestData(localHashMap);
      paramString2 = com.tencent.mm.model.c.d.aDI().xi("100456");
      if (paramString2.isValid()) {
        break;
      }
      ae.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
      AppMethodBeat.o(72894);
      return;
      localHashMap.put("source_type", String.valueOf(paramInt4));
      localHashMap.put("source", paramString2);
    }
    if (bu.getInt((String)paramString2.fsy().get("open"), 0) == 0)
    {
      ae.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
      AppMethodBeat.o(72894);
      return;
    }
    try
    {
      paramString1 = new URI(paramString1).getQuery();
      if (!bu.isNullOrNil(paramString1))
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
              paramInt3 = bu.getInt(paramString2[1], 0);
              ae.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", new Object[] { Integer.valueOf(paramInt3) });
              getCommReqResp().getReqObj().setRouteInfo(paramInt3);
            }
          }
          paramInt1 += 1;
        }
      }
      AppMethodBeat.o(72894);
      return;
    }
    catch (URISyntaxException paramString1)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", paramString1, "", new Object[0]);
      AppMethodBeat.o(72894);
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
    AppMethodBeat.i(72895);
    ae.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ae.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", new Object[] { paramJSONObject.toString() });
    this.dmw = paramJSONObject.optString("reqkey");
    this.appId = paramJSONObject.optString("appid");
    this.DHy = paramJSONObject.optString("appsource");
    this.dpp = paramJSONObject.optString("productid");
    this.LWh = paramJSONObject.optString("retcode");
    this.kuP = paramJSONObject.optString("retmsg");
    paramString = paramJSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
    if (paramString != null)
    {
      this.DHz.Iie = paramString.optString("pay_gate_url");
      this.DHz.Iig = paramString.optBoolean("need_dialog");
      this.DHz.Iih = paramString.optString("dialog_text");
      paramString = paramString.optJSONObject("callback_retry_conf");
      if (paramString != null)
      {
        this.DHz.Iif = new se();
        this.DHz.Iif.Ghp = paramString.optInt("inteval_time");
        this.DHz.Iif.Ghq = paramString.optInt("max_count");
        this.DHz.Iif.Ghr = paramString.optString("default_wording");
      }
      ae.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", new Object[] { this.DHz.Iie, this.DHz.Iih });
    }
    AppMethodBeat.o(72895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.o
 * JD-Core Version:    0.7.0.1
 */