package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fv
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(91457);
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appid";
    locala.yrM.put("appid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appid";
    locala.columns[1] = "jsExceptionCount";
    locala.yrM.put("jsExceptionCount", "INTEGER");
    localStringBuilder.append(" jsExceptionCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "crashCount";
    locala.yrM.put("crashCount", "INTEGER");
    localStringBuilder.append(" crashCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "beginTimestamp";
    locala.yrM.put("beginTimestamp", "LONG");
    localStringBuilder.append(" beginTimestamp LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "pkgVersion";
    locala.yrM.put("pkgVersion", "INTEGER");
    localStringBuilder.append(" pkgVersion INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(91457);
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