package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class b
  extends a
{
  public b()
  {
    super(6);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6423);
    Object localObject = parame.dba().agU(parame.getUrl());
    if (bo.isNullOrNil((String)localObject)) {}
    for (parame = parame.getUrl();; parame = (e)localObject)
    {
      localObject = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      if (localObject != null) {}
      try
      {
        ((ClipboardManager)localObject).setText(parame);
        Toast.makeText(paramContext, paramContext.getString(2131306000), 0).show();
        h.qsU.cT(982, 0);
        AppMethodBeat.o(6423);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", paramContext, "clip.setText error", new Object[0]);
        }
      }
    }
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6422);
    if (parame.wZ(44)) {
      paraml.a(6, paramContext.getString(2131305999), 2131231007);
    }
    AppMethodBeat.o(6422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */