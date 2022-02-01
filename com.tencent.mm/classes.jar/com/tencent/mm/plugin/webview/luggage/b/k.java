package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.ui.base.l;

public final class k
  extends a
{
  public k()
  {
    super(31);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78704);
    if (!paramg.Egy.isShown())
    {
      paramg.Egy.reset();
      paramg.Egy.eZx();
      paramg.Egy.show();
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(982, 8);
    AppMethodBeat.o(78704);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78703);
    paraml.a(31, paramContext.getString(2131766282), 2131689827);
    AppMethodBeat.o(78703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */