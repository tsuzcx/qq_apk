package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public boolean mhc;
  public Bankcard umB;
  public String umC;
  public String umD;
  public boolean umE;
  public int umF;
  
  public b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(47046);
    this.umB = paramBankcard;
    try
    {
      paramBankcard = new JSONObject(this.umB.field_ext_msg);
      this.umC = paramBankcard.optString("information");
      this.mhc = paramBankcard.optBoolean("verified");
      this.umD = paramBankcard.optString("card_expiry");
      this.umF = paramBankcard.optInt("cvv_length");
      this.umE = paramBankcard.optBoolean("is_credit");
      AppMethodBeat.o(47046);
      return;
    }
    catch (JSONException paramBankcard)
    {
      ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramBankcard, "", new Object[0]);
      AppMethodBeat.o(47046);
    }
  }
  
  public static String aO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47045);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cvv_length", paramJSONObject.optInt("cvv_length"));
      localJSONObject.put("information", paramJSONObject.optString("information"));
      localJSONObject.put("verified", paramJSONObject.optBoolean("verified"));
      localJSONObject.put("card_expiry", paramJSONObject.optString("card_expiry"));
      localJSONObject.put("is_credit", paramJSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
      paramJSONObject = localJSONObject.toString();
      AppMethodBeat.o(47045);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.b
 * JD-Core Version:    0.7.0.1
 */