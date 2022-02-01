package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$a
  extends l.c
{
  public final Throwable cause;
  
  public l$a(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189264);
    if (((paramObject instanceof a)) && (s.p(this.cause, ((a)paramObject).cause)))
    {
      AppMethodBeat.o(189264);
      return true;
    }
    AppMethodBeat.o(189264);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(189272);
    Throwable localThrowable = this.cause;
    if (localThrowable != null)
    {
      int i = localThrowable.hashCode();
      AppMethodBeat.o(189272);
      return i;
    }
    AppMethodBeat.o(189272);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189277);
    String str = "Closed(" + this.cause + ')';
    AppMethodBeat.o(189277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.l.a
 * JD-Core Version:    0.7.0.1
 */