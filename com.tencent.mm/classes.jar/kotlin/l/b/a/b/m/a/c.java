package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.ai;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.an;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.as;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bf;
import kotlin.l.b.a.b.m.bf.a;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.p;
import kotlin.l.b.a.b.m.c.t;
import kotlin.l.b.a.b.m.c.t.a;
import kotlin.l.b.a.b.m.c.v;
import kotlin.l.b.a.b.m.c.w;
import kotlin.l.b.a.b.m.x;

public abstract interface c
  extends bf, t
{
  public abstract kotlin.l.b.a.b.m.c.i a(kotlin.l.b.a.b.m.c.k paramk1, kotlin.l.b.a.b.m.c.k paramk2);
  
  public abstract kotlin.l.b.a.b.m.c.k a(kotlin.l.b.a.b.m.c.k paramk, boolean paramBoolean);
  
  public abstract kotlin.l.b.a.b.m.c.d b(kotlin.l.b.a.b.m.c.k paramk);
  
  public abstract kotlin.l.b.a.b.m.c.k b(kotlin.l.b.a.b.m.c.g paramg);
  
  public abstract kotlin.l.b.a.b.m.c.k c(kotlin.l.b.a.b.m.c.g paramg);
  
  public abstract kotlin.l.b.a.b.m.c.k c(kotlin.l.b.a.b.m.c.i parami);
  
  public abstract boolean h(kotlin.l.b.a.b.m.c.k paramk);
  
  public abstract o l(kotlin.l.b.a.b.m.c.k paramk);
  
  public static final class a
  {
    public static int a(c paramc, kotlin.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61040);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramm, "receiver");
      int i = t.a.a((t)paramc, paramm);
      AppMethodBeat.o(61040);
      return i;
    }
    
    public static Collection<kotlin.l.b.a.b.m.c.i> a(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(60990);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      paramc = paramc.l(paramk);
      if (!(paramc instanceof kotlin.l.b.a.b.j.b.n))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(60990);
        throw paramc;
      }
      paramc = (Collection)((kotlin.l.b.a.b.j.b.n)paramc).ajjL;
      AppMethodBeat.o(60990);
      return paramc;
    }
    
    public static List<kotlin.l.b.a.b.m.c.k> a(c paramc, kotlin.l.b.a.b.m.c.k paramk, o paramo)
    {
      AppMethodBeat.i(191859);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      kotlin.g.b.s.u(paramo, "constructor");
      paramc = t.a.a((t)paramc, paramk, paramo);
      AppMethodBeat.o(191859);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.f a(c paramc, kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(191724);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramg, "receiver");
      if (!(paramg instanceof x))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + ai.cz(paramg.getClass())).toString());
        AppMethodBeat.o(191724);
        throw paramc;
      }
      if ((paramg instanceof kotlin.l.b.a.b.m.s)) {}
      for (paramc = (kotlin.l.b.a.b.m.s)paramg;; paramc = null)
      {
        paramc = (kotlin.l.b.a.b.m.c.f)paramc;
        AppMethodBeat.o(191724);
        return paramc;
      }
    }
    
    public static kotlin.l.b.a.b.m.c.i a(c paramc, List<? extends kotlin.l.b.a.b.m.c.i> paramList)
    {
      AppMethodBeat.i(191788);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramList, "types");
      paramc = (kotlin.l.b.a.b.m.c.i)d.pf(paramList);
      AppMethodBeat.o(191788);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.i a(c paramc, kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(191711);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramd, "receiver");
      if (!(paramd instanceof i))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + ai.cz(paramd.getClass())).toString());
        AppMethodBeat.o(191711);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)((i)paramd).ajre;
      AppMethodBeat.o(191711);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k a(c paramc, kotlin.l.b.a.b.m.c.e parame)
    {
      AppMethodBeat.i(191829);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parame, "receiver");
      if (!(parame instanceof kotlin.l.b.a.b.m.m))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parame + ", " + ai.cz(parame.getClass())).toString());
        AppMethodBeat.o(191829);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.k)((kotlin.l.b.a.b.m.m)parame).ajpp;
      AppMethodBeat.o(191829);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k a(c paramc, kotlin.l.b.a.b.m.c.k paramk, b paramb)
    {
      AppMethodBeat.i(191764);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "type");
      kotlin.g.b.s.u(paramb, "status");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191764);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.k)k.a((al)paramk, paramb);
      AppMethodBeat.o(191764);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k a(c paramc, kotlin.l.b.a.b.m.c.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(191687);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191687);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.k)((al)paramk).Pq(paramBoolean);
      AppMethodBeat.o(191687);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.n a(c paramc, kotlin.l.b.a.b.m.c.c paramc1)
    {
      AppMethodBeat.i(191740);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramc1, "receiver");
      if (!(paramc1 instanceof j))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramc1 + ", " + ai.cz(paramc1.getClass())).toString());
        AppMethodBeat.o(191740);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.n)((j)paramc1).ajjx;
      AppMethodBeat.o(191740);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.n a(c paramc, kotlin.l.b.a.b.m.c.i parami, int paramInt)
    {
      AppMethodBeat.i(191742);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191742);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.n)((ad)parami).klR().get(paramInt);
      AppMethodBeat.o(191742);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.n a(c paramc, kotlin.l.b.a.b.m.c.k paramk, int paramInt)
    {
      AppMethodBeat.i(191860);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      paramc = t.a.a((t)paramc, paramk, paramInt);
      AppMethodBeat.o(191860);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.n a(c paramc, kotlin.l.b.a.b.m.c.m paramm, int paramInt)
    {
      AppMethodBeat.i(61038);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramm, "receiver");
      paramc = t.a.a((t)paramc, paramm, paramInt);
      AppMethodBeat.o(61038);
      return paramc;
    }
    
    public static p a(c paramc, o paramo, int paramInt)
    {
      AppMethodBeat.i(191748);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191748);
        throw paramc;
      }
      paramc = ((ax)paramo).klq().get(paramInt);
      kotlin.g.b.s.s(paramc, "this.parameters[index]");
      paramc = (p)paramc;
      AppMethodBeat.o(191748);
      return paramc;
    }
    
    public static p a(c paramc, v paramv)
    {
      AppMethodBeat.i(191677);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramv, "receiver");
      if (!(paramv instanceof n))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramv + ", " + ai.cz(paramv.getClass())).toString());
        AppMethodBeat.o(191677);
        throw paramc;
      }
      paramc = (p)((n)paramv).kAW();
      AppMethodBeat.o(191677);
      return paramc;
    }
    
    public static w a(c paramc, p paramp)
    {
      AppMethodBeat.i(191753);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramp, "receiver");
      if (!(paramp instanceof ba))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramp + ", " + ai.cz(paramp.getClass())).toString());
        AppMethodBeat.o(191753);
        throw paramc;
      }
      paramc = ((ba)paramp).kom();
      kotlin.g.b.s.s(paramc, "this.variance");
      paramc = kotlin.l.b.a.b.m.c.s.a(paramc);
      AppMethodBeat.o(191753);
      return paramc;
    }
    
    public static boolean a(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191697);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191697);
        throw paramc;
      }
      boolean bool = af.ai((ad)parami);
      AppMethodBeat.o(191697);
      return bool;
    }
    
    public static boolean a(c paramc, kotlin.l.b.a.b.m.c.i parami, kotlin.l.b.a.b.f.c paramc1)
    {
      AppMethodBeat.i(191837);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      kotlin.g.b.s.u(paramc1, "fqName");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191837);
        throw paramc;
      }
      boolean bool = ((ad)parami).knl().i(paramc1);
      AppMethodBeat.o(191837);
      return bool;
    }
    
    public static boolean a(c paramc, kotlin.l.b.a.b.m.c.k paramk1, kotlin.l.b.a.b.m.c.k paramk2)
    {
      AppMethodBeat.i(191719);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk1, "a");
      kotlin.g.b.s.u(paramk2, "b");
      if (!(paramk1 instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk1 + ", " + ai.cz(paramk1.getClass())).toString());
        AppMethodBeat.o(191719);
        throw paramc;
      }
      if (!(paramk2 instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk2 + ", " + ai.cz(paramk2.getClass())).toString());
        AppMethodBeat.o(191719);
        throw paramc;
      }
      if (((al)paramk1).klR() == ((al)paramk2).klR())
      {
        AppMethodBeat.o(191719);
        return true;
      }
      AppMethodBeat.o(191719);
      return false;
    }
    
    public static boolean a(c paramc, kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(191743);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramn, "receiver");
      if (!(paramn instanceof kotlin.l.b.a.b.m.az))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + ai.cz(paramn.getClass())).toString());
        AppMethodBeat.o(191743);
        throw paramc;
      }
      boolean bool = ((kotlin.l.b.a.b.m.az)paramn).kAM();
      AppMethodBeat.o(191743);
      return bool;
    }
    
    public static boolean a(c paramc, o paramo)
    {
      AppMethodBeat.i(191672);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191672);
        throw paramc;
      }
      boolean bool = ((ax)paramo).knx();
      AppMethodBeat.o(191672);
      return bool;
    }
    
    public static boolean a(c paramc, o paramo1, o paramo2)
    {
      AppMethodBeat.i(191757);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo1, "c1");
      kotlin.g.b.s.u(paramo2, "c2");
      if (!(paramo1 instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo1 + ", " + ai.cz(paramo1.getClass())).toString());
        AppMethodBeat.o(191757);
        throw paramc;
      }
      if (!(paramo2 instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo2 + ", " + ai.cz(paramo2.getClass())).toString());
        AppMethodBeat.o(191757);
        throw paramc;
      }
      boolean bool = kotlin.g.b.s.p(paramo1, paramo2);
      AppMethodBeat.o(191757);
      return bool;
    }
    
    public static boolean a(c paramc, p paramp, o paramo)
    {
      AppMethodBeat.i(191755);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramp, "receiver");
      if (!(paramp instanceof ba))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramp + ", " + ai.cz(paramp.getClass())).toString());
        AppMethodBeat.o(191755);
        throw paramc;
      }
      if (paramo == null) {}
      for (boolean bool = true; !bool; bool = paramo instanceof ax)
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramp + ", " + ai.cz(paramp.getClass())).toString());
        AppMethodBeat.o(191755);
        throw paramc;
      }
      bool = kotlin.l.b.a.b.m.d.a.a((ba)paramp, (ax)paramo, 4);
      AppMethodBeat.o(191755);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.c b(c paramc, kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(191738);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramd, "receiver");
      if (!(paramd instanceof i))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + ai.cz(paramd.getClass())).toString());
        AppMethodBeat.o(191738);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.c)((i)paramd).ajrd;
      AppMethodBeat.o(191738);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.i b(c paramc, kotlin.l.b.a.b.m.c.k paramk1, kotlin.l.b.a.b.m.c.k paramk2)
    {
      AppMethodBeat.i(191792);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk1, "lowerBound");
      kotlin.g.b.s.u(paramk2, "upperBound");
      if (!(paramk1 instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramc + ", " + ai.cz(paramc.getClass())).toString());
        AppMethodBeat.o(191792);
        throw paramc;
      }
      if (!(paramk2 instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramc + ", " + ai.cz(paramc.getClass())).toString());
        AppMethodBeat.o(191792);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)ae.a((al)paramk1, (al)paramk2);
      AppMethodBeat.o(191792);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.i b(c paramc, p paramp)
    {
      AppMethodBeat.i(191842);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramp, "receiver");
      if (!(paramp instanceof ba))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramp + ", " + ai.cz(paramp.getClass())).toString());
        AppMethodBeat.o(191842);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)kotlin.l.b.a.b.m.d.a.d((ba)paramp);
      AppMethodBeat.o(191842);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k b(c paramc, kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(191726);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramg, "receiver");
      if (!(paramg instanceof x))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + ai.cz(paramg.getClass())).toString());
        AppMethodBeat.o(191726);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.k)((x)paramg).ajpF;
      AppMethodBeat.o(191726);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k b(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191721);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191721);
        throw paramc;
      }
      paramc = ((ad)parami).kAK();
      if ((paramc instanceof al)) {}
      for (paramc = (al)paramc;; paramc = null)
      {
        paramc = (kotlin.l.b.a.b.m.c.k)paramc;
        AppMethodBeat.o(191721);
        return paramc;
      }
    }
    
    public static w b(c paramc, kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(191745);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramn, "receiver");
      if (!(paramn instanceof kotlin.l.b.a.b.m.az))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + ai.cz(paramn.getClass())).toString());
        AppMethodBeat.o(191745);
        throw paramc;
      }
      paramc = ((kotlin.l.b.a.b.m.az)paramn).kAN();
      kotlin.g.b.s.s(paramc, "this.projectionKind");
      paramc = kotlin.l.b.a.b.m.c.s.a(paramc);
      AppMethodBeat.o(191745);
      return paramc;
    }
    
    public static boolean b(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191703);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191703);
        throw paramc;
      }
      if (!(paramk instanceof kotlin.l.b.a.b.m.e)) {
        if ((!(paramk instanceof kotlin.l.b.a.b.m.m)) || (!(((kotlin.l.b.a.b.m.m)paramk).ajpp instanceof kotlin.l.b.a.b.m.e))) {
          break label119;
        }
      }
      label119:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(191703);
        return true;
      }
      AppMethodBeat.o(191703);
      return false;
    }
    
    public static boolean b(c paramc, o paramo)
    {
      AppMethodBeat.i(191674);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191674);
        throw paramc;
      }
      boolean bool = paramo instanceof kotlin.l.b.a.b.j.b.n;
      AppMethodBeat.o(191674);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.g c(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191722);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191722);
        throw paramc;
      }
      paramc = ((ad)parami).kAK();
      if ((paramc instanceof x)) {}
      for (paramc = (x)paramc;; paramc = null)
      {
        paramc = (kotlin.l.b.a.b.m.c.g)paramc;
        AppMethodBeat.o(191722);
        return paramc;
      }
    }
    
    public static kotlin.l.b.a.b.m.c.i c(c paramc, kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(191746);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramn, "receiver");
      if (!(paramn instanceof kotlin.l.b.a.b.m.az))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + ai.cz(paramn.getClass())).toString());
        AppMethodBeat.o(191746);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)((kotlin.l.b.a.b.m.az)paramn).koG().kAK();
      AppMethodBeat.o(191746);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k c(c paramc, kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(191730);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramg, "receiver");
      if (!(paramg instanceof x))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + ai.cz(paramg.getClass())).toString());
        AppMethodBeat.o(191730);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.k)((x)paramg).ajpE;
      AppMethodBeat.o(191730);
      return paramc;
    }
    
    public static boolean c(c paramc, kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(191807);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramd, "receiver");
      if (!(paramd instanceof i))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + ai.cz(paramd.getClass())).toString());
        AppMethodBeat.o(191807);
        throw paramc;
      }
      boolean bool = ((i)paramd).ajrf;
      AppMethodBeat.o(191807);
      return bool;
    }
    
    public static boolean c(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191709);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191709);
        throw paramc;
      }
      if (!(paramk instanceof as)) {
        if ((!(paramk instanceof kotlin.l.b.a.b.m.m)) || (!(((kotlin.l.b.a.b.m.m)paramk).ajpp instanceof as))) {
          break label119;
        }
      }
      label119:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(191709);
        return true;
      }
      AppMethodBeat.o(191709);
      return false;
    }
    
    public static boolean c(c paramc, o paramo)
    {
      AppMethodBeat.i(191715);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191715);
        throw paramc;
      }
      boolean bool = paramo instanceof kotlin.l.b.a.b.m.ac;
      AppMethodBeat.o(191715);
      return bool;
    }
    
    public static int d(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191741);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191741);
        throw paramc;
      }
      int i = ((ad)parami).klR().size();
      AppMethodBeat.o(191741);
      return i;
    }
    
    public static int d(c paramc, o paramo)
    {
      AppMethodBeat.i(191747);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191747);
        throw paramc;
      }
      int i = ((ax)paramo).klq().size();
      AppMethodBeat.o(191747);
      return i;
    }
    
    public static b d(c paramc, kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(191811);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramd, "receiver");
      if (!(paramd instanceof i))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + ai.cz(paramd.getClass())).toString());
        AppMethodBeat.o(191811);
        throw paramc;
      }
      paramc = ((i)paramd).ajrc;
      AppMethodBeat.o(191811);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.d d(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191732);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191732);
        throw paramc;
      }
      if ((paramk instanceof an))
      {
        paramc = paramc.b((kotlin.l.b.a.b.m.c.k)((an)paramk).aiUV);
        AppMethodBeat.o(191732);
        return paramc;
      }
      if ((paramk instanceof i)) {}
      for (paramc = (i)paramk;; paramc = null)
      {
        paramc = (kotlin.l.b.a.b.m.c.d)paramc;
        AppMethodBeat.o(191732);
        return paramc;
      }
    }
    
    public static Collection<kotlin.l.b.a.b.m.c.i> e(c paramc, o paramo)
    {
      AppMethodBeat.i(191750);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191750);
        throw paramc;
      }
      paramc = ((ax)paramo).kpG();
      kotlin.g.b.s.s(paramc, "this.supertypes");
      AppMethodBeat.o(191750);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.e e(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191734);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191734);
        throw paramc;
      }
      if ((paramk instanceof kotlin.l.b.a.b.m.m)) {}
      for (paramc = (kotlin.l.b.a.b.m.m)paramk;; paramc = null)
      {
        paramc = (kotlin.l.b.a.b.m.c.e)paramc;
        AppMethodBeat.o(191734);
        return paramc;
      }
    }
    
    public static kotlin.l.b.a.b.m.c.n e(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191775);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191775);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.n)kotlin.l.b.a.b.m.d.a.aF((ad)parami);
      AppMethodBeat.o(191775);
      return paramc;
    }
    
    public static boolean e(c paramc, kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(191818);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramd, "receiver");
      boolean bool = paramd instanceof kotlin.l.b.a.b.j.a.a.a;
      AppMethodBeat.o(191818);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.i f(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191799);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if ((parami instanceof kotlin.l.b.a.b.m.c.k))
      {
        paramc = (kotlin.l.b.a.b.m.c.i)paramc.a((kotlin.l.b.a.b.m.c.k)parami, true);
        AppMethodBeat.o(191799);
        return paramc;
      }
      if ((parami instanceof kotlin.l.b.a.b.m.c.g))
      {
        paramc = paramc.a(paramc.a(paramc.b((kotlin.l.b.a.b.m.c.g)parami), true), paramc.a(paramc.c((kotlin.l.b.a.b.m.c.g)parami), true));
        AppMethodBeat.o(191799);
        return paramc;
      }
      paramc = (Throwable)new IllegalStateException("sealed".toString());
      AppMethodBeat.o(191799);
      throw paramc;
    }
    
    public static boolean f(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191735);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191735);
        throw paramc;
      }
      boolean bool = ((al)paramk).ksB();
      AppMethodBeat.o(191735);
      return bool;
    }
    
    public static boolean f(c paramc, o paramo)
    {
      AppMethodBeat.i(191758);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191758);
        throw paramc;
      }
      boolean bool = ((ax)paramo).knA() instanceof kotlin.l.b.a.b.b.e;
      AppMethodBeat.o(191758);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.i g(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191803);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof bk))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191803);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)ao.b((bk)parami);
      AppMethodBeat.o(191803);
      return paramc;
    }
    
    public static o g(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191737);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191737);
        throw paramc;
      }
      paramc = (o)((al)paramk).kzm();
      AppMethodBeat.o(191737);
      return paramc;
    }
    
    public static boolean g(c paramc, o paramo)
    {
      AppMethodBeat.i(191760);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191760);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if ((paramc instanceof kotlin.l.b.a.b.b.e)) {}
      for (paramc = (kotlin.l.b.a.b.b.e)paramc; paramc == null; paramc = null)
      {
        AppMethodBeat.o(191760);
        return false;
      }
      if ((kotlin.l.b.a.b.b.ac.o(paramc)) && (paramc.kna() != kotlin.l.b.a.b.b.f.aiGw) && (paramc.kna() != kotlin.l.b.a.b.b.f.aiGx))
      {
        AppMethodBeat.o(191760);
        return true;
      }
      AppMethodBeat.o(191760);
      return false;
    }
    
    public static kotlin.l.b.a.b.m.c.m h(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191762);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191762);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.m)paramk;
      AppMethodBeat.o(191762);
      return paramc;
    }
    
    public static boolean h(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191823);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191823);
        throw paramc;
      }
      boolean bool = bg.aw((ad)parami);
      AppMethodBeat.o(191823);
      return bool;
    }
    
    public static boolean h(c paramc, o paramo)
    {
      AppMethodBeat.i(191766);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191766);
        throw paramc;
      }
      boolean bool = h.a((ax)paramo, k.a.aiCy);
      AppMethodBeat.o(191766);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.i i(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191843);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      if (!(parami instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + ai.cz(parami.getClass())).toString());
        AppMethodBeat.o(191843);
        throw paramc;
      }
      paramc = (kotlin.l.b.a.b.m.c.i)kotlin.l.b.a.b.j.f.S((ad)parami);
      AppMethodBeat.o(191843);
      return paramc;
    }
    
    public static boolean i(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191778);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof al))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191778);
        throw paramc;
      }
      if ((!af.ai((ad)paramk)) && (!(((al)paramk).kzm().knA() instanceof kotlin.l.b.a.b.b.az)) && ((((al)paramk).kzm().knA() != null) || ((paramk instanceof kotlin.l.b.a.b.j.a.a.a)) || ((paramk instanceof i)) || ((paramk instanceof kotlin.l.b.a.b.m.m)) || ((((al)paramk).kzm() instanceof kotlin.l.b.a.b.j.b.n)) || (j(paramc, paramk))))
      {
        AppMethodBeat.o(191778);
        return true;
      }
      AppMethodBeat.o(191778);
      return false;
    }
    
    public static boolean i(c paramc, o paramo)
    {
      AppMethodBeat.i(191769);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191769);
        throw paramc;
      }
      boolean bool = h.a((ax)paramo, k.a.aiCz);
      AppMethodBeat.o(191769);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.i j(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(61042);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      paramc = bf.a.b((bf)paramc, parami);
      AppMethodBeat.o(61042);
      return paramc;
    }
    
    public static p j(c paramc, o paramo)
    {
      AppMethodBeat.i(191840);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191840);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if ((paramc instanceof ba)) {}
      for (paramc = (ba)paramc;; paramc = null)
      {
        paramc = (p)paramc;
        AppMethodBeat.o(191840);
        return paramc;
      }
    }
    
    private static boolean j(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191783);
      if (((paramk instanceof an)) && (paramc.h((kotlin.l.b.a.b.m.c.k)((an)paramk).aiUV)))
      {
        AppMethodBeat.o(191783);
        return true;
      }
      AppMethodBeat.o(191783);
      return false;
    }
    
    public static boolean k(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191849);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.a((t)paramc, parami);
      AppMethodBeat.o(191849);
      return bool;
    }
    
    public static boolean k(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191834);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      if (!(paramk instanceof ad))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramk + ", " + ai.cz(paramk.getClass())).toString());
        AppMethodBeat.o(191834);
        throw paramc;
      }
      boolean bool = h.p((ad)paramk);
      AppMethodBeat.o(191834);
      return bool;
    }
    
    public static boolean k(c paramc, o paramo)
    {
      AppMethodBeat.i(191841);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191841);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if ((paramc instanceof kotlin.l.b.a.b.b.e)) {}
      for (paramc = (kotlin.l.b.a.b.b.e)paramc; (paramc != null) && (kotlin.l.b.a.b.j.f.D((l)paramc) == true); paramc = null)
      {
        AppMethodBeat.o(191841);
        return true;
      }
      AppMethodBeat.o(191841);
      return false;
    }
    
    public static kotlin.l.b.a.b.a.i l(c paramc, o paramo)
    {
      AppMethodBeat.i(191844);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191844);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(191844);
        throw paramc;
      }
      paramc = h.e((l)paramc);
      AppMethodBeat.o(191844);
      return paramc;
    }
    
    public static boolean l(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191850);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.b((t)paramc, parami);
      AppMethodBeat.o(191850);
      return bool;
    }
    
    public static boolean l(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191862);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      boolean bool = t.a.a((t)paramc, paramk);
      AppMethodBeat.o(191862);
      return bool;
    }
    
    public static kotlin.l.b.a.b.a.i m(c paramc, o paramo)
    {
      AppMethodBeat.i(191845);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191845);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(191845);
        throw paramc;
      }
      paramc = h.f((l)paramc);
      AppMethodBeat.o(191845);
      return paramc;
    }
    
    public static boolean m(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191851);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.c((t)paramc, parami);
      AppMethodBeat.o(191851);
      return bool;
    }
    
    public static boolean m(c paramc, kotlin.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(191863);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramk, "receiver");
      boolean bool = t.a.b((t)paramc, paramk);
      AppMethodBeat.o(191863);
      return bool;
    }
    
    public static boolean n(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191853);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.d((t)paramc, parami);
      AppMethodBeat.o(191853);
      return bool;
    }
    
    public static boolean n(c paramc, o paramo)
    {
      AppMethodBeat.i(191846);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191846);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if ((paramc != null) && (h.d((l)paramc) == true))
      {
        AppMethodBeat.o(191846);
        return true;
      }
      AppMethodBeat.o(191846);
      return false;
    }
    
    public static kotlin.l.b.a.b.f.d o(c paramc, o paramo)
    {
      AppMethodBeat.i(191848);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(paramo, "receiver");
      if (!(paramo instanceof ax))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + ai.cz(paramo.getClass())).toString());
        AppMethodBeat.o(191848);
        throw paramc;
      }
      paramc = ((ax)paramo).knA();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(191848);
        throw paramc;
      }
      paramc = kotlin.l.b.a.b.j.d.a.q((l)paramc);
      AppMethodBeat.o(191848);
      return paramc;
    }
    
    public static boolean o(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(61036);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.e((t)paramc, parami);
      AppMethodBeat.o(61036);
      return bool;
    }
    
    public static boolean p(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(191855);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      boolean bool = t.a.f((t)paramc, parami);
      AppMethodBeat.o(191855);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.k q(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(61039);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      paramc = t.a.g((t)paramc, parami);
      AppMethodBeat.o(61039);
      return paramc;
    }
    
    public static o r(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(61037);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      paramc = t.a.h((t)paramc, parami);
      AppMethodBeat.o(61037);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.k s(c paramc, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(61041);
      kotlin.g.b.s.u(paramc, "this");
      kotlin.g.b.s.u(parami, "receiver");
      paramc = t.a.i((t)paramc, parami);
      AppMethodBeat.o(61041);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.c
 * JD-Core Version:    0.7.0.1
 */