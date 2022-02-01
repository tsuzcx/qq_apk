package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@Metadata(d1={""}, d2={"Lkotlin/InitializedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isInitialized", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class e<T>
  implements Serializable, j<T>
{
  private final T value = null;
  
  public final T getValue()
  {
    return this.value;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129327);
    String str = String.valueOf(getValue());
    AppMethodBeat.o(129327);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e
 * JD-Core Version:    0.7.0.1
 */