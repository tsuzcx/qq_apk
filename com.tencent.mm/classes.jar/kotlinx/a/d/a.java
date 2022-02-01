package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/modules/EmptyModule;", "Lkotlinx/serialization/modules/SerialModule;", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "", "kclass", "Lkotlin/reflect/KClass;", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "", "kotlinx-serialization-runtime"})
public final class a
  implements b
{
  public static final a abDW;
  
  static
  {
    AppMethodBeat.i(257169);
    abDW = new a();
    AppMethodBeat.o(257169);
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, T paramT)
  {
    AppMethodBeat.i(257163);
    p.k(paramb, "baseClass");
    p.k(paramT, "value");
    AppMethodBeat.o(257163);
    return null;
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, String paramString)
  {
    AppMethodBeat.i(257164);
    p.k(paramb, "baseClass");
    p.k(paramString, "serializedClassName");
    AppMethodBeat.o(257164);
    return null;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(257166);
    p.k(paramd, "collector");
    AppMethodBeat.o(257166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.d.a
 * JD-Core Version:    0.7.0.1
 */