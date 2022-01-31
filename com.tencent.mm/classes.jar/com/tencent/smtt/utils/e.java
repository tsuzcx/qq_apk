package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;

class e
  implements d.a
{
  e(d paramd, WebView paramWebView, Context paramContext, RelativeLayout paramRelativeLayout, String paramString, TextView paramTextView) {}
  
  public void a()
  {
    this.a.post(new f(this));
  }
  
  public void a(int paramInt)
  {
    this.a.post(new g(this, paramInt));
  }
  
  public void a(Throwable paramThrowable)
  {
    this.a.post(new h(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */