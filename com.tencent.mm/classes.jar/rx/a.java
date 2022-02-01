package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d ajZS;
  public static final d ajZT;
  public static final d ajZU = b.ajZX;
  public static final d ajZV = a.ajZW;
  
  static
  {
    c localc = c.ajZY;
    ajZS = localc;
    ajZT = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a ajZW;
    
    static
    {
      AppMethodBeat.i(90031);
      ajZW = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean kKd()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b ajZX;
    
    static
    {
      AppMethodBeat.i(90030);
      ajZX = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean kKd()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c ajZY;
    
    static
    {
      AppMethodBeat.i(90033);
      ajZY = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean kKd()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean kKd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */