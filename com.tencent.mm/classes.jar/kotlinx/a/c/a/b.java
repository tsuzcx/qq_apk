package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.d;
import kotlinx.a.h;
import kotlinx.a.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/ContextValidator;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "discriminator", "", "(Ljava/lang/String;)V", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "kotlinx-serialization-runtime"})
public final class b
  implements d
{
  private final String abDu;
  
  public b(String paramString)
  {
    AppMethodBeat.i(255910);
    this.abDu = paramString;
    AppMethodBeat.o(255910);
  }
  
  public final <Base, Sub extends Base> void a(kotlin.l.b<Base> paramb, kotlin.l.b<Sub> paramb1, h<Sub> paramh)
  {
    AppMethodBeat.i(255909);
    p.k(paramb, "baseClass");
    p.k(paramb1, "actualClass");
    p.k(paramh, "actualSerializer");
    paramb = paramh.gPe();
    int i = 0;
    int j = paramb.iTI();
    while (i < j)
    {
      paramh = paramb.aFX(i);
      if (p.h(paramh, this.abDu))
      {
        paramb = (Throwable)new IllegalArgumentException("Polymorphic serializer for " + paramb1 + " has property '" + paramh + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
        AppMethodBeat.o(255909);
        throw paramb;
      }
      i += 1;
    }
    AppMethodBeat.o(255909);
  }
  
  public final <T> void a(kotlin.l.b<T> paramb, h<T> paramh)
  {
    AppMethodBeat.i(255908);
    p.k(paramb, "kClass");
    p.k(paramh, "serializer");
    AppMethodBeat.o(255908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */