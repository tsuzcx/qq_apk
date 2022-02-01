package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.t;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.l.a;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.m;
import kotlinx.coroutines.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "()V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onReceiveDequeued", "onReceiveEnqueued", "poll", "()Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "receiveOrNullResult", "result", "(Ljava/lang/Object;)Ljava/lang/Object;", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"})
public abstract class a<E>
  extends c<E>
  implements g<E>
{
  private final void a(m<?> paramm, s<?> params)
  {
    paramm.am((kotlin.g.a.b)new a.b(this, params));
  }
  
  public final boolean H(Throwable paramThrowable)
  {
    boolean bool = I(paramThrowable);
    JG(bool);
    return bool;
  }
  
  protected void JG(boolean paramBoolean)
  {
    k localk = iSj();
    if (localk == null) {
      throw ((Throwable)new IllegalStateException("Cannot happen".toString()));
    }
    Object localObject = null;
    for (;;)
    {
      kotlinx.coroutines.internal.l locall = localk.iSN();
      if ((locall instanceof j)) {
        break;
      }
      if ((ap.iRg()) && (!(locall instanceof w))) {
        throw ((Throwable)new AssertionError());
      }
      if (!locall.remove())
      {
        locall.iSP();
      }
      else
      {
        if (locall == null) {
          throw new t("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        }
        localObject = i.S(localObject, (w)locall);
      }
    }
    if (localObject != null)
    {
      if ((localObject instanceof ArrayList)) {
        break label134;
      }
      ((w)localObject).d(localk);
    }
    for (;;)
    {
      return;
      label134:
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
      }
      localObject = (ArrayList)localObject;
      int i = ((ArrayList)localObject).size() - 1;
      while (i >= 0)
      {
        ((w)((ArrayList)localObject).get(i)).d(localk);
        i -= 1;
      }
    }
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    if (paramCancellationException != null) {}
    for (paramCancellationException = (Throwable)paramCancellationException;; paramCancellationException = (Throwable)new CancellationException(getClass().getSimpleName() + " was cancelled"))
    {
      H(paramCancellationException);
      return;
    }
  }
  
  protected boolean a(s<? super E> params)
  {
    int i;
    if (iSb())
    {
      locall1 = (kotlinx.coroutines.internal.l)iSg();
      do
      {
        localObject = locall1.iSN();
        if (!(localObject instanceof w)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      } while (!((kotlinx.coroutines.internal.l)localObject).a((kotlinx.coroutines.internal.l)params, locall1));
      return true;
    }
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)iSg();
    Object localObject = (l.a)new c((kotlinx.coroutines.internal.l)params, (kotlinx.coroutines.internal.l)params, this);
    for (;;)
    {
      kotlinx.coroutines.internal.l locall2 = locall1.iSN();
      if (!(locall2 instanceof w)) {}
      for (i = 1; i == 0; i = 0) {
        return false;
      }
      switch (locall2.a((kotlinx.coroutines.internal.l)params, locall1, (l.a)localObject))
      {
      }
    }
    return true;
    return false;
  }
  
  protected abstract boolean iSb();
  
  protected abstract boolean iSc();
  
  protected Object iSd()
  {
    w localw;
    v localv;
    do
    {
      localw = iSl();
      if (localw == null) {
        return b.abyf;
      }
      localv = localw.iSp();
    } while (localv == null);
    if (ap.iRg())
    {
      if (localv == o.abwj) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    localw.iSq();
    return localw.iSo();
  }
  
  protected final u<E> iSe()
  {
    return super.iSe();
  }
  
  public final Object q(d<? super E> paramd)
  {
    Object localObject = iSd();
    if ((localObject != b.abyf) && (!(localObject instanceof k))) {
      return localObject;
    }
    return a(0, paramd);
  }
  
  public final Object r(d<? super z<? extends E>> paramd)
  {
    Object localObject = iSd();
    if (localObject != b.abyf)
    {
      if ((localObject instanceof k)) {
        paramd = z.abyF;
      }
      for (paramd = z.constructor-impl(new z.a(((k)localObject).abyu));; paramd = z.constructor-impl(localObject))
      {
        return z.gu(paramd);
        paramd = z.abyF;
      }
    }
    return a(2, paramd);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"})
  static final class a<E>
    extends s<E>
  {
    public final m<Object> abxd;
    public final int abya;
    
    public a(m<Object> paramm, int paramInt)
    {
      this.abxd = paramm;
      this.abya = paramInt;
    }
    
    public final void a(k<?> paramk)
    {
      AppMethodBeat.i(204403);
      if ((this.abya == 1) && (paramk.abyu == null))
      {
        paramk = (d)this.abxd;
        localObject1 = Result.Companion;
        paramk.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(204403);
        return;
      }
      if (this.abya == 2)
      {
        localObject1 = (d)this.abxd;
        localObject2 = z.abyF;
        paramk = z.gu(z.constructor-impl(new z.a(paramk.abyu)));
        localObject2 = Result.Companion;
        ((d)localObject1).resumeWith(Result.constructor-impl(paramk));
        AppMethodBeat.o(204403);
        return;
      }
      Object localObject1 = (d)this.abxd;
      paramk = paramk.iSz();
      Object localObject2 = Result.Companion;
      ((d)localObject1).resumeWith(Result.constructor-impl(ResultKt.createFailure(paramk)));
      AppMethodBeat.o(204403);
    }
    
    public final Object gm(E paramE)
    {
      AppMethodBeat.i(204400);
      switch (this.abya)
      {
      default: 
        AppMethodBeat.o(204400);
        return paramE;
      }
      z.b localb = z.abyF;
      paramE = z.gu(z.constructor-impl(paramE));
      AppMethodBeat.o(204400);
      return paramE;
    }
    
    public final v gn(E paramE)
    {
      AppMethodBeat.i(204401);
      paramE = this.abxd.fV(gm(paramE));
      if (paramE == null)
      {
        AppMethodBeat.o(204401);
        return null;
      }
      if (ap.iRg())
      {
        if (paramE == o.abwj) {}
        for (int i = 1; i == 0; i = 0)
        {
          paramE = (Throwable)new AssertionError();
          AppMethodBeat.o(204401);
          throw paramE;
        }
      }
      paramE = o.abwj;
      AppMethodBeat.o(204401);
      return paramE;
    }
    
    public final void iSf()
    {
      AppMethodBeat.i(204402);
      this.abxd.fW(o.abwj);
      AppMethodBeat.o(204402);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204405);
      String str = "ReceiveElement@" + Integer.toHexString(System.identityHashCode(this)) + "[receiveMode=" + this.abya + ']';
      AppMethodBeat.o(204405);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class c
    extends l.a
  {
    public c(kotlinx.coroutines.internal.l paraml1, kotlinx.coroutines.internal.l paraml2, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */