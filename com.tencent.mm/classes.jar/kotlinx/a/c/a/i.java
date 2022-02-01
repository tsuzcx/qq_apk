package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.b;
import kotlinx.a.c.f;
import kotlinx.a.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/JsonTreeListInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "kotlinx-serialization-runtime"})
final class i
  extends a
{
  private final b abDE;
  private int currentIndex;
  private final int size;
  
  public i(kotlinx.a.c.a parama, b paramb)
  {
    super(parama, (f)paramb, (byte)0);
    AppMethodBeat.i(256282);
    this.abDE = paramb;
    this.size = this.abDE.abCD.size();
    this.currentIndex = -1;
    AppMethodBeat.o(256282);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(256281);
    p.k(paramn, "descriptor");
    if (this.currentIndex < this.size - 1)
    {
      this.currentIndex += 1;
      int i = this.currentIndex;
      AppMethodBeat.o(256281);
      return i;
    }
    AppMethodBeat.o(256281);
    return -1;
  }
  
  protected final f bHK(String paramString)
  {
    AppMethodBeat.i(256280);
    p.k(paramString, "tag");
    paramString = this.abDE.aFZ(Integer.parseInt(paramString));
    AppMethodBeat.o(256280);
    return paramString;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(256278);
    p.k(paramn, "desc");
    AppMethodBeat.o(256278);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */