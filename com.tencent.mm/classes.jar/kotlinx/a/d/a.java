package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.h;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/modules/EmptyModule;", "Lkotlinx/serialization/modules/SerialModule;", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "", "kclass", "Lkotlin/reflect/KClass;", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "", "kotlinx-serialization-runtime"})
public final class a
  implements b
{
  public static final a NOF;
  
  static
  {
    AppMethodBeat.i(191499);
    NOF = new a();
    AppMethodBeat.o(191499);
  }
  
  public final <T> h<? extends T> a(d.l.b<T> paramb, T paramT)
  {
    AppMethodBeat.i(191496);
    p.h(paramb, "baseClass");
    p.h(paramT, "value");
    AppMethodBeat.o(191496);
    return null;
  }
  
  public final <T> h<? extends T> a(d.l.b<T> paramb, String paramString)
  {
    AppMethodBeat.i(191497);
    p.h(paramb, "baseClass");
    p.h(paramString, "serializedClassName");
    AppMethodBeat.o(191497);
    return null;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(191498);
    p.h(paramd, "collector");
    AppMethodBeat.o(191498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.a
 * JD-Core Version:    0.7.0.1
 */