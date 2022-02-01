package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"nullable", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "buildClassSerialDescriptor", "typeParameters", "", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "buildSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "listSerialDescriptor", "T", "elementDescriptor", "mapSerialDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "serialDescriptor", "type", "Lkotlin/reflect/KType;", "setSerialDescriptor", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class h
{
  public static final e a(String paramString, i parami, e[] paramArrayOfe, b<? super a, ah> paramb)
  {
    AppMethodBeat.i(188435);
    s.u(paramString, "serialName");
    s.u(parami, "kind");
    s.u(paramArrayOfe, "typeParameters");
    s.u(paramb, "builder");
    if (!n.bp((CharSequence)paramString)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Blank serial names are prohibited".toString());
      AppMethodBeat.o(188435);
      throw paramString;
    }
    if (!(s.p(parami, j.a.ajDj) ^ true))
    {
      paramString = (Throwable)new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
      AppMethodBeat.o(188435);
      throw paramString;
    }
    a locala = new a(paramString);
    paramb.invoke(locala);
    paramString = (e)new f(paramString, parami, locala.ajCB.size(), k.ae(paramArrayOfe), locala);
    AppMethodBeat.o(188435);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.b.h
 * JD-Core Version:    0.7.0.1
 */