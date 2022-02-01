package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import okhttp3.r;

public final class i
{
  public static String d(r paramr)
  {
    AppMethodBeat.i(186779);
    String str = paramr.kGQ();
    paramr = paramr.kGS();
    if (paramr != null)
    {
      paramr = str + '?' + paramr;
      AppMethodBeat.o(186779);
      return paramr;
    }
    AppMethodBeat.o(186779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.c.i
 * JD-Core Version:    0.7.0.1
 */