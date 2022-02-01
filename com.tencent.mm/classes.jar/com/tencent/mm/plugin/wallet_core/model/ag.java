package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends gy
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70435);
    c.a locala = new c.a();
    locala.IBL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pref_key";
    locala.IBN.put("pref_key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pref_key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "pref_key";
    locala.columns[1] = "pref_title";
    locala.IBN.put("pref_title", "TEXT");
    localStringBuilder.append(" pref_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pref_url";
    locala.IBN.put("pref_url", "TEXT");
    localStringBuilder.append(" pref_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "is_show";
    locala.IBN.put("is_show", "INTEGER default '1' ");
    localStringBuilder.append(" is_show INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "pref_desc";
    locala.IBN.put("pref_desc", "TEXT");
    localStringBuilder.append(" pref_desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "logo_url";
    locala.IBN.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "jump_type";
    locala.IBN.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "tinyapp_username";
    locala.IBN.put("tinyapp_username", "TEXT");
    localStringBuilder.append(" tinyapp_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "tinyapp_path";
    locala.IBN.put("tinyapp_path", "TEXT");
    localStringBuilder.append(" tinyapp_path TEXT");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70435);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */