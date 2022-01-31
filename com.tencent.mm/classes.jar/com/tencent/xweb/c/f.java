package com.tencent.xweb.c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.i;
import com.tencent.xweb.j;

public abstract interface f
{
  public abstract boolean a(String paramString1, String paramString2, j paramj);
  
  public abstract boolean a(String paramString1, String paramString2, String paramString3, i parami);
  
  public abstract boolean b(String paramString1, String paramString2, j paramj);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void w(String paramString, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.c.f
 * JD-Core Version:    0.7.0.1
 */