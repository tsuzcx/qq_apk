package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.b;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.a.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "_state", "", "_state$annotations", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "countOrElement", "delegate", "getDelegate", "()Lkotlin/coroutines/Continuation;", "dispatchYield", "", "value", "dispatchYield$kotlinx_coroutines_core", "(Ljava/lang/Object;)V", "resumeCancellable", "resumeCancellableWithException", "exception", "", "resumeCancelled", "", "resumeUndispatched", "resumeUndispatchedWithException", "resumeWith", "result", "Lkotlin/Result;", "takeState", "toString", "", "kotlinx-coroutines-core"})
public final class al<T>
  extends an<T>
  implements c<T>
{
  public final Object CHM;
  public final w CHN;
  public final c<T> CHO;
  public Object CHh;
  
  public al(w paramw, c<? super T> paramc)
  {
    super(0);
    AppMethodBeat.i(118516);
    this.CHN = paramw;
    this.CHO = paramc;
    this.CHh = am.epG();
    this.CHM = o.d(eaV());
    AppMethodBeat.o(118516);
  }
  
  public final void dg(Object paramObject)
  {
    AppMethodBeat.i(118514);
    Object localObject1 = this.CHO.eaV();
    Object localObject2 = r.dY(paramObject);
    if (this.CHN.b((e)localObject1))
    {
      this.CHh = localObject2;
      this.CHQ = 0;
      this.CHN.a((e)localObject1, (Runnable)this);
      AppMethodBeat.o(118514);
      return;
    }
    localObject1 = bu.CIG;
    localObject1 = (bu.a)bu.CIF.get();
    if (((bu.a)localObject1).isActive)
    {
      this.CHh = localObject2;
      this.CHQ = 0;
      ((bu.a)localObject1).CIH.addLast(this);
      AppMethodBeat.o(118514);
      return;
    }
    j.p(localObject1, "eventLoop");
    for (;;)
    {
      try
      {
        ((bu.a)localObject1).isActive = true;
        localObject2 = eaV();
        Object localObject3 = o.b((e)localObject2, this.CHM);
        try
        {
          this.CHO.dg(paramObject);
          paramObject = y.BMg;
          o.a((e)localObject2, localObject3);
          paramObject = (Runnable)((bu.a)localObject1).CIH.eqc();
          if (paramObject == null) {
            return;
          }
        }
        finally
        {
          o.a((e)localObject2, localObject3);
          AppMethodBeat.o(118514);
        }
        paramObject.run();
      }
      catch (Throwable paramObject)
      {
        ((bu.a)localObject1).CIH.clear();
        paramObject = (Throwable)new ak("Unexpected exception in undispatched event loop, clearing pending tasks", paramObject);
        AppMethodBeat.o(118514);
        throw paramObject;
      }
      finally
      {
        ((bu.a)localObject1).isActive = false;
        AppMethodBeat.o(118514);
      }
    }
  }
  
  public final e eaV()
  {
    AppMethodBeat.i(118517);
    e locale = this.CHO.eaV();
    AppMethodBeat.o(118517);
    return locale;
  }
  
  public final Object epm()
  {
    AppMethodBeat.i(118513);
    Object localObject = this.CHh;
    if (localObject != am.epG()) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118513);
      throw ((Throwable)localObject);
    }
    this.CHh = am.epG();
    AppMethodBeat.o(118513);
    return localObject;
  }
  
  public final c<T> epp()
  {
    return (c)this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118515);
    String str = "DispatchedContinuation[" + this.CHN + ", " + af.d(this.CHO) + ']';
    AppMethodBeat.o(118515);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.al
 * JD-Core Version:    0.7.0.1
 */