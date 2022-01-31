package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
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
    AppMethodBeat.i(6441);
    if (!parame.uRq.isShown())
    {
      parame.uRq.reset();
      parame.uRq.dgZ();
      parame.uRq.show();
    }
    h.qsU.cT(982, 8);
    AppMethodBeat.o(6441);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6440);
    paraml.a(31, paramContext.getString(2131306034), 2131231034);
    AppMethodBeat.o(6440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */