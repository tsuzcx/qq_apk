package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.p;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.ak;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.r;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<E>
  extends a<E>
{
  private int aivl;
  private final g ajxw;
  private final ReentrantLock bKF;
  private Object[] buffer;
  private final int cZV;
  
  public e(int paramInt, g paramg, kotlin.g.a.b<? super E, ah> paramb)
  {
    super(null);
    AppMethodBeat.i(189293);
    this.cZV = paramInt;
    this.ajxw = paramg;
    if (this.cZV > 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramg = (Throwable)new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.cZV + " was specified").toString());
      AppMethodBeat.o(189293);
      throw paramg;
    }
    this.bKF = new ReentrantLock();
    paramg = new Object[Math.min(this.cZV, 8)];
    k.b(paramg, b.ajxj);
    paramb = ah.aiuX;
    this.buffer = paramg;
    this.size = 0;
    AppMethodBeat.o(189293);
  }
  
  private final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(189300);
    int k;
    Object[] arrayOfObject;
    if (paramInt >= this.buffer.length)
    {
      k = Math.min(this.buffer.length * 2, this.cZV);
      arrayOfObject = new Object[k];
      if (paramInt <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      arrayOfObject[i] = this.buffer[((this.aivl + i) % this.buffer.length)];
      if (j >= paramInt)
      {
        k.a(arrayOfObject, b.ajxj, paramInt, k);
        this.buffer = arrayOfObject;
        this.aivl = 0;
        AppMethodBeat.o(189300);
        return;
      }
    }
  }
  
  protected final void PK(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(189380);
    kotlin.g.a.b localb = this.ajxf;
    Object localObject1 = null;
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      int j = this.size;
      while (i < j)
      {
        Object localObject4 = this.buffer[this.aivl];
        localObject3 = localObject1;
        if (localb != null)
        {
          localObject3 = localObject1;
          if (localObject4 != b.ajxj) {
            localObject3 = v.a(localb, localObject4, (ak)localObject1);
          }
        }
        this.buffer[this.aivl] = b.ajxj;
        this.aivl = ((this.aivl + 1) % this.buffer.length);
        i += 1;
        localObject1 = localObject3;
      }
      this.size = 0;
      Object localObject3 = ah.aiuX;
      localLock.unlock();
      super.PK(paramBoolean);
      if (localObject1 != null)
      {
        AppMethodBeat.o(189380);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189380);
    }
    AppMethodBeat.o(189380);
  }
  
  protected final Object a(aa paramaa)
  {
    AppMethodBeat.i(189355);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      paramaa = super.a(paramaa);
      return paramaa;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189355);
    }
  }
  
  protected final boolean a(w<? super E> paramw)
  {
    AppMethodBeat.i(189372);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      boolean bool = super.a(paramw);
      return bool;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189372);
    }
  }
  
  protected final Object iT(E paramE)
  {
    int i = 1;
    AppMethodBeat.i(189346);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    int j;
    Object localObject1;
    for (;;)
    {
      try
      {
        j = this.size;
        localObject1 = kDb();
        if (localObject1 != null) {
          return localObject1;
        }
        if (j < this.cZV)
        {
          this.size = (j + 1);
          localObject1 = null;
          if (localObject1 == null) {
            break label453;
          }
          return localObject1;
        }
        localObject1 = this.ajxw;
        switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        case 1: 
          label132:
          paramE = new p();
          AppMethodBeat.o(189346);
          throw paramE;
        }
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(189346);
      }
      localObject1 = b.ajxl;
      continue;
      localObject1 = b.ajxk;
      continue;
      label178:
      do
      {
        localObject1 = kCX();
        if (localObject1 == null) {
          break;
        }
        if ((localObject1 instanceof n))
        {
          this.size = j;
          localLock.unlock();
          AppMethodBeat.o(189346);
          return localObject1;
        }
        localObject2 = ((y)localObject1).iQ(paramE);
      } while (localObject2 == null);
      if (au.ASSERTIONS_ENABLED)
      {
        if (localObject2 != r.ajvr) {
          break label460;
        }
        label246:
        if (i == 0)
        {
          paramE = new AssertionError();
          AppMethodBeat.o(189346);
          throw paramE;
        }
      }
      this.size = j;
      Object localObject2 = ah.aiuX;
      localLock.unlock();
      ((y)localObject1).iR(paramE);
      paramE = ((y)localObject1).kDt();
      AppMethodBeat.o(189346);
      return paramE;
      label305:
      if (j < this.cZV)
      {
        ensureCapacity(j);
        this.buffer[((this.aivl + j) % this.buffer.length)] = paramE;
        label336:
        paramE = b.ajxk;
        localLock.unlock();
        AppMethodBeat.o(189346);
        return paramE;
      }
      if (au.ASSERTIONS_ENABLED) {
        if (this.ajxw != g.ajxy) {
          break label465;
        }
      }
    }
    label453:
    label460:
    label465:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramE = new AssertionError();
        AppMethodBeat.o(189346);
        throw paramE;
      }
      this.buffer[(this.aivl % this.buffer.length)] = null;
      this.buffer[((this.aivl + j) % this.buffer.length)] = paramE;
      this.aivl = ((this.aivl + 1) % this.buffer.length);
      break label336;
      break label132;
      localObject1 = null;
      break;
      if (j != 0) {
        break label305;
      }
      break label178;
      i = 0;
      break label246;
    }
  }
  
  protected final boolean kCR()
  {
    return false;
  }
  
  protected final boolean kCS()
  {
    return this.size == 0;
  }
  
  protected final Object kCT()
  {
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(189364);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    int m;
    Object localObject6;
    try
    {
      m = this.size;
      if (m == 0)
      {
        localObject4 = kDb();
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = b.ajxm;
        }
        return localObject1;
      }
      localObject6 = this.buffer[this.aivl];
      this.buffer[this.aivl] = null;
      this.size = (m - 1);
      localObject5 = b.ajxm;
      localObject4 = localObject5;
      i = k;
      if (m != this.cZV) {
        break label226;
      }
      localObject1 = null;
      localObject4 = kDd();
      if (localObject4 == null) {
        break label331;
      }
      localObject1 = ((aa)localObject4).kDh();
      if (localObject1 == null) {
        break label319;
      }
      if (au.ASSERTIONS_ENABLED)
      {
        i = j;
        if (localObject1 == r.ajvr) {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = new AssertionError();
          AppMethodBeat.o(189364);
          throw ((Throwable)localObject1);
        }
      }
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189364);
    }
    Object localObject5 = ((aa)localObject4).kDg();
    int i = 1;
    Object localObject3 = localObject4;
    Object localObject4 = localObject5;
    for (;;)
    {
      label226:
      if ((localObject4 != b.ajxm) && (!(localObject4 instanceof n)))
      {
        this.size = m;
        this.buffer[((this.aivl + m) % this.buffer.length)] = localObject4;
      }
      this.aivl = ((this.aivl + 1) % this.buffer.length);
      localObject4 = ah.aiuX;
      localLock.unlock();
      if (i != 0)
      {
        s.checkNotNull(localObject3);
        localObject3.kDi();
      }
      AppMethodBeat.o(189364);
      return localObject6;
      label319:
      ((aa)localObject4).kDv();
      localObject3 = localObject4;
      break;
      label331:
      localObject4 = localObject5;
      i = k;
    }
  }
  
  public final boolean kCU()
  {
    AppMethodBeat.i(189338);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      boolean bool = super.kCU();
      return bool;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189338);
    }
  }
  
  protected final boolean kCZ()
  {
    return false;
  }
  
  protected final boolean kDa()
  {
    return (this.size == this.cZV) && (this.ajxw == g.ajxx);
  }
  
  protected final String kDf()
  {
    AppMethodBeat.i(189387);
    String str = "(buffer:capacity=" + this.cZV + ",size=" + this.size + ')';
    AppMethodBeat.o(189387);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.e
 * JD-Core Version:    0.7.0.1
 */