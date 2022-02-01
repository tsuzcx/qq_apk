package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.e.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementName", "desc", "index", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
final class h
  extends a
{
  private final b ajEJ;
  private int currentIndex;
  private final int size;
  
  public h(kotlinx.a.e.a parama, b paramb)
  {
    super(parama, (kotlinx.a.e.e)paramb, (byte)0);
    AppMethodBeat.i(188523);
    this.ajEJ = paramb;
    this.size = this.ajEJ.size();
    this.currentIndex = -1;
    AppMethodBeat.o(188523);
  }
  
  protected final kotlinx.a.e.e bJQ(String paramString)
  {
    AppMethodBeat.i(188542);
    s.u(paramString, "tag");
    paramString = this.ajEJ.aMM(Integer.parseInt(paramString));
    AppMethodBeat.o(188542);
    return paramString;
  }
  
  public final int g(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188555);
    s.u(parame, "descriptor");
    if (this.currentIndex < this.size - 1)
    {
      this.currentIndex += 1;
      int i = this.currentIndex;
      AppMethodBeat.o(188555);
      return i;
    }
    AppMethodBeat.o(188555);
    return -1;
  }
  
  public final String g(kotlinx.a.b.e parame, int paramInt)
  {
    AppMethodBeat.i(188535);
    s.u(parame, "desc");
    AppMethodBeat.o(188535);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.h
 * JD-Core Version:    0.7.0.1
 */