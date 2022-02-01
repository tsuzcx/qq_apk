package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gw;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class ad
  extends gw
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70430);
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_tpa_country";
    locala.IBN.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "wallet_tpa_country";
    locala.columns[1] = "wallet_type";
    locala.IBN.put("wallet_type", "INTEGER");
    localStringBuilder.append(" wallet_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "wallet_name";
    locala.IBN.put("wallet_name", "TEXT");
    localStringBuilder.append(" wallet_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "wallet_selected";
    locala.IBN.put("wallet_selected", "INTEGER");
    localStringBuilder.append(" wallet_selected INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "wallet_balance";
    locala.IBN.put("wallet_balance", "INTEGER");
    localStringBuilder.append(" wallet_balance INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "wallet_tpa_country_mask";
    locala.IBN.put("wallet_tpa_country_mask", "INTEGER");
    localStringBuilder.append(" wallet_tpa_country_mask INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70430);
  }
  
  public static ad bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70429);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.WalletKindInfo", "json is null");
      AppMethodBeat.o(70429);
      return null;
    }
    ad localad = new ad();
    localad.field_wallet_tpa_country = paramJSONObject.optString("wallet_tpa_country");
    localad.field_wallet_name = paramJSONObject.optString("wallet_name");
    localad.field_wallet_selected = paramJSONObject.optInt("wallet_selected");
    localad.field_wallet_type = paramJSONObject.optInt("wallet_type");
    localad.field_wallet_balance = paramJSONObject.optInt("wallet_balance");
    localad.field_wallet_tpa_country_mask = paramJSONObject.optInt("wallet_tpa_country_mask");
    if (bu.isNullOrNil(localad.field_wallet_tpa_country))
    {
      ae.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
      AppMethodBeat.o(70429);
      return null;
    }
    AppMethodBeat.o(70429);
    return localad;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ad
 * JD-Core Version:    0.7.0.1
 */