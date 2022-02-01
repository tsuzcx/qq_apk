package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.d.a;

public final class h
{
  public static final h aiOE;
  
  static
  {
    AppMethodBeat.i(192051);
    aiOE = new h();
    AppMethodBeat.o(192051);
  }
  
  public static String k(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(192040);
    s.u(paramb, "<this>");
    boolean bool = kotlin.l.b.a.b.a.h.c((l)paramb);
    if ((ak.aiuY) && (!bool))
    {
      paramb = (Throwable)new AssertionError("This method is defined only for builtin members, but " + paramb + " found");
      AppMethodBeat.o(192040);
      throw paramb;
    }
    paramb = a.b(a.v(paramb), (kotlin.g.a.b)a.aiOF);
    if (paramb == null)
    {
      AppMethodBeat.o(192040);
      return null;
    }
    f localf = f.aiOz;
    paramb = (kotlin.l.b.a.b.f.f)f.kry().get(a.o((l)paramb));
    if (paramb == null)
    {
      AppMethodBeat.o(192040);
      return null;
    }
    paramb = paramb.PF();
    AppMethodBeat.o(192040);
    return paramb;
  }
  
  public static boolean l(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(192044);
    s.u(paramb, "callableMemberDescriptor");
    Object localObject = f.aiOz;
    if (!f.krA().contains(paramb.kok()))
    {
      AppMethodBeat.o(192044);
      return false;
    }
    localObject = f.aiOz;
    if ((p.a((Iterable)f.krz(), a.I((l)paramb))) && (paramb.kod().isEmpty()))
    {
      AppMethodBeat.o(192044);
      return true;
    }
    if (kotlin.l.b.a.b.a.h.c((l)paramb))
    {
      paramb = paramb.kof();
      s.s(paramb, "overriddenDescriptors");
      paramb = (Iterable)paramb;
      if (!((Collection)paramb).isEmpty())
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          localObject = (kotlin.l.b.a.b.b.b)paramb.next();
          s.s(localObject, "it");
          if (l((kotlin.l.b.a.b.b.b)localObject))
          {
            AppMethodBeat.o(192044);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(192044);
    return false;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final a aiOF;
    
    static
    {
      AppMethodBeat.i(191986);
      aiOF = new a();
      AppMethodBeat.o(191986);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.h
 * JD-Core Version:    0.7.0.1
 */