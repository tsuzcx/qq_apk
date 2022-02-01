package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class w
  extends gn
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(203222);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "top";
    localMAutoDBInfo.colsMap.put("top", "LONG");
    localStringBuilder.append(" top LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "bottom";
    localMAutoDBInfo.colsMap.put("bottom", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bottom LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bottom";
    localMAutoDBInfo.columns[2] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(203222);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.w
 * JD-Core Version:    0.7.0.1
 */