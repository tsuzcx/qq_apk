package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.d;
import io.flutter.embedding.engine.b.e;
import io.flutter.embedding.engine.b.f;
import io.flutter.embedding.engine.b.g;
import io.flutter.embedding.engine.b.h;
import io.flutter.embedding.engine.b.j;
import io.flutter.embedding.engine.b.k;
import io.flutter.embedding.engine.b.l;
import io.flutter.embedding.engine.b.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.plugin.platform.PlatformViewsController;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  public final io.flutter.embedding.engine.b.c aaon;
  public final io.flutter.embedding.engine.renderer.a aaos;
  private final FlutterJNI aapT;
  public final DartExecutor aapU;
  public final c aapV;
  public final io.flutter.embedding.engine.b.a aapW;
  private final io.flutter.embedding.engine.b.b aapX;
  public final d aapY;
  private final e aapZ;
  public final f aaqa;
  public final g aaqb;
  public final j aaqc;
  public final h aaqd;
  public final k aaqe;
  public final l aaqf;
  public final m aaqg;
  private final a aaqh;
  private final Set<a> engineLifecycleListeners;
  public final io.flutter.plugin.b.a localizationPlugin;
  public final PlatformViewsController platformViewsController;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this(paramContext, new FlutterJNI(), true);
    AppMethodBeat.i(254763);
    AppMethodBeat.o(254763);
  }
  
  public a(Context paramContext, char paramChar)
  {
    this(paramContext, new FlutterJNI(), false);
    AppMethodBeat.i(254764);
    AppMethodBeat.o(254764);
  }
  
  private a(Context paramContext, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, null, paramFlutterJNI, paramPlatformViewsController, null, paramBoolean, false);
  }
  
  private a(Context paramContext, FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    this(paramContext, paramFlutterJNI, new PlatformViewsController(), null, paramBoolean);
    AppMethodBeat.i(254766);
    AppMethodBeat.o(254766);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.c paramc, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(254769);
    this.engineLifecycleListeners = new HashSet();
    this.aaqh = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.b.iAd();
        Iterator localIterator = a.e(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        a.f(a.this).iBw();
        a.g(a.this).aatD = null;
        AppMethodBeat.o(10115);
      }
    };
    try
    {
      paramc = paramContext.createPackageContext(paramContext.getPackageName(), 0).getAssets();
      this.aapU = new DartExecutor(paramFlutterJNI, paramc);
      this.aapU.onAttachedToJNI();
      paramc = io.flutter.a.iAc().deferredComponentManager;
      this.aapW = new io.flutter.embedding.engine.b.a(this.aapU, paramFlutterJNI);
      this.aapX = new io.flutter.embedding.engine.b.b(this.aapU);
      this.aaon = new io.flutter.embedding.engine.b.c(this.aapU);
      this.aapY = new d(this.aapU);
      this.aapZ = new e(this.aapU);
      this.aaqa = new f(this.aapU);
      this.aaqb = new g(this.aapU);
      this.aaqd = new h(this.aapU);
      this.aaqc = new j(this.aapU, paramBoolean2);
      this.aaqe = new k(this.aapU);
      this.aaqf = new l(this.aapU);
      this.aaqg = new m(this.aapU);
      if (paramc != null) {
        paramc.a(this.aapX);
      }
      this.localizationPlugin = new io.flutter.plugin.b.a(paramContext, this.aapZ);
      this.aapT = paramFlutterJNI;
      paramc = io.flutter.a.iAc().aanR;
      if (!paramFlutterJNI.isAttached())
      {
        paramc.startInitialization(paramContext.getApplicationContext());
        paramc.ensureInitializationComplete(paramContext, paramArrayOfString);
      }
      paramFlutterJNI.addEngineLifecycleListener(this.aaqh);
      paramFlutterJNI.setPlatformViewsController(paramPlatformViewsController);
      paramFlutterJNI.setLocalizationPlugin(this.localizationPlugin);
      paramFlutterJNI.setDeferredComponentManager(io.flutter.a.iAc().deferredComponentManager);
      if (!paramFlutterJNI.isAttached())
      {
        io.flutter.b.iAd();
        this.aapT.attachToNative(false);
        if (!this.aapT.isAttached())
        {
          paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
          AppMethodBeat.o(254769);
          throw paramContext;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramc)
    {
      for (;;)
      {
        paramc = paramContext.getAssets();
      }
      this.aaos = new io.flutter.embedding.engine.renderer.a(paramFlutterJNI);
      this.platformViewsController = paramPlatformViewsController;
      this.platformViewsController.onAttachedToJNI();
      this.aapV = new c(paramContext.getApplicationContext(), this, paramc);
      if (paramBoolean1) {
        try
        {
          Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { a.class }).invoke(null, new Object[] { this });
          AppMethodBeat.o(254769);
          return;
        }
        catch (Exception paramContext)
        {
          new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
          io.flutter.b.iAf();
        }
      }
      AppMethodBeat.o(254769);
    }
  }
  
  public a(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, null, new FlutterJNI(), new PlatformViewsController(), paramArrayOfString, false, paramBoolean);
    AppMethodBeat.i(254765);
    AppMethodBeat.o(254765);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.b.iAd();
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.aapV.destroy();
    this.platformViewsController.onDetachedFromJNI();
    this.aapU.onDetachedFromJNI();
    this.aapT.removeEngineLifecycleListener(this.aaqh);
    this.aapT.setDeferredComponentManager(null);
    this.aapT.detachFromNativeAndReleaseResources();
    if (io.flutter.a.iAc().deferredComponentManager != null)
    {
      io.flutter.a.iAc().deferredComponentManager.destroy();
      this.aapX.deferredComponentManager = null;
    }
    AppMethodBeat.o(10181);
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.aapU;
  }
  
  public static abstract interface a
  {
    public abstract void onPreEngineRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.a
 * JD-Core Version:    0.7.0.1
 */