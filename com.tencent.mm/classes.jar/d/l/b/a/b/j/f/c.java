package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int gxK();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int NUr;
    public static final a NUs;
    
    static
    {
      AppMethodBeat.i(60194);
      NUs = new a();
      d.a locala = d.NUU;
      int i = d.gxS();
      locala = d.NUU;
      int j = d.gxQ();
      locala = d.NUU;
      NUr = i & ((j | d.gxR()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int gxK()
    {
      return NUr;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b NUt;
    
    static
    {
      AppMethodBeat.i(60195);
      NUt = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int gxK()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */