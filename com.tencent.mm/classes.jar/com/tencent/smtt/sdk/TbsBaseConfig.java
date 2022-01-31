package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig
{
  public static final String TAG = "TbsBaseConfig";
  Map<String, String> a;
  private Context b;
  
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
  
  public void clear()
  {
    this.a.clear();
    commit();
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
  
  public abstract String getConfigFileName();
  
  public void init(Context paramContext)
  {
    this.a = new HashMap();
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    refreshSyncMap(paramContext);
  }
  
  /* Error */
  public void refreshSyncMap(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 70	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   8: aload_0
    //   9: invokevirtual 79	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   12: invokestatic 81	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 45	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   27: invokeinterface 49 1 0
    //   32: new 83	java/io/BufferedInputStream
    //   35: dup
    //   36: new 85	java/io/FileInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_1
    //   48: new 93	java/util/Properties
    //   51: dup
    //   52: invokespecial 94	java/util/Properties:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_1
    //   58: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   61: aload_2
    //   62: invokevirtual 101	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   65: invokeinterface 107 1 0
    //   70: astore_3
    //   71: aload_3
    //   72: invokeinterface 112 1 0
    //   77: ifeq +51 -> 128
    //   80: aload_3
    //   81: invokeinterface 116 1 0
    //   86: checkcast 118	java/lang/String
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 45	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   95: aload 4
    //   97: aload_2
    //   98: aload 4
    //   100: invokevirtual 122	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokeinterface 126 3 0
    //   108: pop
    //   109: goto -38 -> 71
    //   112: astore_2
    //   113: aload_1
    //   114: ifnull -94 -> 20
    //   117: aload_1
    //   118: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   121: goto -101 -> 20
    //   124: astore_1
    //   125: goto -105 -> 20
    //   128: aload_1
    //   129: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   132: goto -112 -> 20
    //   135: astore_1
    //   136: goto -116 -> 20
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: goto -8 -> 150
    //   161: astore_2
    //   162: aload_1
    //   163: astore_3
    //   164: aload_2
    //   165: astore_1
    //   166: aload_3
    //   167: astore_2
    //   168: goto -26 -> 142
    //   171: astore_1
    //   172: aload_2
    //   173: astore_1
    //   174: goto -61 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	TbsBaseConfig
    //   0	177	1	paramContext	Context
    //   3	95	2	localProperties	java.util.Properties
    //   112	1	2	localThrowable	java.lang.Throwable
    //   141	6	2	localObject1	Object
    //   157	1	2	localException	java.lang.Exception
    //   161	4	2	localObject2	Object
    //   167	6	2	localObject3	Object
    //   70	97	3	localObject4	Object
    //   89	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   48	71	112	java/lang/Throwable
    //   71	109	112	java/lang/Throwable
    //   117	121	124	java/lang/Exception
    //   128	132	135	java/lang/Exception
    //   4	16	139	finally
    //   23	48	139	finally
    //   117	121	152	finally
    //   128	132	152	finally
    //   146	150	152	finally
    //   150	152	152	finally
    //   146	150	157	java/lang/Exception
    //   48	71	161	finally
    //   71	109	161	finally
    //   4	16	171	java/lang/Throwable
    //   23	48	171	java/lang/Throwable
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: ldc 131
    //   6: invokestatic 137	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 70	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   13: aload_0
    //   14: invokevirtual 79	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   17: invokestatic 81	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 83	java/io/BufferedInputStream
    //   31: dup
    //   32: new 85	java/io/FileInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_2
    //   44: new 93	java/util/Properties
    //   47: dup
    //   48: invokespecial 94	java/util/Properties:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: aload_2
    //   54: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   57: aload_3
    //   58: invokevirtual 138	java/util/Properties:clear	()V
    //   61: aload_0
    //   62: getfield 45	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   65: invokeinterface 141 1 0
    //   70: invokeinterface 107 1 0
    //   75: astore 4
    //   77: aload 4
    //   79: invokeinterface 112 1 0
    //   84: ifeq +101 -> 185
    //   87: aload 4
    //   89: invokeinterface 116 1 0
    //   94: checkcast 118	java/lang/String
    //   97: astore 5
    //   99: aload_0
    //   100: getfield 45	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   103: aload 5
    //   105: invokeinterface 145 2 0
    //   110: astore 6
    //   112: aload_3
    //   113: aload 5
    //   115: aload 6
    //   117: invokestatic 149	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   120: invokevirtual 153	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   123: pop
    //   124: ldc 8
    //   126: new 155	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 157
    //   132: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload 5
    //   137: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 166
    //   142: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 6
    //   147: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 137	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -79 -> 77
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   170: aload_1
    //   171: ifnull -146 -> 25
    //   174: aload_1
    //   175: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   178: goto -153 -> 25
    //   181: astore_1
    //   182: goto -157 -> 25
    //   185: aload_0
    //   186: getfield 45	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   189: invokeinterface 49 1 0
    //   194: new 174	java/io/BufferedOutputStream
    //   197: dup
    //   198: new 177	java/io/FileOutputStream
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   206: invokespecial 181	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   209: astore_1
    //   210: aload_3
    //   211: aload_1
    //   212: aconst_null
    //   213: invokevirtual 185	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   216: aload_2
    //   217: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   220: aload_1
    //   221: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   224: goto -199 -> 25
    //   227: astore_1
    //   228: goto -203 -> 25
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_3
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_1
    //   258: athrow
    //   259: astore_2
    //   260: goto -40 -> 220
    //   263: astore_2
    //   264: goto -94 -> 170
    //   267: astore_3
    //   268: goto -24 -> 244
    //   271: astore_2
    //   272: goto -20 -> 252
    //   275: astore_1
    //   276: aconst_null
    //   277: astore 4
    //   279: aload_2
    //   280: astore_3
    //   281: aload 4
    //   283: astore_2
    //   284: goto -48 -> 236
    //   287: astore 4
    //   289: aload_1
    //   290: astore 5
    //   292: aload_2
    //   293: astore_3
    //   294: aload 4
    //   296: astore_1
    //   297: aload 5
    //   299: astore_2
    //   300: goto -64 -> 236
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_1
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -146 -> 162
    //   311: astore_3
    //   312: goto -150 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	TbsBaseConfig
    //   20	17	1	localFile	File
    //   159	1	1	localThrowable1	java.lang.Throwable
    //   161	14	1	localObject1	Object
    //   181	22	1	localException1	java.lang.Exception
    //   209	12	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   227	1	1	localException2	java.lang.Exception
    //   231	22	1	localObject2	Object
    //   254	4	1	localObject3	Object
    //   275	15	1	localObject4	Object
    //   296	1	1	localObject5	Object
    //   303	1	1	localThrowable2	java.lang.Throwable
    //   305	1	1	localObject6	Object
    //   43	206	2	localBufferedInputStream	java.io.BufferedInputStream
    //   259	1	2	localException3	java.lang.Exception
    //   263	1	2	localException4	java.lang.Exception
    //   271	9	2	localException5	java.lang.Exception
    //   283	25	2	localObject7	Object
    //   51	190	3	localProperties	java.util.Properties
    //   267	1	3	localException6	java.lang.Exception
    //   280	14	3	localObject8	Object
    //   311	1	3	localThrowable3	java.lang.Throwable
    //   75	207	4	localIterator	java.util.Iterator
    //   287	8	4	localObject9	Object
    //   97	201	5	localObject10	Object
    //   110	36	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   44	77	159	java/lang/Throwable
    //   77	156	159	java/lang/Throwable
    //   185	210	159	java/lang/Throwable
    //   174	178	181	java/lang/Exception
    //   220	224	227	java/lang/Exception
    //   9	21	231	finally
    //   28	44	231	finally
    //   2	9	254	finally
    //   166	170	254	finally
    //   174	178	254	finally
    //   216	220	254	finally
    //   220	224	254	finally
    //   240	244	254	finally
    //   248	252	254	finally
    //   252	254	254	finally
    //   216	220	259	java/lang/Exception
    //   166	170	263	java/lang/Exception
    //   240	244	267	java/lang/Exception
    //   248	252	271	java/lang/Exception
    //   44	77	275	finally
    //   77	156	275	finally
    //   185	210	275	finally
    //   210	216	287	finally
    //   9	21	303	java/lang/Throwable
    //   28	44	303	java/lang/Throwable
    //   210	216	311	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */