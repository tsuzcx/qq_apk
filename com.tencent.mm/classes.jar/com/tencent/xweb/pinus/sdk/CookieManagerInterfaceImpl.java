package com.tencent.xweb.pinus.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.ReflectMethod;

public class CookieManagerInterfaceImpl
  implements CookieManagerInterface
{
  private static final String TAG = "CookieManagerInterfaceImpl";
  private ReflectMethod acceptCookieMethod;
  private ReflectMethod allowFileSchemeCookiesMethod;
  private ReflectMethod flushMethod;
  private ReflectMethod getCookieStringMethod;
  private ReflectMethod hasCookiesMethod;
  private Object inner;
  private ReflectMethod removeAllCookieMethod;
  private ReflectMethod removeAllCookieValueCallbackBooleanMethod;
  private ReflectMethod removeExpiredCookieMethod;
  private ReflectMethod removeSessionCookieMethod;
  private ReflectMethod removeSessionCookieValueCallbackBooleanMethod;
  private ReflectMethod setAcceptCookiebooleanMethod;
  private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod;
  private ReflectMethod setCookieStringStringMethod;
  private ReflectMethod setCookieStringStringValueCallbackBooleanMethod;
  
  public CookieManagerInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getAcceptCookieMethod()
  {
    try
    {
      AppMethodBeat.i(213602);
      ReflectMethod localReflectMethod2 = this.acceptCookieMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "acceptCookie", new Class[0]);
        this.acceptCookieMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213602);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getAllowFileSchemeCookiesMethod()
  {
    try
    {
      AppMethodBeat.i(213610);
      ReflectMethod localReflectMethod2 = this.allowFileSchemeCookiesMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "allowFileSchemeCookies", new Class[0]);
        this.allowFileSchemeCookiesMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213610);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getFlushMethod()
  {
    try
    {
      AppMethodBeat.i(213619);
      ReflectMethod localReflectMethod2 = this.flushMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "flush", new Class[0]);
        this.flushMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213619);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetCookieStringMethod()
  {
    try
    {
      AppMethodBeat.i(213628);
      ReflectMethod localReflectMethod2 = this.getCookieStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getCookie", new Class[] { String.class });
        this.getCookieStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213628);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getHasCookiesMethod()
  {
    try
    {
      AppMethodBeat.i(213636);
      ReflectMethod localReflectMethod2 = this.hasCookiesMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "hasCookies", new Class[0]);
        this.hasCookiesMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213636);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveAllCookieMethod()
  {
    try
    {
      AppMethodBeat.i(213646);
      ReflectMethod localReflectMethod2 = this.removeAllCookieMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeAllCookie", new Class[0]);
        this.removeAllCookieMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213646);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveAllCookieValueCallbackBooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213654);
      ReflectMethod localReflectMethod2 = this.removeAllCookieValueCallbackBooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeAllCookie", new Class[] { ValueCallback.class });
        this.removeAllCookieValueCallbackBooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213654);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveExpiredCookieMethod()
  {
    try
    {
      AppMethodBeat.i(213661);
      ReflectMethod localReflectMethod2 = this.removeExpiredCookieMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeExpiredCookie", new Class[0]);
        this.removeExpiredCookieMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213661);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveSessionCookieMethod()
  {
    try
    {
      AppMethodBeat.i(213669);
      ReflectMethod localReflectMethod2 = this.removeSessionCookieMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeSessionCookie", new Class[0]);
        this.removeSessionCookieMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213669);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveSessionCookieValueCallbackBooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213679);
      ReflectMethod localReflectMethod2 = this.removeSessionCookieValueCallbackBooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeSessionCookie", new Class[] { ValueCallback.class });
        this.removeSessionCookieValueCallbackBooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213679);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAcceptCookiebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213686);
      ReflectMethod localReflectMethod2 = this.setAcceptCookiebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAcceptCookie", new Class[] { Boolean.TYPE });
        this.setAcceptCookiebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213686);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAcceptFileSchemeCookiesbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213694);
      ReflectMethod localReflectMethod2 = this.setAcceptFileSchemeCookiesbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAcceptFileSchemeCookies", new Class[] { Boolean.TYPE });
        this.setAcceptFileSchemeCookiesbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213694);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetCookieStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(213712);
      ReflectMethod localReflectMethod2 = this.setCookieStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setCookie", new Class[] { String.class, String.class });
        this.setCookieStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213712);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetCookieStringStringValueCallbackBooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213704);
      ReflectMethod localReflectMethod2 = this.setCookieStringStringValueCallbackBooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setCookie", new Class[] { String.class, String.class, ValueCallback.class });
        this.setCookieStringStringValueCallbackBooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213704);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(213727);
    try
    {
      bool = ((Boolean)getAcceptCookieMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(213727);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public boolean allowFileSchemeCookies()
  {
    AppMethodBeat.i(213734);
    try
    {
      bool = ((Boolean)getAllowFileSchemeCookiesMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(213734);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(213741);
    try
    {
      getFlushMethod().invoke(new Object[0]);
      AppMethodBeat.o(213741);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213741);
    }
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(213756);
    try
    {
      paramString = (String)getGetCookieStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(213756);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      for (;;)
      {
        handleRuntimeError(paramString);
        paramString = null;
      }
    }
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(213762);
    try
    {
      bool = ((Boolean)getHasCookiesMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(213762);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(213769);
    try
    {
      getRemoveAllCookieMethod().invoke(new Object[0]);
      AppMethodBeat.o(213769);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213769);
    }
  }
  
  public void removeAllCookie(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213779);
    try
    {
      getRemoveAllCookieValueCallbackBooleanMethod().invoke(new Object[] { paramValueCallback });
      AppMethodBeat.o(213779);
      return;
    }
    catch (UnsupportedOperationException paramValueCallback)
    {
      handleRuntimeError(paramValueCallback);
      AppMethodBeat.o(213779);
    }
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(213786);
    try
    {
      getRemoveExpiredCookieMethod().invoke(new Object[0]);
      AppMethodBeat.o(213786);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213786);
    }
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(213793);
    try
    {
      getRemoveSessionCookieMethod().invoke(new Object[0]);
      AppMethodBeat.o(213793);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213793);
    }
  }
  
  public void removeSessionCookie(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213804);
    try
    {
      getRemoveSessionCookieValueCallbackBooleanMethod().invoke(new Object[] { paramValueCallback });
      AppMethodBeat.o(213804);
      return;
    }
    catch (UnsupportedOperationException paramValueCallback)
    {
      handleRuntimeError(paramValueCallback);
      AppMethodBeat.o(213804);
    }
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(213809);
    try
    {
      getSetAcceptCookiebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(213809);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213809);
    }
  }
  
  public void setAcceptFileSchemeCookies(boolean paramBoolean)
  {
    AppMethodBeat.i(213818);
    try
    {
      getSetAcceptFileSchemeCookiesbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(213818);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(213818);
    }
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213833);
    try
    {
      getSetCookieStringStringMethod().invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(213833);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      handleRuntimeError(paramString1);
      AppMethodBeat.o(213833);
    }
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213826);
    try
    {
      getSetCookieStringStringValueCallbackBooleanMethod().invoke(new Object[] { paramString1, paramString2, paramValueCallback });
      AppMethodBeat.o(213826);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      handleRuntimeError(paramString1);
      AppMethodBeat.o(213826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.CookieManagerInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */