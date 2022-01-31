package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class s
{
  private static s c = null;
  private Context a = null;
  private File b = null;
  private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "http://wup.imtt.qq.com:8080";
  private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String j = "http://mqqad.html5.qq.com/adjs";
  private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  
  @TargetApi(11)
  private s(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    g();
  }
  
  public static s a()
  {
    try
    {
      s locals = c;
      return locals;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static s a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new s(paramContext);
      }
      paramContext = c;
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
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 97	com/tencent/smtt/utils/s:h	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +25 -> 35
    //   13: ldc 69
    //   15: ldc 99
    //   17: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 103	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 104	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new 106	java/io/BufferedInputStream
    //   38: dup
    //   39: new 108	java/io/FileInputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: new 116	java/util/Properties
    //   54: dup
    //   55: invokespecial 117	java/util/Properties:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual 120	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_1
    //   65: ldc 122
    //   67: ldc 124
    //   69: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: ldc 124
    //   75: aload_3
    //   76: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +8 -> 87
    //   82: aload_0
    //   83: aload_3
    //   84: putfield 39	com/tencent/smtt/utils/s:d	Ljava/lang/String;
    //   87: aload_1
    //   88: ldc 136
    //   90: ldc 124
    //   92: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_3
    //   96: ldc 124
    //   98: aload_3
    //   99: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +8 -> 110
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 47	com/tencent/smtt/utils/s:f	Ljava/lang/String;
    //   110: aload_1
    //   111: ldc 138
    //   113: ldc 124
    //   115: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: ldc 124
    //   121: aload_3
    //   122: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +8 -> 133
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 51	com/tencent/smtt/utils/s:g	Ljava/lang/String;
    //   133: aload_1
    //   134: ldc 140
    //   136: ldc 124
    //   138: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_3
    //   142: ldc 124
    //   144: aload_3
    //   145: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifne +8 -> 156
    //   151: aload_0
    //   152: aload_3
    //   153: putfield 55	com/tencent/smtt/utils/s:h	Ljava/lang/String;
    //   156: aload_1
    //   157: ldc 142
    //   159: ldc 124
    //   161: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_3
    //   165: ldc 124
    //   167: aload_3
    //   168: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +8 -> 179
    //   174: aload_0
    //   175: aload_3
    //   176: putfield 59	com/tencent/smtt/utils/s:i	Ljava/lang/String;
    //   179: aload_1
    //   180: ldc 144
    //   182: ldc 124
    //   184: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore_3
    //   188: ldc 124
    //   190: aload_3
    //   191: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +8 -> 202
    //   197: aload_0
    //   198: aload_3
    //   199: putfield 63	com/tencent/smtt/utils/s:j	Ljava/lang/String;
    //   202: aload_1
    //   203: ldc 146
    //   205: ldc 124
    //   207: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore_3
    //   211: ldc 124
    //   213: aload_3
    //   214: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifne +8 -> 225
    //   220: aload_0
    //   221: aload_3
    //   222: putfield 67	com/tencent/smtt/utils/s:k	Ljava/lang/String;
    //   225: aload_1
    //   226: ldc 148
    //   228: ldc 124
    //   230: invokevirtual 128	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_1
    //   234: ldc 124
    //   236: aload_1
    //   237: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifne +8 -> 248
    //   243: aload_0
    //   244: aload_1
    //   245: putfield 43	com/tencent/smtt/utils/s:e	Ljava/lang/String;
    //   248: aload_2
    //   249: ifnull -217 -> 32
    //   252: aload_2
    //   253: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   256: goto -224 -> 32
    //   259: astore_1
    //   260: goto -228 -> 32
    //   263: astore_2
    //   264: new 153	java/io/StringWriter
    //   267: dup
    //   268: invokespecial 154	java/io/StringWriter:<init>	()V
    //   271: astore_3
    //   272: aload_2
    //   273: new 156	java/io/PrintWriter
    //   276: dup
    //   277: aload_3
    //   278: invokespecial 159	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   281: invokevirtual 163	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   284: ldc 69
    //   286: new 165	java/lang/StringBuilder
    //   289: dup
    //   290: ldc 167
    //   292: invokespecial 170	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: aload_3
    //   296: invokevirtual 174	java/io/StringWriter:toString	()Ljava/lang/String;
    //   299: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_1
    //   309: ifnull -277 -> 32
    //   312: aload_1
    //   313: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   316: goto -284 -> 32
    //   319: astore_1
    //   320: aload_0
    //   321: monitorexit
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 151	java/io/BufferedInputStream:close	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_2
    //   338: goto -3 -> 335
    //   341: astore_1
    //   342: goto -15 -> 327
    //   345: astore_3
    //   346: aload_1
    //   347: astore_2
    //   348: aload_3
    //   349: astore_1
    //   350: goto -23 -> 327
    //   353: astore_3
    //   354: aload_2
    //   355: astore_1
    //   356: aload_3
    //   357: astore_2
    //   358: goto -94 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	s
    //   3	242	1	localObject1	Object
    //   259	54	1	localIOException1	java.io.IOException
    //   319	4	1	localObject2	Object
    //   324	12	1	localObject3	Object
    //   341	6	1	localObject4	Object
    //   349	7	1	localObject5	Object
    //   8	245	2	localObject6	Object
    //   263	10	2	localThrowable1	Throwable
    //   326	6	2	localObject7	Object
    //   337	1	2	localIOException2	java.io.IOException
    //   347	11	2	localObject8	Object
    //   72	224	3	localObject9	Object
    //   345	4	3	localObject10	Object
    //   353	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	259	java/io/IOException
    //   252	256	259	java/io/IOException
    //   312	316	259	java/io/IOException
    //   4	9	263	java/lang/Throwable
    //   13	20	263	java/lang/Throwable
    //   35	51	263	java/lang/Throwable
    //   24	32	319	finally
    //   252	256	319	finally
    //   312	316	319	finally
    //   331	335	319	finally
    //   335	337	319	finally
    //   4	9	324	finally
    //   13	20	324	finally
    //   35	51	324	finally
    //   331	335	337	java/io/IOException
    //   51	87	341	finally
    //   87	110	341	finally
    //   110	133	341	finally
    //   133	156	341	finally
    //   156	179	341	finally
    //   179	202	341	finally
    //   202	225	341	finally
    //   225	248	341	finally
    //   264	308	345	finally
    //   51	87	353	java/lang/Throwable
    //   87	110	353	java/lang/Throwable
    //   110	133	353	java/lang/Throwable
    //   133	156	353	java/lang/Throwable
    //   156	179	353	java/lang/Throwable
    //   179	202	353	java/lang/Throwable
    //   202	225	353	java/lang/Throwable
    //   225	248	353	java/lang/Throwable
  }
  
  private File h()
  {
    try
    {
      if (this.b == null)
      {
        this.b = new File(j.a(this.a, 5));
        if ((this.b == null) || (!this.b.isDirectory())) {
          break label177;
        }
      }
      localFile = new File(this.b, "tbsnet.conf");
      if (!localFile.exists())
      {
        TbsLog.e("TbsCommonConfig", "Get file(" + localFile.getCanonicalPath() + ") failed!");
        return null;
      }
      try
      {
        TbsLog.w("TbsCommonConfig", "pathc:" + localFile.getCanonicalPath());
        return localFile;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        StringWriter localStringWriter;
        File localFile = null;
      }
    }
    localStringWriter = new StringWriter();
    localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
    return localFile;
    label177:
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.s
 * JD-Core Version:    0.7.0.1
 */