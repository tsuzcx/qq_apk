package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class p
  extends bp
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105121);
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "prodcutID";
    locala.IhC.put("prodcutID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "prodcutID";
    locala.columns[1] = "totalCount";
    locala.IhC.put("totalCount", "INTEGER");
    localStringBuilder.append(" totalCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "continuCount";
    locala.IhC.put("continuCount", "INTEGER");
    localStringBuilder.append(" continuCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "flag";
    locala.IhC.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "modifyTime";
    locala.IhC.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "showTipsTime";
    locala.IhC.put("showTipsTime", "LONG");
    localStringBuilder.append(" showTipsTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "setFlagTime";
    locala.IhC.put("setFlagTime", "LONG");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.p
 * JD-Core Version:    0.7.0.1
 */