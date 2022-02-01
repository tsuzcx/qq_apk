package com.tencent.xweb.pinus.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectConstructor;

public class CookieManager
  implements CookieManagerInterface
{
  private static final String TAG = "CookieManager";
  private static CookieManager sInstance;
  private static final Object sInstanceLock;
  private PSCoreWrapper coreWrapper;
  private Object inner;
  private CookieManagerInterface reflectInterface;
  
  static
  {
    AppMethodBeat.i(213377);
    sInstanceLock = new Object();
    AppMethodBeat.o(213377);
  }
  
  private CookieManager()
  {
    AppMethodBeat.i(213355);
    init();
    AppMethodBeat.o(213355);
  }
  
  public static CookieManager getInstance()
  {
    AppMethodBeat.i(213349);
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new CookieManager();
      }
      CookieManager localCookieManager = sInstance;
      AppMethodBeat.o(213349);
      return localCookieManager;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(213368);
    this.coreWrapper = PSCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      AppMethodBeat.o(213368);
      return;
    }
    ReflectConstructor localReflectConstructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("CookieManager"), new Class[0]);
    try
    {
      this.inner = localReflectConstructor.newInstance(new Object[0]);
      this.reflectInterface = new CookieManagerInterfaceImpl(this.inner);
      AppMethodBeat.o(213368);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Log.e("CookieManager", "init error:".concat(String.valueOf(localUnsupportedOperationException)));
      AppMethodBeat.o(213368);
    }
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(213387);
    boolean bool = this.reflectInterface.acceptCookie();
    AppMethodBeat.o(213387);
    return bool;
  }
  
  public boolean allowFileSchemeCookies()
  {
    AppMethodBeat.i(213397);
    boolean bool = this.reflectInterface.allowFileSchemeCookies();
    AppMethodBeat.o(213397);
    return bool;
  }
  
  public void flush()
  {
    AppMethodBeat.i(213403);
    this.reflectInterface.flush();
    AppMethodBeat.o(213403);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(213409);
    paramString = this.reflectInterface.getCookie(paramString);
    AppMethodBeat.o(213409);
    return paramString;
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(213418);
    boolean bool = this.reflectInterface.hasCookies();
    AppMethodBeat.o(213418);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(213424);
    this.reflectInterface.removeAllCookie();
    AppMethodBeat.o(213424);
  }
  
  public void removeAllCookie(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213429);
    this.reflectInterface.removeAllCookie(paramValueCallback);
    AppMethodBeat.o(213429);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(213434);
    this.reflectInterface.removeExpiredCookie();
    AppMethodBeat.o(213434);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(213440);
    this.reflectInterface.removeSessionCookie();
    AppMethodBeat.o(213440);
  }
  
  public void removeSessionCookie(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213446);
    this.reflectInterface.removeSessionCookie(paramValueCallback);
    AppMethodBeat.o(213446);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(213452);
    this.reflectInterface.setAcceptCookie(paramBoolean);
    AppMethodBeat.o(213452);
  }
  
  public void setAcceptFileSchemeCookies(boolean paramBoolean)
  {
    AppMethodBeat.i(213458);
    this.reflectInterface.setAcceptFileSchemeCookies(paramBoolean);
    AppMethodBeat.o(213458);
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213476);
    this.reflectInterface.setCookie(paramString1, paramString2);
    AppMethodBeat.o(213476);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(213468);
    this.reflectInterface.setCookie(paramString1, paramString2, paramValueCallback);
    AppMethodBeat.o(213468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */