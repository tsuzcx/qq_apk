package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlinx.a.e.a;
import kotlinx.a.e.k;
import kotlinx.a.e.l;
import kotlinx.a.e.m;
import kotlinx.a.e.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonTreeMapDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
final class i
  extends g
{
  private final m ajEG;
  private final List<String> keys;
  private int position;
  private final int size;
  
  public i(a parama, m paramm)
  {
    super(parama, paramm);
    AppMethodBeat.i(188519);
    this.ajEG = paramm;
    this.keys = p.p((Iterable)this.ajEG.keySet());
    this.size = (this.keys.size() * 2);
    this.position = -1;
    AppMethodBeat.o(188519);
  }
  
  public final void b(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188568);
    s.u(parame, "descriptor");
    AppMethodBeat.o(188568);
  }
  
  protected final kotlinx.a.e.e bJQ(String paramString)
  {
    AppMethodBeat.i(188556);
    s.u(paramString, "tag");
    if (this.position % 2 == 0)
    {
      if (paramString == null) {}
      for (paramString = (n)l.ajEh;; paramString = (n)new k(paramString, true))
      {
        paramString = (kotlinx.a.e.e)paramString;
        AppMethodBeat.o(188556);
        return paramString;
      }
    }
    paramString = (kotlinx.a.e.e)ak.e((Map)this.ajEG, paramString);
    AppMethodBeat.o(188556);
    return paramString;
  }
  
  public final int g(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188541);
    s.u(parame, "descriptor");
    if (this.position < this.size - 1)
    {
      this.position += 1;
      int i = this.position;
      AppMethodBeat.o(188541);
      return i;
    }
    AppMethodBeat.o(188541);
    return -1;
  }
  
  public final String g(kotlinx.a.b.e parame, int paramInt)
  {
    AppMethodBeat.i(188528);
    s.u(parame, "desc");
    paramInt /= 2;
    parame = (String)this.keys.get(paramInt);
    AppMethodBeat.o(188528);
    return parame;
  }
  
  public final m kFM()
  {
    return this.ajEG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.i
 * JD-Core Version:    0.7.0.1
 */