package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends c
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(153150);
    c.a locala = new c.a();
    locala.EYt = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "abtestkey";
    locala.EYv.put("abtestkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "abtestkey";
    locala.columns[1] = "value";
    locala.EYv.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "expId";
    locala.EYv.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sequence";
    locala.EYv.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "prioritylevel";
    locala.EYv.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "startTime";
    locala.EYv.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "endTime";
    locala.EYv.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "noReport";
    locala.EYv.put("noReport", "INTEGER");
    localStringBuilder.append(" noReport INTEGER");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(153150);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153149);
    long l = bt.aGK();
    if ((l >= this.field_startTime) && (l < this.field_endTime))
    {
      AppMethodBeat.o(153149);
      return true;
    }
    AppMethodBeat.o(153149);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.a
 * JD-Core Version:    0.7.0.1
 */