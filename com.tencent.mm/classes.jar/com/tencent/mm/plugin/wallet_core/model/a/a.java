package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a
  extends d
{
  private static a Dtm = null;
  
  public static a eKG()
  {
    AppMethodBeat.i(70575);
    if (Dtm == null) {
      Dtm = new a();
    }
    a locala = Dtm;
    AppMethodBeat.o(70575);
    return locala;
  }
  
  public final Bankcard ba(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70576);
    Bankcard localBankcard = super.ba(paramJSONObject);
    localBankcard.field_ext_msg = b.bv(paramJSONObject);
    localBankcard.field_bankcardClientType = 1;
    localBankcard.field_desc = paramJSONObject.optString("description");
    localBankcard.field_trueName = paramJSONObject.optString("name_on_card");
    if ("CREDITCARD_PAYU".equals(paramJSONObject.optString("bank_type"))) {}
    for (localBankcard.field_cardType |= Bankcard.DlW;; localBankcard.field_cardType |= Bankcard.DlY)
    {
      AppMethodBeat.o(70576);
      return localBankcard;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.a
 * JD-Core Version:    0.7.0.1
 */