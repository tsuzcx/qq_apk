package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI;

final class FindMoreFriendsUI$10
  implements View.OnClickListener
{
  FindMoreFriendsUI$10(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33042);
    paramView = this.FJN;
    Object localObject = new Intent(this.FJN.getContext(), SettingsManageFindMoreUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/FindMoreFriendsUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/FindMoreFriendsUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */