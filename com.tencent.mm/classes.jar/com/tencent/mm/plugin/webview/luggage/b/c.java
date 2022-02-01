package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

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
    String str2 = paramg.gbF().aZj(paramg.getUrl());
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramg.getUrl();
    }
    ClipboardHelper.setText(str1);
    Toast.makeText(paramContext, paramContext.getString(2131768759), 0).show();
    h.CyF.dN(982, 0);
    AppMethodBeat.o(78684);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78683);
    if (paramg.Oc(44)) {
      paramm.b(6, paramContext.getString(2131768758), 2131689812);
    }
    AppMethodBeat.o(78683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */