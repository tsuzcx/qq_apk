package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.f;
import kotlinx.a.c.v;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
final class e
  extends a
{
  private final v Uak;
  
  public e(kotlinx.a.c.a parama, v paramv)
  {
    super(parama, (f)paramv, (byte)0);
    AppMethodBeat.i(225648);
    this.Uak = paramv;
    gz("primitive");
    AppMethodBeat.o(225648);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(225646);
    p.h(paramn, "descriptor");
    AppMethodBeat.o(225646);
    return 0;
  }
  
  protected final f buH(String paramString)
  {
    AppMethodBeat.i(225647);
    p.h(paramString, "tag");
    if (paramString == "primitive") {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
      AppMethodBeat.o(225647);
      throw paramString;
    }
    paramString = (f)this.Uak;
    AppMethodBeat.o(225647);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */