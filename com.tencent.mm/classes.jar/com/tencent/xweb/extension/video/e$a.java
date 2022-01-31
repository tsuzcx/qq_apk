package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import org.xwalk.core.ReflectMethod;

public final class e$a
  implements b
{
  private ReflectMethod hasEnteredFullscreenMethod;
  private ReflectMethod onHideCustomViewMethod;
  ReflectMethod xiS;
  private ReflectMethod xiT;
  private ReflectMethod xiU;
  private ReflectMethod xiV;
  private Object xiW;
  
  public e$a(Object paramObject)
  {
    this.xiW = paramObject;
    this.xiS = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
    this.xiT = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
    this.xiU = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
    this.onHideCustomViewMethod = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
    this.hasEnteredFullscreenMethod = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
    this.xiV = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xiT.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public final void cv(Object paramObject)
  {
    this.xiV.invoke(new Object[] { paramObject });
  }
  
  public final boolean hasEnteredFullscreen()
  {
    return ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
  }
  
  public final void onHideCustomView()
  {
    this.onHideCustomViewMethod.invoke(new Object[0]);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.xiU.invoke(new Object[] { paramView, paramCustomViewCallback });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.a
 * JD-Core Version:    0.7.0.1
 */