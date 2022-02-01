package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlinx.a.b.bj;
import kotlinx.a.c.d;
import kotlinx.a.c.e;
import kotlinx.a.c.f;
import kotlinx.a.c.s;
import kotlinx.a.j;
import kotlinx.a.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "endStructure", "", "kotlinx-serialization-runtime"})
class h
  extends a
{
  private final s Uao;
  private int position;
  
  public h(kotlinx.a.c.a parama, s params)
  {
    super(parama, (f)params, (byte)0);
    AppMethodBeat.i(225658);
    this.Uao = params;
    AppMethodBeat.o(225658);
  }
  
  public void a(n paramn)
  {
    AppMethodBeat.i(225656);
    p.h(paramn, "descriptor");
    if ((this.TZf.TZr) || ((paramn.hOA() instanceof j)))
    {
      AppMethodBeat.o(225656);
      return;
    }
    Object localObject = bj.e(paramn);
    Iterator localIterator = hPe().keySet().iterator();
    while (localIterator.hasNext())
    {
      paramn = (String)localIterator.next();
      if (!((Set)localObject).contains(paramn))
      {
        localObject = hPe().toString();
        p.h(paramn, "key");
        p.h(localObject, "input");
        paramn = (Throwable)new e(-1, "JSON encountered unknown key: '" + paramn + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys.\n JSON input: " + kotlinx.a.c.l.hW((String)localObject, -1));
        AppMethodBeat.o(225656);
        throw paramn;
      }
    }
    AppMethodBeat.o(225656);
  }
  
  public int b(n paramn)
  {
    AppMethodBeat.i(225654);
    p.h(paramn, "descriptor");
    while (this.position < paramn.hOC())
    {
      int i = this.position;
      this.position = (i + 1);
      String str = k(paramn, i);
      s locals = hPe();
      p.h(str, "key");
      if (((locals instanceof s)) && (((s)locals).TZX.containsKey(str))) {}
      for (i = 1; i != 0; i = 0)
      {
        i = this.position;
        AppMethodBeat.o(225654);
        return i - 1;
      }
    }
    AppMethodBeat.o(225654);
    return -1;
  }
  
  protected f buH(String paramString)
  {
    AppMethodBeat.i(225655);
    p.h(paramString, "tag");
    paramString = (f)ae.e((Map)hPe(), paramString);
    AppMethodBeat.o(225655);
    return paramString;
  }
  
  public s hPe()
  {
    return this.Uao;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */