package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareImgUI$6
  implements DialogInterface.OnCancelListener
{
  ShareImgUI$6(ShareImgUI paramShareImgUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(34941);
    this.Axx.finish();
    AppMethodBeat.o(34941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI.6
 * JD-Core Version:    0.7.0.1
 */