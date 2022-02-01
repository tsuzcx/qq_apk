package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"nullable", "Lkotlinx/serialization/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/SerialDescriptor;)Lkotlinx/serialization/SerialDescriptor;", "PrimitiveDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "SerialDescriptor", "Lkotlinx/serialization/SerialKind;", "builder", "Lkotlin/Function1;", "Lkotlinx/serialization/SerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "descriptor", "T", "listDescriptor", "typeDescriptor", "mapDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "setDescriptor", "kotlinx-serialization-runtime"})
public final class p
{
  public static final n a(String paramString, s params, b<? super o, x> paramb)
  {
    AppMethodBeat.i(225363);
    kotlin.g.b.p.h(paramString, "serialName");
    kotlin.g.b.p.h(params, "kind");
    kotlin.g.b.p.h(paramb, "builder");
    if (!kotlin.n.n.aL((CharSequence)paramString)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(225363);
      throw paramString;
    }
    o localo = new o(paramString);
    paramb.invoke(localo);
    paramString = (n)new q(paramString, params, localo.TXD.size(), localo);
    AppMethodBeat.o(225363);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.p
 * JD-Core Version:    0.7.0.1
 */