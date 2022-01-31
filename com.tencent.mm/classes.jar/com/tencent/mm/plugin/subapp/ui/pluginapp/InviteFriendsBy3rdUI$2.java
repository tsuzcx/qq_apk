package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.b;

final class InviteFriendsBy3rdUI$2
  implements q.b
{
  InviteFriendsBy3rdUI$2(InviteFriendsBy3rdUI paramInviteFriendsBy3rdUI, String paramString, int paramInt) {}
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(25539);
    if (paramBoolean)
    {
      if (InviteFriendsBy3rdUI.b(this.sZR) == null) {}
      for (String str = this.gWF;; str = InviteFriendsBy3rdUI.b(this.sZR).getText().toString())
      {
        InviteFriendsBy3rdUI.a(this.sZR, this.nVE, str);
        AppMethodBeat.o(25539);
        return;
      }
    }
    AppMethodBeat.o(25539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.InviteFriendsBy3rdUI.2
 * JD-Core Version:    0.7.0.1
 */