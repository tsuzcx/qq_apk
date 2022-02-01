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
    AppMethodBeat.i(29197);
    h.wUl.f(11264, new Object[] { Integer.valueOf(1) });
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(this.zTg, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
    paramView = this.zTg.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.4
 * JD-Core Version:    0.7.0.1
 */