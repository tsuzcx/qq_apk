package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;

final class SnsPermissionUI$2
  implements DialogInterface.OnCancelListener
{
  SnsPermissionUI$2(SnsPermissionUI paramSnsPermissionUI, w paramw) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39176);
    SnsPermissionUI.a(this.rUk);
    g.RM();
    g.RK().eHt.a(this.rUl);
    AppMethodBeat.o(39176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI.2
 * JD-Core Version:    0.7.0.1
 */