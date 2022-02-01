package io.flutter.embedding.engine;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.c.c;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.h;
import io.flutter.embedding.engine.c.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.k;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements LifecycleOwner
{
  public final io.flutter.embedding.engine.c.b IXa;
  public final io.flutter.embedding.engine.b.a IXd;
  private final FlutterJNI IYd;
  public final DartExecutor IYe;
  public final d IYf;
  private final b IYg;
  public final io.flutter.embedding.engine.c.a IYh;
  public final c IYi;
  public final io.flutter.embedding.engine.c.d IYj;
  public final e IYk;
  private final i IYl;
  public final f IYm;
  public final h IYn;
  public final j IYo;
  private final k IYp;
  public final g IYq;
  private final a IYr;
  private final Set<a> engineLifecycleListeners;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(10180);
    this.engineLifecycleListeners = new HashSet();
    this.IYr = new a()
    {
      public final void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        io.flutter.a.ftS();
        Iterator localIterator = a.c(a.this).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).onPreEngineRestart();
        }
        AppMethodBeat.o(10115);
      }
    };
    this.IYd = new FlutterJNI();
    this.IYd.addEngineLifecycleListener(this.IYr);
    io.flutter.a.ftS();
    this.IYd.attachToNative(false);
    if (!this.IYd.isAttached())
    {
      paramContext = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(10180);
      throw paramContext;
    }
    this.IYe = new DartExecutor(this.IYd, paramContext.getAssets());
    this.IYe.onAttachedToJNI();
    this.IXd = new io.flutter.embedding.engine.b.a(this.IYd);
    this.IYh = new io.flutter.embedding.engine.c.a(this.IYe, this.IYd);
    this.IXa = new io.flutter.embedding.engine.c.b(this.IYe);
    this.IYi = new c(this.IYe);
    this.IYj = new io.flutter.embedding.engine.c.d(this.IYe);
    this.IYk = new e(this.IYe);
    this.IYl = new i(this.IYe);
    this.IYm = new f(this.IYe);
    this.IYn = new h(this.IYe);
    this.IYo = new j(this.IYe);
    this.IYp = new k(this.IYe);
    this.IYq = new g();
    this.IYg = new b(this);
    this.IYf = new d(paramContext.getApplicationContext(), this, this.IYg);
    AppMethodBeat.o(10180);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(10181);
    io.flutter.a.ftT();
    this.IYf.destroy();
    this.IYe.onDetachedFromJNI();
    this.IYd.removeEngineLifecycleListener(this.IYr);
    this.IYd.detachFromNativeAndReleaseResources();
    AppMethodBeat.o(10181);
  }
  
  public final io.flutter.embedding.engine.b.a fuA()
  {
    return this.IXd;
  }
  
  public final c fuB()
  {
    return this.IYi;
  }
  
  public final e fuC()
  {
    return this.IYk;
  }
  
  public final DartExecutor getDartExecutor()
  {
    return this.IYe;
  }
  
  public final Lifecycle getLifecycle()
  {
    return this.IYg;
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