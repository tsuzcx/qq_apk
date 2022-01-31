package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadUpload
{
  private static TbsDownloadUpload b;
  Map<String, Object> a = new HashMap();
  private Context c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  public SharedPreferences mPreferences;
  
  public TbsDownloadUpload(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_upload", 4);
    this.c = paramContext.getApplicationContext();
    if (this.c == null) {
      this.c = paramContext;
    }
  }
  
  private static File a(Context paramContext, String paramString)
  {
    an.a();
    paramContext = an.t(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static void clear()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance()
  {
    try
    {
      TbsDownloadUpload localTbsDownloadUpload = b;
      return localTbsDownloadUpload;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new TbsDownloadUpload(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public void clearUploadCode()
  {
    this.a.put("tbs_needdownload_code", Integer.valueOf(0));
    this.a.put("tbs_startdownload_code", Integer.valueOf(0));
    this.a.put("tbs_needdownload_return", Integer.valueOf(0));
    this.a.put("tbs_needdownload_sent", Integer.valueOf(0));
    this.a.put("tbs_startdownload_sent", Integer.valueOf(0));
    writeTbsDownloadInfo();
  }
  
  public void commit()
  {
    try
    {
      writeTbsDownloadInfo();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getNeedDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 148
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 113	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	i	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  public int getNeedDownloadReturn()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getStartDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 168
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 121	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	i	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public void readTbsDownloadInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   6: ldc 128
    //   8: invokestatic 130	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: new 132	java/io/BufferedInputStream
    //   22: dup
    //   23: new 134	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 140	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_1
    //   35: new 142	java/util/Properties
    //   38: dup
    //   39: invokespecial 143	java/util/Properties:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: ldc 83
    //   51: ldc 148
    //   53: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_3
    //   57: ldc 148
    //   59: aload_3
    //   60: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +15 -> 78
    //   66: aload_0
    //   67: aload_3
    //   68: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: iconst_0
    //   72: invokestatic 168	java/lang/Math:max	(II)I
    //   75: putfield 113	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   78: aload_2
    //   79: ldc 97
    //   81: ldc 148
    //   83: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: ldc 148
    //   89: aload_3
    //   90: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifne +15 -> 108
    //   96: aload_0
    //   97: aload_3
    //   98: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   101: iconst_0
    //   102: invokestatic 168	java/lang/Math:max	(II)I
    //   105: putfield 121	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   108: aload_2
    //   109: ldc 99
    //   111: ldc 148
    //   113: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: ldc 148
    //   119: aload_3
    //   120: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +15 -> 138
    //   126: aload_0
    //   127: aload_3
    //   128: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: iconst_0
    //   132: invokestatic 168	java/lang/Math:max	(II)I
    //   135: putfield 116	com/tencent/smtt/sdk/TbsDownloadUpload:f	I
    //   138: aload_2
    //   139: ldc 101
    //   141: ldc 148
    //   143: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore_3
    //   147: ldc 148
    //   149: aload_3
    //   150: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +15 -> 168
    //   156: aload_0
    //   157: aload_3
    //   158: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   161: iconst_0
    //   162: invokestatic 168	java/lang/Math:max	(II)I
    //   165: putfield 111	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   168: aload_2
    //   169: ldc 103
    //   171: ldc 148
    //   173: invokevirtual 152	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_2
    //   177: ldc 148
    //   179: aload_2
    //   180: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +15 -> 198
    //   186: aload_0
    //   187: aload_2
    //   188: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: iconst_0
    //   192: invokestatic 168	java/lang/Math:max	(II)I
    //   195: putfield 119	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   198: aload_1
    //   199: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   202: goto -186 -> 16
    //   205: astore_1
    //   206: goto -190 -> 16
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull -197 -> 16
    //   216: aload_1
    //   217: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   220: goto -204 -> 16
    //   223: astore_1
    //   224: goto -208 -> 16
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: astore_2
    //   246: goto -8 -> 238
    //   249: astore_2
    //   250: aload_1
    //   251: astore_3
    //   252: aload_2
    //   253: astore_1
    //   254: aload_3
    //   255: astore_2
    //   256: goto -26 -> 230
    //   259: astore_2
    //   260: goto -48 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	TbsDownloadUpload
    //   0	263	1	paramContext	Context
    //   42	193	2	localObject1	Object
    //   245	1	2	localException	java.lang.Exception
    //   249	4	2	localObject2	Object
    //   255	1	2	localObject3	Object
    //   259	1	2	localThrowable	java.lang.Throwable
    //   56	199	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   198	202	205	java/lang/Exception
    //   2	12	209	java/lang/Throwable
    //   19	35	209	java/lang/Throwable
    //   216	220	223	java/lang/Exception
    //   2	12	227	finally
    //   19	35	227	finally
    //   198	202	240	finally
    //   216	220	240	finally
    //   234	238	240	finally
    //   238	240	240	finally
    //   234	238	245	java/lang/Exception
    //   35	78	249	finally
    //   78	108	249	finally
    //   108	138	249	finally
    //   138	168	249	finally
    //   168	198	249	finally
    //   35	78	259	java/lang/Throwable
    //   78	108	259	java/lang/Throwable
    //   108	138	259	java/lang/Throwable
    //   138	168	259	java/lang/Throwable
    //   168	198	259	java/lang/Throwable
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 173
    //   4: ldc 175
    //   6: invokestatic 181	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 47	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   13: ldc 128
    //   15: invokestatic 130	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: new 132	java/io/BufferedInputStream
    //   29: dup
    //   30: new 134	java/io/FileInputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 140	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore_2
    //   42: new 142	java/util/Properties
    //   45: dup
    //   46: invokespecial 143	java/util/Properties:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_2
    //   52: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_0
    //   56: getfield 31	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   59: invokeinterface 185 1 0
    //   64: invokeinterface 191 1 0
    //   69: astore 4
    //   71: aload 4
    //   73: invokeinterface 196 1 0
    //   78: ifeq +101 -> 179
    //   81: aload 4
    //   83: invokeinterface 200 1 0
    //   88: checkcast 154	java/lang/String
    //   91: astore 5
    //   93: aload_0
    //   94: getfield 31	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   97: aload 5
    //   99: invokeinterface 204 2 0
    //   104: astore 6
    //   106: aload_3
    //   107: aload 5
    //   109: aload 6
    //   111: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokevirtual 211	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   117: pop
    //   118: ldc 173
    //   120: new 213	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 215
    //   126: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload 5
    //   131: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 224
    //   136: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 6
    //   141: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 181	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: goto -79 -> 71
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_1
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   164: aload_1
    //   165: ifnull -142 -> 23
    //   168: aload_1
    //   169: invokevirtual 234	java/io/BufferedOutputStream:close	()V
    //   172: goto -149 -> 23
    //   175: astore_1
    //   176: goto -153 -> 23
    //   179: aload_0
    //   180: getfield 31	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   183: invokeinterface 236 1 0
    //   188: new 233	java/io/BufferedOutputStream
    //   191: dup
    //   192: new 238	java/io/FileOutputStream
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   200: invokespecial 242	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   203: astore_1
    //   204: aload_3
    //   205: aload_1
    //   206: aconst_null
    //   207: invokevirtual 246	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   210: aload_2
    //   211: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   214: aload_1
    //   215: invokevirtual 234	java/io/BufferedOutputStream:close	()V
    //   218: goto -195 -> 23
    //   221: astore_1
    //   222: goto -199 -> 23
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 234	java/io/BufferedOutputStream:close	()V
    //   246: aload_1
    //   247: athrow
    //   248: astore_1
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_1
    //   252: athrow
    //   253: astore_2
    //   254: goto -40 -> 214
    //   257: astore_2
    //   258: goto -94 -> 164
    //   261: astore_3
    //   262: goto -24 -> 238
    //   265: astore_2
    //   266: goto -20 -> 246
    //   269: astore_1
    //   270: aconst_null
    //   271: astore 4
    //   273: aload_2
    //   274: astore_3
    //   275: aload 4
    //   277: astore_2
    //   278: goto -48 -> 230
    //   281: astore 4
    //   283: aload_1
    //   284: astore 5
    //   286: aload_2
    //   287: astore_3
    //   288: aload 4
    //   290: astore_1
    //   291: aload 5
    //   293: astore_2
    //   294: goto -64 -> 230
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_1
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -146 -> 156
    //   305: astore_3
    //   306: goto -150 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	TbsDownloadUpload
    //   18	17	1	localFile	File
    //   153	1	1	localThrowable1	java.lang.Throwable
    //   155	14	1	localObject1	Object
    //   175	22	1	localException1	java.lang.Exception
    //   203	12	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   221	1	1	localException2	java.lang.Exception
    //   225	22	1	localObject2	Object
    //   248	4	1	localObject3	Object
    //   269	15	1	localObject4	Object
    //   290	1	1	localObject5	Object
    //   297	1	1	localThrowable2	java.lang.Throwable
    //   299	1	1	localObject6	Object
    //   41	202	2	localBufferedInputStream	java.io.BufferedInputStream
    //   253	1	2	localException3	java.lang.Exception
    //   257	1	2	localException4	java.lang.Exception
    //   265	9	2	localException5	java.lang.Exception
    //   277	25	2	localObject7	Object
    //   49	186	3	localProperties	java.util.Properties
    //   261	1	3	localException6	java.lang.Exception
    //   274	14	3	localObject8	Object
    //   305	1	3	localThrowable3	java.lang.Throwable
    //   69	207	4	localIterator	java.util.Iterator
    //   281	8	4	localObject9	Object
    //   91	201	5	localObject10	Object
    //   104	36	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   42	71	153	java/lang/Throwable
    //   71	150	153	java/lang/Throwable
    //   179	204	153	java/lang/Throwable
    //   168	172	175	java/lang/Exception
    //   214	218	221	java/lang/Exception
    //   9	19	225	finally
    //   26	42	225	finally
    //   2	9	248	finally
    //   160	164	248	finally
    //   168	172	248	finally
    //   210	214	248	finally
    //   214	218	248	finally
    //   234	238	248	finally
    //   242	246	248	finally
    //   246	248	248	finally
    //   210	214	253	java/lang/Exception
    //   160	164	257	java/lang/Exception
    //   234	238	261	java/lang/Exception
    //   242	246	265	java/lang/Exception
    //   42	71	269	finally
    //   71	150	269	finally
    //   179	204	269	finally
    //   204	210	281	finally
    //   9	19	297	java/lang/Throwable
    //   26	42	297	java/lang/Throwable
    //   204	210	305	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadUpload
 * JD-Core Version:    0.7.0.1
 */