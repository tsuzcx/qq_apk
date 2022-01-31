package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends j
{
  public String desc;
  public double iHP;
  public String nyK;
  public String nzb;
  public String nzc;
  public String nzd = "";
  public String nze = "";
  public String nzf = "";
  public String nzg = "";
  public int nzh;
  public String nzi = "";
  public String nzj = "";
  public int nzk;
  public String nzl;
  public String nzm;
  public int nzn;
  public String nzo;
  public BusiRemittanceResp nzp;
  public int scene;
  public String username;
  
  public w(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", URLEncoder.encode(paramString));
    D(localHashMap);
    paramString = new HashMap();
    paramString.put("channel", String.valueOf(paramInt));
    aC(paramString);
  }
  
  public final int HH()
  {
    return 1515;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      y.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
      if (paramInt != 0) {
        return;
      }
      y.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[] { paramJSONObject.toString() });
      this.username = paramJSONObject.optString("user_name", "");
      this.nzb = paramJSONObject.optString("true_name");
      this.iHP = (paramJSONObject.optDouble("fee") / 100.0D);
      this.desc = paramJSONObject.optString("desc");
      this.scene = paramJSONObject.optInt("scene");
      this.nzc = URLEncoder.encode(paramJSONObject.optString("transfer_qrcode_id"));
      this.nzd = paramJSONObject.optString("f2f_pay_desc");
      this.nze = paramJSONObject.optString("rcvr_desc");
      this.nzf = paramJSONObject.optString("payer_desc");
      this.nzg = paramJSONObject.optString("rcvr_ticket");
      this.nzh = paramJSONObject.optInt("busi_type", 0);
      this.nzi = paramJSONObject.optString("mch_name");
      this.nzj = paramJSONObject.optString("mch_photo");
      this.nzm = paramJSONObject.optString("mch_type", "");
      this.nzk = paramJSONObject.optInt("mch_time", 0);
      this.nzl = paramJSONObject.optString("receiver_openid");
      this.nzn = paramJSONObject.optInt("get_pay_wifi");
      this.nyK = paramJSONObject.optString("receiver_true_name");
      this.nzo = paramJSONObject.optString("mch_info_string");
      this.nzp = new BusiRemittanceResp(paramJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", paramString, "", new Object[0]);
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferscanqrcode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */