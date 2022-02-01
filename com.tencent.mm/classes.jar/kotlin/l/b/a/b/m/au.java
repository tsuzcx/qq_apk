package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;

public abstract class au
  extends ay
{
  public static final a TOz = new a((byte)0);
  
  public static final ay a(at paramat, List<? extends av> paramList)
  {
    return a.a(paramat, paramList);
  }
  
  public static final au cB(Map<at, ? extends av> paramMap)
  {
    return a.cC(paramMap);
  }
  
  public final av N(ab paramab)
  {
    p.h(paramab, "key");
    return d(paramab.hKE());
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
      as localas = (as)j.kv((List)localObject);
      boolean bool;
      if (localas != null) {
        bool = localas.hAC();
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
            paramat.add(localas.hzz());
            continue;
            bool = false;
            break;
          }
        }
        paramat = (ay)cC(ae.E((Iterable)j.c((Iterable)paramat, (Iterable)paramList)));
        AppMethodBeat.o(60835);
        return paramat;
      }
      paramat = (ay)new z((List)localObject, paramList);
      AppMethodBeat.o(60835);
      return paramat;
    }
    
    public static au cC(Map<at, ? extends av> paramMap)
    {
      AppMethodBeat.i(60833);
      p.h(paramMap, "map");
      paramMap = (au)new a(paramMap, false);
      AppMethodBeat.o(60833);
      return paramMap;
    }
    
    public final ay ax(ab paramab)
    {
      AppMethodBeat.i(60834);
      p.h(paramab, "kotlinType");
      paramab = a(paramab.hKE(), paramab.hKB());
      AppMethodBeat.o(60834);
      return paramab;
    }
    
    public static final class a
      extends au
    {
      a(Map paramMap, boolean paramBoolean) {}
      
      public final av d(at paramat)
      {
        AppMethodBeat.i(60831);
        p.h(paramat, "key");
        paramat = (av)this.TOA.get(paramat);
        AppMethodBeat.o(60831);
        return paramat;
      }
      
      public final boolean hLy()
      {
        return this.TOB;
      }
      
      public final boolean isEmpty()
      {
        AppMethodBeat.i(60832);
        boolean bool = this.TOA.isEmpty();
        AppMethodBeat.o(60832);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.au
 * JD-Core Version:    0.7.0.1
 */