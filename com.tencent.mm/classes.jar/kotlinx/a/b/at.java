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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "(Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class at<T>
  implements h<T>
{
  final n TXo;
  private final T TYI;
  
  public at(String paramString, T paramT)
  {
    AppMethodBeat.i(225490);
    this.TYI = paramT;
    this.TXo = kotlinx.a.p.a(paramString, (s)w.d.TXV);
    AppMethodBeat.o(225490);
  }
  
  public final T a(c paramc)
  {
    AppMethodBeat.i(225489);
    kotlin.g.b.p.h(paramc, "decoder");
    paramc.a(this.TXo, new h[0]).a(this.TXo);
    paramc = this.TYI;
    AppMethodBeat.o(225489);
    return paramc;
  }
  
  public final T a(c paramc, T paramT)
  {
    AppMethodBeat.i(225491);
    kotlin.g.b.p.h(paramc, "decoder");
    kotlin.g.b.p.h(paramT, "old");
    paramc = h.a.a(this, paramc);
    AppMethodBeat.o(225491);
    return paramc;
  }
  
  public final void a(g paramg, T paramT)
  {
    AppMethodBeat.i(225488);
    kotlin.g.b.p.h(paramg, "encoder");
    kotlin.g.b.p.h(paramT, "value");
    paramg.b(this.TXo, new h[0]).a(this.TXo);
    AppMethodBeat.o(225488);
  }
  
  public final n fWv()
  {
    return this.TXo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.at
 * JD-Core Version:    0.7.0.1
 */