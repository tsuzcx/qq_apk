package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "<init>", "(I)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "currentSize", "", "ensureCapacity", "element", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "isFull", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"})
public final class e<E>
  extends a<E>
{
  private int abyp;
  private final int bgc;
  private Object[] buffer;
  private final ReentrantLock eYl;
  private volatile int size;
  
  public e(int paramInt)
  {
    AppMethodBeat.i(204467);
    this.bgc = paramInt;
    if (this.bgc > 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.bgc + " was specified").toString());
      AppMethodBeat.o(204467);
      throw localThrowable;
    }
    this.eYl = new ReentrantLock();
    this.buffer = new Object[Math.min(this.bgc, 8)];
    this.size = 0;
    AppMethodBeat.o(204467);
  }
  
  private final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(204458);
    if (paramInt >= this.buffer.length)
    {
      Object[] arrayOfObject = new Object[Math.min(this.buffer.length * 2, this.bgc)];
      int i = 0;
      while (i < paramInt)
      {
        arrayOfObject[i] = this.buffer[((this.abyp + i) % this.buffer.length)];
        i += 1;
      }
      this.buffer = arrayOfObject;
      this.abyp = 0;
    }
    AppMethodBeat.o(204458);
  }
  
  protected final void JG(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(204464);
    Lock localLock;
    if (paramBoolean)
    {
      localLock = (Lock)this.eYl;
      localLock.lock();
    }
    try
    {
      int j = this.size;
      while (i < j)
      {
        this.buffer[this.abyp] = Integer.valueOf(0);
        this.abyp = ((this.abyp + 1) % this.buffer.length);
        i += 1;
      }
      this.size = 0;
      x localx = x.aazN;
      localLock.unlock();
      super.JG(paramBoolean);
      AppMethodBeat.o(204464);
      return;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204464);
    }
  }
  
  protected final Object a(w paramw)
  {
    AppMethodBeat.i(204456);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    try
    {
      paramw = super.a(paramw);
      return paramw;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204456);
    }
  }
  
  protected final boolean a(s<? super E> params)
  {
    AppMethodBeat.i(204462);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    try
    {
      boolean bool = super.a(params);
      return bool;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204462);
    }
  }
  
  protected final Object go(E paramE)
  {
    AppMethodBeat.i(204454);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    int j;
    Object localObject;
    for (;;)
    {
      try
      {
        j = this.size;
        localObject = iSj();
        if (localObject != null) {
          return localObject;
        }
        if (j >= this.bgc) {
          break label294;
        }
        this.size = (j + 1);
        if (j == 0)
        {
          localObject = iSe();
          if (localObject != null) {}
        }
        else
        {
          ensureCapacity(j);
          this.buffer[((this.abyp + j) % this.buffer.length)] = paramE;
          paramE = b.abyd;
          return paramE;
        }
        if ((localObject instanceof k))
        {
          this.size = j;
          if (localObject == null) {
            p.iCn();
          }
          return localObject;
        }
        if (localObject == null) {
          p.iCn();
        }
        v localv = ((u)localObject).gn(paramE);
        if (localv == null) {
          continue;
        }
        if (!ap.iRg()) {
          break;
        }
        if (localv == o.abwj)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          paramE = (Throwable)new AssertionError();
          AppMethodBeat.o(204454);
          throw paramE;
        }
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(204454);
      }
      int i = 0;
    }
    this.size = j;
    paramE = x.aazN;
    localLock.unlock();
    if (localObject == null) {
      p.iCn();
    }
    ((u)localObject).iSf();
    if (localObject == null) {
      p.iCn();
    }
    paramE = ((u)localObject).iSA();
    AppMethodBeat.o(204454);
    return paramE;
    label294:
    paramE = b.abye;
    localLock.unlock();
    AppMethodBeat.o(204454);
    return paramE;
  }
  
  protected final boolean iSb()
  {
    return false;
  }
  
  protected final boolean iSc()
  {
    return this.size == 0;
  }
  
  protected final Object iSd()
  {
    Object localObject1 = null;
    Object localObject6 = null;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(204460);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    for (;;)
    {
      try
      {
        int m = this.size;
        if (m == 0)
        {
          localObject4 = iSj();
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = b.abyf;
          }
          return localObject1;
        }
        Object localObject7 = this.buffer[this.abyp];
        this.buffer[this.abyp] = null;
        this.size = (m - 1);
        localObject5 = b.abyf;
        localObject4 = localObject5;
        i = j;
        if (m == this.bgc)
        {
          localObject1 = localObject6;
          localObject4 = iSl();
          if (localObject4 == null)
          {
            i = j;
            localObject4 = localObject5;
          }
        }
        else
        {
          if ((localObject4 != b.abyf) && (!(localObject4 instanceof k)))
          {
            this.size = m;
            this.buffer[((this.abyp + m) % this.buffer.length)] = localObject4;
          }
          this.abyp = ((this.abyp + 1) % this.buffer.length);
          localObject4 = x.aazN;
          localLock.unlock();
          if (i != 0)
          {
            if (localObject1 == null) {
              p.iCn();
            }
            ((w)localObject1).iSq();
          }
          AppMethodBeat.o(204460);
          return localObject7;
        }
        if (localObject4 == null) {
          p.iCn();
        }
        localObject1 = ((w)localObject4).iSp();
        if (localObject1 == null) {
          break label353;
        }
        if (ap.iRg())
        {
          i = k;
          if (localObject1 == o.abwj) {
            i = 1;
          }
          if (i == 0)
          {
            localObject1 = (Throwable)new AssertionError();
            AppMethodBeat.o(204460);
            throw ((Throwable)localObject1);
          }
        }
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(204460);
      }
      if (localObject4 == null) {
        p.iCn();
      }
      Object localObject3 = ((w)localObject4).iSo();
      int i = 1;
      Object localObject5 = localObject4;
      Object localObject4 = localObject3;
      localObject3 = localObject5;
      continue;
      label353:
      localObject3 = localObject4;
    }
  }
  
  protected final boolean iSh()
  {
    return false;
  }
  
  protected final boolean iSi()
  {
    return this.size == this.bgc;
  }
  
  protected final String iSn()
  {
    AppMethodBeat.i(204466);
    String str = "(buffer:capacity=" + this.bgc + ",size=" + this.size + ')';
    AppMethodBeat.o(204466);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.e
 * JD-Core Version:    0.7.0.1
 */