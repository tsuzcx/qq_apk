package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class cu
  extends hc
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(148673);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "cmsgId";
    localMAutoDBInfo.colsMap.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(148673);
  }
  
  public final void bkY(String paramString)
  {
    AppMethodBeat.i(148672);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(148672);
      return;
    }
    this.field_cmsgId = paramString;
    AppMethodBeat.o(148672);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cu
 * JD-Core Version:    0.7.0.1
 */