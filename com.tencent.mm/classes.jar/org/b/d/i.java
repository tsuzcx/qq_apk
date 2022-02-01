package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import org.b.g.d;

public final class i
  implements Serializable
{
  public final String FjO;
  private final String rawResponse;
  public final String token;
  
  public i(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40536);
    d.j(paramString1, "Token can't be null");
    d.j(paramString2, "Secret can't be null");
    this.token = paramString1;
    this.FjO = paramString2;
    this.rawResponse = paramString3;
    AppMethodBeat.o(40536);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40538);
    if (this == paramObject)
    {
      AppMethodBeat.o(40538);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(40538);
      return false;
    }
    paramObject = (i)paramObject;
    if ((this.token.equals(paramObject.token)) && (this.FjO.equals(paramObject.FjO)))
    {
      AppMethodBeat.o(40538);
      return true;
    }
    AppMethodBeat.o(40538);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(40539);
    int i = this.token.hashCode();
    int j = this.FjO.hashCode();
    AppMethodBeat.o(40539);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(40537);
    String str = String.format("Token[%s , %s]", new Object[] { this.token, this.FjO });
    AppMethodBeat.o(40537);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.d.i
 * JD-Core Version:    0.7.0.1
 */