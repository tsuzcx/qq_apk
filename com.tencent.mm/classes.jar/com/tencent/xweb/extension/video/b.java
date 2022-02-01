package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.t;

public abstract interface b
  extends t
{
  public abstract void aP(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void ev(Object paramObject);
  
  public abstract boolean ew(Object paramObject);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void xF(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.b
 * JD-Core Version:    0.7.0.1
 */