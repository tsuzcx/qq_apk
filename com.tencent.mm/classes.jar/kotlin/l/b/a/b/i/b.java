package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.ap;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d;

public abstract interface b
{
  public abstract String a(h paramh, c paramc);
  
  public static final class a
    implements b
  {
    public static final a ajgp;
    
    static
    {
      AppMethodBeat.i(59650);
      ajgp = new a();
      AppMethodBeat.o(59650);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59649);
      s.u(paramh, "classifier");
      s.u(paramc, "renderer");
      if ((paramh instanceof ba))
      {
        paramh = ((ba)paramh).kok();
        s.s(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59649);
        return paramh;
      }
      paramh = d.n((l)paramh);
      s.s(paramh, "getFqName(classifier)");
      paramh = paramc.j(paramh);
      AppMethodBeat.o(59649);
      return paramh;
    }
  }
  
  public static final class b
    implements b
  {
    public static final b ajgq;
    
    static
    {
      AppMethodBeat.i(59652);
      ajgq = new b();
      AppMethodBeat.o(59652);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59651);
      s.u(paramh, "classifier");
      s.u(paramc, "renderer");
      if ((paramh instanceof ba))
      {
        paramh = ((ba)paramh).kok();
        s.s(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59651);
        return paramh;
      }
      ArrayList localArrayList = new ArrayList();
      paramh = (l)paramh;
      do
      {
        localArrayList.add(paramh.kok());
        paramc = paramh.knp();
        paramh = paramc;
      } while ((paramc instanceof e));
      paramh = (List)localArrayList;
      s.u(paramh, "$this$asReversed");
      paramh = n.pc((List)new ap(paramh));
      AppMethodBeat.o(59651);
      return paramh;
    }
  }
  
  public static final class c
    implements b
  {
    public static final c ajgr;
    
    static
    {
      AppMethodBeat.i(59656);
      ajgr = new c();
      AppMethodBeat.o(59656);
    }
    
    private final String b(h paramh)
    {
      AppMethodBeat.i(59654);
      Object localObject = paramh.kok();
      s.s(localObject, "descriptor.name");
      localObject = n.y((f)localObject);
      if ((paramh instanceof ba))
      {
        AppMethodBeat.o(59654);
        return localObject;
      }
      paramh = paramh.knp();
      s.s(paramh, "descriptor.containingDeclaration");
      paramh = j(paramh);
      if ((paramh != null) && (!s.p(paramh, "")))
      {
        paramh = paramh + '.' + (String)localObject;
        AppMethodBeat.o(59654);
        return paramh;
      }
      AppMethodBeat.o(59654);
      return localObject;
    }
    
    private final String j(l paraml)
    {
      AppMethodBeat.i(59655);
      if ((paraml instanceof e))
      {
        paraml = b((h)paraml);
        AppMethodBeat.o(59655);
        return paraml;
      }
      if ((paraml instanceof ah))
      {
        paraml = ((ah)paraml).koY().kxR();
        s.s(paraml, "descriptor.fqName.toUnsafe()");
        paraml = n.k(paraml);
        AppMethodBeat.o(59655);
        return paraml;
      }
      AppMethodBeat.o(59655);
      return null;
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59653);
      s.u(paramh, "classifier");
      s.u(paramc, "renderer");
      paramh = b(paramh);
      AppMethodBeat.o(59653);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.i.b
 * JD-Core Version:    0.7.0.1
 */