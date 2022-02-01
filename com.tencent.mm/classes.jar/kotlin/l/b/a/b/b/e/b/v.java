package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.u;
import kotlin.l.b.a.b.j.e.e;

public final class v
  extends w
  implements u
{
  private final Collection<a> aiMX;
  private final boolean aiMY;
  private final Class<?> aiNm;
  
  public v(Class<?> paramClass)
  {
    AppMethodBeat.i(57503);
    this.aiNm = paramClass;
    this.aiMX = ((Collection)ab.aivy);
    AppMethodBeat.o(57503);
  }
  
  public final boolean kqA()
  {
    return this.aiMY;
  }
  
  public final Collection<a> kqz()
  {
    return this.aiMX;
  }
  
  public final i krj()
  {
    AppMethodBeat.i(57502);
    if (s.p(this.aiNm, Void.TYPE))
    {
      AppMethodBeat.o(57502);
      return null;
    }
    i locali = e.bJq(this.aiNm.getName()).kzs();
    AppMethodBeat.o(57502);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.v
 * JD-Core Version:    0.7.0.1
 */