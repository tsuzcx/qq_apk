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
import d.l.b.a.b.l.i;
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
  public static final d.l.b.a.b.f.f KYU;
  public static final d.l.b.a.b.f.b KYV;
  private static final d.l.b.a.b.f.b KYW;
  public static final d.l.b.a.b.f.b KYX;
  public static final d.l.b.a.b.f.b KYY;
  public static final d.l.b.a.b.f.b KYZ;
  public static final Set<d.l.b.a.b.f.b> KZa;
  public static final a KZg;
  public static final d.l.b.a.b.f.f KZh;
  w KZb;
  private final d.l.b.a.b.l.f<b> KZc;
  private final d.l.b.a.b.l.f<Collection<ad>> KZd;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, e> KZe;
  public final i KZf;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = d.l.b.a.b.f.f.aWB("kotlin");
      KYU = (d.l.b.a.b.f.f)localObject;
      localObject = d.l.b.a.b.f.b.r((d.l.b.a.b.f.f)localObject);
      KYV = (d.l.b.a.b.f.b)localObject;
      KYW = ((d.l.b.a.b.f.b)localObject).p(d.l.b.a.b.f.f.aWB("annotation"));
      KYX = KYV.p(d.l.b.a.b.f.f.aWB("collections"));
      KYY = KYV.p(d.l.b.a.b.f.f.aWB("ranges"));
      KYZ = KYV.p(d.l.b.a.b.f.f.aWB("text"));
      KZa = ak.setOf(new d.l.b.a.b.f.b[] { KYV, KYX, KYY, KYW, j.fPT(), KYV.p(d.l.b.a.b.f.f.aWB("internal")), d.l.b.a.b.j.c.LEu });
      KZg = new a();
      KZh = d.l.b.a.b.f.f.aWD("<built-ins module>");
      return;
    }
  }
  
  protected g(i parami)
  {
    this.KZf = parami;
    this.KZd = parami.O(new d.g.a.a() {});
    this.KZc = parami.O(new d.g.a.a() {});
    this.KZe = parami.I(new d.g.a.b() {});
  }
  
  public static boolean A(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(131);
    }
    return (z(paramab)) && (paramab.fUx());
  }
  
  public static boolean B(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(132);
    }
    return A(paramab);
  }
  
  public static boolean C(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(133);
    }
    return b(paramab, KZg.KZo);
  }
  
  public static boolean D(d.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, KZg.KZq));
  }
  
  private static boolean a(d.l.b.a.b.b.h paramh, d.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      agL(99);
    }
    if (paramc == null) {
      agL(100);
    }
    return (paramh.fRf().equals(paramc.fZI())) && (paramc.equals(d.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      agL(93);
    }
    if (paramc == null) {
      agL(94);
    }
    return a(paramab.gbz(), paramc);
  }
  
  public static boolean a(at paramat, d.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      agL(97);
    }
    if (paramc == null) {
      agL(98);
    }
    paramat = paramat.fQq();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String agM(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      agL(17);
    }
    return str;
  }
  
  public static d.l.b.a.b.f.a agN(int paramInt)
  {
    return new d.l.b.a.b.f.a(KYV, d.l.b.a.b.f.f.aWB(agM(paramInt)));
  }
  
  public static boolean b(d.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      agL(75);
    }
    return KZg.LaI.get(paramc) != null;
  }
  
  private static boolean b(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      agL(101);
    }
    if (paramc == null) {
      agL(102);
    }
    return (!paramab.fUx()) && (a(paramab, paramc));
  }
  
  public static d.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      agL(152);
    }
    return KYV.p(paramh.fPQ());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      agL(85);
    }
    return (a(parame, KZg.KZr)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      agL(8);
    }
    if (d.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      agL(125);
    }
    if (paramc == null) {
      agL(126);
    }
    return (a(paramab, paramc)) && (!paramab.fUx());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      agL(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      agL(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof d.l.b.a.b.b.ab)) {
        return ((d.l.b.a.b.b.ab)paraml).fRH().q(KYU);
      }
      paraml = paraml.fPU();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      agL(76);
    }
    if (KZg.LaF.contains(paraml.fRf())) {
      return (h)KZg.LaH.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      agL(103);
    }
    return (a(parame, KZg.KZk)) || (a(parame, KZg.KZl));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      agL(77);
    }
    if (KZg.LaG.contains(paraml.fRf())) {
      return (h)KZg.LaI.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      agL(104);
    }
    return a(parame, KZg.KZk);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      agL(147);
    }
    return a(parame, KZg.Lal);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      agL(150);
    }
    if (paraml.fRc().fQj().h(KZg.KZH)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).fSc();
      ai localai = ((ah)paraml).fRK();
      paraml = ((ah)paraml).fRL();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(84);
    }
    return a(paramab, KZg.KZr);
  }
  
  public static boolean n(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(87);
    }
    paramab = paramab.gbz().fQq();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(90);
    }
    if (!paramab.fUx())
    {
      if (paramab == null) {
        agL(91);
      }
      paramab = paramab.gbz().fQq();
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
      agL(106);
    }
    return c(paramab, KZg.KZs);
  }
  
  public static boolean q(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(110);
    }
    return c(paramab, KZg.KZt);
  }
  
  public static boolean r(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(112);
    }
    return c(paramab, KZg.KZw);
  }
  
  public static boolean s(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(113);
    }
    return c(paramab, KZg.KZu);
  }
  
  public static boolean t(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(114);
    }
    return c(paramab, KZg.KZx);
  }
  
  public static boolean u(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(116);
    }
    return c(paramab, KZg.KZv);
  }
  
  public static boolean v(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(117);
    }
    if (paramab == null) {
      agL(118);
    }
    return (a(paramab, KZg.KZy)) && (!paramab.fUx());
  }
  
  public static boolean w(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(119);
    }
    if (paramab == null) {
      agL(124);
    }
    return (a(paramab, KZg.KZz)) && (!paramab.fUx());
  }
  
  public static boolean x(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(127);
    }
    return (y(paramab)) && (!bc.aF(paramab));
  }
  
  public static boolean y(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(129);
    }
    return a(paramab, KZg.KZl);
  }
  
  public static boolean z(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(130);
    }
    return a(paramab, KZg.KZk);
  }
  
  public final e a(d.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      agL(11);
    }
    e locale = q.a(this.KZb, paramb, d.l.b.a.b.c.a.c.LjV);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      agL(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      agL(52);
    }
    if (paramh == null) {
      agL(15);
    }
    paramh = aWc(paramh.fPQ().rf()).fRe();
    if (paramh == null) {
      agL(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, d.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      agL(78);
    }
    if (paramab == null) {
      agL(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = d.l.b.a.b.b.a.g.LeU;
    parambh = ac.a(d.l.b.a.b.b.a.g.a.fSm(), aWc("Array"), parambh);
    if (parambh == null) {
      agL(80);
    }
    return parambh;
  }
  
  public final e aWc(String paramString)
  {
    if (paramString == null) {
      agL(13);
    }
    paramString = (e)this.KZe.ay(d.l.b.a.b.f.f.aWB(paramString));
    if (paramString == null) {
      agL(14);
    }
    return paramString;
  }
  
  public final e agO(int paramInt)
  {
    Object localObject = d.l.b.a.b.f.f.aWB(b.c.LbT.LbY + paramInt);
    localObject = a(d.l.b.a.b.j.c.LEu.p((d.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      agL(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      agL(72);
    }
    paramh = (aj)((b)this.KZc.invoke()).LaJ.get(paramh);
    if (paramh == null) {
      agL(73);
    }
    return paramh;
  }
  
  protected d.l.b.a.b.b.b.a fPA()
  {
    d.l.b.a.b.b.b.a.a locala = d.l.b.a.b.b.b.a.a.Lgf;
    if (locala == null) {
      agL(2);
    }
    return locala;
  }
  
  protected d.l.b.a.b.b.b.c fPB()
  {
    c.b localb = c.b.Lgh;
    if (localb == null) {
      agL(3);
    }
    return localb;
  }
  
  protected Iterable<d.l.b.a.b.b.b.b> fPC()
  {
    List localList = Collections.singletonList(new d.l.b.a.b.a.a.a(this.KZf, this.KZb));
    if (localList == null) {
      agL(4);
    }
    return localList;
  }
  
  public final w fPD()
  {
    w localw = this.KZb;
    if (localw == null) {
      agL(6);
    }
    return localw;
  }
  
  public final aj fPE()
  {
    aj localaj = aWc("Nothing").fRe();
    if (localaj == null) {
      agL(47);
    }
    return localaj;
  }
  
  public final aj fPF()
  {
    aj localaj = aWc("Any").fRe();
    if (localaj == null) {
      agL(49);
    }
    return localaj;
  }
  
  public final aj fPG()
  {
    aj localaj = fPF().zo(true);
    if (localaj == null) {
      agL(50);
    }
    return localaj;
  }
  
  public final aj fPH()
  {
    aj localaj = fPG();
    if (localaj == null) {
      agL(51);
    }
    return localaj;
  }
  
  public final aj fPI()
  {
    aj localaj = a(h.LaO);
    if (localaj == null) {
      agL(55);
    }
    return localaj;
  }
  
  public final aj fPJ()
  {
    aj localaj = a(h.LaP);
    if (localaj == null) {
      agL(56);
    }
    return localaj;
  }
  
  public final aj fPK()
  {
    aj localaj = a(h.LaQ);
    if (localaj == null) {
      agL(57);
    }
    return localaj;
  }
  
  public final aj fPL()
  {
    aj localaj = a(h.LaS);
    if (localaj == null) {
      agL(58);
    }
    return localaj;
  }
  
  public final aj fPM()
  {
    aj localaj = a(h.LaM);
    if (localaj == null) {
      agL(62);
    }
    return localaj;
  }
  
  public final aj fPN()
  {
    aj localaj = aWc("Unit").fRe();
    if (localaj == null) {
      agL(63);
    }
    return localaj;
  }
  
  public final aj fPO()
  {
    aj localaj = aWc("String").fRe();
    if (localaj == null) {
      agL(64);
    }
    return localaj;
  }
  
  protected final void fPz()
  {
    this.KZb = new w(KZh, this.KZf, this);
    w localw = this.KZb;
    Object localObject = a.KYM;
    localObject = a.a.fPw();
    fPC();
    fPB();
    fPA();
    localw.a(((a)localObject).fPv());
    this.KZb.a(new w[] { this.KZb });
  }
  
  public final d.l.b.a.b.m.ab l(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      agL(66);
    }
    if (m(paramab))
    {
      if (paramab.gbw().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.gbw().get(0)).fRV();
      paramab = (d.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        agL(67);
        paramab = (d.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aE(paramab);
      localObject1 = (d.l.b.a.b.m.ab)((b)this.KZc.invoke()).LaL.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (d.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    agL(68);
    return localObject1;
    Object localObject1 = d.l.b.a.b.j.c.Z((d.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        agL(70);
      }
      if (localObject1 == null) {
        agL(71);
      }
      localObject2 = ((d.l.b.a.b.m.ab)localObject2).gbz().fQq();
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
        agL(69);
        return localObject1;
        m localm = m.LbG;
        if (!m.c(((d.l.b.a.b.b.h)localObject2).fRf()))
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
            localm = m.LbG;
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
                localObject1 = ((e)localObject1).fRe();
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
    public final d.l.b.a.b.f.c KZA;
    public final d.l.b.a.b.f.c KZB;
    public final d.l.b.a.b.f.c KZC;
    public final d.l.b.a.b.f.b KZD;
    public final d.l.b.a.b.f.b KZE;
    public final d.l.b.a.b.f.c KZF;
    public final d.l.b.a.b.f.c KZG;
    public final d.l.b.a.b.f.b KZH;
    public final d.l.b.a.b.f.b KZI;
    public final d.l.b.a.b.f.b KZJ;
    public final d.l.b.a.b.f.b KZK;
    public final d.l.b.a.b.f.b KZL;
    public final d.l.b.a.b.f.b KZM;
    public final d.l.b.a.b.f.b KZN;
    public final d.l.b.a.b.f.b KZO;
    public final d.l.b.a.b.f.b KZP;
    public final d.l.b.a.b.f.b KZQ;
    public final d.l.b.a.b.f.b KZR;
    public final d.l.b.a.b.f.b KZS;
    public final d.l.b.a.b.f.b KZT;
    public final d.l.b.a.b.f.b KZU;
    public final d.l.b.a.b.f.b KZV;
    public final d.l.b.a.b.f.b KZW;
    public final d.l.b.a.b.f.b KZX;
    public final d.l.b.a.b.f.b KZY;
    public final d.l.b.a.b.f.b KZZ;
    public final d.l.b.a.b.f.c KZk;
    public final d.l.b.a.b.f.c KZl;
    public final d.l.b.a.b.f.c KZm;
    public final d.l.b.a.b.f.b KZn;
    public final d.l.b.a.b.f.c KZo;
    public final d.l.b.a.b.f.c KZp;
    public final d.l.b.a.b.f.c KZq;
    public final d.l.b.a.b.f.c KZr;
    public final d.l.b.a.b.f.c KZs;
    public final d.l.b.a.b.f.c KZt;
    public final d.l.b.a.b.f.c KZu;
    public final d.l.b.a.b.f.c KZv;
    public final d.l.b.a.b.f.c KZw;
    public final d.l.b.a.b.f.c KZx;
    public final d.l.b.a.b.f.c KZy;
    public final d.l.b.a.b.f.c KZz;
    public final d.l.b.a.b.f.b LaA;
    public final d.l.b.a.b.f.a LaB;
    public final d.l.b.a.b.f.a LaC;
    public final d.l.b.a.b.f.a LaD;
    public final d.l.b.a.b.f.a LaE;
    public final Set<d.l.b.a.b.f.f> LaF;
    public final Set<d.l.b.a.b.f.f> LaG;
    public final Map<d.l.b.a.b.f.c, h> LaH;
    public final Map<d.l.b.a.b.f.c, h> LaI;
    public final d.l.b.a.b.f.b Laa;
    public final d.l.b.a.b.f.b Lab;
    public final d.l.b.a.b.f.b Lac;
    public final d.l.b.a.b.f.b Lad;
    public final d.l.b.a.b.f.b Lae;
    public final d.l.b.a.b.f.b Laf;
    public final d.l.b.a.b.f.b Lag;
    public final d.l.b.a.b.f.b Lah;
    public final d.l.b.a.b.f.b Lai;
    public final d.l.b.a.b.f.b Laj;
    public final d.l.b.a.b.f.b Lak;
    public final d.l.b.a.b.f.c Lal;
    public final d.l.b.a.b.f.c Lam;
    public final d.l.b.a.b.f.c Lan;
    public final d.l.b.a.b.f.c Lao;
    public final d.l.b.a.b.f.c Lap;
    public final d.l.b.a.b.f.c Laq;
    public final d.l.b.a.b.f.c Lar;
    public final d.l.b.a.b.f.c Las;
    public final d.l.b.a.b.f.c Lat;
    public final d.l.b.a.b.f.c Lau;
    public final d.l.b.a.b.f.a Lav;
    public final d.l.b.a.b.f.c Law;
    public final d.l.b.a.b.f.b Lax;
    public final d.l.b.a.b.f.b Lay;
    public final d.l.b.a.b.f.b Laz;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.KZk = aWd("Any");
      this.KZl = aWd("Nothing");
      this.KZm = aWd("Cloneable");
      this.KZn = aWe("Suppress");
      this.KZo = aWd("Unit");
      this.KZp = aWd("CharSequence");
      this.KZq = aWd("String");
      this.KZr = aWd("Array");
      this.KZs = aWd("Boolean");
      this.KZt = aWd("Char");
      this.KZu = aWd("Byte");
      this.KZv = aWd("Short");
      this.KZw = aWd("Int");
      this.KZx = aWd("Long");
      this.KZy = aWd("Float");
      this.KZz = aWd("Double");
      this.KZA = aWd("Number");
      this.KZB = aWd("Enum");
      this.KZC = aWd("Function");
      this.KZD = aWe("Throwable");
      this.KZE = aWe("Comparable");
      this.KZF = aWg("IntRange");
      this.KZG = aWg("LongRange");
      this.KZH = aWe("Deprecated");
      this.KZI = aWe("DeprecationLevel");
      this.KZJ = aWe("ReplaceWith");
      this.KZK = aWe("ExtensionFunctionType");
      this.KZL = aWe("ParameterName");
      this.KZM = aWe("Annotation");
      this.KZN = aWi("Target");
      this.KZO = aWi("AnnotationTarget");
      this.KZP = aWi("AnnotationRetention");
      this.KZQ = aWi("Retention");
      this.KZR = aWi("Repeatable");
      this.KZS = aWi("MustBeDocumented");
      this.KZT = aWe("UnsafeVariance");
      this.KZU = aWe("PublishedApi");
      this.KZV = aWf("Iterator");
      this.KZW = aWf("Iterable");
      this.KZX = aWf("Collection");
      this.KZY = aWf("List");
      this.KZZ = aWf("ListIterator");
      this.Laa = aWf("Set");
      this.Lab = aWf("Map");
      this.Lac = this.Lab.p(d.l.b.a.b.f.f.aWB("Entry"));
      this.Lad = aWf("MutableIterator");
      this.Lae = aWf("MutableIterable");
      this.Laf = aWf("MutableCollection");
      this.Lag = aWf("MutableList");
      this.Lah = aWf("MutableListIterator");
      this.Lai = aWf("MutableSet");
      this.Laj = aWf("MutableMap");
      this.Lak = this.Laj.p(d.l.b.a.b.f.f.aWB("MutableEntry"));
      this.Lal = aWh("KClass");
      this.Lam = aWh("KCallable");
      this.Lan = aWh("KProperty0");
      this.Lao = aWh("KProperty1");
      this.Lap = aWh("KProperty2");
      this.Laq = aWh("KMutableProperty0");
      this.Lar = aWh("KMutableProperty1");
      this.Las = aWh("KMutableProperty2");
      this.Lat = aWh("KProperty");
      this.Lau = aWh("KMutableProperty");
      this.Lav = d.l.b.a.b.f.a.p(this.Lat.fZL());
      this.Law = aWh("KDeclarationContainer");
      this.Lax = aWe("UByte");
      this.Lay = aWe("UShort");
      this.Laz = aWe("UInt");
      this.LaA = aWe("ULong");
      this.LaB = d.l.b.a.b.f.a.p(this.Lax);
      this.LaC = d.l.b.a.b.f.a.p(this.Lay);
      this.LaD = d.l.b.a.b.f.a.p(this.Laz);
      this.LaE = d.l.b.a.b.f.a.p(this.LaA);
      this.LaF = d.l.b.a.b.o.a.aiS(h.values().length);
      this.LaG = d.l.b.a.b.o.a.aiS(h.values().length);
      this.LaH = d.l.b.a.b.o.a.aiR(h.values().length);
      this.LaI = d.l.b.a.b.o.a.aiR(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.LaF.add(localh.fPQ());
        this.LaG.add(localh.fPR());
        this.LaH.put(aWd(localh.fPQ().rf()), localh);
        this.LaI.put(aWd(localh.fPR().rf()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static d.l.b.a.b.f.c aWd(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        agL(0);
      }
      paramString = aWe(paramString).fZG();
      if (paramString == null) {
        agL(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aWe(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        agL(2);
      }
      paramString = g.KYV.p(d.l.b.a.b.f.f.aWB(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aWf(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.KYX.p(d.l.b.a.b.f.f.aWB(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c aWg(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.KYY.p(d.l.b.a.b.f.f.aWB(paramString)).fZG();
      if (paramString == null) {
        agL(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c aWh(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.fPT().p(d.l.b.a.b.f.f.aWB(paramString)).fZG();
      if (paramString == null) {
        agL(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aWi(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.fPP().p(d.l.b.a.b.f.f.aWB(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
  
  static final class b
  {
    public final Map<h, aj> LaJ;
    public final Map<d.l.b.a.b.m.ab, aj> LaK;
    public final Map<aj, aj> LaL;
    
    private b(Map<h, aj> paramMap, Map<d.l.b.a.b.m.ab, aj> paramMap1, Map<aj, aj> paramMap2)
    {
      AppMethodBeat.i(56680);
      this.LaJ = paramMap;
      this.LaK = paramMap1;
      this.LaL = paramMap2;
      AppMethodBeat.o(56680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */