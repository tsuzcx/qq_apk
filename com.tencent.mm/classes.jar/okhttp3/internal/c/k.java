package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.ProtocolException;
import okhttp3.v;

public final class k
{
  public final v ajJs;
  public final int code;
  public final String message;
  
  public k(v paramv, int paramInt, String paramString)
  {
    this.ajJs = paramv;
    this.code = paramInt;
    this.message = paramString;
  }
  
  public static k bKJ(String paramString)
  {
    int i = 9;
    AppMethodBeat.i(186803);
    int j;
    v localv;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < 9) || (paramString.charAt(8) != ' '))
      {
        paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(186803);
        throw paramString;
      }
      j = paramString.charAt(7) - '0';
      if (j == 0) {
        localv = v.ajNu;
      }
    }
    while (paramString.length() < i + 3)
    {
      paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(186803);
      throw paramString;
      if (j == 1)
      {
        localv = v.ajNv;
      }
      else
      {
        paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(186803);
        throw paramString;
        if (paramString.startsWith("ICY "))
        {
          localv = v.ajNu;
          i = 4;
        }
        else
        {
          paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(186803);
          throw paramString;
        }
      }
    }
    try
    {
      j = Integer.parseInt(paramString.substring(i, i + 3));
      if (paramString.length() > i + 3) {
        if (paramString.charAt(i + 3) != ' ')
        {
          paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(186803);
          throw paramString;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(186803);
      throw paramString;
    }
    for (paramString = paramString.substring(i + 4);; paramString = "")
    {
      paramString = new k(localNumberFormatException, j, paramString);
      AppMethodBeat.o(186803);
      return paramString;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186814);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ajJs == v.ajNu) {}
    for (String str = "HTTP/1.0";; str = "HTTP/1.1")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(' ').append(this.code);
      if (this.message != null) {
        localStringBuilder.append(' ').append(this.message);
      }
      str = localStringBuilder.toString();
      AppMethodBeat.o(186814);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.c.k
 * JD-Core Version:    0.7.0.1
 */