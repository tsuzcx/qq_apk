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
  private static final Pattern ajYv;
  private static final Pattern ajYw;
  
  static
  {
    AppMethodBeat.i(40507);
    ajYv = Pattern.compile("oauth_token=([^&]+)");
    ajYw = Pattern.compile("oauth_token_secret=([^&]*)");
    AppMethodBeat.o(40507);
  }
  
  private static String g(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(40509);
    paramPattern = paramPattern.matcher(paramString);
    if ((paramPattern.find()) && (paramPattern.groupCount() > 0))
    {
      paramString = c.ch(paramPattern.group(1));
      AppMethodBeat.o(40509);
      return paramString;
    }
    paramString = new b("Response body is incorrect. Can't extract token and secret from this: '" + paramString + "'", null);
    AppMethodBeat.o(40509);
    throw paramString;
  }
  
  public final i bLx(String paramString)
  {
    AppMethodBeat.i(40508);
    d.rN(paramString, "Response body is incorrect. Can't extract a token from an empty string");
    paramString = new i(g(paramString, ajYv), g(paramString, ajYw), paramString);
    AppMethodBeat.o(40508);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.c.g
 * JD-Core Version:    0.7.0.1
 */