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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.b.a;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.m.h;
import kotlin.m.k;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.p.a;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class ci
  implements cq, x
{
  static
  {
    AppMethodBeat.i(118317);
    ajvp = AtomicReferenceFieldUpdater.newUpdater(ci.class, Object.class, "_state");
    AppMethodBeat.o(118317);
  }
  
  public ci(boolean paramBoolean)
  {
    AppMethodBeat.i(118311);
    if (paramBoolean) {}
    for (bl localbl = cj.kCE();; localbl = cj.kCF())
    {
      this._state = localbl;
      this._parentHandle = null;
      AppMethodBeat.o(118311);
      return;
    }
  }
  
  private final boolean S(Throwable paramThrowable)
  {
    AppMethodBeat.i(118307);
    if (kBx())
    {
      AppMethodBeat.o(118307);
      return true;
    }
    boolean bool = paramThrowable instanceof CancellationException;
    v localv = (v)this._parentHandle;
    if ((localv == null) || (localv == co.ajwK))
    {
      AppMethodBeat.o(118307);
      return bool;
    }
    if ((localv.Q(paramThrowable)) || (bool))
    {
      AppMethodBeat.o(118307);
      return true;
    }
    AppMethodBeat.o(118307);
    return false;
  }
  
  private final Object a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(188813);
    int i;
    if (au.ASSERTIONS_ENABLED)
    {
      if (kCy() == paramc) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = new AssertionError();
        AppMethodBeat.o(188813);
        throw paramc;
      }
    }
    if (au.ASSERTIONS_ENABLED)
    {
      if (!paramc.kqK()) {}
      for (i = 1; i == 0; i = 0)
      {
        paramc = new AssertionError();
        AppMethodBeat.o(188813);
        throw paramc;
      }
    }
    if ((au.ASSERTIONS_ENABLED) && (paramc._isCompleting == 0))
    {
      paramc = new AssertionError();
      AppMethodBeat.o(188813);
      throw paramc;
    }
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof ae))
    {
      localObject1 = (ae)paramObject;
      if (localObject1 != null) {
        break label305;
      }
      localObject2 = null;
    }
    for (;;)
    {
      label137:
      Object localObject3;
      try
      {
        paramc.kCB();
        localObject3 = paramc._exceptionsHolder;
        if (localObject3 == null)
        {
          localObject1 = c.kCC();
          localObject3 = (Throwable)paramc._rootCause;
          if (localObject3 != null) {
            ((ArrayList)localObject1).add(0, localObject3);
          }
          if ((localObject2 != null) && (!kotlin.g.b.s.p(localObject2, localObject3))) {
            ((ArrayList)localObject1).add(localObject2);
          }
          paramc._exceptionsHolder = cj.kCJ();
          localObject3 = (List)localObject1;
          localObject1 = a(paramc, (List)localObject3);
          if (localObject1 != null) {
            a((Throwable)localObject1, (List)localObject3);
          }
          if (localObject1 != null) {
            break label398;
          }
          if (localObject1 == null) {
            break label434;
          }
          if ((!S((Throwable)localObject1)) && (!V((Throwable)localObject1))) {
            break label421;
          }
          i = 1;
          if (i == 0) {
            break label434;
          }
          if (paramObject != null) {
            break label426;
          }
          paramc = new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
          AppMethodBeat.o(188813);
          throw paramc;
          localObject1 = null;
          break;
          label305:
          localObject2 = ((ae)localObject1).cause;
          break label137;
        }
        if ((localObject3 instanceof Throwable))
        {
          localObject1 = c.kCC();
          ((ArrayList)localObject1).add(localObject3);
          continue;
        }
        if (!(localObject3 instanceof ArrayList)) {
          break label368;
        }
      }
      finally
      {
        AppMethodBeat.o(188813);
      }
      localObject1 = (ArrayList)localObject3;
      continue;
      label368:
      paramObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("State is ", localObject3).toString());
      AppMethodBeat.o(188813);
      throw paramObject;
      label398:
      if (localObject1 != localObject2)
      {
        paramObject = new ae((Throwable)localObject1);
        continue;
        label421:
        i = 0;
      }
    }
    label426:
    ((ae)paramObject).kBV();
    label434:
    iu(paramObject);
    boolean bool = ajvp.compareAndSet(this, paramc, cj.iM(paramObject));
    if ((au.ASSERTIONS_ENABLED) && (!bool))
    {
      paramc = new AssertionError();
      AppMethodBeat.o(188813);
      throw paramc;
    }
    b((bw)paramc, paramObject);
    AppMethodBeat.o(188813);
    return paramObject;
  }
  
  private final Throwable a(c paramc, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(118280);
    if (paramList.isEmpty())
    {
      if (paramc.kCB())
      {
        paramc = (Throwable)new cc(kBt(), null, (cb)this);
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
    if ((localObject instanceof da))
    {
      paramList = ((Iterable)paramList).iterator();
      if (paramList.hasNext())
      {
        paramc = paramList.next();
        Throwable localThrowable = (Throwable)paramc;
        if ((localThrowable != localObject) && ((localThrowable instanceof da)))
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
  
  private final cn a(bw parambw)
  {
    AppMethodBeat.i(118300);
    cn localcn = parambw.kCj();
    if (localcn == null)
    {
      if ((parambw instanceof bl))
      {
        parambw = new cn();
        AppMethodBeat.o(118300);
        return parambw;
      }
      if ((parambw instanceof ch))
      {
        a((ch)parambw);
        AppMethodBeat.o(118300);
        return null;
      }
      parambw = (Throwable)new IllegalStateException(kotlin.g.b.s.X("State should have list: ", parambw).toString());
      AppMethodBeat.o(118300);
      throw parambw;
    }
    AppMethodBeat.o(118300);
    return localcn;
  }
  
  private static w a(kotlinx.coroutines.internal.p paramp)
  {
    AppMethodBeat.i(118303);
    while (paramp.isRemoved()) {
      paramp = paramp.kEb();
    }
    kotlinx.coroutines.internal.p localp;
    do
    {
      do
      {
        localp = o.jk(paramp.kDZ());
        paramp = localp;
      } while (localp.isRemoved());
      if ((localp instanceof w))
      {
        paramp = (w)localp;
        AppMethodBeat.o(118303);
        return paramp;
      }
      paramp = localp;
    } while (!(localp instanceof cn));
    AppMethodBeat.o(118303);
    return null;
  }
  
  private static void a(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    AppMethodBeat.i(188824);
    if (paramList.size() <= 1)
    {
      AppMethodBeat.o(188824);
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    Iterator localIterator;
    if (!au.ajvP)
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
      if (!au.ajvP) {}
      for (;;)
      {
        if ((paramList == paramThrowable) || (paramList == localThrowable) || ((paramList instanceof CancellationException)) || (!localSet.add(paramList))) {
          break label135;
        }
        kotlin.b.a(paramThrowable, paramList);
        break label59;
        localThrowable = ab.ad(paramThrowable);
        break;
        paramList = ab.ad(paramList);
      }
    }
    label137:
    AppMethodBeat.o(188824);
  }
  
  private final void a(ch paramch)
  {
    AppMethodBeat.i(118293);
    paramch.c((kotlinx.coroutines.internal.p)new cn());
    kotlinx.coroutines.internal.p localp = o.jk(paramch.kDZ());
    ajvp.compareAndSet(this, paramch, localp);
    AppMethodBeat.o(118293);
  }
  
  /* Error */
  private final void a(cn paramcn, Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc_w 544
    //   3: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 546	kotlinx/coroutines/internal/n
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 547	kotlinx/coroutines/internal/n:kDZ	()Ljava/lang/Object;
    //   17: checkcast 472	kotlinx/coroutines/internal/p
    //   20: astore_1
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_1
    //   24: aload 6
    //   26: invokestatic 348	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   29: ifne +120 -> 149
    //   32: aload_3
    //   33: astore 4
    //   35: aload_1
    //   36: instanceof 549
    //   39: ifeq +18 -> 57
    //   42: aload_1
    //   43: checkcast 463	kotlinx/coroutines/ch
    //   46: astore 7
    //   48: aload 7
    //   50: aload_2
    //   51: invokevirtual 552	kotlinx/coroutines/ch:N	(Ljava/lang/Throwable;)V
    //   54: aload_3
    //   55: astore 4
    //   57: aload_1
    //   58: invokevirtual 555	kotlinx/coroutines/internal/p:kEa	()Lkotlinx/coroutines/internal/p;
    //   61: astore_1
    //   62: aload 4
    //   64: astore_3
    //   65: goto -42 -> 23
    //   68: astore 8
    //   70: aload_3
    //   71: checkcast 336	java/lang/Throwable
    //   74: astore 5
    //   76: aload 5
    //   78: ifnonnull +61 -> 139
    //   81: aconst_null
    //   82: astore 5
    //   84: aload_3
    //   85: astore 4
    //   87: aload 5
    //   89: ifnonnull -32 -> 57
    //   92: aload_0
    //   93: checkcast 2	kotlinx/coroutines/ci
    //   96: astore_3
    //   97: new 557	kotlinx/coroutines/ah
    //   100: dup
    //   101: new 559	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 561
    //   108: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 7
    //   113: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: ldc_w 568
    //   119: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload 8
    //   131: invokespecial 575	kotlinx/coroutines/ah:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: astore 4
    //   136: goto -79 -> 57
    //   139: aload 5
    //   141: aload 8
    //   143: invokestatic 519	kotlin/b:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   146: goto -62 -> 84
    //   149: aload_3
    //   150: checkcast 336	java/lang/Throwable
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +8 -> 163
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 578	kotlinx/coroutines/ci:M	(Ljava/lang/Throwable;)V
    //   163: aload_0
    //   164: aload_2
    //   165: invokespecial 363	kotlinx/coroutines/ci:S	(Ljava/lang/Throwable;)Z
    //   168: pop
    //   169: ldc_w 544
    //   172: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ci
    //   0	176	1	paramcn	cn
    //   0	176	2	paramThrowable	Throwable
    //   22	128	3	localObject1	Object
    //   33	102	4	localObject2	Object
    //   74	66	5	localThrowable1	Throwable
    //   10	15	6	localn	n
    //   46	66	7	localch	ch
    //   68	74	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	54	68	finally
  }
  
  private final boolean a(final Object paramObject, cn paramcn, ch paramch)
  {
    AppMethodBeat.i(118292);
    paramcn = (kotlinx.coroutines.internal.p)paramcn;
    paramObject = (p.a)new d((kotlinx.coroutines.internal.p)paramch, this, paramObject);
    for (;;)
    {
      switch (paramcn.kEb().a((kotlinx.coroutines.internal.p)paramch, paramcn, paramObject))
      {
      }
    }
    AppMethodBeat.o(118292);
    return true;
    AppMethodBeat.o(118292);
    return false;
  }
  
  private final boolean a(bw parambw, Object paramObject)
  {
    AppMethodBeat.i(188832);
    int i;
    if (au.ASSERTIONS_ENABLED)
    {
      if (((parambw instanceof bl)) || ((parambw instanceof ch))) {}
      for (i = 1; i == 0; i = 0)
      {
        parambw = new AssertionError();
        AppMethodBeat.o(188832);
        throw parambw;
      }
    }
    if (au.ASSERTIONS_ENABLED)
    {
      if (!(paramObject instanceof ae)) {}
      for (i = 1; i == 0; i = 0)
      {
        parambw = new AssertionError();
        AppMethodBeat.o(188832);
        throw parambw;
      }
    }
    if (!ajvp.compareAndSet(this, parambw, cj.iM(paramObject)))
    {
      AppMethodBeat.o(188832);
      return false;
    }
    iu(paramObject);
    b(parambw, paramObject);
    AppMethodBeat.o(188832);
    return true;
  }
  
  private final boolean a(c paramc, w paramw, Object paramObject)
  {
    AppMethodBeat.i(118302);
    w localw;
    do
    {
      if (cb.a.a((cb)paramw.ajvu, false, false, (kotlin.g.a.b)new b(this, paramc, paramw, paramObject), 1) != co.ajwK)
      {
        AppMethodBeat.o(118302);
        return true;
      }
      localw = a((kotlinx.coroutines.internal.p)paramw);
      paramw = localw;
    } while (localw != null);
    AppMethodBeat.o(118302);
    return false;
  }
  
  private final Object ac(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(188929);
    if (!(paramObject1 instanceof bw))
    {
      paramObject1 = cj.kCG();
      AppMethodBeat.o(188929);
      return paramObject1;
    }
    if ((((paramObject1 instanceof bl)) || ((paramObject1 instanceof ch))) && (!(paramObject1 instanceof w)) && (!(paramObject2 instanceof ae)))
    {
      if (a((bw)paramObject1, paramObject2))
      {
        AppMethodBeat.o(188929);
        return paramObject2;
      }
      paramObject1 = cj.kCI();
      AppMethodBeat.o(188929);
      return paramObject1;
    }
    paramObject1 = c((bw)paramObject1, paramObject2);
    AppMethodBeat.o(188929);
    return paramObject1;
  }
  
  /* Error */
  private final void b(bw parambw, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 620
    //   5: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 277	kotlinx/coroutines/ci:_parentHandle	Ljava/lang/Object;
    //   12: checkcast 289	kotlinx/coroutines/v
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +20 -> 39
    //   22: aload 4
    //   24: invokeinterface 623 1 0
    //   29: aload_0
    //   30: getstatic 295	kotlinx/coroutines/co:ajwK	Lkotlinx/coroutines/co;
    //   33: checkcast 289	kotlinx/coroutines/v
    //   36: putfield 277	kotlinx/coroutines/ci:_parentHandle	Ljava/lang/Object;
    //   39: aload_2
    //   40: instanceof 321
    //   43: ifeq +36 -> 79
    //   46: aload_2
    //   47: checkcast 321	kotlinx/coroutines/ae
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +32 -> 84
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: instanceof 463
    //   61: ifeq +81 -> 142
    //   64: aload_1
    //   65: checkcast 463	kotlinx/coroutines/ch
    //   68: aload_2
    //   69: invokevirtual 552	kotlinx/coroutines/ch:N	(Ljava/lang/Throwable;)V
    //   72: ldc_w 620
    //   75: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: aconst_null
    //   80: astore_2
    //   81: goto -30 -> 51
    //   84: aload_2
    //   85: getfield 376	kotlinx/coroutines/ae:cause	Ljava/lang/Throwable;
    //   88: astore_2
    //   89: goto -32 -> 57
    //   92: astore_2
    //   93: aload_0
    //   94: new 557	kotlinx/coroutines/ah
    //   97: dup
    //   98: new 559	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 561
    //   105: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: ldc_w 568
    //   115: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_2
    //   126: invokespecial 575	kotlinx/coroutines/ah:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: checkcast 336	java/lang/Throwable
    //   132: invokevirtual 578	kotlinx/coroutines/ci:M	(Ljava/lang/Throwable;)V
    //   135: ldc_w 620
    //   138: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: aload_1
    //   143: invokeinterface 456 1 0
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +9 -> 159
    //   153: aload_0
    //   154: aload_1
    //   155: aload_2
    //   156: invokespecial 625	kotlinx/coroutines/ci:b	(Lkotlinx/coroutines/cn;Ljava/lang/Throwable;)V
    //   159: ldc_w 620
    //   162: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	ci
    //   0	166	1	parambw	bw
    //   0	166	2	paramObject	Object
    //   1	55	3	localObject	Object
    //   15	8	4	localv	v
    // Exception table:
    //   from	to	target	type
    //   64	72	92	finally
  }
  
  /* Error */
  private final void b(cn paramcn, Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc_w 626
    //   3: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 546	kotlinx/coroutines/internal/n
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 547	kotlinx/coroutines/internal/n:kDZ	()Ljava/lang/Object;
    //   17: checkcast 472	kotlinx/coroutines/internal/p
    //   20: astore_1
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_1
    //   24: aload 6
    //   26: invokestatic 348	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   29: ifne +120 -> 149
    //   32: aload_3
    //   33: astore 4
    //   35: aload_1
    //   36: instanceof 463
    //   39: ifeq +18 -> 57
    //   42: aload_1
    //   43: checkcast 463	kotlinx/coroutines/ch
    //   46: astore 7
    //   48: aload 7
    //   50: aload_2
    //   51: invokevirtual 552	kotlinx/coroutines/ch:N	(Ljava/lang/Throwable;)V
    //   54: aload_3
    //   55: astore 4
    //   57: aload_1
    //   58: invokevirtual 555	kotlinx/coroutines/internal/p:kEa	()Lkotlinx/coroutines/internal/p;
    //   61: astore_1
    //   62: aload 4
    //   64: astore_3
    //   65: goto -42 -> 23
    //   68: astore 8
    //   70: aload_3
    //   71: checkcast 336	java/lang/Throwable
    //   74: astore 5
    //   76: aload 5
    //   78: ifnonnull +61 -> 139
    //   81: aconst_null
    //   82: astore 5
    //   84: aload_3
    //   85: astore 4
    //   87: aload 5
    //   89: ifnonnull -32 -> 57
    //   92: aload_0
    //   93: checkcast 2	kotlinx/coroutines/ci
    //   96: astore_3
    //   97: new 557	kotlinx/coroutines/ah
    //   100: dup
    //   101: new 559	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 561
    //   108: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 7
    //   113: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: ldc_w 568
    //   119: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 566	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload 8
    //   131: invokespecial 575	kotlinx/coroutines/ah:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: astore 4
    //   136: goto -79 -> 57
    //   139: aload 5
    //   141: aload 8
    //   143: invokestatic 519	kotlin/b:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   146: goto -62 -> 84
    //   149: aload_3
    //   150: checkcast 336	java/lang/Throwable
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +8 -> 163
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 578	kotlinx/coroutines/ci:M	(Ljava/lang/Throwable;)V
    //   163: ldc_w 626
    //   166: invokestatic 263	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	ci
    //   0	170	1	paramcn	cn
    //   0	170	2	paramThrowable	Throwable
    //   22	128	3	localObject1	Object
    //   33	102	4	localObject2	Object
    //   74	66	5	localThrowable1	Throwable
    //   10	15	6	localn	n
    //   46	66	7	localch	ch
    //   68	74	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	54	68	finally
  }
  
  private final Object c(bw parambw, Object paramObject)
  {
    int j = 1;
    AppMethodBeat.i(188938);
    Object localObject2 = a(parambw);
    if (localObject2 == null)
    {
      parambw = cj.kCI();
      AppMethodBeat.o(188938);
      return parambw;
    }
    Object localObject1;
    if ((parambw instanceof c))
    {
      localObject1 = (c)parambw;
      if (localObject1 != null) {
        break label95;
      }
    }
    label95:
    int i;
    for (;;)
    {
      synchronized (new c((cn)localObject2, null))
      {
        if (((c)???)._isCompleting != 0)
        {
          parambw = cj.kCG();
          AppMethodBeat.o(188938);
          return parambw;
          localObject1 = null;
          break;
          ??? = localObject1;
          continue;
        }
        ((c)???)._isCompleting = 1;
        if ((??? != parambw) && (!ajvp.compareAndSet(this, parambw, ???)))
        {
          parambw = cj.kCI();
          AppMethodBeat.o(188938);
          return parambw;
        }
        if (!au.ASSERTIONS_ENABLED) {
          break label195;
        }
        if (!((c)???).kqK())
        {
          i = 1;
          if (i != 0) {
            break label195;
          }
          parambw = new AssertionError();
          AppMethodBeat.o(188938);
          throw parambw;
        }
      }
      i = 0;
    }
    label195:
    boolean bool = ((c)???).kCB();
    if ((paramObject instanceof ae))
    {
      localObject1 = (ae)paramObject;
      if (localObject1 != null) {
        ((c)???).W(((ae)localObject1).cause);
      }
      localObject1 = (Throwable)((c)???)._rootCause;
      if (bool) {
        break label343;
      }
      i = j;
      break label388;
    }
    label388:
    for (;;)
    {
      ah localah = ah.aiuX;
      if (localObject1 != null) {
        a((cn)localObject2, (Throwable)localObject1);
      }
      if ((parambw instanceof w))
      {
        localObject1 = (w)parambw;
        label285:
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          parambw = parambw.kCj();
          if (parambw != null) {
            break label360;
          }
          localObject2 = null;
        }
        label308:
        if ((localObject2 == null) || (!a((c)???, (w)localObject2, paramObject))) {
          break label372;
        }
        parambw = cj.ajwE;
        AppMethodBeat.o(188938);
        return parambw;
        localObject1 = null;
        break;
        label343:
        i = 0;
      }
      label360:
      label372:
      while (i == 0)
      {
        localObject1 = null;
        break;
        localObject1 = null;
        break label285;
        localObject2 = a((kotlinx.coroutines.internal.p)parambw);
        break label308;
        parambw = a((c)???, paramObject);
        AppMethodBeat.o(188938);
        return parambw;
      }
    }
  }
  
  private CancellationException d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(118289);
    if ((paramThrowable instanceof CancellationException)) {}
    for (Object localObject = (CancellationException)paramThrowable; localObject == null; localObject = null)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = kBt();
      }
      paramThrowable = (CancellationException)new cc((String)localObject, paramThrowable, (cb)this);
      AppMethodBeat.o(118289);
      return paramThrowable;
    }
    AppMethodBeat.o(118289);
    return localObject;
  }
  
  private final int iE(Object paramObject)
  {
    AppMethodBeat.i(118287);
    if ((paramObject instanceof bl))
    {
      if (((bl)paramObject).isActive)
      {
        AppMethodBeat.o(118287);
        return 0;
      }
      if (!ajvp.compareAndSet(this, paramObject, cj.kCE()))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      onStart();
      AppMethodBeat.o(118287);
      return 1;
    }
    if ((paramObject instanceof bv))
    {
      if (!ajvp.compareAndSet(this, paramObject, ((bv)paramObject).ajwp))
      {
        AppMethodBeat.o(118287);
        return -1;
      }
      onStart();
      AppMethodBeat.o(118287);
      return 1;
    }
    AppMethodBeat.o(118287);
    return 0;
  }
  
  private final Object iG(Object paramObject)
  {
    AppMethodBeat.i(188898);
    Object localObject;
    do
    {
      localObject = kCy();
      if ((!(localObject instanceof bw)) || (((localObject instanceof c)) && (((c)localObject)._isCompleting != 0)))
      {
        paramObject = cj.kCG();
        AppMethodBeat.o(188898);
        return paramObject;
      }
      localObject = ac(localObject, new ae(iH(paramObject)));
    } while (localObject == cj.kCI());
    AppMethodBeat.o(188898);
    return localObject;
  }
  
  private final Throwable iH(Object paramObject)
  {
    AppMethodBeat.i(118298);
    boolean bool;
    if (paramObject == null) {
      bool = true;
    }
    while (bool)
    {
      paramObject = (Throwable)paramObject;
      if (paramObject == null)
      {
        paramObject = (Throwable)new cc(kBt(), null, (cb)this);
        AppMethodBeat.o(118298);
        return paramObject;
        bool = paramObject instanceof Throwable;
      }
      else
      {
        AppMethodBeat.o(118298);
        return paramObject;
      }
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
      AppMethodBeat.o(118298);
      throw paramObject;
    }
    paramObject = (Throwable)((cq)paramObject).kCz();
    AppMethodBeat.o(118298);
    return paramObject;
  }
  
  private final Object iI(Object paramObject)
  {
    AppMethodBeat.i(188913);
    Throwable localThrowable = null;
    label154:
    label436:
    label451:
    label458:
    for (;;)
    {
      Object localObject2 = kCy();
      int i;
      if ((localObject2 instanceof c))
      {
        try
        {
          if (((c)localObject2).kqK())
          {
            paramObject = cj.kCH();
            return paramObject;
          }
          boolean bool = ((c)localObject2).kCB();
          if ((paramObject != null) || (!bool))
          {
            localObject1 = localThrowable;
            if (localThrowable == null) {
              localObject1 = iH(paramObject);
            }
            ((c)localObject2).W((Throwable)localObject1);
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
              a(((c)localObject2).ajwp, paramObject);
            }
            paramObject = cj.kCG();
            AppMethodBeat.o(188913);
            return paramObject;
            i = 0;
            break;
            paramObject = null;
          }
          if (!(localObject2 instanceof bw)) {
            break label436;
          }
        }
        finally
        {
          AppMethodBeat.o(188913);
        }
      }
      else
      {
        if (localThrowable != null) {
          break label451;
        }
        localThrowable = iH(paramObject);
      }
      for (Object localObject1 = localThrowable;; localObject1 = localThrowable)
      {
        if (((bw)localObject2).isActive())
        {
          localObject2 = (bw)localObject2;
          if (au.ASSERTIONS_ENABLED)
          {
            if (!(localObject2 instanceof c)) {}
            for (i = 1; i == 0; i = 0)
            {
              paramObject = new AssertionError();
              AppMethodBeat.o(188913);
              throw paramObject;
            }
          }
          if ((au.ASSERTIONS_ENABLED) && (!((bw)localObject2).isActive()))
          {
            paramObject = new AssertionError();
            AppMethodBeat.o(188913);
            throw paramObject;
          }
          cn localcn = a((bw)localObject2);
          if (localcn == null) {
            i = 0;
          }
          while (i != 0)
          {
            paramObject = cj.kCG();
            AppMethodBeat.o(188913);
            return paramObject;
            c localc = new c(localcn, (Throwable)localObject1);
            if (!ajvp.compareAndSet(this, localObject2, localc))
            {
              i = 0;
            }
            else
            {
              a(localcn, (Throwable)localObject1);
              i = 1;
            }
          }
        }
        localObject1 = ac(localObject2, new ae((Throwable)localObject1));
        if (localObject1 == cj.kCG())
        {
          paramObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Cannot happen in ", localObject2).toString());
          AppMethodBeat.o(188913);
          throw paramObject;
        }
        if (localObject1 == cj.kCI()) {
          break label458;
        }
        AppMethodBeat.o(188913);
        return localObject1;
        paramObject = cj.kCH();
        AppMethodBeat.o(188913);
        return paramObject;
        break;
      }
    }
  }
  
  private static String iL(Object paramObject)
  {
    AppMethodBeat.i(118310);
    if ((paramObject instanceof c))
    {
      if (((c)paramObject).kCB())
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
    if ((paramObject instanceof bw))
    {
      if (((bw)paramObject).isActive())
      {
        AppMethodBeat.o(118310);
        return "Active";
      }
      AppMethodBeat.o(118310);
      return "New";
    }
    if ((paramObject instanceof ae))
    {
      AppMethodBeat.o(118310);
      return "Cancelled";
    }
    AppMethodBeat.o(118310);
    return "Completed";
  }
  
  public void M(Throwable paramThrowable)
  {
    AppMethodBeat.i(118305);
    AppMethodBeat.o(118305);
    throw paramThrowable;
  }
  
  public boolean Q(Throwable paramThrowable)
  {
    AppMethodBeat.i(189155);
    if ((paramThrowable instanceof CancellationException))
    {
      AppMethodBeat.o(189155);
      return true;
    }
    if ((iF(paramThrowable)) && (kCw()))
    {
      AppMethodBeat.o(189155);
      return true;
    }
    AppMethodBeat.o(189155);
    return false;
  }
  
  public void T(Throwable paramThrowable)
  {
    AppMethodBeat.i(189134);
    iF(paramThrowable);
    AppMethodBeat.o(189134);
  }
  
  public final boolean U(Throwable paramThrowable)
  {
    AppMethodBeat.i(189168);
    boolean bool = iF(paramThrowable);
    AppMethodBeat.o(189168);
    return bool;
  }
  
  protected boolean V(Throwable paramThrowable)
  {
    return false;
  }
  
  public final bi a(boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(118290);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1) {
      if ((paramb instanceof cd))
      {
        localObject1 = (cd)paramb;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (cd)new bz(paramb);
        }
        localObject1 = (ch)localObject2;
        label52:
        ((ch)localObject1).ajwv = this;
      }
    }
    Object localObject4;
    label130:
    label165:
    cn localcn;
    for (;;)
    {
      localObject4 = kCy();
      if ((localObject4 instanceof bl))
      {
        if (((bl)localObject4).isActive)
        {
          if (!ajvp.compareAndSet(this, localObject4, localObject1)) {
            continue;
          }
          paramb = (bi)localObject1;
          AppMethodBeat.o(118290);
          return paramb;
          localObject1 = null;
          break;
          if ((paramb instanceof ch))
          {
            localObject1 = (ch)paramb;
            if (localObject1 != null) {
              break label165;
            }
            localObject2 = null;
          }
          for (;;)
          {
            if (localObject2 == null)
            {
              localObject1 = (ch)new ca(paramb);
              break;
              localObject1 = null;
              break label130;
              localObject2 = localObject1;
              if (au.ASSERTIONS_ENABLED)
              {
                if (!(localObject1 instanceof cd)) {}
                for (int i = 1;; i = 0)
                {
                  localObject2 = localObject1;
                  if (i != 0) {
                    break;
                  }
                  paramb = new AssertionError();
                  AppMethodBeat.o(118290);
                  throw paramb;
                }
              }
            }
          }
          localObject1 = localObject2;
          break label52;
        }
        localObject3 = (bl)localObject4;
        localObject2 = new cn();
        if (((bl)localObject3).isActive) {}
        for (localObject2 = (bw)localObject2;; localObject2 = (bw)new bv((cn)localObject2))
        {
          ajvp.compareAndSet(this, localObject3, localObject2);
          break;
        }
      }
      if (!(localObject4 instanceof bw)) {
        break label540;
      }
      localcn = ((bw)localObject4).kCj();
      if (localcn != null) {
        break label348;
      }
      if (localObject4 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        AppMethodBeat.o(118290);
        throw paramb;
      }
      a((ch)localObject4);
    }
    label348:
    Object localObject3 = co.ajwK;
    if ((paramBoolean1) && ((localObject4 instanceof c))) {}
    for (;;)
    {
      try
      {
        Throwable localThrowable = (Throwable)((c)localObject4)._rootCause;
        if ((localThrowable != null) && ((!(paramb instanceof w)) || (((c)localObject4)._isCompleting != 0))) {
          break label607;
        }
        boolean bool = a(localObject4, localcn, (ch)localObject1);
        if (!bool) {
          break;
        }
        if (localThrowable == null)
        {
          paramb = (bi)localObject1;
          return paramb;
        }
        localObject2 = localObject1;
        localObject3 = ah.aiuX;
        localObject3 = localObject2;
        localObject2 = localThrowable;
        if (localObject2 != null)
        {
          if (paramBoolean2) {
            paramb.invoke(localObject2);
          }
          paramb = (bi)localObject3;
          AppMethodBeat.o(118290);
          return paramb;
        }
      }
      finally
      {
        AppMethodBeat.o(118290);
      }
      if (!a(localObject4, localcn, (ch)localObject1)) {
        break;
      }
      paramb = (bi)localObject1;
      AppMethodBeat.o(118290);
      return paramb;
      label540:
      if (paramBoolean2)
      {
        if (!(localObject4 instanceof ae)) {
          break label591;
        }
        localObject1 = (ae)localObject4;
        if (localObject1 != null) {
          break label597;
        }
      }
      label591:
      label597:
      for (localObject1 = null;; localObject1 = ((ae)localObject1).cause)
      {
        paramb.invoke(localObject1);
        paramb = (bi)co.ajwK;
        AppMethodBeat.o(118290);
        return paramb;
        localObject1 = null;
        break;
      }
      label607:
      localObject2 = localObject3;
      continue;
      localObject2 = null;
    }
  }
  
  public final v a(x paramx)
  {
    AppMethodBeat.i(118304);
    paramx = (v)cb.a.a((cb)this, true, false, (kotlin.g.a.b)new w(paramx), 2);
    AppMethodBeat.o(118304);
    return paramx;
  }
  
  public void a(CancellationException paramCancellationException)
  {
    AppMethodBeat.i(189118);
    if (paramCancellationException == null) {
      paramCancellationException = (CancellationException)new cc(kBt(), null, (cb)this);
    }
    for (;;)
    {
      T((Throwable)paramCancellationException);
      AppMethodBeat.o(189118);
      return;
    }
  }
  
  public final void a(cq paramcq)
  {
    AppMethodBeat.i(118295);
    iF(paramcq);
    AppMethodBeat.o(118295);
  }
  
  public final Object ay(d<? super ah> paramd)
  {
    AppMethodBeat.i(189095);
    Object localObject = kCy();
    if (!(localObject instanceof bw)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label58;
      }
      cg.g(paramd.getContext());
      paramd = ah.aiuX;
      AppMethodBeat.o(189095);
      return paramd;
      if (iE(localObject) < 0) {
        break;
      }
    }
    label58:
    localObject = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject).kBA();
    p localp = (p)localObject;
    s.a(localp, a(false, true, (kotlin.g.a.b)new ct((d)localp)));
    localObject = ((q)localObject).getResult();
    if (localObject == a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    paramd = (d<? super ah>)localObject;
    if (localObject != a.aiwj) {
      paramd = ah.aiuX;
    }
    if (paramd == a.aiwj)
    {
      AppMethodBeat.o(189095);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(189095);
    return paramd;
  }
  
  public final Object az(d<Object> paramd)
  {
    AppMethodBeat.i(189299);
    do
    {
      localObject = kCy();
      if (!(localObject instanceof bw))
      {
        if ((localObject instanceof ae))
        {
          localObject = ((ae)localObject).cause;
          if (!au.ajvP)
          {
            AppMethodBeat.o(189299);
            throw ((Throwable)localObject);
          }
          if (!(paramd instanceof e))
          {
            AppMethodBeat.o(189299);
            throw ((Throwable)localObject);
          }
          paramd = ab.a((Throwable)localObject, (e)paramd);
          AppMethodBeat.o(189299);
          throw paramd;
        }
        paramd = cj.iN(localObject);
        AppMethodBeat.o(189299);
        return paramd;
      }
    } while (iE(localObject) < 0);
    Object localObject = new a(kotlin.d.a.b.au(paramd), this);
    ((a)localObject).kBA();
    s.a((p)localObject, a(false, true, (kotlin.g.a.b)new cs((q)localObject)));
    localObject = ((a)localObject).getResult();
    if (localObject == a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(189299);
    return localObject;
  }
  
  public final bi bh(kotlin.g.a.b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(189066);
    paramb = a(false, true, paramb);
    AppMethodBeat.o(189066);
    return paramb;
  }
  
  protected final void f(cb paramcb)
  {
    AppMethodBeat.i(189001);
    if (au.ASSERTIONS_ENABLED)
    {
      if ((v)this._parentHandle == null) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramcb = new AssertionError();
        AppMethodBeat.o(189001);
        throw paramcb;
      }
    }
    if (paramcb == null)
    {
      this._parentHandle = ((v)co.ajwK);
      AppMethodBeat.o(189001);
      return;
    }
    paramcb.start();
    paramcb = paramcb.a((x)this);
    this._parentHandle = paramcb;
    if (isCompleted())
    {
      paramcb.dispose();
      this._parentHandle = ((v)co.ajwK);
    }
    AppMethodBeat.o(189001);
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
    return (f.c)cb.ajws;
  }
  
  public final boolean iF(Object paramObject)
  {
    AppMethodBeat.i(189179);
    Object localObject1 = cj.kCG();
    if (kBR())
    {
      localObject2 = iG(paramObject);
      localObject1 = localObject2;
      if (localObject2 == cj.ajwE)
      {
        AppMethodBeat.o(189179);
        return true;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == cj.kCG()) {
      localObject2 = iI(paramObject);
    }
    if (localObject2 == cj.kCG())
    {
      AppMethodBeat.o(189179);
      return true;
    }
    if (localObject2 == cj.ajwE)
    {
      AppMethodBeat.o(189179);
      return true;
    }
    if (localObject2 == cj.kCH())
    {
      AppMethodBeat.o(189179);
      return false;
    }
    iw(localObject2);
    AppMethodBeat.o(189179);
    return true;
  }
  
  public final boolean iJ(Object paramObject)
  {
    AppMethodBeat.i(189196);
    Object localObject;
    do
    {
      localObject = ac(kCy(), paramObject);
      if (localObject == cj.kCG())
      {
        AppMethodBeat.o(189196);
        return false;
      }
      if (localObject == cj.ajwE)
      {
        AppMethodBeat.o(189196);
        return true;
      }
    } while (localObject == cj.kCI());
    iw(localObject);
    AppMethodBeat.o(189196);
    return true;
  }
  
  public final Object iK(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(189210);
    Object localObject2;
    label94:
    do
    {
      localObject2 = ac(kCy(), paramObject);
      if (localObject2 == cj.kCG())
      {
        localObject2 = "Job " + this + " is already complete or completing, but is being completed with " + paramObject;
        if ((paramObject instanceof ae))
        {
          paramObject = (ae)paramObject;
          if (paramObject != null) {
            break label94;
          }
        }
        for (paramObject = localObject1;; paramObject = paramObject.cause)
        {
          paramObject = new IllegalStateException((String)localObject2, paramObject);
          AppMethodBeat.o(189210);
          throw paramObject;
          paramObject = null;
          break;
        }
      }
    } while (localObject2 == cj.kCI());
    AppMethodBeat.o(189210);
    return localObject2;
  }
  
  public boolean isActive()
  {
    AppMethodBeat.i(118278);
    Object localObject = kCy();
    if (((localObject instanceof bw)) && (((bw)localObject).isActive()))
    {
      AppMethodBeat.o(118278);
      return true;
    }
    AppMethodBeat.o(118278);
    return false;
  }
  
  public final boolean isCancelled()
  {
    AppMethodBeat.i(189033);
    Object localObject = kCy();
    if (((localObject instanceof ae)) || (((localObject instanceof c)) && (((c)localObject).kCB())))
    {
      AppMethodBeat.o(189033);
      return true;
    }
    AppMethodBeat.o(189033);
    return false;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(189025);
    if (!(kCy() instanceof bw))
    {
      AppMethodBeat.o(189025);
      return true;
    }
    AppMethodBeat.o(189025);
    return false;
  }
  
  protected void iu(Object paramObject) {}
  
  protected void iw(Object paramObject) {}
  
  public boolean kBR()
  {
    return false;
  }
  
  protected String kBt()
  {
    return "Job was cancelled";
  }
  
  public String kBu()
  {
    AppMethodBeat.i(118309);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(118309);
    return str;
  }
  
  protected boolean kBx()
  {
    return false;
  }
  
  public final Object kCA()
  {
    AppMethodBeat.i(189292);
    Object localObject = kCy();
    if (!(localObject instanceof bw)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("This job has not completed yet".toString());
      AppMethodBeat.o(189292);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof ae))
    {
      localObject = ((ae)localObject).cause;
      AppMethodBeat.o(189292);
      throw ((Throwable)localObject);
    }
    localObject = cj.iN(localObject);
    AppMethodBeat.o(189292);
    return localObject;
  }
  
  public final CancellationException kCu()
  {
    AppMethodBeat.i(118288);
    Object localObject = kCy();
    if ((localObject instanceof c))
    {
      localObject = (Throwable)((c)localObject)._rootCause;
      if (localObject == null)
      {
        localObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Job is still new or active: ", this).toString());
        AppMethodBeat.o(118288);
        throw ((Throwable)localObject);
      }
      localObject = d((Throwable)localObject, kotlin.g.b.s.X(getClass().getSimpleName(), " is cancelling"));
      AppMethodBeat.o(118288);
      return localObject;
    }
    if ((localObject instanceof bw))
    {
      localObject = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Job is still new or active: ", this).toString());
      AppMethodBeat.o(118288);
      throw ((Throwable)localObject);
    }
    if ((localObject instanceof ae))
    {
      localObject = d(((ae)localObject).cause, null);
      AppMethodBeat.o(118288);
      return localObject;
    }
    localObject = (CancellationException)new cc(kotlin.g.b.s.X(getClass().getSimpleName(), " has completed normally"), null, (cb)this);
    AppMethodBeat.o(118288);
    return localObject;
  }
  
  public final h<cb> kCv()
  {
    AppMethodBeat.i(189222);
    h localh = k.w((m)new e(this, null));
    AppMethodBeat.o(189222);
    return localh;
  }
  
  public boolean kCw()
  {
    return true;
  }
  
  public final Object kCy()
  {
    AppMethodBeat.i(118277);
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof kotlinx.coroutines.internal.w))
      {
        AppMethodBeat.o(118277);
        return localObject;
      }
      ((kotlinx.coroutines.internal.w)localObject).jj(this);
    }
  }
  
  public final CancellationException kCz()
  {
    AppMethodBeat.i(189186);
    Object localObject2 = kCy();
    Object localObject1;
    if ((localObject2 instanceof c))
    {
      localObject1 = (Throwable)((c)localObject2)._rootCause;
      if (!(localObject1 instanceof CancellationException)) {
        break label138;
      }
    }
    label138:
    for (CancellationException localCancellationException = (CancellationException)localObject1;; localCancellationException = null)
    {
      if (localCancellationException != null) {
        break label143;
      }
      localObject1 = (CancellationException)new cc(kotlin.g.b.s.X("Parent job is ", iL(localObject2)), (Throwable)localObject1, (cb)this);
      AppMethodBeat.o(189186);
      return localObject1;
      if ((localObject2 instanceof ae))
      {
        localObject1 = ((ae)localObject2).cause;
        break;
      }
      if ((localObject2 instanceof bw))
      {
        localObject1 = (Throwable)new IllegalStateException(kotlin.g.b.s.X("Cannot be cancelling child in this state: ", localObject2).toString());
        AppMethodBeat.o(189186);
        throw ((Throwable)localObject1);
      }
      localObject1 = null;
      break;
    }
    label143:
    AppMethodBeat.o(189186);
    return localCancellationException;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(118315);
    paramc = f.b.a.b((f.b)this, paramc);
    AppMethodBeat.o(118315);
    return paramc;
  }
  
  protected void onStart() {}
  
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
      switch (iE(kCy()))
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
    String str = new StringBuilder().append(kBu()).append('{').append(iL(kCy())).append('}').toString() + '@' + Integer.toHexString(System.identityHashCode(this));
    AppMethodBeat.o(118308);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<T>
    extends q<T>
  {
    private final ci ajwv;
    
    public a(d<? super T> paramd, ci paramci)
    {
      super(1);
      AppMethodBeat.i(118133);
      this.ajwv = paramci;
      AppMethodBeat.o(118133);
    }
    
    public final Throwable c(cb paramcb)
    {
      AppMethodBeat.i(118131);
      Object localObject = this.ajwv.kCy();
      if ((localObject instanceof ci.c))
      {
        Throwable localThrowable = (Throwable)((ci.c)localObject)._rootCause;
        if (localThrowable != null)
        {
          AppMethodBeat.o(118131);
          return localThrowable;
        }
      }
      if ((localObject instanceof ae))
      {
        paramcb = ((ae)localObject).cause;
        AppMethodBeat.o(118131);
        return paramcb;
      }
      paramcb = (Throwable)paramcb.kCu();
      AppMethodBeat.o(118131);
      return paramcb;
    }
    
    protected final String kBJ()
    {
      AppMethodBeat.i(118132);
      AppMethodBeat.o(118132);
      return "AwaitContinuation";
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends ch
  {
    private final ci ajww;
    private final ci.c ajwx;
    private final w ajwy;
    private final Object ajwz;
    
    public b(ci paramci, ci.c paramc, w paramw, Object paramObject)
    {
      AppMethodBeat.i(118262);
      this.ajww = paramci;
      this.ajwx = paramc;
      this.ajwy = paramw;
      this.ajwz = paramObject;
      AppMethodBeat.o(118262);
    }
    
    public final void N(Throwable paramThrowable)
    {
      AppMethodBeat.i(118259);
      ci.a(this.ajww, this.ajwx, this.ajwy, this.ajwz);
      AppMethodBeat.o(118259);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements bw
  {
    final cn ajwp;
    
    public c(cn paramcn, Throwable paramThrowable)
    {
      AppMethodBeat.i(118225);
      this.ajwp = paramcn;
      this._isCompleting = 0;
      this._rootCause = paramThrowable;
      this._exceptionsHolder = null;
      AppMethodBeat.o(118225);
    }
    
    static ArrayList<Throwable> kCC()
    {
      AppMethodBeat.i(118223);
      ArrayList localArrayList = new ArrayList(4);
      AppMethodBeat.o(118223);
      return localArrayList;
    }
    
    public final void W(Throwable paramThrowable)
    {
      AppMethodBeat.i(118222);
      Object localObject1 = (Throwable)this._rootCause;
      if (localObject1 == null)
      {
        this._rootCause = paramThrowable;
        AppMethodBeat.o(118222);
        return;
      }
      if (paramThrowable == localObject1)
      {
        AppMethodBeat.o(118222);
        return;
      }
      Object localObject2 = this._exceptionsHolder;
      if (localObject2 == null)
      {
        this._exceptionsHolder = paramThrowable;
        AppMethodBeat.o(118222);
        return;
      }
      if ((localObject2 instanceof Throwable))
      {
        if (paramThrowable == localObject2)
        {
          AppMethodBeat.o(118222);
          return;
        }
        localObject1 = kCC();
        ((ArrayList)localObject1).add(localObject2);
        ((ArrayList)localObject1).add(paramThrowable);
        paramThrowable = ah.aiuX;
        this._exceptionsHolder = localObject1;
        AppMethodBeat.o(118222);
        return;
      }
      if ((localObject2 instanceof ArrayList))
      {
        ((ArrayList)localObject2).add(paramThrowable);
        AppMethodBeat.o(118222);
        return;
      }
      paramThrowable = (Throwable)new IllegalStateException(kotlin.g.b.s.X("State is ", localObject2).toString());
      AppMethodBeat.o(118222);
      throw paramThrowable;
    }
    
    public final boolean isActive()
    {
      return (Throwable)this._rootCause == null;
    }
    
    public final boolean kCB()
    {
      return (Throwable)this._rootCause != null;
    }
    
    public final cn kCj()
    {
      return this.ajwp;
    }
    
    public final boolean kqK()
    {
      AppMethodBeat.i(118221);
      if (this._exceptionsHolder == cj.kCJ())
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
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends p.a
  {
    public d(kotlinx.coroutines.internal.p paramp, ci paramci, Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.j
    implements m<kotlin.m.j<? super x>, d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    e(ci paramci, d<? super e> paramd)
    {
      super();
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(188915);
      paramd = new e(this.ajwB, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(188915);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188908);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188908);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localj = (kotlin.m.j)this.L$0;
        paramObject = this.ajwB.kCy();
        if ((paramObject instanceof w))
        {
          paramObject = ((w)paramObject).ajvu;
          localObject1 = (d)this;
          this.label = 1;
          if (localj.d(paramObject, (d)localObject1) == locala)
          {
            AppMethodBeat.o(188908);
            return locala;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        do
        {
          do
          {
            do
            {
              paramObject = ah.aiuX;
              AppMethodBeat.o(188908);
              return paramObject;
            } while (!(paramObject instanceof bw));
            paramObject = ((bw)paramObject).kCj();
          } while (paramObject == null);
          localObject1 = (n)paramObject;
          paramObject = (kotlinx.coroutines.internal.p)((n)localObject1).kDZ();
        } while (kotlin.g.b.s.p(paramObject, localObject1));
        if (!(paramObject instanceof w)) {
          break label277;
        }
        localObject2 = ((w)paramObject).ajvu;
        this.L$0 = localj;
        this.Uf = localObject1;
        this.VC = paramObject;
        this.label = 2;
        if (localj.d(localObject2, this) != locala) {
          break label277;
        }
        AppMethodBeat.o(188908);
        return locala;
      }
      Object localObject2 = (kotlinx.coroutines.internal.p)this.VC;
      Object localObject1 = (n)this.Uf;
      kotlin.m.j localj = (kotlin.m.j)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject2;
      label277:
      for (;;)
      {
        paramObject = o.jk(paramObject.kDZ());
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ci
 * JD-Core Version:    0.7.0.1
 */