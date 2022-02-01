package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.m;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ao;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.o;
import d.l.b.a.b.b.p;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class c
{
  public static final d.l.b.a.b.f.f JQZ;
  public static final d.l.b.a.b.f.f JRa;
  public static final d.l.b.a.b.f.b JRb;
  public static final d.l.b.a.b.f.b JRc;
  public static final d.l.b.a.b.f.b JRd;
  public static final d.l.b.a.b.f.b JRe;
  public static final d.l.b.a.b.f.b JRf;
  public static final d.l.b.a.b.f.b JRg;
  public static final d.l.b.a.b.f.b JRh;
  
  static
  {
    AppMethodBeat.i(59932);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      JQZ = d.l.b.a.b.f.f.aQC("values");
      JRa = d.l.b.a.b.f.f.aQC("valueOf");
      d.l.b.a.b.f.b localb = new d.l.b.a.b.f.b("kotlin.coroutines");
      JRb = localb;
      localb = localb.p(d.l.b.a.b.f.f.aQC("experimental"));
      JRc = localb;
      JRd = localb.p(d.l.b.a.b.f.f.aQC("intrinsics"));
      JRe = JRc.p(d.l.b.a.b.f.f.aQC("Continuation"));
      JRf = JRb.p(d.l.b.a.b.f.f.aQC("Continuation"));
      JRg = new d.l.b.a.b.f.b("kotlin.Result");
      JRh = new d.l.b.a.b.f.b("kotlin.jvm.JvmName");
      AppMethodBeat.o(59932);
      return;
    }
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(59919);
    boolean bool = a(paraml, d.l.b.a.b.b.f.Jqe);
    AppMethodBeat.o(59919);
    return bool;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(59920);
    if ((a(paraml, d.l.b.a.b.b.f.Jqd)) || (a(paraml, d.l.b.a.b.b.f.Jqf)))
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
      adP(74);
    }
    if ((paraml instanceof aj)) {
      paraml = ((aj)paraml).fzf();
    }
    for (;;)
    {
      if ((paraml instanceof o))
      {
        paraml = ((o)paraml).fxG().fzn();
        if (paraml == null) {
          adP(75);
        }
        AppMethodBeat.o(59931);
        return paraml;
      }
      paraml = ao.JqK;
      if (paraml == null) {
        adP(76);
      }
      AppMethodBeat.o(59931);
      return paraml;
    }
  }
  
  public static y Z(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59906);
    if (paramab == null) {
      adP(18);
    }
    paramab = paramab.fIW().fxM();
    if (paramab == null)
    {
      AppMethodBeat.o(59906);
      return null;
    }
    paramab = t(paramab);
    AppMethodBeat.o(59906);
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
      adP(17);
    }
    if (paraml == null)
    {
      AppMethodBeat.o(59905);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.fxq();
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
        paraml = paraml.fxq();
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
      adP(57);
    }
    if ((paramD instanceof d.l.b.a.b.b.b))
    {
      paramD = t((d.l.b.a.b.b.b)paramD);
      AppMethodBeat.o(59927);
      return paramD;
    }
    if (paramD == null) {
      adP(58);
    }
    AppMethodBeat.o(59927);
    return paramD;
  }
  
  private static <D extends d.l.b.a.b.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(59930);
    if (paramD == null) {
      adP(66);
    }
    if (paramSet == null) {
      adP(67);
    }
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(59930);
      return;
    }
    paramD = paramD.fyp().fys().iterator();
    while (paramD.hasNext())
    {
      d.l.b.a.b.b.a locala = ((d.l.b.a.b.b.a)paramD.next()).fyp();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(59930);
  }
  
  public static boolean a(ax paramax, d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59928);
    if (paramax == null) {
      adP(59);
    }
    if (paramab == null) {
      adP(60);
    }
    if ((paramax.fzy()) || (d.l.b.a.b.m.ad.aq(paramab)))
    {
      AppMethodBeat.o(59928);
      return false;
    }
    if (bc.aG(paramab))
    {
      AppMethodBeat.o(59928);
      return true;
    }
    paramax = d.l.b.a.b.j.d.a.G(paramax);
    if ((!d.l.b.a.b.a.g.o(paramab)) && (!d.l.b.a.b.m.a.g.JYN.d(paramax.fxk(), paramab)) && (!d.l.b.a.b.m.a.g.JYN.d(paramax.aQd("Number").fyA(), paramab)) && (!d.l.b.a.b.m.a.g.JYN.d(paramax.fxb(), paramab)))
    {
      paramax = m.Jom;
      if (!m.F(paramab)) {}
    }
    else
    {
      AppMethodBeat.o(59928);
      return true;
    }
    AppMethodBeat.o(59928);
    return false;
  }
  
  private static boolean a(l paraml, d.l.b.a.b.b.f paramf)
  {
    AppMethodBeat.i(59921);
    if (paramf == null) {
      adP(35);
    }
    if (((paraml instanceof e)) && (((e)paraml).fxu() == paramf))
    {
      AppMethodBeat.o(59921);
      return true;
    }
    AppMethodBeat.o(59921);
    return false;
  }
  
  private static boolean a(d.l.b.a.b.m.ab paramab, l paraml)
  {
    AppMethodBeat.i(59911);
    if (paramab == null) {
      adP(28);
    }
    if (paraml == null) {
      adP(29);
    }
    paramab = paramab.fIW().fxM();
    if (paramab != null)
    {
      paramab = paramab.fyy();
      if (((paramab instanceof d.l.b.a.b.b.h)) && ((paraml instanceof d.l.b.a.b.b.h)) && (((d.l.b.a.b.b.h)paraml).fxs().equals(((d.l.b.a.b.b.h)paramab).fxs())))
      {
        AppMethodBeat.o(59911);
        return true;
      }
    }
    AppMethodBeat.o(59911);
    return false;
  }
  
  public static e aa(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59923);
    if (paramab == null) {
      adP(43);
    }
    paramab = b(paramab.fIW());
    AppMethodBeat.o(59923);
    return paramab;
  }
  
  private static e b(at paramat)
  {
    AppMethodBeat.i(59924);
    if (paramat == null) {
      adP(44);
    }
    d.l.b.a.b.b.h localh = paramat.fxM();
    if ((!$assertionsDisabled) && (!(localh instanceof e)))
    {
      paramat = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paramat)));
      AppMethodBeat.o(59924);
      throw paramat;
    }
    paramat = (e)localh;
    if (paramat == null) {
      adP(45);
    }
    AppMethodBeat.o(59924);
    return paramat;
  }
  
  public static boolean b(e parame1, e parame2)
  {
    AppMethodBeat.i(59909);
    if (parame1 == null) {
      adP(24);
    }
    if (parame2 == null) {
      adP(25);
    }
    parame1 = parame1.fxs().fzP().iterator();
    while (parame1.hasNext()) {
      if (a((d.l.b.a.b.m.ab)parame1.next(), parame2.fyI()))
      {
        AppMethodBeat.o(59909);
        return true;
      }
    }
    AppMethodBeat.o(59909);
    return false;
  }
  
  public static boolean b(d.l.b.a.b.m.ab paramab, l paraml)
  {
    AppMethodBeat.i(59912);
    if (paramab == null) {
      adP(30);
    }
    if (paraml == null) {
      adP(31);
    }
    if (a(paramab, paraml))
    {
      AppMethodBeat.o(59912);
      return true;
    }
    paramab = paramab.fIW().fzP().iterator();
    while (paramab.hasNext()) {
      if (b((d.l.b.a.b.m.ab)paramab.next(), paraml))
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
      adP(26);
    }
    if (parame2 == null) {
      adP(27);
    }
    boolean bool = b(parame1.fyA(), parame2.fyI());
    AppMethodBeat.o(59910);
    return bool;
  }
  
  public static boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(59903);
    if (paraml1 == null) {
      adP(14);
    }
    if (paraml2 == null) {
      adP(15);
    }
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static <D extends d.l.b.a.b.b.a> Set<D> e(D paramD)
  {
    AppMethodBeat.i(59929);
    if (paramD == null) {
      adP(64);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.fyp(), localLinkedHashSet);
    AppMethodBeat.o(59929);
    return localLinkedHashSet;
  }
  
  public static ak l(l paraml)
  {
    AppMethodBeat.i(59896);
    if (paraml == null) {
      adP(0);
    }
    if ((paraml instanceof e))
    {
      paraml = ((e)paraml).fyH();
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
      adP(1);
    }
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof p)) || (((p)paraml).fxx() != az.JqU)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(59897);
        return true;
      }
      paraml = paraml.fxq();
    }
    AppMethodBeat.o(59897);
    return false;
  }
  
  public static d.l.b.a.b.f.c n(l paraml)
  {
    AppMethodBeat.i(59898);
    if (paraml == null) {
      adP(2);
    }
    d.l.b.a.b.f.b localb = p(paraml);
    if (localb != null)
    {
      paraml = localb.fHc();
      AppMethodBeat.o(59898);
      return paraml;
    }
    paraml = q(paraml);
    AppMethodBeat.o(59898);
    return paraml;
  }
  
  public static d.l.b.a.b.f.b o(l paraml)
  {
    AppMethodBeat.i(59899);
    if (paraml == null) {
      adP(3);
    }
    d.l.b.a.b.f.b localb = p(paraml);
    if (localb != null) {}
    for (paraml = localb;; paraml = q(paraml).fHh())
    {
      if (paraml == null) {
        adP(4);
      }
      AppMethodBeat.o(59899);
      return paraml;
    }
  }
  
  private static d.l.b.a.b.f.b p(l paraml)
  {
    AppMethodBeat.i(59900);
    if (paraml == null) {
      adP(5);
    }
    if (((paraml instanceof y)) || (u.L(paraml)))
    {
      paraml = d.l.b.a.b.f.b.JLP;
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.b.ad))
    {
      paraml = ((d.l.b.a.b.b.ad)paraml).fzd();
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.b.ab))
    {
      paraml = ((d.l.b.a.b.b.ab)paraml).fzd();
      AppMethodBeat.o(59900);
      return paraml;
    }
    AppMethodBeat.o(59900);
    return null;
  }
  
  private static d.l.b.a.b.f.c q(l paraml)
  {
    AppMethodBeat.i(59901);
    if (paraml == null) {
      adP(6);
    }
    l locall = paraml.fxq();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59901);
      throw paraml;
    }
    paraml = n(locall).s(paraml.fyB());
    AppMethodBeat.o(59901);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(59902);
    if ((paraml != null) && ((paraml.fxq() instanceof d.l.b.a.b.b.ab)))
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
      adP(19);
    }
    y localy = t(paraml);
    if ((!$assertionsDisabled) && (localy == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59907);
      throw paraml;
    }
    if (localy == null) {
      adP(20);
    }
    AppMethodBeat.o(59907);
    return localy;
  }
  
  public static <D extends d.l.b.a.b.b.b> D t(D paramD)
  {
    AppMethodBeat.i(59926);
    Object localObject = paramD;
    if (paramD == null) {
      adP(55);
    }
    for (localObject = paramD; ((d.l.b.a.b.b.b)localObject).fyu() == b.a.JpW; localObject = (d.l.b.a.b.b.b)paramD.iterator().next())
    {
      paramD = ((d.l.b.a.b.b.b)localObject).fys();
      if (paramD.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(59926);
        throw paramD;
      }
    }
    if (localObject == null) {
      adP(56);
    }
    AppMethodBeat.o(59926);
    return localObject;
  }
  
  private static y t(l paraml)
  {
    AppMethodBeat.i(59908);
    if (paraml == null) {
      adP(21);
    }
    while (paraml != null)
    {
      if ((paraml instanceof y))
      {
        paraml = (y)paraml;
        AppMethodBeat.o(59908);
        return paraml;
      }
      if ((paraml instanceof d.l.b.a.b.b.ad))
      {
        paraml = ((d.l.b.a.b.b.ad)paraml).fze();
        AppMethodBeat.o(59908);
        return paraml;
      }
      paraml = paraml.fxq();
    }
    AppMethodBeat.o(59908);
    return null;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(59913);
    if ((a(paraml, d.l.b.a.b.b.f.Jqi)) && (((e)paraml).fxy()))
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
    if ((a(paraml, d.l.b.a.b.b.f.Jqd)) && (((e)paraml).fxv() == w.Jqo))
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
      adP(32);
    }
    if ((a(paraml, d.l.b.a.b.b.f.Jqd)) && (paraml.fyB().equals(d.l.b.a.b.f.h.JMc)))
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
      adP(34);
    }
    boolean bool = a(paraml, d.l.b.a.b.b.f.Jqg);
    AppMethodBeat.o(59916);
    return bool;
  }
  
  public static e y(e parame)
  {
    AppMethodBeat.i(59922);
    if (parame == null) {
      adP(42);
    }
    parame = parame.fxs().fzP().iterator();
    while (parame.hasNext())
    {
      e locale = aa((d.l.b.a.b.m.ab)parame.next());
      if (locale.fxu() != d.l.b.a.b.b.f.Jqe)
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
    boolean bool = a(paraml, d.l.b.a.b.b.f.Jqf);
    AppMethodBeat.o(59917);
    return bool;
  }
  
  public static ba z(e parame)
  {
    AppMethodBeat.i(59925);
    if (parame == null) {
      adP(46);
    }
    d.l.b.a.b.b.f localf = parame.fxu();
    if ((localf == d.l.b.a.b.b.f.Jqf) || (localf.fyJ()) || (v(parame)))
    {
      parame = az.JqP;
      if (parame == null) {
        adP(47);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if (w(parame))
    {
      parame = az.Jra;
      if (parame == null) {
        adP(48);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != d.l.b.a.b.b.f.Jqd) && (localf != d.l.b.a.b.b.f.Jqe) && (localf != d.l.b.a.b.b.f.Jqh))
    {
      parame = new AssertionError();
      AppMethodBeat.o(59925);
      throw parame;
    }
    parame = az.JqT;
    if (parame == null) {
      adP(49);
    }
    AppMethodBeat.o(59925);
    return parame;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(59918);
    boolean bool = a(paraml, d.l.b.a.b.b.f.Jqh);
    AppMethodBeat.o(59918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.c
 * JD-Core Version:    0.7.0.1
 */