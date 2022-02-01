package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hi
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(116652);
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.IhC.put("appid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "appid";
    locala.columns[1] = "jsExceptionCount";
    locala.IhC.put("jsExceptionCount", "INTEGER");
    localStringBuilder.append(" jsExceptionCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "crashCount";
    locala.IhC.put("crashCount", "INTEGER");
    localStringBuilder.append(" crashCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "beginTimestamp";
    locala.IhC.put("beginTimestamp", "LONG");
    localStringBuilder.append(" beginTimestamp LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "pkgVersion";
    locala.IhC.put("pkgVersion", "INTEGER");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.a
 * JD-Core Version:    0.7.0.1
 */