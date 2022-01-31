package org.c.d;

import java.util.HashMap;
import java.util.Map;

public final class c
  extends f
{
  public Map<String, String> xuw = new HashMap();
  
  public c(j paramj, String paramString)
  {
    super(paramj, paramString);
  }
  
  public final void ha(String paramString1, String paramString2)
  {
    Map localMap = this.xuw;
    if ((paramString1.startsWith("oauth_")) || (paramString1.equals("scope")))
    {
      localMap.put(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[] { "scope", "oauth_" }));
  }
  
  public final String toString()
  {
    return String.format("@OAuthRequest(%s, %s)", new Object[] { super.cUV(), super.getUrl() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.c.d.c
 * JD-Core Version:    0.7.0.1
 */