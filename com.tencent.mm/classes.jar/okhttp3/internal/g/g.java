package okhttp3.internal.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.u;
import okhttp3.v;

public class g
{
  private static final g ajSD;
  private static final Logger logger;
  
  static
  {
    AppMethodBeat.i(187129);
    Object localObject1;
    Object localObject2;
    if (isAndroid())
    {
      localObject1 = a.kIi();
      if (localObject1 != null) {}
      do
      {
        ajSD = (g)localObject1;
        logger = Logger.getLogger(u.class.getName());
        AppMethodBeat.o(187129);
        return;
        localObject2 = b.kIi();
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = new NullPointerException("No platform found on Android");
      AppMethodBeat.o(187129);
      throw ((Throwable)localObject1);
    }
    if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {}
    for (boolean bool = true;; bool = "Conscrypt".equals(java.security.Security.getProviders()[0].getName()))
    {
      if (bool)
      {
        localObject2 = c.kIo();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
      }
      localObject2 = d.kIp();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = e.kIi();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new g();
      break;
    }
  }
  
  public static String getPrefix()
  {
    return "OkHttp";
  }
  
  public static boolean isAndroid()
  {
    AppMethodBeat.i(187107);
    boolean bool = "Dalvik".equals(System.getProperty("java.vm.name"));
    AppMethodBeat.o(187107);
    return bool;
  }
  
  public static g kIq()
  {
    return ajSD;
  }
  
  public static List<String> pm(List<v> paramList)
  {
    AppMethodBeat.i(187101);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      v localv = (v)paramList.get(i);
      if (localv != v.ajNu) {
        localArrayList.add(localv.toString());
      }
      i += 1;
    }
    AppMethodBeat.o(187101);
    return localArrayList;
  }
  
  public void Z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(187170);
    String str = paramString;
    if (paramObject == null) {
      str = paramString + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    }
    g(5, str, (Throwable)paramObject);
    AppMethodBeat.o(187170);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    AppMethodBeat.i(187148);
    paramSocket.connect(paramInetSocketAddress, paramInt);
    AppMethodBeat.o(187148);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList) {}
  
  public void a(SSLSocketFactory paramSSLSocketFactory) {}
  
  public okhttp3.internal.i.c b(X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(187174);
    paramX509TrustManager = new okhttp3.internal.i.a(c(paramX509TrustManager));
    AppMethodBeat.o(187174);
    return paramX509TrustManager;
  }
  
  public Object bKK(String paramString)
  {
    AppMethodBeat.i(187166);
    if (logger.isLoggable(Level.FINE))
    {
      paramString = new Throwable(paramString);
      AppMethodBeat.o(187166);
      return paramString;
    }
    AppMethodBeat.o(187166);
    return null;
  }
  
  public boolean bKL(String paramString)
  {
    return true;
  }
  
  public okhttp3.internal.i.e c(X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(187187);
    paramX509TrustManager = new okhttp3.internal.i.b(paramX509TrustManager.getAcceptedIssuers());
    AppMethodBeat.o(187187);
    return paramX509TrustManager;
  }
  
  public String d(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void e(SSLSocket paramSSLSocket) {}
  
  public void g(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(187157);
    if (paramInt == 5) {}
    for (Level localLevel = Level.WARNING;; localLevel = Level.INFO)
    {
      logger.log(localLevel, paramString, paramThrowable);
      AppMethodBeat.o(187157);
      return;
    }
  }
  
  public SSLContext kIk()
  {
    AppMethodBeat.i(187180);
    if ("1.7".equals(System.getProperty("java.specification.version"))) {
      try
      {
        SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.2");
        AppMethodBeat.o(187180);
        return localSSLContext1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
    }
    try
    {
      SSLContext localSSLContext2 = SSLContext.getInstance("TLS");
      AppMethodBeat.o(187180);
      return localSSLContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("No TLS provider", localNoSuchAlgorithmException2);
      AppMethodBeat.o(187180);
      throw localIllegalStateException;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(187191);
    String str = getClass().getSimpleName();
    AppMethodBeat.o(187191);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.g
 * JD-Core Version:    0.7.0.1
 */