package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends gy
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(116652);
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.GvH.put("appid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "appid";
    locala.columns[1] = "jsExceptionCount";
    locala.GvH.put("jsExceptionCount", "INTEGER");
    localStringBuilder.append(" jsExceptionCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "crashCount";
    locala.GvH.put("crashCount", "INTEGER");
    localStringBuilder.append(" crashCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "beginTimestamp";
    locala.GvH.put("beginTimestamp", "LONG");
    localStringBuilder.append(" beginTimestamp LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "pkgVersion";
    locala.GvH.put("pkgVersion", "INTEGER");
    localStringBuilder.append(" pkgVersion INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116652);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.a
 * JD-Core Version:    0.7.0.1
 */