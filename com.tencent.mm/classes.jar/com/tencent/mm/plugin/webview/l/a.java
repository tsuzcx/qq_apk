package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.compatible.util.q;
import kotlin.l;
import org.apache.commons.b.f;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"config", "Lcom/tencent/mm/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getConfig", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "host", "", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "meta", "getMeta", "pkgVersion", "", "getPkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "htmlEncode", "kotlin.jvm.PlatformType", "readFile", "path", "safeReadFile", "toJsString", "webview-sdk_release"})
public final class a
{
  public static final i a(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    AppMethodBeat.i(205414);
    kotlin.g.b.p.k(paramp, "$this$meta");
    paramp = new i(a(paramp, "/meta.json"));
    AppMethodBeat.o(205414);
    return paramp;
  }
  
  /* Error */
  public static final String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 67
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 69
    //   10: invokestatic 49	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 70
    //   16: invokestatic 49	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 76 2 0
    //   26: checkcast 78	java/io/Closeable
    //   29: astore_3
    //   30: aload_3
    //   31: checkcast 80	java/io/InputStream
    //   34: astore_0
    //   35: aload_0
    //   36: ldc 82
    //   38: invokestatic 85	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: new 87	java/lang/String
    //   44: dup
    //   45: aload_0
    //   46: invokestatic 93	kotlin/f/a:S	(Ljava/io/InputStream;)[B
    //   49: getstatic 99	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   52: invokespecial 102	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   55: astore_0
    //   56: aload_3
    //   57: aconst_null
    //   58: invokestatic 107	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   61: ldc 67
    //   63: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore_1
    //   69: ldc 67
    //   71: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_0
    //   77: aload_3
    //   78: aload_1
    //   79: invokestatic 107	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: ldc 67
    //   84: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: astore_1
    //   92: goto -15 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
    //   0	95	1	paramString	String
    //   1	90	2	localObject	Object
    //   29	49	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   30	56	68	java/lang/Throwable
    //   69	76	76	finally
    //   30	56	89	finally
  }
  
  public static final int b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    AppMethodBeat.i(205415);
    kotlin.g.b.p.k(paramp, "$this$pkgVersion");
    int i = a(paramp).optInt("version");
    AppMethodBeat.o(205415);
    return i;
  }
  
  /* Error */
  public static final String b(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 121
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 123
    //   10: invokestatic 49	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 70
    //   16: invokestatic 49	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 76 2 0
    //   26: checkcast 78	java/io/Closeable
    //   29: astore_3
    //   30: aload_3
    //   31: checkcast 80	java/io/InputStream
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +30 -> 66
    //   39: new 87	java/lang/String
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 93	kotlin/f/a:S	(Ljava/io/InputStream;)[B
    //   47: getstatic 99	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   50: invokespecial 102	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   53: astore_0
    //   54: aload_3
    //   55: aconst_null
    //   56: invokestatic 107	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   59: ldc 121
    //   61: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: ldc 124
    //   68: astore_0
    //   69: goto -15 -> 54
    //   72: astore_1
    //   73: ldc 121
    //   75: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: athrow
    //   80: astore_0
    //   81: aload_3
    //   82: aload_1
    //   83: invokestatic 107	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   86: ldc 121
    //   88: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: goto -15 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
    //   0	99	1	paramString	String
    //   1	94	2	localObject	Object
    //   29	53	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   30	35	72	java/lang/Throwable
    //   39	54	72	java/lang/Throwable
    //   73	80	80	finally
    //   30	35	93	finally
    //   39	54	93	finally
  }
  
  public static final String bnr(String paramString)
  {
    AppMethodBeat.i(82769);
    kotlin.g.b.p.k(paramString, "$this$htmlEncode");
    paramString = q.an(paramString, "UTF-8");
    AppMethodBeat.o(82769);
    return paramString;
  }
  
  public static final String bns(String paramString)
  {
    AppMethodBeat.i(82770);
    kotlin.g.b.p.k(paramString, "$this$toJsString");
    paramString = "'" + f.bIi(paramString) + '\'';
    AppMethodBeat.o(82770);
    return paramString;
  }
  
  public static final String getHost(String paramString)
  {
    AppMethodBeat.i(205411);
    kotlin.g.b.p.k(paramString, "$this$host");
    try
    {
      paramString = Uri.parse(paramString);
      kotlin.g.b.p.j(paramString, "Uri.parse(this)");
      String str = paramString.getHost();
      paramString = str;
      if (str == null) {
        paramString = "unknow";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "unknow";
      }
    }
    AppMethodBeat.o(205411);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.a
 * JD-Core Version:    0.7.0.1
 */