package com.tencent.mm.plugin.performance.diagnostic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class c<HOOK extends com.tencent.matrix.hook.a, CONFIG extends a>
  implements com.tencent.mm.plugin.performance.a.c, e.a, ICrashReporter.ICrashReportExtraMessageGetter
{
  private static b GLA = null;
  private static String TAG = "MicroMsg.BaseHookLogic";
  private final c GLz;
  
  static
  {
    TAG += fnr();
  }
  
  public c()
  {
    e.GMC.a(fnv(), this);
    CrashReportFactory.addCrashReportExtraMessageGetter(this);
    this.GLz = new c(this);
  }
  
  public static void a(b paramb)
  {
    GLA = paramb;
  }
  
  private void a(Map<String, String> paramMap, d paramd)
  {
    if (fny())
    {
      b(paramMap, paramd);
      return;
    }
    Log.e(TAG, "[%s] crash too many times, disable the hook", new Object[] { fnv() });
    fnt().fnC();
  }
  
  public static void a(com.tencent.matrix.hook.a... paramVarArgs)
  {
    HookManager localHookManager = HookManager.cYg;
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      com.tencent.matrix.hook.a locala = paramVarArgs[i];
      if (locala != null) {
        j = 0;
      }
      localHookManager.a(locala);
      i += 1;
    }
    if (j == 0)
    {
      paramVarArgs = GLA;
      if (paramVarArgs != null) {
        paramVarArgs.fno();
      }
      localHookManager.WL();
      if (paramVarArgs != null) {
        paramVarArgs.fnp();
      }
    }
  }
  
  private void b(Map<String, String> paramMap, d paramd)
  {
    Log.i(TAG, "[%s] processCmd: [%s]", new Object[] { fnv(), paramMap });
    boolean bool1 = fnt().fnB();
    fnt().av(paramMap);
    boolean bool2 = fnt().fnB();
    fnt().fnJ();
    if ((!bool1) && (bool2) && (fnt().fnJ()))
    {
      com.tencent.mm.plugin.expansions.a.dbf();
      Log.i(TAG, "[%s] hook immediately", new Object[] { fnv() });
    }
    try
    {
      a(new com.tencent.matrix.hook.a[] { fns() });
      a(paramd);
      fnx();
      this.GLz.install();
      return;
    }
    catch (Throwable paramMap)
    {
      Log.printErrStackTrace(TAG, paramMap, "[%s] do hook error", new Object[] { fnv() });
    }
  }
  
  public static String fnr()
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
  
  private void fnx()
  {
    String str = TAG + "-repeat";
    final long l = fnt().fnI();
    com.tencent.e.h.ZvG.bDh(str);
    if (l < 0L)
    {
      Log.i(TAG, "[%s] dump cycle is negative. just disable repeating dump", new Object[] { fnv() });
      return;
    }
    com.tencent.e.h.ZvG.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201722);
        if (c.this.fnt().fnB())
        {
          c.this.hU(false);
          com.tencent.e.h.ZvG.a(this, l, this.GLC);
        }
        AppMethodBeat.o(201722);
      }
    }, l, str);
  }
  
  private boolean fny()
  {
    if (BuildInfo.CLIENT_VERSION_INT != fnt().fnF()) {
      fnt().fnG();
    }
    if ((fnt().fnH() >= 3) && (!BuildInfo.DEBUG) && (!WeChatEnvironment.hasDebugger())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(TAG, "[%s] crash too many times, disable hook", new Object[] { fnv() });
        fnt().fnC();
      }
      if (i != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  protected static String fnz()
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
  
  protected void a(d paramd) {}
  
  public final void au(Map<String, String> paramMap)
  {
    Log.e(TAG, "[%s] onReceiveCmd", new Object[] { fnv() });
    String str = (String)paramMap.get(fnt().GLE);
    if ((TextUtils.isEmpty(str)) || (d.GLR.name().equalsIgnoreCase(str))) {
      b(paramMap, d.GLR);
    }
    do
    {
      return;
      if ((!fnt().fnB()) && (d.GLS.name().equalsIgnoreCase(str)))
      {
        a(paramMap, d.GLS);
        return;
      }
    } while ((fnt().fnB()) || (!d.GLT.name().equalsIgnoreCase(str)));
    a(paramMap, d.GLT);
  }
  
  public final void fnA()
  {
    if (fnt().fnB()) {
      this.GLz.Pb(System.currentTimeMillis());
    }
  }
  
  public final String fnm()
  {
    return ".cmd.diagnostic." + fnv();
  }
  
  public void fnn() {}
  
  protected abstract HOOK fns();
  
  public abstract CONFIG fnt();
  
  protected abstract String fnu();
  
  protected String fnv()
  {
    return null;
  }
  
  public final HOOK fnw()
  {
    Log.i(TAG, "[%s] boot", new Object[] { fnv() });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l1;
    long l2;
    int i;
    if (fny())
    {
      localObject1 = localObject2;
      if (fnt().fnB())
      {
        localObject1 = localObject2;
        if (fnt().fnJ())
        {
          l1 = 3600000L * fnt().aba(0);
          l2 = fnt().fnD();
          Log.i(TAG, "[%s] hook duration = %s, hook begin time = %s", new Object[] { fnv(), Long.valueOf(l1), com.tencent.mm.plugin.performance.c.OZ(l2) });
          if (l2 >= 0L) {
            break label257;
          }
          l1 = System.currentTimeMillis();
          fnt().Pa(l1);
          Log.i(TAG, "[%s] update hookBeginTime = %s", new Object[] { fnv(), Long.valueOf(l1) });
          i = 1;
          label168:
          localObject1 = localObject2;
          if (i != 0)
          {
            com.tencent.mm.plugin.expansions.a.dbf();
            localObject2 = fns();
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              fnx();
              this.GLz.install();
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    localObject2 = TAG;
    String str = fnv();
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject2, "[%s] boot enable=%s", new Object[] { str, Boolean.valueOf(bool) });
      return localObject1;
      label257:
      i = fnt().fnF();
      long l3 = System.currentTimeMillis();
      if ((l3 - l2 <= l1) && (i == BuildInfo.CLIENT_VERSION_INT)) {
        break;
      }
      fnt().fnC();
      Log.i(TAG, "[%s] time out, disable hook: (%s > %s || 0x%x != 0x%x)", new Object[] { fnv(), Long.valueOf(l3 - l2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT) });
      i = 0;
      break label168;
    }
  }
  
  public final String getCrashReportExtraMessage()
  {
    Log.e(TAG, "[%s] crash happened", new Object[] { fnv() });
    boolean bool = fnt().fnB();
    int j = fnt().fnH();
    StringBuilder localStringBuilder = new StringBuilder(fnv()).append(":");
    localStringBuilder.append("\nenable=").append(bool);
    int i = j;
    if (bool) {}
    try
    {
      hU(true);
      Object localObject = fnu();
      localObject = localStringBuilder.append(",").append((String)localObject).append(",begin:").append(com.tencent.mm.plugin.performance.c.OZ(fnt().fnD())).append(",crash times:");
      i = j + 1;
      ((StringBuilder)localObject).append(i);
      fnt().fnG();
      if ((bool) && (i >= 3))
      {
        fnt().fnC();
        Log.e(TAG, "[%s] crash happens 3 times, disable hook: %s", new Object[] { fnv(), fnv() });
        com.tencent.mm.plugin.report.service.h.IzE.p(1376L, 1L, 1L);
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, localThrowable, "error onCrash", new Object[0]);
      }
    }
  }
  
  public abstract void hU(boolean paramBoolean);
  
  public static abstract class a
  {
    protected final String GLE;
    private final String GLF;
    private final String GLG;
    private final String GLH;
    private final String GLI;
    private final String GLJ;
    private final String GLK;
    private final String GLL;
    private final String GLM;
    private final String GLN;
    protected MultiProcessMMKV fbr = MultiProcessMMKV.getMMKV("diagnostic_storage");
    
    public a(c<? extends com.tencent.matrix.hook.a, ? extends a> paramc)
    {
      this.GLN = paramc.fnv();
      this.GLE = (paramc.fnm() + ".$source");
      this.GLF = (paramc.fnm() + ".$enable");
      this.GLG = (paramc.fnm() + ".$duration");
      this.GLH = (paramc.fnm() + ".begin");
      this.GLI = (paramc.fnm() + ".$multiprocess");
      this.GLJ = (paramc.fnm() + ".$process");
      this.GLK = (paramc.fnm() + ".clientversion");
      this.GLL = (paramc.fnm() + ".crash");
      this.GLM = (paramc.fnm() + ".$dumpcycle");
    }
    
    @Deprecated
    private boolean fnE()
    {
      return this.fbr.decodeBool(this.GLI, false);
    }
    
    public final void Pa(long paramLong)
    {
      this.fbr.encode(this.GLH, paramLong);
    }
    
    public final int aba(int paramInt)
    {
      return this.fbr.decodeInt(this.GLG, paramInt);
    }
    
    public void av(Map<String, String> paramMap)
    {
      Log.i(c.TAG, "convert and save config");
      this.fbr.encode(this.GLF, "1".equals(paramMap.get(this.GLF)));
      this.fbr.encode(this.GLG, Util.getInt((String)paramMap.get(this.GLG), 0));
      this.fbr.encode(this.GLH, System.currentTimeMillis());
      this.fbr.encode(this.GLI, "1".equals(paramMap.get(this.GLI)));
      this.fbr.encode(this.GLJ, (String)paramMap.get(this.GLJ));
      this.fbr.encode(this.GLK, BuildInfo.CLIENT_VERSION_INT);
    }
    
    public final boolean fnB()
    {
      return this.fbr.decodeBool(this.GLF, false);
    }
    
    public final void fnC()
    {
      this.fbr.encode(this.GLF, false);
    }
    
    public final long fnD()
    {
      return this.fbr.decodeLong(this.GLH, 0L);
    }
    
    public final int fnF()
    {
      return this.fbr.decodeInt(this.GLK, -1);
    }
    
    public final void fnG()
    {
      this.fbr.encode(this.GLL, 0);
    }
    
    public final int fnH()
    {
      return this.fbr.decodeInt(this.GLL, 0);
    }
    
    public long fnI()
    {
      return TimeUnit.MINUTES.toMillis(this.fbr.decodeLong(this.GLM, 30L));
    }
    
    public final boolean fnJ()
    {
      boolean bool = fnE();
      String str = getTargetProcess();
      Log.i(c.TAG, "[%s] filterProcess: target process is %s, current process is %s", new Object[] { this.GLN, str, MMApplicationContext.getProcessName() });
      if ((str.contains("all")) || ((TextUtils.isEmpty(str)) && (bool))) {}
      while (((str.contains("mm")) || (TextUtils.isEmpty(str))) && ((MMApplicationContext.isMainProcess()) || ((str.contains("appbrand")) && (MMApplicationContext.isAppBrandProcess())) || ((str.contains("tools")) && ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))))) {
        return true;
      }
      return false;
    }
    
    public final String getTargetProcess()
    {
      return this.fbr.decodeString(this.GLJ, "");
    }
  }
  
  public static abstract interface b
  {
    public abstract void fno();
    
    public abstract void fnp();
  }
  
  static final class c
    extends BroadcastReceiver
  {
    private final String ACTION;
    private final c<? extends com.tencent.matrix.hook.a, ? extends c.a> GLO;
    private long GLP;
    private boolean ddV;
    
    public c(c<? extends com.tencent.matrix.hook.a, ? extends c.a> paramc)
    {
      AppMethodBeat.i(200712);
      this.GLO = paramc;
      this.ACTION = ("com.tencent.mm.report." + paramc.fnv());
      AppMethodBeat.o(200712);
    }
    
    final void Pb(long paramLong)
    {
      AppMethodBeat.i(200716);
      Log.d(c.TAG, "[%s] report token: %s", new Object[] { this.GLO.fnv(), Long.valueOf(paramLong) });
      Intent localIntent = new Intent(this.ACTION);
      localIntent.putExtra("PARAM_KEY_TOKEN", paramLong);
      MMApplicationContext.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(200716);
    }
    
    /* Error */
    final void install()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 107
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 109	com/tencent/mm/plugin/performance/diagnostic/c$c:ddV	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 107
      //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: new 111	android/content/IntentFilter
      //   25: dup
      //   26: aload_0
      //   27: getfield 52	com/tencent/mm/plugin/performance/diagnostic/c$c:ACTION	Ljava/lang/String;
      //   30: invokespecial 112	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
      //   33: astore_1
      //   34: invokestatic 97	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   37: aload_0
      //   38: aload_1
      //   39: ldc 99
      //   41: aconst_null
      //   42: invokevirtual 116	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   45: pop
      //   46: aload_0
      //   47: iconst_1
      //   48: putfield 109	com/tencent/mm/plugin/performance/diagnostic/c$c:ddV	Z
      //   51: invokestatic 66	com/tencent/mm/plugin/performance/diagnostic/c:access$000	()Ljava/lang/String;
      //   54: ldc 118
      //   56: iconst_1
      //   57: anewarray 70	java/lang/Object
      //   60: dup
      //   61: iconst_0
      //   62: aload_0
      //   63: getfield 32	com/tencent/mm/plugin/performance/diagnostic/c$c:GLO	Lcom/tencent/mm/plugin/performance/diagnostic/c;
      //   66: invokevirtual 43	com/tencent/mm/plugin/performance/diagnostic/c:fnv	()Ljava/lang/String;
      //   69: aastore
      //   70: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   73: ldc 107
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
      AppMethodBeat.i(200718);
      long l = paramIntent.getLongExtra("PARAM_KEY_TOKEN", 0L);
      paramContext = paramIntent.getAction();
      Log.i(c.TAG, "[%s] received token [%s], action [%s]", new Object[] { this.GLO.fnv(), Long.valueOf(l), paramContext });
      if (l == 0L)
      {
        Log.e(c.TAG, "[%s] ERR: report token should not be 0", new Object[] { this.GLO.fnv() });
        AppMethodBeat.o(200718);
        return;
      }
      if (l <= this.GLP)
      {
        Log.i(c.TAG, "[%s] already reported, xfer to next process, token [%s]", new Object[] { this.GLO.fnv(), Long.valueOf(l) });
        AppMethodBeat.o(200718);
        return;
      }
      this.GLP = l;
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200813);
          Log.d(c.TAG, "[%s] report async", new Object[] { c.this.fnv() });
          c.this.hU(false);
          Log.d(c.TAG, "[%s] report done.", new Object[] { c.this.fnv() });
          AppMethodBeat.o(200813);
        }
      }, "HookReporter");
      AppMethodBeat.o(200718);
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(200960);
      GLR = new d("PUSH", 0);
      GLS = new d("AUTO", 1);
      GLT = new d("EXPT", 2);
      GLU = new d[] { GLR, GLS, GLT };
      AppMethodBeat.o(200960);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c
 * JD-Core Version:    0.7.0.1
 */