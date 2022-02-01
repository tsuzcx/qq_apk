package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d MbJ;
  public static final d MbK;
  public static final d MbL = b.MbO;
  public static final d MbM = a.MbN;
  
  static
  {
    c localc = c.MbP;
    MbJ = localc;
    MbK = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a MbN;
    
    static
    {
      AppMethodBeat.i(90031);
      MbN = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean ggg()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b MbO;
    
    static
    {
      AppMethodBeat.i(90030);
      MbO = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean ggg()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c MbP;
    
    static
    {
      AppMethodBeat.i(90033);
      MbP = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean ggg()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean ggg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */