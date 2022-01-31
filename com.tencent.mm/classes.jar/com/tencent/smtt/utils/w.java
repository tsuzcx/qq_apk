package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class w
{
  private static w e = null;
  public boolean a;
  private Context b;
  private File c;
  private boolean d;
  private File f;
  
  private w(Context paramContext)
  {
    AppMethodBeat.i(65309);
    this.b = null;
    this.c = null;
    this.a = false;
    this.d = false;
    this.f = null;
    this.b = paramContext.getApplicationContext();
    b();
    AppMethodBeat.o(65309);
  }
  
  public static w a()
  {
    try
    {
      w localw = e;
      return localw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static w a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(65308);
      if (e == null) {
        e = new w(paramContext);
      }
      paramContext = e;
      AppMethodBeat.o(65308);
      return paramContext;
    }
    finally {}
  }
  
  private File d()
  {
    AppMethodBeat.i(65311);
    try
    {
      if (this.c == null)
      {
        this.c = new File(this.b.getDir("tbs", 0), "core_private");
        if (this.c != null)
        {
          boolean bool = this.c.isDirectory();
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(65311);
          return null;
        }
      }
      File localFile2 = new File(this.c, "debug.conf");
      localFile1 = localFile2;
      if (!localFile2.exists())
      {
        localFile2.createNewFile();
        localFile1 = localFile2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        File localFile1;
        Object localObject = null;
      }
    }
    AppMethodBeat.o(65311);
    return localFile1;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(65312);
    this.d = paramBoolean;
    c();
    AppMethodBeat.o(65312);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 92
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: getfield 40	com/tencent/smtt/utils/w:f	Ljava/io/File;
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: aload_0
    //   18: invokespecial 94	com/tencent/smtt/utils/w:d	()Ljava/io/File;
    //   21: putfield 40	com/tencent/smtt/utils/w:f	Ljava/io/File;
    //   24: aload_0
    //   25: getfield 40	com/tencent/smtt/utils/w:f	Ljava/io/File;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +11 -> 41
    //   33: ldc 92
    //   35: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new 96	java/io/BufferedInputStream
    //   44: dup
    //   45: new 98	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: getfield 40	com/tencent/smtt/utils/w:f	Ljava/io/File;
    //   53: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 104	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_1
    //   60: new 106	java/util/Properties
    //   63: dup
    //   64: invokespecial 107	java/util/Properties:<init>	()V
    //   67: astore_2
    //   68: aload_2
    //   69: aload_1
    //   70: invokevirtual 110	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_2
    //   74: ldc 112
    //   76: ldc 114
    //   78: invokevirtual 118	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_2
    //   82: ldc 114
    //   84: aload_2
    //   85: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +11 -> 99
    //   91: aload_0
    //   92: aload_2
    //   93: invokestatic 130	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   96: putfield 36	com/tencent/smtt/utils/w:a	Z
    //   99: aload_1
    //   100: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   103: ldc 92
    //   105: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: goto -70 -> 38
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: ldc 92
    //   119: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: goto -84 -> 38
    //   125: astore_1
    //   126: aload_2
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   136: ldc 92
    //   138: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: goto -103 -> 38
    //   144: astore_1
    //   145: ldc 92
    //   147: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -112 -> 38
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   164: ldc 92
    //   166: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: athrow
    //   171: astore_2
    //   172: goto -8 -> 164
    //   175: astore_2
    //   176: aload_1
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: aload_3
    //   181: astore_2
    //   182: goto -26 -> 156
    //   185: astore_2
    //   186: goto -58 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	w
    //   28	72	1	localObject1	Object
    //   111	4	1	localObject2	Object
    //   116	1	1	localException1	java.lang.Exception
    //   125	1	1	localThrowable1	Throwable
    //   127	6	1	localObject3	Object
    //   144	1	1	localException2	java.lang.Exception
    //   153	24	1	localObject4	Object
    //   179	1	1	localObject5	Object
    //   8	153	2	localObject6	Object
    //   171	1	2	localException3	java.lang.Exception
    //   175	4	2	localObject7	Object
    //   181	1	2	localObject8	Object
    //   185	1	2	localThrowable2	Throwable
    //   177	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	111	finally
    //   33	38	111	finally
    //   99	103	111	finally
    //   103	108	111	finally
    //   117	122	111	finally
    //   132	136	111	finally
    //   136	141	111	finally
    //   145	150	111	finally
    //   160	164	111	finally
    //   164	171	111	finally
    //   99	103	116	java/lang/Exception
    //   9	24	125	java/lang/Throwable
    //   24	29	125	java/lang/Throwable
    //   41	60	125	java/lang/Throwable
    //   132	136	144	java/lang/Exception
    //   9	24	153	finally
    //   24	29	153	finally
    //   41	60	153	finally
    //   160	164	171	java/lang/Exception
    //   60	99	175	finally
    //   60	99	185	java/lang/Throwable
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/utils/w:d	()Ljava/io/File;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +26 -> 37
    //   14: new 136	java/lang/NullPointerException
    //   17: dup
    //   18: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   21: athrow
    //   22: new 136	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: astore_1
    //   31: ldc 134
    //   33: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: new 96	java/io/BufferedInputStream
    //   40: dup
    //   41: new 98	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 104	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: new 106	java/util/Properties
    //   56: dup
    //   57: invokespecial 107	java/util/Properties:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: aload_2
    //   63: invokevirtual 110	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   66: aload_3
    //   67: ldc 112
    //   69: aload_0
    //   70: getfield 36	com/tencent/smtt/utils/w:a	Z
    //   73: invokestatic 141	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   76: invokevirtual 145	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_3
    //   81: ldc 147
    //   83: aload_0
    //   84: getfield 38	com/tencent/smtt/utils/w:d	Z
    //   87: invokestatic 141	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   90: invokevirtual 145	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   93: pop
    //   94: new 149	java/io/BufferedOutputStream
    //   97: dup
    //   98: new 151	java/io/FileOutputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 152	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 155	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   109: astore_1
    //   110: aload_3
    //   111: aload_1
    //   112: aconst_null
    //   113: invokevirtual 159	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   120: aload_1
    //   121: invokevirtual 160	java/io/BufferedOutputStream:close	()V
    //   124: ldc 134
    //   126: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore_1
    //   131: ldc 134
    //   133: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   146: aload_1
    //   147: invokevirtual 160	java/io/BufferedOutputStream:close	()V
    //   150: ldc 134
    //   152: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: astore_1
    //   157: ldc 134
    //   159: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   172: aload_2
    //   173: invokevirtual 160	java/io/BufferedOutputStream:close	()V
    //   176: ldc 134
    //   178: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: goto -162 -> 22
    //   187: astore_2
    //   188: goto -68 -> 120
    //   191: astore_2
    //   192: goto -46 -> 146
    //   195: astore_3
    //   196: goto -24 -> 172
    //   199: astore_2
    //   200: goto -24 -> 176
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: astore_3
    //   209: aload 4
    //   211: astore_2
    //   212: goto -44 -> 168
    //   215: astore 5
    //   217: aload_1
    //   218: astore 4
    //   220: aload_2
    //   221: astore_3
    //   222: aload 5
    //   224: astore_1
    //   225: aload 4
    //   227: astore_2
    //   228: goto -60 -> 168
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -92 -> 142
    //   237: astore_3
    //   238: goto -96 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	w
    //   9	2	1	localFile	File
    //   30	73	1	localException1	java.lang.Exception
    //   109	12	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   130	1	1	localException2	java.lang.Exception
    //   137	1	1	localThrowable1	Throwable
    //   139	8	1	localObject1	Object
    //   156	1	1	localException3	java.lang.Exception
    //   163	19	1	localObject2	Object
    //   183	1	1	localException4	java.lang.Exception
    //   203	15	1	localObject3	Object
    //   224	1	1	localObject4	Object
    //   231	1	1	localThrowable2	Throwable
    //   233	1	1	localObject5	Object
    //   52	121	2	localBufferedInputStream	java.io.BufferedInputStream
    //   187	1	2	localException5	java.lang.Exception
    //   191	1	2	localException6	java.lang.Exception
    //   199	9	2	localException7	java.lang.Exception
    //   211	17	2	localObject6	Object
    //   60	109	3	localProperties	java.util.Properties
    //   195	1	3	localException8	java.lang.Exception
    //   208	14	3	localObject7	Object
    //   237	1	3	localThrowable3	Throwable
    //   205	21	4	localObject8	Object
    //   215	8	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   22	30	30	java/lang/Exception
    //   120	124	130	java/lang/Exception
    //   5	10	137	java/lang/Throwable
    //   37	53	137	java/lang/Throwable
    //   146	150	156	java/lang/Exception
    //   5	10	163	finally
    //   37	53	163	finally
    //   14	22	183	java/lang/Exception
    //   116	120	187	java/lang/Exception
    //   142	146	191	java/lang/Exception
    //   168	172	195	java/lang/Exception
    //   172	176	199	java/lang/Exception
    //   53	110	203	finally
    //   110	116	215	finally
    //   53	110	231	java/lang/Throwable
    //   110	116	237	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.utils.w
 * JD-Core Version:    0.7.0.1
 */