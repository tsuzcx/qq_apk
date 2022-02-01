package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.b;

final class SettingsTrustFriendUI$2
  implements DialogInterface.OnCancelListener
{
  SettingsTrustFriendUI$2(SettingsTrustFriendUI paramSettingsTrustFriendUI, b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(74469);
    g.agi().a(this.xuL);
    AppMethodBeat.o(74469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.2
 * JD-Core Version:    0.7.0.1
 */