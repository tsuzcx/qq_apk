package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ab
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32817);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "deviceId";
    localMAutoDBInfo.colsMap.put("deviceId", "TEXT default '' ");
    localStringBuilder.append(" deviceId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "sessionName";
    localMAutoDBInfo.colsMap.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "moveTime";
    localMAutoDBInfo.colsMap.put("moveTime", "BLOB default '' ");
    localStringBuilder.append(" moveTime BLOB default '' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(32817);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.j
 * JD-Core Version:    0.7.0.1
 */