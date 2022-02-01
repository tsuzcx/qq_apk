package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T>
{
  private final ay<T>[] ajvh;
  
  static
  {
    AppMethodBeat.i(188821);
    ajvi = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");
    AppMethodBeat.o(188821);
  }
  
  public e(ay<? extends T>[] paramArrayOfay)
  {
    AppMethodBeat.i(188808);
    this.ajvh = paramArrayOfay;
    this.notCompletedCount = this.ajvh.length;
    AppMethodBeat.o(188808);
  }
  
  public final Object e(d<? super List<? extends T>> paramd)
  {
    AppMethodBeat.i(188826);
    Object localObject1 = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject1).kBA();
    p localp = (p)localObject1;
    int j = this.ajvh.length;
    a[] arrayOfa = new a[j];
    int i = 0;
    while (i < j)
    {
      Object localObject3 = this.ajvh[i];
      ((ay)localObject3).start();
      localObject2 = new a(localp);
      ((a)localObject2).ajvj = ((ay)localObject3).bh((kotlin.g.a.b)localObject2);
      localObject3 = ah.aiuX;
      arrayOfa[i] = localObject2;
      i += 1;
    }
    Object localObject2 = new b(arrayOfa);
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      arrayOfa[i]._disposer = localObject2;
      i += 1;
    }
    if (localp.isCompleted()) {
      ((b)localObject2).kBw();
    }
    for (;;)
    {
      localObject1 = ((q)localObject1).getResult();
      if (localObject1 == a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(188826);
      return localObject1;
      localp.bg((kotlin.g.a.b)localObject2);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends ch
  {
    public bi ajvj;
    private final p<List<? extends T>> bgf;
    
    public a()
    {
      Object localObject;
      this.bgf = localObject;
      this._disposer = null;
    }
    
    public final void N(Throwable paramThrowable)
    {
      AppMethodBeat.i(188903);
      if (paramThrowable != null)
      {
        paramThrowable = this.bgf.O(paramThrowable);
        if (paramThrowable != null)
        {
          this.bgf.iy(paramThrowable);
          paramThrowable = (e.b)this._disposer;
          if (paramThrowable != null)
          {
            paramThrowable.kBw();
            AppMethodBeat.o(188903);
          }
        }
      }
      else
      {
        paramThrowable = e.this;
        if (e.ajvi.decrementAndGet(paramThrowable) == 0)
        {
          paramThrowable = (d)this.bgf;
          Object localObject1 = e.a(e.this);
          Object localObject2 = (Collection)new ArrayList(localObject1.length);
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((Collection)localObject2).add(localObject1[i].kBS());
            i += 1;
          }
          localObject1 = (List)localObject2;
          localObject2 = Result.Companion;
          paramThrowable.resumeWith(Result.constructor-impl(localObject1));
        }
      }
      AppMethodBeat.o(188903);
    }
    
    public final bi kBv()
    {
      AppMethodBeat.i(188896);
      bi localbi = this.ajvj;
      if (localbi != null)
      {
        AppMethodBeat.o(188896);
        return localbi;
      }
      s.bIx("handle");
      AppMethodBeat.o(188896);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends n
  {
    private final e<T>[].a ajvl;
    
    public b()
    {
      Object localObject;
      this.ajvl = localObject;
    }
    
    public final void N(Throwable paramThrowable)
    {
      AppMethodBeat.i(188922);
      kBw();
      AppMethodBeat.o(188922);
    }
    
    public final void kBw()
    {
      AppMethodBeat.i(188916);
      e.a[] arrayOfa = this.ajvl;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].kBv().dispose();
        i += 1;
      }
      AppMethodBeat.o(188916);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188930);
      String str = "DisposeHandlersOnCancel[" + this.ajvl + ']';
      AppMethodBeat.o(188930);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e
 * JD-Core Version:    0.7.0.1
 */