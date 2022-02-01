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
  public static final d.l.b.a.b.f.f NmU;
  public static final d.l.b.a.b.f.b NmV;
  private static final d.l.b.a.b.f.b NmW;
  public static final d.l.b.a.b.f.b NmX;
  public static final d.l.b.a.b.f.b NmY;
  public static final d.l.b.a.b.f.b NmZ;
  public static final Set<d.l.b.a.b.f.b> Nna;
  public static final a Nng;
  public static final d.l.b.a.b.f.f Nnh;
  w Nnb;
  private final d.l.b.a.b.l.f<b> Nnc;
  private final d.l.b.a.b.l.f<Collection<ad>> Nnd;
  private final d.l.b.a.b.l.c<d.l.b.a.b.f.f, e> Nne;
  public final d.l.b.a.b.l.j Nnf;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = d.l.b.a.b.f.f.bei("kotlin");
      NmU = (d.l.b.a.b.f.f)localObject;
      localObject = d.l.b.a.b.f.b.r((d.l.b.a.b.f.f)localObject);
      NmV = (d.l.b.a.b.f.b)localObject;
      NmW = ((d.l.b.a.b.f.b)localObject).p(d.l.b.a.b.f.f.bei("annotation"));
      NmX = NmV.p(d.l.b.a.b.f.f.bei("collections"));
      NmY = NmV.p(d.l.b.a.b.f.f.bei("ranges"));
      NmZ = NmV.p(d.l.b.a.b.f.f.bei("text"));
      Nna = ak.setOf(new d.l.b.a.b.f.b[] { NmV, NmX, NmY, NmW, j.glT(), NmV.p(d.l.b.a.b.f.f.bei("internal")), d.l.b.a.b.j.c.NSz });
      Nng = new a();
      Nnh = d.l.b.a.b.f.f.bek("<built-ins module>");
      return;
    }
  }
  
  protected g(d.l.b.a.b.l.j paramj)
  {
    this.Nnf = paramj;
    this.Nnd = paramj.S(new d.g.a.a() {});
    this.Nnc = paramj.S(new d.g.a.a() {});
    this.Nne = paramj.L(new d.g.a.b() {});
  }
  
  public static boolean A(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(131);
    }
    return (z(paramab)) && (paramab.gqy());
  }
  
  public static boolean B(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(132);
    }
    return A(paramab);
  }
  
  public static boolean C(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(133);
    }
    return b(paramab, Nng.Nno);
  }
  
  public static boolean D(d.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, Nng.Nnq));
  }
  
  private static boolean a(d.l.b.a.b.b.h paramh, d.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      ajW(99);
    }
    if (paramc == null) {
      ajW(100);
    }
    return (paramh.gnf().equals(paramc.gvJ())) && (paramc.equals(d.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajW(93);
    }
    if (paramc == null) {
      ajW(94);
    }
    return a(paramab.gxB(), paramc);
  }
  
  public static boolean a(at paramat, d.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      ajW(97);
    }
    if (paramc == null) {
      ajW(98);
    }
    paramat = paramat.gmq();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String ajX(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      ajW(17);
    }
    return str;
  }
  
  public static d.l.b.a.b.f.a ajY(int paramInt)
  {
    return new d.l.b.a.b.f.a(NmV, d.l.b.a.b.f.f.bei(ajX(paramInt)));
  }
  
  public static boolean b(d.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      ajW(75);
    }
    return Nng.NoI.get(paramc) != null;
  }
  
  private static boolean b(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajW(101);
    }
    if (paramc == null) {
      ajW(102);
    }
    return (!paramab.gqy()) && (a(paramab, paramc));
  }
  
  public static d.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      ajW(152);
    }
    return NmV.p(paramh.glQ());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      ajW(85);
    }
    return (a(parame, Nng.Nnr)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      ajW(8);
    }
    if (d.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(d.l.b.a.b.m.ab paramab, d.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      ajW(125);
    }
    if (paramc == null) {
      ajW(126);
    }
    return (a(paramab, paramc)) && (!paramab.gqy());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      ajW(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      ajW(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof d.l.b.a.b.b.ab)) {
        return ((d.l.b.a.b.b.ab)paraml).gnI().q(NmU);
      }
      paraml = paraml.glU();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      ajW(76);
    }
    if (Nng.NoF.contains(paraml.gnf())) {
      return (h)Nng.NoH.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      ajW(103);
    }
    return (a(parame, Nng.Nnk)) || (a(parame, Nng.Nnl));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      ajW(77);
    }
    if (Nng.NoG.contains(paraml.gnf())) {
      return (h)Nng.NoI.get(d.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      ajW(104);
    }
    return a(parame, Nng.Nnk);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      ajW(147);
    }
    return a(parame, Nng.Nol);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      ajW(150);
    }
    if (paraml.gnc().gmj().h(Nng.NnH)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).god();
      ai localai = ((ah)paraml).gnL();
      paraml = ((ah)paraml).gnM();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(84);
    }
    return a(paramab, Nng.Nnr);
  }
  
  public static boolean n(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(87);
    }
    paramab = paramab.gxB().gmq();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(90);
    }
    if (!paramab.gqy())
    {
      if (paramab == null) {
        ajW(91);
      }
      paramab = paramab.gxB().gmq();
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
      ajW(106);
    }
    return c(paramab, Nng.Nns);
  }
  
  public static boolean q(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(110);
    }
    return c(paramab, Nng.Nnt);
  }
  
  public static boolean r(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(112);
    }
    return c(paramab, Nng.Nnw);
  }
  
  public static boolean s(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(113);
    }
    return c(paramab, Nng.Nnu);
  }
  
  public static boolean t(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(114);
    }
    return c(paramab, Nng.Nnx);
  }
  
  public static boolean u(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(116);
    }
    return c(paramab, Nng.Nnv);
  }
  
  public static boolean v(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(117);
    }
    if (paramab == null) {
      ajW(118);
    }
    return (a(paramab, Nng.Nny)) && (!paramab.gqy());
  }
  
  public static boolean w(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(119);
    }
    if (paramab == null) {
      ajW(124);
    }
    return (a(paramab, Nng.Nnz)) && (!paramab.gqy());
  }
  
  public static boolean x(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(127);
    }
    return (y(paramab)) && (!bc.aF(paramab));
  }
  
  public static boolean y(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(129);
    }
    return a(paramab, Nng.Nnl);
  }
  
  public static boolean z(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(130);
    }
    return a(paramab, Nng.Nnk);
  }
  
  public final e a(d.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      ajW(11);
    }
    e locale = q.a(this.Nnb, paramb, d.l.b.a.b.c.a.c.NxX);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      ajW(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      ajW(52);
    }
    if (paramh == null) {
      ajW(15);
    }
    paramh = bdJ(paramh.glQ().sD()).gne();
    if (paramh == null) {
      ajW(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, d.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      ajW(78);
    }
    if (paramab == null) {
      ajW(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = d.l.b.a.b.b.a.g.NsU;
    parambh = ac.a(d.l.b.a.b.b.a.g.a.gon(), bdJ("Array"), parambh);
    if (parambh == null) {
      ajW(80);
    }
    return parambh;
  }
  
  public final e ajZ(int paramInt)
  {
    Object localObject = d.l.b.a.b.f.f.bei(b.c.NpT.NpY + paramInt);
    localObject = a(d.l.b.a.b.j.c.NSz.p((d.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      ajW(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      ajW(72);
    }
    paramh = (aj)((b)this.Nnc.invoke()).NoJ.get(paramh);
    if (paramh == null) {
      ajW(73);
    }
    return paramh;
  }
  
  public final e bdJ(String paramString)
  {
    if (paramString == null) {
      ajW(13);
    }
    paramString = (e)this.Nne.invoke(d.l.b.a.b.f.f.bei(paramString));
    if (paramString == null) {
      ajW(14);
    }
    return paramString;
  }
  
  protected d.l.b.a.b.b.b.a glA()
  {
    d.l.b.a.b.b.b.a.a locala = d.l.b.a.b.b.b.a.a.Nuh;
    if (locala == null) {
      ajW(2);
    }
    return locala;
  }
  
  protected d.l.b.a.b.b.b.c glB()
  {
    c.b localb = c.b.Nuj;
    if (localb == null) {
      ajW(3);
    }
    return localb;
  }
  
  protected Iterable<d.l.b.a.b.b.b.b> glC()
  {
    List localList = Collections.singletonList(new d.l.b.a.b.a.a.a(this.Nnf, this.Nnb));
    if (localList == null) {
      ajW(4);
    }
    return localList;
  }
  
  public final w glD()
  {
    w localw = this.Nnb;
    if (localw == null) {
      ajW(6);
    }
    return localw;
  }
  
  public final aj glE()
  {
    aj localaj = bdJ("Nothing").gne();
    if (localaj == null) {
      ajW(47);
    }
    return localaj;
  }
  
  public final aj glF()
  {
    aj localaj = bdJ("Any").gne();
    if (localaj == null) {
      ajW(49);
    }
    return localaj;
  }
  
  public final aj glG()
  {
    aj localaj = glF().Ap(true);
    if (localaj == null) {
      ajW(50);
    }
    return localaj;
  }
  
  public final aj glH()
  {
    aj localaj = glG();
    if (localaj == null) {
      ajW(51);
    }
    return localaj;
  }
  
  public final aj glI()
  {
    aj localaj = a(h.NoO);
    if (localaj == null) {
      ajW(55);
    }
    return localaj;
  }
  
  public final aj glJ()
  {
    aj localaj = a(h.NoP);
    if (localaj == null) {
      ajW(56);
    }
    return localaj;
  }
  
  public final aj glK()
  {
    aj localaj = a(h.NoQ);
    if (localaj == null) {
      ajW(57);
    }
    return localaj;
  }
  
  public final aj glL()
  {
    aj localaj = a(h.NoS);
    if (localaj == null) {
      ajW(58);
    }
    return localaj;
  }
  
  public final aj glM()
  {
    aj localaj = a(h.NoM);
    if (localaj == null) {
      ajW(62);
    }
    return localaj;
  }
  
  public final aj glN()
  {
    aj localaj = bdJ("Unit").gne();
    if (localaj == null) {
      ajW(63);
    }
    return localaj;
  }
  
  public final aj glO()
  {
    aj localaj = bdJ("String").gne();
    if (localaj == null) {
      ajW(64);
    }
    return localaj;
  }
  
  protected final void glz()
  {
    this.Nnb = new w(Nnh, this.Nnf, this);
    w localw = this.Nnb;
    Object localObject = a.NmM;
    localObject = a.a.glw();
    glC();
    glB();
    glA();
    localw.a(((a)localObject).glv());
    this.Nnb.a(new w[] { this.Nnb });
  }
  
  public final d.l.b.a.b.m.ab l(d.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      ajW(66);
    }
    if (m(paramab))
    {
      if (paramab.gxy().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.gxy().get(0)).gnW();
      paramab = (d.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        ajW(67);
        paramab = (d.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aE(paramab);
      localObject1 = (d.l.b.a.b.m.ab)((b)this.Nnc.invoke()).NoL.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (d.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    ajW(68);
    return localObject1;
    Object localObject1 = d.l.b.a.b.j.c.Z((d.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        ajW(70);
      }
      if (localObject1 == null) {
        ajW(71);
      }
      localObject2 = ((d.l.b.a.b.m.ab)localObject2).gxB().gmq();
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
        ajW(69);
        return localObject1;
        m localm = m.NpG;
        if (!m.c(((d.l.b.a.b.b.h)localObject2).gnf()))
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
            localm = m.NpG;
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
                localObject1 = ((e)localObject1).gne();
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
    public final d.l.b.a.b.f.c NnA;
    public final d.l.b.a.b.f.c NnB;
    public final d.l.b.a.b.f.c NnC;
    public final d.l.b.a.b.f.b NnD;
    public final d.l.b.a.b.f.b NnE;
    public final d.l.b.a.b.f.c NnF;
    public final d.l.b.a.b.f.c NnG;
    public final d.l.b.a.b.f.b NnH;
    public final d.l.b.a.b.f.b NnI;
    public final d.l.b.a.b.f.b NnJ;
    public final d.l.b.a.b.f.b NnK;
    public final d.l.b.a.b.f.b NnL;
    public final d.l.b.a.b.f.b NnM;
    public final d.l.b.a.b.f.b NnN;
    public final d.l.b.a.b.f.b NnO;
    public final d.l.b.a.b.f.b NnP;
    public final d.l.b.a.b.f.b NnQ;
    public final d.l.b.a.b.f.b NnR;
    public final d.l.b.a.b.f.b NnS;
    public final d.l.b.a.b.f.b NnT;
    public final d.l.b.a.b.f.b NnU;
    public final d.l.b.a.b.f.b NnV;
    public final d.l.b.a.b.f.b NnW;
    public final d.l.b.a.b.f.b NnX;
    public final d.l.b.a.b.f.b NnY;
    public final d.l.b.a.b.f.b NnZ;
    public final d.l.b.a.b.f.c Nnk;
    public final d.l.b.a.b.f.c Nnl;
    public final d.l.b.a.b.f.c Nnm;
    public final d.l.b.a.b.f.b Nnn;
    public final d.l.b.a.b.f.c Nno;
    public final d.l.b.a.b.f.c Nnp;
    public final d.l.b.a.b.f.c Nnq;
    public final d.l.b.a.b.f.c Nnr;
    public final d.l.b.a.b.f.c Nns;
    public final d.l.b.a.b.f.c Nnt;
    public final d.l.b.a.b.f.c Nnu;
    public final d.l.b.a.b.f.c Nnv;
    public final d.l.b.a.b.f.c Nnw;
    public final d.l.b.a.b.f.c Nnx;
    public final d.l.b.a.b.f.c Nny;
    public final d.l.b.a.b.f.c Nnz;
    public final d.l.b.a.b.f.b NoA;
    public final d.l.b.a.b.f.a NoB;
    public final d.l.b.a.b.f.a NoC;
    public final d.l.b.a.b.f.a NoD;
    public final d.l.b.a.b.f.a NoE;
    public final Set<d.l.b.a.b.f.f> NoF;
    public final Set<d.l.b.a.b.f.f> NoG;
    public final Map<d.l.b.a.b.f.c, h> NoH;
    public final Map<d.l.b.a.b.f.c, h> NoI;
    public final d.l.b.a.b.f.b Noa;
    public final d.l.b.a.b.f.b Nob;
    public final d.l.b.a.b.f.b Noc;
    public final d.l.b.a.b.f.b Nod;
    public final d.l.b.a.b.f.b Noe;
    public final d.l.b.a.b.f.b Nof;
    public final d.l.b.a.b.f.b Nog;
    public final d.l.b.a.b.f.b Noh;
    public final d.l.b.a.b.f.b Noi;
    public final d.l.b.a.b.f.b Noj;
    public final d.l.b.a.b.f.b Nok;
    public final d.l.b.a.b.f.c Nol;
    public final d.l.b.a.b.f.c Nom;
    public final d.l.b.a.b.f.c Non;
    public final d.l.b.a.b.f.c Noo;
    public final d.l.b.a.b.f.c Nop;
    public final d.l.b.a.b.f.c Noq;
    public final d.l.b.a.b.f.c Nor;
    public final d.l.b.a.b.f.c Nos;
    public final d.l.b.a.b.f.c Not;
    public final d.l.b.a.b.f.c Nou;
    public final d.l.b.a.b.f.a Nov;
    public final d.l.b.a.b.f.c Now;
    public final d.l.b.a.b.f.b Nox;
    public final d.l.b.a.b.f.b Noy;
    public final d.l.b.a.b.f.b Noz;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.Nnk = bdK("Any");
      this.Nnl = bdK("Nothing");
      this.Nnm = bdK("Cloneable");
      this.Nnn = bdL("Suppress");
      this.Nno = bdK("Unit");
      this.Nnp = bdK("CharSequence");
      this.Nnq = bdK("String");
      this.Nnr = bdK("Array");
      this.Nns = bdK("Boolean");
      this.Nnt = bdK("Char");
      this.Nnu = bdK("Byte");
      this.Nnv = bdK("Short");
      this.Nnw = bdK("Int");
      this.Nnx = bdK("Long");
      this.Nny = bdK("Float");
      this.Nnz = bdK("Double");
      this.NnA = bdK("Number");
      this.NnB = bdK("Enum");
      this.NnC = bdK("Function");
      this.NnD = bdL("Throwable");
      this.NnE = bdL("Comparable");
      this.NnF = bdN("IntRange");
      this.NnG = bdN("LongRange");
      this.NnH = bdL("Deprecated");
      this.NnI = bdL("DeprecationLevel");
      this.NnJ = bdL("ReplaceWith");
      this.NnK = bdL("ExtensionFunctionType");
      this.NnL = bdL("ParameterName");
      this.NnM = bdL("Annotation");
      this.NnN = bdP("Target");
      this.NnO = bdP("AnnotationTarget");
      this.NnP = bdP("AnnotationRetention");
      this.NnQ = bdP("Retention");
      this.NnR = bdP("Repeatable");
      this.NnS = bdP("MustBeDocumented");
      this.NnT = bdL("UnsafeVariance");
      this.NnU = bdL("PublishedApi");
      this.NnV = bdM("Iterator");
      this.NnW = bdM("Iterable");
      this.NnX = bdM("Collection");
      this.NnY = bdM("List");
      this.NnZ = bdM("ListIterator");
      this.Noa = bdM("Set");
      this.Nob = bdM("Map");
      this.Noc = this.Nob.p(d.l.b.a.b.f.f.bei("Entry"));
      this.Nod = bdM("MutableIterator");
      this.Noe = bdM("MutableIterable");
      this.Nof = bdM("MutableCollection");
      this.Nog = bdM("MutableList");
      this.Noh = bdM("MutableListIterator");
      this.Noi = bdM("MutableSet");
      this.Noj = bdM("MutableMap");
      this.Nok = this.Noj.p(d.l.b.a.b.f.f.bei("MutableEntry"));
      this.Nol = bdO("KClass");
      this.Nom = bdO("KCallable");
      this.Non = bdO("KProperty0");
      this.Noo = bdO("KProperty1");
      this.Nop = bdO("KProperty2");
      this.Noq = bdO("KMutableProperty0");
      this.Nor = bdO("KMutableProperty1");
      this.Nos = bdO("KMutableProperty2");
      this.Not = bdO("KProperty");
      this.Nou = bdO("KMutableProperty");
      this.Nov = d.l.b.a.b.f.a.p(this.Not.gvM());
      this.Now = bdO("KDeclarationContainer");
      this.Nox = bdL("UByte");
      this.Noy = bdL("UShort");
      this.Noz = bdL("UInt");
      this.NoA = bdL("ULong");
      this.NoB = d.l.b.a.b.f.a.p(this.Nox);
      this.NoC = d.l.b.a.b.f.a.p(this.Noy);
      this.NoD = d.l.b.a.b.f.a.p(this.Noz);
      this.NoE = d.l.b.a.b.f.a.p(this.NoA);
      this.NoF = d.l.b.a.b.o.a.amd(h.values().length);
      this.NoG = d.l.b.a.b.o.a.amd(h.values().length);
      this.NoH = d.l.b.a.b.o.a.amc(h.values().length);
      this.NoI = d.l.b.a.b.o.a.amc(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.NoF.add(localh.glQ());
        this.NoG.add(localh.glR());
        this.NoH.put(bdK(localh.glQ().sD()), localh);
        this.NoI.put(bdK(localh.glR().sD()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static d.l.b.a.b.f.c bdK(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        ajW(0);
      }
      paramString = bdL(paramString).gvH();
      if (paramString == null) {
        ajW(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bdL(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        ajW(2);
      }
      paramString = g.NmV.p(d.l.b.a.b.f.f.bei(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bdM(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.NmX.p(d.l.b.a.b.f.f.bei(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c bdN(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.NmY.p(d.l.b.a.b.f.f.bei(paramString)).gvH();
      if (paramString == null) {
        ajW(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static d.l.b.a.b.f.c bdO(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.glT().p(d.l.b.a.b.f.f.bei(paramString)).gvH();
      if (paramString == null) {
        ajW(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static d.l.b.a.b.f.b bdP(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.glP().p(d.l.b.a.b.f.f.bei(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
  
  static final class b
  {
    public final Map<h, aj> NoJ;
    public final Map<d.l.b.a.b.m.ab, aj> NoK;
    public final Map<aj, aj> NoL;
    
    private b(Map<h, aj> paramMap, Map<d.l.b.a.b.m.ab, aj> paramMap1, Map<aj, aj> paramMap2)
    {
      AppMethodBeat.i(56680);
      this.NoJ = paramMap;
      this.NoK = paramMap1;
      this.NoL = paramMap2;
      AppMethodBeat.o(56680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */