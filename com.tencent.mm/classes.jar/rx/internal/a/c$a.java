package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

final class c$a
  implements Serializable
{
  final Throwable e;
  
  public c$a(Throwable paramThrowable)
  {
    this.e = paramThrowable;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90231);
    String str = "Notification=>Error:" + this.e;
    AppMethodBeat.o(90231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     rx.internal.a.c.a
 * JD-Core Version:    0.7.0.1
 */