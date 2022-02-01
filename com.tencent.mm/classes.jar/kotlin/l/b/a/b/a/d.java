package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.d.a;

public final class d
{
  public static final boolean a(c paramc, e parame)
  {
    AppMethodBeat.i(191414);
    s.u(paramc, "<this>");
    s.u(parame, "classDescriptor");
    if (kotlin.l.b.a.b.j.d.u((l)parame))
    {
      Iterable localIterable = (Iterable)c.kmF();
      paramc = a.d((h)parame);
      if (paramc == null) {}
      for (paramc = null; p.a(localIterable, paramc); paramc = paramc.kxO())
      {
        AppMethodBeat.o(191414);
        return true;
      }
    }
    AppMethodBeat.o(191414);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */