package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.a.a;
import d.g.b.p;
import d.l.b.a.b.f.b;
import java.util.Iterator;
import java.util.List;

public abstract interface g
  extends a, Iterable<c>
{
  public static final a MVP = a.MVR;
  
  public abstract c g(b paramb);
  
  public abstract boolean h(b paramb);
  
  public abstract boolean isEmpty();
  
  public static final class a
  {
    private static final g MVQ;
    
    static
    {
      AppMethodBeat.i(56946);
      MVR = new a();
      MVQ = (g)new a();
      AppMethodBeat.o(56946);
    }
    
    public static g gjL()
    {
      return MVQ;
    }
    
    public static g jl(List<? extends c> paramList)
    {
      AppMethodBeat.i(56945);
      p.h(paramList, "annotations");
      if (paramList.isEmpty())
      {
        paramList = MVQ;
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
      public final boolean h(b paramb)
      {
        AppMethodBeat.i(56944);
        p.h(paramb, "fqName");
        boolean bool = g.b.b(this, paramb);
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
        Iterator localIterator = ((List)v.MKE).iterator();
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
    public static c a(g paramg, b paramb)
    {
      AppMethodBeat.i(56947);
      p.h(paramb, "fqName");
      Iterator localIterator = ((Iterable)paramg).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramg = localIterator.next();
      } while (!p.i(((c)paramg).gjg(), paramb));
      for (;;)
      {
        paramg = (c)paramg;
        AppMethodBeat.o(56947);
        return paramg;
        paramg = null;
      }
    }
    
    public static boolean b(g paramg, b paramb)
    {
      AppMethodBeat.i(56948);
      p.h(paramb, "fqName");
      if (paramg.g(paramb) != null)
      {
        AppMethodBeat.o(56948);
        return true;
      }
      AppMethodBeat.o(56948);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.g
 * JD-Core Version:    0.7.0.1
 */