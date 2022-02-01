package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.be;
import kotlinx.coroutines.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class a
  extends b
{
  private volatile a _immediate;
  private final a abxU;
  private final boolean abxV;
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
    this.abxV = paramBoolean;
    if (this.abxV) {}
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
      this.abxU = paramHandler;
      AppMethodBeat.o(107776);
      return;
    }
  }
  
  public final void a(long paramLong, final m<? super x> paramm)
  {
    AppMethodBeat.i(107773);
    final Runnable localRunnable = (Runnable)new b(this, paramm);
    this.handler.postDelayed(localRunnable, i.bf(paramLong, 4611686018427387903L));
    paramm.am((kotlin.g.a.b)new c(this, localRunnable));
    AppMethodBeat.o(107773);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(107772);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(107772);
  }
  
  public final be d(long paramLong, final Runnable paramRunnable)
  {
    AppMethodBeat.i(243905);
    this.handler.postDelayed(paramRunnable, i.bf(paramLong, 4611686018427387903L));
    paramRunnable = (be)new a(this, paramRunnable);
    AppMethodBeat.o(243905);
    return paramRunnable;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (((a)paramObject).handler == this.handler);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(107775);
    int i = System.identityHashCode(this.handler);
    AppMethodBeat.o(107775);
    return i;
  }
  
  public final boolean iRd()
  {
    AppMethodBeat.i(243904);
    if ((!this.abxV) || ((p.h(Looper.myLooper(), this.handler.getLooper()) ^ true)))
    {
      AppMethodBeat.o(243904);
      return true;
    }
    AppMethodBeat.o(243904);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107774);
    if (this.name != null)
    {
      if (this.abxV)
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/android/HandlerContext$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-android"})
  public static final class a
    implements be
  {
    a(Runnable paramRunnable) {}
    
    public final void dispose()
    {
      AppMethodBeat.i(243892);
      a.a(this.abxW).removeCallbacks(paramRunnable);
      AppMethodBeat.o(243892);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
  public static final class b
    implements Runnable
  {
    public b(a parama, m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(107778);
      paramm.a(this.abxW, x.aazN);
      AppMethodBeat.o(107778);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.android.a
 * JD-Core Version:    0.7.0.1
 */