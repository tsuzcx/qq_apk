package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"nullable", "Lkotlinx/serialization/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/SerialDescriptor;)Lkotlinx/serialization/SerialDescriptor;", "PrimitiveDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "SerialDescriptor", "Lkotlinx/serialization/SerialKind;", "builder", "Lkotlin/Function1;", "Lkotlinx/serialization/SerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "descriptor", "T", "listDescriptor", "typeDescriptor", "mapDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "setDescriptor", "kotlinx-serialization-runtime"})
public final class p
{
  public static final n a(String paramString, s params, b<? super o, x> paramb)
  {
    AppMethodBeat.i(254162);
    kotlin.g.b.p.k(paramString, "serialName");
    kotlin.g.b.p.k(params, "kind");
    kotlin.g.b.p.k(paramb, "builder");
    if (!kotlin.n.n.ba((CharSequence)paramString)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(254162);
      throw paramString;
    }
    o localo = new o(paramString);
    paramb.invoke(localo);
    paramString = (n)new q(paramString, params, localo.abAS.size(), localo);
    AppMethodBeat.o(254162);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<o, x>
  {
    public static final a abAY;
    
    static
    {
      AppMethodBeat.i(254200);
      abAY = new a();
      AppMethodBeat.o(254200);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.p
 * JD-Core Version:    0.7.0.1
 */