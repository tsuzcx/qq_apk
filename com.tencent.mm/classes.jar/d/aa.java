package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import java.io.Serializable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class aa<T>
  implements f<T>, Serializable
{
  private a<? extends T> MKg;
  private Object MKh;
  
  public aa(a<? extends T> parama)
  {
    AppMethodBeat.i(129284);
    this.MKg = parama;
    this.MKh = x.MKn;
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
    if (this.MKh == x.MKn)
    {
      localObject = this.MKg;
      if (localObject == null) {
        p.gfZ();
      }
      this.MKh = ((a)localObject).invoke();
      this.MKg = null;
    }
    Object localObject = this.MKh;
    AppMethodBeat.o(129281);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129282);
    if (this.MKh != x.MKn) {}
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
 * Qualified Name:     d.aa
 * JD-Core Version:    0.7.0.1
 */