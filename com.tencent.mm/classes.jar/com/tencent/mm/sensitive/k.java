package com.tencent.mm.sensitive;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/SensitiveUtils;", "", "()V", "TAG", "", "getFromAssets", "context", "Landroid/content/Context;", "fileName", "isTest", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static final String TAG;
  public static final k acud;
  
  static
  {
    AppMethodBeat.i(240890);
    acud = new k();
    TAG = "SensitiveUtils";
    AppMethodBeat.o(240890);
  }
  
  /* Error */
  public static String cl(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 55
    //   8: invokestatic 61	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 62
    //   14: invokestatic 61	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 68	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: aload_1
    //   22: invokevirtual 74	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 80	java/io/InputStream:available	()I
    //   30: newarray byte
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 84	java/io/InputStream:read	([B)I
    //   38: pop
    //   39: getstatic 90	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   42: astore_2
    //   43: aload_2
    //   44: ldc 91
    //   46: invokestatic 94	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   49: new 96	java/lang/String
    //   52: dup
    //   53: aload_1
    //   54: aload_2
    //   55: invokespecial 99	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull +33 -> 93
    //   63: aload_0
    //   64: invokevirtual 102	java/io/InputStream:close	()V
    //   67: aload_1
    //   68: astore_0
    //   69: ldc 54
    //   71: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: getstatic 44	com/tencent/mm/sensitive/k:TAG	Ljava/lang/String;
    //   80: aload_0
    //   81: checkcast 104	java/lang/Throwable
    //   84: ldc 105
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: astore_0
    //   95: goto -26 -> 69
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: getstatic 44	com/tencent/mm/sensitive/k:TAG	Ljava/lang/String;
    //   104: aload_1
    //   105: checkcast 104	java/lang/Throwable
    //   108: ldc 112
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: getstatic 118	com/tencent/mm/sensitive/d/a:acvx	Lcom/tencent/mm/sensitive/d/a;
    //   120: astore_2
    //   121: ldc 120
    //   123: ldc 122
    //   125: aload_1
    //   126: invokevirtual 126	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   129: invokestatic 130	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokestatic 134	com/tencent/mm/sensitive/d/a:pC	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: ifnull +30 -> 166
    //   139: aload_0
    //   140: invokevirtual 102	java/io/InputStream:close	()V
    //   143: ldc 135
    //   145: astore_0
    //   146: goto -77 -> 69
    //   149: astore_0
    //   150: getstatic 44	com/tencent/mm/sensitive/k:TAG	Ljava/lang/String;
    //   153: aload_0
    //   154: checkcast 104	java/lang/Throwable
    //   157: ldc 105
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: ldc 135
    //   168: astore_0
    //   169: goto -100 -> 69
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 102	java/io/InputStream:close	()V
    //   183: ldc 54
    //   185: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_0
    //   191: getstatic 44	com/tencent/mm/sensitive/k:TAG	Ljava/lang/String;
    //   194: aload_0
    //   195: checkcast 104	java/lang/Throwable
    //   198: ldc 105
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -24 -> 183
    //   210: astore_1
    //   211: goto -36 -> 175
    //   214: astore_1
    //   215: goto -40 -> 175
    //   218: astore_1
    //   219: goto -118 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramContext	android.content.Context
    //   0	222	1	paramString	String
    //   42	79	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	76	java/lang/Exception
    //   17	26	98	java/lang/Exception
    //   139	143	149	java/lang/Exception
    //   17	26	172	finally
    //   179	183	190	java/lang/Exception
    //   26	59	210	finally
    //   101	135	214	finally
    //   26	59	218	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.k
 * JD-Core Version:    0.7.0.1
 */