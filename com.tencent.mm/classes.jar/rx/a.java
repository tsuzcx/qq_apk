package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d NWL;
  public static final d NWM;
  public static final d NWN = b.NWQ;
  public static final d NWO = a.NWP;
  
  static
  {
    c localc = c.NWR;
    NWL = localc;
    NWM = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a NWP;
    
    static
    {
      AppMethodBeat.i(90031);
      NWP = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean gyK()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b NWQ;
    
    static
    {
      AppMethodBeat.i(90030);
      NWQ = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean gyK()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c NWR;
    
    static
    {
      AppMethodBeat.i(90033);
      NWR = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean gyK()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean gyK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */