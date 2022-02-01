package com.tencent.mm.plugin.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bf
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(143779);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bakLogId";
    localMAutoDBInfo.colsMap.put("bakLogId", "INTEGER");
    localStringBuilder.append(" bakLogId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "valueStr";
    localMAutoDBInfo.colsMap.put("valueStr", "TEXT");
    localStringBuilder.append(" valueStr TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(143779);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.a
 * JD-Core Version:    0.7.0.1
 */