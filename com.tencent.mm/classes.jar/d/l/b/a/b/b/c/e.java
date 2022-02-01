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
  private final j Nnf;
  private final d.l.b.a.b.l.f<aj> Num;
  private final bh Nuw;
  final boolean Nux;
  private final d.l.b.a.b.l.f<at> Nuy;
  private final int index;
  
  protected e(final j paramj, l paraml, d.l.b.a.b.b.a.g paramg, final d.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.Nuw = parambh;
    this.Nux = paramBoolean;
    this.index = paramInt;
    this.Nuy = paramj.S(new d.g.a.a() {});
    this.Num = paramj.S(new d.g.a.a() {});
    this.Nnf = paramj;
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
  
  public final List<ab> gkL()
  {
    List localList = ((a)glW()).gyu();
    if (localList == null) {
      ajW(8);
    }
    return localList;
  }
  
  public final at glW()
  {
    at localat = (at)this.Nuy.invoke();
    if (localat == null) {
      ajW(9);
    }
    return localat;
  }
  
  public final boolean gna()
  {
    return false;
  }
  
  public final as gnb()
  {
    as localas = (as)super.gor();
    if (localas == null) {
      ajW(11);
    }
    return localas;
  }
  
  public final aj gne()
  {
    aj localaj = (aj)this.Num.invoke();
    if (localaj == null) {
      ajW(10);
    }
    return localaj;
  }
  
  public final j gng()
  {
    j localj = this.Nnf;
    if (localj == null) {
      ajW(12);
    }
    return localj;
  }
  
  public final bh gnh()
  {
    bh localbh = this.Nuw;
    if (localbh == null) {
      ajW(7);
    }
    return localbh;
  }
  
  public final boolean gni()
  {
    return this.Nux;
  }
  
  protected abstract List<ab> gou();
  
  final class a
    extends d.l.b.a.b.m.h
  {
    private final aq NuE;
    
    public a(j paramj, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.NuE = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void I(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        ajW(6);
      }
      e.this.I(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        ajW(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final Collection<ab> gmp()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.gou();
      if (localList == null) {
        ajW(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final d.l.b.a.b.b.h gmq()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        ajW(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean gms()
    {
      return true;
    }
    
    public final aq gmt()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.NuE;
      if (localaq == null) {
        ajW(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final d.l.b.a.b.a.g gnF()
    {
      AppMethodBeat.i(57009);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        ajW(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final ab gov()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.bey("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.gnf().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */