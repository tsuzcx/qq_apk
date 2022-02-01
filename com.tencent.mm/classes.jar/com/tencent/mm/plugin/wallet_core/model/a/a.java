package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a
  extends d
{
  private static a AiV = null;
  
  public static a edx()
  {
    AppMethodBeat.i(70575);
    if (AiV == null) {
      AiV = new a();
    }
    a locala = AiV;
    AppMethodBeat.o(70575);
    return locala;
  }
  
  public final Bankcard aR(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70576);
    Bankcard localBankcard = super.aR(paramJSONObject);
    localBankcard.field_ext_msg = b.bl(paramJSONObject);
    localBankcard.field_bankcardClientType = 1;
    localBankcard.field_desc = paramJSONObject.optString("description");
    localBankcard.field_trueName = paramJSONObject.optString("name_on_card");
    if ("CREDITCARD_PAYU".equals(paramJSONObject.optString("bank_type"))) {}
    for (localBankcard.field_cardType |= Bankcard.AbH;; localBankcard.field_cardType |= Bankcard.AbJ)
    {
      AppMethodBeat.o(70576);
      return localBankcard;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.a
 * JD-Core Version:    0.7.0.1
 */