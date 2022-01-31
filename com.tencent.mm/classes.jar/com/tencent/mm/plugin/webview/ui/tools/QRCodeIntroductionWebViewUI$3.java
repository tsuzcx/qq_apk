package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.base.h.c;

final class QRCodeIntroductionWebViewUI$3
  implements h.c
{
  QRCodeIntroductionWebViewUI$3(QRCodeIntroductionWebViewUI paramQRCodeIntroductionWebViewUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(7473);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7473);
      return;
      this.vbl.uQS.q(null);
      AppMethodBeat.o(7473);
      return;
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.vbl.daZ()));
      this.vbl.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */