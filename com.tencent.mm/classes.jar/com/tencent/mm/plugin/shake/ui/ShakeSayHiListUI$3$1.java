package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bu;

final class ShakeSayHiListUI$3$1
  implements DialogInterface.OnClickListener
{
  ShakeSayHiListUI$3$1(ShakeSayHiListUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24875);
    ShakeSayHiListUI.e(this.qRD.qRC).axH();
    ShakeSayHiListUI.b(this.qRD.qRC).Ku();
    paramDialogInterface = (TextView)this.qRD.qRC.findViewById(2131821852);
    paramDialogInterface.setText(2131302880);
    paramDialogInterface.setVisibility(0);
    this.qRD.qRC.enableOptionMenu(false);
    AppMethodBeat.o(24875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.3.1
 * JD-Core Version:    0.7.0.1
 */