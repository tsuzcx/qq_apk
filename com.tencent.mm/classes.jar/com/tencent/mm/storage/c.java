package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.d;
import com.tencent.mm.model.c.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends d
  implements Serializable
{
  protected static c.a info;
  private Map<String, String> InG = null;
  
  static
  {
    AppMethodBeat.i(153160);
    c.a locala = new c.a();
    locala.IhA = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "layerId";
    locala.IhC.put("layerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" layerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "layerId";
    locala.columns[1] = "business";
    locala.IhC.put("business", "TEXT");
    localStringBuilder.append(" business TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "expId";
    locala.IhC.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sequence";
    locala.IhC.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "prioritylevel";
    locala.IhC.put("prioritylevel", "INTEGER default '0' ");
    localStringBuilder.append(" prioritylevel INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "startTime";
    locala.IhC.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "endTime";
    locala.IhC.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "needReport";
    locala.IhC.put("needReport", "INTEGER");
    localStringBuilder.append(" needReport INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "rawXML";
    locala.IhC.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(153160);
  }
  
  public final Map<String, String> foF()
  {
    AppMethodBeat.i(153159);
    if (this.InG == null) {
      this.InG = a.BR(this.field_rawXML);
    }
    Map localMap = this.InG;
    AppMethodBeat.o(153159);
    return localMap;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153158);
    long l = bt.aQJ();
    if ((l >= this.field_startTime) && (l <= this.field_endTime))
    {
      AppMethodBeat.o(153158);
      return true;
    }
    AppMethodBeat.o(153158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.c
 * JD-Core Version:    0.7.0.1
 */