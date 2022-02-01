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
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.m.a.i;

public final class u
{
  private static final y abqn;
  private static final a abqo;
  public static final aj abqp;
  private static final ab abqq;
  private static final ah abqr;
  private static final Set<ah> abqs;
  
  static
  {
    AppMethodBeat.i(60726);
    abqn = new y()
    {
      public final <R, D> R a(n<R, D> paramAnonymousn, D paramAnonymousD)
      {
        AppMethodBeat.i(60672);
        if (paramAnonymousn == null) {
          aDG(10);
        }
        AppMethodBeat.o(60672);
        return null;
      }
      
      public final <T> T a(y.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(60666);
        if (paramAnonymousa == null) {
          aDG(0);
        }
        AppMethodBeat.o(60666);
        return null;
      }
      
      public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramAnonymousb, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramAnonymousb1)
      {
        AppMethodBeat.i(60668);
        if (paramAnonymousb == null) {
          aDG(2);
        }
        if (paramAnonymousb1 == null) {
          aDG(3);
        }
        paramAnonymousb = (List)v.aaAd;
        if (paramAnonymousb == null) {
          aDG(4);
        }
        AppMethodBeat.o(60668);
        return paramAnonymousb;
      }
      
      public final boolean a(y paramAnonymousy)
      {
        AppMethodBeat.i(60673);
        if (paramAnonymousy == null) {
          aDG(11);
        }
        AppMethodBeat.o(60673);
        return false;
      }
      
      public final ad e(kotlin.l.b.a.b.f.b paramAnonymousb)
      {
        AppMethodBeat.i(60670);
        if (paramAnonymousb == null) {
          aDG(7);
        }
        paramAnonymousb = new IllegalStateException("Should not be called!");
        AppMethodBeat.o(60670);
        throw paramAnonymousb;
      }
      
      public final l iDJ()
      {
        return null;
      }
      
      public final kotlin.l.b.a.b.b.a.g iDY()
      {
        AppMethodBeat.i(60667);
        Object localObject = kotlin.l.b.a.b.b.a.g.aaLw;
        localObject = g.a.iGe();
        if (localObject == null) {
          aDG(1);
        }
        AppMethodBeat.o(60667);
        return localObject;
      }
      
      public final l iER()
      {
        AppMethodBeat.i(60674);
        if (this == null) {
          aDG(12);
        }
        AppMethodBeat.o(60674);
        return this;
      }
      
      public final kotlin.l.b.a.b.f.f iEU()
      {
        AppMethodBeat.i(60669);
        kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bHd("<ERROR MODULE>");
        AppMethodBeat.o(60669);
        return localf;
      }
      
      public final kotlin.l.b.a.b.a.g iFv()
      {
        AppMethodBeat.i(60675);
        kotlin.l.b.a.b.a.d locald = kotlin.l.b.a.b.a.d.iDn();
        if (locald == null) {
          aDG(13);
        }
        AppMethodBeat.o(60675);
        return locald;
      }
      
      public final List<y> iFw()
      {
        AppMethodBeat.i(60671);
        List localList = (List)v.aaAd;
        if (localList == null) {
          aDG(9);
        }
        AppMethodBeat.o(60671);
        return localList;
      }
    };
    abqo = new a(kotlin.l.b.a.b.f.f.bHd("<ERROR CLASS>"));
    abqp = bHp("<LOOP IN SUPERTYPES>");
    abqq = bHp("<ERROR PROPERTY TYPE>");
    Object localObject = abqo;
    g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject = aa.a((l)localObject, g.a.iGe(), w.aaKk, az.aaKO, kotlin.l.b.a.b.f.f.bHd("<ERROR PROPERTY>"), b.a.aaJQ, an.aaKE);
    ((aa)localObject).a(abqq, Collections.emptyList(), null, null);
    abqr = (ah)localObject;
    abqs = Collections.singleton(localObject);
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
    if (((paraml instanceof a)) || ((paraml.iDJ() instanceof a)) || (paraml == abqn))
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
      aDG(11);
    }
    if (paramList == null) {
      aDG(12);
    }
    paramString = new t(bHr(paramString), bHo(paramString), paramList);
    AppMethodBeat.o(60718);
    return paramString;
  }
  
  public static aj a(String paramString, at paramat)
  {
    AppMethodBeat.i(60717);
    if (paramString == null) {
      aDG(9);
    }
    if (paramat == null) {
      aDG(10);
    }
    paramString = new t(paramat, bHo(paramString));
    AppMethodBeat.o(60717);
    return paramString;
  }
  
  private static at a(final String paramString, a parama)
  {
    AppMethodBeat.i(60720);
    if (paramString == null) {
      aDG(17);
    }
    if (parama == null) {
      aDG(18);
    }
    paramString = new at()
    {
      public final List<as> iCb()
      {
        AppMethodBeat.i(60677);
        List localList = (List)v.aaAd;
        if (localList == null) {
          aDG(0);
        }
        AppMethodBeat.o(60677);
        return localList;
      }
      
      public final kotlin.l.b.a.b.b.h iEf()
      {
        return this.abqt;
      }
      
      public final boolean iEh()
      {
        return false;
      }
      
      public final kotlin.l.b.a.b.a.g iFv()
      {
        AppMethodBeat.i(60679);
        kotlin.l.b.a.b.a.d locald = kotlin.l.b.a.b.a.d.iDn();
        if (locald == null) {
          aDG(2);
        }
        AppMethodBeat.o(60679);
        return locald;
      }
      
      public final Collection<ab> iGk()
      {
        AppMethodBeat.i(60678);
        List localList = (List)v.aaAd;
        if (localList == null) {
          aDG(1);
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
  
  public static boolean ak(ab paramab)
  {
    AppMethodBeat.i(60723);
    if ((paramab != null) && ((paramab.iOU() instanceof d)))
    {
      AppMethodBeat.o(60723);
      return true;
    }
    AppMethodBeat.o(60723);
    return false;
  }
  
  public static e bHn(String paramString)
  {
    AppMethodBeat.i(60712);
    if (paramString == null) {
      aDG(1);
    }
    paramString = new a(kotlin.l.b.a.b.f.f.bHd("<ERROR CLASS: " + paramString + ">"));
    AppMethodBeat.o(60712);
    return paramString;
  }
  
  public static kotlin.l.b.a.b.j.f.h bHo(String paramString)
  {
    AppMethodBeat.i(60713);
    if (paramString == null) {
      aDG(2);
    }
    paramString = eh(paramString, false);
    AppMethodBeat.o(60713);
    return paramString;
  }
  
  public static aj bHp(String paramString)
  {
    AppMethodBeat.i(60715);
    if (paramString == null) {
      aDG(7);
    }
    paramString = S(paramString, Collections.emptyList());
    AppMethodBeat.o(60715);
    return paramString;
  }
  
  public static aj bHq(String paramString)
  {
    AppMethodBeat.i(60716);
    paramString = a(paramString, a(paramString, abqo));
    AppMethodBeat.o(60716);
    return paramString;
  }
  
  public static at bHr(String paramString)
  {
    AppMethodBeat.i(60719);
    if (paramString == null) {
      aDG(15);
    }
    paramString = a("[ERROR : " + paramString + "]", abqo);
    AppMethodBeat.o(60719);
    return paramString;
  }
  
  public static kotlin.l.b.a.b.j.f.h eh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(60714);
    if (paramString == null) {
      aDG(3);
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
  
  public static y iPT()
  {
    AppMethodBeat.i(60722);
    y localy = abqn;
    if (localy == null) {
      aDG(19);
    }
    AppMethodBeat.o(60722);
    return localy;
  }
  
  static final class a
    extends kotlin.l.b.a.b.b.c.h
  {
    public a(kotlin.l.b.a.b.f.f paramf)
    {
      super(paramf, w.aaKk, kotlin.l.b.a.b.b.f.aaJY, Collections.emptyList(), an.aaKE, kotlin.l.b.a.b.l.b.abpp);
      AppMethodBeat.i(60681);
      paramf = kotlin.l.b.a.b.b.a.g.aaLw;
      paramf = kotlin.l.b.a.b.b.c.f.a(this, g.a.iGe(), an.aaKE);
      paramf.a(Collections.emptyList(), az.aaKN);
      kotlin.l.b.a.b.j.f.h localh = u.bHo(iEU().qu());
      paramf.I(new t(u.b("<ERROR>", this), localh));
      a(localh, Collections.singleton(paramf), paramf);
      AppMethodBeat.o(60681);
    }
    
    public final kotlin.l.b.a.b.j.f.h a(ay paramay, i parami)
    {
      AppMethodBeat.i(60684);
      if (paramay == null) {
        aDG(6);
      }
      if (parami == null) {
        aDG(7);
      }
      paramay = u.bHo("Error scope for class " + iEU() + " with arguments: " + paramay);
      if (paramay == null) {
        aDG(8);
      }
      AppMethodBeat.o(60684);
      return paramay;
    }
    
    public final e g(ba paramba)
    {
      AppMethodBeat.i(60682);
      if (paramba == null) {
        aDG(1);
      }
      AppMethodBeat.o(60682);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60683);
      String str = iEU().qu();
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
        aDG(16);
      }
      if (paramb == null) {
        aDG(17);
      }
      paramd = Collections.emptyList();
      if (paramd == null) {
        aDG(18);
      }
      AppMethodBeat.o(60691);
      return paramd;
    }
    
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(60688);
      if (paramf == null) {
        aDG(1);
      }
      if (parama == null) {
        aDG(2);
      }
      paramf = u.bHn(paramf.qu());
      AppMethodBeat.o(60688);
      return paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> iGp()
    {
      AppMethodBeat.i(60689);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        aDG(11);
      }
      AppMethodBeat.o(60689);
      return localSet;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> iGq()
    {
      AppMethodBeat.i(60690);
      Set localSet = Collections.emptySet();
      if (localSet == null) {
        aDG(12);
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
    
    public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(60698);
      if (paramf == null) {
        aDG(5);
      }
      if (parama == null) {
        aDG(6);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60698);
      throw paramf;
    }
    
    public final Collection<l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
    {
      AppMethodBeat.i(60700);
      if (paramd == null) {
        aDG(9);
      }
      if (paramb == null) {
        aDG(10);
      }
      paramd = new IllegalStateException(this.debugMessage);
      AppMethodBeat.o(60700);
      throw paramd;
    }
    
    public final Collection<? extends am> b(kotlin.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(60699);
      if (paramf == null) {
        aDG(7);
      }
      if (parama == null) {
        aDG(8);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60699);
      throw paramf;
    }
    
    public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, a parama)
    {
      AppMethodBeat.i(60697);
      if (paramf == null) {
        aDG(1);
      }
      if (parama == null) {
        aDG(2);
      }
      paramf = new IllegalStateException(this.debugMessage + ", required name: " + paramf);
      AppMethodBeat.o(60697);
      throw paramf;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> iGp()
    {
      AppMethodBeat.i(60701);
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(60701);
      throw localIllegalStateException;
    }
    
    public final Set<kotlin.l.b.a.b.f.f> iGq()
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
    public final List<as> iCb()
    {
      AppMethodBeat.i(60706);
      AppMethodBeat.o(60706);
      throw null;
    }
    
    public final kotlin.l.b.a.b.b.h iEf()
    {
      AppMethodBeat.i(60709);
      AppMethodBeat.o(60709);
      throw null;
    }
    
    public final boolean iEh()
    {
      AppMethodBeat.i(60708);
      AppMethodBeat.o(60708);
      throw null;
    }
    
    public final kotlin.l.b.a.b.a.g iFv()
    {
      AppMethodBeat.i(60710);
      AppMethodBeat.o(60710);
      throw null;
    }
    
    public final Collection<ab> iGk()
    {
      AppMethodBeat.i(60707);
      AppMethodBeat.o(60707);
      throw null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.u
 * JD-Core Version:    0.7.0.1
 */