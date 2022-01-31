package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.be;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends be
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(62849);
    c.a locala = new c.a();
    locala.yrK = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "designerIDAndType";
    locala.yrM.put("designerIDAndType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "designerIDAndType";
    locala.columns[1] = "content";
    locala.yrM.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(62849);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */