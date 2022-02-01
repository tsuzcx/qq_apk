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
  private final Class<?> aaQn;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(57503);
    this.aaQn = paramClass;
    AppMethodBeat.o(57503);
  }
  
  public final h iHB()
  {
    AppMethodBeat.i(57502);
    if (p.h(this.aaQn, Void.TYPE))
    {
      AppMethodBeat.o(57502);
      return null;
    }
    Object localObject = d.bHm(this.aaQn.getName());
    p.j(localObject, "JvmPrimitiveType.get(reflectType.name)");
    localObject = ((d)localObject).iOZ();
    AppMethodBeat.o(57502);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */