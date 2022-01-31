package com.tencent.tinker.loader;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer
{
  public static boolean a(Collection<File> paramCollection, File paramFile, ResultCallback paramResultCallback)
  {
    return a(paramCollection, paramFile, false, null, paramResultCallback);
  }
  
  public static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, ResultCallback paramResultCallback)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, new Comparator() {});
    Collections.reverse(paramCollection);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!new OptimizeWorker((File)paramCollection.next(), paramFile, paramBoolean, paramString, paramResultCallback).cQK()) {
        return false;
      }
    }
    return true;
  }
  
  private static class OptimizeWorker
  {
    private static String wXc = null;
    private final boolean wWy;
    private final File wXd;
    private final File wXe;
    private final TinkerDexOptimizer.ResultCallback wXf;
    
    OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
    {
      this.wXd = paramFile1;
      this.wXe = paramFile2;
      this.wWy = paramBoolean;
      this.wXf = paramResultCallback;
      wXc = paramString;
    }
    
    /* Error */
    public final boolean cQK()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   4: invokestatic 47	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ae	(Ljava/io/File;)Z
      //   7: ifne +59 -> 66
      //   10: aload_0
      //   11: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   14: ifnull +52 -> 66
      //   17: aload_0
      //   18: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   21: aload_0
      //   22: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   25: new 41	java/io/IOException
      //   28: dup
      //   29: new 49	java/lang/StringBuilder
      //   32: dup
      //   33: ldc 51
      //   35: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   38: aload_0
      //   39: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   42: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   45: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: ldc 66
      //   50: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   56: invokespecial 70	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   59: invokeinterface 76 3 0
      //   64: iconst_0
      //   65: ireturn
      //   66: aload_0
      //   67: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   70: ifnull +16 -> 86
      //   73: aload_0
      //   74: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   77: aload_0
      //   78: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   81: invokeinterface 80 2 0
      //   86: aload_0
      //   87: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   90: aload_0
      //   91: getfield 29	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXe	Ljava/io/File;
      //   94: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
      //   97: astore 4
      //   99: aload_0
      //   100: getfield 31	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wWy	Z
      //   103: ifeq +472 -> 575
      //   106: aload_0
      //   107: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   110: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   113: astore 5
      //   115: new 56	java/io/File
      //   118: dup
      //   119: aload 4
      //   121: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
      //   124: astore_2
      //   125: aload_2
      //   126: invokevirtual 88	java/io/File:exists	()Z
      //   129: ifne +11 -> 140
      //   132: aload_2
      //   133: invokevirtual 92	java/io/File:getParentFile	()Ljava/io/File;
      //   136: invokevirtual 95	java/io/File:mkdirs	()Z
      //   139: pop
      //   140: new 56	java/io/File
      //   143: dup
      //   144: aload_2
      //   145: invokevirtual 92	java/io/File:getParentFile	()Ljava/io/File;
      //   148: ldc 97
      //   150: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   153: astore_3
      //   154: aconst_null
      //   155: astore_2
      //   156: aload_3
      //   157: invokestatic 106	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:ad	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
      //   160: astore_3
      //   161: aload_3
      //   162: astore_2
      //   163: new 108	java/util/ArrayList
      //   166: dup
      //   167: invokespecial 109	java/util/ArrayList:<init>	()V
      //   170: astore 6
      //   172: aload_3
      //   173: astore_2
      //   174: aload 6
      //   176: ldc 111
      //   178: invokeinterface 117 2 0
      //   183: pop
      //   184: aload_3
      //   185: astore_2
      //   186: getstatic 123	android/os/Build$VERSION:SDK_INT	I
      //   189: bipush 24
      //   191: if_icmplt +51 -> 242
      //   194: aload_3
      //   195: astore_2
      //   196: aload 6
      //   198: ldc 125
      //   200: invokeinterface 117 2 0
      //   205: pop
      //   206: aload_3
      //   207: astore_2
      //   208: aload 6
      //   210: ldc 127
      //   212: invokeinterface 117 2 0
      //   217: pop
      //   218: aload_3
      //   219: astore_2
      //   220: aload 6
      //   222: ldc 125
      //   224: invokeinterface 117 2 0
      //   229: pop
      //   230: aload_3
      //   231: astore_2
      //   232: aload 6
      //   234: ldc 129
      //   236: invokeinterface 117 2 0
      //   241: pop
      //   242: aload_3
      //   243: astore_2
      //   244: aload 6
      //   246: new 49	java/lang/StringBuilder
      //   249: dup
      //   250: ldc 131
      //   252: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   255: aload 5
      //   257: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   263: invokeinterface 117 2 0
      //   268: pop
      //   269: aload_3
      //   270: astore_2
      //   271: aload 6
      //   273: new 49	java/lang/StringBuilder
      //   276: dup
      //   277: ldc 133
      //   279: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   282: aload 4
      //   284: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   287: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   290: invokeinterface 117 2 0
      //   295: pop
      //   296: aload_3
      //   297: astore_2
      //   298: aload 6
      //   300: new 49	java/lang/StringBuilder
      //   303: dup
      //   304: ldc 135
      //   306: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   309: getstatic 20	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXc	Ljava/lang/String;
      //   312: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   318: invokeinterface 117 2 0
      //   323: pop
      //   324: aload_3
      //   325: astore_2
      //   326: getstatic 123	android/os/Build$VERSION:SDK_INT	I
      //   329: bipush 25
      //   331: if_icmple +193 -> 524
      //   334: aload_3
      //   335: astore_2
      //   336: aload 6
      //   338: ldc 137
      //   340: invokeinterface 117 2 0
      //   345: pop
      //   346: aload_3
      //   347: astore_2
      //   348: new 139	java/lang/ProcessBuilder
      //   351: dup
      //   352: aload 6
      //   354: invokespecial 142	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
      //   357: astore 5
      //   359: aload_3
      //   360: astore_2
      //   361: aload 5
      //   363: iconst_1
      //   364: invokevirtual 146	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
      //   367: pop
      //   368: aload_3
      //   369: astore_2
      //   370: aload 5
      //   372: invokevirtual 150	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
      //   375: astore 5
      //   377: aload_3
      //   378: astore_2
      //   379: aload 5
      //   381: invokevirtual 156	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   384: invokestatic 162	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:H	(Ljava/io/InputStream;)V
      //   387: aload_3
      //   388: astore_2
      //   389: aload 5
      //   391: invokevirtual 165	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   394: invokestatic 162	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:H	(Ljava/io/InputStream;)V
      //   397: aload_3
      //   398: astore_2
      //   399: aload 5
      //   401: invokevirtual 169	java/lang/Process:waitFor	()I
      //   404: istore_1
      //   405: iload_1
      //   406: ifeq +133 -> 539
      //   409: aload_3
      //   410: astore_2
      //   411: new 41	java/io/IOException
      //   414: dup
      //   415: new 49	java/lang/StringBuilder
      //   418: dup
      //   419: ldc 171
      //   421: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   424: iload_1
      //   425: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   428: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   431: invokespecial 70	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   434: athrow
      //   435: astore 4
      //   437: aload_3
      //   438: astore_2
      //   439: new 41	java/io/IOException
      //   442: dup
      //   443: new 49	java/lang/StringBuilder
      //   446: dup
      //   447: ldc 176
      //   449: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   452: aload 4
      //   454: invokevirtual 179	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   457: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   460: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   463: aload 4
      //   465: invokespecial 182	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   468: athrow
      //   469: astore_3
      //   470: aload_2
      //   471: ifnull +7 -> 478
      //   474: aload_2
      //   475: invokevirtual 185	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
      //   478: aload_3
      //   479: athrow
      //   480: astore_2
      //   481: new 49	java/lang/StringBuilder
      //   484: dup
      //   485: ldc 187
      //   487: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   490: aload_0
      //   491: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   494: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   497: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   500: pop
      //   501: aload_0
      //   502: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   505: ifnull +95 -> 600
      //   508: aload_0
      //   509: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   512: aload_0
      //   513: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   516: aload_2
      //   517: invokeinterface 76 3 0
      //   522: iconst_0
      //   523: ireturn
      //   524: aload_3
      //   525: astore_2
      //   526: aload 6
      //   528: ldc 189
      //   530: invokeinterface 117 2 0
      //   535: pop
      //   536: goto -190 -> 346
      //   539: aload_3
      //   540: invokevirtual 185	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
      //   543: aload_0
      //   544: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   547: ifnull +53 -> 600
      //   550: aload_0
      //   551: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXf	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   554: aload_0
      //   555: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   558: new 56	java/io/File
      //   561: dup
      //   562: aload 4
      //   564: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
      //   567: invokeinterface 193 3 0
      //   572: goto +28 -> 600
      //   575: aload_0
      //   576: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:wXd	Ljava/io/File;
      //   579: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   582: aload 4
      //   584: iconst_0
      //   585: invokestatic 199	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
      //   588: pop
      //   589: goto -46 -> 543
      //   592: astore_2
      //   593: goto -50 -> 543
      //   596: astore_2
      //   597: goto -119 -> 478
      //   600: iconst_1
      //   601: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	602	0	this	OptimizeWorker
      //   404	21	1	i	int
      //   124	351	2	localObject1	Object
      //   480	37	2	localThrowable	Throwable
      //   525	1	2	localObject2	Object
      //   592	1	2	localIOException1	java.io.IOException
      //   596	1	2	localIOException2	java.io.IOException
      //   153	285	3	localObject3	Object
      //   469	71	3	localObject4	Object
      //   97	186	4	str	String
      //   435	148	4	localInterruptedException	java.lang.InterruptedException
      //   113	287	5	localObject5	Object
      //   170	357	6	localArrayList	ArrayList
      // Exception table:
      //   from	to	target	type
      //   399	405	435	java/lang/InterruptedException
      //   411	435	435	java/lang/InterruptedException
      //   156	161	469	finally
      //   163	172	469	finally
      //   174	184	469	finally
      //   186	194	469	finally
      //   196	206	469	finally
      //   208	218	469	finally
      //   220	230	469	finally
      //   232	242	469	finally
      //   244	269	469	finally
      //   271	296	469	finally
      //   298	324	469	finally
      //   326	334	469	finally
      //   336	346	469	finally
      //   348	359	469	finally
      //   361	368	469	finally
      //   370	377	469	finally
      //   379	387	469	finally
      //   389	397	469	finally
      //   399	405	469	finally
      //   411	435	469	finally
      //   439	469	469	finally
      //   526	536	469	finally
      //   0	64	480	java/lang/Throwable
      //   66	86	480	java/lang/Throwable
      //   86	140	480	java/lang/Throwable
      //   140	154	480	java/lang/Throwable
      //   474	478	480	java/lang/Throwable
      //   478	480	480	java/lang/Throwable
      //   539	543	480	java/lang/Throwable
      //   543	572	480	java/lang/Throwable
      //   575	589	480	java/lang/Throwable
      //   539	543	592	java/io/IOException
      //   474	478	596	java/io/IOException
    }
  }
  
  public static abstract interface ResultCallback
  {
    public abstract void X(File paramFile);
    
    public abstract void b(File paramFile, Throwable paramThrowable);
    
    public abstract void i(File paramFile1, File paramFile2);
  }
  
  private static class StreamConsumer
  {
    static final Executor wXg = ;
    
    static void H(InputStream paramInputStream)
    {
      wXg.execute(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:wXh	Ljava/io/InputStream;
          //   4: ifnonnull +4 -> 8
          //   7: return
          //   8: sipush 256
          //   11: newarray byte
          //   13: astore_2
          //   14: aload_0
          //   15: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:wXh	Ljava/io/InputStream;
          //   18: aload_2
          //   19: invokevirtual 34	java/io/InputStream:read	([B)I
          //   22: istore_1
          //   23: iload_1
          //   24: ifgt -10 -> 14
          //   27: aload_0
          //   28: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:wXh	Ljava/io/InputStream;
          //   31: invokevirtual 37	java/io/InputStream:close	()V
          //   34: return
          //   35: astore_2
          //   36: return
          //   37: astore_2
          //   38: aload_0
          //   39: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:wXh	Ljava/io/InputStream;
          //   42: invokevirtual 37	java/io/InputStream:close	()V
          //   45: return
          //   46: astore_2
          //   47: return
          //   48: astore_2
          //   49: aload_0
          //   50: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:wXh	Ljava/io/InputStream;
          //   53: invokevirtual 37	java/io/InputStream:close	()V
          //   56: aload_2
          //   57: athrow
          //   58: astore_3
          //   59: goto -3 -> 56
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	62	0	this	1
          //   22	2	1	i	int
          //   13	6	2	arrayOfByte	byte[]
          //   35	1	2	localException1	java.lang.Exception
          //   37	1	2	localIOException	java.io.IOException
          //   46	1	2	localException2	java.lang.Exception
          //   48	9	2	localObject	Object
          //   58	1	3	localException3	java.lang.Exception
          // Exception table:
          //   from	to	target	type
          //   27	34	35	java/lang/Exception
          //   14	23	37	java/io/IOException
          //   38	45	46	java/lang/Exception
          //   14	23	48	finally
          //   49	56	58	java/lang/Exception
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer
 * JD-Core Version:    0.7.0.1
 */