package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a;
import d.d.d;
import d.d.f.b;
import d.d.f.b.a;
import d.d.f.c;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.e;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.g.a;
import kotlinx.coroutines.a.j;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class bn
  implements bj, bv, o
{
  static final AtomicReferenceFieldUpdater Kdh;
  volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(118317);
    Kdh = AtomicReferenceFieldUpdater.newUpdater(bn.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public bn(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (aw localaw = bo.fLB();; localaw = bo.fLF())
    {
      this._state = localaw;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final Object T(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190003);
    if (!(paramObject1 instanceof be))
    {
      paramObject1 = bo.fLC();
      AppMethodBeat.o(190003);
      return paramObject1;
    }
    if ((((paramObject1 instanceof aw)) || ((paramObject1 instanceof bm))) && (!(paramObject1 instanceof n)) && (!(paramObject2 instanceof q)))
    {
      if (a((be)paramObject1, paramObject2))
      {
        AppMethodBeat.o(190003);
        return paramObject2;
      }
      paramObject1 = bo.fLE();
      AppMethodBeat.o(190003);
      return paramObject1;
    }
    paramObject1 = c((be)paramObject1, paramObject2);
    AppMethodBeat.o(190003);
    return paramObject1;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(189995);
    int i;
    if (ah.fKW())
    {
      if (fLv() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(189995);
        throw paramc;
      }
    }
    if (ah.fKW())
    {
      if (!paramc.isSealed()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(189995);
        throw paramc;
      }
    }
    if ((ah.fKW()) && (paramc._isCompleting == 0))
    {
      paramc = (Throwable)new AssertionError();
      AppMethodBeat.o(189995);
      throw paramc;
    }
    if (!(paramObject instanceof q)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (q)localObject1;
      Throwable localThrowable;
      if (localObject1 != null) {
        localThrowable = ((q)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = paramc._exceptionsHolder;
          if (localObject2 == null)
          {
            localObject1 = c.fLy();
            localObject2 = (Throwable)paramc._rootCause;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((k.g(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramc._exceptionsHolder = bo.fLA();
            localObject2 = (List)localObject1;
            localObject1 = a(paramc, (List)localObject2);
            if (localObject1 != null) {
              b((Throwable)localObject1, (List)localObject2);
            }
            if (localObject1 != null) {
              break label405;
            }
            if (localObject1 == null) {
              break label441;
            }
            if ((!y((Throwable)localObject1)) && (!z((Throwable)localObject1))) {
              break label428;
            }
            i = 1;
            if (i == 0) {
              break label441;
            }
            if (paramObject != null) {
              break label433;
            }
            paramc = new d.v("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            AppMethodBeat.o(189995);
            throw paramc;
            localThrowable = null;
            break;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = c.fLy();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label372;
          }
        }
        finally
        {
          AppMethodBeat.o(189995);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label372:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(189995);
        throw paramObject;
        label405:
        if (localObject1 != localThrowable)
        {
          paramObject = new q((Throwable)localObject1);
          continue;
          label428:
          i = 0;
        }
      }
      label433:
      ((q)paramObject).fKR();
      label441:
      boolean bool = Kdh.compareAndSet(this, paramc, bo.fJ(paramObject));
      if ((ah.fKW()) && (!bool))
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(189995);
        throw paramc;
      }
      b((be)paramc, paramObject);
      AppMethodBeat.o(189995);
      return paramObject;
    }
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.fLx())
      {
        paramc = (Throwable)new bk(fKD(), null, (bj)this);
        AppMethodBeat.o(118280);
        return paramc;
      }
      AppMethodBeat.o(118280);
      return null;
    }
    Object localObject = ((Iterable)paramList).iterator();
    int i;
    if (((Iterator)localObject).hasNext())
    {
      paramc = ((Iterator)localObject).next();
      if (!((Throwable)paramc instanceof CancellationException))
      {
        i = 1;
        label99:
        if (i == 0) {
          break label123;
        }
      }
    }
    for (;;)
    {
      paramc = (Throwable)paramc;
      if (paramc == null) {
        break label130;
      }
      AppMethodBeat.o(118280);
      return paramc;
      i = 0;
      break label99;
      label123:
      break;
      paramc = null;
    }
    label130:
    localObject = (Throwable)paramList.get(0);
    if ((localObject instanceof cc))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof cc)))
        {
          i = 1;
          label199:
          if (i == 0) {
            break label223;
          }
        }
      }
      for (;;)
      {
        paramc = (Throwable)paramc;
        if (paramc == null) {
          break label230;
        }
        AppMethodBeat.o(118280);
        return paramc;
        i = 0;
        break label199;
        label223:
        break;
        paramc = null;
      }
    }
    label230:
    AppMethodBeat.o(118280);
    return localObject;
  }
  
  private final bm<?> a(b<? super Throwable, y> paramb, boolean paramBoolean)
  {
    bm localbm = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118291);
    if (paramBoolean) {
      if ((paramb instanceof bl)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (bl)localObject;
      if (localObject != null)
      {
        if (ah.fKW())
        {
          if (((bl)localObject).Kes == (bn)this) {}
          while (i == 0)
          {
            paramb = (Throwable)new AssertionError();
            AppMethodBeat.o(118291);
            throw paramb;
            i = 0;
          }
        }
        if (localObject != null)
        {
          paramb = (bm)localObject;
          AppMethodBeat.o(118291);
          return paramb;
        }
      }
      paramb = (bm)new bh((bj)this, paramb);
      AppMethodBeat.o(118291);
      return paramb;
      if (!(paramb instanceof bm)) {}
      for (localObject = localbm;; localObject = paramb)
      {
        localbm = (bm)localObject;
        if (localbm != null)
        {
          if (ah.fKW())
          {
            if ((localbm.Kes == (bn)this) && (!(localbm instanceof bl))) {}
            for (i = 1; i == 0; i = 0)
            {
              paramb = (Throwable)new AssertionError();
              AppMethodBeat.o(118291);
              throw paramb;
            }
          }
          localObject = localbm;
          if (localbm != null) {}
        }
        else
        {
          localObject = (bm)new bi((bj)this, paramb);
        }
        AppMethodBeat.o(118291);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private final bs a(be parambe)
  {
    AppMethodBeat.i(118300);
    bs localbs = parambe.fLh();
    if (localbs == null)
    {
      if ((parambe instanceof aw))
      {
        parambe = new bs();
        AppMethodBeat.o(118300);
        return parambe;
      }
      if ((parambe instanceof bm))
      {
        a((bm)parambe);
        AppMethodBeat.o(118300);
        return null;
      }
      parambe = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(parambe)).toString());
      AppMethodBeat.o(118300);
      throw parambe;
    }
    AppMethodBeat.o(118300);
    return localbs;
  }
  
  private static n a(g paramg)
  {
    AppMethodBeat.i(118303);
    while (paramg.isRemoved()) {
      paramg = paramg.fLP();
    }
    g localg;
    do
    {
      do
      {
        localg = kotlinx.coroutines.a.f.fM(paramg.fLN());
        paramg = localg;
      } while (localg.isRemoved());
      if ((localg instanceof n))
      {
        paramg = (n)localg;
        AppMethodBeat.o(118303);
        return paramg;
      }
      paramg = localg;
    } while (!(localg instanceof bs));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private final void a(bm<?> parambm)
  {
    AppMethodBeat.i(118293);
    parambm.c((g)new bs());
    g localg = kotlinx.coroutines.a.f.fM(parambm.fLN());
    Kdh.compareAndSet(this, parambm, localg);
    AppMethodBeat.o(118293);
  }
  
  private final void a(bs parambs, Throwable paramThrowable)
  {
    AppMethodBeat.i(118284);
    Object localObject1 = null;
    e locale = (e)parambs;
    parambs = locale.fLN();
    if (parambs == null)
    {
      parambs = new d.v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118284);
      throw parambs;
    }
    Object localObject2 = (g)parambs;
    parambs = (bs)localObject1;
    localObject1 = localObject2;
    if ((k.g(localObject1, locale) ^ true))
    {
      if (!(localObject1 instanceof bl)) {
        break label184;
      }
      localObject2 = (bm)localObject1;
    }
    label184:
    for (;;)
    {
      try
      {
        ((bm)localObject2).u(paramThrowable);
        localObject1 = ((g)localObject1).fLO();
      }
      catch (Throwable localThrowable)
      {
        if (parambs != null)
        {
          a.a(parambs, localThrowable);
          if (parambs != null) {
            break label184;
          }
        }
        parambs = (bn)this;
        parambs = (Throwable)new v("Exception in completion handler " + localObject2 + " for " + parambs, localThrowable);
        localObject2 = y.JfV;
        continue;
      }
      if (parambs != null) {
        t(parambs);
      }
      y(paramThrowable);
      AppMethodBeat.o(118284);
      return;
    }
  }
  
  private final boolean a(final Object paramObject, bs parambs, bm<?> parambm)
  {
    AppMethodBeat.i(118292);
    parambs = (g)parambs;
    paramObject = (g.a)new d((g)parambm, (g)parambm, this, paramObject);
    for (;;)
    {
      switch (parambs.fLP().a((g)parambm, parambs, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(be parambe, Object paramObject)
  {
    AppMethodBeat.i(189997);
    int i;
    if (ah.fKW())
    {
      if (((parambe instanceof aw)) || ((parambe instanceof bm))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambe = (Throwable)new AssertionError();
        AppMethodBeat.o(189997);
        throw parambe;
      }
    }
    if (ah.fKW())
    {
      if (!(paramObject instanceof q)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambe = (Throwable)new AssertionError();
        AppMethodBeat.o(189997);
        throw parambe;
      }
    }
    if (!Kdh.compareAndSet(this, parambe, bo.fJ(paramObject)))
    {
      AppMethodBeat.o(189997);
      return false;
    }
    b(parambe, paramObject);
    AppMethodBeat.o(189997);
    return true;
  }
  
  private final boolean a(c paramc, n paramn, Object paramObject)
  {
    AppMethodBeat.i(118302);
    n localn;
    do
    {
      if (bj.a.a(paramn.Kdk, false, false, (b)new b(this, paramc, paramn, paramObject), 1) != bt.KeI)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localn = a((g)paramn);
      paramn = localn;
    } while (localn != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private static void b(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(189996);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(189996);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!ah.fKX())
    {
      localThrowable = paramThrowable;
      localIterator = paramList.iterator();
    }
    label135:
    for (;;)
    {
      label59:
      if (!localIterator.hasNext()) {
        break label137;
      }
      paramList = (Throwable)localIterator.next();
      if (!ah.fKX()) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        a.a(paramThrowable, paramList);
        break label59;
        localThrowable = kotlinx.coroutines.a.l.D(paramThrowable);
        break;
        paramList = kotlinx.coroutines.a.l.D(paramList);
      }
    }
    label137:
    AppMethodBeat.o(189996);
  }
  
  private final void b(be parambe, Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(189998);
    Object localObject2 = (m)this._parentHandle;
    if (localObject2 != null)
    {
      ((m)localObject2).dispose();
      this._parentHandle = ((m)bt.KeI);
    }
    if (!(paramObject instanceof q)) {
      paramObject = null;
    }
    for (;;)
    {
      localObject2 = (q)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((q)localObject2).cause;
      }
      if ((parambe instanceof bm)) {
        try
        {
          ((bm)parambe).u(paramObject);
          AppMethodBeat.o(189998);
          return;
        }
        catch (Throwable paramObject)
        {
          t((Throwable)new v("Exception in completion handler " + parambe + " for " + this, paramObject));
          AppMethodBeat.o(189998);
          return;
        }
      }
      parambe = parambe.fLh();
      if (parambe != null)
      {
        b(parambe, paramObject);
        AppMethodBeat.o(189998);
        return;
      }
      AppMethodBeat.o(189998);
      return;
    }
  }
  
  private final void b(bs parambs, Throwable paramThrowable)
  {
    AppMethodBeat.i(118285);
    Object localObject1 = null;
    e locale = (e)parambs;
    parambs = locale.fLN();
    if (parambs == null)
    {
      parambs = new d.v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118285);
      throw parambs;
    }
    Object localObject2 = (g)parambs;
    parambs = (bs)localObject1;
    localObject1 = localObject2;
    if ((k.g(localObject1, locale) ^ true))
    {
      if (!(localObject1 instanceof bm)) {
        break label185;
      }
      localObject2 = (bm)localObject1;
    }
    label185:
    for (;;)
    {
      try
      {
        ((bm)localObject2).u(paramThrowable);
        localObject1 = ((g)localObject1).fLO();
      }
      catch (Throwable localThrowable)
      {
        if (parambs != null)
        {
          a.a(parambs, localThrowable);
          if (parambs != null) {
            break label185;
          }
        }
        parambs = (bn)this;
        parambs = (Throwable)new v("Exception in completion handler " + localObject2 + " for " + parambs, localThrowable);
        localObject2 = y.JfV;
        continue;
      }
      if (parambs != null)
      {
        t(parambs);
        AppMethodBeat.o(118285);
        return;
      }
      AppMethodBeat.o(118285);
      return;
    }
  }
  
  private final Object c(be parambe, Object paramObject)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(190004);
    bs localbs = a(parambe);
    if (localbs == null)
    {
      parambe = bo.fLE();
      AppMethodBeat.o(190004);
      return parambe;
    }
    label70:
    int i;
    Object localObject2;
    if (!(parambe instanceof c))
    {
      ??? = null;
      ??? = (c)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new c(localbs, null))
          {
            if (((c)???)._isCompleting != 0)
            {
              parambe = bo.fLC();
              AppMethodBeat.o(190004);
              return parambe;
            }
            ((c)???)._isCompleting = 1;
            if ((??? != parambe) && (!Kdh.compareAndSet(this, parambe, ???)))
            {
              parambe = bo.fLE();
              AppMethodBeat.o(190004);
              return parambe;
            }
            if (!ah.fKW()) {
              break;
            }
            if (!((c)???).isSealed())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              parambe = (Throwable)new AssertionError();
              AppMethodBeat.o(190004);
              throw parambe;
            }
          }
          i = 0;
        }
        boolean bool = ((c)???).fLx();
        if (!(paramObject instanceof q))
        {
          localObject2 = null;
          label209:
          localObject2 = (q)localObject2;
          if (localObject2 != null) {
            ((c)???).A(((q)localObject2).cause);
          }
          localObject2 = (Throwable)((c)???)._rootCause;
          if (!bool)
          {
            i = j;
            break label401;
          }
        }
      }
    }
    for (;;)
    {
      label252:
      y localy = y.JfV;
      if (localObject2 != null) {
        a(localbs, (Throwable)localObject2);
      }
      if (!(parambe instanceof n))
      {
        localObject2 = null;
        label283:
        localObject2 = (n)localObject2;
        if (localObject2 == null)
        {
          localObject2 = parambe.fLh();
          parambe = localObject3;
          if (localObject2 != null) {
            parambe = a((g)localObject2);
          }
          label320:
          if ((parambe != null) && (a((c)???, parambe, paramObject)))
          {
            parambe = bo.KeC;
            AppMethodBeat.o(190004);
            return parambe;
            i = 0;
          }
        }
      }
      label401:
      while (i == 0)
      {
        localObject2 = null;
        break label252;
        parambe = a((c)???, paramObject);
        AppMethodBeat.o(190004);
        return parambe;
        parambe = (be)localObject2;
        break label320;
        localObject2 = parambe;
        break label283;
        localObject2 = paramObject;
        break label209;
        break label70;
        ??? = parambe;
        break;
      }
    }
  }
  
  private CancellationException c(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(118289);
    if (!(paramThrowable instanceof CancellationException)) {}
    for (Object localObject = null;; localObject = paramThrowable)
    {
      CancellationException localCancellationException = (CancellationException)localObject;
      localObject = localCancellationException;
      if (localCancellationException == null)
      {
        localObject = paramString;
        if (paramString == null) {
          localObject = fKD();
        }
        localObject = (CancellationException)new bk((String)localObject, paramThrowable, (bj)this);
      }
      AppMethodBeat.o(118289);
      return localObject;
    }
  }
  
  private final Throwable fG(Object paramObject)
  {
    AppMethodBeat.i(118298);
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof Throwable;
    }
    while (bool) {
      if (paramObject != null)
      {
        paramObject = (Throwable)paramObject;
        AppMethodBeat.o(118298);
        return paramObject;
        bool = true;
      }
      else
      {
        paramObject = (Throwable)new bk(fKD(), null, (bj)this);
        AppMethodBeat.o(118298);
        return paramObject;
      }
    }
    if (paramObject == null)
    {
      paramObject = new d.v("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
      AppMethodBeat.o(118298);
      throw paramObject;
    }
    paramObject = (Throwable)((bv)paramObject).fLw();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object fH(Object paramObject)
  {
    AppMethodBeat.i(190002);
    Throwable localThrowable = null;
    Object localObject2 = fLv();
    int i;
    if ((localObject2 instanceof c))
    {
      try
      {
        if (((c)localObject2).isSealed())
        {
          paramObject = bo.fLD();
          return paramObject;
        }
        boolean bool = ((c)localObject2).fLx();
        if ((paramObject != null) || (!bool))
        {
          localObject1 = localThrowable;
          if (localThrowable == null) {
            localObject1 = fG(paramObject);
          }
          ((c)localObject2).A((Throwable)localObject1);
        }
        paramObject = (Throwable)((c)localObject2)._rootCause;
        if (!bool)
        {
          i = 1;
          if (i == 0) {
            break label154;
          }
        }
        for (;;)
        {
          if (paramObject != null) {
            a(((c)localObject2).Ken, paramObject);
          }
          paramObject = bo.fLC();
          AppMethodBeat.o(190002);
          return paramObject;
          i = 0;
          break;
          label154:
          paramObject = null;
        }
        if (!(localObject2 instanceof be)) {
          break label445;
        }
      }
      finally
      {
        AppMethodBeat.o(190002);
      }
    }
    else
    {
      if (localThrowable != null) {
        break label460;
      }
      localThrowable = fG(paramObject);
    }
    label445:
    label460:
    for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
    {
      if (((be)localObject2).isActive())
      {
        localObject2 = (be)localObject2;
        if (ah.fKW())
        {
          if (!(localObject2 instanceof c)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new AssertionError();
            AppMethodBeat.o(190002);
            throw paramObject;
          }
        }
        if ((ah.fKW()) && (!((be)localObject2).isActive()))
        {
          paramObject = (Throwable)new AssertionError();
          AppMethodBeat.o(190002);
          throw paramObject;
        }
        bs localbs = a((be)localObject2);
        if (localbs == null) {
          i = 0;
        }
        while (i != 0)
        {
          paramObject = bo.fLC();
          AppMethodBeat.o(190002);
          return paramObject;
          c localc = new c(localbs, (Throwable)localObject1);
          if (!Kdh.compareAndSet(this, localObject2, localc))
          {
            i = 0;
          }
          else
          {
            a(localbs, (Throwable)localObject1);
            i = 1;
          }
        }
      }
      localObject1 = T(localObject2, new q((Throwable)localObject1));
      if (localObject1 == bo.fLC())
      {
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(190002);
        throw paramObject;
      }
      if (localObject1 != bo.fLE())
      {
        AppMethodBeat.o(190002);
        return localObject1;
        paramObject = bo.fLD();
        AppMethodBeat.o(190002);
        return paramObject;
      }
      break;
    }
  }
  
  private static String fI(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).fLx())
      {
        AppMethodBeat.o(118310);
        return "Cancelling";
      }
      if (((c)paramObject)._isCompleting != 0)
      {
        AppMethodBeat.o(118310);
        return "Completing";
      }
      AppMethodBeat.o(118310);
      return "Active";
    }
    if ((paramObject instanceof be))
    {
      if (((be)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof q))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  private static Throwable gk(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof q)) {
      paramObject = null;
    }
    for (;;)
    {
      q localq = (q)paramObject;
      paramObject = localObject;
      if (localq != null) {
        paramObject = localq.cause;
      }
      return paramObject;
    }
  }
  
  private final boolean y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (gaH())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    m localm = (m)this._parentHandle;
    if ((localm == null) || (localm == bt.KeI))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((localm.x(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  public final au L(b<? super Throwable, y> paramb)
  {
    AppMethodBeat.i(202326);
    paramb = a(false, true, paramb);
    AppMethodBeat.o(202326);
    return paramb;
  }
  
  public final au a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, y> paramb)
  {
    Object localObject4 = null;
    AppMethodBeat.i(118290);
    Object localObject1 = null;
    Object localObject5 = fLv();
    if ((localObject5 instanceof aw)) {
      if (((aw)localObject5).isActive)
      {
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = a(paramb, paramBoolean1);
      }
    }
    label518:
    label530:
    label532:
    label539:
    label549:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      Object localObject3;
      bs localbs;
      au localau;
      if (Kdh.compareAndSet(this, localObject5, localObject2))
      {
        paramb = (au)localObject2;
        AppMethodBeat.o(118290);
        return paramb;
        localObject3 = (aw)localObject5;
        localObject2 = new bs();
        if (((aw)localObject3).isActive) {}
        for (localObject2 = (be)localObject2;; localObject2 = (be)new bd((bs)localObject2))
        {
          Kdh.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject5 instanceof be))
        {
          localbs = ((be)localObject5).fLh();
          if (localbs == null)
          {
            if (localObject5 == null)
            {
              paramb = new d.v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118290);
              throw paramb;
            }
            a((bm)localObject5);
            break;
          }
          localau = (au)bt.KeI;
          if ((!paramBoolean1) || (!(localObject5 instanceof c))) {
            break label539;
          }
        }
      }
      for (;;)
      {
        try
        {
          Throwable localThrowable = (Throwable)((c)localObject5)._rootCause;
          if (localThrowable != null)
          {
            localObject2 = localau;
            localObject3 = localObject1;
            if ((paramb instanceof n))
            {
              localObject2 = localau;
              localObject3 = localObject1;
              if (((c)localObject5)._isCompleting != 0) {}
            }
          }
          else
          {
            if (localObject1 != null) {
              break label532;
            }
            localObject1 = a(paramb, paramBoolean1);
            localObject2 = localObject1;
            boolean bool = a(localObject5, localbs, (bm)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (au)localObject2;
              return paramb;
            }
            localObject2 = (au)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = y.JfV;
          localObject1 = localObject3;
          localObject3 = localThrowable;
          if (localObject3 != null)
          {
            if (paramBoolean2) {
              paramb.aA(localObject3);
            }
            AppMethodBeat.o(118290);
            return localObject2;
          }
        }
        finally
        {
          AppMethodBeat.o(118290);
        }
        if (localObject1 == null) {
          localObject1 = a(paramb, paramBoolean1);
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          if (!a(localObject5, localbs, (bm)localObject2)) {
            break label530;
          }
          paramb = (au)localObject2;
          AppMethodBeat.o(118290);
          return paramb;
          if (paramBoolean2) {
            if ((localObject5 instanceof q)) {
              break label518;
            }
          }
          for (localObject1 = null;; localObject1 = localObject5)
          {
            localObject2 = (q)localObject1;
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = ((q)localObject2).cause;
            }
            paramb.aA(localObject1);
            paramb = (au)bt.KeI;
            AppMethodBeat.o(118290);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localau;
      }
    }
  }
  
  public final m a(o paramo)
  {
    AppMethodBeat.i(118304);
    paramo = bj.a.a(this, true, false, (b)new n(this, paramo), 2);
    if (paramo == null)
    {
      paramo = new d.v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118304);
      throw paramo;
    }
    paramo = (m)paramo;
    AppMethodBeat.o(118304);
    return paramo;
  }
  
  public final void a(bv parambv)
  {
    AppMethodBeat.i(118295);
    fF(parambv);
    AppMethodBeat.o(118295);
  }
  
  final int fE(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof aw))
    {
      if (((aw)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!Kdh.compareAndSet(this, paramObject, bo.fLB()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      fKC();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bd))
    {
      if (!Kdh.compareAndSet(this, paramObject, ((bd)paramObject).Ken))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      fKC();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  public final boolean fF(Object paramObject)
  {
    AppMethodBeat.i(190000);
    kotlinx.coroutines.a.m localm = bo.fLC();
    Object localObject = localm;
    if (localm == bo.fLC()) {
      localObject = fH(paramObject);
    }
    if (localObject == bo.fLC())
    {
      AppMethodBeat.o(190000);
      return true;
    }
    if (localObject == bo.KeC)
    {
      AppMethodBeat.o(190000);
      return true;
    }
    if (localObject == bo.fLD())
    {
      AppMethodBeat.o(190000);
      return false;
    }
    gi(localObject);
    AppMethodBeat.o(190000);
    return true;
  }
  
  public void fKC() {}
  
  protected String fKD()
  {
    return "Job was cancelled";
  }
  
  public String fKE()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  public final CancellationException fLt()
  {
    AppMethodBeat.i(118288);
    Object localObject = fLv();
    if ((localObject instanceof c))
    {
      localObject = (Throwable)((c)localObject)._rootCause;
      if (localObject != null)
      {
        CancellationException localCancellationException = c((Throwable)localObject, getClass().getSimpleName() + " is cancelling");
        localObject = localCancellationException;
        if (localCancellationException != null) {}
      }
      else
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      if ((localObject instanceof be))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof q))
      {
        localObject = c(((q)localObject).cause, null);
        AppMethodBeat.o(118288);
        return localObject;
      }
      localObject = (CancellationException)new bk(getClass().getSimpleName() + " has completed normally", null, (bj)this);
    }
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public final void fLu()
  {
    AppMethodBeat.i(189999);
    fF((Throwable)new bk(fKD(), null, (bj)this));
    AppMethodBeat.o(189999);
  }
  
  public final Object fLv()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof j))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((j)localObject).fL(this);
    }
  }
  
  public final CancellationException fLw()
  {
    AppMethodBeat.i(190001);
    Object localObject2 = fLv();
    Throwable localThrowable;
    if ((localObject2 instanceof c))
    {
      localThrowable = (Throwable)((c)localObject2)._rootCause;
      if ((localThrowable instanceof CancellationException)) {
        break label163;
      }
    }
    label163:
    for (Object localObject1 = null;; localObject1 = localThrowable)
    {
      CancellationException localCancellationException = (CancellationException)localObject1;
      localObject1 = localCancellationException;
      if (localCancellationException == null) {
        localObject1 = (CancellationException)new bk("Parent job is " + fI(localObject2), localThrowable, (bj)this);
      }
      AppMethodBeat.o(190001);
      return localObject1;
      if ((localObject2 instanceof q))
      {
        localThrowable = ((q)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof be))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(190001);
        throw localThrowable;
      }
      localThrowable = null;
      break;
    }
  }
  
  public <R> R fold(R paramR, d.g.a.m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118313);
    paramR = f.b.a.a((f.b)this, paramR, paramm);
    AppMethodBeat.o(118313);
    return paramR;
  }
  
  protected boolean gaH()
  {
    return false;
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(118314);
    paramc = f.b.a.a((f.b)this, paramc);
    AppMethodBeat.o(118314);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    return (f.c)bj.Keq;
  }
  
  protected void gi(Object paramObject) {}
  
  public final Object gj(Object paramObject)
  {
    AppMethodBeat.i(202327);
    Object localObject;
    do
    {
      localObject = T(fLv(), paramObject);
      if (localObject == bo.fLC())
      {
        paramObject = (Throwable)new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + paramObject, gk(paramObject));
        AppMethodBeat.o(202327);
        throw paramObject;
      }
    } while (localObject == bo.fLE());
    AppMethodBeat.o(202327);
    return localObject;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = fLv();
    if (((localObject instanceof be)) && (((be)localObject).isActive()))
    {
      AppMethodBeat.o(118278);
      return true;
    }
    AppMethodBeat.o(118278);
    return false;
  }
  
  public d.d.f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(118315);
    paramc = f.b.a.b((f.b)this, paramc);
    AppMethodBeat.o(118315);
    return paramc;
  }
  
  public d.d.f plus(d.d.f paramf)
  {
    AppMethodBeat.i(118312);
    paramf = f.b.a.a((f.b)this, paramf);
    AppMethodBeat.o(118312);
    return paramf;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(118286);
    for (;;)
    {
      switch (fE(fLv()))
      {
      }
    }
    AppMethodBeat.o(118286);
    return false;
    AppMethodBeat.o(118286);
    return true;
  }
  
  public void t(Throwable paramThrowable)
  {
    AppMethodBeat.i(118305);
    AppMethodBeat.o(118305);
    throw paramThrowable;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118308);
    String str = new StringBuilder().append(fKE()).append('{').append(fI(fLv())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  protected boolean z(Throwable paramThrowable)
  {
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
  static final class a<T>
    extends i<T>
  {
    private final bn Ket;
    
    public a(d<? super T> paramd, bn parambn)
    {
      super();
      AppMethodBeat.i(118133);
      this.Ket = parambn;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable a(bj parambj)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.Ket.fLv();
      if ((localObject instanceof bn.c))
      {
        Throwable localThrowable = (Throwable)((bn.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof q))
      {
        parambj = ((q)localObject).cause;
        AppMethodBeat.o(118131);
        return parambj;
      }
      parambj = (Throwable)parambj.fLt();
      AppMethodBeat.o(118131);
      return parambj;
    }
    
    protected final String fKL()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends bm<bj>
  {
    private final bn Keu;
    private final bn.c Kev;
    private final n Kew;
    private final Object Kex;
    
    public b(bn parambn, bn.c paramc, n paramn, Object paramObject)
    {
      super();
      AppMethodBeat.i(118262);
      this.Keu = parambn;
      this.Kev = paramc;
      this.Kew = paramn;
      this.Kex = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118261);
      String str = "ChildCompletion[" + this.Kew + ", " + this.Kex + ']';
      AppMethodBeat.o(118261);
      return str;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      bn.a(this.Keu, this.Kev, this.Kew, this.Kex);
      AppMethodBeat.o(118259);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
  static final class c
    implements be
  {
    final bs Ken;
    volatile Object _exceptionsHolder;
    volatile int _isCompleting;
    volatile Object _rootCause;
    
    public c(bs parambs, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.Ken = parambs;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> fLy()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void A(Throwable paramThrowable)
    {
      AppMethodBeat.i(118222);
      Object localObject = (Throwable)this._rootCause;
      if (localObject == null)
      {
        this._rootCause = paramThrowable;
        AppMethodBeat.o(118222);
        return;
      }
      if (paramThrowable == localObject)
      {
        AppMethodBeat.o(118222);
        return;
      }
      localObject = this._exceptionsHolder;
      if (localObject == null)
      {
        this._exceptionsHolder = paramThrowable;
        AppMethodBeat.o(118222);
        return;
      }
      if ((localObject instanceof Throwable))
      {
        if (paramThrowable == localObject)
        {
          AppMethodBeat.o(118222);
          return;
        }
        ArrayList localArrayList = fLy();
        localArrayList.add(localObject);
        localArrayList.add(paramThrowable);
        this._exceptionsHolder = localArrayList;
        AppMethodBeat.o(118222);
        return;
      }
      if ((localObject instanceof ArrayList))
      {
        ((ArrayList)localObject).add(paramThrowable);
        AppMethodBeat.o(118222);
        return;
      }
      paramThrowable = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject)).toString());
      AppMethodBeat.o(118222);
      throw paramThrowable;
    }
    
    public final bs fLh()
    {
      return this.Ken;
    }
    
    public final boolean fLx()
    {
      return (Throwable)this._rootCause != null;
    }
    
    public final boolean isActive()
    {
      return (Throwable)this._rootCause == null;
    }
    
    public final boolean isSealed()
    {
      AppMethodBeat.i(118221);
      if (this._exceptionsHolder == bo.fLA())
      {
        AppMethodBeat.o(118221);
        return true;
      }
      AppMethodBeat.o(118221);
      return false;
    }
    
    public final String toString()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class d
    extends g.a
  {
    public d(g paramg1, g paramg2, bn parambn, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bn
 * JD-Core Version:    0.7.0.1
 */