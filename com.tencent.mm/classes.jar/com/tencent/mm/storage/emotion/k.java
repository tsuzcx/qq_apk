package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends bg
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(62859);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.yrM.put("productID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "productID";
    locala.columns[1] = "content";
    locala.yrM.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(62859);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.k
 * JD-Core Version:    0.7.0.1
 */