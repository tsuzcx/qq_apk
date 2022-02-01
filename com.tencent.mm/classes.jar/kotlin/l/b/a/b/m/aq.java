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
  private final h aaOs;
  private final boolean abkQ;
  private final at abqY;
  private final at abql;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.abqY = paramat1;
    this.abkQ = paramBoolean;
    this.abql = paramat2;
    this.aaOs = paramh;
    AppMethodBeat.o(60825);
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.abkQ)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.abqY, paramBoolean, this.abql, this.aaOs);
    AppMethodBeat.o(60820);
    return localaj;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60818);
    p.k(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60818);
    return paramg;
  }
  
  public final g iDY()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.aaLw;
    localObject = g.a.iGe();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final h iEC()
  {
    return this.aaOs;
  }
  
  public final boolean iIu()
  {
    return this.abkQ;
  }
  
  public final List<av> iOR()
  {
    return (List)v.aaAd;
  }
  
  public final at iOU()
  {
    return this.abql;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.abqY;
    AppMethodBeat.o(60822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */