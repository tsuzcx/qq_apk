package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;

@Metadata(d1={""}, d2={"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final void a(p<?> paramp, bi parambi)
  {
    AppMethodBeat.i(188794);
    paramp.bg((b)new bj(parambi));
    AppMethodBeat.o(188794);
  }
  
  public static final void a(p<?> paramp, kotlinx.coroutines.internal.p paramp1)
  {
    AppMethodBeat.i(188786);
    paramp.bg((b)new cr(paramp1));
    AppMethodBeat.o(188786);
  }
  
  public static final <T> q<T> av(kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(188778);
    if (!(paramd instanceof h))
    {
      paramd = new q(paramd, 1);
      AppMethodBeat.o(188778);
      return paramd;
    }
    Object localObject1 = (h)paramd;
    Object localObject2 = ((h)localObject1)._reusableCancellableContinuation;
    if (localObject2 == null)
    {
      ((h)localObject1)._reusableCancellableContinuation = i.ajAn;
      localObject1 = null;
      label52:
      if (localObject1 == null) {
        break label317;
      }
      if (!au.ASSERTIONS_ENABLED) {
        break label166;
      }
      if (((q)localObject1).ajvU != 2) {
        break label161;
      }
    }
    label161:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label166;
      }
      paramd = new AssertionError();
      AppMethodBeat.o(188778);
      throw paramd;
      if ((localObject2 instanceof q))
      {
        if (!h.ajAm.compareAndSet(localObject1, localObject2, i.ajAn)) {
          break;
        }
        localObject1 = (q)localObject2;
        break label52;
      }
      if ((localObject2 == i.ajAn) || ((localObject2 instanceof Throwable))) {
        break;
      }
      paramd = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Inconsistent state ", localObject2).toString());
      AppMethodBeat.o(188778);
      throw paramd;
    }
    label166:
    if (au.ASSERTIONS_ENABLED)
    {
      if (((q)localObject1).ajvq != co.ajwK) {}
      for (i = 1; i == 0; i = 0)
      {
        paramd = new AssertionError();
        AppMethodBeat.o(188778);
        throw paramd;
      }
    }
    localObject2 = ((q)localObject1)._state;
    if (au.ASSERTIONS_ENABLED)
    {
      if (!(localObject2 instanceof cp)) {}
      for (i = 1; i == 0; i = 0)
      {
        paramd = new AssertionError();
        AppMethodBeat.o(188778);
        throw paramd;
      }
    }
    if (((localObject2 instanceof ad)) && (((ad)localObject2).ajvA != null))
    {
      ((q)localObject1).kBI();
      i = 0;
      if (i == 0) {
        break label317;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label322;
      }
      paramd = new q(paramd, 2);
      AppMethodBeat.o(188778);
      return paramd;
      ((q)localObject1)._decision = 0;
      ((q)localObject1)._state = d.ajvg;
      i = 1;
      break;
      label317:
      localObject1 = null;
    }
    label322:
    AppMethodBeat.o(188778);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.s
 * JD-Core Version:    0.7.0.1
 */