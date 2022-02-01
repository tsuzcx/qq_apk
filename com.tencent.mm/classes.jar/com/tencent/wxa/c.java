package com.tencent.wxa;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d.b.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineGroup;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  private static final Integer aidl;
  private static c aidm;
  public c.a aidn;
  private FlutterEngineGroup aido;
  public FlutterEngine aidp;
  private FlutterEngine aidq;
  public SparseArray<b> aidr;
  public HashMap<String, com.tencent.wxa.b.b> aids;
  public Boolean aidt;
  public com.tencent.wxa.b.b aidu;
  private SparseArray<Integer> aidv;
  private AtomicInteger aidw;
  public Handler handler;
  
  static
  {
    AppMethodBeat.i(210576);
    aidl = Integer.valueOf(1000);
    AppMethodBeat.o(210576);
  }
  
  public c()
  {
    AppMethodBeat.i(210484);
    this.aidr = new SparseArray();
    this.aids = new HashMap();
    this.aidt = Boolean.FALSE;
    this.aidv = new SparseArray();
    this.aidw = new AtomicInteger(aidl.intValue());
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(210484);
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(210508);
    this.aido = new FlutterEngineGroup(c.a.g(parama));
    AppMethodBeat.o(210508);
  }
  
  private void a(FlutterEngine paramFlutterEngine, int paramInt)
  {
    AppMethodBeat.i(210547);
    if (paramFlutterEngine != null)
    {
      this.aidv.put(paramFlutterEngine.hashCode(), Integer.valueOf(paramInt));
      AppMethodBeat.o(210547);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "engine is null.", new Object[0]);
    AppMethodBeat.o(210547);
  }
  
  public static void a(FlutterEngine paramFlutterEngine, String paramString, Object paramObject)
  {
    AppMethodBeat.i(210536);
    if (paramFlutterEngine != null)
    {
      ((d)paramFlutterEngine.getPlugins().get(d.class)).aidJ.invokeMethod(paramString, paramObject, null);
      AppMethodBeat.o(210536);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "engine is null.", new Object[0]);
    AppMethodBeat.o(210536);
  }
  
  public static void a(FlutterEngine paramFlutterEngine, String paramString, Object paramObject, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(210543);
    if (paramFlutterEngine != null)
    {
      ((d)paramFlutterEngine.getPlugins().get(d.class)).aidJ.invokeMethod(paramString, paramObject, paramResult);
      AppMethodBeat.o(210543);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "engine is null.", new Object[0]);
    AppMethodBeat.o(210543);
  }
  
  private void b(c.a parama)
  {
    AppMethodBeat.i(210514);
    Object localObject = com.tencent.wxa.d.b.aiee;
    b.a.bHa(String.valueOf(this.aidw.toString()));
    FlutterMain.startInitialization(c.a.g(parama));
    FlutterMain.ensureInitializationComplete(c.a.g(parama), c.a.h(parama).toArray());
    parama = new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), this.aidn.dartEntrypoint);
    localObject = String.format("%s-%s", new Object[] { this.aidn.initialRoute, Integer.valueOf(this.aidw.get()) });
    FlutterEngine localFlutterEngine = this.aido.createAndRunEngine(c.a.g(this.aidn), parama, (String)localObject);
    a(localFlutterEngine, this.aidw.get());
    if (this.aidp == null) {
      this.aidp = localFlutterEngine;
    }
    for (;;)
    {
      com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "create flutter engineId:%s", new Object[] { Integer.valueOf(this.aidw.get()) });
      localFlutterEngine.getNavigationChannel().setInitialRoute((String)localObject);
      if (!localFlutterEngine.getDartExecutor().isExecutingDart()) {
        localFlutterEngine.getDartExecutor().executeDartEntrypoint(parama);
      }
      c(localFlutterEngine);
      b(localFlutterEngine);
      parama = com.tencent.wxa.d.b.aiee;
      com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "TimeRecord createFlutterEngine:%d", new Object[] { Long.valueOf(b.a.bHb(this.aidw.toString())) });
      this.aidw.addAndGet(1);
      AppMethodBeat.o(210514);
      return;
      this.aidq = localFlutterEngine;
    }
  }
  
  private void b(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210520);
    if (c.a.j(this.aidn) != null)
    {
      ((d)paramFlutterEngine.getPlugins().get(d.class)).n(c.a.j(this.aidn));
      AppMethodBeat.o(210520);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(210520);
  }
  
  private void c(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210529);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "registerPlugins by wxa router", new Object[0]);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      a.a(paramFlutterEngine, c.a.k(this.aidn));
      AppMethodBeat.o(210529);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "Tried to automatically register plugins with FlutterEngine (" + paramFlutterEngine + ") but could not find and invoke the GeneratedPluginRegistrant.", new Object[0]);
      }
    }
  }
  
  private void csC()
  {
    AppMethodBeat.i(210496);
    if (c.a.f(this.aidn) != null) {
      com.tencent.wxa.c.a.a(c.a.f(this.aidn));
    }
    AppMethodBeat.o(210496);
  }
  
  private void initFlutter()
  {
    AppMethodBeat.i(210504);
    if (this.aidp != null)
    {
      AppMethodBeat.o(210504);
      return;
    }
    a(this.aidn);
    b(this.aidn);
    AppMethodBeat.o(210504);
  }
  
  public static c keQ()
  {
    AppMethodBeat.i(210491);
    if (aidm == null) {}
    try
    {
      aidm = new c();
      c localc = aidm;
      AppMethodBeat.o(210491);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(210491);
    }
  }
  
  public final FlutterEngine OM(boolean paramBoolean)
  {
    AppMethodBeat.i(210631);
    if ((paramBoolean) && (this.aidt.booleanValue()))
    {
      if (this.aidq == null) {
        b(this.aidn);
      }
      localFlutterEngine = this.aidq;
      AppMethodBeat.o(210631);
      return localFlutterEngine;
    }
    if (this.aido == null) {
      a(this.aidn);
    }
    if (this.aidp == null) {
      b(this.aidn);
    }
    FlutterEngine localFlutterEngine = this.aidp;
    AppMethodBeat.o(210631);
    return localFlutterEngine;
  }
  
  public final void a(com.tencent.wxa.b.b paramb, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210590);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "attach activityId:%s engineId:%d", new Object[] { paramb.anP(), Integer.valueOf(d(paramFlutterEngine)) });
    if (paramFlutterEngine == null)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "attach failed.", new Object[0]);
      AppMethodBeat.o(210590);
      return;
    }
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) >= 0) {
      ((b)this.aidr.get(d(paramFlutterEngine))).aidI = paramb;
    }
    for (;;)
    {
      if (paramFlutterEngine == this.aidp)
      {
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "default engine attach", new Object[0]);
        this.aidt = Boolean.TRUE;
      }
      this.aids.put(paramb.anP(), paramb);
      this.aidu = paramb;
      AppMethodBeat.o(210590);
      return;
      Object localObject = new b(paramb, paramFlutterEngine);
      this.aidr.put(d(paramFlutterEngine), localObject);
      localObject = this.aidn;
      com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "prepareNextEngine", new Object[0]);
      this.aidq = null;
      if ((c.a.d((c.a)localObject).booleanValue()) && (this.aidt.booleanValue())) {
        b((c.a)localObject);
      }
    }
  }
  
  public final void a(FlutterView paramFlutterView, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210605);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "attachViewToFlutterEngine view:%d engineId:%d", new Object[] { Integer.valueOf(paramFlutterView.hashCode()), Integer.valueOf(d(paramFlutterEngine)) });
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210605);
      return;
    }
    b localb = (b)this.aidr.get(d(paramFlutterEngine));
    if (paramFlutterView == localb.flutterView)
    {
      com.tencent.wxa.c.a.d("WxaRouter.WxaRouter", "some flutter view. ignore", new Object[0]);
      AppMethodBeat.o(210605);
      return;
    }
    if (localb.flutterView != null) {
      localb.flutterView.detachFromFlutterEngine();
    }
    if (paramFlutterView != null)
    {
      paramFlutterView.attachToFlutterEngine(paramFlutterEngine);
      localb.flutterView = paramFlutterView;
    }
    AppMethodBeat.o(210605);
  }
  
  public final void b(com.tencent.wxa.b.b paramb, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210599);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "detach activityId:%s engineId:%d", new Object[] { paramb.anP(), Integer.valueOf(d(paramFlutterEngine)) });
    b localb;
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) >= 0)
    {
      localb = (b)this.aidr.get(d(paramFlutterEngine));
      localb.aidI = null;
      if (c.a.e(this.aidn).booleanValue())
      {
        if (paramFlutterEngine != this.aidp) {
          break label180;
        }
        localb.aidI = null;
      }
    }
    for (;;)
    {
      if (paramFlutterEngine == this.aidp)
      {
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "default engine attach", new Object[0]);
        this.aidt = Boolean.FALSE;
      }
      this.aids.remove(paramb.anP());
      if ((this.aidu != null) && (this.aidu == paramb))
      {
        com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "detach current activity. set CurrentActivity null", new Object[0]);
        this.aidu = null;
      }
      AppMethodBeat.o(210599);
      return;
      label180:
      this.aidr.delete(d(paramFlutterEngine));
      localb.release();
    }
  }
  
  public final void b(FlutterView paramFlutterView, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210610);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "detachViewFromFlutterEngine view:%d engineId:%d", new Object[] { Integer.valueOf(paramFlutterView.hashCode()), Integer.valueOf(d(paramFlutterEngine)) });
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210610);
      return;
    }
    paramFlutterEngine = (b)this.aidr.get(d(paramFlutterEngine));
    if (paramFlutterView == null)
    {
      AppMethodBeat.o(210610);
      return;
    }
    if (paramFlutterView != paramFlutterEngine.flutterView)
    {
      AppMethodBeat.o(210610);
      return;
    }
    paramFlutterView.detachFromFlutterEngine();
    paramFlutterEngine.flutterView = null;
    AppMethodBeat.o(210610);
  }
  
  public final com.tencent.wxa.b.b bGZ(String paramString)
  {
    AppMethodBeat.i(210646);
    if (this.aids.containsKey(paramString))
    {
      paramString = (com.tencent.wxa.b.b)this.aids.get(paramString);
      AppMethodBeat.o(210646);
      return paramString;
    }
    AppMethodBeat.o(210646);
    return null;
  }
  
  public final void c(FlutterView paramFlutterView, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210614);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "appIsInactive view:%d engineId:%d", new Object[] { Integer.valueOf(paramFlutterView.hashCode()), Integer.valueOf(d(paramFlutterEngine)) });
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210614);
      return;
    }
    paramFlutterEngine = (b)this.aidr.get(d(paramFlutterEngine));
    if (paramFlutterView != paramFlutterEngine.flutterView)
    {
      AppMethodBeat.o(210614);
      return;
    }
    paramFlutterEngine.flutterEngine.getLifecycleChannel().appIsInactive();
    AppMethodBeat.o(210614);
  }
  
  public final int d(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210637);
    if ((paramFlutterEngine != null) && (this.aidv.indexOfKey(paramFlutterEngine.hashCode()) >= 0))
    {
      int i = ((Integer)this.aidv.get(paramFlutterEngine.hashCode())).intValue();
      AppMethodBeat.o(210637);
      return i;
    }
    AppMethodBeat.o(210637);
    return -1;
  }
  
  public final void d(FlutterView paramFlutterView, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210620);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "appIsResumed view:%d engineId:%d", new Object[] { Integer.valueOf(paramFlutterView.hashCode()), Integer.valueOf(d(paramFlutterEngine)) });
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210620);
      return;
    }
    paramFlutterEngine = (b)this.aidr.get(d(paramFlutterEngine));
    if (paramFlutterView != paramFlutterEngine.flutterView)
    {
      AppMethodBeat.o(210620);
      return;
    }
    paramFlutterEngine.flutterEngine.getLifecycleChannel().appIsResumed();
    this.aidu = paramFlutterEngine.aidI;
    AppMethodBeat.o(210620);
  }
  
  public final void e(FlutterView paramFlutterView, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210625);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "appIsPause view:%d engineId:%d", new Object[] { Integer.valueOf(paramFlutterView.hashCode()), Integer.valueOf(d(paramFlutterEngine)) });
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210625);
      return;
    }
    if (this.aidr.indexOfKey(d(paramFlutterEngine)) < 0)
    {
      com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "please attach activity first.", new Object[0]);
      AppMethodBeat.o(210625);
      return;
    }
    paramFlutterEngine = (b)this.aidr.get(d(paramFlutterEngine));
    if (paramFlutterView != paramFlutterEngine.flutterView)
    {
      AppMethodBeat.o(210625);
      return;
    }
    paramFlutterEngine.flutterEngine.getLifecycleChannel().appIsPaused();
    AppMethodBeat.o(210625);
  }
  
  public final void e(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(210640);
    if (paramFlutterEngine != null)
    {
      this.aidv.remove(paramFlutterEngine.hashCode());
      AppMethodBeat.o(210640);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "engine is null.", new Object[0]);
    AppMethodBeat.o(210640);
  }
  
  public final void init()
  {
    AppMethodBeat.i(210582);
    csC();
    if (c.a.c(this.aidn).booleanValue()) {
      initFlutter();
    }
    AppMethodBeat.o(210582);
  }
  
  public final FlutterEngine keR()
  {
    AppMethodBeat.i(210629);
    if (this.aidp == null) {
      b(this.aidn);
    }
    FlutterEngine localFlutterEngine = this.aidp;
    AppMethodBeat.o(210629);
    return localFlutterEngine;
  }
  
  public final class b
  {
    com.tencent.wxa.b.b aidI;
    public FlutterEngine flutterEngine;
    FlutterView flutterView;
    
    public b(com.tencent.wxa.b.b paramb, FlutterEngine paramFlutterEngine)
    {
      this.aidI = paramb;
      this.flutterEngine = paramFlutterEngine;
    }
    
    public final void release()
    {
      AppMethodBeat.i(210467);
      if (this.flutterEngine != null) {}
      try
      {
        c.this.e(this.flutterEngine);
        this.flutterEngine.destroy();
        this.flutterEngine = null;
        this.aidI = null;
        this.flutterView = null;
        AppMethodBeat.o(210467);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.wxa.c.a.e("WxaRouter.WxaRouter", "release fail.%s", new Object[] { localException.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.c
 * JD-Core Version:    0.7.0.1
 */