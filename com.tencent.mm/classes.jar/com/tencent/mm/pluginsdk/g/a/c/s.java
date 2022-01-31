package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Map;

public final class s
  extends ec
{
  public static final c.a info;
  
  static
  {
    AppMethodBeat.i(79628);
    c.a locala = new c.a();
    locala.yrK = new Field[34];
    locala.columns = new String[35];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "urlKey_hashcode";
    locala.yrM.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "urlKey_hashcode";
    locala.columns[1] = "urlKey";
    locala.yrM.put("urlKey", "TEXT");
    localStringBuilder.append(" urlKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "fileVersion";
    locala.yrM.put("fileVersion", "TEXT");
    localStringBuilder.append(" fileVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "networkType";
    locala.yrM.put("networkType", "INTEGER default '2' ");
    localStringBuilder.append(" networkType INTEGER default '2' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "maxRetryTimes";
    locala.yrM.put("maxRetryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" maxRetryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "retryTimes";
    locala.yrM.put("retryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" retryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "filePath";
    locala.yrM.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.yrM.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "contentLength";
    locala.yrM.put("contentLength", "LONG default '0' ");
    localStringBuilder.append(" contentLength LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "contentType";
    locala.yrM.put("contentType", "TEXT");
    localStringBuilder.append(" contentType TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "expireTime";
    locala.yrM.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "md5";
    locala.yrM.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "groupId1";
    locala.yrM.put("groupId1", "TEXT");
    localStringBuilder.append(" groupId1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId2";
    locala.yrM.put("groupId2", "TEXT");
    localStringBuilder.append(" groupId2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "priority";
    locala.yrM.put("priority", "INTEGER default '0' ");
    localStringBuilder.append(" priority INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "fileUpdated";
    locala.yrM.put("fileUpdated", "INTEGER");
    localStringBuilder.append(" fileUpdated INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleted";
    locala.yrM.put("deleted", "INTEGER default 'false' ");
    localStringBuilder.append(" deleted INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "resType";
    locala.yrM.put("resType", "INTEGER");
    localStringBuilder.append(" resType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "subType";
    locala.yrM.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[20] = "reportId";
    locala.yrM.put("reportId", "LONG");
    localStringBuilder.append(" reportId LONG");
    localStringBuilder.append(", ");
    locala.columns[21] = "sampleId";
    locala.yrM.put("sampleId", "TEXT");
    localStringBuilder.append(" sampleId TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "eccSignature";
    locala.yrM.put("eccSignature", "BLOB");
    localStringBuilder.append(" eccSignature BLOB");
    localStringBuilder.append(", ");
    locala.columns[23] = "originalMd5";
    locala.yrM.put("originalMd5", "TEXT");
    localStringBuilder.append(" originalMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "fileCompress";
    locala.yrM.put("fileCompress", "INTEGER default 'false' ");
    localStringBuilder.append(" fileCompress INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "fileEncrypt";
    locala.yrM.put("fileEncrypt", "INTEGER default 'false' ");
    localStringBuilder.append(" fileEncrypt INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "encryptKey";
    locala.yrM.put("encryptKey", "TEXT");
    localStringBuilder.append(" encryptKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "keyVersion";
    locala.yrM.put("keyVersion", "INTEGER default '0' ");
    localStringBuilder.append(" keyVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "EID";
    locala.yrM.put("EID", "INTEGER");
    localStringBuilder.append(" EID INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "fileSize";
    locala.yrM.put("fileSize", "LONG");
    localStringBuilder.append(" fileSize LONG");
    localStringBuilder.append(", ");
    locala.columns[30] = "needRetry";
    locala.yrM.put("needRetry", "INTEGER default '1' ");
    localStringBuilder.append(" needRetry INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[31] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "wvCacheType";
    locala.yrM.put("wvCacheType", "INTEGER");
    localStringBuilder.append(" wvCacheType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[33] = "packageId";
    locala.yrM.put("packageId", "TEXT");
    localStringBuilder.append(" packageId TEXT");
    locala.columns[34] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(79628);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79627);
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
        AppMethodBeat.o(79627);
        return localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException2, "", new Object[0]);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", localNoSuchFieldException, "", new Object[0]);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException1, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.s
 * JD-Core Version:    0.7.0.1
 */