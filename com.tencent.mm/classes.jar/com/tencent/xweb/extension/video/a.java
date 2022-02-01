package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.w;

public abstract interface a
  extends w
{
  public abstract void OV(boolean paramBoolean);
  
  public abstract void bV(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void hm(Object paramObject);
  
  public abstract boolean hn(Object paramObject);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.a
 * JD-Core Version:    0.7.0.1
 */