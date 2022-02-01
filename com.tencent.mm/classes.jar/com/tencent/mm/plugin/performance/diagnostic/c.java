package com.tencent.mm.plugin.performance.diagnostic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.hook.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class c<HOOK extends a, CONFIG extends a>
  implements com.tencent.mm.plugin.performance.a.c, e.a, ICrashReporter.ICrashReportExtraMessageGetter
{
  private static b MIv = null;
  private static String TAG = "MicroMsg.BaseHookLogic";
  private final c MIu;
  
  static
  {
    TAG += gye();
  }
  
  public c()
  {
    e.MJy.a(gyi(), this);
    CrashReportFactory.addCrashReportExtraMessageGetter(this);
    this.MIu = new c(this);
  }
  
  public static void a(b paramb)
  {
    MIv = paramb;
  }
  
  private void a(Map<String, String> paramMap, d paramd)
  {
    if (gyl())
    {
      b(paramMap, paramd);
      return;
    }
    Log.e(TAG, "[%s] crash too many times, disable the hook", new Object[] { gyi() });
    gyg().gyq();
  }
  
  public static void a(a... paramVarArgs)
  {
    HookManager localHookManager = HookManager.eUL;
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      a locala = paramVarArgs[i];
      if (locala != null) {
        j = 0;
      }
      localHookManager.a(locala);
      i += 1;
    }
    if (j == 0)
    {
      paramVarArgs = MIv;
      if (paramVarArgs != null) {
        paramVarArgs.gyb();
      }
      localHookManager.axJ();
      if (paramVarArgs != null) {
        paramVarArgs.gyc();
      }
    }
  }
  
  private void b(Map<String, String> paramMap, d paramd)
  {
    Log.i(TAG, "[%s] processCmd: [%s]", new Object[] { gyi(), paramMap });
    boolean bool1 = gyg().gyp();
    gyg().aL(paramMap);
    boolean bool2 = gyg().gyp();
    gyg().gyx();
    if ((!bool1) && (bool2) && (gyg().gyx()) && (gyn())) {
      Log.i(TAG, "[%s] hook immediately", new Object[] { gyi() });
    }
    try
    {
      a(new a[] { gyf() });
      a(paramd);
      gyk();
      this.MIu.install();
      return;
    }
    finally
    {
      Log.printErrStackTrace(TAG, paramMap, "[%s] do hook error", new Object[] { gyi() });
    }
  }
  
  public static String gye()
  {
    Object localObject = MMApplicationContext.getProcessName();
    String str = "_others_";
    if (MMApplicationContext.isMainProcess()) {
      localObject = "_MM_";
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return localObject;
        if (MMApplicationContext.isToolsProcess()) {
          return "_tools_";
        }
        if (MMApplicationContext.isToolsMpProcess()) {
          return "_mp_";
        }
        if (((String)localObject).contains(":appbrand0")) {
          return "_appbrand0_";
        }
        if (((String)localObject).contains(":appbrand1")) {
          return "_appbrand1_";
        }
        if (((String)localObject).contains(":appbrand2")) {
          return "_appbrand2_";
        }
        if (((String)localObject).contains(":appbrand3")) {
          return "_appbrand3_";
        }
        if (((String)localObject).contains(":appbrand4")) {
          return "_appbrand4_";
        }
        arrayOfString = ((String)localObject).split(":");
        localObject = str;
      } while (arrayOfString == null);
      localObject = str;
    } while (arrayOfString.length < 2);
    return "_" + arrayOfString[1] + "_";
  }
  
  private void gyk()
  {
    String str = TAG + "-repeat";
    final long l = gyg().gyw();
    com.tencent.threadpool.h.ahAA.bFQ(str);
    if (l < 0L)
    {
      Log.i(TAG, "[%s] dump cycle is negative. just disable repeating dump", new Object[] { gyi() });
      return;
    }
    com.tencent.threadpool.h.ahAA.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300873);
        if (c.this.gyg().gyp())
        {
          c.this.iT(false);
          com.tencent.threadpool.h.ahAA.a(this, l, this.MIx);
        }
        AppMethodBeat.o(300873);
      }
    }, l, str);
  }
  
  private boolean gyl()
  {
    if (BuildInfo.CLIENT_VERSION_INT != gyg().gyt()) {
      gyg().gyu();
    }
    if ((gyg().gyv() >= 3) && (!BuildInfo.DEBUG) && (!WeChatEnvironment.hasDebugger())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(TAG, "[%s] crash too many times, disable hook", new Object[] { gyi() });
        gyg().gyq();
      }
      if (i != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  protected static String gym()
  {
    if (MMApplicationContext.isMainProcess()) {
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess()) {
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess())) {
      return "tools";
    }
    return "";
  }
  
  private boolean gyn()
  {
    boolean bool = com.tencent.mm.plugin.expansions.e.aQh();
    if (!bool)
    {
      Log.e(TAG, "expansions was NOT installed yet!! disable hook [%s]", new Object[] { gyi() });
      gyg().gyq();
    }
    return bool;
  }
  
  protected void a(d paramd) {}
  
  public final void aK(Map<String, String> paramMap)
  {
    Log.e(TAG, "[%s] onReceiveCmd", new Object[] { gyi() });
    String str = (String)paramMap.get(gyg().MIz);
    if ((TextUtils.isEmpty(str)) || (d.MIN.name().equalsIgnoreCase(str))) {
      b(paramMap, d.MIN);
    }
    do
    {
      return;
      if ((!gyg().gyp()) && (d.MIO.name().equalsIgnoreCase(str)))
      {
        a(paramMap, d.MIO);
        return;
      }
    } while ((gyg().gyp()) || (!d.MIP.name().equalsIgnoreCase(str)));
    a(paramMap, d.MIP);
  }
  
  public final String getCrashReportExtraMessage()
  {
    Log.e(TAG, "[%s] crash happened", new Object[] { gyi() });
    boolean bool = gyg().gyp();
    int j = gyg().gyv();
    StringBuilder localStringBuilder = new StringBuilder(gyi()).append(":");
    localStringBuilder.append("\nenable=").append(bool);
    int i = j;
    if (bool) {}
    try
    {
      iT(true);
      Object localObject = gyh();
      localObject = localStringBuilder.append(",").append((String)localObject).append(",begin:").append(com.tencent.mm.plugin.performance.c.tc(gyg().gyr())).append(",crash times:");
      i = j + 1;
      ((StringBuilder)localObject).append(i);
      gyg().gyu();
      if ((bool) && (i >= 3))
      {
        gyg().gyq();
        Log.e(TAG, "[%s] crash happens 3 times, disable hook: %s", new Object[] { gyi(), gyi() });
        com.tencent.mm.plugin.report.service.h.OAn.p(1376L, 1L, 1L);
      }
      return localStringBuilder.toString();
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, localThrowable, "error onCrash", new Object[0]);
      }
    }
  }
  
  public final String gxZ()
  {
    return ".cmd.diagnostic." + gyi();
  }
  
  public void gya() {}
  
  protected abstract HOOK gyf();
  
  public abstract CONFIG gyg();
  
  protected abstract String gyh();
  
  protected String gyi()
  {
    return null;
  }
  
  public final HOOK gyj()
  {
    Log.i(TAG, "[%s] boot", new Object[] { gyi() });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l1;
    long l2;
    int i;
    if (gyl())
    {
      localObject1 = localObject2;
      if (gyg().gyp())
      {
        localObject1 = localObject2;
        if (gyg().gyx())
        {
          l1 = 3600000L * gyg().aft(0);
          l2 = gyg().gyr();
          Log.i(TAG, "[%s] hook duration = %s, hook begin time = %s", new Object[] { gyi(), Long.valueOf(l1), com.tencent.mm.plugin.performance.c.tc(l2) });
          if (l2 >= 0L) {
            break label264;
          }
          l1 = System.currentTimeMillis();
          gyg().td(l1);
          Log.i(TAG, "[%s] update hookBeginTime = %s", new Object[] { gyi(), Long.valueOf(l1) });
          i = 1;
          label168:
          localObject1 = localObject2;
          if (i != 0)
          {
            localObject1 = localObject2;
            if (gyn())
            {
              localObject2 = gyf();
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                gyk();
                this.MIu.install();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    localObject2 = TAG;
    String str = gyi();
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject2, "[%s] boot enable=%s", new Object[] { str, Boolean.valueOf(bool) });
      return localObject1;
      label264:
      i = gyg().gyt();
      long l3 = System.currentTimeMillis();
      if ((l3 - l2 <= l1) && (i == BuildInfo.CLIENT_VERSION_INT)) {
        break;
      }
      gyg().gyq();
      Log.i(TAG, "[%s] time out, disable hook: (%s > %s || 0x%x != 0x%x)", new Object[] { gyi(), Long.valueOf(l3 - l2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT) });
      i = 0;
      break label168;
    }
  }
  
  public final void gyo()
  {
    if (gyg().gyp()) {
      this.MIu.te(System.currentTimeMillis());
    }
  }
  
  public abstract void iT(boolean paramBoolean);
  
  public static abstract class a
  {
    private final String MIA;
    private final String MIB;
    private final String MIC;
    private final String MID;
    private final String MIE;
    private final String MIF;
    private final String MIG;
    private final String MIH;
    private final String MII;
    protected final String MIz;
    protected MultiProcessMMKV evW = MultiProcessMMKV.getMMKV("diagnostic_storage");
    
    public a(c<? extends a, ? extends a> paramc)
    {
      this.MII = paramc.gyi();
      this.MIz = (paramc.gxZ() + ".$source");
      this.MIA = (paramc.gxZ() + ".$enable");
      this.MIB = (paramc.gxZ() + ".$duration");
      this.MIC = (paramc.gxZ() + ".begin");
      this.MID = (paramc.gxZ() + ".$multiprocess");
      this.MIE = (paramc.gxZ() + ".$process");
      this.MIF = (paramc.gxZ() + ".clientversion");
      this.MIG = (paramc.gxZ() + ".crash");
      this.MIH = (paramc.gxZ() + ".$dumpcycle");
    }
    
    @Deprecated
    private boolean gys()
    {
      return this.evW.decodeBool(this.MID, false);
    }
    
    public void aL(Map<String, String> paramMap)
    {
      Log.i(c.TAG, "convert and save config");
      this.evW.encode(this.MIA, "1".equals(paramMap.get(this.MIA)));
      this.evW.encode(this.MIB, Util.getInt((String)paramMap.get(this.MIB), 0));
      this.evW.encode(this.MIC, System.currentTimeMillis());
      this.evW.encode(this.MID, "1".equals(paramMap.get(this.MID)));
      this.evW.encode(this.MIE, (String)paramMap.get(this.MIE));
      this.evW.encode(this.MIF, BuildInfo.CLIENT_VERSION_INT);
    }
    
    public final int aft(int paramInt)
    {
      return this.evW.decodeInt(this.MIB, paramInt);
    }
    
    public final String getTargetProcess()
    {
      return this.evW.decodeString(this.MIE, "");
    }
    
    public final boolean gyp()
    {
      return this.evW.decodeBool(this.MIA, false);
    }
    
    public final void gyq()
    {
      this.evW.encode(this.MIA, false);
    }
    
    public final long gyr()
    {
      return this.evW.decodeLong(this.MIC, 0L);
    }
    
    public final int gyt()
    {
      return this.evW.decodeInt(this.MIF, -1);
    }
    
    public final void gyu()
    {
      this.evW.encode(this.MIG, 0);
    }
    
    public final int gyv()
    {
      return this.evW.decodeInt(this.MIG, 0);
    }
    
    public long gyw()
    {
      return TimeUnit.MINUTES.toMillis(this.evW.decodeLong(this.MIH, 30L));
    }
    
    public final boolean gyx()
    {
      boolean bool = gys();
      String str = getTargetProcess();
      Log.i(c.TAG, "[%s] filterProcess: target process is %s, current process is %s", new Object[] { this.MII, str, MMApplicationContext.getProcessName() });
      if ((str.contains("all")) || ((TextUtils.isEmpty(str)) && (bool))) {}
      while (((str.contains("mm")) || (TextUtils.isEmpty(str))) && ((MMApplicationContext.isMainProcess()) || ((str.contains("appbrand")) && (MMApplicationContext.isAppBrandProcess())) || ((str.contains("tools")) && ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))))) {
        return true;
      }
      return false;
    }
    
    public final void td(long paramLong)
    {
      this.evW.encode(this.MIC, paramLong);
    }
  }
  
  public static abstract interface b
  {
    public abstract void gyb();
    
    public abstract void gyc();
  }
  
  static final class c
    extends BroadcastReceiver
  {
    private boolean MIJ;
    private final c<? extends a, ? extends c.a> MIK;
    private long MIL;
    private final String mnL;
    
    public c(c<? extends a, ? extends c.a> paramc)
    {
      AppMethodBeat.i(300864);
      this.MIK = paramc;
      this.mnL = ("com.tencent.mm.report." + paramc.gyi());
      AppMethodBeat.o(300864);
    }
    
    /* Error */
    final void install()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 62
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 64	com/tencent/mm/plugin/performance/diagnostic/c$c:MIJ	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 62
      //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: new 66	android/content/IntentFilter
      //   25: dup
      //   26: aload_0
      //   27: getfield 52	com/tencent/mm/plugin/performance/diagnostic/c$c:mnL	Ljava/lang/String;
      //   30: invokespecial 67	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   33: astore_1
      //   34: invokestatic 73	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   37: aload_0
      //   38: aload_1
      //   39: ldc 75
      //   41: aconst_null
      //   42: invokevirtual 81	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   45: pop
      //   46: aload_0
      //   47: iconst_1
      //   48: putfield 64	com/tencent/mm/plugin/performance/diagnostic/c$c:MIJ	Z
      //   51: invokestatic 84	com/tencent/mm/plugin/performance/diagnostic/c:access$000	()Ljava/lang/String;
      //   54: ldc 86
      //   56: iconst_1
      //   57: anewarray 88	java/lang/Object
      //   60: dup
      //   61: iconst_0
      //   62: aload_0
      //   63: getfield 32	com/tencent/mm/plugin/performance/diagnostic/c$c:MIK	Lcom/tencent/mm/plugin/performance/diagnostic/c;
      //   66: invokevirtual 43	com/tencent/mm/plugin/performance/diagnostic/c:gyi	()Ljava/lang/String;
      //   69: aastore
      //   70: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   73: ldc 62
      //   75: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   78: goto -59 -> 19
      //   81: astore_1
      //   82: aload_0
      //   83: monitorexit
      //   84: aload_1
      //   85: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	c
      //   33	6	1	localIntentFilter	android.content.IntentFilter
      //   81	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	81	finally
      //   22	78	81	finally
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(300894);
      long l = paramIntent.getLongExtra("PARAM_KEY_TOKEN", 0L);
      paramContext = paramIntent.getAction();
      Log.i(c.TAG, "[%s] received token [%s], action [%s]", new Object[] { this.MIK.gyi(), Long.valueOf(l), paramContext });
      if (l == 0L)
      {
        Log.e(c.TAG, "[%s] ERR: report token should not be 0", new Object[] { this.MIK.gyi() });
        AppMethodBeat.o(300894);
        return;
      }
      if (l <= this.MIL)
      {
        Log.i(c.TAG, "[%s] already reported, xfer to next process, token [%s]", new Object[] { this.MIK.gyi(), Long.valueOf(l) });
        AppMethodBeat.o(300894);
        return;
      }
      this.MIL = l;
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300877);
          Log.d(c.TAG, "[%s] report async", new Object[] { c.this.gyi() });
          c.this.iT(false);
          Log.d(c.TAG, "[%s] report done.", new Object[] { c.this.gyi() });
          AppMethodBeat.o(300877);
        }
      }, "HookReporter");
      AppMethodBeat.o(300894);
    }
    
    final void te(long paramLong)
    {
      AppMethodBeat.i(300883);
      Log.d(c.TAG, "[%s] report token: %s", new Object[] { this.MIK.gyi(), Long.valueOf(paramLong) });
      Intent localIntent = new Intent(this.mnL);
      localIntent.putExtra("PARAM_KEY_TOKEN", paramLong);
      MMApplicationContext.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(300883);
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(300867);
      MIN = new d("PUSH", 0);
      MIO = new d("AUTO", 1);
      MIP = new d("EXPT", 2);
      MIQ = new d[] { MIN, MIO, MIP };
      AppMethodBeat.o(300867);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c
 * JD-Core Version:    0.7.0.1
 */