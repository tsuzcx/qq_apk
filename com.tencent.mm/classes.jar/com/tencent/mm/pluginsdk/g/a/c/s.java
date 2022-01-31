package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.h.c.dr;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public final class s
  extends dr
{
  public static final c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[34];
    locala.columns = new String[35];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "urlKey_hashcode";
    locala.ujN.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "urlKey_hashcode";
    locala.columns[1] = "urlKey";
    locala.ujN.put("urlKey", "TEXT");
    localStringBuilder.append(" urlKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "fileVersion";
    locala.ujN.put("fileVersion", "TEXT");
    localStringBuilder.append(" fileVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "networkType";
    locala.ujN.put("networkType", "INTEGER default '2' ");
    localStringBuilder.append(" networkType INTEGER default '2' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "maxRetryTimes";
    locala.ujN.put("maxRetryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" maxRetryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "retryTimes";
    locala.ujN.put("retryTimes", "INTEGER default '3' ");
    localStringBuilder.append(" retryTimes INTEGER default '3' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "filePath";
    locala.ujN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.ujN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "contentLength";
    locala.ujN.put("contentLength", "LONG default '0' ");
    localStringBuilder.append(" contentLength LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "contentType";
    locala.ujN.put("contentType", "TEXT");
    localStringBuilder.append(" contentType TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "expireTime";
    locala.ujN.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "md5";
    locala.ujN.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "groupId1";
    locala.ujN.put("groupId1", "TEXT");
    localStringBuilder.append(" groupId1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId2";
    locala.ujN.put("groupId2", "TEXT");
    localStringBuilder.append(" groupId2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "priority";
    locala.ujN.put("priority", "INTEGER default '0' ");
    localStringBuilder.append(" priority INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "fileUpdated";
    locala.ujN.put("fileUpdated", "INTEGER");
    localStringBuilder.append(" fileUpdated INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleted";
    locala.ujN.put("deleted", "INTEGER default 'false' ");
    localStringBuilder.append(" deleted INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "resType";
    locala.ujN.put("resType", "INTEGER");
    localStringBuilder.append(" resType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "subType";
    locala.ujN.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[20] = "reportId";
    locala.ujN.put("reportId", "LONG");
    localStringBuilder.append(" reportId LONG");
    localStringBuilder.append(", ");
    locala.columns[21] = "sampleId";
    locala.ujN.put("sampleId", "TEXT");
    localStringBuilder.append(" sampleId TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "eccSignature";
    locala.ujN.put("eccSignature", "BLOB");
    localStringBuilder.append(" eccSignature BLOB");
    localStringBuilder.append(", ");
    locala.columns[23] = "originalMd5";
    locala.ujN.put("originalMd5", "TEXT");
    localStringBuilder.append(" originalMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "fileCompress";
    locala.ujN.put("fileCompress", "INTEGER default 'false' ");
    localStringBuilder.append(" fileCompress INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "fileEncrypt";
    locala.ujN.put("fileEncrypt", "INTEGER default 'false' ");
    localStringBuilder.append(" fileEncrypt INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[26] = "encryptKey";
    locala.ujN.put("encryptKey", "TEXT");
    localStringBuilder.append(" encryptKey TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "keyVersion";
    locala.ujN.put("keyVersion", "INTEGER default '0' ");
    localStringBuilder.append(" keyVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "EID";
    locala.ujN.put("EID", "INTEGER");
    localStringBuilder.append(" EID INTEGER");
    localStringBuilder.append(", ");
    locala.columns[29] = "fileSize";
    locala.ujN.put("fileSize", "LONG");
    localStringBuilder.append(" fileSize LONG");
    localStringBuilder.append(", ");
    locala.columns[30] = "needRetry";
    locala.ujN.put("needRetry", "INTEGER default '1' ");
    localStringBuilder.append(" needRetry INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[31] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "wvCacheType";
    locala.ujN.put("wvCacheType", "INTEGER");
    localStringBuilder.append(" wvCacheType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[33] = "packageId";
    locala.ujN.put("packageId", "TEXT");
    localStringBuilder.append(" packageId TEXT");
    locala.columns[34] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    localStringBuilder = new StringBuilder("ResDownloaderRecord {");
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
          Object localObject = localField2.get(this);
          localStringBuilder.append(localField2.getName().replaceFirst("field_", "")).append(" = ").append(localObject).append(", ");
        }
        i += 1;
      }
      try
      {
        Field localField1 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
        localField1.setAccessible(true);
        localStringBuilder.append("systemRowid = ").append(localField1.get(this));
        return " }";
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException2, "", new Object[0]);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ResDownloaderRecord", localNoSuchFieldException, "", new Object[0]);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      y.printErrStackTrace("MicroMsg.ResDownloaderRecord", localIllegalAccessException1, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.s
 * JD-Core Version:    0.7.0.1
 */