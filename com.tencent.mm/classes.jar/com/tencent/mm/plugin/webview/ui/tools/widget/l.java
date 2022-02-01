package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l
  extends k
{
  private d Qxi = null;
  private m Qxj = null;
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd)
  {
    this(paramMMWebView, paramBoolean, paramd, null);
  }
  
  public l(MMWebView paramMMWebView, boolean paramBoolean, d paramd, Bundle paramBundle)
  {
    super(paramMMWebView, paramBoolean, paramBundle);
    this.Qxi = paramd;
  }
  
  protected final boolean Su(String paramString)
  {
    AppMethodBeat.i(82234);
    if ((this.Qxi != null) && ((this.Qxi instanceof e)))
    {
      bool = ((e)this.Qxi).Su(paramString);
      AppMethodBeat.o(82234);
      return bool;
    }
    boolean bool = super.Su(paramString);
    AppMethodBeat.o(82234);
    return bool;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(82232);
    super.a(paramWebView, paramString, paramBitmap);
    if ((this.Qxi instanceof e)) {
      ((e)this.Qxi).bgs();
    }
    AppMethodBeat.o(82232);
  }
  
  protected final m bXB()
  {
    AppMethodBeat.i(82231);
    if (this.Qxj == null) {
      this.Qxj = new m()
      {
        public final void aI(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82230);
          if (((l.a(l.this) instanceof e)) && (((e)l.a(l.this)).bgr()))
          {
            AppMethodBeat.o(82230);
            return;
          }
          super.aI(paramAnonymousBundle);
          AppMethodBeat.o(82230);
        }
        
        public final boolean h(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(82229);
          if (l.a(l.this) != null)
          {
            bool = l.a(l.this).h(paramAnonymousInt, paramAnonymousBundle);
            AppMethodBeat.o(82229);
            return bool;
          }
          boolean bool = super.h(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(82229);
          return bool;
        }
      };
    }
    m localm = this.Qxj;
    AppMethodBeat.o(82231);
    return localm;
  }
  
  protected final void f(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(82233);
    super.f(paramWebView, paramString);
    if ((this.Qxi instanceof e)) {
      ((e)this.Qxi).c((MMWebView)paramWebView);
    }
    AppMethodBeat.o(82233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.l
 * JD-Core Version:    0.7.0.1
 */