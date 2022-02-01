package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"})
public class j<E>
{
  private static final AtomicReferenceFieldUpdater LSS;
  private volatile Object _cur;
  
  static
  {
    AppMethodBeat.i(118130);
    LSS = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_cur");
    AppMethodBeat.o(118130);
  }
  
  public j()
  {
    AppMethodBeat.i(118129);
    this._cur = new k(8, false);
    AppMethodBeat.o(118129);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118126);
    for (;;)
    {
      k localk = (k)this._cur;
      if (localk.close())
      {
        AppMethodBeat.o(118126);
        return;
      }
      LSS.compareAndSet(this, localk, localk.geE());
    }
  }
  
  public final boolean fV(E paramE)
  {
    AppMethodBeat.i(118127);
    for (;;)
    {
      k localk = (k)this._cur;
      switch (localk.fW(paramE))
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
        LSS.compareAndSet(this, localk, localk.geE());
      }
    }
  }
  
  public final int getSize()
  {
    long l = ((k)this._cur)._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return (int)((l & 0xC0000000) >> 30) - i & 0x3FFFFFFF;
  }
  
  public final E geu()
  {
    AppMethodBeat.i(118128);
    for (;;)
    {
      k localk = (k)this._cur;
      Object localObject = localk.geu();
      if (localObject != k.LSW)
      {
        AppMethodBeat.o(118128);
        return localObject;
      }
      LSS.compareAndSet(this, localk, localk.geE());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.j
 * JD-Core Version:    0.7.0.1
 */