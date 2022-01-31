package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends at
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(29024);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "labelId";
    locala.yrM.put("labelId", "TEXT");
    localStringBuilder.append(" labelId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "contactName";
    locala.yrM.put("contactName", "TEXT");
    localStringBuilder.append(" contactName TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(29024);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.ag
 * JD-Core Version:    0.7.0.1
 */