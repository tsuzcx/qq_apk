package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ar;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ae
  extends ar
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(1102);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.yrM.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "username";
    locala.columns[1] = "cmdbuf";
    locala.yrM.put("cmdbuf", "BLOB default '' ");
    localStringBuilder.append(" cmdbuf BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(1102);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */