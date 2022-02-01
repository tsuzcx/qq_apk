package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;

public final class c
  extends a
{
  public c()
  {
    super(6);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78684);
    Object localObject = paramg.ePi().aHL(paramg.getUrl());
    if (bt.isNullOrNil((String)localObject)) {}
    for (paramg = paramg.getUrl();; paramg = (com.tencent.mm.plugin.webview.luggage.g)localObject)
    {
      localObject = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      if (localObject != null) {}
      try
      {
        ((ClipboardManager)localObject).setText(paramg);
        Toast.makeText(paramContext, paramContext.getString(2131766248), 0).show();
        com.tencent.mm.plugin.report.service.g.yhR.dD(982, 0);
        AppMethodBeat.o(78684);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", paramContext, "clip.setText error", new Object[0]);
        }
      }
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78683);
    if (paramg.HC(44)) {
      paraml.a(6, paramContext.getString(2131766247), 2131689800);
    }
    AppMethodBeat.o(78683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */