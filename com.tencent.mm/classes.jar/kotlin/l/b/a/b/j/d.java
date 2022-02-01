package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.aw;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.v;

public class d
{
  public static final c ajiL;
  
  static
  {
    AppMethodBeat.i(59932);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajiL = new c("kotlin.jvm.JvmName");
      AppMethodBeat.o(59932);
      return;
    }
  }
  
  public static kotlin.l.b.a.b.b.e A(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(59922);
    if (parame == null) {
      aKu(44);
    }
    parame = parame.kmZ().kpG().iterator();
    while (parame.hasNext())
    {
      kotlin.l.b.a.b.b.e locale = Q((ad)parame.next());
      if (locale.kna() != kotlin.l.b.a.b.b.f.aiGu)
      {
        AppMethodBeat.o(59922);
        return locale;
      }
    }
    AppMethodBeat.o(59922);
    return null;
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(59919);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aiGu);
    AppMethodBeat.o(59919);
    return bool;
  }
  
  public static t B(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(192248);
    if (parame == null) {
      aKu(48);
    }
    kotlin.l.b.a.b.b.f localf = parame.kna();
    if ((localf == kotlin.l.b.a.b.b.f.aiGv) || (localf.kox()))
    {
      parame = s.aiGC;
      if (parame == null) {
        aKu(49);
      }
      AppMethodBeat.o(192248);
      return parame;
    }
    if (v(parame))
    {
      parame = s.aiGC;
      if (parame == null) {
        aKu(51);
      }
      AppMethodBeat.o(192248);
      return parame;
    }
    if (w(parame))
    {
      parame = s.aiGN;
      if (parame == null) {
        aKu(52);
      }
      AppMethodBeat.o(192248);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != kotlin.l.b.a.b.b.f.aiGt) && (localf != kotlin.l.b.a.b.b.f.aiGu) && (localf != kotlin.l.b.a.b.b.f.aiGx))
    {
      parame = new AssertionError();
      AppMethodBeat.o(192248);
      throw parame;
    }
    parame = s.aiGG;
    if (parame == null) {
      aKu(53);
    }
    AppMethodBeat.o(192248);
    return parame;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(59920);
    if ((a(paraml, kotlin.l.b.a.b.b.f.aiGt)) || (a(paraml, kotlin.l.b.a.b.b.f.aiGv)))
    {
      AppMethodBeat.o(59920);
      return true;
    }
    AppMethodBeat.o(59920);
    return false;
  }
  
  public static aw C(l paraml)
  {
    AppMethodBeat.i(59931);
    if (paraml == null) {
      aKu(79);
    }
    if ((paraml instanceof ar)) {
      paraml = ((ar)paraml).kpb();
    }
    for (;;)
    {
      if ((paraml instanceof kotlin.l.b.a.b.b.o))
      {
        paraml = ((kotlin.l.b.a.b.b.o)paraml).knm().kpk();
        if (paraml == null) {
          aKu(80);
        }
        AppMethodBeat.o(59931);
        return paraml;
      }
      paraml = aw.aiHv;
      if (paraml == null) {
        aKu(81);
      }
      AppMethodBeat.o(59931);
      return paraml;
    }
  }
  
  public static ae P(ad paramad)
  {
    AppMethodBeat.i(59906);
    if (paramad == null) {
      aKu(20);
    }
    paramad = paramad.kzm().knA();
    if (paramad == null)
    {
      AppMethodBeat.o(59906);
      return null;
    }
    paramad = t(paramad);
    AppMethodBeat.o(59906);
    return paramad;
  }
  
  public static kotlin.l.b.a.b.b.e Q(ad paramad)
  {
    AppMethodBeat.i(59923);
    if (paramad == null) {
      aKu(45);
    }
    paramad = b(paramad.kzm());
    AppMethodBeat.o(59923);
    return paramad;
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
      aKu(19);
    }
    if (paraml == null)
    {
      AppMethodBeat.o(59905);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.knp();
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
        paraml = paraml.knp();
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
      aKu(61);
    }
    if ((paramD instanceof b))
    {
      paramD = t((b)paramD);
      AppMethodBeat.o(59927);
      return paramD;
    }
    if (paramD == null) {
      aKu(62);
    }
    AppMethodBeat.o(59927);
    return paramD;
  }
  
  private static <D extends kotlin.l.b.a.b.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(59930);
    if (paramD == null) {
      aKu(70);
    }
    if (paramSet == null) {
      aKu(71);
    }
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(59930);
      return;
    }
    paramD = paramD.koc().kof().iterator();
    while (paramD.hasNext())
    {
      kotlin.l.b.a.b.b.a locala = ((kotlin.l.b.a.b.b.a)paramD.next()).koc();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(59930);
  }
  
  public static boolean a(bf parambf, ad paramad)
  {
    AppMethodBeat.i(59928);
    if (parambf == null) {
      aKu(63);
    }
    if (paramad == null) {
      aKu(64);
    }
    if ((parambf.kpu()) || (af.ai(paramad)))
    {
      AppMethodBeat.o(59928);
      return false;
    }
    if (bg.ax(paramad))
    {
      AppMethodBeat.o(59928);
      return true;
    }
    parambf = kotlin.l.b.a.b.j.d.a.G(parambf);
    if ((!kotlin.l.b.a.b.a.h.p(paramad)) && (!kotlin.l.b.a.b.m.a.e.ajqY.e(parambf.kmX(), paramad)) && (!kotlin.l.b.a.b.m.a.e.ajqY.e(parambf.bIC("Number").koj(), paramad)) && (!kotlin.l.b.a.b.m.a.e.ajqY.e(parambf.kmO(), paramad)))
    {
      parambf = kotlin.l.b.a.b.a.o.aiEq;
      if (!kotlin.l.b.a.b.a.o.x(paramad)) {}
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
      aKu(37);
    }
    if (((paraml instanceof kotlin.l.b.a.b.b.e)) && (((kotlin.l.b.a.b.b.e)paraml).kna() == paramf))
    {
      AppMethodBeat.o(59921);
      return true;
    }
    AppMethodBeat.o(59921);
    return false;
  }
  
  private static boolean a(ad paramad, l paraml)
  {
    AppMethodBeat.i(59911);
    if (paramad == null) {
      aKu(30);
    }
    if (paraml == null) {
      aKu(31);
    }
    paramad = paramad.kzm().knA();
    if (paramad != null)
    {
      paramad = paramad.kor();
      if (((paramad instanceof kotlin.l.b.a.b.b.h)) && ((paraml instanceof kotlin.l.b.a.b.b.h)) && (((kotlin.l.b.a.b.b.h)paraml).kmZ().equals(((kotlin.l.b.a.b.b.h)paramad).kmZ())))
      {
        AppMethodBeat.o(59911);
        return true;
      }
    }
    AppMethodBeat.o(59911);
    return false;
  }
  
  private static kotlin.l.b.a.b.b.e b(ax paramax)
  {
    AppMethodBeat.i(59924);
    if (paramax == null) {
      aKu(46);
    }
    kotlin.l.b.a.b.b.h localh = paramax.knA();
    if ((!$assertionsDisabled) && (!(localh instanceof kotlin.l.b.a.b.b.e)))
    {
      paramax = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paramax)));
      AppMethodBeat.o(59924);
      throw paramax;
    }
    paramax = (kotlin.l.b.a.b.b.e)localh;
    if (paramax == null) {
      aKu(47);
    }
    AppMethodBeat.o(59924);
    return paramax;
  }
  
  public static boolean b(kotlin.l.b.a.b.b.e parame1, kotlin.l.b.a.b.b.e parame2)
  {
    AppMethodBeat.i(59909);
    if (parame1 == null) {
      aKu(26);
    }
    if (parame2 == null) {
      aKu(27);
    }
    parame1 = parame1.kmZ().kpG().iterator();
    while (parame1.hasNext()) {
      if (a((ad)parame1.next(), parame2.kow()))
      {
        AppMethodBeat.o(59909);
        return true;
      }
    }
    AppMethodBeat.o(59909);
    return false;
  }
  
  public static boolean b(ad paramad, l paraml)
  {
    AppMethodBeat.i(59912);
    if (paramad == null) {
      aKu(32);
    }
    if (paraml == null) {
      aKu(33);
    }
    if (a(paramad, paraml))
    {
      AppMethodBeat.o(59912);
      return true;
    }
    paramad = paramad.kzm().kpG().iterator();
    while (paramad.hasNext()) {
      if (b((ad)paramad.next(), paraml))
      {
        AppMethodBeat.o(59912);
        return true;
      }
    }
    AppMethodBeat.o(59912);
    return false;
  }
  
  public static boolean c(kotlin.l.b.a.b.b.e parame1, kotlin.l.b.a.b.b.e parame2)
  {
    AppMethodBeat.i(59910);
    if (parame1 == null) {
      aKu(28);
    }
    if (parame2 == null) {
      aKu(29);
    }
    boolean bool = b(parame1.koj(), parame2.kow());
    AppMethodBeat.o(59910);
    return bool;
  }
  
  public static boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(59903);
    if (paraml1 == null) {
      aKu(16);
    }
    if (paraml2 == null) {
      aKu(17);
    }
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(59903);
    return bool;
  }
  
  public static <D extends kotlin.l.b.a.b.b.a> Set<D> e(D paramD)
  {
    AppMethodBeat.i(59929);
    if (paramD == null) {
      aKu(68);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.koc(), localLinkedHashSet);
    AppMethodBeat.o(59929);
    return localLinkedHashSet;
  }
  
  public static as l(l paraml)
  {
    AppMethodBeat.i(59896);
    if (paraml == null) {
      aKu(0);
    }
    if ((paraml instanceof kotlin.l.b.a.b.b.e))
    {
      paraml = ((kotlin.l.b.a.b.b.e)paraml).kov();
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
      aKu(1);
    }
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof p)) || (((p)paraml).knc() != s.aiGH)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(59897);
        return true;
      }
      paraml = paraml.knp();
    }
    AppMethodBeat.o(59897);
    return false;
  }
  
  public static kotlin.l.b.a.b.f.d n(l paraml)
  {
    AppMethodBeat.i(59898);
    if (paraml == null) {
      aKu(2);
    }
    c localc = p(paraml);
    if (localc != null)
    {
      paraml = localc.kxR();
      AppMethodBeat.o(59898);
      return paraml;
    }
    paraml = q(paraml);
    AppMethodBeat.o(59898);
    return paraml;
  }
  
  public static c o(l paraml)
  {
    AppMethodBeat.i(59899);
    if (paraml == null) {
      aKu(3);
    }
    c localc = p(paraml);
    if (localc != null) {}
    for (paraml = localc;; paraml = q(paraml).kxX())
    {
      if (paraml == null) {
        aKu(4);
      }
      AppMethodBeat.o(59899);
      return paraml;
    }
  }
  
  private static c p(l paraml)
  {
    AppMethodBeat.i(59900);
    if (paraml == null) {
      aKu(5);
    }
    if (((paraml instanceof ae)) || (v.L(paraml)))
    {
      paraml = c.ajew;
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof al))
    {
      paraml = ((al)paraml).koY();
      AppMethodBeat.o(59900);
      return paraml;
    }
    if ((paraml instanceof ah))
    {
      paraml = ((ah)paraml).koY();
      AppMethodBeat.o(59900);
      return paraml;
    }
    AppMethodBeat.o(59900);
    return null;
  }
  
  private static kotlin.l.b.a.b.f.d q(l paraml)
  {
    AppMethodBeat.i(59901);
    if (paraml == null) {
      aKu(6);
    }
    l locall = paraml.knp();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59901);
      throw paraml;
    }
    paraml = n(locall).t(paraml.kok());
    if (paraml == null) {
      aKu(7);
    }
    AppMethodBeat.o(59901);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(59902);
    if ((paraml != null) && ((paraml.knp() instanceof ah)))
    {
      AppMethodBeat.o(59902);
      return true;
    }
    AppMethodBeat.o(59902);
    return false;
  }
  
  public static ae s(l paraml)
  {
    AppMethodBeat.i(59907);
    if (paraml == null) {
      aKu(21);
    }
    ae localae = t(paraml);
    if ((!$assertionsDisabled) && (localae == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(59907);
      throw paraml;
    }
    if (localae == null) {
      aKu(22);
    }
    AppMethodBeat.o(59907);
    return localae;
  }
  
  private static ae t(l paraml)
  {
    AppMethodBeat.i(59908);
    if (paraml == null) {
      aKu(23);
    }
    while (paraml != null)
    {
      if ((paraml instanceof ae))
      {
        paraml = (ae)paraml;
        AppMethodBeat.o(59908);
        return paraml;
      }
      if ((paraml instanceof al))
      {
        paraml = ((al)paraml).koZ();
        AppMethodBeat.o(59908);
        return paraml;
      }
      paraml = paraml.knp();
    }
    AppMethodBeat.o(59908);
    return null;
  }
  
  public static <D extends b> D t(D paramD)
  {
    AppMethodBeat.i(59926);
    Object localObject = paramD;
    if (paramD == null) {
      aKu(59);
    }
    for (localObject = paramD; ((b)localObject).koh() == b.a.aiGm; localObject = (b)paramD.iterator().next())
    {
      paramD = ((b)localObject).kof();
      if (paramD.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(59926);
        throw paramD;
      }
    }
    if (localObject == null) {
      aKu(60);
    }
    AppMethodBeat.o(59926);
    return localObject;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(59913);
    if ((a(paraml, kotlin.l.b.a.b.b.f.aiGy)) && (((kotlin.l.b.a.b.b.e)paraml).knd()))
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
    if (((a(paraml, kotlin.l.b.a.b.b.f.aiGt)) || (a(paraml, kotlin.l.b.a.b.b.f.aiGu))) && (((kotlin.l.b.a.b.b.e)paraml).knb() == ab.aiGZ))
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
      aKu(34);
    }
    if ((a(paraml, kotlin.l.b.a.b.b.f.aiGt)) && (paraml.kok().equals(kotlin.l.b.a.b.f.h.ajeJ)))
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
      aKu(36);
    }
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aiGw);
    AppMethodBeat.o(59916);
    return bool;
  }
  
  public static boolean y(l paraml)
  {
    AppMethodBeat.i(59917);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aiGv);
    AppMethodBeat.o(59917);
    return bool;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(59918);
    boolean bool = a(paraml, kotlin.l.b.a.b.b.f.aiGx);
    AppMethodBeat.o(59918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.d
 * JD-Core Version:    0.7.0.1
 */