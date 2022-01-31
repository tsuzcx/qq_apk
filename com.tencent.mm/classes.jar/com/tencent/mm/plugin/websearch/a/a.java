package com.tencent.mm.plugin.websearch.a;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  /* Error */
  public static java.util.Properties A(File paramFile)
  {
    // Byte code:
    //   0: new 10	java/util/Properties
    //   3: dup
    //   4: invokespecial 14	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 20	java/io/File:isFile	()Z
    //   12: ifeq +23 -> 35
    //   15: new 22	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 29	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   31: aload_1
    //   32: invokestatic 34	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   35: aload_3
    //   36: areturn
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: ldc 36
    //   44: aload_2
    //   45: ldc 38
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 44	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_1
    //   55: invokestatic 34	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   58: aload_3
    //   59: areturn
    //   60: astore_1
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: invokestatic 34	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: goto -7 -> 63
    //   73: astore_2
    //   74: goto -34 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramFile	File
    //   23	32	1	localFileInputStream	java.io.FileInputStream
    //   60	8	1	localObject1	Object
    //   69	1	1	localObject2	Object
    //   37	8	2	localException1	java.lang.Exception
    //   73	1	2	localException2	java.lang.Exception
    //   7	52	3	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   15	24	37	java/lang/Exception
    //   15	24	60	finally
    //   26	31	69	finally
    //   42	54	69	finally
    //   26	31	73	java/lang/Exception
  }
  
  public static String aoA()
  {
    File localFile = new File(e.dOQ.replace("/data/user/0", "/data/data"), "wxa_fts/res");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath();
  }
  
  public static String v(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aoA());
    localStringBuffer.append("/app.html?");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuffer.append("&");
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
    }
    if (!paramMap.containsKey("sessionId"))
    {
      localStringBuffer.append("&");
      localStringBuffer.append("sessionId");
      localStringBuffer.append("=");
      localStringBuffer.append(aa.Bm(bk.ZR((String)paramMap.get("scene"))));
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a
 * JD-Core Version:    0.7.0.1
 */