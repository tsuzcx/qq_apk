package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d rCy = null;
  private m rCz = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.rCy = paramd;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.rCy instanceof e)) {
      ((e)this.rCy).IQ();
    }
  }
  
  protected final m all()
  {
    if (this.rCz == null) {
      this.rCz = new l.1(this);
    }
    return this.rCz;
  }
  
  protected final void e(WebView paramWebView, String paramString)
  {
    super.e(paramWebView, paramString);
    if ((this.rCy instanceof e)) {
      ((e)this.rCy).a((MMWebView)paramWebView);
    }
  }
  
  protected final boolean jh(String paramString)
  {
    if ((this.rCy != null) && ((this.rCy instanceof e))) {
      return ((e)this.rCy).jh(paramString);
    }
    return super.jh(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */