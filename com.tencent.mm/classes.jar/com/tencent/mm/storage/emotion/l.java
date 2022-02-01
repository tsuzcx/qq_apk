package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class l
  extends bo
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105115);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "productID";
    localMAutoDBInfo.colsMap.put("productID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "productID";
    localMAutoDBInfo.columns[1] = "content";
    localMAutoDBInfo.colsMap.put("content", "BLOB default '' ");
    localStringBuilder.append(" content BLOB default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lan";
    localMAutoDBInfo.colsMap.put("lan", "TEXT default '' ");
    localStringBuilder.append(" lan TEXT default '' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(105115);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.l
 * JD-Core Version:    0.7.0.1
 */