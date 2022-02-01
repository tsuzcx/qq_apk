package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(k=3, mv={1, 5, 1})
public final class d$a
{
  public static <M extends Member> void a(d<? extends M> paramd, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56589);
    s.u(paramArrayOfObject, "args");
    if (f.a(paramd) != paramArrayOfObject.length)
    {
      paramd = (Throwable)new IllegalArgumentException("Callable expects " + f.a(paramd) + " arguments, but " + paramArrayOfObject.length + " were provided.");
      AppMethodBeat.o(56589);
      throw paramd;
    }
    AppMethodBeat.o(56589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.a.d.a
 * JD-Core Version:    0.7.0.1
 */