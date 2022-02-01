package com.tencent.mm.plugin.performance.diagnostic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.wxperf.jni.HookManager;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a<HOOK extends com.tencent.wxperf.jni.a, CONFIG extends a>
  implements com.tencent.mm.plugin.performance.a.c, c.a, ICrashReporter.ICrashReportExtraMessageGetter
{
  private static String TAG = "MicroMsg.BaseHookLogic";
  private final b ASf;
  
  static
  {
    TAG += eBE();
  }
  
  public a()
  {
    c.ATi.a(eBI(), this);
    CrashReportFactory.addCrashReportExtraMessageGetter(this);
    this.ASf = new b(this);
  }
  
  private void a(Map<String, String> paramMap, c paramc)
  {
    if (eBL())
    {
      b(paramMap, paramc);
      return;
    }
    Log.e(TAG, "[%s] crash too many times, disable the hook", new Object[] { eBI() });
    eBG().eBP();
  }
  
  private void b(Map<String, String> paramMap, c paramc)
  {
    Log.i(TAG, "[%s] processCmd: [%s]", new Object[] { eBI(), paramMap });
    boolean bool1 = eBG().eBO();
    eBG().aB(paramMap);
    boolean bool2 = eBG().eBO();
    if ((!bool1) && (bool2) && (eBG().eBW()))
    {
      com.tencent.mm.plugin.expansions.a.cMr();
      Log.i(TAG, "[%s] hook immediately", new Object[] { eBI() });
    }
    try
    {
      HookManager.Syn.hsa().a(eBF()).hrZ();
      a(paramc);
      eBK();
      this.ASf.install();
      return;
    }
    catch (Throwable paramMap)
    {
      Log.printErrStackTrace(TAG, paramMap, "[%s] do hook error", new Object[] { eBI() });
    }
  }
  
  public static String eBE()
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
  
  private void eBK()
  {
    String str = TAG + "-repeat";
    final long l = eBG().eBV();
    com.tencent.f.h.RTc.bqo(str);
    if (l < 0L)
    {
      Log.i(TAG, "[%s] dump cycle is negative. just disable repeating dump", new Object[] { eBI() });
      return;
    }
    com.tencent.f.h.RTc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201018);
        if (a.this.eBG().eBO())
        {
          a.this.hd(false);
          com.tencent.f.h.RTc.a(this, l, this.ASh);
        }
        AppMethodBeat.o(201018);
      }
    }, l, str);
  }
  
  private boolean eBL()
  {
    if (BuildInfo.CLIENT_VERSION_INT != eBG().eBS()) {
      eBG().eBT();
    }
    if ((eBG().eBU() >= 3) && (!BuildInfo.DEBUG) && (!WeChatEnvironment.hasDebugger())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(TAG, "[%s] crash too many times, disable hook", new Object[] { eBI() });
        eBG().eBP();
      }
      if (i != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  protected static String eBM()
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
  
  protected void a(c paramc) {}
  
  public final void aA(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get(eBG().ASj);
    if ((TextUtils.isEmpty(str)) || (c.ASx.name().equalsIgnoreCase(str))) {
      b(paramMap, c.ASx);
    }
    do
    {
      return;
      if ((!eBG().eBO()) && (c.ASy.name().equalsIgnoreCase(str)))
      {
        a(paramMap, c.ASy);
        return;
      }
    } while ((eBG().eBO()) || (!c.ASz.name().equalsIgnoreCase(str)));
    a(paramMap, c.ASz);
  }
  
  public final String eBC()
  {
    return ".cmd.diagnostic." + eBI();
  }
  
  public void eBD() {}
  
  protected abstract HOOK eBF();
  
  public abstract CONFIG eBG();
  
  protected abstract String eBH();
  
  protected abstract String eBI();
  
  public final HOOK eBJ()
  {
    Log.i(TAG, "[%s] boot", new Object[] { eBI() });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l1;
    long l2;
    int i;
    if (eBL())
    {
      localObject1 = localObject2;
      if (eBG().eBO())
      {
        localObject1 = localObject2;
        if (eBG().eBW())
        {
          l1 = 3600000L * eBG().Up(0);
          l2 = eBG().eBQ();
          Log.i(TAG, "[%s] hook duration = %s, hook begin time = %s", new Object[] { eBI(), Long.valueOf(l1), com.tencent.mm.plugin.performance.c.HF(l2) });
          if (l2 >= 0L) {
            break label257;
          }
          l1 = System.currentTimeMillis();
          eBG().HG(l1);
          Log.i(TAG, "[%s] update hookBeginTime = %s", new Object[] { eBI(), Long.valueOf(l1) });
          i = 1;
          label168:
          localObject1 = localObject2;
          if (i != 0)
          {
            com.tencent.mm.plugin.expansions.a.cMr();
            localObject2 = eBF();
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              eBK();
              this.ASf.install();
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    localObject2 = TAG;
    String str = eBI();
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject2, "[%s] boot enable=%s", new Object[] { str, Boolean.valueOf(bool) });
      return localObject1;
      label257:
      i = eBG().eBS();
      long l3 = System.currentTimeMillis();
      if ((l3 - l2 <= l1) && (i == BuildInfo.CLIENT_VERSION_INT)) {
        break;
      }
      eBG().eBP();
      Log.i(TAG, "[%s] time out, disable hook: (%s > %s || 0x%x != 0x%x)", new Object[] { eBI(), Long.valueOf(l3 - l2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT) });
      i = 0;
      break label168;
    }
  }
  
  public final void eBN()
  {
    if (eBG().eBO()) {
      this.ASf.HH(System.currentTimeMillis());
    }
  }
  
  public final String getCrashReportExtraMessage()
  {
    Log.e(TAG, "[%s] crash happened", new Object[] { eBI() });
    boolean bool = eBG().eBO();
    int j = eBG().eBU();
    StringBuilder localStringBuilder = new StringBuilder(eBI()).append(":");
    localStringBuilder.append("\nenable=").append(bool);
    int i = j;
    if (bool) {}
    try
    {
      hd(true);
      Object localObject = eBH();
      localObject = localStringBuilder.append(",").append((String)localObject).append(",begin:").append(com.tencent.mm.plugin.performance.c.HF(eBG().eBQ())).append(",crash times:");
      i = j + 1;
      ((StringBuilder)localObject).append(i);
      eBG().eBT();
      if ((bool) && (i >= 3))
      {
        eBG().eBP();
        Log.e(TAG, "[%s] crash happens 3 times, disable hook: %s", new Object[] { eBI(), eBI() });
        com.tencent.mm.plugin.report.service.h.CyF.n(1376L, 1L, 1L);
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
  
  public abstract void hd(boolean paramBoolean);
  
  public static abstract class a
  {
    protected final String ASj;
    private final String ASk;
    private final String ASl;
    private final String ASm;
    private final String ASn;
    private final String ASo;
    private final String ASp;
    private final String ASq;
    private final String ASr;
    private final String ASs;
    protected MultiProcessMMKV djK = MultiProcessMMKV.getMMKV("diagnostic_storage");
    
    public a(a<? extends com.tencent.wxperf.jni.a, ? extends a> parama)
    {
      this.ASs = parama.eBI();
      this.ASj = (parama.eBC() + ".$source");
      this.ASk = (parama.eBC() + ".$enable");
      this.ASl = (parama.eBC() + ".$duration");
      this.ASm = (parama.eBC() + ".begin");
      this.ASn = (parama.eBC() + ".$multiprocess");
      this.ASo = (parama.eBC() + ".$process");
      this.ASp = (parama.eBC() + ".clientversion");
      this.ASq = (parama.eBC() + ".crash");
      this.ASr = (parama.eBC() + ".$dumpcycle");
    }
    
    @Deprecated
    private boolean eBR()
    {
      return this.djK.decodeBool(this.ASn, false);
    }
    
    public final void HG(long paramLong)
    {
      this.djK.encode(this.ASm, paramLong);
    }
    
    public final int Up(int paramInt)
    {
      return this.djK.decodeInt(this.ASl, paramInt);
    }
    
    public void aB(Map<String, String> paramMap)
    {
      Log.i(a.TAG, "convert and save config");
      this.djK.encode(this.ASk, "1".equals(paramMap.get(this.ASk)));
      this.djK.encode(this.ASl, Util.getInt((String)paramMap.get(this.ASl), 0));
      this.djK.encode(this.ASm, System.currentTimeMillis());
      this.djK.encode(this.ASn, "1".equals(paramMap.get(this.ASn)));
      this.djK.encode(this.ASo, (String)paramMap.get(this.ASo));
      this.djK.encode(this.ASp, BuildInfo.CLIENT_VERSION_INT);
    }
    
    public final boolean eBO()
    {
      return this.djK.decodeBool(this.ASk, false);
    }
    
    public final void eBP()
    {
      this.djK.encode(this.ASk, false);
    }
    
    public final long eBQ()
    {
      return this.djK.decodeLong(this.ASm, 0L);
    }
    
    public final int eBS()
    {
      return this.djK.decodeInt(this.ASp, -1);
    }
    
    public final void eBT()
    {
      this.djK.encode(this.ASq, 0);
    }
    
    public final int eBU()
    {
      return this.djK.decodeInt(this.ASq, 0);
    }
    
    public long eBV()
    {
      return TimeUnit.MINUTES.toMillis(this.djK.decodeLong(this.ASr, 30L));
    }
    
    public final boolean eBW()
    {
      boolean bool = eBR();
      String str = getTargetProcess();
      Log.i(a.TAG, "[%s] filterProcess: target process is %s, current process is %s", new Object[] { this.ASs, str, MMApplicationContext.getProcessName() });
      if ((str.contains("all")) || ((TextUtils.isEmpty(str)) && (bool))) {}
      while (((str.contains("mm")) || (TextUtils.isEmpty(str))) && ((MMApplicationContext.isMainProcess()) || ((str.contains("appbrand")) && (MMApplicationContext.isAppBrandProcess())) || ((str.contains("tools")) && ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))))) {
        return true;
      }
      return false;
    }
    
    public final String getTargetProcess()
    {
      return this.djK.decodeString(this.ASo, "");
    }
  }
  
  static final class b
    extends BroadcastReceiver
  {
    private final String ACTION;
    private boolean ASt;
    private final a<? extends com.tencent.wxperf.jni.a, ? extends a.a> ASu;
    private long ASv;
    
    public b(a<? extends com.tencent.wxperf.jni.a, ? extends a.a> parama)
    {
      AppMethodBeat.i(201020);
      this.ASu = parama;
      this.ACTION = ("com.tencent.mm.report." + parama.eBI());
      AppMethodBeat.o(201020);
    }
    
    final void HH(long paramLong)
    {
      AppMethodBeat.i(201022);
      Log.d(a.TAG, "[%s] report token: %s", new Object[] { this.ASu.eBI(), Long.valueOf(paramLong) });
      Intent localIntent = new Intent(this.ACTION);
      localIntent.putExtra("PARAM_KEY_TOKEN", paramLong);
      MMApplicationContext.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(201022);
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
      //   8: getfield 109	com/tencent/mm/plugin/performance/diagnostic/a$b:ASt	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 107
      //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: new 111	android/content/IntentFilter
      //   25: dup
      //   26: aload_0
      //   27: getfield 52	com/tencent/mm/plugin/performance/diagnostic/a$b:ACTION	Ljava/lang/String;
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
      //   48: putfield 109	com/tencent/mm/plugin/performance/diagnostic/a$b:ASt	Z
      //   51: invokestatic 66	com/tencent/mm/plugin/performance/diagnostic/a:access$000	()Ljava/lang/String;
      //   54: ldc 118
      //   56: iconst_1
      //   57: anewarray 70	java/lang/Object
      //   60: dup
      //   61: iconst_0
      //   62: aload_0
      //   63: getfield 32	com/tencent/mm/plugin/performance/diagnostic/a$b:ASu	Lcom/tencent/mm/plugin/performance/diagnostic/a;
      //   66: invokevirtual 43	com/tencent/mm/plugin/performance/diagnostic/a:eBI	()Ljava/lang/String;
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
      //   0	86	0	this	b
      //   33	6	1	localIntentFilter	android.content.IntentFilter
      //   81	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	81	finally
      //   22	78	81	finally
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(201023);
      long l = paramIntent.getLongExtra("PARAM_KEY_TOKEN", 0L);
      paramContext = paramIntent.getAction();
      Log.i(a.TAG, "[%s] received token [%s], action [%s]", new Object[] { this.ASu.eBI(), Long.valueOf(l), paramContext });
      if (l == 0L)
      {
        Log.e(a.TAG, "[%s] ERR: report token should not be 0", new Object[] { this.ASu.eBI() });
        AppMethodBeat.o(201023);
        return;
      }
      if (l <= this.ASv)
      {
        Log.i(a.TAG, "[%s] already reported, xfer to next process, token [%s]", new Object[] { this.ASu.eBI(), Long.valueOf(l) });
        AppMethodBeat.o(201023);
        return;
      }
      this.ASv = l;
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201019);
          Log.d(a.TAG, "[%s] report async", new Object[] { a.this.eBI() });
          a.this.hd(false);
          Log.d(a.TAG, "[%s] report done.", new Object[] { a.this.eBI() });
          AppMethodBeat.o(201019);
        }
      }, "HookReporter");
      AppMethodBeat.o(201023);
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(201026);
      ASx = new c("PUSH", 0);
      ASy = new c("AUTO", 1);
      ASz = new c("EXPT", 2);
      ASA = new c[] { ASx, ASy, ASz };
      AppMethodBeat.o(201026);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a
 * JD-Core Version:    0.7.0.1
 */