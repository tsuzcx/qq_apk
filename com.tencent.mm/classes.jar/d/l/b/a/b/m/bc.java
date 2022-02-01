package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class bc
{
  public static final aj JYA;
  public static final aj JYx;
  public static final aj JYy;
  public static final aj JYz;
  
  static
  {
    AppMethodBeat.i(60901);
    if (!bc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      JYx = u.aQT("DONT_CARE");
      JYy = u.aQS("Cannot be inferred");
      JYz = new a("NO_EXPECTED_TYPE");
      JYA = new a("UNIT_EXPECTED_TYPE");
      AppMethodBeat.o(60901);
      return;
    }
  }
  
  public static ab a(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(60889);
    if (paramab == null) {
      adP(3);
    }
    paramab = paramab.fJW().xV(paramBoolean);
    if (paramab == null) {
      adP(4);
    }
    AppMethodBeat.o(60889);
    return paramab;
  }
  
  public static aj a(d.l.b.a.b.b.h paramh, d.l.b.a.b.j.f.h paramh1, b<i, aj> paramb)
  {
    AppMethodBeat.i(60891);
    if (u.L(paramh))
    {
      paramh = u.aQS("Unsubstituted type for ".concat(String.valueOf(paramh)));
      if (paramh == null) {
        adP(11);
      }
      AppMethodBeat.o(60891);
      return paramh;
    }
    paramh = paramh.fxs();
    if (paramh == null) {
      adP(12);
    }
    if (paramh1 == null) {
      adP(13);
    }
    List localList = iP(paramh.getParameters());
    g.a locala = g.JrB;
    paramh = ac.a(g.a.fzI(), paramh, localList, false, paramh1, paramb);
    AppMethodBeat.o(60891);
    return paramh;
  }
  
  private static boolean a(ab paramab, b<bg, Boolean> paramb, HashSet<ab> paramHashSet)
  {
    AppMethodBeat.i(60897);
    if (paramb == null) {
      adP(44);
    }
    if (paramab == null)
    {
      AppMethodBeat.o(60897);
      return false;
    }
    if (paramHashSet.contains(paramab))
    {
      AppMethodBeat.o(60897);
      return false;
    }
    paramHashSet.add(paramab);
    bg localbg = paramab.fJW();
    if (((Boolean)paramb.aA(localbg)).booleanValue())
    {
      AppMethodBeat.o(60897);
      return true;
    }
    if ((localbg instanceof v)) {}
    for (Object localObject = (v)localbg; (localObject != null) && ((a(((v)localObject).JXH, paramb, paramHashSet)) || (a(((v)localObject).JXI, paramb, paramHashSet))); localObject = null)
    {
      AppMethodBeat.o(60897);
      return true;
    }
    if (((localbg instanceof l)) && (a(((l)localbg).JXr, paramb, paramHashSet)))
    {
      AppMethodBeat.o(60897);
      return true;
    }
    localObject = paramab.fIW();
    if ((localObject instanceof aa))
    {
      paramab = ((Collection)((aa)localObject).JXQ).iterator();
      while (paramab.hasNext()) {
        if (a((ab)paramab.next(), paramb, paramHashSet))
        {
          AppMethodBeat.o(60897);
          return true;
        }
      }
      AppMethodBeat.o(60897);
      return false;
    }
    paramab = paramab.fIT().iterator();
    while (paramab.hasNext())
    {
      localObject = (av)paramab.next();
      if ((!((av)localObject).fJY()) && (a(((av)localObject).fzr(), paramb, paramHashSet)))
      {
        AppMethodBeat.o(60897);
        return true;
      }
    }
    AppMethodBeat.o(60897);
    return false;
  }
  
  public static boolean aB(ab paramab)
  {
    AppMethodBeat.i(60885);
    if (paramab == null) {
      adP(0);
    }
    if ((paramab == JYz) || (paramab == JYA))
    {
      AppMethodBeat.o(60885);
      return true;
    }
    AppMethodBeat.o(60885);
    return false;
  }
  
  public static boolean aC(ab paramab)
  {
    AppMethodBeat.i(60886);
    if ((paramab != null) && (paramab.fIW() == JYx.fIW()))
    {
      AppMethodBeat.o(60886);
      return true;
    }
    AppMethodBeat.o(60886);
    return false;
  }
  
  public static ab aD(ab paramab)
  {
    AppMethodBeat.i(60887);
    if (paramab == null) {
      adP(1);
    }
    paramab = a(paramab, true);
    AppMethodBeat.o(60887);
    return paramab;
  }
  
  public static ab aE(ab paramab)
  {
    AppMethodBeat.i(60888);
    if (paramab == null) {
      adP(2);
    }
    paramab = a(paramab, false);
    AppMethodBeat.o(60888);
    return paramab;
  }
  
  public static boolean aF(ab paramab)
  {
    AppMethodBeat.i(60893);
    if (paramab == null) {
      adP(27);
    }
    if (paramab.fBT())
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if ((y.am(paramab)) && (aF(y.an(paramab).JXI)))
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if (aI(paramab))
    {
      if (paramab == null) {
        adP(29);
      }
      if (!(paramab.fIW().fxM() instanceof e))
      {
        if (paramab == null) {
          adP(18);
        }
        ba localba = ba.aA(paramab);
        Object localObject = paramab.fIW().fzP();
        ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
        Iterator localIterator = ((Collection)localObject).iterator();
        label220:
        while (localIterator.hasNext())
        {
          localObject = (ab)localIterator.next();
          if (paramab == null) {
            adP(20);
          }
          if (localObject == null) {
            adP(21);
          }
          if (localba == null) {
            adP(22);
          }
          localObject = localba.c((ab)localObject, bh.JYC);
          if (localObject != null) {}
          for (localObject = b((ab)localObject, paramab.fBT());; localObject = null)
          {
            if (localObject == null) {
              break label220;
            }
            localArrayList.add(localObject);
            break;
          }
        }
        paramab = localArrayList.iterator();
        while (paramab.hasNext()) {
          if (aF((ab)paramab.next()))
          {
            AppMethodBeat.o(60893);
            return true;
          }
        }
      }
      AppMethodBeat.o(60893);
      return false;
    }
    paramab = paramab.fIW();
    if ((paramab instanceof aa))
    {
      paramab = paramab.fzP().iterator();
      while (paramab.hasNext()) {
        if (aF((ab)paramab.next()))
        {
          AppMethodBeat.o(60893);
          return true;
        }
      }
    }
    AppMethodBeat.o(60893);
    return false;
  }
  
  public static boolean aG(ab paramab)
  {
    AppMethodBeat.i(60894);
    if (paramab == null) {
      adP(28);
    }
    if (paramab.fBT())
    {
      AppMethodBeat.o(60894);
      return true;
    }
    if ((y.am(paramab)) && (aG(y.an(paramab).JXI)))
    {
      AppMethodBeat.o(60894);
      return true;
    }
    AppMethodBeat.o(60894);
    return false;
  }
  
  public static e aH(ab paramab)
  {
    AppMethodBeat.i(60895);
    if (paramab == null) {
      adP(30);
    }
    paramab = paramab.fIW().fxM();
    if ((paramab instanceof e))
    {
      paramab = (e)paramab;
      AppMethodBeat.o(60895);
      return paramab;
    }
    AppMethodBeat.o(60895);
    return null;
  }
  
  public static boolean aI(ab paramab)
  {
    AppMethodBeat.i(60899);
    if (paramab == null) {
      adP(59);
    }
    if ((aJ(paramab) != null) || ((paramab.fIW() instanceof p)))
    {
      AppMethodBeat.o(60899);
      return true;
    }
    AppMethodBeat.o(60899);
    return false;
  }
  
  private static as aJ(ab paramab)
  {
    AppMethodBeat.i(60900);
    if (paramab == null) {
      adP(62);
    }
    if ((paramab.fIW().fxM() instanceof as))
    {
      paramab = (as)paramab.fIW().fxM();
      AppMethodBeat.o(60900);
      return paramab;
    }
    AppMethodBeat.o(60900);
    return null;
  }
  
  public static ab b(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(60890);
    if (paramab == null) {
      adP(8);
    }
    if (paramBoolean)
    {
      paramab = aD(paramab);
      AppMethodBeat.o(60890);
      return paramab;
    }
    if (paramab == null) {
      adP(9);
    }
    AppMethodBeat.o(60890);
    return paramab;
  }
  
  public static boolean b(ab paramab, b<bg, Boolean> paramb)
  {
    AppMethodBeat.i(60896);
    if (paramb == null) {
      adP(43);
    }
    boolean bool = a(paramab, paramb, new HashSet());
    AppMethodBeat.o(60896);
    return bool;
  }
  
  public static av d(as paramas)
  {
    AppMethodBeat.i(60898);
    if (paramas == null) {
      adP(45);
    }
    paramas = new ao(paramas);
    AppMethodBeat.o(60898);
    return paramas;
  }
  
  public static List<av> iP(List<as> paramList)
  {
    AppMethodBeat.i(60892);
    if (paramList == null) {
      adP(16);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ax(((as)paramList.next()).fyA()));
    }
    paramList = j.m(localArrayList);
    if (paramList == null) {
      adP(17);
    }
    AppMethodBeat.o(60892);
    return paramList;
  }
  
  public static final class a
    extends n
  {
    private final String name;
    
    public a(String paramString)
    {
      this.name = paramString;
    }
    
    private a n(i parami)
    {
      AppMethodBeat.i(60878);
      if (parami == null) {
        adP(3);
      }
      AppMethodBeat.o(60878);
      return this;
    }
    
    public final n b(aj paramaj)
    {
      AppMethodBeat.i(60877);
      if (paramaj == null) {
        adP(2);
      }
      paramaj = new IllegalStateException(this.name);
      AppMethodBeat.o(60877);
      throw paramaj;
    }
    
    public final aj d(g paramg)
    {
      AppMethodBeat.i(60874);
      if (paramg == null) {
        adP(0);
      }
      paramg = new IllegalStateException(this.name);
      AppMethodBeat.o(60874);
      throw paramg;
    }
    
    protected final aj fBP()
    {
      AppMethodBeat.i(60873);
      IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
      AppMethodBeat.o(60873);
      throw localIllegalStateException;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60876);
      String str = this.name;
      if (str == null) {
        adP(1);
      }
      AppMethodBeat.o(60876);
      return str;
    }
    
    public final aj xW(boolean paramBoolean)
    {
      AppMethodBeat.i(60875);
      IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
      AppMethodBeat.o(60875);
      throw localIllegalStateException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bc
 * JD-Core Version:    0.7.0.1
 */