package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.d.a;

public enum b
  implements d.a<Object>
{
  static final d<Object> Ukx;
  
  static
  {
    AppMethodBeat.i(90248);
    Ukw = new b("INSTANCE");
    Uky = new b[] { Ukw };
    Ukx = d.a(Ukw);
    AppMethodBeat.o(90248);
  }
  
  private b() {}
  
  public static <T> d<T> hQF()
  {
    return Ukx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.b
 * JD-Core Version:    0.7.0.1
 */