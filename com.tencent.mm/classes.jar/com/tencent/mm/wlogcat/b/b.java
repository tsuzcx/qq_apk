package com.tencent.mm.wlogcat.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.xlog.app.XLogSetup;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  private static final b RwF;
  private Runnable RwD;
  private final long RwG;
  private final long RwH;
  private final long RwI;
  private boolean RwJ;
  private boolean RwK;
  private Runnable RwL;
  public HandlerThread RwM;
  public Handler RwN;
  
  static
  {
    AppMethodBeat.i(224062);
    RwF = new b();
    AppMethodBeat.o(224062);
  }
  
  private b()
  {
    AppMethodBeat.i(224058);
    this.RwG = 60000L;
    this.RwH = 524288000L;
    this.RwI = 6442450944L;
    this.RwJ = true;
    this.RwK = true;
    this.RwD = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 14	com/tencent/mm/wlogcat/b/b$1:RwO	Lcom/tencent/mm/wlogcat/b/b;
        //   9: invokestatic 32	com/tencent/mm/wlogcat/b/b:a	(Lcom/tencent/mm/wlogcat/b/b;)Z
        //   12: ifne +16 -> 28
        //   15: ldc 34
        //   17: ldc 36
        //   19: invokestatic 42	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   22: ldc 22
        //   24: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   27: return
        //   28: invokestatic 51	android/os/Process:myPid	()I
        //   31: invokestatic 57	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   34: astore_3
        //   35: ldc 34
        //   37: ldc 59
        //   39: iconst_2
        //   40: anewarray 4	java/lang/Object
        //   43: dup
        //   44: iconst_0
        //   45: invokestatic 65	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
        //   48: aastore
        //   49: dup
        //   50: iconst_1
        //   51: aload_3
        //   52: aastore
        //   53: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   56: invokestatic 71	com/tencent/mm/wlogcat/b/b:hij	()Ljava/lang/String;
        //   59: astore_2
        //   60: aload_2
        //   61: invokevirtual 75	java/lang/String:isEmpty	()Z
        //   64: ifeq +16 -> 80
        //   67: ldc 34
        //   69: ldc 77
        //   71: invokestatic 42	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   74: ldc 22
        //   76: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: return
        //   80: iconst_2
        //   81: iconst_0
        //   82: getstatic 83	com/tencent/mm/xlog/app/XLogSetup:cachePath	Ljava/lang/String;
        //   85: getstatic 86	com/tencent/mm/xlog/app/XLogSetup:logPath	Ljava/lang/String;
        //   88: aload_2
        //   89: iconst_0
        //   90: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:openLogInstance	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;
        //   93: astore 6
        //   95: aload 6
        //   97: iconst_0
        //   98: invokevirtual 96	com/tencent/mm/sdk/platformtools/Log$LogInstance:setConsoleLogOpen	(Z)V
        //   101: invokestatic 102	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
        //   104: ldc 104
        //   106: invokevirtual 108	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
        //   109: astore_2
        //   110: new 110	java/io/InputStreamReader
        //   113: dup
        //   114: aload_2
        //   115: invokevirtual 116	java/lang/Process:getInputStream	()Ljava/io/InputStream;
        //   118: invokespecial 119	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   121: astore 5
        //   123: new 121	java/io/BufferedReader
        //   126: dup
        //   127: aload 5
        //   129: invokespecial 124	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   132: astore 4
        //   134: iconst_1
        //   135: istore_1
        //   136: getstatic 128	com/tencent/mm/xlog/app/XLogSetup:isLogcatOpen	Ljava/lang/Boolean;
        //   139: invokevirtual 133	java/lang/Boolean:booleanValue	()Z
        //   142: ifne +178 -> 320
        //   145: aload_0
        //   146: getfield 14	com/tencent/mm/wlogcat/b/b$1:RwO	Lcom/tencent/mm/wlogcat/b/b;
        //   149: invokestatic 136	com/tencent/mm/wlogcat/b/b:b	(Lcom/tencent/mm/wlogcat/b/b;)Z
        //   152: ifeq +168 -> 320
        //   155: aload_0
        //   156: getfield 14	com/tencent/mm/wlogcat/b/b$1:RwO	Lcom/tencent/mm/wlogcat/b/b;
        //   159: invokestatic 32	com/tencent/mm/wlogcat/b/b:a	(Lcom/tencent/mm/wlogcat/b/b;)Z
        //   162: ifeq +158 -> 320
        //   165: aload 4
        //   167: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   170: astore 7
        //   172: aload 7
        //   174: ifnull +146 -> 320
        //   177: aload 7
        //   179: aload_3
        //   180: invokevirtual 143	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   183: ifeq +27 -> 210
        //   186: aload 7
        //   188: ldc 145
        //   190: invokevirtual 143	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   193: ifne +318 -> 511
        //   196: aload 6
        //   198: ldc 147
        //   200: aload 7
        //   202: invokevirtual 150	com/tencent/mm/sdk/platformtools/Log$LogInstance:iNoFormat	(Ljava/lang/String;Ljava/lang/String;)V
        //   205: iconst_0
        //   206: istore_1
        //   207: goto -71 -> 136
        //   210: iload_1
        //   211: ifeq -75 -> 136
        //   214: aload 7
        //   216: ldc 145
        //   218: invokevirtual 143	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   221: ifne -85 -> 136
        //   224: aload 6
        //   226: ldc 147
        //   228: aload 7
        //   230: invokevirtual 150	com/tencent/mm/sdk/platformtools/Log$LogInstance:iNoFormat	(Ljava/lang/String;Ljava/lang/String;)V
        //   233: goto -97 -> 136
        //   236: astore 7
        //   238: aload 4
        //   240: astore 6
        //   242: aload 5
        //   244: astore_3
        //   245: aload_2
        //   246: astore 4
        //   248: aload 6
        //   250: astore_2
        //   251: aload 7
        //   253: astore 5
        //   255: ldc 34
        //   257: aload 5
        //   259: ldc 147
        //   261: iconst_0
        //   262: anewarray 4	java/lang/Object
        //   265: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   268: getstatic 160	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
        //   271: ldc2_w 161
        //   274: ldc2_w 163
        //   277: lconst_1
        //   278: invokevirtual 168	com/tencent/mm/plugin/report/service/h:n	(JJJ)V
        //   281: ldc 34
        //   283: ldc 170
        //   285: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   288: aload 4
        //   290: ifnull +8 -> 298
        //   293: aload 4
        //   295: invokevirtual 175	java/lang/Process:destroy	()V
        //   298: aload_3
        //   299: ifnull +7 -> 306
        //   302: aload_3
        //   303: invokevirtual 178	java/io/InputStreamReader:close	()V
        //   306: aload_2
        //   307: ifnull +7 -> 314
        //   310: aload_2
        //   311: invokevirtual 179	java/io/BufferedReader:close	()V
        //   314: ldc 22
        //   316: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   319: return
        //   320: ldc 34
        //   322: ldc 170
        //   324: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   327: aload_2
        //   328: ifnull +7 -> 335
        //   331: aload_2
        //   332: invokevirtual 175	java/lang/Process:destroy	()V
        //   335: aload 5
        //   337: invokevirtual 178	java/io/InputStreamReader:close	()V
        //   340: aload 4
        //   342: invokevirtual 179	java/io/BufferedReader:close	()V
        //   345: ldc 22
        //   347: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   350: return
        //   351: astore_2
        //   352: ldc 22
        //   354: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   357: return
        //   358: astore_2
        //   359: ldc 22
        //   361: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   364: return
        //   365: astore_3
        //   366: aconst_null
        //   367: astore 4
        //   369: aconst_null
        //   370: astore 5
        //   372: aconst_null
        //   373: astore_2
        //   374: ldc 34
        //   376: ldc 170
        //   378: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   381: aload_2
        //   382: ifnull +7 -> 389
        //   385: aload_2
        //   386: invokevirtual 175	java/lang/Process:destroy	()V
        //   389: aload 5
        //   391: ifnull +8 -> 399
        //   394: aload 5
        //   396: invokevirtual 178	java/io/InputStreamReader:close	()V
        //   399: aload 4
        //   401: ifnull +8 -> 409
        //   404: aload 4
        //   406: invokevirtual 179	java/io/BufferedReader:close	()V
        //   409: ldc 22
        //   411: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   414: aload_3
        //   415: athrow
        //   416: astore_2
        //   417: goto -8 -> 409
        //   420: astore_3
        //   421: aconst_null
        //   422: astore 4
        //   424: aconst_null
        //   425: astore 5
        //   427: goto -53 -> 374
        //   430: astore_3
        //   431: aconst_null
        //   432: astore 4
        //   434: goto -60 -> 374
        //   437: astore_3
        //   438: goto -64 -> 374
        //   441: astore 7
        //   443: aload_3
        //   444: astore 5
        //   446: aload 4
        //   448: astore 6
        //   450: aload 7
        //   452: astore_3
        //   453: aload_2
        //   454: astore 4
        //   456: aload 6
        //   458: astore_2
        //   459: goto -85 -> 374
        //   462: astore 5
        //   464: aconst_null
        //   465: astore_2
        //   466: aconst_null
        //   467: astore_3
        //   468: aconst_null
        //   469: astore 4
        //   471: goto -216 -> 255
        //   474: astore 5
        //   476: aconst_null
        //   477: astore 6
        //   479: aconst_null
        //   480: astore_3
        //   481: aload_2
        //   482: astore 4
        //   484: aload 6
        //   486: astore_2
        //   487: goto -232 -> 255
        //   490: astore 7
        //   492: aconst_null
        //   493: astore 6
        //   495: aload 5
        //   497: astore_3
        //   498: aload_2
        //   499: astore 4
        //   501: aload 7
        //   503: astore 5
        //   505: aload 6
        //   507: astore_2
        //   508: goto -253 -> 255
        //   511: iconst_0
        //   512: istore_1
        //   513: goto -377 -> 136
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	516	0	this	1
        //   135	378	1	i	int
        //   59	273	2	localObject1	Object
        //   351	1	2	localException1	Exception
        //   358	1	2	localException2	Exception
        //   373	13	2	localObject2	Object
        //   416	38	2	localException3	Exception
        //   458	50	2	localObject3	Object
        //   34	269	3	localObject4	Object
        //   365	50	3	localObject5	Object
        //   420	1	3	localObject6	Object
        //   430	1	3	localObject7	Object
        //   437	7	3	localObject8	Object
        //   452	46	3	localObject9	Object
        //   132	368	4	localObject10	Object
        //   121	324	5	localObject11	Object
        //   462	1	5	localException4	Exception
        //   474	22	5	localException5	Exception
        //   503	1	5	localObject12	Object
        //   93	413	6	localObject13	Object
        //   170	59	7	str	String
        //   236	16	7	localException6	Exception
        //   441	10	7	localObject14	Object
        //   490	12	7	localException7	Exception
        // Exception table:
        //   from	to	target	type
        //   136	172	236	java/lang/Exception
        //   177	205	236	java/lang/Exception
        //   214	233	236	java/lang/Exception
        //   331	335	351	java/lang/Exception
        //   335	345	351	java/lang/Exception
        //   293	298	358	java/lang/Exception
        //   302	306	358	java/lang/Exception
        //   310	314	358	java/lang/Exception
        //   101	110	365	finally
        //   385	389	416	java/lang/Exception
        //   394	399	416	java/lang/Exception
        //   404	409	416	java/lang/Exception
        //   110	123	420	finally
        //   123	134	430	finally
        //   136	172	437	finally
        //   177	205	437	finally
        //   214	233	437	finally
        //   255	281	441	finally
        //   101	110	462	java/lang/Exception
        //   110	123	474	java/lang/Exception
        //   123	134	490	java/lang/Exception
      }
    };
    this.RwL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224056);
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNO, 1) == 1)
        {
          b.a(b.this, true);
          if (!b.a(b.this))
          {
            Log.e("MicroMsg.LogcatCatcher", "checker not safe!");
            AppMethodBeat.o(224056);
          }
        }
        else
        {
          b.a(b.this, false);
          Log.e("MicroMsg.LogcatCatcher", "no need to work");
          AppMethodBeat.o(224056);
          return;
        }
        if (!b.hik())
        {
          Log.e("MicroMsg.LogcatCatcher", "no space!");
          b.c(b.this);
          AppMethodBeat.o(224056);
          return;
        }
        String str = b.hij();
        if (str.isEmpty())
        {
          Log.e("MicroMsg.LogcatCatcher", "errorCheck nameprefix empty!");
          AppMethodBeat.o(224056);
          return;
        }
        str = str + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".xlog";
        Object localObject1 = new o(XLogSetup.logPath);
        if (((o)localObject1).isDirectory())
        {
          localObject1 = ((o)localObject1).het();
          if (localObject1 != null)
          {
            int m = localObject1.length;
            int j = 0;
            for (int i = 1;; i = k)
            {
              k = i;
              if (j >= m) {
                break;
              }
              Object localObject2 = localObject1[j];
              k = i;
              if (localObject2.getName().contains(str))
              {
                long l = localObject2.length();
                Log.i("MicroMsg.LogcatCatcher", "checker find target file:%s, size:%s", new Object[] { str, String.valueOf(l) });
                k = i;
                if (l > 524288000L)
                {
                  Log.e("MicroMsg.LogcatCatcher", "maybe error! stop!");
                  k = 0;
                }
              }
              j += 1;
            }
          }
        }
        int k = 1;
        b.e(b.this).removeCallbacks(b.d(b.this));
        if (k != 0)
        {
          b.e(b.this).postDelayed(b.d(b.this), 60000L);
          AppMethodBeat.o(224056);
          return;
        }
        b.c(b.this);
        com.tencent.mm.plugin.report.service.h.CyF.n(1504L, 2L, 1L);
        AppMethodBeat.o(224056);
      }
    };
    this.RwM = new HandlerThread("LogcatCatcher");
    this.RwN = null;
    AppMethodBeat.o(224058);
  }
  
  private static long cyO()
  {
    AppMethodBeat.i(224059);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.aKD());
      l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AppMethodBeat.o(224059);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(224059);
      return 1L;
    }
    return l;
  }
  
  public static b hii()
  {
    return RwF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wlogcat.b.b
 * JD-Core Version:    0.7.0.1
 */