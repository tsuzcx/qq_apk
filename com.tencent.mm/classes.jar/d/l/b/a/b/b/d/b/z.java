package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.k;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class z
  extends w
  implements d.l.b.a.b.d.a.e.z
{
  private final WildcardType LjQ;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(57520);
    this.LjQ = paramWildcardType;
    AppMethodBeat.o(57520);
  }
  
  public final boolean fTI()
  {
    AppMethodBeat.i(57519);
    Type[] arrayOfType = this.LjQ.getUpperBounds();
    k.g(arrayOfType, "reflectType.upperBounds");
    boolean bool = k.g((Type)e.Q(arrayOfType), Object.class);
    AppMethodBeat.o(57519);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.z
 * JD-Core Version:    0.7.0.1
 */