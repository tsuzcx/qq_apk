package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"})
public class m<E>
{
  private static final AtomicReferenceFieldUpdater abzk;
  private volatile Object _cur;
  
  static
  {
    AppMethodBeat.i(118130);
    abzk = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_cur");
    AppMethodBeat.o(118130);
  }
  
  public m()
  {
    AppMethodBeat.i(118129);
    this._cur = new n(8, false);
    AppMethodBeat.o(118129);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118126);
    for (;;)
    {
      n localn = (n)this._cur;
      if (localn.close())
      {
        AppMethodBeat.o(118126);
        return;
      }
      abzk.compareAndSet(this, localn, localn.iSS());
    }
  }
  
  public final int getSize()
  {
    long l = ((n)this._cur)._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return (int)((l & 0xC0000000) >> 30) - i & 0x3FFFFFFF;
  }
  
  public final boolean gy(E paramE)
  {
    AppMethodBeat.i(118127);
    for (;;)
    {
      n localn = (n)this._cur;
      switch (localn.gz(paramE))
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
        abzk.compareAndSet(this, localn, localn.iSS());
      }
    }
  }
  
  public final E iSD()
  {
    AppMethodBeat.i(118128);
    for (;;)
    {
      n localn = (n)this._cur;
      Object localObject = localn.iSD();
      if (localObject != n.abzo)
      {
        AppMethodBeat.o(118128);
        return localObject;
      }
      abzk.compareAndSet(this, localn, localn.iSS());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.m
 * JD-Core Version:    0.7.0.1
 */