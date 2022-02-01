package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ai<T>
  implements Serializable, j<T>
{
  private a<? extends T> aiuJ;
  private Object aiuK;
  
  public ai(a<? extends T> parama)
  {
    AppMethodBeat.i(129284);
    this.aiuJ = parama;
    this.aiuK = ad.aiuU;
    AppMethodBeat.o(129284);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(129281);
    if (this.aiuK == ad.aiuU)
    {
      localObject = this.aiuJ;
      s.checkNotNull(localObject);
      this.aiuK = ((a)localObject).invoke();
      this.aiuJ = null;
    }
    Object localObject = this.aiuK;
    AppMethodBeat.o(129281);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129282);
    if (this.aiuK != ad.aiuU) {}
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
 * Qualified Name:     kotlin.ai
 * JD-Core Version:    0.7.0.1
 */