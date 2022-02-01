package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

final class l$b$e
  extends q
  implements m<T, T, T>
{
  public static final e TuE;
  
  static
  {
    AppMethodBeat.i(58086);
    TuE = new e();
    AppMethodBeat.o(58086);
  }
  
  l$b$e()
  {
    super(2);
  }
  
  public final <T> T invoke(T paramT1, T paramT2)
  {
    AppMethodBeat.i(58085);
    T ?;
    if ((paramT1 == null) || (paramT2 == null) || (p.j(paramT1, paramT2)))
    {
      ? = paramT1;
      if (paramT1 == null)
      {
        AppMethodBeat.o(58085);
        return paramT2;
      }
    }
    else
    {
      ? = null;
    }
    AppMethodBeat.o(58085);
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.l.b.e
 * JD-Core Version:    0.7.0.1
 */