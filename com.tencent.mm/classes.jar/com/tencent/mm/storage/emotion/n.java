package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends bo
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105118);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.IBN.put("productID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "productID";
    locala.columns[1] = "content";
    locala.IBN.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105118);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.n
 * JD-Core Version:    0.7.0.1
 */