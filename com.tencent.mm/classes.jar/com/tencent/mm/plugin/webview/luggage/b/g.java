package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class g
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a uSO;
  
  public g()
  {
    super(7);
    AppMethodBeat.i(6435);
    this.uSO = new com.tencent.mm.plugin.webview.modeltools.a();
    AppMethodBeat.o(6435);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6437);
    String str2 = parame.dba().agU(parame.getUrl());
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = parame.getUrl();
    }
    if ((paramContext instanceof Activity)) {
      com.tencent.mm.plugin.webview.modeltools.a.g((Activity)paramContext, str1);
    }
    h.qsU.cT(982, 6);
    AppMethodBeat.o(6437);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6436);
    paraml.a(7, paramContext.getString(2131306004), 2131231004);
    AppMethodBeat.o(6436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */