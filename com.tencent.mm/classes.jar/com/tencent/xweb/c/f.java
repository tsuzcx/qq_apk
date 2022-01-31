package com.tencent.xweb.c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.e;

public abstract interface f
{
  public abstract boolean a(String paramString1, String paramString2, com.tencent.xweb.f paramf);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, e parame);
  
  public abstract boolean b(String paramString1, String paramString2, com.tencent.xweb.f paramf);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void u(String paramString, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.c.f
 * JD-Core Version:    0.7.0.1
 */