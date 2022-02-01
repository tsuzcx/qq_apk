package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.aj;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract interface b
{
  public abstract String a(h paramh, c paramc);
  
  public static final class a
    implements b
  {
    public static final a abhC;
    
    static
    {
      AppMethodBeat.i(59650);
      abhC = new a();
      AppMethodBeat.o(59650);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59649);
      p.k(paramh, "classifier");
      p.k(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).iEU();
        p.j(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59649);
        return paramh;
      }
      paramh = kotlin.l.b.a.b.j.c.n((l)paramh);
      p.j(paramh, "DescriptorUtils.getFqName(classifier)");
      paramh = paramc.f(paramh);
      AppMethodBeat.o(59649);
      return paramh;
    }
  }
  
  public static final class b
    implements b
  {
    public static final b abhD;
    
    static
    {
      AppMethodBeat.i(59652);
      abhD = new b();
      AppMethodBeat.o(59652);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59651);
      p.k(paramh, "classifier");
      p.k(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).iEU();
        p.j(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59651);
        return paramh;
      }
      ArrayList localArrayList = new ArrayList();
      paramh = (l)paramh;
      do
      {
        localArrayList.add(paramh.iEU());
        paramc = paramh.iDJ();
        paramh = paramc;
      } while ((paramc instanceof e));
      paramh = (List)localArrayList;
      p.k(paramh, "$this$asReversed");
      paramh = q.lE((List)new aj(paramh));
      AppMethodBeat.o(59651);
      return paramh;
    }
  }
  
  public static final class c
    implements b
  {
    public static final c abhE;
    
    static
    {
      AppMethodBeat.i(59656);
      abhE = new c();
      AppMethodBeat.o(59656);
    }
    
    private final String a(h paramh)
    {
      AppMethodBeat.i(59654);
      Object localObject = paramh.iEU();
      p.j(localObject, "descriptor.name");
      localObject = q.x((f)localObject);
      if ((paramh instanceof as))
      {
        AppMethodBeat.o(59654);
        return localObject;
      }
      paramh = paramh.iDJ();
      p.j(paramh, "descriptor.containingDeclaration");
      paramh = j(paramh);
      if ((paramh != null) && ((p.h(paramh, "") ^ true)))
      {
        paramh = paramh + "." + (String)localObject;
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
        paraml = a((h)paraml);
        AppMethodBeat.o(59655);
        return paraml;
      }
      if ((paraml instanceof ab))
      {
        paraml = ((ab)paraml).iFy().iNy();
        p.j(paraml, "descriptor.fqName.toUnsafe()");
        paraml = q.g(paraml);
        AppMethodBeat.o(59655);
        return paraml;
      }
      AppMethodBeat.o(59655);
      return null;
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59653);
      p.k(paramh, "classifier");
      p.k(paramc, "renderer");
      paramh = a(paramh);
      AppMethodBeat.o(59653);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.b
 * JD-Core Version:    0.7.0.1
 */