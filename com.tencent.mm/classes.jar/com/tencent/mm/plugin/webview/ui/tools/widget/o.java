package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class o
{
  static void Dg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (g.r(a.class) != null)
      {
        ((a)g.r(a.class)).ccW();
        return;
      }
      y.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
      return;
    }
    if (g.r(a.class) != null)
    {
      ((a)g.r(a.class)).ccX();
      return;
    }
    y.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
  }
  
  public static void Dh(int paramInt)
  {
    if (ae.cqV())
    {
      y.i("MicroMsg.WebViewBagService", "in mm process op:%d", new Object[] { Integer.valueOf(paramInt) });
      Dg(paramInt);
      return;
    }
    XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), o.a.class, new o.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.o
 * JD-Core Version:    0.7.0.1
 */