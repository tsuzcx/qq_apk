package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends f
{
  public Map<String, String> CRI;
  
  public c(j paramj, String paramString)
  {
    super(paramj, paramString);
    AppMethodBeat.i(77279);
    this.CRI = new HashMap();
    AppMethodBeat.o(77279);
  }
  
  public final void jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77280);
    Map localMap = this.CRI;
    if ((paramString1.startsWith("oauth_")) || (paramString1.equals("scope")))
    {
      localMap.put(paramString1, paramString2);
      AppMethodBeat.o(77280);
      return;
    }
    paramString1 = new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[] { "scope", "oauth_" }));
    AppMethodBeat.o(77280);
    throw paramString1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77281);
    String str = String.format("@OAuthRequest(%s, %s)", new Object[] { super.erA(), super.getUrl() });
    AppMethodBeat.o(77281);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.d.c
 * JD-Core Version:    0.7.0.1
 */