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
  public static final kotlin.l.b.a.b.f.f TcC;
  public static final kotlin.l.b.a.b.f.b TcD;
  private static final kotlin.l.b.a.b.f.b TcE;
  public static final kotlin.l.b.a.b.f.b TcF;
  public static final kotlin.l.b.a.b.f.b TcG;
  public static final kotlin.l.b.a.b.f.b TcH;
  public static final Set<kotlin.l.b.a.b.f.b> TcI;
  public static final a TcO;
  public static final kotlin.l.b.a.b.f.f TcP;
  w TcJ;
  private final kotlin.l.b.a.b.l.f<b> TcK;
  private final kotlin.l.b.a.b.l.f<Collection<ad>> TcL;
  private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, e> TcM;
  public final kotlin.l.b.a.b.l.j TcN;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = kotlin.l.b.a.b.f.f.btY("kotlin");
      TcC = (kotlin.l.b.a.b.f.f)localObject;
      localObject = kotlin.l.b.a.b.f.b.r((kotlin.l.b.a.b.f.f)localObject);
      TcD = (kotlin.l.b.a.b.f.b)localObject;
      TcE = ((kotlin.l.b.a.b.f.b)localObject).p(kotlin.l.b.a.b.f.f.btY("annotation"));
      TcF = TcD.p(kotlin.l.b.a.b.f.f.btY("collections"));
      TcG = TcD.p(kotlin.l.b.a.b.f.f.btY("ranges"));
      TcH = TcD.p(kotlin.l.b.a.b.f.f.btY("text"));
      TcI = ak.setOf(new kotlin.l.b.a.b.f.b[] { TcD, TcF, TcG, TcE, j.hzw(), TcD.p(kotlin.l.b.a.b.f.f.btY("internal")), kotlin.l.b.a.b.j.c.THv });
      TcO = new a();
      TcP = kotlin.l.b.a.b.f.f.bua("<built-ins module>");
      return;
    }
  }
  
  protected g(kotlin.l.b.a.b.l.j paramj)
  {
    this.TcN = paramj;
    this.TcL = paramj.al(new kotlin.g.a.a() {});
    this.TcK = paramj.al(new kotlin.g.a.a() {});
    this.TcM = paramj.U(new kotlin.g.a.b() {});
  }
  
  public static boolean A(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(131);
    }
    return (z(paramab)) && (paramab.hEa());
  }
  
  public static boolean B(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(132);
    }
    return A(paramab);
  }
  
  public static boolean C(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(133);
    }
    return b(paramab, TcO.TcW);
  }
  
  public static boolean D(kotlin.l.b.a.b.m.ab paramab)
  {
    return (paramab != null) && (b(paramab, TcO.TcY));
  }
  
  private static boolean a(kotlin.l.b.a.b.b.h paramh, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramh == null) {
      atM(99);
    }
    if (paramc == null) {
      atM(100);
    }
    return (paramh.hAH().equals(paramc.hJg())) && (paramc.equals(kotlin.l.b.a.b.j.c.n(paramh)));
  }
  
  private static boolean a(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      atM(93);
    }
    if (paramc == null) {
      atM(94);
    }
    return a(paramab.hKE(), paramc);
  }
  
  public static boolean a(at paramat, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramat == null) {
      atM(97);
    }
    if (paramc == null) {
      atM(98);
    }
    paramat = paramat.hzS();
    return ((paramat instanceof e)) && (a(paramat, paramc));
  }
  
  public static String atN(int paramInt)
  {
    String str = "Function".concat(String.valueOf(paramInt));
    if (str == null) {
      atM(17);
    }
    return str;
  }
  
  public static kotlin.l.b.a.b.f.a atO(int paramInt)
  {
    return new kotlin.l.b.a.b.f.a(TcD, kotlin.l.b.a.b.f.f.btY(atN(paramInt)));
  }
  
  public static boolean b(kotlin.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      atM(75);
    }
    return TcO.Teq.get(paramc) != null;
  }
  
  private static boolean b(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      atM(101);
    }
    if (paramc == null) {
      atM(102);
    }
    return (!paramab.hEa()) && (a(paramab, paramc));
  }
  
  public static kotlin.l.b.a.b.f.b c(h paramh)
  {
    if (paramh == null) {
      atM(152);
    }
    return TcD.p(paramh.hzt());
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      atM(85);
    }
    return (a(parame, TcO.TcZ)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      atM(8);
    }
    if (kotlin.l.b.a.b.j.c.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.f.c paramc)
  {
    if (paramab == null) {
      atM(125);
    }
    if (paramc == null) {
      atM(126);
    }
    return (a(paramab, paramc)) && (!paramab.hEa());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      atM(92);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      atM(9);
    }
    while (paraml != null)
    {
      if ((paraml instanceof kotlin.l.b.a.b.b.ab)) {
        return ((kotlin.l.b.a.b.b.ab)paraml).hBk().q(TcC);
      }
      paraml = paraml.hzx();
    }
    return false;
  }
  
  public static h e(l paraml)
  {
    if (paraml == null) {
      atM(76);
    }
    if (TcO.Ten.contains(paraml.hAH())) {
      return (h)TcO.Tep.get(kotlin.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      atM(103);
    }
    return (a(parame, TcO.TcS)) || (a(parame, TcO.TcT));
  }
  
  public static h f(l paraml)
  {
    if (paraml == null) {
      atM(77);
    }
    if (TcO.Teo.contains(paraml.hAH())) {
      return (h)TcO.Teq.get(kotlin.l.b.a.b.j.c.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      atM(104);
    }
    return a(parame, TcO.TcS);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      atM(147);
    }
    return a(parame, TcO.TdT);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      atM(150);
    }
    if (paraml.hAE().hzL().h(TcO.Tdp)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).hBF();
      ai localai = ((ah)paraml).hBn();
      paraml = ((ah)paraml).hBo();
      return (localai != null) && (g(localai)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(84);
    }
    return a(paramab, TcO.TcZ);
  }
  
  public static boolean n(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(87);
    }
    paramab = paramab.hKE().hzS();
    return (paramab != null) && (f(paramab) != null);
  }
  
  public static boolean o(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(90);
    }
    if (!paramab.hEa())
    {
      if (paramab == null) {
        atM(91);
      }
      paramab = paramab.hKE().hzS();
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
      atM(106);
    }
    return c(paramab, TcO.Tda);
  }
  
  public static boolean q(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(110);
    }
    return c(paramab, TcO.Tdb);
  }
  
  public static boolean r(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(112);
    }
    return c(paramab, TcO.Tde);
  }
  
  public static boolean s(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(113);
    }
    return c(paramab, TcO.Tdc);
  }
  
  public static boolean t(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(114);
    }
    return c(paramab, TcO.Tdf);
  }
  
  public static boolean u(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(116);
    }
    return c(paramab, TcO.Tdd);
  }
  
  public static boolean v(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(117);
    }
    if (paramab == null) {
      atM(118);
    }
    return (a(paramab, TcO.Tdg)) && (!paramab.hEa());
  }
  
  public static boolean w(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(119);
    }
    if (paramab == null) {
      atM(124);
    }
    return (a(paramab, TcO.Tdh)) && (!paramab.hEa());
  }
  
  public static boolean x(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(127);
    }
    return (y(paramab)) && (!bc.aE(paramab));
  }
  
  public static boolean y(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(129);
    }
    return a(paramab, TcO.TcT);
  }
  
  public static boolean z(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(130);
    }
    return a(paramab, TcO.TcS);
  }
  
  public final e a(kotlin.l.b.a.b.f.b paramb)
  {
    if (paramb == null) {
      atM(11);
    }
    e locale = q.a(this.TcJ, paramb, kotlin.l.b.a.b.c.a.c.TnF);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    if (locale == null) {
      atM(12);
    }
    return locale;
  }
  
  public final aj a(h paramh)
  {
    if (paramh == null) {
      atM(52);
    }
    if (paramh == null) {
      atM(15);
    }
    paramh = btz(paramh.hzt().sG()).hAG();
    if (paramh == null) {
      atM(53);
    }
    return paramh;
  }
  
  public final aj a(bh parambh, kotlin.l.b.a.b.m.ab paramab)
  {
    if (parambh == null) {
      atM(78);
    }
    if (paramab == null) {
      atM(79);
    }
    parambh = Collections.singletonList(new ax(parambh, paramab));
    paramab = kotlin.l.b.a.b.b.a.g.TiC;
    parambh = ac.a(kotlin.l.b.a.b.b.a.g.a.hBP(), btz("Array"), parambh);
    if (parambh == null) {
      atM(80);
    }
    return parambh;
  }
  
  public final e atP(int paramInt)
  {
    Object localObject = kotlin.l.b.a.b.f.f.btY(b.c.TfB.TfG + paramInt);
    localObject = a(kotlin.l.b.a.b.j.c.THv.p((kotlin.l.b.a.b.f.f)localObject));
    if (localObject == null) {
      atM(18);
    }
    return localObject;
  }
  
  public final aj b(h paramh)
  {
    if (paramh == null) {
      atM(72);
    }
    paramh = (aj)((b)this.TcK.invoke()).Ter.get(paramh);
    if (paramh == null) {
      atM(73);
    }
    return paramh;
  }
  
  public final e btz(String paramString)
  {
    if (paramString == null) {
      atM(13);
    }
    paramString = (e)this.TcM.invoke(kotlin.l.b.a.b.f.f.btY(paramString));
    if (paramString == null) {
      atM(14);
    }
    return paramString;
  }
  
  protected final void hzc()
  {
    this.TcJ = new w(TcP, this.TcN, this);
    w localw = this.TcJ;
    Object localObject = a.Tcu;
    localObject = a.a.hyZ();
    hzf();
    hze();
    hzd();
    localw.a(((a)localObject).hyY());
    this.TcJ.a(new w[] { this.TcJ });
  }
  
  protected kotlin.l.b.a.b.b.b.a hzd()
  {
    kotlin.l.b.a.b.b.b.a.a locala = kotlin.l.b.a.b.b.b.a.a.TjP;
    if (locala == null) {
      atM(2);
    }
    return locala;
  }
  
  protected kotlin.l.b.a.b.b.b.c hze()
  {
    c.b localb = c.b.TjR;
    if (localb == null) {
      atM(3);
    }
    return localb;
  }
  
  protected Iterable<kotlin.l.b.a.b.b.b.b> hzf()
  {
    List localList = Collections.singletonList(new kotlin.l.b.a.b.a.a.a(this.TcN, this.TcJ));
    if (localList == null) {
      atM(4);
    }
    return localList;
  }
  
  public final w hzg()
  {
    w localw = this.TcJ;
    if (localw == null) {
      atM(6);
    }
    return localw;
  }
  
  public final aj hzh()
  {
    aj localaj = btz("Nothing").hAG();
    if (localaj == null) {
      atM(47);
    }
    return localaj;
  }
  
  public final aj hzi()
  {
    aj localaj = btz("Any").hAG();
    if (localaj == null) {
      atM(49);
    }
    return localaj;
  }
  
  public final aj hzj()
  {
    aj localaj = hzi().EG(true);
    if (localaj == null) {
      atM(50);
    }
    return localaj;
  }
  
  public final aj hzk()
  {
    aj localaj = hzj();
    if (localaj == null) {
      atM(51);
    }
    return localaj;
  }
  
  public final aj hzl()
  {
    aj localaj = a(h.Tew);
    if (localaj == null) {
      atM(55);
    }
    return localaj;
  }
  
  public final aj hzm()
  {
    aj localaj = a(h.Tex);
    if (localaj == null) {
      atM(56);
    }
    return localaj;
  }
  
  public final aj hzn()
  {
    aj localaj = a(h.Tey);
    if (localaj == null) {
      atM(57);
    }
    return localaj;
  }
  
  public final aj hzo()
  {
    aj localaj = a(h.TeA);
    if (localaj == null) {
      atM(58);
    }
    return localaj;
  }
  
  public final aj hzp()
  {
    aj localaj = a(h.Teu);
    if (localaj == null) {
      atM(62);
    }
    return localaj;
  }
  
  public final aj hzq()
  {
    aj localaj = btz("Unit").hAG();
    if (localaj == null) {
      atM(63);
    }
    return localaj;
  }
  
  public final aj hzr()
  {
    aj localaj = btz("String").hAG();
    if (localaj == null) {
      atM(64);
    }
    return localaj;
  }
  
  public final kotlin.l.b.a.b.m.ab l(kotlin.l.b.a.b.m.ab paramab)
  {
    if (paramab == null) {
      atM(66);
    }
    if (m(paramab))
    {
      if (paramab.hKB().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((av)paramab.hKB().get(0)).hBy();
      paramab = (kotlin.l.b.a.b.m.ab)localObject1;
      if (localObject1 == null)
      {
        atM(67);
        paramab = (kotlin.l.b.a.b.m.ab)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramab;
      localObject2 = bc.aD(paramab);
      localObject1 = (kotlin.l.b.a.b.m.ab)((b)this.TcK.invoke()).Tet.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramab = (kotlin.l.b.a.b.m.ab)localObject1;
    } while (localObject1 != null);
    atM(68);
    return localObject1;
    Object localObject1 = kotlin.l.b.a.b.j.c.Y((kotlin.l.b.a.b.m.ab)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        atM(70);
      }
      if (localObject1 == null) {
        atM(71);
      }
      localObject2 = ((kotlin.l.b.a.b.m.ab)localObject2).hKE().hzS();
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
        atM(69);
        return localObject1;
        m localm = m.Tfo;
        if (!m.c(((kotlin.l.b.a.b.b.h)localObject2).hAH()))
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
            localm = m.Tfo;
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
                localObject1 = ((e)localObject1).hAG();
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
    public final kotlin.l.b.a.b.f.c TcS;
    public final kotlin.l.b.a.b.f.c TcT;
    public final kotlin.l.b.a.b.f.c TcU;
    public final kotlin.l.b.a.b.f.b TcV;
    public final kotlin.l.b.a.b.f.c TcW;
    public final kotlin.l.b.a.b.f.c TcX;
    public final kotlin.l.b.a.b.f.c TcY;
    public final kotlin.l.b.a.b.f.c TcZ;
    public final kotlin.l.b.a.b.f.b TdA;
    public final kotlin.l.b.a.b.f.b TdB;
    public final kotlin.l.b.a.b.f.b TdC;
    public final kotlin.l.b.a.b.f.b TdD;
    public final kotlin.l.b.a.b.f.b TdE;
    public final kotlin.l.b.a.b.f.b TdF;
    public final kotlin.l.b.a.b.f.b TdG;
    public final kotlin.l.b.a.b.f.b TdH;
    public final kotlin.l.b.a.b.f.b TdI;
    public final kotlin.l.b.a.b.f.b TdJ;
    public final kotlin.l.b.a.b.f.b TdK;
    public final kotlin.l.b.a.b.f.b TdL;
    public final kotlin.l.b.a.b.f.b TdM;
    public final kotlin.l.b.a.b.f.b TdN;
    public final kotlin.l.b.a.b.f.b TdO;
    public final kotlin.l.b.a.b.f.b TdP;
    public final kotlin.l.b.a.b.f.b TdQ;
    public final kotlin.l.b.a.b.f.b TdR;
    public final kotlin.l.b.a.b.f.b TdS;
    public final kotlin.l.b.a.b.f.c TdT;
    public final kotlin.l.b.a.b.f.c TdU;
    public final kotlin.l.b.a.b.f.c TdV;
    public final kotlin.l.b.a.b.f.c TdW;
    public final kotlin.l.b.a.b.f.c TdX;
    public final kotlin.l.b.a.b.f.c TdY;
    public final kotlin.l.b.a.b.f.c TdZ;
    public final kotlin.l.b.a.b.f.c Tda;
    public final kotlin.l.b.a.b.f.c Tdb;
    public final kotlin.l.b.a.b.f.c Tdc;
    public final kotlin.l.b.a.b.f.c Tdd;
    public final kotlin.l.b.a.b.f.c Tde;
    public final kotlin.l.b.a.b.f.c Tdf;
    public final kotlin.l.b.a.b.f.c Tdg;
    public final kotlin.l.b.a.b.f.c Tdh;
    public final kotlin.l.b.a.b.f.c Tdi;
    public final kotlin.l.b.a.b.f.c Tdj;
    public final kotlin.l.b.a.b.f.c Tdk;
    public final kotlin.l.b.a.b.f.b Tdl;
    public final kotlin.l.b.a.b.f.b Tdm;
    public final kotlin.l.b.a.b.f.c Tdn;
    public final kotlin.l.b.a.b.f.c Tdo;
    public final kotlin.l.b.a.b.f.b Tdp;
    public final kotlin.l.b.a.b.f.b Tdq;
    public final kotlin.l.b.a.b.f.b Tdr;
    public final kotlin.l.b.a.b.f.b Tds;
    public final kotlin.l.b.a.b.f.b Tdt;
    public final kotlin.l.b.a.b.f.b Tdu;
    public final kotlin.l.b.a.b.f.b Tdv;
    public final kotlin.l.b.a.b.f.b Tdw;
    public final kotlin.l.b.a.b.f.b Tdx;
    public final kotlin.l.b.a.b.f.b Tdy;
    public final kotlin.l.b.a.b.f.b Tdz;
    public final kotlin.l.b.a.b.f.c Tea;
    public final kotlin.l.b.a.b.f.c Teb;
    public final kotlin.l.b.a.b.f.c Tec;
    public final kotlin.l.b.a.b.f.a Ted;
    public final kotlin.l.b.a.b.f.c Tee;
    public final kotlin.l.b.a.b.f.b Tef;
    public final kotlin.l.b.a.b.f.b Teg;
    public final kotlin.l.b.a.b.f.b Teh;
    public final kotlin.l.b.a.b.f.b Tei;
    public final kotlin.l.b.a.b.f.a Tej;
    public final kotlin.l.b.a.b.f.a Tek;
    public final kotlin.l.b.a.b.f.a Tel;
    public final kotlin.l.b.a.b.f.a Tem;
    public final Set<kotlin.l.b.a.b.f.f> Ten;
    public final Set<kotlin.l.b.a.b.f.f> Teo;
    public final Map<kotlin.l.b.a.b.f.c, h> Tep;
    public final Map<kotlin.l.b.a.b.f.c, h> Teq;
    
    public a()
    {
      AppMethodBeat.i(56672);
      this.TcS = btA("Any");
      this.TcT = btA("Nothing");
      this.TcU = btA("Cloneable");
      this.TcV = btB("Suppress");
      this.TcW = btA("Unit");
      this.TcX = btA("CharSequence");
      this.TcY = btA("String");
      this.TcZ = btA("Array");
      this.Tda = btA("Boolean");
      this.Tdb = btA("Char");
      this.Tdc = btA("Byte");
      this.Tdd = btA("Short");
      this.Tde = btA("Int");
      this.Tdf = btA("Long");
      this.Tdg = btA("Float");
      this.Tdh = btA("Double");
      this.Tdi = btA("Number");
      this.Tdj = btA("Enum");
      this.Tdk = btA("Function");
      this.Tdl = btB("Throwable");
      this.Tdm = btB("Comparable");
      this.Tdn = btD("IntRange");
      this.Tdo = btD("LongRange");
      this.Tdp = btB("Deprecated");
      this.Tdq = btB("DeprecationLevel");
      this.Tdr = btB("ReplaceWith");
      this.Tds = btB("ExtensionFunctionType");
      this.Tdt = btB("ParameterName");
      this.Tdu = btB("Annotation");
      this.Tdv = btF("Target");
      this.Tdw = btF("AnnotationTarget");
      this.Tdx = btF("AnnotationRetention");
      this.Tdy = btF("Retention");
      this.Tdz = btF("Repeatable");
      this.TdA = btF("MustBeDocumented");
      this.TdB = btB("UnsafeVariance");
      this.TdC = btB("PublishedApi");
      this.TdD = btC("Iterator");
      this.TdE = btC("Iterable");
      this.TdF = btC("Collection");
      this.TdG = btC("List");
      this.TdH = btC("ListIterator");
      this.TdI = btC("Set");
      this.TdJ = btC("Map");
      this.TdK = this.TdJ.p(kotlin.l.b.a.b.f.f.btY("Entry"));
      this.TdL = btC("MutableIterator");
      this.TdM = btC("MutableIterable");
      this.TdN = btC("MutableCollection");
      this.TdO = btC("MutableList");
      this.TdP = btC("MutableListIterator");
      this.TdQ = btC("MutableSet");
      this.TdR = btC("MutableMap");
      this.TdS = this.TdR.p(kotlin.l.b.a.b.f.f.btY("MutableEntry"));
      this.TdT = btE("KClass");
      this.TdU = btE("KCallable");
      this.TdV = btE("KProperty0");
      this.TdW = btE("KProperty1");
      this.TdX = btE("KProperty2");
      this.TdY = btE("KMutableProperty0");
      this.TdZ = btE("KMutableProperty1");
      this.Tea = btE("KMutableProperty2");
      this.Teb = btE("KProperty");
      this.Tec = btE("KMutableProperty");
      this.Ted = kotlin.l.b.a.b.f.a.p(this.Teb.hJj());
      this.Tee = btE("KDeclarationContainer");
      this.Tef = btB("UByte");
      this.Teg = btB("UShort");
      this.Teh = btB("UInt");
      this.Tei = btB("ULong");
      this.Tej = kotlin.l.b.a.b.f.a.p(this.Tef);
      this.Tek = kotlin.l.b.a.b.f.a.p(this.Teg);
      this.Tel = kotlin.l.b.a.b.f.a.p(this.Teh);
      this.Tem = kotlin.l.b.a.b.f.a.p(this.Tei);
      this.Ten = kotlin.l.b.a.b.o.a.avM(h.values().length);
      this.Teo = kotlin.l.b.a.b.o.a.avM(h.values().length);
      this.Tep = kotlin.l.b.a.b.o.a.avL(h.values().length);
      this.Teq = kotlin.l.b.a.b.o.a.avL(h.values().length);
      h[] arrayOfh = h.values();
      int j = arrayOfh.length;
      int i = 0;
      while (i < j)
      {
        h localh = arrayOfh[i];
        this.Ten.add(localh.hzt());
        this.Teo.add(localh.hzu());
        this.Tep.put(btA(localh.hzt().sG()), localh);
        this.Teq.put(btA(localh.hzu().sG()), localh);
        i += 1;
      }
      AppMethodBeat.o(56672);
    }
    
    private static kotlin.l.b.a.b.f.c btA(String paramString)
    {
      AppMethodBeat.i(56673);
      if (paramString == null) {
        atM(0);
      }
      paramString = btB(paramString).hJe();
      if (paramString == null) {
        atM(1);
      }
      AppMethodBeat.o(56673);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b btB(String paramString)
    {
      AppMethodBeat.i(56674);
      if (paramString == null) {
        atM(2);
      }
      paramString = g.TcD.p(kotlin.l.b.a.b.f.f.btY(paramString));
      AppMethodBeat.o(56674);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b btC(String paramString)
    {
      AppMethodBeat.i(56675);
      paramString = g.TcF.p(kotlin.l.b.a.b.f.f.btY(paramString));
      AppMethodBeat.o(56675);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.c btD(String paramString)
    {
      AppMethodBeat.i(56676);
      paramString = g.TcG.p(kotlin.l.b.a.b.f.f.btY(paramString)).hJe();
      if (paramString == null) {
        atM(7);
      }
      AppMethodBeat.o(56676);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.c btE(String paramString)
    {
      AppMethodBeat.i(56677);
      paramString = j.hzw().p(kotlin.l.b.a.b.f.f.btY(paramString)).hJe();
      if (paramString == null) {
        atM(9);
      }
      AppMethodBeat.o(56677);
      return paramString;
    }
    
    private static kotlin.l.b.a.b.f.b btF(String paramString)
    {
      AppMethodBeat.i(56678);
      paramString = g.hzs().p(kotlin.l.b.a.b.f.f.btY(paramString));
      AppMethodBeat.o(56678);
      return paramString;
    }
  }
  
  static final class b
  {
    public final Map<h, aj> Ter;
    public final Map<kotlin.l.b.a.b.m.ab, aj> Tes;
    public final Map<aj, aj> Tet;
    
    private b(Map<h, aj> paramMap, Map<kotlin.l.b.a.b.m.ab, aj> paramMap1, Map<aj, aj> paramMap2)
    {
      AppMethodBeat.i(56680);
      this.Ter = paramMap;
      this.Tes = paramMap1;
      this.Tet = paramMap2;
      AppMethodBeat.o(56680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */