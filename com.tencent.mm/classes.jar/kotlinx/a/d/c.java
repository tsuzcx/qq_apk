package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"SerializersModule", "Lkotlinx/serialization/modules/SerialModule;", "buildAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "", "Lkotlin/ExtensionFunctionType;", "serializersModule", "T", "", "serializer", "Lkotlinx/serialization/KSerializer;", "serializersModuleOf", "map", "", "Lkotlin/reflect/KClass;", "kClass", "contextual", "kotlinx-serialization-runtime"})
public final class c
{
  public static final b P(d.g.a.b<? super h, z> paramb)
  {
    AppMethodBeat.i(200096);
    p.h(paramb, "buildAction");
    h localh = new h();
    paramb.invoke(localh);
    paramb = localh.gCa();
    AppMethodBeat.o(200096);
    return paramb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "invoke"})
  public static final class a
    extends q
    implements d.g.a.b<h, z>
  {
    public a(Map paramMap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.c
 * JD-Core Version:    0.7.0.1
 */