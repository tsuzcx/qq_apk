package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlinx.coroutines.internal.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class l<T>
  extends ay<T>
  implements e, k<T>
{
  private static final AtomicIntegerFieldUpdater TTC;
  private static final AtomicReferenceFieldUpdater TTD;
  final d<T> SXL;
  private final f TTt;
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(192427);
    TTC = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");
    TTD = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    AppMethodBeat.o(192427);
  }
  
  public l(d<? super T> paramd)
  {
    super(1);
    AppMethodBeat.i(118213);
    this.SXL = paramd;
    this.TTt = this.SXL.getContext();
    this._decision = 0;
    this._state = b.TTv;
    this._parentHandle = null;
    AppMethodBeat.o(118213);
  }
  
  private static void a(kotlin.g.a.b<? super Throwable, kotlin.x> paramb, Object paramObject)
  {
    AppMethodBeat.i(192418);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(192418);
    throw paramb;
  }
  
  private final void avT(int paramInt)
  {
    AppMethodBeat.i(192419);
    if (hMv())
    {
      AppMethodBeat.o(192419);
      return;
    }
    az.a(this, paramInt);
    AppMethodBeat.o(192419);
  }
  
  private static void fO(Object paramObject)
  {
    AppMethodBeat.i(192421);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(192421);
    throw paramObject;
  }
  
  private final boolean hMr()
  {
    if ((this.SXL instanceof av))
    {
      if (((av)this.SXL)._reusableCancellableContinuation != null) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private final void hMs()
  {
    Object localObject2 = null;
    AppMethodBeat.i(192409);
    boolean bool = isCompleted();
    if (this.TUq != 0) {}
    while (bool)
    {
      AppMethodBeat.o(192409);
      return;
      Object localObject3 = this.SXL;
      localObject1 = localObject3;
      if (!(localObject3 instanceof av)) {
        localObject1 = null;
      }
      localObject3 = (av)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (k)this;
        Object localObject4;
        do
        {
          localObject4 = ((av)localObject3)._reusableCancellableContinuation;
          if (localObject4 != aw.TUp) {
            break;
          }
        } while (!av.TUl.compareAndSet(localObject3, aw.TUp, localObject1));
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
                if (!av.TUl.compareAndSet(localObject3, localObject4, null))
                {
                  localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                  AppMethodBeat.o(192409);
                  throw ((Throwable)localObject1);
                }
                localObject1 = (Throwable)localObject4;
              }
              else
              {
                localObject1 = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject4)).toString());
                AppMethodBeat.o(192409);
                throw ((Throwable)localObject1);
              }
            }
          }
        }
        if (!bool) {
          A((Throwable)localObject1);
        }
        bool = true;
      }
    }
    if ((bc)this._parentHandle != null)
    {
      AppMethodBeat.o(192409);
      return;
    }
    Object localObject1 = (bu)this.SXL.getContext().get((f.c)bu.TUO);
    if (localObject1 == null)
    {
      AppMethodBeat.o(192409);
      return;
    }
    ((bu)localObject1).start();
    localObject1 = bu.a.a((bu)localObject1, true, false, (kotlin.g.a.b)new p((bu)localObject1, this), 2);
    this._parentHandle = localObject1;
    if ((isCompleted()) && (!hMr()))
    {
      ((bc)localObject1).dispose();
      this._parentHandle = ((bc)cg.TVh);
    }
    AppMethodBeat.o(192409);
  }
  
  private final boolean hMu()
  {
    AppMethodBeat.i(192413);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(192413);
        throw localThrowable;
      }
    } while (!TTC.compareAndSet(this, 0, 1));
    AppMethodBeat.o(192413);
    return true;
    AppMethodBeat.o(192413);
    return false;
  }
  
  private final boolean hMv()
  {
    AppMethodBeat.i(192414);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(192414);
        throw localThrowable;
      }
    } while (!TTC.compareAndSet(this, 0, 2));
    AppMethodBeat.o(192414);
    return true;
    AppMethodBeat.o(192414);
    return false;
  }
  
  private final o s(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(192420);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof ch))
      {
        if (TTD.compareAndSet(this, localObject, paramObject))
        {
          hMw();
          avT(paramInt);
          AppMethodBeat.o(192420);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof o)) && (((o)localObject).hMA()))
        {
          paramObject = (o)localObject;
          AppMethodBeat.o(192420);
          return paramObject;
        }
        fO(paramObject);
      }
    }
  }
  
  public final boolean A(Throwable paramThrowable)
  {
    AppMethodBeat.i(192411);
    Object localObject;
    o localo;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof ch))
      {
        AppMethodBeat.o(192411);
        return false;
      }
      localo = new o((d)this, paramThrowable, localObject instanceof i);
    } while (!TTD.compareAndSet(this, localObject, localo));
    if ((localObject instanceof i)) {}
    try
    {
      ((i)localObject).y(paramThrowable);
      hMw();
      avT(0);
      AppMethodBeat.o(192411);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        af.b(getContext(), (Throwable)new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
  
  public final void W(kotlin.g.a.b<? super Throwable, kotlin.x> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(192417);
    Object localObject1 = null;
    Object localObject4 = this._state;
    if ((localObject4 instanceof b))
    {
      if (localObject1 != null) {
        break label214;
      }
      if ((paramb instanceof i)) {
        localObject1 = (i)paramb;
      }
    }
    label41:
    label208:
    label214:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (TTD.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(192417);
        return;
        localObject1 = (i)new br(paramb);
        break label41;
        if ((localObject4 instanceof i))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof o)) {
          if (!((o)localObject4).hME()) {
            a(paramb, localObject4);
          }
        }
      }
      for (;;)
      {
        try
        {
          if ((localObject4 instanceof v)) {
            break label208;
          }
          localObject1 = null;
          localObject2 = (v)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((v)localObject2).cause;
          }
          paramb.invoke(localObject1);
          AppMethodBeat.o(192417);
          return;
        }
        catch (Throwable paramb)
        {
          af.b(getContext(), (Throwable)new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(192417);
          return;
        }
        AppMethodBeat.o(192417);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public Throwable a(bu parambu)
  {
    AppMethodBeat.i(192412);
    parambu = (Throwable)parambu.hNj();
    AppMethodBeat.o(192412);
    return parambu;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(192410);
    if ((paramObject instanceof y)) {
      try
      {
        ((y)paramObject).TTO.invoke(paramThrowable);
        AppMethodBeat.o(192410);
        return;
      }
      catch (Throwable paramObject)
      {
        af.b(getContext(), (Throwable)new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(192410);
  }
  
  public final void a(ad paramad, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.SXL;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof av)) {
      localObject1 = null;
    }
    localObject3 = (av)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((av)localObject3).TUm;
    }
    if (localObject1 == paramad) {}
    for (int i = 2;; i = this.TUq)
    {
      s(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void fN(Object paramObject)
  {
    AppMethodBeat.i(192425);
    if (an.hMK())
    {
      if (paramObject == m.TTE) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(192425);
        throw paramObject;
      }
    }
    avT(this.TUq);
    AppMethodBeat.o(192425);
  }
  
  public final <T> T fP(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof x)) {
      localObject = ((x)paramObject).result;
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof y));
    return ((y)paramObject).result;
  }
  
  public e getCallerFrame()
  {
    d locald2 = this.SXL;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public f getContext()
  {
    return this.TTt;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(192415);
    hMs();
    if (hMu())
    {
      localObject1 = a.SXO;
      AppMethodBeat.o(192415);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof v))
    {
      localObject1 = ((v)localObject1).cause;
      localObject2 = (d)this;
      if (!an.hML()) {}
      for (;;)
      {
        AppMethodBeat.o(192415);
        throw ((Throwable)localObject1);
        localObject1 = t.a((Throwable)localObject1, (e)localObject2);
      }
    }
    if (this.TUq == 1)
    {
      localObject2 = (bu)getContext().get((f.c)bu.TUO);
      if ((localObject2 != null) && (!((bu)localObject2).isActive()))
      {
        localObject2 = ((bu)localObject2).hNj();
        a(localObject1, (Throwable)localObject2);
        localObject1 = (d)this;
        if (!an.hML()) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = t.a((Throwable)localObject2, (e)localObject1))
        {
          AppMethodBeat.o(192415);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fP(localObject1);
    AppMethodBeat.o(192415);
    return localObject1;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object hMt()
  {
    return this._state;
  }
  
  final void hMw()
  {
    AppMethodBeat.i(192422);
    if (!hMr()) {
      hMx();
    }
    AppMethodBeat.o(192422);
  }
  
  public final void hMx()
  {
    AppMethodBeat.i(192423);
    bc localbc = (bc)this._parentHandle;
    if (localbc != null) {
      localbc.dispose();
    }
    this._parentHandle = ((bc)cg.TVh);
    AppMethodBeat.o(192423);
  }
  
  protected String hMy()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d<T> hMz()
  {
    return this.SXL;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof ch);
  }
  
  public void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(192416);
    k localk = (k)this;
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      s(paramObject, this.TUq);
      AppMethodBeat.o(192416);
      return;
    }
    paramObject = (d)localk;
    if (!an.hML()) {}
    for (paramObject = localThrowable;; paramObject = t.a(localThrowable, (e)paramObject))
    {
      paramObject = new v(paramObject);
      break;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(192426);
    String str = hMy() + '(' + ao.f(this.SXL) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(192426);
    return str;
  }
  
  public final Object z(Throwable paramThrowable)
  {
    AppMethodBeat.i(192424);
    Object localObject;
    v localv;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof ch)) {
        break;
      }
      localv = new v(paramThrowable);
    } while (!TTD.compareAndSet(this, localObject, localv));
    hMw();
    paramThrowable = m.TTE;
    AppMethodBeat.o(192424);
    return paramThrowable;
    AppMethodBeat.o(192424);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.l
 * JD-Core Version:    0.7.0.1
 */