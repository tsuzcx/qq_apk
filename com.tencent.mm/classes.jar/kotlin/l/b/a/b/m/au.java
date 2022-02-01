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
  public static final a abqZ = new a((byte)0);
  
  public static final ay a(at paramat, List<? extends av> paramList)
  {
    return a.a(paramat, paramList);
  }
  
  public static final au cI(Map<at, ? extends av> paramMap)
  {
    return a.cJ(paramMap);
  }
  
  public final av N(ab paramab)
  {
    p.k(paramab, "key");
    return d(paramab.iOU());
  }
  
  public abstract av d(at paramat);
  
  public static final class a
  {
    public static ay a(at paramat, List<? extends av> paramList)
    {
      AppMethodBeat.i(60835);
      p.k(paramat, "typeConstructor");
      p.k(paramList, "arguments");
      Object localObject = paramat.iCb();
      p.j(localObject, "typeConstructor.parameters");
      as localas = (as)j.lr((List)localObject);
      boolean bool;
      if (localas != null) {
        bool = localas.iEP();
      }
      while (bool)
      {
        paramat = paramat.iCb();
        p.j(paramat, "typeConstructor.parameters");
        localObject = (Iterable)paramat;
        paramat = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            localas = (as)((Iterator)localObject).next();
            p.j(localas, "it");
            paramat.add(localas.iDL());
            continue;
            bool = false;
            break;
          }
        }
        paramat = (ay)cJ(ae.E((Iterable)j.c((Iterable)paramat, (Iterable)paramList)));
        AppMethodBeat.o(60835);
        return paramat;
      }
      paramat = (ay)new z((List)localObject, paramList);
      AppMethodBeat.o(60835);
      return paramat;
    }
    
    public static au cJ(Map<at, ? extends av> paramMap)
    {
      AppMethodBeat.i(60833);
      p.k(paramMap, "map");
      paramMap = (au)new a(paramMap, false);
      AppMethodBeat.o(60833);
      return paramMap;
    }
    
    public final ay ax(ab paramab)
    {
      AppMethodBeat.i(60834);
      p.k(paramab, "kotlinType");
      paramab = a(paramab.iOU(), paramab.iOR());
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
        p.k(paramat, "key");
        paramat = (av)this.abra.get(paramat);
        AppMethodBeat.o(60831);
        return paramat;
      }
      
      public final boolean iPR()
      {
        return this.abrb;
      }
      
      public final boolean isEmpty()
      {
        AppMethodBeat.i(60832);
        boolean bool = this.abra.isEmpty();
        AppMethodBeat.o(60832);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.au
 * JD-Core Version:    0.7.0.1
 */