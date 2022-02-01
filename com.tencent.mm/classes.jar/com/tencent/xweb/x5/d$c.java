package com.tencent.xweb.x5;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

public final class d$c
  implements WebChromeClient.CustomViewCallback
{
  IX5WebChromeClient.CustomViewCallback ainb;
  
  d$c(IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.ainb = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    AppMethodBeat.i(153849);
    this.ainb.onCustomViewHidden();
    AppMethodBeat.o(153849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.c
 * JD-Core Version:    0.7.0.1
 */