package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"})
public final class n<E>
  implements f<E>
{
  private static final v abwR;
  private static final AtomicReferenceFieldUpdater abwi;
  private static final AtomicReferenceFieldUpdater abyj;
  private static final AtomicIntegerFieldUpdater abyv;
  private static final a abyw;
  private static final c<Object> abyx;
  private static final n.b abyy;
  private volatile Object _state = abyx;
  private volatile int _updating = 0;
  private volatile Object onCloseHandler = null;
  
  static
  {
    AppMethodBeat.i(204603);
    abyy = new n.b((byte)0);
    abyw = new a(null);
    abwR = new v("UNDEFINED");
    abyx = new c(abwR, null);
    abwi = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
    abyv = AtomicIntegerFieldUpdater.newUpdater(n.class, "_updating");
    abyj = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "onCloseHandler");
    AppMethodBeat.o(204603);
  }
  
  private static d<E>[] a(d<E>[] paramArrayOfd, d<E> paramd)
  {
    AppMethodBeat.i(204595);
    if (paramArrayOfd == null)
    {
      paramArrayOfd = new d[1];
      i = 0;
      while (i <= 0)
      {
        paramArrayOfd[0] = paramd;
        i += 1;
      }
      AppMethodBeat.o(204595);
      return paramArrayOfd;
    }
    p.k(paramArrayOfd, "$this$plus");
    int i = paramArrayOfd.length;
    paramArrayOfd = Arrays.copyOf(paramArrayOfd, i + 1);
    paramArrayOfd[i] = paramd;
    p.j(paramArrayOfd, "result");
    paramArrayOfd = (d[])paramArrayOfd;
    AppMethodBeat.o(204595);
    return paramArrayOfd;
  }
  
  private final a gq(E paramE)
  {
    AppMethodBeat.i(204601);
    if (!abyv.compareAndSet(this, 0, 1))
    {
      AppMethodBeat.o(204601);
      return null;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = this._state;
        if ((localObject instanceof a))
        {
          paramE = (a)localObject;
          return paramE;
        }
        if (!(localObject instanceof c)) {
          break;
        }
        if (localObject == null)
        {
          paramE = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
          AppMethodBeat.o(204601);
          throw paramE;
        }
      }
      finally
      {
        this._updating = 0;
        AppMethodBeat.o(204601);
      }
      c localc = new c(paramE, ((c)localObject).abyz);
      if (abwi.compareAndSet(this, localObject, localc))
      {
        localObject = ((c)localObject).abyz;
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localObject[i].go(paramE);
            i += 1;
          }
        }
        this._updating = 0;
        AppMethodBeat.o(204601);
        return null;
      }
    }
    paramE = (Throwable)new IllegalStateException("Invalid state ".concat(String.valueOf(localObject)).toString());
    AppMethodBeat.o(204601);
    throw paramE;
  }
  
  public final boolean I(Throwable paramThrowable)
  {
    int i = 0;
    AppMethodBeat.i(204597);
    Object localObject2;
    for (;;)
    {
      localObject2 = this._state;
      if ((localObject2 instanceof a))
      {
        AppMethodBeat.o(204597);
        return false;
      }
      if (!(localObject2 instanceof c)) {
        break label195;
      }
      if (paramThrowable == null) {}
      for (localObject1 = abyw; abwi.compareAndSet(this, localObject2, localObject1); localObject1 = new a(paramThrowable))
      {
        if (localObject2 != null) {
          break label97;
        }
        paramThrowable = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
        AppMethodBeat.o(204597);
        throw paramThrowable;
      }
    }
    label97:
    Object localObject1 = ((c)localObject2).abyz;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      while (i < j)
      {
        localObject1[i].I(paramThrowable);
        i += 1;
      }
    }
    localObject1 = this.onCloseHandler;
    if ((localObject1 != null) && (localObject1 != b.abyh) && (abyj.compareAndSet(this, localObject1, b.abyh))) {
      ((kotlin.g.a.b)ag.x(localObject1, 1)).invoke(paramThrowable);
    }
    AppMethodBeat.o(204597);
    return true;
    label195:
    paramThrowable = (Throwable)new IllegalStateException("Invalid state ".concat(String.valueOf(localObject2)).toString());
    AppMethodBeat.o(204597);
    throw paramThrowable;
  }
  
  public final Object c(E paramE, d<? super x> paramd)
  {
    AppMethodBeat.i(204599);
    paramE = gq(paramE);
    if (paramE != null)
    {
      paramE = paramE.iSy();
      AppMethodBeat.o(204599);
      throw paramE;
    }
    if (paramE == a.aaAA)
    {
      AppMethodBeat.o(204599);
      return paramE;
    }
    paramE = x.aazN;
    AppMethodBeat.o(204599);
    return paramE;
  }
  
  public final t<E> iSr()
  {
    AppMethodBeat.i(204594);
    Object localObject1 = new d(this);
    Object localObject2;
    Object localObject3;
    do
    {
      localObject2 = this._state;
      if ((localObject2 instanceof a))
      {
        ((d)localObject1).I(((a)localObject2).abyu);
        localObject1 = (t)localObject1;
        AppMethodBeat.o(204594);
        return localObject1;
      }
      if (!(localObject2 instanceof c)) {
        break;
      }
      if (((c)localObject2).value != abwR) {
        ((d)localObject1).go(((c)localObject2).value);
      }
      localObject3 = ((c)localObject2).value;
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
        AppMethodBeat.o(204594);
        throw ((Throwable)localObject1);
      }
      localObject3 = new c(localObject3, a(((c)localObject2).abyz, (d)localObject1));
    } while (!abwi.compareAndSet(this, localObject2, localObject3));
    localObject1 = (t)localObject1;
    AppMethodBeat.o(204594);
    return localObject1;
    localObject1 = (Throwable)new IllegalStateException("Invalid state ".concat(String.valueOf(localObject2)).toString());
    AppMethodBeat.o(204594);
    throw ((Throwable)localObject1);
  }
  
  public final void iSs()
  {
    AppMethodBeat.i(204598);
    I(null);
    AppMethodBeat.o(204598);
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(204600);
    paramE = gq(paramE);
    if (paramE != null)
    {
      paramE = paramE.iSy();
      AppMethodBeat.o(204600);
      throw paramE;
    }
    AppMethodBeat.o(204600);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"})
  static final class a
  {
    public final Throwable abyu;
    
    public a(Throwable paramThrowable)
    {
      this.abyu = paramThrowable;
    }
    
    public final Throwable iSy()
    {
      AppMethodBeat.i(204503);
      Throwable localThrowable2 = this.abyu;
      Throwable localThrowable1 = localThrowable2;
      if (localThrowable2 == null) {
        localThrowable1 = (Throwable)new m("Channel was closed");
      }
      AppMethodBeat.o(204503);
      return localThrowable1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"})
  static final class c<E>
  {
    public final n.d<E>[] abyz;
    public final Object value;
    
    public c(Object paramObject, n.d<E>[] paramArrayOfd)
    {
      this.value = paramObject;
      this.abyz = paramArrayOfd;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"})
  static final class d<E>
    extends o<E>
  {
    private final n<E> abyA;
    
    public d(n<E> paramn)
    {
      this.abyA = paramn;
    }
    
    protected final void JG(boolean paramBoolean)
    {
      AppMethodBeat.i(204507);
      if (paramBoolean) {
        n.a(this.abyA, this);
      }
      AppMethodBeat.o(204507);
    }
    
    public final Object go(E paramE)
    {
      AppMethodBeat.i(204508);
      paramE = super.go(paramE);
      AppMethodBeat.o(204508);
      return paramE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.n
 * JD-Core Version:    0.7.0.1
 */