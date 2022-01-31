package com.tencent.mm.storage.emotion;

import com.tencent.mm.h.c.bc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends bc
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "designerIDAndType";
    locala.ujN.put("designerIDAndType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "designerIDAndType";
    locala.columns[1] = "content";
    locala.ujN.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.g
 * JD-Core Version:    0.7.0.1
 */