package kotlinx.coroutines;

import a.c.c;
import a.f.b.j;
import a.l;
import a.y;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/AbstractContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/Continuation;", "delegate", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "getDelegate", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "cancel", "cause", "", "cancelImpl", "completeStateUpdate", "", "expect", "Lkotlinx/coroutines/NotCompleted;", "update", "mode", "dispatchResume", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getResult", "handleException", "exception", "initParentJobInternal", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "loopOnState", "", "block", "makeHandler", "Lkotlinx/coroutines/CancelHandler;", "nameString", "", "resumeImpl", "proposedUpdate", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumeWithExceptionMode", "resumeWithExceptionMode$kotlinx_coroutines_core", "stateString", "takeState", "toString", "tryResume", "trySuspend", "tryUpdateStateToFinal", "updateStateToFinal", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends an<T>
  implements c<T>
{
  private static final AtomicIntegerFieldUpdater CHg = AtomicIntegerFieldUpdater.newUpdater(a.class, "CHf");
  private static final AtomicReferenceFieldUpdater CHi = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "CHh");
  public final c<T> BMP;
  private volatile int CHf;
  public volatile Object CHh;
  public volatile ap CHj;
  
  public a(c<? super T> paramc)
  {
    super(1);
    this.BMP = paramc;
    this.CHf = 0;
    this.CHh = b.epq();
  }
  
  private final void Wf(int paramInt)
  {
    int j = 0;
    do
    {
      i = j;
      switch (this.CHf)
      {
      default: 
        throw ((Throwable)new IllegalStateException("Already resumed".toString()));
      }
    } while (!CHg.compareAndSet(this, 0, 2));
    int i = 1;
    if (i != 0) {
      return;
    }
    am.a(this, paramInt);
  }
  
  public static Throwable a(bc parambc)
  {
    j.q(parambc, "parent");
    return (Throwable)parambc.epQ();
  }
  
  private boolean a(bm parambm, Object paramObject)
  {
    j.q(parambm, "expect");
    if (!(paramObject instanceof bm)) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    if (!CHi.compareAndSet(this, parambm, paramObject)) {
      return false;
    }
    parambm = this.CHj;
    if (parambm != null)
    {
      parambm.dispose();
      this.CHj = ((ap)bl.CIC);
    }
    return true;
  }
  
  private void b(bm parambm, Object paramObject, int paramInt)
  {
    Object localObject2 = null;
    j.q(parambm, "expect");
    if (!(paramObject instanceof q)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (q)localObject1;
      if (((paramObject instanceof k)) && ((parambm instanceof g))) {}
      try
      {
        g localg = (g)parambm;
        paramObject = localObject2;
        if (localObject1 != null) {
          paramObject = ((q)localObject1).cause;
        }
        localg.v(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          t((Throwable)new u("Exception in completion handler " + parambm + " for " + this, paramObject));
        }
      }
      Wf(paramInt);
      return;
    }
  }
  
  private final void t(Throwable paramThrowable)
  {
    z.a(eaV(), paramThrowable, null);
  }
  
  final boolean a(bm parambm, Object paramObject, int paramInt)
  {
    if (!a(parambm, paramObject)) {
      return false;
    }
    b(parambm, paramObject, paramInt);
    return true;
  }
  
  public final void dg(Object paramObject)
  {
    k(r.dY(paramObject), this.CHQ);
  }
  
  public final Object epm()
  {
    return this.CHh;
  }
  
  public final boolean epn()
  {
    do
    {
      switch (this.CHf)
      {
      case 1: 
      default: 
        throw ((Throwable)new IllegalStateException("Already suspended".toString()));
      }
    } while (!CHg.compareAndSet(this, 0, 1));
    return true;
    return false;
  }
  
  protected String epo()
  {
    return af.ea(this);
  }
  
  public final c<T> epp()
  {
    return this.BMP;
  }
  
  public final void k(a.f.a.b<? super Throwable, y> paramb)
  {
    Object localObject3 = null;
    j.q(paramb, "handler");
    Object localObject1 = null;
    Object localObject4 = this.CHh;
    if ((localObject4 instanceof d))
    {
      if (localObject1 != null) {
        break label176;
      }
      if ((paramb instanceof g)) {
        localObject1 = (g)paramb;
      }
    }
    label170:
    label176:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (CHi.compareAndSet(this, localObject4, localObject2))
      {
        do
        {
          return;
          localObject1 = (g)new az(paramb);
          break;
          if ((localObject4 instanceof g)) {
            throw ((Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + localObject4).toString()));
          }
        } while (!(localObject4 instanceof k));
        if ((localObject4 instanceof q)) {
          break label170;
        }
      }
      for (localObject1 = null;; localObject1 = localObject4)
      {
        localObject2 = (q)localObject1;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((q)localObject2).cause;
        }
        paramb.S(localObject1);
        return;
        break;
      }
    }
  }
  
  protected final void k(Object paramObject, int paramInt)
  {
    Object localObject;
    do
    {
      localObject = this.CHh;
      if (!(localObject instanceof bm)) {
        break;
      }
    } while (!a((bm)localObject, paramObject, paramInt));
    do
    {
      return;
      if (!(localObject instanceof k)) {
        break;
      }
    } while (!(paramObject instanceof q));
    t(((q)paramObject).cause);
    return;
    throw ((Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString()));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(epo()).append('{');
    Object localObject = this.CHh;
    if ((localObject instanceof bm)) {
      localObject = "Active";
    }
    for (;;)
    {
      return (String)localObject + "}@" + af.dZ(this);
      if ((localObject instanceof k)) {
        localObject = "Cancelled";
      } else if ((localObject instanceof q)) {
        localObject = "CompletedExceptionally";
      } else {
        localObject = "Completed";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */