package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hv
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(116652);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appid";
    localMAutoDBInfo.colsMap.put("appid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appid";
    localMAutoDBInfo.columns[1] = "jsExceptionCount";
    localMAutoDBInfo.colsMap.put("jsExceptionCount", "INTEGER");
    localStringBuilder.append(" jsExceptionCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "crashCount";
    localMAutoDBInfo.colsMap.put("crashCount", "INTEGER");
    localStringBuilder.append(" crashCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "beginTimestamp";
    localMAutoDBInfo.colsMap.put("beginTimestamp", "LONG");
    localStringBuilder.append(" beginTimestamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pkgVersion";
    localMAutoDBInfo.colsMap.put("pkgVersion", "INTEGER");
    localStringBuilder.append(" pkgVersion INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(116652);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.a
 * JD-Core Version:    0.7.0.1
 */