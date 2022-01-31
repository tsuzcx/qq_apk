package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class m
  extends bh
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(62862);
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "prodcutID";
    locala.yrM.put("prodcutID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "prodcutID";
    locala.columns[1] = "totalCount";
    locala.yrM.put("totalCount", "INTEGER");
    localStringBuilder.append(" totalCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "continuCount";
    locala.yrM.put("continuCount", "INTEGER");
    localStringBuilder.append(" continuCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "flag";
    locala.yrM.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "modifyTime";
    locala.yrM.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "showTipsTime";
    locala.yrM.put("showTipsTime", "LONG");
    localStringBuilder.append(" showTipsTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "setFlagTime";
    locala.yrM.put("setFlagTime", "LONG");
    localStringBuilder.append(" setFlagTime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(62862);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.m
 * JD-Core Version:    0.7.0.1
 */