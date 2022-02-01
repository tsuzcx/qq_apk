package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlinx.coroutines.a.l<+TE;>;>;
import kotlinx.coroutines.au;
import kotlinx.coroutines.g;
import kotlinx.coroutines.internal.ab;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.p.a;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<E>
  extends c<E>
  implements h<E>
{
  public a(kotlin.g.a.b<? super E, ah> paramb)
  {
    super(paramb);
  }
  
  private final void a(kotlinx.coroutines.p<?> paramp, w<?> paramw)
  {
    paramp.bg((kotlin.g.a.b)new e(paramw));
  }
  
  private final <R> Object f(int paramInt, kotlin.d.d<? super R> paramd)
  {
    q localq = kotlinx.coroutines.s.av(kotlin.d.a.b.au(paramd));
    kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localq;
    Object localObject1;
    if (this.ajxf == null)
    {
      localObject1 = new b(localp, paramInt);
      if (!a((w)localObject1)) {
        break label97;
      }
      a(localp, (w)localObject1);
    }
    for (;;)
    {
      localObject1 = localq.getResult();
      if (localObject1 == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      return localObject1;
      localObject1 = (b)new c(localp, paramInt, this.ajxf);
      break;
      label97:
      Object localObject2 = kCT();
      if ((localObject2 instanceof n))
      {
        ((b)localObject1).a((n)localObject2);
      }
      else
      {
        if (localObject2 == b.ajxm) {
          break;
        }
        localp.d(((b)localObject1).iP(localObject2), ((b)localObject1).iS(localObject2));
      }
    }
  }
  
  protected void PK(boolean paramBoolean)
  {
    n localn = kDb();
    if (localn == null) {
      throw ((Throwable)new IllegalStateException("Cannot happen".toString()));
    }
    Object localObject = null;
    for (;;)
    {
      kotlinx.coroutines.internal.p localp = localn.kEb();
      if ((localp instanceof kotlinx.coroutines.internal.n)) {
        break;
      }
      if ((au.ASSERTIONS_ENABLED) && (!(localp instanceof aa))) {
        throw new AssertionError();
      }
      if (!localp.remove()) {
        localp.kEd();
      } else {
        localObject = m.ag(localObject, (aa)localp);
      }
    }
    a(localObject, localn);
  }
  
  public final boolean X(Throwable paramThrowable)
  {
    boolean bool = k(paramThrowable);
    PK(bool);
    return bool;
  }
  
  protected void a(Object paramObject, n<?> paramn)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof ArrayList)) {
        break label20;
      }
      ((aa)paramObject).d(paramn);
    }
    label20:
    int i;
    do
    {
      return;
      if (paramObject == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
      }
      paramObject = (ArrayList)paramObject;
      i = paramObject.size() - 1;
    } while (i < 0);
    for (;;)
    {
      int j = i - 1;
      ((aa)paramObject.get(i)).d(paramn);
      if (j < 0) {
        break;
      }
      i = j;
    }
  }
  
  public final void a(CancellationException paramCancellationException)
  {
    if (kCU()) {
      return;
    }
    if (paramCancellationException == null) {
      paramCancellationException = new CancellationException(kotlin.g.b.s.X(getClass().getSimpleName(), " was cancelled"));
    }
    for (;;)
    {
      X((Throwable)paramCancellationException);
      return;
    }
  }
  
  protected boolean a(w<? super E> paramw)
  {
    int i;
    if (kCR())
    {
      localp1 = (kotlinx.coroutines.internal.p)kCY();
      do
      {
        localObject = localp1.kEb();
        if (!(localObject instanceof aa)) {}
        for (i = 1; i == 0; i = 0) {
          return false;
        }
      } while (!((kotlinx.coroutines.internal.p)localObject).a((kotlinx.coroutines.internal.p)paramw, localp1));
      return true;
    }
    kotlinx.coroutines.internal.p localp1 = (kotlinx.coroutines.internal.p)kCY();
    Object localObject = (p.a)new f((kotlinx.coroutines.internal.p)paramw, this);
    for (;;)
    {
      kotlinx.coroutines.internal.p localp2 = localp1.kEb();
      if (!(localp2 instanceof aa)) {}
      for (i = 1; i == 0; i = 0) {
        return false;
      }
      switch (localp2.a((kotlinx.coroutines.internal.p)paramw, localp1, (p.a)localObject))
      {
      }
    }
    return true;
    return false;
  }
  
  public final Object aA(kotlin.d.d<? super E> paramd)
  {
    Object localObject = kCT();
    if ((localObject != b.ajxm) && (!(localObject instanceof n))) {
      return localObject;
    }
    return f(0, paramd);
  }
  
  public final Object aB(kotlin.d.d<? super l<? extends E>> paramd)
  {
    if ((paramd instanceof g))
    {
      localObject = (g)paramd;
      if ((((g)localObject).label & 0x80000000) != 0) {
        ((g)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super l<? extends E>>)localObject;; paramd = new g(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    ResultKt.throwOnFailure(localObject);
    Object localObject = kCT();
    if (localObject != b.ajxm)
    {
      if ((localObject instanceof n))
      {
        paramd = l.ajxF;
        return l.b.Y(((n)localObject).aoY);
      }
      paramd = l.ajxF;
      return l.constructor-impl(localObject);
    }
    paramd.label = 1;
    localObject = f(1, paramd);
    paramd = (kotlin.d.d<? super l<? extends E>>)localObject;
    if (localObject == locala)
    {
      return locala;
      ResultKt.throwOnFailure(localObject);
      paramd = (kotlin.d.d<? super l<? extends E>>)localObject;
    }
    return ((l)paramd).ajxG;
  }
  
  protected abstract boolean kCR();
  
  protected abstract boolean kCS();
  
  protected Object kCT()
  {
    for (;;)
    {
      aa localaa = kDd();
      if (localaa == null) {
        return b.ajxm;
      }
      ac localac = localaa.kDh();
      if (localac != null)
      {
        if (au.ASSERTIONS_ENABLED)
        {
          if (localac == r.ajvr) {}
          for (int i = 1; i == 0; i = 0) {
            throw new AssertionError();
          }
        }
        localaa.kDi();
        return localaa.kDg();
      }
      localaa.kDv();
    }
  }
  
  public boolean kCU()
  {
    return (kDc() != null) && (kCS());
  }
  
  public final Object kCV()
  {
    Object localObject = kCT();
    if (localObject == b.ajxm)
    {
      localObject = l.ajxF;
      return l.constructor-impl(l.kDq());
    }
    if ((localObject instanceof n))
    {
      localb = l.ajxF;
      return l.b.Y(((n)localObject).aoY);
    }
    l.b localb = l.ajxF;
    return l.constructor-impl(localObject);
  }
  
  public final j<E> kCW()
  {
    return (j)new a(this);
  }
  
  protected final y<E> kCX()
  {
    return super.kCX();
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<E>
    implements j<E>
  {
    public final a<E> ajxd;
    Object result;
    
    public a(a<E> parama)
    {
      this.ajxd = parama;
      this.result = b.ajxm;
    }
    
    private static boolean iO(Object paramObject)
    {
      AppMethodBeat.i(189361);
      if ((paramObject instanceof n))
      {
        if (((n)paramObject).aoY != null)
        {
          paramObject = ab.ab(((n)paramObject).kDs());
          AppMethodBeat.o(189361);
          throw paramObject;
        }
        AppMethodBeat.o(189361);
        return false;
      }
      AppMethodBeat.o(189361);
      return true;
    }
    
    public final Object aC(kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(189370);
      boolean bool;
      if (this.result != b.ajxm)
      {
        bool = iO(this.result);
        AppMethodBeat.o(189370);
        return Boolean.valueOf(bool);
      }
      this.result = this.ajxd.kCT();
      if (this.result != b.ajxm)
      {
        bool = iO(this.result);
        AppMethodBeat.o(189370);
        return Boolean.valueOf(bool);
      }
      q localq = kotlinx.coroutines.s.av(kotlin.d.a.b.au(paramd));
      Object localObject2 = (kotlinx.coroutines.p)localq;
      Object localObject3 = new a.d(this, (kotlinx.coroutines.p)localObject2);
      do
      {
        if (a.a(this.ajxd, (w)localObject3)) {
          a.a(this.ajxd, (kotlinx.coroutines.p)localObject2, (w)localObject3);
        }
        for (;;)
        {
          localObject1 = localq.getResult();
          if (localObject1 == kotlin.d.a.a.aiwj) {
            kotlin.g.b.s.u(paramd, "frame");
          }
          AppMethodBeat.o(189370);
          return localObject1;
          localObject1 = this.ajxd.kCT();
          this.result = localObject1;
          if (!(localObject1 instanceof n)) {
            break;
          }
          if (((n)localObject1).aoY == null)
          {
            localObject1 = (kotlin.d.d)localObject2;
            localObject2 = Boolean.FALSE;
            localObject3 = Result.Companion;
            ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
          }
          else
          {
            localObject2 = (kotlin.d.d)localObject2;
            localObject1 = ((n)localObject1).kDs();
            localObject3 = Result.Companion;
            ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject1)));
          }
        }
      } while (localObject1 == b.ajxm);
      localObject3 = Boolean.TRUE;
      kotlin.g.a.b localb = this.ajxd.ajxf;
      if (localb == null) {}
      for (Object localObject1 = null;; localObject1 = v.b(localb, localObject1, ((kotlinx.coroutines.p)localObject2).getContext()))
      {
        ((kotlinx.coroutines.p)localObject2).d(localObject3, (kotlin.g.a.b)localObject1);
        break;
      }
    }
    
    public final E next()
    {
      AppMethodBeat.i(189378);
      Object localObject = this.result;
      if ((localObject instanceof n))
      {
        localObject = ab.ab(((n)localObject).kDs());
        AppMethodBeat.o(189378);
        throw ((Throwable)localObject);
      }
      if (localObject != b.ajxm)
      {
        this.result = b.ajxm;
        AppMethodBeat.o(189378);
        return localObject;
      }
      localObject = new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
      AppMethodBeat.o(189378);
      throw ((Throwable)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static class b<E>
    extends w<E>
  {
    public final kotlinx.coroutines.p<Object> ajwe;
    public final int ajxe;
    
    public b(kotlinx.coroutines.p<Object> paramp, int paramInt)
    {
      this.ajwe = paramp;
      this.ajxe = paramInt;
    }
    
    public final void a(n<?> paramn)
    {
      AppMethodBeat.i(189373);
      if (this.ajxe == 1)
      {
        locald = (kotlin.d.d)this.ajwe;
        localObject = l.ajxF;
        paramn = l.iY(l.b.Y(paramn.aoY));
        localObject = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramn));
        AppMethodBeat.o(189373);
        return;
      }
      kotlin.d.d locald = (kotlin.d.d)this.ajwe;
      paramn = paramn.kDs();
      Object localObject = Result.Companion;
      locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramn)));
      AppMethodBeat.o(189373);
    }
    
    public final Object iP(E paramE)
    {
      AppMethodBeat.i(189350);
      if (this.ajxe == 1)
      {
        l.b localb = l.ajxF;
        paramE = l.iY(l.constructor-impl(paramE));
        AppMethodBeat.o(189350);
        return paramE;
      }
      AppMethodBeat.o(189350);
      return paramE;
    }
    
    public final ac iQ(E paramE)
    {
      AppMethodBeat.i(189362);
      paramE = this.ajwe.c(iP(paramE), iS(paramE));
      if (paramE == null)
      {
        AppMethodBeat.o(189362);
        return null;
      }
      if (au.ASSERTIONS_ENABLED)
      {
        if (paramE == r.ajvr) {}
        for (int i = 1; i == 0; i = 0)
        {
          paramE = new AssertionError();
          AppMethodBeat.o(189362);
          throw paramE;
        }
      }
      paramE = r.ajvr;
      AppMethodBeat.o(189362);
      return paramE;
    }
    
    public final void iR(E paramE)
    {
      AppMethodBeat.i(189368);
      this.ajwe.iy(r.ajvr);
      AppMethodBeat.o(189368);
    }
    
    public String toString()
    {
      AppMethodBeat.i(189383);
      String str = "ReceiveElement@" + Integer.toHexString(System.identityHashCode(this)) + "[receiveMode=" + this.ajxe + ']';
      AppMethodBeat.o(189383);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c<E>
    extends a.b<E>
  {
    public final kotlin.g.a.b<E, ah> ajxf;
    
    public c(kotlinx.coroutines.p<Object> paramp, int paramInt, kotlin.g.a.b<? super E, ah> paramb)
    {
      super(paramInt);
      this.ajxf = paramb;
    }
    
    public final kotlin.g.a.b<Throwable, ah> iS(E paramE)
    {
      AppMethodBeat.i(189328);
      paramE = v.b(this.ajxf, paramE, this.ajwe.getContext());
      AppMethodBeat.o(189328);
      return paramE;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d<E>
    extends w<E>
  {
    public final kotlinx.coroutines.p<Boolean> ajwe;
    public final a.a<E> ajxg;
    
    public d(a.a<E> parama, kotlinx.coroutines.p<? super Boolean> paramp)
    {
      this.ajxg = parama;
      this.ajwe = paramp;
    }
    
    public final void a(n<?> paramn)
    {
      AppMethodBeat.i(189339);
      if (paramn.aoY == null) {}
      for (Object localObject = this.ajwe.ix(Boolean.FALSE);; localObject = this.ajwe.O(paramn.kDs()))
      {
        if (localObject != null)
        {
          this.ajxg.result = paramn;
          this.ajwe.iy(localObject);
        }
        AppMethodBeat.o(189339);
        return;
      }
    }
    
    public final ac iQ(E paramE)
    {
      AppMethodBeat.i(189322);
      paramE = this.ajwe.c(Boolean.TRUE, iS(paramE));
      if (paramE == null)
      {
        AppMethodBeat.o(189322);
        return null;
      }
      if (au.ASSERTIONS_ENABLED)
      {
        if (paramE == r.ajvr) {}
        for (int i = 1; i == 0; i = 0)
        {
          paramE = new AssertionError();
          AppMethodBeat.o(189322);
          throw paramE;
        }
      }
      paramE = r.ajvr;
      AppMethodBeat.o(189322);
      return paramE;
    }
    
    public final void iR(E paramE)
    {
      AppMethodBeat.i(189330);
      this.ajxg.result = paramE;
      this.ajwe.iy(r.ajvr);
      AppMethodBeat.o(189330);
    }
    
    public final kotlin.g.a.b<Throwable, ah> iS(E paramE)
    {
      AppMethodBeat.i(189348);
      kotlin.g.a.b localb = this.ajxg.ajxd.ajxf;
      if (localb == null)
      {
        AppMethodBeat.o(189348);
        return null;
      }
      paramE = v.b(localb, paramE, this.ajwe.getContext());
      AppMethodBeat.o(189348);
      return paramE;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189358);
      String str = kotlin.g.b.s.X("ReceiveHasNext@", Integer.toHexString(System.identityHashCode(this)));
      AppMethodBeat.o(189358);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  final class e
    extends g
  {
    private final w<?> ajxh;
    
    public e()
    {
      Object localObject;
      this.ajxh = localObject;
    }
    
    public final void N(Throwable paramThrowable)
    {
      AppMethodBeat.i(189332);
      this.ajxh.remove();
      AppMethodBeat.o(189332);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189341);
      String str = "RemoveReceiveOnCancel[" + this.ajxh + ']';
      AppMethodBeat.o(189341);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends p.a
  {
    public f(kotlinx.coroutines.internal.p paramp, a parama)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    int label;
    
    g(a<E> parama, kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189331);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ajxi.aB((kotlin.d.d)this);
      if (paramObject == kotlin.d.a.a.aiwj)
      {
        AppMethodBeat.o(189331);
        return paramObject;
      }
      paramObject = l.iY(paramObject);
      AppMethodBeat.o(189331);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */