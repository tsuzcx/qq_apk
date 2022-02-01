package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.a;

public final class z
  extends w
  implements kotlin.l.b.a.b.d.a.e.ab
{
  private final Collection<a> aiMX;
  private final boolean aiMY;
  private final WildcardType aiNt;
  
  public z(WildcardType paramWildcardType)
  {
    AppMethodBeat.i(57520);
    this.aiNt = paramWildcardType;
    this.aiMX = ((Collection)kotlin.a.ab.aivy);
    AppMethodBeat.o(57520);
  }
  
  public final boolean kqA()
  {
    return this.aiMY;
  }
  
  public final Collection<a> kqz()
  {
    return this.aiMX;
  }
  
  public final boolean krl()
  {
    AppMethodBeat.i(57519);
    Type[] arrayOfType = this.aiNt.getUpperBounds();
    s.s(arrayOfType, "reflectType.upperBounds");
    if (!s.p(k.Y((Object[])arrayOfType), Object.class))
    {
      AppMethodBeat.o(57519);
      return true;
    }
    AppMethodBeat.o(57519);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.z
 * JD-Core Version:    0.7.0.1
 */