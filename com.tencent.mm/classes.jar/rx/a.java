package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.c;

public final class a
{
  public static final d Koa;
  public static final d Kob;
  public static final d Koc = b.Kof;
  public static final d Kod = a.Koe;
  
  static
  {
    c localc = c.Kog;
    Koa = localc;
    Kob = localc;
  }
  
  static final class a
    implements a.d
  {
    static final a Koe;
    
    static
    {
      AppMethodBeat.i(90031);
      Koe = new a();
      AppMethodBeat.o(90031);
    }
    
    public final boolean fNq()
    {
      return false;
    }
  }
  
  static final class b
    implements a.d
  {
    static final b Kof;
    
    static
    {
      AppMethodBeat.i(90030);
      Kof = new b();
      AppMethodBeat.o(90030);
    }
    
    public final boolean fNq()
    {
      return true;
    }
  }
  
  static final class c
    implements a.d
  {
    static final c Kog;
    
    static
    {
      AppMethodBeat.i(90033);
      Kog = new c();
      AppMethodBeat.o(90033);
    }
    
    public final boolean fNq()
    {
      AppMethodBeat.i(90032);
      c localc = new c("Overflowed buffer");
      AppMethodBeat.o(90032);
      throw localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean fNq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.a
 * JD-Core Version:    0.7.0.1
 */