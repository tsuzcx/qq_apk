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
  private final d.l.b.a.b.l.f<aj> JsR;
  private final bh Jtb;
  final boolean Jtc;
  private final d.l.b.a.b.l.f<at> Jtd;
  private final int index;
  
  protected e(final i parami, l paraml, d.l.b.a.b.b.a.g paramg, final d.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.Jtb = parambh;
    this.Jtc = paramBoolean;
    this.index = paramInt;
    this.Jtd = parami.H(new d.g.a.a() {});
    this.JsR = parami.H(new d.g.a.a() {});
  }
  
  protected abstract void I(ab paramab);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final List<ab> fwf()
  {
    List localList = ((a)fxs()).fJP();
    if (localList == null) {
      adP(8);
    }
    return localList;
  }
  
  public final at fxs()
  {
    at localat = (at)this.Jtd.invoke();
    if (localat == null) {
      adP(9);
    }
    return localat;
  }
  
  public final aj fyA()
  {
    aj localaj = (aj)this.JsR.invoke();
    if (localaj == null) {
      adP(10);
    }
    return localaj;
  }
  
  public final bh fyC()
  {
    bh localbh = this.Jtb;
    if (localbh == null) {
      adP(7);
    }
    return localbh;
  }
  
  public final boolean fyD()
  {
    return this.Jtc;
  }
  
  public final boolean fyw()
  {
    return false;
  }
  
  public final as fyx()
  {
    as localas = (as)super.fzN();
    if (localas == null) {
      adP(11);
    }
    return localas;
  }
  
  protected abstract List<ab> fzQ();
  
  public final int getIndex()
  {
    return this.index;
  }
  
  final class a
    extends d.l.b.a.b.m.h
  {
    private final aq Jtj;
    
    public a(i parami, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.Jtj = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void I(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        adP(6);
      }
      e.this.I(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final Collection<ab> fxL()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.fzQ();
      if (localList == null) {
        adP(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final d.l.b.a.b.b.h fxM()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        adP(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean fxO()
    {
      return true;
    }
    
    public final aq fxP()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.Jtj;
      if (localaq == null) {
        adP(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final ab fzR()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.aQS("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final d.l.b.a.b.a.g fza()
    {
      AppMethodBeat.i(57009);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        adP(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        adP(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.fyB().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */