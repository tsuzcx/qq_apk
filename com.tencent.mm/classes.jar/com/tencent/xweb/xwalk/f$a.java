package com.tencent.xweb.xwalk;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;

public final class f$a
  implements WebChromeClient.CustomViewCallback
{
  CustomViewCallback BJy;
  
  f$a(CustomViewCallback paramCustomViewCallback)
  {
    this.BJy = paramCustomViewCallback;
  }
  
  public final void onCustomViewHidden()
  {
    AppMethodBeat.i(85217);
    this.BJy.onCustomViewHidden();
    AppMethodBeat.o(85217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.a
 * JD-Core Version:    0.7.0.1
 */