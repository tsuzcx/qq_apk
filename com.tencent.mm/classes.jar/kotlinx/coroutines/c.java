package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class c<T>
{
  static final AtomicIntegerFieldUpdater TTw;
  private final ar<T>[] TTx;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(192500);
    TTw = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    AppMethodBeat.o(192500);
  }
  
  public c(ar<? extends T>[] paramArrayOfar)
  {
    AppMethodBeat.i(192499);
    this.TTx = paramArrayOfar;
    this.notCompletedCount = this.TTx.length;
    AppMethodBeat.o(192499);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends bz<bu>
  {
    public bc TTy;
    private final k<List<? extends T>> TTz;
    volatile Object _disposer;
    
    public a(bu parambu)
    {
      super();
      this.TTz = parambu;
      this._disposer = null;
    }
    
    public final bc hMp()
    {
      AppMethodBeat.i(192377);
      bc localbc = this.TTy;
      if (localbc == null) {
        p.btv("handle");
      }
      AppMethodBeat.o(192377);
      return localbc;
    }
    
    public final void y(Throwable paramThrowable)
    {
      AppMethodBeat.i(192378);
      if (paramThrowable != null)
      {
        paramThrowable = this.TTz.z(paramThrowable);
        if (paramThrowable != null)
        {
          this.TTz.fN(paramThrowable);
          paramThrowable = (c.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.hMq();
            AppMethodBeat.o(192378);
            return;
          }
          AppMethodBeat.o(192378);
        }
      }
      else
      {
        paramThrowable = c.this;
        if (c.TTw.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.TTz;
          Object localObject1 = c.a(c.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].hMS());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = Result.Companion;
          paramThrowable.resumeWith(Result.constructor-impl(localObject1));
        }
      }
      AppMethodBeat.o(192378);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */