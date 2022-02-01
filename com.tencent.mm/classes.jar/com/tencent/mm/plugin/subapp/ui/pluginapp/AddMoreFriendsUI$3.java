package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.ui.aw;

final class AddMoreFriendsUI$3
  implements View.OnClickListener
{
  AddMoreFriendsUI$3(AddMoreFriendsUI paramAddMoreFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29196);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    localb = null;
    paramView = localb;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView = localb;
      if (!aw.isDarkMode()) {
        paramView = ActivityOptions.makeSceneTransitionAnimation(this.SIv, new Pair[0]).toBundle();
      }
    }
    d.b(this.SIv.getContext(), ".ui.FTSAddFriendUI", localIntent, paramView);
    a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */