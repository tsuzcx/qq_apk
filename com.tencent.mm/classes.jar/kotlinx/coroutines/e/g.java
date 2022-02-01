package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.u;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.aa;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  implements f
{
  private final int ajCg;
  private final kotlin.g.a.b<Throwable, ah> ajCm;
  
  static
  {
    AppMethodBeat.i(188961);
    ajCh = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head");
    ajCi = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx");
    ajCj = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail");
    ajCk = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx");
    ajCl = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits");
    AppMethodBeat.o(188961);
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(188942);
    this.ajCg = paramInt;
    this.deqIdx = 0L;
    this.enqIdx = 0L;
    if (this.ajCg > 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(kotlin.g.b.s.X("Semaphore should have at least 1 permit, but had ", Integer.valueOf(this.ajCg)).toString());
      AppMethodBeat.o(188942);
      throw ((Throwable)localObject);
    }
    if (this.ajCg >= 0) {}
    for (paramInt = i; paramInt == 0; paramInt = 0)
    {
      localObject = (Throwable)new IllegalArgumentException(kotlin.g.b.s.X("The number of acquired permits should be in 0..", Integer.valueOf(this.ajCg)).toString());
      AppMethodBeat.o(188942);
      throw ((Throwable)localObject);
    }
    Object localObject = new i(0L, null, 2);
    this.head = localObject;
    this.tail = localObject;
    this._availablePermits = (this.ajCg + 0);
    this.ajCm = ((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(188942);
  }
  
  private final boolean kES()
  {
    AppMethodBeat.i(188954);
    Object localObject3 = (i)this.head;
    long l1 = ajCi.getAndIncrement(this);
    long l2 = l1 / h.kET();
    Object localObject1 = (z)localObject3;
    if (((z)localObject1).id >= l2)
    {
      localObject2 = localObject1;
      if (!((z)localObject1).kDS()) {}
    }
    else
    {
      localObject2 = kotlinx.coroutines.internal.f.b((kotlinx.coroutines.internal.f)localObject1);
      if (localObject2 != e.kDP()) {
        break label166;
      }
      localObject2 = e.kDP();
    }
    if (!aa.iW(localObject2)) {
      localObject1 = aa.jn(localObject2);
    }
    int i;
    for (;;)
    {
      z localz = (z)this.head;
      if (localz.id >= ((z)localObject1).id) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label284;
        }
        localObject1 = (i)aa.jn(localObject2);
        kotlinx.coroutines.internal.f.ajAl.lazySet(localObject1, null);
        if (((z)localObject1).id <= l2) {
          break label302;
        }
        AppMethodBeat.o(188954);
        return false;
        label166:
        localObject2 = (z)localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          break;
        }
        localObject2 = (z)h.a(((z)localObject1).id + 1L, (i)localObject1);
        if (!((z)localObject1).a((kotlinx.coroutines.internal.f)localObject2)) {
          break;
        }
        if (((z)localObject1).kDS()) {
          ((z)localObject1).remove();
        }
        localObject1 = localObject2;
        break;
        if (!((z)localObject1).kEn())
        {
          i = 0;
        }
        else
        {
          if (!ajCh.compareAndSet(this, localz, localObject1)) {
            break label286;
          }
          if (localz.kEo()) {
            localz.remove();
          }
          i = 1;
        }
      }
      label284:
      break;
      label286:
      if (((z)localObject1).kEo()) {
        ((z)localObject1).remove();
      }
    }
    label302:
    int j = (int)(l1 % h.kET());
    Object localObject2 = h.kEU();
    localObject2 = ((i)localObject1).ajCu.getAndSet(j, localObject2);
    if (localObject2 == null)
    {
      int k = h.kEW();
      i = 0;
      while (i < k)
      {
        if (((i)localObject1).ajCu.get(j) == h.kEV())
        {
          AppMethodBeat.o(188954);
          return true;
        }
        i += 1;
      }
      localObject2 = h.kEU();
      localObject3 = h.kEX();
      if (!((i)localObject1).ajCu.compareAndSet(j, localObject2, localObject3))
      {
        AppMethodBeat.o(188954);
        return true;
      }
      AppMethodBeat.o(188954);
      return false;
    }
    if (localObject2 == h.kEY())
    {
      AppMethodBeat.o(188954);
      return false;
    }
    localObject1 = (p)localObject2;
    localObject2 = ((p)localObject1).c(ah.aiuX, this.ajCm);
    if (localObject2 == null)
    {
      AppMethodBeat.o(188954);
      return false;
    }
    ((p)localObject1).iy(localObject2);
    AppMethodBeat.o(188954);
    return true;
  }
  
  public final Object aE(d<? super ah> paramd)
  {
    AppMethodBeat.i(188971);
    if (ajCl.getAndDecrement(this) > 0)
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(188971);
      return paramd;
    }
    q localq = kotlinx.coroutines.s.av(kotlin.d.a.b.au(paramd));
    p localp = (p)localq;
    Object localObject3 = (i)this.tail;
    long l1 = ajCk.getAndIncrement(this);
    long l2 = l1 / h.kET();
    label69:
    Object localObject1 = (z)localObject3;
    label76:
    Object localObject2;
    if (((z)localObject1).id >= l2)
    {
      localObject2 = localObject1;
      if (!((z)localObject1).kDS()) {}
    }
    else
    {
      localObject2 = kotlinx.coroutines.internal.f.b((kotlinx.coroutines.internal.f)localObject1);
      if (localObject2 != e.kDP()) {
        break label304;
      }
      localObject2 = e.kDP();
    }
    label137:
    z localz;
    int i;
    if (!aa.iW(localObject2))
    {
      localObject1 = aa.jn(localObject2);
      localz = (z)this.tail;
      if (localz.id >= ((z)localObject1).id)
      {
        i = 1;
        label162:
        if (i == 0) {
          break label422;
        }
      }
    }
    else
    {
      localObject1 = (i)aa.jn(localObject2);
      i = (int)(l1 % h.kET());
      if (!((i)localObject1).ajCu.compareAndSet(i, null, localp)) {
        break label440;
      }
      localp.bg((kotlin.g.a.b)new a((i)localObject1, i));
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (ajCl.getAndDecrement(this) <= 0) {
          break;
        }
        localp.d(ah.aiuX, this.ajCm);
      }
      localObject1 = localq.getResult();
      if (localObject1 == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      paramd = (d<? super ah>)localObject1;
      if (localObject1 != kotlin.d.a.a.aiwj) {
        paramd = ah.aiuX;
      }
      if (paramd != kotlin.d.a.a.aiwj) {
        break label538;
      }
      AppMethodBeat.o(188971);
      return paramd;
      label304:
      localObject2 = (z)localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        break label76;
      }
      localObject2 = (z)h.a(((z)localObject1).id + 1L, (i)localObject1);
      if (!((z)localObject1).a((kotlinx.coroutines.internal.f)localObject2)) {
        break label76;
      }
      if (((z)localObject1).kDS()) {
        ((z)localObject1).remove();
      }
      localObject1 = localObject2;
      break label76;
      if (!((z)localObject1).kEn())
      {
        i = 0;
        break label162;
      }
      if (ajCj.compareAndSet(this, localz, localObject1))
      {
        if (localz.kEo()) {
          localz.remove();
        }
        i = 1;
        break label162;
        label422:
        break label69;
      }
      if (!((z)localObject1).kEo()) {
        break label137;
      }
      ((z)localObject1).remove();
      break label137;
      label440:
      localObject2 = h.kEU();
      localObject3 = h.kEV();
      if (((i)localObject1).ajCu.compareAndSet(i, localObject2, localObject3))
      {
        localp.d(ah.aiuX, this.ajCm);
        i = 1;
      }
      else
      {
        if (au.ASSERTIONS_ENABLED)
        {
          if (((i)localObject1).ajCu.get(i) == h.kEX()) {}
          for (i = 1; i == 0; i = 0)
          {
            paramd = new AssertionError();
            AppMethodBeat.o(188971);
            throw paramd;
          }
        }
        i = 0;
      }
    }
    label538:
    paramd = ah.aiuX;
    AppMethodBeat.o(188971);
    return paramd;
  }
  
  public final void release()
  {
    AppMethodBeat.i(188978);
    do
    {
      int j;
      do
      {
        j = this._availablePermits;
        if (j < this.ajCg) {}
        for (int i = 1; i == 0; i = 0)
        {
          Throwable localThrowable = (Throwable)new IllegalStateException(kotlin.g.b.s.X("The number of released permits cannot be greater than ", Integer.valueOf(this.ajCg)).toString());
          AppMethodBeat.o(188978);
          throw localThrowable;
        }
      } while (!ajCl.compareAndSet(this, j, j + 1));
      if (j >= 0)
      {
        AppMethodBeat.o(188978);
        return;
      }
    } while (!kES());
    AppMethodBeat.o(188978);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.g
 * JD-Core Version:    0.7.0.1
 */