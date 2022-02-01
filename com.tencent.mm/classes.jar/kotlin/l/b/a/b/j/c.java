package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l.b.a.b.a.m;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.u;

public class c
{
  public static final kotlin.l.b.a.b.f.b THA;
  public static final kotlin.l.b.a.b.f.b THB;
  public static final kotlin.l.b.a.b.f.f THt;
  public static final kotlin.l.b.a.b.f.f THu;
  public static final kotlin.l.b.a.b.f.b THv;
  public static final kotlin.l.b.a.b.f.b THw;
  public static final kotlin.l.b.a.b.f.b THx;
  public static final kotlin.l.b.a.b.f.b THy;
  public static final kotlin.l.b.a.b.f.b THz;
  
  static
  {
    AppMethodBeat.i(59932);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      THt = kotlin.l.b.a.b.f.f.btY("values");
      THu = kotlin.l.b.a.b.f.f.btY("valueOf");
      kotlin.l.b.a.b.f.b localb = new kotlin.l.b.a.b.f.b("kotlin.coroutines");
      THv = localb;
      localb = localb.p(kotlin.l.b.a.b.f.f.btY("experimental"));
      THw = localb;
      THx = localb.p(kotlin.l.b.a.b.f.f.btY("intrinsics"));
      THy = THw.p(kotlin.l.b.a.b.f.f.btY("Continuation"));
      THz = THv.p(kotlin.l.b.a.b.f.f.btY("Continuation"));
      THA = new kotlin.l.b.a.b.f.b("kotlin.Result");
      THB = new kotlin.l.b.a.b.f.b("kotlin.jvm.JvmName");
      AppMethodBeat.o(59932);
      return;
    }
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(59919);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.Thf);
    AppMethodBeat.o(59919);
    return bool;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(59920);
    if ((a(paraml, kotlin.l.b.a.b.b.f.The)) || (a(paraml, kotlin.l.b.a.b.b.f.Thg)))
    {
      AppMethodBeat.o(59920);
      return true;
    }
    AppMethodBeat.o(59920);
    return false;
  }
  
  public static ao C(l paraml)
  {
    AppMethodBeat.i(59931);
    if (paraml == null) {
      atM(74);
    }
    if ((paraml instanceof aj)) {
      paraml = ((aj)paraml).hBm();
    }
    for (;;)
    {
      if ((paraml instanceof o))
      {
        paraml = ((o)paraml).hzM().hBu();
        if (paraml == null) {
          atM(75);
        }
        AppMethodBeat.o(59931);
        return paraml;
      }
      paraml = ao.ThL;
      if (paraml == null) {
        atM(76);
      }
      AppMethodBeat.o(59931);
      return paraml;
    }
  }
  
  public static y Y(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59906);
    if (paramab == null) {
      atM(18);
    }
    paramab = paramab.hKE().hzS();
    if (paramab == null)
    {
      AppMethodBeat.o(59906);
      return null;
    }
    paramab = t(paramab);
    AppMethodBeat.o(59906);
    return paramab;
  }
  
  public static e Z(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59923);
    if (paramab == null) {
      atM(43);
    }
    paramab = b(paramab.hKE());
    AppMethodBeat.o(59923);
    return paramab;
  }
  
  public static <D extends l> D a(l paraml, Class<D> paramClass)
  {
    AppMethodBeat.i(59904);
    paraml = a(paraml, paramClass, true);
    AppMethodBeat.o(59904);
    return paraml;
  }
  
  public static <D extends l> D a(l paraml, Class<D> paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(59905);
    if (paramClass == null) {
      atM(17);
    }
    if (paraml == null)
    {
      AppMethodBeat.o(59905);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.hzx();
    }
    for (;;)
    {
      if (paraml != null)
      {
        if (paramClass.isInstance(paraml))
        {
          AppMethodBeat.o(59905);
          return paraml;
        }
        paraml = paraml.hzx();
      }
      else
      {
        AppMethodBeat.o(59905);
        return null;
      }
    }
  }
  
  public static <D extends p> D a(D paramD)
  {
    AppMethodBeat.i(59927);
    if (paramD == null) {
      atM(57);
    }
    if ((paramD instanceof kotlin.l.b.a.b.b.b))
    {
      paramD = t((kotlin.l.b.a.b.b.b)paramD);
      AppMethodBeat.o(59927);
      return paramD;
    }
    if (paramD == null) {
      atM(58);
    }
    AppMethodBeat.o(59927);
    return paramD;
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(59930);
    if (paramD == null) {
      atM(66);
    }
    if (paramSet == null) {
      atM(67);
    }
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(59930);
      return;
    }
    paramD = paramD.hAv().hAy().iterator();
    while (paramD.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = ((kotlin.l.b.a.b.b.a)paramD.next()).hAv();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(59930);
  }
  
  public static boolean a(ax paramax, kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59928);
    if (paramax == null) {
      atM(59);
    }
    if (paramab == null) {
      atM(60);
    }
    if ((paramax.hBF()) || (kotlin.l.b.a.b.m.ad.ap(paramab)))
    {
      AppMethodBeat.o(59928);
      return false;
    }
    if (bc.aF(paramab))
    {
      AppMethodBeat.o(59928);
      return true;
    }
    paramax = kotlin.l.b.a.b.j.d.a.G(paramax);
    if ((!kotlin.l.b.a.b.a.g.o(paramab)) && (!kotlin.l.b.a.b.m.a.g.TPc.d(paramax.hzr(), paramab)) && (!kotlin.l.b.a.b.m.a.g.TPc.d(paramax.btz("Number").hAG(), paramab)) && (!kotlin.l.b.a.b.m.a.g.TPc.d(paramax.hzi(), paramab)))
    {
      paramax = m.Tfo;
      if (!m.E(paramab)) {}
    }
    else
    {
      AppMethodBeat.o(59928);
      return true;
    }
    AppMethodBeat.o(59928);
    return false;
  }
  
  private static boolean a(l paraml, kotlin.l.b.a.b.b.f paramf)
  {
    AppMethodBeat.i(59921);
    if (paramf == null) {
      atM(35);
    }
    if (((paraml instanceof e)) && (((e)paraml).hzB() == paramf))
    {
      AppMethodBeat.o(59921);
      return true;
    }
    AppMethodBeat.o(59921);
    return false;
  }
  
  private static boolean a(kotlin.l.b.a.b.m.ab paramab, l paraml)
  {
    AppMethodBeat.i(59911);
    if (paramab == null) {
      atM(28);
    }
    if (paraml == null) {
      atM(29);
    }
    paramab = paramab.hKE().hzS();
    if (paramab != null)
    {
      paramab = paramab.hAE();
      if (((paramab instanceof kotlin.l.b.a.b.b.h)) && ((paraml instanceof kotlin.l.b.a.b.b.h)) && (((kotlin.l.b.a.b.b.h)paraml).hzz().equals(((kotlin.l.b.a.b.b.h)paramab).hzz())))
      {
        AppMethodBeat.o(59911);
        return true;
      }
    }
    AppMethodBeat.o(59911);
    return false;
  }
  
  private static e b(at paramat)
  {
    AppMethodBeat.i(59924);
    if (paramat == null) {
      atM(44);
    }
    kotlin.l.b.a.b.b.h localh = paramat.hzS();
    if ((!$assertionsDisabled) && (!(localh instanceof e)))
    {
      paramat = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paramat)));
      AppMethodBeat.o(59924);
      throw paramat;
    }
    paramat = (e)localh;
    if (paramat == null) {
      atM(45);
    }
    AppMethodBeat.o(59924);
    return paramat;
  }
  
  public static boolean b(e parame1, e parame2)
  {
    AppMethodBeat.i(59909);
    if (parame1 == null) {
      atM(24);
    }
    if (parame2 == null) {
      atM(25);
    }
    parame1 = parame1.hzz().hBV().iterator();
    while (parame1.hasNext()) {
      if (a((kotlin.l.b.a.b.m.ab)parame1.next(), parame2.hAP()))
      {
        AppMethodBeat.o(59909);
        return true;
      }
    }
    AppMethodBeat.o(59909);
    return false;
  }
  
  public static boolean b(kotlin.l.b.a.b.m.ab paramab, l paraml)
  {
    AppMethodBeat.i(59912);
    if (paramab == null) {
      atM(30);
    }
    if (paraml == null) {
      atM(31);
    }
    if (a(paramab, paraml))
    {
      AppMethodBeat.o(59912);
      return true;
    }
    paramab = paramab.hKE().hBV().iterator();
    while (paramab.hasNext()) {
      if (b((kotlin.l.b.a.b.m.ab)paramab.next(), paraml))
      {
        AppMethodBeat.o(59912);
        return true;
      }
    }
    AppMethodBeat.o(59912);
    return false;
  }
  
  public static boolean c(e parame1, e parame2)
  {
    AppMethodBeat.i(59910);
    if (parame1 == null) {
      atM(26);
    }
    if (parame2 == null) {
      atM(27);
    }
    boolean bool = b(parame1.hAG(), parame2.hAP());
    AppMethodBeat.o(59910);
    return bool;
  }
  
  public static boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(59903);
    if (paraml1 == null) {
      atM(14);
    }
    if (paraml2 == null) {
      atM(15);
    }
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static <D extends kotlin.l.b.a.b.b.a> Set<D> e(D paramD)
  {
    AppMethodBeat.i(59929);
    if (paramD == null) {
      atM(64);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.hAv(), localLinkedHashSet);
    AppMethodBeat.o(59929);
    return localLinkedHashSet;
  }
  
  public static ak l(l paraml)
  {
    AppMethodBeat.i(59896);
    if (paraml == null) {
      atM(0);
    }
    if ((paraml instanceof e))
    {
      paraml = ((e)paraml).hAO();
      AppMethodBeat.o(59896);
      return paraml;
    }
    AppMethodBeat.o(59896);
    return null;
  }
  
  public static boolean m(l paraml)
  {
    AppMethodBeat.i(59897);
    if (paraml == null) {
      atM(1);
    }
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof p)) || (((p)paraml).hzE() != az.ThV)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(59897);
        return true;
      }
      paraml = paraml.hzx();
    }
    AppMethodBeat.o(59897);
    return false;
  }
  
  public static kotlin.l.b.a.b.f.c n(l paraml)
  {
    AppMethodBeat.i(59898);
    if (paraml == null) {
      atM(2);
    }
    kotlin.l.b.a.b.f.b localb = p(paraml);
    if (localb != null)
    {
      paraml = localb.hJe();
      AppMethodBeat.o(59898);
      return paraml;
    }
    paraml = q(paraml);
    AppMethodBeat.o(59898);
    return paraml;
  }
  
  public static kotlin.l.b.a.b.f.b o(l paraml)
  {
    AppMethodBeat.i(59899);
    if (paraml == null) {
      atM(3);
    }
    kotlin.l.b.a.b.f.b localb = p(paraml);
    if (localb != null) {}
    for (paraml = localb;; paraml = q(paraml).hJj())
    {
      if (paraml == null) {
        atM(4);
      }
      AppMethodBeat.o(59899);
      return paraml;
    }
  }
  
  private static kotlin.l.b.a.b.f.b p(l paraml)
  {
    AppMethodBeat.i(59900);
    if (paraml == null) {
      atM(5);
    }
    if (((paraml instanceof y)) || (u.L(paraml)))
    {
      paraml = kotlin.l.b.a.b.f.b.TCQ;
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.b.ad))
    {
      paraml = ((kotlin.l.b.a.b.b.ad)paraml).hBk();
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.b.ab))
    {
      paraml = ((kotlin.l.b.a.b.b.ab)paraml).hBk();
      AppMethodBeat.o(59900);
      return paraml;
    }
    AppMethodBeat.o(59900);
    return null;
  }
  
  private static kotlin.l.b.a.b.f.c q(l paraml)
  {
    AppMethodBeat.i(59901);
    if (paraml == null) {
      atM(6);
    }
    l locall = paraml.hzx();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59901);
      throw paraml;
    }
    paraml = n(locall).s(paraml.hAH());
    AppMethodBeat.o(59901);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(59902);
    if ((paraml != null) && ((paraml.hzx() instanceof kotlin.l.b.a.b.b.ab)))
    {
      AppMethodBeat.o(59902);
      return true;
    }
    AppMethodBeat.o(59902);
    return false;
  }
  
  public static y s(l paraml)
  {
    AppMethodBeat.i(59907);
    if (paraml == null) {
      atM(19);
    }
    y localy = t(paraml);
    if ((!$assertionsDisabled) && (localy == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59907);
      throw paraml;
    }
    if (localy == null) {
      atM(20);
    }
    AppMethodBeat.o(59907);
    return localy;
  }
  
  public static <D extends kotlin.l.b.a.b.b.b> D t(D paramD)
  {
    AppMethodBeat.i(59926);
    Object localObject = paramD;
    if (paramD == null) {
      atM(55);
    }
    for (localObject = paramD; ((kotlin.l.b.a.b.b.b)localObject).hAA() == b.a.TgX; localObject = (kotlin.l.b.a.b.b.b)paramD.iterator().next())
    {
      paramD = ((kotlin.l.b.a.b.b.b)localObject).hAy();
      if (paramD.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(59926);
        throw paramD;
      }
    }
    if (localObject == null) {
      atM(56);
    }
    AppMethodBeat.o(59926);
    return localObject;
  }
  
  private static y t(l paraml)
  {
    AppMethodBeat.i(59908);
    if (paraml == null) {
      atM(21);
    }
    while (paraml != null)
    {
      if ((paraml instanceof y))
      {
        paraml = (y)paraml;
        AppMethodBeat.o(59908);
        return paraml;
      }
      if ((paraml instanceof kotlin.l.b.a.b.b.ad))
      {
        paraml = ((kotlin.l.b.a.b.b.ad)paraml).hBl();
        AppMethodBeat.o(59908);
        return paraml;
      }
      paraml = paraml.hzx();
    }
    AppMethodBeat.o(59908);
    return null;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(59913);
    if ((a(paraml, kotlin.l.b.a.b.b.f.Thj)) && (((e)paraml).hzF()))
    {
      AppMethodBeat.o(59913);
      return true;
    }
    AppMethodBeat.o(59913);
    return false;
  }
  
  public static boolean v(l paraml)
  {
    AppMethodBeat.i(59914);
    if ((a(paraml, kotlin.l.b.a.b.b.f.The)) && (((e)paraml).hzC() == w.Thp))
    {
      AppMethodBeat.o(59914);
      return true;
    }
    AppMethodBeat.o(59914);
    return false;
  }
  
  private static boolean w(l paraml)
  {
    AppMethodBeat.i(59915);
    if (paraml == null) {
      atM(32);
    }
    if ((a(paraml, kotlin.l.b.a.b.b.f.The)) && (paraml.hAH().equals(kotlin.l.b.a.b.f.h.TDd)))
    {
      AppMethodBeat.o(59915);
      return true;
    }
    AppMethodBeat.o(59915);
    return false;
  }
  
  public static boolean x(l paraml)
  {
    AppMethodBeat.i(59916);
    if (paraml == null) {
      atM(34);
    }
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.Thh);
    AppMethodBeat.o(59916);
    return bool;
  }
  
  public static e y(e parame)
  {
    AppMethodBeat.i(59922);
    if (parame == null) {
      atM(42);
    }
    parame = parame.hzz().hBV().iterator();
    while (parame.hasNext())
    {
      e locale = Z((kotlin.l.b.a.b.m.ab)parame.next());
      if (locale.hzB() != kotlin.l.b.a.b.b.f.Thf)
      {
        AppMethodBeat.o(59922);
        return locale;
      }
    }
    AppMethodBeat.o(59922);
    return null;
  }
  
  public static boolean y(l paraml)
  {
    AppMethodBeat.i(59917);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.Thg);
    AppMethodBeat.o(59917);
    return bool;
  }
  
  public static ba z(e parame)
  {
    AppMethodBeat.i(59925);
    if (parame == null) {
      atM(46);
    }
    kotlin.l.b.a.b.b.f localf = parame.hzB();
    if ((localf == kotlin.l.b.a.b.b.f.Thg) || (localf.hAQ()) || (v(parame)))
    {
      parame = az.ThQ;
      if (parame == null) {
        atM(47);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if (w(parame))
    {
      parame = az.Tib;
      if (parame == null) {
        atM(48);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != kotlin.l.b.a.b.b.f.The) && (localf != kotlin.l.b.a.b.b.f.Thf) && (localf != kotlin.l.b.a.b.b.f.Thi))
    {
      parame = new AssertionError();
      AppMethodBeat.o(59925);
      throw parame;
    }
    parame = az.ThU;
    if (parame == null) {
      atM(49);
    }
    AppMethodBeat.o(59925);
    return parame;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(59918);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.Thi);
    AppMethodBeat.o(59918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.c
 * JD-Core Version:    0.7.0.1
 */