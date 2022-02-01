package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

public abstract interface g
  extends Iterable<c>, a
{
  public static final a aiIh = a.aiIi;
  
  public abstract c h(kotlin.l.b.a.b.f.c paramc);
  
  public abstract boolean i(kotlin.l.b.a.b.f.c paramc);
  
  public abstract boolean isEmpty();
  
  public static final class a
  {
    private static final g aiIj;
    
    static
    {
      AppMethodBeat.i(56946);
      aiIi = new a();
      aiIj = (g)new a();
      AppMethodBeat.o(56946);
    }
    
    public static g kpB()
    {
      return aiIj;
    }
    
    public static g oS(List<? extends c> paramList)
    {
      AppMethodBeat.i(56945);
      s.u(paramList, "annotations");
      if (paramList.isEmpty())
      {
        paramList = aiIj;
        AppMethodBeat.o(56945);
        return paramList;
      }
      paramList = (g)new h(paramList);
      AppMethodBeat.o(56945);
      return paramList;
    }
    
    public static final class a
      implements g
    {
      public final boolean i(kotlin.l.b.a.b.f.c paramc)
      {
        AppMethodBeat.i(56944);
        boolean bool = g.b.b(this, paramc);
        AppMethodBeat.o(56944);
        return bool;
      }
      
      public final boolean isEmpty()
      {
        return true;
      }
      
      public final Iterator<c> iterator()
      {
        AppMethodBeat.i(56943);
        Iterator localIterator = ((List)ab.aivy).iterator();
        AppMethodBeat.o(56943);
        return localIterator;
      }
      
      public final String toString()
      {
        return "EMPTY";
      }
    }
  }
  
  public static final class b
  {
    public static c a(g paramg, kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56947);
      s.u(paramg, "this");
      s.u(paramc, "fqName");
      Iterator localIterator = ((Iterable)paramg).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramg = localIterator.next();
      } while (!s.p(((c)paramg).koY(), paramc));
      for (;;)
      {
        paramg = (c)paramg;
        AppMethodBeat.o(56947);
        return paramg;
        paramg = null;
      }
    }
    
    public static boolean b(g paramg, kotlin.l.b.a.b.f.c paramc)
    {
      AppMethodBeat.i(56948);
      s.u(paramg, "this");
      s.u(paramc, "fqName");
      if (paramg.h(paramc) != null)
      {
        AppMethodBeat.o(56948);
        return true;
      }
      AppMethodBeat.o(56948);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.g
 * JD-Core Version:    0.7.0.1
 */