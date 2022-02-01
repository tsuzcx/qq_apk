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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class c<T>
{
  static final AtomicIntegerFieldUpdater abvZ;
  private final at<T>[] abwa;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(204643);
    abvZ = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    AppMethodBeat.o(204643);
  }
  
  public c(at<? extends T>[] paramArrayOfat)
  {
    AppMethodBeat.i(204642);
    this.abwa = paramArrayOfat;
    this.notCompletedCount = this.abwa.length;
    AppMethodBeat.o(204642);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends cd<by>
  {
    volatile Object _disposer;
    public be abwb;
    private final m<List<? extends T>> abwc;
    
    public a(by paramby)
    {
      super();
      this.abwc = paramby;
      this._disposer = null;
    }
    
    public final be iQH()
    {
      AppMethodBeat.i(204226);
      be localbe = this.abwb;
      if (localbe == null) {
        p.bGy("handle");
      }
      AppMethodBeat.o(204226);
      return localbe;
    }
    
    public final void y(Throwable paramThrowable)
    {
      AppMethodBeat.i(204227);
      if (paramThrowable != null)
      {
        paramThrowable = this.abwc.z(paramThrowable);
        if (paramThrowable != null)
        {
          this.abwc.fW(paramThrowable);
          paramThrowable = (c.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.iQI();
            AppMethodBeat.o(204227);
            return;
          }
          AppMethodBeat.o(204227);
        }
      }
      else
      {
        paramThrowable = c.this;
        if (c.abvZ.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.abwc;
          Object localObject1 = c.a(c.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].iRo());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = Result.Companion;
          paramThrowable.resumeWith(Result.constructor-impl(localObject1));
        }
      }
      AppMethodBeat.o(204227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */