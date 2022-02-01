package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ap
  extends az
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(32840);
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "labelId";
    locala.IhC.put("labelId", "TEXT");
    localStringBuilder.append(" labelId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "contactName";
    locala.IhC.put("contactName", "TEXT");
    localStringBuilder.append(" contactName TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(32840);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */