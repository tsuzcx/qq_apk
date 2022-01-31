package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import org.b.g.d;

public final class i
  implements Serializable
{
  private final String rawResponse;
  public final String token;
  public final String xsy;
  
  public i(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(77267);
    d.s(paramString1, "Token can't be null");
    d.s(paramString2, "Secret can't be null");
    this.token = paramString1;
    this.xsy = paramString2;
    this.rawResponse = paramString3;
    AppMethodBeat.o(77267);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77269);
    if (this == paramObject)
    {
      AppMethodBeat.o(77269);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(77269);
      return false;
    }
    paramObject = (i)paramObject;
    if ((this.token.equals(paramObject.token)) && (this.xsy.equals(paramObject.xsy)))
    {
      AppMethodBeat.o(77269);
      return true;
    }
    AppMethodBeat.o(77269);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77270);
    int i = this.token.hashCode();
    int j = this.xsy.hashCode();
    AppMethodBeat.o(77270);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77268);
    String str = String.format("Token[%s , %s]", new Object[] { this.token, this.xsy });
    AppMethodBeat.o(77268);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.d.i
 * JD-Core Version:    0.7.0.1
 */