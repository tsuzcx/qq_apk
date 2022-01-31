package org.c.f;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.c.g.c;

public final class a
  implements b
{
  public final String au(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      org.c.g.d.hc(paramString1, "Base string cant be null or empty string");
      org.c.g.d.hc(paramString2, "Api secret cant be null or empty string");
      paramString2 = new SecretKeySpec((c.encode(paramString2) + '&' + c.encode(paramString3)).getBytes("UTF-8"), "HmacSHA1");
      paramString3 = Mac.getInstance("HmacSHA1");
      paramString3.init(paramString2);
      paramString2 = new String(org.c.g.a.cj(paramString3.doFinal(paramString1.getBytes("UTF-8")))).replace("\r\n", "");
      return paramString2;
    }
    catch (Exception paramString2)
    {
      throw new org.c.b.d(paramString1, paramString2);
    }
  }
  
  public final String cVf()
  {
    return "HMAC-SHA1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.c.f.a
 * JD-Core Version:    0.7.0.1
 */