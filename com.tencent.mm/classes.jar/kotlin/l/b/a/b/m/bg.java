package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.a.n;
import kotlin.l.b.a.b.o.f;

public class bg
{
  public static final al ajqF;
  public static final al ajqG;
  public static final al ajqH;
  public static final al ajqI;
  
  static
  {
    AppMethodBeat.i(60901);
    if (!bg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajqF = v.bJu("DONT_CARE");
      ajqG = v.bJt("Cannot be inferred");
      ajqH = new a("NO_EXPECTED_TYPE");
      ajqI = new a("UNIT_EXPECTED_TYPE");
      AppMethodBeat.o(60901);
      return;
    }
  }
  
  public static al a(kotlin.l.b.a.b.b.h paramh, kotlin.l.b.a.b.j.g.h paramh1, b<kotlin.l.b.a.b.m.a.g, al> paramb)
  {
    AppMethodBeat.i(60891);
    if (v.L(paramh))
    {
      paramh = v.bJt("Unsubstituted type for ".concat(String.valueOf(paramh)));
      if (paramh == null) {
        aKu(11);
      }
      AppMethodBeat.o(60891);
      return paramh;
    }
    paramh = a(paramh.kmZ(), paramh1, paramb);
    AppMethodBeat.o(60891);
    return paramh;
  }
  
  public static al a(ax paramax, kotlin.l.b.a.b.j.g.h paramh, b<kotlin.l.b.a.b.m.a.g, al> paramb)
  {
    AppMethodBeat.i(191594);
    if (paramax == null) {
      aKu(12);
    }
    if (paramh == null) {
      aKu(13);
    }
    if (paramb == null) {
      aKu(14);
    }
    List localList = pe(paramax.klq());
    g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
    paramax = ae.a(g.a.kpB(), paramax, localList, false, paramh, paramb);
    if (paramax == null) {
      aKu(15);
    }
    AppMethodBeat.o(191594);
    return paramax;
  }
  
  public static boolean a(ad paramad, b<bk, Boolean> paramb)
  {
    AppMethodBeat.i(60896);
    if (paramb == null) {
      aKu(43);
    }
    boolean bool = a(paramad, paramb, null, null);
    AppMethodBeat.o(60896);
    return bool;
  }
  
  public static boolean a(ad paramad, b<bk, Boolean> paramb, b<ad, Boolean> paramb1)
  {
    AppMethodBeat.i(191616);
    if (paramb == null) {
      aKu(44);
    }
    if (paramb1 == null) {
      aKu(45);
    }
    boolean bool = a(paramad, paramb, paramb1, null);
    AppMethodBeat.o(191616);
    return bool;
  }
  
  private static boolean a(ad paramad, b<bk, Boolean> paramb, b<ad, Boolean> paramb1, f<ad> paramf)
  {
    AppMethodBeat.i(191619);
    if (paramb == null) {
      aKu(46);
    }
    if (paramad == null)
    {
      AppMethodBeat.o(191619);
      return false;
    }
    bk localbk = paramad.kAK();
    if (ar(paramad))
    {
      boolean bool = ((Boolean)paramb.invoke(localbk)).booleanValue();
      AppMethodBeat.o(191619);
      return bool;
    }
    if ((paramf != null) && (paramf.contains(paramad)))
    {
      AppMethodBeat.o(191619);
      return false;
    }
    if (((Boolean)paramb.invoke(localbk)).booleanValue())
    {
      AppMethodBeat.o(191619);
      return true;
    }
    if ((paramb1 != null) && (((Boolean)paramb1.invoke(localbk)).booleanValue()))
    {
      AppMethodBeat.o(191619);
      return false;
    }
    Object localObject = paramf;
    if (paramf == null) {
      localObject = f.kBe();
    }
    ((f)localObject).add(paramad);
    if ((localbk instanceof x)) {}
    for (paramf = (x)localbk; (paramf != null) && ((a(paramf.ajpE, paramb, paramb1, (f)localObject)) || (a(paramf.ajpF, paramb, paramb1, (f)localObject))); paramf = null)
    {
      AppMethodBeat.o(191619);
      return true;
    }
    if (((localbk instanceof m)) && (a(((m)localbk).ajpp, paramb, paramb1, (f)localObject)))
    {
      AppMethodBeat.o(191619);
      return true;
    }
    paramf = paramad.kzm();
    if ((paramf instanceof ac))
    {
      paramad = ((Collection)((ac)paramf).ajpO).iterator();
      while (paramad.hasNext()) {
        if (a((ad)paramad.next(), paramb, paramb1, (f)localObject))
        {
          AppMethodBeat.o(191619);
          return true;
        }
      }
      AppMethodBeat.o(191619);
      return false;
    }
    paramad = paramad.klR().iterator();
    while (paramad.hasNext())
    {
      paramf = (az)paramad.next();
      if ((!paramf.kAM()) && (a(paramf.koG(), paramb, paramb1, (f)localObject)))
      {
        AppMethodBeat.o(191619);
        return true;
      }
    }
    AppMethodBeat.o(191619);
    return false;
  }
  
