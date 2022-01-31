package com.tencent.xweb.xwalk;

import android.webkit.WebChromeClient.CustomViewCallback;
import org.xwalk.core.CustomViewCallback;

public final class e$a
  implements WebChromeClient.CustomViewCallback
{
  CustomViewCallback xlQ;
  
  e$a(CustomViewCallback paramCustomViewCallback)
  {
    this.xlQ = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    this.xlQ.onCustomViewHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e.a
 * JD-Core Version:    0.7.0.1
 */