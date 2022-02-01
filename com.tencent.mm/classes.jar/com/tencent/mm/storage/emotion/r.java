package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends dg
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105127);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "reqType";
    localMAutoDBInfo.colsMap.put("reqType", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqType TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "reqType";
    localMAutoDBInfo.columns[1] = "cache";
    localMAutoDBInfo.colsMap.put("cache", "BLOB default '' ");
    localStringBuilder.append(" cache BLOB default '' ");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
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
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.r
 * JD-Core Version:    0.7.0.1
 */