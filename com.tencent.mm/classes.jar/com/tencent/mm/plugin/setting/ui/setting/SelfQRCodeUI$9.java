package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;

final class SelfQRCodeUI$9
  implements DialogInterface.OnCancelListener
{
  SelfQRCodeUI$9(SelfQRCodeUI paramSelfQRCodeUI, m paramm) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154169);
    g.Rc().a(this.ckS);
    if ((t.nI(SelfQRCodeUI.d(this.qGz))) || (f.rX(SelfQRCodeUI.d(this.qGz)))) {
      this.qGz.finish();
    }
    AppMethodBeat.o(154169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */