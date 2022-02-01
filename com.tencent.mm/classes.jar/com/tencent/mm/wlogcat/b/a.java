package com.tencent.mm.wlogcat.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.xlog.app.XLogSetup;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static final a LXH;
  private final long LXI;
  private final long LXJ;
  private final long LXK;
  private boolean LXL;
  private boolean LXM;
  private Runnable LXN;
  private Runnable LXO;
  public HandlerThread LXP;
  public Handler LXQ;
  
  static
  {
    AppMethodBeat.i(218634);
    LXH = new a();
    AppMethodBeat.o(218634);
  }
  
  private a()
  {
    AppMethodBeat.i(218630);
    this.LXI = 60000L;
    this.LXJ = 524288000L;
    this.LXK = 6442450944L;
    this.LXL = true;
    this.LXM = true;
    this.LXN = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_1
        //   2: ldc 22
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_0
        //   8: getfield 14	com/tencent/mm/wlogcat/b/a$1:LXR	Lcom/tencent/mm/wlogcat/b/a;
        //   11: invokestatic 32	com/tencent/mm/wlogcat/b/a:a	(Lcom/tencent/mm/wlogcat/b/a;)Z
        //   14: ifne +16 -> 30
        //   17: ldc 34
        //   19: ldc 36
        //   21: invokestatic 42	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   24: ldc 22
        //   26: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   29: return
        //   30: invokestatic 51	android/os/Process:myPid	()I
        //   33: invokestatic 57	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   36: astore_3
        //   37: ldc 34
        //   39: ldc 59
        //   41: iconst_2
        //   42: anewarray 4	java/lang/Object
        //   45: dup
        //   46: iconst_0
        //   47: invokestatic 65	com/tencent/mm/sdk/platformtools/ak:getProcessName	()Ljava/lang/String;
        //   50: aastore
        //   51: dup
        //   52: iconst_1
        //   53: aload_3
        //   54: aastore
        //   55: invokestatic 68	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   58: invokestatic 71	com/tencent/mm/wlogcat/b/a:fWI	()Ljava/lang/String;
        //   61: astore_2
        //   62: aload_2
        //   63: invokevirtual 75	java/lang/String:isEmpty	()Z
        //   66: ifeq +16 -> 82
        //   69: ldc 34
        //   71: ldc 77
        //   73: invokestatic 42	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   76: ldc 22
        //   78: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   81: return
        //   82: getstatic 83	com/tencent/mm/xlog/app/XLogSetup:cachePath	Ljava/lang/String;
        //   85: getstatic 86	com/tencent/mm/xlog/app/XLogSetup:logPath	Ljava/lang/String;
        //   88: aload_2
        //   89: invokestatic 90	com/tencent/mm/sdk/platformtools/ae:bd	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ae$b;
        //   92: astore 6
        //   94: invokestatic 94	com/tencent/mm/sdk/platformtools/ae:foq	()Lcom/tencent/mm/sdk/platformtools/ae$a;
        //   97: ifnull +29 -> 126
        //   100: aload 6
        //   102: getfield 100	com/tencent/mm/sdk/platformtools/ae$b:IxA	J
        //   105: ldc2_w 101
        //   108: lcmp
        //   109: ifeq +17 -> 126
        //   112: invokestatic 94	com/tencent/mm/sdk/platformtools/ae:foq	()Lcom/tencent/mm/sdk/platformtools/ae$a;
        //   115: aload 6
        //   117: getfield 100	com/tencent/mm/sdk/platformtools/ae$b:IxA	J
        //   120: iconst_0
        //   121: invokeinterface 108 4 0
        //   126: invokestatic 114	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
        //   129: ldc 116
        //   131: invokevirtual 120	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
        //   134: astore_2
        //   135: new 122	java/io/InputStreamReader
        //   138: dup
        //   139: aload_2
        //   140: invokevirtual 128	java/lang/Process:getInputStream	()Ljava/io/InputStream;
        //   143: invokespecial 131	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   146: astore 5
        //   148: new 133	java/io/BufferedReader
        //   151: dup
        //   152: aload 5
        //   154: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   157: astore 4
        //   159: getstatic 140	com/tencent/mm/xlog/app/XLogSetup:isLogcatOpen	Ljava/lang/Boolean;
        //   162: invokevirtual 145	java/lang/Boolean:booleanValue	()Z
        //   165: ifne +178 -> 343
        //   168: aload_0
        //   169: getfield 14	com/tencent/mm/wlogcat/b/a$1:LXR	Lcom/tencent/mm/wlogcat/b/a;
        //   172: invokestatic 148	com/tencent/mm/wlogcat/b/a:b	(Lcom/tencent/mm/wlogcat/b/a;)Z
        //   175: ifeq +168 -> 343
        //   178: aload_0
        //   179: getfield 14	com/tencent/mm/wlogcat/b/a$1:LXR	Lcom/tencent/mm/wlogcat/b/a;
        //   182: invokestatic 32	com/tencent/mm/wlogcat/b/a:a	(Lcom/tencent/mm/wlogcat/b/a;)Z
        //   185: ifeq +158 -> 343
        //   188: aload 4
        //   190: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   193: astore 7
        //   195: aload 7
        //   197: ifnull +146 -> 343
        //   200: aload 7
        //   202: aload_3
        //   203: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   206: ifeq +27 -> 233
        //   209: aload 7
        //   211: ldc 157
        //   213: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   216: ifne +318 -> 534
        //   219: aload 6
        //   221: ldc 159
        //   223: aload 7
        //   225: invokevirtual 162	com/tencent/mm/sdk/platformtools/ae$b:nV	(Ljava/lang/String;Ljava/lang/String;)V
        //   228: iconst_0
        //   229: istore_1
        //   230: goto -71 -> 159
        //   233: iload_1
        //   234: ifeq -75 -> 159
        //   237: aload 7
        //   239: ldc 157
        //   241: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   244: ifne -85 -> 159
        //   247: aload 6
        //   249: ldc 159
        //   251: aload 7
        //   253: invokevirtual 162	com/tencent/mm/sdk/platformtools/ae$b:nV	(Ljava/lang/String;Ljava/lang/String;)V
        //   256: goto -97 -> 159
        //   259: astore 7
        //   261: aload 4
        //   263: astore 6
        //   265: aload 5
        //   267: astore_3
        //   268: aload_2
        //   269: astore 4
        //   271: aload 6
        //   273: astore_2
        //   274: aload 7
        //   276: astore 5
        //   278: ldc 34
        //   280: aload 5
        //   282: ldc 159
        //   284: iconst_0
        //   285: anewarray 4	java/lang/Object
        //   288: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   291: getstatic 172	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   294: ldc2_w 173
        //   297: ldc2_w 175
        //   300: lconst_1
        //   301: invokevirtual 180	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
        //   304: ldc 34
        //   306: ldc 182
        //   308: invokestatic 184	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   311: aload 4
        //   313: ifnull +8 -> 321
        //   316: aload 4
        //   318: invokevirtual 187	java/lang/Process:destroy	()V
        //   321: aload_3
        //   322: ifnull +7 -> 329
        //   325: aload_3
        //   326: invokevirtual 190	java/io/InputStreamReader:close	()V
        //   329: aload_2
        //   330: ifnull +7 -> 337
        //   333: aload_2
        //   334: invokevirtual 191	java/io/BufferedReader:close	()V
        //   337: ldc 22
        //   339: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   342: return
        //   343: ldc 34
        //   345: ldc 182
        //   347: invokestatic 184	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   350: aload_2
        //   351: ifnull +7 -> 358
        //   354: aload_2
        //   355: invokevirtual 187	java/lang/Process:destroy	()V
        //   358: aload 5
        //   360: invokevirtual 190	java/io/InputStreamReader:close	()V
        //   363: aload 4
        //   365: invokevirtual 191	java/io/BufferedReader:close	()V
        //   368: ldc 22
        //   370: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   373: return
        //   374: astore_2
        //   375: ldc 22
        //   377: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   380: return
        //   381: astore_2
        //   382: ldc 22
        //   384: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   387: return
        //   388: astore_3
        //   389: aconst_null
        //   390: astore 4
        //   392: aconst_null
        //   393: astore 5
        //   395: aconst_null
        //   396: astore_2
        //   397: ldc 34
        //   399: ldc 182
        //   401: invokestatic 184	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   404: aload_2
        //   405: ifnull +7 -> 412
        //   408: aload_2
        //   409: invokevirtual 187	java/lang/Process:destroy	()V
        //   412: aload 5
        //   414: ifnull +8 -> 422
        //   417: aload 5
        //   419: invokevirtual 190	java/io/InputStreamReader:close	()V
        //   422: aload 4
        //   424: ifnull +8 -> 432
        //   427: aload 4
        //   429: invokevirtual 191	java/io/BufferedReader:close	()V
        //   432: ldc 22
        //   434: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   437: aload_3
        //   438: athrow
        //   439: astore_2
        //   440: goto -8 -> 432
        //   443: astore_3
        //   444: aconst_null
        //   445: astore 4
        //   447: aconst_null
        //   448: astore 5
        //   450: goto -53 -> 397
        //   453: astore_3
        //   454: aconst_null
        //   455: astore 4
        //   457: goto -60 -> 397
        //   460: astore_3
        //   461: goto -64 -> 397
        //   464: astore 7
        //   466: aload_3
        //   467: astore 5
        //   469: aload 4
        //   471: astore 6
        //   473: aload 7
        //   475: astore_3
        //   476: aload_2
        //   477: astore 4
        //   479: aload 6
        //   481: astore_2
        //   482: goto -85 -> 397
        //   485: astore 5
        //   487: aconst_null
        //   488: astore_2
        //   489: aconst_null
        //   490: astore_3
        //   491: aconst_null
        //   492: astore 4
        //   494: goto -216 -> 278
        //   497: astore 5
        //   499: aconst_null
        //   500: astore 6
        //   502: aconst_null
        //   503: astore_3
        //   504: aload_2
        //   505: astore 4
        //   507: aload 6
        //   509: astore_2
        //   510: goto -232 -> 278
        //   513: astore 7
        //   515: aconst_null
        //   516: astore 6
        //   518: aload 5
        //   520: astore_3
        //   521: aload_2
        //   522: astore 4
        //   524: aload 7
        //   526: astore 5
        //   528: aload 6
        //   530: astore_2
        //   531: goto -253 -> 278
        //   534: iconst_0
        //   535: istore_1
        //   536: goto -377 -> 159
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	539	0	this	1
        //   1	535	1	i	int
        //   61	294	2	localObject1	Object
        //   374	1	2	localException1	Exception
        //   381	1	2	localException2	Exception
        //   396	13	2	localObject2	Object
        //   439	38	2	localException3	Exception
        //   481	50	2	localObject3	Object
        //   36	290	3	localObject4	Object
        //   388	50	3	localObject5	Object
        //   443	1	3	localObject6	Object
        //   453	1	3	localObject7	Object
        //   460	7	3	localObject8	Object
        //   475	46	3	localObject9	Object
        //   157	366	4	localObject10	Object
        //   146	322	5	localObject11	Object
        //   485	1	5	localException4	Exception
        //   497	22	5	localException5	Exception
        //   526	1	5	localObject12	Object
        //   92	437	6	localObject13	Object
        //   193	59	7	str	String
        //   259	16	7	localException6	Exception
        //   464	10	7	localObject14	Object
        //   513	12	7	localException7	Exception
        // Exception table:
        //   from	to	target	type
        //   159	195	259	java/lang/Exception
        //   200	228	259	java/lang/Exception
        //   237	256	259	java/lang/Exception
        //   354	358	374	java/lang/Exception
        //   358	368	374	java/lang/Exception
        //   316	321	381	java/lang/Exception
        //   325	329	381	java/lang/Exception
        //   333	337	381	java/lang/Exception
        //   126	135	388	finally
        //   408	412	439	java/lang/Exception
        //   417	422	439	java/lang/Exception
        //   427	432	439	java/lang/Exception
        //   135	148	443	finally
        //   148	159	453	finally
        //   159	195	460	finally
        //   200	228	460	finally
        //   237	256	460	finally
        //   278	304	464	finally
        //   126	135	485	java/lang/Exception
        //   135	148	497	java/lang/Exception
        //   148	159	513	java/lang/Exception
      }
    };
    this.LXO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218628);
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwg, 0) == 1)
        {
          a.a(a.this, true);
          if (!a.a(a.this))
          {
            ae.e("MicroMsg.LogcatCatcher", "checker not safe!");
            AppMethodBeat.o(218628);
          }
        }
        else
        {
          a.a(a.this, false);
          ae.e("MicroMsg.LogcatCatcher", "no need to work");
          AppMethodBeat.o(218628);
          return;
        }
        if (!a.fWJ())
        {
          ae.e("MicroMsg.LogcatCatcher", "no space!");
          a.c(a.this);
          AppMethodBeat.o(218628);
          return;
        }
        String str = a.fWI();
        if (str.isEmpty())
        {
          ae.e("MicroMsg.LogcatCatcher", "errorCheck nameprefix empty!");
          AppMethodBeat.o(218628);
          return;
        }
        str = str + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".xlog";
        Object localObject1 = new k(XLogSetup.logPath);
        if (((k)localObject1).isDirectory())
        {
          localObject1 = ((k)localObject1).fTj();
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
                ae.i("MicroMsg.LogcatCatcher", "checker find target file:%s, size:%s", new Object[] { str, String.valueOf(l) });
                k = i;
                if (l > 524288000L)
                {
                  ae.e("MicroMsg.LogcatCatcher", "maybe error! stop!");
                  k = 0;
                }
              }
              j += 1;
            }
          }
        }
        int k = 1;
        a.e(a.this).removeCallbacks(a.d(a.this));
        if (k != 0)
        {
          a.e(a.this).postDelayed(a.d(a.this), 60000L);
          AppMethodBeat.o(218628);
          return;
        }
        a.c(a.this);
        com.tencent.mm.plugin.report.service.g.yxI.n(1504L, 2L, 1L);
        AppMethodBeat.o(218628);
      }
    };
    this.LXP = new HandlerThread("LogcatCatcher");
    this.LXQ = null;
    AppMethodBeat.o(218630);
  }
  
  private static long caZ()
  {
    AppMethodBeat.i(218631);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.asd());
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
      AppMethodBeat.o(218631);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(218631);
      return 1L;
    }
    return l;
  }
  
  public static a fWH()
  {
    return LXH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wlogcat.b.a
 * JD-Core Version:    0.7.0.1
 */