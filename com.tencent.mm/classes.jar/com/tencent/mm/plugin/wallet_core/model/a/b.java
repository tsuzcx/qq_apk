package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public boolean jMT;
  public Bankcard qzR;
  public String qzS;
  public String qzT;
  public boolean qzU;
  public int qzV;
  
  public b(Bankcard paramBankcard)
  {
    this.qzR = paramBankcard;
    try
    {
      paramBankcard = new JSONObject(this.qzR.field_ext_msg);
      this.qzS = paramBankcard.optString("information");
      this.jMT = paramBankcard.optBoolean("verified");
      this.qzT = paramBankcard.optString("card_expiry");
      this.qzV = paramBankcard.optInt("cvv_length");
      this.qzU = paramBankcard.optBoolean("is_credit");
      return;
    }
    catch (JSONException paramBankcard)
    {
      y.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramBankcard, "", new Object[0]);
    }
  }
  
  public static String av(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cvv_length", paramJSONObject.optInt("cvv_length"));
      localJSONObject.put("information", paramJSONObject.optString("information"));
      localJSONObject.put("verified", paramJSONObject.optBoolean("verified"));
      localJSONObject.put("card_expiry", paramJSONObject.optString("card_expiry"));
      localJSONObject.put("is_credit", paramJSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
      return localJSONObject.toString();
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.b
 * JD-Core Version:    0.7.0.1
 */