package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;

final class g$c
  extends q
  implements m<String, String, String>
{
  public static final c TtB;
  
  static
  {
    AppMethodBeat.i(57996);
    TtB = new c();
    AppMethodBeat.o(57996);
  }
  
  g$c()
  {
    super(2);
  }
  
  public static String os(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57995);
    p.h(paramString1, "$this$replaceArgs");
    p.h(paramString2, "newArgs");
    if (!n.c((CharSequence)paramString1, '<'))
    {
      AppMethodBeat.o(57995);
      return paramString1;
    }
    paramString1 = n.a(paramString1, '<') + '<' + paramString2 + '>' + n.b(paramString1, '>');
    AppMethodBeat.o(57995);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.g.c
 * JD-Core Version:    0.7.0.1
 */