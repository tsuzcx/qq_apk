package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;

final class SnsCommentDetailUI$8
  implements DialogInterface.OnCancelListener
{
  SnsCommentDetailUI$8(SnsCommentDetailUI paramSnsCommentDetailUI, com.tencent.mm.plugin.sns.model.s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(308299);
    h.baF();
    h.baD().mCm.a(this.RpK);
    AppMethodBeat.o(308299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.8
 * JD-Core Version:    0.7.0.1
 */