package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public Bankcard OUK;
  public String OUL;
  public String OUM;
  public boolean OUN;
  public int OUO;
  public boolean wvU;
  
  public b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70578);
    this.OUK = paramBankcard;
    try
    {
      paramBankcard = new JSONObject(this.OUK.field_ext_msg);
      this.OUL = paramBankcard.optString("information");
      this.wvU = paramBankcard.optBoolean("verified");
      this.OUM = paramBankcard.optString("card_expiry");
      this.OUO = paramBankcard.optInt("cvv_length");
      this.OUN = paramBankcard.optBoolean("is_credit");
      AppMethodBeat.o(70578);
      return;
    }
    catch (JSONException paramBankcard)
    {
      Log.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramBankcard, "", new Object[0]);
      AppMethodBeat.o(70578);
    }
  }
  
  public static String cf(JSONObject paramJSONObject)
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
        Log.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.b
 * JD-Core Version:    0.7.0.1
 */