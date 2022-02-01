package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.p;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.a.b.bj;
import kotlinx.a.c.d;
import kotlinx.a.c.e;
import kotlinx.a.c.f;
import kotlinx.a.c.s;
import kotlinx.a.j;
import kotlinx.a.n;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "endStructure", "", "kotlinx-serialization-runtime"})
class h
  extends a
{
  private final s NOl;
  private int position;
  
  public h(kotlinx.a.c.a parama, s params)
  {
    super(parama, (f)params, (byte)0);
    AppMethodBeat.i(191298);
    this.NOl = params;
    AppMethodBeat.o(191298);
  }
  
  public void a(n paramn)
  {
    AppMethodBeat.i(191296);
    p.h(paramn, "descriptor");
    if ((this.NNe.NNq) || ((paramn.gwR() instanceof j)))
    {
      AppMethodBeat.o(191296);
      return;
    }
    Object localObject = bj.e(paramn);
    Iterator localIterator = gxv().keySet().iterator();
    while (localIterator.hasNext())
    {
      paramn = (String)localIterator.next();
      if (!((Set)localObject).contains(paramn))
      {
        localObject = gxv().toString();
        p.h(paramn, "key");
        p.h(localObject, "input");
        paramn = (Throwable)new e(-1, "JSON encountered unknown key: '" + paramn + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys.\n JSON input: " + kotlinx.a.c.l.hr((String)localObject, -1));
        AppMethodBeat.o(191296);
        throw paramn;
      }
    }
    AppMethodBeat.o(191296);
  }
  
  public int b(n paramn)
  {
    AppMethodBeat.i(191294);
    p.h(paramn, "descriptor");
    while (this.position < paramn.gwT())
    {
      int i = this.position;
      this.position = (i + 1);
      String str = k(paramn, i);
      s locals = gxv();
      p.h(str, "key");
      if (((locals instanceof s)) && (((s)locals).NNU.containsKey(str))) {}
      for (i = 1; i != 0; i = 0)
      {
        i = this.position;
        AppMethodBeat.o(191294);
        return i - 1;
      }
    }
    AppMethodBeat.o(191294);
    return -1;
  }
  
  protected f bdo(String paramString)
  {
    AppMethodBeat.i(191295);
    p.h(paramString, "tag");
    paramString = (f)ae.e((Map)gxv(), paramString);
    AppMethodBeat.o(191295);
    return paramString;
  }
  
  public s gxv()
  {
    return this.NOl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */