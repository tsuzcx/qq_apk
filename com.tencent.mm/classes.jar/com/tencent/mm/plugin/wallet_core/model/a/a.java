package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.f;
import org.json.JSONObject;

public final class a
  extends f
{
  private static a umA = null;
  
  public static a cVc()
  {
    AppMethodBeat.i(47043);
    if (umA == null) {
      umA = new a();
    }
    a locala = umA;
    AppMethodBeat.o(47043);
    return locala;
  }
  
  public final Bankcard aw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47044);
    Bankcard localBankcard = super.aw(paramJSONObject);
    localBankcard.field_ext_msg = b.aO(paramJSONObject);
    localBankcard.field_bankcardClientType = 1;
    localBankcard.field_desc = paramJSONObject.optString("description");
    localBankcard.field_trueName = paramJSONObject.optString("name_on_card");
    if ("CREDITCARD_PAYU".equals(paramJSONObject.optString("bank_type"))) {}
    for (localBankcard.field_cardType |= Bankcard.ufz;; localBankcard.field_cardType |= Bankcard.ufB)
    {
      AppMethodBeat.o(47044);
      return localBankcard;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.a
 * JD-Core Version:    0.7.0.1
 */