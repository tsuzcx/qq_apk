package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class q<T>
  implements Serializable, f<T>
{
  private a<? extends T> aazF;
  private volatile Object aazG;
  private final Object lock;
  
  private q(a<? extends T> parama)
  {
    AppMethodBeat.i(129585);
    this.aazF = parama;
    this.aazG = v.aazM;
    this.lock = this;
    AppMethodBeat.o(129585);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129584);
    d locald = new d(getValue());
    AppMethodBeat.o(129584);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129582);
    Object localObject1 = this.aazG;
    if (localObject1 != v.aazM)
    {
      AppMethodBeat.o(129582);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.aazG;
      v localv = v.aazM;
      if (localObject1 != localv)
      {
        AppMethodBeat.o(129582);
        return localObject1;
      }
      localObject1 = this.aazF;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((a)localObject1).invoke();
      this.aazG = localObject1;
      this.aazF = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129583);
    if (this.aazG != v.aazM) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129583);
      return str;
    }
    AppMethodBeat.o(129583);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.q
 * JD-Core Version:    0.7.0.1
 */