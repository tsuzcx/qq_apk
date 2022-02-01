package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.w;
import d.l.b.a.b.f.f;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class ab
  extends z
  implements ai
{
  private d.l.b.a.b.m.ab MZs;
  private final ai MZt;
  
  public ab(ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, ai paramai, an paraman)
  {
    super(paramw, paramba, paramah, paramg, f.bcG("<get-" + paramah.giD() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57244);
    if (paramai != null) {}
    for (;;)
    {
      this.MZt = paramai;
      AppMethodBeat.o(57244);
      return;
      paramai = this;
    }
  }
  
  private ai gko()
  {
    AppMethodBeat.i(57249);
    ai localai = this.MZt;
    if (localai == null) {
      ajm(8);
    }
    AppMethodBeat.o(57249);
    return localai;
  }
  
  public final void K(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(57245);
    d.l.b.a.b.m.ab localab = paramab;
    if (paramab == null) {
      localab = gji().gju();
    }
    this.MZs = localab;
    AppMethodBeat.o(57245);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57248);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57248);
    return paramn;
  }
  
  public final d.l.b.a.b.m.ab giq()
  {
    return this.MZs;
  }
  
  public final List<av> gis()
  {
    AppMethodBeat.i(57247);
    List localList = Collections.emptyList();
    if (localList == null) {
      ajm(7);
    }
    AppMethodBeat.o(57247);
    return localList;
  }
  
  public final Collection<? extends ai> giu()
  {
    AppMethodBeat.i(57246);
    Collection localCollection = super.Aa(true);
    AppMethodBeat.o(57246);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.ab
 * JD-Core Version:    0.7.0.1
 */