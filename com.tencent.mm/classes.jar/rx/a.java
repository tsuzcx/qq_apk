package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d OtQ;
  public static final d OtR;
  public static final d OtS = b.OtV;
  public static final d OtT = a.OtU;
  
  static
  {
    c localc = c.OtW;
    OtQ = localc;
    OtR = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a OtU;
    
    static
    {
      AppMethodBeat.i(90031);
      OtU = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean gDm()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b OtV;
    
    static
    {
      AppMethodBeat.i(90030);
      OtV = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean gDm()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c OtW;
    
    static
    {
      AppMethodBeat.i(90033);
      OtW = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean gDm()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean gDm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */