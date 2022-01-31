package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class g$95
  implements Runnable
{
  g$95(g paramg, i parami) {}
  
  public final void run()
  {
    h.a(g.i(this.rzi), g.i(this.rzi).getString(R.l.nfc_off_tips), "", g.i(this.rzi).getString(R.l.nfc_open_title), g.i(this.rzi).getString(R.l.app_cancel), new g.95.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a(g.95.this.rzi, g.95.this.rzk, "nfcCheckState:nfc_off", null);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.95
 * JD-Core Version:    0.7.0.1
 */