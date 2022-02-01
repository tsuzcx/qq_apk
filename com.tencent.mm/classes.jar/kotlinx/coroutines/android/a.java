package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class a
  extends b
  implements at
{
  private final a TVq;
  private final boolean TVr;
  private volatile a _immediate;
  private final Handler handler;
  private final String name;
  
  public a(Handler paramHandler, String paramString)
  {
    this(paramHandler, paramString, false);
    AppMethodBeat.i(107777);
    AppMethodBeat.o(107777);
  }
  
  private a(Handler paramHandler, String paramString, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(107776);
    this.handler = paramHandler;
    this.name = paramString;
    this.TVr = paramBoolean;
    if (this.TVr) {}
    for (paramHandler = this;; paramHandler = null)
    {
      this._immediate = paramHandler;
      paramString = this._immediate;
      paramHandler = paramString;
      if (paramString == null)
      {
        paramHandler = new a(this.handler, this.name, true);
        this._immediate = paramHandler;
      }
      this.TVq = paramHandler;
      AppMethodBeat.o(107776);
      return;
    }
  }
  
  public final void a(long paramLong, final k<? super x> paramk)
  {
    AppMethodBeat.i(107773);
    final Runnable localRunnable = (Runnable)new b(this, paramk);
    this.handler.postDelayed(localRunnable, j.aN(paramLong, 4611686018427387903L));
    paramk.W((kotlin.g.a.b)new c(this, localRunnable));
    AppMethodBeat.o(107773);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(107772);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(107772);
  }
  
  public final bc d(long paramLong, final Runnable paramRunnable)
  {
    AppMethodBeat.i(187958);
    this.handler.postDelayed(paramRunnable, j.aN(paramLong, 4611686018427387903L));
    paramRunnable = (bc)new a(this, paramRunnable);
    AppMethodBeat.o(187958);
    return paramRunnable;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (((a)paramObject).handler == this.handler);
  }
  
  public final boolean hMH()
  {
    AppMethodBeat.i(187957);
    if ((!this.TVr) || ((p.j(Looper.myLooper(), this.handler.getLooper()) ^ true)))
    {
      AppMethodBeat.o(187957);
      return true;
    }
    AppMethodBeat.o(187957);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(107775);
    int i = System.identityHashCode(this.handler);
    AppMethodBeat.o(107775);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107774);
    if (this.name != null)
    {
      if (this.TVr)
      {
        str = this.name + " [immediate]";
        AppMethodBeat.o(107774);
        return str;
      }
      str = this.name;
      AppMethodBeat.o(107774);
      return str;
    }
    String str = this.handler.toString();
    AppMethodBeat.o(107774);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlinx/coroutines/android/HandlerContext$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-android"})
  public static final class a
    implements bc
  {
    a(Runnable paramRunnable) {}
    
    public final void dispose()
    {
      AppMethodBeat.i(187959);
      a.a(this.TVs).removeCallbacks(paramRunnable);
      AppMethodBeat.o(187959);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
  public static final class b
    implements Runnable
  {
    public b(a parama, k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(107778);
      paramk.a(this.TVs, x.SXb);
      AppMethodBeat.o(107778);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Throwable, x>
  {
    c(a parama, Runnable paramRunnable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.android.a
 * JD-Core Version:    0.7.0.1
 */