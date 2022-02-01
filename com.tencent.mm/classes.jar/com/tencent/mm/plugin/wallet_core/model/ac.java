package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import org.json.JSONObject;

public final class ac
  extends ik
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70430);
    info = ik.aJm();
    AppMethodBeat.o(70430);
  }
  
  public static ac cv(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70429);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.WalletKindInfo", "json is null");
      AppMethodBeat.o(70429);
      return null;
    }
    ac localac = new ac();
    localac.field_wallet_tpa_country = paramJSONObject.optString("wallet_tpa_country");
    localac.field_wallet_name = paramJSONObject.optString("wallet_name");
    localac.field_wallet_selected = paramJSONObject.optInt("wallet_selected");
    localac.field_wallet_type = paramJSONObject.optInt("wallet_type");
    localac.field_wallet_balance = paramJSONObject.optInt("wallet_balance");
    localac.field_wallet_tpa_country_mask = paramJSONObject.optInt("wallet_tpa_country_mask");
    if (Util.isNullOrNil(localac.field_wallet_tpa_country))
    {
      Log.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
      AppMethodBeat.o(70429);
      return null;
    }
    AppMethodBeat.o(70429);
    return localac;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */