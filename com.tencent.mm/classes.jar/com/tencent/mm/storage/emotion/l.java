package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class l
  extends bn
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105115);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.IBN.put("productID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "productID";
    locala.columns[1] = "content";
    locala.IBN.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "lan";
    locala.IBN.put("lan", "TEXT default '' ");
    localStringBuilder.append(" lan TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105115);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.l
 * JD-Core Version:    0.7.0.1
 */