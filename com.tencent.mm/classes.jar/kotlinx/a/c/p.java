package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.b.az;
import kotlinx.a.h;
import kotlinx.a.l.i;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class p
  implements h<o>
{
  static final kotlinx.a.n NLm;
  public static final p NNP;
  
  static
  {
    AppMethodBeat.i(191418);
    NNP = new p();
    Object localObject = (kotlinx.a.l)l.i.NLx;
    d.g.b.p.h("kotlinx.serialization.json.JsonLiteral", "serialName");
    d.g.b.p.h(localObject, "kind");
    if (!d.n.n.aE((CharSequence)"kotlinx.serialization.json.JsonLiteral")) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(191418);
      throw ((Throwable)localObject);
    }
    NLm = az.a("kotlinx.serialization.json.JsonLiteral", (kotlinx.a.l)localObject);
    AppMethodBeat.o(191418);
  }
  
  public final kotlinx.a.n eLj()
  {
    return NLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.p
 * JD-Core Version:    0.7.0.1
 */