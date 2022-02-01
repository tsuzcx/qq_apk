package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int hKN();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int TJo;
    public static final a TJp;
    
    static
    {
      AppMethodBeat.i(60194);
      TJp = new a();
      d.a locala = d.TJQ;
      int i = d.hKV();
      locala = d.TJQ;
      int j = d.hKT();
      locala = d.TJQ;
      TJo = i & ((j | d.hKU()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int hKN()
    {
      return TJo;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b TJq;
    
    static
    {
      AppMethodBeat.i(60195);
      TJq = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int hKN()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */