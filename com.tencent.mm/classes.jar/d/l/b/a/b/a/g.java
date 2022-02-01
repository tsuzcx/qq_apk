package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.l.b.a.b.a.a.b.c;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.b.c.b;
import d.l.b.a.b.b.c.w;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.q;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bh;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class g
{
  public static final d.l.b.a.b.f.f MPP;
  public static final d.l.b.a.b.f.b MPQ;
  private static final d.l.b.a.b.f.b MPR;
  public static final d.l.b.a.b.f.b MPS;
  public static final d.l.b.a.b.f.b MPT;
  public static final d.l.b.a.b.f.b MPU;
  public static final Set<d.l.b.a.b.f.b> MPV;
  public static final a MQb;
  public static final d.l.b.a.b.f.f MQc;
  w MPW;
  private final d.l.b.a.b.l.f<g.b> MPX;
  private final d.l.b.a.b.l.f<Collection<ad>> MPY;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, e> MPZ;
  public final d.l.b.a.b.l.j MQa;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = d.l.b.a.b.f.f.bcE("kotlin");
      MPP = (d.l.b.a.b.f.f)localObject;
      localObject = d.l.b.a.b.f.b.r((d.l.b.a.b.f.f)localObject);
      MPQ = (d.l.b.a.b.f.b)localObject;
      MPR = ((d.l.b.a.b.f.b)localObject).p(d.l.b.a.b.f.f.bcE("annotation"));
      MPS = MPQ.p(d.l.b.a.b.f.f.bcE("collections"));
      MPT = MPQ.p(d.l.b.a.b.f.f.bcE("ranges"));
      MPU = MPQ.p(d.l.b.a.b.f.f.bcE("text"));
      MPV = ak.setOf(new d.l.b.a.b.f.b[] { MPQ, MPS, MPT, MPR, j.ghr(), MPQ.p(d.l.b.a.b.f.f.bcE("internal")), d.l.b.a.b.j.c.Nvt });
      MQb = new a();
      MQc = d.l.b.a.b.f.f.bcG("<built-ins module>");
      return;
    }
  }
  
  protected g(d.l.b.a.b.l.j paramj)
  {
    this.MQa = paramj;
    this.MPY = paramj.S(new d.g.a.a() {});
    this.MPX = paramj.S(new d.g.a.a() {});
    this.MPZ = paramj.I(new d.g.a.b() {});
  }
  
  public static boolean A(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(131);
    }
    return (z(paramab)) && (paramab.glW());
  }
  
  public static boolean B(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(132);
    }
    return A(paramab);
  }
  
  public static boolean C(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(133);
    }
    return b(paramab, MQb.MQj);
  }
  
  public static boolean D(d.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, MQb.MQl));
  }
  
  private static boolean a(d.l.b.a.b.b.h paramh, d.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      ajm(99);
    }
    if (paramc == null) {
      ajm(100);
    }
    return (paramh.giD().equals(paramc.grh())) && (paramc.equals(d.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajm(93);
    }
    if (paramc == null) {
      ajm(94);
    }
    return a(paramab.gsZ(), paramc);
  }
  
  public static boolean a(at paramat, d.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      ajm(97);
    }
    if (paramc == null) {
      ajm(98);
    }
    paramat = paramat.ghO();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String ajn(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      ajm(17);
    }
    return str;
  }
  
  public static d.l.b.a.b.f.a ajo(int paramInt)
  {
    return new d.l.b.a.b.f.a(MPQ, d.l.b.a.b.f.f.bcE(ajn(paramInt)));
  }
  
  public static boolean b(d.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      ajm(75);
    }
    return MQb.MRD.get(paramc) != null;
  }
  
  private static boolean b(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajm(101);
    }
    if (paramc == null) {
      ajm(102);
    }
    return (!paramab.glW()) && (a(paramab, paramc));
  }
  
  public static d.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      ajm(152);
    }
    return MPQ.p(paramh.gho());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      ajm(85);
    }
    return (a(parame, MQb.MQm)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      ajm(8);
    }
    if (d.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajm(125);
    }
    if (paramc == null) {
      ajm(126);
    }
    return (a(paramab, paramc)) && (!paramab.glW());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      ajm(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      ajm(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof d.l.b.a.b.b.ab)) {
        return ((d.l.b.a.b.b.ab)paraml).gjg().q(MPP);
      }
      paraml = paraml.ghs();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      ajm(76);
    }
    if (MQb.MRA.contains(paraml.giD())) {
      return (h)MQb.MRC.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      ajm(103);
    }
    return (a(parame, MQb.MQf)) || (a(parame, MQb.MQg));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      ajm(77);
    }
    if (MQb.MRB.contains(paraml.giD())) {
      return (h)MQb.MRD.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      ajm(104);
    }
    return a(parame, MQb.MQf);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      ajm(147);
    }
    return a(parame, MQb.MRg);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      ajm(150);
    }
    if (paraml.giA().ghH().h(MQb.MQC)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).gjB();
      ai localai = ((ah)paraml).gjj();
      paraml = ((ah)paraml).gjk();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(84);
    }
    return a(paramab, MQb.MQm);
  }
  
  public static boolean n(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(87);
    }
    paramab = paramab.gsZ().ghO();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(90);
    }
    if (!paramab.glW())
    {
      if (paramab == null) {
        ajm(91);
      }
      paramab = paramab.gsZ().ghO();
      if (((paramab instanceof e)) && (d((e)paramab))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean p(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(106);
    }
    return c(paramab, MQb.MQn);
  }
  
  public static boolean q(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(110);
    }
    return c(paramab, MQb.MQo);
  }
  
  public static boolean r(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(112);
    }
    return c(paramab, MQb.MQr);
  }
  
  public static boolean s(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(113);
    }
    return c(paramab, MQb.MQp);
  }
  
  public static boolean t(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(114);
    }
    return c(paramab, MQb.MQs);
  }
  
  public static boolean u(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(116);
    }
    return c(paramab, MQb.MQq);
  }
  
  public static boolean v(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(117);
    }
    if (paramab == null) {
      ajm(118);
    }
    return (a(paramab, MQb.MQt)) && (!paramab.glW());
  }
  
  public static boolean w(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(119);
    }
    if (paramab == null) {
      ajm(124);
    }
    return (a(paramab, MQb.MQu)) && (!paramab.glW());
  }
  
  public static boolean x(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(127);
    }
    return (y(paramab)) && (!bc.aF(paramab));
  }
  
  public static boolean y(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(129);
    }
    return a(paramab, MQb.MQg);
  }
  
  public static boolean z(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(130);
    }
    return a(paramab, MQb.MQf);
  }
  
  public final e a(d.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      ajm(11);
    }
    e locale = q.a(this.MPW, paramb, d.l.b.a.b.c.a.c.NaS);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      ajm(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      ajm(52);
    }
    if (paramh == null) {
      ajm(15);
    }
    paramh = bcf(paramh.gho().sD()).giC();
    if (paramh == null) {
      ajm(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, d.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      ajm(78);
    }
    if (paramab == null) {
      ajm(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = d.l.b.a.b.b.a.g.MVP;
    parambh = ac.a(d.l.b.a.b.b.a.g.a.gjL(), bcf("Array"), parambh);
    if (parambh == null) {
      ajm(80);
    }
    return parambh;
  }
  
  public final e ajp(int paramInt)
  {
    Object localObject = d.l.b.a.b.f.f.bcE(b.c.MSO.MST + paramInt);
    localObject = a(d.l.b.a.b.j.c.Nvt.p((d.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      ajm(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      ajm(72);
    }
    paramh = (aj)((g.b)this.MPX.invoke()).MRE.get(paramh);
    if (paramh == null) {
      ajm(73);
    }
    return paramh;
  }
  
  public final e bcf(String paramString)
  {
    if (paramString == null) {
      ajm(13);
    }
    paramString = (e)this.MPZ.invoke(d.l.b.a.b.f.f.bcE(paramString));
    if (paramString == null) {
      ajm(14);
    }
    return paramString;
  }
  
  protected final void ggX()
  {
    this.MPW = new w(MQc, this.MQa, this);
    w localw = this.MPW;
    Object localObject = a.MPH;
    localObject = a.a.ggU();
    gha();
    ggZ();
    ggY();
    localw.a(((a)localObject).ggT());
    this.MPW.a(new w[] { this.MPW });
  }
  
  protected d.l.b.a.b.b.b.a ggY()
  {
    d.l.b.a.b.b.b.a.a locala = d.l.b.a.b.b.b.a.a.MXb;
    if (locala == null) {
      ajm(2);
    }
    return locala;
  }
  
  protected d.l.b.a.b.b.b.c ggZ()
  {
    c.b localb = c.b.MXd;
    if (localb == null) {
      ajm(3);
    }
    return localb;
  }
  
  protected Iterable<d.l.b.a.b.b.b.b> gha()
  {
    List localList = Collections.singletonList(new d.l.b.a.b.a.a.a(this.MQa, this.MPW));
    if (localList == null) {
      ajm(4);
    }
    return localList;
  }
  
  public final w ghb()
  {
    w localw = this.MPW;
    if (localw == null) {
      ajm(6);
    }
    return localw;
  }
  
  public final aj ghc()
  {
    aj localaj = bcf("Nothing").giC();
    if (localaj == null) {
      ajm(47);
    }
    return localaj;
  }
  
  public final aj ghd()
  {
    aj localaj = bcf("Any").giC();
    if (localaj == null) {
      ajm(49);
    }
    return localaj;
  }
  
  public final aj ghe()
  {
    aj localaj = ghd().Ac(true);
    if (localaj == null) {
      ajm(50);
    }
    return localaj;
  }
  
  public final aj ghf()
  {
    aj localaj = ghe();
    if (localaj == null) {
      ajm(51);
    }
    return localaj;
  }
  
  public final aj ghg()
  {
    aj localaj = a(h.MRJ);
    if (localaj == null) {
      ajm(55);
    }
    return localaj;
  }
  
  public final aj ghh()
  {
    aj localaj = a(h.MRK);
    if (localaj == null) {
      ajm(56);
    }
    return localaj;
  }
  
  public final aj ghi()
  {
    aj localaj = a(h.MRL);
    if (localaj == null) {
      ajm(57);
    }
    return localaj;
  }
  
  public final aj ghj()
  {
    aj localaj = a(h.MRN);
    if (localaj == null) {
      ajm(58);
    }
    return localaj;
  }
  
  public final aj ghk()
  {
    aj localaj = a(h.MRH);
    if (localaj == null) {
      ajm(62);
    }
    return localaj;
  }
  
  public final aj ghl()
  {
    aj localaj = bcf("Unit").giC();
    if (localaj == null) {
      ajm(63);
    }
    return localaj;
  }
  
  public final aj ghm()
  {
    aj localaj = bcf("String").giC();
    if (localaj == null) {
      ajm(64);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.m.ab l(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajm(66);
    }
    if (m(paramab))
    {
      if (paramab.gsW().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.gsW().get(0)).gju();
      paramab = (d.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        ajm(67);
        paramab = (d.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aE(paramab);
      localObject1 = (d.l.b.a.b.m.ab)((g.b)this.MPX.invoke()).MRG.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (d.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    ajm(68);
    return localObject1;
    Object localObject1 = d.l.b.a.b.j.c.Z((d.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        ajm(70);
      }
      if (localObject1 == null) {
        ajm(71);
      }
      localObject2 = ((d.l.b.a.b.m.ab)localObject2).gsZ().ghO();
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label258;
        }
        paramab = (d.l.b.a.b.m.ab)localObject1;
        if (localObject1 != null) {
          break;
        }
        ajm(69);
        return localObject1;
        m localm = m.MSB;
        if (!m.c(((d.l.b.a.b.b.h)localObject2).giD()))
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = d.l.b.a.b.j.d.a.c((d.l.b.a.b.b.h)localObject2);
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localm = m.MSB;
            localObject2 = m.a((d.l.b.a.b.f.a)localObject2);
            if (localObject2 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = s.b((y)localObject1, (d.l.b.a.b.f.a)localObject2);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((e)localObject1).giC();
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
    public final d.l.b.a.b.f.c MQA;
    public final d.l.b.a.b.f.c MQB;
    public final d.l.b.a.b.f.b MQC;
    public final d.l.b.a.b.f.b MQD;
    public final d.l.b.a.b.f.b MQE;
    public final d.l.b.a.b.f.b MQF;
    public final d.l.b.a.b.f.b MQG;
    public final d.l.b.a.b.f.b MQH;
    public final d.l.b.a.b.f.b MQI;
    public final d.l.b.a.b.f.b MQJ;
    public final d.l.b.a.b.f.b MQK;
    public final d.l.b.a.b.f.b MQL;
    public final d.l.b.a.b.f.b MQM;
    public final d.l.b.a.b.f.b MQN;
    public final d.l.b.a.b.f.b MQO;
    public final d.l.b.a.b.f.b MQP;
    public final d.l.b.a.b.f.b MQQ;
    public final d.l.b.a.b.f.b MQR;
    public final d.l.b.a.b.f.b MQS;
    public final d.l.b.a.b.f.b MQT;
    public final d.l.b.a.b.f.b MQU;
    public final d.l.b.a.b.f.b MQV;
    public final d.l.b.a.b.f.b MQW;
    public final d.l.b.a.b.f.b MQX;
    public final d.l.b.a.b.f.b MQY;
    public final d.l.b.a.b.f.b MQZ;
    public final d.l.b.a.b.f.c MQf;
    public final d.l.b.a.b.f.c MQg;
    public final d.l.b.a.b.f.c MQh;
    public final d.l.b.a.b.f.b MQi;
    public final d.l.b.a.b.f.c MQj;
    public final d.l.b.a.b.f.c MQk;
    public final d.l.b.a.b.f.c MQl;
    public final d.l.b.a.b.f.c MQm;
    public final d.l.b.a.b.f.c MQn;
    public final d.l.b.a.b.f.c MQo;
    public final d.l.b.a.b.f.c MQp;
    public final d.l.b.a.b.f.c MQq;
    public final d.l.b.a.b.f.c MQr;
    public final d.l.b.a.b.f.c MQs;
    public final d.l.b.a.b.f.c MQt;
    public final d.l.b.a.b.f.c MQu;
    public final d.l.b.a.b.f.c MQv;
    public final d.l.b.a.b.f.c MQw;
    public final d.l.b.a.b.f.c MQx;
    public final d.l.b.a.b.f.b MQy;
    public final d.l.b.a.b.f.b MQz;
    public final Set<d.l.b.a.b.f.f> MRA;
    public final Set<d.l.b.a.b.f.f> MRB;
    public final Map<d.l.b.a.b.f.c, h> MRC;
    public final Map<d.l.b.a.b.f.c, h> MRD;
    public final d.l.b.a.b.f.b MRa;
    public final d.l.b.a.b.f.b MRb;
    public final d.l.b.a.b.f.b MRc;
    public final d.l.b.a.b.f.b MRd;
    public final d.l.b.a.b.f.b MRe;
    public final d.l.b.a.b.f.b MRf;
    public final d.l.b.a.b.f.c MRg;
    public final d.l.b.a.b.f.c MRh;
    public final d.l.b.a.b.f.c MRi;
    public final d.l.b.a.b.f.c MRj;
    public final d.l.b.a.b.f.c MRk;
    public final d.l.b.a.b.f.c MRl;
    public final d.l.b.a.b.f.c MRm;
    public final d.l.b.a.b.f.c MRn;
    public final d.l.b.a.b.f.c MRo;
    public final d.l.b.a.b.f.c MRp;
    public final d.l.b.a.b.f.a MRq;
    public final d.l.b.a.b.f.c MRr;
    public final d.l.b.a.b.f.b MRs;
    public final d.l.b.a.b.f.b MRt;
    public final d.l.b.a.b.f.b MRu;
    public final d.l.b.a.b.f.b MRv;
    public final d.l.b.a.b.f.a MRw;
    public final d.l.b.a.b.f.a MRx;
    public final d.l.b.a.b.f.a MRy;
    public final d.l.b.a.b.f.a MRz;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.MQf = bcg("Any");
      this.MQg = bcg("Nothing");
      this.MQh = bcg("Cloneable");
      this.MQi = bch("Suppress");
      this.MQj = bcg("Unit");
      this.MQk = bcg("CharSequence");
      this.MQl = bcg("String");
      this.MQm = bcg("Array");
      this.MQn = bcg("Boolean");
      this.MQo = bcg("Char");
      this.MQp = bcg("Byte");
      this.MQq = bcg("Short");
      this.MQr = bcg("Int");
      this.MQs = bcg("Long");
      this.MQt = bcg("Float");
      this.MQu = bcg("Double");
      this.MQv = bcg("Number");
      this.MQw = bcg("Enum");
      this.MQx = bcg("Function");
      this.MQy = bch("Throwable");
      this.MQz = bch("Comparable");
      this.MQA = bcj("IntRange");
      this.MQB = bcj("LongRange");
      this.MQC = bch("Deprecated");
      this.MQD = bch("DeprecationLevel");
      this.MQE = bch("ReplaceWith");
      this.MQF = bch("ExtensionFunctionType");
      this.MQG = bch("ParameterName");
      this.MQH = bch("Annotation");
      this.MQI = bcl("Target");
      this.MQJ = bcl("AnnotationTarget");
      this.MQK = bcl("AnnotationRetention");
      this.MQL = bcl("Retention");
      this.MQM = bcl("Repeatable");
      this.MQN = bcl("MustBeDocumented");
      this.MQO = bch("UnsafeVariance");
      this.MQP = bch("PublishedApi");
      this.MQQ = bci("Iterator");
      this.MQR = bci("Iterable");
      this.MQS = bci("Collection");
      this.MQT = bci("List");
      this.MQU = bci("ListIterator");
      this.MQV = bci("Set");
      this.MQW = bci("Map");
      this.MQX = this.MQW.p(d.l.b.a.b.f.f.bcE("Entry"));
      this.MQY = bci("MutableIterator");
      this.MQZ = bci("MutableIterable");
      this.MRa = bci("MutableCollection");
      this.MRb = bci("MutableList");
      this.MRc = bci("MutableListIterator");
      this.MRd = bci("MutableSet");
      this.MRe = bci("MutableMap");
      this.MRf = this.MRe.p(d.l.b.a.b.f.f.bcE("MutableEntry"));
      this.MRg = bck("KClass");
      this.MRh = bck("KCallable");
      this.MRi = bck("KProperty0");
      this.MRj = bck("KProperty1");
      this.MRk = bck("KProperty2");
      this.MRl = bck("KMutableProperty0");
      this.MRm = bck("KMutableProperty1");
      this.MRn = bck("KMutableProperty2");
      this.MRo = bck("KProperty");
      this.MRp = bck("KMutableProperty");
      this.MRq = d.l.b.a.b.f.a.p(this.MRo.grk());
      this.MRr = bck("KDeclarationContainer");
      this.MRs = bch("UByte");
      this.MRt = bch("UShort");
      this.MRu = bch("UInt");
      this.MRv = bch("ULong");
      this.MRw = d.l.b.a.b.f.a.p(this.MRs);
      this.MRx = d.l.b.a.b.f.a.p(this.MRt);
      this.MRy = d.l.b.a.b.f.a.p(this.MRu);
      this.MRz = d.l.b.a.b.f.a.p(this.MRv);
      this.MRA = d.l.b.a.b.o.a.alt(h.values().length);
      this.MRB = d.l.b.a.b.o.a.alt(h.values().length);
      this.MRC = d.l.b.a.b.o.a.als(h.values().length);
      this.MRD = d.l.b.a.b.o.a.als(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.MRA.add(localh.gho());
        this.MRB.add(localh.ghp());
        this.MRC.put(bcg(localh.gho().sD()), localh);
        this.MRD.put(bcg(localh.ghp().sD()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static d.l.b.a.b.f.c bcg(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        ajm(0);
      }
      paramString = bch(paramString).grf();
      if (paramString == null) {
        ajm(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bch(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        ajm(2);
      }
      paramString = g.MPQ.p(d.l.b.a.b.f.f.bcE(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bci(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.MPS.p(d.l.b.a.b.f.f.bcE(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c bcj(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.MPT.p(d.l.b.a.b.f.f.bcE(paramString)).grf();
      if (paramString == null) {
        ajm(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c bck(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.ghr().p(d.l.b.a.b.f.f.bcE(paramString)).grf();
      if (paramString == null) {
        ajm(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bcl(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.ghn().p(d.l.b.a.b.f.f.bcE(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */