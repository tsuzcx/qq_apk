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
  
  @TargetApi(11)
  private n(Context paramContext)
  {
    AppMethodBeat.i(53862);
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
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 100
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: invokespecial 103	com/tencent/smtt/utils/n:i	()Ljava/io/File;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +18 -> 33
    //   18: ldc 70
    //   20: ldc 105
    //   22: invokestatic 107	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc 100
    //   27: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new 109	java/io/BufferedInputStream
    //   36: dup
    //   37: new 111	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: new 119	java/util/Properties
    //   52: dup
    //   53: invokespecial 120	java/util/Properties:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 123	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_1
    //   63: ldc 125
    //   65: ldc 127
    //   67: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: ldc 127
    //   73: aload_3
    //   74: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +8 -> 85
    //   80: aload_0
    //   81: aload_3
    //   82: putfield 44	com/tencent/smtt/utils/n:d	Ljava/lang/String;
    //   85: aload_1
    //   86: ldc 139
    //   88: ldc 127
    //   90: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: ldc 127
    //   96: aload_3
    //   97: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +8 -> 108
    //   103: aload_0
    //   104: aload_3
    //   105: putfield 52	com/tencent/smtt/utils/n:f	Ljava/lang/String;
    //   108: aload_1
    //   109: ldc 141
    //   111: ldc 127
    //   113: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: ldc 127
    //   119: aload_3
    //   120: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +8 -> 131
    //   126: aload_0
    //   127: aload_3
    //   128: putfield 56	com/tencent/smtt/utils/n:g	Ljava/lang/String;
    //   131: aload_1
    //   132: ldc 143
    //   134: ldc 127
    //   136: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: ldc 127
    //   142: aload_3
    //   143: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +8 -> 154
    //   149: aload_0
    //   150: aload_3
    //   151: putfield 60	com/tencent/smtt/utils/n:h	Ljava/lang/String;
    //   154: aload_1
    //   155: ldc 145
    //   157: ldc 127
    //   159: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_3
    //   163: ldc 127
    //   165: aload_3
    //   166: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +8 -> 177
    //   172: aload_0
    //   173: aload_3
    //   174: putfield 64	com/tencent/smtt/utils/n:i	Ljava/lang/String;
    //   177: aload_1
    //   178: ldc 147
    //   180: ldc 127
    //   182: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: astore_3
    //   186: ldc 127
    //   188: aload_3
    //   189: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifne +8 -> 200
    //   195: aload_0
    //   196: aload_3
    //   197: putfield 68	com/tencent/smtt/utils/n:j	Ljava/lang/String;
    //   200: aload_1
    //   201: ldc 149
    //   203: ldc 127
    //   205: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_1
    //   209: ldc 127
    //   211: aload_1
    //   212: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +8 -> 223
    //   218: aload_0
    //   219: aload_1
    //   220: putfield 48	com/tencent/smtt/utils/n:e	Ljava/lang/String;
    //   223: aload_2
    //   224: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   227: ldc 100
    //   229: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: goto -202 -> 30
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: ldc 100
    //   243: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: goto -216 -> 30
    //   249: astore_2
    //   250: new 154	java/io/StringWriter
    //   253: dup
    //   254: invokespecial 155	java/io/StringWriter:<init>	()V
    //   257: astore_3
    //   258: aload_2
    //   259: new 157	java/io/PrintWriter
    //   262: dup
    //   263: aload_3
    //   264: invokespecial 160	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   267: invokevirtual 164	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   270: ldc 70
    //   272: new 166	java/lang/StringBuilder
    //   275: dup
    //   276: ldc 168
    //   278: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_3
    //   282: invokevirtual 175	java/io/StringWriter:toString	()Ljava/lang/String;
    //   285: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 107	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_1
    //   295: ifnull +42 -> 337
    //   298: aload_1
    //   299: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   302: ldc 100
    //   304: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: goto -277 -> 30
    //   310: astore_1
    //   311: ldc 100
    //   313: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: goto -286 -> 30
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_2
    //   323: ifnull +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 152	java/io/BufferedInputStream:close	()V
    //   330: ldc 100
    //   332: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload_1
    //   336: athrow
    //   337: ldc 100
    //   339: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: goto -312 -> 30
    //   345: astore_2
    //   346: goto -16 -> 330
    //   349: astore_1
    //   350: goto -28 -> 322
    //   353: astore_3
    //   354: aload_1
    //   355: astore_2
    //   356: aload_3
    //   357: astore_1
    //   358: goto -36 -> 322
    //   361: astore_3
    //   362: aload_2
    //   363: astore_1
    //   364: aload_3
    //   365: astore_2
    //   366: goto -116 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	n
    //   8	212	1	localObject1	Object
    //   235	4	1	localObject2	Object
    //   240	59	1	localIOException1	java.io.IOException
    //   310	1	1	localIOException2	java.io.IOException
    //   319	17	1	localObject3	Object
    //   349	6	1	localObject4	Object
    //   357	7	1	localObject5	Object
    //   13	211	2	localObject6	Object
    //   249	10	2	localThrowable1	Throwable
    //   321	6	2	localObject7	Object
    //   345	1	2	localIOException3	java.io.IOException
    //   355	11	2	localObject8	Object
    //   70	212	3	localObject9	Object
    //   353	4	3	localObject10	Object
    //   361	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	235	finally
    //   25	30	235	finally
    //   223	227	235	finally
    //   227	232	235	finally
    //   241	246	235	finally
    //   298	302	235	finally
    //   302	307	235	finally
    //   311	316	235	finally
    //   326	330	235	finally
    //   330	337	235	finally
    //   337	342	235	finally
    //   223	227	240	java/io/IOException
    //   9	14	249	java/lang/Throwable
    //   18	25	249	java/lang/Throwable
    //   33	49	249	java/lang/Throwable
    //   298	302	310	java/io/IOException
    //   9	14	319	finally
    //   18	25	319	finally
    //   33	49	319	finally
    //   326	330	345	java/io/IOException
    //   49	85	349	finally
    //   85	108	349	finally
    //   108	131	349	finally
    //   131	154	349	finally
    //   154	177	349	finally
    //   177	200	349	finally
    //   200	223	349	finally
    //   250	294	353	finally
    //   49	85	361	java/lang/Throwable
    //   85	108	361	java/lang/Throwable
    //   108	131	361	java/lang/Throwable
    //   131	154	361	java/lang/Throwable
    //   154	177	361	java/lang/Throwable
    //   177	200	361	java/lang/Throwable
    //   200	223	361	java/lang/Throwable
  }
  
  private File i()
  {
    AppMethodBeat.i(188554);
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
            AppMethodBeat.o(188554);
            return null;
          }
        }
        File localFile = new File(this.b, "tbsnet.conf");
        if (!localFile.exists())
        {
          TbsLog.e("TbsCommonConfig", "Get file(" + localFile.getCanonicalPath() + ") failed!");
          AppMethodBeat.o(188554);
          return null;
        }
        localStringWriter = new StringWriter();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          TbsLog.w("TbsCommonConfig", "pathc:" + localFile.getCanonicalPath());
          AppMethodBeat.o(188554);
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
    TbsLog.d("TbsCommonConfig", "getTbsDownloadStatPostUrl:" + this.f);
    String str = this.f;
    AppMethodBeat.o(53866);
    return str;
  }
  
  public String d()
  {
    AppMethodBeat.i(53867);
    TbsLog.d("TbsCommonConfig", "getTbsDownloaderPostUrl:" + this.g);
    String str = this.g;
    AppMethodBeat.o(53867);
    return str;
  }
  
  public String e()
  {
    AppMethodBeat.i(53868);
    TbsLog.d("TbsCommonConfig", "getTbsLogPostUrl:" + this.h);
    String str = this.h;
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
  
  public String g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */