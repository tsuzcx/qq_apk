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
      if (!new OptimizeWorker((File)paramCollection.next(), paramFile, paramBoolean, paramString, paramResultCallback).dWz()) {
        return false;
      }
    }
    return true;
  }
  
  static class OptimizeWorker
  {
    private static String BtG = null;
    private final File BtH;
    private final File BtI;
    private final TinkerDexOptimizer.ResultCallback BtJ;
    private final boolean Btb;
    
    OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
    {
      this.BtH = paramFile1;
      this.BtI = paramFile2;
      this.Btb = paramBoolean;
      this.BtJ = paramResultCallback;
      BtG = paramString;
    }
    
    /* Error */
    public final boolean dWz()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   4: invokestatic 47	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:an	(Ljava/io/File;)Z
      //   7: ifne +59 -> 66
      //   10: aload_0
      //   11: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   14: ifnull +52 -> 66
      //   17: aload_0
      //   18: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   21: aload_0
      //   22: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   25: new 41	java/io/IOException
      //   28: dup
      //   29: new 49	java/lang/StringBuilder
      //   32: dup
      //   33: ldc 51
      //   35: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   38: aload_0
      //   39: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
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
      //   67: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   70: ifnull +16 -> 86
      //   73: aload_0
      //   74: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   77: aload_0
      //   78: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   81: invokeinterface 80 2 0
      //   86: aload_0
      //   87: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   90: aload_0
      //   91: getfield 29	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtI	Ljava/io/File;
      //   94: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
      //   97: astore 4
      //   99: aload_0
      //   100: getfield 31	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:Btb	Z
      //   103: ifeq +451 -> 554
      //   106: aload_0
      //   107: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
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
      //   157: invokestatic 106	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:am	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
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
      //   246: ldc 131
      //   248: aload 5
      //   250: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   253: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   256: invokeinterface 117 2 0
      //   261: pop
      //   262: aload_3
      //   263: astore_2
      //   264: aload 6
      //   266: ldc 143
      //   268: aload 4
      //   270: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   273: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   276: invokeinterface 117 2 0
      //   281: pop
      //   282: aload_3
      //   283: astore_2
      //   284: aload 6
      //   286: new 49	java/lang/StringBuilder
      //   289: dup
      //   290: ldc 145
      //   292: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   295: getstatic 20	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtG	Ljava/lang/String;
      //   298: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   301: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   304: invokeinterface 117 2 0
      //   309: pop
      //   310: aload_3
      //   311: astore_2
      //   312: getstatic 123	android/os/Build$VERSION:SDK_INT	I
      //   315: bipush 25
      //   317: if_icmple +186 -> 503
      //   320: aload_3
      //   321: astore_2
      //   322: aload 6
      //   324: ldc 147
      //   326: invokeinterface 117 2 0
      //   331: pop
      //   332: aload_3
      //   333: astore_2
      //   334: new 149	java/lang/ProcessBuilder
      //   337: dup
      //   338: aload 6
      //   340: invokespecial 152	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
      //   343: astore 5
      //   345: aload_3
      //   346: astore_2
      //   347: aload 5
      //   349: iconst_1
      //   350: invokevirtual 156	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
      //   353: pop
      //   354: aload_3
      //   355: astore_2
      //   356: aload 5
      //   358: invokevirtual 160	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
      //   361: astore 5
      //   363: aload_3
      //   364: astore_2
      //   365: aload 5
      //   367: invokevirtual 166	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   370: invokestatic 171	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:I	(Ljava/io/InputStream;)V
      //   373: aload_3
      //   374: astore_2
      //   375: aload 5
      //   377: invokevirtual 174	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   380: invokestatic 171	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer:I	(Ljava/io/InputStream;)V
      //   383: aload_3
      //   384: astore_2
      //   385: aload 5
      //   387: invokevirtual 178	java/lang/Process:waitFor	()I
      //   390: istore_1
      //   391: iload_1
      //   392: ifeq +126 -> 518
      //   395: aload_3
      //   396: astore_2
      //   397: new 41	java/io/IOException
      //   400: dup
      //   401: ldc 180
      //   403: iload_1
      //   404: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   407: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   410: invokespecial 70	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   413: athrow
      //   414: astore 4
      //   416: aload_3
      //   417: astore_2
      //   418: new 41	java/io/IOException
      //   421: dup
      //   422: new 49	java/lang/StringBuilder
      //   425: dup
      //   426: ldc 185
      //   428: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   431: aload 4
      //   433: invokevirtual 188	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   436: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   439: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   442: aload 4
      //   444: invokespecial 191	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   447: athrow
      //   448: astore_3
      //   449: aload_2
      //   450: ifnull +7 -> 457
      //   453: aload_2
      //   454: invokevirtual 194	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
      //   457: aload_3
      //   458: athrow
      //   459: astore_2
      //   460: new 49	java/lang/StringBuilder
      //   463: dup
      //   464: ldc 196
      //   466: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   469: aload_0
      //   470: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   473: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   476: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   479: pop
      //   480: aload_0
      //   481: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   484: ifnull +95 -> 579
      //   487: aload_0
      //   488: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   491: aload_0
      //   492: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   495: aload_2
      //   496: invokeinterface 76 3 0
      //   501: iconst_0
      //   502: ireturn
      //   503: aload_3
      //   504: astore_2
      //   505: aload 6
      //   507: ldc 198
      //   509: invokeinterface 117 2 0
      //   514: pop
      //   515: goto -183 -> 332
      //   518: aload_3
      //   519: invokevirtual 194	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
      //   522: aload_0
      //   523: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   526: ifnull +53 -> 579
      //   529: aload_0
      //   530: getfield 33	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtJ	Lcom/tencent/tinker/loader/TinkerDexOptimizer$ResultCallback;
      //   533: aload_0
      //   534: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   537: new 56	java/io/File
      //   540: dup
      //   541: aload 4
      //   543: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
      //   546: invokeinterface 202 3 0
      //   551: goto +28 -> 579
      //   554: aload_0
      //   555: getfield 27	com/tencent/tinker/loader/TinkerDexOptimizer$OptimizeWorker:BtH	Ljava/io/File;
      //   558: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   561: aload 4
      //   563: iconst_0
      //   564: invokestatic 208	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
      //   567: pop
      //   568: goto -46 -> 522
      //   571: astore_2
      //   572: goto -50 -> 522
      //   575: astore_2
      //   576: goto -119 -> 457
      //   579: iconst_1
      //   580: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	581	0	this	OptimizeWorker
      //   390	14	1	i	int
      //   124	330	2	localObject1	Object
      //   459	37	2	localThrowable	Throwable
      //   504	1	2	localObject2	Object
      //   571	1	2	localIOException1	java.io.IOException
      //   575	1	2	localIOException2	java.io.IOException
      //   153	264	3	localObject3	Object
      //   448	71	3	localObject4	Object
      //   97	172	4	str	String
      //   414	148	4	localInterruptedException	java.lang.InterruptedException
      //   113	273	5	localObject5	Object
      //   170	336	6	localArrayList	ArrayList
      // Exception table:
      //   from	to	target	type
      //   385	391	414	java/lang/InterruptedException
      //   397	414	414	java/lang/InterruptedException
      //   156	161	448	finally
      //   163	172	448	finally
      //   174	184	448	finally
      //   186	194	448	finally
      //   196	206	448	finally
      //   208	218	448	finally
      //   220	230	448	finally
      //   232	242	448	finally
      //   244	262	448	finally
      //   264	282	448	finally
      //   284	310	448	finally
      //   312	320	448	finally
      //   322	332	448	finally
      //   334	345	448	finally
      //   347	354	448	finally
      //   356	363	448	finally
      //   365	373	448	finally
      //   375	383	448	finally
      //   385	391	448	finally
      //   397	414	448	finally
      //   418	448	448	finally
      //   505	515	448	finally
      //   0	64	459	java/lang/Throwable
      //   66	86	459	java/lang/Throwable
      //   86	140	459	java/lang/Throwable
      //   140	154	459	java/lang/Throwable
      //   453	457	459	java/lang/Throwable
      //   457	459	459	java/lang/Throwable
      //   518	522	459	java/lang/Throwable
      //   522	551	459	java/lang/Throwable
      //   554	568	459	java/lang/Throwable
      //   518	522	571	java/io/IOException
      //   453	457	575	java/io/IOException
    }
  }
  
  public static abstract interface ResultCallback
  {
    public abstract void ag(File paramFile);
    
    public abstract void b(File paramFile, Throwable paramThrowable);
    
    public abstract void i(File paramFile1, File paramFile2);
  }
  
  static class StreamConsumer
  {
    static final Executor BtK = ;
    
    static void I(InputStream paramInputStream)
    {
      BtK.execute(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:BtL	Ljava/io/InputStream;
          //   4: ifnonnull +4 -> 8
          //   7: return
          //   8: sipush 256
          //   11: newarray byte
          //   13: astore_2
          //   14: aload_0
          //   15: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:BtL	Ljava/io/InputStream;
          //   18: aload_2
          //   19: invokevirtual 34	java/io/InputStream:read	([B)I
          //   22: istore_1
          //   23: iload_1
          //   24: ifgt -10 -> 14
          //   27: aload_0
          //   28: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:BtL	Ljava/io/InputStream;
          //   31: invokevirtual 37	java/io/InputStream:close	()V
          //   34: return
          //   35: astore_2
          //   36: return
          //   37: astore_2
          //   38: aload_0
          //   39: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:BtL	Ljava/io/InputStream;
          //   42: invokevirtual 37	java/io/InputStream:close	()V
          //   45: return
          //   46: astore_2
          //   47: return
          //   48: astore_2
          //   49: aload_0
          //   50: getfield 19	com/tencent/tinker/loader/TinkerDexOptimizer$StreamConsumer$1:BtL	Ljava/io/InputStream;
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