package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
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
    AppMethodBeat.i(29039);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if (l.aSO() != l.a.jdO)
    {
      paramView = new Intent(this.BiI.getContext(), BindMContactIntroUI.class);
      paramView.putExtra("key_upload_scene", 5);
      MMWizardActivity.al(this.BiI.getContext(), paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29039);
      return;
      paramView = this.BiI;
      localObject = new Intent(this.BiI.getContext(), MobileFriendUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.3
 * JD-Core Version:    0.7.0.1
 */