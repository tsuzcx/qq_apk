package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d JyX = null;
  private m JyY = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.JyX = paramd;
  }
  
  protected final boolean Lb(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.JyX != null) && ((this.JyX instanceof e)))
    {
      bool = ((e)this.JyX).Lb(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.Lb(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.JyX instanceof e)) {
      ((e)this.JyX).aXl();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m bLB()
  {
    AppMethodBeat.i(82231);
    if (this.JyY == null) {
      this.JyY = new m()
      {
        public final void aM(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.this.JyX instanceof e)) && (((e)l.this.JyX).aXk()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.aM(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.this.JyX != null)
          {
            bool = l.this.JyX.f(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.f(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.JyY;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.JyX instanceof e)) {
      ((e)this.JyX).c((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */