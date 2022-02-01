package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.d.a.b.c;
import kotlin.l.b.a.b.d.b.j;
import kotlin.l.b.a.b.d.b.j.d;
import kotlin.l.b.a.b.d.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.a;
import kotlin.l.b.a.b.j.e.b;
import kotlin.l.b.a.b.m.ax;
import kotlin.r;

public final class p
  implements kotlin.l.b.a.b.j.e
{
  public static final a aiOT;
  
  static
  {
    AppMethodBeat.i(57591);
    aiOT = new a((byte)0);
    AppMethodBeat.o(57591);
  }
  
  public final e.b a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57590);
    s.u(parama1, "superDescriptor");
    s.u(parama2, "subDescriptor");
    int i;
    if ((!(parama1 instanceof b)) || (!(parama2 instanceof x)) || (kotlin.l.b.a.b.a.h.c((l)parama2))) {
      i = 0;
    }
    while (i != 0)
    {
      parama1 = e.b.ajiS;
      AppMethodBeat.o(57590);
      return parama1;
      Object localObject = e.aiOw;
      localObject = ((x)parama2).kok();
      s.s(localObject, "subDescriptor.name");
      if (!e.e((f)localObject))
      {
        localObject = ad.aiQo;
        localObject = ((x)parama2).kok();
        s.s(localObject, "subDescriptor.name");
        if (!ad.a.i((f)localObject))
        {
          i = 0;
          continue;
        }
      }
      b localb = ac.o((b)parama1);
      boolean bool = ((x)parama2).koJ();
      if ((parama1 instanceof x))
      {
        localObject = (x)parama1;
        label161:
        if ((localObject == null) || (bool != ((x)localObject).koJ())) {
          break label223;
        }
        i = 1;
        label181:
        if (i != 0) {
          break label229;
        }
      }
      label223:
      label229:
      for (i = 1;; i = 0)
      {
        if ((i == 0) || ((localb != null) && (((x)parama2).koJ()))) {
          break label235;
        }
        i = 1;
        break;
        localObject = null;
        break label161;
        i = 0;
        break label181;
      }
      label235:
      if ((!(parame instanceof c)) || (((x)parama2).koI() != null))
      {
        i = 0;
      }
      else if ((localb == null) || (ac.a(parame, (kotlin.l.b.a.b.b.a)localb)))
      {
        i = 0;
      }
      else
      {
        if (((localb instanceof x)) && ((parama1 instanceof x)) && (e.e((x)localb) != null))
        {
          parame = t.a((x)parama2, false, false, 2);
          localObject = ((x)parama1).koH();
          s.s(localObject, "superDescriptor.original");
          if (s.p(parame, t.a((x)localObject, false, false, 2)))
          {
            i = 0;
            continue;
          }
        }
        i = 1;
      }
    }
    if (a.a(parama1, parama2))
    {
      parama1 = e.b.ajiS;
      AppMethodBeat.o(57590);
      return parama1;
    }
    parama1 = e.b.ajiT;
    AppMethodBeat.o(57590);
    return parama1;
  }
  
  public final e.a krB()
  {
    return e.a.ajiM;
  }
  
  public static final class a
  {
    private static j a(x paramx, bd parambd)
    {
      AppMethodBeat.i(57588);
      if ((t.b((kotlin.l.b.a.b.b.a)paramx)) || (f(paramx)))
      {
        paramx = parambd.koG();
        s.s(paramx, "valueParameterDescriptor.type");
        paramx = t.L(kotlin.l.b.a.b.m.d.a.at(paramx));
        AppMethodBeat.o(57588);
        return paramx;
      }
      paramx = parambd.koG();
      s.s(paramx, "valueParameterDescriptor.type");
      paramx = t.L(paramx);
      AppMethodBeat.o(57588);
      return paramx;
    }
    
    public static boolean a(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
    {
      AppMethodBeat.i(57587);
      s.u(parama1, "superDescriptor");
      s.u(parama2, "subDescriptor");
      if ((!(parama2 instanceof kotlin.l.b.a.b.d.a.b.e)) || (!(parama1 instanceof x)))
      {
        AppMethodBeat.o(57587);
        return false;
      }
      if (((kotlin.l.b.a.b.d.a.b.e)parama2).kod().size() == ((x)parama1).kod().size()) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        parama1 = (Throwable)new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
        AppMethodBeat.o(57587);
        throw parama1;
      }
      Object localObject1 = ((kotlin.l.b.a.b.d.a.b.e)parama2).kqi().kod();
      s.s(localObject1, "subDescriptor.original.valueParameters");
      localObject1 = (Iterable)localObject1;
      Object localObject2 = ((x)parama1).koH().kod();
      s.s(localObject2, "superDescriptor.original.valueParameters");
      localObject1 = kotlin.a.p.d((Iterable)localObject1, (Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (r)((Iterator)localObject1).next();
        localObject2 = (bd)((r)localObject3).bsC;
        localObject3 = (bd)((r)localObject3).bsD;
        x localx = (x)parama2;
        s.s(localObject2, "subParameter");
        boolean bool = a(localx, (bd)localObject2) instanceof j.d;
        localObject2 = (x)parama1;
        s.s(localObject3, "superParameter");
        if (bool != a((x)localObject2, (bd)localObject3) instanceof j.d)
        {
          AppMethodBeat.o(57587);
          return true;
        }
      }
      AppMethodBeat.o(57587);
      return false;
    }
    
    private static boolean f(x paramx)
    {
      Object localObject2 = null;
      AppMethodBeat.i(57589);
      if (paramx.kod().size() != 1)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      Object localObject1 = paramx.knp();
      if ((localObject1 instanceof kotlin.l.b.a.b.b.e)) {}
      for (localObject1 = (kotlin.l.b.a.b.b.e)localObject1; localObject1 == null; localObject1 = null)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      paramx = paramx.kod();
      s.s(paramx, "f.valueParameters");
      kotlin.l.b.a.b.b.h localh = ((bd)kotlin.a.p.oO(paramx)).koG().kzm().knA();
      paramx = localObject2;
      if ((localh instanceof kotlin.l.b.a.b.b.e)) {
        paramx = (kotlin.l.b.a.b.b.e)localh;
      }
      if (paramx == null)
      {
        AppMethodBeat.o(57589);
        return false;
      }
      if ((kotlin.l.b.a.b.a.h.d((kotlin.l.b.a.b.b.e)localObject1)) && (s.p(kotlin.l.b.a.b.j.d.a.o((l)localObject1), kotlin.l.b.a.b.j.d.a.o((l)paramx))))
      {
        AppMethodBeat.o(57589);
        return true;
      }
      AppMethodBeat.o(57589);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.p
 * JD-Core Version:    0.7.0.1
 */