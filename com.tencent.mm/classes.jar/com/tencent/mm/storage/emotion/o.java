package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.h.c.by;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class o
  extends by
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqType";
    locala.ujN.put("reqType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "reqType";
    locala.columns[1] = "cache";
    locala.ujN.put("cache", "BLOB default '' ");
    localStringBuilder.append(" cache BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public o(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    d(paramCursor);
  }
  
  public o(String paramString, byte[] paramArrayOfByte)
  {
    this.field_reqType = paramString;
    this.field_cache = paramArrayOfByte;
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.o
 * JD-Core Version:    0.7.0.1
 */