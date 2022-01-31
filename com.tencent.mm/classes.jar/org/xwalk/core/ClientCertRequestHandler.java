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
    AppMethodBeat.i(85500);
    this.proceedPrivateKeyListMethod = new ReflectMethod(null, "proceed", new Class[0]);
    this.ignoreMethod = new ReflectMethod(null, "ignore", new Class[0]);
    this.cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    this.getHostMethod = new ReflectMethod(null, "getHost", new Class[0]);
    this.getPortMethod = new ReflectMethod(null, "getPort", new Class[0]);
    this.getKeyTypesMethod = new ReflectMethod(null, "getKeyTypes", new Class[0]);
    this.getPrincipalsMethod = new ReflectMethod(null, "getPrincipals", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(85500);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(85503);
    try
    {
      this.cancelMethod.invoke(new Object[0]);
      AppMethodBeat.o(85503);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85503);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85503);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getHost()
  {
    AppMethodBeat.i(85504);
    try
    {
      String str = (String)this.getHostMethod.invoke(new Object[0]);
      AppMethodBeat.o(85504);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85504);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85504);
    }
    return null;
  }
  
  public String[] getKeyTypes()
  {
    AppMethodBeat.i(85506);
    try
    {
      String[] arrayOfString = (String[])this.getKeyTypesMethod.invoke(new Object[0]);
      AppMethodBeat.o(85506);
      return arrayOfString;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85506);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85506);
    }
    return null;
  }
  
  public int getPort()
  {
    AppMethodBeat.i(85505);
    try
    {
      int i = ((Integer)this.getPortMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85505);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85505);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85505);
    }
    return 0;
  }
  
  public Principal[] getPrincipals()
  {
    AppMethodBeat.i(85507);
    try
    {
      Principal[] arrayOfPrincipal = (Principal[])this.getPrincipalsMethod.invoke(new Object[0]);
      AppMethodBeat.o(85507);
      return arrayOfPrincipal;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85507);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85507);
    }
    return null;
  }
  
  public void ignore()
  {
    AppMethodBeat.i(85502);
    try
    {
      this.ignoreMethod.invoke(new Object[0]);
      AppMethodBeat.o(85502);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85502);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85502);
    }
  }
  
  public void proceed(PrivateKey paramPrivateKey, List<X509Certificate> paramList)
  {
    AppMethodBeat.i(85501);
    try
    {
      this.proceedPrivateKeyListMethod.invoke(new Object[] { paramPrivateKey, paramList });
      AppMethodBeat.o(85501);
      return;
    }
    catch (UnsupportedOperationException paramPrivateKey)
    {
      if (this.coreWrapper == null)
      {
        paramPrivateKey = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85501);
        throw paramPrivateKey;
      }
      XWalkCoreWrapper.handleRuntimeError(paramPrivateKey);
      AppMethodBeat.o(85501);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85508);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85508);
      return;
    }
    this.proceedPrivateKeyListMethod.init(this.bridge, null, "proceedSuper", new Class[] { PrivateKey.class, List.class });
    this.ignoreMethod.init(this.bridge, null, "ignoreSuper", new Class[0]);
    this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
    this.getHostMethod.init(this.bridge, null, "getHostSuper", new Class[0]);
    this.getPortMethod.init(this.bridge, null, "getPortSuper", new Class[0]);
    this.getKeyTypesMethod.init(this.bridge, null, "getKeyTypesSuper", new Class[0]);
    this.getPrincipalsMethod.init(this.bridge, null, "getPrincipalsSuper", new Class[0]);
    AppMethodBeat.o(85508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.ClientCertRequestHandler
 * JD-Core Version:    0.7.0.1
 */