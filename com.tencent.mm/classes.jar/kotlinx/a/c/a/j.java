package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.a;
import kotlinx.a.c.f;
import kotlinx.a.c.o;
import kotlinx.a.c.s;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonTreeMapInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-runtime"})
final class j
  extends h
{
  private final s Uao;
  private final List<String> Uaq;
  private int position;
  private final int size;
  
  public j(a parama, s params)
  {
    super(parama, params);
    AppMethodBeat.i(225653);
    this.Uao = params;
    this.Uaq = kotlin.a.j.p((Iterable)this.Uao.keySet());
    this.size = (this.Uaq.size() * 2);
    this.position = -1;
    AppMethodBeat.o(225653);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(225652);
    p.h(paramn, "descriptor");
    AppMethodBeat.o(225652);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(225650);
    p.h(paramn, "descriptor");
    if (this.position < this.size - 1)
    {
      this.position += 1;
      int i = this.position;
      AppMethodBeat.o(225650);
      return i;
    }
    AppMethodBeat.o(225650);
    return -1;
  }
  
  protected final f buH(String paramString)
  {
    AppMethodBeat.i(225651);
    p.h(paramString, "tag");
    if (this.position % 2 == 0)
    {
      paramString = (f)new o(paramString);
      AppMethodBeat.o(225651);
      return paramString;
    }
    paramString = (f)ae.e((Map)this.Uao, paramString);
    AppMethodBeat.o(225651);
    return paramString;
  }
  
  public final s hPe()
  {
    return this.Uao;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(225649);
    p.h(paramn, "desc");
    paramInt /= 2;
    paramn = (String)this.Uaq.get(paramInt);
    AppMethodBeat.o(225649);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */