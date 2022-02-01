package okhttp3.internal.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.c;
import okhttp3.v;

final class e
  extends g
{
  private final Method ajSu;
  private final Method ajSv;
  private final Class<?> ajSw;
  private final Class<?> ajSx;
  private final Method dSt;
  
  private e(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.ajSu = paramMethod1;
    this.dSt = paramMethod2;
    this.ajSv = paramMethod3;
    this.ajSw = paramClass1;
    this.ajSx = paramClass2;
  }
  
  public static g kIi()
  {
    AppMethodBeat.i(187087);
    try
    {
      Object localObject = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Class localClass1 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
      Class localClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
      Class localClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
      localObject = new e(((Class)localObject).getMethod("put", new Class[] { SSLSocket.class, localClass1 }), ((Class)localObject).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject).getMethod("remove", new Class[] { SSLSocket.class }), localClass2, localClass3);
      AppMethodBeat.o(187087);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(187087);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label150:
      break label150;
    }
  }
  
  public final void a(SSLSocket paramSSLSocket, String paramString, List<v> paramList)
  {
    AppMethodBeat.i(187096);
    Object localObject = pm(paramList);
    try
    {
      paramString = g.class.getClassLoader();
      paramList = this.ajSw;
      Class localClass = this.ajSx;
      localObject = new a((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.ajSu.invoke(null, new Object[] { paramSSLSocket, paramString });
      AppMethodBeat.o(187096);
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      paramSSLSocket = c.c("unable to set alpn", paramSSLSocket);
      AppMethodBeat.o(187096);
      throw paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label87:
      break label87;
    }
  }
  
  public final String d(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187116);
    try
    {
      paramSSLSocket = (a)Proxy.getInvocationHandler(this.dSt.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.ajSy) && (paramSSLSocket.ajSz == null))
      {
        g.kIq().g(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        AppMethodBeat.o(187116);
        return null;
      }
      if (paramSSLSocket.ajSy)
      {
        AppMethodBeat.o(187116);
        return null;
      }
      paramSSLSocket = paramSSLSocket.ajSz;
      AppMethodBeat.o(187116);
      return paramSSLSocket;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      paramSSLSocket = c.c("unable to get selected protocol", paramSSLSocket);
      AppMethodBeat.o(187116);
      throw paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label86:
      break label86;
    }
  }
  
  public final void e(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(187102);
    try
    {
      this.ajSv.invoke(null, new Object[] { paramSSLSocket });
      AppMethodBeat.o(187102);
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      paramSSLSocket = c.c("unable to remove alpn", paramSSLSocket);
      AppMethodBeat.o(187102);
      throw paramSSLSocket;
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label29:
      break label29;
    }
  }
  
  static final class a
    implements InvocationHandler
  {
    private final List<String> ajIR;
    boolean ajSy;
    String ajSz;
    
    a(List<String> paramList)
    {
      this.ajIR = paramList;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(187141);
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = c.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass))
      {
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(187141);
        return paramObject;
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.ajSy = true;
        AppMethodBeat.o(187141);
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0))
      {
        paramObject = this.ajIR;
        AppMethodBeat.o(187141);
        return paramObject;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = paramObject.size();
        int i = 0;
        while (i < j)
        {
          if (this.ajIR.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.ajSz = paramObject;
            AppMethodBeat.o(187141);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.ajIR.get(0);
        this.ajSz = paramObject;
        AppMethodBeat.o(187141);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.ajSz = ((String)paramObject[0]);
        AppMethodBeat.o(187141);
        return null;
      }
      paramObject = paramMethod.invoke(this, paramObject);
      AppMethodBeat.o(187141);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.g.e
 * JD-Core Version:    0.7.0.1
 */