package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.a.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class p<T>
  implements Serializable, f<T>
{
  private static final AtomicReferenceFieldUpdater<p<?>, Object> aazI;
  public static final p.a aazJ;
  private volatile a<? extends T> aazF;
  private volatile Object aazG;
  private final Object aazH;
  
  static
  {
    AppMethodBeat.i(129580);
    aazJ = new p.a((byte)0);
    aazI = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "aazG");
    AppMethodBeat.o(129580);
  }
  
  public p(a<? extends T> parama)
  {
    AppMethodBeat.i(129579);
    this.aazF = parama;
    this.aazG = v.aazM;
    this.aazH = v.aazM;
    AppMethodBeat.o(129579);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129578);
    d locald = new d(getValue());
    AppMethodBeat.o(129578);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129576);
    Object localObject = this.aazG;
    if (localObject != v.aazM)
    {
      AppMethodBeat.o(129576);
      return localObject;
    }
    localObject = this.aazF;
    if (localObject != null)
    {
      localObject = ((a)localObject).invoke();
      if (aazI.compareAndSet(this, v.aazM, localObject))
      {
        this.aazF = null;
        AppMethodBeat.o(129576);
        return localObject;
      }
    }
    localObject = this.aazG;
    AppMethodBeat.o(129576);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129577);
    if (this.aazG != v.aazM) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129577);
      return str;
    }
    AppMethodBeat.o(129577);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.p
 * JD-Core Version:    0.7.0.1
 */