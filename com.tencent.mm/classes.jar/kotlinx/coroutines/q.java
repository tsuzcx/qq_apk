package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.h;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k=1, mv={1, 5, 1}, xi=48)
public class q<T>
  extends bd<T>
  implements e, p<T>
{
  private final kotlin.d.f aMa;
  final kotlin.d.d<T> aiwg;
  bi ajvq;
  
  static
  {
    AppMethodBeat.i(188854);
    ajvo = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decision");
    ajvp = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");
    AppMethodBeat.o(188854);
  }
  
  public q(kotlin.d.d<? super T> paramd, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(188774);
    this.aiwg = paramd;
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramInt != -1) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        paramd = new AssertionError();
        AppMethodBeat.o(188774);
        throw paramd;
      }
    }
    this.aMa = this.aiwg.getContext();
    this._decision = 0;
    this._state = d.ajvg;
    AppMethodBeat.o(188774);
  }
  
  private static Object a(cp paramcp, Object paramObject1, int paramInt, b<? super Throwable, kotlin.ah> paramb, Object paramObject2)
  {
    int i = 1;
    AppMethodBeat.i(188829);
    if ((paramObject1 instanceof ae))
    {
      if (au.ASSERTIONS_ENABLED)
      {
        if (paramObject2 == null) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          paramcp = new AssertionError();
          AppMethodBeat.o(188829);
          throw paramcp;
        }
      }
      if (au.ASSERTIONS_ENABLED)
      {
        if (paramb == null) {}
        for (paramInt = i; paramInt == 0; paramInt = 0)
        {
          paramcp = new AssertionError();
          AppMethodBeat.o(188829);
          throw paramcp;
        }
      }
      AppMethodBeat.o(188829);
      return paramObject1;
    }
    if (((be.aMD(paramInt)) || (paramObject2 != null)) && ((paramb != null) || (((paramcp instanceof n)) && (!(paramcp instanceof g))) || (paramObject2 != null)))
    {
      if ((paramcp instanceof n)) {}
      for (paramcp = (n)paramcp;; paramcp = null)
      {
        paramcp = new ad(paramObject1, paramcp, paramb, paramObject2, null, 16);
        AppMethodBeat.o(188829);
        return paramcp;
      }
    }
    AppMethodBeat.o(188829);
    return paramObject1;
  }
  
  private final ac a(Object paramObject1, Object paramObject2, b<? super Throwable, kotlin.ah> paramb)
  {
    AppMethodBeat.i(188843);
    Object localObject;
    do
    {
      paramObject2 = this._state;
      if (!(paramObject2 instanceof cp)) {
        break;
      }
      localObject = a((cp)paramObject2, paramObject1, this.ajvU, paramb, null);
    } while (!ajvp.compareAndSet(this, paramObject2, localObject));
    kBH();
    paramObject1 = r.ajvr;
    AppMethodBeat.o(188843);
    return paramObject1;
    if ((paramObject2 instanceof ad))
    {
      AppMethodBeat.o(188843);
      return null;
    }
    AppMethodBeat.o(188843);
    return null;
  }
  
  private final void a(Object paramObject, int paramInt, b<? super Throwable, kotlin.ah> paramb)
  {
    AppMethodBeat.i(188836);
    Object localObject1;
    Object localObject2;
    do
    {
      localObject1 = this._state;
      if (!(localObject1 instanceof cp)) {
        break;
      }
      localObject2 = a((cp)localObject1, paramObject, paramInt, paramb, null);
    } while (!ajvp.compareAndSet(this, localObject1, localObject2));
    kBH();
    aMC(paramInt);
    AppMethodBeat.o(188836);
    return;
    if (((localObject1 instanceof t)) && (((t)localObject1).kBK()))
    {
      if (paramb != null) {
        b(paramb, ((t)localObject1).cause);
      }
      AppMethodBeat.o(188836);
      return;
    }
    iz(paramObject);
    paramObject = new kotlin.f();
    AppMethodBeat.o(188836);
    throw paramObject;
  }
  
  private final void a(b<? super Throwable, kotlin.ah> paramb, Throwable paramThrowable)
  {
    AppMethodBeat.i(188779);
    try
    {
      paramb.invoke(paramThrowable);
      AppMethodBeat.o(188779);
      return;
    }
    finally
    {
      an.b(getContext(), (Throwable)new ah(s.X("Exception in invokeOnCancellation handler for ", this), paramb));
      AppMethodBeat.o(188779);
    }
  }
  
  private void a(n paramn, Throwable paramThrowable)
  {
    AppMethodBeat.i(188785);
    try
    {
      paramn.N(paramThrowable);
      AppMethodBeat.o(188785);
      return;
    }
    finally
    {
      an.b(getContext(), (Throwable)new ah(s.X("Exception in invokeOnCancellation handler for ", this), paramn));
      AppMethodBeat.o(188785);
    }
  }
  
  private final void aMC(int paramInt)
  {
    AppMethodBeat.i(188823);
    if (kBE())
    {
      AppMethodBeat.o(188823);
      return;
    }
    be.a((bd)this, paramInt);
    AppMethodBeat.o(188823);
  }
  
  private void b(b<? super Throwable, kotlin.ah> paramb, Throwable paramThrowable)
  {
    AppMethodBeat.i(188791);
    try
    {
      paramb.invoke(paramThrowable);
      AppMethodBeat.o(188791);
      return;
    }
    finally
    {
      an.b(getContext(), (Throwable)new ah(s.X("Exception in resume onCancellation handler for ", this), paramb));
      AppMethodBeat.o(188791);
    }
  }
  
  private static void h(b<? super Throwable, kotlin.ah> paramb, Object paramObject)
  {
    AppMethodBeat.i(188818);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(188818);
    throw paramb;
  }
  
  private static Void iz(Object paramObject)
  {
    AppMethodBeat.i(188849);
    paramObject = (Throwable)new IllegalStateException(s.X("Already resumed, but proposed with update ", paramObject).toString());
    AppMethodBeat.o(188849);
    throw paramObject;
  }
  
  private final boolean kBD()
  {
    AppMethodBeat.i(188800);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(188800);
        throw localThrowable;
      }
    } while (!ajvo.compareAndSet(this, 0, 1));
    AppMethodBeat.o(188800);
    return true;
    AppMethodBeat.o(188800);
    return false;
  }
  
  private final boolean kBE()
  {
    AppMethodBeat.i(188805);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(188805);
        throw localThrowable;
      }
    } while (!ajvo.compareAndSet(this, 0, 2));
    AppMethodBeat.o(188805);
    return true;
    AppMethodBeat.o(188805);
    return false;
  }
  
  private final bi kBF()
  {
    AppMethodBeat.i(188809);
    Object localObject = (cb)getContext().get((f.c)cb.ajws);
    if (localObject == null)
    {
      AppMethodBeat.o(188809);
      return null;
    }
    localObject = cb.a.a((cb)localObject, true, false, (b)new u(this), 2);
    this.ajvq = ((bi)localObject);
    AppMethodBeat.o(188809);
    return localObject;
  }
  
  private final void kBG()
  {
    AppMethodBeat.i(188814);
    Object localObject = this.aiwg;
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (localObject != null) {
        break label45;
      }
    }
    label45:
    for (localObject = null;; localObject = ((h)localObject).a((p)this))
    {
      if (localObject != null) {
        break label57;
      }
      AppMethodBeat.o(188814);
      return;
      localObject = null;
      break;
    }
    label57:
    kBI();
    P((Throwable)localObject);
    AppMethodBeat.o(188814);
  }
  
  public final Object O(Throwable paramThrowable)
  {
    AppMethodBeat.i(188977);
    paramThrowable = a(new ae(paramThrowable), null, null);
    AppMethodBeat.o(188977);
    return paramThrowable;
  }
  
  public final boolean P(Throwable paramThrowable)
  {
    AppMethodBeat.i(188907);
    t localt;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cp))
      {
        AppMethodBeat.o(188907);
        return false;
      }
      localt = new t((kotlin.d.d)this, paramThrowable, localObject instanceof n);
    } while (!ajvp.compareAndSet(this, localObject, localt));
    if ((localObject instanceof n)) {}
    for (Object localObject = (n)localObject;; localObject = null)
    {
      if (localObject != null) {
        a((n)localObject, paramThrowable);
      }
      kBH();
      aMC(this.ajvU);
      AppMethodBeat.o(188907);
      return true;
    }
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(188901);
    do
    {
      do
      {
        paramObject = this._state;
        if ((paramObject instanceof cp))
        {
          paramObject = (Throwable)new IllegalStateException("Not completed".toString());
          AppMethodBeat.o(188901);
          throw paramObject;
        }
        if ((paramObject instanceof ae))
        {
          AppMethodBeat.o(188901);
          return;
        }
        if (!(paramObject instanceof ad)) {
          break;
        }
        if (!((ad)paramObject).kBU()) {}
        for (int i = 1; i == 0; i = 0)
        {
          paramObject = (Throwable)new IllegalStateException("Must be called at most once".toString());
          AppMethodBeat.o(188901);
          throw paramObject;
        }
        localObject = ad.a((ad)paramObject, null, null, null, null, paramThrowable, 15);
      } while (!ajvp.compareAndSet(this, paramObject, localObject));
      paramObject = (ad)paramObject;
      Object localObject = paramObject.ajvy;
      if (localObject != null) {
        a((n)localObject, paramThrowable);
      }
      paramObject = paramObject.ajvz;
      if (paramObject != null) {
        b(paramObject, paramThrowable);
      }
      AppMethodBeat.o(188901);
      return;
    } while (!ajvp.compareAndSet(this, paramObject, new ad(paramObject, null, null, null, paramThrowable, 14)));
    AppMethodBeat.o(188901);
  }
  
  public final void a(al paramal, T paramT)
  {
    AppMethodBeat.i(118211);
    Object localObject = this.aiwg;
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (localObject != null) {
        break label63;
      }
      localObject = null;
      label35:
      if (localObject != paramal) {
        break label73;
      }
    }
    label63:
    label73:
    for (int i = 4;; i = this.ajvU)
    {
      a(paramT, i, null);
      AppMethodBeat.o(118211);
      return;
      localObject = null;
      break;
      localObject = ((h)localObject).bRx;
      break label35;
    }
  }
  
  public final void bg(b<? super Throwable, kotlin.ah> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(188945);
    Object localObject1;
    if ((paramb instanceof n)) {
      localObject1 = (n)paramb;
    }
    Object localObject3;
    label152:
    label157:
    ad localad;
    do
    {
      do
      {
        for (;;)
        {
          localObject3 = this._state;
          if ((localObject3 instanceof d))
          {
            if (ajvp.compareAndSet(this, localObject3, localObject1))
            {
              AppMethodBeat.o(188945);
              return;
              localObject1 = (n)new by(paramb);
            }
          }
          else
          {
            if (!(localObject3 instanceof n)) {
              break;
            }
            h(paramb, localObject3);
          }
        }
        if ((localObject3 instanceof ae))
        {
          if (!((ae)localObject3).kBV()) {
            h(paramb, localObject3);
          }
          if ((localObject3 instanceof t))
          {
            if (!(localObject3 instanceof ae)) {
              break label152;
            }
            localObject1 = (ae)localObject3;
            if (localObject1 != null) {
              break label157;
            }
          }
          for (localObject1 = localObject2;; localObject1 = ((ae)localObject1).cause)
          {
            a(paramb, (Throwable)localObject1);
            AppMethodBeat.o(188945);
            return;
            localObject1 = null;
            break;
          }
        }
        if (!(localObject3 instanceof ad)) {
          break;
        }
        if (((ad)localObject3).ajvy != null) {
          h(paramb, localObject3);
        }
        if ((localObject1 instanceof g))
        {
          AppMethodBeat.o(188945);
          return;
        }
        if (((ad)localObject3).kBU())
        {
          a(paramb, ((ad)localObject3).ajvB);
          AppMethodBeat.o(188945);
          return;
        }
        localad = ad.a((ad)localObject3, null, (n)localObject1, null, null, null, 29);
      } while (!ajvp.compareAndSet(this, localObject3, localad));
      AppMethodBeat.o(188945);
      return;
      if ((localObject1 instanceof g))
      {
        AppMethodBeat.o(188945);
        return;
      }
      localad = new ad(localObject3, (n)localObject1, null, null, null, 28);
    } while (!ajvp.compareAndSet(this, localObject3, localad));
    AppMethodBeat.o(188945);
  }
  
  public final Object c(T paramT, b<? super Throwable, kotlin.ah> paramb)
  {
    AppMethodBeat.i(188972);
    paramT = a(paramT, null, paramb);
    AppMethodBeat.o(188972);
    return paramT;
  }
  
  public Throwable c(cb paramcb)
  {
    AppMethodBeat.i(188914);
    paramcb = (Throwable)paramcb.kCu();
    AppMethodBeat.o(188914);
    return paramcb;
  }
  
  public final void d(T paramT, b<? super Throwable, kotlin.ah> paramb)
  {
    AppMethodBeat.i(188932);
    a(paramT, this.ajvU, paramb);
    AppMethodBeat.o(188932);
  }
  
  public e getCallerFrame()
  {
    kotlin.d.d locald = this.aiwg;
    if ((locald instanceof e)) {
      return (e)locald;
    }
    return null;
  }
  
  public kotlin.d.f getContext()
  {
    return this.aMa;
  }
  
  public final Object getResult()
  {
    AppMethodBeat.i(188920);
    boolean bool = kBB();
    if (kBD())
    {
      if (this.ajvq == null) {
        kBF();
      }
      if (bool) {
        kBG();
      }
      localObject1 = a.aiwj;
      AppMethodBeat.o(188920);
      return localObject1;
    }
    if (bool) {
      kBG();
    }
    Object localObject1 = this._state;
    if ((localObject1 instanceof ae))
    {
      localObject1 = ((ae)localObject1).cause;
      if ((!au.ajvP) || (!((kotlin.d.d)this instanceof e))) {}
      for (;;)
      {
        AppMethodBeat.o(188920);
        throw ((Throwable)localObject1);
        localObject1 = ab.a((Throwable)localObject1, (e)this);
      }
    }
    if (be.aMD(this.ajvU))
    {
      Object localObject2 = (cb)getContext().get((f.c)cb.ajws);
      if ((localObject2 != null) && (!((cb)localObject2).isActive()))
      {
        localObject2 = ((cb)localObject2).kCu();
        a(localObject1, (Throwable)localObject2);
        if ((!au.ajvP) || (!((kotlin.d.d)this instanceof e))) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = ab.a((Throwable)localObject2, (e)this))
        {
          AppMethodBeat.o(188920);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = iA(localObject1);
    AppMethodBeat.o(188920);
    return localObject1;
  }
  
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final <T> T iA(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof ad)) {
      localObject = ((ad)paramObject).result;
    }
    return localObject;
  }
  
  public final Throwable iB(Object paramObject)
  {
    AppMethodBeat.i(189004);
    paramObject = super.iB(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(189004);
      return null;
    }
    kotlin.d.d locald = this.aiwg;
    if ((!au.ajvP) || (!(locald instanceof e)))
    {
      AppMethodBeat.o(189004);
      return paramObject;
    }
    paramObject = ab.a(paramObject, (e)locald);
    AppMethodBeat.o(189004);
    return paramObject;
  }
  
  public final boolean isActive()
  {
    return this._state instanceof cp;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof cp);
  }
  
  public final Object ix(T paramT)
  {
    AppMethodBeat.i(188966);
    paramT = a(paramT, null, null);
    AppMethodBeat.o(188966);
    return paramT;
  }
  
  public final void iy(Object paramObject)
  {
    AppMethodBeat.i(188986);
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramObject == r.ajvr) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = new AssertionError();
        AppMethodBeat.o(188986);
        throw paramObject;
      }
    }
    aMC(this.ajvU);
    AppMethodBeat.o(188986);
  }
  
  public final void kBA()
  {
    AppMethodBeat.i(118210);
    bi localbi = kBF();
    if (localbi == null)
    {
      AppMethodBeat.o(118210);
      return;
    }
    if (isCompleted())
    {
      localbi.dispose();
      this.ajvq = ((bi)co.ajwK);
    }
    AppMethodBeat.o(118210);
  }
  
  final boolean kBB()
  {
    if (this.ajvU == 2)
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
      if (((h)this.aiwg)._reusableCancellableContinuation == null) {
        break label40;
      }
    }
    label40:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label45;
      }
      return true;
      i = 0;
      break;
    }
    label45:
    return false;
  }
  
  public final Object kBC()
  {
    return this._state;
  }
  
  final void kBH()
  {
    AppMethodBeat.i(188949);
    if (!kBB()) {
      kBI();
    }
    AppMethodBeat.o(188949);
  }
  
  public final void kBI()
  {
    AppMethodBeat.i(188958);
    bi localbi = this.ajvq;
    if (localbi == null)
    {
      AppMethodBeat.o(188958);
      return;
    }
    localbi.dispose();
    this.ajvq = ((bi)co.ajwK);
    AppMethodBeat.o(188958);
  }
  
  protected String kBJ()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final kotlin.d.d<T> kBz()
  {
    return this.aiwg;
  }
  
  public void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(188928);
    p localp = (p)this;
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      a(paramObject, this.ajvU, null);
      AppMethodBeat.o(188928);
      return;
    }
    if (!au.ajvP) {}
    for (paramObject = localThrowable;; paramObject = ab.a(localThrowable, (e)localp))
    {
      paramObject = new ae(paramObject);
      break;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(189012);
    StringBuilder localStringBuilder = new StringBuilder().append(kBJ()).append('(').append(av.aw(this.aiwg)).append("){");
    Object localObject = this._state;
    if ((localObject instanceof cp)) {
      localObject = "Active";
    }
    for (;;)
    {
      localObject = (String)localObject + "}@" + Integer.toHexString(System.identityHashCode(this));
      AppMethodBeat.o(189012);
      return localObject;
      if ((localObject instanceof t)) {
        localObject = "Cancelled";
      } else {
        localObject = "Completed";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.q
 * JD-Core Version:    0.7.0.1
 */