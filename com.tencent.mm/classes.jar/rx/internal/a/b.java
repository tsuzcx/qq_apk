package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.d.a;

public enum b
  implements d.a<Object>
{
  static final d<Object> abNT;
  
  static
  {
    AppMethodBeat.i(90248);
    abNS = new b("INSTANCE");
    abNU = new b[] { abNS };
    abNT = d.a(abNS);
    AppMethodBeat.o(90248);
  }
  
  private b() {}
  
  public static <T> d<T> iVO()
  {
    return abNT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.b
 * JD-Core Version:    0.7.0.1
 */