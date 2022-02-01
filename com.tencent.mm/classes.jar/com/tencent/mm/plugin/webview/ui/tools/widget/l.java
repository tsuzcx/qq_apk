package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d BuH = null;
  private m BuI = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.BuH = paramd;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.BuH instanceof e)) {
      ((e)this.BuH).atp();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m beG()
  {
    AppMethodBeat.i(82231);
    if (this.BuI == null) {
      this.BuI = new m()
      {
        public final void ay(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.this.BuH instanceof e)) && (((e)l.this.BuH).ato()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.ay(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.this.BuH != null)
          {
            bool = l.this.BuH.f(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.f(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.BuI;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.BuH instanceof e)) {
      ((e)this.BuH).b((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
  
  protected final boolean uJ(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.BuH != null) && ((this.BuH instanceof e)))
    {
      bool = ((e)this.BuH).uJ(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.uJ(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */