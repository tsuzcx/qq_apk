package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends cr
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(105127);
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqType";
    locala.GvH.put("reqType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "reqType";
    locala.columns[1] = "cache";
    locala.GvH.put("cache", "BLOB default '' ");
    localStringBuilder.append(" cache BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105127);
  }
  
  public r(Cursor paramCursor)
  {
    AppMethodBeat.i(105126);
    if (paramCursor == null)
    {
      AppMethodBeat.o(105126);
      return;
    }
    convertFrom(paramCursor);
    AppMethodBeat.o(105126);
  }
  
  public r(String paramString, byte[] paramArrayOfByte)
  {
    this.field_reqType = paramString;
    this.field_cache = paramArrayOfByte;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.r
 * JD-Core Version:    0.7.0.1
 */