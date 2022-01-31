package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CreateAvatarUI$3
  implements DialogInterface.OnCancelListener
{
  CreateAvatarUI$3(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7355);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(7355);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(7355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.3
 * JD-Core Version:    0.7.0.1
 */