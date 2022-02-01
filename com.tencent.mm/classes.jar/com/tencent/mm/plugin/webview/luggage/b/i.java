package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class i
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a IVh;
  
  public i()
  {
    super(7);
    AppMethodBeat.i(78698);
    this.IVh = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(78698);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78700);
    String str2 = paramg.gbF().aZj(paramg.getUrl());
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramg.getUrl();
    }
    if ((paramContext instanceof Activity)) {
      this.IVh.c((Activity)paramContext, str1);
    }
    h.CyF.dN(982, 6);
    AppMethodBeat.o(78700);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78699);
    paramm.b(7, paramContext.getString(2131768763), 2131689809);
    AppMethodBeat.o(78699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */