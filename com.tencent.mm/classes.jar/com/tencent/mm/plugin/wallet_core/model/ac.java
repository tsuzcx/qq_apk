package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class ac
  extends gh
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70430);
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_tpa_country";
    locala.EYv.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "wallet_tpa_country";
    locala.columns[1] = "wallet_type";
    locala.EYv.put("wallet_type", "INTEGER");
    localStringBuilder.append(" wallet_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "wallet_name";
    locala.EYv.put("wallet_name", "TEXT");
    localStringBuilder.append(" wallet_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "wallet_selected";
    locala.EYv.put("wallet_selected", "INTEGER");
    localStringBuilder.append(" wallet_selected INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "wallet_balance";
    locala.EYv.put("wallet_balance", "INTEGER");
    localStringBuilder.append(" wallet_balance INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "wallet_tpa_country_mask";
    locala.EYv.put("wallet_tpa_country_mask", "INTEGER");
    localStringBuilder.append(" wallet_tpa_country_mask INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70430);
  }
  
  public static ac be(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70429);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.WalletKindInfo", "json is null");
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
    if (bt.isNullOrNil(localac.field_wallet_tpa_country))
    {
      ad.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
      AppMethodBeat.o(70429);
      return null;
    }
    AppMethodBeat.o(70429);
    return localac;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */