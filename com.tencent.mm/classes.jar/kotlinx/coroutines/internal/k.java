package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"})
public class k<E>
{
  private static final AtomicReferenceFieldUpdater OgV;
  private volatile Object _cur;
  
  static
  {
    AppMethodBeat.i(118130);
    OgV = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur");
    AppMethodBeat.o(118130);
  }
  
  public k()
  {
    AppMethodBeat.i(118129);
    this._cur = new l(8, false);
    AppMethodBeat.o(118129);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118126);
    for (;;)
    {
      l locall = (l)this._cur;
      if (locall.close())
      {
        AppMethodBeat.o(118126);
        return;
      }
      OgV.compareAndSet(this, locall, locall.gAF());
    }
  }
  
  public final E gAv()
  {
    AppMethodBeat.i(118128);
    for (;;)
    {
      l locall = (l)this._cur;
      Object localObject = locall.gAv();
      if (localObject != l.OgZ)
      {
        AppMethodBeat.o(118128);
        return localObject;
      }
      OgV.compareAndSet(this, locall, locall.gAF());
    }
  }
  
  public final boolean gb(E paramE)
  {
    AppMethodBeat.i(118127);
    for (;;)
    {
      l locall = (l)this._cur;
      switch (locall.gc(paramE))
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
        OgV.compareAndSet(this, locall, locall.gAF());
      }
    }
  }
  
  public final int getSize()
  {
    long l = ((l)this._cur)._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return (int)((l & 0xC0000000) >> 30) - i & 0x3FFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.k
 * JD-Core Version:    0.7.0.1
 */