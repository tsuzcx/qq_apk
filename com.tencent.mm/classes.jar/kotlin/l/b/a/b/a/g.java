package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l.b.a.b.a.a.b.c;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.b.c.b;
import kotlin.l.b.a.b.b.c.w;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.q;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;

public abstract class g
{
  public static final kotlin.l.b.a.b.f.b aaFA;
  public static final kotlin.l.b.a.b.f.b aaFB;
  public static final Set<kotlin.l.b.a.b.f.b> aaFC;
  public static final a aaFI;
  public static final kotlin.l.b.a.b.f.f aaFJ;
  public static final kotlin.l.b.a.b.f.f aaFw;
  public static final kotlin.l.b.a.b.f.b aaFx;
  private static final kotlin.l.b.a.b.f.b aaFy;
  public static final kotlin.l.b.a.b.f.b aaFz;
  w aaFD;
  private final kotlin.l.b.a.b.l.f<b> aaFE;
  private final kotlin.l.b.a.b.l.f<Collection<ad>> aaFF;
  private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, e> aaFG;
  public final kotlin.l.b.a.b.l.j aaFH;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = kotlin.l.b.a.b.f.f.bHb("kotlin");
      aaFw = (kotlin.l.b.a.b.f.f)localObject;
      localObject = kotlin.l.b.a.b.f.b.r((kotlin.l.b.a.b.f.f)localObject);
      aaFx = (kotlin.l.b.a.b.f.b)localObject;
      aaFy = ((kotlin.l.b.a.b.f.b)localObject).p(kotlin.l.b.a.b.f.f.bHb("annotation"));
      aaFz = aaFx.p(kotlin.l.b.a.b.f.f.bHb("collections"));
      aaFA = aaFx.p(kotlin.l.b.a.b.f.f.bHb("ranges"));
      aaFB = aaFx.p(kotlin.l.b.a.b.f.f.bHb("text"));
      aaFC = ak.setOf(new kotlin.l.b.a.b.f.b[] { aaFx, aaFz, aaFA, aaFy, j.iDI(), aaFx.p(kotlin.l.b.a.b.f.f.bHb("internal")), kotlin.l.b.a.b.j.c.abjZ });
      aaFI = new a();
      aaFJ = kotlin.l.b.a.b.f.f.bHd("<built-ins module>");
      return;
    }
  }
  
  protected g(kotlin.l.b.a.b.l.j paramj)
  {
    this.aaFH = paramj;
    this.aaFF = paramj.av(new kotlin.g.a.a() {});
    this.aaFE = paramj.av(new kotlin.g.a.a() {});
    this.aaFG = paramj.ak(new kotlin.g.a.b() {});
  }
  
  public static boolean A(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(131);
    }
    return (z(paramab)) && (paramab.iIu());
  }
  
  public static boolean B(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(132);
    }
    return A(paramab);
  }
  
  public static boolean C(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(133);
    }
    return b(paramab, aaFI.aaFQ);
  }
  
  public static boolean D(kotlin.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, aaFI.aaFS));
  }
  
  private static boolean a(kotlin.l.b.a.b.b.h paramh, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      aDG(99);
    }
    if (paramc == null) {
      aDG(100);
    }
    return (paramh.iEU().equals(paramc.iNA())) && (paramc.equals(kotlin.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      aDG(93);
    }
    if (paramc == null) {
      aDG(94);
    }
    return a(paramab.iOU(), paramc);
  }
  
  public static boolean a(at paramat, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      aDG(97);
    }
    if (paramc == null) {
      aDG(98);
    }
    paramat = paramat.iEf();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String aDH(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      aDG(17);
    }
    return str;
  }
  
  public static kotlin.l.b.a.b.f.a aDI(int paramInt)
  {
    return new kotlin.l.b.a.b.f.a(aaFx, kotlin.l.b.a.b.f.f.bHb(aDH(paramInt)));
  }
  
  public static boolean b(kotlin.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      aDG(75);
    }
    return aaFI.aaHk.get(paramc) != null;
  }
  
  private static boolean b(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      aDG(101);
    }
    if (paramc == null) {
      aDG(102);
    }
    return (!paramab.iIu()) && (a(paramab, paramc));
  }
  
  public static kotlin.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      aDG(152);
    }
    return aaFx.p(paramh.iDF());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      aDG(85);
    }
    return (a(parame, aaFI.aaFT)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      aDG(8);
    }
    if (kotlin.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      aDG(125);
    }
    if (paramc == null) {
      aDG(126);
    }
    return (a(paramab, paramc)) && (!paramab.iIu());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      aDG(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      aDG(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof kotlin.l.b.a.b.b.ab)) {
        return ((kotlin.l.b.a.b.b.ab)paraml).iFy().q(aaFw);
      }
      paraml = paraml.iDJ();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      aDG(76);
    }
    if (aaFI.aaHh.contains(paraml.iEU())) {
      return (h)aaFI.aaHj.get(kotlin.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      aDG(103);
    }
    return (a(parame, aaFI.aaFM)) || (a(parame, aaFI.aaFN));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      aDG(77);
    }
    if (aaFI.aaHi.contains(paraml.iEU())) {
      return (h)aaFI.aaHk.get(kotlin.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      aDG(104);
    }
    return a(parame, aaFI.aaFM);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      aDG(147);
    }
    return a(parame, aaFI.aaGN);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      aDG(150);
    }
    if (paraml.iER().iDY().h(aaFI.aaGj)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).iFU();
      ai localai = ((ah)paraml).iFC();
      paraml = ((ah)paraml).iFD();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(84);
    }
    return a(paramab, aaFI.aaFT);
  }
  
  public static boolean n(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(87);
    }
    paramab = paramab.iOU().iEf();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(90);
    }
    if (!paramab.iIu())
    {
      if (paramab == null) {
        aDG(91);
      }
      paramab = paramab.iOU().iEf();
      if (((paramab instanceof e)) && (d((e)paramab))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean p(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(106);
    }
    return c(paramab, aaFI.aaFU);
  }
  
  public static boolean q(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(110);
    }
    return c(paramab, aaFI.aaFV);
  }
  
  public static boolean r(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(112);
    }
    return c(paramab, aaFI.aaFY);
  }
  
  public static boolean s(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(113);
    }
    return c(paramab, aaFI.aaFW);
  }
  
  public static boolean t(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(114);
    }
    return c(paramab, aaFI.aaFZ);
  }
  
  public static boolean u(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(116);
    }
    return c(paramab, aaFI.aaFX);
  }
  
  public static boolean v(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(117);
    }
    if (paramab == null) {
      aDG(118);
    }
    return (a(paramab, aaFI.aaGa)) && (!paramab.iIu());
  }
  
  public static boolean w(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(119);
    }
    if (paramab == null) {
      aDG(124);
    }
    return (a(paramab, aaFI.aaGb)) && (!paramab.iIu());
  }
  
  public static boolean x(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(127);
    }
    return (y(paramab)) && (!bc.aE(paramab));
  }
  
  public static boolean y(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(129);
    }
    return a(paramab, aaFI.aaFN);
  }
  
  public static boolean z(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(130);
    }
    return a(paramab, aaFI.aaFM);
  }
  
  public final e a(kotlin.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      aDG(11);
    }
    e locale = q.a(this.aaFD, paramb, kotlin.l.b.a.b.c.a.c.aaQz);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      aDG(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      aDG(52);
    }
    if (paramh == null) {
      aDG(15);
    }
    paramh = bGC(paramh.iDF().qu()).iET();
    if (paramh == null) {
      aDG(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, kotlin.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      aDG(78);
    }
    if (paramab == null) {
      aDG(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = kotlin.l.b.a.b.b.a.g.aaLw;
    parambh = ac.a(kotlin.l.b.a.b.b.a.g.a.iGe(), bGC("Array"), parambh);
    if (parambh == null) {
      aDG(80);
    }
    return parambh;
  }
  
  public final e aDJ(int paramInt)
  {
    Object localObject = kotlin.l.b.a.b.f.f.bHb(b.c.aaIv.aaIA + paramInt);
    localObject = a(kotlin.l.b.a.b.j.c.abjZ.p((kotlin.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      aDG(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      aDG(72);
    }
    paramh = (aj)((b)this.aaFE.invoke()).aaHl.get(paramh);
    if (paramh == null) {
      aDG(73);
    }
    return paramh;
  }
  
  public final e bGC(String paramString)
  {
    if (paramString == null) {
      aDG(13);
    }
    paramString = (e)this.aaFG.invoke(kotlin.l.b.a.b.f.f.bHb(paramString));
    if (paramString == null) {
      aDG(14);
    }
    return paramString;
  }
  
  public final aj iDA()
  {
    aj localaj = a(h.aaHu);
    if (localaj == null) {
      aDG(58);
    }
    return localaj;
  }
  
  public final aj iDB()
  {
    aj localaj = a(h.aaHo);
    if (localaj == null) {
      aDG(62);
    }
    return localaj;
  }
  
  public final aj iDC()
  {
    aj localaj = bGC("Unit").iET();
    if (localaj == null) {
      aDG(63);
    }
    return localaj;
  }
  
  public final aj iDD()
  {
    aj localaj = bGC("String").iET();
    if (localaj == null) {
      aDG(64);
    }
    return localaj;
  }
  
  protected final void iDo()
  {
    this.aaFD = new w(aaFJ, this.aaFH, this);
    w localw = this.aaFD;
    Object localObject = a.aaFo;
    localObject = a.a.iDl();
    iDr();
    iDq();
    iDp();
    localw.a(((a)localObject).iDk());
    this.aaFD.a(new w[] { this.aaFD });
  }
  
  protected kotlin.l.b.a.b.b.b.a iDp()
  {
    kotlin.l.b.a.b.b.b.a.a locala = kotlin.l.b.a.b.b.b.a.a.aaMJ;
    if (locala == null) {
      aDG(2);
    }
    return locala;
  }
  
  protected kotlin.l.b.a.b.b.b.c iDq()
  {
    c.b localb = c.b.aaML;
    if (localb == null) {
      aDG(3);
    }
    return localb;
  }
  
  protected Iterable<kotlin.l.b.a.b.b.b.b> iDr()
  {
    List localList = Collections.singletonList(new kotlin.l.b.a.b.a.a.a(this.aaFH, this.aaFD));
    if (localList == null) {
      aDG(4);
    }
    return localList;
  }
  
  public final w iDs()
  {
    w localw = this.aaFD;
    if (localw == null) {
      aDG(6);
    }
    return localw;
  }
  
  public final aj iDt()
  {
    aj localaj = bGC("Nothing").iET();
    if (localaj == null) {
      aDG(47);
    }
    return localaj;
  }
  
  public final aj iDu()
  {
    aj localaj = bGC("Any").iET();
    if (localaj == null) {
      aDG(49);
    }
    return localaj;
  }
  
  public final aj iDv()
  {
    aj localaj = iDu().Jn(true);
    if (localaj == null) {
      aDG(50);
    }
    return localaj;
  }
  
  public final aj iDw()
  {
    aj localaj = iDv();
    if (localaj == null) {
      aDG(51);
    }
    return localaj;
  }
  
  public final aj iDx()
  {
    aj localaj = a(h.aaHq);
    if (localaj == null) {
      aDG(55);
    }
    return localaj;
  }
  
  public final aj iDy()
  {
    aj localaj = a(h.aaHr);
    if (localaj == null) {
      aDG(56);
    }
    return localaj;
  }
  
  public final aj iDz()
  {
    aj localaj = a(h.aaHs);
    if (localaj == null) {
      aDG(57);
    }
    return localaj;
  }
  
  public final kotlin.l.b.a.b.m.ab l(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      aDG(66);
    }
    if (m(paramab))
    {
      if (paramab.iOR().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.iOR().get(0)).iFN();
      paramab = (kotlin.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        aDG(67);
        paramab = (kotlin.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aD(paramab);
      localObject1 = (kotlin.l.b.a.b.m.ab)((b)this.aaFE.invoke()).aaHn.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (kotlin.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    aDG(68);
    return localObject1;
    Object localObject1 = kotlin.l.b.a.b.j.c.Y((kotlin.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        aDG(70);
      }
      if (localObject1 == null) {
        aDG(71);
      }
      localObject2 = ((kotlin.l.b.a.b.m.ab)localObject2).iOU().iEf();
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label258;
        }
        paramab = (kotlin.l.b.a.b.m.ab)localObject1;
        if (localObject1 != null) {
          break;
        }
        aDG(69);
        return localObject1;
        m localm = m.aaIi;
        if (!m.c(((kotlin.l.b.a.b.b.h)localObject2).iEU()))
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = kotlin.l.b.a.b.j.d.a.c((kotlin.l.b.a.b.b.h)localObject2);
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localm = m.aaIi;
            localObject2 = m.a((kotlin.l.b.a.b.f.a)localObject2);
            if (localObject2 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = s.b((y)localObject1, (kotlin.l.b.a.b.f.a)localObject2);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((e)localObject1).iET();
              }
            }
          }
        }
      }
    }
    label258:
    throw new IllegalStateException("not array: ".concat(String.valueOf(paramab)));
  }
  
  public static final class a
  {
    public final kotlin.l.b.a.b.f.c aaFM;
    public final kotlin.l.b.a.b.f.c aaFN;
    public final kotlin.l.b.a.b.f.c aaFO;
    public final kotlin.l.b.a.b.f.b aaFP;
    public final kotlin.l.b.a.b.f.c aaFQ;
    public final kotlin.l.b.a.b.f.c aaFR;
    public final kotlin.l.b.a.b.f.c aaFS;
    public final kotlin.l.b.a.b.f.c aaFT;
    public final kotlin.l.b.a.b.f.c aaFU;
    public final kotlin.l.b.a.b.f.c aaFV;
    public final kotlin.l.b.a.b.f.c aaFW;
    public final kotlin.l.b.a.b.f.c aaFX;
    public final kotlin.l.b.a.b.f.c aaFY;
    public final kotlin.l.b.a.b.f.c aaFZ;
    public final kotlin.l.b.a.b.f.b aaGA;
    public final kotlin.l.b.a.b.f.b aaGB;
    public final kotlin.l.b.a.b.f.b aaGC;
    public final kotlin.l.b.a.b.f.b aaGD;
    public final kotlin.l.b.a.b.f.b aaGE;
    public final kotlin.l.b.a.b.f.b aaGF;
    public final kotlin.l.b.a.b.f.b aaGG;
    public final kotlin.l.b.a.b.f.b aaGH;
    public final kotlin.l.b.a.b.f.b aaGI;
    public final kotlin.l.b.a.b.f.b aaGJ;
    public final kotlin.l.b.a.b.f.b aaGK;
    public final kotlin.l.b.a.b.f.b aaGL;
    public final kotlin.l.b.a.b.f.b aaGM;
    public final kotlin.l.b.a.b.f.c aaGN;
    public final kotlin.l.b.a.b.f.c aaGO;
    public final kotlin.l.b.a.b.f.c aaGP;
    public final kotlin.l.b.a.b.f.c aaGQ;
    public final kotlin.l.b.a.b.f.c aaGR;
    public final kotlin.l.b.a.b.f.c aaGS;
    public final kotlin.l.b.a.b.f.c aaGT;
    public final kotlin.l.b.a.b.f.c aaGU;
    public final kotlin.l.b.a.b.f.c aaGV;
    public final kotlin.l.b.a.b.f.c aaGW;
    public final kotlin.l.b.a.b.f.a aaGX;
    public final kotlin.l.b.a.b.f.c aaGY;
    public final kotlin.l.b.a.b.f.b aaGZ;
    public final kotlin.l.b.a.b.f.c aaGa;
    public final kotlin.l.b.a.b.f.c aaGb;
    public final kotlin.l.b.a.b.f.c aaGc;
    public final kotlin.l.b.a.b.f.c aaGd;
    public final kotlin.l.b.a.b.f.c aaGe;
    public final kotlin.l.b.a.b.f.b aaGf;
    public final kotlin.l.b.a.b.f.b aaGg;
    public final kotlin.l.b.a.b.f.c aaGh;
    public final kotlin.l.b.a.b.f.c aaGi;
    public final kotlin.l.b.a.b.f.b aaGj;
    public final kotlin.l.b.a.b.f.b aaGk;
    public final kotlin.l.b.a.b.f.b aaGl;
    public final kotlin.l.b.a.b.f.b aaGm;
    public final kotlin.l.b.a.b.f.b aaGn;
    public final kotlin.l.b.a.b.f.b aaGo;
    public final kotlin.l.b.a.b.f.b aaGp;
    public final kotlin.l.b.a.b.f.b aaGq;
    public final kotlin.l.b.a.b.f.b aaGr;
    public final kotlin.l.b.a.b.f.b aaGs;
    public final kotlin.l.b.a.b.f.b aaGt;
    public final kotlin.l.b.a.b.f.b aaGu;
    public final kotlin.l.b.a.b.f.b aaGv;
    public final kotlin.l.b.a.b.f.b aaGw;
    public final kotlin.l.b.a.b.f.b aaGx;
    public final kotlin.l.b.a.b.f.b aaGy;
    public final kotlin.l.b.a.b.f.b aaGz;
    public final kotlin.l.b.a.b.f.b aaHa;
    public final kotlin.l.b.a.b.f.b aaHb;
    public final kotlin.l.b.a.b.f.b aaHc;
    public final kotlin.l.b.a.b.f.a aaHd;
    public final kotlin.l.b.a.b.f.a aaHe;
    public final kotlin.l.b.a.b.f.a aaHf;
    public final kotlin.l.b.a.b.f.a aaHg;
    public final Set<kotlin.l.b.a.b.f.f> aaHh;
    public final Set<kotlin.l.b.a.b.f.f> aaHi;
    public final Map<kotlin.l.b.a.b.f.c, h> aaHj;
    public final Map<kotlin.l.b.a.b.f.c, h> aaHk;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.aaFM = bGD("Any");
      this.aaFN = bGD("Nothing");
      this.aaFO = bGD("Cloneable");
      this.aaFP = bGE("Suppress");
      this.aaFQ = bGD("Unit");
      this.aaFR = bGD("CharSequence");
      this.aaFS = bGD("String");
      this.aaFT = bGD("Array");
      this.aaFU = bGD("Boolean");
      this.aaFV = bGD("Char");
      this.aaFW = bGD("Byte");
      this.aaFX = bGD("Short");
      this.aaFY = bGD("Int");
      this.aaFZ = bGD("Long");
      this.aaGa = bGD("Float");
      this.aaGb = bGD("Double");
      this.aaGc = bGD("Number");
      this.aaGd = bGD("Enum");
      this.aaGe = bGD("Function");
      this.aaGf = bGE("Throwable");
      this.aaGg = bGE("Comparable");
      this.aaGh = bGG("IntRange");
      this.aaGi = bGG("LongRange");
      this.aaGj = bGE("Deprecated");
      this.aaGk = bGE("DeprecationLevel");
      this.aaGl = bGE("ReplaceWith");
      this.aaGm = bGE("ExtensionFunctionType");
      this.aaGn = bGE("ParameterName");
      this.aaGo = bGE("Annotation");
      this.aaGp = bGI("Target");
      this.aaGq = bGI("AnnotationTarget");
      this.aaGr = bGI("AnnotationRetention");
      this.aaGs = bGI("Retention");
      this.aaGt = bGI("Repeatable");
      this.aaGu = bGI("MustBeDocumented");
      this.aaGv = bGE("UnsafeVariance");
      this.aaGw = bGE("PublishedApi");
      this.aaGx = bGF("Iterator");
      this.aaGy = bGF("Iterable");
      this.aaGz = bGF("Collection");
      this.aaGA = bGF("List");
      this.aaGB = bGF("ListIterator");
      this.aaGC = bGF("Set");
      this.aaGD = bGF("Map");
      this.aaGE = this.aaGD.p(kotlin.l.b.a.b.f.f.bHb("Entry"));
      this.aaGF = bGF("MutableIterator");
      this.aaGG = bGF("MutableIterable");
      this.aaGH = bGF("MutableCollection");
      this.aaGI = bGF("MutableList");
      this.aaGJ = bGF("MutableListIterator");
      this.aaGK = bGF("MutableSet");
      this.aaGL = bGF("MutableMap");
      this.aaGM = this.aaGL.p(kotlin.l.b.a.b.f.f.bHb("MutableEntry"));
      this.aaGN = bGH("KClass");
      this.aaGO = bGH("KCallable");
      this.aaGP = bGH("KProperty0");
      this.aaGQ = bGH("KProperty1");
      this.aaGR = bGH("KProperty2");
      this.aaGS = bGH("KMutableProperty0");
      this.aaGT = bGH("KMutableProperty1");
      this.aaGU = bGH("KMutableProperty2");
      this.aaGV = bGH("KProperty");
      this.aaGW = bGH("KMutableProperty");
      this.aaGX = kotlin.l.b.a.b.f.a.p(this.aaGV.iND());
      this.aaGY = bGH("KDeclarationContainer");
      this.aaGZ = bGE("UByte");
      this.aaHa = bGE("UShort");
      this.aaHb = bGE("UInt");
      this.aaHc = bGE("ULong");
      this.aaHd = kotlin.l.b.a.b.f.a.p(this.aaGZ);
      this.aaHe = kotlin.l.b.a.b.f.a.p(this.aaHa);
      this.aaHf = kotlin.l.b.a.b.f.a.p(this.aaHb);
      this.aaHg = kotlin.l.b.a.b.f.a.p(this.aaHc);
      this.aaHh = kotlin.l.b.a.b.o.a.aFG(h.values().length);
      this.aaHi = kotlin.l.b.a.b.o.a.aFG(h.values().length);
      this.aaHj = kotlin.l.b.a.b.o.a.aFF(h.values().length);
      this.aaHk = kotlin.l.b.a.b.o.a.aFF(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.aaHh.add(localh.iDF());
        this.aaHi.add(localh.iDG());
        this.aaHj.put(bGD(localh.iDF().qu()), localh);
        this.aaHk.put(bGD(localh.iDG().qu()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static kotlin.l.b.a.b.f.c bGD(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        aDG(0);
      }
      paramString = bGE(paramString).iNy();
      if (paramString == null) {
        aDG(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b bGE(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        aDG(2);
      }
      paramString = g.aaFx.p(kotlin.l.b.a.b.f.f.bHb(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b bGF(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.aaFz.p(kotlin.l.b.a.b.f.f.bHb(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.c bGG(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.aaFA.p(kotlin.l.b.a.b.f.f.bHb(paramString)).iNy();
      if (paramString == null) {
        aDG(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.c bGH(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.iDI().p(kotlin.l.b.a.b.f.f.bHb(paramString)).iNy();
      if (paramString == null) {
        aDG(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b bGI(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.iDE().p(kotlin.l.b.a.b.f.f.bHb(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
  
  static final class b
  {
    public final Map<h, aj> aaHl;
    public final Map<kotlin.l.b.a.b.m.ab, aj> aaHm;
    public final Map<aj, aj> aaHn;
    
    private b(Map<h, aj> paramMap, Map<kotlin.l.b.a.b.m.ab, aj> paramMap1, Map<aj, aj> paramMap2)
    {
      AppMethodBeat.i(56680);
      this.aaHl = paramMap;
      this.aaHm = paramMap1;
      this.aaHn = paramMap2;
      AppMethodBeat.o(56680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */