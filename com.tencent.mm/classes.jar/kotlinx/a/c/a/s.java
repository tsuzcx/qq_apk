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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-runtime"})
public final class s
{
  public static final r a(a parama, n paramn)
  {
    AppMethodBeat.i(256132);
    p.k(parama, "$this$switchMode");
    p.k(paramn, "desc");
    kotlinx.a.s locals = paramn.iTG();
    if ((locals instanceof j))
    {
      parama = r.abDQ;
      AppMethodBeat.o(256132);
      return parama;
    }
    if (p.h(locals, w.b.abBi))
    {
      parama = r.abDO;
      AppMethodBeat.o(256132);
      return parama;
    }
    if (p.h(locals, w.c.abBj))
    {
      paramn = paramn.aFY(0);
      locals = paramn.iTG();
      if (((locals instanceof kotlinx.a.l)) || (p.h(locals, x.c.abBo)))
      {
        parama = r.abDP;
        AppMethodBeat.o(256132);
        return parama;
      }
      if (parama.abCv.abCJ)
      {
        parama = r.abDO;
        AppMethodBeat.o(256132);
        return parama;
      }
      parama = (Throwable)kotlinx.a.c.l.f(paramn);
      AppMethodBeat.o(256132);
      throw parama;
    }
    parama = r.abDN;
    AppMethodBeat.o(256132);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.s
 * JD-Core Version:    0.7.0.1
 */