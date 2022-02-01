package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class q
  extends cp
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(105127);
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "reqType";
    locala.EYv.put("reqType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "reqType";
    locala.columns[1] = "cache";
    locala.EYv.put("cache", "BLOB default '' ");
    localStringBuilder.append(" cache BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(105127);
  }
  
  public q(Cursor paramCursor)
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
  
  public q(String paramString, byte[] paramArrayOfByte)
  {
    this.field_reqType = paramString;
    this.field_cache = paramArrayOfByte;
  }
  
  public final c.a getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.q
 * JD-Core Version:    0.7.0.1
 */