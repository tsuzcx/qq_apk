package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.h.c.et;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends et
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "wallet_tpa_country";
    locala.ujN.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "wallet_tpa_country";
    locala.columns[1] = "wallet_type";
    locala.ujN.put("wallet_type", "INTEGER");
    localStringBuilder.append(" wallet_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "wallet_name";
    locala.ujN.put("wallet_name", "TEXT");
    localStringBuilder.append(" wallet_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "wallet_selected";
    locala.ujN.put("wallet_selected", "INTEGER");
    localStringBuilder.append(" wallet_selected INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "wallet_balance";
    locala.ujN.put("wallet_balance", "INTEGER");
    localStringBuilder.append(" wallet_balance INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "wallet_tpa_country_mask";
    locala.ujN.put("wallet_tpa_country_mask", "INTEGER");
    localStringBuilder.append(" wallet_tpa_country_mask INTEGER");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public static x au(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.WalletKindInfo", "json is null");
      return null;
    }
    x localx = new x();
    localx.field_wallet_tpa_country = paramJSONObject.optString("wallet_tpa_country");
    localx.field_wallet_name = paramJSONObject.optString("wallet_name");
    localx.field_wallet_selected = paramJSONObject.optInt("wallet_selected");
    localx.field_wallet_type = paramJSONObject.optInt("wallet_type");
    localx.field_wallet_balance = paramJSONObject.optInt("wallet_balance");
    localx.field_wallet_tpa_country_mask = paramJSONObject.optInt("wallet_tpa_country_mask");
    if (bk.bl(localx.field_wallet_tpa_country))
    {
      y.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
      return null;
    }
    return localx;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */