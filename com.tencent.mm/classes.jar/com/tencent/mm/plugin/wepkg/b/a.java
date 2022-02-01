package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hm;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends hm
{
  public static final IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(110557);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "pkgId";
    localMAutoDBInfo.colsMap.put("pkgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" pkgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "pkgId";
    localMAutoDBInfo.columns[1] = "version";
    localMAutoDBInfo.colsMap.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "oldVersion";
    localMAutoDBInfo.colsMap.put("oldVersion", "TEXT");
    localStringBuilder.append(" oldVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "oldPath";
    localMAutoDBInfo.colsMap.put("oldPath", "TEXT");
    localStringBuilder.append(" oldPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "downloadUrl";
    localMAutoDBInfo.colsMap.put("downloadUrl", "TEXT");
    localStringBuilder.append(" downloadUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "pkgSize";
    localMAutoDBInfo.colsMap.put("pkgSize", "INTEGER");
    localStringBuilder.append(" pkgSize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadNetType";
    localMAutoDBInfo.colsMap.put("downloadNetType", "INTEGER");
    localStringBuilder.append(" downloadNetType INTEGER");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(110557);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b.a
 * JD-Core Version:    0.7.0.1
 */