package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class r
{
  private static String a;
  private static String b;
  
  public static final InputStream a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147063);
    paramContext = a(paramContext, "tencentmap/mapsdk_vector/", paramString);
    AppMethodBeat.o(147063);
    return paramContext;
  }
  
  public static final InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147064);
    paramContext = b(paramContext, paramString1 + paramString2);
    AppMethodBeat.o(147064);
    return paramContext;
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147062);
    if (!new File(paramString1, paramString2).exists()) {
      b(paramContext, paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(147062);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(147067);
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      a = str;
    }
    AppMethodBeat.o(147067);
  }
  
  public static final InputStream b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147065);
    if (paramContext == null)
    {
      AppMethodBeat.o(147065);
      return null;
    }
    paramContext = paramContext.getAssets();
    if (paramContext == null)
    {
      AppMethodBeat.o(147065);
      return null;
    }
    try
    {
      paramContext = paramContext.open(paramString);
      AppMethodBeat.o(147065);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(147065);
    }
    return null;
  }
  
  public static String b()
  {
    return b;
  }
  
  /* Error */
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 27	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: invokestatic 97	com/tencent/tencentmap/mapsdk/a/p:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/p;
    //   16: aconst_null
    //   17: invokevirtual 101	com/tencent/tencentmap/mapsdk/a/p:c	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 105	com/tencent/tencentmap/mapsdk/a/t:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore 7
    //   35: aload 7
    //   37: astore 4
    //   39: aload 7
    //   41: ifnonnull +51 -> 92
    //   44: aload 7
    //   46: astore 5
    //   48: aload 7
    //   50: astore 6
    //   52: getstatic 43	com/tencent/tencentmap/mapsdk/a/r:a	Ljava/lang/String;
    //   55: ifnull +154 -> 209
    //   58: aload 7
    //   60: astore 5
    //   62: aload 7
    //   64: astore 6
    //   66: aload_0
    //   67: new 27	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   74: getstatic 43	com/tencent/tencentmap/mapsdk/a/r:a	Ljava/lang/String;
    //   77: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_3
    //   81: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 41	com/tencent/tencentmap/mapsdk/a/r:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   90: astore 4
    //   92: aload 4
    //   94: astore 6
    //   96: aload 4
    //   98: ifnonnull +44 -> 142
    //   101: aload 4
    //   103: astore 5
    //   105: aload 4
    //   107: astore 6
    //   109: new 27	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   116: aload_0
    //   117: invokestatic 97	com/tencent/tencentmap/mapsdk/a/p:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/p;
    //   120: invokevirtual 108	com/tencent/tencentmap/mapsdk/a/p:e	()Ljava/lang/String;
    //   123: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 105	com/tencent/tencentmap/mapsdk/a/t:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   136: astore 4
    //   138: aload 4
    //   140: astore 6
    //   142: aload 6
    //   144: astore 4
    //   146: aload 6
    //   148: ifnonnull +14 -> 162
    //   151: aload 6
    //   153: astore 5
    //   155: aload_0
    //   156: aload_3
    //   157: invokestatic 110	com/tencent/tencentmap/mapsdk/a/r:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   160: astore 4
    //   162: aload 4
    //   164: astore 5
    //   166: aload 4
    //   168: astore 6
    //   170: new 112	java/io/FileOutputStream
    //   173: dup
    //   174: new 47	java/io/File
    //   177: dup
    //   178: aload_1
    //   179: aload_2
    //   180: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   186: astore_0
    //   187: aload 4
    //   189: aload_0
    //   190: invokestatic 118	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   193: pop2
    //   194: aload_0
    //   195: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   198: aload 4
    //   200: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   203: ldc 92
    //   205: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: aload 7
    //   211: astore 4
    //   213: aload 7
    //   215: astore 5
    //   217: aload 7
    //   219: astore 6
    //   221: getstatic 91	com/tencent/tencentmap/mapsdk/a/r:b	Ljava/lang/String;
    //   224: ifnull -132 -> 92
    //   227: aload 7
    //   229: astore 5
    //   231: aload 7
    //   233: astore 6
    //   235: new 27	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   242: getstatic 91	com/tencent/tencentmap/mapsdk/a/r:b	Ljava/lang/String;
    //   245: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_3
    //   249: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 105	com/tencent/tencentmap/mapsdk/a/t:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   258: astore 4
    //   260: goto -168 -> 92
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_0
    //   266: aconst_null
    //   267: astore 4
    //   269: aload_0
    //   270: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   273: aload 4
    //   275: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   278: ldc 92
    //   280: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: return
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_1
    //   287: aconst_null
    //   288: astore 4
    //   290: aload_1
    //   291: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   294: aload 4
    //   296: invokestatic 121	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   299: ldc 92
    //   301: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_0
    //   305: athrow
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_1
    //   309: aload 5
    //   311: astore 4
    //   313: goto -23 -> 290
    //   316: astore_1
    //   317: aload_0
    //   318: astore_2
    //   319: aload_1
    //   320: astore_0
    //   321: aload_2
    //   322: astore_1
    //   323: goto -33 -> 290
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_0
    //   329: aload 6
    //   331: astore 4
    //   333: goto -64 -> 269
    //   336: astore_1
    //   337: goto -68 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	Context
    //   0	340	1	paramString1	String
    //   0	340	2	paramString2	String
    //   0	340	3	paramString3	String
    //   37	295	4	localObject1	Object
    //   46	264	5	localObject2	Object
    //   50	280	6	localObject3	Object
    //   33	199	7	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   5	35	263	java/io/IOException
    //   5	35	284	finally
    //   52	58	306	finally
    //   66	92	306	finally
    //   109	138	306	finally
    //   155	162	306	finally
    //   170	187	306	finally
    //   221	227	306	finally
    //   235	260	306	finally
    //   187	194	316	finally
    //   52	58	326	java/io/IOException
    //   66	92	326	java/io/IOException
    //   109	138	326	java/io/IOException
    //   155	162	326	java/io/IOException
    //   170	187	326	java/io/IOException
    //   221	227	326	java/io/IOException
    //   235	260	326	java/io/IOException
    //   187	194	336	java/io/IOException
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(147068);
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      b = str;
    }
    AppMethodBeat.o(147068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.r
 * JD-Core Version:    0.7.0.1
 */