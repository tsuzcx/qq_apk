package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;

public abstract class ay
  extends bc
{
  public static final a ajqs = new a((byte)0);
  
  public static final bc a(ax paramax, List<? extends az> paramList)
  {
    return a.a(paramax, paramList);
  }
  
  public static final ay dE(Map<ax, ? extends az> paramMap)
  {
    s.u(paramMap, "map");
    return a.dF(paramMap);
  }
  
  public final az G(ad paramad)
  {
    s.u(paramad, "key");
    return c(paramad.kzm());
  }
  
  public abstract az c(ax paramax);
  
  public static final class a
  {
    public static bc a(ax paramax, List<? extends az> paramList)
    {
      AppMethodBeat.i(60835);
      s.u(paramax, "typeConstructor");
      s.u(paramList, "arguments");
      Object localObject = paramax.klq();
      s.s(localObject, "typeConstructor.parameters");
      ba localba = (ba)p.oN((List)localObject);
      int i;
      if ((localba != null) && (localba.koo() == true)) {
        i = 1;
      }
      while (i != 0)
      {
        paramax = paramax.klq();
        s.s(paramax, "typeConstructor.parameters");
        localObject = (Iterable)paramax;
        paramax = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramax.add(((ba)((Iterator)localObject).next()).kmZ());
            continue;
            i = 0;
            break;
          }
        }
        paramax = (bc)dF(ak.F((Iterable)p.d((Iterable)paramax, (Iterable)paramList)));
        AppMethodBeat.o(60835);
        return paramax;
      }
      paramax = (bc)new ab((List)localObject, paramList);
      AppMethodBeat.o(60835);
      return paramax;
    }
    
    public static ay dF(Map<ax, ? extends az> paramMap)
    {
      AppMethodBeat.i(60833);
      s.u(paramMap, "map");
      paramMap = (ay)new a(paramMap, false);
      AppMethodBeat.o(60833);
      return paramMap;
    }
    
    public final bc ao(ad paramad)
    {
      AppMethodBeat.i(60834);
      s.u(paramad, "kotlinType");
      paramad = a(paramad.kzm(), paramad.klR());
      AppMethodBeat.o(60834);
      return paramad;
    }
    
    public static final class a
      extends ay
    {
      a(Map<ax, ? extends az> paramMap, boolean paramBoolean) {}
      
      public final az c(ax paramax)
      {
        AppMethodBeat.i(60831);
        s.u(paramax, "key");
        paramax = (az)this.ajqt.get(paramax);
        AppMethodBeat.o(60831);
        return paramax;
      }
      
      public final boolean isEmpty()
      {
        AppMethodBeat.i(60832);
        boolean bool = this.ajqt.isEmpty();
        AppMethodBeat.o(60832);
        return bool;
      }
      
      public final boolean kAD()
      {
        return this.ajqu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ay
 * JD-Core Version:    0.7.0.1
 */