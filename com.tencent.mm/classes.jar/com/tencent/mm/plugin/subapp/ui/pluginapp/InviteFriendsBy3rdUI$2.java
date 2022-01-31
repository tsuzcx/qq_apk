package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.widget.EditText;
import com.tencent.mm.pluginsdk.ui.applet.q.b;

final class InviteFriendsBy3rdUI$2
  implements q.b
{
  InviteFriendsBy3rdUI$2(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI, String paramString, int paramInt) {}
  
  public final void hc(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (InviteFriendsBy3rdUI.b(this.pyd) != null) {
        break label32;
      }
    }
    label32:
    for (String str = this.fEp;; str = InviteFriendsBy3rdUI.b(this.pyd).getText().toString())
    {
      InviteFriendsBy3rdUI.a(this.pyd, this.lys, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.2
 * JD-Core Version:    0.7.0.1
 */