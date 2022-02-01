package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.f.h;

final class ak
  extends aj
{
  private final boolean TIm;
  private final at TNJ;
  private final b<kotlin.l.b.a.b.m.a.i, aj> TOs;
  private final List<av> ThC;
  private final h Tly;
  
  public ak(at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super kotlin.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60791);
    this.TNJ = paramat;
    this.ThC = paramList;
    this.TIm = paramBoolean;
    this.Tly = paramh;
    this.TOs = paramb;
    if ((this.Tly instanceof u.b))
    {
      paramat = (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.Tly + '\n' + this.TNJ);
      AppMethodBeat.o(60791);
      throw paramat;
    }
    AppMethodBeat.o(60791);
  }
  
  private aj i(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60788);
    p.h(parami, "kotlinTypeRefiner");
    parami = (aj)this.TOs.invoke(parami);
    if (parami == null) {
      parami = (aj)this;
    }
    for (;;)
    {
      AppMethodBeat.o(60788);
      return parami;
    }
  }
  
  public final aj EG(boolean paramBoolean)
  {
    AppMethodBeat.i(60786);
    if (paramBoolean == this.TIm)
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
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60784);
    p.h(paramg, "newAnnotations");
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
    return this.ThC;
  }
  
  public final at hKE()
  {
    return this.TNJ;
  }
  
  public final g hzL()
  {
    AppMethodBeat.i(60783);
    Object localObject = g.TiC;
    localObject = g.a.hBP();
    AppMethodBeat.o(60783);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ak
 * JD-Core Version:    0.7.0.1
 */