package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends hj
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70435);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pref_key";
    localMAutoDBInfo.colsMap.put("pref_key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pref_key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "pref_key";
    localMAutoDBInfo.columns[1] = "pref_title";
    localMAutoDBInfo.colsMap.put("pref_title", "TEXT");
    localStringBuilder.append(" pref_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pref_url";
    localMAutoDBInfo.colsMap.put("pref_url", "TEXT");
    localStringBuilder.append(" pref_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "is_show";
    localMAutoDBInfo.colsMap.put("is_show", "INTEGER default '1' ");
    localStringBuilder.append(" is_show INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pref_desc";
    localMAutoDBInfo.colsMap.put("pref_desc", "TEXT");
    localStringBuilder.append(" pref_desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "logo_url";
    localMAutoDBInfo.colsMap.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "jump_type";
    localMAutoDBInfo.colsMap.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "tinyapp_username";
    localMAutoDBInfo.colsMap.put("tinyapp_username", "TEXT");
    localStringBuilder.append(" tinyapp_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "tinyapp_path";
    localMAutoDBInfo.colsMap.put("tinyapp_path", "TEXT");
    localStringBuilder.append(" tinyapp_path TEXT");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(70435);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */