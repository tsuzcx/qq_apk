package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.f.a;
import d.l.b.a.b.k.a.u;

public abstract interface n
  extends u
{
  public abstract a a(g paramg);
  
  public abstract a c(a parama);
  
  public static abstract class a
  {
    public final p fUL()
    {
      Object localObject2 = null;
      if (!(this instanceof b)) {}
      for (Object localObject1 = null;; localObject1 = this)
      {
        b localb = (b)localObject1;
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.Lsf;
        }
        return localObject1;
      }
    }
    
    public static final class b
      extends n.a
    {
      final p Lsf;
      
      public b(p paramp)
      {
        super();
        AppMethodBeat.i(58220);
        this.Lsf = paramp;
        AppMethodBeat.o(58220);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(58223);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (!k.g(this.Lsf, paramObject.Lsf)) {}
          }
        }
        else
        {
          AppMethodBeat.o(58223);
          return true;
        }
        AppMethodBeat.o(58223);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(58222);
        p localp = this.Lsf;
        if (localp != null)
        {
          int i = localp.hashCode();
          AppMethodBeat.o(58222);
          return i;
        }
        AppMethodBeat.o(58222);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(58221);
        String str = "KotlinClass(kotlinJvmBinaryClass=" + this.Lsf + ")";
        AppMethodBeat.o(58221);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.n
 * JD-Core Version:    0.7.0.1
 */