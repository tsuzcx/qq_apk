package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.f;
import d.d.f.c;
import d.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.r;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class k<T>
  extends aw<T>
  implements d.d.b.a.d, j<T>
{
  private static final AtomicIntegerFieldUpdater LQH;
  private static final AtomicReferenceFieldUpdater LQI;
  final d.d.d<T> KUa;
  private final f LQy;
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(191183);
    LQH = AtomicIntegerFieldUpdater.newUpdater(k.class, "_decision");
    LQI = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_state");
    AppMethodBeat.o(191183);
  }
  
  public k(d.d.d<? super T> paramd)
  {
    super(1);
    AppMethodBeat.i(118213);
    this.KUa = paramd;
    this.LQy = this.KUa.fOf();
    this._decision = 0;
    this._state = b.LQA;
    this._parentHandle = null;
    AppMethodBeat.o(118213);
  }
  
  private static void a(d.g.a.b<? super Throwable, d.y> paramb, Object paramObject)
  {
    AppMethodBeat.i(191174);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(191174);
    throw paramb;
  }
  
  private final void aiZ(int paramInt)
  {
    AppMethodBeat.i(191175);
    if (gdp())
    {
      AppMethodBeat.o(191175);
      return;
    }
    ax.a(this, paramInt);
    AppMethodBeat.o(191175);
  }
  
  private static void fE(Object paramObject)
  {
    AppMethodBeat.i(191177);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(191177);
    throw paramObject;
  }
  
  private final boolean gdl()
  {
    if ((this.KUa instanceof at))
    {
      if (((at)this.KUa)._reusableCancellableContinuation != null) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private final void gdm()
  {
    Object localObject2 = null;
    AppMethodBeat.i(191165);
    boolean bool = isCompleted();
    if (this.LRu != 0) {}
    while (bool)
    {
      AppMethodBeat.o(191165);
      return;
      Object localObject3 = this.KUa;
      localObject1 = localObject3;
      if (!(localObject3 instanceof at)) {
        localObject1 = null;
      }
      localObject3 = (at)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (j)this;
        Object localObject4;
        do
        {
          localObject4 = ((at)localObject3)._reusableCancellableContinuation;
          if (localObject4 != au.LRt) {
            break;
          }
        } while (!at.LRp.compareAndSet(localObject3, au.LRt, localObject1));
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
                if (!at.LRp.compareAndSet(localObject3, localObject4, null))
                {
                  localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                  AppMethodBeat.o(191165);
                  throw ((Throwable)localObject1);
                }
                localObject1 = (Throwable)localObject4;
              }
              else
              {
                localObject1 = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject4)).toString());
                AppMethodBeat.o(191165);
                throw ((Throwable)localObject1);
              }
            }
          }
        }
        if (!bool) {
          x((Throwable)localObject1);
        }
        bool = true;
      }
    }
    if ((az)this._parentHandle != null)
    {
      AppMethodBeat.o(191165);
      return;
    }
    Object localObject1 = (bo)this.KUa.fOf().get((f.c)bo.LRQ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(191165);
      return;
    }
    ((bo)localObject1).start();
    localObject1 = bo.a.a((bo)localObject1, true, false, (d.g.a.b)new o((bo)localObject1, this), 2);
    this._parentHandle = localObject1;
    if ((isCompleted()) && (!gdl()))
    {
      ((az)localObject1).dispose();
      this._parentHandle = ((az)by.LSi);
    }
    AppMethodBeat.o(191165);
  }
  
  private final boolean gdo()
  {
    AppMethodBeat.i(191169);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(191169);
        throw localThrowable;
      }
    } while (!LQH.compareAndSet(this, 0, 1));
    AppMethodBeat.o(191169);
    return true;
    AppMethodBeat.o(191169);
    return false;
  }
  
  private final boolean gdp()
  {
    AppMethodBeat.i(191170);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(191170);
        throw localThrowable;
      }
    } while (!LQH.compareAndSet(this, 0, 2));
    AppMethodBeat.o(191170);
    return true;
    AppMethodBeat.o(191170);
    return false;
  }
  
  private final n o(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(191176);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof bz))
      {
        if (LQI.compareAndSet(this, localObject, paramObject))
        {
          gdq();
          aiZ(paramInt);
          AppMethodBeat.o(191176);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof n)) && (((n)localObject).gdu()))
        {
          paramObject = (n)localObject;
          AppMethodBeat.o(191176);
          return paramObject;
        }
        fE(paramObject);
      }
    }
  }
  
  public final void K(d.g.a.b<? super Throwable, d.y> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(191173);
    Object localObject1 = null;
    Object localObject4 = this._state;
    if ((localObject4 instanceof b))
    {
      if (localObject1 != null) {
        break label214;
      }
      if ((paramb instanceof h)) {
        localObject1 = (h)paramb;
      }
    }
    label41:
    label208:
    label214:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (LQI.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(191173);
        return;
        localObject1 = (h)new bl(paramb);
        break label41;
        if ((localObject4 instanceof h))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof n)) {
          if (!((n)localObject4).gdy()) {
            a(paramb, localObject4);
          }
        }
      }
      for (;;)
      {
        try
        {
          if ((localObject4 instanceof t)) {
            break label208;
          }
          localObject1 = null;
          localObject2 = (t)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((t)localObject2).cause;
          }
          paramb.ay(localObject1);
          AppMethodBeat.o(191173);
          return;
        }
        catch (Throwable paramb)
        {
          ad.b(this.LQy, (Throwable)new y("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(191173);
          return;
        }
        AppMethodBeat.o(191173);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public Throwable a(bo parambo)
  {
    AppMethodBeat.i(191168);
    parambo = (Throwable)parambo.gec();
    AppMethodBeat.o(191168);
    return parambo;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(191166);
    if ((paramObject instanceof w)) {
      try
      {
        ((w)paramObject).LQT.ay(paramThrowable);
        AppMethodBeat.o(191166);
        return;
      }
      catch (Throwable paramObject)
      {
        ad.b(this.LQy, (Throwable)new y("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(191166);
  }
  
  public final void a(ab paramab, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.KUa;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof at)) {
      localObject1 = null;
    }
    localObject3 = (at)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((at)localObject3).LRq;
    }
    if (localObject1 == paramab) {}
    for (int i = 2;; i = this.LRu)
    {
      o(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void eK(Object paramObject)
  {
    AppMethodBeat.i(191172);
    j localj = (j)this;
    Throwable localThrowable = p.eH(paramObject);
    if (localThrowable == null)
    {
      o(paramObject, this.LRu);
      AppMethodBeat.o(191172);
      return;
    }
    paramObject = (d.d.d)localj;
    if (!al.gdE()) {}
    for (paramObject = localThrowable;; paramObject = r.a(localThrowable, (d.d.b.a.d)paramObject))
    {
      paramObject = new t(paramObject);
      break;
    }
  }
  
  public final void fD(Object paramObject)
  {
    AppMethodBeat.i(191181);
    if (al.gdD())
    {
      if (paramObject == l.LQJ) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(191181);
        throw paramObject;
      }
    }
    aiZ(this.LRu);
    AppMethodBeat.o(191181);
  }
  
  public final <T> T fF(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof v)) {
      localObject = ((v)paramObject).result;
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof w));
    return ((w)paramObject).result;
  }
  
  public final f fOf()
  {
    return this.LQy;
  }
  
  public final d.d.b.a.d fOh()
  {
    d.d.d locald2 = this.KUa;
    d.d.d locald1 = locald2;
    if (!(locald2 instanceof d.d.b.a.d)) {
      locald1 = null;
    }
    return (d.d.b.a.d)locald1;
  }
  
  public final StackTraceElement fOi()
  {
    return null;
  }
  
  public final Object gdn()
  {
    return this._state;
  }
  
  final void gdq()
  {
    AppMethodBeat.i(191178);
    if (!gdl()) {
      gdr();
    }
    AppMethodBeat.o(191178);
  }
  
  public final void gdr()
  {
    AppMethodBeat.i(191179);
    az localaz = (az)this._parentHandle;
    if (localaz != null) {
      localaz.dispose();
    }
    this._parentHandle = ((az)by.LSi);
    AppMethodBeat.o(191179);
  }
  
  protected String gds()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d.d.d<T> gdt()
  {
    return this.KUa;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(191171);
    gdm();
    if (gdo())
    {
      localObject1 = a.KUd;
      AppMethodBeat.o(191171);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof t))
    {
      localObject1 = ((t)localObject1).cause;
      localObject2 = (d.d.d)this;
      if (!al.gdE()) {}
      for (;;)
      {
        AppMethodBeat.o(191171);
        throw ((Throwable)localObject1);
        localObject1 = r.a((Throwable)localObject1, (d.d.b.a.d)localObject2);
      }
    }
    if (this.LRu == 1)
    {
      localObject2 = (bo)this.LQy.get((f.c)bo.LRQ);
      if ((localObject2 != null) && (!((bo)localObject2).isActive()))
      {
        localObject2 = ((bo)localObject2).gec();
        a(localObject1, (Throwable)localObject2);
        localObject1 = (d.d.d)this;
        if (!al.gdE()) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = r.a((Throwable)localObject2, (d.d.b.a.d)localObject1))
        {
          AppMethodBeat.o(191171);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fF(localObject1);
    AppMethodBeat.o(191171);
    return localObject1;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof bz);
  }
  
  public String toString()
  {
    AppMethodBeat.i(191182);
    String str = gds() + '(' + am.e(this.KUa) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(191182);
    return str;
  }
  
  public final Object v(Throwable paramThrowable)
  {
    AppMethodBeat.i(191180);
    Object localObject;
    t localt;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof bz)) {
        break;
      }
      localt = new t(paramThrowable);
    } while (!LQI.compareAndSet(this, localObject, localt));
    gdq();
    paramThrowable = l.LQJ;
    AppMethodBeat.o(191180);
    return paramThrowable;
    AppMethodBeat.o(191180);
    return null;
  }
  
  public final boolean x(Throwable paramThrowable)
  {
    AppMethodBeat.i(191167);
    Object localObject;
    n localn;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof bz))
      {
        AppMethodBeat.o(191167);
        return false;
      }
      localn = new n((d.d.d)this, paramThrowable, localObject instanceof h);
    } while (!LQI.compareAndSet(this, localObject, localn));
    if ((localObject instanceof h)) {}
    try
    {
      ((h)localObject).u(paramThrowable);
      gdq();
      aiZ(0);
      AppMethodBeat.o(191167);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        ad.b(this.LQy, (Throwable)new y("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.k
 * JD-Core Version:    0.7.0.1
 */