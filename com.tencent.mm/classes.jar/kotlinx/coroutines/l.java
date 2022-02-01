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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class l<T>
  extends ax<T>
  implements e, k<T>
{
  private static final AtomicIntegerFieldUpdater OeI;
  private static final AtomicReferenceFieldUpdater OeJ;
  final d<T> Nic;
  private final f Oez;
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(209285);
    OeI = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");
    OeJ = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    AppMethodBeat.o(209285);
  }
  
  public l(d<? super T> paramd)
  {
    super(1);
    AppMethodBeat.i(118213);
    this.Nic = paramd;
    this.Oez = this.Nic.gkg();
    this._decision = 0;
    this._state = b.OeB;
    this._parentHandle = null;
    AppMethodBeat.o(118213);
  }
  
  private static void a(d.g.a.b<? super Throwable, d.z> paramb, Object paramObject)
  {
    AppMethodBeat.i(209276);
    paramb = (Throwable)new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + paramb + ", already has " + paramObject).toString());
    AppMethodBeat.o(209276);
    throw paramb;
  }
  
  private final void amk(int paramInt)
  {
    AppMethodBeat.i(209277);
    if (gzr())
    {
      AppMethodBeat.o(209277);
      return;
    }
    ay.a(this, paramInt);
    AppMethodBeat.o(209277);
  }
  
  private static void fK(Object paramObject)
  {
    AppMethodBeat.i(209279);
    paramObject = (Throwable)new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(paramObject)).toString());
    AppMethodBeat.o(209279);
    throw paramObject;
  }
  
  private final boolean gzn()
  {
    if ((this.Nic instanceof au))
    {
      if (((au)this.Nic)._reusableCancellableContinuation != null) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private final void gzo()
  {
    Object localObject2 = null;
    AppMethodBeat.i(209267);
    boolean bool = isCompleted();
    if (this.Ofv != 0) {}
    while (bool)
    {
      AppMethodBeat.o(209267);
      return;
      Object localObject3 = this.Nic;
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
          if (localObject4 != av.Ofu) {
            break;
          }
        } while (!au.Ofq.compareAndSet(localObject3, av.Ofu, localObject1));
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
                if (!au.Ofq.compareAndSet(localObject3, localObject4, null))
                {
                  localObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                  AppMethodBeat.o(209267);
                  throw ((Throwable)localObject1);
                }
                localObject1 = (Throwable)localObject4;
              }
              else
              {
                localObject1 = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject4)).toString());
                AppMethodBeat.o(209267);
                throw ((Throwable)localObject1);
              }
            }
          }
        }
        if (!bool) {
          z((Throwable)localObject1);
        }
        bool = true;
      }
    }
    if ((ba)this._parentHandle != null)
    {
      AppMethodBeat.o(209267);
      return;
    }
    Object localObject1 = (br)this.Nic.gkg().get((f.c)br.OfS);
    if (localObject1 == null)
    {
      AppMethodBeat.o(209267);
      return;
    }
    ((br)localObject1).start();
    localObject1 = br.a.a((br)localObject1, true, false, (d.g.a.b)new p((br)localObject1, this), 2);
    this._parentHandle = localObject1;
    if ((isCompleted()) && (!gzn()))
    {
      ((ba)localObject1).dispose();
      this._parentHandle = ((ba)cb.Ogk);
    }
    AppMethodBeat.o(209267);
  }
  
  private final boolean gzq()
  {
    AppMethodBeat.i(209271);
    do
    {
      switch (this._decision)
      {
      case 1: 
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already suspended".toString());
        AppMethodBeat.o(209271);
        throw localThrowable;
      }
    } while (!OeI.compareAndSet(this, 0, 1));
    AppMethodBeat.o(209271);
    return true;
    AppMethodBeat.o(209271);
    return false;
  }
  
  private final boolean gzr()
  {
    AppMethodBeat.i(209272);
    do
    {
      switch (this._decision)
      {
      default: 
        Throwable localThrowable = (Throwable)new IllegalStateException("Already resumed".toString());
        AppMethodBeat.o(209272);
        throw localThrowable;
      }
    } while (!OeI.compareAndSet(this, 0, 2));
    AppMethodBeat.o(209272);
    return true;
    AppMethodBeat.o(209272);
    return false;
  }
  
  private final o q(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(209278);
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof cc))
      {
        if (OeJ.compareAndSet(this, localObject, paramObject))
        {
          gzs();
          amk(paramInt);
          AppMethodBeat.o(209278);
          return null;
        }
      }
      else
      {
        if (((localObject instanceof o)) && (((o)localObject).gzw()))
        {
          paramObject = (o)localObject;
          AppMethodBeat.o(209278);
          return paramObject;
        }
        fK(paramObject);
      }
    }
  }
  
  public final void N(d.g.a.b<? super Throwable, d.z> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(209275);
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
      if (OeJ.compareAndSet(this, localObject4, localObject2))
      {
        AppMethodBeat.o(209275);
        return;
        localObject1 = (i)new bo(paramb);
        break label41;
        if ((localObject4 instanceof i))
        {
          a(paramb, localObject4);
          break;
        }
        if ((localObject4 instanceof o)) {
          if (!((o)localObject4).gzA()) {
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
          AppMethodBeat.o(209275);
          return;
        }
        catch (Throwable paramb)
        {
          ae.b(this.Oez, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramb));
          AppMethodBeat.o(209275);
          return;
        }
        AppMethodBeat.o(209275);
        return;
        break;
        localObject1 = localObject4;
      }
    }
  }
  
  public Throwable a(br parambr)
  {
    AppMethodBeat.i(209270);
    parambr = (Throwable)parambr.gAe();
    AppMethodBeat.o(209270);
    return parambr;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(209268);
    if ((paramObject instanceof x)) {
      try
      {
        ((x)paramObject).OeU.invoke(paramThrowable);
        AppMethodBeat.o(209268);
        return;
      }
      catch (Throwable paramObject)
      {
        ae.b(this.Oez, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramObject));
      }
    }
    AppMethodBeat.o(209268);
  }
  
  public final void a(ac paramac, T paramT)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118211);
    Object localObject3 = this.Nic;
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof au)) {
      localObject1 = null;
    }
    localObject3 = (au)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((au)localObject3).Ofr;
    }
    if (localObject1 == paramac) {}
    for (int i = 2;; i = this.Ofv)
    {
      q(paramT, i);
      AppMethodBeat.o(118211);
      return;
    }
  }
  
  public final void eQ(Object paramObject)
  {
    AppMethodBeat.i(209274);
    k localk = (k)this;
    Throwable localThrowable = d.p.eN(paramObject);
    if (localThrowable == null)
    {
      q(paramObject, this.Ofv);
      AppMethodBeat.o(209274);
      return;
    }
    paramObject = (d)localk;
    if (!am.gzG()) {}
    for (paramObject = localThrowable;; paramObject = s.a(localThrowable, (e)paramObject))
    {
      paramObject = new u(paramObject);
      break;
    }
  }
  
  public final void fJ(Object paramObject)
  {
    AppMethodBeat.i(209283);
    if (am.gzF())
    {
      if (paramObject == m.OeK) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramObject = (Throwable)new AssertionError();
        AppMethodBeat.o(209283);
        throw paramObject;
      }
    }
    amk(this.Ofv);
    AppMethodBeat.o(209283);
  }
  
  public final <T> T fL(Object paramObject)
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
    AppMethodBeat.i(209273);
    gzo();
    if (gzq())
    {
      localObject1 = a.Nif;
      AppMethodBeat.o(209273);
      return localObject1;
    }
    Object localObject1 = this._state;
    Object localObject2;
    if ((localObject1 instanceof u))
    {
      localObject1 = ((u)localObject1).cause;
      localObject2 = (d)this;
      if (!am.gzG()) {}
      for (;;)
      {
        AppMethodBeat.o(209273);
        throw ((Throwable)localObject1);
        localObject1 = s.a((Throwable)localObject1, (e)localObject2);
      }
    }
    if (this.Ofv == 1)
    {
      localObject2 = (br)this.Oez.get((f.c)br.OfS);
      if ((localObject2 != null) && (!((br)localObject2).isActive()))
      {
        localObject2 = ((br)localObject2).gAe();
        a(localObject1, (Throwable)localObject2);
        localObject1 = (d)this;
        if (!am.gzG()) {}
        for (localObject1 = (Throwable)localObject2;; localObject1 = s.a((Throwable)localObject2, (e)localObject1))
        {
          AppMethodBeat.o(209273);
          throw ((Throwable)localObject1);
        }
      }
    }
    localObject1 = fL(localObject1);
    AppMethodBeat.o(209273);
    return localObject1;
  }
  
  public final f gkg()
  {
    return this.Oez;
  }
  
  public final e gki()
  {
    d locald2 = this.Nic;
    d locald1 = locald2;
    if (!(locald2 instanceof e)) {
      locald1 = null;
    }
    return (e)locald1;
  }
  
  public final StackTraceElement gkj()
  {
    return null;
  }
  
  public final Object gzp()
  {
    return this._state;
  }
  
  final void gzs()
  {
    AppMethodBeat.i(209280);
    if (!gzn()) {
      gzt();
    }
    AppMethodBeat.o(209280);
  }
  
  public final void gzt()
  {
    AppMethodBeat.i(209281);
    ba localba = (ba)this._parentHandle;
    if (localba != null) {
      localba.dispose();
    }
    this._parentHandle = ((ba)cb.Ogk);
    AppMethodBeat.o(209281);
  }
  
  protected String gzu()
  {
    AppMethodBeat.i(118212);
    AppMethodBeat.o(118212);
    return "CancellableContinuation";
  }
  
  public final d<T> gzv()
  {
    return this.Nic;
  }
  
  public final boolean isCompleted()
  {
    return !(this._state instanceof cc);
  }
  
  public String toString()
  {
    AppMethodBeat.i(209284);
    String str = gzu() + '(' + an.e(this.Nic) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(209284);
    return str;
  }
  
  public final Object y(Throwable paramThrowable)
  {
    AppMethodBeat.i(209282);
    Object localObject;
    u localu;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cc)) {
        break;
      }
      localu = new u(paramThrowable);
    } while (!OeJ.compareAndSet(this, localObject, localu));
    gzs();
    paramThrowable = m.OeK;
    AppMethodBeat.o(209282);
    return paramThrowable;
    AppMethodBeat.o(209282);
    return null;
  }
  
  public final boolean z(Throwable paramThrowable)
  {
    AppMethodBeat.i(209269);
    Object localObject;
    o localo;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof cc))
      {
        AppMethodBeat.o(209269);
        return false;
      }
      localo = new o((d)this, paramThrowable, localObject instanceof i);
    } while (!OeJ.compareAndSet(this, localObject, localo));
    if ((localObject instanceof i)) {}
    try
    {
      ((i)localObject).x(paramThrowable);
      gzs();
      amk(0);
      AppMethodBeat.o(209269);
      return true;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        ae.b(this.Oez, (Throwable)new z("Exception in cancellation handler for ".concat(String.valueOf(this)), paramThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.l
 * JD-Core Version:    0.7.0.1
 */