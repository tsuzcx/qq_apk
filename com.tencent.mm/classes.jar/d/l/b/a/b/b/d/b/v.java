package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.a.h;
import d.l.b.a.b.d.a.e.u;
import d.l.b.a.b.j.e.d;

public final class v
  extends w
  implements u
{
  private final Class<?> NxL;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(57503);
    this.NxL = paramClass;
    AppMethodBeat.o(57503);
  }
  
  public final h gpF()
  {
    AppMethodBeat.i(57502);
    if (p.i(this.NxL, Void.TYPE))
    {
      AppMethodBeat.o(57502);
      return null;
    }
    Object localObject = d.bev(this.NxL.getName());
    p.g(localObject, "JvmPrimitiveType.get(reflectType.name)");
    localObject = ((d)localObject).gxG();
    AppMethodBeat.o(57502);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */