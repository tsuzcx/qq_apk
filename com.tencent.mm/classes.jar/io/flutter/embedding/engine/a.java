package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.b;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.k;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  public final b MYe;
  public final io.flutter.embedding.engine.b.a MYh;
  private final FlutterJNI MZl;
  public final DartExecutor MZm;
  public final c MZn;
  public final io.flutter.embedding.engine.c.a MZo;
  public final io.flutter.embedding.engine.c.c MZp;
  public final d MZq;
  public final e MZr;
  public final f MZs;
  private final i MZt;
  public final io.flutter.embedding.engine.c.h MZu;
  public final j MZv;
  private final k MZw;
  public final io.flutter.plugin.platform.h MZx;
  private final a MZy;
  private final Set<a> engineLifecycleListeners;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.gjs(), new FlutterJNI(), null, true);
    AppMethodBeat.i(197831);
    AppMethodBeat.o(197831);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, io.flutter.plugin.platform.h paramh, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(197834);
    this.engineLifecycleListeners = new HashSet();
    this.MZy = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.a.giD();
        Iterator localIterator = a.d(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        a.e(a.this).gjP();
        AppMethodBeat.o(10115);
      }
    };
    this.MZl = paramFlutterJNI;
    parama.startInitialization(paramContext.getApplicationContext());
    parama.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.MZy);
    io.flutter.a.giD();
    this.MZl.attachToNative(false);
    if (!this.MZl.isAttached())
    {
      paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(197834);
      throw paramContext;
    }
    this.MZm = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.MZm.onAttachedToJNI();
    this.MYh = new io.flutter.embedding.engine.b.a(paramFlutterJNI);
    this.MZo = new io.flutter.embedding.engine.c.a(this.MZm, paramFlutterJNI);
    this.MYe = new b(this.MZm);
    this.MZp = new io.flutter.embedding.engine.c.c(this.MZm);
    this.MZq = new d(this.MZm);
    this.MZr = new e(this.MZm);
    this.MZs = new f(this.MZm);
    this.MZt = new i(this.MZm);
    this.MZu = new io.flutter.embedding.engine.c.h(this.MZm);
    this.MZv = new j(this.MZm);
    this.MZw = new k(this.MZm);
    this.MZx = paramh;
    this.MZn = new c(paramContext.getApplicationContext(), this, parama);
    if (paramBoolean) {
      try
      {
        Class.forName("io.flutter.a.a").getDeclaredMethod("registerWith", new Class[] { a.class }).invoke(null, new Object[] { this });
        AppMethodBeat.o(197834);
        return;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
        io.flutter.a.giG();
      }
    }
    AppMethodBeat.o(197834);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, parama, paramFlutterJNI, new io.flutter.plugin.platform.h(), paramArrayOfString, paramBoolean);
    AppMethodBeat.i(197833);
    AppMethodBeat.o(197833);
  }
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.gjs(), new FlutterJNI(), paramArrayOfString, false);
    AppMethodBeat.i(197832);
    AppMethodBeat.o(197832);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.a.giD();
    this.MZn.destroy();
    this.MZm.onDetachedFromJNI();
    this.MZl.removeEngineLifecycleListener(this.MZy);
    this.MZl.detachFromNativeAndReleaseResources();
    AppMethodBeat.o(10181);
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.MZm;
  }
  
  public final io.flutter.embedding.engine.c.c gjd()
  {
    return this.MZp;
  }
  
  public final e gje()
  {
    return this.MZr;
  }
  
  public static abstract interface a
  {
    public abstract void onPreEngineRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a
 * JD-Core Version:    0.7.0.1
 */