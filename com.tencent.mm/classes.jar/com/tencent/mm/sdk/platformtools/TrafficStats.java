package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStats.Bucket;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;

public final class TrafficStats
{
  private static long CURRENT_TIMESTAMP = 0L;
  public static final String DEV_FILE = "/proc/self/net/dev";
  public static final String GPRSLINE = "rmnet0";
  private static q NET_DEV_FILE;
  private static final String TAG = "MicroMsg.SDK.TrafficStats";
  public static final String WIFILINE = "tiwlan0";
  private static q XT_STATS_FILE;
  private static long lastMobileRx;
  private static long lastMobileTx;
  private static long lastWifiRx;
  private static long lastWifiTx;
  private static long lastWxMobileRx;
  private static long lastWxMobileTx;
  private static long lastWxWifiRx;
  private static long lastWxWifiTx;
  private static long mobileRx;
  private static long mobileTx;
  private static long wifiRx;
  private static long wifiTx;
  private static long wxMobileRx;
  private static long wxMobileTx;
  private static long wxWifiRx;
  private static long wxWifiTx;
  
  static
  {
    AppMethodBeat.i(157851);
    for (;;)
    {
      try
      {
        localq = new q("/proc/" + Process.myPid() + "/net/dev");
        if (localq.ifH()) {
          NET_DEV_FILE = localq;
        }
      }
      catch (Exception localException1)
      {
        q localq;
        Log.printErrStackTrace("MicroMsg.SDK.TrafficStats", localException1, "Failed init NET_DEV_FILE.", new Object[0]);
        continue;
        Object localObject = null;
        continue;
      }
      try
      {
        localq = new q("/proc/net/xt_qtaguid/stats");
        if (!localq.ifH()) {
          continue;
        }
        XT_STATS_FILE = localq;
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.SDK.TrafficStats", localException2, "Failed init XT_STATS_FILE.", new Object[0]);
        continue;
      }
      CURRENT_TIMESTAMP = System.currentTimeMillis();
      AppMethodBeat.o(157851);
      return;
      localq = null;
    }
  }
  
  private static boolean checkIfFrequently()
  {
    AppMethodBeat.i(182968);
    if (System.currentTimeMillis() - CURRENT_TIMESTAMP < 2000L)
    {
      AppMethodBeat.o(182968);
      return true;
    }
    CURRENT_TIMESTAMP = System.currentTimeMillis();
    AppMethodBeat.o(182968);
    return false;
  }
  
  public static long getMobileRx(long paramLong)
  {
    long l = paramLong;
    if (mobileRx > paramLong) {
      l = mobileRx;
    }
    return l;
  }
  
  public static long getMobileTx(long paramLong)
  {
    long l = paramLong;
    if (mobileTx > paramLong) {
      l = mobileTx;
    }
    return l;
  }
  
  public static long getWifiRx(long paramLong)
  {
    long l = paramLong;
    if (wifiRx > paramLong) {
      l = wifiRx;
    }
    return l;
  }
  
  public static long getWifiTx(long paramLong)
  {
    long l = paramLong;
    if (wifiTx > paramLong) {
      l = wifiTx;
    }
    return l;
  }
  
  public static long getWxMobileRx(long paramLong)
  {
    long l = paramLong;
    if (wxMobileRx > paramLong) {
      l = wxMobileRx;
    }
    return l;
  }
  
  public static long getWxMobileTx(long paramLong)
  {
    long l = paramLong;
    if (wxMobileTx > paramLong) {
      l = wxMobileTx;
    }
    return l;
  }
  
  public static long getWxWifiRx(long paramLong)
  {
    long l = paramLong;
    if (wxWifiRx > paramLong) {
      l = wxWifiRx;
    }
    return l;
  }
  
