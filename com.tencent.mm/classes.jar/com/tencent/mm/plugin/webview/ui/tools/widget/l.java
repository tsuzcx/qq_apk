package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  d CMQ = null;
  private m CMR = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.CMQ = paramd;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.CMQ instanceof e)) {
      ((e)this.CMQ).aAg();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m blA()
  {
    AppMethodBeat.i(82231);
    if (this.CMR == null) {
      this.CMR = new m()
      {
        public final void aD(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.this.CMQ instanceof e)) && (((e)l.this.CMQ).aAf()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.aD(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.this.CMQ != null)
          {
            bool = l.this.CMQ.g(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.g(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.CMR;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.CMQ instanceof e)) {
      ((e)this.CMQ).b((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
  
  protected final boolean yP(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.CMQ != null) && ((this.CMQ instanceof e)))
    {
      bool = ((e)this.CMQ).yP(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.yP(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */