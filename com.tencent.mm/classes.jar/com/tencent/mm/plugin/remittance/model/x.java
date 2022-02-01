package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public String desc;
  public int dlw;
  public int ozA;
  public String ozD;
  public double paV;
  public int scene;
  public String username;
  public String xYR;
  public String xYS;
  public String xYT;
  public String xYU;
  public String xYV;
  public String xYW;
  public int xYX;
  public String xYY;
  public String xYZ;
  public String xYy;
  public int xZa;
  public String xZb;
  public String xZc;
  public int xZd;
  public String xZe;
  public int xZf;
  public BusiRemittanceResp xZg;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.xYT = "";
    this.xYU = "";
    this.xYV = "";
    this.xYW = "";
    this.xYY = "";
    this.xYZ = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", URLEncoder.encode(paramString));
    setRequestData(localHashMap);
    paramString = new HashMap();
    paramString.put("channel", String.valueOf(paramInt));
    setWXRequestData(paramString);
    AppMethodBeat.o(67887);
  }
  
  public final int getFuncId()
  {
    return 1515;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferscanqrcode";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67888);
    try
    {
      ad.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      ad.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.xYR = paramJSONObject.optString("true_name");
      this.paV = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.xYS = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.xYT = paramJSONObject.optString("f2f_pay_desc");
      this.xYU = paramJSONObject.optString("rcvr_desc");
      this.xYV = paramJSONObject.optString("payer_desc");
      this.xYW = paramJSONObject.optString("rcvr_ticket");
      this.xYX = paramJSONObject.optInt("busi_type", 0);
      this.xYY = paramJSONObject.optString("mch_name");
      this.xYZ = paramJSONObject.optString("mch_photo");
      this.xZc = paramJSONObject.optString("mch_type", "");
      this.xZa = paramJSONObject.optInt("mch_time", 0);
      this.xZb = paramJSONObject.optString("receiver_openid");
      this.xZd = paramJSONObject.optInt("get_pay_wifi");
      this.xYy = paramJSONObject.optString("receiver_true_name");
      this.xZe = paramJSONObject.optString("mch_info_string");
      this.xZf = paramJSONObject.optInt("amount_remind_bit");
      this.ozA = paramJSONObject.optInt("action_type");
      this.dlw = paramJSONObject.optInt("retcode");
      this.ozD = paramJSONObject.optString("jump_url");
      this.xZg = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */