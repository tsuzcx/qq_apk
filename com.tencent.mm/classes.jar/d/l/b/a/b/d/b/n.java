package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.f.a;
import d.l.b.a.b.k.a.u;
import java.util.Arrays;

public abstract interface n
  extends u
{
  public abstract a a(g paramg);
  
  public abstract a c(a parama);
  
  public static abstract class a
  {
    public final p gqM()
    {
      Object localObject2 = null;
      if (!(this instanceof b)) {}
      for (Object localObject1 = null;; localObject1 = this)
      {
        b localb = (b)localObject1;
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.NGi;
        }
        return localObject1;
      }
    }
    
    public static final class a
      extends n.a
    {
      public final byte[] content;
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(58219);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!d.g.b.p.i(this.content, paramObject.content)) {}
          }
        }
        else
        {
          AppMethodBeat.o(58219);
          return true;
        }
        AppMethodBeat.o(58219);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(58218);
        byte[] arrayOfByte = this.content;
        if (arrayOfByte != null)
        {
          int i = Arrays.hashCode(arrayOfByte);
          AppMethodBeat.o(58218);
          return i;
        }
        AppMethodBeat.o(58218);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(58217);
        String str = "ClassFileContent(content=" + Arrays.toString(this.content) + ")";
        AppMethodBeat.o(58217);
        return str;
      }
    }
    
    public static final class b
      extends n.a
    {
      final p NGi;
      
      public b(p paramp)
      {
        super();
        AppMethodBeat.i(58220);
        this.NGi = paramp;
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
            if (!d.g.b.p.i(this.NGi, paramObject.NGi)) {}
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
        p localp = this.NGi;
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
        String str = "KotlinClass(kotlinJvmBinaryClass=" + this.NGi + ")";
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