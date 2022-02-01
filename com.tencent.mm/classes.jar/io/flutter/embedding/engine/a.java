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
  public final b KKl;
  public final io.flutter.embedding.engine.b.a KKo;
  private final FlutterJNI KLj;
  public final DartExecutor KLk;
  public final c KLl;
  public final io.flutter.embedding.engine.c.a KLm;
  public final io.flutter.embedding.engine.c.c KLn;
  public final d KLo;
  public final e KLp;
  public final f KLq;
  private final i KLr;
  public final io.flutter.embedding.engine.c.h KLs;
  public final j KLt;
  private final k KLu;
  public final io.flutter.plugin.platform.h KLv;
  private final a KLw;
  private final Set<a> engineLifecycleListeners;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  private a(Context paramContext, io.flutter.embedding.engine.a.a parama, FlutterJNI paramFlutterJNI, String[] paramArrayOfString)
  {
    AppMethodBeat.i(192803);
    this.engineLifecycleListeners = new HashSet();
    this.KLw = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.a.fMD();
        Iterator localIterator = a.d(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        AppMethodBeat.o(10115);
      }
    };
    this.KLj = paramFlutterJNI;
    parama.startInitialization(paramContext);
    parama.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.KLw);
    io.flutter.a.fMD();
    this.KLj.attachToNative(false);
    if (!this.KLj.isAttached())
    {
      paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(192803);
      throw paramContext;
    }
    this.KLk = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.KLk.onAttachedToJNI();
    this.KKo = new io.flutter.embedding.engine.b.a(paramFlutterJNI);
    this.KLm = new io.flutter.embedding.engine.c.a(this.KLk, paramFlutterJNI);
    this.KKl = new b(this.KLk);
    this.KLn = new io.flutter.embedding.engine.c.c(this.KLk);
    this.KLo = new d(this.KLk);
    this.KLp = new e(this.KLk);
    this.KLq = new f(this.KLk);
    this.KLr = new i(this.KLk);
    this.KLs = new io.flutter.embedding.engine.c.h(this.KLk);
    this.KLt = new j(this.KLk);
    this.KLu = new k(this.KLk);
    this.KLv = new io.flutter.plugin.platform.h();
    this.KLl = new c(paramContext.getApplicationContext(), this, parama);
    try
    {
      Class.forName("io.flutter.a.a").getDeclaredMethod("registerWith", new Class[] { a.class }).invoke(null, new Object[] { this });
      AppMethodBeat.o(192803);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(this).append(") but could not find and invoke the GeneratedPluginRegistrant.");
      io.flutter.a.fMG();
      AppMethodBeat.o(192803);
    }
  }
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, io.flutter.embedding.engine.a.a.fNr(), new FlutterJNI(), paramArrayOfString);
    AppMethodBeat.i(192802);
    AppMethodBeat.o(192802);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.a.fMF();
    this.KLl.destroy();
    this.KLk.onDetachedFromJNI();
    this.KLj.removeEngineLifecycleListener(this.KLw);
    this.KLj.detachFromNativeAndReleaseResources();
    AppMethodBeat.o(10181);
  }
  
  public final io.flutter.embedding.engine.c.c fNb()
  {
    return this.KLn;
  }
  
  public final e fNc()
  {
    return this.KLp;
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.KLk;
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