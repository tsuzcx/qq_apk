package com.tencent.mm.plugin.websearch.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public final class a
{
  public static String F(Map<String, String> paramMap)
  {
    AppMethodBeat.i(91361);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aLw());
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
      localStringBuffer.append(com.tencent.mm.plugin.websearch.api.aa.IZ(bo.apV((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(91361);
    return paramMap;
  }
  
  /* Error */
  private static Properties J(File paramFile)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 107	java/util/Properties
    //   8: dup
    //   9: invokespecial 108	java/util/Properties:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 113	java/io/File:isFile	()Z
    //   17: ifeq +23 -> 40
    //   20: new 115	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 122	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   36: aload_1
    //   37: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   40: ldc 105
    //   42: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_3
    //   46: areturn
    //   47: astore_2
    //   48: aconst_null
    //   49: astore_1
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 129
    //   54: aload_2
    //   55: ldc 131
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_1
    //   65: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   68: goto -28 -> 40
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   78: ldc 105
    //   80: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: goto -12 -> 74
    //   89: astore_2
    //   90: goto -40 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFile	File
    //   28	37	1	localFileInputStream	java.io.FileInputStream
    //   71	13	1	localObject1	Object
    //   85	1	1	localObject2	Object
    //   47	8	2	localException1	java.lang.Exception
    //   89	1	2	localException2	java.lang.Exception
    //   12	34	3	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   20	29	47	java/lang/Exception
    //   20	29	71	finally
    //   31	36	85	finally
    //   52	64	85	finally
    //   31	36	89	java/lang/Exception
  }
  
  public static String aLw()
  {
    AppMethodBeat.i(91358);
    Object localObject = new File(agk(), "wxa_fts/res");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(91358);
    return localObject;
  }
  
  private static int aLx()
  {
    AppMethodBeat.i(91360);
    int i = Integer.valueOf(J(new File(aLw(), "config.conf")).getProperty("version", "0")).intValue();
    AppMethodBeat.o(91360);
    return i;
  }
  
  private static String agk()
  {
    AppMethodBeat.i(91357);
    String str = e.eQw.replace("/data/user/0", "/data/data");
    AppMethodBeat.o(91357);
    return str;
  }
  
  public static Map<String, String> bA(int paramInt, String paramString)
  {
    AppMethodBeat.i(91362);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    localHashMap.put("type", "64");
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(aLx()));
    localHashMap.put("isHomePage", "0");
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("extParams", paramString);
    }
    paramString = com.tencent.mm.model.c.c.abU().me("100192");
    if ((paramString.isValid()) && ("1".equals(paramString.dvN().get("openSearchSuggestion")))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE, Integer.valueOf(64), Boolean.valueOf(bool) });
      if (bool) {
        localHashMap.put("isSug", "1");
      }
      AppMethodBeat.o(91362);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a
 * JD-Core Version:    0.7.0.1
 */