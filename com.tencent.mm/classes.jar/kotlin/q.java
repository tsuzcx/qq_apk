package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class q<T>
  implements Serializable, f<T>
{
  private a<? extends T> SWT;
  private volatile Object SWU;
  private final Object lock;
  
  private q(a<? extends T> parama)
  {
    AppMethodBeat.i(129585);
    this.SWT = parama;
    this.SWU = v.SXa;
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
    Object localObject1 = this.SWU;
    if (localObject1 != v.SXa)
    {
      AppMethodBeat.o(129582);
      return localObject1;
    }
    synchronized (this.lock)
    {
      localObject1 = this.SWU;
      v localv = v.SXa;
      if (localObject1 != localv)
      {
        AppMethodBeat.o(129582);
        return localObject1;
      }
      localObject1 = this.SWT;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((a)localObject1).invoke();
      this.SWU = localObject1;
      this.SWT = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129583);
    if (this.SWU != v.SXa) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.q
 * JD-Core Version:    0.7.0.1
 */