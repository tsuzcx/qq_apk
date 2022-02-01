package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;

public final class i
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a Eim;
  
  public i()
  {
    super(7);
    AppMethodBeat.i(78698);
    this.Eim = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(78698);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78700);
    String str2 = paramg.eSU().aJe(paramg.getUrl());
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = paramg.getUrl();
    }
    if ((paramContext instanceof Activity)) {
      this.Eim.c((Activity)paramContext, str1);
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(982, 6);
    AppMethodBeat.o(78700);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
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