package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class n
{
  private static n c = null;
  private Context a;
  private File b;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  @TargetApi(11)
  private n(Context paramContext)
  {
    AppMethodBeat.i(53862);
    this.a = null;
    this.b = null;
    this.d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    this.e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    this.f = "http://wup.imtt.qq.com:8080";
    this.g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    this.h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    this.i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    this.j = "http://mqqad.html5.qq.com/adjs";
    this.k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    g();
    AppMethodBeat.o(53862);
  }
  
  public static n a()
  {
    try
    {
      n localn = c;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(53861);
      if (c == null) {
        c = new n(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(53861);
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 105
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: invokespecial 108	com/tencent/smtt/utils/n:h	()Ljava/io/File;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +18 -> 33
    //   18: ldc 75
    //   20: ldc 110
    //   22: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc 105
    //   27: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new 114	java/io/BufferedInputStream
    //   36: dup
    //   37: new 116	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: new 124	java/util/Properties
    //   52: dup
    //   53: invokespecial 125	java/util/Properties:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 128	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_1
    //   63: ldc 130
    //   65: ldc 132
    //   67: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: ldc 132
    //   73: aload_3
    //   74: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +8 -> 85
    //   80: aload_0
    //   81: aload_3
    //   82: putfield 45	com/tencent/smtt/utils/n:d	Ljava/lang/String;
    //   85: aload_1
    //   86: ldc 144
    //   88: ldc 132
    //   90: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: ldc 132
    //   96: aload_3
    //   97: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +8 -> 108
    //   103: aload_0
    //   104: aload_3
    //   105: putfield 53	com/tencent/smtt/utils/n:f	Ljava/lang/String;
    //   108: aload_1
    //   109: ldc 146
    //   111: ldc 132
    //   113: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: ldc 132
    //   119: aload_3
    //   120: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +8 -> 131
    //   126: aload_0
    //   127: aload_3
    //   128: putfield 57	com/tencent/smtt/utils/n:g	Ljava/lang/String;
    //   131: aload_1
    //   132: ldc 148
    //   134: ldc 132
    //   136: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: ldc 132
    //   142: aload_3
    //   143: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +8 -> 154
    //   149: aload_0
    //   150: aload_3
    //   151: putfield 61	com/tencent/smtt/utils/n:h	Ljava/lang/String;
    //   154: aload_1
    //   155: ldc 150
    //   157: ldc 132
    //   159: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_3
    //   163: ldc 132
    //   165: aload_3
    //   166: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +8 -> 177
    //   172: aload_0
    //   173: aload_3
    //   174: putfield 65	com/tencent/smtt/utils/n:i	Ljava/lang/String;
    //   177: aload_1
    //   178: ldc 152
    //   180: ldc 132
    //   182: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: astore_3
    //   186: ldc 132
    //   188: aload_3
    //   189: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifne +8 -> 200
    //   195: aload_0
    //   196: aload_3
    //   197: putfield 69	com/tencent/smtt/utils/n:j	Ljava/lang/String;
    //   200: aload_1
    //   201: ldc 154
    //   203: ldc 132
    //   205: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_3
    //   209: ldc 132
    //   211: aload_3
    //   212: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +8 -> 223
    //   218: aload_0
    //   219: aload_3
    //   220: putfield 73	com/tencent/smtt/utils/n:k	Ljava/lang/String;
    //   223: aload_1
    //   224: ldc 156
    //   226: ldc 132
    //   228: invokevirtual 136	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: astore_1
    //   232: ldc 132
    //   234: aload_1
    //   235: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifne +8 -> 246
    //   241: aload_0
    //   242: aload_1
    //   243: putfield 49	com/tencent/smtt/utils/n:e	Ljava/lang/String;
    //   246: aload_2
    //   247: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   250: ldc 105
    //   252: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: goto -225 -> 30
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: ldc 105
    //   266: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: goto -239 -> 30
    //   272: astore_2
    //   273: new 161	java/io/StringWriter
    //   276: dup
    //   277: invokespecial 162	java/io/StringWriter:<init>	()V
    //   280: astore_3
    //   281: aload_2
    //   282: new 164	java/io/PrintWriter
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 167	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   290: invokevirtual 171	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   293: ldc 75
    //   295: new 173	java/lang/StringBuilder
    //   298: dup
    //   299: ldc 175
    //   301: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload_3
    //   305: invokevirtual 182	java/io/StringWriter:toString	()Ljava/lang/String;
    //   308: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: ifnull +42 -> 360
    //   321: aload_1
    //   322: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   325: ldc 105
    //   327: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: goto -300 -> 30
    //   333: astore_1
    //   334: ldc 105
    //   336: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: goto -309 -> 30
    //   342: astore_1
    //   343: aconst_null
    //   344: astore_2
    //   345: aload_2
    //   346: ifnull +7 -> 353
    //   349: aload_2
    //   350: invokevirtual 159	java/io/BufferedInputStream:close	()V
    //   353: ldc 105
    //   355: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: aload_1
    //   359: athrow
    //   360: ldc 105
    //   362: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: goto -335 -> 30
    //   368: astore_2
    //   369: goto -16 -> 353
    //   372: astore_1
    //   373: goto -28 -> 345
    //   376: astore_3
    //   377: aload_1
    //   378: astore_2
    //   379: aload_3
    //   380: astore_1
    //   381: goto -36 -> 345
    //   384: astore_3
    //   385: aload_2
    //   386: astore_1
    //   387: aload_3
    //   388: astore_2
    //   389: goto -116 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	n
    //   8	235	1	localObject1	Object
    //   258	4	1	localObject2	Object
    //   263	59	1	localIOException1	java.io.IOException
    //   333	1	1	localIOException2	java.io.IOException
    //   342	17	1	localObject3	Object
    //   372	6	1	localObject4	Object
    //   380	7	1	localObject5	Object
    //   13	234	2	localObject6	Object
    //   272	10	2	localThrowable1	Throwable
    //   344	6	2	localObject7	Object
    //   368	1	2	localIOException3	java.io.IOException
    //   378	11	2	localObject8	Object
    //   70	235	3	localObject9	Object
    //   376	4	3	localObject10	Object
    //   384	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	258	finally
    //   25	30	258	finally
    //   246	250	258	finally
    //   250	255	258	finally
    //   264	269	258	finally
    //   321	325	258	finally
    //   325	330	258	finally
    //   334	339	258	finally
    //   349	353	258	finally
    //   353	360	258	finally
    //   360	365	258	finally
    //   246	250	263	java/io/IOException
    //   9	14	272	java/lang/Throwable
    //   18	25	272	java/lang/Throwable
    //   33	49	272	java/lang/Throwable
    //   321	325	333	java/io/IOException
    //   9	14	342	finally
    //   18	25	342	finally
    //   33	49	342	finally
    //   349	353	368	java/io/IOException
    //   49	85	372	finally
    //   85	108	372	finally
    //   108	131	372	finally
    //   131	154	372	finally
    //   154	177	372	finally
    //   177	200	372	finally
    //   200	223	372	finally
    //   223	246	372	finally
    //   273	317	376	finally
    //   49	85	384	java/lang/Throwable
    //   85	108	384	java/lang/Throwable
    //   108	131	384	java/lang/Throwable
    //   131	154	384	java/lang/Throwable
    //   154	177	384	java/lang/Throwable
    //   177	200	384	java/lang/Throwable
    //   200	223	384	java/lang/Throwable
    //   223	246	384	java/lang/Throwable
  }
  
  private File h()
  {
    AppMethodBeat.i(53864);
    for (;;)
    {
      try
      {
        if (this.b == null)
        {
          this.b = new File(f.a(this.a, 5));
          if (this.b != null)
          {
            boolean bool = this.b.isDirectory();
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(53864);
            return null;
          }
        }
        File localFile = new File(this.b, "tbsnet.conf");
        if (!localFile.exists())
        {
          TbsLog.e("TbsCommonConfig", "Get file(" + localFile.getCanonicalPath() + ") failed!");
          AppMethodBeat.o(53864);
          return null;
        }
        localStringWriter = new StringWriter();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          TbsLog.w("TbsCommonConfig", "pathc:" + localFile.getCanonicalPath());
          AppMethodBeat.o(53864);
          return localFile;
        }
        catch (Throwable localThrowable2)
        {
          StringWriter localStringWriter;
          break label148;
        }
        localThrowable1 = localThrowable1;
        localFile = null;
      }
      label148:
      localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
      TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
    }
  }
  
  public String b()
  {
    AppMethodBeat.i(53865);
    TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.d);
    String str = this.d;
    AppMethodBeat.o(53865);
    return str;
  }
  
  public String c()
  {
    AppMethodBeat.i(53866);
    TbsLog.d("TbsCommonConfig", "getTbsDownloadStatPostUrl:" + this.g);
    String str = this.g;
    AppMethodBeat.o(53866);
    return str;
  }
  
  public String d()
  {
    AppMethodBeat.i(53867);
    TbsLog.d("TbsCommonConfig", "getTbsDownloaderPostUrl:" + this.h);
    String str = this.h;
    AppMethodBeat.o(53867);
    return str;
  }
  
  public String e()
  {
    AppMethodBeat.i(53868);
    TbsLog.d("TbsCommonConfig", "getTbsLogPostUrl:" + this.i);
    String str = this.i;
    AppMethodBeat.o(53868);
    return str;
  }
  
  public String f()
  {
    AppMethodBeat.i(53869);
    TbsLog.d("TbsCommonConfig", "getPvUploadPostUrl:" + this.e);
    String str = this.e;
    AppMethodBeat.o(53869);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */