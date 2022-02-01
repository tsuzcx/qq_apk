package okhttp3.internal.g;

import android.net.ssl.SSLSockets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.v;

final class a
  extends b
{
  private a(Class<?> paramClass)
  {
    super(paramClass, null, null, null, null);
  }
  
  public static g kIi()
  {
    AppMethodBeat.i(187095);
    if (!g.isAndroid())
    {
      AppMethodBeat.o(187095);
      return null;
    }
    try
    {
      if (kIl() >= 29)
      {
        a locala = new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
        AppMethodBeat.o(187095);
        return locala;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(187095);
    }
    return null;
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList)
  {
    AppMethodBeat.i(187103);
    try
    {
      if (SSLSockets.isSupportedSocket(paramSSLSocket)) {
        SSLSockets.setUseSessionTickets(paramSSLSocket, true);
      }
      paramString = paramSSLSocket.getSSLParameters();
      paramString.setApplicationProtocols((String[])g.pm(paramList).toArray(new String[0]));
      paramSSLSocket.setSSLParameters(paramString);
      AppMethodBeat.o(187103);
      return;
    }
    catch (IllegalArgumentException paramSSLSocket)
    {
      paramSSLSocket = new IOException("Android internal error", paramSSLSocket);
      AppMethodBeat.o(187103);
      throw paramSSLSocket;
    }
  }
  
  public final String d(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187113);
    paramSSLSocket = paramSSLSocket.getApplicationProtocol();
    if ((paramSSLSocket == null) || (paramSSLSocket.isEmpty()))
    {
      AppMethodBeat.o(187113);
      return null;
    }
    AppMethodBeat.o(187113);
    return paramSSLSocket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.a
 * JD-Core Version:    0.7.0.1
 */