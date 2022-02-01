package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.d.a.e.u;
import kotlin.l.b.a.b.j.e.d;

public final class v
  extends w
  implements u
{
  private final Class<?> Tnt;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(57503);
    this.Tnt = paramClass;
    AppMethodBeat.o(57503);
  }
  
  public final h hDh()
  {
    AppMethodBeat.i(57502);
    if (p.j(this.Tnt, Void.TYPE))
    {
      AppMethodBeat.o(57502);
      return null;
    }
    Object localObject = d.buk(this.Tnt.getName());
    p.g(localObject, "JvmPrimitiveType.get(reflectType.name)");
    localObject = ((d)localObject).hKJ();
    AppMethodBeat.o(57502);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */