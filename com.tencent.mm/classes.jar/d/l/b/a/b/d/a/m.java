package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.d.b.k.c;
import d.l.b.a.b.j.d.a;
import d.l.b.a.b.j.d.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.o;
import java.util.Iterator;
import java.util.List;

public final class m
  implements d.l.b.a.b.j.d
{
  public static final a Jya;
  
  static
  {
    AppMethodBeat.i(57591);
    Jya = new a((byte)0);
    AppMethodBeat.o(57591);
  }
  
  public final d.b a(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(57590);
    d.g.b.k.h(parama1, "superDescriptor");
    d.g.b.k.h(parama2, "subDescriptor");
    int i;
    if ((!(parama1 instanceof b)) || (!(parama2 instanceof d.l.b.a.b.b.t)) || (g.c((l)parama2))) {
      i = 0;
    }
    b localb;
    boolean bool;
    while (i != 0)
    {
      parama1 = d.b.JRo;
      AppMethodBeat.o(57590);
      return parama1;
      localObject = d.JxA;
      localObject = ((d.l.b.a.b.b.t)parama2).fyB();
      d.g.b.k.g(localObject, "subDescriptor.name");
      if (!d.g((d.l.b.a.b.f.f)localObject))
      {
        localObject = c.Jxr;
        localObject = ((d.l.b.a.b.b.t)parama2).fyB();
        d.g.b.k.g(localObject, "subDescriptor.name");
        if (!c.e((d.l.b.a.b.f.f)localObject))
        {
          i = 0;
          continue;
        }
      }
      localb = t.o((b)parama1);
      bool = ((d.l.b.a.b.b.t)parama2).fyO();
      if ((parama1 instanceof d.l.b.a.b.b.t)) {
        break label379;
      }
    }
    label219:
    label379:
    for (Object localObject = null;; localObject = parama1)
    {
      localObject = (d.l.b.a.b.b.t)localObject;
      if ((localObject == null) || (bool != ((d.l.b.a.b.b.t)localObject).fyO())) {}
      for (i = 1;; i = 0)
      {
        if ((i == 0) || ((localb != null) && (((d.l.b.a.b.b.t)parama2).fyO()))) {
          break label219;
        }
        i = 1;
        break;
      }
      if ((!(parame instanceof d.l.b.a.b.d.a.b.d)) || (((d.l.b.a.b.b.t)parama2).fyN() != null))
      {
        i = 0;
        break;
      }
      if ((localb == null) || (t.a(parame, (d.l.b.a.b.b.a)localb)))
      {
        i = 0;
        break;
      }
      if (((localb instanceof d.l.b.a.b.b.t)) && ((parama1 instanceof d.l.b.a.b.b.t)) && (d.e((d.l.b.a.b.b.t)localb) != null))
      {
        parame = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)parama2, false, false, 2);
        localObject = ((d.l.b.a.b.b.t)parama1).fyM();
        d.g.b.k.g(localObject, "superDescriptor.original");
        if (d.g.b.k.g(parame, d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)localObject, false, false, 2)))
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      if (a.a(parama1, parama2))
      {
        parama1 = d.b.JRo;
        AppMethodBeat.o(57590);
        return parama1;
      }
      parama1 = d.b.JRp;
      AppMethodBeat.o(57590);
      return parama1;
    }
  }
  
  public final d.a fBn()
  {
    return d.a.JRi;
  }
  
  public static final class a
  {
    private static d.l.b.a.b.d.b.k a(d.l.b.a.b.b.t paramt, av paramav)
    {
      AppMethodBeat.i(57588);
      if ((d.l.b.a.b.d.b.t.b((d.l.b.a.b.b.a)paramt)) || (f(paramt)))
      {
        paramt = paramav.fzr();
        d.g.b.k.g(paramt, "valueParameterDescriptor.type");
        paramt = d.l.b.a.b.d.b.t.V(d.l.b.a.b.m.d.a.aD(paramt));
        AppMethodBeat.o(57588);
        return paramt;
      }
      paramt = paramav.fzr();
      d.g.b.k.g(paramt, "valueParameterDescriptor.type");
      paramt = d.l.b.a.b.d.b.t.V(paramt);
      AppMethodBeat.o(57588);
      return paramt;
    }
    
    public static boolean a(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
    {
      AppMethodBeat.i(57587);
      d.g.b.k.h(parama1, "superDescriptor");
      d.g.b.k.h(parama2, "subDescriptor");
      if ((!(parama2 instanceof d.l.b.a.b.d.a.b.f)) || (!(parama1 instanceof d.l.b.a.b.b.t)))
      {
        AppMethodBeat.o(57587);
        return false;
      }
      if (((d.l.b.a.b.d.a.b.f)parama2).fyq().size() == ((d.l.b.a.b.b.t)parama1).fyq().size()) {}
      for (int i = 1; (aa.JfW) && (i == 0); i = 0)
      {
        parama1 = (Throwable)new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
        AppMethodBeat.o(57587);
        throw parama1;
      }
      Object localObject1 = ((d.l.b.a.b.d.a.b.f)parama2).fAn();
      d.g.b.k.g(localObject1, "subDescriptor.original");
      localObject1 = ((am)localObject1).fyq();
      d.g.b.k.g(localObject1, "subDescriptor.original.valueParameters");
      localObject1 = (Iterable)localObject1;
      Object localObject2 = ((d.l.b.a.b.b.t)parama1).fyM();
      d.g.b.k.g(localObject2, "superDescriptor.original");
      localObject2 = ((d.l.b.a.b.b.t)localObject2).fyq();
      d.g.b.k.g(localObject2, "superDescriptor.original.valueParameters");
      localObject1 = j.b((Iterable)localObject1, (Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (o)((Iterator)localObject1).next();
        localObject2 = (av)((o)localObject3).first;
        localObject3 = (av)((o)localObject3).second;
        d.l.b.a.b.b.t localt = (d.l.b.a.b.b.t)parama2;
        d.g.b.k.g(localObject2, "subParameter");
        boolean bool = a(localt, (av)localObject2) instanceof k.c;
        localObject2 = (d.l.b.a.b.b.t)parama1;
        d.g.b.k.g(localObject3, "superParameter");
        if (bool != a((d.l.b.a.b.b.t)localObject2, (av)localObject3) instanceof k.c)
        {
          AppMethodBeat.o(57587);
          return true;
        }
      }
      AppMethodBeat.o(57587);
      return false;
    }
    
    private static boolean f(d.l.b.a.b.b.t paramt)
    {
      AppMethodBeat.i(57589);
      if (paramt.fyq().size() != 1)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      Object localObject2 = paramt.fxq();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof e)) {
        localObject1 = null;
      }
      localObject2 = (e)localObject1;
      if (localObject2 == null)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      paramt = paramt.fyq();
      d.g.b.k.g(paramt, "f.valueParameters");
      paramt = j.iC(paramt);
      d.g.b.k.g(paramt, "f.valueParameters.single()");
      localObject1 = ((av)paramt).fzr().fIW().fxM();
      paramt = (d.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof e)) {
        paramt = null;
      }
      paramt = (e)paramt;
      if (paramt == null)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      if ((g.d((e)localObject2)) && (d.g.b.k.g(d.l.b.a.b.j.d.a.o((l)localObject2), d.l.b.a.b.j.d.a.o((l)paramt))))
      {
        AppMethodBeat.o(57589);
        return true;
      }
      AppMethodBeat.o(57589);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.m
 * JD-Core Version:    0.7.0.1
 */