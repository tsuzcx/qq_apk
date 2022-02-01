package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.b.az;
import kotlinx.a.h;
import kotlinx.a.l.i;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class p
  implements h<o>
{
  static final kotlinx.a.n Ois;
  public static final p OkV;
  
  static
  {
    AppMethodBeat.i(200006);
    OkV = new p();
    Object localObject = (kotlinx.a.l)l.i.OiD;
    d.g.b.p.h("kotlinx.serialization.json.JsonLiteral", "serialName");
    d.g.b.p.h(localObject, "kind");
    if (!d.n.n.aD((CharSequence)"kotlinx.serialization.json.JsonLiteral")) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(200006);
      throw ((Throwable)localObject);
    }
    Ois = az.a("kotlinx.serialization.json.JsonLiteral", (kotlinx.a.l)localObject);
    AppMethodBeat.o(200006);
  }
  
  public final kotlinx.a.n eOR()
  {
    return Ois;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.p
 * JD-Core Version:    0.7.0.1
 */