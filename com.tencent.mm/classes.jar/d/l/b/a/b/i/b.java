package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.aj;
import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import java.util.ArrayList;
import java.util.List;

public abstract interface b
{
  public abstract String a(h paramh, c paramc);
  
  public static final class a
    implements b
  {
    public static final a JOE;
    
    static
    {
      AppMethodBeat.i(59650);
      JOE = new a();
      AppMethodBeat.o(59650);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59649);
      k.h(paramh, "classifier");
      k.h(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).fyB();
        k.g(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59649);
        return paramh;
      }
      paramh = d.l.b.a.b.j.c.n((l)paramh);
      k.g(paramh, "DescriptorUtils.getFqName(classifier)");
      paramh = paramc.f(paramh);
      AppMethodBeat.o(59649);
      return paramh;
    }
  }
  
  public static final class b
    implements b
  {
    public static final b JOF;
    
    static
    {
      AppMethodBeat.i(59652);
      JOF = new b();
      AppMethodBeat.o(59652);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59651);
      k.h(paramh, "classifier");
      k.h(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).fyB();
        k.g(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59651);
        return paramh;
      }
      ArrayList localArrayList = new ArrayList();
      paramh = (l)paramh;
      do
      {
        localArrayList.add(paramh.fyB());
        paramc = paramh.fxq();
        paramh = paramc;
      } while ((paramc instanceof e));
      paramh = (List)localArrayList;
      k.h(paramh, "$this$asReversed");
      paramh = q.iO((List)new aj(paramh));
      AppMethodBeat.o(59651);
      return paramh;
    }
  }
  
  public static final class c
    implements b
  {
    public static final c JOG;
    
    static
    {
      AppMethodBeat.i(59656);
      JOG = new c();
      AppMethodBeat.o(59656);
    }
    
    private final String a(h paramh)
    {
      AppMethodBeat.i(59654);
      Object localObject = paramh.fyB();
      k.g(localObject, "descriptor.name");
      localObject = q.x((f)localObject);
      if ((paramh instanceof as))
      {
        AppMethodBeat.o(59654);
        return localObject;
      }
      paramh = paramh.fxq();
      k.g(paramh, "descriptor.containingDeclaration");
      paramh = j(paramh);
      if ((paramh != null) && ((k.g(paramh, "") ^ true)))
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
        paraml = ((ab)paraml).fzd().fHc();
        k.g(paraml, "descriptor.fqName.toUnsafe()");
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
      k.h(paramh, "classifier");
      k.h(paramc, "renderer");
      paramh = a(paramh);
      AppMethodBeat.o(59653);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.b
 * JD-Core Version:    0.7.0.1
 */