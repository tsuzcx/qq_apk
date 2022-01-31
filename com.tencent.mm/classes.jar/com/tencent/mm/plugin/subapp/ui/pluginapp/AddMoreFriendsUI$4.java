package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class AddMoreFriendsUI$4
  implements View.OnClickListener
{
  AddMoreFriendsUI$4(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25507);
    h.qsU.e(11264, new Object[] { Integer.valueOf(1) });
    paramView = new Intent();
    paramView.setClassName(this.sZu, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
    this.sZu.getContext().startActivity(paramView);
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */