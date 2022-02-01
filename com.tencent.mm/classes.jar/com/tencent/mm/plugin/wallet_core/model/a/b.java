package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public Bankcard BBr;
  public String BBs;
  public String BBt;
  public boolean BBu;
  public int BBv;
  public boolean qwz;
  
  public b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(70578);
    this.BBr = paramBankcard;
    try
    {
      paramBankcard = new JSONObject(this.BBr.field_ext_msg);
      this.BBs = paramBankcard.optString("information");
      this.qwz = paramBankcard.optBoolean("verified");
      this.BBt = paramBankcard.optString("card_expiry");
      this.BBv = paramBankcard.optInt("cvv_length");
      this.BBu = paramBankcard.optBoolean("is_credit");
      AppMethodBeat.o(70578);
      return;
    }
    catch (JSONException paramBankcard)
    {
      ac.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramBankcard, "", new Object[0]);
      AppMethodBeat.o(70578);
    }
  }
  
  public static String bm(JSONObject paramJSONObject)
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
        ac.printErrStackTrace("MicroMsg.BankcardPayUWrapper", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.b
 * JD-Core Version:    0.7.0.1
 */