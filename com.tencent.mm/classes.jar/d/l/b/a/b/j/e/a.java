package d.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.l;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.e;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;

public final class a
{
  private static boolean ag(ab paramab)
  {
    AppMethodBeat.i(60160);
    p.h(paramab, "$this$isInlineClassThatRequiresMangling");
    paramab = paramab.gsZ().ghO();
    if (paramab != null)
    {
      paramab = (l)paramab;
      p.h(paramab, "$this$isInlineClassThatRequiresMangling");
      if ((e.D(paramab)) && (!p.i(d.l.b.a.b.j.d.a.o((l)paramab), c.Nvy))) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(60160);
        return true;
      }
    }
    AppMethodBeat.o(60160);
    return false;
  }
  
  public static final boolean ah(ab paramab)
  {
    AppMethodBeat.i(60161);
    if ((ag(paramab)) || (ai(paramab)))
    {
      AppMethodBeat.o(60161);
      return true;
    }
    AppMethodBeat.o(60161);
    return false;
  }
  
  private static final boolean ai(ab paramab)
  {
    AppMethodBeat.i(60162);
    h localh = paramab.gsZ().ghO();
    paramab = localh;
    if (!(localh instanceof as)) {
      paramab = null;
    }
    paramab = (as)paramab;
    if (paramab == null)
    {
      AppMethodBeat.o(60162);
      return false;
    }
    boolean bool = ah(d.l.b.a.b.m.d.a.e(paramab));
    AppMethodBeat.o(60162);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.e.a
 * JD-Core Version:    0.7.0.1
 */