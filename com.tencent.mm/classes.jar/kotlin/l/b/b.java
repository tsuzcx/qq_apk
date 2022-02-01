package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.ae;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.s;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a.f;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.j;
import kotlin.l.d;
import kotlin.l.e;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"})
public final class b
{
  public static final <R> e<R> a(kotlin.c<? extends R> paramc)
  {
    AppMethodBeat.i(56271);
    p.k(paramc, "$this$reflect");
    Object localObject2 = (l)paramc.getClass().getAnnotation(l.class);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56271);
      return null;
    }
    Object localObject1 = ((l)localObject2).iBL();
    int i;
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label72;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label77;
      }
      AppMethodBeat.o(56271);
      return null;
      i = 0;
      break;
      label72:
      localObject1 = null;
    }
    label77:
    Object localObject3 = kotlin.l.b.a.b.e.c.a.i.g((String[])localObject1, ((l)localObject2).iBM());
    localObject1 = (g)((o)localObject3).Mx;
    localObject3 = (a.h)((o)localObject3).My;
    Object localObject4 = ((l)localObject2).iBK();
    if ((((l)localObject2).iBN() & 0x8) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new f((int[])localObject4, bool);
      paramc = paramc.getClass();
      localObject4 = (r)localObject3;
      localObject1 = (kotlin.l.b.a.b.e.b.c)localObject1;
      localObject3 = ((a.h)localObject3).abay;
      p.j(localObject3, "proto.typeTable");
      paramc = (am)ae.a(paramc, (r)localObject4, (kotlin.l.b.a.b.e.b.c)localObject1, new h((a.s)localObject3), (kotlin.l.b.a.b.e.b.a)localObject2, (m)a.aaCo);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(56271);
      return null;
    }
    paramc = (e)new j((kotlin.l.b.a.i)kotlin.l.b.a.a.aaCp, (t)paramc);
    AppMethodBeat.o(56271);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.b
 * JD-Core Version:    0.7.0.1
 */