package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class o
{
  static void KZ(int paramInt)
  {
    AppMethodBeat.i(80452);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80452);
      return;
      if (g.E(a.class) != null)
      {
        ((a)g.E(a.class)).dcS();
        AppMethodBeat.o(80452);
        return;
      }
      ab.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
      AppMethodBeat.o(80452);
      return;
      if (g.E(a.class) != null)
      {
        ((a)g.E(a.class)).dcT();
        AppMethodBeat.o(80452);
        return;
      }
      ab.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
    }
  }
  
  public static void La(int paramInt)
  {
    AppMethodBeat.i(80453);
    if (ah.brt())
    {
      ab.i("MicroMsg.WebViewBagService", "in mm process op:%d", new Object[] { Integer.valueOf(paramInt) });
      KZ(paramInt);
      AppMethodBeat.o(80453);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), o.a.class, new o.1());
    AppMethodBeat.o(80453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.o
 * JD-Core Version:    0.7.0.1
 */