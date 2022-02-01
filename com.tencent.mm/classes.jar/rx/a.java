package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d UjE;
  public static final d UjF;
  public static final d UjG = b.UjJ;
  public static final d UjH = a.UjI;
  
  static
  {
    c localc = c.UjK;
    UjE = localc;
    UjF = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a UjI;
    
    static
    {
      AppMethodBeat.i(90031);
      UjI = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean hQu()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b UjJ;
    
    static
    {
      AppMethodBeat.i(90030);
      UjJ = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean hQu()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c UjK;
    
    static
    {
      AppMethodBeat.i(90033);
      UjK = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean hQu()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean hQu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */