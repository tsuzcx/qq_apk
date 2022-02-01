package okhttp3.internal.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.c;
import okhttp3.v;

final class d
  extends g
{
  final Method ajSs;
  final Method ajSt;
  
  private d(Method paramMethod1, Method paramMethod2)
  {
    this.ajSs = paramMethod1;
    this.ajSt = paramMethod2;
  }
  
  public static d kIp()
  {
    AppMethodBeat.i(187108);
    try
    {
      d locald = new d(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      AppMethodBeat.o(187108);
      return locald;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(187108);
    }
    return null;
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList)
  {
    AppMethodBeat.i(187123);
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = pm(paramList);
      this.ajSs.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      AppMethodBeat.o(187123);
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      paramSSLSocket = c.c("unable to set ssl parameters", paramSSLSocket);
      AppMethodBeat.o(187123);
      throw paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label58:
      break label58;
    }
  }
  
  public final String d(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187135);
    try
    {
      paramSSLSocket = (String)this.ajSt.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null)
      {
        boolean bool = paramSSLSocket.equals("");
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(187135);
        return null;
      }
      AppMethodBeat.o(187135);
      return paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      if ((paramSSLSocket.getCause() instanceof UnsupportedOperationException))
      {
        AppMethodBeat.o(187135);
        return null;
      }
      paramSSLSocket = c.c("failed to get ALPN selected protocol", paramSSLSocket);
      AppMethodBeat.o(187135);
      throw paramSSLSocket;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      paramSSLSocket = c.c("failed to get ALPN selected protocol", paramSSLSocket);
      AppMethodBeat.o(187135);
      throw paramSSLSocket;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.d
 * JD-Core Version:    0.7.0.1
 */