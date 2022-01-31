package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.MMWebView;

public final class h
  extends a
{
  public h()
  {
    super(28);
  }
  
  public final void a(Context paramContext, e parame)
  {
    if (parame.rbA != null) {
      parame.rbA.reload();
    }
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    paraml.a(28, paramContext.getString(R.l.webview_bottomsheet_refresh), R.k.bottomsheet_icon_refresh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */