package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a;
import d.g.b.p;
import d.l;
import d.l.b;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"enumFromName", "E", "", "enumClass", "Lkotlin/reflect/KClass;", "value", "", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Ljava/lang/Enum;", "enumFromOrdinal", "ordinal", "", "(Lkotlin/reflect/KClass;I)Ljava/lang/Enum;", "findObjectSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "isReferenceArray", "", "type", "Lkotlin/reflect/KType;", "rootClass", "stringFromUtf8Bytes", "bytes", "", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "args", "", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "enumClassName", "enumMembers", "(Lkotlin/reflect/KClass;)[Ljava/lang/Enum;", "isInstanceOf", "kclass", "simpleName", "toNativeArrayImpl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "toUtf8Bytes", "kotlinx-serialization-runtime"})
public final class u
{
  public static final boolean a(Object paramObject, b<?> paramb)
  {
    AppMethodBeat.i(200079);
    p.h(paramObject, "$this$isInstanceOf");
    p.h(paramb, "kclass");
    boolean bool = a.c(paramb).isInstance(paramObject);
    AppMethodBeat.o(200079);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.u
 * JD-Core Version:    0.7.0.1
 */