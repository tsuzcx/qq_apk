package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class c<T>
{
  static final AtomicIntegerFieldUpdater NHw;
  private final aq<T>[] NHx;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(190864);
    NHw = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    AppMethodBeat.o(190864);
  }
  
  public c(aq<? extends T>[] paramArrayOfaq)
  {
    AppMethodBeat.i(190863);
    this.NHx = paramArrayOfaq;
    this.notCompletedCount = this.NHx.length;
    AppMethodBeat.o(190863);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends bu<br>
  {
    public ba NHy;
    private final k<List<? extends T>> NHz;
    volatile Object _disposer;
    
    public a(br parambr)
    {
      super();
      this.NHz = parambr;
      this._disposer = null;
    }
    
    public final ba guJ()
    {
      AppMethodBeat.i(190751);
      ba localba = this.NHy;
      if (localba == null) {
        d.g.b.p.bcb("handle");
      }
      AppMethodBeat.o(190751);
      return localba;
    }
    
    public final void v(Throwable paramThrowable)
    {
      AppMethodBeat.i(190752);
      if (paramThrowable != null)
      {
        paramThrowable = this.NHz.x(paramThrowable);
        if (paramThrowable != null)
        {
          this.NHz.fG(paramThrowable);
          paramThrowable = (c.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.guK();
            AppMethodBeat.o(190752);
            return;
          }
          AppMethodBeat.o(190752);
        }
      }
      else
      {
        paramThrowable = c.this;
        if (c.NHw.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.NHz;
          Object localObject1 = c.a(c.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].gvl());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = d.p.MKe;
          paramThrowable.eN(d.p.eL(localObject1));
        }
      }
      AppMethodBeat.o(190752);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  final class b
    extends i
  {
    private final c<T>[].a NHB;
    
    public b()
    {
      Object localObject;
      this.NHB = localObject;
    }
    
    public final void guK()
    {
      AppMethodBeat.i(190766);
      c.a[] arrayOfa = this.NHB;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].guJ().dispose();
        i += 1;
      }
      AppMethodBeat.o(190766);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(190769);
      String str = "DisposeHandlersOnCancel[" + this.NHB + ']';
      AppMethodBeat.o(190769);
      return str;
    }
    
    public final void v(Throwable paramThrowable)
    {
      AppMethodBeat.i(190767);
      guK();
      AppMethodBeat.o(190767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */