package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ga;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends ga
{
  public static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(152071);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[34];
    localMAutoDBInfo.columns = new String[35];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "urlKey_hashcode";
    localMAutoDBInfo.colsMap.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "urlKey_hashcode";
    localMAutoDBInfo.columns[1] = "urlKey";
    localMAutoDBInfo.colsMap.put("urlKey", "TEXT");
    localStringBuilder.append(" urlKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "fileVersion";
    localMAutoDBInfo.colsMap.put("fileVersion", "TEXT");
    localStringBuilder.append(" fileVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "networkType";
    localMAutoDBInfo.colsMap.put("networkType", "INTEGER default '2' ");
    localStringBuilder.append(" networkType INTEGER default '2' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "maxRetryTimes";
    localMAutoDBInfo.colsMap.put("maxRetryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" maxRetryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "retryTimes";
    localMAutoDBInfo.colsMap.put("retryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" retryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "contentLength";
    localMAutoDBInfo.colsMap.put("contentLength", "LONG default '0' ");
    localStringBuilder.append(" contentLength LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "contentType";
    localMAutoDBInfo.colsMap.put("contentType", "TEXT");
    localStringBuilder.append(" contentType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "groupId1";
    localMAutoDBInfo.colsMap.put("groupId1", "TEXT");
    localStringBuilder.append(" groupId1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "groupId2";
    localMAutoDBInfo.colsMap.put("groupId2", "TEXT");
    localStringBuilder.append(" groupId2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "priority";
    localMAutoDBInfo.colsMap.put("priority", "INTEGER default '0' ");
    localStringBuilder.append(" priority INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "fileUpdated";
    localMAutoDBInfo.colsMap.put("fileUpdated", "INTEGER");
    localStringBuilder.append(" fileUpdated INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "deleted";
    localMAutoDBInfo.colsMap.put("deleted", "INTEGER default 'false' ");
    localStringBuilder.append(" deleted INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "resType";
    localMAutoDBInfo.colsMap.put("resType", "INTEGER");
    localStringBuilder.append(" resType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "subType";
    localMAutoDBInfo.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "reportId";
    localMAutoDBInfo.colsMap.put("reportId", "LONG");
    localStringBuilder.append(" reportId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "sampleId";
    localMAutoDBInfo.colsMap.put("sampleId", "TEXT");
    localStringBuilder.append(" sampleId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "eccSignature";
    localMAutoDBInfo.colsMap.put("eccSignature", "BLOB");
    localStringBuilder.append(" eccSignature BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "originalMd5";
    localMAutoDBInfo.colsMap.put("originalMd5", "TEXT");
    localStringBuilder.append(" originalMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "fileCompress";
    localMAutoDBInfo.colsMap.put("fileCompress", "INTEGER default 'false' ");
    localStringBuilder.append(" fileCompress INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "fileEncrypt";
    localMAutoDBInfo.colsMap.put("fileEncrypt", "INTEGER default 'false' ");
    localStringBuilder.append(" fileEncrypt INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "encryptKey";
    localMAutoDBInfo.colsMap.put("encryptKey", "TEXT");
    localStringBuilder.append(" encryptKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "keyVersion";
    localMAutoDBInfo.colsMap.put("keyVersion", "INTEGER default '0' ");
    localStringBuilder.append(" keyVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "EID";
    localMAutoDBInfo.colsMap.put("EID", "INTEGER");
    localStringBuilder.append(" EID INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "fileSize";
    localMAutoDBInfo.colsMap.put("fileSize", "LONG");
    localStringBuilder.append(" fileSize LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "needRetry";
    localMAutoDBInfo.colsMap.put("needRetry", "INTEGER default '1' ");
    localStringBuilder.append(" needRetry INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "wvCacheType";
    localMAutoDBInfo.colsMap.put("wvCacheType", "INTEGER");
    localStringBuilder.append(" wvCacheType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "packageId";
    localMAutoDBInfo.colsMap.put("packageId", "TEXT");
    localStringBuilder.append(" packageId TEXT");
    localMAutoDBInfo.columns[34] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(152071);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152070);
    localObject1 = new StringBuilder("ResDownloaderRecord {");
    try
    {
      Field[] arrayOfField = getClass().getSuperclass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField2 = arrayOfField[i];
        if (localField2.getName().startsWith("field_"))
        {
          localField2.setAccessible(true);
          Object localObject2 = localField2.get(this);
          ((StringBuilder)localObject1).append(localField2.getName().replaceFirst("field_", "")).append(" = ").append(localObject2).append(", ");
        }
        i += 1;
      }
      try
      {
        Field localField1 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
        localField1.setAccessible(true);
        ((StringBuilder)localObject1).append("systemRowid = ").append(localField1.get(this));
        localObject1 = " }";
        AppMethodBeat.o(152070);
        return localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException2, "", new Object[0]);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", localNoSuchFieldException, "", new Object[0]);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      Log.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException1, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.c.r
 * JD-Core Version:    0.7.0.1
 */