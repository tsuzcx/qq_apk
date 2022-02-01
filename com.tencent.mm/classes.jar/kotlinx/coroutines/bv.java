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
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.j.a;
import kotlinx.coroutines.internal.t;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class bv
  implements br, cd, s
{
  static final AtomicReferenceFieldUpdater OeJ;
  volatile Object _parentHandle;
  private volatile Object _state;
  
  static
  {
    AppMethodBeat.i(118317);
    OeJ = AtomicReferenceFieldUpdater.newUpdater(bv.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public bv(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (bc localbc = bw.gAn();; localbc = bw.gAr())
    {
      this._state = localbc;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (gAi())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    q localq = (q)this._parentHandle;
    if ((localq == null) || (localq == cb.Ogk))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((localq.A(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  private final Object V(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(209216);
    if (!(paramObject1 instanceof bm))
    {
      paramObject1 = bw.gAo();
      AppMethodBeat.o(209216);
      return paramObject1;
    }
    if ((((paramObject1 instanceof bc)) || ((paramObject1 instanceof bu))) && (!(paramObject1 instanceof r)) && (!(paramObject2 instanceof u)))
    {
      if (a((bm)paramObject1, paramObject2))
      {
        AppMethodBeat.o(209216);
        return paramObject2;
      }
      paramObject1 = bw.gAq();
      AppMethodBeat.o(209216);
      return paramObject1;
    }
    paramObject1 = c((bm)paramObject1, paramObject2);
    AppMethodBeat.o(209216);
    return paramObject1;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(209206);
    int i;
    if (am.gzF())
    {
      if (gAg() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(209206);
        throw paramc;
      }
    }
    if (am.gzF())
    {
      if (!paramc.isSealed()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(209206);
        throw paramc;
      }
    }
    if ((am.gzF()) && (paramc._isCompleting == 0))
    {
      paramc = (Throwable)new AssertionError();
      AppMethodBeat.o(209206);
      throw paramc;
    }
    if (!(paramObject instanceof u)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (u)localObject1;
      Throwable localThrowable;
      if (localObject1 != null) {
        localThrowable = ((u)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = paramc._exceptionsHolder;
          if (localObject2 == null)
          {
            localObject1 = c.gAk();
            localObject2 = (Throwable)paramc._rootCause;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((d.g.b.p.i(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramc._exceptionsHolder = bw.gAm();
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
            if ((!B((Throwable)localObject1)) && (!C((Throwable)localObject1))) {
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
            AppMethodBeat.o(209206);
            throw paramc;
            localThrowable = null;
            break;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = c.gAk();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label372;
          }
        }
        finally
        {
          AppMethodBeat.o(209206);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label372:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(209206);
        throw paramObject;
        label405:
        if (localObject1 != localThrowable)
        {
          paramObject = new u((Throwable)localObject1);
          continue;
          label428:
          i = 0;
        }
      }
      label433:
      ((u)paramObject).gzA();
      label441:
      boolean bool = OeJ.compareAndSet(this, paramc, bw.fX(paramObject));
      if ((am.gzF()) && (!bool))
      {
        paramc = (Throwable)new AssertionError();
        AppMethodBeat.o(209206);
        throw paramc;
      }
      b((bm)paramc, paramObject);
      AppMethodBeat.o(209206);
      return paramObject;
    }
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.gAj())
      {
        paramc = (Throwable)new bs(gzj(), null, (br)this);
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
    if ((localObject instanceof cl))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof cl)))
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
  
  private final ca a(bm parambm)
  {
    AppMethodBeat.i(118300);
    ca localca = parambm.gzS();
    if (localca == null)
    {
      if ((parambm instanceof bc))
      {
        parambm = new ca();
        AppMethodBeat.o(118300);
        return parambm;
      }
      if ((parambm instanceof bu))
      {
        a((bu)parambm);
        AppMethodBeat.o(118300);
        return null;
      }
      parambm = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(parambm)).toString());
      AppMethodBeat.o(118300);
      throw parambm;
    }
    AppMethodBeat.o(118300);
    return localca;
  }
  
  private static r a(j paramj)
  {
    AppMethodBeat.i(118303);
    while (paramj.isRemoved()) {
      paramj = paramj.gAD();
    }
    j localj;
    do
    {
      do
      {
        localj = i.ga(paramj.gAB());
        paramj = localj;
      } while (localj.isRemoved());
      if ((localj instanceof r))
      {
        paramj = (r)localj;
        AppMethodBeat.o(118303);
        return paramj;
      }
      paramj = localj;
    } while (!(localj instanceof ca));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private final void a(bu<?> parambu)
  {
    AppMethodBeat.i(118293);
    parambu.c((j)new ca());
    j localj = i.ga(parambu.gAB());
    OeJ.compareAndSet(this, parambu, localj);
    AppMethodBeat.o(118293);
  }
  
  private final void a(ca paramca, Throwable paramThrowable)
  {
    AppMethodBeat.i(118284);
    Object localObject1 = null;
    h localh = (h)paramca;
    paramca = localh.gAB();
    if (paramca == null)
    {
      paramca = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118284);
      throw paramca;
    }
    Object localObject2 = (j)paramca;
    paramca = (ca)localObject1;
    localObject1 = localObject2;
    if ((d.g.b.p.i(localObject1, localh) ^ true))
    {
      if (!(localObject1 instanceof bt)) {
        break label184;
      }
      localObject2 = (bu)localObject1;
    }
    label184:
    for (;;)
    {
      try
      {
        ((bu)localObject2).x(paramThrowable);
        localObject1 = ((j)localObject1).gAC();
      }
      catch (Throwable localThrowable)
      {
        if (paramca != null)
        {
          a.a(paramca, localThrowable);
          if (paramca != null) {
            break label184;
          }
        }
        paramca = (bv)this;
        paramca = (Throwable)new z("Exception in completion handler " + localObject2 + " for " + paramca, localThrowable);
        localObject2 = d.z.Nhr;
        continue;
      }
      if (paramca != null) {
        v(paramca);
      }
      B(paramThrowable);
      AppMethodBeat.o(118284);
      return;
    }
  }
  
  private final boolean a(final Object paramObject, ca paramca, bu<?> parambu)
  {
    AppMethodBeat.i(118292);
    paramca = (j)paramca;
    paramObject = (j.a)new d((j)parambu, (j)parambu, this, paramObject);
    for (;;)
    {
      switch (paramca.gAD().a((j)parambu, paramca, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(bm parambm, Object paramObject)
  {
    AppMethodBeat.i(209208);
    int i;
    if (am.gzF())
    {
      if (((parambm instanceof bc)) || ((parambm instanceof bu))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambm = (Throwable)new AssertionError();
        AppMethodBeat.o(209208);
        throw parambm;
      }
    }
    if (am.gzF())
    {
      if (!(paramObject instanceof u)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambm = (Throwable)new AssertionError();
        AppMethodBeat.o(209208);
        throw parambm;
      }
    }
    if (!OeJ.compareAndSet(this, parambm, bw.fX(paramObject)))
    {
      AppMethodBeat.o(209208);
      return false;
    }
    b(parambm, paramObject);
    AppMethodBeat.o(209208);
    return true;
  }
  
  private final boolean a(c paramc, r paramr, Object paramObject)
  {
    AppMethodBeat.i(118302);
    r localr;
    do
    {
      if (br.a.a(paramr.OeN, false, false, (b)new b(this, paramc, paramr, paramObject), 1) != cb.Ogk)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localr = a((j)paramr);
      paramr = localr;
    } while (localr != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private final bu<?> b(b<? super Throwable, d.z> paramb, boolean paramBoolean)
  {
    bu localbu = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118291);
    if (paramBoolean) {
      if ((paramb instanceof bt)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (bt)localObject;
      if (localObject != null)
      {
        if (am.gzF())
        {
          if (((bt)localObject).OfU == (bv)this) {}
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
          paramb = (bu)localObject;
          AppMethodBeat.o(118291);
          return paramb;
        }
      }
      paramb = (bu)new bp((br)this, paramb);
      AppMethodBeat.o(118291);
      return paramb;
      if (!(paramb instanceof bu)) {}
      for (localObject = localbu;; localObject = paramb)
      {
        localbu = (bu)localObject;
        if (localbu != null)
        {
          if (am.gzF())
          {
            if ((localbu.OfU == (bv)this) && (!(localbu instanceof bt))) {}
            for (i = 1; i == 0; i = 0)
            {
              paramb = (Throwable)new AssertionError();
              AppMethodBeat.o(118291);
              throw paramb;
            }
          }
          localObject = localbu;
          if (localbu != null) {}
        }
        else
        {
          localObject = (bu)new bq((br)this, paramb);
        }
        AppMethodBeat.o(118291);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private static void b(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(209207);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(209207);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!am.gzG())
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
      if (!am.gzG()) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        a.a(paramThrowable, paramList);
        break label59;
        localThrowable = kotlinx.coroutines.internal.s.G(paramThrowable);
        break;
        paramList = kotlinx.coroutines.internal.s.G(paramList);
      }
    }
    label137:
    AppMethodBeat.o(209207);
  }
  
  private final void b(bm parambm, Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(209209);
    Object localObject2 = (q)this._parentHandle;
    if (localObject2 != null)
    {
      ((q)localObject2).dispose();
      this._parentHandle = ((q)cb.Ogk);
    }
    if (!(paramObject instanceof u)) {
      paramObject = null;
    }
    for (;;)
    {
      localObject2 = (u)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((u)localObject2).cause;
      }
      if ((parambm instanceof bu)) {
        try
        {
          ((bu)parambm).x(paramObject);
          AppMethodBeat.o(209209);
          return;
        }
        catch (Throwable paramObject)
        {
          v((Throwable)new z("Exception in completion handler " + parambm + " for " + this, paramObject));
          AppMethodBeat.o(209209);
          return;
        }
      }
      parambm = parambm.gzS();
      if (parambm != null)
      {
        b(parambm, paramObject);
        AppMethodBeat.o(209209);
        return;
      }
      AppMethodBeat.o(209209);
      return;
    }
  }
  
  private final void b(ca paramca, Throwable paramThrowable)
  {
    AppMethodBeat.i(118285);
    Object localObject1 = null;
    h localh = (h)paramca;
    paramca = localh.gAB();
    if (paramca == null)
    {
      paramca = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118285);
      throw paramca;
    }
    Object localObject2 = (j)paramca;
    paramca = (ca)localObject1;
    localObject1 = localObject2;
    if ((d.g.b.p.i(localObject1, localh) ^ true))
    {
      if (!(localObject1 instanceof bu)) {
        break label185;
      }
      localObject2 = (bu)localObject1;
    }
    label185:
    for (;;)
    {
      try
      {
        ((bu)localObject2).x(paramThrowable);
        localObject1 = ((j)localObject1).gAC();
      }
      catch (Throwable localThrowable)
      {
        if (paramca != null)
        {
          a.a(paramca, localThrowable);
          if (paramca != null) {
            break label185;
          }
        }
        paramca = (bv)this;
        paramca = (Throwable)new z("Exception in completion handler " + localObject2 + " for " + paramca, localThrowable);
        localObject2 = d.z.Nhr;
        continue;
      }
      if (paramca != null)
      {
        v(paramca);
        AppMethodBeat.o(118285);
        return;
      }
      AppMethodBeat.o(118285);
      return;
    }
  }
  
  private final Object c(bm parambm, Object paramObject)
  {
    int j = 1;
    Object localObject3 = null;
    AppMethodBeat.i(209217);
    ca localca = a(parambm);
    if (localca == null)
    {
      parambm = bw.gAq();
      AppMethodBeat.o(209217);
      return parambm;
    }
    label70:
    int i;
    Object localObject2;
    if (!(parambm instanceof c))
    {
      ??? = null;
      ??? = (c)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new c(localca, null))
          {
            if (((c)???)._isCompleting != 0)
            {
              parambm = bw.gAo();
              AppMethodBeat.o(209217);
              return parambm;
            }
            ((c)???)._isCompleting = 1;
            if ((??? != parambm) && (!OeJ.compareAndSet(this, parambm, ???)))
            {
              parambm = bw.gAq();
              AppMethodBeat.o(209217);
              return parambm;
            }
            if (!am.gzF()) {
              break;
            }
            if (!((c)???).isSealed())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              parambm = (Throwable)new AssertionError();
              AppMethodBeat.o(209217);
              throw parambm;
            }
          }
          i = 0;
        }
        boolean bool = ((c)???).gAj();
        if (!(paramObject instanceof u))
        {
          localObject2 = null;
          label209:
          localObject2 = (u)localObject2;
          if (localObject2 != null) {
            ((c)???).D(((u)localObject2).cause);
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
      d.z localz = d.z.Nhr;
      if (localObject2 != null) {
        a(localca, (Throwable)localObject2);
      }
      if (!(parambm instanceof r))
      {
        localObject2 = null;
        label283:
        localObject2 = (r)localObject2;
        if (localObject2 == null)
        {
          localObject2 = parambm.gzS();
          parambm = localObject3;
          if (localObject2 != null) {
            parambm = a((j)localObject2);
          }
          label320:
          if ((parambm != null) && (a((c)???, parambm, paramObject)))
          {
            parambm = bw.Oge;
            AppMethodBeat.o(209217);
            return parambm;
            i = 0;
          }
        }
      }
      label401:
      while (i == 0)
      {
        localObject2 = null;
        break label252;
        parambm = a((c)???, paramObject);
        AppMethodBeat.o(209217);
        return parambm;
        parambm = (bm)localObject2;
        break label320;
        localObject2 = parambm;
        break label283;
        localObject2 = paramObject;
        break label209;
        break label70;
        ??? = parambm;
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
          localObject = gzj();
        }
        localObject = (CancellationException)new bs((String)localObject, paramThrowable, (br)this);
      }
      AppMethodBeat.o(118289);
      return localObject;
    }
  }
  
  private final Throwable fS(Object paramObject)
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
        paramObject = (Throwable)new bs(gzj(), null, (br)this);
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
    paramObject = (Throwable)((cd)paramObject).gAh();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object fT(Object paramObject)
  {
    AppMethodBeat.i(209214);
    Throwable localThrowable = null;
    Object localObject2 = gAg();
    int i;
    if ((localObject2 instanceof c))
    {
      try
      {
        if (((c)localObject2).isSealed())
        {
          paramObject = bw.gAp();
          return paramObject;
        }
        boolean bool = ((c)localObject2).gAj();
        if ((paramObject != null) || (!bool))
        {
          localObject1 = localThrowable;
          if (localThrowable == null) {
            localObject1 = fS(paramObject);
          }
          ((c)localObject2).D((Throwable)localObject1);
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
            a(((c)localObject2).OfP, paramObject);
          }
          paramObject = bw.gAo();
          AppMethodBeat.o(209214);
          return paramObject;
          i = 0;
          break;
          label154:
          paramObject = null;
        }
        if (!(localObject2 instanceof bm)) {
          break label445;
        }
      }
      finally
      {
        AppMethodBeat.o(209214);
      }
    }
    else
    {
      if (localThrowable != null) {
        break label460;
      }
      localThrowable = fS(paramObject);
    }
    label445:
    label460:
    for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
    {
      if (((bm)localObject2).isActive())
      {
        localObject2 = (bm)localObject2;
        if (am.gzF())
        {
          if (!(localObject2 instanceof c)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramObject = (Throwable)new AssertionError();
            AppMethodBeat.o(209214);
            throw paramObject;
          }
        }
        if ((am.gzF()) && (!((bm)localObject2).isActive()))
        {
          paramObject = (Throwable)new AssertionError();
          AppMethodBeat.o(209214);
          throw paramObject;
        }
        ca localca = a((bm)localObject2);
        if (localca == null) {
          i = 0;
        }
        while (i != 0)
        {
          paramObject = bw.gAo();
          AppMethodBeat.o(209214);
          return paramObject;
          c localc = new c(localca, (Throwable)localObject1);
          if (!OeJ.compareAndSet(this, localObject2, localc))
          {
            i = 0;
          }
          else
          {
            a(localca, (Throwable)localObject1);
            i = 1;
          }
        }
      }
      localObject1 = V(localObject2, new u((Throwable)localObject1));
      if (localObject1 == bw.gAo())
      {
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(209214);
        throw paramObject;
      }
      if (localObject1 != bw.gAq())
      {
        AppMethodBeat.o(209214);
        return localObject1;
        paramObject = bw.gAp();
        AppMethodBeat.o(209214);
        return paramObject;
      }
      break;
    }
  }
  
  private static Throwable fV(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof u)) {
      paramObject = null;
    }
    for (;;)
    {
      u localu = (u)paramObject;
      paramObject = localObject;
      if (localu != null) {
        paramObject = localu.cause;
      }
      return paramObject;
    }
  }
  
  private static String fW(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).gAj())
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
    if ((paramObject instanceof bm))
    {
      if (((bm)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof u))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  protected boolean C(Throwable paramThrowable)
  {
    return false;
  }
  
  public final ba O(b<? super Throwable, d.z> paramb)
  {
    AppMethodBeat.i(224250);
    paramb = b(false, true, paramb);
    AppMethodBeat.o(224250);
    return paramb;
  }
  
  public final q a(s params)
  {
    AppMethodBeat.i(118304);
    params = br.a.a(this, true, false, (b)new r(this, params), 2);
    if (params == null)
    {
      params = new v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118304);
      throw params;
    }
    params = (q)params;
    AppMethodBeat.o(118304);
    return params;
  }
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(118295);
    fR(paramcd);
    AppMethodBeat.o(118295);
  }
  
  public final ba b(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, d.z> paramb)
  {
    Object localObject4 = null;
    AppMethodBeat.i(118290);
    Object localObject1 = null;
    Object localObject5 = gAg();
    if ((localObject5 instanceof bc)) {
      if (((bc)localObject5).isActive)
      {
        if (localObject1 != null) {
          break label549;
        }
        localObject1 = b(paramb, paramBoolean1);
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
      ca localca;
      ba localba;
      if (OeJ.compareAndSet(this, localObject5, localObject2))
      {
        paramb = (ba)localObject2;
        AppMethodBeat.o(118290);
        return paramb;
        localObject3 = (bc)localObject5;
        localObject2 = new ca();
        if (((bc)localObject3).isActive) {}
        for (localObject2 = (bm)localObject2;; localObject2 = (bm)new bl((ca)localObject2))
        {
          OeJ.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject5 instanceof bm))
        {
          localca = ((bm)localObject5).gzS();
          if (localca == null)
          {
            if (localObject5 == null)
            {
              paramb = new v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118290);
              throw paramb;
            }
            a((bu)localObject5);
            break;
          }
          localba = (ba)cb.Ogk;
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
            localObject2 = localba;
            localObject3 = localObject1;
            if ((paramb instanceof r))
            {
              localObject2 = localba;
              localObject3 = localObject1;
              if (((c)localObject5)._isCompleting != 0) {}
            }
          }
          else
          {
            if (localObject1 != null) {
              break label532;
            }
            localObject1 = b(paramb, paramBoolean1);
            localObject2 = localObject1;
            boolean bool = a(localObject5, localca, (bu)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (ba)localObject2;
              return paramb;
            }
            localObject2 = (ba)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = d.z.Nhr;
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
          localObject1 = b(paramb, paramBoolean1);
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          if (!a(localObject5, localca, (bu)localObject2)) {
            break label530;
          }
          paramb = (ba)localObject2;
          AppMethodBeat.o(118290);
          return paramb;
          if (paramBoolean2) {
            if ((localObject5 instanceof u)) {
              break label518;
            }
          }
          for (localObject1 = null;; localObject1 = localObject5)
          {
            localObject2 = (u)localObject1;
            localObject1 = localObject4;
            if (localObject2 != null) {
              localObject1 = ((u)localObject2).cause;
            }
            paramb.invoke(localObject1);
            paramb = (ba)cb.Ogk;
            AppMethodBeat.o(118290);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localba;
      }
    }
  }
  
  protected void fO(Object paramObject) {}
  
  final int fQ(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof bc))
    {
      if (((bc)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!OeJ.compareAndSet(this, paramObject, bw.gAn()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      gzi();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bl))
    {
      if (!OeJ.compareAndSet(this, paramObject, ((bl)paramObject).OfP))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      gzi();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  public final boolean fR(Object paramObject)
  {
    AppMethodBeat.i(209212);
    t localt = bw.gAo();
    Object localObject = localt;
    if (localt == bw.gAo()) {
      localObject = fT(paramObject);
    }
    if (localObject == bw.gAo())
    {
      AppMethodBeat.o(209212);
      return true;
    }
    if (localObject == bw.Oge)
    {
      AppMethodBeat.o(209212);
      return true;
    }
    if (localObject == bw.gAp())
    {
      AppMethodBeat.o(209212);
      return false;
    }
    fO(localObject);
    AppMethodBeat.o(209212);
    return true;
  }
  
  public final Object fU(Object paramObject)
  {
    AppMethodBeat.i(209215);
    Object localObject;
    do
    {
      localObject = V(gAg(), paramObject);
      if (localObject == bw.gAo())
      {
        paramObject = (Throwable)new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + paramObject, fV(paramObject));
        AppMethodBeat.o(209215);
        throw paramObject;
      }
    } while (localObject == bw.gAq());
    AppMethodBeat.o(209215);
    return localObject;
  }
  
  public <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118313);
    paramR = f.b.a.a((f.b)this, paramR, paramm);
    AppMethodBeat.o(118313);
    return paramR;
  }
  
  public final CancellationException gAe()
  {
    AppMethodBeat.i(118288);
    Object localObject = gAg();
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
      if ((localObject instanceof bm))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof u))
      {
        localObject = c(((u)localObject).cause, null);
        AppMethodBeat.o(118288);
        return localObject;
      }
      localObject = (CancellationException)new bs(getClass().getSimpleName() + " has completed normally", null, (br)this);
    }
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public final void gAf()
  {
    AppMethodBeat.i(209211);
    fR((Throwable)new bs(gzj(), null, (br)this));
    AppMethodBeat.o(209211);
  }
  
  public final Object gAg()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof kotlinx.coroutines.internal.p))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((kotlinx.coroutines.internal.p)localObject).fZ(this);
    }
  }
  
  public final CancellationException gAh()
  {
    AppMethodBeat.i(209213);
    Object localObject2 = gAg();
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
        localObject1 = (CancellationException)new bs("Parent job is " + fW(localObject2), localThrowable, (br)this);
      }
      AppMethodBeat.o(209213);
      return localObject1;
      if ((localObject2 instanceof u))
      {
        localThrowable = ((u)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof bm))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(209213);
        throw localThrowable;
      }
      localThrowable = null;
      break;
    }
  }
  
  protected boolean gAi()
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
    return (f.c)br.OfS;
  }
  
  public void gzi() {}
  
  protected String gzj()
  {
    return "Job was cancelled";
  }
  
  public String gzk()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = gAg();
    if (((localObject instanceof bm)) && (((bm)localObject).isActive()))
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
      switch (fQ(gAg()))
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
    String str = new StringBuilder().append(gzk()).append('{').append(fW(gAg())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  public void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118305);
    AppMethodBeat.o(118305);
    throw paramThrowable;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
  static final class a<T>
    extends l<T>
  {
    private final bv OfV;
    
    public a(d<? super T> paramd, bv parambv)
    {
      super();
      AppMethodBeat.i(118133);
      this.OfV = parambv;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable a(br parambr)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.OfV.gAg();
      if ((localObject instanceof bv.c))
      {
        Throwable localThrowable = (Throwable)((bv.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof u))
      {
        parambr = ((u)localObject).cause;
        AppMethodBeat.o(118131);
        return parambr;
      }
      parambr = (Throwable)parambr.gAe();
      AppMethodBeat.o(118131);
      return parambr;
    }
    
    protected final String gzu()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
  static final class b
    extends bu<br>
  {
    private final bv OfW;
    private final bv.c OfX;
    private final r OfY;
    private final Object OfZ;
    
    public b(bv parambv, bv.c paramc, r paramr, Object paramObject)
    {
      super();
      AppMethodBeat.i(118262);
      this.OfW = parambv;
      this.OfX = paramc;
      this.OfY = paramr;
      this.OfZ = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118261);
      String str = "ChildCompletion[" + this.OfY + ", " + this.OfZ + ']';
      AppMethodBeat.o(118261);
      return str;
    }
    
    public final void x(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      bv.a(this.OfW, this.OfX, this.OfY, this.OfZ);
      AppMethodBeat.o(118259);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
  static final class c
    implements bm
  {
    final ca OfP;
    volatile Object _exceptionsHolder;
    volatile int _isCompleting;
    volatile Object _rootCause;
    
    public c(ca paramca, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.OfP = paramca;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> gAk()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void D(Throwable paramThrowable)
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
        ArrayList localArrayList = gAk();
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
    
    public final boolean gAj()
    {
      return (Throwable)this._rootCause != null;
    }
    
    public final ca gzS()
    {
      return this.OfP;
    }
    
    public final boolean isActive()
    {
      return (Throwable)this._rootCause == null;
    }
    
    public final boolean isSealed()
    {
      AppMethodBeat.i(118221);
      if (this._exceptionsHolder == bw.gAm())
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class d
    extends j.a
  {
    public d(j paramj1, j paramj2, bv parambv, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bv
 * JD-Core Version:    0.7.0.1
 */