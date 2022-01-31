package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.ui.MMWizardActivity;

final class FMessageConversationUI$3
  implements View.OnClickListener
{
  FMessageConversationUI$3(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25360);
    if (l.aqq() != l.a.gxB)
    {
      paramView = new Intent(this.sYg.getContext(), BindMContactIntroUI.class);
      paramView.putExtra("key_upload_scene", 5);
      MMWizardActivity.J(this.sYg.getContext(), paramView);
      AppMethodBeat.o(25360);
      return;
    }
    this.sYg.startActivity(new Intent(this.sYg.getContext(), MobileFriendUI.class));
    AppMethodBeat.o(25360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.3
 * JD-Core Version:    0.7.0.1
 */