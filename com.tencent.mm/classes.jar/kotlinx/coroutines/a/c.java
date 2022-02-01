package kotlinx.coroutines.a;

import TE;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.ag;
import kotlin.t;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.cn;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.l.a;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "<init>", "()V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendFair$kotlinx_coroutines_core", "sendFair", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFull", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"})
public abstract class c<E>
  implements x<E>
{
  private static final AtomicReferenceFieldUpdater abyj = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
  private final j abyi = new j();
  private volatile Object onCloseHandler = null;
  
  private static void a(d<?> paramd, k<?> paramk)
  {
    c(paramk);
    paramk = paramk.iSy();
    Result.Companion localCompanion = Result.Companion;
    paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramk)));
  }
  
  private static Throwable b(k<?> paramk)
  {
    c(paramk);
    return paramk.iSy();
  }
  
  private static void c(k<?> paramk)
  {
    Object localObject1 = null;
    kotlinx.coroutines.internal.l locall = paramk.iSN();
    Object localObject2 = locall;
    if (!(locall instanceof s)) {
      localObject2 = null;
    }
    localObject2 = (s)localObject2;
    if (localObject2 == null) {
      if (localObject1 != null)
      {
        if ((localObject1 instanceof ArrayList)) {
          break label73;
        }
        ((s)localObject1).a(paramk);
      }
    }
    for (;;)
    {
      return;
      if (!((s)localObject2).remove())
      {
        ((s)localObject2).iSP();
        break;
      }
      localObject1 = i.S(localObject1, localObject2);
      break;
      label73:
      if (localObject1 == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
      }
      localObject1 = (ArrayList)localObject1;
      int i = ((ArrayList)localObject1).size() - 1;
      while (i >= 0)
      {
        ((s)((ArrayList)localObject1).get(i)).a(paramk);
        i -= 1;
      }
    }
  }
  
  private final int iSm()
  {
    int i = 0;
    j localj = this.abyi;
    Object localObject = localj.iSL();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
    localObject = (kotlinx.coroutines.internal.l)localObject;
    while ((kotlin.g.b.p.h(localObject, localj) ^ true))
    {
      int j = i;
      if ((localObject instanceof kotlinx.coroutines.internal.l)) {
        j = i + 1;
      }
      localObject = kotlinx.coroutines.internal.k.gx(((kotlinx.coroutines.internal.l)localObject).iSL());
      i = j;
    }
    return i;
  }
  
  public boolean I(Throwable paramThrowable)
  {
    Object localObject = new k(paramThrowable);
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)this.abyi;
    kotlinx.coroutines.internal.l locall2 = locall1.iSN();
    int i;
    label36:
    boolean bool;
    if (!(locall2 instanceof k))
    {
      i = 1;
      if (i != 0) {
        break label112;
      }
      bool = false;
      label42:
      if (!bool) {
        break label132;
      }
    }
    for (;;)
    {
      c((k)localObject);
      if (bool)
      {
        localObject = this.onCloseHandler;
        if ((localObject != null) && (localObject != b.abyh) && (abyj.compareAndSet(this, localObject, b.abyh))) {
          ((kotlin.g.a.b)ag.x(localObject, 1)).invoke(paramThrowable);
        }
      }
      return bool;
      i = 0;
      break label36;
      label112:
      if (!locall2.a((kotlinx.coroutines.internal.l)localObject, locall1)) {
        break;
      }
      bool = true;
      break label42;
      label132:
      localObject = this.abyi.iSN();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
      }
      localObject = (k)localObject;
    }
  }
  
  protected Object a(w paramw)
  {
    if (iSh())
    {
      locall1 = (kotlinx.coroutines.internal.l)this.abyi;
      do
      {
        localObject = locall1.iSN();
        if ((localObject instanceof u)) {
          return localObject;
        }
      } while (!((kotlinx.coroutines.internal.l)localObject).a((kotlinx.coroutines.internal.l)paramw, locall1));
      return null;
    }
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)this.abyi;
    Object localObject = (l.a)new b((kotlinx.coroutines.internal.l)paramw, (kotlinx.coroutines.internal.l)paramw, this);
    for (;;)
    {
      kotlinx.coroutines.internal.l locall2 = locall1.iSN();
      if ((locall2 instanceof u)) {
        return locall2;
      }
      switch (locall2.a((kotlinx.coroutines.internal.l)paramw, locall1, (l.a)localObject))
      {
      }
    }
    for (int i = 1; i == 0; i = 0) {
      return b.abyg;
    }
  }
  
  public final Object c(E paramE, d<? super kotlin.x> paramd)
  {
    if (go(paramE) == b.abyd)
    {
      paramE = kotlin.x.aazN;
      return paramE;
    }
    Object localObject1 = kotlinx.coroutines.p.l(kotlin.d.a.b.k(paramd));
    Object localObject2 = (m)localObject1;
    label33:
    int i;
    label58:
    Object localObject3;
    Object localObject4;
    if ((!(kotlinx.coroutines.internal.k.gx(this.abyi.iSL()) instanceof u)) && (iSi()))
    {
      i = 1;
      if (i == 0) {
        break label222;
      }
      localObject3 = new y(paramE, (m)localObject2);
      localObject4 = a((w)localObject3);
      if (localObject4 != null) {
        break label157;
      }
      ((m)localObject2).am((kotlin.g.a.b)new cn((kotlinx.coroutines.internal.l)localObject3));
    }
    for (;;)
    {
      localObject1 = ((n)localObject1).getResult();
      if (localObject1 == a.aaAA) {
        kotlin.g.b.p.k(paramd, "frame");
      }
      paramE = (TE)localObject1;
      if (localObject1 == a.aaAA) {
        break;
      }
      return kotlin.x.aazN;
      i = 0;
      break label58;
      label157:
      if ((localObject4 instanceof k))
      {
        a((d)localObject2, (k)localObject4);
      }
      else
      {
        if ((localObject4 != b.abyg) && (!(localObject4 instanceof s))) {
          throw ((Throwable)new IllegalStateException("enqueueSend returned ".concat(String.valueOf(localObject4)).toString()));
        }
        label222:
        localObject3 = go(paramE);
        if (localObject3 == b.abyd)
        {
          paramE = (d)localObject2;
          localObject2 = kotlin.x.aazN;
          localObject3 = Result.Companion;
          paramE.resumeWith(Result.constructor-impl(localObject2));
        }
        else
        {
          if (localObject3 == b.abye) {
            break label33;
          }
          if (!(localObject3 instanceof k)) {
            break label299;
          }
          a((d)localObject2, (k)localObject3);
        }
      }
    }
    label299:
    throw ((Throwable)new IllegalStateException("offerInternal returned ".concat(String.valueOf(localObject3)).toString()));
  }
  
  protected Object go(E paramE)
  {
    u localu;
    v localv;
    do
    {
      localu = iSe();
      if (localu == null) {
        return b.abye;
      }
      localv = localu.gn(paramE);
    } while (localv == null);
    if (ap.iRg())
    {
      if (localv == o.abwj) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    localu.iSf();
    return localu.iSA();
  }
  
  protected final u<?> gp(E paramE)
  {
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)this.abyi;
    paramE = (kotlinx.coroutines.internal.l)new a(paramE);
    kotlinx.coroutines.internal.l locall2;
    do
    {
      locall2 = locall1.iSN();
      if ((locall2 instanceof u)) {
        return (u)locall2;
      }
    } while (!locall2.a(paramE, locall1));
    return null;
  }
  
  protected u<E> iSe()
  {
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)this.abyi;
    for (;;)
    {
      Object localObject = locall1.iSL();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      }
      localObject = (kotlinx.coroutines.internal.l)localObject;
      if (localObject == locall1) {
        localObject = null;
      }
      kotlinx.coroutines.internal.l locall2;
      do
      {
        do
        {
          for (;;)
          {
            return (u)localObject;
            if ((localObject instanceof u)) {
              break;
            }
            localObject = null;
          }
        } while ((((u)localObject instanceof k)) && (!((kotlinx.coroutines.internal.l)localObject).isRemoved()));
        locall2 = ((kotlinx.coroutines.internal.l)localObject).iSO();
      } while (locall2 == null);
      locall2.iSQ();
    }
  }
  
  protected final j iSg()
  {
    return this.abyi;
  }
  
  protected abstract boolean iSh();
  
  protected abstract boolean iSi();
  
  protected final k<?> iSj()
  {
    kotlinx.coroutines.internal.l locall = this.abyi.iSN();
    Object localObject = locall;
    if (!(locall instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      c((k)localObject);
      return localObject;
    }
    return null;
  }
  
  protected final k<?> iSk()
  {
    kotlinx.coroutines.internal.l locall = kotlinx.coroutines.internal.k.gx(this.abyi.iSL());
    Object localObject = locall;
    if (!(locall instanceof k)) {
      localObject = null;
    }
    localObject = (k)localObject;
    if (localObject != null)
    {
      c((k)localObject);
      return localObject;
    }
    return null;
  }
  
  protected final w iSl()
  {
    kotlinx.coroutines.internal.l locall1 = (kotlinx.coroutines.internal.l)this.abyi;
    for (;;)
    {
      Object localObject = locall1.iSL();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
      }
      localObject = (kotlinx.coroutines.internal.l)localObject;
      if (localObject == locall1) {
        localObject = null;
      }
      kotlinx.coroutines.internal.l locall2;
      do
      {
        do
        {
          for (;;)
          {
            return (w)localObject;
            if ((localObject instanceof w)) {
              break;
            }
            localObject = null;
          }
        } while ((((w)localObject instanceof k)) && (!((kotlinx.coroutines.internal.l)localObject).isRemoved()));
        locall2 = ((kotlinx.coroutines.internal.l)localObject).iSO();
      } while (locall2 == null);
      locall2.iSQ();
    }
  }
  
  protected String iSn()
  {
    return "";
  }
  
  public final boolean offer(E paramE)
  {
    paramE = go(paramE);
    if (paramE == b.abyd) {
      return true;
    }
    if (paramE == b.abye)
    {
      paramE = iSj();
      if (paramE == null) {
        return false;
      }
      throw kotlinx.coroutines.internal.u.L(b(paramE));
    }
    if ((paramE instanceof k)) {
      throw kotlinx.coroutines.internal.u.L(b((k)paramE));
    }
    throw ((Throwable)new IllegalStateException("offerInternal returned ".concat(String.valueOf(paramE)).toString()));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('{');
    kotlinx.coroutines.internal.l locall1 = this.abyi.iSM();
    Object localObject;
    if (locall1 == this.abyi)
    {
      localObject = "EmptyQueue";
      return (String)localObject + '}' + iSn();
    }
    String str;
    if ((locall1 instanceof k)) {
      str = locall1.toString();
    }
    for (;;)
    {
      kotlinx.coroutines.internal.l locall2 = this.abyi.iSN();
      localObject = str;
      if (locall2 == locall1) {
        break;
      }
      str = str + ",queueSize=" + iSm();
      localObject = str;
      if (!(locall2 instanceof k)) {
        break;
      }
      localObject = str + ",closedForSend=" + locall2;
      break;
      if ((locall1 instanceof s)) {
        str = "ReceiveQueued";
      } else if ((locall1 instanceof w)) {
        str = "SendQueued";
      } else {
        str = "UNEXPECTED:".concat(String.valueOf(locall1));
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"})
  public static final class a<E>
    extends w
  {
    public final E aaBC;
    
    public a(E paramE)
    {
      this.aaBC = paramE;
    }
    
    public final void d(k<?> paramk) {}
    
    public final Object iSo()
    {
      return this.aaBC;
    }
    
    public final v iSp()
    {
      return o.abwj;
    }
    
    public final void iSq() {}
    
    public final String toString()
    {
      AppMethodBeat.i(204494);
      String str = "SendBuffered@" + Integer.toHexString(System.identityHashCode(this)) + '(' + this.aaBC + ')';
      AppMethodBeat.o(204494);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
  public static final class b
    extends l.a
  {
    public b(kotlinx.coroutines.internal.l paraml1, kotlinx.coroutines.internal.l paraml2, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.c
 * JD-Core Version:    0.7.0.1
 */