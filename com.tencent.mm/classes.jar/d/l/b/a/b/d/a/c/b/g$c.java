package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.g.b.l;
import d.n.n;

final class g$c
  extends l
  implements m<String, String, String>
{
  public static final c JCz;
  
  static
  {
    AppMethodBeat.i(57996);
    JCz = new c();
    AppMethodBeat.o(57996);
  }
  
  g$c()
  {
    super(2);
  }
  
  public static String mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57995);
    k.h(paramString1, "$this$replaceArgs");
    k.h(paramString2, "newArgs");
    if (!n.c((CharSequence)paramString1, '<'))
    {
      AppMethodBeat.o(57995);
      return paramString1;
    }
    paramString1 = n.b(paramString1, '<') + '<' + paramString2 + '>' + n.a(paramString1, '>');
    AppMethodBeat.o(57995);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.g.c
 * JD-Core Version:    0.7.0.1
 */