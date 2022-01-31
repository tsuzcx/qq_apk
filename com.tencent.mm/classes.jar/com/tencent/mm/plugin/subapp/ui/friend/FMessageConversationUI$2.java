package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FMessageConversationUI$2
  implements View.OnClickListener
{
  FMessageConversationUI$2(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    paramView = null;
    if (Build.VERSION.SDK_INT >= 21) {
      paramView = ActivityOptions.makeSceneTransitionAnimation(this.pwx, new Pair[0]).toBundle();
    }
    d.b(this.pwx.mController.uMN, ".ui.FTSAddFriendUI", localIntent, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.2
 * JD-Core Version:    0.7.0.1
 */