package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;

final class ShareToQQUI$6
  implements DialogInterface.OnClickListener
{
  ShareToQQUI$6(ShareToQQUI paramShareToQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(126925);
    paramDialogInterface = new Intent(this.qFA.getContext(), FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.qFA.getContext().startActivityForResult(paramDialogInterface, 8);
    AppMethodBeat.o(126925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.6
 * JD-Core Version:    0.7.0.1
 */