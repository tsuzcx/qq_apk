package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.g.b.k;
import d.l;
import d.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class c<T>
{
  static final AtomicIntegerFieldUpdater LQB;
  private final ap<T>[] LQC;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(191251);
    LQB = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    AppMethodBeat.o(191251);
  }
  
  public c(ap<? extends T>[] paramArrayOfap)
  {
    AppMethodBeat.i(191250);
    this.LQC = paramArrayOfap;
    this.notCompletedCount = this.LQC.length;
    AppMethodBeat.o(191250);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends br<bo>
  {
    public az LQD;
    private final j<List<? extends T>> LQE;
    volatile Object _disposer;
    
    public a(bo parambo)
    {
      super();
      this.LQE = parambo;
      this._disposer = null;
    }
    
    public final az gdj()
    {
      AppMethodBeat.i(191141);
      az localaz = this.LQD;
      if (localaz == null) {
        k.aVY("handle");
      }
      AppMethodBeat.o(191141);
      return localaz;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(191142);
      if (paramThrowable != null)
      {
        paramThrowable = this.LQE.v(paramThrowable);
        if (paramThrowable != null)
        {
          this.LQE.fD(paramThrowable);
          paramThrowable = (c.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.gdk();
            AppMethodBeat.o(191142);
            return;
          }
          AppMethodBeat.o(191142);
        }
      }
      else
      {
        paramThrowable = c.this;
        if (c.LQB.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.LQE;
          Object localObject1 = c.a(c.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].gdL());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = p.KTg;
          paramThrowable.eK(p.eI(localObject1));
        }
      }
      AppMethodBeat.o(191142);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  final class b
    extends h
  {
    private final c<T>[].a LQG;
    
    public b()
    {
      Object localObject;
      this.LQG = localObject;
    }
    
    public final void gdk()
    {
      AppMethodBeat.i(191155);
      c.a[] arrayOfa = this.LQG;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].gdj().dispose();
        i += 1;
      }
      AppMethodBeat.o(191155);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191158);
      String str = "DisposeHandlersOnCancel[" + this.LQG + ']';
      AppMethodBeat.o(191158);
      return str;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(191156);
      gdk();
      AppMethodBeat.o(191156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */