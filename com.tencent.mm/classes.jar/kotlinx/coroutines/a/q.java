package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k=1, mv={1, 5, 1}, xi=48)
public final class q<E>
  implements f<E>
{
  private static final q.b ajxI;
  @Deprecated
  private static final a ajxK;
  @Deprecated
  private static final ac ajxL;
  @Deprecated
  private static final c<Object> ajxM;
  
  static
  {
    AppMethodBeat.i(189291);
    ajxI = new q.b((byte)0);
    ajxK = new a(null);
    ajxL = new ac("UNDEFINED");
    ajxM = new c(ajxL, null);
    ajvp = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");
    ajxJ = AtomicIntegerFieldUpdater.newUpdater(q.class, "_updating");
    ajxq = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "onCloseHandler");
    AppMethodBeat.o(189291);
  }
  
  private static d<E>[] a(d<E>[] paramArrayOfd, d<E> paramd)
  {
    AppMethodBeat.i(189273);
    if (paramArrayOfd == null)
    {
      paramArrayOfd = new d[1];
      for (int i = 0; i <= 0; i = 1) {
        paramArrayOfd[0] = paramd;
      }
      AppMethodBeat.o(189273);
      return paramArrayOfd;
    }
    paramArrayOfd = (d[])k.c(paramArrayOfd, paramd);
    AppMethodBeat.o(189273);
    return paramArrayOfd;
  }
  
  private final a iZ(E paramE)
  {
    AppMethodBeat.i(189280);
    if (!ajxJ.compareAndSet(this, 0, 1))
    {
      AppMethodBeat.o(189280);
      return null;
    }
    try
    {
      c localc;
      do
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
        localc = new c(paramE, ((c)localObject).ajxN);
      } while (!ajvp.compareAndSet(this, localObject, localc));
      Object localObject = ((c)localObject).ajxN;
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].iT(paramE);
          i += 1;
        }
      }
      return null;
      paramE = (Throwable)new IllegalStateException(s.X("Invalid state ", localObject).toString());
      AppMethodBeat.o(189280);
      throw paramE;
    }
    finally
    {
      this._updating = 0;
      AppMethodBeat.o(189280);
    }
  }
  
  public final boolean Ij()
  {
    return this._state instanceof a;
  }
  
  public final Object b(E paramE, d<? super ah> paramd)
  {
    AppMethodBeat.i(189335);
    paramE = iZ(paramE);
    if (paramE == null)
    {
      if (a.aiwj == null)
      {
        AppMethodBeat.o(189335);
        return null;
      }
    }
    else
    {
      paramE = paramE.kDr();
      AppMethodBeat.o(189335);
      throw paramE;
    }
    paramE = ah.aiuX;
    AppMethodBeat.o(189335);
    return paramE;
  }
  
  public final Object iV(E paramE)
  {
    AppMethodBeat.i(189344);
    paramE = iZ(paramE);
    if (paramE != null)
    {
      l.b localb = l.ajxF;
      paramE = l.b.Y(paramE.kDr());
      AppMethodBeat.o(189344);
      return paramE;
    }
    paramE = l.ajxF;
    paramE = l.constructor-impl(ah.aiuX);
    AppMethodBeat.o(189344);
    return paramE;
  }
  
  public final boolean k(Throwable paramThrowable)
  {
    int i = 0;
    AppMethodBeat.i(189314);
    Object localObject2;
    for (;;)
    {
      localObject2 = this._state;
      if ((localObject2 instanceof a))
      {
        AppMethodBeat.o(189314);
        return false;
      }
      if (!(localObject2 instanceof c)) {
        break label172;
      }
      if (paramThrowable == null) {}
      for (localObject1 = ajxK; ajvp.compareAndSet(this, localObject2, localObject1); localObject1 = new a(paramThrowable))
      {
        localObject1 = ((c)localObject2).ajxN;
        if (localObject1 == null) {
          break label114;
        }
        int j = localObject1.length;
        while (i < j)
        {
          localObject1[i].k(paramThrowable);
          i += 1;
        }
      }
    }
    label114:
    Object localObject1 = this.onCloseHandler;
    if ((localObject1 != null) && (localObject1 != b.ajxo) && (ajxq.compareAndSet(this, localObject1, b.ajxo))) {
      ((kotlin.g.a.b)an.y(localObject1, 1)).invoke(paramThrowable);
    }
    AppMethodBeat.o(189314);
    return true;
    label172:
    paramThrowable = (Throwable)new IllegalStateException(s.X("Invalid state ", localObject2).toString());
    AppMethodBeat.o(189314);
    throw paramThrowable;
  }
  
  public final x<E> kDj()
  {
    AppMethodBeat.i(189306);
    Object localObject1 = new d(this);
    Object localObject2;
    c localc;
    do
    {
      localObject2 = this._state;
      if ((localObject2 instanceof a))
      {
        ((d)localObject1).k(((a)localObject2).aoY);
        localObject1 = (x)localObject1;
        AppMethodBeat.o(189306);
        return localObject1;
      }
      if (!(localObject2 instanceof c)) {
        break;
      }
      if (((c)localObject2).value != ajxL) {
        ((d)localObject1).iT(((c)localObject2).value);
      }
      localc = new c(((c)localObject2).value, a(((c)localObject2).ajxN, (d)localObject1));
    } while (!ajvp.compareAndSet(this, localObject2, localc));
    localObject1 = (x)localObject1;
    AppMethodBeat.o(189306);
    return localObject1;
    localObject1 = (Throwable)new IllegalStateException(s.X("Invalid state ", localObject2).toString());
    AppMethodBeat.o(189306);
    throw ((Throwable)localObject1);
  }
  
  public final void kDk()
  {
    AppMethodBeat.i(189327);
    k(null);
    AppMethodBeat.o(189327);
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(189353);
    boolean bool = ab.a.a((ab)this, paramE);
    AppMethodBeat.o(189353);
    return bool;
  }
  
  public final void p(kotlin.g.a.b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(189320);
    if (!ajxq.compareAndSet(this, null, paramb))
    {
      paramb = this.onCloseHandler;
      if (paramb == b.ajxo)
      {
        paramb = new IllegalStateException("Another handler was already registered and successfully invoked");
        AppMethodBeat.o(189320);
        throw paramb;
      }
      paramb = new IllegalStateException(s.X("Another handler was already registered: ", paramb));
      AppMethodBeat.o(189320);
      throw paramb;
    }
    Object localObject = this._state;
    if (((localObject instanceof a)) && (ajxq.compareAndSet(this, paramb, b.ajxo))) {
      paramb.invoke(((a)localObject).aoY);
    }
    AppMethodBeat.o(189320);
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    public final Throwable aoY;
    
    public a(Throwable paramThrowable)
    {
      this.aoY = paramThrowable;
    }
    
    public final Throwable kDr()
    {
      AppMethodBeat.i(189279);
      Throwable localThrowable = this.aoY;
      if (localThrowable == null)
      {
        localThrowable = (Throwable)new p("Channel was closed");
        AppMethodBeat.o(189279);
        return localThrowable;
      }
      AppMethodBeat.o(189279);
      return localThrowable;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c<E>
  {
    public final q.d<E>[] ajxN;
    public final Object value;
    
    public c(Object paramObject, q.d<E>[] paramArrayOfd)
    {
      this.value = paramObject;
      this.ajxN = paramArrayOfd;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d<E>
    extends r<E>
  {
    private final q<E> ajxO;
    
    public d(q<E> paramq)
    {
      super();
      this.ajxO = paramq;
    }
    
    protected final void PK(boolean paramBoolean)
    {
      AppMethodBeat.i(189284);
      if (paramBoolean) {
        q.a(this.ajxO, this);
      }
      AppMethodBeat.o(189284);
    }
    
    public final Object iT(E paramE)
    {
      AppMethodBeat.i(189288);
      paramE = super.iT(paramE);
      AppMethodBeat.o(189288);
      return paramE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.q
 * JD-Core Version:    0.7.0.1
 */