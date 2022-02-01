package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ac;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class l
  extends ac
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32825);
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgListDataId";
    locala.EYv.put("msgListDataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "msgListDataId";
    locala.columns[1] = "sessionName";
    locala.EYv.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32825);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.l
 * JD-Core Version:    0.7.0.1
 */