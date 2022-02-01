package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.a.e;
import kotlin.g.b.p;

public final class z
  extends w
  implements kotlin.l.b.a.b.d.a.e.z
{
  private final WildcardType TnA;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(57520);
    this.TnA = paramWildcardType;
    AppMethodBeat.o(57520);
  }
  
  public final boolean hDl()
  {
    AppMethodBeat.i(57519);
    Type[] arrayOfType = this.TnA.getUpperBounds();
    p.g(arrayOfType, "reflectType.upperBounds");
    boolean bool = p.j((Type)e.R(arrayOfType), Object.class);
    AppMethodBeat.o(57519);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.z
 * JD-Core Version:    0.7.0.1
 */