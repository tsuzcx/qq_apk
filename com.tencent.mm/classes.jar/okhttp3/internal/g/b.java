package okhttp3.internal.g;

import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.i.e;
import okhttp3.v;

class b
  extends g
{
  private final Class<?> ajSg;
  private final f<Socket> ajSh;
  private final f<Socket> ajSi;
  private final f<Socket> ajSj;
  private final f<Socket> ajSk;
  private final c ajSl;
  
  b(Class<?> paramClass, f<Socket> paramf1, f<Socket> paramf2, f<Socket> paramf3, f<Socket> paramf4)
  {
    AppMethodBeat.i(187088);
    this.ajSl = c.kIm();
    this.ajSg = paramClass;
    this.ajSh = paramf1;
    this.ajSi = paramf2;
    this.ajSj = paramf3;
    this.ajSk = paramf4;
    AppMethodBeat.o(187088);
  }
  
  private boolean b(String paramString, Class<?> paramClass, Object paramObject)
  {
    AppMethodBeat.i(187097);
    boolean bool;
    try
    {
      bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      AppMethodBeat.o(187097);
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      bool = c(paramString, paramClass, paramObject);
      AppMethodBeat.o(187097);
    }
    return bool;
  }
  
  private boolean c(String paramString, Class<?> paramClass, Object paramObject)
  {
    AppMethodBeat.i(187104);
    boolean bool;
    try
    {
      bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      AppMethodBeat.o(187104);
      return bool;
    }
    catch (NoSuchMethodException paramClass)
    {
      bool = super.bKL(paramString);
      AppMethodBeat.o(187104);
    }
    return bool;
  }
  
  public static g kIi()
  {
    AppMethodBeat.i(187133);
    if (!g.isAndroid())
    {
      AppMethodBeat.o(187133);
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          f localf3 = new f(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
          f localf4 = new f(null, "setHostname", new Class[] { String.class });
          if (!kIj()) {
            break label147;
          }
          localf1 = new f([B.class, "getAlpnSelectedProtocol", new Class[0]);
          localf2 = new f(null, "setAlpnProtocols", new Class[] { [B.class });
          Object localObject = new b((Class)localObject, localf3, localf4, localf1, localf2);
          AppMethodBeat.o(187133);
          return localObject;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          Class localClass;
          AppMethodBeat.o(187133);
          return null;
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        localClass = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        continue;
      }
      label147:
      f localf2 = null;
      f localf1 = null;
    }
  }
  
  private static boolean kIj()
  {
    AppMethodBeat.i(187114);
    if (Security.getProvider("GMSCore_OpenSSL") != null)
    {
      AppMethodBeat.o(187114);
      return true;
    }
    try
    {
      Class.forName("android.net.Network");
      AppMethodBeat.o(187114);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(187114);
    }
    return false;
  }
  
  static int kIl()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
    return 0;
  }
  
  public final void Z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(187195);
    if (!this.ajSl.jI(paramObject)) {
      g(5, paramString, null);
    }
    AppMethodBeat.o(187195);
  }
  
  public final void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    AppMethodBeat.i(187149);
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      AppMethodBeat.o(187149);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (okhttp3.internal.c.a(paramSocket))
      {
        paramSocket = new IOException(paramSocket);
        AppMethodBeat.o(187149);
        throw paramSocket;
      }
      AppMethodBeat.o(187149);
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      AppMethodBeat.o(187149);
      throw paramInetSocketAddress;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        AppMethodBeat.o(187149);
        throw paramInetSocketAddress;
      }
      AppMethodBeat.o(187149);
      throw paramSocket;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList)
  {
    AppMethodBeat.i(187164);
    if (paramString != null)
    {
      this.ajSh.e(paramSSLSocket, new Object[] { Boolean.TRUE });
      this.ajSi.e(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.ajSk != null) && (this.ajSk.jJ(paramSSLSocket)))
    {
      paramString = new j.f();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        v localv = (v)paramList.get(i);
        if (localv != v.ajNu)
        {
          paramString.aNg(localv.toString().length());
          paramString.bKQ(localv.toString());
        }
        i += 1;
      }
      paramString = paramString.Ml();
      this.ajSk.f(paramSSLSocket, new Object[] { paramString });
    }
    AppMethodBeat.o(187164);
  }
  
  public final okhttp3.internal.i.c b(X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(187204);
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new a(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      AppMethodBeat.o(187204);
      return localObject;
    }
    catch (Exception localException)
    {
      paramX509TrustManager = super.b(paramX509TrustManager);
      AppMethodBeat.o(187204);
    }
    return paramX509TrustManager;
  }
  
  public final Object bKK(String paramString)
  {
    AppMethodBeat.i(187182);
    paramString = this.ajSl.bKM(paramString);
    AppMethodBeat.o(187182);
    return paramString;
  }
  
  public final boolean bKL(String paramString)
  {
    AppMethodBeat.i(187199);
    boolean bool;
    if (Build.VERSION.SDK_INT < 23)
    {
      bool = super.bKL(paramString);
      AppMethodBeat.o(187199);
      return bool;
    }
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      bool = b(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
      AppMethodBeat.o(187199);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      bool = super.bKL(paramString);
      AppMethodBeat.o(187199);
      return bool;
    }
    catch (IllegalAccessException paramString)
    {
      paramString = okhttp3.internal.c.c("unable to determine cleartext support", paramString);
      AppMethodBeat.o(187199);
      throw paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      break label85;
    }
    catch (InvocationTargetException paramString)
    {
      break label85;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label70:
      label85:
      break label70;
    }
  }
  
  public final e c(X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(187207);
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new b(paramX509TrustManager, (Method)localObject);
      AppMethodBeat.o(187207);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramX509TrustManager = super.c(paramX509TrustManager);
      AppMethodBeat.o(187207);
    }
    return paramX509TrustManager;
  }
  
  public String d(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187171);
    if (this.ajSj == null)
    {
      AppMethodBeat.o(187171);
      return null;
    }
    if (!this.ajSj.jJ(paramSSLSocket))
    {
      AppMethodBeat.o(187171);
      return null;
    }
    paramSSLSocket = (byte[])this.ajSj.f(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null)
    {
      paramSSLSocket = new String(paramSSLSocket, okhttp3.internal.c.UTF_8);
      AppMethodBeat.o(187171);
      return paramSSLSocket;
    }
    AppMethodBeat.o(187171);
    return null;
  }
  
  public final void g(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(187178);
    int i;
    String str;
    int k;
    label58:
    int j;
    if (paramInt == 5)
    {
      i = 5;
      str = paramString;
      if (paramThrowable != null) {
        str = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      }
      paramInt = 0;
      k = str.length();
      if (paramInt >= k) {
        break label137;
      }
      j = str.indexOf('\n', paramInt);
      if (j == -1) {
        break label130;
      }
    }
    for (;;)
    {
      int m = Math.min(j, paramInt + 4000);
      Log.println(i, "OkHttp", str.substring(paramInt, m));
      if (m >= j)
      {
        paramInt = m + 1;
        break label58;
        i = 3;
        break;
        label130:
        j = k;
        continue;
        label137:
        AppMethodBeat.o(187178);
        return;
      }
      paramInt = m;
    }
  }
  
  public final SSLContext kIk()
  {
    int i = 1;
    AppMethodBeat.i(187212);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 16) {
          continue;
        }
        int j = Build.VERSION.SDK_INT;
        if (j >= 22) {
          continue;
        }
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        SSLContext localSSLContext2;
        IllegalStateException localIllegalStateException;
        continue;
      }
      if (i == 0) {
        continue;
      }
      try
      {
        SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.2");
        AppMethodBeat.o(187212);
        return localSSLContext1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
      i = 0;
    }
    try
    {
      localSSLContext2 = SSLContext.getInstance("TLS");
      AppMethodBeat.o(187212);
      return localSSLContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      localIllegalStateException = new IllegalStateException("No TLS provider", localNoSuchAlgorithmException2);
      AppMethodBeat.o(187212);
      throw localIllegalStateException;
    }
  }
  
  static final class a
    extends okhttp3.internal.i.c
  {
    private final Object ajSm;
    private final Method ajSn;
    
    a(Object paramObject, Method paramMethod)
    {
      this.ajSm = paramObject;
      this.ajSn = paramMethod;
    }
    
    public final List<Certificate> M(List<Certificate> paramList, String paramString)
    {
      AppMethodBeat.i(187126);
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.ajSn.invoke(this.ajSm, new Object[] { paramList, "RSA", paramString });
        AppMethodBeat.o(187126);
        return paramList;
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        AppMethodBeat.o(187126);
        throw paramString;
      }
      catch (IllegalAccessException paramList)
      {
        paramList = new AssertionError(paramList);
        AppMethodBeat.o(187126);
        throw paramList;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      return paramObject instanceof a;
    }
    
    public final int hashCode()
    {
      return 0;
    }
  }
  
  static final class b
    implements e
  {
    private final X509TrustManager ajSo;
    private final Method ajSp;
    
    b(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.ajSp = paramMethod;
      this.ajSo = paramX509TrustManager;
    }
    
    public final X509Certificate d(X509Certificate paramX509Certificate)
    {
      AppMethodBeat.i(187119);
      try
      {
        paramX509Certificate = (TrustAnchor)this.ajSp.invoke(this.ajSo, new Object[] { paramX509Certificate });
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.getTrustedCert();
          AppMethodBeat.o(187119);
          return paramX509Certificate;
        }
        AppMethodBeat.o(187119);
        return null;
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        paramX509Certificate = okhttp3.internal.c.c("unable to get issues and signature", paramX509Certificate);
        AppMethodBeat.o(187119);
        throw paramX509Certificate;
      }
      catch (InvocationTargetException paramX509Certificate)
      {
        AppMethodBeat.o(187119);
      }
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187131);
      if (paramObject == this)
      {
        AppMethodBeat.o(187131);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(187131);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.ajSo.equals(paramObject.ajSo)) && (this.ajSp.equals(paramObject.ajSp)))
      {
        AppMethodBeat.o(187131);
        return true;
      }
      AppMethodBeat.o(187131);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(187138);
      int i = this.ajSo.hashCode();
      int j = this.ajSp.hashCode();
      AppMethodBeat.o(187138);
      return i + j * 31;
    }
  }
  
  static final class c
  {
    private final Method ajSq;
    private final Method ajSr;
    private final Method dSt;
    
    private c(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.dSt = paramMethod1;
      this.ajSq = paramMethod2;
      this.ajSr = paramMethod3;
    }
    
    static c kIm()
    {
      AppMethodBeat.i(187110);
      try
      {
        localObject3 = Class.forName("dalvik.system.CloseGuard");
        localMethod = ((Class)localObject3).getMethod("get", new Class[0]);
        Object localObject1 = ((Class)localObject3).getMethod("open", new Class[] { String.class });
        localObject3 = ((Class)localObject3).getMethod("warnIfOpen", new Class[0]);
        localObject1 = new c(localMethod, (Method)localObject1, (Method)localObject3);
        AppMethodBeat.o(187110);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
          Method localMethod = null;
          Object localObject3 = null;
        }
      }
    }
    
    final Object bKM(String paramString)
    {
      AppMethodBeat.i(187122);
      if (this.dSt != null) {
        try
        {
          Object localObject = this.dSt.invoke(null, new Object[0]);
          this.ajSq.invoke(localObject, new Object[] { paramString });
          AppMethodBeat.o(187122);
          return localObject;
        }
        catch (Exception paramString) {}
      }
      AppMethodBeat.o(187122);
      return null;
    }
    
    final boolean jI(Object paramObject)
    {
      bool2 = false;
      AppMethodBeat.i(187130);
      bool1 = bool2;
      if (paramObject != null) {}
      try
      {
        this.ajSr.invoke(paramObject, new Object[0]);
        bool1 = true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
      AppMethodBeat.o(187130);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.b
 * JD-Core Version:    0.7.0.1
 */