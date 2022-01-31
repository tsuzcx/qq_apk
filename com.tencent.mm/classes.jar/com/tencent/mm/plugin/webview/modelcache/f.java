package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.h.c.fd;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends fd
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "urlMd5Hashcode";
    locala.ujN.put("urlMd5Hashcode", "INTEGER");
    localStringBuilder.append(" urlMd5Hashcode INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "domain";
    locala.ujN.put("domain", "TEXT");
    localStringBuilder.append(" domain TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "version";
    locala.ujN.put("version", "TEXT");
    localStringBuilder.append(" version TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "localPath";
    locala.ujN.put("localPath", "TEXT");
    localStringBuilder.append(" localPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "contentType";
    locala.ujN.put("contentType", "TEXT");
    localStringBuilder.append(" contentType TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "contentLength";
    locala.ujN.put("contentLength", "LONG");
    localStringBuilder.append(" contentLength LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "isLatestVersion";
    locala.ujN.put("isLatestVersion", "INTEGER");
    localStringBuilder.append(" isLatestVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "createTime";
    locala.ujN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "accessTime";
    locala.ujN.put("accessTime", "LONG");
    localStringBuilder.append(" accessTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "expireTime";
    locala.ujN.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "cacheType";
    locala.ujN.put("cacheType", "INTEGER");
    localStringBuilder.append(" cacheType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "configId";
    locala.ujN.put("configId", "TEXT");
    localStringBuilder.append(" configId TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "protocol";
    locala.ujN.put("protocol", "INTEGER");
    localStringBuilder.append(" protocol INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "packageId";
    locala.ujN.put("packageId", "TEXT");
    localStringBuilder.append(" packageId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "contentMd5";
    locala.ujN.put("contentMd5", "TEXT");
    localStringBuilder.append(" contentMd5 TEXT");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final String toString()
  {
    localStringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
    try
    {
      Field[] arrayOfField = getClass().getSuperclass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.getName().startsWith("field_"))
        {
          localField.setAccessible(true);
          Object localObject = localField.get(this);
          localStringBuilder.append(localField.getName().replaceFirst("field_", "")).append(" = ").append(localObject).append(", ");
        }
        i += 1;
      }
      return " }";
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      y.printErrStackTrace("MicroMsg.WebViewCacheRes", localIllegalAccessException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.f
 * JD-Core Version:    0.7.0.1
 */