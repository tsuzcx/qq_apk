package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.ui.base.l;

public final class f
  extends a
{
  public f()
  {
    super(35);
  }
  
  public final void a(Context paramContext, e parame)
  {
    paramContext = parame.cba();
    if (paramContext != null)
    {
      if (!paramContext.ceZ()) {
        paramContext.lo(false);
      }
    }
    else {
      return;
    }
    paramContext.lo(true);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    h localh = parame.cba();
    if ((parame.caZ()) && (localh != null))
    {
      if (!localh.ceZ()) {
        paraml.a(35, paramContext.getString(R.l.readerapp_minimize), R.k.bottomsheet_icon_webview_minimize);
      }
    }
    else {
      return;
    }
    paraml.a(35, paramContext.getString(R.l.readerapp_cancel_minimize), R.k.bottomsheet_icon_webview_cancel_minimize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */