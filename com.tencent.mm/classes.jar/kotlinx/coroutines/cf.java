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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class cf<T>
{
  static final AtomicIntegerFieldUpdater LEw;
  private final al<T>[] LEx;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(202371);
    LEw = AtomicIntegerFieldUpdater.newUpdater(cf.class, "notCompletedCount");
    AppMethodBeat.o(202371);
  }
  
  public cf(al<? extends T>[] paramArrayOfal)
  {
    AppMethodBeat.i(202370);
    this.LEx = paramArrayOfal;
    this.notCompletedCount = this.LEx.length;
    AppMethodBeat.o(202370);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends bm<bj>
  {
    public au KdY;
    private final h<List<? extends T>> LEy;
    volatile Object _disposer;
    
    public a(bj parambj)
    {
      super();
      this.LEy = parambj;
      this._disposer = null;
    }
    
    public final au gaC()
    {
      AppMethodBeat.i(202328);
      au localau = this.KdY;
      if (localau == null) {
        k.aPZ("handle");
      }
      AppMethodBeat.o(202328);
      return localau;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(202329);
      if (paramThrowable != null)
      {
        paramThrowable = this.LEy.S(paramThrowable);
        if (paramThrowable != null)
        {
          this.LEy.gh(paramThrowable);
          paramThrowable = (cf.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.gaD();
            AppMethodBeat.o(202329);
            return;
          }
          AppMethodBeat.o(202329);
        }
      }
      else
      {
        paramThrowable = cf.this;
        if (cf.LEw.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.LEy;
          Object localObject1 = cf.a(cf.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].gaF());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = p.JfM;
          paramThrowable.eH(p.eF(localObject1));
        }
      }
      AppMethodBeat.o(202329);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  final class b
    extends f
  {
    private final cf<T>[].a LEA;
    
    public b()
    {
      Object localObject;
      this.LEA = localObject;
    }
    
    public final void gaD()
    {
      AppMethodBeat.i(202334);
      cf.a[] arrayOfa = this.LEA;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].gaC().dispose();
        i += 1;
      }
      AppMethodBeat.o(202334);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202337);
      String str = "DisposeHandlersOnCancel[" + this.LEA + ']';
      AppMethodBeat.o(202337);
      return str;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(202335);
      gaD();
      AppMethodBeat.o(202335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */