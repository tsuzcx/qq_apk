package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/Symbol;", "", "symbol", "", "(Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "toString", "unbox", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  private final String aitW;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(118071);
    this.aitW = paramString;
    AppMethodBeat.o(118071);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189434);
    String str = "<" + this.aitW + '>';
    AppMethodBeat.o(189434);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.ac
 * JD-Core Version:    0.7.0.1
 */