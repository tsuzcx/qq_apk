package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;

public final class c
  extends a
{
  public c()
  {
    super(6);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78684);
    Object localObject = paramf.eAs().aCl(paramf.getUrl());
    if (bs.isNullOrNil((String)localObject)) {}
    for (paramf = paramf.getUrl();; paramf = (f)localObject)
    {
      localObject = (ClipboardManager)ai.getContext().getSystemService("clipboard");
      if (localObject != null) {}
      try
      {
        ((ClipboardManager)localObject).setText(paramf);
        Toast.makeText(paramContext, paramContext.getString(2131766248), 0).show();
        h.wUl.dB(982, 0);
        AppMethodBeat.o(78684);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", paramContext, "clip.setText error", new Object[0]);
        }
      }
    }
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78683);
    if (paramf.Gi(44)) {
      paraml.a(6, paramContext.getString(2131766247), 2131689800);
    }
    AppMethodBeat.o(78683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */