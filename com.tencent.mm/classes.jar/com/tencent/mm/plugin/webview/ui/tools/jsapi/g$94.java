package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class g$94
  implements Runnable
{
  g$94(g paramg, i parami) {}
  
  public final void run()
  {
    h.a(g.i(this.rzi), g.i(this.rzi).getString(R.l.nfc_mmsetting_off_title), "", g.i(this.rzi).getString(R.l.nfc_open_title), g.i(this.rzi).getString(R.l.app_cancel), new g.94.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a(g.94.this.rzi, g.94.this.rzk, "nfcCheckState:nfc_wechat_setting_off", null);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.94
 * JD-Core Version:    0.7.0.1
 */