package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.d;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/ContextValidator;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "discriminator", "", "(Ljava/lang/String;)V", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "kotlinx-serialization-runtime"})
public final class b
  implements d
{
  private final String Uag;
  
  public b(String paramString)
  {
    AppMethodBeat.i(225677);
    this.Uag = paramString;
    AppMethodBeat.o(225677);
  }
  
  public final <Base, Sub extends Base> void a(kotlin.l.b<Base> paramb, kotlin.l.b<Sub> paramb1, h<Sub> paramh)
  {
    AppMethodBeat.i(225676);
    p.h(paramb, "baseClass");
    p.h(paramb1, "actualClass");
    p.h(paramh, "actualSerializer");
    paramb = paramh.fWv();
    int i = 0;
    int j = paramb.hOC();
    while (i < j)
    {
      paramh = paramb.awc(i);
      if (p.j(paramh, this.Uag))
      {
        paramb = (Throwable)new IllegalArgumentException("Polymorphic serializer for " + paramb1 + " has property '" + paramh + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
        AppMethodBeat.o(225676);
        throw paramb;
      }
      i += 1;
    }
    AppMethodBeat.o(225676);
  }
  
  public final <T> void a(kotlin.l.b<T> paramb, h<T> paramh)
  {
    AppMethodBeat.i(225675);
    p.h(paramb, "kClass");
    p.h(paramh, "serializer");
    AppMethodBeat.o(225675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */