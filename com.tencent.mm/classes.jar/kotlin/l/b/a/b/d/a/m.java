package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.b.k;
import kotlin.l.b.a.b.d.b.k.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.j.d.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.o;
import kotlin.z;

public final class m
  implements kotlin.l.b.a.b.j.d
{
  public static final a aaRX;
  
  static
  {
    AppMethodBeat.i(57591);
    aaRX = new a((byte)0);
    AppMethodBeat.o(57591);
  }
  
  public final d.b a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, e parame)
  {
    AppMethodBeat.i(57590);
    p.k(parama1, "superDescriptor");
    p.k(parama2, "subDescriptor");
    int i;
    if ((!(parama1 instanceof b)) || (!(parama2 instanceof kotlin.l.b.a.b.b.t)) || (g.c((l)parama2))) {
      i = 0;
    }
    b localb;
    boolean bool;
    while (i != 0)
    {
      parama1 = d.b.abkm;
      AppMethodBeat.o(57590);
      return parama1;
      localObject = d.aaRx;
      localObject = ((kotlin.l.b.a.b.b.t)parama2).iEU();
      p.j(localObject, "subDescriptor.name");
      if (!d.g((kotlin.l.b.a.b.f.f)localObject))
      {
        localObject = c.aaRo;
        localObject = ((kotlin.l.b.a.b.b.t)parama2).iEU();
        p.j(localObject, "subDescriptor.name");
        if (!c.e((kotlin.l.b.a.b.f.f)localObject))
        {
          i = 0;
          continue;
        }
      }
      localb = t.o((b)parama1);
      bool = ((kotlin.l.b.a.b.b.t)parama2).iFj();
      if ((parama1 instanceof kotlin.l.b.a.b.b.t)) {
        break label379;
      }
    }
    label219:
    label379:
    for (Object localObject = null;; localObject = parama1)
    {
      localObject = (kotlin.l.b.a.b.b.t)localObject;
      if ((localObject == null) || (bool != ((kotlin.l.b.a.b.b.t)localObject).iFj())) {}
      for (i = 1;; i = 0)
      {
        if ((i == 0) || ((localb != null) && (((kotlin.l.b.a.b.b.t)parama2).iFj()))) {
          break label219;
        }
        i = 1;
        break;
      }
      if ((!(parame instanceof kotlin.l.b.a.b.d.a.b.d)) || (((kotlin.l.b.a.b.b.t)parama2).iFi() != null))
      {
        i = 0;
        break;
      }
      if ((localb == null) || (t.a(parame, (kotlin.l.b.a.b.b.a)localb)))
      {
        i = 0;
        break;
      }
      if (((localb instanceof kotlin.l.b.a.b.b.t)) && ((parama1 instanceof kotlin.l.b.a.b.b.t)) && (d.e((kotlin.l.b.a.b.b.t)localb) != null))
      {
        parame = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)parama2, false, false, 2);
        localObject = ((kotlin.l.b.a.b.b.t)parama1).iFh();
        p.j(localObject, "superDescriptor.original");
        if (p.h(parame, kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)localObject, false, false, 2)))
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      if (a.a(parama1, parama2))
      {
        parama1 = d.b.abkm;
        AppMethodBeat.o(57590);
        return parama1;
      }
      parama1 = d.b.abkn;
      AppMethodBeat.o(57590);
      return parama1;
    }
  }
  
  public final d.a iHN()
  {
    return d.a.abkg;
  }
  
  public static final class a
  {
    private static k a(kotlin.l.b.a.b.b.t paramt, av paramav)
    {
      AppMethodBeat.i(57588);
      if ((kotlin.l.b.a.b.d.b.t.b((kotlin.l.b.a.b.b.a)paramt)) || (f(paramt)))
      {
        paramt = paramav.iFN();
        p.j(paramt, "valueParameterDescriptor.type");
        paramt = kotlin.l.b.a.b.d.b.t.U(kotlin.l.b.a.b.m.d.a.aC(paramt));
        AppMethodBeat.o(57588);
        return paramt;
      }
      paramt = paramav.iFN();
      p.j(paramt, "valueParameterDescriptor.type");
      paramt = kotlin.l.b.a.b.d.b.t.U(paramt);
      AppMethodBeat.o(57588);
      return paramt;
    }
    
    public static boolean a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
    {
      AppMethodBeat.i(57587);
      p.k(parama1, "superDescriptor");
      p.k(parama2, "subDescriptor");
      if ((!(parama2 instanceof kotlin.l.b.a.b.d.a.b.f)) || (!(parama1 instanceof kotlin.l.b.a.b.b.t)))
      {
        AppMethodBeat.o(57587);
        return false;
      }
      if (((kotlin.l.b.a.b.d.a.b.f)parama2).iEJ().size() == ((kotlin.l.b.a.b.b.t)parama1).iEJ().size()) {}
      for (int i = 1; (z.aazO) && (i == 0); i = 0)
      {
        parama1 = (Throwable)new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
        AppMethodBeat.o(57587);
        throw parama1;
      }
      Object localObject1 = ((kotlin.l.b.a.b.d.a.b.f)parama2).iGK();
      p.j(localObject1, "subDescriptor.original");
      localObject1 = ((am)localObject1).iEJ();
      p.j(localObject1, "subDescriptor.original.valueParameters");
      localObject1 = (Iterable)localObject1;
      Object localObject2 = ((kotlin.l.b.a.b.b.t)parama1).iFh();
      p.j(localObject2, "superDescriptor.original");
      localObject2 = ((kotlin.l.b.a.b.b.t)localObject2).iEJ();
      p.j(localObject2, "superDescriptor.original.valueParameters");
      localObject1 = j.c((Iterable)localObject1, (Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (o)((Iterator)localObject1).next();
        localObject2 = (av)((o)localObject3).Mx;
        localObject3 = (av)((o)localObject3).My;
        kotlin.l.b.a.b.b.t localt = (kotlin.l.b.a.b.b.t)parama2;
        p.j(localObject2, "subParameter");
        boolean bool = a(localt, (av)localObject2) instanceof k.c;
        localObject2 = (kotlin.l.b.a.b.b.t)parama1;
        p.j(localObject3, "superParameter");
        if (bool != a((kotlin.l.b.a.b.b.t)localObject2, (av)localObject3) instanceof k.c)
        {
          AppMethodBeat.o(57587);
          return true;
        }
      }
      AppMethodBeat.o(57587);
      return false;
    }
    
    private static boolean f(kotlin.l.b.a.b.b.t paramt)
    {
      AppMethodBeat.i(57589);
      if (paramt.iEJ().size() != 1)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      Object localObject2 = paramt.iDJ();
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
      paramt = paramt.iEJ();
      p.j(paramt, "f.valueParameters");
      paramt = j.ls(paramt);
      p.j(paramt, "f.valueParameters.single()");
      localObject1 = ((av)paramt).iFN().iOU().iEf();
      paramt = (kotlin.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof e)) {
        paramt = null;
      }
      paramt = (e)paramt;
      if (paramt == null)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      if ((g.d((e)localObject2)) && (p.h(kotlin.l.b.a.b.j.d.a.o((l)localObject2), kotlin.l.b.a.b.j.d.a.o((l)paramt))))
      {
        AppMethodBeat.o(57589);
        return true;
      }
      AppMethodBeat.o(57589);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.m
 * JD-Core Version:    0.7.0.1
 */