package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;

public final class c
  extends a
{
  public c()
  {
    super(6);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78684);
    String str2 = paramg.iuj().bkG(paramg.getUrl());
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramg.getUrl();
    }
    ClipboardHelper.setText(str1);
    Toast.makeText(paramContext, paramContext.getString(c.i.wv_alert_copy_link_toast), 0).show();
    h.OAn.kJ(982, 0);
    AppMethodBeat.o(78684);
  }
  
  public final void a(Context paramContext, g paramg, s params)
  {
    AppMethodBeat.i(78683);
    if (paramg.Xp(44)) {
      params.a(6, paramContext.getString(c.i.wv_alert_copy_link), c.h.icons_outlined_link);
    }
    AppMethodBeat.o(78683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */