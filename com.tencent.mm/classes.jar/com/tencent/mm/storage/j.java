package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ab
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32817);
    c.a locala = new c.a();
    locala.GvF = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceId";
    locala.GvH.put("deviceId", "TEXT default '' ");
    localStringBuilder.append(" deviceId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "sessionName";
    locala.GvH.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "moveTime";
    locala.GvH.put("moveTime", "BLOB default '' ");
    localStringBuilder.append(" moveTime BLOB default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32817);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.j
 * JD-Core Version:    0.7.0.1
 */