package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int iPd();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int ablQ;
    public static final a ablR;
    
    static
    {
      AppMethodBeat.i(60194);
      ablR = new a();
      d.a locala = d.abms;
      int i = d.iPl();
      locala = d.abms;
      int j = d.iPj();
      locala = d.abms;
      ablQ = i & ((j | d.iPk()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int iPd()
    {
      return ablQ;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b ablS;
    
    static
    {
      AppMethodBeat.i(60195);
      ablS = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int iPd()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */