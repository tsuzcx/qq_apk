package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.h.a;
import kotlinx.a.n;
import kotlinx.a.s;
import kotlinx.a.w.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "(Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class at<T>
  implements h<T>
{
  final n abAF;
  private final T abBX;
  
  public at(String paramString, T paramT)
  {
    AppMethodBeat.i(254477);
    this.abBX = paramT;
    this.abAF = kotlinx.a.p.a(paramString, (s)w.d.abBk);
    AppMethodBeat.o(254477);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(254474);
    kotlin.g.b.p.k(paramc, "decoder");
    paramc.a(this.abAF, new h[0]).a(this.abAF);
    paramc = this.abBX;
    AppMethodBeat.o(254474);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(254478);
    kotlin.g.b.p.k(paramc, "decoder");
    kotlin.g.b.p.k(paramT, "old");
    paramc = h.a.a(this, paramc);
    AppMethodBeat.o(254478);
    return paramc;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(254473);
    kotlin.g.b.p.k(paramg, "encoder");
    kotlin.g.b.p.k(paramT, "value");
    paramg.b(this.abAF, new h[0]).a(this.abAF);
    AppMethodBeat.o(254473);
  }
  
  public final n gPe()
  {
    return this.abAF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.at
 * JD-Core Version:    0.7.0.1
 */