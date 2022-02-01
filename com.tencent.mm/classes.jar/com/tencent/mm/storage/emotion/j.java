package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends bl
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(105108);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "designerIDAndType";
    locala.GvH.put("designerIDAndType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "designerIDAndType";
    locala.columns[1] = "content";
    locala.GvH.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105108);
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.j
 * JD-Core Version:    0.7.0.1
 */