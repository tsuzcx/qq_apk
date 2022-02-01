package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d abMZ;
  public static final d abNa;
  public static final d abNb = b.abNe;
  public static final d abNc = a.abNd;
  
  static
  {
    c localc = c.abNf;
    abMZ = localc;
    abNa = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a abNd;
    
    static
    {
      AppMethodBeat.i(90031);
      abNd = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean iVE()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b abNe;
    
    static
    {
      AppMethodBeat.i(90030);
      abNe = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean iVE()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c abNf;
    
    static
    {
      AppMethodBeat.i(90033);
      abNf = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean iVE()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean iVE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */