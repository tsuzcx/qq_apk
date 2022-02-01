package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
public final class a<T>
  implements h<T>
{
  private final AtomicReference<h<T>> LPx;
  
  public a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129535);
    this.LPx = new AtomicReference(paramh);
    AppMethodBeat.o(129535);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129534);
    Object localObject = (h)this.LPx.getAndSet(null);
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
 * Qualified Name:     d.m.a
 * JD-Core Version:    0.7.0.1
 */