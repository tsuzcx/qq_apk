package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends m
{
  public String ImO;
  public String ImP;
  public String ImQ;
  public String ImR;
  public String ImS;
  public String ImT;
  public int ImU;
  public String ImV;
  public String ImW;
  public int ImX;
  public String ImY;
  public String ImZ;
  public String Imv;
  public int Ina;
  public String Inb;
  public int Inc;
  public BusiRemittanceResp Ind;
  public String desc;
  public int fwx;
  public String jump_url;
  public int scene;
  public double tVK;
  public int tpK;
  public String username;
  
  public af(String paramString, int paramInt)
  {
    AppMethodBeat.i(67887);
    this.ImQ = "";
    this.ImR = "";
    this.ImS = "";
    this.ImT = "";
    this.ImV = "";
    this.ImW = "";
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
      Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(67888);
        return;
      }
      Log.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.ImO = paramJSONObject.optString("true_name");
      this.tVK = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.ImP = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.ImQ = paramJSONObject.optString("f2f_pay_desc");
      this.ImR = paramJSONObject.optString("rcvr_desc");
      this.ImS = paramJSONObject.optString("payer_desc");
      this.ImT = paramJSONObject.optString("rcvr_ticket");
      this.ImU = paramJSONObject.optInt("busi_type", 0);
      this.ImV = paramJSONObject.optString("mch_name");
      this.ImW = paramJSONObject.optString("mch_photo");
      this.ImZ = paramJSONObject.optString("mch_type", "");
      this.ImX = paramJSONObject.optInt("mch_time", 0);
      this.ImY = paramJSONObject.optString("receiver_openid");
      this.Ina = paramJSONObject.optInt("get_pay_wifi");
      this.Imv = paramJSONObject.optString("receiver_true_name");
      this.Inb = paramJSONObject.optString("mch_info_string");
      this.Inc = paramJSONObject.optInt("amount_remind_bit");
      this.tpK = paramJSONObject.optInt("action_type");
      this.fwx = paramJSONObject.optInt("retcode");
      this.jump_url = paramJSONObject.optString("jump_url");
      this.Ind = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(67888);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(67888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.af
 * JD-Core Version:    0.7.0.1
 */