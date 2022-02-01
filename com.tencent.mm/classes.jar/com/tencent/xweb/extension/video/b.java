package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.u;

public abstract interface b
  extends u
{
  public abstract void aT(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void ex(Object paramObject);
  
  public abstract boolean ey(Object paramObject);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
  
  public abstract void yW(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.b
 * JD-Core Version:    0.7.0.1
 */