package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a
  extends d
{
  private static a qzQ = null;
  
  public static a bWl()
  {
    if (qzQ == null) {
      qzQ = new a();
    }
    return qzQ;
  }
  
  public final Bankcard am(JSONObject paramJSONObject)
  {
    Bankcard localBankcard = super.am(paramJSONObject);
    localBankcard.field_ext_msg = b.av(paramJSONObject);
    localBankcard.field_bankcardClientType = 1;
    localBankcard.field_desc = paramJSONObject.optString("description");
    localBankcard.field_trueName = paramJSONObject.optString("name_on_card");
    if ("CREDITCARD_PAYU".equals(paramJSONObject.optString("bank_type")))
    {
      localBankcard.field_cardType |= Bankcard.qtm;
      return localBankcard;
    }
    localBankcard.field_cardType |= Bankcard.qto;
    return localBankcard;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.a.a
 * JD-Core Version:    0.7.0.1
 */