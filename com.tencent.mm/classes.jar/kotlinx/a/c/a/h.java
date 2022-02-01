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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "endStructure", "", "kotlinx-serialization-runtime"})
class h
  extends a
{
  private final s abDD;
  private int position;
  
  public h(kotlinx.a.c.a parama, s params)
  {
    super(parama, (f)params, (byte)0);
    AppMethodBeat.i(255828);
    this.abDD = params;
    AppMethodBeat.o(255828);
  }
  
  public void a(n paramn)
  {
    AppMethodBeat.i(255825);
    p.k(paramn, "descriptor");
    if ((this.abCv.abCH) || ((paramn.iTG() instanceof j)))
    {
      AppMethodBeat.o(255825);
      return;
    }
    Object localObject = bj.e(paramn);
    Iterator localIterator = iUl().keySet().iterator();
    while (localIterator.hasNext())
    {
      paramn = (String)localIterator.next();
      if (!((Set)localObject).contains(paramn))
      {
        localObject = iUl().toString();
        p.k(paramn, "key");
        p.k(localObject, "input");
        paramn = (Throwable)new e(-1, "JSON encountered unknown key: '" + paramn + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys.\n JSON input: " + kotlinx.a.c.l.iF((String)localObject, -1));
        AppMethodBeat.o(255825);
        throw paramn;
      }
    }
    AppMethodBeat.o(255825);
  }
  
  public int b(n paramn)
  {
    AppMethodBeat.i(255822);
    p.k(paramn, "descriptor");
    while (this.position < paramn.iTI())
    {
      int i = this.position;
      this.position = (i + 1);
      String str = k(paramn, i);
      s locals = iUl();
      p.k(str, "key");
      if (((locals instanceof s)) && (((s)locals).abDl.containsKey(str))) {}
      for (i = 1; i != 0; i = 0)
      {
        i = this.position;
        AppMethodBeat.o(255822);
        return i - 1;
      }
    }
    AppMethodBeat.o(255822);
    return -1;
  }
  
  protected f bHK(String paramString)
  {
    AppMethodBeat.i(255823);
    p.k(paramString, "tag");
    paramString = (f)ae.e((Map)iUl(), paramString);
    AppMethodBeat.o(255823);
    return paramString;
  }
  
  public s iUl()
  {
    return this.abDD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */