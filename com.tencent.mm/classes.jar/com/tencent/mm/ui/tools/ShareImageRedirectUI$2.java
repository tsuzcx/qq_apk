package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareImageRedirectUI$2
  implements DialogInterface.OnClickListener
{
  ShareImageRedirectUI$2(ShareImageRedirectUI paramShareImageRedirectUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34929);
    this.Axv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    this.Axv.finish();
    AppMethodBeat.o(34929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImageRedirectUI.2
 * JD-Core Version:    0.7.0.1
 */