package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;

public final class i
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a WHU;
  
  public i()
  {
    super(7);
    AppMethodBeat.i(78698);
    this.WHU = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(78698);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78700);
    String str2 = paramg.iuj().bkG(paramg.getUrl());
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramg.getUrl();
    }
    if ((paramContext instanceof Activity)) {
      this.WHU.c((Activity)paramContext, str1);
    }
    h.OAn.kJ(982, 6);
    AppMethodBeat.o(78700);
  }
  
  public final void a(Context paramContext, g paramg, s params)
  {
    AppMethodBeat.i(78699);
    params.a(7, paramContext.getString(c.i.wv_alert_open_in_browser), c.h.bottomsheet_icon_brower, paramContext.getResources().getColor(c.c.Indigo));
    AppMethodBeat.o(78699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */