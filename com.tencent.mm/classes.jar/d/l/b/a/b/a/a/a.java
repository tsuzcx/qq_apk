package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.x;
import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.i;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  implements d.l.b.a.b.b.b.b
{
  public static final a.a Joo;
  private final i JlL;
  private final y Jon;
  
  static
  {
    AppMethodBeat.i(56715);
    Joo = new a.a((byte)0);
    AppMethodBeat.o(56715);
  }
  
  public a(i parami, y paramy)
  {
    AppMethodBeat.i(56714);
    this.JlL = parami;
    this.Jon = paramy;
    AppMethodBeat.o(56714);
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, f paramf)
  {
    AppMethodBeat.i(56711);
    k.h(paramb, "packageFqName");
    k.h(paramf, "name");
    paramf = paramf.qV();
    k.g(paramf, "name.asString()");
    if (((n.mA(paramf, "Function")) || (n.mA(paramf, "KFunction")) || (n.mA(paramf, "SuspendFunction")) || (n.mA(paramf, "KSuspendFunction"))) && (a.a.a(paramf, paramb) != null))
    {
      AppMethodBeat.o(56711);
      return true;
    }
    AppMethodBeat.o(56711);
    return false;
  }
  
  public final d.l.b.a.b.b.e b(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56712);
    k.h(parama, "classId");
    if ((parama.BOl) || (parama.fHa()))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    Object localObject1 = parama.fGX().qV();
    k.g(localObject1, "classId.relativeClassName.asString()");
    if (!n.a((CharSequence)localObject1, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    parama = parama.fGW();
    k.g(parama, "classId.packageFqName");
    Object localObject2 = a.a.a((String)localObject1, parama);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56712);
      return null;
    }
    localObject1 = ((a.b)localObject2).Jop;
    int i = ((a.b)localObject2).arity;
    localObject2 = (Iterable)this.Jon.e(parama).getFragments();
    parama = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof d.l.b.a.b.a.b)) {
        parama.add(localObject3);
      }
    }
    parama = (List)parama;
    Object localObject3 = (Iterable)parama;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if ((localObject4 instanceof d.l.b.a.b.a.e)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject2 = (d.l.b.a.b.a.e)j.iz((List)localObject2);
    if (localObject2 != null) {}
    for (parama = (d.l.b.a.b.a.b)localObject2;; parama = (d.l.b.a.b.a.b)j.iy(parama))
    {
      parama = (d.l.b.a.b.b.e)new b(this.JlL, (ab)parama, (b.c)localObject1, i);
      AppMethodBeat.o(56712);
      return parama;
    }
  }
  
  public final Collection<d.l.b.a.b.b.e> b(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56713);
    k.h(paramb, "packageFqName");
    paramb = (Collection)x.Jgn;
    AppMethodBeat.o(56713);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */