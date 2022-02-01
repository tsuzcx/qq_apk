package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class SnsUserUI$14
  implements DialogInterface.OnClickListener
{
  SnsUserUI$14(SnsUserUI paramSnsUserUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99640);
    paramDialogInterface.dismiss();
    b.lx(this.REI.getContext());
    AppMethodBeat.o(99640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.14
 * JD-Core Version:    0.7.0.1
 */