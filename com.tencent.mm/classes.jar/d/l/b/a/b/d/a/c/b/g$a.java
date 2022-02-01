package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.g.b.l;
import d.n.n;

final class g$a
  extends l
  implements m<String, String, Boolean>
{
  public static final a JCx;
  
  static
  {
    AppMethodBeat.i(57991);
    JCx = new a();
    AppMethodBeat.o(57991);
  }
  
  g$a()
  {
    super(2);
  }
  
  public static boolean ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57990);
    k.h(paramString1, "first");
    k.h(paramString2, "second");
    if ((k.g(paramString1, n.b(paramString2, (CharSequence)"out "))) || (k.g(paramString2, "*")))
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