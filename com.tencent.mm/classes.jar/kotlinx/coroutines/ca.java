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
import kotlin.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.k.a;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class ca
  implements bu, ci, s
{
  static final AtomicReferenceFieldUpdater TTD;
  volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(118317);
    TTD = AtomicReferenceFieldUpdater.newUpdater(ca.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public ca(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (bf localbf = cb.hNt();; localbf = cb.hNx())
    {
      this._state = localbf;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final boolean C(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (hNo())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    q localq = (q)this._parentHandle;
    if ((localq == null) || (localq == cg.TVh))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((localq.B(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  private final Object Y(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(192350);
    if (!(paramObject1 instanceof bp))
    {
      paramObject1 = cb.hNu();
      AppMethodBeat.o(192350);
      return paramObject1;
    }
    if ((((paramObject1 instanceof bf)) || ((paramObject1 instanceof bz))) && (!(paramObject1 instanceof r)) && (!(paramObject2 instanceof v)))
    {
      if (a((bp)paramObject1, paramObject2))
      {
        AppMethodBeat.o(192350);
        return paramObject2;
      }
      paramObject1 = cb.hNw();
      AppMethodBeat.o(192350);
      return paramObject1;
    }
    paramObject1 = c((bp)paramObject1, paramObject2);
    AppMethodBeat.o(192350);
    return paramObject1;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(192337);
    int i;
    if (an.hMK())
    {
      if (hNm() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(192337);
        throw paramc;
      }
    }
    if (an.hMK())
    {
      if (!paramc.isSealed()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(192337);
        throw paramc;
      }
    }
    if ((an.hMK()) && (paramc._isCompleting == 0))
    {
      paramc = (Throwable)new AssertionError();
      AppMethodBeat.o(192337);
      throw paramc;
    }
    if (!(paramObject instanceof v)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (v)localObject1;
      Throwable localThrowable;
      if (localObject1 != null) {
        localThrowable = ((v)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = paramc._exceptionsHolder;
          if (localObject2 == null)
          {
            localObject1 = c.hNq();
            localObject2 = (Throwable)paramc._rootCause;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((p.j(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramc._exceptionsHolder = cb.hNs();
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
            if ((!C((Throwable)localObject1)) && (!E((Throwable)localObject1))) {
              break label428;
            }
            i = 1;
            if (i == 0) {
              break label441;
            }
            if (paramObject != null) {
              break label433;
            }
            paramc = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            AppMethodBeat.o(192337);
            throw paramc;
            localThrowable = null;
            break;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = c.hNq();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label372;
          }
        }
        finally
        {
          AppMethodBeat.o(192337);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label372:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(192337);
        throw paramObject;
        label405:
        if (localObject1 != localThrowable)
        {
          paramObject = new v((Throwable)localObject1);
          continue;
          label428:
          i = 0;
        }
      }
      label433:
      ((v)paramObject).hME();
      label441:
      boolean bool = TTD.compareAndSet(this, paramc, cb.gc(paramObject));
      if ((an.hMK()) && (!bool))
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(192337);
        throw paramc;
      }
      b((bp)paramc, paramObject);
      AppMethodBeat.o(192337);
      return paramObject;
    }
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.hNp())
      {
        paramc = (Throwable)new bv(hMn(), null, (bu)this);
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
    if ((localObject instanceof cs))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof cs)))
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
  
  private final bz<?> a(b<? super Throwable, x> paramb, boolean paramBoolean)
  {
    bz localbz = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118291);
    if (paramBoolean) {
      if ((paramb instanceof bw)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (bw)localObject;
      if (localObject != null)
      {
        if (an.hMK())
        {
          if (((bw)localObject).TUQ == (ca)this) {}
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
          paramb = (bz)localObject;
          AppMethodBeat.o(118291);
          return paramb;
        }
      }
      paramb = (bz)new bs((bu)this, paramb);
      AppMethodBeat.o(118291);
      return paramb;
      if (!(paramb instanceof bz)) {}
      for (localObject = localbz;; localObject = paramb)
      {
        localbz = (bz)localObject;
        if (localbz != null)
        {
          if (an.hMK())
          {
            if ((localbz.TUQ == (ca)this) && (!(localbz instanceof bw))) {}
            for (i = 1; i == 0; i = 0)
            {
              paramb = (Throwable)new AssertionError();
              AppMethodBeat.o(118291);
              throw paramb;
            }
          }
          localObject = localbz;
          if (localbz != null) {}
        }
        else
        {
          localObject = (bz)new bt((bu)this, paramb);
        }
        AppMethodBeat.o(118291);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private final cf a(bp parambp)
  {
    AppMethodBeat.i(118300);
    cf localcf = parambp.hMX();
    if (localcf == null)
    {
      if ((parambp instanceof bf))
      {
        parambp = new cf();
        AppMethodBeat.o(118300);
        return parambp;
      }
      if ((parambp instanceof bz))
      {
        a((bz)parambp);
        AppMethodBeat.o(118300);
        return null;
      }
      parambp = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(parambp)).toString());
      AppMethodBeat.o(118300);
      throw parambp;
    }
    AppMethodBeat.o(118300);
    return localcf;
  }
  
  private static r a(k paramk)
  {
    AppMethodBeat.i(118303);
    while (paramk.isRemoved()) {
      paramk = paramk.hNK();
    }
    k localk;
    do
    {
      do
      {
        localk = j.gf(paramk.hNI());
        paramk = localk;
      } while (localk.isRemoved());
      if ((localk instanceof r))
      {
        paramk = (r)localk;
        AppMethodBeat.o(118303);
        return paramk;
      }
      paramk = localk;
    } while (!(localk instanceof cf));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private final void a(bz<?> parambz)
  {
    AppMethodBeat.i(118293);
    parambz.c((k)new cf());
    k localk = j.gf(parambz.hNI());
    TTD.compareAndSet(this, parambz, localk);
    AppMethodBeat.o(118293);
  }
  
  private final void a(cf paramcf, Throwable paramThrowable)
  {
    AppMethodBeat.i(118284);
    Object localObject1 = null;
    i locali = (i)paramcf;
    paramcf = locali.hNI();
    if (paramcf == null)
    {
      paramcf = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118284);
      throw paramcf;
    }
    Object localObject2 = (k)paramcf;
    paramcf = (cf)localObject1;
    localObject1 = localObject2;
    if ((p.j(localObject1, locali) ^ true))
    {
      if (!(localObject1 instanceof bw)) {
        break label184;
      }
      localObject2 = (bz)localObject1;
    }
    label184:
    for (;;)
    {
      try
      {
        ((bz)localObject2).y(paramThrowable);
        localObject1 = ((k)localObject1).hNJ();
      }
      catch (Throwable localThrowable)
      {
        if (paramcf != null)
        {
          a.a(paramcf, localThrowable);
          if (paramcf != null) {
            break label184;
          }
        }
        paramcf = (ca)this;
        paramcf = (Throwable)new aa("Exception in completion handler " + localObject2 + " for " + paramcf, localThrowable);
        localObject2 = x.SXb;
        continue;
      }
      if (paramcf != null) {
        x(paramcf);
      }
      C(paramThrowable);
      AppMethodBeat.o(118284);
      return;
    }
  }
  
  private final boolean a(final Object paramObject, cf paramcf, bz<?> parambz)
  {
    AppMethodBeat.i(118292);
    paramcf = (k)paramcf;
    paramObject = (k.a)new d((k)parambz, (k)parambz, this, paramObject);
    for (;;)
    {
      switch (paramcf.hNK().a((k)parambz, paramcf, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(bp parambp, Object paramObject)
  {
    AppMethodBeat.i(192339);
    int i;
    if (an.hMK())
    {
      if (((parambp instanceof bf)) || ((parambp instanceof bz))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambp = (Throwable)new AssertionError();
        AppMethodBeat.o(192339);
        throw parambp;
      }
    }
    if (an.hMK())
    {
      if (!(paramObject instanceof v)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambp = (Throwable)new AssertionError();
        AppMethodBeat.o(192339);
        throw parambp;
      }
    }
    if (!TTD.compareAndSet(this, parambp, cb.gc(paramObject)))
    {
      AppMethodBeat.o(192339);
      return false;
    }
    b(parambp, paramObject);
    AppMethodBeat.o(192339);
    return true;
  }
  
  private final boolean a(c paramc, r paramr, Object paramObject)
  {
    AppMethodBeat.i(118302);
    r localr;
    do
    {
      if (bu.a.a(paramr.TTH, false, false, (b)new b(this, paramc, paramr, paramObject), 1) != cg.TVh)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localr = a((k)paramr);
      paramr = localr;
    } while (localr != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private static void b(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(192338);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(192338);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!an.hML())
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
      if (!an.hML()) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        a.a(paramThrowable, paramList);
        break label59;
        localThrowable = kotlinx.coroutines.internal.t.I(paramThrowable);
        break;
        paramList = kotlinx.coroutines.internal.t.I(paramList);
      }
    }
    label137:
    AppMethodBeat.o(192338);
  }
  
  private final void b(bp parambp, Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(192340);
    Object localObject2 = (q)this._parentHandle;
    if (localObject2 != null)
    {
      ((q)localObject2).dispose();
      this._parentHandle = ((q)cg.TVh);
    }
    if (!(paramObject instanceof v)) {
      paramObject = null;
    }
    for (;;)
    {
      localObject2 = (v)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((v)localObject2).cause;
      }
      if ((parambp instanceof bz)) {
        try
        {
          ((bz)parambp).y(paramObject);
          AppMethodBeat.o(192340);
          return;
        }
        catch (Throwable paramObject)
        {
          x((Throwable)new aa("Exception in completion handler " + parambp + " for " + this, paramObject));
          AppMethodBeat.o(192340);
          return;
        }
      }
      parambp = parambp.hMX();
      if (parambp != null)
      {
        b(parambp, paramObject);
        AppMethodBeat.o(192340);
        return;
      }
      AppMethodBeat.o(192340);
      return;
    }
  }
  
  private final void b(cf paramcf, Throwable paramThrowable)
  {
    AppMethodBeat.i(118285);
    Object localObject1 = null;
    i locali = (i)paramcf;
    paramcf = locali.hNI();
    if (paramcf == null)
    {
      paramcf = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118285);
      throw paramcf;
    }
    Object localObject2 = (k)paramcf;
    paramcf = (cf)localObject1;
    localObject1 = localObject2;
    if ((p.j(localObject1, locali) ^ true))
    {
      if (!(localObject1 instanceof bz)) {
        break label185;
      }
      localObject2 = (bz)localObject1;
    }
    label185:
    for (;;)
    {
      try
      {
        ((bz)localObject2).y(paramThrowable);
        localObject1 = ((k)localObject1).hNJ();
      }
      catch (Throwable localThrowable)
      {
        if (paramcf != null)
        {
          a.a(paramcf, localThrowable);
          if (paramcf != null) {
            break label185;
          }
        }
        paramcf = (ca)this;
        paramcf = (Throwable)new aa("Exception in completion handler " + localObject2 + " for " + paramcf, localThrowable);
        localObject2 = x.SXb;
        continue;
      }
      if (paramcf != null)
      {
        x(paramcf);
        AppMethodBeat.o(118285);
        return;
      }
      AppMethodBeat.o(118285);
      return;
    }
  }
  
  private final Object c(bp parambp, Object paramObject)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(192351);
    cf localcf = a(parambp);
    if (localcf == null)
    {
      parambp = cb.hNw();
      AppMethodBeat.o(192351);
      return parambp;
    }
    label70:
    int i;
    Object localObject2;
    if (!(parambp instanceof c))
    {
      ??? = null;
      ??? = (c)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new c(localcf, null))
          {
            if (((c)???)._isCompleting != 0)
            {
              parambp = cb.hNu();
              AppMethodBeat.o(192351);
              return parambp;
            }
            ((c)???)._isCompleting = 1;
            if ((??? != parambp) && (!TTD.compareAndSet(this, parambp, ???)))
            {
              parambp = cb.hNw();
              AppMethodBeat.o(192351);
              return parambp;
            }
            if (!an.hMK()) {
              break;
            }
            if (!((c)???).isSealed())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              parambp = (Throwable)new AssertionError();
              AppMethodBeat.o(192351);
              throw parambp;
            }
          }
          i = 0;
        }
        boolean bool = ((c)???).hNp();
        if (!(paramObject instanceof v))
        {
          localObject2 = null;
          label209:
          localObject2 = (v)localObject2;
          if (localObject2 != null) {
            ((c)???).F(((v)localObject2).cause);
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
      x localx = x.SXb;
      if (localObject2 != null) {
        a(localcf, (Throwable)localObject2);
      }
      if (!(parambp instanceof r))
      {
        localObject2 = null;
        label283:
        localObject2 = (r)localObject2;
        if (localObject2 == null)
        {
          localObject2 = parambp.hMX();
          parambp = localObject3;
          if (localObject2 != null) {
            parambp = a((k)localObject2);
          }
          label320:
          if ((parambp != null) && (a((c)???, parambp, paramObject)))
          {
            parambp = cb.TVb;
            AppMethodBeat.o(192351);
            return parambp;
            i = 0;
          }
        }
      }
      label401:
      while (i == 0)
      {
        localObject2 = null;
        break label252;
        parambp = a((c)???, paramObject);
        AppMethodBeat.o(192351);
        return parambp;
        parambp = (bp)localObject2;
        break label320;
        localObject2 = parambp;
        break label283;
        localObject2 = paramObject;
        break label209;
        break label70;
        ??? = parambp;
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
          localObject = hMn();
        }
        localObject = (CancellationException)new bv((String)localObject, paramThrowable, (bu)this);
      }
      AppMethodBeat.o(118289);
      return localObject;
    }
  }
  
  private boolean fV(Object paramObject)
  {
    AppMethodBeat.i(192345);
    Object localObject1 = cb.hNu();
    if (hNk())
    {
      localObject2 = fW(paramObject);
      localObject1 = localObject2;
      if (localObject2 == cb.TVb)
      {
        AppMethodBeat.o(192345);
        return true;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == cb.hNu()) {
      localObject2 = fY(paramObject);
    }
    if (localObject2 == cb.hNu())
    {
      AppMethodBeat.o(192345);
      return true;
    }
    if (localObject2 == cb.TVb)
    {
      AppMethodBeat.o(192345);
      return true;
    }
    if (localObject2 == cb.hNv())
    {
      AppMethodBeat.o(192345);
      return false;
    }
    fS(localObject2);
    AppMethodBeat.o(192345);
    return true;
  }
  
  private final Object fW(Object paramObject)
  {
    AppMethodBeat.i(192346);
    Object localObject;
    do
    {
      localObject = hNm();
      if ((!(localObject instanceof bp)) || (((localObject instanceof c)) && (((c)localObject)._isCompleting != 0)))
      {
        paramObject = cb.hNu();
        AppMethodBeat.o(192346);
        return paramObject;
      }
      localObject = Y(localObject, new v(fX(paramObject)));
    } while (localObject == cb.hNw());
    AppMethodBeat.o(192346);
    return localObject;
  }
  
  private final Throwable fX(Object paramObject)
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
        paramObject = (Throwable)new bv(hMn(), null, (bu)this);
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
    paramObject = (Throwable)((ci)paramObject).hNn();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object fY(Object paramObject)
  {
    AppMethodBeat.i(192348);
    Throwable localThrowable = null;
    Object localObject2 = hNm();
    int i;
    if ((localObject2 instanceof c))
    {
      try
      {
        if (((c)localObject2).isSealed())
        {
          paramObject = cb.hNv();
          return paramObject;
        }
        boolean bool = ((c)localObject2).hNp();
        if ((paramObject != null) || (!bool))
        {
          localObject1 = localThrowable;
          if (localThrowable == null) {
            localObject1 = fX(paramObject);
          }
          ((c)localObject2).F((Throwable)localObject1);
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
            a(((c)localObject2).TUL, paramObject);
          }
          paramObject = cb.hNu();
          AppMethodBeat.o(192348);
          return paramObject;
          i = 0;
          break;
          label154:
          paramObject = null;
        }
        if (!(localObject2 instanceof bp)) {
          break label445;
        }
      }
      finally
      {
        AppMethodBeat.o(192348);
      }
    }
    else
    {
      if (localThrowable != null) {
        break label460;
      }
      localThrowable = fX(paramObject);
    }
    label445:
    label460:
    for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
    {
      if (((bp)localObject2).isActive())
      {
        localObject2 = (bp)localObject2;
        if (an.hMK())
        {
          if (!(localObject2 instanceof c)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new AssertionError();
            AppMethodBeat.o(192348);
            throw paramObject;
          }
        }
        if ((an.hMK()) && (!((bp)localObject2).isActive()))
        {
          paramObject = (Throwable)new AssertionError();
          AppMethodBeat.o(192348);
          throw paramObject;
        }
        cf localcf = a((bp)localObject2);
        if (localcf == null) {
          i = 0;
        }
        while (i != 0)
        {
          paramObject = cb.hNu();
          AppMethodBeat.o(192348);
          return paramObject;
          c localc = new c(localcf, (Throwable)localObject1);
          if (!TTD.compareAndSet(this, localObject2, localc))
          {
            i = 0;
          }
          else
          {
            a(localcf, (Throwable)localObject1);
            i = 1;
          }
        }
      }
      localObject1 = Y(localObject2, new v((Throwable)localObject1));
      if (localObject1 == cb.hNu())
      {
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(192348);
        throw paramObject;
      }
      if (localObject1 != cb.hNw())
      {
        AppMethodBeat.o(192348);
        return localObject1;
        paramObject = cb.hNv();
        AppMethodBeat.o(192348);
        return paramObject;
      }
      break;
    }
  }
  
  private static Throwable ga(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof v)) {
      paramObject = null;
    }
    for (;;)
    {
      v localv = (v)paramObject;
      paramObject = localObject;
      if (localv != null) {
        paramObject = localv.cause;
      }
      return paramObject;
    }
  }
  
  private static String gb(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).hNp())
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
    if ((paramObject instanceof bp))
    {
      if (((bp)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof v))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  public boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(192343);
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(192343);
      return true;
    }
    if ((fV(paramThrowable)) && (hNl()))
    {
      AppMethodBeat.o(192343);
      return true;
    }
    AppMethodBeat.o(192343);
    return false;
  }
  
  public final boolean D(Throwable paramThrowable)
  {
    AppMethodBeat.i(192344);
    boolean bool = fV(paramThrowable);
    AppMethodBeat.o(192344);
    return bool;
  }
  
  protected boolean E(Throwable paramThrowable)
  {
    return false;
  }
  
  public final bc X(b<? super Throwable, x> paramb)
  {
    AppMethodBeat.i(258587);
    paramb = b(false, true, paramb);
    AppMethodBeat.o(258587);
    return paramb;
  }
  
  public final q a(s params)
  {
    AppMethodBeat.i(118304);
    params = bu.a.a(this, true, false, (b)new r(this, params), 2);
    if (params == null)
    {
      params = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118304);
      throw params;
    }
    params = (q)params;
    AppMethodBeat.o(118304);
    return params;
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    AppMethodBeat.i(192342);
    fV((Throwable)new bv(hMn(), null, (bu)this));
    AppMethodBeat.o(192342);
  }
  
  public final void a(ci paramci)
  {
    AppMethodBeat.i(118295);
    fV(paramci);
    AppMethodBeat.o(118295);
  }
  
  public final bc b(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, x> paramb)
  {
    Object localObject4 = null;
    AppMethodBeat.i(118290);
    Object localObject1 = null;
    Object localObject5 = hNm();
    if ((localObject5 instanceof bf)) {
      if (((bf)localObject5).isActive)
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
      cf localcf;
      bc localbc;
      if (TTD.compareAndSet(this, localObject5, localObject2))
      {
        paramb = (bc)localObject2;
        AppMethodBeat.o(118290);
        return paramb;
        localObject3 = (bf)localObject5;
        localObject2 = new cf();
        if (((bf)localObject3).isActive) {}
        for (localObject2 = (bp)localObject2;; localObject2 = (bp)new bo((cf)localObject2))
        {
          TTD.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject5 instanceof bp))
        {
          localcf = ((bp)localObject5).hMX();
          if (localcf == null)
          {
            if (localObject5 == null)
            {
              paramb = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118290);
              throw paramb;
            }
            a((bz)localObject5);
            break;
          }
          localbc = (bc)cg.TVh;
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
            localObject2 = localbc;
            localObject3 = localObject1;
            if ((paramb instanceof r))
            {
              localObject2 = localbc;
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
            boolean bool = a(localObject5, localcf, (bz)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (bc)localObject2;
              return paramb;
            }
            localObject2 = (bc)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = x.SXb;
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
          if (!a(localObject5, localcf, (bz)localObject2)) {
            break label530;
          }
          paramb = (bc)localObject2;
          AppMethodBeat.o(118290);
          return paramb;
          if (paramBoolean2) {
            if ((localObject5 instanceof v)) {
              break label518;
            }
          }
          for (localObject1 = null;; localObject1 = localObject5)
          {
            localObject2 = (v)localObject1;
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = ((v)localObject2).cause;
            }
            paramb.invoke(localObject1);
            paramb = (bc)cg.TVh;
            AppMethodBeat.o(118290);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localbc;
      }
    }
  }
  
  public final void b(bu parambu)
  {
    AppMethodBeat.i(192335);
    if (an.hMK())
    {
      if ((q)this._parentHandle == null) {}
      for (int i = 1; i == 0; i = 0)
      {
        parambu = (Throwable)new AssertionError();
        AppMethodBeat.o(192335);
        throw parambu;
      }
    }
    if (parambu == null)
    {
      this._parentHandle = ((q)cg.TVh);
      AppMethodBeat.o(192335);
      return;
    }
    parambu.start();
    parambu = parambu.a((s)this);
    this._parentHandle = parambu;
    if (isCompleted())
    {
      parambu.dispose();
      this._parentHandle = ((q)cg.TVh);
    }
    AppMethodBeat.o(192335);
  }
  
  protected void fS(Object paramObject) {}
  
  final int fU(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof bf))
    {
      if (((bf)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!TTD.compareAndSet(this, paramObject, cb.hNt()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      hMm();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bo))
    {
      if (!TTD.compareAndSet(this, paramObject, ((bo)paramObject).TUL))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      hMm();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  public final Object fZ(Object paramObject)
  {
    AppMethodBeat.i(192349);
    Object localObject;
    do
    {
      localObject = Y(hNm(), paramObject);
      if (localObject == cb.hNu())
      {
        paramObject = (Throwable)new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + paramObject, ga(paramObject));
        AppMethodBeat.o(192349);
        throw paramObject;
      }
    } while (localObject == cb.hNw());
    AppMethodBeat.o(192349);
    return localObject;
  }
  
  public <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
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
    return (f.c)bu.TUO;
  }
  
  public void hMm() {}
  
  protected String hMn()
  {
    return "Job was cancelled";
  }
  
  public String hMo()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  public final CancellationException hNj()
  {
    AppMethodBeat.i(118288);
    Object localObject = hNm();
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
      if ((localObject instanceof bp))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof v))
      {
        localObject = d(((v)localObject).cause, null);
        AppMethodBeat.o(118288);
        return localObject;
      }
      localObject = (CancellationException)new bv(getClass().getSimpleName() + " has completed normally", null, (bu)this);
    }
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public boolean hNk()
  {
    return false;
  }
  
  public boolean hNl()
  {
    return true;
  }
  
  public final Object hNm()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof kotlinx.coroutines.internal.q))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((kotlinx.coroutines.internal.q)localObject).ge(this);
    }
  }
  
  public final CancellationException hNn()
  {
    AppMethodBeat.i(192347);
    Object localObject2 = hNm();
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
        localObject1 = (CancellationException)new bv("Parent job is " + gb(localObject2), localThrowable, (bu)this);
      }
      AppMethodBeat.o(192347);
      return localObject1;
      if ((localObject2 instanceof v))
      {
        localThrowable = ((v)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof bp))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(192347);
        throw localThrowable;
      }
      localThrowable = null;
      break;
    }
  }
  
  protected boolean hNo()
  {
    return false;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = hNm();
    if (((localObject instanceof bp)) && (((bp)localObject).isActive()))
    {
      AppMethodBeat.o(118278);
      return true;
    }
    AppMethodBeat.o(118278);
    return false;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(192336);
    if (!(hNm() instanceof bp))
    {
      AppMethodBeat.o(192336);
      return true;
    }
    AppMethodBeat.o(192336);
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
      switch (fU(hNm()))
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
    String str = new StringBuilder().append(hMo()).append('{').append(gb(hNm())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  public void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118305);
    AppMethodBeat.o(118305);
    throw paramThrowable;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
  static final class a<T>
    extends l<T>
  {
    private final ca TUS;
    
    public a(d<? super T> paramd, ca paramca)
    {
      super();
      AppMethodBeat.i(118133);
      this.TUS = paramca;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable a(bu parambu)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.TUS.hNm();
      if ((localObject instanceof ca.c))
      {
        Throwable localThrowable = (Throwable)((ca.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof v))
      {
        parambu = ((v)localObject).cause;
        AppMethodBeat.o(118131);
        return parambu;
      }
      parambu = (Throwable)parambu.hNj();
      AppMethodBeat.o(118131);
      return parambu;
    }
    
    protected final String hMy()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends bz<bu>
  {
    private final ca TUT;
    private final ca.c TUU;
    private final r TUV;
    private final Object TUW;
    
    public b(ca paramca, ca.c paramc, r paramr, Object paramObject)
    {
      super();
      AppMethodBeat.i(118262);
      this.TUT = paramca;
      this.TUU = paramc;
      this.TUV = paramr;
      this.TUW = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118261);
      String str = "ChildCompletion[" + this.TUV + ", " + this.TUW + ']';
      AppMethodBeat.o(118261);
      return str;
    }
    
    public final void y(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      ca.a(this.TUT, this.TUU, this.TUV, this.TUW);
      AppMethodBeat.o(118259);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
  static final class c
    implements bp
  {
    final cf TUL;
    volatile Object _exceptionsHolder;
    volatile int _isCompleting;
    volatile Object _rootCause;
    
    public c(cf paramcf, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.TUL = paramcf;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> hNq()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void F(Throwable paramThrowable)
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
        ArrayList localArrayList = hNq();
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
    
    public final cf hMX()
    {
      return this.TUL;
    }
    
    public final boolean hNp()
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
      if (this._exceptionsHolder == cb.hNs())
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class d
    extends k.a
  {
    public d(k paramk1, k paramk2, ca paramca, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ca
 * JD-Core Version:    0.7.0.1
 */