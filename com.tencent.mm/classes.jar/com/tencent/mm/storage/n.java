package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ad;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends ad
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32833);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionName";
    locala.IBN.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "startTime";
    locala.IBN.put("startTime", "LONG default '0' ");
    localStringBuilder.append(" startTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "endTime";
    locala.IBN.put("endTime", "LONG default '0' ");
    localStringBuilder.append(" endTime LONG default '0' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32833);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.n
 * JD-Core Version:    0.7.0.1
 */