package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ab;

public final class d
{
  private final Set<ab> ajPs;
  
  public d()
  {
    AppMethodBeat.i(186853);
    this.ajPs = new LinkedHashSet();
    AppMethodBeat.o(186853);
  }
  
  public final void a(ab paramab)
  {
    try
    {
      AppMethodBeat.i(186860);
      this.ajPs.add(paramab);
      AppMethodBeat.o(186860);
      return;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
  
  public final void b(ab paramab)
  {
    try
    {
      AppMethodBeat.i(186867);
      this.ajPs.remove(paramab);
      AppMethodBeat.o(186867);
      return;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
  
  public final boolean c(ab paramab)
  {
    try
    {
      AppMethodBeat.i(186872);
      boolean bool = this.ajPs.contains(paramab);
      AppMethodBeat.o(186872);
      return bool;
    }
    finally
    {
      paramab = finally;
      throw paramab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.d
 * JD-Core Version:    0.7.0.1
 */