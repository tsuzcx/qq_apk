package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import java.util.List;

final class ak
  extends aj
{
  private final boolean JRT;
  private final at JXw;
  private final b<d.l.b.a.b.m.a.i, aj> JYe;
  private final List<av> JqB;
  private final h Juv;
  
  public ak(at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super d.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60791);
    this.JXw = paramat;
    this.JqB = paramList;
    this.JRT = paramBoolean;
    this.Juv = paramh;
    this.JYe = paramb;
    if ((this.Juv instanceof u.b))
    {
      paramat = (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.Juv + '\n' + this.JXw);
      AppMethodBeat.o(60791);
      throw paramat;
    }
    AppMethodBeat.o(60791);
  }
  
  private aj i(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60788);
    k.h(parami, "kotlinTypeRefiner");
    parami = (aj)this.JYe.aA(parami);
    if (parami == null) {
      parami = (aj)this;
    }
    for (;;)
    {
      AppMethodBeat.o(60788);
      return parami;
    }
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60784);
    k.h(paramg, "newAnnotations");
    if (paramg.isEmpty())
    {
      paramg = (aj)this;
      AppMethodBeat.o(60784);
      return paramg;
    }
    paramg = (aj)new i((aj)this, paramg);
    AppMethodBeat.o(60784);
    return paramg;
  }
  
  public final boolean fBT()
  {
    return this.JRT;
  }
  
  public final List<av> fIT()
  {
    return this.JqB;
  }
  
  public final at fIW()
  {
    return this.JXw;
  }
  
  public final g fxF()
  {
    AppMethodBeat.i(60783);
    Object localObject = g.JrB;
    localObject = g.a.fzI();
    AppMethodBeat.o(60783);
    return localObject;
  }
  
  public final h fyj()
  {
    return this.Juv;
  }
  
  public final aj xW(boolean paramBoolean)
  {
    AppMethodBeat.i(60786);
    if (paramBoolean == this.JRT)
    {
      localaj = (aj)this;
      AppMethodBeat.o(60786);
      return localaj;
    }
    if (paramBoolean)
    {
      localaj = (aj)new ah((aj)this);
      AppMethodBeat.o(60786);
      return localaj;
    }
    aj localaj = (aj)new af((aj)this);
    AppMethodBeat.o(60786);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ak
 * JD-Core Version:    0.7.0.1
 */