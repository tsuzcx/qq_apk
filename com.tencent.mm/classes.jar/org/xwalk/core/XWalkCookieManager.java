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
    AppMethodBeat.i(154642);
    if (!XWalkCookieManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154642);
      return;
    }
  }
  
  public XWalkCookieManager()
  {
    AppMethodBeat.i(154629);
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
    AppMethodBeat.o(154629);
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(154641);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(154641);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
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
      label133:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label133;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(154641);
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
      AppMethodBeat.o(154641);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("XWalkCookieManager", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(154641);
    }
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(154631);
    try
    {
      boolean bool = ((Boolean)this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154631);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154631);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154631);
    }
    return false;
  }
  
  public boolean allowFileSchemeCookies()
  {
    AppMethodBeat.i(154639);
    try
    {
      boolean bool = ((Boolean)this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154639);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154639);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154639);
    }
    return false;
  }
  
  public void flushCookieStore()
  {
    AppMethodBeat.i(154638);
    try
    {
      this.flushCookieStoreMethod.invoke(new Object[0]);
      AppMethodBeat.o(154638);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154638);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154638);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(154633);
    try
    {
      String str = new WebAddress(paramString).toString();
      paramString = str;
      return null;
    }
    finally
    {
      for (;;)
      {
        try
        {
          paramString = (String)this.getCookieStringMethod.invoke(new Object[] { paramString });
          AppMethodBeat.o(154633);
          return paramString;
        }
        catch (UnsupportedOperationException paramString)
        {
          if (this.coreWrapper != null) {
            continue;
          }
          paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
          AppMethodBeat.o(154633);
          throw paramString;
          XWalkCoreWrapper.handleRuntimeError(paramString);
          AppMethodBeat.o(154633);
        }
        localObject = finally;
        Log.e("XWalkCookieManager", "getCookie transform url to WebAddress failed, error:".concat(String.valueOf(localObject)));
      }
    }
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(154636);
    try
    {
      boolean bool = ((Boolean)this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154636);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154636);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154636);
    }
    return false;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(154635);
    try
    {
      this.removeAllCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(154635);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154635);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154635);
    }
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(154637);
    try
    {
      this.removeExpiredCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(154637);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154637);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154637);
    }
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(154634);
    try
    {
      this.removeSessionCookieMethod.invoke(new Object[0]);
      AppMethodBeat.o(154634);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154634);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154634);
    }
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(154630);
    try
    {
      this.setAcceptCookiebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154630);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154630);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154630);
    }
  }
  
  public void setAcceptFileSchemeCookies(boolean paramBoolean)
  {
    AppMethodBeat.i(154640);
    try
    {
      this.setAcceptFileSchemeCookiesbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154640);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154640);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154640);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154632);
    try
    {
      String str = new WebAddress(paramString1).toString();
      paramString1 = str;
      return;
    }
    finally
    {
      for (;;)
      {
        try
        {
          this.setCookieStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
          AppMethodBeat.o(154632);
          return;
        }
        catch (UnsupportedOperationException paramString1)
        {
          if (this.coreWrapper != null) {
            continue;
          }
          paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
          AppMethodBeat.o(154632);
          throw paramString1;
          XWalkCoreWrapper.handleRuntimeError(paramString1);
          AppMethodBeat.o(154632);
        }
        localObject = finally;
        Log.e("XWalkCookieManager", "setCookie transform url to WebAddress failed, error:".concat(String.valueOf(localObject)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkCookieManager
 * JD-Core Version:    0.7.0.1
 */