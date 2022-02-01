package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.p;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class z
  extends w
  implements d.l.b.a.b.d.a.e.z
{
  private final WildcardType NxS;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(57520);
    this.NxS = paramWildcardType;
    AppMethodBeat.o(57520);
  }
  
  public final boolean gpJ()
  {
    AppMethodBeat.i(57519);
    Type[] arrayOfType = this.NxS.getUpperBounds();
    p.g(arrayOfType, "reflectType.upperBounds");
    boolean bool = p.i((Type)e.Q(arrayOfType), Object.class);
    AppMethodBeat.o(57519);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.z
 * JD-Core Version:    0.7.0.1
 */