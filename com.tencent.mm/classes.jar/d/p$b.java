package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.io.Serializable;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class p$b
  implements Serializable
{
  public final Throwable MKf;
  
  public p$b(Throwable paramThrowable)
  {
    AppMethodBeat.i(129288);
    this.MKf = paramThrowable;
    AppMethodBeat.o(129288);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129285);
    if (((paramObject instanceof b)) && (p.i(this.MKf, ((b)paramObject).MKf)))
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
    int i = this.MKf.hashCode();
    AppMethodBeat.o(129286);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129287);
    String str = "Failure(" + this.MKf + ')';
    AppMethodBeat.o(129287);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.p.b
 * JD-Core Version:    0.7.0.1
 */