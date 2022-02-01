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
  private final j aaFH;
  private final kotlin.l.b.a.b.l.f<aj> aaMO;
  private final bh aaMY;
  private final boolean aaMZ;
  private final kotlin.l.b.a.b.l.f<at> aaNa;
  private final int index;
  
  protected e(final j paramj, l paraml, kotlin.l.b.a.b.b.a.g paramg, final kotlin.l.b.a.b.f.f paramf, bh parambh, boolean paramBoolean, int paramInt, an paraman, final aq paramaq)
  {
    super(paraml, paramg, paramf, paraman);
    this.aaMY = parambh;
    this.aaMZ = paramBoolean;
    this.index = paramInt;
    this.aaNa = paramj.av(new kotlin.g.a.a() {});
    this.aaMO = paramj.av(new kotlin.g.a.a() {});
    this.aaFH = paramj;
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
  
  public final List<ab> iCz()
  {
    List localList = ((a)iDL()).iPQ();
    if (localList == null) {
      aDG(8);
    }
    return localList;
  }
  
  public final at iDL()
  {
    at localat = (at)this.aaNa.invoke();
    if (localat == null) {
      aDG(9);
    }
    return localat;
  }
  
  public final boolean iEP()
  {
    return false;
  }
  
  public final as iEQ()
  {
    as localas = (as)super.iGi();
    if (localas == null) {
      aDG(11);
    }
    return localas;
  }
  
  public final aj iET()
  {
    aj localaj = (aj)this.aaMO.invoke();
    if (localaj == null) {
      aDG(10);
    }
    return localaj;
  }
  
  public final j iEV()
  {
    j localj = this.aaFH;
    if (localj == null) {
      aDG(12);
    }
    return localj;
  }
  
  public final bh iEW()
  {
    bh localbh = this.aaMY;
    if (localbh == null) {
      aDG(7);
    }
    return localbh;
  }
  
  public final boolean iEX()
  {
    return this.aaMZ;
  }
  
  protected abstract List<ab> iGl();
  
  final class a
    extends kotlin.l.b.a.b.m.h
  {
    private final aq aaNg;
    
    public a(j paramj, aq paramaq)
    {
      super();
      AppMethodBeat.i(57005);
      this.aaNg = paramaq;
      AppMethodBeat.o(57005);
    }
    
    public final void H(ab paramab)
    {
      AppMethodBeat.i(57012);
      if (paramab == null) {
        aDG(6);
      }
      e.this.H(paramab);
      AppMethodBeat.o(57012);
    }
    
    public final List<as> iCb()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        aDG(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final Collection<ab> iEe()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.iGl();
      if (localList == null) {
        aDG(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final kotlin.l.b.a.b.b.h iEf()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        aDG(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final boolean iEh()
    {
      return true;
    }
    
    public final aq iEi()
    {
      AppMethodBeat.i(57011);
      aq localaq = this.aaNg;
      if (localaq == null) {
        aDG(5);
      }
      AppMethodBeat.o(57011);
      return localaq;
    }
    
    public final kotlin.l.b.a.b.a.g iFv()
    {
      AppMethodBeat.i(57009);
      kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.j.d.a.G(e.this);
      if (localg == null) {
        aDG(4);
      }
      AppMethodBeat.o(57009);
      return localg;
    }
    
    public final ab iGm()
    {
      AppMethodBeat.i(57013);
      aj localaj = u.bHp("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localaj;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.iEU().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */