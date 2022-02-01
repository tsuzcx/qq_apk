package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class cl
  extends gb
{
  protected static Field[] fields;
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(43301);
    fields = gb.getValidFields(cl.class);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrid";
    localMAutoDBInfo.columns[1] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "sayhiuser";
    localMAutoDBInfo.colsMap.put("sayhiuser", "TEXT");
    localStringBuilder.append(" sayhiuser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sayhicontent";
    localMAutoDBInfo.colsMap.put("sayhicontent", "TEXT");
    localStringBuilder.append(" sayhicontent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "imgpath";
    localMAutoDBInfo.colsMap.put("imgpath", "TEXT");
    localStringBuilder.append(" imgpath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(43301);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cl
 * JD-Core Version:    0.7.0.1
 */