package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.c.k;

public final class aq
  extends aj
  implements k
{
  private final boolean TIm;
  private final at TNJ;
  private final at TOy;
  private final h Tly;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.TOy = paramat1;
    this.TIm = paramBoolean;
    this.TNJ = paramat2;
    this.Tly = paramh;
    AppMethodBeat.o(60825);
  }
  
  public final aj EG(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.TIm)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.TOy, paramBoolean, this.TNJ, this.Tly);
    AppMethodBeat.o(60820);
    return localaj;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60818);
    p.h(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60818);
    return paramg;
  }
  
  public final h hAp()
  {
    return this.Tly;
  }
  
  public final boolean hEa()
  {
    return this.TIm;
  }
  
  public final List<av> hKB()
  {
    return (List)v.SXr;
  }
  
  public final at hKE()
  {
    return this.TNJ;
  }
  
  public final g hzL()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.TiC;
    localObject = g.a.hBP();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.TOy;
    AppMethodBeat.o(60822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */