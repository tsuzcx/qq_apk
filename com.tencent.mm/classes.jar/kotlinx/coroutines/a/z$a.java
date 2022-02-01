package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ValueOrClosed$Closed;", "", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
public final class z$a
{
  public final Throwable cause;
  
  public z$a(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204605);
    if (((paramObject instanceof a)) && (p.h(this.cause, ((a)paramObject).cause)))
    {
      AppMethodBeat.o(204605);
      return true;
    }
    AppMethodBeat.o(204605);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204606);
    Throwable localThrowable = this.cause;
    if (localThrowable != null)
    {
      int i = localThrowable.hashCode();
      AppMethodBeat.o(204606);
      return i;
    }
    AppMethodBeat.o(204606);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204607);
    String str = "Closed(" + this.cause + ')';
    AppMethodBeat.o(204607);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.a.z.a
 * JD-Core Version:    0.7.0.1
 */