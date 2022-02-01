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
  public static final d.l.b.a.b.f.f JlA;
  public static final d.l.b.a.b.f.b JlB;
  private static final d.l.b.a.b.f.b JlC;
  public static final d.l.b.a.b.f.b JlD;
  public static final d.l.b.a.b.f.b JlE;
  public static final d.l.b.a.b.f.b JlF;
  public static final Set<d.l.b.a.b.f.b> JlG;
  public static final a JlM;
  public static final d.l.b.a.b.f.f JlN;
  w JlH;
  private final d.l.b.a.b.l.f<g.b> JlI;
  private final d.l.b.a.b.l.f<Collection<ad>> JlJ;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, e> JlK;
  public final i JlL;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = d.l.b.a.b.f.f.aQC("kotlin");
      JlA = (d.l.b.a.b.f.f)localObject;
      localObject = d.l.b.a.b.f.b.r((d.l.b.a.b.f.f)localObject);
      JlB = (d.l.b.a.b.f.b)localObject;
      JlC = ((d.l.b.a.b.f.b)localObject).p(d.l.b.a.b.f.f.aQC("annotation"));
      JlD = JlB.p(d.l.b.a.b.f.f.aQC("collections"));
      JlE = JlB.p(d.l.b.a.b.f.f.aQC("ranges"));
      JlF = JlB.p(d.l.b.a.b.f.f.aQC("text"));
      JlG = ak.setOf(new d.l.b.a.b.f.b[] { JlB, JlD, JlE, JlC, j.fxp(), JlB.p(d.l.b.a.b.f.f.aQC("internal")), d.l.b.a.b.j.c.JRb });
      JlM = new a();
      JlN = d.l.b.a.b.f.f.aQE("<built-ins module>");
      return;
    }
  }
  
  protected g(i parami)
  {
    this.JlL = parami;
    this.JlJ = parami.H(new d.g.a.a() {});
    this.JlI = parami.H(new d.g.a.a() {});
    this.JlK = parami.A(new d.g.a.b() {});
  }
  
  public static boolean A(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(131);
    }
    return (z(paramab)) && (paramab.fBT());
  }
  
  public static boolean B(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(132);
    }
    return A(paramab);
  }
  
  public static boolean C(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(133);
    }
    return b(paramab, JlM.JlU);
  }
  
  public static boolean D(d.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, JlM.JlW));
  }
  
  private static boolean a(d.l.b.a.b.b.h paramh, d.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      adP(99);
    }
    if (paramc == null) {
      adP(100);
    }
    return (paramh.fyB().equals(paramc.fHe())) && (paramc.equals(d.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      adP(93);
    }
    if (paramc == null) {
      adP(94);
    }
    return a(paramab.fIW(), paramc);
  }
  
  public static boolean a(at paramat, d.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      adP(97);
    }
    if (paramc == null) {
      adP(98);
    }
    paramat = paramat.fxM();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String adQ(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      adP(17);
    }
    return str;
  }
  
  public static d.l.b.a.b.f.a adR(int paramInt)
  {
    return new d.l.b.a.b.f.a(JlB, d.l.b.a.b.f.f.aQC(adQ(paramInt)));
  }
  
  public static boolean b(d.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      adP(75);
    }
    return JlM.Jno.get(paramc) != null;
  }
  
  private static boolean b(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      adP(101);
    }
    if (paramc == null) {
      adP(102);
    }
    return (!paramab.fBT()) && (a(paramab, paramc));
  }
  
  public static d.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      adP(152);
    }
    return JlB.p(paramh.fxm());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      adP(85);
    }
    return (a(parame, JlM.JlX)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      adP(8);
    }
    if (d.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      adP(125);
    }
    if (paramc == null) {
      adP(126);
    }
    return (a(paramab, paramc)) && (!paramab.fBT());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      adP(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      adP(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof d.l.b.a.b.b.ab)) {
        return ((d.l.b.a.b.b.ab)paraml).fzd().q(JlA);
      }
      paraml = paraml.fxq();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      adP(76);
    }
    if (JlM.Jnl.contains(paraml.fyB())) {
      return (h)JlM.Jnn.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      adP(103);
    }
    return (a(parame, JlM.JlQ)) || (a(parame, JlM.JlR));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      adP(77);
    }
    if (JlM.Jnm.contains(paraml.fyB())) {
      return (h)JlM.Jno.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      adP(104);
    }
    return a(parame, JlM.JlQ);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      adP(147);
    }
    return a(parame, JlM.JmR);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      adP(150);
    }
    if (paraml.fyy().fxF().h(JlM.Jmn)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).fzy();
      ai localai = ((ah)paraml).fzg();
      paraml = ((ah)paraml).fzh();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(84);
    }
    return a(paramab, JlM.JlX);
  }
  
  public static boolean n(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(87);
    }
    paramab = paramab.fIW().fxM();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(90);
    }
    if (!paramab.fBT())
    {
      if (paramab == null) {
        adP(91);
      }
      paramab = paramab.fIW().fxM();
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
      adP(106);
    }
    return c(paramab, JlM.JlY);
  }
  
  public static boolean q(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(110);
    }
    return c(paramab, JlM.JlZ);
  }
  
  public static boolean r(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(112);
    }
    return c(paramab, JlM.Jmc);
  }
  
  public static boolean s(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(113);
    }
    return c(paramab, JlM.Jma);
  }
  
  public static boolean t(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(114);
    }
    return c(paramab, JlM.Jmd);
  }
  
  public static boolean u(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(116);
    }
    return c(paramab, JlM.Jmb);
  }
  
  public static boolean v(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(117);
    }
    if (paramab == null) {
      adP(118);
    }
    return (a(paramab, JlM.Jme)) && (!paramab.fBT());
  }
  
  public static boolean w(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(119);
    }
    if (paramab == null) {
      adP(124);
    }
    return (a(paramab, JlM.Jmf)) && (!paramab.fBT());
  }
  
  public static boolean x(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(127);
    }
    return (y(paramab)) && (!bc.aF(paramab));
  }
  
  public static boolean y(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(129);
    }
    return a(paramab, JlM.JlR);
  }
  
  public static boolean z(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(130);
    }
    return a(paramab, JlM.JlQ);
  }
  
  public final e a(d.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      adP(11);
    }
    e locale = q.a(this.JlH, paramb, d.l.b.a.b.c.a.c.JwC);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      adP(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      adP(52);
    }
    if (paramh == null) {
      adP(15);
    }
    paramh = aQd(paramh.fxm().qV()).fyA();
    if (paramh == null) {
      adP(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, d.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      adP(78);
    }
    if (paramab == null) {
      adP(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = d.l.b.a.b.b.a.g.JrB;
    parambh = ac.a(d.l.b.a.b.b.a.g.a.fzI(), aQd("Array"), parambh);
    if (parambh == null) {
      adP(80);
    }
    return parambh;
  }
  
  public final e aQd(String paramString)
  {
    if (paramString == null) {
      adP(13);
    }
    paramString = (e)this.JlK.aA(d.l.b.a.b.f.f.aQC(paramString));
    if (paramString == null) {
      adP(14);
    }
    return paramString;
  }
  
  public final e adS(int paramInt)
  {
    Object localObject = d.l.b.a.b.f.f.aQC(b.c.JoA.JoF + paramInt);
    localObject = a(d.l.b.a.b.j.c.JRb.p((d.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      adP(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      adP(72);
    }
    paramh = (aj)((g.b)this.JlI.invoke()).Jnp.get(paramh);
    if (paramh == null) {
      adP(73);
    }
    return paramh;
  }
  
  protected final void fwV()
  {
    this.JlH = new w(JlN, this.JlL, this);
    w localw = this.JlH;
    Object localObject = a.Jls;
    localObject = a.a.fwS();
    fwY();
    fwX();
    fwW();
    localw.a(((a)localObject).fwR());
    this.JlH.a(new w[] { this.JlH });
  }
  
  protected d.l.b.a.b.b.b.a fwW()
  {
    d.l.b.a.b.b.b.a.a locala = d.l.b.a.b.b.b.a.a.JsM;
    if (locala == null) {
      adP(2);
    }
    return locala;
  }
  
  protected d.l.b.a.b.b.b.c fwX()
  {
    c.b localb = c.b.JsO;
    if (localb == null) {
      adP(3);
    }
    return localb;
  }
  
  protected Iterable<d.l.b.a.b.b.b.b> fwY()
  {
    List localList = Collections.singletonList(new d.l.b.a.b.a.a.a(this.JlL, this.JlH));
    if (localList == null) {
      adP(4);
    }
    return localList;
  }
  
  public final w fwZ()
  {
    w localw = this.JlH;
    if (localw == null) {
      adP(6);
    }
    return localw;
  }
  
  public final aj fxa()
  {
    aj localaj = aQd("Nothing").fyA();
    if (localaj == null) {
      adP(47);
    }
    return localaj;
  }
  
  public final aj fxb()
  {
    aj localaj = aQd("Any").fyA();
    if (localaj == null) {
      adP(49);
    }
    return localaj;
  }
  
  public final aj fxc()
  {
    aj localaj = fxb().xW(true);
    if (localaj == null) {
      adP(50);
    }
    return localaj;
  }
  
  public final aj fxd()
  {
    aj localaj = fxc();
    if (localaj == null) {
      adP(51);
    }
    return localaj;
  }
  
  public final aj fxe()
  {
    aj localaj = a(h.Jnu);
    if (localaj == null) {
      adP(55);
    }
    return localaj;
  }
  
  public final aj fxf()
  {
    aj localaj = a(h.Jnv);
    if (localaj == null) {
      adP(56);
    }
    return localaj;
  }
  
  public final aj fxg()
  {
    aj localaj = a(h.Jnw);
    if (localaj == null) {
      adP(57);
    }
    return localaj;
  }
  
  public final aj fxh()
  {
    aj localaj = a(h.Jny);
    if (localaj == null) {
      adP(58);
    }
    return localaj;
  }
  
  public final aj fxi()
  {
    aj localaj = a(h.Jns);
    if (localaj == null) {
      adP(62);
    }
    return localaj;
  }
  
  public final aj fxj()
  {
    aj localaj = aQd("Unit").fyA();
    if (localaj == null) {
      adP(63);
    }
    return localaj;
  }
  
  public final aj fxk()
  {
    aj localaj = aQd("String").fyA();
    if (localaj == null) {
      adP(64);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.m.ab l(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      adP(66);
    }
    if (m(paramab))
    {
      if (paramab.fIT().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.fIT().get(0)).fzr();
      paramab = (d.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        adP(67);
        paramab = (d.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aE(paramab);
      localObject1 = (d.l.b.a.b.m.ab)((g.b)this.JlI.invoke()).Jnr.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (d.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    adP(68);
    return localObject1;
    Object localObject1 = d.l.b.a.b.j.c.Z((d.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        adP(70);
      }
      if (localObject1 == null) {
        adP(71);
      }
      localObject2 = ((d.l.b.a.b.m.ab)localObject2).fIW().fxM();
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
        adP(69);
        return localObject1;
        m localm = m.Jom;
        if (!m.c(((d.l.b.a.b.b.h)localObject2).fyB()))
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
            localm = m.Jom;
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
                localObject1 = ((e)localObject1).fyA();
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
    public final d.l.b.a.b.f.c JlQ;
    public final d.l.b.a.b.f.c JlR;
    public final d.l.b.a.b.f.c JlS;
    public final d.l.b.a.b.f.b JlT;
    public final d.l.b.a.b.f.c JlU;
    public final d.l.b.a.b.f.c JlV;
    public final d.l.b.a.b.f.c JlW;
    public final d.l.b.a.b.f.c JlX;
    public final d.l.b.a.b.f.c JlY;
    public final d.l.b.a.b.f.c JlZ;
    public final d.l.b.a.b.f.b JmA;
    public final d.l.b.a.b.f.b JmB;
    public final d.l.b.a.b.f.b JmC;
    public final d.l.b.a.b.f.b JmD;
    public final d.l.b.a.b.f.b JmE;
    public final d.l.b.a.b.f.b JmF;
    public final d.l.b.a.b.f.b JmG;
    public final d.l.b.a.b.f.b JmH;
    public final d.l.b.a.b.f.b JmI;
    public final d.l.b.a.b.f.b JmJ;
    public final d.l.b.a.b.f.b JmK;
    public final d.l.b.a.b.f.b JmL;
    public final d.l.b.a.b.f.b JmM;
    public final d.l.b.a.b.f.b JmN;
    public final d.l.b.a.b.f.b JmO;
    public final d.l.b.a.b.f.b JmP;
    public final d.l.b.a.b.f.b JmQ;
    public final d.l.b.a.b.f.c JmR;
    public final d.l.b.a.b.f.c JmS;
    public final d.l.b.a.b.f.c JmT;
    public final d.l.b.a.b.f.c JmU;
    public final d.l.b.a.b.f.c JmV;
    public final d.l.b.a.b.f.c JmW;
    public final d.l.b.a.b.f.c JmX;
    public final d.l.b.a.b.f.c JmY;
    public final d.l.b.a.b.f.c JmZ;
    public final d.l.b.a.b.f.c Jma;
    public final d.l.b.a.b.f.c Jmb;
    public final d.l.b.a.b.f.c Jmc;
    public final d.l.b.a.b.f.c Jmd;
    public final d.l.b.a.b.f.c Jme;
    public final d.l.b.a.b.f.c Jmf;
    public final d.l.b.a.b.f.c Jmg;
    public final d.l.b.a.b.f.c Jmh;
    public final d.l.b.a.b.f.c Jmi;
    public final d.l.b.a.b.f.b Jmj;
    public final d.l.b.a.b.f.b Jmk;
    public final d.l.b.a.b.f.c Jml;
    public final d.l.b.a.b.f.c Jmm;
    public final d.l.b.a.b.f.b Jmn;
    public final d.l.b.a.b.f.b Jmo;
    public final d.l.b.a.b.f.b Jmp;
    public final d.l.b.a.b.f.b Jmq;
    public final d.l.b.a.b.f.b Jmr;
    public final d.l.b.a.b.f.b Jms;
    public final d.l.b.a.b.f.b Jmt;
    public final d.l.b.a.b.f.b Jmu;
    public final d.l.b.a.b.f.b Jmv;
    public final d.l.b.a.b.f.b Jmw;
    public final d.l.b.a.b.f.b Jmx;
    public final d.l.b.a.b.f.b Jmy;
    public final d.l.b.a.b.f.b Jmz;
    public final d.l.b.a.b.f.c Jna;
    public final d.l.b.a.b.f.a Jnb;
    public final d.l.b.a.b.f.c Jnc;
    public final d.l.b.a.b.f.b Jnd;
    public final d.l.b.a.b.f.b Jne;
    public final d.l.b.a.b.f.b Jnf;
    public final d.l.b.a.b.f.b Jng;
    public final d.l.b.a.b.f.a Jnh;
    public final d.l.b.a.b.f.a Jni;
    public final d.l.b.a.b.f.a Jnj;
    public final d.l.b.a.b.f.a Jnk;
    public final Set<d.l.b.a.b.f.f> Jnl;
    public final Set<d.l.b.a.b.f.f> Jnm;
    public final Map<d.l.b.a.b.f.c, h> Jnn;
    public final Map<d.l.b.a.b.f.c, h> Jno;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.JlQ = aQe("Any");
      this.JlR = aQe("Nothing");
      this.JlS = aQe("Cloneable");
      this.JlT = aQf("Suppress");
      this.JlU = aQe("Unit");
      this.JlV = aQe("CharSequence");
      this.JlW = aQe("String");
      this.JlX = aQe("Array");
      this.JlY = aQe("Boolean");
      this.JlZ = aQe("Char");
      this.Jma = aQe("Byte");
      this.Jmb = aQe("Short");
      this.Jmc = aQe("Int");
      this.Jmd = aQe("Long");
      this.Jme = aQe("Float");
      this.Jmf = aQe("Double");
      this.Jmg = aQe("Number");
      this.Jmh = aQe("Enum");
      this.Jmi = aQe("Function");
      this.Jmj = aQf("Throwable");
      this.Jmk = aQf("Comparable");
      this.Jml = aQh("IntRange");
      this.Jmm = aQh("LongRange");
      this.Jmn = aQf("Deprecated");
      this.Jmo = aQf("DeprecationLevel");
      this.Jmp = aQf("ReplaceWith");
      this.Jmq = aQf("ExtensionFunctionType");
      this.Jmr = aQf("ParameterName");
      this.Jms = aQf("Annotation");
      this.Jmt = aQj("Target");
      this.Jmu = aQj("AnnotationTarget");
      this.Jmv = aQj("AnnotationRetention");
      this.Jmw = aQj("Retention");
      this.Jmx = aQj("Repeatable");
      this.Jmy = aQj("MustBeDocumented");
      this.Jmz = aQf("UnsafeVariance");
      this.JmA = aQf("PublishedApi");
      this.JmB = aQg("Iterator");
      this.JmC = aQg("Iterable");
      this.JmD = aQg("Collection");
      this.JmE = aQg("List");
      this.JmF = aQg("ListIterator");
      this.JmG = aQg("Set");
      this.JmH = aQg("Map");
      this.JmI = this.JmH.p(d.l.b.a.b.f.f.aQC("Entry"));
      this.JmJ = aQg("MutableIterator");
      this.JmK = aQg("MutableIterable");
      this.JmL = aQg("MutableCollection");
      this.JmM = aQg("MutableList");
      this.JmN = aQg("MutableListIterator");
      this.JmO = aQg("MutableSet");
      this.JmP = aQg("MutableMap");
      this.JmQ = this.JmP.p(d.l.b.a.b.f.f.aQC("MutableEntry"));
      this.JmR = aQi("KClass");
      this.JmS = aQi("KCallable");
      this.JmT = aQi("KProperty0");
      this.JmU = aQi("KProperty1");
      this.JmV = aQi("KProperty2");
      this.JmW = aQi("KMutableProperty0");
      this.JmX = aQi("KMutableProperty1");
      this.JmY = aQi("KMutableProperty2");
      this.JmZ = aQi("KProperty");
      this.Jna = aQi("KMutableProperty");
      this.Jnb = d.l.b.a.b.f.a.p(this.JmZ.fHh());
      this.Jnc = aQi("KDeclarationContainer");
      this.Jnd = aQf("UByte");
      this.Jne = aQf("UShort");
      this.Jnf = aQf("UInt");
      this.Jng = aQf("ULong");
      this.Jnh = d.l.b.a.b.f.a.p(this.Jnd);
      this.Jni = d.l.b.a.b.f.a.p(this.Jne);
      this.Jnj = d.l.b.a.b.f.a.p(this.Jnf);
      this.Jnk = d.l.b.a.b.f.a.p(this.Jng);
      this.Jnl = d.l.b.a.b.o.a.afW(h.values().length);
      this.Jnm = d.l.b.a.b.o.a.afW(h.values().length);
      this.Jnn = d.l.b.a.b.o.a.afV(h.values().length);
      this.Jno = d.l.b.a.b.o.a.afV(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.Jnl.add(localh.fxm());
        this.Jnm.add(localh.fxn());
        this.Jnn.put(aQe(localh.fxm().qV()), localh);
        this.Jno.put(aQe(localh.fxn().qV()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static d.l.b.a.b.f.c aQe(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        adP(0);
      }
      paramString = aQf(paramString).fHc();
      if (paramString == null) {
        adP(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aQf(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        adP(2);
      }
      paramString = g.JlB.p(d.l.b.a.b.f.f.aQC(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aQg(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.JlD.p(d.l.b.a.b.f.f.aQC(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c aQh(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.JlE.p(d.l.b.a.b.f.f.aQC(paramString)).fHc();
      if (paramString == null) {
        adP(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c aQi(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.fxp().p(d.l.b.a.b.f.f.aQC(paramString)).fHc();
      if (paramString == null) {
        adP(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b aQj(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.fxl().p(d.l.b.a.b.f.f.aQC(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */