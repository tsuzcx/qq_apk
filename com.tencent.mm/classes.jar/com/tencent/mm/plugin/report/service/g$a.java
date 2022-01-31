package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

public final class g$a
{
  public static a qsT;
  public volatile boolean hasInit;
  public long[] qsP;
  public int qsQ;
  public String qsR;
  public long qsS;
  
  /* Error */
  private static String Lr()
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 39
    //   7: astore_1
    //   8: new 41	java/io/FileReader
    //   11: dup
    //   12: ldc 43
    //   14: invokespecial 46	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 48	java/io/BufferedReader
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 51	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
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
    //   41: invokevirtual 54	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: invokevirtual 59	java/lang/String:trim	()Ljava/lang/String;
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
    //   61: invokevirtual 62	java/io/BufferedReader:close	()V
    //   64: aload_0
    //   65: invokevirtual 63	java/io/FileReader:close	()V
    //   68: aload 4
    //   70: invokevirtual 62	java/io/BufferedReader:close	()V
    //   73: aload_1
    //   74: astore_0
    //   75: ldc 31
    //   77: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: areturn
    //   82: astore_0
    //   83: ldc 68
    //   85: aload_0
    //   86: ldc 70
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -27 -> 68
    //   98: astore_0
    //   99: ldc 68
    //   101: aload_0
    //   102: ldc 70
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   128: ldc 68
    //   130: aload 5
    //   132: ldc 70
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 63	java/io/FileReader:close	()V
    //   149: aload_1
    //   150: astore_0
    //   151: aload 4
    //   153: ifnull -78 -> 75
    //   156: aload 4
    //   158: invokevirtual 62	java/io/BufferedReader:close	()V
    //   161: aload_1
    //   162: astore_0
    //   163: goto -88 -> 75
    //   166: astore_0
    //   167: ldc 68
    //   169: aload_0
    //   170: ldc 70
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_1
    //   180: astore_0
    //   181: goto -106 -> 75
    //   184: astore_0
    //   185: ldc 68
    //   187: aload_0
    //   188: ldc 70
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   212: ldc 68
    //   214: aload 5
    //   216: ldc 70
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_0
    //   226: ifnull +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 63	java/io/FileReader:close	()V
    //   233: aload_1
    //   234: astore_0
    //   235: aload 4
    //   237: ifnull -162 -> 75
    //   240: aload 4
    //   242: invokevirtual 62	java/io/BufferedReader:close	()V
    //   245: aload_1
    //   246: astore_0
    //   247: goto -172 -> 75
    //   250: astore_0
    //   251: ldc 68
    //   253: aload_0
    //   254: ldc 70
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_1
    //   264: astore_0
    //   265: goto -190 -> 75
    //   268: astore_0
    //   269: ldc 68
    //   271: aload_0
    //   272: ldc 70
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: goto -48 -> 233
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_3
    //   287: aconst_null
    //   288: astore_0
    //   289: aload_0
    //   290: ifnull +7 -> 297
    //   293: aload_0
    //   294: invokevirtual 63	java/io/FileReader:close	()V
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 62	java/io/BufferedReader:close	()V
    //   305: ldc 31
    //   307: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload_1
    //   311: athrow
    //   312: astore_0
    //   313: ldc 68
    //   315: aload_0
    //   316: ldc 70
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -28 -> 297
    //   328: astore_0
    //   329: ldc 68
    //   331: aload_0
    //   332: ldc 70
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static a chR()
  {
    try
    {
      AppMethodBeat.i(72741);
      if (qsT == null)
      {
        locala = new a();
        qsT = locala;
        locala.qsQ = getNumCores();
        qsT.qsR = Lr();
        locala = qsT;
        Object localObject2 = (ActivityManager)ah.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject2).getMemoryInfo(localMemoryInfo);
        locala.qsS = (localMemoryInfo.availMem >> 10);
        locala = qsT;
        localObject2 = new StatFs(h.getDataDirectory().getPath());
        long l1 = ((StatFs)localObject2).getBlockSize();
        long l2 = ((StatFs)localObject2).getBlockCount();
        localObject2 = new StatFs(h.getDataDirectory().getPath());
        long l3 = ((StatFs)localObject2).getBlockSize();
        locala.qsP = new long[] { l2 * l1, ((StatFs)localObject2).getAvailableBlocks() * l3 };
        qsT.hasInit = true;
      }
      a locala = qsT;
      AppMethodBeat.o(72741);
      return locala;
    }
    finally {}
  }
  
  private static int getNumCores()
  {
    AppMethodBeat.i(72743);
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new g.a.a()).length;
      AppMethodBeat.o(72743);
      return i;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.ReportLogInfo", localException, "", new Object[0]);
      AppMethodBeat.o(72743);
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g.a
 * JD-Core Version:    0.7.0.1
 */