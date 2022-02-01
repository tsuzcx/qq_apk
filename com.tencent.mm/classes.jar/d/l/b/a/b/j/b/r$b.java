package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.m.ab;

public abstract class r$b
{
  public static final class a
    extends r.b
  {
    public final ab Jko;
    
    public a(ab paramab)
    {
      super();
      AppMethodBeat.i(60093);
      this.Jko = paramab;
      AppMethodBeat.o(60093);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60096);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (!k.g(this.Jko, paramObject.Jko)) {}
        }
      }
      else
      {
        AppMethodBeat.o(60096);
        return true;
      }
      AppMethodBeat.o(60096);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60095);
      ab localab = this.Jko;
      if (localab != null)
      {
        int i = localab.hashCode();
        AppMethodBeat.o(60095);
        return i;
      }
      AppMethodBeat.o(60095);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60094);
      String str = "LocalClass(type=" + this.Jko + ")";
      AppMethodBeat.o(60094);
      return str;
    }
  }
  
  public static final class b
    extends r.b
  {
    public final f JSr;
    
    public b(f paramf)
    {
      super();
      AppMethodBeat.i(60097);
      this.JSr = paramf;
      AppMethodBeat.o(60097);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60100);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!k.g(this.JSr, paramObject.JSr)) {}
        }
      }
      else
      {
        AppMethodBeat.o(60100);
        return true;
      }
      AppMethodBeat.o(60100);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60099);
      f localf = this.JSr;
      if (localf != null)
      {
        int i = localf.hashCode();
        AppMethodBeat.o(60099);
        return i;
      }
      AppMethodBeat.o(60099);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60098);
      String str = "NormalClass(value=" + this.JSr + ")";
      AppMethodBeat.o(60098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.j.b.r.b
 * JD-Core Version:    0.7.0.1
 */