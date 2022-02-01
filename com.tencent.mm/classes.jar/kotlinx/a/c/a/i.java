package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.List;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/JsonTreeListInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "kotlinx-serialization-runtime"})
final class i
  extends a
{
  private final b Ols;
  private int currentIndex;
  private final int size;
  
  public i(kotlinx.a.c.a parama, b paramb)
  {
    super(parama, (f)paramb, (byte)0);
    AppMethodBeat.i(199945);
    this.Ols = paramb;
    this.size = this.Ols.Oks.size();
    this.currentIndex = -1;
    AppMethodBeat.o(199945);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(199944);
    p.h(paramn, "descriptor");
    if (this.currentIndex < this.size - 1)
    {
      this.currentIndex += 1;
      int i = this.currentIndex;
      AppMethodBeat.o(199944);
      return i;
    }
    AppMethodBeat.o(199944);
    return -1;
  }
  
  protected final f beS(String paramString)
  {
    AppMethodBeat.i(199943);
    p.h(paramString, "tag");
    paramString = this.Ols.amv(Integer.parseInt(paramString));
    AppMethodBeat.o(199943);
    return paramString;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(199942);
    p.h(paramn, "desc");
    AppMethodBeat.o(199942);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */