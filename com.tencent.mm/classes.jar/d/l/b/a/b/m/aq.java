package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.c.k;
import java.util.List;

public final class aq
  extends aj
  implements k
{
  private final h MYK;
  private final at NBJ;
  private final at NCy;
  private final boolean Nwk;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.NCy = paramat1;
    this.Nwk = paramBoolean;
    this.NBJ = paramat2;
    this.MYK = paramh;
    AppMethodBeat.o(60825);
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.Nwk)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.NCy, paramBoolean, this.NBJ, this.MYK);
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
  
  public final g ghH()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.MVP;
    localObject = g.a.gjL();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final h gil()
  {
    return this.MYK;
  }
  
  public final boolean glW()
  {
    return this.Nwk;
  }
  
  public final List<av> gsW()
  {
    return (List)v.MKE;
  }
  
  public final at gsZ()
  {
    return this.NBJ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.NCy;
    AppMethodBeat.o(60822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */