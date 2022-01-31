package com.tencent.xweb.x5;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

public final class g$c
  implements WebChromeClient.CustomViewCallback
{
  IX5WebChromeClient.CustomViewCallback BHY;
  
  g$c(IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.BHY = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    AppMethodBeat.i(84825);
    this.BHY.onCustomViewHidden();
    AppMethodBeat.o(84825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.c
 * JD-Core Version:    0.7.0.1
 */