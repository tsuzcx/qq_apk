package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.go;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class u
  extends go
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(203216);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" groupId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "groupId";
    localMAutoDBInfo.columns[1] = "groupTime";
    localMAutoDBInfo.colsMap.put("groupTime", "INTEGER");
    localStringBuilder.append(" groupTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "groupStrcut";
    localMAutoDBInfo.colsMap.put("groupStrcut", "BLOB");
    localStringBuilder.append(" groupStrcut BLOB");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(203216);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */