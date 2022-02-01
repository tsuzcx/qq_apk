package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class o
{
  private static o c = null;
  private Context a;
  private File b;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  private o(Context paramContext)
  {
    AppMethodBeat.i(53849);
    this.a = null;
    this.b = null;
    this.d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    this.e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    this.f = "http://log.tbs.qq.com/ajax?c=dl&k=";
    this.g = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    this.h = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    this.i = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    this.j = "https://tbsrecovery.imtt.qq.com/getconfig";
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    h();
    AppMethodBeat.o(53849);
  }
  
  public static o a()
  {
    try
    {
      o localo = c;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static o a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(53848);
      if (c == null) {
        c = new o(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(53848);
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 94
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: invokespecial 97	com/tencent/smtt/utils/o:i	()Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +18 -> 33
    //   18: ldc 67
    //   20: ldc 99
    //   22: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc 94
    //   27: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new 103	java/io/BufferedInputStream
    //   36: dup
    //   37: new 105	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_1
    //   49: new 113	java/util/Properties
    //   52: dup
    //   53: invokespecial 114	java/util/Properties:<init>	()V
    //   56: astore_2
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 117	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_2
    //   63: ldc 119
    //   65: ldc 121
    //   67: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: ldc 121
    //   73: aload_3
    //   74: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +8 -> 85
    //   80: aload_0
    //   81: aload_3
    //   82: putfield 41	com/tencent/smtt/utils/o:d	Ljava/lang/String;
    //   85: aload_2
    //   86: ldc 133
    //   88: ldc 121
    //   90: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: ldc 121
    //   96: aload_3
    //   97: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +8 -> 108
    //   103: aload_0
    //   104: aload_3
    //   105: putfield 49	com/tencent/smtt/utils/o:f	Ljava/lang/String;
    //   108: aload_2
    //   109: ldc 135
    //   111: ldc 121
    //   113: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: ldc 121
    //   119: aload_3
    //   120: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +8 -> 131
    //   126: aload_0
    //   127: aload_3
    //   128: putfield 53	com/tencent/smtt/utils/o:g	Ljava/lang/String;
    //   131: aload_2
    //   132: ldc 137
    //   134: ldc 121
    //   136: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: ldc 121
    //   142: aload_3
    //   143: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +8 -> 154
    //   149: aload_0
    //   150: aload_3
    //   151: putfield 57	com/tencent/smtt/utils/o:h	Ljava/lang/String;
    //   154: aload_2
    //   155: ldc 139
    //   157: ldc 121
    //   159: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_3
    //   163: ldc 121
    //   165: aload_3
    //   166: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +8 -> 177
    //   172: aload_0
    //   173: aload_3
    //   174: putfield 61	com/tencent/smtt/utils/o:i	Ljava/lang/String;
    //   177: aload_2
    //   178: ldc 141
    //   180: ldc 121
    //   182: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: astore_3
    //   186: ldc 121
    //   188: aload_3
    //   189: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifne +8 -> 200
    //   195: aload_0
    //   196: aload_3
    //   197: putfield 65	com/tencent/smtt/utils/o:j	Ljava/lang/String;
    //   200: aload_2
    //   201: ldc 143
    //   203: ldc 121
    //   205: invokevirtual 125	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_2
    //   209: ldc 121
    //   211: aload_2
    //   212: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +8 -> 223
    //   218: aload_0
    //   219: aload_2
    //   220: putfield 45	com/tencent/smtt/utils/o:e	Ljava/lang/String;
    //   223: aload_1
    //   224: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   227: ldc 94
    //   229: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: goto -202 -> 30
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: ldc 94
    //   243: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: goto -216 -> 30
    //   249: astore_3
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: new 148	java/io/StringWriter
    //   257: dup
    //   258: invokespecial 149	java/io/StringWriter:<init>	()V
    //   261: astore_3
    //   262: aload_2
    //   263: new 151	java/io/PrintWriter
    //   266: dup
    //   267: aload_3
    //   268: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   271: invokevirtual 160	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   274: ldc 67
    //   276: new 162	java/lang/StringBuilder
    //   279: dup
    //   280: ldc 164
    //   282: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_3
    //   286: invokevirtual 171	java/io/StringWriter:toString	()Ljava/lang/String;
    //   289: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_1
    //   299: ifnull +40 -> 339
    //   302: aload_1
    //   303: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   306: ldc 94
    //   308: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: goto -281 -> 30
    //   314: astore_1
    //   315: ldc 94
    //   317: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: goto -290 -> 30
    //   323: astore_2
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   332: ldc 94
    //   334: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_2
    //   338: athrow
    //   339: ldc 94
    //   341: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: goto -314 -> 30
    //   347: astore_1
    //   348: goto -16 -> 332
    //   351: astore_2
    //   352: goto -98 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	o
    //   13	211	1	localObject1	Object
    //   235	4	1	localObject2	Object
    //   240	1	1	localIOException1	java.io.IOException
    //   251	52	1	localObject3	Object
    //   314	15	1	localIOException2	java.io.IOException
    //   347	1	1	localIOException3	java.io.IOException
    //   8	255	2	localObject4	Object
    //   323	15	2	localObject5	Object
    //   351	1	2	localObject6	Object
    //   70	127	3	str	String
    //   249	4	3	localObject7	Object
    //   261	25	3	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   2	7	235	finally
    //   25	30	235	finally
    //   223	227	235	finally
    //   227	232	235	finally
    //   241	246	235	finally
    //   302	306	235	finally
    //   306	311	235	finally
    //   315	320	235	finally
    //   328	332	235	finally
    //   332	339	235	finally
    //   339	344	235	finally
    //   223	227	240	java/io/IOException
    //   9	14	249	finally
    //   18	25	249	finally
    //   33	49	249	finally
    //   302	306	314	java/io/IOException
    //   254	298	323	finally
    //   328	332	347	java/io/IOException
    //   49	85	351	finally
    //   85	108	351	finally
    //   108	131	351	finally
    //   131	154	351	finally
    //   154	177	351	finally
    //   177	200	351	finally
    //   200	223	351	finally
  }
  
  /* Error */
  private File i()
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/smtt/utils/o:b	Ljava/io/File;
    //   9: ifnonnull +48 -> 57
    //   12: aload_0
    //   13: new 179	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield 35	com/tencent/smtt/utils/o:a	Landroid/content/Context;
    //   21: iconst_5
    //   22: invokestatic 184	com/tencent/smtt/utils/f:a	(Landroid/content/Context;I)Ljava/lang/String;
    //   25: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: putfield 37	com/tencent/smtt/utils/o:b	Ljava/io/File;
    //   31: aload_0
    //   32: getfield 37	com/tencent/smtt/utils/o:b	Ljava/io/File;
    //   35: ifnull +15 -> 50
    //   38: aload_0
    //   39: getfield 37	com/tencent/smtt/utils/o:b	Ljava/io/File;
    //   42: invokevirtual 189	java/io/File:isDirectory	()Z
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +10 -> 57
    //   50: ldc 177
    //   52: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: new 179	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 37	com/tencent/smtt/utils/o:b	Ljava/io/File;
    //   65: ldc 191
    //   67: invokespecial 194	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 197	java/io/File:exists	()Z
    //   75: ifne +39 -> 114
    //   78: ldc 67
    //   80: new 162	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 199
    //   86: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: invokevirtual 202	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   93: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 204
    //   98: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: ldc 177
    //   109: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aconst_null
    //   113: areturn
    //   114: ldc 67
    //   116: new 162	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 206
    //   122: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_2
    //   126: invokevirtual 202	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   129: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 75	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: ldc 177
    //   140: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: new 148	java/io/StringWriter
    //   151: dup
    //   152: invokespecial 149	java/io/StringWriter:<init>	()V
    //   155: astore 4
    //   157: aload_3
    //   158: new 151	java/io/PrintWriter
    //   161: dup
    //   162: aload 4
    //   164: invokespecial 154	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   167: invokevirtual 160	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   170: ldc 67
    //   172: new 162	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 208
    //   178: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload 4
    //   183: invokevirtual 171	java/io/StringWriter:toString	()Ljava/lang/String;
    //   186: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: goto -57 -> 138
    //   198: astore_3
    //   199: goto -51 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	o
    //   45	2	1	bool	boolean
    //   70	78	2	localFile	File
    //   145	13	3	localObject1	Object
    //   198	1	3	localObject2	Object
    //   155	27	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   5	46	145	finally
    //   57	107	145	finally
    //   114	138	198	finally
  }
  
  public String b()
  {
    AppMethodBeat.i(219363);
    TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.d);
    String str = this.d;
    AppMethodBeat.o(219363);
    return str;
  }
  
  public String c()
  {
    AppMethodBeat.i(219368);
    TbsLog.d("TbsCommonConfig", "getTbsDownloadStatPostUrl:" + this.f);
    String str = this.f;
    AppMethodBeat.o(219368);
    return str;
  }
  
  public String d()
  {
    AppMethodBeat.i(219373);
    TbsLog.d("TbsCommonConfig", "getTbsDownloaderPostUrl:" + this.g);
    String str = this.g;
    AppMethodBeat.o(219373);
    return str;
  }
  
  public String e()
  {
    AppMethodBeat.i(219378);
    TbsLog.d("TbsCommonConfig", "getTbsLogPostUrl:" + this.h);
    String str = this.h;
    AppMethodBeat.o(219378);
    return str;
  }
  
  public String f()
  {
    AppMethodBeat.i(219381);
    TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.e);
    String str = this.e;
    AppMethodBeat.o(219381);
    return str;
  }
  
  public String g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.o
 * JD-Core Version:    0.7.0.1
 */