  public static long getWxWifiTx(long paramLong)
  {
    long l = paramLong;
    if (wxWifiTx > paramLong) {
      l = wxWifiTx;
    }
    return l;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(157847);
    lastMobileTx = -1L;
    lastMobileRx = -1L;
    lastWifiTx = -1L;
    lastWifiRx = -1L;
    lastWxMobileRx = -1L;
    lastWxMobileTx = -1L;
    lastWxWifiRx = -1L;
    lastWxWifiTx = -1L;
    updateFile();
    AppMethodBeat.o(157847);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(186473);
    lastMobileTx = -1L;
    lastMobileRx = -1L;
    lastWifiTx = -1L;
    lastWifiRx = -1L;
    lastWxMobileRx = -1L;
    lastWxMobileTx = -1L;
    lastWxWifiRx = -1L;
    lastWxWifiTx = -1L;
    if (Build.VERSION.SDK_INT >= 28)
    {
      updateNsm(paramContext);
      AppMethodBeat.o(186473);
      return;
    }
    updateFile();
    AppMethodBeat.o(186473);
  }
  
  public static void update()
  {
    AppMethodBeat.i(157850);
    updateFile();
    AppMethodBeat.o(157850);
  }
  
  public static void update(String paramString, Context paramContext)
  {
    AppMethodBeat.i(186485);
    if (Build.VERSION.SDK_INT >= 28)
    {
      updateNsm(paramContext);
      AppMethodBeat.o(186485);
      return;
    }
    updateFile();
    AppMethodBeat.o(186485);
  }
  
