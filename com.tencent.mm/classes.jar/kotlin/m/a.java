package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
public final class a<T>
  implements h<T>
{
  private final AtomicReference<h<T>> TSs;
  
  public a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129535);
    this.TSs = new AtomicReference(paramh);
    AppMethodBeat.o(129535);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129534);
    Object localObject = (h)this.TSs.getAndSet(null);
    if (localObject == null)
    {
      localObject = (Throwable)new IllegalStateException("This sequence can be consumed only once.");
      AppMethodBeat.o(129534);
      throw ((Throwable)localObject);
    }
    localObject = ((h)localObject).iterator();
    AppMethodBeat.o(129534);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.a
 * JD-Core Version:    0.7.0.1
 */