package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class c
{
  public abstract int fJg();
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public static final class a
    extends c
  {
    private static final int JSU;
    public static final a JSV;
    
    static
    {
      AppMethodBeat.i(60194);
      JSV = new a();
      d.a locala = d.JTw;
      int i = d.fJo();
      locala = d.JTw;
      int j = d.fJm();
      locala = d.JTw;
      JSU = i & ((j | d.fJn()) ^ 0xFFFFFFFF);
      AppMethodBeat.o(60194);
    }
    
    public final int fJg()
    {
      return JSU;
    }
  }
  
  public static final class b
    extends c
  {
    public static final b JSW;
    
    static
    {
      AppMethodBeat.i(60195);
      JSW = new b();
      AppMethodBeat.o(60195);
    }
    
    public final int fJg()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.c
 * JD-Core Version:    0.7.0.1
 */