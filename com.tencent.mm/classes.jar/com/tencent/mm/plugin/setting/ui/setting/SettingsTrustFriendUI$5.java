package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.e;

final class SettingsTrustFriendUI$5
  implements DialogInterface.OnCancelListener
{
  SettingsTrustFriendUI$5(SettingsTrustFriendUI paramSettingsTrustFriendUI, e parame) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127536);
    g.Rc().a(this.qKB);
    AppMethodBeat.o(127536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.5
 * JD-Core Version:    0.7.0.1
 */