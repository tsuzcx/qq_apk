package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.c.f;
import kotlinx.a.c.v;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
final class e
  extends a
{
  private final v Oln;
  
  public e(kotlinx.a.c.a parama, v paramv)
  {
    super(parama, (f)paramv, (byte)0);
    AppMethodBeat.i(199876);
    this.Oln = paramv;
    gu("primitive");
    AppMethodBeat.o(199876);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(199874);
    p.h(paramn, "descriptor");
    AppMethodBeat.o(199874);
    return 0;
  }
  
  protected final f beS(String paramString)
  {
    AppMethodBeat.i(199875);
    p.h(paramString, "tag");
    if (paramString == "primitive") {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
      AppMethodBeat.o(199875);
      throw paramString;
    }
    paramString = (f)this.Oln;
    AppMethodBeat.o(199875);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */