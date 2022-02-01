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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/JsonTreeMapInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-runtime"})
final class j
  extends h
{
  private final s abDD;
  private final List<String> keys;
  private int position;
  private final int size;
  
  public j(a parama, s params)
  {
    super(parama, params);
    AppMethodBeat.i(255805);
    this.abDD = params;
    this.keys = kotlin.a.j.p((Iterable)this.abDD.keySet());
    this.size = (this.keys.size() * 2);
    this.position = -1;
    AppMethodBeat.o(255805);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(255803);
    p.k(paramn, "descriptor");
    AppMethodBeat.o(255803);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(255800);
    p.k(paramn, "descriptor");
    if (this.position < this.size - 1)
    {
      this.position += 1;
      int i = this.position;
      AppMethodBeat.o(255800);
      return i;
    }
    AppMethodBeat.o(255800);
    return -1;
  }
  
  protected final f bHK(String paramString)
  {
    AppMethodBeat.i(255801);
    p.k(paramString, "tag");
    if (this.position % 2 == 0)
    {
      paramString = (f)new o(paramString);
      AppMethodBeat.o(255801);
      return paramString;
    }
    paramString = (f)ae.e((Map)this.abDD, paramString);
    AppMethodBeat.o(255801);
    return paramString;
  }
  
  public final s iUl()
  {
    return this.abDD;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(255799);
    p.k(paramn, "desc");
    paramInt /= 2;
    paramn = (String)this.keys.get(paramInt);
    AppMethodBeat.o(255799);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */