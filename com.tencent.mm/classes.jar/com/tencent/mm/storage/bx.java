package com.tencent.mm.storage;

import com.tencent.mm.h.c.ej;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bx
  extends ej
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tableHash";
    locala.ujN.put("tableHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "tableHash";
    locala.columns[1] = "tableSQLMD5";
    locala.ujN.put("tableSQLMD5", "TEXT");
    localStringBuilder.append(" tableSQLMD5 TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bx
 * JD-Core Version:    0.7.0.1
 */