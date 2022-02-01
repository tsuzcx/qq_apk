package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends a
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(28128);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrid";
    localMAutoDBInfo.columns[1] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "subtype";
    localMAutoDBInfo.colsMap.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tag";
    localMAutoDBInfo.colsMap.put("tag", "TEXT");
    localStringBuilder.append(" tag TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "thumburl";
    localMAutoDBInfo.colsMap.put("thumburl", "TEXT");
    localStringBuilder.append(" thumburl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reservedBuf";
    localMAutoDBInfo.colsMap.put("reservedBuf", "BLOB");
    localStringBuilder.append(" reservedBuf BLOB");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(28128);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.f
 * JD-Core Version:    0.7.0.1
 */