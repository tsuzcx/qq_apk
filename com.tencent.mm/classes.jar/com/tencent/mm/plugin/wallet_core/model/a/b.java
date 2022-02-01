package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public Bankcard Dtn;
  public String Dto;
  public String Dtp;
  public boolean Dtq;
  public int Dtr;
  public boolean ros;
  
  public b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70578);
    this.Dtn = paramBankcard;
    try
    {
      paramBankcard = new JSONObject(this.Dtn.field_ext_msg);
      this.Dto = paramBankcard.optString("information");
      this.ros = paramBankcard.optBoolean("verified");
      this.Dtp = paramBankcard.optString("card_expiry");
      this.Dtr = paramBankcard.optInt("cvv_length");
      this.Dtq = paramBankcard.optBoolean("is_credit");
      AppMethodBeat.o(70578);
      return;
    }
    catch (JSONException paramBankcard)
    {
      ae.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramBankcard, "", new Object[0]);
      AppMethodBeat.o(70578);
    }
  }
  
  public static String bv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70577);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cvv_length", paramJSONObject.optInt("cvv_length"));
      localJSONObject.put("information", paramJSONObject.optString("information"));
      localJSONObject.put("verified", paramJSONObject.optBoolean("verified"));
      localJSONObject.put("card_expiry", paramJSONObject.optString("card_expiry"));
      localJSONObject.put("is_credit", paramJSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
      paramJSONObject = localJSONObject.toString();
      AppMethodBeat.o(70577);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.b
 * JD-Core Version:    0.7.0.1
 */