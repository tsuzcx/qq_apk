package com.tencent.mm.plugin.performance.diagnostic.memory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class MemoryHookLogic$MemoryHookReporter
  extends BroadcastReceiver
{
  private static final String wHm;
  private static MemoryHookReporter wHn;
  
  static
  {
    AppMethodBeat.i(124958);
    wHm = MemoryHookLogic.access$000() + "-reporter";
    wHn = null;
    AppMethodBeat.o(124958);
  }
  
  static void dyG()
  {
    AppMethodBeat.i(124956);
    Intent localIntent = new Intent("com.tencent.mm.memoryhook.dump");
    localIntent.putExtra("op", 1);
    localIntent.putExtra("log_file", q.B(MemoryHookLogic.dyF().fOK()));
    aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(124956);
  }
  
  /* Error */
  public static void install()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 99
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wHn	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
    //   11: ifnull +12 -> 23
    //   14: ldc 99
    //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: new 2	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter
    //   26: dup
    //   27: invokespecial 100	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:<init>	()V
    //   30: putstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wHn	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
    //   33: new 102	android/content/IntentFilter
    //   36: dup
    //   37: ldc 55
    //   39: invokespecial 103	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   42: astore_0
    //   43: invokestatic 91	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   46: getstatic 44	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:wHn	Lcom/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter;
    //   49: aload_0
    //   50: ldc 105
    //   52: aconst_null
    //   53: invokevirtual 109	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   56: pop
    //   57: ldc 99
    //   59: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -43 -> 19
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	8	0	localIntentFilter	android.content.IntentFilter
    //   65	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	65	finally
    //   23	62	65	finally
  }
  
  static void report()
  {
    AppMethodBeat.i(124955);
    Intent localIntent = new Intent("com.tencent.mm.memoryhook.dump");
    localIntent.putExtra("op", 0);
    aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(124955);
  }
  
  public final void onReceive(final Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(124957);
    final int i = paramIntent.getIntExtra("op", 0);
    paramContext = paramIntent.getStringExtra("log_file");
    h.LTJ.f(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 36
        //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 26	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter$1:wHo	I
        //   9: tableswitch	default:+23 -> 32, 0:+29->38, 1:+59->68
        //   33: fload_2
        //   34: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   37: return
        //   38: invokestatic 49	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$000	()Ljava/lang/String;
        //   41: ldc 51
        //   43: iconst_1
        //   44: anewarray 4	java/lang/Object
        //   47: dup
        //   48: iconst_0
        //   49: invokestatic 56	com/tencent/mm/sdk/platformtools/aj:getProcessName	()Ljava/lang/String;
        //   52: aastore
        //   53: invokestatic 61	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   56: invokestatic 64	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$200	()V
        //   59: invokestatic 67	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter:dyG	()V
        //   62: ldc 36
        //   64: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   67: return
        //   68: invokestatic 71	com/tencent/mm/sdk/platformtools/aj:cmR	()Z
        //   71: ifne +9 -> 80
        //   74: ldc 36
        //   76: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: return
        //   80: invokestatic 49	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic:access$000	()Ljava/lang/String;
        //   83: astore 7
        //   85: new 73	com/tencent/mm/vfs/e
        //   88: dup
        //   89: aload_0
        //   90: getfield 28	com/tencent/mm/plugin/performance/diagnostic/memory/MemoryHookLogic$MemoryHookReporter$1:wHp	Ljava/lang/String;
        //   93: invokespecial 76	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
        //   96: astore 6
        //   98: aload 7
        //   100: ldc 78
        //   102: iconst_2
        //   103: anewarray 4	java/lang/Object
        //   106: dup
        //   107: iconst_0
        //   108: aload 6
        //   110: invokevirtual 81	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
        //   113: aastore
        //   114: dup
        //   115: iconst_1
        //   116: aload 6
        //   118: invokevirtual 85	com/tencent/mm/vfs/e:lastModified	()J
        //   121: invokestatic 91	com/tencent/mm/plugin/performance/c:yt	(J)Ljava/lang/String;
        //   124: aastore
        //   125: invokestatic 61	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   128: aload 6
        //   130: invokevirtual 94	com/tencent/mm/vfs/e:exists	()Z
        //   133: ifeq +184 -> 317
        //   136: new 96	java/io/BufferedReader
        //   139: dup
        //   140: new 98	java/io/InputStreamReader
        //   143: dup
        //   144: aload 6
        //   146: invokestatic 104	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
        //   149: invokespecial 107	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   152: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   155: astore 4
        //   157: aload 4
        //   159: astore_3
        //   160: new 112	java/lang/StringBuilder
        //   163: dup
        //   164: invokespecial 113	java/lang/StringBuilder:<init>	()V
        //   167: astore 5
        //   169: iconst_0
        //   170: istore_1
        //   171: aload 4
        //   173: astore_3
        //   174: aload 4
        //   176: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   179: astore 8
        //   181: aload 8
        //   183: ifnull +66 -> 249
        //   186: aload 4
        //   188: astore_3
        //   189: aload 5
        //   191: aload 8
        //   193: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: pop
        //   197: aload 4
        //   199: astore_3
        //   200: aload 5
        //   202: bipush 10
        //   204: invokevirtual 123	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
        //   207: pop
        //   208: iload_1
        //   209: iconst_1
        //   210: iadd
        //   211: istore_2
        //   212: iload_1
        //   213: bipush 20
        //   215: irem
        //   216: ifne +201 -> 417
        //   219: aload 4
        //   221: astore_3
        //   222: aload 7
        //   224: aload 5
        //   226: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   229: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   232: aload 4
        //   234: astore_3
        //   235: new 112	java/lang/StringBuilder
        //   238: dup
        //   239: invokespecial 113	java/lang/StringBuilder:<init>	()V
        //   242: astore 5
        //   244: iload_2
        //   245: istore_1
        //   246: goto -75 -> 171
        //   249: aload 4
        //   251: astore_3
        //   252: aload 7
        //   254: aload 5
        //   256: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   259: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   262: aload 4
        //   264: astore_3
        //   265: invokestatic 134	com/tencent/mm/sdk/platformtools/bu:fjL	()Z
        //   268: ifne +30 -> 298
        //   271: aload 4
        //   273: astore_3
        //   274: invokestatic 137	com/tencent/mm/sdk/platformtools/bu:flY	()Z
        //   277: ifne +21 -> 298
        //   280: aload 4
        //   282: astore_3
        //   283: getstatic 143	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
        //   286: ifne +12 -> 298
        //   289: aload 4
        //   291: astore_3
        //   292: getstatic 146	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
        //   295: ifeq +11 -> 306
        //   298: aload 4
        //   300: astore_3
        //   301: aload 6
        //   303: invokestatic 150	com/tencent/mm/plugin/performance/c:N	(Lcom/tencent/mm/vfs/e;)V
        //   306: aload 4
        //   308: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
        //   311: aload 6
        //   313: invokevirtual 159	com/tencent/mm/vfs/e:delete	()Z
        //   316: pop
        //   317: aload 7
        //   319: ldc 161
        //   321: iconst_2
        //   322: anewarray 4	java/lang/Object
        //   325: dup
        //   326: iconst_0
        //   327: aload 6
        //   329: invokevirtual 81	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
        //   332: aastore
        //   333: dup
        //   334: iconst_1
        //   335: aload 6
        //   337: invokevirtual 85	com/tencent/mm/vfs/e:lastModified	()J
        //   340: invokestatic 91	com/tencent/mm/plugin/performance/c:yt	(J)Ljava/lang/String;
        //   343: aastore
        //   344: invokestatic 61	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   347: goto -315 -> 32
        //   350: astore 5
        //   352: aconst_null
        //   353: astore 4
        //   355: aload 4
        //   357: astore_3
        //   358: aload 7
        //   360: aload 5
        //   362: ldc 163
        //   364: iconst_0
        //   365: anewarray 4	java/lang/Object
        //   368: invokestatic 167	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   371: aload 4
        //   373: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
        //   376: aload 6
        //   378: invokevirtual 159	com/tencent/mm/vfs/e:delete	()Z
        //   381: pop
        //   382: goto -65 -> 317
        //   385: astore 4
        //   387: aconst_null
        //   388: astore_3
        //   389: aload_3
        //   390: invokestatic 156	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
        //   393: aload 6
        //   395: invokevirtual 159	com/tencent/mm/vfs/e:delete	()Z
        //   398: pop
        //   399: ldc 36
        //   401: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   404: aload 4
        //   406: athrow
        //   407: astore 4
        //   409: goto -20 -> 389
        //   412: astore 5
        //   414: goto -59 -> 355
        //   417: iload_2
        //   418: istore_1
        //   419: goto -248 -> 171
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	422	0	this	1
        //   170	249	1	i	int
        //   211	207	2	j	int
        //   159	231	3	localBufferedReader1	java.io.BufferedReader
        //   155	217	4	localBufferedReader2	java.io.BufferedReader
        //   385	20	4	localObject1	Object
        //   407	1	4	localObject2	Object
        //   167	88	5	localStringBuilder	java.lang.StringBuilder
        //   350	11	5	localIOException1	java.io.IOException
        //   412	1	5	localIOException2	java.io.IOException
        //   96	298	6	locale	e
        //   83	276	7	str1	String
        //   179	13	8	str2	String
        // Exception table:
        //   from	to	target	type
        //   136	157	350	java/io/IOException
        //   136	157	385	finally
        //   160	169	407	finally
        //   174	181	407	finally
        //   189	197	407	finally
        //   200	208	407	finally
        //   222	232	407	finally
        //   235	244	407	finally
        //   252	262	407	finally
        //   265	271	407	finally
        //   274	280	407	finally
        //   283	289	407	finally
        //   292	298	407	finally
        //   301	306	407	finally
        //   358	371	407	finally
        //   160	169	412	java/io/IOException
        //   174	181	412	java/io/IOException
        //   189	197	412	java/io/IOException
        //   200	208	412	java/io/IOException
        //   222	232	412	java/io/IOException
        //   235	244	412	java/io/IOException
        //   252	262	412	java/io/IOException
        //   265	271	412	java/io/IOException
        //   274	280	412	java/io/IOException
        //   283	289	412	java/io/IOException
        //   292	298	412	java/io/IOException
        //   301	306	412	java/io/IOException
      }
    }, wHm);
    AppMethodBeat.o(124957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic.MemoryHookReporter
 * JD-Core Version:    0.7.0.1
 */