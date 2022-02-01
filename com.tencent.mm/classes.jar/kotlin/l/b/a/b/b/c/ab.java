package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;

public final class ab
  extends z
  implements ai
{
  private kotlin.l.b.a.b.m.ab Tmg;
  private final ai Tmh;
  
  public ab(ah paramah, g paramg, w paramw, ba paramba, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, ai paramai, an paraman)
  {
    super(paramw, paramba, paramah, paramg, f.bua("<get-" + paramah.hAH() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paraman);
    AppMethodBeat.i(57244);
    if (paramai != null) {}
    for (;;)
    {
      this.Tmh = paramai;
      AppMethodBeat.o(57244);
      return;
      paramai = this;
    }
  }
  
  private ai hCs()
  {
    AppMethodBeat.i(57249);
    ai localai = this.Tmh;
    if (localai == null) {
      atM(8);
    }
    AppMethodBeat.o(57249);
    return localai;
  }
  
  public final void J(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(57245);
    kotlin.l.b.a.b.m.ab localab = paramab;
    if (paramab == null) {
      localab = hBm().hBy();
    }
    this.Tmg = localab;
    AppMethodBeat.o(57245);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57248);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(57248);
    return paramn;
  }
  
  public final kotlin.l.b.a.b.m.ab hAu()
  {
    return this.Tmg;
  }
  
  public final List<av> hAw()
  {
    AppMethodBeat.i(57247);
    List localList = Collections.emptyList();
    if (localList == null) {
      atM(7);
    }
    AppMethodBeat.o(57247);
    return localList;
  }
  
  public final Collection<? extends ai> hAy()
  {
    AppMethodBeat.i(57246);
    Collection localCollection = super.EE(true);
    AppMethodBeat.o(57246);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.ab
 * JD-Core Version:    0.7.0.1
 */