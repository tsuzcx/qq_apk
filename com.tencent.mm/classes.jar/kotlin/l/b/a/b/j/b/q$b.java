package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.ad;

public abstract class q$b
{
  public static final class a
    extends q.b
  {
    public final ad aiAd;
    
    public a(ad paramad)
    {
      super();
      AppMethodBeat.i(60093);
      this.aiAd = paramad;
      AppMethodBeat.o(60093);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60096);
      if (this == paramObject)
      {
        AppMethodBeat.o(60096);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(60096);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.aiAd, paramObject.aiAd))
      {
        AppMethodBeat.o(60096);
        return false;
      }
      AppMethodBeat.o(60096);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60095);
      int i = this.aiAd.hashCode();
      AppMethodBeat.o(60095);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60094);
      String str = "LocalClass(type=" + this.aiAd + ')';
      AppMethodBeat.o(60094);
      return str;
    }
  }
  
  public static final class b
    extends q.b
  {
    public final f ajjT;
    
    public b(f paramf)
    {
      super();
      AppMethodBeat.i(60097);
      this.ajjT = paramf;
      AppMethodBeat.o(60097);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60100);
      if (this == paramObject)
      {
        AppMethodBeat.o(60100);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(60100);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.ajjT, paramObject.ajjT))
      {
        AppMethodBeat.o(60100);
        return false;
      }
      AppMethodBeat.o(60100);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60099);
      int i = this.ajjT.hashCode();
      AppMethodBeat.o(60099);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60098);
      String str = "NormalClass(value=" + this.ajjT + ')';
      AppMethodBeat.o(60098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.q.b
 * JD-Core Version:    0.7.0.1
 */