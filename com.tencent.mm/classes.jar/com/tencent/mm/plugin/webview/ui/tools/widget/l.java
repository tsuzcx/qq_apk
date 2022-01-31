package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d vsK = null;
  private m vsL = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.vsK = paramd;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(10024);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.vsK instanceof e)) {
      ((e)this.vsK).abN();
    }
    AppMethodBeat.o(10024);
  }
  
  protected final m aGm()
  {
    AppMethodBeat.i(10023);
    if (this.vsL == null) {
      this.vsL = new l.1(this);
    }
    m localm = this.vsL;
    AppMethodBeat.o(10023);
    return localm;
  }
  
  protected final void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(10025);
    super.e(paramWebView, paramString);
    if ((this.vsK instanceof e)) {
      ((e)this.vsK).a((MMWebView)paramWebView);
    }
    AppMethodBeat.o(10025);
  }
  
  protected final boolean pV(String paramString)
  {
    AppMethodBeat.i(10026);
    if ((this.vsK != null) && ((this.vsK instanceof e)))
    {
      bool = ((e)this.vsK).pV(paramString);
      AppMethodBeat.o(10026);
      return bool;
    }
    boolean bool = super.pV(paramString);
    AppMethodBeat.o(10026);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */