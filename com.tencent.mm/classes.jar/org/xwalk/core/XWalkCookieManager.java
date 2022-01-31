package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.xwalk.core.util.WebAddress;

public class XWalkCookieManager
{
  private static final String TAG = "XWalkCookieManager";
  private ReflectMethod acceptCookieMethod;
  private ReflectMethod allowFileSchemeCookiesMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod flushCookieStoreMethod;
  private ReflectMethod getCookieStringMethod;
  private ReflectMethod hasCookiesMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod removeAllCookieMethod;
  private ReflectMethod removeExpiredCookieMethod;
  private ReflectMethod removeSessionCookieMethod;
  private ReflectMethod setAcceptCookiebooleanMethod;
  private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod;
  private ReflectMethod setCookieStringStringMethod;
  
  static
  {
    AppMethodBeat.i(85552);
    if (!XWalkCookieManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(85552);
      return;
    }
  }
  
  public XWalkCookieManager()
  {
    AppMethodBeat.i(85539);
    this.setAcceptCookiebooleanMethod = new ReflectMethod(null, "setAcceptCookie", new Class[0]);
    this.acceptCookieMethod = new ReflectMethod(null, "acceptCookie", new Class[0]);
    this.setCookieStringStringMethod = new ReflectMethod(null, "setCookie", new Class[0]);
    this.getCookieStringMethod = new ReflectMethod(null, "getCookie", new Class[0]);
    this.removeSessionCookieMethod = new ReflectMethod(null, "removeSessionCookie", new Class[0]);
    this.removeAllCookieMethod = new ReflectMethod(null, "removeAllCookie", new Class[0]);
    this.hasCookiesMethod = new ReflectMethod(null, "hasCookies", new Class[0]);
    this.removeExpiredCookieMethod = new ReflectMethod(null, "removeExpiredCookie", new Class[0]);
    this.flushCookieStoreMethod = new ReflectMethod(null, "flushCookieStore", new Class[0]);
    this.allowFileSchemeCookiesMethod = new ReflectMethod(null, "allowFileSchemeCookies", new Class[0]);
    this.setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod(null, "setAcceptFileSchemeCookies", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorParams = new ArrayList();
    reflectionInit();
    AppMethodBeat.o(85539);
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(85541);
    try
    {
      boolean bool = ((Boolean)this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85541);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85541);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85541);
    }
    return false;
  }
  
  public boolean allowFileSchemeCookies()
  {
    AppMethodBeat.i(85549);
    try
    {
      boolean bool = ((Boolean)this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85549);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85549);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85549);
    }
    return false;
  }
  
  public void flushCookieStore()
  {
    AppMethodBeat.i(85548);
    try
    {
      this.flushCookieStoreMethod.invoke(new Object[0]);
      AppMethodBeat.o(85548);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85548);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85548);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(85543);
    try
    {
      String str = new WebAddress(paramString).toString();
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkCookieManager", "getCookie transform url to WebAddress failed");
      }
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null) {
        break label81;
      }
      paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
      AppMethodBeat.o(85543);
      throw paramString;
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85543);
    }
    paramString = (String)this.getCookieStringMethod.invoke(new Object[] { paramString });
    AppMethodBeat.o(85543);
    return paramString;
    label81:
    return null;
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(85546);
    try
    {
      boolean bool = ((Boolean)this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85546);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85546);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85546);
    }
    return false;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85551);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85551);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
      }
      label137:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label137;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(85551);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.setAcceptCookiebooleanMethod.init(this.bridge, null, "setAcceptCookieSuper", new Class[] { Boolean.TYPE });
      this.acceptCookieMethod.init(this.bridge, null, "acceptCookieSuper", new Class[0]);
      this.setCookieStringStringMethod.init(this.bridge, null, "setCookieSuper", new Class[] { String.class, String.class });
      this.getCookieStringMethod.init(this.bridge, null, "getCookieSuper", new Class[] { String.class });
      this.removeSessionCookieMethod.init(this.bridge, null, "removeSessionCookieSuper", new Class[0]);
      this.removeAllCookieMethod.init(this.bridge, null, "removeAllCookieSuper", new Class[0]);
      this.hasCookiesMethod.init(this.bridge, null, "hasCookiesSuper", new Class[0]);
      this.removeExpiredCookieMethod.init(this.bridge, null, "removeExpiredCookieSuper", new Class[0]);
      this.flushCookieStoreMethod.init(this.bridge, null, "flushCookieStoreSuper", new Class[0]);
      this.allowFileSchemeCookiesMethod.init(this.bridge, null, "allowFileSchemeCookiesSuper", new Class[0]);
      this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, null, "setAcceptFileSchemeCookiesSuper", new Class[] { Boolean.TYPE });
      AppMethodBeat.o(85551);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(85551);
    }
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(85545);
    try
    {
      this.removeAllCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(85545);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85545);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85545);
    }
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(85547);
    try
    {
      this.removeExpiredCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(85547);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85547);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85547);
    }
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(85544);
    try
    {
      this.removeSessionCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(85544);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85544);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85544);
    }
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(85540);
    try
    {
      this.setAcceptCookiebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85540);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85540);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85540);
    }
  }
  
  public void setAcceptFileSchemeCookies(boolean paramBoolean)
  {
    AppMethodBeat.i(85550);
    try
    {
      this.setAcceptFileSchemeCookiesbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85550);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85550);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85550);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85542);
    try
    {
      String str = new WebAddress(paramString1).toString();
      paramString1 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkCookieManager", "setCookie transform url to WebAddress failed");
      }
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null) {
        break label85;
      }
      paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
      AppMethodBeat.o(85542);
      throw paramString1;
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85542);
    }
    this.setCookieStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(85542);
    return;
    label85:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkCookieManager
 * JD-Core Version:    0.7.0.1
 */