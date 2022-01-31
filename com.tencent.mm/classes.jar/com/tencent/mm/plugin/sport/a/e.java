package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.et;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class e
  extends et
  implements Comparable<e>
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(55719);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "id";
    locala.yrM.put("id", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "id";
    locala.columns[1] = "date";
    locala.yrM.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "step";
    locala.yrM.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "timestamp";
    locala.yrM.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(55719);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.e
 * JD-Core Version:    0.7.0.1
 */