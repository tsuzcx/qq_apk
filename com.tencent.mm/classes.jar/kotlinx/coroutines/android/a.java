package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.g.b.p;
import d.g.b.q;
import d.k.j;
import d.l;
import d.z;
import kotlinx.coroutines.as;
import kotlinx.coroutines.k;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class a
  extends b
  implements as
{
  private final a Ogt;
  private final boolean Ogu;
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
    this.Ogu = paramBoolean;
    if (this.Ogu) {}
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
      this.Ogt = paramHandler;
      AppMethodBeat.o(107776);
      return;
    }
  }
  
  public final void a(long paramLong, final k<? super z> paramk)
  {
    AppMethodBeat.i(107773);
    final Runnable localRunnable = (Runnable)new a(this, paramk);
    this.handler.postDelayed(localRunnable, j.aH(paramLong, 4611686018427387903L));
    paramk.N((d.g.a.b)new b(this, localRunnable));
    AppMethodBeat.o(107773);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(107772);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(107772);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (((a)paramObject).handler == this.handler);
  }
  
  public final boolean gzD()
  {
    AppMethodBeat.i(193468);
    if ((!this.Ogu) || ((p.i(Looper.myLooper(), this.handler.getLooper()) ^ true)))
    {
      AppMethodBeat.o(193468);
      return true;
    }
    AppMethodBeat.o(193468);
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
      if (this.Ogu)
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
  public static final class a
    implements Runnable
  {
    public a(a parama, k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(107778);
      paramk.a(this.Ogv, z.Nhr);
      AppMethodBeat.o(107778);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Throwable, z>
  {
    b(a parama, Runnable paramRunnable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.android.a
 * JD-Core Version:    0.7.0.1
 */