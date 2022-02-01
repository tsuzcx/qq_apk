package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.b.az;
import kotlinx.a.h;
import kotlinx.a.l.i;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class p
  implements h<o>
{
  static final kotlinx.a.n abAF;
  public static final p abDg;
  
  static
  {
    AppMethodBeat.i(256784);
    abDg = new p();
    Object localObject = (kotlinx.a.l)l.i.abAQ;
    kotlin.g.b.p.k("kotlinx.serialization.json.JsonLiteral", "serialName");
    kotlin.g.b.p.k(localObject, "kind");
    if (!kotlin.n.n.ba((CharSequence)"kotlinx.serialization.json.JsonLiteral")) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(256784);
      throw ((Throwable)localObject);
    }
    abAF = az.a("kotlinx.serialization.json.JsonLiteral", (kotlinx.a.l)localObject);
    AppMethodBeat.o(256784);
  }
  
  public final kotlinx.a.n gPe()
  {
    return abAF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.p
 * JD-Core Version:    0.7.0.1
 */