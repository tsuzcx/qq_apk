package com.tencent.xweb.sys;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import java.util.HashMap;

public final class e$b
{
  HashMap<String, ValueCallback<String>> xka = new HashMap();
  int xkb = 0;
  
  @JavascriptInterface
  public final void notifyJava(String paramString1, String paramString2)
  {
    ValueCallback localValueCallback = (ValueCallback)this.xka.get(paramString1);
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(paramString2);
      this.xka.remove(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.e.b
 * JD-Core Version:    0.7.0.1
 */