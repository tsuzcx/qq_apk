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
  private final WildcardType aaQu;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(57520);
    this.aaQu = paramWildcardType;
    AppMethodBeat.o(57520);
  }
  
  public final boolean iHF()
  {
    AppMethodBeat.i(57519);
    Type[] arrayOfType = this.aaQu.getUpperBounds();
    p.j(arrayOfType, "reflectType.upperBounds");
    boolean bool = p.h((Type)e.U(arrayOfType), Object.class);
    AppMethodBeat.o(57519);
    return bool ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.z
 * JD-Core Version:    0.7.0.1
 */