package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public class q<E>
{
  static
  {
    AppMethodBeat.i(118130);
    ajAB = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_cur");
    AppMethodBeat.o(118130);
  }
  
  public q()
  {
    AppMethodBeat.i(118129);
    this._cur = new r(8, false);
    AppMethodBeat.o(118129);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118126);
    for (;;)
    {
      r localr = (r)this._cur;
      if (localr.close())
      {
        AppMethodBeat.o(118126);
        return;
      }
      ajAB.compareAndSet(this, localr, localr.kEh());
    }
  }
  
  public final int getSize()
  {
    long l = ((r)this._cur)._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return (int)((l & 0xC0000000) >> 30) - i & 0x3FFFFFFF;
  }
  
  public final boolean jl(E paramE)
  {
    AppMethodBeat.i(118127);
    for (;;)
    {
      r localr = (r)this._cur;
      switch (localr.jm(paramE))
      {
      default: 
        break;
      case 0: 
        AppMethodBeat.o(118127);
        return true;
      case 2: 
        AppMethodBeat.o(118127);
        return false;
      case 1: 
        ajAB.compareAndSet(this, localr, localr.kEh());
      }
    }
  }
  
  public final E kkV()
  {
    AppMethodBeat.i(118128);
    for (;;)
    {
      r localr = (r)this._cur;
      Object localObject = localr.kkV();
      if (localObject != r.ajAG)
      {
        AppMethodBeat.o(118128);
        return localObject;
      }
      ajAB.compareAndSet(this, localr, localr.kEh());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.q
 * JD-Core Version:    0.7.0.1
 */