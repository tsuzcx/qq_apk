package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class SnsCommentDetailUI$40$1
  implements DialogInterface.OnCancelListener
{
  SnsCommentDetailUI$40$1(SnsCommentDetailUI.40 param40, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(38825);
    g.RM();
    g.RK().eHt.a(this.rPO);
    AppMethodBeat.o(38825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.40.1
 * JD-Core Version:    0.7.0.1
 */