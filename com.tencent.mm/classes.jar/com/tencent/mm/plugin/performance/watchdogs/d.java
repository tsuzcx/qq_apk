package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.diagnostic.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class d
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static final d MNS;
  private static final AtomicBoolean MOh;
  private static final SimpleDateFormat MOi;
  public int MNT;
  public int MNU;
  private int MNV;
  private final Set<String> MNW;
  private boolean MNX;
  private volatile boolean MNY;
  private long MNZ;
  private long MOa;
  private long MOb;
  private long MOc;
  public long MOd;
  private boolean MOe;
  private boolean MOf;
  public a MOg;
  private int MOj;
  private long MOk;
  private long MOl;
  public volatile boolean eLx;
  private volatile String hfG;
  public final ActivityManager zXp;
  
  static
  {
    AppMethodBeat.i(301123);
    MNS = new d();
    MOh = new AtomicBoolean(false);
    MOi = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    AppMethodBeat.o(301123);
  }
  
  private d()
  {
    AppMethodBeat.i(301046);
    this.MNV = 0;
    this.MNW = new HashSet();
    this.MNX = true;
    this.eLx = true;
    this.MNY = false;
    this.zXp = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    this.MNZ = 524288000L;
    this.MOa = 1258291L;
    this.MOe = false;
    this.MOf = false;
    this.MOj = 0;
    this.MOk = 0L;
    if ((MMApplicationContext.isMainProcess()) && ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))) {
      MultiProcessMMKV.getMMKV("diagnostic_storage").encode("KEY_ENABLE_HOOK_TOAST", true);
    }
    com.tencent.matrix.a.eLw.a(new d.1(this));
    com.tencent.mm.plugin.performance.dice.a.MKN.a(new d.2(this));
    new MemoryWatchDog.3(this, f.hfK).alive();
    if (!BuildInfo.IS_ARM64) {
      com.tencent.mm.plugin.performance.c.gxW();
    }
    AppMethodBeat.o(301046);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(301112);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "check triggerMemoryHook");
    if (!this.MOf)
    {
      if (((paramb.MOy > 209715200L) || (paramb.FrK > 1048576)) && (Build.VERSION.SDK_INT >= 26))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "trigger hook");
        paramb = "<cmd><diagnostic><MemoryHook enable='1' source='auto' process='" + processCmd() + "' duration='24' hook='" + ".*com\\.tencent\\.mm.*\\.so$" + "' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.MIk.aRq(paramb);
        paramb = new ArrayList();
        IDKey localIDKey1 = new IDKey(1571, 1, 1);
        IDKey localIDKey2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
        paramb.add(localIDKey1);
        paramb.add(localIDKey2);
        com.tencent.mm.plugin.report.service.h.OAn.b(paramb, false);
        this.MOf = true;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()))
        {
          if (!MultiProcessMMKV.getMMKV("diagnostic_storage").decodeBool("KEY_ENABLE_HOOK_TOAST", true))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "skip toast");
            AppMethodBeat.o(301112);
            return;
          }
          com.tencent.threadpool.h.ahAA.bk(new d.6(this));
        }
      }
      AppMethodBeat.o(301112);
      return;
    }
    if ((paramb.MOy > this.MNZ) || (paramb.FrK > this.MOa))
    {
      this.MNZ = (paramb.MOy + 104857600L);
      if (this.MOa >= 2097152L) {
        break label404;
      }
    }
    label404:
    for (this.MOa = (paramb.FrK + 102400);; this.MOa = 9223372036854775807L)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "trigger report, next threshold : native %s pss %s, isFg=%s, fgSvs=%s, bgDur=%s", new Object[] { Long.valueOf(this.MNZ), Long.valueOf(this.MOa), Boolean.valueOf(paramb.eLx), Arrays.toString(paramb.MOu.toArray()), Long.valueOf(paramb.MOH) });
      if (paramInt != 3)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "not SOURCE_AUTO_CHECK, dumpForegroundService");
        d(paramb);
      }
      ((b)com.tencent.mm.plugin.performance.a.a.MIk.bX(b.class)).b(paramb);
      AppMethodBeat.o(301112);
      return;
    }
  }
  
  private static int[] a(b[] paramArrayOfb)
  {
    int[] arrayOfInt = new int[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      arrayOfInt[i] = paramArrayOfb[i].pid;
      i += 1;
    }
    return arrayOfInt;
  }
  
  private void afw(final int paramInt)
  {
    AppMethodBeat.i(301090);
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(301027);
        d.b localb = d.this.af(false, paramInt);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { localb });
        if (d.b(d.this)) {
          d.a(d.this, localb, paramInt);
        }
        AppMethodBeat.o(301027);
      }
    }, 2000L);
    AppMethodBeat.o(301090);
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(301096);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label62;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label62:
    AppMethodBeat.o(301096);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(301096);
    return paramInputStream;
  }
  
  private void d(b paramb)
  {
    AppMethodBeat.i(301062);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.zXp.getRunningServices(2147483647).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (localRunningServiceInfo.uid == Process.myUid())
      {
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "foreground %s, stared %s, lastActivityTime %s, activeSince %s, class %s", new Object[] { Boolean.valueOf(localRunningServiceInfo.foreground), Boolean.valueOf(localRunningServiceInfo.started), Long.valueOf(localRunningServiceInfo.lastActivityTime), Long.valueOf(localRunningServiceInfo.activeSince), localRunningServiceInfo.service.getClassName() });
        if (localRunningServiceInfo.foreground) {
          paramb.MOu.add(localRunningServiceInfo.service.getClassName());
        }
      }
    }
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "getting running service info cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(301062);
  }
  
  /* Error */
  private void e(b paramb)
  {
    // Byte code:
    //   0: ldc_w 498
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 440	java/lang/System:currentTimeMillis	()J
    //   9: lstore 11
    //   11: aload_1
    //   12: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   15: invokeinterface 504 1 0
    //   20: new 506	java/util/HashMap
    //   23: dup
    //   24: invokespecial 507	java/util/HashMap:<init>	()V
    //   27: astore 17
    //   29: aconst_null
    //   30: astore 15
    //   32: new 416	java/io/BufferedReader
    //   35: dup
    //   36: new 509	java/io/FileReader
    //   39: dup
    //   40: ldc_w 511
    //   43: invokespecial 512	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 424	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 16
    //   51: aload 16
    //   53: invokevirtual 427	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 15
    //   58: aload 15
    //   60: ifnull +371 -> 431
    //   63: aload 15
    //   65: invokevirtual 517	java/lang/String:trim	()Ljava/lang/String;
    //   68: astore 18
    //   70: aload 18
    //   72: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   75: ifne -24 -> 51
    //   78: iconst_1
    //   79: istore_3
    //   80: iconst_0
    //   81: istore_2
    //   82: iconst_0
    //   83: istore 4
    //   85: lconst_0
    //   86: lstore 7
    //   88: iconst_0
    //   89: istore 6
    //   91: iconst_0
    //   92: istore 5
    //   94: iload_2
    //   95: aload 18
    //   97: invokevirtual 523	java/lang/String:length	()I
    //   100: if_icmpge +449 -> 549
    //   103: iload_3
    //   104: tableswitch	default:+451 -> 555, 1:+94->198, 2:+113->217, 3:+133->237
    //   133: iconst_m1
    //   134: fconst_2
    //   135: dup
    //   136: ldc_w 527
    //   139: invokespecial 528	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   142: astore 15
    //   144: ldc_w 498
    //   147: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 15
    //   152: athrow
    //   153: astore 17
    //   155: aload 16
    //   157: astore 15
    //   159: aload 17
    //   161: astore 16
    //   163: ldc 228
    //   165: aload 16
    //   167: ldc_w 530
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 534	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_1
    //   178: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   181: invokeinterface 504 1 0
    //   186: aload 15
    //   188: invokestatic 540	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   191: ldc_w 498
    //   194: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: return
    //   198: aload 18
    //   200: iload_2
    //   201: invokevirtual 544	java/lang/String:charAt	(I)C
    //   204: invokestatic 550	java/lang/Character:isSpaceChar	(C)Z
    //   207: ifeq +351 -> 558
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -120 -> 94
    //   217: aload 18
    //   219: iload_2
    //   220: invokevirtual 544	java/lang/String:charAt	(I)C
    //   223: invokestatic 550	java/lang/Character:isSpaceChar	(C)Z
    //   226: ifeq +340 -> 566
    //   229: iload_2
    //   230: istore 6
    //   232: iconst_3
    //   233: istore_3
    //   234: goto -140 -> 94
    //   237: iload 4
    //   239: ifne +171 -> 410
    //   242: aload 18
    //   244: iload 5
    //   246: iload 6
    //   248: invokevirtual 554	java/lang/String:substring	(II)Ljava/lang/String;
    //   251: invokevirtual 517	java/lang/String:trim	()Ljava/lang/String;
    //   254: astore 19
    //   256: aload 19
    //   258: bipush 45
    //   260: invokevirtual 558	java/lang/String:indexOf	(I)I
    //   263: istore_3
    //   264: iload_3
    //   265: iflt +284 -> 549
    //   268: aload 19
    //   270: iconst_0
    //   271: iload_3
    //   272: invokevirtual 554	java/lang/String:substring	(II)Ljava/lang/String;
    //   275: astore 15
    //   277: aload 19
    //   279: iload_3
    //   280: iconst_1
    //   281: iadd
    //   282: invokevirtual 561	java/lang/String:substring	(I)Ljava/lang/String;
    //   285: astore 19
    //   287: aload 19
    //   289: bipush 16
    //   291: invokestatic 565	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   294: lstore 9
    //   296: aload 15
    //   298: bipush 16
    //   300: invokestatic 565	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   303: lstore 13
    //   305: lload 9
    //   307: lload 13
    //   309: lsub
    //   310: lstore 7
    //   312: iload 4
    //   314: iconst_1
    //   315: iadd
    //   316: istore 4
    //   318: iconst_1
    //   319: istore_3
    //   320: goto -226 -> 94
    //   323: astore 15
    //   325: aconst_null
    //   326: astore 15
    //   328: iload_2
    //   329: aload 18
    //   331: invokevirtual 523	java/lang/String:length	()I
    //   334: if_icmpne +209 -> 543
    //   337: aload 15
    //   339: ifnonnull +204 -> 543
    //   342: ldc_w 567
    //   345: astore 15
    //   347: aload 15
    //   349: ifnull -298 -> 51
    //   352: lload 7
    //   354: lconst_0
    //   355: lcmp
    //   356: ifle -305 -> 51
    //   359: aload 17
    //   361: aload 15
    //   363: invokeinterface 573 2 0
    //   368: checkcast 338	java/lang/Long
    //   371: astore 18
    //   373: lload 7
    //   375: lstore 9
    //   377: aload 18
    //   379: ifnull +13 -> 392
    //   382: lload 7
    //   384: aload 18
    //   386: invokevirtual 576	java/lang/Long:longValue	()J
    //   389: ladd
    //   390: lstore 9
    //   392: aload 17
    //   394: aload 15
    //   396: lload 9
    //   398: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: invokeinterface 580 3 0
    //   406: pop
    //   407: goto -356 -> 51
    //   410: iload 4
    //   412: iconst_4
    //   413: if_icmpne +133 -> 546
    //   416: aload 18
    //   418: iload 6
    //   420: invokevirtual 561	java/lang/String:substring	(I)Ljava/lang/String;
    //   423: invokevirtual 517	java/lang/String:trim	()Ljava/lang/String;
    //   426: astore 15
    //   428: goto -100 -> 328
    //   431: aload 16
    //   433: invokestatic 540	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   436: aload_1
    //   437: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   440: aload 17
    //   442: invokeinterface 584 1 0
    //   447: invokeinterface 588 2 0
    //   452: pop
    //   453: aload_1
    //   454: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   457: new 590	com/tencent/mm/plugin/performance/watchdogs/d$4
    //   460: dup
    //   461: aload_0
    //   462: invokespecial 591	com/tencent/mm/plugin/performance/watchdogs/d$4:<init>	(Lcom/tencent/mm/plugin/performance/watchdogs/d;)V
    //   465: invokestatic 597	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   468: aload_1
    //   469: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   472: bipush 20
    //   474: aload_1
    //   475: getfield 501	com/tencent/mm/plugin/performance/watchdogs/d$b:MOM	Ljava/util/List;
    //   478: invokeinterface 600 1 0
    //   483: invokeinterface 604 3 0
    //   488: invokeinterface 504 1 0
    //   493: ldc 228
    //   495: ldc_w 606
    //   498: iconst_1
    //   499: anewarray 4	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: invokestatic 440	java/lang/System:currentTimeMillis	()J
    //   507: lload 11
    //   509: lsub
    //   510: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: aastore
    //   514: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: ldc_w 498
    //   520: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: return
    //   524: astore_1
    //   525: aload 15
    //   527: invokestatic 540	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   530: ldc_w 498
    //   533: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: aload_1
    //   537: athrow
    //   538: astore 16
    //   540: goto -377 -> 163
    //   543: goto -196 -> 347
    //   546: goto -234 -> 312
    //   549: aconst_null
    //   550: astore 15
    //   552: goto -224 -> 328
    //   555: goto -423 -> 132
    //   558: iload_2
    //   559: istore 5
    //   561: iconst_2
    //   562: istore_3
    //   563: goto -469 -> 94
    //   566: iload_2
    //   567: iconst_1
    //   568: iadd
    //   569: istore_2
    //   570: goto -476 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	d
    //   0	573	1	paramb	b
    //   81	489	2	i	int
    //   79	484	3	j	int
    //   83	331	4	k	int
    //   92	468	5	m	int
    //   89	330	6	n	int
    //   86	297	7	l1	long
    //   294	103	9	l2	long
    //   9	499	11	l3	long
    //   303	5	13	l4	long
    //   30	267	15	localObject1	Object
    //   323	1	15	localObject2	Object
    //   326	225	15	str1	String
    //   49	383	16	localObject3	Object
    //   538	1	16	localObject4	Object
    //   27	1	17	localHashMap	HashMap
    //   153	288	17	localObject5	Object
    //   68	349	18	localObject6	Object
    //   254	34	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	58	153	finally
    //   63	78	153	finally
    //   94	103	153	finally
    //   132	153	153	finally
    //   198	210	153	finally
    //   217	229	153	finally
    //   242	264	153	finally
    //   268	287	153	finally
    //   328	337	153	finally
    //   359	373	153	finally
    //   382	392	153	finally
    //   392	407	153	finally
    //   416	428	153	finally
    //   287	305	323	finally
    //   163	186	524	finally
    //   32	51	538	finally
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(301097);
    Object localObject1 = new u(paramString);
    paramString = null;
    try
    {
      localObject1 = y.ao((u)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(301097);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(301097);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(301093);
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject = getStringFromFile((String)localObject).trim().split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        boolean bool = str.startsWith("VmSize");
        if (bool)
        {
          AppMethodBeat.o(301093);
          return str;
        }
        i += 1;
      }
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(301093);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(301093);
    }
    return "";
  }
  
  private static int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(301107);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(301107);
      return 30;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(301107);
      return 31;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(301107);
      return 32;
    }
    AppMethodBeat.o(301107);
    return -1;
  }
  
  public static d gzs()
  {
    return MNS;
  }
  
  private b[] gzt()
  {
    AppMethodBeat.i(301082);
    Object localObject1 = this.zXp.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      Object localObject2 = (ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i);
      String str = WeChatBrands.AppInfo.current().getPackageName();
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "pkg name is [%s]", new Object[] { str });
      if ((Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject2).uid) || (TextUtils.isEmpty(((ActivityManager.RunningAppProcessInfo)localObject2).processName)) || (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(str))) {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s][%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName, Integer.valueOf(Process.myUid()), str });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = new b();
        ((b)localObject2).pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).pid;
        ((b)localObject2).processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName;
        localArrayList.add(localObject2);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", new Object[] { Integer.valueOf(((b)localObject2).pid), ((b)localObject2).processName });
      }
    }
    localObject1 = new b[localArrayList.size()];
    localArrayList.toArray((Object[])localObject1);
    AppMethodBeat.o(301082);
    return localObject1;
  }
  
  private boolean gzv()
  {
    AppMethodBeat.i(301099);
    long l = SystemClock.uptimeMillis();
    if (l - this.MOl > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.MOl = l;
      AppMethodBeat.o(301099);
      return bool;
    }
  }
  
  static boolean gzw()
  {
    AppMethodBeat.i(301102);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(301102);
      return true;
    }
    AppMethodBeat.o(301102);
    return false;
  }
  
  private boolean gzx()
  {
    AppMethodBeat.i(301106);
    com.tencent.mm.booter.d locald = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).lsS;
    if ((locald != null) && (Util.nullAs(locald.Ck(".com.tencent.mm.debug.disable_memory_hook"), false)))
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "disabled by assist");
      AppMethodBeat.o(301106);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zti, false))
    {
      AppMethodBeat.o(301106);
      return false;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (com.tencent.mm.protocal.d.Yxk) || (WeChatEnvironment.hasDebugger()) || (this.MOe))
    {
      AppMethodBeat.o(301106);
      return true;
    }
    AppMethodBeat.o(301106);
    return false;
  }
  
  private static String processCmd()
  {
    AppMethodBeat.i(301114);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(301114);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(301114);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(301114);
      return "tools";
    }
    AppMethodBeat.o(301114);
    return "all";
  }
  
  public final void Aq(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(301138);
    b localb = af(true, 3);
    new StringBuilder("[AutoCheck] ").append(localb);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.eLx), localb });
    if (!this.MNW.isEmpty()) {}
    for (;;)
    {
      c.a(localb, bool, paramBoolean);
      if (gzx()) {
        a(localb, 3);
      }
      AppMethodBeat.o(301138);
      return;
      bool = false;
    }
  }
  
  public final b af(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(301130);
    long l1 = System.currentTimeMillis();
    b localb = new b();
    if (this.hfG != null) {
      localb.hfG = this.hfG;
    }
    localb.source = paramInt;
    localb.MOD = this.MNT;
    localb.MOE = this.MNU;
    long l2;
    Object localObject4;
    if (paramBoolean)
    {
      try
      {
        l2 = System.currentTimeMillis();
        localObject1 = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject1);
        localb.FrK = ((Debug.MemoryInfo)localObject1).getTotalPss();
        if (Build.VERSION.SDK_INT < 23) {
          break label397;
        }
        localb.MOr = ((Debug.MemoryInfo)localObject1).getMemoryStats();
        localObject1 = this.zXp.getProcessMemoryInfo(new int[] { Process.myPid() });
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          localObject1 = localObject1[0];
          localb.MOJ = ((Debug.MemoryInfo)localObject1).getTotalPss();
          if (Build.VERSION.SDK_INT < 23) {
            break label943;
          }
          localb.MOr.put("summary.graphics", ((Debug.MemoryInfo)localObject1).getMemoryStat("summary.graphics"));
          localb.MOs = ((Debug.MemoryInfo)localObject1).getMemoryStats();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject1;
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.MemoryWatchDog", localException1, "", new Object[0]);
          localb.MOF = (System.currentTimeMillis() - l1);
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (localb.MOF > 30L) && (this.MNX))
          {
            this.MNV += 1;
            if (this.MNV > 10)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
              this.MNX = false;
            }
          }
          if (localb.MOI == null)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
            localb.MOI = new ActivityManager.MemoryInfo();
          }
          localb.eLx = this.eLx;
          localb.MNY = this.MNY;
          if (gzw())
          {
            if (this.MNW.isEmpty()) {
              break;
            }
            bool = true;
            localb.MOw = bool;
          }
          if ((!gzw()) || (localb.MNY)) {
            break label1691;
          }
          localb.MOH = (System.currentTimeMillis() - this.MOc);
          localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
          localObject4 = c.a.zvt;
          if ((!BuildInfo.DEBUG) && (!com.tencent.mm.protocal.d.Yxk) && (!WeChatEnvironment.hasDebugger())) {
            break label1721;
          }
          bool = true;
          if (localc.a((c.a)localObject4, bool))
          {
            l1 = System.currentTimeMillis();
            if (l1 - this.MOk >= TimeUnit.SECONDS.toMillis(30L)) {
              break label1727;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "less than 30 seconds since last publish");
          }
          paramInt = 0;
          if (paramInt != 0) {
            h(localb, paramBoolean);
          }
          l1 = localb.MOA - localb.MOB;
          if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
            break label2078;
          }
          com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MemoryWatchDog", "Skip hprof dump and publish: not debuggable package.");
          AppMethodBeat.o(301130);
          return localb;
          localb.MOs = new HashMap();
          localb.MOs.put("summary.java-heap", String.valueOf(localc.dalvikPrivateDirty));
          localb.MOs.put("summary.native-heap", String.valueOf(localc.nativePrivateDirty));
          localb.MOs.put("summary.code", "-1");
          localb.MOs.put("summary.stack", "-1");
          localb.MOs.put("summary.graphics", "-1");
          localb.MOs.put("summary.private-other", "-1");
          localb.MOs.put("summary.system", String.valueOf(localc.getTotalPss() - localc.getTotalPrivateClean() - localc.getTotalPrivateDirty()));
          localb.MOs.put("summary.total-pss", String.valueOf(localc.getTotalPss()));
          localb.MOs.put("summary.total-swap", "-1");
        }
      }
      finally
      {
        localb.MOF = (System.currentTimeMillis() - l1);
        if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (paramBoolean) || (localb.MOF <= 30L) || (!this.MNX)) {
          break label1223;
        }
        this.MNV += 1;
        if (this.MNV <= 10) {
          break label1223;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
        this.MNX = false;
        if (localb.MOI != null) {
          break label1251;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
        localb.MOI = new ActivityManager.MemoryInfo();
        AppMethodBeat.o(301130);
      }
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      if (MMApplicationContext.isMainProcess())
      {
        l2 = System.currentTimeMillis();
        localObject1 = gzt();
        localObject4 = this.zXp.getProcessMemoryInfo(a((b[])localObject1));
        if (localObject4 == null) {
          break label1594;
        }
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(localObject4.length), Integer.valueOf(localObject1.length) });
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.isCoolassistEnv())) {
          break label2485;
        }
        Assert.assertEquals(localObject1.length, localObject4.length);
        break label2485;
      }
    }
    for (;;)
    {
      if (i < Math.min(localObject4.length, localObject1.length))
      {
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "total pss = %d", new Object[] { Integer.valueOf(localObject4[i].getTotalPss()) });
        localObject1[i].FrK = localObject4[i].getTotalPss();
        j += localObject1[i].FrK;
        i += 1;
        continue;
        label397:
        localb.MOr = new HashMap();
        localb.MOr.put("summary.java-heap", String.valueOf(((Debug.MemoryInfo)localObject1).dalvikPrivateDirty));
        localb.MOr.put("summary.native-heap", String.valueOf(((Debug.MemoryInfo)localObject1).nativePrivateDirty));
        localb.MOr.put("summary.code", "-1");
        localb.MOr.put("summary.stack", "-1");
        localb.MOr.put("summary.graphics", "-1");
        localb.MOr.put("summary.private-other", "-1");
        localb.MOr.put("summary.system", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss() - ((Debug.MemoryInfo)localObject1).getTotalPrivateClean() - ((Debug.MemoryInfo)localObject1).getTotalPrivateDirty()));
        localb.MOr.put("summary.total-pss", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss()));
        localb.MOr.put("summary.total-swap", "-1");
        break;
      }
      label1678:
      label2070:
      label2072:
      for (;;)
      {
        com.tencent.mm.plugin.expt.b.c localc;
        label878:
        localb.MOK = j;
        label943:
        label1223:
        label1251:
        localb.MOL = localObject2;
        label1274:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        d(localb);
        if (this.MOg == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "mAppbrandExtraMemoryInfo == null");
          label1319:
          if ((!BuildInfo.IS_ARM64) && (paramInt == 4) && (com.tencent.mm.protocal.d.Yxk)) {
            if (!com.tencent.mm.plugin.performance.c.gxW()) {
              break label1678;
            }
          }
        }
        Object localObject3;
        for (double d = 2700000.0D;; d = 3400000.0D)
        {
          l2 = d;
          if (localb.MOt > l2) {
            e(localb);
          }
          localObject3 = Pattern.compile("\\d+").matcher(getVmSize());
          if (((Matcher)localObject3).find()) {
            localb.MOt = Util.safeParseInt(((Matcher)localObject3).group());
          }
          localb.MOx = Debug.getNativeHeapSize();
          localb.MOy = Debug.getNativeHeapAllocatedSize();
          localb.MOz = Debug.getNativeHeapFreeSize();
          localb.MOA = Runtime.getRuntime().totalMemory();
          localb.MOB = Runtime.getRuntime().freeMemory();
          localb.MOC = Runtime.getRuntime().maxMemory();
          localObject3 = new ActivityManager.MemoryInfo();
          this.zXp.getMemoryInfo((ActivityManager.MemoryInfo)localObject3);
          localb.MOI = ((ActivityManager.MemoryInfo)localObject3);
          localb.MOF = (System.currentTimeMillis() - l1);
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (localb.MOF > 30L) && (this.MNX))
          {
            this.MNV += 1;
            if (this.MNV > 10)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
              this.MNX = false;
            }
          }
          if (localb.MOI != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          localb.MOI = new ActivityManager.MemoryInfo();
          break;
          label1594:
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
          break label1274;
          localb.extra = this.MOg.cIr();
          localb.MON = this.MOg.cIs();
          localb.MOO = this.MOg.cIt();
          localb.MOP = this.MOg.cIu();
          localb.MOQ = this.MOg.cIv();
          break label1319;
        }
        boolean bool = false;
        continue;
        label1691:
        if ((!gzw()) && (!localb.eLx))
        {
          localb.MOH = (System.currentTimeMillis() - this.MOb);
          continue;
          label1721:
          bool = false;
          continue;
          label1727:
          if (l1 - this.MOk > TimeUnit.MINUTES.toMinutes(30L))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "has not published for more than 30 minutes. reset publish times limit");
            this.MOj = 0;
          }
          if (this.MOj > 5)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "has published more than 5 times, ignore in 30 minutes");
          }
          else
          {
            if ((!BuildInfo.IS_ARM64) && (com.tencent.mm.plugin.performance.c.gxW()))
            {
              paramInt = 1;
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(new IDKey(1660, 0, 1));
              if (BuildInfo.IS_ARM64) {
                break label1913;
              }
              if (paramInt == 0) {
                break label1901;
              }
              d = 2700000.0D;
              label1834:
              l1 = d;
              if (localb.MOt <= l1) {
                break label1913;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: vmsize");
              if (paramInt == 0) {
                break label1908;
              }
            }
            label1901:
            label1908:
            for (paramInt = 1;; paramInt = 4)
            {
              ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
              com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject3, false);
              paramInt = 1;
              break;
              paramInt = 0;
              break label1793;
              d = 3700000.0D;
              break label1834;
            }
            label1913:
            if (paramInt != 0)
            {
              l1 = 367001600L;
              if (localb.MOA - localb.MOB <= l1) {
                break label1998;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: java heap");
              if (paramInt == 0) {
                break label1993;
              }
            }
            label1993:
            for (paramInt = 2;; paramInt = 5)
            {
              ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
              com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject3, false);
              paramInt = 1;
              break;
              l1 = 471859200L;
              break label1922;
            }
            label1998:
            if (paramInt != 0)
            {
              l1 = 734003200L;
              label2007:
              if (localb.MOy <= l1) {
                break label2070;
              }
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: native heap");
              if (paramInt == 0) {
                break label2072;
              }
            }
            for (paramInt = 3;; paramInt = 6)
            {
              ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
              com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject3, false);
              paramInt = 1;
              break label878;
              l1 = 943718400L;
              break label2007;
              break;
            }
            label2078:
            if (l1 <= 367001600L)
            {
              com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MemoryWatchDog", "Skip hprof dump and publish: memory not reaches threshold.");
            }
            else
            {
              if (com.tencent.matrix.c.isInstalled())
              {
                com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class);
                if (com.tencent.matrix.resource.c.azg())
                {
                  com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MemoryWatchDog", "Skip hprof dump and publish: Matrix is analyzing resources.");
                  continue;
                }
              }
              if (MOh.compareAndSet(false, true))
              {
                localObject3 = MOi.format(Calendar.getInstance().getTime());
                localObject4 = new u(MMApplicationContext.getContext().getExternalCacheDir().getAbsolutePath() + "/hprofs");
                if (!((u)localObject4).jKS())
                {
                  com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "HPROF cache dir not exists, mkdir: %s", new Object[] { ah.v(((u)localObject4).jKT()) });
                  ((u)localObject4).jKY();
                }
                localObject4 = new u(ah.v(((u)localObject4).jKT()) + "/fork-dump-" + Process.myPid() + "-" + (String)localObject3 + ".hprof");
                if (((u)localObject4).jKS())
                {
                  com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.MemoryWatchDog", "HPROF file exists, delete and recreate: %s", new Object[] { ah.v(((u)localObject4).jKT()) });
                  ((u)localObject4).diJ();
                }
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "start fork dump heap: %s", new Object[] { ah.v(((u)localObject4).jKT()) });
                try
                {
                  com.tencent.matrix.memorydump.a.a(ah.v(((u)localObject4).mUri), new d.3((u)localObject4, (String)localObject3, l1));
                }
                catch (Exception localException2)
                {
                  com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.MemoryWatchDog", localException2, "dump heap failed with exception", new Object[0]);
                  String str = android.util.Log.getStackTraceString(localException2).replace('\n', ';').replace("\t", "");
                  com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { str, localObject3, Integer.valueOf(3), Integer.valueOf(32), Long.valueOf(l1), BuildInfo.BUILD_TAG, BuildInfo.REV });
                  MOh.set(false);
                }
              }
            }
          }
        }
      }
      label1793:
      label1922:
      label2485:
      int j = 0;
      int i = 0;
    }
  }
  
  public final void du(boolean paramBoolean)
  {
    AppMethodBeat.i(301134);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MemoryWatchDog", "isAppForeground: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.eLx = paramBoolean;
    if (!paramBoolean)
    {
      this.MOb = System.currentTimeMillis();
      AppMethodBeat.o(301134);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.MOd > 300000L)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "onAppForeground: forward check");
      this.MOd = l;
      com.tencent.threadpool.h.ahAA.bFQ("MicroMsg.MemoryWatchDog");
      com.tencent.threadpool.h.ahAA.a(this, 300000L, "MicroMsg.MemoryWatchDog");
    }
    AppMethodBeat.o(301134);
  }
  
  public final b gzu()
  {
    AppMethodBeat.i(369879);
    b localb = af(true, 0);
    AppMethodBeat.o(369879);
    return localb;
  }
  
  public final void h(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301131);
    this.MOk = System.currentTimeMillis();
    this.MOj += 1;
    oc localoc = new oc();
    localoc.hQB.reason = 1;
    localoc.hQB.hQC = paramb.MOt;
    localoc.hQB.hQD = paramb.MOx;
    localoc.hQB.hQE = paramb.MOy;
    localoc.hQB.hQF = (paramb.MOA - paramb.MOB);
    if (paramBoolean)
    {
      localoc.hQB.hQG = paramb.FrK;
      localoc.hQB.hQH = Util.getInt((String)paramb.MOr.get("summary.graphics"), 0);
      localoc.hQB.hQI = Util.getInt((String)paramb.MOr.get("summary.native-heap"), 0);
      localoc.hQB.hQJ = paramb.MOK;
    }
    localoc.publish();
    AppMethodBeat.o(301131);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(301140);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.MNW.add(paramActivity);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.MNW.size()) });
    }
    AppMethodBeat.o(301140);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(301141);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.MNW.remove(paramActivity);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.MNW.size()) });
    }
    AppMethodBeat.o(301141);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(301136);
    this.hfG = paramActivity.getClass().getSimpleName();
    AppMethodBeat.o(301136);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(301135);
    this.hfG = paramActivity.getClass().getSimpleName();
    if (gzv()) {
      afw(1);
    }
    AppMethodBeat.o(301135);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(301137);
    if (gzv()) {
      afw(2);
    }
    AppMethodBeat.o(301137);
  }
  
  public final void run()
  {
    AppMethodBeat.i(301139);
    Aq(false);
    this.MOd = System.currentTimeMillis();
    i locali = com.tencent.threadpool.h.ahAA;
    if (this.eLx) {}
    for (long l = 300000L;; l = 1800000L)
    {
      locali.a(this, l, "MicroMsg.MemoryWatchDog");
      AppMethodBeat.o(301139);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract String cIr();
    
    public abstract String cIs();
    
    public abstract String cIt();
    
    public abstract String cIu();
    
    public abstract String cIv();
  }
  
  public static final class b
  {
    public int FrK;
    public boolean MNY;
    public long MOA;
    public long MOB;
    public long MOC;
    public long MOD;
    public long MOE;
    public long MOF;
    public long MOG;
    public long MOH;
    public ActivityManager.MemoryInfo MOI;
    public int MOJ;
    public int MOK;
    public b[] MOL;
    public List<Map.Entry<String, Long>> MOM;
    public String MON;
    public String MOO;
    public String MOP;
    public String MOQ;
    public Map<String, String> MOr;
    public Map<String, String> MOs;
    public int MOt;
    public List<String> MOu;
    public boolean MOv;
    public boolean MOw;
    public long MOx;
    public long MOy;
    public long MOz;
    public boolean eLx;
    public String extra;
    public String hfG;
    public int pid;
    public String processName;
    public int source;
    
    public b()
    {
      AppMethodBeat.i(301002);
      this.processName = "current";
      this.source = 0;
      this.hfG = "default";
      this.MOu = new ArrayList();
      this.MOv = d.gzw();
      this.MOG = Thread.currentThread().getId();
      this.MOH = -1L;
      this.MOL = new b[0];
      this.MOM = new ArrayList();
      AppMethodBeat.o(301002);
    }
    
    private static String aO(Map<String, String> paramMap)
    {
      AppMethodBeat.i(301010);
      if (paramMap == null)
      {
        AppMethodBeat.o(301010);
        return "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!((String)localEntry.getKey()).equals("java-heap")) && (!((String)localEntry.getKey()).equals("native-heap"))) {
          localStringBuilder.append(((String)localEntry.getKey()).replaceFirst("summary.", "")).append("=").append((String)localEntry.getValue()).append(", ");
        }
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      paramMap = localStringBuilder.toString();
      AppMethodBeat.o(301010);
      return paramMap;
    }
    
    public final String gzA()
    {
      AppMethodBeat.i(301028);
      Object localObject1 = new StringBuilder();
      try
      {
        ((StringBuilder)localObject1).append("totalMem:").append(this.MOI.totalMem / 1000L).append(" VmSize:").append(this.MOt).append(" javaMaxMem:").append(this.MOC / 1000L).append(" javaUsedMem:").append(this.MOA / 1000L).append(" javaFreeMem:").append((this.MOC - this.MOA) / 1000L);
        String str = ((StringBuilder)localObject1).toString();
        AppMethodBeat.o(301028);
        return str;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MemoryWatchDog", "getAnrReportMemoryInfoString error : %s", new Object[] { localObject2.getMessage() });
        localObject1 = ((StringBuilder)localObject1).toString();
        AppMethodBeat.o(301028);
      }
      return localObject1;
    }
    
    public final String gzz()
    {
      AppMethodBeat.i(301014);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!this.MOM.isEmpty())
      {
        localStringBuilder.append("| Top 20 mapped memory region sizes:\n");
        Iterator localIterator = this.MOM.iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (TextUtils.isEmpty((CharSequence)localEntry.getKey())) {}
          for (str = "!no-name!";; str = "'" + (String)localEntry.getKey() + "'")
          {
            localStringBuilder.append("|   name: ").append(str).append(", size: ").append(localEntry.getValue()).append(" bytes\n");
            break;
          }
        }
      }
      String str = localStringBuilder.toString();
      AppMethodBeat.o(301014);
      return str;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(301024);
      StringBuilder localStringBuilder1 = new StringBuilder(" \n");
      StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(tid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.MOG) })).append("\n| Activity:\t").append(this.hfG).append("\tAppForeground:").append(this.eLx).append("\tProcessForeground:").append(this.MNY);
      if (d.gzw())
      {
        localObject = "\thasActivity:";
        localStringBuilder2 = localStringBuilder2.append((String)localObject);
        if (!d.gzw()) {
          break label493;
        }
      }
      label493:
      for (Object localObject = Boolean.valueOf(this.MOw);; localObject = "")
      {
        localStringBuilder2.append(localObject).append("\n| Source:\t ").append(this.source).append("\n| VmSize:\t ").append(this.MOt).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.MOI.totalMem).append(", availMem=").append(this.MOI.availMem).append(", lowMemory=").append(this.MOI.lowMemory).append(", threshold=").append(this.MOI.threshold).append("\n| Dalvik:\t memClass=").append(this.MOD).append(", memLargeClass=").append(this.MOE).append(" B, UsedMemory=").append(this.MOA).append(" B, RecycledMemory=").append(this.MOB).append(" B, MaxMemory=").append(this.MOC).append(" B\n| NATIVE:\t HeapSize=").append(this.MOx).append(" B, AllocatedSize=").append(this.MOy).append(" B, RecycledSize=").append(this.MOz).append(" B\n| Stats:\t pss-sum:").append(this.MOK).append(" KB, ").append(aO(this.MOr)).append("\n| AMSStats:\t ").append(aO(this.MOs)).append("\n| FgService:\t").append(Arrays.toString(this.MOu.toArray())).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.MOF).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        if (this.MOL == null) {
          break label499;
        }
        localObject = this.MOL;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder2 = localObject[i];
          localStringBuilder1.append("| Process: ").append(localStringBuilder2.processName).append(", pid: ").append(localStringBuilder2.pid).append(", totalPss: ").append(localStringBuilder2.FrK).append("\n");
          i += 1;
        }
        localObject = "";
        break;
      }
      label499:
      localObject = localStringBuilder1.toString();
      AppMethodBeat.o(301024);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d
 * JD-Core Version:    0.7.0.1
 */