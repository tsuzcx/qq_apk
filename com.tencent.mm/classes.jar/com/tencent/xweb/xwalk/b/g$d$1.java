package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class g$d$1
  implements HostnameVerifier
{
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    AppMethodBeat.i(85492);
    if (paramString.contains("dldir1.qq.com"))
    {
      AppMethodBeat.o(85492);
      return true;
    }
    AppMethodBeat.o(85492);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.g.d.1
 * JD-Core Version:    0.7.0.1
 */