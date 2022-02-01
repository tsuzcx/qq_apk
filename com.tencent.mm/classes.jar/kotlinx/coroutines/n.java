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
import kotlin.l;
import kotlinx.coroutines.internal.u;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class n<T>
  extends ba<T>
  implements e, m<T>
{
  private static final AtomicIntegerFieldUpdater abwh;
  private static final AtomicReferenceFieldUpdater abwi;
  volatile int _decision;
  volatile Object _parentHandle;
  volatile Object _state;
  final d<T> aaAx;
  private final f abvW;
  
  static
  {
    AppMethodBeat.i(204205);
    abwh = AtomicIntegerFieldUpdater.newUpdater(n.class, "_decision");
    abwi = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
    AppMethodBeat.o(204205);
  }
  
  public n(d<? super T> paramd, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(204204);
    this.aaAx = paramd;
    this.abvW = this.aaAx.getContext();
    this._decision = 0;
    this._state = b.abvY;
    this._parentHandle = null;
    AppMethodBeat.o(204204);
  }
  
  private static void a(kotlin.g.a.b<? super Throwable, kotlin.x> paramb, Object paramObject)
  {
    AppMethodBeat.i(204194);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(204194);
    throw paramb;
  }
  
  private final void aFN(int paramInt)
  {
    AppMethodBeat.i(204195);
    if (iQQ())
    {
      AppMethodBeat.o(204195);
      return;
    }
    bb.a(this, paramInt);
    AppMethodBeat.o(204195);
  }
  
  private static void fY(Object paramObject)
  {
    AppMethodBeat.i(204197);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(204197);
    throw paramObject;
  }
  
  private final boolean iQL()
  {
    if ((this.aaAx instanceof ax))
    {
      Object localObject = ((ax)this.aaAx)._reusableCancellableContinuation;
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (i != 0)
      {
        return true;
        if (((localObject instanceof n)) && (localObject != this)) {
          i = 0;
        } else {
          i = 1;
        }
      }
    }
    return false;
  }
  
  private final boolean iQN()
  {
    AppMethodBeat.i(204184);
    boolean bool = isCompleted();
    if (this.abwT != 0)
    {
      AppMethodBeat.o(204184);
      return bool;
    }
    d locald = this.aaAx;
    Object localObject = locald;
    if (!(locald instanceof ax)) {
      localObject = null;
    }
    localObject = (ax)localObject;
    if (localObject == null)
    {
      AppMethodBeat.o(204184);
      return bool;
    }
    localObject = ((ax)localObject).a((m)this);
    if (localObject == null)
    {
      AppMethodBeat.o(204184);
      return bool;
    }
    if (!bool) {
      A((Throwable)localObject);
    }
    AppMethodBeat.o(204184);
    return true;
  }
  
  private final boolean iQP()
  {
    AppMethodBeat.i(204189);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(204189);
        throw localThrowable;
      }
    } while (!abwh.compareAndSet(this, 0, 1));
    AppMethodBeat.o(204189);
    return true;
    AppMethodBeat.o(204189);
    return false;
  }
  
  private final boolean iQQ()
  {
    AppMethodBeat.i(204190);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(204190);
        throw localThrowable;
      }
    } while (!abwh.compareAndSet(this, 0, 2));
    AppMethodBeat.o(204190);
    return true;
    AppMethodBeat.o(204190);
    return false;
  }
  
  private final q y(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(204196);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof cl))
      {
        if (abwi.compareAndSet(this, localObject, paramObject))
        {
          iQR();
          aFN(paramInt);
          AppMethodBeat.o(204196);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof q)) && (((q)localObject).iQV()))
        {
          paramObject = (q)localObject;
          AppMethodBeat.o(204196);
          return paramObject;
        }
        fY(paramObject);
      }
    }
  }
  
  public final boolean A(Throwable paramThrowable)
  {
    AppMethodBeat.i(204186);
    Object localObject;
    q localq;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cl))
      {
        AppMethodBeat.o(204186);
        return false;
      }
      localq = new q((d)this, paramThrowable, localObject instanceof k);
    } while (!abwi.compareAndSet(this, localObject, localq));
    if ((localObject instanceof k)) {}
    try
    {
      ((k)localObject).y(paramThrowable);
      iQR();
      aFN(0);
      AppMethodBeat.o(204186);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        ah.b(getContext(), (Throwable)new ac("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
  
  public Throwable a(by paramby)
  {
    AppMethodBeat.i(204187);
    paramby = (Throwable)paramby.iRF();
    AppMethodBeat.o(204187);
    return paramby;
  }
  
  public final void a(af paramaf, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.aaAx;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof ax)) {
      localObject1 = null;
    }
    localObject3 = (ax)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((ax)localObject3).abwP;
    }
    if (localObject1 == paramaf) {}
    for (int i = 2;; i = this.abwT)
    {
      y(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void am(kotlin.g.a.b<? super Throwable, kotlin.x> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(204193);
    Object localObject1 = null;
    Object localObject4 = this._state;
    if ((localObject4 instanceof b))
    {
      if (localObject1 != null) {
        break label214;
      }
      if ((paramb instanceof k)) {
        localObject1 = (k)paramb;
      }
    }
    label41:
    label208:
    label214:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (abwi.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(204193);
        return;
        localObject1 = (k)new bv(paramb);
        break label41;
        if ((localObject4 instanceof k))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof q)) {
          if (!((q)localObject4).iRa()) {
            a(paramb, localObject4);
          }
        }
      }
      for (;;)
      {
        try
        {
          if ((localObject4 instanceof x)) {
            break label208;
          }
          localObject1 = null;
          localObject2 = (x)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((x)localObject2).cause;
          }
          paramb.invoke(localObject1);
          AppMethodBeat.o(204193);
          return;
        }
        catch (Throwable paramb)
        {
          ah.b(getContext(), (Throwable)new ac("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(204193);
          return;
        }
        AppMethodBeat.o(204193);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public final Object fV(T paramT)
  {
    AppMethodBeat.i(204200);
    Object localObject;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cl)) {
        break;
      }
    } while (!abwi.compareAndSet(this, localObject, paramT));
    iQR();
    paramT = o.abwj;
    AppMethodBeat.o(204200);
    return paramT;
    if ((localObject instanceof z))
    {
      paramT = (z)localObject;
      AppMethodBeat.o(204200);
      throw null;
    }
    AppMethodBeat.o(204200);
    return null;
  }
  
  public final void fW(Object paramObject)
  {
    AppMethodBeat.i(204202);
    if (ap.iRg())
    {
      if (paramObject == o.abwj) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(204202);
        throw paramObject;
      }
    }
    aFN(this.abwT);
    AppMethodBeat.o(204202);
  }
  
  public final void fX(Object paramObject)
  {
    AppMethodBeat.i(204185);
    if ((paramObject instanceof aa)) {
      try
      {
        AppMethodBeat.o(204185);
        throw null;
      }
      catch (Throwable paramObject)
      {
        ah.b(getContext(), (Throwable)new ac("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(204185);
  }
  
  public final <T> T fZ(Object paramObject)
  {
    if ((paramObject instanceof z))
    {
      paramObject = (z)paramObject;
      throw null;
    }
    if ((paramObject instanceof aa)) {
      throw null;
    }
    return paramObject;
  }
  
  public e getCallerFrame()
  {
    d locald2 = this.aaAx;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public f getContext()
  {
    return this.abvW;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(204191);
    iQM();
    if (iQP())
    {
      localObject1 = a.aaAA;
      AppMethodBeat.o(204191);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof x))
    {
      localObject2 = ((x)localObject1).cause;
      d locald = (d)this;
      localObject1 = localObject2;
      if (ap.iRh()) {
        if ((locald instanceof e)) {
          break label79;
        }
      }
      label79:
      for (localObject1 = localObject2;; localObject1 = u.a((Throwable)localObject2, (e)locald))
      {
        AppMethodBeat.o(204191);
        throw ((Throwable)localObject1);
      }
    }
    if (this.abwT == 1)
    {
      localObject2 = (by)getContext().get((f.c)by.abxs);
      if ((localObject2 != null) && (!((by)localObject2).isActive()))
      {
        localObject2 = ((by)localObject2).iRF();
        fX(localObject1);
        localObject1 = (d)this;
        if ((!ap.iRh()) || (!(localObject1 instanceof e))) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = u.a((Throwable)localObject2, (e)localObject1))
        {
          AppMethodBeat.o(204191);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fZ(localObject1);
    AppMethodBeat.o(204191);
    return localObject1;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final void iQM()
  {
    AppMethodBeat.i(204183);
    if (iQN())
    {
      AppMethodBeat.o(204183);
      return;
    }
    if ((be)this._parentHandle != null)
    {
      AppMethodBeat.o(204183);
      return;
    }
    Object localObject = (by)this.aaAx.getContext().get((f.c)by.abxs);
    if (localObject == null)
    {
      AppMethodBeat.o(204183);
      return;
    }
    ((by)localObject).start();
    localObject = by.a.a((by)localObject, true, false, (kotlin.g.a.b)new r((by)localObject, this), 2);
    this._parentHandle = localObject;
    if ((isCompleted()) && (!iQL()))
    {
      ((be)localObject).dispose();
      this._parentHandle = ((be)ck.abxK);
    }
    AppMethodBeat.o(204183);
  }
  
  public final Object iQO()
  {
    return this._state;
  }
  
  final void iQR()
  {
    AppMethodBeat.i(204198);
    if (!iQL()) {
      iQS();
    }
    AppMethodBeat.o(204198);
  }
  
  public final void iQS()
  {
    AppMethodBeat.i(204199);
    be localbe = (be)this._parentHandle;
    if (localbe != null) {
      localbe.dispose();
    }
    this._parentHandle = ((be)ck.abxK);
    AppMethodBeat.o(204199);
  }
  
  protected String iQT()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d<T> iQU()
  {
    return this.aaAx;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof cl);
  }
  
  public void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(204192);
    m localm = (m)this;
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      y(paramObject, this.abwT);
      AppMethodBeat.o(204192);
      return;
    }
    paramObject = (d)localm;
    if (!ap.iRh()) {}
    for (paramObject = localThrowable;; paramObject = u.a(localThrowable, (e)paramObject))
    {
      paramObject = new x(paramObject);
      break;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(204203);
    String str = iQT() + '(' + aq.m(this.aaAx) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(204203);
    return str;
  }
  
  public final Object z(Throwable paramThrowable)
  {
    AppMethodBeat.i(204201);
    Object localObject;
    x localx;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cl)) {
        break;
      }
      localx = new x(paramThrowable);
    } while (!abwi.compareAndSet(this, localObject, localx));
    iQR();
    paramThrowable = o.abwj;
    AppMethodBeat.o(204201);
    return paramThrowable;
    AppMethodBeat.o(204201);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.n
 * JD-Core Version:    0.7.0.1
 */