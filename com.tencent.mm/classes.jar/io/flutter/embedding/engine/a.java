package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.g;
import io.flutter.embedding.engine.c.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.k;
import io.flutter.embedding.engine.c.l;
import io.flutter.embedding.engine.c.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.platform.PlatformViewsController;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  public final io.flutter.embedding.engine.c.b SMo;
  public final io.flutter.embedding.engine.b.a SMr;
  private final FlutterJNI SNV;
  public final DartExecutor SNW;
  public final c SNX;
  public final io.flutter.embedding.engine.c.a SNY;
  public final io.flutter.embedding.engine.c.c SNZ;
  private final d SOa;
  public final e SOb;
  public final f SOc;
  public final i SOd;
  public final g SOe;
  private final k SOf;
  public final j SOg;
  public final l SOh;
  public final m SOi;
  private final a SOj;
  private final Set<a> engineLifecycleListeners;
  public final io.flutter.plugin.c.a localizationPlugin;
  public final PlatformViewsController platformViewsController;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), true);
    AppMethodBeat.i(214941);
    AppMethodBeat.o(214941);
  }
  
  public a(Context paramContext, char paramChar)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), false);
    AppMethodBeat.i(214942);
    AppMethodBeat.o(214942);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, parama, paramFlutterJNI, paramPlatformViewsController, null, paramBoolean, false);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214945);
    this.engineLifecycleListeners = new HashSet();
    this.SOj = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.a.hwd();
        Iterator localIterator = a.e(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        a.f(a.this).hxs();
        a.g(a.this).SRe = null;
        AppMethodBeat.o(10115);
      }
    };
    this.SNW = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.SNW.onAttachedToJNI();
    this.SNY = new io.flutter.embedding.engine.c.a(this.SNW, paramFlutterJNI);
    this.SMo = new io.flutter.embedding.engine.c.b(this.SNW);
    this.SNZ = new io.flutter.embedding.engine.c.c(this.SNW);
    this.SOa = new d(this.SNW);
    this.SOb = new e(this.SNW);
    this.SOc = new f(this.SNW);
    this.SOe = new g(this.SNW);
    this.SOd = new i(this.SNW, paramBoolean2);
    this.SOf = new k(this.SNW);
    this.SOg = new j(this.SNW);
    this.SOh = new l(this.SNW);
    this.SOi = new m(this.SNW);
    this.localizationPlugin = new io.flutter.plugin.c.a(paramContext, this.SOa);
    this.SNV = paramFlutterJNI;
    parama.startInitialization(paramContext.getApplicationContext());
    parama.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.SOj);
    paramFlutterJNI.setPlatformViewsController(paramPlatformViewsController);
    paramFlutterJNI.setLocalizationPlugin(this.localizationPlugin);
    io.flutter.a.hwd();
    this.SNV.attachToNative(false);
    if (!this.SNV.isAttached())
    {
      paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(214945);
      throw paramContext;
    }
    this.SMr = new io.flutter.embedding.engine.b.a(paramFlutterJNI);
    this.platformViewsController = paramPlatformViewsController;
    this.platformViewsController.onAttachedToJNI();
    this.SNX = new c(paramContext.getApplicationContext(), this, parama);
    if (paramBoolean1) {
      try
      {
        Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { a.class }).invoke(null, new Object[] { this });
        AppMethodBeat.o(214945);
        return;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
        io.flutter.a.hwf();
      }
    }
    AppMethodBeat.o(214945);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    this(paramContext, parama, paramFlutterJNI, new PlatformViewsController(), null, paramBoolean);
    AppMethodBeat.i(214944);
    AppMethodBeat.o(214944);
  }
  
  public a(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.hwT(), new FlutterJNI(), new PlatformViewsController(), paramArrayOfString, false, paramBoolean);
    AppMethodBeat.i(214943);
    AppMethodBeat.o(214943);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.a.hwd();
    this.SNX.destroy();
    this.platformViewsController.onDetachedFromJNI();
    this.SNW.onDetachedFromJNI();
    this.SNV.removeEngineLifecycleListener(this.SOj);
    this.SNV.detachFromNativeAndReleaseResources();
    AppMethodBeat.o(10181);
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.SNW;
  }
  
  public final io.flutter.embedding.engine.plugins.b hwF()
  {
    return this.SNX;
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