  public static boolean aA(ad paramad)
  {
    AppMethodBeat.i(60899);
    if (paramad == null) {
      aKu(61);
    }
    if ((aB(paramad) != null) || ((paramad.kzm() instanceof n)))
    {
      AppMethodBeat.o(60899);
      return true;
    }
    AppMethodBeat.o(60899);
    return false;
  }
  
  private static ba aB(ad paramad)
  {
    AppMethodBeat.i(60900);
    if (paramad == null) {
      aKu(64);
    }
    if ((paramad.kzm().knA() instanceof ba))
    {
      paramad = (ba)paramad.kzm().knA();
      AppMethodBeat.o(60900);
      return paramad;
    }
    AppMethodBeat.o(60900);
    return null;
  }
  
  public static boolean ar(ad paramad)
  {
    AppMethodBeat.i(60885);
    if (paramad == null) {
      aKu(0);
    }
    if ((paramad == ajqH) || (paramad == ajqI))
    {
      AppMethodBeat.o(60885);
      return true;
    }
    AppMethodBeat.o(60885);
    return false;
  }
  
  public static boolean as(ad paramad)
  {
    AppMethodBeat.i(60886);
    if ((paramad != null) && (paramad.kzm() == ajqF.kzm()))
    {
      AppMethodBeat.o(60886);
      return true;
    }
    AppMethodBeat.o(60886);
    return false;
  }
  
  public static ad at(ad paramad)
  {
    AppMethodBeat.i(60887);
    if (paramad == null) {
      aKu(1);
    }
    paramad = b(paramad, true);
    AppMethodBeat.o(60887);
    return paramad;
  }
  
  public static ad au(ad paramad)
  {
    AppMethodBeat.i(60888);
    if (paramad == null) {
      aKu(2);
    }
    paramad = b(paramad, false);
    AppMethodBeat.o(60888);
    return paramad;
  }
  
  private static List<ad> av(ad paramad)
  {
    AppMethodBeat.i(191603);
    if (paramad == null) {
      aKu(18);
    }
    be localbe = be.aq(paramad);
    Object localObject = paramad.kzm().kpG();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    Iterator localIterator = ((Collection)localObject).iterator();
    label140:
    while (localIterator.hasNext())
    {
      localObject = (ad)localIterator.next();
      if (paramad == null) {
        aKu(20);
      }
      if (localObject == null) {
        aKu(21);
      }
      if (localbe == null) {
        aKu(22);
      }
      localObject = localbe.c((ad)localObject, bl.ajqM);
      if (localObject != null) {}
      for (localObject = c((ad)localObject, paramad.ksB());; localObject = null)
      {
        if (localObject == null) {
          break label140;
        }
        localArrayList.add(localObject);
        break;
      }
    }
    AppMethodBeat.o(191603);
    return localArrayList;
  }
  
  public static boolean aw(ad paramad)
  {
    AppMethodBeat.i(60893);
    if (paramad == null) {
      aKu(27);
    }
    if (paramad.ksB())
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if ((aa.ac(paramad)) && (aw(aa.ad(paramad).ajpF)))
    {
      AppMethodBeat.o(60893);
      return true;
    }
    if (ao.ak(paramad))
    {
      AppMethodBeat.o(60893);
      return false;
    }
    if (aA(paramad))
    {
      boolean bool = ay(paramad);
      AppMethodBeat.o(60893);
      return bool;
    }
    if ((paramad instanceof e))
    {
      paramad = ((n)((e)paramad).ajoR).kAW();
      if ((paramad == null) || (ay(paramad.koj())))
      {
        AppMethodBeat.o(60893);
        return true;
      }
      AppMethodBeat.o(60893);
      return false;
    }
    paramad = paramad.kzm();
    if ((paramad instanceof ac))
    {
      paramad = paramad.kpG().iterator();
      while (paramad.hasNext()) {
        if (aw((ad)paramad.next()))
        {
          AppMethodBeat.o(60893);
          return true;
        }
      }
    }
    AppMethodBeat.o(60893);
    return false;
  }
  
