package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class y<T>
  implements Serializable, f<T>
{
  private a<? extends T> SWT;
  private Object SWU;
  
  public y(a<? extends T> parama)
  {
    AppMethodBeat.i(129284);
    this.SWT = parama;
    this.SWU = v.SXa;
    AppMethodBeat.o(129284);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129283);
    d locald = new d(getValue());
    AppMethodBeat.o(129283);
    return locald;
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129281);
    if (this.SWU == v.SXa)
    {
      localObject = this.SWT;
      if (localObject == null) {
        p.hyc();
      }
      this.SWU = ((a)localObject).invoke();
      this.SWT = null;
    }
    Object localObject = this.SWU;
    AppMethodBeat.o(129281);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129282);
    if (this.SWU != v.SXa) {}
    for (int i = 1; i != 0; i = 0)
    {
      String str = String.valueOf(getValue());
      AppMethodBeat.o(129282);
      return str;
    }
    AppMethodBeat.o(129282);
    return "Lazy value not initialized yet.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.y
 * JD-Core Version:    0.7.0.1
 */