package com.tencent.skyline.jni;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;

public final class IOUtil
{
  private static final String TAG = "IOUtil";
  
  /* Error */
  public static String convertStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 26	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 29	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   13: astore_2
    //   14: sipush 16384
    //   17: newarray char
    //   19: astore_3
    //   20: new 31	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 32	java/io/StringWriter:<init>	()V
    //   27: astore 4
    //   29: aload_2
    //   30: aload_3
    //   31: invokevirtual 36	java/io/InputStreamReader:read	([C)I
    //   34: istore_1
    //   35: iconst_m1
    //   36: iload_1
    //   37: if_icmpeq +48 -> 85
    //   40: aload 4
    //   42: aload_3
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 40	java/io/StringWriter:write	([CII)V
    //   48: goto -19 -> 29
    //   51: astore_3
    //   52: ldc 42
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_3
    //   61: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   68: pop
    //   69: aload_2
    //   70: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   73: aload_0
    //   74: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   77: ldc 18
    //   79: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: ldc 61
    //   84: areturn
    //   85: aload_2
    //   86: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   89: aload_0
    //   90: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   93: aload 4
    //   95: invokevirtual 64	java/io/StringWriter:toString	()Ljava/lang/String;
    //   98: astore_0
    //   99: ldc 18
    //   101: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_3
    //   107: aload_2
    //   108: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: invokestatic 56	com/tencent/skyline/jni/IOUtil:qualityClose	(Ljava/io/Closeable;)V
    //   115: ldc 18
    //   117: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_3
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramInputStream	java.io.InputStream
    //   34	11	1	i	int
    //   13	95	2	localInputStreamReader	java.io.InputStreamReader
    //   19	24	3	arrayOfChar	char[]
    //   51	10	3	localException	Exception
    //   106	15	3	localObject	Object
    //   27	67	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   29	35	51	java/lang/Exception
    //   40	48	51	java/lang/Exception
    //   29	35	106	finally
    //   40	48	106	finally
    //   52	69	106	finally
  }
  
  public static String getAssetAsString(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210726);
    Object localObject = paramContext.getAssets();
    paramContext = null;
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String.format("openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      }
      paramContext = convertStreamToString(paramContext);
      AppMethodBeat.o(210726);
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(210726);
      return "";
    }
    return paramContext;
  }
  
  public static void qualityClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(210704);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(210704);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(210704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.skyline.jni.IOUtil
 * JD-Core Version:    0.7.0.1
 */