package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.c;

public final class p
{
  final ac ajMO;
  public final h ajMP;
  public final List<Certificate> ajMQ;
  final List<Certificate> ajMR;
  
  p(ac paramac, h paramh, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.ajMO = paramac;
    this.ajMP = paramh;
    this.ajMQ = paramList1;
    this.ajMR = paramList2;
  }
  
  public static p a(SSLSession paramSSLSession)
  {
    AppMethodBeat.i(186688);
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null)
    {
      paramSSLSession = new IllegalStateException("cipherSuite == null");
      AppMethodBeat.o(186688);
      throw paramSSLSession;
    }
    if ("SSL_NULL_WITH_NULL_NULL".equals(localObject))
    {
      paramSSLSession = new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
      AppMethodBeat.o(186688);
      throw paramSSLSession;
    }
    h localh = h.bKg((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null)
    {
      paramSSLSession = new IllegalStateException("tlsVersion == null");
      AppMethodBeat.o(186688);
      throw paramSSLSession;
    }
    if ("NONE".equals(localObject))
    {
      paramSSLSession = new IOException("tlsVersion == NONE");
      AppMethodBeat.o(186688);
      throw paramSSLSession;
    }
    ac localac = ac.bKx((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = c.au((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label187;
        }
        paramSSLSession = c.au(paramSSLSession);
        paramSSLSession = new p(localac, localh, (List)localObject, paramSSLSession);
        AppMethodBeat.o(186688);
        return paramSSLSession;
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label187:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186702);
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(186702);
      return false;
    }
    paramObject = (p)paramObject;
    if ((this.ajMO.equals(paramObject.ajMO)) && (this.ajMP.equals(paramObject.ajMP)) && (this.ajMQ.equals(paramObject.ajMQ)) && (this.ajMR.equals(paramObject.ajMR)))
    {
      AppMethodBeat.o(186702);
      return true;
    }
    AppMethodBeat.o(186702);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186709);
    int i = this.ajMO.hashCode();
    int j = this.ajMP.hashCode();
    int k = this.ajMQ.hashCode();
    int m = this.ajMR.hashCode();
    AppMethodBeat.o(186709);
    return (((i + 527) * 31 + j) * 31 + k) * 31 + m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.p
 * JD-Core Version:    0.7.0.1
 */