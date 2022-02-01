package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l.a;
import kotlinx.coroutines.internal.r;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class ce
  implements cm, u
{
  static final AtomicReferenceFieldUpdater abwi;
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(118317);
    abwi = AtomicReferenceFieldUpdater.newUpdater(ce.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public ce(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (bh localbh = cf.iRQ();; localbh = cf.iRU())
    {
      this._state = localbh;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final boolean C(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (iQJ())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    s locals = (s)this._parentHandle;
    if ((locals == null) || (locals == ck.abxK))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((locals.B(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  private final Object Q(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(204846);
    if (!(paramObject1 instanceof bt))
    {
      paramObject1 = cf.iRR();
      AppMethodBeat.o(204846);
      return paramObject1;
    }
    if ((((paramObject1 instanceof bh)) || ((paramObject1 instanceof cd))) && (!(paramObject1 instanceof t)) && (!(paramObject2 instanceof x)))
    {
      if (a((bt)paramObject1, paramObject2))
      {
        AppMethodBeat.o(204846);
        return paramObject2;
      }
      paramObject1 = cf.iRT();
      AppMethodBeat.o(204846);
      return paramObject1;
    }
    paramObject1 = c((bt)paramObject1, paramObject2);
    AppMethodBeat.o(204846);
    return paramObject1;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(204826);
    int i;
    if (ap.iRg())
    {
      if (iRJ() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(204826);
        throw paramc;
      }
    }
    if (ap.iRg())
    {
      if (!paramc.iRL()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(204826);
        throw paramc;
      }
    }
    if ((ap.iRg()) && (paramc._isCompleting == 0))
    {
      paramc = (Throwable)new AssertionError();
      AppMethodBeat.o(204826);
      throw paramc;
    }
    if (!(paramObject instanceof x)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (x)localObject1;
      Throwable localThrowable;
      if (localObject1 != null) {
        localThrowable = ((x)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          paramc.iRM();
          localObject2 = paramc._exceptionsHolder;
          if (localObject2 == null)
          {
            localObject1 = c.iRN();
            localObject2 = (Throwable)paramc._rootCause;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((kotlin.g.b.p.h(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramc._exceptionsHolder = cf.iRP();
            localObject2 = (List)localObject1;
            localObject1 = a(paramc, (List)localObject2);
            if (localObject1 != null) {
              a((Throwable)localObject1, (List)localObject2);
            }
            if (localObject1 != null) {
              break label410;
            }
            if (localObject1 == null) {
              break label446;
            }
            if ((!C((Throwable)localObject1)) && (!F((Throwable)localObject1))) {
              break label433;
            }
            i = 1;
            if (i == 0) {
              break label446;
            }
            if (paramObject != null) {
              break label438;
            }
            paramc = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            AppMethodBeat.o(204826);
            throw paramc;
            localThrowable = null;
            break;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = c.iRN();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label377;
          }
        }
        finally
        {
          AppMethodBeat.o(204826);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label377:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(204826);
        throw paramObject;
        label410:
        if (localObject1 != localThrowable)
        {
          paramObject = new x((Throwable)localObject1);
          continue;
          label433:
          i = 0;
        }
      }
      label438:
      ((x)paramObject).iRa();
      label446:
      fS(paramObject);
      boolean bool = abwi.compareAndSet(this, paramc, cf.gk(paramObject));
      if ((ap.iRg()) && (!bool))
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(204826);
        throw paramc;
      }
      b((bt)paramc, paramObject);
      AppMethodBeat.o(204826);
      return paramObject;
    }
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.iRM())
      {
        paramc = (Throwable)new bz(iQF(), null, (by)this);
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
    if ((localObject instanceof cy))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof cy)))
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
  
  private final cd<?> a(kotlin.g.a.b<? super Throwable, kotlin.x> paramb, boolean paramBoolean)
  {
    cd localcd = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118291);
    if (paramBoolean) {
      if ((paramb instanceof ca)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (ca)localObject;
      if (localObject != null)
      {
        if (ap.iRg())
        {
          if (((ca)localObject).Gib == (ce)this) {}
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
          paramb = (cd)localObject;
          AppMethodBeat.o(118291);
          return paramb;
        }
      }
      paramb = (cd)new bw((by)this, paramb);
      AppMethodBeat.o(118291);
      return paramb;
      if (!(paramb instanceof cd)) {}
      for (localObject = localcd;; localObject = paramb)
      {
        localcd = (cd)localObject;
        if (localcd != null)
        {
          if (ap.iRg())
          {
            if ((localcd.Gib == (ce)this) && (!(localcd instanceof ca))) {}
            for (i = 1; i == 0; i = 0)
            {
              paramb = (Throwable)new AssertionError();
              AppMethodBeat.o(118291);
              throw paramb;
            }
          }
          localObject = localcd;
          if (localcd != null) {}
        }
        else
        {
          localObject = (cd)new bx((by)this, paramb);
        }
        AppMethodBeat.o(118291);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private final cj a(bt parambt)
  {
    AppMethodBeat.i(118300);
    cj localcj = parambt.iRt();
    if (localcj == null)
    {
      if ((parambt instanceof bh))
      {
        parambt = new cj();
        AppMethodBeat.o(118300);
        return parambt;
      }
      if ((parambt instanceof cd))
      {
        a((cd)parambt);
        AppMethodBeat.o(118300);
        return null;
      }
      parambt = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(parambt)).toString());
      AppMethodBeat.o(118300);
      throw parambt;
    }
    AppMethodBeat.o(118300);
    return localcj;
  }
  
  private static t a(kotlinx.coroutines.internal.l paraml)
  {
    AppMethodBeat.i(118303);
    while (paraml.isRemoved()) {
      paraml = paraml.iSN();
    }
    kotlinx.coroutines.internal.l locall;
    do
    {
      do
      {
        locall = k.gx(paraml.iSL());
        paraml = locall;
      } while (locall.isRemoved());
      if ((locall instanceof t))
      {
        paraml = (t)locall;
        AppMethodBeat.o(118303);
        return paraml;
      }
      paraml = locall;
    } while (!(locall instanceof cj));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private static void a(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(204827);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(204827);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!ap.iRh())
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
      if (!ap.iRh()) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        kotlin.a.a(paramThrowable, paramList);
        break label59;
        localThrowable = kotlinx.coroutines.internal.u.M(paramThrowable);
        break;
        paramList = kotlinx.coroutines.internal.u.M(paramList);
      }
    }
    label137:
    AppMethodBeat.o(204827);
  }
  
  private final void a(cd<?> paramcd)
  {
    AppMethodBeat.i(118293);
    paramcd.c((kotlinx.coroutines.internal.l)new cj());
    kotlinx.coroutines.internal.l locall = k.gx(paramcd.iSL());
    abwi.compareAndSet(this, paramcd, locall);
    AppMethodBeat.o(118293);
  }
  
  private final void a(cj paramcj, Throwable paramThrowable)
  {
    AppMethodBeat.i(118284);
    Object localObject1 = null;
    j localj = (j)paramcj;
    paramcj = localj.iSL();
    if (paramcj == null)
    {
      paramcj = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118284);
      throw paramcj;
    }
    Object localObject2 = (kotlinx.coroutines.internal.l)paramcj;
    paramcj = (cj)localObject1;
    localObject1 = localObject2;
    if ((kotlin.g.b.p.h(localObject1, localj) ^ true))
    {
      if (!(localObject1 instanceof ca)) {
        break label184;
      }
      localObject2 = (cd)localObject1;
    }
    label184:
    for (;;)
    {
      try
      {
        ((cd)localObject2).y(paramThrowable);
        localObject1 = ((kotlinx.coroutines.internal.l)localObject1).iSM();
      }
      catch (Throwable localThrowable)
      {
        if (paramcj != null)
        {
          kotlin.a.a(paramcj, localThrowable);
          if (paramcj != null) {
            break label184;
          }
        }
        paramcj = (ce)this;
        paramcj = (Throwable)new ac("Exception in completion handler " + localObject2 + " for " + paramcj, localThrowable);
        localObject2 = kotlin.x.aazN;
        continue;
      }
      if (paramcj != null) {
        x(paramcj);
      }
      C(paramThrowable);
      AppMethodBeat.o(118284);
      return;
    }
  }
  
  private final boolean a(final Object paramObject, cj paramcj, cd<?> paramcd)
  {
    AppMethodBeat.i(118292);
    paramcj = (kotlinx.coroutines.internal.l)paramcj;
    paramObject = (l.a)new d((kotlinx.coroutines.internal.l)paramcd, (kotlinx.coroutines.internal.l)paramcd, this, paramObject);
    for (;;)
    {
      switch (paramcj.iSN().a((kotlinx.coroutines.internal.l)paramcd, paramcj, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(bt parambt, Object paramObject)
  {
    AppMethodBeat.i(204828);
    int i;
    if (ap.iRg())
    {
      if (((parambt instanceof bh)) || ((parambt instanceof cd))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambt = (Throwable)new AssertionError();
        AppMethodBeat.o(204828);
        throw parambt;
      }
    }
    if (ap.iRg())
    {
      if (!(paramObject instanceof x)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambt = (Throwable)new AssertionError();
        AppMethodBeat.o(204828);
        throw parambt;
      }
    }
    if (!abwi.compareAndSet(this, parambt, cf.gk(paramObject)))
    {
      AppMethodBeat.o(204828);
      return false;
    }
    fS(paramObject);
    b(parambt, paramObject);
    AppMethodBeat.o(204828);
    return true;
  }
  
  private final boolean a(c paramc, t paramt, Object paramObject)
  {
    AppMethodBeat.i(118302);
    t localt;
    do
    {
      if (by.a.a(paramt.abwm, false, false, (kotlin.g.a.b)new b(this, paramc, paramt, paramObject), 1) != ck.abxK)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localt = a((kotlinx.coroutines.internal.l)paramt);
      paramt = localt;
    } while (localt != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private final void b(bt parambt, Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(204829);
    Object localObject2 = (s)this._parentHandle;
    if (localObject2 != null)
    {
      ((s)localObject2).dispose();
      this._parentHandle = ((s)ck.abxK);
    }
    if (!(paramObject instanceof x)) {
      paramObject = null;
    }
    for (;;)
    {
      localObject2 = (x)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((x)localObject2).cause;
      }
      if ((parambt instanceof cd)) {
        try
        {
          ((cd)parambt).y(paramObject);
          AppMethodBeat.o(204829);
          return;
        }
        catch (Throwable paramObject)
        {
          x((Throwable)new ac("Exception in completion handler " + parambt + " for " + this, paramObject));
          AppMethodBeat.o(204829);
          return;
        }
      }
      parambt = parambt.iRt();
      if (parambt != null)
      {
        b(parambt, paramObject);
        AppMethodBeat.o(204829);
        return;
      }
      AppMethodBeat.o(204829);
      return;
    }
  }
  
  private final void b(cj paramcj, Throwable paramThrowable)
  {
    AppMethodBeat.i(118285);
    Object localObject1 = null;
    j localj = (j)paramcj;
    paramcj = localj.iSL();
    if (paramcj == null)
    {
      paramcj = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118285);
      throw paramcj;
    }
    Object localObject2 = (kotlinx.coroutines.internal.l)paramcj;
    paramcj = (cj)localObject1;
    localObject1 = localObject2;
    if ((kotlin.g.b.p.h(localObject1, localj) ^ true))
    {
      if (!(localObject1 instanceof cd)) {
        break label185;
      }
      localObject2 = (cd)localObject1;
    }
    label185:
    for (;;)
    {
      try
      {
        ((cd)localObject2).y(paramThrowable);
        localObject1 = ((kotlinx.coroutines.internal.l)localObject1).iSM();
      }
      catch (Throwable localThrowable)
      {
        if (paramcj != null)
        {
          kotlin.a.a(paramcj, localThrowable);
          if (paramcj != null) {
            break label185;
          }
        }
        paramcj = (ce)this;
        paramcj = (Throwable)new ac("Exception in completion handler " + localObject2 + " for " + paramcj, localThrowable);
        localObject2 = kotlin.x.aazN;
        continue;
      }
      if (paramcj != null)
      {
        x(paramcj);
        AppMethodBeat.o(118285);
        return;
      }
      AppMethodBeat.o(118285);
      return;
    }
  }
  
  private final Object c(bt parambt, Object paramObject)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(204847);
    cj localcj = a(parambt);
    if (localcj == null)
    {
      parambt = cf.iRT();
      AppMethodBeat.o(204847);
      return parambt;
    }
    label70:
    int i;
    Object localObject2;
    if (!(parambt instanceof c))
    {
      ??? = null;
      ??? = (c)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new c(localcj, null))
          {
            if (((c)???)._isCompleting != 0)
            {
              parambt = cf.iRR();
              AppMethodBeat.o(204847);
              return parambt;
            }
            ((c)???)._isCompleting = 1;
            if ((??? != parambt) && (!abwi.compareAndSet(this, parambt, ???)))
            {
              parambt = cf.iRT();
              AppMethodBeat.o(204847);
              return parambt;
            }
            if (!ap.iRg()) {
              break;
            }
            if (!((c)???).iRL())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              parambt = (Throwable)new AssertionError();
              AppMethodBeat.o(204847);
              throw parambt;
            }
          }
          i = 0;
        }
        boolean bool = ((c)???).iRM();
        if (!(paramObject instanceof x))
        {
          localObject2 = null;
          label209:
          localObject2 = (x)localObject2;
          if (localObject2 != null) {
            ((c)???).G(((x)localObject2).cause);
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
      kotlin.x localx = kotlin.x.aazN;
      if (localObject2 != null) {
        a(localcj, (Throwable)localObject2);
      }
      if (!(parambt instanceof t))
      {
        localObject2 = null;
        label283:
        localObject2 = (t)localObject2;
        if (localObject2 == null)
        {
          localObject2 = parambt.iRt();
          parambt = localObject3;
          if (localObject2 != null) {
            parambt = a((kotlinx.coroutines.internal.l)localObject2);
          }
          label320:
          if ((parambt != null) && (a((c)???, parambt, paramObject)))
          {
            parambt = cf.abxE;
            AppMethodBeat.o(204847);
            return parambt;
            i = 0;
          }
        }
      }
      label401:
      while (i == 0)
      {
        localObject2 = null;
        break label252;
        parambt = a((c)???, paramObject);
        AppMethodBeat.o(204847);
        return parambt;
        parambt = (bt)localObject2;
        break label320;
        localObject2 = parambt;
        break label283;
        localObject2 = paramObject;
        break label209;
        break label70;
        ??? = parambt;
        break;
      }
    }
  }
  
  private CancellationException d(Throwable paramThrowable, String paramString)
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
          localObject = iQF();
        }
        localObject = (CancellationException)new bz((String)localObject, paramThrowable, (by)this);
      }
      AppMethodBeat.o(118289);
      return localObject;
    }
  }
  
  private final int gd(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof bh))
    {
      if (((bh)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!abwi.compareAndSet(this, paramObject, cf.iRQ()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      iQD();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bs))
    {
      if (!abwi.compareAndSet(this, paramObject, ((bs)paramObject).abxp))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      iQD();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  private boolean ge(Object paramObject)
  {
    AppMethodBeat.i(204839);
    Object localObject1 = cf.iRR();
    if (iRG())
    {
      localObject2 = gf(paramObject);
      localObject1 = localObject2;
      if (localObject2 == cf.abxE)
      {
        AppMethodBeat.o(204839);
        return true;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == cf.iRR()) {
      localObject2 = gh(paramObject);
    }
    if (localObject2 == cf.iRR())
    {
      AppMethodBeat.o(204839);
      return true;
    }
    if (localObject2 == cf.abxE)
    {
      AppMethodBeat.o(204839);
      return true;
    }
    if (localObject2 == cf.iRS())
    {
      AppMethodBeat.o(204839);
      return false;
    }
    fU(localObject2);
    AppMethodBeat.o(204839);
    return true;
  }
  
  private final Object gf(Object paramObject)
  {
    AppMethodBeat.i(204840);
    Object localObject;
    do
    {
      localObject = iRJ();
      if ((!(localObject instanceof bt)) || (((localObject instanceof c)) && (((c)localObject)._isCompleting != 0)))
      {
        paramObject = cf.iRR();
        AppMethodBeat.o(204840);
        return paramObject;
      }
      localObject = Q(localObject, new x(gg(paramObject)));
    } while (localObject == cf.iRT());
    AppMethodBeat.o(204840);
    return localObject;
  }
  
  private final Throwable gg(Object paramObject)
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
        paramObject = (Throwable)new bz(iQF(), null, (by)this);
        AppMethodBeat.o(118298);
        return paramObject;
      }
    }
    if (paramObject == null)
    {
      paramObject = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
      AppMethodBeat.o(118298);
      throw paramObject;
    }
    paramObject = (Throwable)((cm)paramObject).iRK();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object gh(Object paramObject)
  {
    AppMethodBeat.i(204843);
    Throwable localThrowable = null;
    Object localObject2 = iRJ();
    int i;
    if ((localObject2 instanceof c))
    {
      try
      {
        if (((c)localObject2).iRL())
        {
          paramObject = cf.iRS();
          return paramObject;
        }
        boolean bool = ((c)localObject2).iRM();
        if ((paramObject != null) || (!bool))
        {
          localObject1 = localThrowable;
          if (localThrowable == null) {
            localObject1 = gg(paramObject);
          }
          ((c)localObject2).G((Throwable)localObject1);
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
            a(((c)localObject2).abxp, paramObject);
          }
          paramObject = cf.iRR();
          AppMethodBeat.o(204843);
          return paramObject;
          i = 0;
          break;
          label154:
          paramObject = null;
        }
        if (!(localObject2 instanceof bt)) {
          break label445;
        }
      }
      finally
      {
        AppMethodBeat.o(204843);
      }
    }
    else
    {
      if (localThrowable != null) {
        break label460;
      }
      localThrowable = gg(paramObject);
    }
    label445:
    label460:
    for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
    {
      if (((bt)localObject2).isActive())
      {
        localObject2 = (bt)localObject2;
        if (ap.iRg())
        {
          if (!(localObject2 instanceof c)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new AssertionError();
            AppMethodBeat.o(204843);
            throw paramObject;
          }
        }
        if ((ap.iRg()) && (!((bt)localObject2).isActive()))
        {
          paramObject = (Throwable)new AssertionError();
          AppMethodBeat.o(204843);
          throw paramObject;
        }
        cj localcj = a((bt)localObject2);
        if (localcj == null) {
          i = 0;
        }
        while (i != 0)
        {
          paramObject = cf.iRR();
          AppMethodBeat.o(204843);
          return paramObject;
          c localc = new c(localcj, (Throwable)localObject1);
          if (!abwi.compareAndSet(this, localObject2, localc))
          {
            i = 0;
          }
          else
          {
            a(localcj, (Throwable)localObject1);
            i = 1;
          }
        }
      }
      localObject1 = Q(localObject2, new x((Throwable)localObject1));
      if (localObject1 == cf.iRR())
      {
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(204843);
        throw paramObject;
      }
      if (localObject1 != cf.iRT())
      {
        AppMethodBeat.o(204843);
        return localObject1;
        paramObject = cf.iRS();
        AppMethodBeat.o(204843);
        return paramObject;
      }
      break;
    }
  }
  
  private static String gj(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).iRM())
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
    if ((paramObject instanceof bt))
    {
      if (((bt)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof x))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  public boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(204837);
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(204837);
      return true;
    }
    if ((ge(paramThrowable)) && (iRH()))
    {
      AppMethodBeat.o(204837);
      return true;
    }
    AppMethodBeat.o(204837);
    return false;
  }
  
  public void D(Throwable paramThrowable)
  {
    AppMethodBeat.i(204836);
    ge(paramThrowable);
    AppMethodBeat.o(204836);
  }
  
  public final boolean E(Throwable paramThrowable)
  {
    AppMethodBeat.i(204838);
    boolean bool = ge(paramThrowable);
    AppMethodBeat.o(204838);
    return bool;
  }
  
  protected boolean F(Throwable paramThrowable)
  {
    return false;
  }
  
  public final be a(boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super Throwable, kotlin.x> paramb)
  {
    Object localObject4 = null;
    AppMethodBeat.i(118290);
    Object localObject1 = null;
    Object localObject5 = iRJ();
    if ((localObject5 instanceof bh)) {
      if (((bh)localObject5).isActive)
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
      cj localcj;
      be localbe;
      if (abwi.compareAndSet(this, localObject5, localObject2))
      {
        paramb = (be)localObject2;
        AppMethodBeat.o(118290);
        return paramb;
        localObject3 = (bh)localObject5;
        localObject2 = new cj();
        if (((bh)localObject3).isActive) {}
        for (localObject2 = (bt)localObject2;; localObject2 = (bt)new bs((cj)localObject2))
        {
          abwi.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject5 instanceof bt))
        {
          localcj = ((bt)localObject5).iRt();
          if (localcj == null)
          {
            if (localObject5 == null)
            {
              paramb = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118290);
              throw paramb;
            }
            a((cd)localObject5);
            break;
          }
          localbe = (be)ck.abxK;
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
            localObject2 = localbe;
            localObject3 = localObject1;
            if ((paramb instanceof t))
            {
              localObject2 = localbe;
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
            boolean bool = a(localObject5, localcj, (cd)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (be)localObject2;
              return paramb;
            }
            localObject2 = (be)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = kotlin.x.aazN;
          localObject1 = localObject3;
          localObject3 = localThrowable;
          if (localObject3 != null)
          {
            if (paramBoolean2) {
              paramb.invoke(localObject3);
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
          if (!a(localObject5, localcj, (cd)localObject2)) {
            break label530;
          }
          paramb = (be)localObject2;
          AppMethodBeat.o(118290);
          return paramb;
          if (paramBoolean2) {
            if ((localObject5 instanceof x)) {
              break label518;
            }
          }
          for (localObject1 = null;; localObject1 = localObject5)
          {
            localObject2 = (x)localObject1;
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = ((x)localObject2).cause;
            }
            paramb.invoke(localObject1);
            paramb = (be)ck.abxK;
            AppMethodBeat.o(118290);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localbe;
      }
    }
  }
  
  public final s a(u paramu)
  {
    AppMethodBeat.i(118304);
    paramu = by.a.a(this, true, false, (kotlin.g.a.b)new t(this, paramu), 2);
    if (paramu == null)
    {
      paramu = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118304);
      throw paramu;
    }
    paramu = (s)paramu;
    AppMethodBeat.o(118304);
    return paramu;
  }
  
  public void a(CancellationException paramCancellationException)
  {
    AppMethodBeat.i(204835);
    if (paramCancellationException != null) {}
    for (paramCancellationException = (Throwable)paramCancellationException;; paramCancellationException = (Throwable)new bz(iQF(), null, (by)this))
    {
      D(paramCancellationException);
      AppMethodBeat.o(204835);
      return;
    }
  }
  
  public final void a(cm paramcm)
  {
    AppMethodBeat.i(118295);
    ge(paramcm);
    AppMethodBeat.o(118295);
  }
  
  public final be an(kotlin.g.a.b<? super Throwable, kotlin.x> paramb)
  {
    AppMethodBeat.i(204832);
    paramb = a(false, true, paramb);
    AppMethodBeat.o(204832);
    return paramb;
  }
  
  public final void c(by paramby)
  {
    AppMethodBeat.i(204822);
    if (ap.iRg())
    {
      if ((s)this._parentHandle == null) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramby = (Throwable)new AssertionError();
        AppMethodBeat.o(204822);
        throw paramby;
      }
    }
    if (paramby == null)
    {
      this._parentHandle = ((s)ck.abxK);
      AppMethodBeat.o(204822);
      return;
    }
    paramby.start();
    paramby = paramby.a((u)this);
    this._parentHandle = paramby;
    if (isCompleted())
    {
      paramby.dispose();
      this._parentHandle = ((s)ck.abxK);
    }
    AppMethodBeat.o(204822);
  }
  
  protected void fS(Object paramObject) {}
  
  protected void fU(Object paramObject) {}
  
  public <R> R fold(R paramR, kotlin.g.a.m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118313);
    paramR = f.b.a.a((f.b)this, paramR, paramm);
    AppMethodBeat.o(118313);
    return paramR;
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
    return (f.c)by.abxs;
  }
  
  public final Object gi(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(204845);
    Object localObject2 = Q(iRJ(), paramObject);
    if (localObject2 == cf.iRR())
    {
      localObject2 = "Job " + this + " is already complete or completing, but is being completed with " + paramObject;
      if ((paramObject instanceof x)) {
        break label117;
      }
      paramObject = null;
    }
    label117:
    for (;;)
    {
      x localx = (x)paramObject;
      paramObject = localObject1;
      if (localx != null) {
        paramObject = localx.cause;
      }
      paramObject = (Throwable)new IllegalStateException((String)localObject2, paramObject);
      AppMethodBeat.o(204845);
      throw paramObject;
      if (localObject2 == cf.iRT()) {
        break;
      }
      AppMethodBeat.o(204845);
      return localObject2;
    }
  }
  
  public void iQD() {}
  
  protected String iQF()
  {
    return "Job was cancelled";
  }
  
  public String iQG()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  protected boolean iQJ()
  {
    return false;
  }
  
  public final CancellationException iRF()
  {
    AppMethodBeat.i(118288);
    Object localObject = iRJ();
    if ((localObject instanceof c))
    {
      localObject = (Throwable)((c)localObject)._rootCause;
      if (localObject != null)
      {
        CancellationException localCancellationException = d((Throwable)localObject, getClass().getSimpleName() + " is cancelling");
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
      if ((localObject instanceof bt))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof x))
      {
        localObject = d(((x)localObject).cause, null);
        AppMethodBeat.o(118288);
        return localObject;
      }
      localObject = (CancellationException)new bz(getClass().getSimpleName() + " has completed normally", null, (by)this);
    }
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public boolean iRG()
  {
    return false;
  }
  
  public boolean iRH()
  {
    return true;
  }
  
  public final s iRI()
  {
    return (s)this._parentHandle;
  }
  
  public final Object iRJ()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof r))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((r)localObject).gw(this);
    }
  }
  
  public final CancellationException iRK()
  {
    AppMethodBeat.i(204841);
    Object localObject2 = iRJ();
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
        localObject1 = (CancellationException)new bz("Parent job is " + gj(localObject2), localThrowable, (by)this);
      }
      AppMethodBeat.o(204841);
      return localObject1;
      if ((localObject2 instanceof x))
      {
        localThrowable = ((x)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof bt))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(204841);
        throw localThrowable;
      }
      localThrowable = null;
      break;
    }
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = iRJ();
    if (((localObject instanceof bt)) && (((bt)localObject).isActive()))
    {
      AppMethodBeat.o(118278);
      return true;
    }
    AppMethodBeat.o(118278);
    return false;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(204823);
    if (!(iRJ() instanceof bt))
    {
      AppMethodBeat.o(204823);
      return true;
    }
    AppMethodBeat.o(204823);
    return false;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(118315);
    paramc = f.b.a.b((f.b)this, paramc);
    AppMethodBeat.o(118315);
    return paramc;
  }
  
  public final Object o(d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(204834);
    Object localObject = iRJ();
    if (!(localObject instanceof bt)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label58;
      }
      de.e(paramd.getContext());
      paramd = kotlin.x.aazN;
      AppMethodBeat.o(204834);
      return paramd;
      if (gd(localObject) < 0) {
        break;
      }
    }
    label58:
    localObject = new n(kotlin.d.a.b.k(paramd), 1);
    ((n)localObject).iQM();
    m localm = (m)localObject;
    p.a(localm, a(false, true, (kotlin.g.a.b)new cp((by)this, (d)localm)));
    localObject = ((n)localObject).getResult();
    if (localObject == kotlin.d.a.a.aaAA) {
      kotlin.g.b.p.k(paramd, "frame");
    }
    if (localObject == kotlin.d.a.a.aaAA)
    {
      AppMethodBeat.o(204834);
      return localObject;
    }
    paramd = kotlin.x.aazN;
    AppMethodBeat.o(204834);
    return paramd;
  }
  
  public final Object p(d<Object> paramd)
  {
    AppMethodBeat.i(204850);
    do
    {
      localObject = iRJ();
      if (!(localObject instanceof bt))
      {
        if ((localObject instanceof x))
        {
          localObject = ((x)localObject).cause;
          if (!ap.iRh())
          {
            AppMethodBeat.o(204850);
            throw ((Throwable)localObject);
          }
          if (!(paramd instanceof e))
          {
            AppMethodBeat.o(204850);
            throw ((Throwable)localObject);
          }
          paramd = kotlinx.coroutines.internal.u.a((Throwable)localObject, (e)paramd);
          AppMethodBeat.o(204850);
          throw paramd;
        }
        paramd = cf.gl(localObject);
        AppMethodBeat.o(204850);
        return paramd;
      }
    } while (gd(localObject) < 0);
    Object localObject = new a(kotlin.d.a.b.k(paramd), this);
    p.a((m)localObject, a(false, true, (kotlin.g.a.b)new co(this, (n)localObject)));
    localObject = ((a)localObject).getResult();
    if (localObject == kotlin.d.a.a.aaAA) {
      kotlin.g.b.p.k(paramd, "frame");
    }
    AppMethodBeat.o(204850);
    return localObject;
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
      switch (gd(iRJ()))
      {
      }
    }
    AppMethodBeat.o(118286);
    return false;
    AppMethodBeat.o(118286);
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118308);
    String str = new StringBuilder().append(iQG()).append('{').append(gj(iRJ())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  public void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118305);
    AppMethodBeat.o(118305);
    throw paramThrowable;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
  static final class a<T>
    extends n<T>
  {
    private final ce abxv;
    
    public a(d<? super T> paramd, ce paramce)
    {
      super(1);
      AppMethodBeat.i(118133);
      this.abxv = paramce;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable a(by paramby)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.abxv.iRJ();
      if ((localObject instanceof ce.c))
      {
        Throwable localThrowable = (Throwable)((ce.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof x))
      {
        paramby = ((x)localObject).cause;
        AppMethodBeat.o(118131);
        return paramby;
      }
      paramby = (Throwable)paramby.iRF();
      AppMethodBeat.o(118131);
      return paramby;
    }
    
    protected final String iQT()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends cd<by>
  {
    private final ce abxw;
    private final ce.c abxx;
    private final t abxy;
    private final Object abxz;
    
    public b(ce paramce, ce.c paramc, t paramt, Object paramObject)
    {
      super();
      AppMethodBeat.i(118262);
      this.abxw = paramce;
      this.abxx = paramc;
      this.abxy = paramt;
      this.abxz = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118261);
      String str = "ChildCompletion[" + this.abxy + ", " + this.abxz + ']';
      AppMethodBeat.o(118261);
      return str;
    }
    
    public final void y(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      ce.a(this.abxw, this.abxx, this.abxy, this.abxz);
      AppMethodBeat.o(118259);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
  static final class c
    implements bt
  {
    volatile Object _exceptionsHolder;
    volatile int _isCompleting;
    volatile Object _rootCause;
    final cj abxp;
    
    public c(cj paramcj, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.abxp = paramcj;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> iRN()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void G(Throwable paramThrowable)
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
        ArrayList localArrayList = iRN();
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
    
    public final boolean iRL()
    {
      AppMethodBeat.i(118221);
      if (this._exceptionsHolder == cf.iRP())
      {
        AppMethodBeat.o(118221);
        return true;
      }
      AppMethodBeat.o(118221);
      return false;
    }
    
    public final boolean iRM()
    {
      return (Throwable)this._rootCause != null;
    }
    
    public final cj iRt()
    {
      return this.abxp;
    }
    
    public final boolean isActive()
    {
      return (Throwable)this._rootCause == null;
    }
    
    public final String toString()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class d
    extends l.a
  {
    public d(kotlinx.coroutines.internal.l paraml1, kotlinx.coroutines.internal.l paraml2, ce paramce, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ce
 * JD-Core Version:    0.7.0.1
 */