package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "savedContext", "savedOldValue", "", "afterResume", "", "state", "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class de<T>
  extends y<T>
{
  f ajwR;
  Object ajwS;
  
  public de(f paramf, d<? super T> paramd)
  {
    super(localf, paramd);
    AppMethodBeat.i(188970);
    AppMethodBeat.o(188970);
  }
  
  public final void iv(Object paramObject)
  {
    ah localah = null;
    AppMethodBeat.i(188984);
    f localf = this.ajwR;
    if (localf != null)
    {
      ag.c(localf, this.ajwS);
      this.ajwR = null;
      this.ajwS = null;
    }
    Object localObject3 = ai.e(paramObject, this.ajzY);
    d locald = this.ajzY;
    localf = locald.getContext();
    Object localObject2 = ag.b(localf, null);
    paramObject = localah;
    if (localObject2 != ag.ajAT) {
      paramObject = ak.a(locald, localf, localObject2);
    }
    try
    {
      this.ajzY.resumeWith(localObject3);
      localah = ah.aiuX;
      return;
    }
    finally
    {
      if ((paramObject == null) || (paramObject.kCP())) {
        ag.c(localf, localObject2);
      }
      AppMethodBeat.o(188984);
    }
  }
  
  public final boolean kCP()
  {
    if (this.ajwR == null) {
      return false;
    }
    this.ajwR = null;
    this.ajwS = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.de
 * JD-Core Version:    0.7.0.1
 */