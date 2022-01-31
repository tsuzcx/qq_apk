package com.tencent.xweb.x5;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

public final class g$c
  implements WebChromeClient.CustomViewCallback
{
  IX5WebChromeClient.CustomViewCallback xkt;
  
  g$c(IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.xkt = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    this.xkt.onCustomViewHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.c
 * JD-Core Version:    0.7.0.1
 */