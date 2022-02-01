package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class au
  extends ay
{
  public static final a JYl = new a((byte)0);
  
  public static final ay a(at paramat, List<? extends av> paramList)
  {
    return a.a(paramat, paramList);
  }
  
  public static final au bX(Map<at, ? extends av> paramMap)
  {
    return a.bY(paramMap);
  }
  
  public final av O(ab paramab)
  {
    k.h(paramab, "key");
    return d(paramab.fIW());
  }
  
  public abstract av d(at paramat);
  
  public static final class a
  {
    public static ay a(at paramat, List<? extends av> paramList)
    {
      AppMethodBeat.i(60835);
      k.h(paramat, "typeConstructor");
      k.h(paramList, "arguments");
      Object localObject = paramat.getParameters();
      k.g(localObject, "typeConstructor.parameters");
      as localas = (as)j.iB((List)localObject);
      boolean bool;
      if (localas != null) {
        bool = localas.fyw();
      }
      while (bool)
      {
        paramat = paramat.getParameters();
        k.g(paramat, "typeConstructor.parameters");
        localObject = (Iterable)paramat;
        paramat = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localas = (as)((Iterator)localObject).next();
            k.g(localas, "it");
            paramat.add(localas.fxs());
            continue;
            bool = false;
            break;
          }
        }
        paramat = (ay)bY(ae.z((Iterable)j.b((Iterable)paramat, (Iterable)paramList)));
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
      k.h(paramab, "kotlinType");
      paramab = a(paramab.fIW(), paramab.fIT());
      AppMethodBeat.o(60834);
      return paramab;
    }
    
    public static au bY(Map<at, ? extends av> paramMap)
    {
      AppMethodBeat.i(60833);
      k.h(paramMap, "map");
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
        k.h(paramat, "key");
        paramat = (av)this.JYm.get(paramat);
        AppMethodBeat.o(60831);
        return paramat;
      }
      
      public final boolean fJQ()
      {
        return this.JYn;
      }
      
      public final boolean isEmpty()
      {
        AppMethodBeat.i(60832);
        boolean bool = this.JYm.isEmpty();
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