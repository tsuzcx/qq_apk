package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public enum v
{
  private final String protocol;
  
  static
  {
    AppMethodBeat.i(186719);
    ajNu = new v("HTTP_1_0", 0, "http/1.0");
    ajNv = new v("HTTP_1_1", 1, "http/1.1");
    ajNw = new v("SPDY_3", 2, "spdy/3.1");
    ajNx = new v("HTTP_2", 3, "h2");
    ajNy = new v("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    ajNz = new v("QUIC", 5, "quic");
    ajNA = new v[] { ajNu, ajNv, ajNw, ajNx, ajNy, ajNz };
    AppMethodBeat.o(186719);
  }
  
  private v(String paramString)
  {
    this.protocol = paramString;
  }
  
  public static v bKu(String paramString)
  {
    AppMethodBeat.i(186708);
    if (paramString.equals(ajNu.protocol))
    {
      paramString = ajNu;
      AppMethodBeat.o(186708);
      return paramString;
    }
    if (paramString.equals(ajNv.protocol))
    {
      paramString = ajNv;
      AppMethodBeat.o(186708);
      return paramString;
    }
    if (paramString.equals(ajNy.protocol))
    {
      paramString = ajNy;
      AppMethodBeat.o(186708);
      return paramString;
    }
    if (paramString.equals(ajNx.protocol))
    {
      paramString = ajNx;
      AppMethodBeat.o(186708);
      return paramString;
    }
    if (paramString.equals(ajNw.protocol))
    {
      paramString = ajNw;
      AppMethodBeat.o(186708);
      return paramString;
    }
    if (paramString.equals(ajNz.protocol))
    {
      paramString = ajNz;
      AppMethodBeat.o(186708);
      return paramString;
    }
    paramString = new IOException("Unexpected protocol: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(186708);
    throw paramString;
  }
  
  public final String toString()
  {
    return this.protocol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.v
 * JD-Core Version:    0.7.0.1
 */