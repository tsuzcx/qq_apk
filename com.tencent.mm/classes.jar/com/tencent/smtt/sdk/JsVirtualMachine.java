package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context a;
  private final IX5JsVirtualMachine b;
  private final HashSet<WeakReference<a>> c;
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(55060);
    this.c = new HashSet();
    this.a = paramContext;
    this.b = X5JsCore.a(paramContext, paramLooper);
    AppMethodBeat.o(55060);
  }
  
  protected final IX5JsContext a()
  {
    AppMethodBeat.i(55061);
    Object localObject;
    if (this.b == null)
    {
      localObject = new a(this.a);
      this.c.add(new WeakReference(localObject));
    }
    for (;;)
    {
      AppMethodBeat.o(55061);
      return localObject;
      localObject = this.b.createJsContext();
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55062);
    if (this.b != null)
    {
      this.b.destroy();
      AppMethodBeat.o(55062);
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).destroy();
      }
    }
    AppMethodBeat.o(55062);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(55063);
    if (this.b != null)
    {
      localLooper = this.b.getLooper();
      AppMethodBeat.o(55063);
      return localLooper;
    }
    Looper localLooper = Looper.myLooper();
    AppMethodBeat.o(55063);
    return localLooper;
  }
  
  public final boolean isFallback()
  {
    return this.b == null;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55064);
    if (this.b != null)
    {
      this.b.onPause();
      AppMethodBeat.o(55064);
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).a();
      }
    }
    AppMethodBeat.o(55064);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55065);
    if (this.b != null)
    {
      this.b.onResume();
      AppMethodBeat.o(55065);
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((a)localWeakReference.get()).b();
      }
    }
    AppMethodBeat.o(55065);
  }
  
  static class a
    implements IX5JsContext
  {
    private WebView a;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(54487);
      this.a = new WebView(paramContext);
      this.a.getSettings().setJavaScriptEnabled(true);
      AppMethodBeat.o(54487);
    }
    
    public void a()
    {
      AppMethodBeat.i(54488);
      if (this.a == null)
      {
        AppMethodBeat.o(54488);
        return;
      }
      this.a.onPause();
      AppMethodBeat.o(54488);
    }
    
    public void addJavascriptInterface(Object paramObject, String paramString)
    {
      AppMethodBeat.i(54490);
      if (this.a == null)
      {
        AppMethodBeat.o(54490);
        return;
      }
      this.a.addJavascriptInterface(paramObject, paramString);
      this.a.loadUrl("about:blank");
      AppMethodBeat.o(54490);
    }
    
    public void b()
    {
      AppMethodBeat.i(54489);
      if (this.a == null)
      {
        AppMethodBeat.o(54489);
        return;
      }
      this.a.onResume();
      AppMethodBeat.o(54489);
    }
    
    public void destroy()
    {
      AppMethodBeat.i(54491);
      if (this.a == null)
      {
        AppMethodBeat.o(54491);
        return;
      }
      this.a.clearHistory();
      this.a.clearCache(true);
      this.a.loadUrl("about:blank");
      this.a.freeMemory();
      this.a.pauseTimers();
      this.a.destroy();
      this.a = null;
      AppMethodBeat.o(54491);
    }
    
    public void evaluateJavascript(String paramString, final android.webkit.ValueCallback<String> paramValueCallback, URL paramURL)
    {
      AppMethodBeat.i(54492);
      if (this.a == null)
      {
        AppMethodBeat.o(54492);
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void a(String paramAnonymousString)
            {
              AppMethodBeat.i(54496);
              paramValueCallback.onReceiveValue(paramAnonymousString);
              AppMethodBeat.o(54496);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(54492);
        return;
      }
    }
    
    public IX5JsValue evaluateScript(String paramString, URL paramURL)
    {
      AppMethodBeat.i(54493);
      if (this.a == null)
      {
        AppMethodBeat.o(54493);
        return null;
      }
      this.a.evaluateJavascript(paramString, null);
      AppMethodBeat.o(54493);
      return null;
    }
    
    public void evaluateScriptAsync(String paramString, final android.webkit.ValueCallback<IX5JsValue> paramValueCallback, URL paramURL)
    {
      AppMethodBeat.i(54494);
      if (this.a == null)
      {
        AppMethodBeat.o(54494);
        return;
      }
      paramURL = this.a;
      if (paramValueCallback == null) {}
      for (paramValueCallback = null;; paramValueCallback = new ValueCallback()
          {
            public void a(String paramAnonymousString)
            {
              AppMethodBeat.i(54385);
              paramValueCallback.onReceiveValue(null);
              AppMethodBeat.o(54385);
            }
          })
      {
        paramURL.evaluateJavascript(paramString, paramValueCallback);
        AppMethodBeat.o(54494);
        return;
      }
    }
    
    public byte[] getNativeBuffer(int paramInt)
    {
      return null;
    }
    
    public int getNativeBufferId()
    {
      return -1;
    }
    
    public void removeJavascriptInterface(String paramString)
    {
      AppMethodBeat.i(54495);
      if (this.a == null)
      {
        AppMethodBeat.o(54495);
        return;
      }
      this.a.removeJavascriptInterface(paramString);
      AppMethodBeat.o(54495);
    }
    
    public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> paramValueCallback) {}
    
    public void setName(String paramString) {}
    
    public int setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
    {
      return -1;
    }
    
    public void setPerContextData(Object paramObject) {}
    
    public void stealValueFromOtherCtx(String paramString1, IX5JsContext paramIX5JsContext, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */