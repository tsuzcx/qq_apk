package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.p;

public class bc
{
  public static final aj TOL;
  public static final aj TOM;
  public static final aj TON;
  public static final aj TOO;
  
  static
  {
    AppMethodBeat.i(60901);
    if (!bc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TOL = u.buo("DONT_CARE");
      TOM = u.bun("Cannot be inferred");
      TON = new a("NO_EXPECTED_TYPE");
      TOO = new a("UNIT_EXPECTED_TYPE");
      AppMethodBeat.o(60901);
      return;
    }
  }
  
  public static aj a(kotlin.l.b.a.b.b.h paramh, kotlin.l.b.a.b.j.f.h paramh1, b<i, aj> paramb)
  {
    AppMethodBeat.i(60891);
    if (u.L(paramh))
    {
      paramh = u.bun("Unsubstituted type for ".concat(String.valueOf(paramh)));
      if (paramh == null) {
        atM(11);
      }
      AppMethodBeat.o(60891);
      return paramh;
    }
    paramh = paramh.hzz();
    if (paramh == null) {
      atM(12);
    }
    if (paramh1 == null) {
      atM(13);
    }
    List localList = kI(paramh.getParameters());
    g.a locala = g.TiC;
    paramh = ac.a(g.a.hBP(), paramh, localList, false, paramh1, paramb);
    AppMethodBeat.o(60891);
    return paramh;
  }
  
