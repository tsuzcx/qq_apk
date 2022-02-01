package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends bh
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(183925);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "designerUin";
    localMAutoDBInfo.colsMap.put("designerUin", "INTEGER");
    localStringBuilder.append(" designerUin INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "productId";
    localMAutoDBInfo.colsMap.put("productId", "TEXT");
    localStringBuilder.append(" productId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "syncTime";
    localMAutoDBInfo.colsMap.put("syncTime", "INTEGER");
    localStringBuilder.append(" syncTime INTEGER");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(183925);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.a
 * JD-Core Version:    0.7.0.1
 */