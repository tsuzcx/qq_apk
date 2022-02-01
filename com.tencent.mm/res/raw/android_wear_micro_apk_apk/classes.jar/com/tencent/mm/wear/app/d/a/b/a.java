package com.tencent.mm.wear.app.d.a.b;

import java.util.concurrent.BlockingQueue;

public final class a
  extends Thread
{
  private String adT;
  private BlockingQueue<g> ahr;
  private boolean ahs;
  
  public a(String paramString, BlockingQueue<g> paramBlockingQueue)
  {
    this.adT = paramString;
    this.ahr = paramBlockingQueue;
  }
  
  public final void nx()
  {
    this.ahs = true;
    this.ahr.add(new g());
  }
  
  public final String ny()
  {
    return this.adT;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 46
    //   2: ldc 48
    //   4: iconst_1
    //   5: anewarray 50	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: getfield 18	com/tencent/mm/wear/app/d/a/b/a:adT	Ljava/lang/String;
    //   14: aastore
    //   15: invokestatic 56	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: new 58	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: getfield 18	com/tencent/mm/wear/app/d/a/b/a:adT	Ljava/lang/String;
    //   26: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   34: invokevirtual 69	java/io/File:exists	()Z
    //   37: ifne +35 -> 72
    //   40: aload_1
    //   41: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   44: invokevirtual 72	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload_1
    //   49: invokevirtual 75	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: aload_1
    //   54: invokevirtual 69	java/io/File:exists	()Z
    //   57: ifne +30 -> 87
    //   60: ldc 46
    //   62: ldc 77
    //   64: iconst_0
    //   65: anewarray 50	java/lang/Object
    //   68: invokestatic 80	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: return
    //   72: aload_1
    //   73: invokevirtual 69	java/io/File:exists	()Z
    //   76: ifeq -28 -> 48
    //   79: aload_1
    //   80: invokevirtual 83	java/io/File:delete	()Z
    //   83: pop
    //   84: goto -36 -> 48
    //   87: new 85	java/io/FileOutputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: aload_1
    //   97: ifnonnull +52 -> 149
    //   100: ldc 46
    //   102: ldc 90
    //   104: iconst_0
    //   105: anewarray 50	java/lang/Object
    //   108: invokestatic 80	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: return
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -19 -> 96
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 26	com/tencent/mm/wear/app/d/a/b/a:ahs	Z
    //   125: ifne +40 -> 165
    //   128: aload_2
    //   129: ifnull +20 -> 149
    //   132: aload_1
    //   133: aload_2
    //   134: getfield 94	com/tencent/mm/wear/app/d/a/b/g:data	[B
    //   137: iconst_0
    //   138: aload_2
    //   139: getfield 98	com/tencent/mm/wear/app/d/a/b/g:size	I
    //   142: invokevirtual 104	java/io/OutputStream:write	([BII)V
    //   145: aload_1
    //   146: invokevirtual 107	java/io/OutputStream:flush	()V
    //   149: aload_0
    //   150: getfield 20	com/tencent/mm/wear/app/d/a/b/a:ahr	Ljava/util/concurrent/BlockingQueue;
    //   153: invokeinterface 111 1 0
    //   158: checkcast 28	com/tencent/mm/wear/app/d/a/b/g
    //   161: astore_2
    //   162: goto -41 -> 121
    //   165: aload_1
    //   166: invokevirtual 107	java/io/OutputStream:flush	()V
    //   169: aload_1
    //   170: invokevirtual 114	java/io/OutputStream:close	()V
    //   173: new 58	java/io/File
    //   176: dup
    //   177: aload_0
    //   178: getfield 18	com/tencent/mm/wear/app/d/a/b/a:adT	Ljava/lang/String;
    //   181: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore_1
    //   185: ldc 46
    //   187: ldc 116
    //   189: iconst_2
    //   190: anewarray 50	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: getfield 18	com/tencent/mm/wear/app/d/a/b/a:adT	Ljava/lang/String;
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload_1
    //   203: invokevirtual 120	java/io/File:length	()J
    //   206: invokestatic 126	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: invokestatic 56	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: return
    //   214: astore_1
    //   215: aload_1
    //   216: athrow
    //   217: astore_2
    //   218: goto -165 -> 53
    //   221: astore_1
    //   222: goto -49 -> 173
    //   225: astore_2
    //   226: goto -77 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	a
    //   29	68	1	localObject1	java.lang.Object
    //   112	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   114	89	1	localFile	java.io.File
    //   214	2	1	localObject2	java.lang.Object
    //   221	1	1	localIOException1	java.io.IOException
    //   118	1	2	localInterruptedException	java.lang.InterruptedException
    //   120	42	2	localg	g
    //   217	1	2	localIOException2	java.io.IOException
    //   225	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   87	96	112	java/io/FileNotFoundException
    //   149	162	118	java/lang/InterruptedException
    //   165	173	214	finally
    //   48	53	217	java/io/IOException
    //   165	173	221	java/io/IOException
    //   132	149	225	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */