package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends eu
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(127262);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tipId";
    localMAutoDBInfo.colsMap.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tipId";
    localMAutoDBInfo.columns[1] = "tipVersion";
    localMAutoDBInfo.colsMap.put("tipVersion", "INTEGER");
    localStringBuilder.append(" tipVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "tipkey";
    localMAutoDBInfo.colsMap.put("tipkey", "TEXT");
    localStringBuilder.append(" tipkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "tipType";
    localMAutoDBInfo.colsMap.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isExit";
    localMAutoDBInfo.colsMap.put("isExit", "INTEGER");
    localStringBuilder.append(" isExit INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hadRead";
    localMAutoDBInfo.colsMap.put("hadRead", "INTEGER");
    localStringBuilder.append(" hadRead INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isReject";
    localMAutoDBInfo.colsMap.put("isReject", "INTEGER");
    localStringBuilder.append(" isReject INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "beginShowTime";
    localMAutoDBInfo.colsMap.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "disappearTime";
    localMAutoDBInfo.colsMap.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "overdueTime";
    localMAutoDBInfo.colsMap.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "tipsShowInfo";
    localMAutoDBInfo.colsMap.put("tipsShowInfo", "BLOB");
    localStringBuilder.append(" tipsShowInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "pagestaytime";
    localMAutoDBInfo.colsMap.put("pagestaytime", "LONG");
    localStringBuilder.append(" pagestaytime LONG");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(127262);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.b.a
 * JD-Core Version:    0.7.0.1
 */