package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;

final class FMessageConversationUI$2
  implements View.OnClickListener
{
  FMessageConversationUI$2(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25359);
    Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    paramView = null;
    if (Build.VERSION.SDK_INT >= 21) {
      paramView = ActivityOptions.makeSceneTransitionAnimation(this.sYg, new Pair[0]).toBundle();
    }
    d.b(this.sYg.getContext(), ".ui.FTSAddFriendUI", localIntent, paramView);
    AppMethodBeat.o(25359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.2
 * JD-Core Version:    0.7.0.1
 */