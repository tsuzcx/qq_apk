package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public abstract class e
{
  public abstract String getDesc();
  
  public abstract String getName();
  
  public abstract String rf();
  
  public final String toString()
  {
    return rf();
  }
  
  public static final class a
    extends e
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
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(59236);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!k.g(this.name, paramObject.name)) || (!k.g(this.desc, paramObject.desc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(59236);
        return true;
      }
      AppMethodBeat.o(59236);
      return false;
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
      int j = 0;
      AppMethodBeat.i(59235);
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.desc;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(59235);
        return i * 31 + j;
      }
    }
    
    public final String rf()
    {
      AppMethodBeat.i(59233);
      String str = this.name + ':' + this.desc;
      AppMethodBeat.o(59233);
      return str;
    }
  }
  
  public static final class b
    extends e
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
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(59240);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!k.g(this.name, paramObject.name)) || (!k.g(this.desc, paramObject.desc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(59240);
        return true;
      }
      AppMethodBeat.o(59240);
      return false;
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
      int j = 0;
      AppMethodBeat.i(59239);
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.desc;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(59239);
        return i * 31 + j;
      }
    }
    
    public final String rf()
    {
      AppMethodBeat.i(59237);
      String str = this.name + this.desc;
      AppMethodBeat.o(59237);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.e
 * JD-Core Version:    0.7.0.1
 */