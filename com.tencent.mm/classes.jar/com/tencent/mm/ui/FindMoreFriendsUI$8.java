package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;

final class FindMoreFriendsUI$8
  implements View.OnClickListener
{
  FindMoreFriendsUI$8(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29217);
    this.yWI.startActivity(new Intent(this.yWI.getContext(), SettingsManageFindMoreUI.class));
    AppMethodBeat.o(29217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.8
 * JD-Core Version:    0.7.0.1
 */