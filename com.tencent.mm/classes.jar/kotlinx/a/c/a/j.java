package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.p;
import d.l;
import java.util.List;
import java.util.Map;
import kotlinx.a.c.a;
import kotlinx.a.c.f;
import kotlinx.a.c.o;
import kotlinx.a.c.s;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/JsonTreeMapInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-runtime"})
final class j
  extends h
{
  private final s NOl;
  private final List<String> NOn;
  private int position;
  private final int size;
  
  public j(a parama, s params)
  {
    super(parama, params);
    AppMethodBeat.i(191293);
    this.NOl = params;
    this.NOn = d.a.j.l((Iterable)this.NOl.keySet());
    this.size = (this.NOn.size() * 2);
    this.position = -1;
    AppMethodBeat.o(191293);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(191292);
    p.h(paramn, "descriptor");
    AppMethodBeat.o(191292);
  }
  
  public final int b(n paramn)
  {
    AppMethodBeat.i(191290);
    p.h(paramn, "descriptor");
    if (this.position < this.size - 1)
    {
      this.position += 1;
      int i = this.position;
      AppMethodBeat.o(191290);
      return i;
    }
    AppMethodBeat.o(191290);
    return -1;
  }
  
  protected final f bdo(String paramString)
  {
    AppMethodBeat.i(191291);
    p.h(paramString, "tag");
    if (this.position % 2 == 0)
    {
      paramString = (f)new o(paramString);
      AppMethodBeat.o(191291);
      return paramString;
    }
    paramString = (f)ae.e((Map)this.NOl, paramString);
    AppMethodBeat.o(191291);
    return paramString;
  }
  
  public final s gxv()
  {
    return this.NOl;
  }
  
  public final String m(n paramn, int paramInt)
  {
    AppMethodBeat.i(191289);
    p.h(paramn, "desc");
    paramInt /= 2;
    paramn = (String)this.NOn.get(paramInt);
    AppMethodBeat.o(191289);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.j
 * JD-Core Version:    0.7.0.1
 */