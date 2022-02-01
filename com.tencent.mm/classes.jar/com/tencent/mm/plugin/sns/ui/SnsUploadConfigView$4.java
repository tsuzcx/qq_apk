package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;

final class SnsUploadConfigView$4
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$4(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99522);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("is_force_unbind", true);
    paramDialogInterface.putExtra("shake_music", true);
    d.b(this.xKd.getContext(), "account", ".ui.FacebookAuthUI", paramDialogInterface, 8);
    AppMethodBeat.o(99522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.4
 * JD-Core Version:    0.7.0.1
 */