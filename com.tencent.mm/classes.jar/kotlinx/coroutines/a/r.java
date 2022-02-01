package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.au;
import kotlinx.coroutines.internal.ak;
import kotlinx.coroutines.internal.v;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class r<E>
  extends a<E>
{
  private final ReentrantLock bKF;
  private Object value;
  
  public r(kotlin.g.a.b<? super E, ah> paramb)
  {
    super(null);
    AppMethodBeat.i(189265);
    this.bKF = new ReentrantLock();
    this.value = b.ajxj;
    AppMethodBeat.o(189265);
  }
  
  private final ak ja(Object paramObject)
  {
    ak localak = null;
    AppMethodBeat.i(189274);
    Object localObject = this.value;
    if (localObject == b.ajxj) {}
    for (;;)
    {
      this.value = paramObject;
      AppMethodBeat.o(189274);
      return localak;
      kotlin.g.a.b localb = this.ajxf;
      if (localb != null) {
        localak = v.a(localb, localObject, null);
      }
    }
  }
  
  protected void PK(boolean paramBoolean)
  {
    AppMethodBeat.i(189325);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      ak localak = ja(b.ajxj);
      ah localah = ah.aiuX;
      localLock.unlock();
      super.PK(paramBoolean);
      if (localak != null)
      {
        AppMethodBeat.o(189325);
        throw localak;
      }
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189325);
    }
    AppMethodBeat.o(189325);
  }
  
  protected final boolean a(w<? super E> paramw)
  {
    AppMethodBeat.i(189336);
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
      AppMethodBeat.o(189336);
    }
  }
  
  protected Object iT(E paramE)
  {
    AppMethodBeat.i(189311);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = kDb();
        if (localObject1 != null) {
          return localObject1;
        }
        if (this.value != b.ajxj) {
          break;
        }
        localObject1 = kCX();
        if (localObject1 == null) {
          break;
        }
        boolean bool = localObject1 instanceof n;
        if (bool) {
          return localObject1;
        }
        localObject2 = ((y)localObject1).iQ(paramE);
        if (localObject2 == null) {
          continue;
        }
        if (!au.ASSERTIONS_ENABLED) {
          break label198;
        }
        if (localObject2 == kotlinx.coroutines.r.ajvr)
        {
          i = 1;
          if (i != 0) {
            break label198;
          }
          paramE = new AssertionError();
          AppMethodBeat.o(189311);
          throw paramE;
        }
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(189311);
      }
      int i = 0;
    }
    paramE = ja(paramE);
    if (paramE != null)
    {
      AppMethodBeat.o(189311);
      throw paramE;
    }
    paramE = b.ajxk;
    localLock.unlock();
    AppMethodBeat.o(189311);
    return paramE;
    label198:
    Object localObject2 = ah.aiuX;
    localLock.unlock();
    ((y)localObject1).iR(paramE);
    paramE = ((y)localObject1).kDt();
    AppMethodBeat.o(189311);
    return paramE;
  }
  
  protected final boolean kCR()
  {
    return false;
  }
  
  protected final boolean kCS()
  {
    return this.value == b.ajxj;
  }
  
  protected final Object kCT()
  {
    AppMethodBeat.i(189318);
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      if (this.value == b.ajxj)
      {
        localObject3 = kDb();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = b.ajxm;
        }
        return localObject1;
      }
      Object localObject1 = this.value;
      this.value = b.ajxj;
      Object localObject3 = ah.aiuX;
      return localObject1;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(189318);
    }
  }
  
  protected final boolean kCZ()
  {
    return false;
  }
  
  protected final boolean kDa()
  {
    return false;
  }
  
  protected final String kDf()
  {
    AppMethodBeat.i(189345);
    String str = "(value=" + this.value + ')';
    AppMethodBeat.o(189345);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.r
 * JD-Core Version:    0.7.0.1
 */