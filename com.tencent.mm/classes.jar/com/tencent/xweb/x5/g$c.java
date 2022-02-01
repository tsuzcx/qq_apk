package com.tencent.xweb.x5;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

public final class g$c
  implements WebChromeClient.CustomViewCallback
{
  IX5WebChromeClient.CustomViewCallback KEt;
  
  g$c(IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.KEt = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    AppMethodBeat.i(153849);
    this.KEt.onCustomViewHidden();
    AppMethodBeat.o(153849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.c
 * JD-Core Version:    0.7.0.1
 */