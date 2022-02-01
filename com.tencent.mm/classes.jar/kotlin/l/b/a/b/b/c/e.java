package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.v;

public abstract class e
  extends k
  implements ba
{
  private final m aiBu;
  private final bl aiJJ;
  private final boolean aiJK;
  private final kotlin.l.b.a.b.l.h<ax> aiJL;
  private final kotlin.l.b.a.b.l.h<al> aiJz;
  private final int index;
  
  protected e(final m paramm, l paraml, g paramg, final f paramf, bl parambl, boolean paramBoolean, int paramInt, av paramav, final ay paramay)
  {
    super(paraml, paramg, paramf, paramav);
    this.aiJJ = parambl;
    this.aiJK = paramBoolean;
    this.index = paramInt;
    this.aiJL = paramm.cq(new kotlin.g.a.a() {});
    this.aiJz = paramm.cq(new kotlin.g.a.a() {});
    this.aiBu = paramm;
  }
  
  protected abstract void A(ad paramad);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final List<ad> klF()
  {
    List localList = ((a)kmZ()).kAC();
    if (localList == null) {
      aKu(8);
    }
    return localList;
  }
  
  public final ax kmZ()
  {
    ax localax = (ax)this.aiJL.invoke();
    if (localax == null) {
      aKu(9);
    }
    return localax;
  }
  
  public final al koj()
  {
    al localal = (al)this.aiJz.invoke();
    if (localal == null) {
      aKu(10);
    }
    return localal;
  }
  
  public final m kol()
  {
    m localm = this.aiBu;
    if (localm == null) {
      aKu(14);
    }
    return localm;
  }
  
  public final bl kom()
  {
    bl localbl = this.aiJJ;
    if (localbl == null) {
      aKu(7);
    }
    return localbl;
  }
  
  public final boolean kon()
  {
    return this.aiJK;
  }
  
  public final boolean koo()
  {
    return false;
  }
  
  public final ba kop()
  {
    ba localba = (ba)super.kpF();
    if (localba == null) {
      aKu(11);
    }
    return localba;
  }
  
  protected abstract List<ad> kpH();
  
  protected List<ad> oU(List<ad> paramList)
  {
    if (paramList == null) {
      aKu(12);
    }
    if (paramList == null) {
      aKu(13);
    }
    return paramList;
  }
  
  final class a
    extends kotlin.l.b.a.b.m.h
  {
    private final ay aiJR;
    
    public a(m paramm, ay paramay)
    {
      super();
      AppMethodBeat.i(57005);
      this.aiJR = paramay;
      AppMethodBeat.o(57005);
    }
    
    public final void A(ad paramad)
    {
      AppMethodBeat.i(57012);
      if (paramad == null) {
        aKu(6);
      }
      e.this.A(paramad);
      AppMethodBeat.o(57012);
    }
    
    public final boolean a(kotlin.l.b.a.b.b.h paramh)
    {
      AppMethodBeat.i(191898);
      if (paramh == null) {
        aKu(9);
      }
      if ((paramh instanceof ba))
      {
        b localb = b.ajiF;
        e locale = e.this;
        paramh = (ba)paramh;
        s.u(locale, "a");
        s.u(paramh, "b");
        if (b.a(localb, locale, paramh, true))
        {
          AppMethodBeat.o(191898);
          return true;
        }
      }
      AppMethodBeat.o(191898);
      return false;
    }
    
    public final List<ba> klq()
    {
      AppMethodBeat.i(57007);
      List localList = Collections.emptyList();
      if (localList == null) {
        aKu(2);
      }
      AppMethodBeat.o(57007);
      return localList;
    }
    
    public final kotlin.l.b.a.b.b.h knA()
    {
      AppMethodBeat.i(57008);
      e locale = e.this;
      if (locale == null) {
        aKu(3);
      }
      AppMethodBeat.o(57008);
      return locale;
    }
    
    public final Collection<ad> knw()
    {
      AppMethodBeat.i(57006);
      List localList = e.this.kpH();
      if (localList == null) {
        aKu(1);
      }
      AppMethodBeat.o(57006);
      return localList;
    }
    
    public final boolean knx()
    {
      return true;
    }
    
    public final ay kny()
    {
      AppMethodBeat.i(57011);
      ay localay = this.aiJR;
      if (localay == null) {
        aKu(5);
      }
      AppMethodBeat.o(57011);
      return localay;
    }
    
    public final kotlin.l.b.a.b.a.h koV()
    {
      AppMethodBeat.i(57009);
      kotlin.l.b.a.b.a.h localh = kotlin.l.b.a.b.j.d.a.G(e.this);
      if (localh == null) {
        aKu(4);
      }
      AppMethodBeat.o(57009);
      return localh;
    }
    
    public final ad kpI()
    {
      AppMethodBeat.i(57013);
      al localal = v.bJt("Cyclic upper bounds");
      AppMethodBeat.o(57013);
      return localal;
    }
    
    public final List<ad> oV(List<ad> paramList)
    {
      AppMethodBeat.i(191894);
      if (paramList == null) {
        aKu(7);
      }
      paramList = e.this.oU(paramList);
      if (paramList == null) {
        aKu(8);
      }
      AppMethodBeat.o(191894);
      return paramList;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(57010);
      String str = e.this.kok().toString();
      AppMethodBeat.o(57010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */