package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.s;
import kotlin.l.b.a.ai;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.s;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.k.a.v;
import kotlin.l.b.a.j;
import kotlin.l.b.a.k;

@Metadata(d1={""}, d2={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class b
{
  public static final <R> kotlin.l.f<R> a(d<? extends R> paramd)
  {
    AppMethodBeat.i(56271);
    s.u(paramd, "$this$reflect");
    Object localObject2 = (Metadata)paramd.getClass().getAnnotation(Metadata.class);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56271);
      return null;
    }
    Object localObject1 = ((Metadata)localObject2).d1();
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
    Object localObject3 = kotlin.l.b.a.b.e.c.a.g.h((String[])localObject1, ((Metadata)localObject2).d2());
    localObject1 = (kotlin.l.b.a.b.e.c.a.f)((kotlin.r)localObject3).bsC;
    localObject3 = (a.h)((kotlin.r)localObject3).bsD;
    Object localObject4 = ((Metadata)localObject2).mv();
    if ((((Metadata)localObject2).xi() & 0x8) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = new kotlin.l.b.a.b.e.c.a.e((int[])localObject4, bool);
      paramd = paramd.getClass();
      localObject4 = (kotlin.l.b.a.b.h.r)localObject3;
      localObject1 = (c)localObject1;
      localObject3 = ((a.h)localObject3).aiYZ;
      s.s(localObject3, "proto.typeTable");
      paramd = (au)ai.a(paramd, (kotlin.l.b.a.b.h.r)localObject4, (c)localObject1, new kotlin.l.b.a.b.e.b.g((a.s)localObject3), (a)localObject2, (m)a.aixW);
      if (paramd != null) {
        break;
      }
      AppMethodBeat.o(56271);
      return null;
    }
    paramd = (kotlin.l.f)new k((j)kotlin.l.b.a.b.aixY, (x)paramd);
    AppMethodBeat.o(56271);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.b
 * JD-Core Version:    0.7.0.1
 */