package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"})
public class l<E>
{
  private static final AtomicReferenceFieldUpdater TVT;
  private volatile Object _cur;
  
  static
  {
    AppMethodBeat.i(118130);
    TVT = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur");
    AppMethodBeat.o(118130);
  }
  
  public l()
  {
    AppMethodBeat.i(118129);
    this._cur = new m(8, false);
    AppMethodBeat.o(118129);
  }
  
  public final void close()
  {
    AppMethodBeat.i(118126);
    for (;;)
    {
      m localm = (m)this._cur;
      if (localm.close())
      {
        AppMethodBeat.o(118126);
        return;
      }
      TVT.compareAndSet(this, localm, localm.hNM());
    }
  }
  
  public final int getSize()
  {
    long l = ((m)this._cur)._state;
    int i = (int)((0x3FFFFFFF & l) >> 0);
    return (int)((l & 0xC0000000) >> 30) - i & 0x3FFFFFFF;
  }
  
  public final boolean gg(E paramE)
  {
    AppMethodBeat.i(118127);
    for (;;)
    {
      m localm = (m)this._cur;
      switch (localm.gh(paramE))
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
        TVT.compareAndSet(this, localm, localm.hNM());
      }
    }
  }
  
  public final E hNC()
  {
    AppMethodBeat.i(118128);
    for (;;)
    {
      m localm = (m)this._cur;
      Object localObject = localm.hNC();
      if (localObject != m.TVX)
      {
        AppMethodBeat.o(118128);
        return localObject;
      }
      TVT.compareAndSet(this, localm, localm.hNM());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.l
 * JD-Core Version:    0.7.0.1
 */