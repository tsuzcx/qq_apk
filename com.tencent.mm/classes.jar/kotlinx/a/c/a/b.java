package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.d.d;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/ContextValidator;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "discriminator", "", "(Ljava/lang/String;)V", "contextual", "", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "kotlinx-serialization-runtime"})
public final class b
  implements d
{
  private final String Olj;
  
  public b(String paramString)
  {
    AppMethodBeat.i(199905);
    this.Olj = paramString;
    AppMethodBeat.o(199905);
  }
  
  public final <Base, Sub extends Base> void a(d.l.b<Base> paramb, d.l.b<Sub> paramb1, h<Sub> paramh)
  {
    AppMethodBeat.i(199904);
    p.h(paramb, "baseClass");
    p.h(paramb1, "actualClass");
    p.h(paramh, "actualSerializer");
    paramb = paramh.eOR();
    int i = 0;
    int j = paramb.gBv();
    while (i < j)
    {
      paramh = paramb.amt(i);
      if (p.i(paramh, this.Olj))
      {
        paramb = (Throwable)new IllegalArgumentException("Polymorphic serializer for " + paramb1 + " has property '" + paramh + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
        AppMethodBeat.o(199904);
        throw paramb;
      }
      i += 1;
    }
    AppMethodBeat.o(199904);
  }
  
  public final <T> void a(d.l.b<T> paramb, h<T> paramh)
  {
    AppMethodBeat.i(199903);
    p.h(paramb, "kClass");
    p.h(paramh, "serializer");
    AppMethodBeat.o(199903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */