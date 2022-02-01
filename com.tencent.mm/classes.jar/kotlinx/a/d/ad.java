package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b;
import kotlinx.a.b.h;
import kotlinx.a.b.i;
import kotlinx.a.b.j.d;
import kotlinx.a.c.c;
import kotlinx.a.c.d;
import kotlinx.a.c.f;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "(Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class ad<T>
  implements b<T>
{
  final kotlinx.a.b.e Wki;
  private final T ajDH;
  
  public ad(String paramString, T paramT)
  {
    AppMethodBeat.i(188692);
    this.ajDH = paramT;
    this.Wki = h.a(paramString, (i)j.d.ajDm, new kotlinx.a.b.e[0]);
    AppMethodBeat.o(188692);
  }
  
  public final T a(kotlinx.a.c.e parame)
  {
    AppMethodBeat.i(188720);
    s.u(parame, "decoder");
    parame.c(this.Wki).b(this.Wki);
    parame = this.ajDH;
    AppMethodBeat.o(188720);
    return parame;
  }
  
  public final void a(f paramf, T paramT)
  {
    AppMethodBeat.i(188711);
    s.u(paramf, "encoder");
    s.u(paramT, "value");
    paramf.e(this.Wki).b(this.Wki);
    AppMethodBeat.o(188711);
  }
  
  public final kotlinx.a.b.e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ad
 * JD-Core Version:    0.7.0.1
 */