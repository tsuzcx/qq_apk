package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class ComposeUI$19$1
  implements DialogInterface.OnClickListener
{
  ComposeUI$19$1(ComposeUI.19 param19, MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68198);
    this.pMf.pNx.setText("");
    ComposeUI.i(this.pMg.pLX).postDelayed(new ComposeUI.19.1.1(this), 150L);
    AppMethodBeat.o(68198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.19.1
 * JD-Core Version:    0.7.0.1
 */