package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.string.StringUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class cb
{
  static String a = "tafnode.dat";
  static Properties b = new Properties();
  static AtomicBoolean c = new AtomicBoolean();
  static long d = System.currentTimeMillis();
  static Object e = new Object();
  
  public static double a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
    return new BigDecimal(Double.toString(paramDouble1)).divide(new BigDecimal(Double.toString(paramDouble2)), paramInt, 4).doubleValue();
  }
  
  public static an<ArrayList<bg>, ArrayList<bg>> a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = a(paramString);
    if (str == null) {
      bc.a("can not find cacheServerData " + paramString);
    }
    for (;;)
    {
      return null;
      bc.a("getConfigFromRegister failed, try to use backData");
      try
      {
        an localan = aq.a(paramString, paramInt1, paramInt2, paramInt3, str);
        return localan;
      }
      catch (Exception localException)
      {
        bc.a("read cacheServerData " + paramString + " serviceList error " + str, localException);
      }
    }
  }
  
  public static lu a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str;
    int i;
    if ((paramString6 == null) || (paramString6.length() == 0))
    {
      paramString6 = paramString1 + "@1.4.1";
      str = "";
      paramString7 = "";
      paramString8 = "";
      i = 0;
      if ((paramString9 == null) || (paramString9.length() <= 0)) {
        break label235;
      }
      paramString9 = StringUtil.split(paramString9, ".");
      if (paramString9.length != 3) {
        break label235;
      }
      paramString1 = paramString9[0];
      paramString7 = paramString9[1];
      paramString8 = paramString9[2];
      i = 1;
      paramString2 = b(a(paramString2, 127));
      paramString9 = paramString1 + paramString7 + paramString8 + "." + paramString2;
      paramString2 = paramString1;
      paramString1 = paramString9;
    }
    for (;;)
    {
      paramString9 = paramString1;
      if (i == 0) {
        paramString9 = a(paramString1, 127);
      }
      return new lu(paramString6, paramString9, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString2, paramString7, paramString8, "");
      paramString1 = b(paramString1);
      paramString6 = paramString6 + paramString7 + paramString8 + paramString1 + "@1.4.1";
      break;
      label235:
      paramString1 = paramString2;
      paramString2 = str;
    }
  }
  
  public static String a(String paramString)
  {
    a();
    return b.getProperty(paramString);
  }
  
  private static String a(String paramString, int paramInt)
  {
    String str = "";
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt);
      }
    }
    return str;
  }
  
  public static String a(String paramString, Class paramClass)
  {
    paramClass = paramClass.getResource(paramString).getPath();
    paramString = paramClass;
    if (paramClass.startsWith("file:"))
    {
      paramClass = paramClass.substring(paramClass.indexOf("/"));
      i = paramClass.indexOf("!");
      paramString = paramClass;
      if (i > 0) {
        paramString = paramClass.substring(0, i);
      }
    }
    paramClass = paramString;
    if (b())
    {
      paramClass = paramString;
      if (paramString.startsWith("/")) {
        paramClass = paramString.substring(1);
      }
    }
    char c1 = File.separatorChar;
    if (b()) {
      c1 = '/';
    }
    int i = paramClass.indexOf("WEB-INF");
    paramString = paramClass;
    if (i > 0) {
      paramString = paramClass.substring(0, i + 7) + c1 + "classes" + c1;
    }
    paramClass = paramString;
    if (paramString.charAt(paramString.length() - 1) != c1) {
      paramClass = paramString.substring(0, paramString.lastIndexOf(c1) + 1);
    }
    return paramClass;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/tencent/tencentmap/mapsdk/a/cb:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 207	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_0
    //   10: iload_0
    //   11: ifeq +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_1
    //   22: invokestatic 210	com/tencent/tencentmap/mapsdk/a/cb:d	()Ljava/io/InputStream;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_1
    //   28: aload_3
    //   29: astore_2
    //   30: getstatic 27	com/tencent/tencentmap/mapsdk/a/cb:b	Ljava/util/Properties;
    //   33: aload_3
    //   34: invokevirtual 214	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   37: aload_3
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: new 216	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 217	java/util/ArrayList:<init>	()V
    //   48: astore 4
    //   50: aload_3
    //   51: astore_1
    //   52: aload_3
    //   53: astore_2
    //   54: getstatic 27	com/tencent/tencentmap/mapsdk/a/cb:b	Ljava/util/Properties;
    //   57: invokevirtual 221	java/util/Properties:entrySet	()Ljava/util/Set;
    //   60: invokeinterface 227 1 0
    //   65: astore 5
    //   67: aload_3
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: aload 5
    //   73: invokeinterface 232 1 0
    //   78: ifeq +119 -> 197
    //   81: aload_3
    //   82: astore_1
    //   83: aload_3
    //   84: astore_2
    //   85: aload 5
    //   87: invokeinterface 236 1 0
    //   92: checkcast 238	java/util/Map$Entry
    //   95: astore 6
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: aload 6
    //   103: invokeinterface 241 1 0
    //   108: invokevirtual 242	java/lang/Object:toString	()Ljava/lang/String;
    //   111: ldc 244
    //   113: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   116: ifeq -49 -> 67
    //   119: aload_3
    //   120: astore_1
    //   121: aload_3
    //   122: astore_2
    //   123: aload 4
    //   125: aload 6
    //   127: invokeinterface 241 1 0
    //   132: invokevirtual 242	java/lang/Object:toString	()Ljava/lang/String;
    //   135: invokevirtual 248	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: goto -72 -> 67
    //   142: astore_3
    //   143: aload_1
    //   144: astore_2
    //   145: new 250	com/tencent/tencentmap/mapsdk/a/bq
    //   148: dup
    //   149: new 77	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 252
    //   155: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: getstatic 20	com/tencent/tencentmap/mapsdk/a/cb:a	Ljava/lang/String;
    //   161: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 254
    //   166: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 258	com/tencent/tencentmap/mapsdk/a/bq:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_1
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 263	java/io/InputStream:close	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: ldc 2
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: aload_3
    //   198: astore_1
    //   199: aload_3
    //   200: astore_2
    //   201: aload 4
    //   203: invokevirtual 264	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   206: astore 4
    //   208: aload_3
    //   209: astore_1
    //   210: aload_3
    //   211: astore_2
    //   212: aload 4
    //   214: invokeinterface 232 1 0
    //   219: ifeq +35 -> 254
    //   222: aload_3
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: aload 4
    //   228: invokeinterface 236 1 0
    //   233: checkcast 110	java/lang/String
    //   236: astore 5
    //   238: aload_3
    //   239: astore_1
    //   240: aload_3
    //   241: astore_2
    //   242: getstatic 27	com/tencent/tencentmap/mapsdk/a/cb:b	Ljava/util/Properties;
    //   245: aload 5
    //   247: invokevirtual 268	java/util/Properties:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -43 -> 208
    //   254: aload_3
    //   255: astore_1
    //   256: aload_3
    //   257: astore_2
    //   258: new 77	java/lang/StringBuilder
    //   261: dup
    //   262: ldc_w 270
    //   265: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: getstatic 20	com/tencent/tencentmap/mapsdk/a/cb:a	Ljava/lang/String;
    //   271: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 91	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   280: aload_3
    //   281: astore_1
    //   282: aload_3
    //   283: astore_2
    //   284: getstatic 32	com/tencent/tencentmap/mapsdk/a/cb:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   287: iconst_1
    //   288: invokevirtual 274	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   291: aload_3
    //   292: ifnull -278 -> 14
    //   295: aload_3
    //   296: invokevirtual 263	java/io/InputStream:close	()V
    //   299: goto -285 -> 14
    //   302: astore_1
    //   303: goto -289 -> 14
    //   306: astore_2
    //   307: goto -118 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	2	0	bool	boolean
    //   21	123	1	localObject1	Object
    //   180	10	1	localObject2	Object
    //   191	5	1	localObject3	Object
    //   198	84	1	localObject4	Object
    //   302	1	1	localIOException1	java.io.IOException
    //   19	265	2	localObject5	Object
    //   306	1	2	localIOException2	java.io.IOException
    //   25	97	3	localInputStream	InputStream
    //   142	154	3	localException	Exception
    //   48	179	4	localObject6	Object
    //   65	181	5	localObject7	Object
    //   95	31	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   22	26	142	java/lang/Exception
    //   30	37	142	java/lang/Exception
    //   41	50	142	java/lang/Exception
    //   54	67	142	java/lang/Exception
    //   71	81	142	java/lang/Exception
    //   85	97	142	java/lang/Exception
    //   101	119	142	java/lang/Exception
    //   123	139	142	java/lang/Exception
    //   201	208	142	java/lang/Exception
    //   212	222	142	java/lang/Exception
    //   226	238	142	java/lang/Exception
    //   242	251	142	java/lang/Exception
    //   258	280	142	java/lang/Exception
    //   284	291	142	java/lang/Exception
    //   22	26	180	finally
    //   30	37	180	finally
    //   41	50	180	finally
    //   54	67	180	finally
    //   71	81	180	finally
    //   85	97	180	finally
    //   101	119	180	finally
    //   123	139	180	finally
    //   145	180	180	finally
    //   201	208	180	finally
    //   212	222	180	finally
    //   226	238	180	finally
    //   242	251	180	finally
    //   258	280	180	finally
    //   284	291	180	finally
    //   3	10	191	finally
    //   185	189	191	finally
    //   189	191	191	finally
    //   295	299	191	finally
    //   295	299	302	java/io/IOException
    //   185	189	306	java/io/IOException
  }
  
  public static void a(String arg0, String paramString2)
  {
    a();
    b.put(???, paramString2);
    synchronized (e)
    {
      if (System.currentTimeMillis() - d > 60000L)
      {
        d = System.currentTimeMillis();
        c();
      }
      return;
    }
  }
  
  private static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null)
    {
      int i = paramString.indexOf('.');
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring(i + 1);
      }
    }
    return str1;
  }
  
  public static boolean b()
  {
    return File.separatorChar == '\\';
  }
  
  /* Error */
  public static void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: astore_0
    //   6: invokestatic 139	com/tencent/tencentmap/mapsdk/a/cb:a	()V
    //   9: aload_1
    //   10: astore_0
    //   11: new 183	java/io/File
    //   14: dup
    //   15: getstatic 20	com/tencent/tencentmap/mapsdk/a/cb:a	Ljava/lang/String;
    //   18: invokespecial 286	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: aload_1
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual 289	java/io/File:exists	()Z
    //   28: ifne +10 -> 38
    //   31: aload_1
    //   32: astore_0
    //   33: aload_3
    //   34: invokevirtual 292	java/io/File:createNewFile	()Z
    //   37: pop
    //   38: aload_1
    //   39: astore_0
    //   40: new 294	java/io/BufferedOutputStream
    //   43: dup
    //   44: new 296	java/io/FileOutputStream
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_1
    //   56: getstatic 27	com/tencent/tencentmap/mapsdk/a/cb:b	Ljava/util/Properties;
    //   59: aload_1
    //   60: new 304	java/util/Date
    //   63: dup
    //   64: invokespecial 305	java/util/Date:<init>	()V
    //   67: invokevirtual 306	java/util/Date:toString	()Ljava/lang/String;
    //   70: invokevirtual 310	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   73: new 77	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 312
    //   80: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: getstatic 20	com/tencent/tencentmap/mapsdk/a/cb:a	Ljava/lang/String;
    //   86: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 91	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 315	java/io/OutputStream:close	()V
    //   99: return
    //   100: astore_0
    //   101: aload_2
    //   102: astore_1
    //   103: aload_0
    //   104: astore_2
    //   105: aload_1
    //   106: astore_0
    //   107: new 77	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 312
    //   114: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: getstatic 20	com/tencent/tencentmap/mapsdk/a/cb:a	Ljava/lang/String;
    //   120: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 317
    //   126: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aload_2
    //   133: invokestatic 105	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_1
    //   137: ifnull -38 -> 99
    //   140: aload_1
    //   141: invokevirtual 315	java/io/OutputStream:close	()V
    //   144: return
    //   145: astore_0
    //   146: return
    //   147: astore_2
    //   148: aload_0
    //   149: astore_1
    //   150: aload_2
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 315	java/io/OutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: return
    //   164: astore_1
    //   165: goto -5 -> 160
    //   168: astore_0
    //   169: goto -17 -> 152
    //   172: astore_2
    //   173: goto -68 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	35	0	localObject1	Object
    //   100	4	0	localException1	Exception
    //   106	1	0	localObject2	Object
    //   145	4	0	localIOException1	java.io.IOException
    //   151	10	0	localObject3	Object
    //   162	1	0	localIOException2	java.io.IOException
    //   168	1	0	localObject4	Object
    //   1	156	1	localObject5	Object
    //   164	1	1	localIOException3	java.io.IOException
    //   3	130	2	localObject6	Object
    //   147	4	2	localObject7	Object
    //   172	1	2	localException2	Exception
    //   21	28	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	9	100	java/lang/Exception
    //   11	22	100	java/lang/Exception
    //   24	31	100	java/lang/Exception
    //   33	38	100	java/lang/Exception
    //   40	56	100	java/lang/Exception
    //   140	144	145	java/io/IOException
    //   6	9	147	finally
    //   11	22	147	finally
    //   24	31	147	finally
    //   33	38	147	finally
    //   40	56	147	finally
    //   107	136	147	finally
    //   95	99	162	java/io/IOException
    //   156	160	164	java/io/IOException
    //   56	95	168	finally
    //   56	95	172	java/lang/Exception
  }
  
  private static InputStream d()
  {
    File localFile = new File(a("TafUtils.class", cb.class));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    Object localObject = File.separator;
    if (b()) {
      localObject = "/";
    }
    localObject = new File(localFile + (String)localObject + "tafnode.dat");
    if (!((File)localObject).exists()) {
      ((File)localObject).createNewFile();
    }
    a = ((File)localObject).getAbsolutePath();
    bc.a("set dataFilePath " + a);
    return new BufferedInputStream(new FileInputStream((File)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cb
 * JD-Core Version:    0.7.0.1
 */