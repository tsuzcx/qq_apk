package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends fw
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(51587);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "productId";
    localMAutoDBInfo.colsMap.put("productId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" productId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "productId";
    localMAutoDBInfo.columns[1] = "xmlContent";
    localMAutoDBInfo.colsMap.put("xmlContent", "TEXT");
    localStringBuilder.append(" xmlContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ScanTime";
    localMAutoDBInfo.colsMap.put("ScanTime", "LONG");
    localStringBuilder.append(" ScanTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "funcType";
    localMAutoDBInfo.colsMap.put("funcType", "INTEGER");
    localStringBuilder.append(" funcType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "qrcodeUrl";
    localMAutoDBInfo.colsMap.put("qrcodeUrl", "TEXT");
    localStringBuilder.append(" qrcodeUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(51587);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.a.a
 * JD-Core Version:    0.7.0.1
 */