  private static boolean a(ab paramab, b<bg, Boolean> paramb, HashSet<ab> paramHashSet)
  {
    AppMethodBeat.i(60897);
    if (paramb == null) {
      atM(44);
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
    bg localbg = paramab.hLF();
    if (((Boolean)paramb.invoke(localbg)).booleanValue())
    {
      AppMethodBeat.o(60897);
      return true;
    }
    if ((localbg instanceof v)) {}
    for (Object localObject = (v)localbg; (localObject != null) && ((a(((v)localObject).TNV, paramb, paramHashSet)) || (a(((v)localObject).TNW, paramb, paramHashSet))); localObject = null)
    {
      AppMethodBeat.o(60897);
      return true;
    }
    if (((localbg instanceof l)) && (a(((l)localbg).TNE, paramb, paramHashSet)))
    {
      AppMethodBeat.o(60897);
      return true;
    }
    localObject = paramab.hKE();
    if ((localObject instanceof aa))
    {
      paramab = ((Collection)((aa)localObject).TOe).iterator();
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
    paramab = paramab.hKB().iterator();
    while (paramab.hasNext())
    {
      localObject = (av)paramab.next();
      if ((!((av)localObject).hLH()) && (a(((av)localObject).hBy(), paramb, paramHashSet)))
      {
        AppMethodBeat.o(60897);
        return true;
      }
    }
    AppMethodBeat.o(60897);
    return false;
  }
  
  public static boolean aA(ab paramab)
  {
    AppMethodBeat.i(60885);
    if (paramab == null) {
      atM(0);
    }
    if ((paramab == TON) || (paramab == TOO))
    {
      AppMethodBeat.o(60885);
      return true;
    }
    AppMethodBeat.o(60885);
    return false;
  }
  
  public static boolean aB(ab paramab)
  {
    AppMethodBeat.i(60886);
    if ((paramab != null) && (paramab.hKE() == TOL.hKE()))
    {
      AppMethodBeat.o(60886);
      return true;
    }
    AppMethodBeat.o(60886);
    return false;
  }
  
  public static ab aC(ab paramab)
  {
    AppMethodBeat.i(60887);
    if (paramab == null) {
      atM(1);
    }
    paramab = b(paramab, true);
    AppMethodBeat.o(60887);
    return paramab;
  }
  
  public static ab aD(ab paramab)
  {
    AppMethodBeat.i(60888);
    if (paramab == null) {
      atM(2);
    }
    paramab = b(paramab, false);
    AppMethodBeat.o(60888);
    return paramab;
  }
  
  public static boolean aE(ab paramab)
  {
    AppMethodBeat.i(60893);
    if (paramab == null) {
      atM(27);
    }
    if (paramab.hEa())
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if ((y.al(paramab)) && (aE(y.am(paramab).TNW)))
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if (aH(paramab))
    {
      if (paramab == null) {
        atM(29);
      }
      if (!(paramab.hKE().hzS() instanceof e))
      {
        if (paramab == null) {
          atM(18);
        }
        ba localba = ba.az(paramab);
        Object localObject = paramab.hKE().hBV();
        ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
        Iterator localIterator = ((Collection)localObject).iterator();
        label220:
        while (localIterator.hasNext())
        {
          localObject = (ab)localIterator.next();
          if (paramab == null) {
            atM(20);
          }
          if (localObject == null) {
            atM(21);
          }
          if (localba == null) {
            atM(22);
          }
          localObject = localba.c((ab)localObject, bh.TOQ);
          if (localObject != null) {}
          for (localObject = c((ab)localObject, paramab.hEa());; localObject = null)
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
          if (aE((ab)paramab.next()))
          {
            AppMethodBeat.o(60893);
            return true;
          }
        }
      }
      AppMethodBeat.o(60893);
      return false;
    }
    paramab = paramab.hKE();
    if ((paramab instanceof aa))
    {
      paramab = paramab.hBV().iterator();
      while (paramab.hasNext()) {
        if (aE((ab)paramab.next()))
        {
          AppMethodBeat.o(60893);
          return true;
        }
      }
    }
    AppMethodBeat.o(60893);
    return false;
  }
  
  public static boolean aF(ab paramab)
  {
    AppMethodBeat.i(60894);
    if (paramab == null) {
      atM(28);
    }
    if (paramab.hEa())
    {
      AppMethodBeat.o(60894);
      return true;
    }
    if ((y.al(paramab)) && (aF(y.am(paramab).TNW)))
    {
      AppMethodBeat.o(60894);
      return true;
    }
    AppMethodBeat.o(60894);
    return false;
  }
  
  public static e aG(ab paramab)
  {
    AppMethodBeat.i(60895);
    if (paramab == null) {
      atM(30);
    }
    paramab = paramab.hKE().hzS();
    if ((paramab instanceof e))
    {
      paramab = (e)paramab;
      AppMethodBeat.o(60895);
      return paramab;
    }
    AppMethodBeat.o(60895);
    return null;
  }
  
  public static boolean aH(ab paramab)
  {
    AppMethodBeat.i(60899);
    if (paramab == null) {
      atM(59);
    }
    if ((aI(paramab) != null) || ((paramab.hKE() instanceof p)))
    {
      AppMethodBeat.o(60899);
      return true;
    }
    AppMethodBeat.o(60899);
    return false;
  }
  
  private static as aI(ab paramab)
  {
    AppMethodBeat.i(60900);
    if (paramab == null) {
      atM(62);
    }
    if ((paramab.hKE().hzS() instanceof as))
    {
      paramab = (as)paramab.hKE().hzS();
      AppMethodBeat.o(60900);
      return paramab;
    }
    AppMethodBeat.o(60900);
    return null;
  }
  
  public static ab b(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(60889);
    if (paramab == null) {
      atM(3);
    }
    paramab = paramab.hLF().EF(paramBoolean);
    if (paramab == null) {
      atM(4);
    }
    AppMethodBeat.o(60889);
    return paramab;
  }
  
  public static boolean b(ab paramab, b<bg, Boolean> paramb)
  {
    AppMethodBeat.i(60896);
    if (paramb == null) {
      atM(43);
    }
    boolean bool = a(paramab, paramb, new HashSet());
    AppMethodBeat.o(60896);
    return bool;
  }
  
  public static ab c(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(60890);
    if (paramab == null) {
      atM(8);
    }
    if (paramBoolean)
    {
      paramab = aC(paramab);
      AppMethodBeat.o(60890);
      return paramab;
    }
    if (paramab == null) {
      atM(9);
    }
    AppMethodBeat.o(60890);
    return paramab;
  }
  
  public static av d(as paramas)
  {
    AppMethodBeat.i(60898);
    if (paramas == null) {
      atM(45);
    }
    paramas = new ao(paramas);
    AppMethodBeat.o(60898);
    return paramas;
  }
  
  public static List<av> kI(List<as> paramList)
  {
    AppMethodBeat.i(60892);
    if (paramList == null) {
      atM(16);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ax(((as)paramList.next()).hAG()));
    }
    paramList = j.p(localArrayList);
    if (paramList == null) {
      atM(17);
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
        atM(3);
      }
      AppMethodBeat.o(60878);
      return this;
    }
    
    public final aj EG(boolean paramBoolean)
    {
      AppMethodBeat.i(60875);
      IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
      AppMethodBeat.o(60875);
      throw localIllegalStateException;
    }
    
    public final n b(aj paramaj)
    {
      AppMethodBeat.i(60877);
      if (paramaj == null) {
        atM(2);
      }
      paramaj = new IllegalStateException(this.name);
      AppMethodBeat.o(60877);
      throw paramaj;
    }
    
    public final aj d(g paramg)
    {
      AppMethodBeat.i(60874);
      if (paramg == null) {
        atM(0);
      }
      paramg = new IllegalStateException(this.name);
      AppMethodBeat.o(60874);
      throw paramg;
    }
    
    protected final aj hDW()
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
        atM(1);
      }
      AppMethodBeat.o(60876);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bc
 * JD-Core Version:    0.7.0.1
 */