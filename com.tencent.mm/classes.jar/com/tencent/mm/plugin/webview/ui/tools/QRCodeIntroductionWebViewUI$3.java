package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.base.h.c;

final class QRCodeIntroductionWebViewUI$3
  implements h.c
{
  QRCodeIntroductionWebViewUI$3(QRCodeIntroductionWebViewUI paramQRCodeIntroductionWebViewUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.rlJ.rbk.cgc();
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.rlJ.caV()));
    this.rlJ.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */