package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.c.aa;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.b.y.a;
import d.l.b.a.b.m.a.i;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class u
{
  private static final y NYS;
  private static final a NYT;
  public static final aj NYU;
  private static final ab NYV;
  private static final ah NYW;
  private static final Set<ah> NYX;
  
  static
  {
    AppMethodBeat.i(60726);
    NYS = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          ajW(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          ajW(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramAnonymousb, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          ajW(2);
        }
        if (paramAnonymousb1 == null) {
          ajW(3);
        }
        paramAnonymousb = (List)v.NhH;
        if (paramAnonymousb == null) {
          ajW(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          ajW(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(d.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          ajW(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final l glU()
      {
        return null;
      }
      
      public final d.l.b.a.b.b.a.g gmj()
      {
        AppMethodBeat.i(60667);
        Object localObject = d.l.b.a.b.b.a.g.NsU;
        localObject = g.a.gon();
        if (localObject == null) {
          ajW(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final d.l.b.a.b.a.g gnF()
      {
        AppMethodBeat.i(60675);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.gly();
        if (locald == null) {
          ajW(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> gnG()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.NhH;
        if (localList == null) {
          ajW(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
      
      public final l gnc()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          ajW(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final d.l.b.a.b.f.f gnf()
      {
        AppMethodBeat.i(60669);
        d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bek("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
    };
    NYT = new a(d.l.b.a.b.f.f.bek("<ERROR CLASS>"));
    NYU = bey("<LOOP IN SUPERTYPES>");
    NYV = bey("<ERROR PROPERTY TYPE>");
    Object localObject = NYT;
    g.a locala = d.l.b.a.b.b.a.g.NsU;
    localObject = aa.a((l)localObject, g.a.gon(), w.NrI, az.Nsm, d.l.b.a.b.f.f.bek("<ERROR PROPERTY>"), b.a.Nro, an.Nsc);
    ((aa)localObject).a(NYV, Collections.emptyList(), null, null);
    NYW = (ah)localObject;
    NYX = Collections.singleton(localObject);
    AppMethodBeat.o(60726);
  }
  
  public static aj L(String paramString, List<av> paramList)
  {
    AppMethodBeat.i(60718);
    if (paramString == null) {
      ajW(11);
    }
    if (paramList == null) {
      ajW(12);
    }
    paramString = new t(beA(paramString), bex(paramString), paramList);
    AppMethodBeat.o(60718);
    return paramString;
  }
  
  public static boolean L(l paraml)
  {
    AppMethodBeat.i(60721);
    if (paraml == null)
    {
      AppMethodBeat.o(60721);
      return false;
    }
    if (((paraml instanceof a)) || ((paraml.glU() instanceof a)) || (paraml == NYS))
    {
      AppMethodBeat.o(60721);
      return true;
    }
    AppMethodBeat.o(60721);
    return false;
  }
  
  public static aj a(String paramString, at paramat)
  {
    AppMethodBeat.i(60717);
    if (paramString == null) {
      ajW(9);
    }
    if (paramat == null) {
      ajW(10);
    }
    paramString = new t(paramat, bex(paramString));
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      ajW(17);
    }
    if (parama == null) {
      ajW(18);
    }
    paramString = new at()
    {
      public final List<as> getParameters()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.NhH;
        if (localList == null) {
          ajW(0);
        }
        AppMethodBeat.o(60677);
        return localList;
      }
      
      public final d.l.b.a.b.b.h gmq()
      {
        return this.NYY;
      }
      
      public final boolean gms()
      {
        return false;
      }
      
      public final d.l.b.a.b.a.g gnF()
      {
        AppMethodBeat.i(60679);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.gly();
        if (locald == null) {
          ajW(2);
        }
        AppMethodBeat.o(60679);
        return locald;
      }
      
      public final Collection<ab> got()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.NhH;
        if (localList == null) {
          ajW(1);
        }
        AppMethodBeat.o(60678);
        return localList;
      }
      
      public final String toString()
      {
        return paramString;
      }
    };
    AppMethodBeat.o(60720);
    return paramString;
  }
  
  public static boolean al(ab paramab)
  {
    AppMethodBeat.i(60723);
    if ((paramab != null) && ((paramab.gxB() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static at beA(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      ajW(15);
    }
    paramString = a("[ERROR : " + paramString + "]", NYT);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static e bew(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      ajW(1);
    }
    paramString = new a(d.l.b.a.b.f.f.bek("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h bex(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      ajW(2);
    }
    paramString = dy(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj bey(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      ajW(7);
    }
    paramString = L(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj bez(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, NYT));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h dy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      ajW(3);
    }
    if (paramBoolean)
    {
      paramString = new c(paramString, (byte)0);
      AppMethodBeat.o(60714);
      return paramString;
    }
    paramString = new b(paramString, (byte)0);
    AppMethodBeat.o(60714);
    return paramString;
  }
  
  public static y gyx()
  {
    AppMethodBeat.i(60722);
    y localy = NYS;
    if (localy == null) {
      ajW(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends d.l.b.a.b.b.c.h
  {
    public a(d.l.b.a.b.f.f paramf)
    {
      super(paramf, w.NrI, d.l.b.a.b.b.f.Nrw, Collections.emptyList(), an.Nsc, d.l.b.a.b.l.b.NXU);
      AppMethodBeat.i(60681);
      paramf = d.l.b.a.b.b.a.g.NsU;
      paramf = d.l.b.a.b.b.c.f.a(this, g.a.gon(), an.Nsc);
      paramf.a(Collections.emptyList(), az.Nsl);
      d.l.b.a.b.j.f.h localh = u.bex(gnf().sD());
      paramf.J(new t(u.b("<ERROR>", this), localh));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final d.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        ajW(6);
      }
      if (parami == null) {
        ajW(7);
      }
      paramay = u.bex("Error scope for class " + gnf() + " with arguments: " + paramay);
      if (paramay == null) {
        ajW(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        ajW(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = gnf().sD();
      AppMethodBeat.o(60683);
      return str;
    }
  }
  
  public static final class b
    implements d.l.b.a.b.j.f.h
  {
    private final String debugMessage;
    
    private b(String paramString)
    {
      AppMethodBeat.i(60687);
      this.debugMessage = paramString;
      AppMethodBeat.o(60687);
    }
    
    public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60691);
      if (paramd == null) {
        ajW(16);
      }
      if (paramb == null) {
        ajW(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        ajW(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        ajW(1);
      }
      if (parama == null) {
        ajW(2);
      }
      paramf = u.bew(paramf.sD());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> goy()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        ajW(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<d.l.b.a.b.f.f> goz()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        ajW(12);
      }
      AppMethodBeat.o(60690);
      return localSet;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60692);
      String str = "ErrorScope{" + this.debugMessage + '}';
      AppMethodBeat.o(60692);
      return str;
    }
  }
  
  static final class c
    implements d.l.b.a.b.j.f.h
  {
    private final String debugMessage;
    
    private c(String paramString)
    {
      AppMethodBeat.i(60696);
      this.debugMessage = paramString;
      AppMethodBeat.o(60696);
    }
    
    public final Collection<? extends ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60698);
      if (paramf == null) {
        ajW(5);
      }
      if (parama == null) {
        ajW(6);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60698);
      throw paramf;
    }
    
    public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60700);
      if (paramd == null) {
        ajW(9);
      }
      if (paramb == null) {
        ajW(10);
      }
      paramd = new IllegalStateException(this.debugMessage);
      AppMethodBeat.o(60700);
      throw paramd;
    }
    
    public final Collection<? extends am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60699);
      if (paramf == null) {
        ajW(7);
      }
      if (parama == null) {
        ajW(8);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60699);
      throw paramf;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60697);
      if (paramf == null) {
        ajW(1);
      }
      if (parama == null) {
        ajW(2);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60697);
      throw paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> goy()
    {
      AppMethodBeat.i(60701);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60701);
      throw localIllegalStateException;
    }
    
    public final Set<d.l.b.a.b.f.f> goz()
    {
      AppMethodBeat.i(60702);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60702);
      throw localIllegalStateException;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60703);
      String str = "ThrowingScope{" + this.debugMessage + '}';
      AppMethodBeat.o(60703);
      return str;
    }
  }
  
  public static final class d
    implements at
  {
    private final as NZa;
    private final at NZb;
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(60706);
      List localList = this.NZb.getParameters();
      if (localList == null) {
        ajW(2);
      }
      AppMethodBeat.o(60706);
      return localList;
    }
    
    public final d.l.b.a.b.b.h gmq()
    {
      AppMethodBeat.i(60709);
      d.l.b.a.b.b.h localh = this.NZb.gmq();
      AppMethodBeat.o(60709);
      return localh;
    }
    
    public final boolean gms()
    {
      AppMethodBeat.i(60708);
      boolean bool = this.NZb.gms();
      AppMethodBeat.o(60708);
      return bool;
    }
    
    public final d.l.b.a.b.a.g gnF()
    {
      AppMethodBeat.i(60710);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(this.NZa);
      if (localg == null) {
        ajW(4);
      }
      AppMethodBeat.o(60710);
      return localg;
    }
    
    public final Collection<ab> got()
    {
      AppMethodBeat.i(60707);
      Collection localCollection = this.NZb.got();
      if (localCollection == null) {
        ajW(3);
      }
      AppMethodBeat.o(60707);
      return localCollection;
    }
    
    public final as gyy()
    {
      AppMethodBeat.i(60705);
      as localas = this.NZa;
      if (localas == null) {
        ajW(1);
      }
      AppMethodBeat.o(60705);
      return localas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */