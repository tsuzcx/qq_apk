package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.u;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class e
  extends k
  implements as
{
  private final j MQa;
  private final d.l.b.a.b.l.f<aj> MXg;
  private final bh MXq;
  final boolean MXr;
  private final d.l.b.a.b.l.f<at> MXs;
  private final int index;
  
  protected e(final j paramj, l paraml, d.l.b.a.b.b.a.g paramg, final d.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.MXq = parambh;
    this.MXr = paramBoolean;
    this.index = paramInt;
    this.MXs = paramj.S(new d.g.a.a() {});
    this.MXg = paramj.S(new d.g.a.a() {});
    this.MQa = paramj;
  }
  
  protected abstract void I(ab paramab);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final List<ab> ggj()
  {
    List localList = ((a)ghu()).gtS();
    if (localList == null) {
      ajm(8);
    }
    return localList;
  }
  
  public final at ghu()
  {
    at localat = (at)this.MXs.invoke();
    if (localat == null) {
      ajm(9);
    }
    return localat;
  }
  
  public final aj giC()
  {
    aj localaj = (aj)this.MXg.invoke();
    if (localaj == null) {
      ajm(10);
    }
    return localaj;
  }
  
  public final j giE()
  {
    j localj = this.MQa;
    if (localj == null) {
      ajm(12);
    }
    return localj;
  }
  
  public final bh giF()
  {
    bh localbh = this.MXq;
    if (localbh == null) {
      ajm(7);
    }
    return localbh;
  }
  
  public final boolean giG()
  {
    return this.MXr;
  }
  
  public final boolean giy()
  {
    return false;
  }
  
  public final as giz()
  {
    as localas = (as)super.gjP();
    if (localas == null) {
      ajm(11);
    }
    return localas;
  }
  
  protected abstract List<ab> gjS();
  
  final class a
    extends d.l.b.a.b.m.h
  {
    private final aq MXy;
    
    public a(j paramj, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.MXy = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void I(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        ajm(6);
      }
      e.this.I(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        ajm(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final Collection<ab> ghN()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.gjS();
      if (localList == null) {
        ajm(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final d.l.b.a.b.b.h ghO()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        ajm(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean ghQ()
    {
      return true;
    }
    
    public final aq ghR()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.MXy;
      if (localaq == null) {
        ajm(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final ab gjT()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.bcU("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final d.l.b.a.b.a.g gjd()
    {
      AppMethodBeat.i(57009);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        ajm(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.giD().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */