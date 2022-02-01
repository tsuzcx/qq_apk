package kotlinx.coroutines.a;

import TE;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.p.a;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<E>
  implements ab<E>
{
  protected final kotlin.g.a.b<E, ah> ajxf;
  private final kotlinx.coroutines.internal.n ajxp;
  
  public c(kotlin.g.a.b<? super E, ah> paramb)
  {
    this.ajxf = paramb;
    this.ajxp = new kotlinx.coroutines.internal.n();
    this.onCloseHandler = null;
  }
  
  private final void a(d<?> paramd, E paramE, n<?> paramn)
  {
    c(paramn);
    paramn = paramn.kDr();
    kotlin.g.a.b localb = this.ajxf;
    if (localb != null)
    {
      paramE = v.a(localb, paramE, null);
      if (paramE != null)
      {
        kotlin.b.a((Throwable)paramE, paramn);
        paramn = Result.Companion;
        paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)paramE)));
        return;
      }
    }
    paramE = Result.Companion;
    paramd.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramn)));
  }
  
  private static Throwable b(n<?> paramn)
  {
    c(paramn);
    return paramn.kDr();
  }
  
  private static void c(n<?> paramn)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2 = paramn.kEb();
      if ((localObject2 instanceof w)) {}
      for (localObject2 = (w)localObject2;; localObject2 = null)
      {
        if (localObject2 == null) {
          break label60;
        }
        if (((w)localObject2).remove()) {
          break label50;
        }
        ((w)localObject2).kEd();
        break;
      }
      label50:
      localObject1 = m.ag(localObject1, localObject2);
    }
    label60:
    if (localObject1 != null)
    {
      if ((localObject1 instanceof ArrayList)) {
        break label80;
      }
      ((w)localObject1).a(paramn);
    }
    label80:
    int i;
    do
    {
      return;
      if (localObject1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
      }
      localObject1 = (ArrayList)localObject1;
      i = ((ArrayList)localObject1).size() - 1;
    } while (i < 0);
    for (;;)
    {
      int j = i - 1;
      ((w)((ArrayList)localObject1).get(i)).a(paramn);
      if (j < 0) {
        break;
      }
      i = j;
    }
  }
  
  private final int kDe()
  {
    int i = 0;
    kotlinx.coroutines.internal.n localn = this.ajxp;
    kotlinx.coroutines.internal.p localp = (kotlinx.coroutines.internal.p)localn.kDZ();
    while (!kotlin.g.b.s.p(localp, localn))
    {
      int j = i;
      if ((localp instanceof kotlinx.coroutines.internal.p)) {
        j = i + 1;
      }
      localp = o.jk(localp.kDZ());
      i = j;
    }
    return i;
  }
  
  public final boolean Ij()
  {
    return kDb() != null;
  }
  
  protected Object a(aa paramaa)
  {
    if (kCZ())
    {
      localp1 = (kotlinx.coroutines.internal.p)this.ajxp;
      do
      {
        localObject = localp1.kEb();
        if ((localObject instanceof y)) {
          return localObject;
        }
      } while (!((kotlinx.coroutines.internal.p)localObject).a((kotlinx.coroutines.internal.p)paramaa, localp1));
      return null;
    }
    kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)this.ajxp;
    Object localObject = (p.a)new b((kotlinx.coroutines.internal.p)paramaa, this);
    for (;;)
    {
      kotlinx.coroutines.internal.p localp2 = localp1.kEb();
      if ((localp2 instanceof y)) {
        return localp2;
      }
      switch (localp2.a((kotlinx.coroutines.internal.p)paramaa, localp1, (p.a)localObject))
      {
      }
    }
    for (int i = 1; i == 0; i = 0) {
      return b.ajxn;
    }
  }
  
  public final Object b(E paramE, d<? super ah> paramd)
  {
    if (iT(paramE) == b.ajxk)
    {
      paramd = ah.aiuX;
      return paramd;
    }
    q localq = kotlinx.coroutines.s.av(kotlin.d.a.b.au(paramd));
    Object localObject2 = (kotlinx.coroutines.p)localq;
    label33:
    int i;
    label58:
    Object localObject1;
    label81:
    Object localObject3;
    if ((!(o.jk(this.ajxp.kDZ()) instanceof y)) && (kDa()))
    {
      i = 1;
      if (i == 0) {
        break label248;
      }
      if (this.ajxf != null) {
        break label162;
      }
      localObject1 = new ac(paramE, (kotlinx.coroutines.p)localObject2);
      localObject3 = a((aa)localObject1);
      if (localObject3 != null) {
        break label184;
      }
      kotlinx.coroutines.s.a((kotlinx.coroutines.p)localObject2, (kotlinx.coroutines.internal.p)localObject1);
    }
    for (;;)
    {
      localObject1 = localq.getResult();
      if (localObject1 == a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      paramE = (TE)localObject1;
      if (localObject1 != a.aiwj) {
        paramE = ah.aiuX;
      }
      paramd = paramE;
      if (paramE == a.aiwj) {
        break;
      }
      return ah.aiuX;
      i = 0;
      break label58;
      label162:
      localObject1 = (ac)new ad(paramE, (kotlinx.coroutines.p)localObject2, this.ajxf);
      break label81;
      label184:
      if ((localObject3 instanceof n))
      {
        a((d)localObject2, paramE, (n)localObject3);
      }
      else
      {
        if ((localObject3 != b.ajxn) && (!(localObject3 instanceof w))) {
          throw ((Throwable)new IllegalStateException(kotlin.g.b.s.X("enqueueSend returned ", localObject3).toString()));
        }
        label248:
        localObject1 = iT(paramE);
        if (localObject1 == b.ajxk)
        {
          paramE = (d)localObject2;
          localObject1 = ah.aiuX;
          localObject2 = Result.Companion;
          paramE.resumeWith(Result.constructor-impl(localObject1));
        }
        else
        {
          if (localObject1 == b.ajxl) {
            break label33;
          }
          if (!(localObject1 instanceof n)) {
            break label327;
          }
          a((d)localObject2, paramE, (n)localObject1);
        }
      }
    }
    label327:
    throw ((Throwable)new IllegalStateException(kotlin.g.b.s.X("offerInternal returned ", localObject1).toString()));
  }
  
  protected Object iT(E paramE)
  {
    y localy;
    kotlinx.coroutines.internal.ac localac;
    do
    {
      localy = kCX();
      if (localy == null) {
        return b.ajxl;
      }
      localac = localy.iQ(paramE);
    } while (localac == null);
    if (au.ASSERTIONS_ENABLED)
    {
      if (localac == r.ajvr) {}
      for (int i = 1; i == 0; i = 0) {
        throw new AssertionError();
      }
    }
    localy.iR(paramE);
    return localy.kDt();
  }
  
  protected final y<?> iU(E paramE)
  {
    kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)this.ajxp;
    paramE = (kotlinx.coroutines.internal.p)new a(paramE);
    kotlinx.coroutines.internal.p localp2;
    do
    {
      localp2 = localp1.kEb();
      if ((localp2 instanceof y)) {
        return (y)localp2;
      }
    } while (!localp2.a(paramE, localp1));
    return null;
  }
  
  public final Object iV(E paramE)
  {
    paramE = iT(paramE);
    if (paramE == b.ajxk)
    {
      paramE = l.ajxF;
      return l.constructor-impl(ah.aiuX);
    }
    l.b localb;
    if (paramE == b.ajxl)
    {
      paramE = kDb();
      if (paramE == null)
      {
        paramE = l.ajxF;
        return l.constructor-impl(l.kDq());
      }
      localb = l.ajxF;
      return l.b.Y(b(paramE));
    }
    if ((paramE instanceof n))
    {
      localb = l.ajxF;
      return l.b.Y(b((n)paramE));
    }
    throw ((Throwable)new IllegalStateException(kotlin.g.b.s.X("trySend returned ", paramE).toString()));
  }
  
  public boolean k(Throwable paramThrowable)
  {
    Object localObject = new n(paramThrowable);
    kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)this.ajxp;
    kotlinx.coroutines.internal.p localp2 = localp1.kEb();
    int i;
    label36:
    boolean bool;
    if (!(localp2 instanceof n))
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
      c((n)localObject);
      if (bool)
      {
        localObject = this.onCloseHandler;
        if ((localObject != null) && (localObject != b.ajxo) && (ajxq.compareAndSet(this, localObject, b.ajxo))) {
          ((kotlin.g.a.b)an.y(localObject, 1)).invoke(paramThrowable);
        }
      }
      return bool;
      i = 0;
      break label36;
      label112:
      if (!localp2.a((kotlinx.coroutines.internal.p)localObject, localp1)) {
        break;
      }
      bool = true;
      break label42;
      label132:
      localObject = (n)this.ajxp.kEb();
    }
  }
  
  protected y<E> kCX()
  {
    kotlinx.coroutines.internal.p localp2 = (kotlinx.coroutines.internal.p)this.ajxp;
    for (;;)
    {
      kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)localp2.kDZ();
      if (localp1 == localp2) {
        localp1 = null;
      }
      kotlinx.coroutines.internal.p localp3;
      do
      {
        do
        {
          for (;;)
          {
            return (y)localp1;
            if ((localp1 instanceof y)) {
              break;
            }
            localp1 = null;
          }
        } while ((((y)localp1 instanceof n)) && (!localp1.isRemoved()));
        localp3 = localp1.kEc();
      } while (localp3 == null);
      localp3.kEe();
    }
  }
  
  protected final kotlinx.coroutines.internal.n kCY()
  {
    return this.ajxp;
  }
  
  protected abstract boolean kCZ();
  
  protected abstract boolean kDa();
  
  protected final n<?> kDb()
  {
    Object localObject = this.ajxp.kEb();
    if ((localObject instanceof n)) {}
    for (localObject = (n)localObject; localObject == null; localObject = null) {
      return null;
    }
    c((n)localObject);
    return localObject;
  }
  
  protected final n<?> kDc()
  {
    Object localObject = o.jk(this.ajxp.kDZ());
    if ((localObject instanceof n)) {}
    for (localObject = (n)localObject; localObject == null; localObject = null) {
      return null;
    }
    c((n)localObject);
    return localObject;
  }
  
  protected final aa kDd()
  {
    kotlinx.coroutines.internal.p localp2 = (kotlinx.coroutines.internal.p)this.ajxp;
    for (;;)
    {
      kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)localp2.kDZ();
      if (localp1 == localp2) {
        localp1 = null;
      }
      kotlinx.coroutines.internal.p localp3;
      do
      {
        do
        {
          for (;;)
          {
            return (aa)localp1;
            if ((localp1 instanceof aa)) {
              break;
            }
            localp1 = null;
          }
        } while ((((aa)localp1 instanceof n)) && (!localp1.isRemoved()));
        localp3 = localp1.kEc();
      } while (localp3 == null);
      localp3.kEe();
    }
  }
  
  protected String kDf()
  {
    return "";
  }
  
  public final boolean offer(E paramE)
  {
    try
    {
      boolean bool = ab.a.a((ab)this, paramE);
      return bool;
    }
    finally
    {
      kotlin.g.a.b localb = this.ajxf;
      if (localb != null)
      {
        paramE = v.a(localb, paramE, null);
        if (paramE != null)
        {
          kotlin.b.a((Throwable)paramE, localThrowable);
          throw paramE;
        }
      }
    }
  }
  
  public final void p(kotlin.g.a.b<? super Throwable, ah> paramb)
  {
    if (!ajxq.compareAndSet(this, null, paramb))
    {
      paramb = this.onCloseHandler;
      if (paramb == b.ajxo) {
        throw new IllegalStateException("Another handler was already registered and successfully invoked");
      }
      throw new IllegalStateException(kotlin.g.b.s.X("Another handler was already registered: ", paramb));
    }
    n localn = kDb();
    if ((localn != null) && (ajxq.compareAndSet(this, paramb, b.ajxo))) {
      paramb.invoke(localn.aoY);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('{');
    kotlinx.coroutines.internal.p localp1 = this.ajxp.kEa();
    Object localObject;
    if (localp1 == this.ajxp)
    {
      localObject = "EmptyQueue";
      return (String)localObject + '}' + kDf();
    }
    String str;
    if ((localp1 instanceof n)) {
      str = localp1.toString();
    }
    for (;;)
    {
      kotlinx.coroutines.internal.p localp2 = this.ajxp.kEb();
      localObject = str;
      if (localp2 == localp1) {
        break;
      }
      str = str + ",queueSize=" + kDe();
      localObject = str;
      if (!(localp2 instanceof n)) {
        break;
      }
      localObject = str + ",closedForSend=" + localp2;
      break;
      if ((localp1 instanceof w)) {
        str = "ReceiveQueued";
      } else if ((localp1 instanceof aa)) {
        str = "SendQueued";
      } else {
        str = kotlin.g.b.s.X("UNEXPECTED:", localp1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<E>
    extends aa
  {
    public final E aqH;
    
    public a(E paramE)
    {
      this.aqH = paramE;
    }
    
    public final void d(n<?> paramn)
    {
      AppMethodBeat.i(189369);
      if (au.ASSERTIONS_ENABLED)
      {
        paramn = new AssertionError();
        AppMethodBeat.o(189369);
        throw paramn;
      }
      AppMethodBeat.o(189369);
    }
    
    public final Object kDg()
    {
      return this.aqH;
    }
    
    public final kotlinx.coroutines.internal.ac kDh()
    {
      return r.ajvr;
    }
    
    public final void kDi() {}
    
    public final String toString()
    {
      AppMethodBeat.i(189377);
      String str = "SendBuffered@" + Integer.toHexString(System.identityHashCode(this)) + '(' + this.aqH + ')';
      AppMethodBeat.o(189377);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends p.a
  {
    public b(kotlinx.coroutines.internal.p paramp, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.c
 * JD-Core Version:    0.7.0.1
 */