package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.au;

final class SelfQRCodeUI$13
  implements DialogInterface.OnCancelListener
{
  SelfQRCodeUI$13(SelfQRCodeUI paramSelfQRCodeUI, p paramp) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(299013);
    h.aZW().a(this.hxO);
    if ((au.bwE(SelfQRCodeUI.e(this.PpF))) || (g.MB(SelfQRCodeUI.e(this.PpF)))) {
      this.PpF.finish();
    }
    AppMethodBeat.o(299013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.13
 * JD-Core Version:    0.7.0.1
 */