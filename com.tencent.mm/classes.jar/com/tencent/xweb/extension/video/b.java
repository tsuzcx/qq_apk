package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.u;

public abstract interface b
  extends u
{
  public abstract void Em(boolean paramBoolean);
  
  public abstract void bk(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void eJ(Object paramObject);
  
  public abstract boolean eK(Object paramObject);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.extension.video.b
 * JD-Core Version:    0.7.0.1
 */