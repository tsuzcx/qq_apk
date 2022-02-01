package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.ah;
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
  private static final y NBL;
  private static final a NBM;
  public static final aj NBN;
  private static final ab NBO;
  private static final ah NBP;
  private static final Set<ah> NBQ;
  
  static
  {
    AppMethodBeat.i(60726);
    NBL = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          ajm(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          ajm(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramAnonymousb, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          ajm(2);
        }
        if (paramAnonymousb1 == null) {
          ajm(3);
        }
        paramAnonymousb = (List)v.MKE;
        if (paramAnonymousb == null) {
          ajm(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          ajm(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(d.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          ajm(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final d.l.b.a.b.b.a.g ghH()
      {
        AppMethodBeat.i(60667);
        Object localObject = d.l.b.a.b.b.a.g.MVP;
        localObject = g.a.gjL();
        if (localObject == null) {
          ajm(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final l ghs()
      {
        return null;
      }
      
      public final l giA()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          ajm(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final d.l.b.a.b.f.f giD()
      {
        AppMethodBeat.i(60669);
        d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bcG("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
      
      public final d.l.b.a.b.a.g gjd()
      {
        AppMethodBeat.i(60675);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.ggW();
        if (locald == null) {
          ajm(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> gje()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.MKE;
        if (localList == null) {
          ajm(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
    };
    NBM = new a(d.l.b.a.b.f.f.bcG("<ERROR CLASS>"));
    NBN = bcU("<LOOP IN SUPERTYPES>");
    NBO = bcU("<ERROR PROPERTY TYPE>");
    Object localObject = NBM;
    g.a locala = d.l.b.a.b.b.a.g.MVP;
    localObject = aa.a((l)localObject, g.a.gjL(), w.MUD, az.MVh, d.l.b.a.b.f.f.bcG("<ERROR PROPERTY>"), b.a.MUj, an.MUX);
    ((aa)localObject).a(NBO, Collections.emptyList(), null, null);
    NBP = (ah)localObject;
    NBQ = Collections.singleton(localObject);
    AppMethodBeat.o(60726);
  }
  
  public static aj K(String paramString, List<av> paramList)
  {
    AppMethodBeat.i(60718);
    if (paramString == null) {
      ajm(11);
    }
    if (paramList == null) {
      ajm(12);
    }
    paramString = new t(bcW(paramString), bcT(paramString), paramList);
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
    if (((paraml instanceof a)) || ((paraml.ghs() instanceof a)) || (paraml == NBL))
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
      ajm(9);
    }
    if (paramat == null) {
      ajm(10);
    }
    paramString = new t(paramat, bcT(paramString));
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      ajm(17);
    }
    if (parama == null) {
      ajm(18);
    }
    paramString = new at()
    {
      public final List<as> getParameters()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.MKE;
        if (localList == null) {
          ajm(0);
        }
        AppMethodBeat.o(60677);
        return localList;
      }
      
      public final d.l.b.a.b.b.h ghO()
      {
        return this.NBR;
      }
      
      public final boolean ghQ()
      {
        return false;
      }
      
      public final Collection<ab> gjR()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.MKE;
        if (localList == null) {
          ajm(1);
        }
        AppMethodBeat.o(60678);
        return localList;
      }
      
      public final d.l.b.a.b.a.g gjd()
      {
        AppMethodBeat.i(60679);
        d.l.b.a.b.a.d locald = d.l.b.a.b.a.d.ggW();
        if (locald == null) {
          ajm(2);
        }
        AppMethodBeat.o(60679);
        return locald;
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
    if ((paramab != null) && ((paramab.gsZ() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static e bcS(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      ajm(1);
    }
    paramString = new a(d.l.b.a.b.f.f.bcG("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h bcT(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      ajm(2);
    }
    paramString = dv(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj bcU(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      ajm(7);
    }
    paramString = K(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj bcV(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, NBM));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static at bcW(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      ajm(15);
    }
    paramString = a("[ERROR : " + paramString + "]", NBM);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static d.l.b.a.b.j.f.h dv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      ajm(3);
    }
    if (paramBoolean)
    {
      paramString = new u.c(paramString, (byte)0);
      AppMethodBeat.o(60714);
      return paramString;
    }
    paramString = new b(paramString, (byte)0);
    AppMethodBeat.o(60714);
    return paramString;
  }
  
  public static y gtV()
  {
    AppMethodBeat.i(60722);
    y localy = NBL;
    if (localy == null) {
      ajm(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends d.l.b.a.b.b.c.h
  {
    public a(d.l.b.a.b.f.f paramf)
    {
      super(paramf, w.MUD, d.l.b.a.b.b.f.MUr, Collections.emptyList(), an.MUX, d.l.b.a.b.l.b.NAN);
      AppMethodBeat.i(60681);
      paramf = d.l.b.a.b.b.a.g.MVP;
      paramf = d.l.b.a.b.b.c.f.a(this, g.a.gjL(), an.MUX);
      paramf.a(Collections.emptyList(), az.MVg);
      d.l.b.a.b.j.f.h localh = u.bcT(giD().sD());
      paramf.J(new t(u.b("<ERROR>", this), localh));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final d.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        ajm(6);
      }
      if (parami == null) {
        ajm(7);
      }
      paramay = u.bcT("Error scope for class " + giD() + " with arguments: " + paramay);
      if (paramay == null) {
        ajm(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        ajm(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = giD().sD();
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
        ajm(16);
      }
      if (paramb == null) {
        ajm(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        ajm(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        ajm(1);
      }
      if (parama == null) {
        ajm(2);
      }
      paramf = u.bcS(paramf.sD());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<d.l.b.a.b.f.f> gjW()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        ajm(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<d.l.b.a.b.f.f> gjX()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        ajm(12);
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
  
  public static final class d
    implements at
  {
    private final as NBT;
    private final at NBU;
    
    public final List<as> getParameters()
    {
      AppMethodBeat.i(60706);
      List localList = this.NBU.getParameters();
      if (localList == null) {
        ajm(2);
      }
      AppMethodBeat.o(60706);
      return localList;
    }
    
    public final d.l.b.a.b.b.h ghO()
    {
      AppMethodBeat.i(60709);
      d.l.b.a.b.b.h localh = this.NBU.ghO();
      AppMethodBeat.o(60709);
      return localh;
    }
    
    public final boolean ghQ()
    {
      AppMethodBeat.i(60708);
      boolean bool = this.NBU.ghQ();
      AppMethodBeat.o(60708);
      return bool;
    }
    
    public final Collection<ab> gjR()
    {
      AppMethodBeat.i(60707);
      Collection localCollection = this.NBU.gjR();
      if (localCollection == null) {
        ajm(3);
      }
      AppMethodBeat.o(60707);
      return localCollection;
    }
    
    public final d.l.b.a.b.a.g gjd()
    {
      AppMethodBeat.i(60710);
      d.l.b.a.b.a.g localg = d.l.b.a.b.j.d.a.G(this.NBT);
      if (localg == null) {
        ajm(4);
      }
      AppMethodBeat.o(60710);
      return localg;
    }
    
    public final as gtW()
    {
      AppMethodBeat.i(60705);
      as localas = this.NBT;
      if (localas == null) {
        ajm(1);
      }
      AppMethodBeat.o(60705);
      return localas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */