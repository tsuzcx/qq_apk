package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public abstract class d
{
  public abstract String PF();
  
  public abstract String getDesc();
  
  public abstract String getName();
  
  public final String toString()
  {
    return PF();
  }
  
  public static final class a
    extends d
  {
    public final String desc;
    public final String name;
    
    public a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(59234);
      this.name = paramString1;
      this.desc = paramString2;
      AppMethodBeat.o(59234);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(59233);
      String str = this.name + ':' + this.desc;
      AppMethodBeat.o(59233);
      return str;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(59236);
      if (this == paramObject)
      {
        AppMethodBeat.o(59236);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(59236);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(59236);
        return false;
      }
      if (!s.p(this.desc, paramObject.desc))
      {
        AppMethodBeat.o(59236);
        return false;
      }
      AppMethodBeat.o(59236);
      return true;
    }
    
    public final String getDesc()
    {
      return this.desc;
    }
    
    public final String getName()
    {
      return this.name;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(59235);
      int i = this.name.hashCode();
      int j = this.desc.hashCode();
      AppMethodBeat.o(59235);
      return i * 31 + j;
    }
  }
  
  public static final class b
    extends d
  {
    public final String desc;
    public final String name;
    
    public b(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(59238);
      this.name = paramString1;
      this.desc = paramString2;
      AppMethodBeat.o(59238);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(59237);
      String str = s.X(this.name, this.desc);
      AppMethodBeat.o(59237);
      return str;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(59240);
      if (this == paramObject)
      {
        AppMethodBeat.o(59240);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(59240);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.name, paramObject.name))
      {
        AppMethodBeat.o(59240);
        return false;
      }
      if (!s.p(this.desc, paramObject.desc))
      {
        AppMethodBeat.o(59240);
        return false;
      }
      AppMethodBeat.o(59240);
      return true;
    }
    
    public final String getDesc()
    {
      return this.desc;
    }
    
    public final String getName()
    {
      return this.name;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(59239);
      int i = this.name.hashCode();
      int j = this.desc.hashCode();
      AppMethodBeat.o(59239);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.d
 * JD-Core Version:    0.7.0.1
 */