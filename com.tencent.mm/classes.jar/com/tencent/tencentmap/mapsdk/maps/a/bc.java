package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class bc
  implements HostnameVerifier
{
  private String a;
  
  public bc(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147272);
    if ((TextUtils.isEmpty(this.a)) || (!(paramObject instanceof bc)))
    {
      AppMethodBeat.o(147272);
      return false;
    }
    paramObject = ((bc)paramObject).a;
    if (TextUtils.isEmpty(paramObject))
    {
      AppMethodBeat.o(147272);
      return false;
    }
    boolean bool = this.a.equals(paramObject);
    AppMethodBeat.o(147272);
    return bool;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    AppMethodBeat.i(147271);
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
    AppMethodBeat.o(147271);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bc
 * JD-Core Version:    0.7.0.1
 */