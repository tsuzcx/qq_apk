package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.b.g.c;

public final class a
  implements b
{
  public final String bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(40569);
    try
    {
      org.b.g.d.np(paramString1, "Base string cant be null or empty string");
      org.b.g.d.np(paramString2, "Api secret cant be null or empty string");
      paramString2 = new SecretKeySpec((c.encode(paramString2) + '&' + c.encode(paramString3)).getBytes("UTF-8"), "HmacSHA1");
      paramString3 = Mac.getInstance("HmacSHA1");
      paramString3.init(paramString2);
      paramString2 = new String(org.b.g.a.dm(paramString3.doFinal(paramString1.getBytes("UTF-8")))).replace("\r\n", "");
      AppMethodBeat.o(40569);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString1 = new org.b.b.d(paramString1, paramString2);
      AppMethodBeat.o(40569);
      throw paramString1;
    }
  }
  
  public final String ggd()
  {
    return "HMAC-SHA1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.f.a
 * JD-Core Version:    0.7.0.1
 */