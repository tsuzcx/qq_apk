package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.ab;

public abstract class r$b
{
  public static final class a
    extends r.b
  {
    public final ab Tbs;
    
    public a(ab paramab)
    {
      super();
      AppMethodBeat.i(60093);
      this.Tbs = paramab;
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
          if (!p.j(this.Tbs, paramObject.Tbs)) {}
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
      ab localab = this.Tbs;
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
      String str = "LocalClass(type=" + this.Tbs + ")";
      AppMethodBeat.o(60094);
      return str;
    }
  }
  
  public static final class b
    extends r.b
  {
    public final f TIK;
    
    public b(f paramf)
    {
      super();
      AppMethodBeat.i(60097);
      this.TIK = paramf;
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
          if (!p.j(this.TIK, paramObject.TIK)) {}
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
      f localf = this.TIK;
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
      String str = "NormalClass(value=" + this.TIK + ")";
      AppMethodBeat.o(60098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.r.b
 * JD-Core Version:    0.7.0.1
 */