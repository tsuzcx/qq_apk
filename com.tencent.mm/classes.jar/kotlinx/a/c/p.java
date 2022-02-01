package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.b.az;
import kotlinx.a.h;
import kotlinx.a.l.i;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class p
  implements h<o>
{
  static final kotlinx.a.n TXo;
  public static final p TZS;
  
  static
  {
    AppMethodBeat.i(225779);
    TZS = new p();
    Object localObject = (kotlinx.a.l)l.i.TXz;
    kotlin.g.b.p.h("kotlinx.serialization.json.JsonLiteral", "serialName");
    kotlin.g.b.p.h(localObject, "kind");
    if (!kotlin.n.n.aL((CharSequence)"kotlinx.serialization.json.JsonLiteral")) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(225779);
      throw ((Throwable)localObject);
    }
    TXo = az.a("kotlinx.serialization.json.JsonLiteral", (kotlinx.a.l)localObject);
    AppMethodBeat.o(225779);
  }
  
  public final kotlinx.a.n fWv()
  {
    return TXo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.p
 * JD-Core Version:    0.7.0.1
 */