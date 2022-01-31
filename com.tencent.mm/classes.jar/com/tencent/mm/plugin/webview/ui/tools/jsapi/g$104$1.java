package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class g$104$1
  implements DialogInterface.OnClickListener
{
  g$104$1(g.104 param104) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155024);
    d.H(g.j(this.vru.vqm), "setting", ".ui.setting.SettingsAboutSystemUI");
    this.vru.vqm.a(this.vru.uZa, "nfcCheckState:nfc_wechat_setting_off", null);
    AppMethodBeat.o(155024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.104.1
 * JD-Core Version:    0.7.0.1
 */