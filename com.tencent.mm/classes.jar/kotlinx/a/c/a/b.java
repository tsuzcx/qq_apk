package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.d.d;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/ContextValidator;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "discriminator", "", "(Ljava/lang/String;)V", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "kotlinx-serialization-runtime"})
public final class b
  implements d
{
  private final String NOd;
  
  public b(String paramString)
  {
    AppMethodBeat.i(191317);
    this.NOd = paramString;
    AppMethodBeat.o(191317);
  }
  
  public final <Base, Sub extends Base> void a(d.l.b<Base> paramb, d.l.b<Sub> paramb1, h<Sub> paramh)
  {
    AppMethodBeat.i(191316);
    p.h(paramb, "baseClass");
    p.h(paramb1, "actualClass");
    p.h(paramh, "actualSerializer");
    paramb = paramh.eLj();
    int i = 0;
    int j = paramb.gwT();
    while (i < j)
    {
      paramh = paramb.alJ(i);
      if (p.i(paramh, this.NOd))
      {
        paramb = (Throwable)new IllegalArgumentException("Polymorphic serializer for " + paramb1 + " has property '" + paramh + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
        AppMethodBeat.o(191316);
        throw paramb;
      }
      i += 1;
    }
    AppMethodBeat.o(191316);
  }
  
  public final <T> void a(d.l.b<T> paramb, h<T> paramh)
  {
    AppMethodBeat.i(191315);
    p.h(paramb, "kClass");
    p.h(paramh, "serializer");
    AppMethodBeat.o(191315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */