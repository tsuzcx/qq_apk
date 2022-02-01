package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.b.y.a;
import kotlin.l.b.a.b.m.a.i;

public final class u
{
  private static final y TNL;
  private static final a TNM;
  public static final aj TNN;
  private static final ab TNO;
  private static final ah TNP;
  private static final Set<ah> TNQ;
  
  static
  {
    AppMethodBeat.i(60726);
    TNL = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          atM(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          atM(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramAnonymousb, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          atM(2);
        }
        if (paramAnonymousb1 == null) {
          atM(3);
        }
        paramAnonymousb = (List)v.SXr;
        if (paramAnonymousb == null) {
          atM(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          atM(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(kotlin.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          atM(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final l hAE()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          atM(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final kotlin.l.b.a.b.f.f hAH()
      {
        AppMethodBeat.i(60669);
        kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bua("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
      
      public final kotlin.l.b.a.b.a.g hBh()
      {
        AppMethodBeat.i(60675);
        kotlin.l.b.a.b.a.d locald = kotlin.l.b.a.b.a.d.hzb();
        if (locald == null) {
          atM(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> hBi()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.SXr;
        if (localList == null) {
          atM(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
      
      public final kotlin.l.b.a.b.b.a.g hzL()
      {
        AppMethodBeat.i(60667);
        Object localObject = kotlin.l.b.a.b.b.a.g.TiC;
        localObject = g.a.hBP();
        if (localObject == null) {
          atM(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final l hzx()
      {
        return null;
      }
    };
    TNM = new a(kotlin.l.b.a.b.f.f.bua("<ERROR CLASS>"));
    TNN = bun("<LOOP IN SUPERTYPES>");
    TNO = bun("<ERROR PROPERTY TYPE>");
    Object localObject = TNM;
    g.a locala = kotlin.l.b.a.b.b.a.g.TiC;
    localObject = aa.a((l)localObject, g.a.hBP(), w.Thq, az.ThU, kotlin.l.b.a.b.f.f.bua("<ERROR PROPERTY>"), b.a.TgW, an.ThK);
    ((aa)localObject).a(TNO, Collections.emptyList(), null, null);
    TNP = (ah)localObject;
    TNQ = Collections.singleton(localObject);
    AppMethodBeat.o(60726);
  }
  
  public static boolean L(l paraml)
  {
    AppMethodBeat.i(60721);
    if (paraml == null)
    {
      AppMethodBeat.o(60721);
      return false;
    }
    if (((paraml instanceof a)) || ((paraml.hzx() instanceof a)) || (paraml == TNL))
    {
      AppMethodBeat.o(60721);
      return true;
    }
    AppMethodBeat.o(60721);
    return false;
  }
  
  public static aj S(String paramString, List<av> paramList)
  {
    AppMethodBeat.i(60718);
    if (paramString == null) {
      atM(11);
    }
    if (paramList == null) {
      atM(12);
    }
    paramString = new t(bup(paramString), bum(paramString), paramList);
    AppMethodBeat.o(60718);
    return paramString;
  }
  
  public static aj a(String paramString, at paramat)
  {
    AppMethodBeat.i(60717);
    if (paramString == null) {
      atM(9);
    }
    if (paramat == null) {
      atM(10);
    }
    paramString = new t(paramat, bum(paramString));
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      atM(17);
    }
    if (parama == null) {
      atM(18);
    }
    paramString = new at()
    {
      public final List<as> getParameters()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.SXr;
        if (localList == null) {
          atM(0);
        }
        AppMethodBeat.o(60677);
        return localList;
      }
      
      public final Collection<ab> hBV()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.SXr;
        if (localList == null) {
          atM(1);
        }
        AppMethodBeat.o(60678);
        return localList;
      }
      
      public final kotlin.l.b.a.b.a.g hBh()
      {
        AppMethodBeat.i(60679);
        kotlin.l.b.a.b.a.d locald = kotlin.l.b.a.b.a.d.hzb();
        if (locald == null) {
          atM(2);
        }
        AppMethodBeat.o(60679);
        return locald;
      }
      
      public final kotlin.l.b.a.b.b.h hzS()
      {
        return this.TNR;
      }
      
      public final boolean hzU()
      {
        return false;
      }
      
      public final String toString()
      {
        return paramString;
      }
    };
    AppMethodBeat.o(60720);
    return paramString;
  }
  
  public static boolean ak(ab paramab)
  {
    AppMethodBeat.i(60723);
    if ((paramab != null) && ((paramab.hKE() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static e bul(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      atM(1);
    }
    paramString = new a(kotlin.l.b.a.b.f.f.bua("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static kotlin.l.b.a.b.j.f.h bum(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      atM(2);
    }
    paramString = dU(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj bun(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      atM(7);
    }
    paramString = S(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj buo(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, TNM));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static at bup(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      atM(15);
    }
    paramString = a("[ERROR : " + paramString + "]", TNM);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static kotlin.l.b.a.b.j.f.h dU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      atM(3);
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
  
  public static y hLA()
  {
    AppMethodBeat.i(60722);
    y localy = TNL;
    if (localy == null) {
      atM(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends kotlin.l.b.a.b.b.c.h
  {
    public a(kotlin.l.b.a.b.f.f paramf)
    {
      super(paramf, w.Thq, kotlin.l.b.a.b.b.f.The, Collections.emptyList(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
      AppMethodBeat.i(60681);
      paramf = kotlin.l.b.a.b.b.a.g.TiC;
      paramf = kotlin.l.b.a.b.b.c.f.a(this, g.a.hBP(), an.ThK);
      paramf.a(Collections.emptyList(), az.ThT);
      kotlin.l.b.a.b.j.f.h localh = u.bum(hAH().sG());
      paramf.I(new t(u.b("<ERROR>", this), localh));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final kotlin.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        atM(6);
      }
      if (parami == null) {
        atM(7);
      }
      paramay = u.bum("Error scope for class " + hAH() + " with arguments: " + paramay);
      if (paramay == null) {
        atM(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        atM(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = hAH().sG();
      AppMethodBeat.o(60683);
      return str;
    }
  }
  
  public static final class b
    implements kotlin.l.b.a.b.j.f.h
  {
    private final String debugMessage;
    
    private b(String paramString)
    {
      AppMethodBeat.i(60687);
      this.debugMessage = paramString;
      AppMethodBeat.o(60687);
    }
    
    public final Collection<l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60691);
      if (paramd == null) {
        atM(16);
      }
      if (paramb == null) {
        atM(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        atM(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        atM(1);
      }
      if (parama == null) {
        atM(2);
      }
      paramf = u.bul(paramf.sG());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> hCa()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        atM(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> hCb()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        atM(12);
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
    implements kotlin.l.b.a.b.j.f.h
  {
    private final String debugMessage;
    
    private c(String paramString)
    {
      AppMethodBeat.i(60696);
      this.debugMessage = paramString;
      AppMethodBeat.o(60696);
    }
    
    public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60698);
      if (paramf == null) {
        atM(5);
      }
      if (parama == null) {
        atM(6);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60698);
      throw paramf;
    }
    
    public final Collection<l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60700);
      if (paramd == null) {
        atM(9);
      }
      if (paramb == null) {
        atM(10);
      }
      paramd = new IllegalStateException(this.debugMessage);
      AppMethodBeat.o(60700);
      throw paramd;
    }
    
    public final Collection<? extends am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60699);
      if (paramf == null) {
        atM(7);
      }
      if (parama == null) {
        atM(8);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60699);
      throw paramf;
    }
    
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60697);
      if (paramf == null) {
        atM(1);
      }
      if (parama == null) {
        atM(2);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60697);
      throw paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> hCa()
    {
      AppMethodBeat.i(60701);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60701);
      throw localIllegalStateException;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> hCb()
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
    private final as TNT;
    private final at TNU;
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(60706);
      List localList = this.TNU.getParameters();
      if (localList == null) {
        atM(2);
      }
      AppMethodBeat.o(60706);
      return localList;
    }
    
    public final Collection<ab> hBV()
    {
      AppMethodBeat.i(60707);
      Collection localCollection = this.TNU.hBV();
      if (localCollection == null) {
        atM(3);
      }
      AppMethodBeat.o(60707);
      return localCollection;
    }
    
    public final kotlin.l.b.a.b.a.g hBh()
    {
      AppMethodBeat.i(60710);
      kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.j.d.a.G(this.TNT);
      if (localg == null) {
        atM(4);
      }
      AppMethodBeat.o(60710);
      return localg;
    }
    
    public final as hLB()
    {
      AppMethodBeat.i(60705);
      as localas = this.TNT;
      if (localas == null) {
        atM(1);
      }
      AppMethodBeat.o(60705);
      return localas;
    }
    
    public final kotlin.l.b.a.b.b.h hzS()
    {
      AppMethodBeat.i(60709);
      kotlin.l.b.a.b.b.h localh = this.TNU.hzS();
      AppMethodBeat.o(60709);
      return localh;
    }
    
    public final boolean hzU()
    {
      AppMethodBeat.i(60708);
      boolean bool = this.TNU.hzU();
      AppMethodBeat.o(60708);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */