package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ho;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends ho
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(77856);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "recordId";
    localMAutoDBInfo.colsMap.put("recordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" recordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "recordId";
    localMAutoDBInfo.columns[1] = "link";
    localMAutoDBInfo.colsMap.put("link", "TEXT");
    localStringBuilder.append(" link TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "source";
    localMAutoDBInfo.colsMap.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "imgUrl";
    localMAutoDBInfo.colsMap.put("imgUrl", "TEXT");
    localStringBuilder.append(" imgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(77856);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.d
 * JD-Core Version:    0.7.0.1
 */