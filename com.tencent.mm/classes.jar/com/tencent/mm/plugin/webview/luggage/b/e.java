package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;

public final class e
  extends a
{
  public e()
  {
    super(27);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame)
  {
    AppMethodBeat.i(6432);
    if ((!parame.daU()) && (!parame.byJ.un().ug())) {
      ((Activity)parame.mContext).finish();
    }
    com.tencent.mm.plugin.report.service.h.qsU.cT(982, 11);
    AppMethodBeat.o(6432);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, l paraml)
  {
    AppMethodBeat.i(6431);
    if (parame.isFullScreen()) {
      paraml.a(27, paramContext.getString(2131302291), 2131231013);
    }
    AppMethodBeat.o(6431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */