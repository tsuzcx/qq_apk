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
  private final boolean NTq;
  private final at NYQ;
  private final at NZF;
  private final h NvQ;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.NZF = paramat1;
    this.NTq = paramBoolean;
    this.NYQ = paramat2;
    this.NvQ = paramh;
    AppMethodBeat.o(60825);
  }
  
  public final aj Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.NTq)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.NZF, paramBoolean, this.NYQ, this.NvQ);
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
  
  public final h gmN()
  {
    return this.NvQ;
  }
  
  public final g gmj()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.NsU;
    localObject = g.a.gon();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final boolean gqy()
  {
    return this.NTq;
  }
  
  public final at gxB()
  {
    return this.NYQ;
  }
  
  public final List<av> gxy()
  {
    return (List)v.NhH;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.NZF;
    AppMethodBeat.o(60822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */