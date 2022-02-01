package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.h;
import d.l.b.a.b.d.a.e.u;
import d.l.b.a.b.j.e.d;

public final class v
  extends w
  implements u
{
  private final Class<?> LjJ;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(57503);
    this.LjJ = paramClass;
    AppMethodBeat.o(57503);
  }
  
  public final h fTE()
  {
    AppMethodBeat.i(57502);
    if (k.g(this.LjJ, Void.TYPE))
    {
      AppMethodBeat.o(57502);
      return null;
    }
    Object localObject = d.aWO(this.LjJ.getName());
    k.g(localObject, "JvmPrimitiveType.get(reflectType.name)");
    localObject = ((d)localObject).gbF();
    AppMethodBeat.o(57502);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.v
 * JD-Core Version:    0.7.0.1
 */