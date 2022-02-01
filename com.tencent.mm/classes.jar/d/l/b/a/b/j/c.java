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
  public static final d.l.b.a.b.f.b LEA;
  public static final d.l.b.a.b.f.f LEs;
  public static final d.l.b.a.b.f.f LEt;
  public static final d.l.b.a.b.f.b LEu;
  public static final d.l.b.a.b.f.b LEv;
  public static final d.l.b.a.b.f.b LEw;
  public static final d.l.b.a.b.f.b LEx;
  public static final d.l.b.a.b.f.b LEy;
  public static final d.l.b.a.b.f.b LEz;
  
  static
  {
    AppMethodBeat.i(59932);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEs = d.l.b.a.b.f.f.aWB("values");
      LEt = d.l.b.a.b.f.f.aWB("valueOf");
      d.l.b.a.b.f.b localb = new d.l.b.a.b.f.b("kotlin.coroutines");
      LEu = localb;
      localb = localb.p(d.l.b.a.b.f.f.aWB("experimental"));
      LEv = localb;
      LEw = localb.p(d.l.b.a.b.f.f.aWB("intrinsics"));
      LEx = LEv.p(d.l.b.a.b.f.f.aWB("Continuation"));
      LEy = LEu.p(d.l.b.a.b.f.f.aWB("Continuation"));
      LEz = new d.l.b.a.b.f.b("kotlin.Result");
      LEA = new d.l.b.a.b.f.b("kotlin.jvm.JvmName");
      AppMethodBeat.o(59932);
      return;
    }
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(59919);
    boolean bool = a(paraml, d.l.b.a.b.b.f.Ldx);
    AppMethodBeat.o(59919);
    return bool;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(59920);
    if ((a(paraml, d.l.b.a.b.b.f.Ldw)) || (a(paraml, d.l.b.a.b.b.f.Ldy)))
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
      agL(74);
    }
    if ((paraml instanceof aj)) {
      paraml = ((aj)paraml).fRJ();
    }
    for (;;)
    {
      if ((paraml instanceof o))
      {
        paraml = ((o)paraml).fQk().fRR();
        if (paraml == null) {
          agL(75);
        }
        AppMethodBeat.o(59931);
        return paraml;
      }
      paraml = ao.Led;
      if (paraml == null) {
        agL(76);
      }
      AppMethodBeat.o(59931);
      return paraml;
    }
  }
  
  public static y Z(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59906);
    if (paramab == null) {
      agL(18);
    }
    paramab = paramab.gbz().fQq();
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
      agL(17);
    }
    if (paraml == null)
    {
      AppMethodBeat.o(59905);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.fPU();
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
        paraml = paraml.fPU();
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
      agL(57);
    }
    if ((paramD instanceof d.l.b.a.b.b.b))
    {
      paramD = t((d.l.b.a.b.b.b)paramD);
      AppMethodBeat.o(59927);
      return paramD;
    }
    if (paramD == null) {
      agL(58);
    }
    AppMethodBeat.o(59927);
    return paramD;
  }
  
  private static <D extends d.l.b.a.b.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(59930);
    if (paramD == null) {
      agL(66);
    }
    if (paramSet == null) {
      agL(67);
    }
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(59930);
      return;
    }
    paramD = paramD.fQT().fQW().iterator();
    while (paramD.hasNext())
    {
      d.l.b.a.b.b.a locala = ((d.l.b.a.b.b.a)paramD.next()).fQT();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(59930);
  }
  
  public static boolean a(ax paramax, d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(59928);
    if (paramax == null) {
      agL(59);
    }
    if (paramab == null) {
      agL(60);
    }
    if ((paramax.fSc()) || (d.l.b.a.b.m.ad.aq(paramab)))
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
    if ((!d.l.b.a.b.a.g.o(paramab)) && (!d.l.b.a.b.m.a.g.LMg.d(paramax.fPO(), paramab)) && (!d.l.b.a.b.m.a.g.LMg.d(paramax.aWc("Number").fRe(), paramab)) && (!d.l.b.a.b.m.a.g.LMg.d(paramax.fPF(), paramab)))
    {
      paramax = m.LbG;
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
      agL(35);
    }
    if (((paraml instanceof e)) && (((e)paraml).fPY() == paramf))
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
      agL(28);
    }
    if (paraml == null) {
      agL(29);
    }
    paramab = paramab.gbz().fQq();
    if (paramab != null)
    {
      paramab = paramab.fRc();
      if (((paramab instanceof d.l.b.a.b.b.h)) && ((paraml instanceof d.l.b.a.b.b.h)) && (((d.l.b.a.b.b.h)paraml).fPW().equals(((d.l.b.a.b.b.h)paramab).fPW())))
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
      agL(43);
    }
    paramab = b(paramab.gbz());
    AppMethodBeat.o(59923);
    return paramab;
  }
  
  private static e b(at paramat)
  {
    AppMethodBeat.i(59924);
    if (paramat == null) {
      agL(44);
    }
    d.l.b.a.b.b.h localh = paramat.fQq();
    if ((!$assertionsDisabled) && (!(localh instanceof e)))
    {
      paramat = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paramat)));
      AppMethodBeat.o(59924);
      throw paramat;
    }
    paramat = (e)localh;
    if (paramat == null) {
      agL(45);
    }
    AppMethodBeat.o(59924);
    return paramat;
  }
  
  public static boolean b(e parame1, e parame2)
  {
    AppMethodBeat.i(59909);
    if (parame1 == null) {
      agL(24);
    }
    if (parame2 == null) {
      agL(25);
    }
    parame1 = parame1.fPW().fSt().iterator();
    while (parame1.hasNext()) {
      if (a((d.l.b.a.b.m.ab)parame1.next(), parame2.fRm()))
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
      agL(30);
    }
    if (paraml == null) {
      agL(31);
    }
    if (a(paramab, paraml))
    {
      AppMethodBeat.o(59912);
      return true;
    }
    paramab = paramab.gbz().fSt().iterator();
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
      agL(26);
    }
    if (parame2 == null) {
      agL(27);
    }
    boolean bool = b(parame1.fRe(), parame2.fRm());
    AppMethodBeat.o(59910);
    return bool;
  }
  
  public static boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(59903);
    if (paraml1 == null) {
      agL(14);
    }
    if (paraml2 == null) {
      agL(15);
    }
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static <D extends d.l.b.a.b.b.a> Set<D> e(D paramD)
  {
    AppMethodBeat.i(59929);
    if (paramD == null) {
      agL(64);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.fQT(), localLinkedHashSet);
    AppMethodBeat.o(59929);
    return localLinkedHashSet;
  }
  
  public static ak l(l paraml)
  {
    AppMethodBeat.i(59896);
    if (paraml == null) {
      agL(0);
    }
    if ((paraml instanceof e))
    {
      paraml = ((e)paraml).fRl();
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
      agL(1);
    }
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof p)) || (((p)paraml).fQb() != az.Len)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(59897);
        return true;
      }
      paraml = paraml.fPU();
    }
    AppMethodBeat.o(59897);
    return false;
  }
  
  public static d.l.b.a.b.f.c n(l paraml)
  {
    AppMethodBeat.i(59898);
    if (paraml == null) {
      agL(2);
    }
    d.l.b.a.b.f.b localb = p(paraml);
    if (localb != null)
    {
      paraml = localb.fZG();
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
      agL(3);
    }
    d.l.b.a.b.f.b localb = p(paraml);
    if (localb != null) {}
    for (paraml = localb;; paraml = q(paraml).fZL())
    {
      if (paraml == null) {
        agL(4);
      }
      AppMethodBeat.o(59899);
      return paraml;
    }
  }
  
  private static d.l.b.a.b.f.b p(l paraml)
  {
    AppMethodBeat.i(59900);
    if (paraml == null) {
      agL(5);
    }
    if (((paraml instanceof y)) || (u.L(paraml)))
    {
      paraml = d.l.b.a.b.f.b.Lzi;
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.b.ad))
    {
      paraml = ((d.l.b.a.b.b.ad)paraml).fRH();
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.b.ab))
    {
      paraml = ((d.l.b.a.b.b.ab)paraml).fRH();
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
      agL(6);
    }
    l locall = paraml.fPU();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59901);
      throw paraml;
    }
    paraml = n(locall).s(paraml.fRf());
    AppMethodBeat.o(59901);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(59902);
    if ((paraml != null) && ((paraml.fPU() instanceof d.l.b.a.b.b.ab)))
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
      agL(19);
    }
    y localy = t(paraml);
    if ((!$assertionsDisabled) && (localy == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59907);
      throw paraml;
    }
    if (localy == null) {
      agL(20);
    }
    AppMethodBeat.o(59907);
    return localy;
  }
  
  public static <D extends d.l.b.a.b.b.b> D t(D paramD)
  {
    AppMethodBeat.i(59926);
    Object localObject = paramD;
    if (paramD == null) {
      agL(55);
    }
    for (localObject = paramD; ((d.l.b.a.b.b.b)localObject).fQY() == b.a.Ldp; localObject = (d.l.b.a.b.b.b)paramD.iterator().next())
    {
      paramD = ((d.l.b.a.b.b.b)localObject).fQW();
      if (paramD.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(59926);
        throw paramD;
      }
    }
    if (localObject == null) {
      agL(56);
    }
    AppMethodBeat.o(59926);
    return localObject;
  }
  
  private static y t(l paraml)
  {
    AppMethodBeat.i(59908);
    if (paraml == null) {
      agL(21);
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
        paraml = ((d.l.b.a.b.b.ad)paraml).fRI();
        AppMethodBeat.o(59908);
        return paraml;
      }
      paraml = paraml.fPU();
    }
    AppMethodBeat.o(59908);
    return null;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(59913);
    if ((a(paraml, d.l.b.a.b.b.f.LdB)) && (((e)paraml).fQc()))
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
    if ((a(paraml, d.l.b.a.b.b.f.Ldw)) && (((e)paraml).fPZ() == w.LdH))
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
      agL(32);
    }
    if ((a(paraml, d.l.b.a.b.b.f.Ldw)) && (paraml.fRf().equals(d.l.b.a.b.f.h.Lzv)))
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
      agL(34);
    }
    boolean bool = a(paraml, d.l.b.a.b.b.f.Ldz);
    AppMethodBeat.o(59916);
    return bool;
  }
  
  public static e y(e parame)
  {
    AppMethodBeat.i(59922);
    if (parame == null) {
      agL(42);
    }
    parame = parame.fPW().fSt().iterator();
    while (parame.hasNext())
    {
      e locale = aa((d.l.b.a.b.m.ab)parame.next());
      if (locale.fPY() != d.l.b.a.b.b.f.Ldx)
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
    boolean bool = a(paraml, d.l.b.a.b.b.f.Ldy);
    AppMethodBeat.o(59917);
    return bool;
  }
  
  public static ba z(e parame)
  {
    AppMethodBeat.i(59925);
    if (parame == null) {
      agL(46);
    }
    d.l.b.a.b.b.f localf = parame.fPY();
    if ((localf == d.l.b.a.b.b.f.Ldy) || (localf.fRn()) || (v(parame)))
    {
      parame = az.Lei;
      if (parame == null) {
        agL(47);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if (w(parame))
    {
      parame = az.Let;
      if (parame == null) {
        agL(48);
      }
      AppMethodBeat.o(59925);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != d.l.b.a.b.b.f.Ldw) && (localf != d.l.b.a.b.b.f.Ldx) && (localf != d.l.b.a.b.b.f.LdA))
    {
      parame = new AssertionError();
      AppMethodBeat.o(59925);
      throw parame;
    }
    parame = az.Lem;
    if (parame == null) {
      agL(49);
    }
    AppMethodBeat.o(59925);
    return parame;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(59918);
    boolean bool = a(paraml, d.l.b.a.b.b.f.LdA);
    AppMethodBeat.o(59918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.c
 * JD-Core Version:    0.7.0.1
 */