  /* Error */
  public static void updateFile()
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 185	com/tencent/mm/sdk/platformtools/TrafficStats:checkIfFrequently	()Z
    //   8: ifeq +16 -> 24
    //   11: ldc 20
    //   13: ldc 187
    //   15: invokestatic 190	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 183
    //   20: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: lconst_0
    //   25: lstore_3
    //   26: lconst_0
    //   27: lstore_1
    //   28: lconst_0
    //   29: lstore 7
    //   31: lconst_0
    //   32: lstore 13
    //   34: lconst_0
    //   35: lstore 11
    //   37: aconst_null
    //   38: astore 16
    //   40: getstatic 87	com/tencent/mm/sdk/platformtools/TrafficStats:NET_DEV_FILE	Lcom/tencent/mm/vfs/q;
    //   43: astore 17
    //   45: aload 17
    //   47: ifnull +471 -> 518
    //   50: new 192	java/io/BufferedReader
    //   53: dup
    //   54: new 194	com/tencent/mm/vfs/x
    //   57: dup
    //   58: getstatic 87	com/tencent/mm/sdk/platformtools/TrafficStats:NET_DEV_FILE	Lcom/tencent/mm/vfs/q;
    //   61: invokespecial 197	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   64: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 17
    //   69: aload 17
    //   71: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: pop
    //   75: aload 17
    //   77: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: pop
    //   81: lconst_0
    //   82: lstore 5
    //   84: aload 17
    //   86: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 16
    //   91: aload 16
    //   93: ifnull +126 -> 219
    //   96: aload 16
    //   98: ldc 205
    //   100: invokevirtual 211	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore 16
    //   105: aload 16
    //   107: iconst_0
    //   108: aaload
    //   109: invokevirtual 214	java/lang/String:length	()I
    //   112: ifne +923 -> 1035
    //   115: iconst_1
    //   116: istore_0
    //   117: aload 16
    //   119: iload_0
    //   120: iconst_0
    //   121: iadd
    //   122: aaload
    //   123: ldc 216
    //   125: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifne -44 -> 84
    //   131: aload 16
    //   133: iload_0
    //   134: iconst_0
    //   135: iadd
    //   136: aaload
    //   137: ldc 222
    //   139: invokevirtual 226	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifne +17 -> 159
    //   145: aload 16
    //   147: iload_0
    //   148: iconst_0
    //   149: iadd
    //   150: aaload
    //   151: ldc 228
    //   153: invokevirtual 226	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +31 -> 187
    //   159: lload_3
    //   160: aload 16
    //   162: iload_0
    //   163: bipush 9
    //   165: iadd
    //   166: aaload
    //   167: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   170: ladd
    //   171: lstore_3
    //   172: lload_1
    //   173: aload 16
    //   175: iload_0
    //   176: iconst_1
    //   177: iadd
    //   178: aaload
    //   179: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   182: ladd
    //   183: lstore_1
    //   184: goto -100 -> 84
    //   187: lload 7
    //   189: aload 16
    //   191: iload_0
    //   192: bipush 9
    //   194: iadd
    //   195: aaload
    //   196: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   199: ladd
    //   200: lstore 7
    //   202: lload 5
    //   204: aload 16
    //   206: iload_0
    //   207: iconst_1
    //   208: iadd
    //   209: aaload
    //   210: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: ladd
    //   214: lstore 5
    //   216: goto -132 -> 84
    //   219: getstatic 150	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileTx	J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifge +25 -> 249
    //   227: lload_3
    //   228: putstatic 150	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileTx	J
    //   231: ldc 20
    //   233: ldc 236
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: lload_3
    //   242: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   245: aastore
    //   246: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: getstatic 152	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileRx	J
    //   252: lconst_0
    //   253: lcmp
    //   254: ifge +25 -> 279
    //   257: lload_1
    //   258: putstatic 152	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileRx	J
    //   261: ldc 20
    //   263: ldc 246
    //   265: iconst_1
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: lload_1
    //   272: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: getstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   282: lconst_0
    //   283: lcmp
    //   284: ifge +27 -> 311
    //   287: lload 7
    //   289: putstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   292: ldc 20
    //   294: ldc 248
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: lload 7
    //   304: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   307: aastore
    //   308: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: getstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   314: lconst_0
    //   315: lcmp
    //   316: ifge +27 -> 343
    //   319: lload 5
    //   321: putstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   324: ldc 20
    //   326: ldc 250
    //   328: iconst_1
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: lload 5
    //   336: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   339: aastore
    //   340: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: lload 5
    //   345: getstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   348: lsub
    //   349: lconst_0
    //   350: lcmp
    //   351: ifge +26 -> 377
    //   354: ldc 20
    //   356: ldc 252
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: lload 5
    //   366: getstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   369: lsub
    //   370: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aastore
    //   374: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: lload 7
    //   379: getstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   382: lsub
    //   383: lconst_0
    //   384: lcmp
    //   385: ifge +26 -> 411
    //   388: ldc 20
    //   390: ldc 252
    //   392: iconst_1
    //   393: anewarray 4	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: lload 7
    //   400: getstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   403: lsub
    //   404: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: lload_3
    //   412: getstatic 150	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileTx	J
    //   415: lcmp
    //   416: iflt +251 -> 667
    //   419: lload_3
    //   420: getstatic 150	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileTx	J
    //   423: lsub
    //   424: lstore 9
    //   426: lload 9
    //   428: putstatic 126	com/tencent/mm/sdk/platformtools/TrafficStats:mobileTx	J
    //   431: lload_1
    //   432: getstatic 152	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileRx	J
    //   435: lcmp
    //   436: iflt +237 -> 673
    //   439: lload_1
    //   440: getstatic 152	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileRx	J
    //   443: lsub
    //   444: lstore 9
    //   446: lload 9
    //   448: putstatic 123	com/tencent/mm/sdk/platformtools/TrafficStats:mobileRx	J
    //   451: lload 7
    //   453: getstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   456: lcmp
    //   457: iflt +222 -> 679
    //   460: lload 7
    //   462: getstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   465: lsub
    //   466: lstore 9
    //   468: lload 9
    //   470: putstatic 132	com/tencent/mm/sdk/platformtools/TrafficStats:wifiTx	J
    //   473: lload 5
    //   475: getstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   478: lcmp
    //   479: iflt +207 -> 686
    //   482: lload 5
    //   484: getstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   487: lsub
    //   488: lstore 9
    //   490: lload 9
    //   492: putstatic 129	com/tencent/mm/sdk/platformtools/TrafficStats:wifiRx	J
    //   495: lload_3
    //   496: putstatic 150	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileTx	J
    //   499: lload_1
    //   500: putstatic 152	com/tencent/mm/sdk/platformtools/TrafficStats:lastMobileRx	J
    //   503: lload 7
    //   505: putstatic 154	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiTx	J
    //   508: lload 5
    //   510: putstatic 156	com/tencent/mm/sdk/platformtools/TrafficStats:lastWifiRx	J
    //   513: aload 17
    //   515: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   518: aconst_null
    //   519: astore 18
    //   521: getstatic 91	com/tencent/mm/sdk/platformtools/TrafficStats:XT_STATS_FILE	Lcom/tencent/mm/vfs/q;
    //   524: astore 16
    //   526: aload 16
    //   528: ifnull +204 -> 732
    //   531: invokestatic 261	android/os/Process:myUid	()I
    //   534: istore_0
    //   535: new 192	java/io/BufferedReader
    //   538: dup
    //   539: new 194	com/tencent/mm/vfs/x
    //   542: dup
    //   543: getstatic 91	com/tencent/mm/sdk/platformtools/TrafficStats:XT_STATS_FILE	Lcom/tencent/mm/vfs/q;
    //   546: invokespecial 197	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   549: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   552: astore 17
    //   554: aload 17
    //   556: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   559: pop
    //   560: lconst_0
    //   561: lstore 7
    //   563: lconst_0
    //   564: lstore 5
    //   566: lload 13
    //   568: lstore_1
    //   569: lload 11
    //   571: lstore_3
    //   572: aload 17
    //   574: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   577: astore 16
    //   579: aload 16
    //   581: ifnull +271 -> 852
    //   584: aload 16
    //   586: ldc_w 263
    //   589: invokevirtual 211	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   592: astore 16
    //   594: aload 16
    //   596: iconst_3
    //   597: aaload
    //   598: invokestatic 269	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   601: iload_0
    //   602: if_icmpne -30 -> 572
    //   605: aload 16
    //   607: iconst_1
    //   608: aaload
    //   609: astore 18
    //   611: aload 16
    //   613: iconst_5
    //   614: aaload
    //   615: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   618: lstore 11
    //   620: aload 16
    //   622: bipush 7
    //   624: aaload
    //   625: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   628: lstore 9
    //   630: aload 18
    //   632: ldc 222
    //   634: invokevirtual 226	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   637: ifne +17 -> 654
    //   640: aload 18
    //   642: ldc 228
    //   644: invokevirtual 226	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   647: istore 15
    //   649: iload 15
    //   651: ifeq +174 -> 825
    //   654: lload_3
    //   655: lload 11
    //   657: ladd
    //   658: lstore_3
    //   659: lload_1
    //   660: lload 9
    //   662: ladd
    //   663: lstore_1
    //   664: goto -92 -> 572
    //   667: lload_3
    //   668: lstore 9
    //   670: goto -244 -> 426
    //   673: lload_1
    //   674: lstore 9
    //   676: goto -230 -> 446
    //   679: lload 7
    //   681: lstore 9
    //   683: goto -215 -> 468
    //   686: lload 5
    //   688: lstore 9
    //   690: goto -200 -> 490
    //   693: astore 18
    //   695: aload 16
    //   697: astore 17
    //   699: aload 18
    //   701: astore 16
    //   703: aload 17
    //   705: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   708: ldc 183
    //   710: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   713: aload 16
    //   715: athrow
    //   716: astore 16
    //   718: ldc 20
    //   720: aload 16
    //   722: ldc_w 271
    //   725: iconst_0
    //   726: anewarray 4	java/lang/Object
    //   729: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   732: ldc 20
    //   734: ldc_w 273
    //   737: bipush 8
    //   739: anewarray 4	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: getstatic 129	com/tencent/mm/sdk/platformtools/TrafficStats:wifiRx	J
    //   747: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   750: aastore
    //   751: dup
    //   752: iconst_1
    //   753: getstatic 132	com/tencent/mm/sdk/platformtools/TrafficStats:wifiTx	J
    //   756: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   759: aastore
    //   760: dup
    //   761: iconst_2
    //   762: getstatic 123	com/tencent/mm/sdk/platformtools/TrafficStats:mobileRx	J
    //   765: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   768: aastore
    //   769: dup
    //   770: iconst_3
    //   771: getstatic 126	com/tencent/mm/sdk/platformtools/TrafficStats:mobileTx	J
    //   774: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   777: aastore
    //   778: dup
    //   779: iconst_4
    //   780: getstatic 141	com/tencent/mm/sdk/platformtools/TrafficStats:wxWifiRx	J
    //   783: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   786: aastore
    //   787: dup
    //   788: iconst_5
    //   789: getstatic 144	com/tencent/mm/sdk/platformtools/TrafficStats:wxWifiTx	J
    //   792: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   795: aastore
    //   796: dup
    //   797: bipush 6
    //   799: getstatic 135	com/tencent/mm/sdk/platformtools/TrafficStats:wxMobileRx	J
    //   802: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   805: aastore
    //   806: dup
    //   807: bipush 7
    //   809: getstatic 138	com/tencent/mm/sdk/platformtools/TrafficStats:wxMobileTx	J
    //   812: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   815: aastore
    //   816: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   819: ldc 183
    //   821: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   824: return
    //   825: aload 18
    //   827: ldc 216
    //   829: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   832: ifne -260 -> 572
    //   835: lload 7
    //   837: lload 11
    //   839: ladd
    //   840: lstore 7
    //   842: lload 5
    //   844: lload 9
    //   846: ladd
    //   847: lstore 5
    //   849: goto -277 -> 572
    //   852: getstatic 158	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileRx	J
    //   855: lconst_0
    //   856: lcmp
    //   857: ifge +7 -> 864
    //   860: lload_3
    //   861: putstatic 158	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileRx	J
    //   864: getstatic 160	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileTx	J
    //   867: lconst_0
    //   868: lcmp
    //   869: ifge +7 -> 876
    //   872: lload_1
    //   873: putstatic 160	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileTx	J
    //   876: getstatic 162	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiRx	J
    //   879: lconst_0
    //   880: lcmp
    //   881: ifge +8 -> 889
    //   884: lload 7
    //   886: putstatic 162	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiRx	J
    //   889: getstatic 164	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiTx	J
    //   892: lconst_0
    //   893: lcmp
    //   894: ifge +8 -> 902
    //   897: lload 5
    //   899: putstatic 164	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiTx	J
    //   902: lload_1
    //   903: getstatic 160	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileTx	J
    //   906: lcmp
    //   907: iflt +133 -> 1040
    //   910: lload_1
    //   911: getstatic 160	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileTx	J
    //   914: lsub
    //   915: lstore 9
    //   917: lload 9
    //   919: putstatic 138	com/tencent/mm/sdk/platformtools/TrafficStats:wxMobileTx	J
    //   922: lload_3
    //   923: getstatic 158	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileRx	J
    //   926: lcmp
    //   927: iflt +119 -> 1046
    //   930: lload_3
    //   931: getstatic 158	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileRx	J
    //   934: lsub
    //   935: lstore 9
    //   937: lload 9
    //   939: putstatic 135	com/tencent/mm/sdk/platformtools/TrafficStats:wxMobileRx	J
    //   942: lload 5
    //   944: getstatic 164	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiTx	J
    //   947: lcmp
    //   948: iflt +104 -> 1052
    //   951: lload 5
    //   953: getstatic 164	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiTx	J
    //   956: lsub
    //   957: lstore 9
    //   959: lload 9
    //   961: putstatic 144	com/tencent/mm/sdk/platformtools/TrafficStats:wxWifiTx	J
    //   964: lload 7
    //   966: getstatic 162	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiRx	J
    //   969: lcmp
    //   970: iflt +89 -> 1059
    //   973: lload 7
    //   975: getstatic 162	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiRx	J
    //   978: lsub
    //   979: lstore 9
    //   981: lload 9
    //   983: putstatic 141	com/tencent/mm/sdk/platformtools/TrafficStats:wxWifiRx	J
    //   986: lload_1
    //   987: putstatic 160	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileTx	J
    //   990: lload_3
    //   991: putstatic 158	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxMobileRx	J
    //   994: lload 5
    //   996: putstatic 164	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiTx	J
    //   999: lload 7
    //   1001: putstatic 162	com/tencent/mm/sdk/platformtools/TrafficStats:lastWxWifiRx	J
    //   1004: aload 17
    //   1006: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   1009: goto -277 -> 732
    //   1012: aload 17
    //   1014: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   1017: ldc 183
    //   1019: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1022: aload 16
    //   1024: athrow
    //   1025: astore 16
    //   1027: goto -15 -> 1012
    //   1030: astore 16
    //   1032: goto -329 -> 703
    //   1035: iconst_0
    //   1036: istore_0
    //   1037: goto -920 -> 117
    //   1040: lload_1
    //   1041: lstore 9
    //   1043: goto -126 -> 917
    //   1046: lload_3
    //   1047: lstore 9
    //   1049: goto -112 -> 937
    //   1052: lload 5
    //   1054: lstore 9
    //   1056: goto -97 -> 959
    //   1059: lload 7
    //   1061: lstore 9
    //   1063: goto -82 -> 981
    //   1066: astore 16
    //   1068: aload 18
    //   1070: astore 17
    //   1072: goto -60 -> 1012
    // Local variable table:
    //   start	length	slot	name	signature
    //   116	921	0	i	int
    //   27	1014	1	l1	long
    //   25	1022	3	l2	long
    //   82	971	5	l3	long
    //   29	1031	7	l4	long
    //   424	638	9	l5	long
    //   35	803	11	l6	long
    //   32	535	13	l7	long
    //   647	3	15	bool	boolean
    //   38	676	16	localObject1	Object
    //   716	307	16	localException	Exception
    //   1025	1	16	localObject2	Object
    //   1030	1	16	localObject3	Object
    //   1066	1	16	localObject4	Object
    //   43	1028	17	localObject5	Object
    //   519	122	18	localObject6	Object
    //   693	376	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   50	69	693	finally
    //   40	45	716	java/lang/Exception
    //   513	518	716	java/lang/Exception
    //   521	526	716	java/lang/Exception
    //   703	716	716	java/lang/Exception
    //   1004	1009	716	java/lang/Exception
    //   1012	1025	716	java/lang/Exception
    //   554	560	1025	finally
    //   572	579	1025	finally
    //   584	605	1025	finally
    //   611	649	1025	finally
    //   825	835	1025	finally
    //   852	864	1025	finally
    //   864	876	1025	finally
    //   876	889	1025	finally
    //   889	902	1025	finally
    //   902	917	1025	finally
    //   917	937	1025	finally
    //   937	959	1025	finally
    //   959	981	1025	finally
    //   981	1004	1025	finally
    //   69	81	1030	finally
    //   84	91	1030	finally
    //   96	115	1030	finally
    //   117	159	1030	finally
    //   159	184	1030	finally
    //   187	216	1030	finally
    //   219	249	1030	finally
    //   249	279	1030	finally
    //   279	311	1030	finally
    //   311	343	1030	finally
    //   343	377	1030	finally
    //   377	411	1030	finally
    //   411	426	1030	finally
    //   426	446	1030	finally
    //   446	468	1030	finally
    //   468	490	1030	finally
    //   490	513	1030	finally
    //   531	554	1066	finally
  }
  
  public static long updateMobileRx(long paramLong)
  {
    AppMethodBeat.i(186471);
    update();
    paramLong = getMobileRx(paramLong);
    AppMethodBeat.o(186471);
    return paramLong;
  }
  
  public static long updateMobileTx(long paramLong)
  {
    AppMethodBeat.i(186470);
    update();
    paramLong = getMobileTx(paramLong);
    AppMethodBeat.o(186470);
    return paramLong;
  }
  
  @TargetApi(23)
  public static void updateNsm(Context paramContext)
  {
    AppMethodBeat.i(186481);
    if (checkIfFrequently())
    {
      Log.i("MicroMsg.SDK.TrafficStats", "updateNsm frequently just return");
      AppMethodBeat.o(186481);
      return;
    }
    long l5 = 0L;
    l6 = 0L;
    Object localObject = (NetworkStatsManager)paramContext.getSystemService("netstats");
    if (localObject == null)
    {
      AppMethodBeat.o(186481);
      return;
    }
    paramContext = new NetworkStats.Bucket();
    l1 = l6;
    l2 = l5;
    for (;;)
    {
      try
      {
        NetworkStats localNetworkStats = ((NetworkStatsManager)localObject).querySummary(1, null, 0L, System.currentTimeMillis());
        l3 = 0L;
        l4 = 0L;
        l1 = l6;
        l2 = l5;
        if (localNetworkStats.hasNextBucket())
        {
          l1 = l6;
          l2 = l5;
          localNetworkStats.getNextBucket(paramContext);
          l1 = l6;
          l2 = l5;
          if (paramContext.getUid() != Process.myUid()) {
            continue;
          }
          l1 = l6;
          l2 = l5;
          l4 += paramContext.getRxBytes();
          l1 = l6;
          l2 = l5;
          l3 += paramContext.getTxBytes();
          continue;
        }
        l7 = 0L + l4;
        l8 = 0L + l3;
        l1 = l7;
        l2 = l8;
        localNetworkStats.close();
        l5 = 0L;
        l4 = 0L;
        l1 = l7;
        l2 = l8;
        localObject = ((NetworkStatsManager)localObject).querySummary(0, null, 0L, System.currentTimeMillis());
        l1 = l7;
        l2 = l8;
        if (((NetworkStats)localObject).hasNextBucket())
        {
          l1 = l7;
          l2 = l8;
          ((NetworkStats)localObject).getNextBucket(paramContext);
          l1 = l7;
          l2 = l8;
          if (paramContext.getUid() != Process.myUid()) {
            continue;
          }
          l1 = l7;
          l2 = l8;
          l5 += paramContext.getRxBytes();
          l1 = l7;
          l2 = l8;
          l3 = paramContext.getTxBytes();
          l4 += l3;
          continue;
        }
        Log.printErrStackTrace("MicroMsg.SDK.TrafficStats", paramContext, "Failed retrieving NsmTrafficStats.", new Object[0]);
      }
      catch (Exception paramContext)
      {
        try
        {
          ((NetworkStats)localObject).close();
          l1 = android.net.TrafficStats.getTotalRxBytes();
          l2 = android.net.TrafficStats.getMobileRxBytes();
          l15 = l1 - l2;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            long l4;
            long l7;
            long l8;
            long l11;
            long l12;
            long l13;
            long l14;
            l6 = 0L;
            l3 = 0L;
            l2 = 0L;
            l1 = 0L;
          }
        }
        try
        {
          l1 = android.net.TrafficStats.getTotalTxBytes();
          l2 = android.net.TrafficStats.getMobileTxBytes();
          l16 = l1 - l2;
        }
        catch (Exception paramContext)
        {
          l3 = 0L;
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          break label976;
        }
        try
        {
          l9 = android.net.TrafficStats.getMobileRxBytes();
        }
        catch (Exception paramContext)
        {
          l2 = 0L;
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          break label976;
        }
        try
        {
          l10 = android.net.TrafficStats.getMobileTxBytes();
        }
        catch (Exception paramContext)
        {
          l1 = 0L;
          l6 = l15;
          l3 = l16;
          l2 = l9;
          break label976;
        }
        try
        {
          if (lastMobileTx < 0L)
          {
            lastMobileTx = l10;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", new Object[] { Long.valueOf(l10) });
          }
          if (lastMobileRx < 0L)
          {
            lastMobileRx = l9;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", new Object[] { Long.valueOf(l9) });
          }
          if (lastWifiTx < 0L)
          {
            lastWifiTx = l16;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", new Object[] { Long.valueOf(l16) });
          }
          if (lastWifiRx < 0L)
          {
            lastWifiRx = l15;
            Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", new Object[] { Long.valueOf(l15) });
          }
          if (l15 - lastWifiRx < 0L) {
            Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l15 - lastWifiRx) });
          }
          l11 = l15;
          l12 = l16;
          l13 = l9;
          l14 = l10;
          l1 = l7;
          l2 = l8;
          l3 = l5;
          l6 = l4;
          if (l16 - lastWifiTx < 0L)
          {
            Log.v("MicroMsg.SDK.TrafficStats", "minu %d", new Object[] { Long.valueOf(l16 - lastWifiTx) });
            l6 = l4;
            l3 = l5;
            l2 = l8;
            l1 = l7;
            l14 = l10;
            l13 = l9;
            l12 = l16;
            l11 = l15;
          }
          if (l14 < lastMobileTx) {
            break label1020;
          }
          l4 = l14 - lastMobileTx;
          mobileTx = l4;
          if (l13 < lastMobileRx) {
            break label1026;
          }
          l4 = l13 - lastMobileRx;
          mobileRx = l4;
          if (l12 < lastWifiTx) {
            break label1032;
          }
          l4 = l12 - lastWifiTx;
          wifiTx = l4;
          if (l11 < lastWifiRx) {
            break label1038;
          }
          l4 = l11 - lastWifiRx;
          wifiRx = l4;
          lastMobileTx = l14;
          lastMobileRx = l13;
          lastWifiTx = l12;
          lastWifiRx = l11;
          if (lastWxMobileRx < 0L) {
            lastWxMobileRx = l3;
          }
          if (lastWxMobileTx < 0L) {
            lastWxMobileTx = l6;
          }
          if (lastWxWifiRx < 0L) {
            lastWxWifiRx = l1;
          }
          if (lastWxWifiTx < 0L) {
            lastWxWifiTx = l2;
          }
          if (l6 < lastWxMobileTx) {
            break label1044;
          }
          l4 = l6 - lastWxMobileTx;
          wxMobileTx = l4;
          if (l3 < lastWxMobileRx) {
            break label1051;
          }
          l4 = l3 - lastWxMobileRx;
          wxMobileRx = l4;
          if (l2 < lastWxWifiTx) {
            break label1058;
          }
          l4 = l2 - lastWxWifiTx;
          wxWifiTx = l4;
          if (l1 < lastWxWifiRx) {
            break label1064;
          }
          l4 = l1 - lastWxWifiRx;
          wxWifiRx = l4;
          lastWxMobileTx = l6;
          lastWxMobileRx = l3;
          lastWxWifiTx = l2;
          lastWxWifiRx = l1;
          Log.i("MicroMsg.SDK.TrafficStats", "updateNSm current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", new Object[] { Long.valueOf(wifiRx), Long.valueOf(wifiTx), Long.valueOf(mobileRx), Long.valueOf(mobileTx), Long.valueOf(wxWifiRx), Long.valueOf(wxWifiTx), Long.valueOf(wxMobileRx), Long.valueOf(wxMobileTx) });
          AppMethodBeat.o(186481);
          return;
        }
        catch (Exception paramContext)
        {
          l6 = l15;
          l3 = l16;
          l2 = l9;
          l1 = l10;
          break label976;
        }
        paramContext = paramContext;
        l6 = 0L;
        l3 = 0L;
        l9 = 0L;
        l10 = 0L;
        l5 = 0L;
        l4 = 0L;
        l8 = l2;
        l7 = l1;
        l1 = l10;
        l2 = l9;
      }
      label976:
      l11 = l6;
      l12 = l3;
      l13 = l2;
      l14 = l1;
      l1 = l7;
      l2 = l8;
      l3 = l5;
      l6 = l4;
      continue;
      label1020:
      l4 = 0L;
      continue;
      label1026:
      l4 = 0L;
      continue;
      label1032:
      l4 = 0L;
      continue;
      label1038:
      l4 = 0L;
      continue;
      label1044:
      l4 = l6;
      continue;
      label1051:
      l4 = l3;
      continue;
      label1058:
      l4 = l2;
      continue;
      label1064:
      l4 = l1;
    }
  }
  
  public static long updateWifiRx(long paramLong)
  {
    AppMethodBeat.i(186465);
    update();
    paramLong = getWifiRx(paramLong);
    AppMethodBeat.o(186465);
    return paramLong;
  }
  
  public static long updateWifiTx(long paramLong)
  {
    AppMethodBeat.i(186464);
    update();
    paramLong = getWifiTx(paramLong);
    AppMethodBeat.o(186464);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.TrafficStats
 * JD-Core Version:    0.7.0.1
 */