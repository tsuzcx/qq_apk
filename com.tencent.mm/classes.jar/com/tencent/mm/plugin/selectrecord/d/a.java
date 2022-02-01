package com.tencent.mm.plugin.selectrecord.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fz
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(187923);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "historyId";
    localMAutoDBInfo.colsMap.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(187923);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.a
 * JD-Core Version:    0.7.0.1
 */