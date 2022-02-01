package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.b.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class au
  extends ay
{
  public static final a NCz = new a((byte)0);
  
  public static final ay a(at paramat, List<? extends av> paramList)
  {
    return a.a(paramat, paramList);
  }
  
  public static final au cj(Map<at, ? extends av> paramMap)
  {
    return a.ck(paramMap);
  }
  
  public final av O(ab paramab)
  {
    p.h(paramab, "key");
    return d(paramab.gsZ());
  }
  
  public abstract av d(at paramat);
  
  public static final class a
  {
    public static ay a(at paramat, List<? extends av> paramList)
    {
      AppMethodBeat.i(60835);
      p.h(paramat, "typeConstructor");
      p.h(paramList, "arguments");
      Object localObject = paramat.getParameters();
      p.g(localObject, "typeConstructor.parameters");
      as localas = (as)j.jf((List)localObject);
      boolean bool;
      if (localas != null) {
        bool = localas.giy();
      }
      while (bool)
      {
        paramat = paramat.getParameters();
        p.g(paramat, "typeConstructor.parameters");
        localObject = (Iterable)paramat;
        paramat = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localas = (as)((Iterator)localObject).next();
            p.g(localas, "it");
            paramat.add(localas.ghu());
            continue;
            bool = false;
            break;
          }
        }
        paramat = (ay)ck(ae.A((Iterable)j.c((Iterable)paramat, (Iterable)paramList)));
        AppMethodBeat.o(60835);
        return paramat;
      }
      paramat = (ay)new z((List)localObject, paramList);
      AppMethodBeat.o(60835);
      return paramat;
    }
    
    public static ay ay(ab paramab)
    {
      AppMethodBeat.i(60834);
      p.h(paramab, "kotlinType");
      paramab = a(paramab.gsZ(), paramab.gsW());
      AppMethodBeat.o(60834);
      return paramab;
    }
    
    public static au ck(Map<at, ? extends av> paramMap)
    {
      AppMethodBeat.i(60833);
      p.h(paramMap, "map");
      paramMap = (au)new a(paramMap);
      AppMethodBeat.o(60833);
      return paramMap;
    }
    
    public static final class a
      extends au
    {
      a(Map paramMap) {}
      
      public final av d(at paramat)
      {
        AppMethodBeat.i(60831);
        p.h(paramat, "key");
        paramat = (av)this.NCA.get(paramat);
        AppMethodBeat.o(60831);
        return paramat;
      }
      
      public final boolean gtT()
      {
        return this.NCB;
      }
      
      public final boolean isEmpty()
      {
        AppMethodBeat.i(60832);
        boolean bool = this.NCA.isEmpty();
        AppMethodBeat.o(60832);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.au
 * JD-Core Version:    0.7.0.1
 */