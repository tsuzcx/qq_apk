package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonTreeListInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "kotlinx-serialization-runtime"})
final class i
  extends a
{
  private final b Uap;
  private int currentIndex;
  private final int size;
  
  public i(kotlinx.a.c.a parama, b paramb)
  {
    super(parama, (f)paramb, (byte)0);
    AppMethodBeat.i(225717);
    this.Uap = paramb;
    this.size = this.Uap.TZn.size();
    this.currentIndex = -1;
    AppMethodBeat.o(225717);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(225716);
    p.h(paramn, "descriptor");
    if (this.currentIndex < this.size - 1)
    {
      this.currentIndex += 1;
      int i = this.currentIndex;
      AppMethodBeat.o(225716);
      return i;
    }
    AppMethodBeat.o(225716);
    return -1;
  }
  
  protected final f buH(String paramString)
  {
    AppMethodBeat.i(225715);
    p.h(paramString, "tag");
    paramString = this.Uap.awe(Integer.parseInt(paramString));
    AppMethodBeat.o(225715);
    return paramString;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(225714);
    p.h(paramn, "desc");
    AppMethodBeat.o(225714);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */