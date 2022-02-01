package d.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.l.b.a.af;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.t;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.s;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.c.a.f;
import d.l.b.a.b.e.c.a.g;
import d.l.b.a.b.h.q;
import d.l.b.a.b.k.a.w;
import d.l.d;
import d.l.e;
import d.o;

@l(fNY={1, 1, 15}, fNZ={""}, fOa={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"})
public final class b
{
  public static final <R> e<R> a(d.c<? extends R> paramc)
  {
    AppMethodBeat.i(56271);
    k.h(paramc, "$this$reflect");
    Object localObject2 = (l)paramc.getClass().getAnnotation(l.class);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56271);
      return null;
    }
    Object localObject1 = ((l)localObject2).fNZ();
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
    Object localObject3 = d.l.b.a.b.e.c.a.i.g((String[])localObject1, ((l)localObject2).fOa());
    localObject1 = (g)((o)localObject3).first;
    localObject3 = (a.h)((o)localObject3).second;
    Object localObject4 = ((l)localObject2).fNY();
    if ((((l)localObject2).fOb() & 0x8) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new f((int[])localObject4, bool);
      paramc = paramc.getClass();
      localObject4 = (q)localObject3;
      localObject1 = (d.l.b.a.b.e.b.c)localObject1;
      localObject3 = ((a.h)localObject3).Luc;
      k.g(localObject3, "proto.typeTable");
      paramc = (am)af.a(paramc, (q)localObject4, (d.l.b.a.b.e.b.c)localObject1, new h((a.s)localObject3), (d.l.b.a.b.e.b.a)localObject2, (m)a.KVB);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(56271);
      return null;
    }
    paramc = (e)new d.l.b.a.j((d.l.b.a.i)d.l.b.a.a.KVC, (t)paramc);
    AppMethodBeat.o(56271);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.b
 * JD-Core Version:    0.7.0.1
 */