package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import java.io.Serializable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class z<T>
  implements f<T>, Serializable
{
  private a<? extends T> JfO;
  private Object JfP;
  
  public z(a<? extends T> parama)
  {
    AppMethodBeat.i(129284);
    this.JfO = parama;
    this.JfP = w.JfU;
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
    if (this.JfP == w.JfU)
    {
      localObject = this.JfO;
      if (localObject == null) {
        k.fvU();
      }
      this.JfP = ((a)localObject).invoke();
      this.JfO = null;
    }
    Object localObject = this.JfP;
    AppMethodBeat.o(129281);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129282);
    if (this.JfP != w.JfU) {}
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
 * Qualified Name:     d.z
 * JD-Core Version:    0.7.0.1
 */