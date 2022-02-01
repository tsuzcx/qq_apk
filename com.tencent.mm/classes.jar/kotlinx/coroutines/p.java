package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendAtomicCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "holdCancellability", "", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendAtomicCancellableCoroutineReusable", "suspendCancellableCoroutine", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"})
public final class p
{
  public static final void a(m<?> paramm, be parambe)
  {
    AppMethodBeat.i(204262);
    paramm.am((kotlin.g.a.b)new bf(parambe));
    AppMethodBeat.o(204262);
  }
  
  public static final <T> n<T> l(d<? super T> paramd)
  {
    AppMethodBeat.i(204261);
    if (!(paramd instanceof ax))
    {
      paramd = new n(paramd, 0);
      AppMethodBeat.o(204261);
      return paramd;
    }
    Object localObject1 = (ax)paramd;
    Object localObject2 = ((ax)localObject1)._reusableCancellableContinuation;
    if (localObject2 == null)
    {
      ((ax)localObject1)._reusableCancellableContinuation = ay.abwS;
      localObject1 = null;
      label52:
      if (localObject1 == null) {
        break label231;
      }
      if (!ap.iRg()) {
        break label163;
      }
      if ((be)((n)localObject1)._parentHandle == ck.abxK) {
        break label158;
      }
    }
    label158:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label163;
      }
      paramd = (Throwable)new AssertionError();
      AppMethodBeat.o(204261);
      throw paramd;
      if ((localObject2 instanceof n))
      {
        if (!ax.abwO.compareAndSet(localObject1, localObject2, ay.abwS)) {
          break;
        }
        localObject1 = (n)localObject2;
        break label52;
      }
      paramd = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject2)).toString());
      AppMethodBeat.o(204261);
      throw paramd;
    }
    label163:
    localObject2 = ((n)localObject1)._state;
    if (ap.iRg())
    {
      if (!(localObject2 instanceof cl)) {}
      for (i = 1; i == 0; i = 0)
      {
        paramd = (Throwable)new AssertionError();
        AppMethodBeat.o(204261);
        throw paramd;
      }
    }
    if ((localObject2 instanceof z))
    {
      ((n)localObject1).iQS();
      i = 0;
      if (i == 0) {
        break label265;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label270;
      }
      label231:
      paramd = new n(paramd, 0);
      AppMethodBeat.o(204261);
      return paramd;
      ((n)localObject1)._decision = 0;
      ((n)localObject1)._state = b.abvY;
      i = 1;
      break;
      label265:
      localObject1 = null;
    }
    label270:
    AppMethodBeat.o(204261);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */