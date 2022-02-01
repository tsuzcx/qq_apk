package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.ui.base.l;

public final class g
  extends a
{
  public g()
  {
    super(27);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78695);
    if ((!paramf.ekR()) && (!paramf.bZZ.Bb().AU())) {
      ((Activity)paramf.mContext).finish();
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(982, 11);
    AppMethodBeat.o(78695);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78694);
    if (paramf.isFullScreen()) {
      paraml.a(27, paramContext.getString(2131762172), 2131689806);
    }
    AppMethodBeat.o(78694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */