package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class af
  extends gj
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70435);
    c.a locala = new c.a();
    locala.EYt = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "pref_key";
    locala.EYv.put("pref_key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pref_key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "pref_key";
    locala.columns[1] = "pref_title";
    locala.EYv.put("pref_title", "TEXT");
    localStringBuilder.append(" pref_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "pref_url";
    locala.EYv.put("pref_url", "TEXT");
    localStringBuilder.append(" pref_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "is_show";
    locala.EYv.put("is_show", "INTEGER default '1' ");
    localStringBuilder.append(" is_show INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "pref_desc";
    locala.EYv.put("pref_desc", "TEXT");
    localStringBuilder.append(" pref_desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "logo_url";
    locala.EYv.put("logo_url", "TEXT");
    localStringBuilder.append(" logo_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "jump_type";
    locala.EYv.put("jump_type", "INTEGER");
    localStringBuilder.append(" jump_type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "tinyapp_username";
    locala.EYv.put("tinyapp_username", "TEXT");
    localStringBuilder.append(" tinyapp_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "tinyapp_path";
    locala.EYv.put("tinyapp_path", "TEXT");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.af
 * JD-Core Version:    0.7.0.1
 */