  public static boolean ax(ad paramad)
  {
    AppMethodBeat.i(60894);
    if (paramad == null) {
      aKu(28);
    }
    if (paramad.ksB())
    {
      AppMethodBeat.o(60894);
      return true;
    }
    if ((aa.ac(paramad)) && (ax(aa.ad(paramad).ajpF)))
    {
      AppMethodBeat.o(60894);
      return true;
    }
    AppMethodBeat.o(60894);
    return false;
  }
  
  private static boolean ay(ad paramad)
  {
    AppMethodBeat.i(191608);
    if (paramad == null) {
      aKu(29);
    }
    if ((paramad.kzm().knA() instanceof kotlin.l.b.a.b.b.e))
    {
      AppMethodBeat.o(191608);
      return false;
    }
    paramad = av(paramad).iterator();
    while (paramad.hasNext()) {
      if (aw((ad)paramad.next()))
      {
        AppMethodBeat.o(191608);
        return true;
      }
    }
    AppMethodBeat.o(191608);
    return false;
  }
  
  public static kotlin.l.b.a.b.b.e az(ad paramad)
  {
    AppMethodBeat.i(60895);
    if (paramad == null) {
      aKu(30);
    }
    paramad = paramad.kzm().knA();
    if ((paramad instanceof kotlin.l.b.a.b.b.e))
    {
      paramad = (kotlin.l.b.a.b.b.e)paramad;
      AppMethodBeat.o(60895);
      return paramad;
    }
    AppMethodBeat.o(60895);
    return null;
  }
  
  public static ad b(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(60889);
    if (paramad == null) {
      aKu(3);
    }
    paramad = paramad.kAK().Pp(paramBoolean);
    if (paramad == null) {
      aKu(4);
    }
    AppMethodBeat.o(60889);
    return paramad;
  }
  
  public static al b(al paramal, boolean paramBoolean)
  {
    AppMethodBeat.i(191587);
    if (paramal == null) {
      aKu(5);
    }
    if (paramBoolean)
    {
      paramal = paramal.Pq(true);
      if (paramal == null) {
        aKu(6);
      }
      AppMethodBeat.o(191587);
      return paramal;
    }
    if (paramal == null) {
      aKu(7);
    }
    AppMethodBeat.o(191587);
    return paramal;
  }
  
  public static ad c(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(60890);
    if (paramad == null) {
      aKu(8);
    }
    if (paramBoolean)
    {
      paramad = at(paramad);
      AppMethodBeat.o(60890);
      return paramad;
    }
    if (paramad == null) {
      aKu(9);
    }
    AppMethodBeat.o(60890);
    return paramad;
  }
  
  public static az c(ba paramba)
  {
    AppMethodBeat.i(60898);
    if (paramba == null) {
      aKu(47);
    }
    paramba = new aq(paramba);
    AppMethodBeat.o(60898);
    return paramba;
  }
  
  public static List<az> pe(List<ba> paramList)
  {
    AppMethodBeat.i(60892);
    if (paramList == null) {
      aKu(16);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new bb(((ba)paramList.next()).koj()));
    }
    paramList = p.p(localArrayList);
    if (paramList == null) {
      aKu(17);
    }
    AppMethodBeat.o(60892);
    return paramList;
  }
  
  public static final class a
    extends o
  {
    private final String name;
    
    public a(String paramString)
    {
      this.name = paramString;
    }
    
    private a p(kotlin.l.b.a.b.m.a.g paramg)
    {
      AppMethodBeat.i(60878);
      if (paramg == null) {
        aKu(3);
      }
      AppMethodBeat.o(60878);
      return this;
    }
    
    public final al Pq(boolean paramBoolean)
    {
      AppMethodBeat.i(60875);
      IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
      AppMethodBeat.o(60875);
      throw localIllegalStateException;
    }
    
    public final o c(al paramal)
    {
      AppMethodBeat.i(60877);
      if (paramal == null) {
        aKu(2);
      }
      paramal = new IllegalStateException(this.name);
      AppMethodBeat.o(60877);
      throw paramal;
    }
    
    public final al d(kotlin.l.b.a.b.b.a.g paramg)
    {
      AppMethodBeat.i(60874);
      if (paramg == null) {
        aKu(0);
      }
      paramg = new IllegalStateException(this.name);
      AppMethodBeat.o(60874);
      throw paramg;
    }
    
    protected final al ksx()
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
        aKu(1);
      }
      AppMethodBeat.o(60876);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bg
 * JD-Core Version:    0.7.0.1
 */