package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class g
{
  private static SparseArray<Long> Cyu;
  private static SparseArray<HashMap<Integer, Integer>> Cyv;
  private static boolean Cyw;
  private static long Cyx;
  private static long Cyy;
  private static long Cyz;
  
  static
  {
    AppMethodBeat.i(143863);
    Cyu = new SparseArray();
    Cyv = new SparseArray();
    Cyw = true;
    Cyx = 0L;
    Cyy = 0L;
    Cyz = 0L;
    AppMethodBeat.o(143863);
  }
  
  public static void Wl(int paramInt)
  {
    AppMethodBeat.i(143857);
    if (!Cyw)
    {
      AppMethodBeat.o(143857);
      return;
    }
    Cyu.put(paramInt, Long.valueOf(Util.nowMilliSecond()));
    Log.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Util.nowMilliSecond()) });
    AppMethodBeat.o(143857);
  }
  
  public static void Wm(int paramInt)
  {
    AppMethodBeat.i(143859);
    if (!Cyw)
    {
      AppMethodBeat.o(143859);
      return;
    }
    Long localLong = (Long)Cyu.get(paramInt);
    if (localLong == null)
    {
      AppMethodBeat.o(143859);
      return;
    }
    if (localLong.longValue() == -1L)
    {
      AppMethodBeat.o(143859);
      return;
    }
    Cyu.put(paramInt, Long.valueOf(-1L));
    long l = Util.nowMilliSecond() - localLong.longValue();
    if (l <= 0L)
    {
      AppMethodBeat.o(143859);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) });
      AppMethodBeat.o(143859);
      return;
      if (MMApplicationContext.sIsRevChange)
      {
        h.CyF.b(23, 4, 5, (int)l, false);
      }
      else
      {
        aB(1, l);
        aA(227, l);
        h.CyF.b(23, 1, 2, (int)l, false);
        continue;
        aB(3, l);
        aA(229, l);
        h.CyF.b(27, 1, 2, (int)l, false);
        continue;
        aB(2, l);
        aA(228, l);
        h.CyF.b(28, 1, 2, (int)l, false);
        continue;
        aB(6, l);
        continue;
        aB(7, l);
        continue;
        aB(8, l);
        continue;
        aB(10, l);
        continue;
        aB(14, l);
        continue;
        aB(15, l);
        continue;
        aB(9, l);
        continue;
        aB(11, l);
        continue;
        aB(16, l);
        continue;
        aB(13, l);
        continue;
        aB(12, l);
      }
    }
  }
  
  public static void Wn(int paramInt)
  {
    AppMethodBeat.i(143862);
    if (!Cyw)
    {
      AppMethodBeat.o(143862);
      return;
    }
    Log.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", new Object[] { Integer.valueOf(paramInt) });
    Cyu.put(paramInt, Long.valueOf(-1L));
    AppMethodBeat.o(143862);
  }
  
  private static void aA(int paramInt, long paramLong)
  {
    AppMethodBeat.i(143860);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(143860);
      return;
    }
    if (paramLong < 1000L)
    {
      h.CyF.aw(paramInt, 0, 1);
      AppMethodBeat.o(143860);
      return;
    }
    if (paramLong < 2000L)
    {
      h.CyF.aw(paramInt, 0, 3);
      AppMethodBeat.o(143860);
      return;
    }
    if (paramLong < 5000L)
    {
      h.CyF.aw(paramInt, 0, 5);
      AppMethodBeat.o(143860);
      return;
    }
    if (paramLong < 10000L)
    {
      h.CyF.aw(paramInt, 0, 7);
      AppMethodBeat.o(143860);
      return;
    }
    h.CyF.aw(paramInt, 0, 9);
    AppMethodBeat.o(143860);
  }
  
  private static void aB(int paramInt, long paramLong)
  {
    AppMethodBeat.i(143861);
    long l;
    if (paramInt == 6)
    {
      l = System.currentTimeMillis();
      if (l < Cyx + 60000L)
      {
        AppMethodBeat.o(143861);
        return;
      }
      Cyx = l;
    }
    for (;;)
    {
      a locala = a.eOH();
      if (!locala.hasInit) {
        break;
      }
      h.CyF.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(locala.CyB), Long.valueOf(locala.CyA[0]), Long.valueOf(locala.CyA[1]), Long.valueOf(locala.CyD) });
      AppMethodBeat.o(143861);
      return;
      if (paramInt == 7)
      {
        l = System.currentTimeMillis();
        if (l < Cyy + 60000L)
        {
          AppMethodBeat.o(143861);
          return;
        }
        Cyy = l;
      }
      else if (paramInt == 8)
      {
        l = System.currentTimeMillis();
        if (l < Cyz + 60000L)
        {
          AppMethodBeat.o(143861);
          return;
        }
        Cyz = l;
      }
    }
    h.CyF.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(143861);
  }
  
  public static final class a
  {
    public static a CyE;
    public long[] CyA;
    public int CyB;
    public String CyC;
    public long CyD;
    public volatile boolean hasInit;
    
    /* Error */
    private static String aop()
    {
      // Byte code:
      //   0: ldc 33
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc 41
      //   7: astore_1
      //   8: new 43	com/tencent/mm/vfs/u
      //   11: dup
      //   12: ldc 45
      //   14: invokespecial 48	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   17: astore_0
      //   18: new 50	java/io/BufferedReader
      //   21: dup
      //   22: aload_0
      //   23: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   26: astore 4
      //   28: aload 4
      //   30: astore_3
      //   31: aload_0
      //   32: astore_2
      //   33: aload_1
      //   34: astore 5
      //   36: aload_1
      //   37: astore 6
      //   39: aload 4
      //   41: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   44: invokevirtual 61	java/lang/String:trim	()Ljava/lang/String;
      //   47: astore_1
      //   48: aload 4
      //   50: astore_3
      //   51: aload_0
      //   52: astore_2
      //   53: aload_1
      //   54: astore 5
      //   56: aload_1
      //   57: astore 6
      //   59: aload 4
      //   61: invokevirtual 64	java/io/BufferedReader:close	()V
      //   64: aload_0
      //   65: invokevirtual 65	com/tencent/mm/vfs/u:close	()V
      //   68: aload 4
      //   70: invokevirtual 64	java/io/BufferedReader:close	()V
      //   73: aload_1
      //   74: astore_0
      //   75: ldc 33
      //   77: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: aload_0
      //   81: areturn
      //   82: astore_0
      //   83: ldc 70
      //   85: aload_0
      //   86: ldc 72
      //   88: iconst_0
      //   89: anewarray 4	java/lang/Object
      //   92: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   95: goto -27 -> 68
      //   98: astore_0
      //   99: ldc 70
      //   101: aload_0
      //   102: ldc 72
      //   104: iconst_0
      //   105: anewarray 4	java/lang/Object
      //   108: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   111: aload_1
      //   112: astore_0
      //   113: goto -38 -> 75
      //   116: astore 5
      //   118: aconst_null
      //   119: astore 4
      //   121: aconst_null
      //   122: astore_0
      //   123: aload 4
      //   125: astore_3
      //   126: aload_0
      //   127: astore_2
      //   128: ldc 70
      //   130: aload 5
      //   132: ldc 72
      //   134: iconst_0
      //   135: anewarray 4	java/lang/Object
      //   138: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   141: aload_0
      //   142: ifnull +7 -> 149
      //   145: aload_0
      //   146: invokevirtual 65	com/tencent/mm/vfs/u:close	()V
      //   149: aload_1
      //   150: astore_0
      //   151: aload 4
      //   153: ifnull -78 -> 75
      //   156: aload 4
      //   158: invokevirtual 64	java/io/BufferedReader:close	()V
      //   161: aload_1
      //   162: astore_0
      //   163: goto -88 -> 75
      //   166: astore_0
      //   167: ldc 70
      //   169: aload_0
      //   170: ldc 72
      //   172: iconst_0
      //   173: anewarray 4	java/lang/Object
      //   176: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   179: aload_1
      //   180: astore_0
      //   181: goto -106 -> 75
      //   184: astore_0
      //   185: ldc 70
      //   187: aload_0
      //   188: ldc 72
      //   190: iconst_0
      //   191: anewarray 4	java/lang/Object
      //   194: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   197: goto -48 -> 149
      //   200: astore 5
      //   202: aconst_null
      //   203: astore 4
      //   205: aconst_null
      //   206: astore_0
      //   207: aload 4
      //   209: astore_3
      //   210: aload_0
      //   211: astore_2
      //   212: ldc 70
      //   214: aload 5
      //   216: ldc 72
      //   218: iconst_0
      //   219: anewarray 4	java/lang/Object
      //   222: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   225: aload_0
      //   226: ifnull +7 -> 233
      //   229: aload_0
      //   230: invokevirtual 65	com/tencent/mm/vfs/u:close	()V
      //   233: aload_1
      //   234: astore_0
      //   235: aload 4
      //   237: ifnull -162 -> 75
      //   240: aload 4
      //   242: invokevirtual 64	java/io/BufferedReader:close	()V
      //   245: aload_1
      //   246: astore_0
      //   247: goto -172 -> 75
      //   250: astore_0
      //   251: ldc 70
      //   253: aload_0
      //   254: ldc 72
      //   256: iconst_0
      //   257: anewarray 4	java/lang/Object
      //   260: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   263: aload_1
      //   264: astore_0
      //   265: goto -190 -> 75
      //   268: astore_0
      //   269: ldc 70
      //   271: aload_0
      //   272: ldc 72
      //   274: iconst_0
      //   275: anewarray 4	java/lang/Object
      //   278: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   281: goto -48 -> 233
      //   284: astore_1
      //   285: aconst_null
      //   286: astore_3
      //   287: aconst_null
      //   288: astore_0
      //   289: aload_0
      //   290: ifnull +7 -> 297
      //   293: aload_0
      //   294: invokevirtual 65	com/tencent/mm/vfs/u:close	()V
      //   297: aload_3
      //   298: ifnull +7 -> 305
      //   301: aload_3
      //   302: invokevirtual 64	java/io/BufferedReader:close	()V
      //   305: ldc 33
      //   307: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   310: aload_1
      //   311: athrow
      //   312: astore_0
      //   313: ldc 70
      //   315: aload_0
      //   316: ldc 72
      //   318: iconst_0
      //   319: anewarray 4	java/lang/Object
      //   322: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   325: goto -28 -> 297
      //   328: astore_0
      //   329: ldc 70
      //   331: aload_0
      //   332: ldc 72
      //   334: iconst_0
      //   335: anewarray 4	java/lang/Object
      //   338: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   341: goto -36 -> 305
      //   344: astore_1
      //   345: aconst_null
      //   346: astore_3
      //   347: goto -58 -> 289
      //   350: astore_1
      //   351: aload_2
      //   352: astore_0
      //   353: goto -64 -> 289
      //   356: astore 5
      //   358: aconst_null
      //   359: astore 4
      //   361: goto -154 -> 207
      //   364: astore_2
      //   365: aload 5
      //   367: astore_1
      //   368: aload_2
      //   369: astore 5
      //   371: goto -164 -> 207
      //   374: astore 5
      //   376: aconst_null
      //   377: astore 4
      //   379: goto -256 -> 123
      //   382: astore 5
      //   384: aload 6
      //   386: astore_1
      //   387: goto -264 -> 123
      // Local variable table:
      //   start	length	slot	name	signature
      //   17	64	0	localObject1	Object
      //   82	4	0	localIOException1	java.io.IOException
      //   98	4	0	localIOException2	java.io.IOException
      //   112	51	0	str1	String
      //   166	4	0	localIOException3	java.io.IOException
      //   180	1	0	str2	String
      //   184	4	0	localIOException4	java.io.IOException
      //   206	41	0	str3	String
      //   250	4	0	localIOException5	java.io.IOException
      //   264	1	0	str4	String
      //   268	4	0	localIOException6	java.io.IOException
      //   288	6	0	localObject2	Object
      //   312	4	0	localIOException7	java.io.IOException
      //   328	4	0	localIOException8	java.io.IOException
      //   352	1	0	localObject3	Object
      //   7	257	1	str5	String
      //   284	27	1	localObject4	Object
      //   344	1	1	localObject5	Object
      //   350	1	1	localObject6	Object
      //   367	20	1	localObject7	Object
      //   32	320	2	localObject8	Object
      //   364	5	2	localIOException9	java.io.IOException
      //   30	317	3	localBufferedReader1	java.io.BufferedReader
      //   26	352	4	localBufferedReader2	java.io.BufferedReader
      //   34	21	5	str6	String
      //   116	15	5	localFileNotFoundException1	java.io.FileNotFoundException
      //   200	15	5	localIOException10	java.io.IOException
      //   356	10	5	localIOException11	java.io.IOException
      //   369	1	5	localIOException12	java.io.IOException
      //   374	1	5	localFileNotFoundException2	java.io.FileNotFoundException
      //   382	1	5	localFileNotFoundException3	java.io.FileNotFoundException
      //   37	348	6	str7	String
      // Exception table:
      //   from	to	target	type
      //   64	68	82	java/io/IOException
      //   68	73	98	java/io/IOException
      //   8	18	116	java/io/FileNotFoundException
      //   156	161	166	java/io/IOException
      //   145	149	184	java/io/IOException
      //   8	18	200	java/io/IOException
      //   240	245	250	java/io/IOException
      //   229	233	268	java/io/IOException
      //   8	18	284	finally
      //   293	297	312	java/io/IOException
      //   301	305	328	java/io/IOException
      //   18	28	344	finally
      //   39	48	350	finally
      //   59	64	350	finally
      //   128	141	350	finally
      //   212	225	350	finally
      //   18	28	356	java/io/IOException
      //   39	48	364	java/io/IOException
      //   59	64	364	java/io/IOException
      //   18	28	374	java/io/FileNotFoundException
      //   39	48	382	java/io/FileNotFoundException
      //   59	64	382	java/io/FileNotFoundException
    }
    
    public static a eOH()
    {
      try
      {
        AppMethodBeat.i(143854);
        if (CyE == null)
        {
          locala = new a();
          CyE = locala;
          locala.CyB = getNumCores();
          CyE.CyC = aop();
          locala = CyE;
          Object localObject2 = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
          ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
          ((ActivityManager)localObject2).getMemoryInfo(localMemoryInfo);
          locala.CyD = (localMemoryInfo.availMem >> 10);
          locala = CyE;
          localObject2 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
          long l1 = ((StatFs)localObject2).getBlockSize();
          long l2 = ((StatFs)localObject2).getBlockCount();
          localObject2 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
          locala.CyA = new long[] { l2 * l1, ((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks() };
          CyE.hasInit = true;
        }
        a locala = CyE;
        AppMethodBeat.o(143854);
        return locala;
      }
      finally {}
    }
    
    private static int getNumCores()
    {
      AppMethodBeat.i(143856);
      try
      {
        int i = new o("/sys/devices/system/cpu/").a(new a()).length;
        AppMethodBeat.o(143856);
        return i;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ReportLogInfo", localException, "", new Object[0]);
        AppMethodBeat.o(143856);
      }
      return 1;
    }
    
    final class a
      implements q
    {
      public final boolean accept(o paramo)
      {
        AppMethodBeat.i(176169);
        if (Pattern.matches("cpu[0-9]", paramo.getName()))
        {
          AppMethodBeat.o(176169);
          return true;
        }
        AppMethodBeat.o(176169);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g
 * JD-Core Version:    0.7.0.1
 */