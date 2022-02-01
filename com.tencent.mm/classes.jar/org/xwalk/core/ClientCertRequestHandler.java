package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ClientCertRequestHandler
  implements ClientCertRequest
{
  private Object bridge;
  private ReflectMethod cancelMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod getHostMethod;
  private ReflectMethod getKeyTypesMethod;
  private ReflectMethod getPortMethod;
  private ReflectMethod getPrincipalsMethod;
  private ReflectMethod ignoreMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod proceedPrivateKeyListMethod;
  
  public ClientCertRequestHandler(Object paramObject)
  {
    AppMethodBeat.i(154590);
    this.proceedPrivateKeyListMethod = new ReflectMethod(null, "proceed", new Class[0]);
    this.ignoreMethod = new ReflectMethod(null, "ignore", new Class[0]);
    this.cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    this.getHostMethod = new ReflectMethod(null, "getHost", new Class[0]);
    this.getPortMethod = new ReflectMethod(null, "getPort", new Class[0]);
    this.getKeyTypesMethod = new ReflectMethod(null, "getKeyTypes", new Class[0]);
    this.getPrincipalsMethod = new ReflectMethod(null, "getPrincipals", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154590);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(154593);
    try
    {
      this.cancelMethod.invoke(new Object[0]);
      AppMethodBeat.o(154593);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154593);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154593);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getHost()
  {
    AppMethodBeat.i(154594);
    try
    {
      String str = (String)this.getHostMethod.invoke(new Object[0]);
      AppMethodBeat.o(154594);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154594);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154594);
    }
    return null;
  }
  
  public String[] getKeyTypes()
  {
    AppMethodBeat.i(154596);
    try
    {
      String[] arrayOfString = (String[])this.getKeyTypesMethod.invoke(new Object[0]);
      AppMethodBeat.o(154596);
      return arrayOfString;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154596);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154596);
    }
    return null;
  }
  
  public int getPort()
  {
    AppMethodBeat.i(154595);
    try
    {
      int i = ((Integer)this.getPortMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154595);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154595);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154595);
    }
    return 0;
  }
  
  public Principal[] getPrincipals()
  {
    AppMethodBeat.i(154597);
    try
    {
      Principal[] arrayOfPrincipal = (Principal[])this.getPrincipalsMethod.invoke(new Object[0]);
      AppMethodBeat.o(154597);
      return arrayOfPrincipal;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154597);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154597);
    }
    return null;
  }
  
  public void ignore()
  {
    AppMethodBeat.i(154592);
    try
    {
      this.ignoreMethod.invoke(new Object[0]);
      AppMethodBeat.o(154592);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154592);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154592);
    }
  }
  
  public void proceed(PrivateKey paramPrivateKey, List<X509Certificate> paramList)
  {
    AppMethodBeat.i(154591);
    try
    {
      this.proceedPrivateKeyListMethod.invoke(new Object[] { paramPrivateKey, paramList });
      AppMethodBeat.o(154591);
      return;
    }
    catch (UnsupportedOperationException paramPrivateKey)
    {
      if (this.coreWrapper == null)
      {
        paramPrivateKey = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154591);
        throw paramPrivateKey;
      }
      XWalkCoreWrapper.handleRuntimeError(paramPrivateKey);
      AppMethodBeat.o(154591);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154598);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154598);
      return;
    }
    this.proceedPrivateKeyListMethod.init(this.bridge, null, "proceedSuper", new Class[] { PrivateKey.class, List.class });
    this.ignoreMethod.init(this.bridge, null, "ignoreSuper", new Class[0]);
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    this.getHostMethod.init(this.bridge, null, "getHostSuper", new Class[0]);
    this.getPortMethod.init(this.bridge, null, "getPortSuper", new Class[0]);
    this.getKeyTypesMethod.init(this.bridge, null, "getKeyTypesSuper", new Class[0]);
    this.getPrincipalsMethod.init(this.bridge, null, "getPrincipalsSuper", new Class[0]);
    AppMethodBeat.o(154598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.ClientCertRequestHandler
 * JD-Core Version:    0.7.0.1
 */