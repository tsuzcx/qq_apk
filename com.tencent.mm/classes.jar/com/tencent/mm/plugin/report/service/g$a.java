package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.StatFs;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class g$a
{
  public static a nFP;
  public volatile boolean hasInit;
  public long[] nFL;
  public int nFM;
  public String nFN;
  public long nFO;
  
  public static a bwY()
  {
    try
    {
      if (nFP == null)
      {
        locala = new a();
        nFP = locala;
        locala.nFM = getNumCores();
        nFP.nFN = yU();
        locala = nFP;
        Object localObject2 = (ActivityManager)ae.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject2).getMemoryInfo(localMemoryInfo);
        locala.nFO = (localMemoryInfo.availMem >> 10);
        locala = nFP;
        localObject2 = new StatFs(h.getDataDirectory().getPath());
        long l1 = ((StatFs)localObject2).getBlockSize();
        long l2 = ((StatFs)localObject2).getBlockCount();
        localObject2 = new StatFs(h.getDataDirectory().getPath());
        long l3 = ((StatFs)localObject2).getBlockSize();
        locala.nFL = new long[] { l2 * l1, ((StatFs)localObject2).getAvailableBlocks() * l3 };
        nFP.hasInit = true;
      }
      a locala = nFP;
      return locala;
    }
    finally {}
  }
  
  private static int getNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new g.a.a()).length;
      return i;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ReportLogInfo", localException, "", new Object[0]);
    }
    return 1;
  }
  
  /* Error */
  private static String yU()
  {
    // Byte code:
    //   0: ldc 126
    //   2: astore_1
    //   3: new 128	java/io/FileReader
    //   6: dup
    //   7: ldc 130
    //   9: invokespecial 131	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 133	java/io/BufferedReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_0
    //   27: astore_2
    //   28: aload_1
    //   29: astore 5
    //   31: aload_1
    //   32: astore 6
    //   34: aload 4
    //   36: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload 4
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_1
    //   49: astore 5
    //   51: aload_1
    //   52: astore 6
    //   54: aload 4
    //   56: invokevirtual 147	java/io/BufferedReader:close	()V
    //   59: aload_0
    //   60: invokevirtual 148	java/io/FileReader:close	()V
    //   63: aload 4
    //   65: invokevirtual 147	java/io/BufferedReader:close	()V
    //   68: aload_1
    //   69: astore_0
    //   70: aload_0
    //   71: areturn
    //   72: astore_0
    //   73: ldc 112
    //   75: aload_0
    //   76: ldc 114
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: goto -22 -> 63
    //   88: astore_0
    //   89: ldc 112
    //   91: aload_0
    //   92: ldc 114
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_1
    //   102: areturn
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_0
    //   110: aload 4
    //   112: astore_3
    //   113: aload_0
    //   114: astore_2
    //   115: ldc 112
    //   117: aload 5
    //   119: ldc 114
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 148	java/io/FileReader:close	()V
    //   136: aload_1
    //   137: astore_0
    //   138: aload 4
    //   140: ifnull -70 -> 70
    //   143: aload 4
    //   145: invokevirtual 147	java/io/BufferedReader:close	()V
    //   148: aload_1
    //   149: areturn
    //   150: astore_0
    //   151: ldc 112
    //   153: aload_0
    //   154: ldc 114
    //   156: iconst_0
    //   157: anewarray 4	java/lang/Object
    //   160: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_1
    //   164: areturn
    //   165: astore_0
    //   166: ldc 112
    //   168: aload_0
    //   169: ldc 114
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -42 -> 136
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_0
    //   188: aload 4
    //   190: astore_3
    //   191: aload_0
    //   192: astore_2
    //   193: ldc 112
    //   195: aload 5
    //   197: ldc 114
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload_0
    //   207: ifnull +7 -> 214
    //   210: aload_0
    //   211: invokevirtual 148	java/io/FileReader:close	()V
    //   214: aload_1
    //   215: astore_0
    //   216: aload 4
    //   218: ifnull -148 -> 70
    //   221: aload 4
    //   223: invokevirtual 147	java/io/BufferedReader:close	()V
    //   226: aload_1
    //   227: areturn
    //   228: astore_0
    //   229: ldc 112
    //   231: aload_0
    //   232: ldc 114
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload_1
    //   242: areturn
    //   243: astore_0
    //   244: ldc 112
    //   246: aload_0
    //   247: ldc 114
    //   249: iconst_0
    //   250: anewarray 4	java/lang/Object
    //   253: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: goto -42 -> 214
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 148	java/io/FileReader:close	()V
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 147	java/io/BufferedReader:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_0
    //   283: ldc 112
    //   285: aload_0
    //   286: ldc 114
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: goto -23 -> 272
    //   298: astore_0
    //   299: ldc 112
    //   301: aload_0
    //   302: ldc 114
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 120	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: goto -31 -> 280
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_3
    //   317: goto -53 -> 264
    //   320: astore_1
    //   321: aload_2
    //   322: astore_0
    //   323: goto -59 -> 264
    //   326: astore 5
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -143 -> 188
    //   334: astore_2
    //   335: aload 5
    //   337: astore_1
    //   338: aload_2
    //   339: astore 5
    //   341: goto -153 -> 188
    //   344: astore 5
    //   346: aconst_null
    //   347: astore 4
    //   349: goto -239 -> 110
    //   352: astore 5
    //   354: aload 6
    //   356: astore_1
    //   357: goto -247 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	59	0	localObject1	Object
    //   72	4	0	localIOException1	java.io.IOException
    //   88	4	0	localIOException2	java.io.IOException
    //   109	29	0	str1	String
    //   150	4	0	localIOException3	java.io.IOException
    //   165	4	0	localIOException4	java.io.IOException
    //   187	29	0	str2	String
    //   228	4	0	localIOException5	java.io.IOException
    //   243	4	0	localIOException6	java.io.IOException
    //   263	6	0	localObject2	Object
    //   282	4	0	localIOException7	java.io.IOException
    //   298	4	0	localIOException8	java.io.IOException
    //   322	1	0	localObject3	Object
    //   2	240	1	str3	String
    //   259	22	1	localObject4	Object
    //   314	1	1	localObject5	Object
    //   320	1	1	localObject6	Object
    //   337	20	1	localObject7	Object
    //   27	295	2	localObject8	Object
    //   334	5	2	localIOException9	java.io.IOException
    //   25	292	3	localBufferedReader1	java.io.BufferedReader
    //   21	327	4	localBufferedReader2	java.io.BufferedReader
    //   29	21	5	str4	String
    //   103	15	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   181	15	5	localIOException10	java.io.IOException
    //   326	10	5	localIOException11	java.io.IOException
    //   339	1	5	localIOException12	java.io.IOException
    //   344	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   352	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   32	323	6	str5	String
    // Exception table:
    //   from	to	target	type
    //   59	63	72	java/io/IOException
    //   63	68	88	java/io/IOException
    //   3	13	103	java/io/FileNotFoundException
    //   143	148	150	java/io/IOException
    //   132	136	165	java/io/IOException
    //   3	13	181	java/io/IOException
    //   221	226	228	java/io/IOException
    //   210	214	243	java/io/IOException
    //   3	13	259	finally
    //   268	272	282	java/io/IOException
    //   276	280	298	java/io/IOException
    //   13	23	314	finally
    //   34	43	320	finally
    //   54	59	320	finally
    //   115	128	320	finally
    //   193	206	320	finally
    //   13	23	326	java/io/IOException
    //   34	43	334	java/io/IOException
    //   54	59	334	java/io/IOException
    //   13	23	344	java/io/FileNotFoundException
    //   34	43	352	java/io/FileNotFoundException
    //   54	59	352	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g.a
 * JD-Core Version:    0.7.0.1
 */