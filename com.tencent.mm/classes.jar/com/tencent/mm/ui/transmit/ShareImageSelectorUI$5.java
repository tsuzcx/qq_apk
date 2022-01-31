package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareImageSelectorUI$5
  implements DialogInterface.OnClickListener
{
  ShareImageSelectorUI$5(ShareImageSelectorUI paramShareImageSelectorUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35251);
    if (ShareImageSelectorUI.access$200() == 1) {
      ShareImageSelectorUI.c(this.AAQ);
    }
    AppMethodBeat.o(35251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI.5
 * JD-Core Version:    0.7.0.1
 */