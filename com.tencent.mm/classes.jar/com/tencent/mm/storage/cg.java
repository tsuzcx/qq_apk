package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fc;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class cg
  extends fc
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(32880);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appId";
    localMAutoDBInfo.columns[1] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT");
    localStringBuilder.append(" packageName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sceneFlag";
    localMAutoDBInfo.colsMap.put("sceneFlag", "INTEGER default '0' ");
    localStringBuilder.append(" sceneFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "msgTypeFlag";
    localMAutoDBInfo.colsMap.put("msgTypeFlag", "INTEGER default '0' ");
    localStringBuilder.append(" msgTypeFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "msgState";
    localMAutoDBInfo.colsMap.put("msgState", "INTEGER default '0' ");
    localStringBuilder.append(" msgState INTEGER default '0' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(32880);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cg
 * JD-Core Version:    0.7.0.1
 */