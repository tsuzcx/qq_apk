package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fa;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bx
  extends fa
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(59016);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tableHash";
    locala.yrM.put("tableHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "tableHash";
    locala.columns[1] = "tableSQLMD5";
    locala.yrM.put("tableSQLMD5", "TEXT");
    localStringBuilder.append(" tableSQLMD5 TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(59016);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bx
 * JD-Core Version:    0.7.0.1
 */