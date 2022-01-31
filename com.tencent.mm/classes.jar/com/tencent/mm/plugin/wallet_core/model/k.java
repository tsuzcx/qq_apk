package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.h.c.cr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends cr
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "title";
    locala.ujN.put("title", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" title TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "title";
    locala.columns[1] = "loan_jump_url";
    locala.ujN.put("loan_jump_url", "TEXT");
    localStringBuilder.append(" loan_jump_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "red_dot_index";
    locala.ujN.put("red_dot_index", "INTEGER");
    localStringBuilder.append(" red_dot_index INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "is_show_entry";
    locala.ujN.put("is_show_entry", "INTEGER");
    localStringBuilder.append(" is_show_entry INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "tips";
    locala.ujN.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "is_overdue";
    locala.ujN.put("is_overdue", "INTEGER");
    localStringBuilder.append(" is_overdue INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "available_otb";
    locala.ujN.put("available_otb", "TEXT");
    localStringBuilder.append(" available_otb TEXT");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.k
 * JD-Core Version:    0.7.0.1
 */