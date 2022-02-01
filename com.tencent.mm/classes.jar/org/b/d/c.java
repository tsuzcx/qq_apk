package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends f
{
  public Map<String, String> ajYy;
  
  public c(j paramj, String paramString)
  {
    super(paramj, paramString);
    AppMethodBeat.i(40548);
    this.ajYy = new HashMap();
    AppMethodBeat.o(40548);
  }
  
  public final void rK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40549);
    Map localMap = this.ajYy;
    if ((paramString1.startsWith("oauth_")) || (paramString1.equals("scope")))
    {
      localMap.put(paramString1, paramString2);
      AppMethodBeat.o(40549);
      return;
    }
    paramString1 = new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[] { "scope", "oauth_" }));
    AppMethodBeat.o(40549);
    throw paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(40550);
    String str = String.format("@OAuthRequest(%s, %s)", new Object[] { super.kJJ(), super.getUrl() });
    AppMethodBeat.o(40550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.d.c
 * JD-Core Version:    0.7.0.1
 */