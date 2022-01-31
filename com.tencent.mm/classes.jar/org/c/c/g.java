package org.c.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.c.b.b;
import org.c.d.i;
import org.c.g.c;
import org.c.g.d;

public final class g
  implements a, f
{
  private static final Pattern xut = Pattern.compile("oauth_token=([^&]+)");
  private static final Pattern xuu = Pattern.compile("oauth_token_secret=([^&]*)");
  
  private static String g(String paramString, Pattern paramPattern)
  {
    paramPattern = paramPattern.matcher(paramString);
    if ((paramPattern.find()) && (paramPattern.groupCount() > 0)) {
      return c.decode(paramPattern.group(1));
    }
    throw new b("Response body is incorrect. Can't extract token and secret from this: '" + paramString + "'", null);
  }
  
  public final i ahz(String paramString)
  {
    d.hc(paramString, "Response body is incorrect. Can't extract a token from an empty string");
    return new i(g(paramString, xut), g(paramString, xuu), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.c.c.g
 * JD-Core Version:    0.7.0.1
 */