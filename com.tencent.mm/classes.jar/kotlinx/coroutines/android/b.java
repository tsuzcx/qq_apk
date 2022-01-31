package kotlinx.coroutines.android;

import a.f.b.j;
import a.l;
import a.y;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class b
  extends c
  implements aj
{
  private volatile b CIK;
  private final b CIL;
  private final boolean CIM;
  private final Handler handler;
  private final String name;
  
  public b(Handler paramHandler, String paramString)
  {
    this(paramHandler, paramString, false);
    AppMethodBeat.i(118254);
    AppMethodBeat.o(118254);
  }
  
  private b(Handler paramHandler, String paramString, boolean paramBoolean)
  {
    super((byte)0);
    AppMethodBeat.i(118253);
    this.handler = paramHandler;
    this.name = paramString;
    this.CIM = paramBoolean;
    if (this.CIM) {}
    for (paramHandler = this;; paramHandler = null)
    {
      this.CIK = paramHandler;
      paramString = this.CIK;
      paramHandler = paramString;
      if (paramString == null)
      {
        paramHandler = new b(this.handler, this.name, true);
        this.CIK = paramHandler;
      }
      this.CIL = paramHandler;
      AppMethodBeat.o(118253);
      return;
    }
  }
  
  public final void a(a.c.e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(118249);
    j.q(parame, "context");
    j.q(paramRunnable, "block");
    this.handler.post(paramRunnable);
    AppMethodBeat.o(118249);
  }
  
  public final void a(i<? super y> parami)
  {
    AppMethodBeat.i(118250);
    j.q(parami, "continuation");
    Runnable localRunnable = (Runnable)new b.a(this, parami);
    this.handler.postDelayed(localRunnable, a.i.e.al(1000L, 4611686018427387903L));
    parami.k((a.f.a.b)new b.b(this, localRunnable));
    AppMethodBeat.o(118250);
  }
  
  public final boolean b(a.c.e parame)
  {
    AppMethodBeat.i(118248);
    j.q(parame, "context");
    if ((!this.CIM) || ((j.e(Looper.myLooper(), this.handler.getLooper()) ^ true)))
    {
      AppMethodBeat.o(118248);
      return true;
    }
    AppMethodBeat.o(118248);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof b)) && (((b)paramObject).handler == this.handler);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118252);
    int i = System.identityHashCode(this.handler);
    AppMethodBeat.o(118252);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118251);
    if (this.name != null)
    {
      if (this.CIM)
      {
        str = this.name + " [immediate]";
        AppMethodBeat.o(118251);
        return str;
      }
      str = this.name;
      AppMethodBeat.o(118251);
      return str;
    }
    String str = this.handler.toString();
    j.p(str, "handler.toString()");
    AppMethodBeat.o(118251);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.android.b
 * JD-Core Version:    0.7.0.1
 */