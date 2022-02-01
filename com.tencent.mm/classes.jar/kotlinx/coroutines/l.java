package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.d.f.c;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.s;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class l<T>
  extends ax<T>
  implements e, k<T>
{
  private static final AtomicIntegerFieldUpdater NHC;
  private static final AtomicReferenceFieldUpdater NHD;
  final d<T> MKZ;
  private final f NHt;
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(190794);
    NHC = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");
    NHD = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    AppMethodBeat.o(190794);
  }
  
  public l(d<? super T> paramd)
  {
    super(1);
    AppMethodBeat.i(118213);
    this.MKZ = paramd;
    this.NHt = this.MKZ.gfE();
    this._decision = 0;
    this._state = b.NHv;
    this._parentHandle = null;
    AppMethodBeat.o(118213);
  }
  
  private static void a(d.g.a.b<? super Throwable, d.z> paramb, Object paramObject)
  {
    AppMethodBeat.i(190785);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(190785);
    throw paramb;
  }
  
  private final void alA(int paramInt)
  {
    AppMethodBeat.i(190786);
    if (guP())
    {
      AppMethodBeat.o(190786);
      return;
    }
    ay.a(this, paramInt);
    AppMethodBeat.o(190786);
  }
  
  private static void fH(Object paramObject)
  {
    AppMethodBeat.i(190788);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(190788);
    throw paramObject;
  }
  
  private final boolean guL()
  {
    if ((this.MKZ instanceof au))
    {
      if (((au)this.MKZ)._reusableCancellableContinuation != null) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private final void guM()
  {
    Object localObject2 = null;
    AppMethodBeat.i(190776);
    boolean bool = isCompleted();
    if (this.NIp != 0) {}
    while (bool)
    {
      AppMethodBeat.o(190776);
      return;
      Object localObject3 = this.MKZ;
      localObject1 = localObject3;
      if (!(localObject3 instanceof au)) {
        localObject1 = null;
      }
      localObject3 = (au)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (k)this;
        Object localObject4;
        do
        {
          localObject4 = ((au)localObject3)._reusableCancellableContinuation;
          if (localObject4 != av.NIo) {
            break;
          }
        } while (!au.NIk.compareAndSet(localObject3, av.NIo, localObject1));
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
                if (!au.NIk.compareAndSet(localObject3, localObject4, null))
                {
                  localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                  AppMethodBeat.o(190776);
                  throw ((Throwable)localObject1);
                }
                localObject1 = (Throwable)localObject4;
              }
              else
              {
                localObject1 = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject4)).toString());
                AppMethodBeat.o(190776);
                throw ((Throwable)localObject1);
              }
            }
          }
        }
        if (!bool) {
          y((Throwable)localObject1);
        }
        bool = true;
      }
    }
    if ((ba)this._parentHandle != null)
    {
      AppMethodBeat.o(190776);
      return;
    }
    Object localObject1 = (br)this.MKZ.gfE().get((f.c)br.NIM);
    if (localObject1 == null)
    {
      AppMethodBeat.o(190776);
      return;
    }
    ((br)localObject1).start();
    localObject1 = br.a.a((br)localObject1, true, false, (d.g.a.b)new p((br)localObject1, this), 2);
    this._parentHandle = localObject1;
    if ((isCompleted()) && (!guL()))
    {
      ((ba)localObject1).dispose();
      this._parentHandle = ((ba)cb.NJe);
    }
    AppMethodBeat.o(190776);
  }
  
  private final boolean guO()
  {
    AppMethodBeat.i(190780);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(190780);
        throw localThrowable;
      }
    } while (!NHC.compareAndSet(this, 0, 1));
    AppMethodBeat.o(190780);
    return true;
    AppMethodBeat.o(190780);
    return false;
  }
  
  private final boolean guP()
  {
    AppMethodBeat.i(190781);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(190781);
        throw localThrowable;
      }
    } while (!NHC.compareAndSet(this, 0, 2));
    AppMethodBeat.o(190781);
    return true;
    AppMethodBeat.o(190781);
    return false;
  }
  
  private final o q(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(190787);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof cc))
      {
        if (NHD.compareAndSet(this, localObject, paramObject))
        {
          guQ();
          alA(paramInt);
          AppMethodBeat.o(190787);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof o)) && (((o)localObject).guU()))
        {
          paramObject = (o)localObject;
          AppMethodBeat.o(190787);
          return paramObject;
        }
        fH(paramObject);
      }
    }
  }
  
  public final void K(d.g.a.b<? super Throwable, d.z> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(190784);
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
      if (NHD.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(190784);
        return;
        localObject1 = (i)new bo(paramb);
        break label41;
        if ((localObject4 instanceof i))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof o)) {
          if (!((o)localObject4).guY()) {
            a(paramb, localObject4);
          }
        }
      }
      for (;;)
      {
        try
        {
          if ((localObject4 instanceof u)) {
            break label208;
          }
          localObject1 = null;
          localObject2 = (u)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((u)localObject2).cause;
          }
          paramb.invoke(localObject1);
          AppMethodBeat.o(190784);
          return;
        }
        catch (Throwable paramb)
        {
          ae.b(this.NHt, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(190784);
          return;
        }
        AppMethodBeat.o(190784);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public Throwable a(br parambr)
  {
    AppMethodBeat.i(190779);
    parambr = (Throwable)parambr.gvC();
    AppMethodBeat.o(190779);
    return parambr;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(190777);
    if ((paramObject instanceof x)) {
      try
      {
        ((x)paramObject).NHO.invoke(paramThrowable);
        AppMethodBeat.o(190777);
        return;
      }
      catch (Throwable paramObject)
      {
        ae.b(this.NHt, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(190777);
  }
  
  public final void a(ac paramac, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.MKZ;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof au)) {
      localObject1 = null;
    }
    localObject3 = (au)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((au)localObject3).NIl;
    }
    if (localObject1 == paramac) {}
    for (int i = 2;; i = this.NIp)
    {
      q(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void eN(Object paramObject)
  {
    AppMethodBeat.i(190783);
    k localk = (k)this;
    Throwable localThrowable = d.p.eK(paramObject);
    if (localThrowable == null)
    {
      q(paramObject, this.NIp);
      AppMethodBeat.o(190783);
      return;
    }
    paramObject = (d)localk;
    if (!am.gve()) {}
    for (paramObject = localThrowable;; paramObject = s.a(localThrowable, (e)paramObject))
    {
      paramObject = new u(paramObject);
      break;
    }
  }
  
  public final void fG(Object paramObject)
  {
    AppMethodBeat.i(190792);
    if (am.gvd())
    {
      if (paramObject == m.NHE) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(190792);
        throw paramObject;
      }
    }
    alA(this.NIp);
    AppMethodBeat.o(190792);
  }
  
  public final <T> T fI(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof w)) {
      localObject = ((w)paramObject).result;
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof x));
    return ((x)paramObject).result;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(190782);
    guM();
    if (guO())
    {
      localObject1 = a.MLc;
      AppMethodBeat.o(190782);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof u))
    {
      localObject1 = ((u)localObject1).cause;
      localObject2 = (d)this;
      if (!am.gve()) {}
      for (;;)
      {
        AppMethodBeat.o(190782);
        throw ((Throwable)localObject1);
        localObject1 = s.a((Throwable)localObject1, (e)localObject2);
      }
    }
    if (this.NIp == 1)
    {
      localObject2 = (br)this.NHt.get((f.c)br.NIM);
      if ((localObject2 != null) && (!((br)localObject2).isActive()))
      {
        localObject2 = ((br)localObject2).gvC();
        a(localObject1, (Throwable)localObject2);
        localObject1 = (d)this;
        if (!am.gve()) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = s.a((Throwable)localObject2, (e)localObject1))
        {
          AppMethodBeat.o(190782);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fI(localObject1);
    AppMethodBeat.o(190782);
    return localObject1;
  }
  
  public final f gfE()
  {
    return this.NHt;
  }
  
  public final e gfG()
  {
    d locald2 = this.MKZ;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement gfH()
  {
    return null;
  }
  
  public final Object guN()
  {
    return this._state;
  }
  
  final void guQ()
  {
    AppMethodBeat.i(190789);
    if (!guL()) {
      guR();
    }
    AppMethodBeat.o(190789);
  }
  
  public final void guR()
  {
    AppMethodBeat.i(190790);
    ba localba = (ba)this._parentHandle;
    if (localba != null) {
      localba.dispose();
    }
    this._parentHandle = ((ba)cb.NJe);
    AppMethodBeat.o(190790);
  }
  
  protected String guS()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d<T> guT()
  {
    return this.MKZ;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof cc);
  }
  
  public String toString()
  {
    AppMethodBeat.i(190793);
    String str = guS() + '(' + an.e(this.MKZ) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(190793);
    return str;
  }
  
  public final Object x(Throwable paramThrowable)
  {
    AppMethodBeat.i(190791);
    Object localObject;
    u localu;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cc)) {
        break;
      }
      localu = new u(paramThrowable);
    } while (!NHD.compareAndSet(this, localObject, localu));
    guQ();
    paramThrowable = m.NHE;
    AppMethodBeat.o(190791);
    return paramThrowable;
    AppMethodBeat.o(190791);
    return null;
  }
  
  public final boolean y(Throwable paramThrowable)
  {
    AppMethodBeat.i(190778);
    Object localObject;
    o localo;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cc))
      {
        AppMethodBeat.o(190778);
        return false;
      }
      localo = new o((d)this, paramThrowable, localObject instanceof i);
    } while (!NHD.compareAndSet(this, localObject, localo));
    if ((localObject instanceof i)) {}
    try
    {
      ((i)localObject).v(paramThrowable);
      guQ();
      alA(0);
      AppMethodBeat.o(190778);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        ae.b(this.NHt, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.l
 * JD-Core Version:    0.7.0.1
 */