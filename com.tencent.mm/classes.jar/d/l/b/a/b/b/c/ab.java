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
  private d.l.b.a.b.m.ab Nwy;
  private final ai Nwz;
  
  public ab(ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, ai paramai, an paraman)
  {
    super(paramw, paramba, paramah, paramg, f.bek("<get-" + paramah.gnf() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57244);
    if (paramai != null) {}
    for (;;)
    {
      this.Nwz = paramai;
      AppMethodBeat.o(57244);
      return;
      paramai = this;
    }
  }
  
  private ai goQ()
  {
    AppMethodBeat.i(57249);
    ai localai = this.Nwz;
    if (localai == null) {
      ajW(8);
    }
    AppMethodBeat.o(57249);
    return localai;
  }
  
  public final void K(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(57245);
    d.l.b.a.b.m.ab localab = paramab;
    if (paramab == null) {
      localab = gnK().gnW();
    }
    this.Nwy = localab;
    AppMethodBeat.o(57245);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57248);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57248);
    return paramn;
  }
  
  public final d.l.b.a.b.m.ab gmS()
  {
    return this.Nwy;
  }
  
  public final List<av> gmU()
  {
    AppMethodBeat.i(57247);
    List localList = Collections.emptyList();
    if (localList == null) {
      ajW(7);
    }
    AppMethodBeat.o(57247);
    return localList;
  }
  
  public final Collection<? extends ai> gmW()
  {
    AppMethodBeat.i(57246);
    Collection localCollection = super.An(true);
    AppMethodBeat.o(57246);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.ab
 * JD-Core Version:    0.7.0.1
 */