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
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class c
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static final c GQA;
  public int GQB;
  public int GQC;
  private int GQD;
  private final Set<String> GQE;
  private boolean GQF;
  private volatile boolean GQG;
  private long GQH;
  private long GQI;
  private long GQJ;
  private long GQK;
  public long GQL;
  private boolean GQM;
  private boolean GQN;
  public a GQO;
  private int GQP;
  private long GQQ;
  private long GQR;
  public volatile boolean cQt;
  private volatile String fca;
  public final ActivityManager wBe;
  
  static
  {
    AppMethodBeat.i(202279);
    GQA = new c();
    AppMethodBeat.o(202279);
  }
  
  private c()
  {
    AppMethodBeat.i(202105);
    this.GQD = 0;
    this.GQE = new HashSet();
    this.GQF = true;
    this.cQt = true;
    this.GQG = false;
    this.wBe = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    this.GQH = 524288000L;
    this.GQI = 1258291L;
    this.GQM = false;
    this.GQN = false;
    this.GQP = 0;
    this.GQQ = 0L;
    com.tencent.mm.bs.a.a.mAJ = new com.tencent.mm.bs.a.a.a() {};
    com.tencent.matrix.a.cQs.a(new com.tencent.matrix.b.a()
    {
      public final void onForeground(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(200810);
        Log.d("MicroMsg.MemoryWatchDog", "[%s] isProcessForeground: %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(paramAnonymousBoolean) });
        c.a(c.this, paramAnonymousBoolean);
        if (!paramAnonymousBoolean) {
          c.a(c.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(200810);
      }
    });
    com.tencent.mm.plugin.performance.b.a.GNv.a(new com.tencent.mm.plugin.performance.b.a.a()
    {
      public final void action(double paramAnonymousDouble)
      {
        AppMethodBeat.i(201332);
        c.a(c.this);
        AppMethodBeat.o(201332);
      }
      
      public final long cycleMinutes()
      {
        return 0L;
      }
      
      public final String key()
      {
        return "MicroMsg.MemoryWatchDog";
      }
      
      public final double rate()
      {
        AppMethodBeat.i(201334);
        double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRd, -1L);
        AppMethodBeat.o(201334);
        return d;
      }
    });
    new IListener() {}.alive();
    if (!BuildInfo.IS_ARM64) {
      com.tencent.mm.plugin.performance.c.fnj();
    }
    AppMethodBeat.o(202105);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(202251);
    Log.i("MicroMsg.MemoryWatchDog", "check triggerMemoryHook");
    if (!this.GQN)
    {
      if (((paramb.GRa > 209715200L) || (paramb.GRk > 1048576)) && (Build.VERSION.SDK_INT >= 26))
      {
        Log.i("MicroMsg.MemoryWatchDog", "trigger hook");
        paramb = "<cmd><diagnostic><MemoryHook enable='1' source='auto' process='" + processCmd() + "' duration='24' hook='" + ".*com\\.tencent\\.mm.*\\.so$" + "' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramb);
        paramb = new ArrayList();
        IDKey localIDKey1 = new IDKey(1571, 1, 1);
        IDKey localIDKey2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
        paramb.add(localIDKey1);
        paramb.add(localIDKey2);
        com.tencent.mm.plugin.report.service.h.IzE.b(paramb, false);
        this.GQN = true;
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) {
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202300);
              Toast.makeText(MMApplicationContext.getContext(), "trigger memory hook\n(toast for debug/coolassist)", 0).show();
              AppMethodBeat.o(202300);
            }
          });
        }
      }
      AppMethodBeat.o(202251);
      return;
    }
    if ((paramb.GRa > this.GQH) || (paramb.GRk > this.GQI))
    {
      this.GQH = (paramb.GRa + 104857600L);
      if (this.GQI >= 2097152L) {
        break label373;
      }
    }
    label373:
    for (this.GQI = (paramb.GRk + 102400);; this.GQI = 9223372036854775807L)
    {
      Log.i("MicroMsg.MemoryWatchDog", "trigger report, next threshold : native %s pss %s, isFg=%s, fgSvs=%s, bgDur=%s", new Object[] { Long.valueOf(this.GQH), Long.valueOf(this.GQI), Boolean.valueOf(paramb.cQt), Arrays.toString(paramb.GQW.toArray()), Long.valueOf(paramb.GRi) });
      if (paramInt != 3)
      {
        Log.i("MicroMsg.MemoryWatchDog", "not SOURCE_AUTO_CHECK, dumpForegroundService");
        i(paramb);
      }
      ((com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).b(paramb);
      AppMethodBeat.o(202251);
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
  
  private void abd(final int paramInt)
  {
    AppMethodBeat.i(202199);
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201376);
        c.b localb = c.this.ad(false, paramInt);
        Log.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { localb });
        if (c.b(c.this)) {
          c.a(c.this, localb, paramInt);
        }
        AppMethodBeat.o(201376);
      }
    }, 2000L);
    AppMethodBeat.o(202199);
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(202210);
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
    AppMethodBeat.o(202210);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(202210);
    return paramInputStream;
  }
  
  public static c fou()
  {
    return GQA;
  }
  
  private b[] fov()
  {
    AppMethodBeat.i(202193);
    Object localObject1 = this.wBe.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      Object localObject2 = (ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i);
      String str = WeChatBrands.AppInfo.current().getPackageName();
      Log.d("MicroMsg.MemoryWatchDog", "pkg name is [%s]", new Object[] { str });
      if ((Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject2).uid) || (TextUtils.isEmpty(((ActivityManager.RunningAppProcessInfo)localObject2).processName)) || (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(str))) {
        Log.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s][%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName, Integer.valueOf(Process.myUid()), str });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = new b();
        ((b)localObject2).pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).pid;
        ((b)localObject2).processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName;
        localArrayList.add(localObject2);
        Log.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", new Object[] { Integer.valueOf(((b)localObject2).pid), ((b)localObject2).processName });
      }
    }
    localObject1 = new b[localArrayList.size()];
    localArrayList.toArray((Object[])localObject1);
    AppMethodBeat.o(202193);
    return localObject1;
  }
  
  private boolean fox()
  {
    AppMethodBeat.i(202215);
    long l = SystemClock.uptimeMillis();
    if (l - this.GQR > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.GQR = l;
      AppMethodBeat.o(202215);
      return bool;
    }
  }
  
  static boolean foy()
  {
    AppMethodBeat.i(202225);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(202225);
      return true;
    }
    AppMethodBeat.o(202225);
    return false;
  }
  
  private boolean foz()
  {
    AppMethodBeat.i(202237);
    com.tencent.mm.booter.d locald = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).iQW;
    if ((locald != null) && (Util.nullAs(locald.JE(".com.tencent.mm.debug.disable_memory_hook"), false)))
    {
      Log.e("MicroMsg.MemoryWatchDog", "disabled by assist");
      AppMethodBeat.o(202237);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZH, false))
    {
      AppMethodBeat.o(202237);
      return false;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (com.tencent.mm.protocal.d.RAG) || (WeChatEnvironment.hasDebugger()) || (this.GQM))
    {
      AppMethodBeat.o(202237);
      return true;
    }
    AppMethodBeat.o(202237);
    return false;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(202213);
    Object localObject1 = new q(paramString);
    paramString = null;
    try
    {
      localObject1 = u.al((q)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(202213);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(202213);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(202208);
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
          AppMethodBeat.o(202208);
          return str;
        }
        i += 1;
      }
      Log.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(202208);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(202208);
    }
    return "";
  }
  
  private static int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(202243);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(202243);
      return 30;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(202243);
      return 31;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(202243);
      return 32;
    }
    AppMethodBeat.o(202243);
    return -1;
  }
  
  private void i(b paramb)
  {
    AppMethodBeat.i(202153);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.wBe.getRunningServices(2147483647).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (localRunningServiceInfo.uid == Process.myUid())
      {
        Log.d("MicroMsg.MemoryWatchDog", "foreground %s, stared %s, lastActivityTime %s, activeSince %s, class %s", new Object[] { Boolean.valueOf(localRunningServiceInfo.foreground), Boolean.valueOf(localRunningServiceInfo.started), Long.valueOf(localRunningServiceInfo.lastActivityTime), Long.valueOf(localRunningServiceInfo.activeSince), localRunningServiceInfo.service.getClassName() });
        if (localRunningServiceInfo.foreground) {
          paramb.GQW.add(localRunningServiceInfo.service.getClassName());
        }
      }
    }
    Log.d("MicroMsg.MemoryWatchDog", "getting running service info cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(202153);
  }
  
  /* Error */
  private void j(b paramb)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   9: lstore 11
    //   11: aload_1
    //   12: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   15: invokeinterface 660 1 0
    //   20: new 662	java/util/HashMap
    //   23: dup
    //   24: invokespecial 663	java/util/HashMap:<init>	()V
    //   27: astore 17
    //   29: aconst_null
    //   30: astore 15
    //   32: new 370	java/io/BufferedReader
    //   35: dup
    //   36: new 665	java/io/FileReader
    //   39: dup
    //   40: ldc_w 667
    //   43: invokespecial 668	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 378	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 16
    //   51: aload 16
    //   53: invokevirtual 381	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 15
    //   58: aload 15
    //   60: ifnull +389 -> 449
    //   63: aload 15
    //   65: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
    //   68: astore 18
    //   70: aload 18
    //   72: invokevirtual 670	java/lang/String:isEmpty	()Z
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
    //   97: invokevirtual 673	java/lang/String:length	()I
    //   100: if_icmpge +464 -> 564
    //   103: iload_3
    //   104: tableswitch	default:+466 -> 570, 1:+94->198, 2:+113->217, 3:+133->237
    //   133: iconst_m1
    //   134: if_icmpgt +22803 -> 22937
    //   137: iconst_m1
    //   138: if_acmpeq -18686 -> -18548
    //   141: if_acmpne +14863 -> 15004
    //   144: ldc_w 654
    //   147: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 15
    //   152: athrow
    //   153: astore 17
    //   155: aload 16
    //   157: astore 15
    //   159: aload 17
    //   161: astore 16
    //   163: ldc 177
    //   165: aload 16
    //   167: ldc_w 680
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 684	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_1
    //   178: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   181: invokeinterface 660 1 0
    //   186: aload 15
    //   188: invokestatic 688	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   191: ldc_w 654
    //   194: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: return
    //   198: aload 18
    //   200: iload_2
    //   201: invokevirtual 692	java/lang/String:charAt	(I)C
    //   204: invokestatic 698	java/lang/Character:isSpaceChar	(C)Z
    //   207: ifeq +366 -> 573
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -120 -> 94
    //   217: aload 18
    //   219: iload_2
    //   220: invokevirtual 692	java/lang/String:charAt	(I)C
    //   223: invokestatic 698	java/lang/Character:isSpaceChar	(C)Z
    //   226: ifeq +355 -> 581
    //   229: iload_2
    //   230: istore 6
    //   232: iconst_3
    //   233: istore_3
    //   234: goto -140 -> 94
    //   237: iload 4
    //   239: ifne +189 -> 428
    //   242: aload 18
    //   244: iload 5
    //   246: iload 6
    //   248: invokevirtual 702	java/lang/String:substring	(II)Ljava/lang/String;
    //   251: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
    //   254: astore 19
    //   256: aload 19
    //   258: bipush 45
    //   260: invokevirtual 706	java/lang/String:indexOf	(I)I
    //   263: istore_3
    //   264: iload_3
    //   265: iflt +299 -> 564
    //   268: aload 19
    //   270: iconst_0
    //   271: iload_3
    //   272: invokevirtual 702	java/lang/String:substring	(II)Ljava/lang/String;
    //   275: astore 15
    //   277: aload 19
    //   279: iload_3
    //   280: iconst_1
    //   281: iadd
    //   282: invokevirtual 709	java/lang/String:substring	(I)Ljava/lang/String;
    //   285: astore 19
    //   287: aload 19
    //   289: bipush 16
    //   291: invokestatic 713	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   294: lstore 9
    //   296: aload 15
    //   298: bipush 16
    //   300: invokestatic 713	java/lang/Long:parseLong	(Ljava/lang/String;I)J
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
    //   331: invokevirtual 673	java/lang/String:length	()I
    //   334: if_icmpne +224 -> 558
    //   337: aload 15
    //   339: ifnonnull +219 -> 558
    //   342: ldc_w 591
    //   345: astore 15
    //   347: aload 15
    //   349: ifnull -298 -> 51
    //   352: lload 7
    //   354: lconst_0
    //   355: lcmp
    //   356: ifle -305 -> 51
    //   359: aload 17
    //   361: aload 15
    //   363: invokeinterface 718 2 0
    //   368: checkcast 294	java/lang/Long
    //   371: astore 18
    //   373: lload 7
    //   375: lstore 9
    //   377: aload 18
    //   379: ifnull +13 -> 392
    //   382: lload 7
    //   384: aload 18
    //   386: invokevirtual 721	java/lang/Long:longValue	()J
    //   389: ladd
    //   390: lstore 9
    //   392: aload 17
    //   394: aload 15
    //   396: lload 9
    //   398: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   401: invokeinterface 725 3 0
    //   406: pop
    //   407: goto -356 -> 51
    //   410: astore_1
    //   411: aload 16
    //   413: astore 15
    //   415: aload 15
    //   417: invokestatic 688	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   420: ldc_w 654
    //   423: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: aload_1
    //   427: athrow
    //   428: iload 4
    //   430: iconst_4
    //   431: if_icmpne +130 -> 561
    //   434: aload 18
    //   436: iload 6
    //   438: invokevirtual 709	java/lang/String:substring	(I)Ljava/lang/String;
    //   441: invokevirtual 576	java/lang/String:trim	()Ljava/lang/String;
    //   444: astore 15
    //   446: goto -118 -> 328
    //   449: aload 16
    //   451: invokestatic 688	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   454: aload_1
    //   455: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   458: aload 17
    //   460: invokeinterface 729 1 0
    //   465: invokeinterface 733 2 0
    //   470: pop
    //   471: aload_1
    //   472: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   475: new 18	com/tencent/mm/plugin/performance/watchdogs/c$5
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 734	com/tencent/mm/plugin/performance/watchdogs/c$5:<init>	(Lcom/tencent/mm/plugin/performance/watchdogs/c;)V
    //   483: invokestatic 740	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   486: aload_1
    //   487: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   490: bipush 20
    //   492: aload_1
    //   493: getfield 657	com/tencent/mm/plugin/performance/watchdogs/c$b:GRo	Ljava/util/List;
    //   496: invokeinterface 399 1 0
    //   501: invokeinterface 744 3 0
    //   506: invokeinterface 660 1 0
    //   511: ldc 177
    //   513: ldc_w 746
    //   516: iconst_1
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: invokestatic 604	java/lang/System:currentTimeMillis	()J
    //   525: lload 11
    //   527: lsub
    //   528: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   531: aastore
    //   532: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: ldc_w 654
    //   538: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: return
    //   542: astore_1
    //   543: aconst_null
    //   544: astore 15
    //   546: goto -131 -> 415
    //   549: astore_1
    //   550: goto -135 -> 415
    //   553: astore 16
    //   555: goto -392 -> 163
    //   558: goto -211 -> 347
    //   561: goto -249 -> 312
    //   564: aconst_null
    //   565: astore 15
    //   567: goto -239 -> 328
    //   570: goto -438 -> 132
    //   573: iload_2
    //   574: istore 5
    //   576: iconst_2
    //   577: istore_3
    //   578: goto -484 -> 94
    //   581: iload_2
    //   582: iconst_1
    //   583: iadd
    //   584: istore_2
    //   585: goto -491 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	c
    //   0	588	1	paramb	b
    //   81	504	2	i	int
    //   79	499	3	j	int
    //   83	349	4	k	int
    //   92	483	5	m	int
    //   89	348	6	n	int
    //   86	297	7	l1	long
    //   294	103	9	l2	long
    //   9	517	11	l3	long
    //   303	5	13	l4	long
    //   30	267	15	localObject1	Object
    //   323	1	15	localThrowable1	java.lang.Throwable
    //   326	240	15	localObject2	Object
    //   49	401	16	localObject3	Object
    //   553	1	16	localThrowable2	java.lang.Throwable
    //   27	1	17	localHashMap	HashMap
    //   153	306	17	localThrowable3	java.lang.Throwable
    //   68	367	18	localObject4	Object
    //   254	34	19	str	String
    // Exception table:
    //   from	to	target	type
    //   51	58	153	java/lang/Throwable
    //   63	78	153	java/lang/Throwable
    //   94	103	153	java/lang/Throwable
    //   132	153	153	java/lang/Throwable
    //   198	210	153	java/lang/Throwable
    //   217	229	153	java/lang/Throwable
    //   242	264	153	java/lang/Throwable
    //   268	287	153	java/lang/Throwable
    //   328	337	153	java/lang/Throwable
    //   359	373	153	java/lang/Throwable
    //   382	392	153	java/lang/Throwable
    //   392	407	153	java/lang/Throwable
    //   434	446	153	java/lang/Throwable
    //   287	305	323	java/lang/Throwable
    //   51	58	410	finally
    //   63	78	410	finally
    //   94	103	410	finally
    //   132	153	410	finally
    //   198	210	410	finally
    //   217	229	410	finally
    //   242	264	410	finally
    //   268	287	410	finally
    //   287	305	410	finally
    //   328	337	410	finally
    //   359	373	410	finally
    //   382	392	410	finally
    //   392	407	410	finally
    //   434	446	410	finally
    //   32	51	542	finally
    //   163	186	549	finally
    //   32	51	553	java/lang/Throwable
  }
  
  private static String processCmd()
  {
    AppMethodBeat.i(202255);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(202255);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(202255);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(202255);
      return "tools";
    }
    AppMethodBeat.o(202255);
    return "all";
  }
  
  public final b ad(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(202139);
    long l1 = System.currentTimeMillis();
    b localb = new b();
    if (this.fca != null) {
      localb.fca = this.fca;
    }
    localb.source = paramInt;
    localb.GRf = this.GQB;
    localb.GRg = this.GQC;
    long l2;
    if (paramBoolean)
    {
      try
      {
        l2 = System.currentTimeMillis();
        localObject1 = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject1);
        localb.GRk = ((Debug.MemoryInfo)localObject1).getTotalPss();
        if (Build.VERSION.SDK_INT < 23) {
          break label397;
        }
        localb.GQT = ((Debug.MemoryInfo)localObject1).getMemoryStats();
        localObject1 = this.wBe.getProcessMemoryInfo(new int[] { Process.myPid() });
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          localObject1 = localObject1[0];
          localb.GRl = ((Debug.MemoryInfo)localObject1).getTotalPss();
          if (Build.VERSION.SDK_INT < 23) {
            break label898;
          }
          localb.GQT.put("summary.graphics", ((Debug.MemoryInfo)localObject1).getMemoryStat("summary.graphics"));
          localb.GQU = ((Debug.MemoryInfo)localObject1).getMemoryStats();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.printErrStackTrace("MicroMsg.MemoryWatchDog", localException, "", new Object[0]);
          localb.jVo = (System.currentTimeMillis() - l1);
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (localb.jVo > 30L) && (this.GQF))
          {
            this.GQD += 1;
            if (this.GQD > 10)
            {
              Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
              this.GQF = false;
            }
          }
          if (localb.GRj == null)
          {
            Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
            localb.GRj = new ActivityManager.MemoryInfo();
          }
          localb.cQt = this.cQt;
          localb.GQG = this.GQG;
          if (foy())
          {
            if (this.GQE.isEmpty()) {
              break;
            }
            bool = true;
            localb.GQY = bool;
          }
          if ((!foy()) || (localb.GQG)) {
            break label1646;
          }
          localb.GRi = (System.currentTimeMillis() - this.GQK);
          localb1 = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
          Object localObject4 = b.a.wbU;
          if ((!BuildInfo.DEBUG) && (!com.tencent.mm.protocal.d.RAG) && (!WeChatEnvironment.hasDebugger())) {
            break label1676;
          }
          bool = true;
          if (localb1.a((b.a)localObject4, bool))
          {
            l1 = System.currentTimeMillis();
            if (l1 - this.GQQ >= TimeUnit.SECONDS.toMillis(30L)) {
              break label1682;
            }
            Log.i("MicroMsg.MemoryWatchDog", "less than 30 seconds since last publish");
          }
          paramInt = 0;
          if (paramInt != 0) {
            c(localb, paramBoolean);
          }
          AppMethodBeat.o(202139);
          return localb;
          localb.GQU = new HashMap();
          localb.GQU.put("summary.java-heap", String.valueOf(localb1.dalvikPrivateDirty));
          localb.GQU.put("summary.native-heap", String.valueOf(localb1.nativePrivateDirty));
          localb.GQU.put("summary.code", "-1");
          localb.GQU.put("summary.stack", "-1");
          localb.GQU.put("summary.graphics", "-1");
          localb.GQU.put("summary.private-other", "-1");
          localb.GQU.put("summary.system", String.valueOf(localb1.getTotalPss() - localb1.getTotalPrivateClean() - localb1.getTotalPrivateDirty()));
          localb.GQU.put("summary.total-pss", String.valueOf(localb1.getTotalPss()));
          localb.GQU.put("summary.total-swap", "-1");
        }
      }
      finally
      {
        localb.jVo = (System.currentTimeMillis() - l1);
        if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (paramBoolean) || (localb.jVo <= 30L) || (!this.GQF)) {
          break label1178;
        }
        this.GQD += 1;
        if (this.GQD <= 10) {
          break label1178;
        }
        Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
        this.GQF = false;
        if (localb.GRj != null) {
          break label1206;
        }
        Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
        localb.GRj = new ActivityManager.MemoryInfo();
        AppMethodBeat.o(202139);
      }
      Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      if (MMApplicationContext.isMainProcess())
      {
        l2 = System.currentTimeMillis();
        localObject1 = fov();
        localObject4 = this.wBe.getProcessMemoryInfo(a((b[])localObject1));
        if (localObject4 == null) {
          break label1549;
        }
        Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(localObject4.length), Integer.valueOf(localObject1.length) });
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.isCoolassistEnv())) {
          break label2033;
        }
        Assert.assertEquals(localObject1.length, localObject4.length);
        break label2033;
      }
    }
    for (;;)
    {
      if (i < Math.min(localObject4.length, localObject1.length))
      {
        Log.d("MicroMsg.MemoryWatchDog", "total pss = %d", new Object[] { Integer.valueOf(localObject4[i].getTotalPss()) });
        localObject1[i].GRk = localObject4[i].getTotalPss();
        j += localObject1[i].GRk;
        i += 1;
        continue;
        label397:
        localb.GQT = new HashMap();
        localb.GQT.put("summary.java-heap", String.valueOf(((Debug.MemoryInfo)localObject1).dalvikPrivateDirty));
        localb.GQT.put("summary.native-heap", String.valueOf(((Debug.MemoryInfo)localObject1).nativePrivateDirty));
        localb.GQT.put("summary.code", "-1");
        localb.GQT.put("summary.stack", "-1");
        localb.GQT.put("summary.graphics", "-1");
        localb.GQT.put("summary.private-other", "-1");
        localb.GQT.put("summary.system", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss() - ((Debug.MemoryInfo)localObject1).getTotalPrivateClean() - ((Debug.MemoryInfo)localObject1).getTotalPrivateDirty()));
        localb.GQT.put("summary.total-pss", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss()));
        localb.GQT.put("summary.total-swap", "-1");
        break;
      }
      label878:
      label1274:
      double d;
      label898:
      label1178:
      label1206:
      label1229:
      Object localObject3;
      label1549:
      label1682:
      for (;;)
      {
        com.tencent.mm.plugin.expt.b.b localb1;
        localb.GRm = j;
        localb.GRn = localObject2;
        Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        i(localb);
        if (this.GQO == null)
        {
          Log.e("MicroMsg.MemoryWatchDog", "mAppbrandExtraMemoryInfo == null");
          if ((!BuildInfo.IS_ARM64) && (paramInt == 4) && (com.tencent.mm.protocal.d.RAG)) {
            if (!com.tencent.mm.plugin.performance.c.fnj()) {
              break label1633;
            }
          }
        }
        label1633:
        for (d = 2700000.0D;; d = 3400000.0D)
        {
          l2 = d;
          if (localb.GQV > l2) {
            j(localb);
          }
          localObject3 = Pattern.compile("\\d+").matcher(getVmSize());
          if (((Matcher)localObject3).find()) {
            localb.GQV = Util.safeParseInt(((Matcher)localObject3).group());
          }
          localb.GQZ = Debug.getNativeHeapSize();
          localb.GRa = Debug.getNativeHeapAllocatedSize();
          localb.GRb = Debug.getNativeHeapFreeSize();
          localb.GRc = Runtime.getRuntime().totalMemory();
          localb.GRd = Runtime.getRuntime().freeMemory();
          localb.GRe = Runtime.getRuntime().maxMemory();
          localObject3 = new ActivityManager.MemoryInfo();
          this.wBe.getMemoryInfo((ActivityManager.MemoryInfo)localObject3);
          localb.GRj = ((ActivityManager.MemoryInfo)localObject3);
          localb.jVo = (System.currentTimeMillis() - l1);
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (localb.jVo > 30L) && (this.GQF))
          {
            this.GQD += 1;
            if (this.GQD > 10)
            {
              Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
              this.GQF = false;
            }
          }
          if (localb.GRj != null) {
            break;
          }
          Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          localb.GRj = new ActivityManager.MemoryInfo();
          break;
          Log.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
          break label1229;
          localb.extra = this.GQO.chx();
          localb.GRp = this.GQO.chy();
          localb.GRq = this.GQO.chz();
          localb.GRr = this.GQO.chA();
          localb.GRs = this.GQO.chB();
          break label1274;
        }
        boolean bool = false;
        continue;
        label1646:
        if ((!foy()) && (!localb.cQt))
        {
          localb.GRi = (System.currentTimeMillis() - this.GQJ);
          continue;
          bool = false;
          continue;
          if (l1 - this.GQQ > TimeUnit.MINUTES.toMinutes(30L))
          {
            Log.i("MicroMsg.MemoryWatchDog", "has not published for more than 30 minutes. reset publish times limit");
            this.GQP = 0;
          }
          if (this.GQP <= 5) {
            break;
          }
          Log.i("MicroMsg.MemoryWatchDog", "has published more than 5 times, ignore in 30 minutes");
        }
      }
      label1676:
      if ((!BuildInfo.IS_ARM64) && (com.tencent.mm.plugin.performance.c.fnj()))
      {
        paramInt = 1;
        label1748:
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(new IDKey(1660, 0, 1));
        if (BuildInfo.IS_ARM64) {
          break label1868;
        }
        if (paramInt == 0) {
          break label1856;
        }
        d = 2700000.0D;
        label1789:
        l1 = d;
        if (localb.GQV <= l1) {
          break label1868;
        }
        Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: vmsize");
        if (paramInt == 0) {
          break label1863;
        }
      }
      label1856:
      label1863:
      for (paramInt = 1;; paramInt = 4)
      {
        ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
        com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject3, false);
        paramInt = 1;
        break;
        paramInt = 0;
        break label1748;
        d = 3700000.0D;
        break label1789;
      }
      label1868:
      if (paramInt != 0)
      {
        l1 = 367001600L;
        label1877:
        if (localb.GRc - localb.GRd <= l1) {
          break label1953;
        }
        Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: java heap");
        if (paramInt == 0) {
          break label1948;
        }
      }
      label1948:
      for (paramInt = 2;; paramInt = 5)
      {
        ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
        com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject3, false);
        paramInt = 1;
        break;
        l1 = 471859200L;
        break label1877;
      }
      label1953:
      if (paramInt != 0)
      {
        l1 = 734003200L;
        label1962:
        if (localb.GRa <= l1) {
          break label2025;
        }
        Log.i("MicroMsg.MemoryWatchDog", "shouldPublish: native heap");
        if (paramInt == 0) {
          break label2027;
        }
      }
      label2025:
      label2027:
      for (paramInt = 3;; paramInt = 6)
      {
        ((ArrayList)localObject3).add(new IDKey(1660, paramInt, 1));
        com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject3, false);
        paramInt = 1;
        break label878;
        l1 = 943718400L;
        break label1962;
        break;
      }
      label2033:
      int j = 0;
      int i = 0;
    }
  }
  
  public final void c(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(202145);
    this.GQQ = System.currentTimeMillis();
    this.GQP += 1;
    mv localmv = new mv();
    localmv.fKU.bnA = 1;
    localmv.fKU.fKV = paramb.GQV;
    localmv.fKU.fKW = paramb.GQZ;
    localmv.fKU.fKX = paramb.GRa;
    localmv.fKU.fKY = (paramb.GRc - paramb.GRd);
    if (paramBoolean)
    {
      localmv.fKU.fKZ = paramb.GRk;
      localmv.fKU.fLa = Util.getInt((String)paramb.GQT.get("summary.graphics"), 0);
      localmv.fKU.fLb = Util.getInt((String)paramb.GQT.get("summary.native-heap"), 0);
      localmv.fKU.fLc = paramb.GRm;
    }
    EventCenter.instance.publish(localmv);
    AppMethodBeat.o(202145);
  }
  
  public final void cN(boolean paramBoolean)
  {
    AppMethodBeat.i(202219);
    Log.d("MicroMsg.MemoryWatchDog", "isAppForeground: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cQt = paramBoolean;
    if (!paramBoolean)
    {
      this.GQJ = System.currentTimeMillis();
      AppMethodBeat.o(202219);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.GQL > 300000L)
    {
      Log.i("MicroMsg.MemoryWatchDog", "onAppForeground: forward check");
      this.GQL = l;
      com.tencent.e.h.ZvG.bDh("MicroMsg.MemoryWatchDog");
      com.tencent.e.h.ZvG.a(this, 300000L, "MicroMsg.MemoryWatchDog");
    }
    AppMethodBeat.o(202219);
  }
  
  public final b fow()
  {
    AppMethodBeat.i(293064);
    b localb = ad(true, 0);
    AppMethodBeat.o(293064);
    return localb;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(202259);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.GQE.add(paramActivity);
      Log.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.GQE.size()) });
    }
    AppMethodBeat.o(202259);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(202267);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.GQE.remove(paramActivity);
      Log.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.GQE.size()) });
    }
    AppMethodBeat.o(202267);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(202222);
    this.fca = paramActivity.getClass().getSimpleName();
    if (fox()) {
      abd(1);
    }
    AppMethodBeat.o(202222);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(202223);
    if (fox()) {
      abd(2);
    }
    AppMethodBeat.o(202223);
  }
  
  public final void run()
  {
    AppMethodBeat.i(202240);
    vU(false);
    this.GQL = System.currentTimeMillis();
    i locali = com.tencent.e.h.ZvG;
    if (this.cQt) {}
    for (long l = 300000L;; l = 1800000L)
    {
      locali.a(this, l, "MicroMsg.MemoryWatchDog");
      AppMethodBeat.o(202240);
      return;
    }
  }
  
  public final void vU(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(202230);
    b localb = ad(true, 3);
    new StringBuilder("[AutoCheck] ").append(localb);
    Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.cQt), localb });
    if (!this.GQE.isEmpty()) {}
    for (;;)
    {
      b.a(localb, bool, paramBoolean);
      if (foz()) {
        a(localb, 3);
      }
      AppMethodBeat.o(202230);
      return;
      bool = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract String chA();
    
    public abstract String chB();
    
    public abstract String chx();
    
    public abstract String chy();
    
    public abstract String chz();
  }
  
  public static final class b
  {
    public boolean GQG;
    public Map<String, String> GQT;
    public Map<String, String> GQU;
    public int GQV;
    public List<String> GQW;
    public boolean GQX;
    public boolean GQY;
    public long GQZ;
    public long GRa;
    public long GRb;
    public long GRc;
    public long GRd;
    public long GRe;
    public long GRf;
    public long GRg;
    public long GRh;
    public long GRi;
    public ActivityManager.MemoryInfo GRj;
    public int GRk;
    public int GRl;
    public int GRm;
    public b[] GRn;
    public List<Map.Entry<String, Long>> GRo;
    public String GRp;
    public String GRq;
    public String GRr;
    public String GRs;
    public boolean cQt;
    public String extra;
    public String fca;
    public long jVo;
    public int pid;
    public String processName;
    public int source;
    
    public b()
    {
      AppMethodBeat.i(201358);
      this.processName = "current";
      this.source = 0;
      this.fca = "default";
      this.GQW = new ArrayList();
      this.GQX = c.foy();
      this.GRh = Thread.currentThread().getId();
      this.GRi = -1L;
      this.GRn = new b[0];
      this.GRo = new ArrayList();
      AppMethodBeat.o(201358);
    }
    
    private static String ay(Map<String, String> paramMap)
    {
      AppMethodBeat.i(201368);
      if (paramMap == null)
      {
        AppMethodBeat.o(201368);
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
      AppMethodBeat.o(201368);
      return paramMap;
    }
    
    public final String foA()
    {
      AppMethodBeat.i(201360);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!this.GRo.isEmpty())
      {
        localStringBuilder.append("| Top 20 mapped memory region sizes:\n");
        Iterator localIterator = this.GRo.iterator();
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
      AppMethodBeat.o(201360);
      return str;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201362);
      StringBuilder localStringBuilder1 = new StringBuilder(" \n");
      StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(tid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.GRh) })).append("\n| Activity:\t").append(this.fca).append("\tAppForeground:").append(this.cQt).append("\tProcessForeground:").append(this.GQG);
      if (c.foy())
      {
        localObject = "\thasActivity:";
        localStringBuilder2 = localStringBuilder2.append((String)localObject);
        if (!c.foy()) {
          break label486;
        }
      }
      label486:
      for (Object localObject = Boolean.valueOf(this.GQY);; localObject = "")
      {
        localStringBuilder2.append(localObject).append("\n| Source:\t ").append(this.source).append("\n| VmSize:\t ").append(this.GQV).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.GRj.totalMem).append(", availMem=").append(this.GRj.availMem).append(", lowMemory=").append(this.GRj.lowMemory).append(", threshold=").append(this.GRj.threshold).append("\n| Dalvik:\t memClass=").append(this.GRf).append(", memLargeClass=").append(this.GRg).append(" B, TalMemory=").append(this.GRc).append(" B, FreeMemory=").append(this.GRd).append(" B, MaxMemory=").append(this.GRe).append(" B\n| NATIVE:\t HeapSize=").append(this.GQZ).append(" B, AllocatedSize=").append(this.GRa).append(" B, FreeSize=").append(this.GRb).append(" B\n| Stats:\t pss-sum:").append(this.GRm).append(" KB, ").append(ay(this.GQT)).append("\n| AMSStats:\t ").append(ay(this.GQU)).append("\n| FgService:\t").append(Arrays.toString(this.GQW.toArray())).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.jVo).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        if (this.GRn == null) {
          break label492;
        }
        localObject = this.GRn;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder2 = localObject[i];
          localStringBuilder1.append("| Process: ").append(localStringBuilder2.processName).append(", pid: ").append(localStringBuilder2.pid).append(", totalPss: ").append(localStringBuilder2.GRk).append("\n");
          i += 1;
        }
        localObject = "";
        break;
      }
      label492:
      localObject = localStringBuilder1.toString();
      AppMethodBeat.o(201362);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.c
 * JD-Core Version:    0.7.0.1
 */