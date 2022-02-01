package kotlin.l.b.a.b.a;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.b.c.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bl;

public abstract class h
{
  public static final kotlin.l.b.a.b.f.f aiBv;
  private kotlin.l.b.a.b.b.c.w aiBp;
  private kotlin.l.b.a.b.l.h<kotlin.l.b.a.b.b.c.w> aiBq;
  private final kotlin.l.b.a.b.l.h<h.a> aiBr;
  private final kotlin.l.b.a.b.l.h<Collection<kotlin.l.b.a.b.b.al>> aiBs;
  private final kotlin.l.b.a.b.l.f<kotlin.l.b.a.b.f.f, e> aiBt;
  public final m aiBu;
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      aiBv = kotlin.l.b.a.b.f.f.bJg("<built-ins module>");
      return;
    }
  }
  
  protected h(m paramm)
  {
    this.aiBu = paramm;
    this.aiBs = paramm.cq(new kotlin.g.a.a() {});
    this.aiBr = paramm.cq(new kotlin.g.a.a() {});
    this.aiBt = paramm.bd(new kotlin.g.a.b() {});
  }
  
  private static boolean a(kotlin.l.b.a.b.b.h paramh, kotlin.l.b.a.b.f.d paramd)
  {
    if (paramh == null) {
      aKu(103);
    }
    if (paramd == null) {
      aKu(104);
    }
    return (paramh.kok().equals(paramd.kxT())) && (paramd.equals(kotlin.l.b.a.b.j.d.n(paramh)));
  }
  
  private static boolean a(ad paramad, kotlin.l.b.a.b.f.d paramd)
  {
    if (paramad == null) {
      aKu(97);
    }
    if (paramd == null) {
      aKu(98);
    }
    return a(paramad.kzm(), paramd);
  }
  
  public static boolean a(ax paramax, kotlin.l.b.a.b.f.d paramd)
  {
    if (paramax == null) {
      aKu(101);
    }
    if (paramd == null) {
      aKu(102);
    }
    paramax = paramax.knA();
    return ((paramax instanceof e)) && (a(paramax, paramd));
  }
  
  private static boolean b(ad paramad, kotlin.l.b.a.b.f.d paramd)
  {
    if (paramad == null) {
      aKu(105);
    }
    if (paramd == null) {
      aKu(106);
    }
    return (!paramad.ksB()) && (a(paramad, paramd));
  }
  
  public static boolean c(e parame)
  {
    if (parame == null) {
      aKu(89);
    }
    return (a(parame, k.a.aiCF)) || (f(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    boolean bool = false;
    if (paraml == null) {
      aKu(9);
    }
    if (kotlin.l.b.a.b.j.d.a(paraml, b.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c(ad paramad, kotlin.l.b.a.b.f.d paramd)
  {
    if (paramad == null) {
      aKu(134);
    }
    if (paramd == null) {
      aKu(135);
    }
    return (a(paramad, paramd)) && (!paramad.ksB());
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      aKu(96);
    }
    return e(parame) != null;
  }
  
  public static boolean d(l paraml)
  {
    if (paraml == null) {
      aKu(10);
    }
    while (paraml != null)
    {
      if ((paraml instanceof ah)) {
        return ((ah)paraml).koY().r(k.aiCq);
      }
      paraml = paraml.knp();
    }
    return false;
  }
  
  public static i e(l paraml)
  {
    if (paraml == null) {
      aKu(76);
    }
    if (k.a.aiDY.contains(paraml.kok())) {
      return (i)k.a.aiEa.get(kotlin.l.b.a.b.j.d.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    if (parame == null) {
      aKu(107);
    }
    return (a(parame, k.a.aiCy)) || (a(parame, k.a.aiCz));
  }
  
  public static i f(l paraml)
  {
    if (paraml == null) {
      aKu(77);
    }
    if (k.a.aiDZ.contains(paraml.kok())) {
      return (i)k.a.aiEb.get(kotlin.l.b.a.b.j.d.n(paraml));
    }
    return null;
  }
  
  public static boolean f(e parame)
  {
    if (parame == null) {
      aKu(108);
    }
    return a(parame, k.a.aiCy);
  }
  
  public static boolean g(e parame)
  {
    if (parame == null) {
      aKu(157);
    }
    return a(parame, k.a.aiDA);
  }
  
  public static boolean g(l paraml)
  {
    if (paraml == null) {
      aKu(160);
    }
    if (paraml.kor().knl().i(k.a.aiCV)) {
      return true;
    }
    if ((paraml instanceof ap))
    {
      boolean bool = ((ap)paraml).kpu();
      aq localaq = ((ap)paraml).kpc();
      paraml = ((ap)paraml).kpd();
      return (localaq != null) && (g(localaq)) && ((!bool) || ((paraml != null) && (g(paraml))));
    }
    return false;
  }
  
  public static boolean m(ad paramad)
  {
    if (paramad == null) {
      aKu(88);
    }
    return a(paramad, k.a.aiCF);
  }
  
  public static boolean n(ad paramad)
  {
    if (paramad == null) {
      aKu(91);
    }
    paramad = paramad.kzm().knA();
    return (paramad != null) && (f(paramad) != null);
  }
  
  public static i o(ad paramad)
  {
    if (paramad == null) {
      aKu(92);
    }
    paramad = paramad.kzm().knA();
    if (paramad == null) {
      return null;
    }
    return f(paramad);
  }
  
  public static boolean p(ad paramad)
  {
    if (paramad == null) {
      aKu(94);
    }
    if (!paramad.ksB())
    {
      if (paramad == null) {
        aKu(95);
      }
      paramad = paramad.kzm().knA();
      if (((paramad instanceof e)) && (d((e)paramad))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean q(ad paramad)
  {
    if (paramad == null) {
      aKu(132);
    }
    if (paramad == null) {
      aKu(128);
    }
    if (!c(paramad, k.a.aiDU.kxR()))
    {
      if (paramad == null) {
        aKu(129);
      }
      if (!c(paramad, k.a.aiDV.kxR()))
      {
        if (paramad == null) {
          aKu(130);
        }
        if (!c(paramad, k.a.aiDW.kxR())) {
          if (paramad == null) {
            aKu(131);
          }
        }
      }
    }
    return c(paramad, k.a.aiDX.kxR());
  }
  
  public static boolean r(ad paramad)
  {
    if (paramad == null) {
      aKu(136);
    }
    if (paramad == null) {
      aKu(138);
    }
    return (a(paramad, k.a.aiCz)) && (!bg.aw(paramad));
  }
  
  public static boolean s(ad paramad)
  {
    if (paramad == null) {
      aKu(139);
    }
    return a(paramad, k.a.aiCy);
  }
  
  public static boolean t(ad paramad)
  {
    if (paramad == null) {
      aKu(140);
    }
    return (s(paramad)) && (paramad.ksB());
  }
  
  public static boolean u(ad paramad)
  {
    if (paramad == null) {
      aKu(141);
    }
    return t(paramad);
  }
  
  public static boolean v(ad paramad)
  {
    if (paramad == null) {
      aKu(142);
    }
    return b(paramad, k.a.aiCC);
  }
  
  public static boolean w(ad paramad)
  {
    return (paramad != null) && (b(paramad, k.a.aiCE));
  }
  
  public final e a(kotlin.l.b.a.b.f.c paramc)
  {
    if (paramc == null) {
      aKu(12);
    }
    e locale = r.a(kmM(), paramc, kotlin.l.b.a.b.c.a.d.aiNy);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramc));
    if (locale == null) {
      aKu(13);
    }
    return locale;
  }
  
  public final kotlin.l.b.a.b.m.al a(i parami)
  {
    if (parami == null) {
      aKu(53);
    }
    if (parami == null) {
      aKu(16);
    }
    parami = bIC(parami.aiBC.PF()).koj();
    if (parami == null) {
      aKu(54);
    }
    return parami;
  }
  
  public final kotlin.l.b.a.b.m.al a(bl parambl, ad paramad)
  {
    if (parambl == null) {
      aKu(82);
    }
    if (paramad == null) {
      aKu(83);
    }
    g.a locala = g.aiIh;
    parambl = a(parambl, paramad, g.a.kpB());
    if (parambl == null) {
      aKu(84);
    }
    return parambl;
  }
  
  public final kotlin.l.b.a.b.m.al a(bl parambl, ad paramad, g paramg)
  {
    if (parambl == null) {
      aKu(78);
    }
    if (paramad == null) {
      aKu(79);
    }
    if (paramg == null) {
      aKu(80);
    }
    parambl = Collections.singletonList(new bb(parambl, paramad));
    parambl = kotlin.l.b.a.b.m.ae.a(paramg, bIC("Array"), parambl);
    if (parambl == null) {
      aKu(81);
    }
    return parambl;
  }
  
  public final e aKv(int paramInt)
  {
    e locale = a(k.aiCi.q(kotlin.l.b.a.b.f.f.bJe(k.aKy(paramInt))));
    if (locale == null) {
      aKu(18);
    }
    return locale;
  }
  
  public final kotlin.l.b.a.b.m.al b(i parami)
  {
    if (parami == null) {
      aKu(73);
    }
    parami = (kotlin.l.b.a.b.m.al)((h.a)this.aiBr.invoke()).aiBy.get(parami);
    if (parami == null) {
      aKu(74);
    }
    return parami;
  }
  
  public final e bIC(String paramString)
  {
    if (paramString == null) {
      aKu(14);
    }
    paramString = (e)this.aiBt.invoke(kotlin.l.b.a.b.f.f.bJe(paramString));
    if (paramString == null) {
      aKu(15);
    }
    return paramString;
  }
  
  protected final void kmI()
  {
    this.aiBp = new kotlin.l.b.a.b.b.c.w(aiBv, this.aiBu, this);
    kotlin.l.b.a.b.b.c.w localw = this.aiBp;
    Object localObject = a.aiBh;
    localObject = a.a.kmE();
    kmL();
    kmK();
    kmJ();
    localw.a(((a)localObject).kmD());
    this.aiBp.a(new kotlin.l.b.a.b.b.c.w[] { this.aiBp });
  }
  
  protected kotlin.l.b.a.b.b.b.a kmJ()
  {
    kotlin.l.b.a.b.b.b.a.a locala = kotlin.l.b.a.b.b.b.a.a.aiJt;
    if (locala == null) {
      aKu(3);
    }
    return locala;
  }
  
  protected kotlin.l.b.a.b.b.b.c kmK()
  {
    c.b localb = c.b.aiJv;
    if (localb == null) {
      aKu(4);
    }
    return localb;
  }
  
  protected Iterable<kotlin.l.b.a.b.b.b.b> kmL()
  {
    List localList = Collections.singletonList(new kotlin.l.b.a.b.a.a.a(this.aiBu, kmM()));
    if (localList == null) {
      aKu(5);
    }
    return localList;
  }
  
  public final kotlin.l.b.a.b.b.c.w kmM()
  {
    assert ((this.aiBp != null) || (this.aiBq != null)) : "Uninitialized built-ins module";
    if (this.aiBp == null) {
      this.aiBp = ((kotlin.l.b.a.b.b.c.w)this.aiBq.invoke());
    }
    kotlin.l.b.a.b.b.c.w localw = this.aiBp;
    if (localw == null) {
      aKu(7);
    }
    return localw;
  }
  
  public final kotlin.l.b.a.b.m.al kmN()
  {
    kotlin.l.b.a.b.m.al localal = bIC("Nothing").koj();
    if (localal == null) {
      aKu(48);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmO()
  {
    kotlin.l.b.a.b.m.al localal = bIC("Any").koj();
    if (localal == null) {
      aKu(50);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmP()
  {
    kotlin.l.b.a.b.m.al localal = kmO().Pq(true);
    if (localal == null) {
      aKu(51);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmQ()
  {
    kotlin.l.b.a.b.m.al localal = kmP();
    if (localal == null) {
      aKu(52);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmR()
  {
    kotlin.l.b.a.b.m.al localal = a(i.aiBJ);
    if (localal == null) {
      aKu(56);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmS()
  {
    kotlin.l.b.a.b.m.al localal = a(i.aiBK);
    if (localal == null) {
      aKu(57);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmT()
  {
    kotlin.l.b.a.b.m.al localal = a(i.aiBL);
    if (localal == null) {
      aKu(58);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmU()
  {
    kotlin.l.b.a.b.m.al localal = a(i.aiBN);
    if (localal == null) {
      aKu(59);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmV()
  {
    kotlin.l.b.a.b.m.al localal = a(i.aiBH);
    if (localal == null) {
      aKu(63);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmW()
  {
    kotlin.l.b.a.b.m.al localal = bIC("Unit").koj();
    if (localal == null) {
      aKu(64);
    }
    return localal;
  }
  
  public final kotlin.l.b.a.b.m.al kmX()
  {
    kotlin.l.b.a.b.m.al localal = bIC("String").koj();
    if (localal == null) {
      aKu(65);
    }
    return localal;
  }
  
  public final ad l(ad paramad)
  {
    if (paramad == null) {
      aKu(67);
    }
    if (m(paramad))
    {
      if (paramad.klR().size() != 1) {
        throw new IllegalStateException();
      }
      localObject1 = ((az)paramad.klR().get(0)).koG();
      paramad = (ad)localObject1;
      if (localObject1 == null)
      {
        aKu(68);
        paramad = (ad)localObject1;
      }
    }
    Object localObject2;
    do
    {
      return paramad;
      localObject2 = bg.au(paramad);
      localObject1 = (ad)((h.a)this.aiBr.invoke()).aiBA.get(localObject2);
      if (localObject1 == null) {
        break;
      }
      paramad = (ad)localObject1;
    } while (localObject1 != null);
    aKu(69);
    return localObject1;
    Object localObject1 = kotlin.l.b.a.b.j.d.P((ad)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        aKu(71);
      }
      if (localObject1 == null) {
        aKu(72);
      }
      localObject2 = ((ad)localObject2).kzm().knA();
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label258;
        }
        paramad = (ad)localObject1;
        if (localObject1 != null) {
          break;
        }
        aKu(70);
        return localObject1;
        o localo = o.aiEq;
        if (!o.c(((kotlin.l.b.a.b.b.h)localObject2).kok()))
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = kotlin.l.b.a.b.j.d.a.d((kotlin.l.b.a.b.b.h)localObject2);
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localo = o.aiEq;
            localObject2 = o.a((kotlin.l.b.a.b.f.b)localObject2);
            if (localObject2 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = kotlin.l.b.a.b.b.w.b((kotlin.l.b.a.b.b.ae)localObject1, (kotlin.l.b.a.b.f.b)localObject2);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((e)localObject1).koj();
              }
            }
          }
        }
      }
    }
    label258:
    throw new IllegalStateException("not array: ".concat(String.valueOf(paramad)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */