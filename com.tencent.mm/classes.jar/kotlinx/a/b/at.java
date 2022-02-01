package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.h.a;
import kotlinx.a.n;
import kotlinx.a.s;
import kotlinx.a.w.d;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "(Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class at<T>
  implements h<T>
{
  final n NLm;
  private final T NMH;
  
  public at(String paramString, T paramT)
  {
    AppMethodBeat.i(191130);
    this.NMH = paramT;
    this.NLm = kotlinx.a.p.a(paramString, (s)w.d.NLT);
    AppMethodBeat.o(191130);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(191129);
    d.g.b.p.h(paramc, "decoder");
    paramc.a(this.NLm, new h[0]).a(this.NLm);
    paramc = this.NMH;
    AppMethodBeat.o(191129);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(191131);
    d.g.b.p.h(paramc, "decoder");
    d.g.b.p.h(paramT, "old");
    paramc = h.a.a(this, paramc);
    AppMethodBeat.o(191131);
    return paramc;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(191128);
    d.g.b.p.h(paramg, "encoder");
    d.g.b.p.h(paramT, "value");
    paramg.b(this.NLm, new h[0]).a(this.NLm);
    AppMethodBeat.o(191128);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.at
 * JD-Core Version:    0.7.0.1
 */