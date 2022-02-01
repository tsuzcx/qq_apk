package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.f;

final class SettingsTrustFriendUI$5
  implements DialogInterface.OnCancelListener
{
  SettingsTrustFriendUI$5(SettingsTrustFriendUI paramSettingsTrustFriendUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(74472);
    g.aeS().a(this.wjw);
    AppMethodBeat.o(74472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.5
 * JD-Core Version:    0.7.0.1
 */