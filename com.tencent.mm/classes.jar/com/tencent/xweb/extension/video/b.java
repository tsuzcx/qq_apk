package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.u;

public abstract interface b
  extends u
{
  public abstract void IO(boolean paramBoolean);
  
  public abstract void a(Activity paramActivity, View paramView1, View paramView2, Context paramContext, String paramString);
  
  public abstract void bu(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void eP(Object paramObject);
  
  public abstract boolean eQ(Object paramObject);
  
  public abstract void onHideCustomView();
  
  public abstract void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.b
 * JD-Core Version:    0.7.0.1
 */