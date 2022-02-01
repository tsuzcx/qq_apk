package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.c.a;
import kotlinx.a.c.d;
import kotlinx.a.j;
import kotlinx.a.n;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-runtime"})
public final class s
{
  public static final r a(a parama, n paramn)
  {
    AppMethodBeat.i(225711);
    p.h(parama, "$this$switchMode");
    p.h(paramn, "desc");
    kotlinx.a.s locals = paramn.hOA();
    if ((locals instanceof j))
    {
      parama = r.UaC;
      AppMethodBeat.o(225711);
      return parama;
    }
    if (p.j(locals, w.b.TXT))
    {
      parama = r.UaA;
      AppMethodBeat.o(225711);
      return parama;
    }
    if (p.j(locals, w.c.TXU))
    {
      paramn = paramn.awd(0);
      locals = paramn.hOA();
      if (((locals instanceof kotlinx.a.l)) || (p.j(locals, x.c.TXZ)))
      {
        parama = r.UaB;
        AppMethodBeat.o(225711);
        return parama;
      }
      if (parama.TZf.TZu)
      {
        parama = r.UaA;
        AppMethodBeat.o(225711);
        return parama;
      }
      parama = (Throwable)kotlinx.a.c.l.f(paramn);
      AppMethodBeat.o(225711);
      throw parama;
    }
    parama = r.Uaz;
    AppMethodBeat.o(225711);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.s
 * JD-Core Version:    0.7.0.1
 */