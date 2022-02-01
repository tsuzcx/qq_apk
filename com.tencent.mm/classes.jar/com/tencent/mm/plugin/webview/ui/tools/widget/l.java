package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d EJg = null;
  private m EJh = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.EJg = paramd;
  }
  
  protected final boolean Cq(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.EJg != null) && ((this.EJg instanceof e)))
    {
      bool = ((e)this.EJg).Cq(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.Cq(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.EJg instanceof e)) {
      ((e)this.EJg).aDz();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m bpV()
  {
    AppMethodBeat.i(82231);
    if (this.EJh == null) {
      this.EJh = new m()
      {
        public final void aA(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.this.EJg instanceof e)) && (((e)l.this.EJg).aDy()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.aA(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.this.EJg != null)
          {
            bool = l.this.EJg.g(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.g(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.EJh;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.EJg instanceof e)) {
      ((e)this.EJg).c((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */