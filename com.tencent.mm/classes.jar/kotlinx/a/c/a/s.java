package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import kotlinx.a.c.a;
import kotlinx.a.c.d;
import kotlinx.a.j;
import kotlinx.a.n;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-runtime"})
public final class s
{
  public static final r a(a parama, n paramn)
  {
    AppMethodBeat.i(199939);
    p.h(parama, "$this$switchMode");
    p.h(paramn, "desc");
    kotlinx.a.s locals = paramn.gBt();
    if ((locals instanceof j))
    {
      parama = r.OlF;
      AppMethodBeat.o(199939);
      return parama;
    }
    if (p.i(locals, w.b.OiX))
    {
      parama = r.OlD;
      AppMethodBeat.o(199939);
      return parama;
    }
    if (p.i(locals, w.c.OiY))
    {
      paramn = paramn.amu(0);
      locals = paramn.gBt();
      if (((locals instanceof kotlinx.a.l)) || (p.i(locals, x.c.Ojd)))
      {
        parama = r.OlE;
        AppMethodBeat.o(199939);
        return parama;
      }
      if (parama.Okk.Oky)
      {
        parama = r.OlD;
        AppMethodBeat.o(199939);
        return parama;
      }
      parama = (Throwable)kotlinx.a.c.l.f(paramn);
      AppMethodBeat.o(199939);
      throw parama;
    }
    parama = r.OlC;
    AppMethodBeat.o(199939);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.s
 * JD-Core Version:    0.7.0.1
 */