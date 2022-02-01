package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.d.d;
import d.d.f.c;
import d.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class i<T>
  extends ar<T>
  implements e, h<T>
{
  private static final AtomicIntegerFieldUpdater Kdg;
  private static final AtomicReferenceFieldUpdater Kdh;
  final d<T> JgG;
  private final d.d.f Kdd;
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(190059);
    Kdg = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");
    Kdh = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state");
    AppMethodBeat.o(190059);
  }
  
  public i(d<? super T> paramd)
  {
    super(1);
    AppMethodBeat.i(118213);
    this.JgG = paramd;
    this.Kdd = this.JgG.fvA();
    this._decision = 0;
    this._state = b.Kdf;
    this._parentHandle = null;
    AppMethodBeat.o(118213);
  }
  
  private static void a(d.g.a.b<? super Throwable, d.y> paramb, Object paramObject)
  {
    AppMethodBeat.i(190052);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(190052);
    throw paramb;
  }
  
  private final void agd(int paramInt)
  {
    AppMethodBeat.i(190053);
    if (fKI())
    {
      AppMethodBeat.o(190053);
      return;
    }
    as.a(this, paramInt);
    AppMethodBeat.o(190053);
  }
  
  private final boolean fKF()
  {
    if ((this.JgG instanceof ap))
    {
      if (((ap)this.JgG)._reusableCancellableContinuation != null) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean fKH()
  {
    AppMethodBeat.i(190047);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(190047);
        throw localThrowable;
      }
    } while (!Kdg.compareAndSet(this, 0, 1));
    AppMethodBeat.o(190047);
    return true;
    AppMethodBeat.o(190047);
    return false;
  }
  
  private final boolean fKI()
  {
    AppMethodBeat.i(190048);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(190048);
        throw localThrowable;
      }
    } while (!Kdg.compareAndSet(this, 0, 2));
    AppMethodBeat.o(190048);
    return true;
    AppMethodBeat.o(190048);
    return false;
  }
  
  private static void fz(Object paramObject)
  {
    AppMethodBeat.i(190055);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(190055);
    throw paramObject;
  }
  
  private final void gaE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(202338);
    boolean bool = isCompleted();
    if (this.KdT != 0) {}
    while (bool)
    {
      AppMethodBeat.o(202338);
      return;
      Object localObject3 = this.JgG;
      localObject1 = localObject3;
      if (!(localObject3 instanceof ap)) {
        localObject1 = null;
      }
      localObject3 = (ap)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (h)this;
        Object localObject4;
        do
        {
          localObject4 = ((ap)localObject3)._reusableCancellableContinuation;
          if (localObject4 != aq.KdS) {
            break;
          }
        } while (!ap.KdO.compareAndSet(localObject3, aq.KdS, localObject1));
        localObject1 = localObject2;
        for (;;)
        {
          if (localObject1 == null)
          {
            break;
            localObject1 = localObject2;
            if (localObject4 != null) {
              if ((localObject4 instanceof Throwable))
              {
                if (!ap.KdO.compareAndSet(localObject3, localObject4, null))
                {
                  localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                  AppMethodBeat.o(202338);
                  throw ((Throwable)localObject1);
                }
                localObject1 = (Throwable)localObject4;
              }
              else
              {
                localObject1 = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject4)).toString());
                AppMethodBeat.o(202338);
                throw ((Throwable)localObject1);
              }
            }
          }
        }
        if (!bool) {
          v((Throwable)localObject1);
        }
        bool = true;
      }
    }
    if ((au)this._parentHandle != null)
    {
      AppMethodBeat.o(202338);
      return;
    }
    Object localObject1 = (bj)this.JgG.fvA().get((f.c)bj.Keq);
    if (localObject1 == null)
    {
      AppMethodBeat.o(202338);
      return;
    }
    ((bj)localObject1).start();
    localObject1 = bj.a.a((bj)localObject1, true, false, (d.g.a.b)new l((bj)localObject1, this), 2);
    this._parentHandle = localObject1;
    if ((isCompleted()) && (!fKF()))
    {
      ((au)localObject1).dispose();
      this._parentHandle = ((au)bt.KeI);
    }
    AppMethodBeat.o(202338);
  }
  
  private final k l(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(190054);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof bu))
      {
        if (Kdh.compareAndSet(this, localObject, paramObject))
        {
          fKJ();
          agd(paramInt);
          AppMethodBeat.o(190054);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof k)) && (((k)localObject).fKN()))
        {
          paramObject = (k)localObject;
          AppMethodBeat.o(190054);
          return paramObject;
        }
        fz(paramObject);
      }
    }
  }
  
  public final void C(d.g.a.b<? super Throwable, d.y> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(190051);
    Object localObject1 = null;
    Object localObject4 = this._state;
    if ((localObject4 instanceof b))
    {
      if (localObject1 != null) {
        break label214;
      }
      if ((paramb instanceof f)) {
        localObject1 = (f)paramb;
      }
    }
    label41:
    label208:
    label214:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (Kdh.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(190051);
        return;
        localObject1 = (f)new bg(paramb);
        break label41;
        if ((localObject4 instanceof f))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof k)) {
          if (!((k)localObject4).fKR()) {
            a(paramb, localObject4);
          }
        }
      }
      for (;;)
      {
        try
        {
          if ((localObject4 instanceof q)) {
            break label208;
          }
          localObject1 = null;
          localObject2 = (q)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((q)localObject2).cause;
          }
          paramb.aA(localObject1);
          AppMethodBeat.o(190051);
          return;
        }
        catch (Throwable paramb)
        {
          aa.b(this.Kdd, (Throwable)new v("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(190051);
          return;
        }
        AppMethodBeat.o(190051);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public final Object S(Throwable paramThrowable)
  {
    AppMethodBeat.i(202339);
    Object localObject;
    q localq;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof bu)) {
        break;
      }
      localq = new q(paramThrowable);
    } while (!Kdh.compareAndSet(this, localObject, localq));
    fKJ();
    paramThrowable = ch.LEB;
    AppMethodBeat.o(202339);
    return paramThrowable;
    AppMethodBeat.o(202339);
    return null;
  }
  
  public Throwable a(bj parambj)
  {
    AppMethodBeat.i(190046);
    parambj = (Throwable)parambj.fLt();
    AppMethodBeat.o(190046);
    return parambj;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(190044);
    if ((paramObject instanceof t)) {
      try
      {
        ((t)paramObject).Kdr.aA(paramThrowable);
        AppMethodBeat.o(190044);
        return;
      }
      catch (Throwable paramObject)
      {
        aa.b(this.Kdd, (Throwable)new v("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(190044);
  }
  
  public final void a(y paramy, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.JgG;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof ap)) {
      localObject1 = null;
    }
    localObject3 = (ap)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((ap)localObject3).KdP;
    }
    if (localObject1 == paramy) {}
    for (int i = 2;; i = this.KdT)
    {
      l(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void eH(Object paramObject)
  {
    AppMethodBeat.i(190050);
    h localh = (h)this;
    Throwable localThrowable = p.eE(paramObject);
    if (localThrowable == null)
    {
      l(paramObject, this.KdT);
      AppMethodBeat.o(190050);
      return;
    }
    paramObject = (d)localh;
    if (!ah.fKX()) {}
    for (paramObject = localThrowable;; paramObject = kotlinx.coroutines.a.l.a(localThrowable, (e)paramObject))
    {
      paramObject = new q(paramObject);
      break;
    }
  }
  
  public final <T> T fA(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof s)) {
      localObject = ((s)paramObject).result;
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof t));
    return ((t)paramObject).result;
  }
  
  public final Object fKG()
  {
    return this._state;
  }
  
  final void fKJ()
  {
    AppMethodBeat.i(190056);
    if (!fKF()) {
      fKK();
    }
    AppMethodBeat.o(190056);
  }
  
  public final void fKK()
  {
    AppMethodBeat.i(190057);
    au localau = (au)this._parentHandle;
    if (localau != null) {
      localau.dispose();
    }
    this._parentHandle = ((au)bt.KeI);
    AppMethodBeat.o(190057);
  }
  
  protected String fKL()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d<T> fKM()
  {
    return this.JgG;
  }
  
  public final d.d.f fvA()
  {
    return this.Kdd;
  }
  
  public final e fvC()
  {
    d locald2 = this.JgG;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement fvD()
  {
    return null;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(190049);
    gaE();
    if (fKH())
    {
      localObject1 = a.JgJ;
      AppMethodBeat.o(190049);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof q))
    {
      localObject1 = ((q)localObject1).cause;
      localObject2 = (d)this;
      if (!ah.fKX()) {}
      for (;;)
      {
        AppMethodBeat.o(190049);
        throw ((Throwable)localObject1);
        localObject1 = kotlinx.coroutines.a.l.a((Throwable)localObject1, (e)localObject2);
      }
    }
    if (this.KdT == 1)
    {
      localObject2 = (bj)this.Kdd.get((f.c)bj.Keq);
      if ((localObject2 != null) && (!((bj)localObject2).isActive()))
      {
        localObject2 = ((bj)localObject2).fLt();
        a(localObject1, (Throwable)localObject2);
        localObject1 = (d)this;
        if (!ah.fKX()) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = kotlinx.coroutines.a.l.a((Throwable)localObject2, (e)localObject1))
        {
          AppMethodBeat.o(190049);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fA(localObject1);
    AppMethodBeat.o(190049);
    return localObject1;
  }
  
  public final void gh(Object paramObject)
  {
    AppMethodBeat.i(202340);
    if (ah.fKW())
    {
      if (paramObject == ch.LEB) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(202340);
        throw paramObject;
      }
    }
    agd(this.KdT);
    AppMethodBeat.o(202340);
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof bu);
  }
  
  public String toString()
  {
    AppMethodBeat.i(190058);
    String str = fKL() + '(' + ai.e(this.JgG) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(190058);
    return str;
  }
  
  public final boolean v(Throwable paramThrowable)
  {
    AppMethodBeat.i(190045);
    Object localObject;
    k localk;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof bu))
      {
        AppMethodBeat.o(190045);
        return false;
      }
      localk = new k((d)this, paramThrowable, localObject instanceof f);
    } while (!Kdh.compareAndSet(this, localObject, localk));
    if ((localObject instanceof f)) {}
    try
    {
      ((f)localObject).u(paramThrowable);
      fKJ();
      agd(0);
      AppMethodBeat.o(190045);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        aa.b(this.Kdd, (Throwable)new v("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.i
 * JD-Core Version:    0.7.0.1
 */