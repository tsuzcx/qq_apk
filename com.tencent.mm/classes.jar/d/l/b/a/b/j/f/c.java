package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int gti();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int Nxl;
    public static final a Nxm;
    
    static
    {
      AppMethodBeat.i(60194);
      Nxm = new a();
      d.a locala = d.NxN;
      int i = d.gtq();
      locala = d.NxN;
      int j = d.gto();
      locala = d.NxN;
      Nxl = i & ((j | d.gtp()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int gti()
    {
      return Nxl;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b Nxn;
    
    static
    {
      AppMethodBeat.i(60195);
      Nxn = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int gti()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */