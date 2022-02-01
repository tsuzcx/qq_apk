package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
final class c<T>
{
  static final AtomicIntegerFieldUpdater OeC;
  private final aq<T>[] OeD;
  volatile int notCompletedCount;
  
  static
  {
    AppMethodBeat.i(209355);
    OeC = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    AppMethodBeat.o(209355);
  }
  
  public c(aq<? extends T>[] paramArrayOfaq)
  {
    AppMethodBeat.i(209354);
    this.OeD = paramArrayOfaq;
    this.notCompletedCount = this.OeD.length;
    AppMethodBeat.o(209354);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
  final class a
    extends bu<br>
  {
    public ba OeE;
    private final k<List<? extends T>> OeF;
    volatile Object _disposer;
    
    public a(br parambr)
    {
      super();
      this.OeF = parambr;
      this._disposer = null;
    }
    
    public final ba gzl()
    {
      AppMethodBeat.i(209242);
      ba localba = this.OeE;
      if (localba == null) {
        d.g.b.p.bdF("handle");
      }
      AppMethodBeat.o(209242);
      return localba;
    }
    
    public final void x(Throwable paramThrowable)
    {
      AppMethodBeat.i(209243);
      if (paramThrowable != null)
      {
        paramThrowable = this.OeF.y(paramThrowable);
        if (paramThrowable != null)
        {
          this.OeF.fJ(paramThrowable);
          paramThrowable = (c.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.gzm();
            AppMethodBeat.o(209243);
            return;
          }
          AppMethodBeat.o(209243);
        }
      }
      else
      {
        paramThrowable = c.this;
        if (c.OeC.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.OeF;
          Object localObject1 = c.a(c.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].gzN());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = d.p.Nhh;
          paramThrowable.eQ(d.p.eO(localObject1));
        }
      }
      AppMethodBeat.o(209243);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  final class b
    extends i
  {
    private final c<T>[].a OeH;
    
    public b()
    {
      Object localObject;
      this.OeH = localObject;
    }
    
    public final void gzm()
    {
      AppMethodBeat.i(209257);
      c.a[] arrayOfa = this.OeH;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].gzl().dispose();
        i += 1;
      }
      AppMethodBeat.o(209257);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(209260);
      String str = "DisposeHandlersOnCancel[" + this.OeH + ']';
      AppMethodBeat.o(209260);
      return str;
    }
    
    public final void x(Throwable paramThrowable)
    {
      AppMethodBeat.i(209258);
      gzm();
      AppMethodBeat.o(209258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */