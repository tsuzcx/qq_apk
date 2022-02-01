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
  private final boolean LFm;
  private final at LKP;
  private final at LLD;
  private final h LhO;
  
  private aq(at paramat1, boolean paramBoolean, at paramat2, h paramh)
  {
    AppMethodBeat.i(60825);
    this.LLD = paramat1;
    this.LFm = paramBoolean;
    this.LKP = paramat2;
    this.LhO = paramh;
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
  
  public final h fQN()
  {
    return this.LhO;
  }
  
  public final g fQj()
  {
    AppMethodBeat.i(60817);
    Object localObject = g.LeU;
    localObject = g.a.fSm();
    AppMethodBeat.o(60817);
    return localObject;
  }
  
  public final boolean fUx()
  {
    return this.LFm;
  }
  
  public final List<av> gbw()
  {
    return (List)v.KTF;
  }
  
  public final at gbz()
  {
    return this.LKP;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60822);
    String str = "NonFixed: " + this.LLD;
    AppMethodBeat.o(60822);
    return str;
  }
  
  public final aj zo(boolean paramBoolean)
  {
    AppMethodBeat.i(60820);
    if (paramBoolean == this.LFm)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60820);
      return localaj;
    }
    aj localaj = (aj)new aq(this.LLD, paramBoolean, this.LKP, this.LhO);
    AppMethodBeat.o(60820);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aq
 * JD-Core Version:    0.7.0.1
 */