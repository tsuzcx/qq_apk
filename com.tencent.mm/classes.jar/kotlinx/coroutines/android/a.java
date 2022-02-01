package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bi;
import kotlinx.coroutines.cg;
import kotlinx.coroutines.co;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private volatile a _immediate;
  private final boolean ajwW;
  private final a ajwX;
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
    this.ajwW = paramBoolean;
    if (this.ajwW) {}
    for (paramHandler = this;; paramHandler = null)
    {
      this._immediate = paramHandler;
      paramString = this._immediate;
      paramHandler = paramString;
      if (paramString == null)
      {
        paramHandler = new a(this.handler, this.name, true);
        this._immediate = paramHandler;
        paramString = ah.aiuX;
      }
      this.ajwX = paramHandler;
      AppMethodBeat.o(107776);
      return;
    }
  }
  
  private final void c(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(188937);
    cg.a(paramf, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
    bg.kCi().a(paramf, paramRunnable);
    AppMethodBeat.o(188937);
  }
  
  public final bi a(long paramLong, final Runnable paramRunnable, f paramf)
  {
    AppMethodBeat.i(188975);
    if (this.handler.postDelayed(paramRunnable, k.bS(paramLong, 4611686018427387903L)))
    {
      paramRunnable = (bi)new a(this, paramRunnable);
      AppMethodBeat.o(188975);
      return paramRunnable;
    }
    c(paramf, paramRunnable);
    paramRunnable = (bi)co.ajwK;
    AppMethodBeat.o(188975);
    return paramRunnable;
  }
  
  public final void a(long paramLong, p<? super ah> paramp)
  {
    AppMethodBeat.i(107773);
    final Runnable localRunnable = (Runnable)new b(paramp, this);
    if (this.handler.postDelayed(localRunnable, k.bS(paramLong, 4611686018427387903L)))
    {
      paramp.bg((kotlin.g.a.b)new c(this, localRunnable));
      AppMethodBeat.o(107773);
      return;
    }
    c(paramp.getContext(), localRunnable);
    AppMethodBeat.o(107773);
  }
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(107772);
    if (!this.handler.post(paramRunnable)) {
      c(paramf, paramRunnable);
    }
    AppMethodBeat.o(107772);
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
  
  public final boolean kBY()
  {
    AppMethodBeat.i(188952);
    if ((!this.ajwW) || (!s.p(Looper.myLooper(), this.handler.getLooper())))
    {
      AppMethodBeat.o(188952);
      return true;
    }
    AppMethodBeat.o(188952);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107774);
    Object localObject = kCL();
    if (localObject == null)
    {
      a locala = (a)this;
      String str = locala.name;
      localObject = str;
      if (str == null) {
        localObject = locala.handler.toString();
      }
      if (locala.ajwW)
      {
        localObject = s.X((String)localObject, ".immediate");
        AppMethodBeat.o(107774);
        return localObject;
      }
      AppMethodBeat.o(107774);
      return localObject;
    }
    AppMethodBeat.o(107774);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements bi
  {
    public a(a parama, Runnable paramRunnable) {}
    
    public final void dispose()
    {
      AppMethodBeat.i(188925);
      a.a(this.ajwY).removeCallbacks(paramRunnable);
      AppMethodBeat.o(188925);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    public b(p paramp, a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(107778);
      this.ajxa.a((al)jdField_this, ah.aiuX);
      AppMethodBeat.o(107778);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    c(a parama, Runnable paramRunnable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.android.a
 * JD-Core Version:    0.7.0.1
 */