package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.b.b.b;
import org.b.d.i;
import org.b.g.c;
import org.b.g.d;

public final class g
  implements a, f
{
  private static final Pattern CRF;
  private static final Pattern CRG;
  
  static
  {
    AppMethodBeat.i(77238);
    CRF = Pattern.compile("oauth_token=([^&]+)");
    CRG = Pattern.compile("oauth_token_secret=([^&]*)");
    AppMethodBeat.o(77238);
  }
  
  private static String f(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(77240);
    paramPattern = paramPattern.matcher(paramString);
    if ((paramPattern.find()) && (paramPattern.groupCount() > 0))
    {
      paramString = c.decode(paramPattern.group(1));
      AppMethodBeat.o(77240);
      return paramString;
    }
    paramString = new b("Response body is incorrect. Can't extract token and secret from this: '" + paramString + "'", null);
    AppMethodBeat.o(77240);
    throw paramString;
  }
  
  public final i azT(String paramString)
  {
    AppMethodBeat.i(77239);
    d.jJ(paramString, "Response body is incorrect. Can't extract a token from an empty string");
    paramString = new i(f(paramString, CRF), f(paramString, CRG), paramString);
    AppMethodBeat.o(77239);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.b.c.g
 * JD-Core Version:    0.7.0.1
 */