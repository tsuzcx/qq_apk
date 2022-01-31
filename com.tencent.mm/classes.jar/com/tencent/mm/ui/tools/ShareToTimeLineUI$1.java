package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareToTimeLineUI$1
  implements DialogInterface.OnCancelListener
{
  ShareToTimeLineUI$1(ShareToTimeLineUI paramShareToTimeLineUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(34980);
    this.AxJ.finish();
    AppMethodBeat.o(34980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareToTimeLineUI.1
 * JD-Core Version:    0.7.0.1
 */