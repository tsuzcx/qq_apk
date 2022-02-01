package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class Result$Failure
  implements Serializable
{
  public final Throwable exception;
  
  public Result$Failure(Throwable paramThrowable)
  {
    AppMethodBeat.i(129288);
    this.exception = paramThrowable;
    AppMethodBeat.o(129288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129285);
    if (((paramObject instanceof Failure)) && (p.j(this.exception, ((Failure)paramObject).exception)))
    {
      AppMethodBeat.o(129285);
      return true;
    }
    AppMethodBeat.o(129285);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129286);
    int i = this.exception.hashCode();
    AppMethodBeat.o(129286);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129287);
    String str = "Failure(" + this.exception + ')';
    AppMethodBeat.o(129287);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.Result.Failure
 * JD-Core Version:    0.7.0.1
 */