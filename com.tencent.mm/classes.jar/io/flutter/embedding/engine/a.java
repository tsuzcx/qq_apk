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
  public final b MAZ;
  public final io.flutter.embedding.engine.b.a MBc;
  private final FlutterJNI MCg;
  public final DartExecutor MCh;
  public final c MCi;
  public final io.flutter.embedding.engine.c.a MCj;
  public final io.flutter.embedding.engine.c.c MCk;
  public final d MCl;
  public final e MCm;
  public final f MCn;
  private final i MCo;
  public final io.flutter.embedding.engine.c.h MCp;
  public final j MCq;
  private final k MCr;
  public final io.flutter.plugin.platform.h MCs;
  private final a MCt;
  private final Set<a> engineLifecycleListeners;
  
  public a(Context paramContext)
  {
    this(paramContext, (byte)0);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  private a(Context paramContext, byte paramByte)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.geQ(), new FlutterJNI(), null, true);
    AppMethodBeat.i(213249);
    AppMethodBeat.o(213249);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, io.flutter.plugin.platform.h paramh, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(213252);
    this.engineLifecycleListeners = new HashSet();
    this.MCt = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.a.gea();
        Iterator localIterator = a.d(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        a.e(a.this).gfn();
        AppMethodBeat.o(10115);
      }
    };
    this.MCg = paramFlutterJNI;
    parama.startInitialization(paramContext.getApplicationContext());
    parama.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.MCt);
    io.flutter.a.gea();
    this.MCg.attachToNative(false);
    if (!this.MCg.isAttached())
    {
      paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(213252);
      throw paramContext;
    }
    this.MCh = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.MCh.onAttachedToJNI();
    this.MBc = new io.flutter.embedding.engine.b.a(paramFlutterJNI);
    this.MCj = new io.flutter.embedding.engine.c.a(this.MCh, paramFlutterJNI);
    this.MAZ = new b(this.MCh);
    this.MCk = new io.flutter.embedding.engine.c.c(this.MCh);
    this.MCl = new d(this.MCh);
    this.MCm = new e(this.MCh);
    this.MCn = new f(this.MCh);
    this.MCo = new i(this.MCh);
    this.MCp = new io.flutter.embedding.engine.c.h(this.MCh);
    this.MCq = new j(this.MCh);
    this.MCr = new k(this.MCh);
    this.MCs = paramh;
    this.MCi = new c(paramContext.getApplicationContext(), this, parama);
    if (paramBoolean) {
      try
      {
        Class.forName("io.flutter.a.a").getDeclaredMethod("registerWith", new Class[] { a.class }).invoke(null, new Object[] { this });
        AppMethodBeat.o(213252);
        return;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
        io.flutter.a.ged();
      }
    }
    AppMethodBeat.o(213252);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, parama, paramFlutterJNI, new io.flutter.plugin.platform.h(), paramArrayOfString, paramBoolean);
    AppMethodBeat.i(213251);
    AppMethodBeat.o(213251);
  }
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.geQ(), new FlutterJNI(), paramArrayOfString, false);
    AppMethodBeat.i(213250);
    AppMethodBeat.o(213250);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.a.gea();
    this.MCi.destroy();
    this.MCh.onDetachedFromJNI();
    this.MCg.removeEngineLifecycleListener(this.MCt);
    this.MCg.detachFromNativeAndReleaseResources();
    AppMethodBeat.o(10181);
  }
  
  public final io.flutter.embedding.engine.c.c geB()
  {
    return this.MCk;
  }
  
  public final e geC()
  {
    return this.MCm;
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.MCh;
  }
  
  public static abstract interface a
  {
    public abstract void onPreEngineRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.a
 * JD-Core Version:    0.7.0.1
 */