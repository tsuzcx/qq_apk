package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "", "capacity", "<init>", "(I)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", "size", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getTail", "setTail", "tail", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;"})
public final class d<E>
  extends c<E>
  implements f<E>
{
  private volatile long _head;
  private volatile int _size;
  volatile long _tail;
  private final ReentrantLock abyl;
  private final List<a<E>> abym;
  private final int bgc;
  private final Object[] buffer;
  
  public d()
  {
    AppMethodBeat.i(204343);
    this.bgc = 10;
    if (this.bgc > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + this.bgc + " was specified").toString());
      AppMethodBeat.o(204343);
      throw localThrowable;
    }
    this.abyl = new ReentrantLock();
    this.buffer = new Object[this.bgc];
    this._head = 0L;
    this._tail = 0L;
    this._size = 0;
    this.abym = kotlinx.coroutines.internal.d.iSG();
    AppMethodBeat.o(204343);
  }
  
  private final void a(a<E> parama1, a<E> parama2)
  {
    AppMethodBeat.i(204340);
    Lock localLock;
    for (;;)
    {
      localLock = (Lock)this.abyl;
      localLock.lock();
      if (parama1 != null) {}
      long l3;
      int k;
      for (;;)
      {
        try
        {
          parama1._subHead = this._tail;
          boolean bool = this.abym.isEmpty();
          this.abym.add(parama1);
          if (!bool) {
            return;
          }
          if (parama2 != null)
          {
            this.abym.remove(parama2);
            l1 = this._head;
            l2 = parama2._subHead;
            if (l1 != l2) {
              return;
            }
          }
          parama1 = this.abym.iterator();
          long l1 = 9223372036854775807L;
          if (parama1.hasNext())
          {
            l1 = i.bf(l1, ((a)parama1.next())._subHead);
            continue;
          }
          l3 = this._tail;
          long l2 = this._head;
          long l4 = i.bf(l1, l3);
          if (l4 <= l2) {
            return;
          }
          i = this._size;
          l1 = l2;
          if (l1 >= l4) {
            break label488;
          }
          this.buffer[((int)(l1 % this.bgc))] = null;
          if (i >= this.bgc)
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
            parama1 = iSl();
            l1 = l2;
            i = k;
            if (parama1 == null) {
              continue;
            }
            l1 = l2;
            i = k;
            if ((parama1 instanceof k)) {
              continue;
            }
            if (parama1 == null) {
              p.iCn();
            }
            parama2 = parama1.iSp();
            if (parama2 == null) {
              continue;
            }
            if (!ap.iRg()) {
              break;
            }
            if (parama2 != o.abwj) {
              break label391;
            }
            i = 1;
            if (i != 0) {
              break;
            }
            parama1 = (Throwable)new AssertionError();
            AppMethodBeat.o(204340);
            throw parama1;
          }
        }
        finally
        {
          localLock.unlock();
          AppMethodBeat.o(204340);
        }
        int j = 0;
        continue;
        label391:
        i = 0;
      }
      parama2 = this.buffer;
      int i = (int)(l3 % this.bgc);
      if (parama1 == null)
      {
        parama1 = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        AppMethodBeat.o(204340);
        throw parama1;
      }
      parama2[i] = parama1.iSo();
      this._size = (k + 1);
      this._tail = (1L + l3);
      parama2 = x.aazN;
      localLock.unlock();
      if (parama1 == null) {
        p.iCn();
      }
      parama1.iSq();
      iSt();
      parama2 = null;
      parama1 = null;
    }
    label488:
    localLock.unlock();
    AppMethodBeat.o(204340);
  }
  
  private final void iSt()
  {
    AppMethodBeat.i(204338);
    Iterator localIterator = this.abym.iterator();
    int j = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((a)localIterator.next()).iSu()) {
        break label73;
      }
      i = 1;
    }
    label73:
    for (;;)
    {
      j = 1;
      break;
      if ((i != 0) || (j == 0)) {
        a(this, null, null, 3);
      }
      AppMethodBeat.o(204338);
      return;
    }
  }
  
  public final boolean I(Throwable paramThrowable)
  {
    AppMethodBeat.i(204332);
    if (!super.I(paramThrowable))
    {
      AppMethodBeat.o(204332);
      return false;
    }
    iSt();
    AppMethodBeat.o(204332);
    return true;
  }
  
  protected final Object go(E paramE)
  {
    AppMethodBeat.i(204336);
    Lock localLock = (Lock)this.abyl;
    localLock.lock();
    try
    {
      k localk = iSj();
      if (localk != null) {
        return localk;
      }
      int i = this._size;
      if (i >= this.bgc)
      {
        paramE = b.abye;
        return paramE;
      }
      long l = this._tail;
      this.buffer[((int)(l % this.bgc))] = paramE;
      this._size = (i + 1);
      this._tail = (l + 1L);
      paramE = x.aazN;
      localLock.unlock();
      iSt();
      paramE = b.abyd;
      AppMethodBeat.o(204336);
      return paramE;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204336);
    }
  }
  
  protected final boolean iSh()
  {
    return false;
  }
  
  protected final boolean iSi()
  {
    return this._size >= this.bgc;
  }
  
  protected final String iSn()
  {
    AppMethodBeat.i(204342);
    String str = "(buffer:capacity=" + this.buffer.length + ",size=" + this._size + ')';
    AppMethodBeat.o(204342);
    return str;
  }
  
  public final t<E> iSr()
  {
    AppMethodBeat.i(204331);
    Object localObject = new a(this);
    a(this, (a)localObject, null, 2);
    localObject = (t)localObject;
    AppMethodBeat.o(204331);
    return localObject;
  }
  
  public final void iSs()
  {
    AppMethodBeat.i(204334);
    I(null);
    Iterator localIterator = this.abym.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).H(null);
    }
    AppMethodBeat.o(204334);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "checkOffer", "()Z", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "needsToCheckOfferWithoutLock", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;"})
  static final class a<E>
    extends a<E>
  {
    volatile long _subHead;
    private final ReentrantLock abyn;
    private final d<E> abyo;
    
    public a(d<E> paramd)
    {
      AppMethodBeat.i(204572);
      this.abyo = paramd;
      this.abyn = new ReentrantLock();
      this._subHead = 0L;
      AppMethodBeat.o(204572);
    }
    
    private final Object iSv()
    {
      AppMethodBeat.i(204571);
      long l = this._subHead;
      Object localObject2 = this.abyo.iSk();
      if (l >= this.abyo._tail)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = iSk();
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = b.abyf;
        }
        AppMethodBeat.o(204571);
        return localObject2;
      }
      Object localObject1 = d.a(this.abyo, l);
      localObject2 = iSk();
      if (localObject2 != null)
      {
        AppMethodBeat.o(204571);
        return localObject2;
      }
      AppMethodBeat.o(204571);
      return localObject1;
    }
    
    public final boolean I(Throwable paramThrowable)
    {
      AppMethodBeat.i(204565);
      boolean bool = super.I(paramThrowable);
      if (bool)
      {
        d.a(this.abyo, null, this, 1);
        paramThrowable = (Lock)this.abyn;
        paramThrowable.lock();
      }
      try
      {
        this._subHead = this.abyo._tail;
        x localx = x.aazN;
        return bool;
      }
      finally
      {
        paramThrowable.unlock();
        AppMethodBeat.o(204565);
      }
    }
    
    protected final boolean iSb()
    {
      return false;
    }
    
    protected final boolean iSc()
    {
      return this._subHead >= this.abyo._tail;
    }
    
    protected final Object iSd()
    {
      int j = 1;
      AppMethodBeat.i(204570);
      int k = 0;
      Object localObject1 = (Lock)this.abyn;
      ((Lock)localObject1).lock();
      for (;;)
      {
        try
        {
          Object localObject2 = iSv();
          int i = k;
          if (!(localObject2 instanceof k))
          {
            i = k;
            if (localObject2 != b.abyf)
            {
              this._subHead += 1L;
              i = 1;
            }
          }
          ((Lock)localObject1).unlock();
          if ((localObject2 instanceof k)) {
            break label154;
          }
          localObject1 = null;
          localObject1 = (k)localObject1;
          if (localObject1 != null) {
            I(((k)localObject1).abyu);
          }
          if (iSu())
          {
            i = j;
            if (i != 0) {
              d.a(this.abyo, null, null, 3);
            }
            AppMethodBeat.o(204570);
            return localObject2;
          }
        }
        finally
        {
          ((Lock)localObject1).unlock();
          AppMethodBeat.o(204570);
        }
        continue;
        label154:
        localObject1 = localObject3;
      }
    }
    
    protected final boolean iSh()
    {
      AppMethodBeat.i(204563);
      Throwable localThrowable = (Throwable)new IllegalStateException("Should not be used".toString());
      AppMethodBeat.o(204563);
      throw localThrowable;
    }
    
    protected final boolean iSi()
    {
      AppMethodBeat.i(204564);
      Throwable localThrowable = (Throwable)new IllegalStateException("Should not be used".toString());
      AppMethodBeat.o(204564);
      throw localThrowable;
    }
    
    public final boolean iSu()
    {
      AppMethodBeat.i(204567);
      boolean bool = false;
      int i;
      if (iSk() != null)
      {
        i = 0;
        label16:
        if ((i == 0) || (!this.abyn.tryLock())) {
          break label282;
        }
      }
      for (;;)
      {
        Object localObject4;
        try
        {
          Object localObject1 = iSv();
          localObject4 = b.abyf;
          if (localObject1 == localObject4)
          {
            this.abyn.unlock();
            break;
            if ((iSc()) && (this.abyo.iSk() == null))
            {
              i = 0;
              break label16;
            }
            i = 1;
            break label16;
          }
          if ((localObject1 instanceof k))
          {
            localObject1 = (k)localObject1;
            this.abyn.unlock();
            if (localObject1 != null) {
              I(((k)localObject1).abyu);
            }
            AppMethodBeat.o(204567);
            return bool;
          }
          localObject4 = iSe();
          if (localObject4 == null)
          {
            this.abyn.unlock();
            localObject1 = null;
            continue;
          }
          if ((localObject4 instanceof k))
          {
            this.abyn.unlock();
            localObject1 = null;
            continue;
          }
          localObject1 = ((u)localObject4).gn(localObject1);
          if (localObject1 == null)
          {
            this.abyn.unlock();
            break;
          }
          if (!ap.iRg()) {
            break label245;
          }
          if (localObject1 == o.abwj)
          {
            i = 1;
            if (i != 0) {
              break label245;
            }
            localObject1 = (Throwable)new AssertionError();
            AppMethodBeat.o(204567);
            throw ((Throwable)localObject1);
          }
        }
        finally
        {
          this.abyn.unlock();
          AppMethodBeat.o(204567);
        }
        i = 0;
        continue;
        label245:
        this._subHead += 1L;
        this.abyn.unlock();
        if (localObject4 == null) {
          p.iCn();
        }
        ((u)localObject4).iSf();
        bool = true;
        break;
        label282:
        Object localObject3 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.d
 * JD-Core Version:    0.7.0.1
 */