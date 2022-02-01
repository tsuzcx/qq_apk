package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class o
  extends n
{
  private g Xqc = null;
  private p Xqd = null;
  
  public o(MMWebView paramMMWebView, boolean paramBoolean, g paramg)
  {
    this(paramMMWebView, paramBoolean, paramg, null);
  }
  
  public o(MMWebView paramMMWebView, boolean paramBoolean, g paramg, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.Xqc = paramg;
  }
  
  protected final boolean Kw(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.Xqc != null) && ((this.Xqc instanceof h)))
    {
      bool = ((h)this.Xqc).Kw(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.Kw(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.Xqc instanceof h)) {
      ((h)this.Xqc).bEk();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final p cxM()
  {
    AppMethodBeat.i(82231);
    if (this.Xqd == null) {
      this.Xqd = new p()
      {
        public final void aF(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((o.a(o.this) instanceof h)) && (((h)o.a(o.this)).bEj()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.aF(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (o.a(o.this) != null)
          {
            bool = o.a(o.this).i(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.i(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    p localp = this.Xqd;
    AppMethodBeat.o(82231);
    return localp;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.Xqc instanceof h)) {
      ((h)this.Xqc).c((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.o
 * JD-Core Version:    0.7.0.1
 */