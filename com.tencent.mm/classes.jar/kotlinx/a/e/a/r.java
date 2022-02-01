package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.d;
import kotlinx.a.b.e;
import kotlinx.a.b.i;
import kotlinx.a.b.i.b;
import kotlinx.a.b.j.b;
import kotlinx.a.b.j.c;
import kotlinx.a.e.a;
import kotlinx.a.e.j;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"selectMapMode", "T", "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class r
{
  public static final q a(a parama, e parame)
  {
    AppMethodBeat.i(188546);
    s.u(parama, "$this$switchMode");
    s.u(parame, "desc");
    i locali = parame.kFd();
    if ((locali instanceof kotlinx.a.b.c))
    {
      parama = q.ajEU;
      AppMethodBeat.o(188546);
      return parama;
    }
    if (s.p(locali, j.b.ajDk))
    {
      parama = q.ajES;
      AppMethodBeat.o(188546);
      return parama;
    }
    if (s.p(locali, j.c.ajDl))
    {
      parame = parame.aMJ(0);
      locali = parame.kFd();
      if (((locali instanceof d)) || (s.p(locali, i.b.ajDi)))
      {
        parama = q.ajET;
        AppMethodBeat.o(188546);
        return parama;
      }
      if (parama.ajEb.ajEt)
      {
        parama = q.ajES;
        AppMethodBeat.o(188546);
        return parama;
      }
      parama = (Throwable)j.i(parame);
      AppMethodBeat.o(188546);
      throw parama;
    }
    parama = q.ajER;
    AppMethodBeat.o(188546);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.r
 * JD-Core Version:    0.7.0.1
 */