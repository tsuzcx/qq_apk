package kotlinx.coroutines;

import a.a;
import a.c.e.b;
import a.c.e.b.a;
import a.c.e.c;
import a.f.a.b;
import a.f.b.j;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.h.a;
import kotlinx.coroutines.a.k;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "active", "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "cancelsParent", "getCancelsParent", "()Z", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "handlesException", "getHandlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parentHandle", "Lkotlinx/coroutines/ChildHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "attachChild", "child", "awaitInternal", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "", "cause", "cancelImpl", "cancelMakeCompleting", "cancelParent", "childCancelled", "completeStateFinalization", "update", "mode", "", "suppressed", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "createJobCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "firstChild", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionCause", "getCompletionExceptionOrNull", "getFinalRootCause", "exceptions", "", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJobInternal", "parent", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onCancellation", "onCompletionInternal", "onCompletionInternal$kotlinx_coroutines_core", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectClause0", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "registerSelectClause1Internal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion", "selectAwaitCompletion$kotlinx_coroutines_core", "start", "startInternal", "stateString", "suppressExceptions", "rootCause", "toString", "tryFinalizeFinishingState", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "message", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class bg
  implements bc, bn, o
{
  static final AtomicReferenceFieldUpdater CHi;
  private volatile Object CHh;
  volatile m CIn;
  
  static
  {
    AppMethodBeat.i(118623);
    CHi = AtomicReferenceFieldUpdater.newUpdater(bg.class, Object.class, "CHh");
    AppMethodBeat.o(118623);
  }
  
  public bg(boolean paramBoolean)
  {
    AppMethodBeat.i(118617);
    if (paramBoolean) {}
    for (ar localar = bh.epY();; localar = bh.epZ())
    {
      this.CHh = localar;
      AppMethodBeat.o(118617);
      return;
    }
  }
  
  private final boolean A(Throwable paramThrowable)
  {
    AppMethodBeat.i(118613);
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(118613);
      return true;
    }
    if (!epU())
    {
      AppMethodBeat.o(118613);
      return false;
    }
    m localm = this.CIn;
    if ((localm != null) && (localm.x(paramThrowable) == true))
    {
      AppMethodBeat.o(118613);
      return true;
    }
    AppMethodBeat.o(118613);
    return false;
  }
  
  private final Throwable a(bg.b paramb, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118587);
    if (paramList.isEmpty())
    {
      if (paramb.epV())
      {
        paramb = (Throwable)epS();
        AppMethodBeat.o(118587);
        return paramb;
      }
      AppMethodBeat.o(118587);
      return null;
    }
    Object localObject = ((Iterable)paramList).iterator();
    int i;
    if (((Iterator)localObject).hasNext())
    {
      paramb = ((Iterator)localObject).next();
      if (!((Throwable)paramb instanceof CancellationException))
      {
        i = 1;
        label84:
        if (i == 0) {
          break label123;
        }
      }
    }
    for (;;)
    {
      localObject = (Throwable)paramb;
      paramb = (bg.b)localObject;
      if (localObject == null) {
        paramb = (Throwable)paramList.get(0);
      }
      AppMethodBeat.o(118587);
      return paramb;
      i = 0;
      break label84;
      label123:
      break;
      paramb = null;
    }
  }
  
  private final bf<?> a(b<? super Throwable, y> paramb, boolean paramBoolean)
  {
    bf localbf = null;
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(118597);
    if (paramBoolean) {
      if ((paramb instanceof be)) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (be)localObject;
      if (localObject != null)
      {
        if (((be)localObject).CIm == (bg)this) {}
        while (i == 0)
        {
          paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
          AppMethodBeat.o(118597);
          throw paramb;
          i = 0;
        }
        if (localObject != null)
        {
          paramb = (bf)localObject;
          AppMethodBeat.o(118597);
          return paramb;
        }
      }
      paramb = (bf)new ba((bc)this, paramb);
      AppMethodBeat.o(118597);
      return paramb;
      if (!(paramb instanceof bf)) {}
      for (localObject = localbf;; localObject = paramb)
      {
        localbf = (bf)localObject;
        if (localbf != null)
        {
          if ((localbf.CIm == (bg)this) && (!(localbf instanceof be))) {}
          for (i = 1; i == 0; i = 0)
          {
            paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.o(118597);
            throw paramb;
          }
          localObject = localbf;
          if (localbf != null) {}
        }
        else
        {
          localObject = (bf)new bb((bc)this, paramb);
        }
        AppMethodBeat.o(118597);
        return localObject;
      }
      label246:
      localObject = paramb;
    }
  }
  
  private final bk a(ay paramay)
  {
    AppMethodBeat.i(118606);
    bk localbk = paramay.epJ();
    if (localbk == null)
    {
      if ((paramay instanceof ar))
      {
        paramay = new bk();
        AppMethodBeat.o(118606);
        return paramay;
      }
      if ((paramay instanceof bf))
      {
        a((bf)paramay);
        AppMethodBeat.o(118606);
        return null;
      }
      paramay = (Throwable)new IllegalStateException("State should have list: ".concat(String.valueOf(paramay)).toString());
      AppMethodBeat.o(118606);
      throw paramay;
    }
    AppMethodBeat.o(118606);
    return localbk;
  }
  
  private static n a(h paramh)
  {
    AppMethodBeat.i(118609);
    while ((paramh.eqh() instanceof kotlinx.coroutines.a.l)) {
      paramh = g.eh(paramh.eqj());
    }
    h localh;
    do
    {
      do
      {
        localh = g.eh(paramh.eqh());
        paramh = localh;
      } while ((localh.eqh() instanceof kotlinx.coroutines.a.l));
      if ((localh instanceof n))
      {
        paramh = (n)localh;
        AppMethodBeat.o(118609);
        return paramh;
      }
      paramh = localh;
    } while (!(localh instanceof bk));
    AppMethodBeat.o(118609);
    return null;
  }
  
  private final void a(bf<?> parambf)
  {
    AppMethodBeat.i(118599);
    parambf.b((h)new bk());
    h localh = g.eh(parambf.eqh());
    CHi.compareAndSet(this, parambf, localh);
    AppMethodBeat.o(118599);
  }
  
  private final void a(bk parambk, Throwable paramThrowable)
  {
    AppMethodBeat.i(118591);
    Object localObject1 = null;
    Object localObject2 = parambk.eqh();
    if (localObject2 == null)
    {
      parambk = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118591);
      throw parambk;
    }
    localObject2 = (h)localObject2;
    Object localObject3;
    if ((j.e(localObject2, (f)parambk) ^ true))
    {
      if (!(localObject2 instanceof be)) {
        break label182;
      }
      localObject3 = (bf)localObject2;
    }
    label182:
    for (;;)
    {
      try
      {
        ((bf)localObject3).v(paramThrowable);
        localObject2 = ((h)localObject2).eqi();
      }
      catch (Throwable localThrowable)
      {
        if (localObject1 != null)
        {
          a.a((Throwable)localObject1, localThrowable);
          if (localObject1 != null) {
            break label182;
          }
        }
        localObject1 = (bg)this;
        localObject1 = (Throwable)new u("Exception in completion handler " + localObject3 + " for " + localObject1, localThrowable);
        localObject3 = y.BMg;
        continue;
      }
      if (localObject1 != null) {
        u((Throwable)localObject1);
      }
      A(paramThrowable);
      AppMethodBeat.o(118591);
      return;
    }
  }
  
  private final boolean a(Object paramObject, bk parambk, bf<?> parambf)
  {
    AppMethodBeat.i(118598);
    paramObject = (h.a)new bg.c((h)parambf, (h)parambf, this, paramObject);
    for (;;)
    {
      Object localObject = parambk.eqj();
      if (localObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        AppMethodBeat.o(118598);
        throw paramObject;
      }
      switch (((h)localObject).a((h)parambf, parambk, paramObject))
      {
      }
    }
    AppMethodBeat.o(118598);
    return true;
    AppMethodBeat.o(118598);
    return false;
  }
  
  private static boolean a(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(118588);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(118588);
      return false;
    }
    Set localSet = kotlinx.coroutines.a.e.Wh(paramList.size());
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Throwable localThrowable = (Throwable)paramList.next();
      if ((localThrowable == paramThrowable) || ((localThrowable instanceof CancellationException)) || (!localSet.add(localThrowable))) {
        break label107;
      }
      a.a(paramThrowable, localThrowable);
      bool = true;
    }
    label107:
    for (;;)
    {
      break;
      AppMethodBeat.o(118588);
      return bool;
    }
  }
  
  private final boolean a(ay paramay, Object paramObject)
  {
    AppMethodBeat.i(118589);
    if (((paramay instanceof ar)) || ((paramay instanceof bf))) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramay = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118589);
      throw paramay;
    }
    if (!(paramObject instanceof q)) {}
    for (i = 1; i == 0; i = 0)
    {
      paramay = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(118589);
      throw paramay;
    }
    if (!CHi.compareAndSet(this, paramay, paramObject))
    {
      AppMethodBeat.o(118589);
      return false;
    }
    b(paramay, paramObject);
    AppMethodBeat.o(118589);
    return true;
  }
  
  private final boolean a(bg.b paramb, Object paramObject)
  {
    Throwable localThrowable = null;
    int j = 0;
    AppMethodBeat.i(118586);
    if (!(paramObject instanceof ay)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118586);
      throw paramb;
    }
    if (epR() == paramb) {}
    for (i = 1; i == 0; i = 0)
    {
      paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118586);
      throw paramb;
    }
    i = j;
    if (!paramb.isSealed()) {
      i = 1;
    }
    if (i == 0)
    {
      paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118586);
      throw paramb;
    }
    if (!paramb.CIt)
    {
      paramb = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(118586);
      throw paramb;
    }
    if (!(paramObject instanceof q)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      localObject1 = (q)localObject1;
      if (localObject1 != null) {
        localThrowable = ((q)localObject1).cause;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject2 = paramb.CIs;
          if (localObject2 == null)
          {
            localObject1 = bg.b.epW();
            localObject2 = paramb.CIu;
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(0, localObject2);
            }
            if ((localThrowable != null) && ((j.e(localThrowable, localObject2) ^ true))) {
              ((ArrayList)localObject1).add(localThrowable);
            }
            paramb.CIs = bh.epX();
            localObject2 = (List)localObject1;
            localObject1 = a(paramb, (List)localObject2);
            if ((localObject1 != null) && (!a((Throwable)localObject1, (List)localObject2))) {
              localObject2 = paramb.CIu;
            }
            if (localObject1 != null) {
              break label518;
            }
            if ((localObject1 != null) && (!A((Throwable)localObject1))) {
              z((Throwable)localObject1);
            }
            if (CHi.compareAndSet(this, paramb, paramObject)) {
              break;
            }
            paramb = (Throwable)new IllegalArgumentException(("Unexpected state: " + this.CHh + ", expected: " + paramb + ", update: " + paramObject).toString());
            AppMethodBeat.o(118586);
            throw paramb;
          }
          if ((localObject2 instanceof Throwable))
          {
            localObject1 = bg.b.epW();
            ((ArrayList)localObject1).add(localObject2);
            continue;
          }
          if (!(localObject2 instanceof ArrayList)) {
            break label485;
          }
          if (localObject2 == null)
          {
            paramObject = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
            AppMethodBeat.o(118586);
            throw paramObject;
          }
        }
        finally
        {
          AppMethodBeat.o(118586);
        }
        localObject1 = (ArrayList)localObject2;
        continue;
        label485:
        paramObject = (Throwable)new IllegalStateException("State is ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(118586);
        throw paramObject;
        label518:
        if (localObject1 != localThrowable) {
          paramObject = new q((Throwable)localObject1);
        }
      }
      b((ay)paramb, paramObject);
      AppMethodBeat.o(118586);
      return true;
    }
  }
  
  private final boolean a(bg.b paramb, n paramn, Object paramObject)
  {
    AppMethodBeat.i(118608);
    n localn;
    do
    {
      if (bc.a.a(paramn.CHo, false, false, (b)new bg.a(this, paramb, paramn, paramObject), 1) != bl.CIC)
      {
        AppMethodBeat.o(118608);
        return true;
      }
      localn = a((h)paramn);
      paramn = localn;
    } while (localn != null);
    AppMethodBeat.o(118608);
    return false;
  }
  
  private final void b(ay paramay, Object paramObject)
  {
    Object localObject3 = null;
    AppMethodBeat.i(118590);
    Object localObject1 = this.CIn;
    if (localObject1 != null)
    {
      ((m)localObject1).dispose();
      this.CIn = ((m)bl.CIC);
    }
    if (!(paramObject instanceof q)) {}
    Object localObject2;
    for (localObject1 = null;; localObject2 = paramObject)
    {
      q localq = (q)localObject1;
      localObject1 = localObject3;
      if (localq != null) {
        localObject1 = localq.cause;
      }
      if ((paramay instanceof bf)) {}
      for (;;)
      {
        try
        {
          ((bf)paramay).v((Throwable)localObject1);
          dW(paramObject);
          AppMethodBeat.o(118590);
          return;
        }
        catch (Throwable localThrowable)
        {
          u((Throwable)new u("Exception in completion handler " + paramay + " for " + this, localThrowable));
          continue;
        }
        paramay = paramay.epJ();
        if (paramay != null) {
          b(paramay, localThrowable);
        }
      }
    }
  }
  
  private final void b(bk parambk, Throwable paramThrowable)
  {
    AppMethodBeat.i(118592);
    Object localObject1 = null;
    Object localObject2 = parambk.eqh();
    if (localObject2 == null)
    {
      parambk = new v("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      AppMethodBeat.o(118592);
      throw parambk;
    }
    localObject2 = (h)localObject2;
    Object localObject3;
    if ((j.e(localObject2, (f)parambk) ^ true))
    {
      if (!(localObject2 instanceof bf)) {
        break label183;
      }
      localObject3 = (bf)localObject2;
    }
    label183:
    for (;;)
    {
      try
      {
        ((bf)localObject3).v(paramThrowable);
        localObject2 = ((h)localObject2).eqi();
      }
      catch (Throwable localThrowable)
      {
        if (localObject1 != null)
        {
          a.a((Throwable)localObject1, localThrowable);
          if (localObject1 != null) {
            break label183;
          }
        }
        localObject1 = (bg)this;
        localObject1 = (Throwable)new u("Exception in completion handler " + localObject3 + " for " + localObject1, localThrowable);
        localObject3 = y.BMg;
        continue;
      }
      if (localObject1 != null)
      {
        u((Throwable)localObject1);
        AppMethodBeat.o(118592);
        return;
      }
      AppMethodBeat.o(118592);
      return;
    }
  }
  
  private final CancellationException c(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(118595);
    if (!(paramThrowable instanceof CancellationException)) {}
    for (Object localObject = null;; localObject = paramThrowable)
    {
      CancellationException localCancellationException = (CancellationException)localObject;
      localObject = localCancellationException;
      if (localCancellationException == null) {
        localObject = (CancellationException)new bd(paramString, paramThrowable, (bc)this);
      }
      AppMethodBeat.o(118595);
      return localObject;
    }
  }
  
  private final Throwable ec(Object paramObject)
  {
    AppMethodBeat.i(118604);
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof Throwable;
    }
    while (bool) {
      if (paramObject != null)
      {
        paramObject = (Throwable)paramObject;
        AppMethodBeat.o(118604);
        return paramObject;
        bool = true;
      }
      else
      {
        paramObject = (Throwable)epS();
        AppMethodBeat.o(118604);
        return paramObject;
      }
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
      AppMethodBeat.o(118604);
      throw paramObject;
    }
    paramObject = ((bn)paramObject).epT();
    AppMethodBeat.o(118604);
    return paramObject;
  }
  
  private static String ee(Object paramObject)
  {
    AppMethodBeat.i(118616);
    if ((paramObject instanceof bg.b))
    {
      if (((bg.b)paramObject).epV())
      {
        AppMethodBeat.o(118616);
        return "Cancelling";
      }
      if (((bg.b)paramObject).CIt)
      {
        AppMethodBeat.o(118616);
        return "Completing";
      }
      AppMethodBeat.o(118616);
      return "Active";
    }
    if ((paramObject instanceof ay))
    {
      if (((ay)paramObject).isActive())
      {
        AppMethodBeat.o(118616);
        return "Active";
      }
      AppMethodBeat.o(118616);
      return "New";
    }
    if ((paramObject instanceof q))
    {
      AppMethodBeat.o(118616);
      return "Cancelled";
    }
    AppMethodBeat.o(118616);
    return "Completed";
  }
  
  private final bd epS()
  {
    AppMethodBeat.i(118602);
    bd localbd = new bd("Job was cancelled", null, (bc)this);
    AppMethodBeat.o(118602);
    return localbd;
  }
  
  final int I(Object paramObject1, Object paramObject2)
  {
    int j = 0;
    Object localObject3 = null;
    AppMethodBeat.i(118607);
    if (!(paramObject1 instanceof ay))
    {
      AppMethodBeat.o(118607);
      return 0;
    }
    if ((((paramObject1 instanceof ar)) || ((paramObject1 instanceof bf))) && (!(paramObject1 instanceof n)) && (!(paramObject2 instanceof q)))
    {
      if (!a((ay)paramObject1, paramObject2))
      {
        AppMethodBeat.o(118607);
        return 3;
      }
      AppMethodBeat.o(118607);
      return 1;
    }
    bk localbk = a((ay)paramObject1);
    if (localbk == null)
    {
      AppMethodBeat.o(118607);
      return 3;
    }
    label140:
    int i;
    Object localObject2;
    if (!(paramObject1 instanceof bg.b))
    {
      ??? = null;
      ??? = (bg.b)???;
      if (??? == null)
      {
        for (;;)
        {
          synchronized (new bg.b(localbk, null))
          {
            bool = ((bg.b)???).CIt;
            if (bool)
            {
              AppMethodBeat.o(118607);
              return 0;
            }
            ((bg.b)???).CIt = true;
            if (??? != paramObject1)
            {
              bool = CHi.compareAndSet(this, paramObject1, ???);
              if (!bool)
              {
                AppMethodBeat.o(118607);
                return 3;
              }
            }
            if (!((bg.b)???).isSealed())
            {
              i = 1;
              if (i != 0) {
                break;
              }
              paramObject1 = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
              AppMethodBeat.o(118607);
              throw paramObject1;
            }
          }
          i = 0;
        }
        boolean bool = ((bg.b)???).epV();
        if (!(paramObject2 instanceof q))
        {
          localObject2 = null;
          label279:
          localObject2 = (q)localObject2;
          if (localObject2 != null) {
            ((bg.b)???).B(((q)localObject2).cause);
          }
          localObject2 = ((bg.b)???).CIu;
          i = j;
          if (bool) {
            break label462;
          }
          i = 1;
          break label462;
        }
      }
    }
    for (;;)
    {
      label321:
      y localy = y.BMg;
      if (localObject2 != null) {
        a(localbk, (Throwable)localObject2);
      }
      localObject2 = (ay)paramObject1;
      if (!(localObject2 instanceof n))
      {
        paramObject1 = null;
        label358:
        paramObject1 = (n)paramObject1;
        if (paramObject1 == null)
        {
          localObject2 = ((ay)localObject2).epJ();
          paramObject1 = localObject3;
          if (localObject2 != null) {
            paramObject1 = a((h)localObject2);
          }
          label393:
          if ((paramObject1 != null) && (a((bg.b)???, paramObject1, paramObject2)))
          {
            AppMethodBeat.o(118607);
            return 2;
          }
        }
      }
      label462:
      do
      {
        localObject2 = null;
        break label321;
        a((bg.b)???, paramObject2);
        AppMethodBeat.o(118607);
        return 1;
        break label393;
        paramObject1 = localObject2;
        break label358;
        localObject2 = paramObject2;
        break label279;
        break label140;
        ??? = paramObject1;
        break;
      } while (i == 0);
    }
  }
  
  public final ap a(boolean paramBoolean1, boolean paramBoolean2, b<? super Throwable, y> paramb)
  {
    Object localObject5 = null;
    AppMethodBeat.i(118596);
    j.q(paramb, "handler");
    Object localObject1 = null;
    Object localObject6 = epR();
    if ((localObject6 instanceof ar)) {
      if (((ar)localObject6).isActive)
      {
        if (localObject1 != null) {
          break label561;
        }
        localObject1 = a(paramb, paramBoolean1);
      }
    }
    label530:
    label542:
    label544:
    label551:
    label561:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      Object localObject3;
      bk localbk;
      Object localObject4;
      if (CHi.compareAndSet(this, localObject6, localObject2))
      {
        paramb = (ap)localObject2;
        AppMethodBeat.o(118596);
        return paramb;
        localObject3 = (ar)localObject6;
        localObject2 = new bk();
        if (((ar)localObject3).isActive) {}
        for (localObject2 = (ay)localObject2;; localObject2 = (ay)new ax((bk)localObject2))
        {
          CHi.compareAndSet(this, localObject3, localObject2);
          break;
        }
        if ((localObject6 instanceof ay))
        {
          localbk = ((ay)localObject6).epJ();
          if (localbk == null)
          {
            if (localObject6 == null)
            {
              paramb = new v("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
              AppMethodBeat.o(118596);
              throw paramb;
            }
            a((bf)localObject6);
            break;
          }
          localObject4 = (ap)bl.CIC;
          if ((!paramBoolean1) || (!(localObject6 instanceof bg.b))) {
            break label551;
          }
        }
      }
      for (;;)
      {
        try
        {
          Throwable localThrowable = ((bg.b)localObject6).CIu;
          if (localThrowable != null)
          {
            localObject2 = localObject4;
            localObject3 = localObject1;
            if ((paramb instanceof n))
            {
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (((bg.b)localObject6).CIt) {}
            }
          }
          else
          {
            if (localObject1 != null) {
              break label544;
            }
            localObject1 = a(paramb, paramBoolean1);
            localObject2 = localObject1;
            boolean bool = a(localObject6, localbk, (bf)localObject2);
            if (!bool) {
              break;
            }
            if (localThrowable == null)
            {
              paramb = (ap)localObject2;
              return paramb;
            }
            localObject2 = (ap)localObject2;
            localObject3 = localObject1;
          }
          localObject1 = y.BMg;
          localObject1 = localThrowable;
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
          if (localObject3 != null)
          {
            if (paramBoolean2) {
              paramb.S(localObject3);
            }
            AppMethodBeat.o(118596);
            return localObject2;
          }
        }
        finally
        {
          AppMethodBeat.o(118596);
        }
        if (localObject1 == null) {
          localObject1 = a(paramb, paramBoolean1);
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          if (!a(localObject6, localbk, (bf)localObject2)) {
            break label542;
          }
          paramb = (ap)localObject2;
          AppMethodBeat.o(118596);
          return paramb;
          if (paramBoolean2) {
            if ((localObject6 instanceof q)) {
              break label530;
            }
          }
          for (localObject1 = null;; localObject1 = localObject6)
          {
            localObject2 = (q)localObject1;
            localObject1 = localObject5;
            if (localObject2 != null) {
              localObject1 = ((q)localObject2).cause;
            }
            paramb.S(localObject1);
            paramb = (ap)bl.CIC;
            AppMethodBeat.o(118596);
            return paramb;
            break;
          }
        }
        break;
        localObject2 = localObject1;
        continue;
        localObject3 = null;
        localObject2 = localObject4;
      }
    }
  }
  
  public final m a(o paramo)
  {
    AppMethodBeat.i(118610);
    j.q(paramo, "child");
    paramo = bc.a.a(this, true, false, (b)new n(this, paramo), 2);
    if (paramo == null)
    {
      paramo = new v("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
      AppMethodBeat.o(118610);
      throw paramo;
    }
    paramo = (m)paramo;
    AppMethodBeat.o(118610);
    return paramo;
  }
  
  public final void a(bn parambn)
  {
    AppMethodBeat.i(118601);
    j.q(parambn, "parentJob");
    ed(parambn);
    AppMethodBeat.o(118601);
  }
  
  public void dW(Object paramObject) {}
  
  final boolean ed(Object paramObject)
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(118605);
    Throwable localThrowable1 = null;
    Object localObject2 = epR();
    int i;
    if ((localObject2 instanceof bg.b)) {
      try
      {
        boolean bool = ((bg.b)localObject2).isSealed();
        if (bool) {
          return false;
        }
        bool = ((bg.b)localObject2).epV();
        if ((paramObject != null) || (!bool))
        {
          localThrowable2 = localThrowable1;
          if (localThrowable1 == null) {
            localThrowable2 = ec(paramObject);
          }
          ((bg.b)localObject2).B(localThrowable2);
        }
        localThrowable1 = ((bg.b)localObject2).CIu;
        i = j;
        if (!bool) {
          i = 1;
        }
        paramObject = localObject1;
        if (i != 0) {
          paramObject = localThrowable1;
        }
        if (paramObject != null) {
          a(((bg.b)localObject2).CIg, paramObject);
        }
        AppMethodBeat.o(118605);
        return true;
      }
      finally
      {
        AppMethodBeat.o(118605);
      }
    }
    if ((localObject2 instanceof ay))
    {
      if (localThrowable1 != null) {
        break label492;
      }
      localThrowable1 = ec(paramObject);
    }
    label492:
    for (Throwable localThrowable2 = localThrowable1;; localThrowable2 = localThrowable1)
    {
      if (((ay)localObject2).isActive())
      {
        localObject2 = (ay)localObject2;
        if (!(localObject2 instanceof bg.b)) {}
        for (i = 1; i == 0; i = 0)
        {
          paramObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(118605);
          throw paramObject;
        }
        if (!((ay)localObject2).isActive())
        {
          paramObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(118605);
          throw paramObject;
        }
        bk localbk = a((ay)localObject2);
        if (localbk == null) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(118605);
          return true;
          bg.b localb = new bg.b(localbk, localThrowable2);
          if (!CHi.compareAndSet(this, localObject2, localb))
          {
            i = 0;
          }
          else
          {
            a(localbk, localThrowable2);
            i = 1;
          }
        }
      }
      switch (I(localObject2, new q(localThrowable2)))
      {
      default: 
        paramObject = (Throwable)new IllegalStateException("unexpected result".toString());
        AppMethodBeat.o(118605);
        throw paramObject;
      case 0: 
        paramObject = (Throwable)new IllegalStateException("Cannot happen in ".concat(String.valueOf(localObject2)).toString());
        AppMethodBeat.o(118605);
        throw paramObject;
      case 1: 
      case 2: 
        AppMethodBeat.o(118605);
        return true;
      }
      break;
      AppMethodBeat.o(118605);
      return false;
      break;
    }
  }
  
  public final CancellationException epQ()
  {
    AppMethodBeat.i(118594);
    Object localObject = epR();
    if ((localObject instanceof bg.b))
    {
      localObject = ((bg.b)localObject).CIu;
      if (localObject != null)
      {
        CancellationException localCancellationException = c((Throwable)localObject, "Job is cancelling");
        localObject = localCancellationException;
        if (localCancellationException != null) {}
      }
      else
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118594);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      if ((localObject instanceof ay))
      {
        localObject = (Throwable)new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
        AppMethodBeat.o(118594);
        throw ((Throwable)localObject);
      }
      if ((localObject instanceof q))
      {
        localObject = c(((q)localObject).cause, "Job was cancelled");
        AppMethodBeat.o(118594);
        return localObject;
      }
      localObject = (CancellationException)new bd("Job has completed normally", null, (bc)this);
    }
    AppMethodBeat.o(118594);
    return localObject;
  }
  
  public final Object epR()
  {
    AppMethodBeat.i(118584);
    for (;;)
    {
      Object localObject = this.CHh;
      if (!(localObject instanceof k))
      {
        AppMethodBeat.o(118584);
        return localObject;
      }
      ((k)localObject).eg(this);
    }
  }
  
  public final Throwable epT()
  {
    AppMethodBeat.i(118603);
    Object localObject = epR();
    Throwable localThrowable;
    if ((localObject instanceof bg.b)) {
      localThrowable = ((bg.b)localObject).CIu;
    }
    while ((localThrowable == null) || (!(localThrowable instanceof CancellationException)))
    {
      localThrowable = (Throwable)new bd("Parent job is " + ee(localObject), localThrowable, (bc)this);
      AppMethodBeat.o(118603);
      return localThrowable;
      if ((localObject instanceof ay))
      {
        localThrowable = (Throwable)new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(localObject)).toString());
        AppMethodBeat.o(118603);
        throw localThrowable;
      }
      if ((localObject instanceof q)) {
        localThrowable = ((q)localObject).cause;
      } else {
        localThrowable = null;
      }
    }
    AppMethodBeat.o(118603);
    return localThrowable;
  }
  
  protected boolean epU()
  {
    return false;
  }
  
  public void eps() {}
  
  public String ept()
  {
    AppMethodBeat.i(118615);
    String str = af.ea(this);
    AppMethodBeat.o(118615);
    return str;
  }
  
  public <R> R fold(R paramR, a.f.a.m<? super R, ? super e.b, ? extends R> paramm)
  {
    AppMethodBeat.i(118619);
    j.q(paramm, "operation");
    j.q(paramm, "operation");
    paramR = e.b.a.a((e.b)this, paramR, paramm);
    AppMethodBeat.o(118619);
    return paramR;
  }
  
  public <E extends e.b> E get(e.c<E> paramc)
  {
    AppMethodBeat.i(118620);
    j.q(paramc, "key");
    j.q(paramc, "key");
    paramc = e.b.a.a((e.b)this, paramc);
    AppMethodBeat.o(118620);
    return paramc;
  }
  
  public final e.c<?> getKey()
  {
    return (e.c)bc.CIk;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118585);
    Object localObject = epR();
    if (((localObject instanceof ay)) && (((ay)localObject).isActive()))
    {
      AppMethodBeat.o(118585);
      return true;
    }
    AppMethodBeat.o(118585);
    return false;
  }
  
  public a.c.e minusKey(e.c<?> paramc)
  {
    AppMethodBeat.i(118621);
    j.q(paramc, "key");
    j.q(paramc, "key");
    paramc = e.b.a.b((e.b)this, paramc);
    AppMethodBeat.o(118621);
    return paramc;
  }
  
  public a.c.e plus(a.c.e parame)
  {
    AppMethodBeat.i(118618);
    j.q(parame, "context");
    j.q(parame, "context");
    parame = e.b.a.a((e.b)this, parame);
    AppMethodBeat.o(118618);
    return parame;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(118593);
    Object localObject = epR();
    int i;
    if ((localObject instanceof ar))
    {
      if (((ar)localObject).isActive) {
        break label127;
      }
      if (!CHi.compareAndSet(this, localObject, bh.epY())) {
        i = -1;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        break;
      case 0: 
        AppMethodBeat.o(118593);
        return false;
        eps();
        i = 1;
        continue;
        if ((localObject instanceof ax))
        {
          if (!CHi.compareAndSet(this, localObject, ((ax)localObject).CIg))
          {
            i = -1;
          }
          else
          {
            eps();
            i = 1;
          }
        }
        else {
          label127:
          i = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(118593);
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(118614);
    String str = ept() + '{' + ee(epR()) + "}@" + af.dZ(this);
    AppMethodBeat.o(118614);
    return str;
  }
  
  public void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118611);
    j.q(paramThrowable, "exception");
    AppMethodBeat.o(118611);
    throw paramThrowable;
  }
  
  public final boolean y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118600);
    if (ed(paramThrowable))
    {
      AppMethodBeat.o(118600);
      return true;
    }
    AppMethodBeat.o(118600);
    return false;
  }
  
  protected void z(Throwable paramThrowable)
  {
    AppMethodBeat.i(118612);
    j.q(paramThrowable, "exception");
    AppMethodBeat.o(118612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bg
 * JD-Core Version:    0.7.0.1
 */