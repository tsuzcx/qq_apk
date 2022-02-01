package com.tencent.xweb.internal;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.o;

public abstract interface e
{
  public abstract boolean a(String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, o paramo);
  
  public abstract boolean b(String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void y(String paramString, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.e
 * JD-Core Version:    0.7.0.1
 */