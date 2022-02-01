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
  private final List<av> aaKw;
  private final h aaOs;
  private final boolean abkQ;
  private final b<kotlin.l.b.a.b.m.a.i, aj> abqS;
  private final at abql;
  
  public ak(at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super kotlin.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60791);
    this.abql = paramat;
    this.aaKw = paramList;
    this.abkQ = paramBoolean;
    this.aaOs = paramh;
    this.abqS = paramb;
    if ((this.aaOs instanceof u.b))
    {
      paramat = (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.aaOs + '\n' + this.abql);
      AppMethodBeat.o(60791);
      throw paramat;
    }
    AppMethodBeat.o(60791);
  }
  
  private aj i(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60788);
    p.k(parami, "kotlinTypeRefiner");
    parami = (aj)this.abqS.invoke(parami);
    if (parami == null) {
      parami = (aj)this;
    }
    for (;;)
    {
      AppMethodBeat.o(60788);
      return parami;
    }
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(60786);
    if (paramBoolean == this.abkQ)
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
    p.k(paramg, "newAnnotations");
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
  
  public final g iDY()
  {
    AppMethodBeat.i(60783);
    Object localObject = g.aaLw;
    localObject = g.a.iGe();
    AppMethodBeat.o(60783);
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
    return this.aaKw;
  }
  
  public final at iOU()
  {
    return this.abql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ak
 * JD-Core Version:    0.7.0.1
 */