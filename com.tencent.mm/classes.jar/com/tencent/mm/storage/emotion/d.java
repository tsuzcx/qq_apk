package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bk;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bk
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105049);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "md5_lang";
    localMAutoDBInfo.colsMap.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "md5_lang";
    localMAutoDBInfo.columns[1] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lang";
    localMAutoDBInfo.colsMap.put("lang", "TEXT COLLATE NOCASE ");
    localStringBuilder.append(" lang TEXT COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "click_flag";
    localMAutoDBInfo.colsMap.put("click_flag", "INTEGER");
    localStringBuilder.append(" click_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "download_flag";
    localMAutoDBInfo.colsMap.put("download_flag", "INTEGER");
    localStringBuilder.append(" download_flag INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(105049);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
  
  public final String getMd5()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.d
 * JD-Core Version:    0.7.0.1
 */