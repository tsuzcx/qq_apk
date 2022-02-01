package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class n
  extends IOException
{
  public final b ajRP;
  
  public n(b paramb)
  {
    super("stream was reset: ".concat(String.valueOf(paramb)));
    AppMethodBeat.i(186865);
    this.ajRP = paramb;
    AppMethodBeat.o(186865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.n
 * JD-Core Version:    0.7.0.1
 */