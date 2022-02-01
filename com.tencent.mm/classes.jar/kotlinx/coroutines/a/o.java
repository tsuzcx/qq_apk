package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.internal.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "pollInternal", "pollSelectInternal", "Companion", "kotlinx-coroutines-core"})
public class o<E>
  extends a<E>
{
  private static final v abyB;
  private static final o.a abyC;
  private final ReentrantLock eYl;
  private Object value;
  
  static
  {
    AppMethodBeat.i(204358);
    abyC = new o.a((byte)0);
    abyB = new v("EMPTY");
    AppMethodBeat.o(204358);
  }
  
  public o()
  {
    AppMethodBeat.i(204357);
    this.eYl = new ReentrantLock();
    this.value = abyB;
    AppMethodBeat.o(204357);
  }
  
  protected void JG(boolean paramBoolean)
  {
    AppMethodBeat.i(204354);
    Lock localLock;
    if (paramBoolean)
    {
      localLock = (Lock)this.eYl;
      localLock.lock();
    }
    try
    {
      this.value = abyB;
      x localx = x.aazN;
      localLock.unlock();
      super.JG(paramBoolean);
      AppMethodBeat.o(204354);
      return;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204354);
    }
  }
  
  protected final boolean a(s<? super E> params)
  {
    AppMethodBeat.i(204355);
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
      AppMethodBeat.o(204355);
    }
  }
  
  protected Object go(E paramE)
  {
    AppMethodBeat.i(204352);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = iSj();
        if (localObject != null) {
          return localObject;
        }
        if (this.value == abyB)
        {
          localObject = iSe();
          if (localObject != null) {}
        }
        else
        {
          this.value = paramE;
          paramE = b.abyd;
          return paramE;
        }
        if ((localObject instanceof k))
        {
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
        if (localv == kotlinx.coroutines.o.abwj)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          paramE = (Throwable)new AssertionError();
          AppMethodBeat.o(204352);
          throw paramE;
        }
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(204352);
      }
      int i = 0;
    }
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
    AppMethodBeat.o(204352);
    return paramE;
  }
  
  protected final boolean iSb()
  {
    return false;
  }
  
  protected final boolean iSc()
  {
    return this.value == abyB;
  }
  
  protected final Object iSd()
  {
    AppMethodBeat.i(204353);
    Lock localLock = (Lock)this.eYl;
    localLock.lock();
    try
    {
      if (this.value == abyB)
      {
        localObject3 = iSj();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = b.abyf;
        }
        return localObject1;
      }
      Object localObject1 = this.value;
      this.value = abyB;
      Object localObject3 = x.aazN;
      return localObject1;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(204353);
    }
  }
  
  protected final boolean iSh()
  {
    return false;
  }
  
  protected final boolean iSi()
  {
    return false;
  }
  
  protected final String iSn()
  {
    AppMethodBeat.i(204356);
    String str = "(value=" + this.value + ')';
    AppMethodBeat.o(204356);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.o
 * JD-Core Version:    0.7.0.1
 */