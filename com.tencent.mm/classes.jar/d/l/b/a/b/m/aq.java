package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.c.j;
import java.util.List;

public final class aq
  extends aj
  implements j
{
  private final boolean JRT;
  private final at JXw;
  private final at JYk;
  private final h Juv;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.JYk = paramat1;
    this.JRT = paramBoolean;
    this.JXw = paramat2;
    this.Juv = paramh;
    AppMethodBeat.o(60825);
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60818);
    k.h(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60818);
    return paramg;
  }
  
  public final boolean fBT()
  {
    return this.JRT;
  }
  
  public final List<av> fIT()
  {
    return (List)v.Jgl;
  }
  
  public final at fIW()
  {
    return this.JXw;
  }
  
  public final g fxF()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.JrB;
    localObject = g.a.fzI();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final h fyj()
  {
    return this.Juv;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.JYk;
    AppMethodBeat.o(60822);
    return str;
  }
  
  public final aj xW(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.JRT)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.JYk, paramBoolean, this.JXw, this.Juv);
    AppMethodBeat.o(60820);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */