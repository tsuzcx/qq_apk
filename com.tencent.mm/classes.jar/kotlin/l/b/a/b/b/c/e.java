package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;

public abstract class e
  extends k
  implements as
{
  private final j TcN;
  private final kotlin.l.b.a.b.l.f<aj> TjU;
  private final bh Tke;
  final boolean Tkf;
  private final kotlin.l.b.a.b.l.f<at> Tkg;
  private final int index;
  
  protected e(final j paramj, l paraml, kotlin.l.b.a.b.b.a.g paramg, final kotlin.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.Tke = parambh;
    this.Tkf = paramBoolean;
    this.index = paramInt;
    this.Tkg = paramj.al(new kotlin.g.a.a() {});
    this.TjU = paramj.al(new kotlin.g.a.a() {});
    this.TcN = paramj;
  }
  
  protected abstract void H(ab paramab);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final boolean hAC()
  {
    return false;
  }
  
  public final as hAD()
  {
    as localas = (as)super.hBT();
    if (localas == null) {
      atM(11);
    }
    return localas;
  }
  
  public final aj hAG()
  {
    aj localaj = (aj)this.TjU.invoke();
    if (localaj == null) {
      atM(10);
    }
    return localaj;
  }
  
  public final j hAI()
  {
    j localj = this.TcN;
    if (localj == null) {
      atM(12);
    }
    return localj;
  }
  
  public final bh hAJ()
  {
    bh localbh = this.Tke;
    if (localbh == null) {
      atM(7);
    }
    return localbh;
  }
  
  public final boolean hAK()
  {
    return this.Tkf;
  }
  
  protected abstract List<ab> hBW();
  
  public final List<ab> hyo()
  {
    List localList = ((a)hzz()).hLx();
    if (localList == null) {
      atM(8);
    }
    return localList;
  }
  
  public final at hzz()
  {
    at localat = (at)this.Tkg.invoke();
    if (localat == null) {
      atM(9);
    }
    return localat;
  }
  
  final class a
    extends kotlin.l.b.a.b.m.h
  {
    private final aq Tkm;
    
    public a(j paramj, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.Tkm = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void H(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        atM(6);
      }
      e.this.H(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        atM(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final ab hBX()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.bun("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final kotlin.l.b.a.b.a.g hBh()
    {
      AppMethodBeat.i(57009);
      kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        atM(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final Collection<ab> hzR()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.hBW();
      if (localList == null) {
        atM(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final kotlin.l.b.a.b.b.h hzS()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        atM(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean hzU()
    {
      return true;
    }
    
    public final aq hzV()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.Tkm;
      if (localaq == null) {
        atM(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.hAH().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */