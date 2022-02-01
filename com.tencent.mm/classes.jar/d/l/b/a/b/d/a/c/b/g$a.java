package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.n.n;

final class g$a
  extends q
  implements m<String, String, Boolean>
{
  public static final a NgN;
  
  static
  {
    AppMethodBeat.i(57991);
    NgN = new a();
    AppMethodBeat.o(57991);
  }
  
  g$a()
  {
    super(2);
  }
  
  public static boolean nr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57990);
    p.h(paramString1, "first");
    p.h(paramString2, "second");
    if ((p.i(paramString1, n.b(paramString2, (CharSequence)"out "))) || (p.i(paramString2, "*")))
    {
      AppMethodBeat.o(57990);
      return true;
    }
    AppMethodBeat.o(57990);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.g.a
 * JD-Core Version:    0.7.0.1
 */