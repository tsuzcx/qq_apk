package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends c
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(28347);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "deeplink";
    localMAutoDBInfo.colsMap.put("deeplink", "TEXT default '' ");
    localStringBuilder.append(" deeplink TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "iconurl";
    localMAutoDBInfo.colsMap.put("iconurl", "TEXT default '' ");
    localStringBuilder.append(" iconurl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG default '' ");
    localStringBuilder.append(" createtime LONG default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(28347);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.n
 * JD-Core Version:    0.7.0.1
 */