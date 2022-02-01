package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends eb
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70302);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.IhC.put("title", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" title TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "title";
    locala.columns[1] = "loan_jump_url";
    locala.IhC.put("loan_jump_url", "TEXT");
    localStringBuilder.append(" loan_jump_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "red_dot_index";
    locala.IhC.put("red_dot_index", "INTEGER");
    localStringBuilder.append(" red_dot_index INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "is_show_entry";
    locala.IhC.put("is_show_entry", "INTEGER");
    localStringBuilder.append(" is_show_entry INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "tips";
    locala.IhC.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "is_overdue";
    locala.IhC.put("is_overdue", "INTEGER");
    localStringBuilder.append(" is_overdue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "available_otb";
    locala.IhC.put("available_otb", "TEXT");
    localStringBuilder.append(" available_otb TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70302);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.n
 * JD-Core Version:    0.7.0.1
 */