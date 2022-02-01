package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.u;
import kotlinx.coroutines.bi;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  static
  {
    AppMethodBeat.i(188948);
    ajvp = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_state");
    AppMethodBeat.o(188948);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(188940);
    this._state = e.kEO();
    AppMethodBeat.o(188940);
  }
  
  public final Object aD(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188963);
    if (jo(null))
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(188963);
      return paramd;
    }
    q localq = kotlinx.coroutines.s.av(kotlin.d.a.b.au(paramd));
    kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localq;
    Object localObject1 = new a(null, localp);
    Object localObject2;
    for (;;)
    {
      localObject2 = this._state;
      if ((localObject2 instanceof b))
      {
        if (((b)localObject2).ajBT != e.kEP())
        {
          ajvp.compareAndSet(this, localObject2, new c(((b)localObject2).ajBT));
        }
        else
        {
          b localb = e.kEN();
          if (ajvp.compareAndSet(this, localObject2, localb)) {
            localp.d(ah.aiuX, (kotlin.g.a.b)new e(this, null));
          }
        }
      }
      else
      {
        for (;;)
        {
          localObject1 = localq.getResult();
          if (localObject1 == a.aiwj) {
            kotlin.g.b.s.u(paramd, "frame");
          }
          paramd = (kotlin.d.d<? super ah>)localObject1;
          if (localObject1 != a.aiwj) {
            paramd = ah.aiuX;
          }
          if (paramd != a.aiwj) {
            break label356;
          }
          AppMethodBeat.o(188963);
          return paramd;
          if (!(localObject2 instanceof c)) {
            break label307;
          }
          if (((c)localObject2).ajBW != null) {}
          for (int i = 1; i == 0; i = 0)
          {
            paramd = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Already locked by ", null).toString());
            AppMethodBeat.o(188963);
            throw paramd;
          }
          ((c)localObject2).d((kotlinx.coroutines.internal.p)localObject1);
          if ((this._state != localObject2) && (((a)localObject1).kEK())) {
            break;
          }
          kotlinx.coroutines.s.a(localp, (kotlinx.coroutines.internal.p)localObject1);
        }
        localObject1 = new a(null, localp);
        continue;
        label307:
        if (!(localObject2 instanceof w)) {
          break;
        }
        ((w)localObject2).jj(this);
      }
    }
    paramd = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Illegal state ", localObject2).toString());
    AppMethodBeat.o(188963);
    throw paramd;
    label356:
    paramd = ah.aiuX;
    AppMethodBeat.o(188963);
    return paramd;
  }
  
  public final boolean jo(Object paramObject)
  {
    int i = 1;
    AppMethodBeat.i(188956);
    for (;;)
    {
      paramObject = this._state;
      if ((paramObject instanceof b))
      {
        if (((b)paramObject).ajBT != e.kEP())
        {
          AppMethodBeat.o(188956);
          return false;
        }
        b localb = e.kEN();
        if (ajvp.compareAndSet(this, paramObject, localb))
        {
          AppMethodBeat.o(188956);
          return true;
        }
      }
      else
      {
        if ((paramObject instanceof c))
        {
          if (((c)paramObject).ajBW != null) {}
          while (i == 0)
          {
            paramObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Already locked by ", null).toString());
            AppMethodBeat.o(188956);
            throw paramObject;
            i = 0;
          }
          AppMethodBeat.o(188956);
          return false;
        }
        if (!(paramObject instanceof w)) {
          break;
        }
        ((w)paramObject).jj(this);
      }
    }
    paramObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Illegal state ", paramObject).toString());
    AppMethodBeat.o(188956);
    throw paramObject;
  }
  
  public final void jp(Object paramObject)
  {
    AppMethodBeat.i(188974);
    Object localObject2;
    do
    {
      do
      {
        int i;
        for (;;)
        {
          localObject1 = this._state;
          if ((localObject1 instanceof b))
          {
            if (paramObject == null)
            {
              if (((b)localObject1).ajBT != e.kEP()) {}
              for (i = 1; i == 0; i = 0)
              {
                paramObject = (Throwable)new IllegalStateException("Mutex is not locked".toString());
                AppMethodBeat.o(188974);
                throw paramObject;
              }
            }
            if (((b)localObject1).ajBT == paramObject) {}
            for (i = 1; i == 0; i = 0)
            {
              paramObject = (Throwable)new IllegalStateException(("Mutex is locked by " + ((b)localObject1).ajBT + " but expected " + paramObject).toString());
              AppMethodBeat.o(188974);
              throw paramObject;
            }
            if (ajvp.compareAndSet(this, localObject1, e.kEO())) {
              AppMethodBeat.o(188974);
            }
          }
          else
          {
            if (!(localObject1 instanceof w)) {
              break;
            }
            ((w)localObject1).jj(this);
          }
        }
        if (!(localObject1 instanceof c)) {
          break label377;
        }
        if (paramObject != null)
        {
          if (((c)localObject1).ajBW == paramObject) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new IllegalStateException(("Mutex is locked by " + ((c)localObject1).ajBW + " but expected " + paramObject).toString());
            AppMethodBeat.o(188974);
            throw paramObject;
          }
        }
        localObject2 = ((c)localObject1).kEf();
        if (localObject2 != null) {
          break;
        }
        localObject2 = new d((c)localObject1);
      } while ((!ajvp.compareAndSet(this, localObject1, localObject2)) || (((d)localObject2).jj(this) != null));
      AppMethodBeat.o(188974);
      return;
    } while (!((b)localObject2).kEI());
    c localc = (c)localObject1;
    Object localObject1 = ((b)localObject2).ajBW;
    paramObject = localObject1;
    if (localObject1 == null) {
      paramObject = e.kER();
    }
    localc.ajBW = paramObject;
    ((b)localObject2).kEJ();
    AppMethodBeat.o(188974);
    return;
    label377:
    paramObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Illegal state ", localObject1).toString());
    AppMethodBeat.o(188974);
    throw paramObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188979);
    for (;;)
    {
      localObject = this._state;
      if ((localObject instanceof b))
      {
        localObject = "Mutex[" + ((b)localObject).ajBT + ']';
        AppMethodBeat.o(188979);
        return localObject;
      }
      if (!(localObject instanceof w)) {
        break;
      }
      ((w)localObject).jj(this);
    }
    if ((localObject instanceof c))
    {
      localObject = "Mutex[" + ((c)localObject).ajBW + ']';
      AppMethodBeat.o(188979);
      return localObject;
    }
    Object localObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Illegal state ", localObject).toString());
    AppMethodBeat.o(188979);
    throw ((Throwable)localObject);
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends d.b
  {
    private final kotlinx.coroutines.p<ah> ajwe;
    
    public a(kotlinx.coroutines.p<? super ah> paramp)
    {
      super(null);
      Object localObject;
      this.ajwe = localObject;
    }
    
    public final boolean kEI()
    {
      AppMethodBeat.i(188965);
      if (!kEK())
      {
        AppMethodBeat.o(188965);
        return false;
      }
      if (this.ajwe.c(ah.aiuX, (kotlin.g.a.b)new a(d.this, this)) != null)
      {
        AppMethodBeat.o(188965);
        return true;
      }
      AppMethodBeat.o(188965);
      return false;
    }
    
    public final void kEJ()
    {
      AppMethodBeat.i(188973);
      this.ajwe.iy(r.ajvr);
      AppMethodBeat.o(188973);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188976);
      String str = "LockCont[" + this.ajBW + ", " + this.ajwe + "] for " + d.this;
      AppMethodBeat.o(188976);
      return str;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Throwable, ah>
    {
      a(d paramd, d.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k=1, mv={1, 5, 1}, xi=48)
  abstract class b
    extends kotlinx.coroutines.internal.p
    implements bi
  {
    public final Object ajBW;
    
    public b()
    {
      Object localObject;
      this.ajBW = localObject;
      this.isTaken = Boolean.FALSE;
    }
    
    public final void dispose()
    {
      remove();
    }
    
    public abstract boolean kEI();
    
    public abstract void kEJ();
    
    public final boolean kEK()
    {
      return ajBX.compareAndSet(this, Boolean.FALSE, Boolean.TRUE);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends n
  {
    public Object ajBW;
    
    public c(Object paramObject)
    {
      this.ajBW = paramObject;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188959);
      String str = "LockedQueue[" + this.ajBW + ']';
      AppMethodBeat.o(188959);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlinx.coroutines.internal.c<d>
  {
    public final d.c ajBY;
    
    public d(d.c paramc)
    {
      this.ajBY = paramc;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    e(d paramd, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.d
 * JD-Core Version:    0.7.0.1
 */