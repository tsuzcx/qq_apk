package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends bf
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(62856);
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.yrM.put("productID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "productID";
    locala.columns[1] = "content";
    locala.yrM.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "lan";
    locala.yrM.put("lan", "TEXT default '' ");
    localStringBuilder.append(" lan TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(62856);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.i
 * JD-Core Version:    0.7.0.1
 */