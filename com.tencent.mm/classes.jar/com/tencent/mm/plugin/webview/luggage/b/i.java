package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;

public final class i
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a AUE;
  
  public i()
  {
    super(7);
    AppMethodBeat.i(78698);
    this.AUE = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(78698);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78700);
    String str2 = paramf.ekW().awT(paramf.getUrl());
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramf.getUrl();
    }
    if ((paramContext instanceof Activity)) {
      com.tencent.mm.plugin.webview.modeltools.a.h((Activity)paramContext, str1);
    }
    h.vKh.dB(982, 6);
    AppMethodBeat.o(78700);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78699);
    paraml.a(7, paramContext.getString(2131766252), 2131689797);
    AppMethodBeat.o(78699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */