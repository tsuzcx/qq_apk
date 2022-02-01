package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.k.k;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "", "capacity", "<init>", "(I)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", "size", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getTail", "setTail", "tail", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<E>
  extends c<E>
  implements f<E>
{
  private final ReentrantLock ajxs;
  private final List<a<E>> ajxt;
  private final Object[] buffer;
  private final int cZV;
  
  public d()
  {
    super(null);
    AppMethodBeat.i(189294);
    this.cZV = 10;
    if (this.cZV > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + this.cZV + " was specified").toString());
      AppMethodBeat.o(189294);
      throw localThrowable;
    }
    this.ajxs = new ReentrantLock();
    this.buffer = new Object[this.cZV];
    this._head = 0L;
    this._tail = 0L;
    this._size = 0;
    this.ajxt = kotlinx.coroutines.internal.d.kDO();
    AppMethodBeat.o(189294);
  }
  
  private final void a(a<E> parama1, a<E> parama2)
  {
    AppMethodBeat.i(189310);
    Lock localLock;
    for (;;)
    {
      localLock = (Lock)this.ajxs;
      localLock.lock();
      if (parama1 != null) {}
      long l3;
      int k;
      for (;;)
      {
        try
        {
          parama1._subHead = this._tail;
          boolean bool = this.ajxt.isEmpty();
          this.ajxt.add(parama1);
          if (!bool) {
            return;
          }
          if (parama2 != null)
          {
            this.ajxt.remove(parama2);
            l1 = this._head;
            l2 = parama2._subHead;
            if (l1 != l2) {
              return;
            }
          }
          parama1 = this.ajxt.iterator();
          long l1 = 9223372036854775807L;
          if (parama1.hasNext())
          {
            l1 = k.bS(l1, ((a)parama1.next())._subHead);
            continue;
          }
          l3 = this._tail;
          long l2 = this._head;
          long l4 = k.bS(l1, l3);
          if (l4 <= l2) {
            return;
          }
          i = this._size;
          l1 = l2;
          if (l1 >= l4) {
            break label446;
          }
          this.buffer[((int)(l1 % this.cZV))] = null;
          if (i >= this.cZV)
          {
            j = 1;
            l2 = l1 + 1L;
            this._head = l2;
            k = i - 1;
            this._size = k;
            l1 = l2;
            i = k;
            if (j == 0) {
              continue;
            }
            parama1 = kDd();
            l1 = l2;
            i = k;
            if (parama1 == null) {
              continue;
            }
            l1 = l2;
            i = k;
            if ((parama1 instanceof n)) {
              continue;
            }
            parama2 = parama1.kDh();
            if (parama2 == null) {
              continue;
            }
            if (!au.ASSERTIONS_ENABLED) {
              break;
            }
            if (parama2 != r.ajvr) {
              break label381;
            }
            i = 1;
            if (i != 0) {
              break;
            }
            parama1 = new AssertionError();
            AppMethodBeat.o(189310);
            throw parama1;
          }
        }
        finally
        {
          localLock.unlock();
          AppMethodBeat.o(189310);
        }
        int j = 0;
        continue;
        label381:
        int i = 0;
      }
      this.buffer[((int)(l3 % this.cZV))] = parama1.kDg();
      this._size = (k + 1);
      this._tail = (1L + l3);
      parama2 = ah.aiuX;
      localLock.unlock();
      parama1.kDi();
      kDl();
      parama1 = null;
      parama2 = null;
    }
    label446:
    localLock.unlock();
    AppMethodBeat.o(189310);
  }
  
  private final void kDl()
  {
    AppMethodBeat.i(189302);
    Iterator localIterator = this.ajxt.iterator();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        if (((a)localIterator.next()).kDm())
        {
          i = 1;
          j = 1;
        }
      }
      else
      {
        if ((j != 0) || (i == 0)) {
          a(this, null, null, 3);
        }
        AppMethodBeat.o(189302);
        return;
      }
      i = 1;
    }
  }
  
  protected final Object iT(E paramE)
  {
    AppMethodBeat.i(189375);
    Lock localLock = (Lock)this.ajxs;
    localLock.lock();
    try
    {
      n localn = kDb();
      if (localn != null) {
        return localn;
      }
      int i = this._size;
      if (i >= this.cZV)
      {
        paramE = b.ajxl;
        return paramE;
      }
      long l = this._tail;
      this.buffer[((int)(l % this.cZV))] = paramE;
      this._size = (i + 1);
      this._tail = (l + 1L);
      paramE = ah.aiuX;
      localLock.unlock();
      kDl();
      paramE = b.ajxk;
      AppMethodBeat.o(189375);
      return paramE;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189375);
    }
  }
  
  public final boolean k(Throwable paramThrowable)
  {
    AppMethodBeat.i(189360);
    if (!super.k(paramThrowable))
    {
      AppMethodBeat.o(189360);
      return false;
    }
    kDl();
    AppMethodBeat.o(189360);
    return true;
  }
  
  protected final boolean kCZ()
  {
    return false;
  }
  
  protected final boolean kDa()
  {
    return this._size >= this.cZV;
  }
  
  protected final String kDf()
  {
    AppMethodBeat.i(189385);
    String str = "(buffer:capacity=" + this.buffer.length + ",size=" + this._size + ')';
    AppMethodBeat.o(189385);
    return str;
  }
  
  public final x<E> kDj()
  {
    AppMethodBeat.i(189347);
    Object localObject = new a(this);
    a(this, (a)localObject, null, 2);
    localObject = (x)localObject;
    AppMethodBeat.o(189347);
    return localObject;
  }
  
  public final void kDk()
  {
    AppMethodBeat.i(189365);
    k(null);
    Iterator localIterator = this.ajxt.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).X(null);
    }
    AppMethodBeat.o(189365);
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "checkOffer", "()Z", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "needsToCheckOfferWithoutLock", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<E>
    extends a<E>
  {
    private final d<E> ajxu;
    private final ReentrantLock ajxv;
    
    public a(d<E> paramd)
    {
      super();
      AppMethodBeat.i(189258);
      this.ajxu = paramd;
      this.ajxv = new ReentrantLock();
      this._subHead = 0L;
      AppMethodBeat.o(189258);
    }
    
    private final Object kDn()
    {
      AppMethodBeat.i(189263);
      long l = this._subHead;
      Object localObject = this.ajxu.kDc();
      if (l >= this.ajxu._tail)
      {
        if (localObject == null)
        {
          localObject = kDc();
          if (localObject == null)
          {
            localObject = b.ajxm;
            AppMethodBeat.o(189263);
            return localObject;
          }
          AppMethodBeat.o(189263);
          return localObject;
        }
        AppMethodBeat.o(189263);
        return localObject;
      }
      localObject = d.a(this.ajxu, l);
      n localn = kDc();
      if (localn != null)
      {
        AppMethodBeat.o(189263);
        return localn;
      }
      AppMethodBeat.o(189263);
      return localObject;
    }
    
    public final boolean k(Throwable paramThrowable)
    {
      AppMethodBeat.i(189295);
      boolean bool = super.k(paramThrowable);
      if (bool)
      {
        d.a(this.ajxu, null, this, 1);
        paramThrowable = (Lock)this.ajxv;
        paramThrowable.lock();
      }
      try
      {
        this._subHead = this.ajxu._tail;
        ah localah = ah.aiuX;
        return bool;
      }
      finally
      {
        paramThrowable.unlock();
        AppMethodBeat.o(189295);
      }
    }
    
    protected final boolean kCR()
    {
      return false;
    }
    
    protected final boolean kCS()
    {
      return this._subHead >= this.ajxu._tail;
    }
    
    protected final Object kCT()
    {
      int j = 1;
      AppMethodBeat.i(189316);
      int k = 0;
      Object localObject1 = (Lock)this.ajxv;
      ((Lock)localObject1).lock();
      label154:
      for (;;)
      {
        try
        {
          Object localObject2 = kDn();
          int i = k;
          if (!(localObject2 instanceof n))
          {
            i = k;
            if (localObject2 != b.ajxm)
            {
              this._subHead += 1L;
              i = 1;
            }
          }
          ((Lock)localObject1).unlock();
          if ((localObject2 instanceof n))
          {
            localObject1 = (n)localObject2;
            if (localObject1 != null) {
              k(((n)localObject1).aoY);
            }
            if (!kDm()) {
              break label154;
            }
            i = j;
            if (i != 0) {
              d.a(this.ajxu, null, null, 3);
            }
            AppMethodBeat.o(189316);
            return localObject2;
          }
        }
        finally
        {
          ((Lock)localObject1).unlock();
          AppMethodBeat.o(189316);
        }
        localObject1 = null;
      }
    }
    
    protected final boolean kCZ()
    {
      AppMethodBeat.i(189283);
      Throwable localThrowable = (Throwable)new IllegalStateException("Should not be used".toString());
      AppMethodBeat.o(189283);
      throw localThrowable;
    }
    
    protected final boolean kDa()
    {
      AppMethodBeat.i(189287);
      Throwable localThrowable = (Throwable)new IllegalStateException("Should not be used".toString());
      AppMethodBeat.o(189287);
      throw localThrowable;
    }
    
    public final boolean kDm()
    {
      AppMethodBeat.i(189307);
      boolean bool = false;
      int i;
      if (kDc() != null)
      {
        i = 0;
        label16:
        if ((i == 0) || (!this.ajxv.tryLock())) {
          break label275;
        }
      }
      for (;;)
      {
        Object localObject4;
        try
        {
          Object localObject1 = kDn();
          localObject4 = b.ajxm;
          if (localObject1 == localObject4)
          {
            this.ajxv.unlock();
            break;
            if ((kCS()) && (this.ajxu.kDc() == null))
            {
              i = 0;
              break label16;
            }
            i = 1;
            break label16;
          }
          if ((localObject1 instanceof n))
          {
            localObject1 = (n)localObject1;
            this.ajxv.unlock();
            if (localObject1 != null) {
              k(((n)localObject1).aoY);
            }
            AppMethodBeat.o(189307);
            return bool;
          }
          localObject4 = kCX();
          if (localObject4 == null)
          {
            this.ajxv.unlock();
            localObject1 = null;
            continue;
          }
          if ((localObject4 instanceof n))
          {
            this.ajxv.unlock();
            localObject1 = null;
            continue;
          }
          ac localac = ((y)localObject4).iQ(localObject1);
          if (localac == null)
          {
            this.ajxv.unlock();
            break;
          }
          if (!au.ASSERTIONS_ENABLED) {
            break label245;
          }
          if (localac == r.ajvr)
          {
            i = 1;
            if (i != 0) {
              break label245;
            }
            localObject1 = new AssertionError();
            AppMethodBeat.o(189307);
            throw ((Throwable)localObject1);
          }
        }
        finally
        {
          this.ajxv.unlock();
          AppMethodBeat.o(189307);
        }
        i = 0;
        continue;
        label245:
        this._subHead += 1L;
        this.ajxv.unlock();
        ((y)localObject4).iR(localObject2);
        bool = true;
        break;
        label275:
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.d
 * JD-Core Version:    0.7.0.1
 */