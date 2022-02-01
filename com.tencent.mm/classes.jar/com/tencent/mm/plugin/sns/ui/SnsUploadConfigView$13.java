package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;

final class SnsUploadConfigView$13
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$13(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99529);
    d.b(this.xKd.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
    AppMethodBeat.o(99529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.13
 * JD-Core Version:    0.7.0.1
 */