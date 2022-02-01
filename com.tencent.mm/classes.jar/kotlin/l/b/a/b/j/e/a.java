package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public final class a
{
  private static boolean af(ab paramab)
  {
    AppMethodBeat.i(60160);
    p.k(paramab, "$this$isInlineClassThatRequiresMangling");
    paramab = paramab.iOU().iEf();
    if (paramab != null)
    {
      paramab = (l)paramab;
      p.k(paramab, "$this$isInlineClassThatRequiresMangling");
      if ((e.D(paramab)) && (!p.h(kotlin.l.b.a.b.j.d.a.o((l)paramab), c.abke))) {}
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(60160);
        return true;
      }
    }
    AppMethodBeat.o(60160);
    return false;
  }
  
  public static final boolean ag(ab paramab)
  {
    AppMethodBeat.i(60161);
    if ((af(paramab)) || (ah(paramab)))
    {
      AppMethodBeat.o(60161);
      return true;
    }
    AppMethodBeat.o(60161);
    return false;
  }
  
  private static final boolean ah(ab paramab)
  {
    AppMethodBeat.i(60162);
    h localh = paramab.iOU().iEf();
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
    boolean bool = ag(kotlin.l.b.a.b.m.d.a.e(paramab));
    AppMethodBeat.o(60162);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.a
 * JD-Core Version:    0.7.0.1
 */