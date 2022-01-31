package com.tencent.mm.storage;

import com.tencent.mm.h.c.u;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends u
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceId";
    locala.ujN.put("deviceId", "TEXT default '' ");
    localStringBuilder.append(" deviceId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "sessionName";
    locala.ujN.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "moveTime";
    locala.ujN.put("moveTime", "BLOB default '' ");
    localStringBuilder.append(" moveTime BLOB default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.i
 * JD-Core Version:    0.7.0.1
 */