package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.l.i;
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
  private final d.l.b.a.b.l.f<aj> Lgk;
  private final bh Lgu;
  final boolean Lgv;
  private final d.l.b.a.b.l.f<at> Lgw;
  private final int index;
  
  protected e(final i parami, l paraml, d.l.b.a.b.b.a.g paramg, final d.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.Lgu = parambh;
    this.Lgv = paramBoolean;
    this.index = paramInt;
    this.Lgw = parami.O(new d.g.a.a() {});
    this.Lgk = parami.O(new d.g.a.a() {});
  }
  
  protected abstract void I(ab paramab);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final List<ab> fOJ()
  {
    List localList = ((a)fPW()).gcs();
    if (localList == null) {
      agL(8);
    }
    return localList;
  }
  
  public final at fPW()
  {
    at localat = (at)this.Lgw.invoke();
    if (localat == null) {
      agL(9);
    }
    return localat;
  }
  
  public final boolean fRa()
  {
    return false;
  }
  
  public final as fRb()
  {
    as localas = (as)super.fSr();
    if (localas == null) {
      agL(11);
    }
    return localas;
  }
  
  public final aj fRe()
  {
    aj localaj = (aj)this.Lgk.invoke();
    if (localaj == null) {
      agL(10);
    }
    return localaj;
  }
  
  public final bh fRg()
  {
    bh localbh = this.Lgu;
    if (localbh == null) {
      agL(7);
    }
    return localbh;
  }
  
  public final boolean fRh()
  {
    return this.Lgv;
  }
  
  protected abstract List<ab> fSu();
  
  public final int getIndex()
  {
    return this.index;
  }
  
  final class a
    extends d.l.b.a.b.m.h
  {
    private final aq LgC;
    
    public a(i parami, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.LgC = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void I(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        agL(6);
      }
      e.this.I(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final Collection<ab> fQp()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.fSu();
      if (localList == null) {
        agL(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final d.l.b.a.b.b.h fQq()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        agL(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean fQs()
    {
      return true;
    }
    
    public final aq fQt()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.LgC;
      if (localaq == null) {
        agL(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final d.l.b.a.b.a.g fRE()
    {
      AppMethodBeat.i(57009);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        agL(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final ab fSv()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.aWR("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        agL(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.fRf().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */