package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class EditHintView$9
  implements DialogInterface.OnClickListener
{
  EditHintView$9(EditHintView paramEditHintView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49186);
    EditHintView.p(this.AYr).dismiss();
    AppMethodBeat.o(49186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.9
 * JD-Core Version:    0.7.0.1
 */