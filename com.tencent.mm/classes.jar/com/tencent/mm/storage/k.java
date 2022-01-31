package com.tencent.mm.storage;

import com.tencent.mm.h.c.v;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends v
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgListDataId";
    locala.ujN.put("msgListDataId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msgListDataId";
    locala.columns[1] = "sessionName";
    locala.ujN.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.k
 * JD-Core Version:    0.7.0.1
 */