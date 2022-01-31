package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class t
{
  private static String a;
  private static String b;
  
  public static final InputStream a(Context paramContext, String paramString)
  {
    return a(paramContext, "tencentmap/mapsdk_vector/", paramString);
  }
  
  public static final InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, paramString1 + paramString2);
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!new File(paramString1, paramString2).exists()) {
      b(paramContext, paramString1, paramString2, paramString3);
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      a = str;
    }
  }
  
  public static final InputStream b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = paramContext.getAssets();
    } while (paramContext == null);
    try
    {
      paramContext = paramContext.open(paramString);
      return paramContext;
    }
    catch (IOException paramContext) {}
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
    //   0: new 16	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokestatic 82	com/tencent/tencentmap/mapsdk/a/r:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/r;
    //   11: aconst_null
    //   12: invokevirtual 86	com/tencent/tencentmap/mapsdk/a/r:h	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_3
    //   19: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 90	com/tencent/tencentmap/mapsdk/a/v:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore 7
    //   30: aload 7
    //   32: astore 4
    //   34: aload 7
    //   36: ifnonnull +51 -> 87
    //   39: aload 7
    //   41: astore 5
    //   43: aload 7
    //   45: astore 6
    //   47: getstatic 32	com/tencent/tencentmap/mapsdk/a/t:a	Ljava/lang/String;
    //   50: ifnull +149 -> 199
    //   53: aload 7
    //   55: astore 5
    //   57: aload 7
    //   59: astore 6
    //   61: aload_0
    //   62: new 16	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   69: getstatic 32	com/tencent/tencentmap/mapsdk/a/t:a	Ljava/lang/String;
    //   72: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 30	com/tencent/tencentmap/mapsdk/a/t:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   85: astore 4
    //   87: aload 4
    //   89: astore 6
    //   91: aload 4
    //   93: ifnonnull +44 -> 137
    //   96: aload 4
    //   98: astore 5
    //   100: aload 4
    //   102: astore 6
    //   104: new 16	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   111: aload_0
    //   112: invokestatic 82	com/tencent/tencentmap/mapsdk/a/r:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/r;
    //   115: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/r:i	()Ljava/lang/String;
    //   118: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 90	com/tencent/tencentmap/mapsdk/a/v:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore 4
    //   133: aload 4
    //   135: astore 6
    //   137: aload 6
    //   139: astore 4
    //   141: aload 6
    //   143: ifnonnull +14 -> 157
    //   146: aload 6
    //   148: astore 5
    //   150: aload_0
    //   151: aload_3
    //   152: invokestatic 95	com/tencent/tencentmap/mapsdk/a/t:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   155: astore 4
    //   157: aload 4
    //   159: astore 5
    //   161: aload 4
    //   163: astore 6
    //   165: new 97	java/io/FileOutputStream
    //   168: dup
    //   169: new 35	java/io/File
    //   172: dup
    //   173: aload_1
    //   174: aload_2
    //   175: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: astore_0
    //   182: aload 4
    //   184: aload_0
    //   185: invokestatic 103	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   188: pop2
    //   189: aload_0
    //   190: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   193: aload 4
    //   195: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   198: return
    //   199: aload 7
    //   201: astore 4
    //   203: aload 7
    //   205: astore 5
    //   207: aload 7
    //   209: astore 6
    //   211: getstatic 77	com/tencent/tencentmap/mapsdk/a/t:b	Ljava/lang/String;
    //   214: ifnull -127 -> 87
    //   217: aload 7
    //   219: astore 5
    //   221: aload 7
    //   223: astore 6
    //   225: new 16	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   232: getstatic 77	com/tencent/tencentmap/mapsdk/a/t:b	Ljava/lang/String;
    //   235: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 90	com/tencent/tencentmap/mapsdk/a/v:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   248: astore 4
    //   250: goto -163 -> 87
    //   253: astore_0
    //   254: aconst_null
    //   255: astore_0
    //   256: aconst_null
    //   257: astore 4
    //   259: aload_0
    //   260: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   263: aload 4
    //   265: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   268: return
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_1
    //   272: aconst_null
    //   273: astore 4
    //   275: aload_1
    //   276: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   279: aload 4
    //   281: invokestatic 106	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_1
    //   289: aload 5
    //   291: astore 4
    //   293: goto -18 -> 275
    //   296: astore_1
    //   297: aload_0
    //   298: astore_2
    //   299: aload_1
    //   300: astore_0
    //   301: aload_2
    //   302: astore_1
    //   303: goto -28 -> 275
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_0
    //   309: aload 6
    //   311: astore 4
    //   313: goto -54 -> 259
    //   316: astore_1
    //   317: goto -58 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramString1	String
    //   0	320	2	paramString2	String
    //   0	320	3	paramString3	String
    //   32	280	4	localObject1	Object
    //   41	249	5	localObject2	Object
    //   45	265	6	localObject3	Object
    //   28	194	7	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	30	253	java/io/IOException
    //   0	30	269	finally
    //   47	53	286	finally
    //   61	87	286	finally
    //   104	133	286	finally
    //   150	157	286	finally
    //   165	182	286	finally
    //   211	217	286	finally
    //   225	250	286	finally
    //   182	189	296	finally
    //   47	53	306	java/io/IOException
    //   61	87	306	java/io/IOException
    //   104	133	306	java/io/IOException
    //   150	157	306	java/io/IOException
    //   165	182	306	java/io/IOException
    //   211	217	306	java/io/IOException
    //   225	250	306	java/io/IOException
    //   182	189	316	java/io/IOException
  }
  
  public static void b(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      b = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.t
 * JD-Core Version:    0.7.0.1
 */