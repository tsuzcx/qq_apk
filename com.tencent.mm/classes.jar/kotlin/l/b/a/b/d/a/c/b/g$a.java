package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;

final class g$a
  extends q
  implements m<String, String, Boolean>
{
  public static final a Ttz;
  
  static
  {
    AppMethodBeat.i(57991);
    Ttz = new a();
    AppMethodBeat.o(57991);
  }
  
  g$a()
  {
    super(2);
  }
  
  public static boolean or(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57990);
    p.h(paramString1, "first");
    p.h(paramString2, "second");
    if ((p.j(paramString1, n.b(paramString2, (CharSequence)"out "))) || (p.j(paramString2, "*")))
    {
      AppMethodBeat.o(57990);
      return true;
    }
    AppMethodBeat.o(57990);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.g.a
 * JD-Core Version:    0.7.0.1
 */