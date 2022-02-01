package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.b.c;

public final class ac
{
  public static final boolean a(kotlin.l.b.a.b.b.e parame, kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57640);
    s.u(parame, "<this>");
    s.u(parama, "specialCallableDescriptor");
    parama = ((kotlin.l.b.a.b.b.e)parama.knp()).koj();
    s.s(parama, "specialCallableDescripto…ssDescriptor).defaultType");
    for (parame = kotlin.l.b.a.b.j.d.A(parame); parame != null; parame = kotlin.l.b.a.b.j.d.A(parame)) {
      if (!(parame instanceof c))
      {
        int i;
        if (kotlin.l.b.a.b.m.a.u.f((kotlin.l.b.a.b.m.ad)parame.koj(), (kotlin.l.b.a.b.m.ad)parama) != null) {
          i = 1;
        }
        while (i != 0) {
          if (!kotlin.l.b.a.b.a.h.c((l)parame))
          {
            AppMethodBeat.o(57640);
            return true;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(57640);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(57640);
    return false;
  }
  
  public static final <T extends kotlin.l.b.a.b.b.b> T m(T paramT)
  {
    AppMethodBeat.i(57635);
    s.u(paramT, "<this>");
    Object localObject = ad.aiQo;
    if (!ad.ksb().contains(paramT.kok()))
    {
      localObject = f.aiOz;
      if (!f.krA().contains(kotlin.l.b.a.b.j.d.a.v(paramT).kok()))
      {
        AppMethodBeat.o(57635);
        return null;
      }
    }
    if ((paramT instanceof ap)) {}
    for (boolean bool = true; bool; bool = paramT instanceof ao)
    {
      paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)a.aiQl);
      AppMethodBeat.o(57635);
      return paramT;
    }
    if ((paramT instanceof au))
    {
      paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)b.aiQm);
      AppMethodBeat.o(57635);
      return paramT;
    }
    AppMethodBeat.o(57635);
    return null;
  }
  
  public static final boolean n(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57636);
    s.u(paramb, "<this>");
    if (m(paramb) != null)
    {
      AppMethodBeat.o(57636);
      return true;
    }
    AppMethodBeat.o(57636);
    return false;
  }
  
  public static final <T extends kotlin.l.b.a.b.b.b> T o(T paramT)
  {
    AppMethodBeat.i(57637);
    s.u(paramT, "<this>");
    Object localObject = m(paramT);
    if (localObject != null)
    {
      AppMethodBeat.o(57637);
      return localObject;
    }
    localObject = e.aiOw;
    localObject = paramT.kok();
    s.s(localObject, "name");
    if (!e.e((kotlin.l.b.a.b.f.f)localObject))
    {
      AppMethodBeat.o(57637);
      return null;
    }
    paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)c.aiQn);
    AppMethodBeat.o(57637);
    return paramT;
  }
  
  public static final String p(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57638);
    s.u(paramb, "callableMemberDescriptor");
    paramb = q(paramb);
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = kotlin.l.b.a.b.j.d.a.v(paramb))
    {
      AppMethodBeat.o(57638);
      return null;
    }
    Object localObject;
    if ((paramb instanceof ap))
    {
      localObject = h.aiOE;
      paramb = h.k(paramb);
      AppMethodBeat.o(57638);
      return paramb;
    }
    if ((paramb instanceof au))
    {
      localObject = d.aiOu;
      paramb = d.a((au)paramb);
      if (paramb != null)
      {
        paramb = paramb.PF();
        AppMethodBeat.o(57638);
        return paramb;
      }
    }
    AppMethodBeat.o(57638);
    return null;
  }
  
  private static final kotlin.l.b.a.b.b.b q(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57639);
    if (kotlin.l.b.a.b.a.h.c((l)paramb))
    {
      paramb = m(paramb);
      AppMethodBeat.o(57639);
      return paramb;
    }
    AppMethodBeat.o(57639);
    return null;
  }
  
  public static final boolean r(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57641);
    s.u(paramb, "<this>");
    s.u(paramb, "<this>");
    if (((kotlin.l.b.a.b.j.d.a.v(paramb).knp() instanceof c)) || (kotlin.l.b.a.b.a.h.c((l)paramb)))
    {
      AppMethodBeat.o(57641);
      return true;
    }
    AppMethodBeat.o(57641);
    return false;
  }
  
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final a aiQl;
    
    static
    {
      AppMethodBeat.i(57627);
      aiQl = new a();
      AppMethodBeat.o(57627);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final b aiQm;
    
    static
    {
      AppMethodBeat.i(57629);
      aiQm = new b();
      AppMethodBeat.o(57629);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final c aiQn;
    
    static
    {
      AppMethodBeat.i(57631);
      aiQn = new c();
      AppMethodBeat.o(57631);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.ac
 * JD-Core Version:    0.7.0.1
 */