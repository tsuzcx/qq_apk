package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import java.util.List;

final class ak
  extends aj
{
  private final boolean NTq;
  private final at NYQ;
  private final b<d.l.b.a.b.m.a.i, aj> NZz;
  private final List<av> NrU;
  private final h NvQ;
  
  public ak(at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super d.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60791);
    this.NYQ = paramat;
    this.NrU = paramList;
    this.NTq = paramBoolean;
    this.NvQ = paramh;
    this.NZz = paramb;
    if ((this.NvQ instanceof u.b))
    {
      paramat = (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.NvQ + '\n' + this.NYQ);
      AppMethodBeat.o(60791);
      throw paramat;
    }
    AppMethodBeat.o(60791);
  }
  
  private aj i(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60788);
    p.h(parami, "kotlinTypeRefiner");
    parami = (aj)this.NZz.invoke(parami);
    if (parami == null) {
      parami = (aj)this;
    }
    for (;;)
    {
      AppMethodBeat.o(60788);
      return parami;
    }
  }
  
  public final aj Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(60786);
    if (paramBoolean == this.NTq)
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
  
  public final h gmN()
  {
    return this.NvQ;
  }
  
  public final g gmj()
  {
    AppMethodBeat.i(60783);
    Object localObject = g.NsU;
    localObject = g.a.gon();
    AppMethodBeat.o(60783);
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
    return this.NrU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ak
 * JD-Core Version:    0.7.0.1
 */