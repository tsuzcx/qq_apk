package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.ui.base.h;

final class SnsLabelUI$9
  implements DialogInterface.OnClickListener
{
  SnsLabelUI$9(SnsLabelUI paramSnsLabelUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39019);
    SnsLabelUI.j(this.rSh);
    a.bKV().cc(SnsLabelUI.b(this.rSh));
    SnsLabelUI.a(this.rSh, h.b(this.rSh, this.rSh.getString(2131303858), false, null));
    AppMethodBeat.o(39019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.9
 * JD-Core Version:    0.7.0.1
 */