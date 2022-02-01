package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"nullable", "Lkotlinx/serialization/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/SerialDescriptor;)Lkotlinx/serialization/SerialDescriptor;", "PrimitiveDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "SerialDescriptor", "Lkotlinx/serialization/SerialKind;", "builder", "Lkotlin/Function1;", "Lkotlinx/serialization/SerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "descriptor", "T", "listDescriptor", "typeDescriptor", "mapDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "setDescriptor", "kotlinx-serialization-runtime"})
public final class p
{
  public static final n a(String paramString, s params, b<? super o, z> paramb)
  {
    AppMethodBeat.i(191003);
    d.g.b.p.h(paramString, "serialName");
    d.g.b.p.h(params, "kind");
    d.g.b.p.h(paramb, "builder");
    if (!d.n.n.aE((CharSequence)paramString)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(191003);
      throw paramString;
    }
    o localo = new o(paramString);
    paramb.invoke(localo);
    paramString = (n)new q(paramString, params, localo.NLB.size(), localo);
    AppMethodBeat.o(191003);
    return paramString;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class a
    extends d.g.b.q
    implements b<o, z>
  {
    public static final a NLH;
    
    static
    {
      AppMethodBeat.i(191020);
      NLH = new a();
      AppMethodBeat.o(191020);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.p
 * JD-Core Version:    0.7.0.1
 */