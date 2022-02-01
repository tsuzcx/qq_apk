package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ch
  extends gk
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(133308);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "tableHash";
    locala.IhC.put("tableHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "tableHash";
    locala.columns[1] = "tableSQLMD5";
    locala.IhC.put("tableSQLMD5", "TEXT");
    localStringBuilder.append(" tableSQLMD5 TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(133308);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ch
 * JD-Core Version:    0.7.0.1
 */