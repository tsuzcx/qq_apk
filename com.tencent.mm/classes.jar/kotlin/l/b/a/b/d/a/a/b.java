package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.a.b.i;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.l;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.n;

public class b
  implements i
{
  final kotlin.l.b.a.b.f.b aaLC;
  private final an aaLe;
  private final kotlin.l.b.a.b.l.f aaSJ;
  final kotlin.l.b.a.b.d.a.e.b aaSK;
  private final boolean aaSL;
  
  static
  {
    AppMethodBeat.i(57654);
    cMt = new n[] { (n)ab.a(new z(ab.bO(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")) };
    AppMethodBeat.o(57654);
  }
  
  public b(final h paramh, kotlin.l.b.a.b.d.a.e.a parama, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(57657);
    this.aaLC = paramb;
    if (parama != null)
    {
      paramb = (an)paramh.aaUp.aaTS.a((l)parama);
      this.aaLe = paramb;
      this.aaSJ = paramh.aaUp.aaFH.av((kotlin.g.a.a)new a(this, paramh));
      if (parama == null) {
        break label132;
      }
    }
    label132:
    for (paramh = (kotlin.l.b.a.b.d.a.e.b)kotlin.a.j.f((Iterable)parama.iGU());; paramh = null)
    {
      this.aaSK = paramh;
      this.aaSL = false;
      AppMethodBeat.o(57657);
      return;
      paramb = an.aaKE;
      p.j(paramb, "SourceElement.NO_SOURCE");
      break;
    }
  }
  
  public final an iDZ()
  {
    return this.aaLe;
  }
  
  public final kotlin.l.b.a.b.f.b iFy()
  {
    return this.aaLC;
  }
  
  public Map<kotlin.l.b.a.b.f.f, g<?>> iGd()
  {
    AppMethodBeat.i(57656);
    Map localMap = ae.iBR();
    AppMethodBeat.o(57656);
    return localMap;
  }
  
  public final boolean iHY()
  {
    return this.aaSL;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<aj>
  {
    a(b paramb, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */