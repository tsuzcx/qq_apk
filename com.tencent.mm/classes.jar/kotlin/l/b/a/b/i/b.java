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
    public static final a TEY;
    
    static
    {
      AppMethodBeat.i(59650);
      TEY = new a();
      AppMethodBeat.o(59650);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59649);
      p.h(paramh, "classifier");
      p.h(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).hAH();
        p.g(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59649);
        return paramh;
      }
      paramh = kotlin.l.b.a.b.j.c.n((l)paramh);
      p.g(paramh, "DescriptorUtils.getFqName(classifier)");
      paramh = paramc.f(paramh);
      AppMethodBeat.o(59649);
      return paramh;
    }
  }
  
  public static final class b
    implements b
  {
    public static final b TEZ;
    
    static
    {
      AppMethodBeat.i(59652);
      TEZ = new b();
      AppMethodBeat.o(59652);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(59651);
      p.h(paramh, "classifier");
      p.h(paramc, "renderer");
      if ((paramh instanceof as))
      {
        paramh = ((as)paramh).hAH();
        p.g(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(59651);
        return paramh;
      }
      ArrayList localArrayList = new ArrayList();
      paramh = (l)paramh;
      do
      {
        localArrayList.add(paramh.hAH());
        paramc = paramh.hzx();
        paramh = paramc;
      } while ((paramc instanceof e));
      paramh = (List)localArrayList;
      p.h(paramh, "$this$asReversed");
      paramh = q.kH((List)new aj(paramh));
      AppMethodBeat.o(59651);
      return paramh;
    }
  }
  
  public static final class c
    implements b
  {
    public static final c TFa;
    
    static
    {
      AppMethodBeat.i(59656);
      TFa = new c();
      AppMethodBeat.o(59656);
    }
    
    private final String a(h paramh)
    {
      AppMethodBeat.i(59654);
      Object localObject = paramh.hAH();
      p.g(localObject, "descriptor.name");
      localObject = q.x((f)localObject);
      if ((paramh instanceof as))
      {
        AppMethodBeat.o(59654);
        return localObject;
      }
      paramh = paramh.hzx();
      p.g(paramh, "descriptor.containingDeclaration");
      paramh = j(paramh);
      if ((paramh != null) && ((p.j(paramh, "") ^ true)))
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
        paraml = ((ab)paraml).hBk().hJe();
        p.g(paraml, "descriptor.fqName.toUnsafe()");
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
      p.h(paramh, "classifier");
      p.h(paramc, "renderer");
      paramh = a(paramh);
      AppMethodBeat.o(59653);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.i.b
 * JD-Core Version:    0.7.0.1
 */