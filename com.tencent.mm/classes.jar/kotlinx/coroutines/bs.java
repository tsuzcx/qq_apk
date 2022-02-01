package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a;
import d.d.d;
import d.d.f;
import d.d.f.b;
import d.d.f.b.a;
import d.d.f.c;
import d.g.a.b;
import d.g.a.m;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.i.a;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.s;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class bs
  implements bo, ca, r
{
  static final AtomicReferenceFieldUpdater LQI;
  volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(118317);
    LQI = AtomicReferenceFieldUpdater.newUpdater(bs.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public bs(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (bb localbb = bt.gel();; localbb = bt.gep())
    {
      this._state = localbb;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final Object U(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191115);
    if (!(paramObject1 instanceof bj))
    {
      paramObject1 = bt.gem();
      AppMethodBeat.o(191115);
      return paramObject1;
    }
    if ((((paramObject1 instanceof bb)) || ((paramObject1 instanceof br))) && (!(paramObject1 instanceof q)) && (!(paramObject2 instanceof t)))
    {
      if (a((bj)paramObject1, paramObject2))
      {
        AppMethodBeat.o(191115);
        return paramObject2;
      }
      paramObject1 = bt.geo();
      AppMethodBeat.o(191115);
      return paramObject1;
    }
    paramObject1 = c((bj)paramObject1, paramObject2);
    AppMethodBeat.o(191115);
    return paramObject1;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(191105);
    int i;
    if (al.gdD())
    {
      if (gee() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(191105);
        throw paramc;
      }
    }
    if (al.gdD())
    {
      if (!paramc.isSealed()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(191105);
        throw paramc;
      }
    }
    if ((al.gdD()) && (paramc._isCompleting == 0))
    {
      paramc = (Throwable)new AssertionError();
      AppMethodBeat.o(191105);
      throw paramc;
    }
    if (!(paramObject instanceof t)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (t)localObject1;
      Throwable localThrowable;
      if (localObject1 != null) {
        localThrowable = ((t)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = paramc._exceptionsHolder;
          if (localObject2 == null)
          {
            localObject1 = c.gei();
            localObject2 = (Throwable)paramc._rootCause;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((d.g.b.k.g(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramc._exceptionsHolder = bt.gek();
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
            if ((!z((Throwable)localObject1)) && (!A((Throwable)localObject1))) {
              break label428;
            }
            i = 1;
            if (i == 0) {
              break label441;
            }
            if (paramObject != null) {
              break label433;
            }
            paramc = new v("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            AppMethodBeat.o(191105);
            throw paramc;
            localThrowable = null;
            break;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = c.gei();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label372;
          }
        }
        finally
        {
          AppMethodBeat.o(191105);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label372:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(191105);
        throw paramObject;
        label405:
        if (localObject1 != localThrowable)
        {
          paramObject = new t((Throwable)localObject1);
          continue;
          label428:
          i = 0;
        }
      }
      label433:
      ((t)paramObject).gdy();
      label441:
      boolean bool = LQI.compareAndSet(this, paramc, bt.fR(paramObject));
      if ((al.gdD()) && (!bool))
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(191105);
        throw paramc;
      }
      b((bj)paramc, paramObject);
      AppMethodBeat.o(191105);
      return paramObject;
    }
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.geh())
      {
        paramc = (Throwable)new bp(gdh(), null, (bo)this);
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
    if ((localObject instanceof ch))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof ch)))
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
  
  private final br<?> a(b<? super Throwable, d.y> paramb, boolean paramBoolean)
  {
    br localbr = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118291);
    if (paramBoolean) {
      if ((paramb instanceof bq)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (bq)localObject;
      if (localObject != null)
      {
        if (al.gdD())
        {
          if (((bq)localObject).LRS == (bs)this) {}
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
          paramb = (br)localObject;
          AppMethodBeat.o(118291);
          return paramb;
        }
      }
      paramb = (br)new bm((bo)this, paramb);
      AppMethodBeat.o(118291);
      return paramb;
      if (!(paramb instanceof br)) {}
      for (localObject = localbr;; localObject = paramb)
      {
        localbr = (br)localObject;
        if (localbr != null)
        {
          if (al.gdD())
          {
            if ((localbr.LRS == (bs)this) && (!(localbr instanceof bq))) {}
            for (i = 1; i == 0; i = 0)
            {
              paramb = (Throwable)new AssertionError();
              AppMethodBeat.o(118291);
              throw paramb;
            }
          }
          localObject = localbr;
          if (localbr != null) {}
        }
        else
        {
          localObject = (br)new bn((bo)this, paramb);
        }
        AppMethodBeat.o(118291);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private final bx a(bj parambj)
  {
    AppMethodBeat.i(118300);
    bx localbx = parambj.gdQ();
    if (localbx == null)
    {
      if ((parambj instanceof bb))
      {
        parambj = new bx();
        AppMethodBeat.o(118300);
        return parambj;
      }
      if ((parambj instanceof br))
      {
        a((br)parambj);
        AppMethodBeat.o(118300);
        return null;
      }
      parambj = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(parambj)).toString());
      AppMethodBeat.o(118300);
      throw parambj;
    }
    AppMethodBeat.o(118300);
    return localbx;
  }
  
  private static q a(i parami)
  {
    AppMethodBeat.i(118303);
    while (parami.isRemoved()) {
      parami = parami.geC();
    }
    i locali;
    do
    {
      do
      {
        locali = h.fU(parami.geA());
        parami = locali;
      } while (locali.isRemoved());
      if ((locali instanceof q))
      {
        parami = (q)locali;
        AppMethodBeat.o(118303);
        return parami;
      }
      parami = locali;
    } while (!(locali instanceof bx));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private final void a(br<?> parambr)
  {
    AppMethodBeat.i(118293);
    parambr.c((i)new bx());
    i locali = h.fU(parambr.geA());
    LQI.compareAndSet(this, parambr, locali);
    AppMethodBeat.o(118293);
  }
  
  private final void a(bx parambx, Throwable paramThrowable)
  {
    AppMethodBeat.i(118284);
    Object localObject1 = null;
    g localg = (g)parambx;
    parambx = localg.geA();
    if (parambx == null)
    {
      parambx = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118284);
      throw parambx;
    }
    Object localObject2 = (i)parambx;
    parambx = (bx)localObject1;
    localObject1 = localObject2;
    if ((d.g.b.k.g(localObject1, localg) ^ true))
    {
      if (!(localObject1 instanceof bq)) {
        break label184;
      }
      localObject2 = (br)localObject1;
    }
    label184:
    for (;;)
    {
      try
      {
        ((br)localObject2).u(paramThrowable);
        localObject1 = ((i)localObject1).geB();
      }
      catch (Throwable localThrowable)
      {
        if (parambx != null)
        {
          a.a(parambx, localThrowable);
          if (parambx != null) {
            break label184;
          }
        }
        parambx = (bs)this;
        parambx = (Throwable)new y("Exception in completion handler " + localObject2 + " for " + parambx, localThrowable);
        localObject2 = d.y.KTp;
        continue;
      }
      if (parambx != null) {
        t(parambx);
      }
      z(paramThrowable);
      AppMethodBeat.o(118284);
      return;
    }
  }
  
  private final boolean a(final Object paramObject, bx parambx, br<?> parambr)
  {
    AppMethodBeat.i(118292);
    parambx = (i)parambx;
    paramObject = (i.a)new d((i)parambr, (i)parambr, this, paramObject);
    for (;;)
    {
      switch (parambx.geC().a((i)parambr, parambx, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(bj parambj, Object paramObject)
  {
    AppMethodBeat.i(191107);
    int i;
    if (al.gdD())
    {
      if (((parambj instanceof bb)) || ((parambj instanceof br))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambj = (Throwable)new AssertionError();
        AppMethodBeat.o(191107);
        throw parambj;
      }
    }
    if (al.gdD())
    {
      if (!(paramObject instanceof t)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambj = (Throwable)new AssertionError();
        AppMethodBeat.o(191107);
        throw parambj;
      }
    }
    if (!LQI.compareAndSet(this, parambj, bt.fR(paramObject)))
    {
      AppMethodBeat.o(191107);
      return false;
    }
    b(parambj, paramObject);
    AppMethodBeat.o(191107);
    return true;
  }
  
  private final boolean a(c paramc, q paramq, Object paramObject)
  {
    AppMethodBeat.i(118302);
    q localq;
    do
    {
      if (bo.a.a(paramq.LQM, false, false, (b)new b(this, paramc, paramq, paramObject), 1) != by.LSi)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localq = a((i)paramq);
      paramq = localq;
    } while (localq != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private static void b(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(191106);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(191106);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!al.gdE())
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
      if (!al.gdE()) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        a.a(paramThrowable, paramList);
        break label59;
        localThrowable = kotlinx.coroutines.internal.r.E(paramThrowable);
        break;
        paramList = kotlinx.coroutines.internal.r.E(paramList);
      }
    }
    label137:
    AppMethodBeat.o(191106);
  }
  
  private final void b(bj parambj, Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(191108);
    Object localObject2 = (p)this._parentHandle;
    if (localObject2 != null)
    {
      ((p)localObject2).dispose();
      this._parentHandle = ((p)by.LSi);
    }
    if (!(paramObject instanceof t)) {
      paramObject = null;
    }
    for (;;)
    {
      localObject2 = (t)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((t)localObject2).cause;
      }
      if ((parambj instanceof br)) {
        try
        {
          ((br)parambj).u(paramObject);
          AppMethodBeat.o(191108);
          return;
        }
        catch (Throwable paramObject)
        {
          t((Throwable)new y("Exception in completion handler " + parambj + " for " + this, paramObject));
          AppMethodBeat.o(191108);
          return;
        }
      }
      parambj = parambj.gdQ();
      if (parambj != null)
      {
        b(parambj, paramObject);
        AppMethodBeat.o(191108);
        return;
      }
      AppMethodBeat.o(191108);
      return;
    }
  }
  
  private final void b(bx parambx, Throwable paramThrowable)
  {
    AppMethodBeat.i(118285);
    Object localObject1 = null;
    g localg = (g)parambx;
    parambx = localg.geA();
    if (parambx == null)
    {
      parambx = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118285);
      throw parambx;
    }
    Object localObject2 = (i)parambx;
    parambx = (bx)localObject1;
    localObject1 = localObject2;
    if ((d.g.b.k.g(localObject1, localg) ^ true))
    {
      if (!(localObject1 instanceof br)) {
        break label185;
      }
      localObject2 = (br)localObject1;
    }
    label185:
    for (;;)
    {
      try
      {
        ((br)localObject2).u(paramThrowable);
        localObject1 = ((i)localObject1).geB();
      }
      catch (Throwable localThrowable)
      {
        if (parambx != null)
        {
          a.a(parambx, localThrowable);
          if (parambx != null) {
            break label185;
          }
        }
        parambx = (bs)this;
        parambx = (Throwable)new y("Exception in completion handler " + localObject2 + " for " + parambx, localThrowable);
        localObject2 = d.y.KTp;
        continue;
      }
      if (parambx != null)
      {
        t(parambx);
        AppMethodBeat.o(118285);
        return;
      }
      AppMethodBeat.o(118285);
      return;
    }
  }
  
  private final Object c(bj parambj, Object paramObject)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(191116);
    bx localbx = a(parambj);
    if (localbx == null)
    {
      parambj = bt.geo();
      AppMethodBeat.o(191116);
      return parambj;
    }
    label70:
    int i;
    Object localObject2;
    if (!(parambj instanceof c))
    {
      ??? = null;
      ??? = (c)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new c(localbx, null))
          {
            if (((c)???)._isCompleting != 0)
            {
              parambj = bt.gem();
              AppMethodBeat.o(191116);
              return parambj;
            }
            ((c)???)._isCompleting = 1;
            if ((??? != parambj) && (!LQI.compareAndSet(this, parambj, ???)))
            {
              parambj = bt.geo();
              AppMethodBeat.o(191116);
              return parambj;
            }
            if (!al.gdD()) {
              break;
            }
            if (!((c)???).isSealed())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              parambj = (Throwable)new AssertionError();
              AppMethodBeat.o(191116);
              throw parambj;
            }
          }
          i = 0;
        }
        boolean bool = ((c)???).geh();
        if (!(paramObject instanceof t))
        {
          localObject2 = null;
          label209:
          localObject2 = (t)localObject2;
          if (localObject2 != null) {
            ((c)???).B(((t)localObject2).cause);
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
      d.y localy = d.y.KTp;
      if (localObject2 != null) {
        a(localbx, (Throwable)localObject2);
      }
      if (!(parambj instanceof q))
      {
        localObject2 = null;
        label283:
        localObject2 = (q)localObject2;
        if (localObject2 == null)
        {
          localObject2 = parambj.gdQ();
          parambj = localObject3;
          if (localObject2 != null) {
            parambj = a((i)localObject2);
          }
          label320:
          if ((parambj != null) && (a((c)???, parambj, paramObject)))
          {
            parambj = bt.LSc;
            AppMethodBeat.o(191116);
            return parambj;
            i = 0;
          }
        }
      }
      label401:
      while (i == 0)
      {
        localObject2 = null;
        break label252;
        parambj = a((c)???, paramObject);
        AppMethodBeat.o(191116);
        return parambj;
        parambj = (bj)localObject2;
        break label320;
        localObject2 = parambj;
        break label283;
        localObject2 = paramObject;
        break label209;
        break label70;
        ??? = parambj;
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
          localObject = gdh();
        }
        localObject = (CancellationException)new bp((String)localObject, paramThrowable, (bo)this);
      }
      AppMethodBeat.o(118289);
      return localObject;
    }
  }
  
  private final Throwable fM(Object paramObject)
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
        paramObject = (Throwable)new bp(gdh(), null, (bo)this);
        AppMethodBeat.o(118298);
        return paramObject;
      }
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
      AppMethodBeat.o(118298);
      throw paramObject;
    }
    paramObject = (Throwable)((ca)paramObject).gef();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object fN(Object paramObject)
  {
    AppMethodBeat.i(191113);
    Throwable localThrowable = null;
    Object localObject2 = gee();
    int i;
    if ((localObject2 instanceof c))
    {
      try
      {
        if (((c)localObject2).isSealed())
        {
          paramObject = bt.gen();
          return paramObject;
        }
        boolean bool = ((c)localObject2).geh();
        if ((paramObject != null) || (!bool))
        {
          localObject1 = localThrowable;
          if (localThrowable == null) {
            localObject1 = fM(paramObject);
          }
          ((c)localObject2).B((Throwable)localObject1);
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
            a(((c)localObject2).LRN, paramObject);
          }
          paramObject = bt.gem();
          AppMethodBeat.o(191113);
          return paramObject;
          i = 0;
          break;
          label154:
          paramObject = null;
        }
        if (!(localObject2 instanceof bj)) {
          break label445;
        }
      }
      finally
      {
        AppMethodBeat.o(191113);
      }
    }
    else
    {
      if (localThrowable != null) {
        break label460;
      }
      localThrowable = fM(paramObject);
    }
    label445:
    label460:
    for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
    {
      if (((bj)localObject2).isActive())
      {
        localObject2 = (bj)localObject2;
        if (al.gdD())
        {
          if (!(localObject2 instanceof c)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new AssertionError();
            AppMethodBeat.o(191113);
            throw paramObject;
          }
        }
        if ((al.gdD()) && (!((bj)localObject2).isActive()))
        {
          paramObject = (Throwable)new AssertionError();
          AppMethodBeat.o(191113);
          throw paramObject;
        }
        bx localbx = a((bj)localObject2);
        if (localbx == null) {
          i = 0;
        }
        while (i != 0)
        {
          paramObject = bt.gem();
          AppMethodBeat.o(191113);
          return paramObject;
          c localc = new c(localbx, (Throwable)localObject1);
          if (!LQI.compareAndSet(this, localObject2, localc))
          {
            i = 0;
          }
          else
          {
            a(localbx, (Throwable)localObject1);
            i = 1;
          }
        }
      }
      localObject1 = U(localObject2, new t((Throwable)localObject1));
      if (localObject1 == bt.gem())
      {
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(191113);
        throw paramObject;
      }
      if (localObject1 != bt.geo())
      {
        AppMethodBeat.o(191113);
        return localObject1;
        paramObject = bt.gen();
        AppMethodBeat.o(191113);
        return paramObject;
      }
      break;
    }
  }
  
  private static Throwable fP(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof t)) {
      paramObject = null;
    }
    for (;;)
    {
      t localt = (t)paramObject;
      paramObject = localObject;
      if (localt != null) {
        paramObject = localt.cause;
      }
      return paramObject;
    }
  }
  
  private static String fQ(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).geh())
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
    if ((paramObject instanceof bj))
    {
      if (((bj)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof t))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  private final boolean z(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (geg())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    p localp = (p)this._parentHandle;
    if ((localp == null) || (localp == by.LSi))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((localp.y(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  protected boolean A(Throwable paramThrowable)
  {
    return false;
  }
  
  public final az L(b<? super Throwable, d.y> paramb)
  {
    AppMethodBeat.i(210002);
    paramb = b(false, true, paramb);
    AppMethodBeat.o(210002);
    return paramb;
  }
  
  public final p a(r paramr)
  {
    AppMethodBeat.i(118304);
    paramr = bo.a.a(this, true, false, (b)new q(this, paramr), 2);
    if (paramr == null)
    {
      paramr = new v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118304);
      throw paramr;
    }
    paramr = (p)paramr;
    AppMethodBeat.o(118304);
    return paramr;
  }
  
  public final void a(ca paramca)
  {
    AppMethodBeat.i(118295);
    fL(paramca);
    AppMethodBeat.o(118295);
  }
  
  public final az b(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, d.y> paramb)
  {
    Object localObject4 = null;
    AppMethodBeat.i(118290);
    Object localObject1 = null;
    Object localObject5 = gee();
    if ((localObject5 instanceof bb)) {
      if (((bb)localObject5).isActive)
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
      bx localbx;
      az localaz;
      if (LQI.compareAndSet(this, localObject5, localObject2))
      {
        paramb = (az)localObject2;
        AppMethodBeat.o(118290);
        return paramb;
        localObject3 = (bb)localObject5;
        localObject2 = new bx();
        if (((bb)localObject3).isActive) {}
        for (localObject2 = (bj)localObject2;; localObject2 = (bj)new bi((bx)localObject2))
        {
          LQI.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject5 instanceof bj))
        {
          localbx = ((bj)localObject5).gdQ();
          if (localbx == null)
          {
            if (localObject5 == null)
            {
              paramb = new v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118290);
              throw paramb;
            }
            a((br)localObject5);
            break;
          }
          localaz = (az)by.LSi;
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
            localObject2 = localaz;
            localObject3 = localObject1;
            if ((paramb instanceof q))
            {
              localObject2 = localaz;
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
            boolean bool = a(localObject5, localbx, (br)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (az)localObject2;
              return paramb;
            }
            localObject2 = (az)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = d.y.KTp;
          localObject1 = localObject3;
          localObject3 = localThrowable;
          if (localObject3 != null)
          {
            if (paramBoolean2) {
              paramb.ay(localObject3);
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
          if (!a(localObject5, localbx, (br)localObject2)) {
            break label530;
          }
          paramb = (az)localObject2;
          AppMethodBeat.o(118290);
          return paramb;
          if (paramBoolean2) {
            if ((localObject5 instanceof t)) {
              break label518;
            }
          }
          for (localObject1 = null;; localObject1 = localObject5)
          {
            localObject2 = (t)localObject1;
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = ((t)localObject2).cause;
            }
            paramb.ay(localObject1);
            paramb = (az)by.LSi;
            AppMethodBeat.o(118290);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localaz;
      }
    }
  }
  
  protected void fI(Object paramObject) {}
  
  final int fK(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof bb))
    {
      if (((bb)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!LQI.compareAndSet(this, paramObject, bt.gel()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      gdg();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bi))
    {
      if (!LQI.compareAndSet(this, paramObject, ((bi)paramObject).LRN))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      gdg();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  public final boolean fL(Object paramObject)
  {
    AppMethodBeat.i(191111);
    s locals = bt.gem();
    Object localObject = locals;
    if (locals == bt.gem()) {
      localObject = fN(paramObject);
    }
    if (localObject == bt.gem())
    {
      AppMethodBeat.o(191111);
      return true;
    }
    if (localObject == bt.LSc)
    {
      AppMethodBeat.o(191111);
      return true;
    }
    if (localObject == bt.gen())
    {
      AppMethodBeat.o(191111);
      return false;
    }
    fI(localObject);
    AppMethodBeat.o(191111);
    return true;
  }
  
  public final Object fO(Object paramObject)
  {
    AppMethodBeat.i(191114);
    Object localObject;
    do
    {
      localObject = U(gee(), paramObject);
      if (localObject == bt.gem())
      {
        paramObject = (Throwable)new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + paramObject, fP(paramObject));
        AppMethodBeat.o(191114);
        throw paramObject;
      }
    } while (localObject == bt.geo());
    AppMethodBeat.o(191114);
    return localObject;
  }
  
  public <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118313);
    paramR = f.b.a.a((f.b)this, paramR, paramm);
    AppMethodBeat.o(118313);
    return paramR;
  }
  
  public void gdg() {}
  
  protected String gdh()
  {
    return "Job was cancelled";
  }
  
  public String gdi()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  public final CancellationException gec()
  {
    AppMethodBeat.i(118288);
    Object localObject = gee();
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
      if ((localObject instanceof bj))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof t))
      {
        localObject = c(((t)localObject).cause, null);
        AppMethodBeat.o(118288);
        return localObject;
      }
      localObject = (CancellationException)new bp(getClass().getSimpleName() + " has completed normally", null, (bo)this);
    }
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public final void ged()
  {
    AppMethodBeat.i(191110);
    fL((Throwable)new bp(gdh(), null, (bo)this));
    AppMethodBeat.o(191110);
  }
  
  public final Object gee()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof o))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((o)localObject).fT(this);
    }
  }
  
  public final CancellationException gef()
  {
    AppMethodBeat.i(191112);
    Object localObject2 = gee();
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
        localObject1 = (CancellationException)new bp("Parent job is " + fQ(localObject2), localThrowable, (bo)this);
      }
      AppMethodBeat.o(191112);
      return localObject1;
      if ((localObject2 instanceof t))
      {
        localThrowable = ((t)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof bj))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(191112);
        throw localThrowable;
      }
      localThrowable = null;
      break;
    }
  }
  
  protected boolean geg()
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
    return (f.c)bo.LRQ;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = gee();
    if (((localObject instanceof bj)) && (((bj)localObject).isActive()))
    {
      AppMethodBeat.o(118278);
      return true;
    }
    AppMethodBeat.o(118278);
    return false;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(118315);
    paramc = f.b.a.b((f.b)this, paramc);
    AppMethodBeat.o(118315);
    return paramc;
  }
  
  public f plus(f paramf)
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
      switch (fK(gee()))
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
    String str = new StringBuilder().append(gdi()).append('{').append(fQ(gee())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
  static final class a<T>
    extends k<T>
  {
    private final bs LRT;
    
    public a(d<? super T> paramd, bs parambs)
    {
      super();
      AppMethodBeat.i(118133);
      this.LRT = parambs;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable a(bo parambo)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.LRT.gee();
      if ((localObject instanceof bs.c))
      {
        Throwable localThrowable = (Throwable)((bs.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof t))
      {
        parambo = ((t)localObject).cause;
        AppMethodBeat.o(118131);
        return parambo;
      }
      parambo = (Throwable)parambo.gec();
      AppMethodBeat.o(118131);
      return parambo;
    }
    
    protected final String gds()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends br<bo>
  {
    private final bs LRU;
    private final bs.c LRV;
    private final q LRW;
    private final Object LRX;
    
    public b(bs parambs, bs.c paramc, q paramq, Object paramObject)
    {
      super();
      AppMethodBeat.i(118262);
      this.LRU = parambs;
      this.LRV = paramc;
      this.LRW = paramq;
      this.LRX = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118261);
      String str = "ChildCompletion[" + this.LRW + ", " + this.LRX + ']';
      AppMethodBeat.o(118261);
      return str;
    }
    
    public final void u(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      bs.a(this.LRU, this.LRV, this.LRW, this.LRX);
      AppMethodBeat.o(118259);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
  static final class c
    implements bj
  {
    final bx LRN;
    volatile Object _exceptionsHolder;
    volatile int _isCompleting;
    volatile Object _rootCause;
    
    public c(bx parambx, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.LRN = parambx;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> gei()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void B(Throwable paramThrowable)
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
        ArrayList localArrayList = gei();
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
    
    public final bx gdQ()
    {
      return this.LRN;
    }
    
    public final boolean geh()
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
      if (this._exceptionsHolder == bt.gek())
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class d
    extends i.a
  {
    public d(i parami1, i parami2, bs parambs, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bs
 * JD-Core Version:    0.7.0.1
 */