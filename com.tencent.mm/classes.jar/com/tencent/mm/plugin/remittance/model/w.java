package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends m
{
  public String desc;
  public double kNS;
  public String qjK;
  public String qkd;
  public String qke;
  public String qkf;
  public String qkg;
  public String qkh;
  public String qki;
  public int qkj;
  public String qkk;
  public String qkl;
  public int qkm;
  public String qkn;
  public String qko;
  public int qkp;
  public String qkq;
  public int qkr;
  public BusiRemittanceResp qks;
  public int scene;
  public String username;
  
  public w(String paramString, int paramInt)
  {
    AppMethodBeat.i(44774);
    this.qkf = "";
    this.qkg = "";
    this.qkh = "";
    this.qki = "";
    this.qkk = "";
    this.qkl = "";
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", URLEncoder.encode(paramString));
    setRequestData(localHashMap);
    paramString = new HashMap();
    paramString.put("channel", String.valueOf(paramInt));
    setWXRequestData(paramString);
    AppMethodBeat.o(44774);
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
    AppMethodBeat.i(44775);
    try
    {
      ab.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0)
      {
        AppMethodBeat.o(44775);
        return;
      }
      ab.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.qkd = paramJSONObject.optString("true_name");
      this.kNS = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.qke = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.qkf = paramJSONObject.optString("f2f_pay_desc");
      this.qkg = paramJSONObject.optString("rcvr_desc");
      this.qkh = paramJSONObject.optString("payer_desc");
      this.qki = paramJSONObject.optString("rcvr_ticket");
      this.qkj = paramJSONObject.optInt("busi_type", 0);
      this.qkk = paramJSONObject.optString("mch_name");
      this.qkl = paramJSONObject.optString("mch_photo");
      this.qko = paramJSONObject.optString("mch_type", "");
      this.qkm = paramJSONObject.optInt("mch_time", 0);
      this.qkn = paramJSONObject.optString("receiver_openid");
      this.qkp = paramJSONObject.optInt("get_pay_wifi");
      this.qjK = paramJSONObject.optString("receiver_true_name");
      this.qkq = paramJSONObject.optString("mch_info_string");
      this.qkr = paramJSONObject.optInt("amount_remind_bit");
      this.qks = new BusiRemittanceResp(paramJSONObject);
      AppMethodBeat.o(44775);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
      AppMethodBeat.o(44775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */