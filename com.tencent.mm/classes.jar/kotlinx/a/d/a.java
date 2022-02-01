package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/modules/EmptyModule;", "Lkotlinx/serialization/modules/SerialModule;", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "", "kclass", "Lkotlin/reflect/KClass;", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "", "kotlinx-serialization-runtime"})
public final class a
  implements b
{
  public static final a UaI;
  
  static
  {
    AppMethodBeat.i(225861);
    UaI = new a();
    AppMethodBeat.o(225861);
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, T paramT)
  {
    AppMethodBeat.i(225858);
    p.h(paramb, "baseClass");
    p.h(paramT, "value");
    AppMethodBeat.o(225858);
    return null;
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, String paramString)
  {
    AppMethodBeat.i(225859);
    p.h(paramb, "baseClass");
    p.h(paramString, "serializedClassName");
    AppMethodBeat.o(225859);
    return null;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(225860);
    p.h(paramd, "collector");
    AppMethodBeat.o(225860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.d.a
 * JD-Core Version:    0.7.0.1
 */