package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.d.a;

public enum b
  implements d.a<Object>
{
  static final d<Object> NXE;
  
  static
  {
    AppMethodBeat.i(90248);
    NXD = new b("INSTANCE");
    NXF = new b[] { NXD };
    NXE = d.a(NXD);
    AppMethodBeat.o(90248);
  }
  
  private b() {}
  
  public static <T> d<T> gyV()
  {
    return NXE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.a.b
 * JD-Core Version:    0.7.0.1
 */