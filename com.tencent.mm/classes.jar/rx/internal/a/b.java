package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.d.a;

public enum b
  implements d.a<Object>
{
  static final d<Object> akaM;
  
  static
  {
    AppMethodBeat.i(90248);
    akaL = new b("INSTANCE");
    akaN = new b[] { akaL };
    akaM = d.a(akaL);
    AppMethodBeat.o(90248);
  }
  
  private b() {}
  
  public static <T> d<T> kKm()
  {
    return akaM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.b
 * JD-Core Version:    0.7.0.1
 */