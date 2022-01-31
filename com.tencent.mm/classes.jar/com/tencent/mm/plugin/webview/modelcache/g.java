package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.h.c.ez;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

final class g
  extends ez
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "disable";
    locala.ujN.put("disable", "INTEGER default 'false' ");
    localStringBuilder.append(" disable INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "configId";
    locala.ujN.put("configId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" configId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "configId";
    locala.columns[2] = "configUrl";
    locala.ujN.put("configUrl", "TEXT");
    localStringBuilder.append(" configUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "configResources";
    locala.ujN.put("configResources", "TEXT");
    localStringBuilder.append(" configResources TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "configCrc32";
    locala.ujN.put("configCrc32", "LONG");
    localStringBuilder.append(" configCrc32 LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "isFromXml";
    locala.ujN.put("isFromXml", "INTEGER default 'false' ");
    localStringBuilder.append(" isFromXml INTEGER default 'false' ");
    locala.columns[6] = "rowid";
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
      y.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", localIllegalAccessException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.g
 * JD-Core Version:    0.7.0.1
 */