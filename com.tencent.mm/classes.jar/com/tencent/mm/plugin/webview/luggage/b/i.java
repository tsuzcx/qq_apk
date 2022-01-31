package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.ui.base.l;

public final class i
  extends a
{
  public i()
  {
    super(31);
  }
  
  public final void a(Context paramContext, e parame)
  {
    if (!parame.rbH.isShown())
    {
      parame.rbH.reset();
      parame.rbH.cgS();
      parame.rbH.show();
    }
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    paraml.a(31, paramContext.getString(R.l.wv_search_content), R.k.bottomsheet_icon_search);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */