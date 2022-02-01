package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int gbJ();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int LGn;
    public static final a LGo;
    
    static
    {
      AppMethodBeat.i(60194);
      LGo = new a();
      d.a locala = d.LGP;
      int i = d.gbR();
      locala = d.LGP;
      int j = d.gbP();
      locala = d.LGP;
      LGn = i & ((j | d.gbQ()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int gbJ()
    {
      return LGn;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b LGp;
    
    static
    {
      AppMethodBeat.i(60195);
      LGp = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int gbJ()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */