package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d EqQ = null;
  private m EqR = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.EqQ = paramd;
  }
  
  protected final boolean BO(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.EqQ != null) && ((this.EqQ instanceof e)))
    {
      bool = ((e)this.EqQ).BO(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.BO(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.EqQ instanceof e)) {
      ((e)this.EqQ).aDj();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m bpl()
  {
    AppMethodBeat.i(82231);
    if (this.EqR == null) {
      this.EqR = new m()
      {
        public final void az(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.this.EqQ instanceof e)) && (((e)l.this.EqQ).aDi()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.az(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.this.EqQ != null)
          {
            bool = l.this.EqQ.g(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.g(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.EqR;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.EqQ instanceof e)) {
      ((e)this.EqQ).c((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */