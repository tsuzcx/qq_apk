package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bm;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends bm
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105105);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "groupID";
    localMAutoDBInfo.colsMap.put("groupID", "TEXT");
    localStringBuilder.append(" groupID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(105105);
  }
  
  public h() {}
  
  public h(String paramString1, String paramString2)
  {
    this.field_groupID = paramString1;
    this.field_desc = paramString2;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.h
 * JD-Core Version:    0.7.0.1
 */