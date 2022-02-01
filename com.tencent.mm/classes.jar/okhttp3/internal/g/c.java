package okhttp3.internal.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.v;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.ProviderBuilder;

public final class c
  extends g
{
  private static Provider kIn()
  {
    AppMethodBeat.i(187089);
    Provider localProvider = Conscrypt.newProviderBuilder().provideTrustManager().build();
    AppMethodBeat.o(187089);
    return localProvider;
  }
  
  public static c kIo()
  {
    AppMethodBeat.i(187098);
    try
    {
      Class.forName("org.conscrypt.Conscrypt");
      boolean bool = Conscrypt.isAvailable();
      if (!bool)
      {
        AppMethodBeat.o(187098);
        return null;
      }
      c localc = new c();
      AppMethodBeat.o(187098);
      return localc;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(187098);
    }
    return null;
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList)
  {
    AppMethodBeat.i(187106);
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])g.pm(paramList).toArray(new String[0]));
      AppMethodBeat.o(187106);
      return;
    }
    super.a(paramSSLSocket, paramString, paramList);
    AppMethodBeat.o(187106);
  }
  
  public final void a(SSLSocketFactory paramSSLSocketFactory)
  {
    AppMethodBeat.i(187132);
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
    AppMethodBeat.o(187132);
  }
  
  public final String d(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187115);
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      paramSSLSocket = Conscrypt.getApplicationProtocol(paramSSLSocket);
      AppMethodBeat.o(187115);
      return paramSSLSocket;
    }
    paramSSLSocket = super.d(paramSSLSocket);
    AppMethodBeat.o(187115);
    return paramSSLSocket;
  }
  
  public final SSLContext kIk()
  {
    AppMethodBeat.i(187125);
    try
    {
      SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.3", kIn());
      AppMethodBeat.o(187125);
      return localSSLContext1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        SSLContext localSSLContext2 = SSLContext.getInstance("TLS", kIn());
        AppMethodBeat.o(187125);
        return localSSLContext2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
        AppMethodBeat.o(187125);
        throw localIllegalStateException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.c
 * JD-Core Version:    0.7.0.1
 */