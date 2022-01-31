package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bg;

final class NearbySayHiListUI$5$1
  implements DialogInterface.OnClickListener
{
  NearbySayHiListUI$5$1(NearbySayHiListUI.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(55497);
    NearbySayHiListUI.e(this.pdS.pdR).axH();
    NearbySayHiListUI.b(this.pdS.pdR).Ku();
    paramDialogInterface = (TextView)this.pdS.pdR.findViewById(2131821852);
    paramDialogInterface.setText(2131302880);
    paramDialogInterface.setVisibility(0);
    this.pdS.pdR.enableOptionMenu(false);
    AppMethodBeat.o(55497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5.1
 * JD-Core Version:    0.7.0.1
 */