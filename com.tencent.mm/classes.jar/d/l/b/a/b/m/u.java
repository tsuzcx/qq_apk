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
  private static final y LKQ;
  private static final a LKR;
  public static final aj LKS;
  private static final ab LKT;
  private static final ah LKU;
  private static final Set<ah> LKV;
  
  static
  {
    AppMethodBeat.i(60726);
    LKQ = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          agL(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          agL(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramAnonymousb, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          agL(2);
        }
        if (paramAnonymousb1 == null) {
          agL(3);
        }
        paramAnonymousb = (List)v.KTF;
        if (paramAnonymousb == null) {
          agL(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          agL(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(d.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          agL(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final l fPU()
      {
        return null;
      }
      
      public final d.l.b.a.b.b.a.g fQj()
      {
        AppMethodBeat.i(60667);
        Object localObject = d.l.b.a.b.b.a.g.LeU;
        localObject = g.a.fSm();
        if (localObject == null) {
          agL(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final d.l.b.a.b.a.g fRE()
      {
        AppMethodBeat.i(60675);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.fPy();
        if (locald == null) {
          agL(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> fRF()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.KTF;
        if (localList == null) {
          agL(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
      
      public final l fRc()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          agL(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final d.l.b.a.b.f.f fRf()
      {
        AppMethodBeat.i(60669);
        d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aWD("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
    };
    LKR = new a(d.l.b.a.b.f.f.aWD("<ERROR CLASS>"));
    LKS = aWR("<LOOP IN SUPERTYPES>");
    LKT = aWR("<ERROR PROPERTY TYPE>");
    Object localObject = LKR;
    g.a locala = d.l.b.a.b.b.a.g.LeU;
    localObject = aa.a((l)localObject, g.a.fSm(), w.LdI, az.Lem, d.l.b.a.b.f.f.aWD("<ERROR PROPERTY>"), b.a.Ldo, an.Lec);
    ((aa)localObject).a(LKT, Collections.emptyList(), null, null);
    LKU = (ah)localObject;
    LKV = Collections.singleton(localObject);
    AppMethodBeat.o(60726);
  }
  
  public static aj I(String paramString, List<av> paramList)
  {
    AppMethodBeat.i(60718);
    if (paramString == null) {
      agL(11);
    }
    if (paramList == null) {
      agL(12);
    }
    paramString = new t(aWT(paramString), aWQ(paramString), paramList, false);
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
    if (((paraml instanceof a)) || ((paraml.fPU() instanceof a)) || (paraml == LKQ))
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
      agL(9);
    }
    if (paramat == null) {
      agL(10);
    }
    paramString = new t(paramat, aWQ(paramString), (byte)0);
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      agL(17);
    }
    if (parama == null) {
      agL(18);
    }
    paramString = new at()
    {
      public final d.l.b.a.b.b.h fQq()
      {
        return this.LKW;
      }
      
      public final boolean fQs()
      {
        return false;
      }
      
      public final d.l.b.a.b.a.g fRE()
      {
        AppMethodBeat.i(60679);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.fPy();
        if (locald == null) {
          agL(2);
        }
        AppMethodBeat.o(60679);
        return locald;
      }
      
      public final Collection<ab> fSt()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.KTF;
        if (localList == null) {
          agL(1);
        }
        AppMethodBeat.o(60678);
        return localList;
      }
      
      public final List<as> getParameters()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.KTF;
        if (localList == null) {
          agL(0);
        }
        AppMethodBeat.o(60677);
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
  
  public static e aWP(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      agL(1);
    }
    paramString = new a(d.l.b.a.b.f.f.aWD("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h aWQ(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      agL(2);
    }
    paramString = dq(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj aWR(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      agL(7);
    }
    paramString = I(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj aWS(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, LKR));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static at aWT(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      agL(15);
    }
    paramString = a("[ERROR : " + paramString + "]", LKR);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static boolean al(ab paramab)
  {
    AppMethodBeat.i(60723);
    if ((paramab != null) && ((paramab.gbz() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static d.l.b.a.b.j.f.h dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      agL(3);
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
  
  public static y gcu()
  {
    AppMethodBeat.i(60722);
    y localy = LKQ;
    if (localy == null) {
      agL(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends d.l.b.a.b.b.c.h
  {
    public a(d.l.b.a.b.f.f paramf)
    {
      super(paramf, w.LdI, d.l.b.a.b.b.f.Ldw, Collections.emptyList(), an.Lec, d.l.b.a.b.l.b.LJP);
      AppMethodBeat.i(60681);
      paramf = d.l.b.a.b.b.a.g.LeU;
      paramf = d.l.b.a.b.b.c.f.a(this, g.a.fSm(), an.Lec);
      paramf.a(Collections.emptyList(), az.Lel);
      d.l.b.a.b.j.f.h localh = u.aWQ(fRf().rf());
      paramf.J(new t(u.b("<ERROR>", this), localh, (byte)0));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final d.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        agL(6);
      }
      if (parami == null) {
        agL(7);
      }
      paramay = u.aWQ("Error scope for class " + fRf() + " with arguments: " + paramay);
      if (paramay == null) {
        agL(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        agL(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = fRf().rf();
      AppMethodBeat.o(60683);
      return str;
    }
  }
  
  public static final class b
    implements d.l.b.a.b.j.f.h
  {
    private final String LFd;
    
    private b(String paramString)
    {
      AppMethodBeat.i(60687);
      this.LFd = paramString;
      AppMethodBeat.o(60687);
    }
    
    public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60691);
      if (paramd == null) {
        agL(16);
      }
      if (paramb == null) {
        agL(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        agL(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        agL(1);
      }
      if (parama == null) {
        agL(2);
      }
      paramf = u.aWP(paramf.rf());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> fSy()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        agL(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<d.l.b.a.b.f.f> fSz()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        agL(12);
      }
      AppMethodBeat.o(60690);
      return localSet;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60692);
      String str = "ErrorScope{" + this.LFd + '}';
      AppMethodBeat.o(60692);
      return str;
    }
  }
  
  static final class c
    implements d.l.b.a.b.j.f.h
  {
    private final String LFd;
    
    private c(String paramString)
    {
      AppMethodBeat.i(60696);
      this.LFd = paramString;
      AppMethodBeat.o(60696);
    }
    
    public final Collection<? extends ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60698);
      if (paramf == null) {
        agL(5);
      }
      if (parama == null) {
        agL(6);
      }
      paramf = new IllegalStateException(this.LFd + ", required name: " + paramf);
      AppMethodBeat.o(60698);
      throw paramf;
    }
    
    public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60700);
      if (paramd == null) {
        agL(9);
      }
      if (paramb == null) {
        agL(10);
      }
      paramd = new IllegalStateException(this.LFd);
      AppMethodBeat.o(60700);
      throw paramd;
    }
    
    public final Collection<? extends am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60699);
      if (paramf == null) {
        agL(7);
      }
      if (parama == null) {
        agL(8);
      }
      paramf = new IllegalStateException(this.LFd + ", required name: " + paramf);
      AppMethodBeat.o(60699);
      throw paramf;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60697);
      if (paramf == null) {
        agL(1);
      }
      if (parama == null) {
        agL(2);
      }
      paramf = new IllegalStateException(this.LFd + ", required name: " + paramf);
      AppMethodBeat.o(60697);
      throw paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> fSy()
    {
      AppMethodBeat.i(60701);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60701);
      throw localIllegalStateException;
    }
    
    public final Set<d.l.b.a.b.f.f> fSz()
    {
      AppMethodBeat.i(60702);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60702);
      throw localIllegalStateException;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60703);
      String str = "ThrowingScope{" + this.LFd + '}';
      AppMethodBeat.o(60703);
      return str;
    }
  }
  
  public static final class d
    implements at
  {
    private final as LKY;
    private final at LKZ;
    
    public final d.l.b.a.b.b.h fQq()
    {
      AppMethodBeat.i(60709);
      d.l.b.a.b.b.h localh = this.LKZ.fQq();
      AppMethodBeat.o(60709);
      return localh;
    }
    
    public final boolean fQs()
    {
      AppMethodBeat.i(60708);
      boolean bool = this.LKZ.fQs();
      AppMethodBeat.o(60708);
      return bool;
    }
    
    public final d.l.b.a.b.a.g fRE()
    {
      AppMethodBeat.i(60710);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(this.LKY);
      if (localg == null) {
        agL(4);
      }
      AppMethodBeat.o(60710);
      return localg;
    }
    
    public final Collection<ab> fSt()
    {
      AppMethodBeat.i(60707);
      Collection localCollection = this.LKZ.fSt();
      if (localCollection == null) {
        agL(3);
      }
      AppMethodBeat.o(60707);
      return localCollection;
    }
    
    public final as gcv()
    {
      AppMethodBeat.i(60705);
      as localas = this.LKY;
      if (localas == null) {
        agL(1);
      }
      AppMethodBeat.o(60705);
      return localas;
    }
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(60706);
      List localList = this.LKZ.getParameters();
      if (localList == null) {
        agL(2);
      }
      AppMethodBeat.o(60706);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */