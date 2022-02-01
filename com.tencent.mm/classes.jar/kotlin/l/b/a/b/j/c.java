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
  public static final kotlin.l.b.a.b.f.f abjX;
  public static final kotlin.l.b.a.b.f.f abjY;
  public static final kotlin.l.b.a.b.f.b abjZ;
  public static final kotlin.l.b.a.b.f.b abka;
  public static final kotlin.l.b.a.b.f.b abkb;
  public static final kotlin.l.b.a.b.f.b abkc;
  public static final kotlin.l.b.a.b.f.b abkd;
  public static final kotlin.l.b.a.b.f.b abke;
  public static final kotlin.l.b.a.b.f.b abkf;
  
  static
  {
    AppMethodBeat.i(59932);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      abjX = kotlin.l.b.a.b.f.f.bHb("values");
      abjY = kotlin.l.b.a.b.f.f.bHb("valueOf");
      kotlin.l.b.a.b.f.b localb = new kotlin.l.b.a.b.f.b("kotlin.coroutines");
      abjZ = localb;
      localb = localb.p(kotlin.l.b.a.b.f.f.bHb("experimental"));
      abka = localb;
      abkb = localb.p(kotlin.l.b.a.b.f.f.bHb("intrinsics"));
      abkc = abka.p(kotlin.l.b.a.b.f.f.bHb("Continuation"));
      abkd = abjZ.p(kotlin.l.b.a.b.f.f.bHb("Continuation"));
      abke = new kotlin.l.b.a.b.f.b("kotlin.Result");
      abkf = new kotlin.l.b.a.b.f.b("kotlin.jvm.JvmName");
      AppMethodBeat.o(59932);
      return;
    }
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(59919);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aaJZ);
    AppMethodBeat.o(59919);
    return bool;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(59920);
    if ((a(paraml, kotlin.l.b.a.b.b.f.aaJY)) || (a(paraml, kotlin.l.b.a.b.b.f.aaKa)))
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
      aDG(74);
    }
    if ((paraml instanceof aj)) {
      paraml = ((aj)paraml).iFB();
    }
    for (;;)
    {
      if ((paraml instanceof o))
      {
        paraml = ((o)paraml).iDZ().iFJ();
        if (paraml == null) {
          aDG(75);
        }
        AppMethodBeat.o(59931);
        return paraml;
      }
      paraml = ao.aaKF;
      if (paraml == null) {
        aDG(76);
      }
      AppMethodBeat.o(59931);
      return paraml;
    }
  }
  
  public static y Y(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59906);
    if (paramab == null) {
      aDG(18);
    }
    paramab = paramab.iOU().iEf();
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
      aDG(43);
    }
    paramab = b(paramab.iOU());
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
      aDG(17);
    }
    if (paraml == null)
    {
      AppMethodBeat.o(59905);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.iDJ();
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
        paraml = paraml.iDJ();
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
      aDG(57);
    }
    if ((paramD instanceof kotlin.l.b.a.b.b.b))
    {
      paramD = t((kotlin.l.b.a.b.b.b)paramD);
      AppMethodBeat.o(59927);
      return paramD;
    }
    if (paramD == null) {
      aDG(58);
    }
    AppMethodBeat.o(59927);
    return paramD;
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(59930);
    if (paramD == null) {
      aDG(66);
    }
    if (paramSet == null) {
      aDG(67);
    }
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(59930);
      return;
    }
    paramD = paramD.iEI().iEL().iterator();
    while (paramD.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = ((kotlin.l.b.a.b.b.a)paramD.next()).iEI();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(59930);
  }
  
  public static boolean a(ax paramax, kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59928);
    if (paramax == null) {
      aDG(59);
    }
    if (paramab == null) {
      aDG(60);
    }
    if ((paramax.iFU()) || (kotlin.l.b.a.b.m.ad.ap(paramab)))
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
    if ((!kotlin.l.b.a.b.a.g.o(paramab)) && (!kotlin.l.b.a.b.m.a.g.abrB.d(paramax.iDD(), paramab)) && (!kotlin.l.b.a.b.m.a.g.abrB.d(paramax.bGC("Number").iET(), paramab)) && (!kotlin.l.b.a.b.m.a.g.abrB.d(paramax.iDu(), paramab)))
    {
      paramax = m.aaIi;
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
      aDG(35);
    }
    if (((paraml instanceof e)) && (((e)paraml).iDN() == paramf))
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
      aDG(28);
    }
    if (paraml == null) {
      aDG(29);
    }
    paramab = paramab.iOU().iEf();
    if (paramab != null)
    {
      paramab = paramab.iER();
      if (((paramab instanceof kotlin.l.b.a.b.b.h)) && ((paraml instanceof kotlin.l.b.a.b.b.h)) && (((kotlin.l.b.a.b.b.h)paraml).iDL().equals(((kotlin.l.b.a.b.b.h)paramab).iDL())))
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
      aDG(44);
    }
    kotlin.l.b.a.b.b.h localh = paramat.iEf();
    if ((!$assertionsDisabled) && (!(localh instanceof e)))
    {
      paramat = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paramat)));
      AppMethodBeat.o(59924);
      throw paramat;
    }
    paramat = (e)localh;
    if (paramat == null) {
      aDG(45);
    }
    AppMethodBeat.o(59924);
    return paramat;
  }
  
  public static boolean b(e parame1, e parame2)
  {
    AppMethodBeat.i(59909);
    if (parame1 == null) {
      aDG(24);
    }
    if (parame2 == null) {
      aDG(25);
    }
    parame1 = parame1.iDL().iGk().iterator();
    while (parame1.hasNext()) {
      if (a((kotlin.l.b.a.b.m.ab)parame1.next(), parame2.iFc()))
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
      aDG(30);
    }
    if (paraml == null) {
      aDG(31);
    }
    if (a(paramab, paraml))
    {
      AppMethodBeat.o(59912);
      return true;
    }
    paramab = paramab.iOU().iGk().iterator();
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
      aDG(26);
    }
    if (parame2 == null) {
      aDG(27);
    }
    boolean bool = b(parame1.iET(), parame2.iFc());
    AppMethodBeat.o(59910);
    return bool;
  }
  
  public static boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(59903);
    if (paraml1 == null) {
      aDG(14);
    }
    if (paraml2 == null) {
      aDG(15);
    }
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static <D extends kotlin.l.b.a.b.b.a> Set<D> e(D paramD)
  {
    AppMethodBeat.i(59929);
    if (paramD == null) {
      aDG(64);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.iEI(), localLinkedHashSet);
    AppMethodBeat.o(59929);
    return localLinkedHashSet;
  }
  
  public static ak l(l paraml)
  {
    AppMethodBeat.i(59896);
    if (paraml == null) {
      aDG(0);
    }
    if ((paraml instanceof e))
    {
      paraml = ((e)paraml).iFb();
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
      aDG(1);
    }
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof p)) || (((p)paraml).iDQ() != az.aaKP)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(59897);
        return true;
      }
      paraml = paraml.iDJ();
    }
    AppMethodBeat.o(59897);
    return false;
  }
  
  public static kotlin.l.b.a.b.f.c n(l paraml)
  {
    AppMethodBeat.i(59898);
    if (paraml == null) {
      aDG(2);
    }
    kotlin.l.b.a.b.f.b localb = p(paraml);
    if (localb != null)
    {
      paraml = localb.iNy();
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
      aDG(3);
    }
    kotlin.l.b.a.b.f.b localb = p(paraml);
    if (localb != null) {}
    for (paraml = localb;; paraml = q(paraml).iND())
    {
      if (paraml == null) {
        aDG(4);
      }
      AppMethodBeat.o(59899);
      return paraml;
    }
  }
  
  private static kotlin.l.b.a.b.f.b p(l paraml)
  {
    AppMethodBeat.i(59900);
    if (paraml == null) {
      aDG(5);
    }
    if (((paraml instanceof y)) || (u.L(paraml)))
    {
      paraml = kotlin.l.b.a.b.f.b.abfD;
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.b.ad))
    {
      paraml = ((kotlin.l.b.a.b.b.ad)paraml).iFy();
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.b.ab))
    {
      paraml = ((kotlin.l.b.a.b.b.ab)paraml).iFy();
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
      aDG(6);
    }
    l locall = paraml.iDJ();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59901);
      throw paraml;
    }
    paraml = n(locall).s(paraml.iEU());
    AppMethodBeat.o(59901);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(59902);
    if ((paraml != null) && ((paraml.iDJ() instanceof kotlin.l.b.a.b.b.ab)))
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
      aDG(19);
    }
    y localy = t(paraml);
    if ((!$assertionsDisabled) && (localy == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59907);
      throw paraml;
    }
    if (localy == null) {
      aDG(20);
    }
    AppMethodBeat.o(59907);
    return localy;
  }
  
  public static <D extends kotlin.l.b.a.b.b.b> D t(D paramD)
  {
    AppMethodBeat.i(59926);
    Object localObject = paramD;
    if (paramD == null) {
      aDG(55);
    }
    for (localObject = paramD; ((kotlin.l.b.a.b.b.b)localObject).iEN() == b.a.aaJR; localObject = (kotlin.l.b.a.b.b.b)paramD.iterator().next())
    {
      paramD = ((kotlin.l.b.a.b.b.b)localObject).iEL();
      if (paramD.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(59926);
        throw paramD;
      }
    }
    if (localObject == null) {
      aDG(56);
    }
    AppMethodBeat.o(59926);
    return localObject;
  }
  
  private static y t(l paraml)
  {
    AppMethodBeat.i(59908);
    if (paraml == null) {
      aDG(21);
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
        paraml = ((kotlin.l.b.a.b.b.ad)paraml).iFz();
        AppMethodBeat.o(59908);
        return paraml;
      }
      paraml = paraml.iDJ();
    }
    AppMethodBeat.o(59908);
    return null;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(59913);
    if ((a(paraml, kotlin.l.b.a.b.b.f.aaKd)) && (((e)paraml).iDR()))
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
    if ((a(paraml, kotlin.l.b.a.b.b.f.aaJY)) && (((e)paraml).iDO() == w.aaKj))
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
      aDG(32);
    }
    if ((a(paraml, kotlin.l.b.a.b.b.f.aaJY)) && (paraml.iEU().equals(kotlin.l.b.a.b.f.h.abfQ)))
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
      aDG(34);
    }
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aaKb);
    AppMethodBeat.o(59916);
    return bool;
  }
  
  public static e y(e parame)
  {
    AppMethodBeat.i(59922);
    if (parame == null) {
      aDG(42);
    }
    parame = parame.iDL().iGk().iterator();
    while (parame.hasNext())
    {
      e locale = Z((kotlin.l.b.a.b.m.ab)parame.next());
      if (locale.iDN() != kotlin.l.b.a.b.b.f.aaJZ)
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
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aaKa);
    AppMethodBeat.o(59917);
    return bool;
  }
  
  public static ba z(e parame)
  {
    AppMethodBeat.i(59925);
    if (parame == null) {
      aDG(46);
    }
    kotlin.l.b.a.b.b.f localf = parame.iDN();
    if ((localf == kotlin.l.b.a.b.b.f.aaKa) || (localf.iFd()) || (v(parame)))
    {
      parame = az.aaKK;
      if (parame == null) {
        aDG(47);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if (w(parame))
    {
      parame = az.aaKV;
      if (parame == null) {
        aDG(48);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != kotlin.l.b.a.b.b.f.aaJY) && (localf != kotlin.l.b.a.b.b.f.aaJZ) && (localf != kotlin.l.b.a.b.b.f.aaKc))
    {
      parame = new AssertionError();
      AppMethodBeat.o(59925);
      throw parame;
    }
    parame = az.aaKO;
    if (parame == null) {
      aDG(49);
    }
    AppMethodBeat.o(59925);
    return parame;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(59918);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aaKc);
    AppMethodBeat.o(59918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.c
 * JD-Core Version:    0.7.0.1
 */