package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"findObjectSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "args", "", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "isInstanceOf", "kclass", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class ae
{
  public static final boolean a(Object paramObject, c<?> paramc)
  {
    AppMethodBeat.i(188708);
    s.u(paramObject, "$this$isInstanceOf");
    s.u(paramc, "kclass");
    boolean bool = a.d(paramc).isInstance(paramObject);
    AppMethodBeat.o(188708);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ae
 * JD-Core Version:    0.7.0.1
 */