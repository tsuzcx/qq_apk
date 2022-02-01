package com.tencent.smtt.export.external.easel.interfaces;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;

public abstract interface IEaselView
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void destroy();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void evaluateJavascript(String paramString1, ValueCallback<String> paramValueCallback, String paramString2);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void pause();
  
  public abstract void removeJavascriptInterface(String paramString);
  
  public abstract void resume();
  
  public abstract void setEaselViewClient(IEaselViewClient paramIEaselViewClient);
  
  public abstract void takeScreenshot(ValueCallback<Bitmap> paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.easel.interfaces.IEaselView
 * JD-Core Version:    0.7.0.1
 */