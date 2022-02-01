package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

final class e$a
  implements Serializable
{
  private static final a aaAZ;
  
  static
  {
    AppMethodBeat.i(128955);
    aaAZ = new a();
    AppMethodBeat.o(128955);
  }
  
  private Object readResolve()
  {
    return aaAZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.g.b.e.a
 * JD-Core Version:    0.7.0.1
 */