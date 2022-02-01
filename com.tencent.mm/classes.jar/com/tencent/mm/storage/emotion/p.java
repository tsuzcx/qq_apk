package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class p
  extends bo
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105121);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "prodcutID";
    locala.GvH.put("prodcutID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "prodcutID";
    locala.columns[1] = "totalCount";
    locala.GvH.put("totalCount", "INTEGER");
    localStringBuilder.append(" totalCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "continuCount";
    locala.GvH.put("continuCount", "INTEGER");
    localStringBuilder.append(" continuCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "flag";
    locala.GvH.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "modifyTime";
    locala.GvH.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "showTipsTime";
    locala.GvH.put("showTipsTime", "LONG");
    localStringBuilder.append(" showTipsTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "setFlagTime";
    locala.GvH.put("setFlagTime", "LONG");
    localStringBuilder.append(" setFlagTime LONG");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105121);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.p
 * JD-Core Version:    0.7.0.1
 */