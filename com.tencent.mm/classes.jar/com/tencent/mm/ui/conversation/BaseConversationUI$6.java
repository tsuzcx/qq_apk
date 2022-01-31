package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$6
  implements OnLayoutChangedLinearLayout.a
{
  long start = 0L;
  
  BaseConversationUI$6(BaseConversationUI paramBaseConversationUI) {}
  
  public final void dDb()
  {
    AppMethodBeat.i(34054);
    if (BaseConversationUI.access$700(this.AgT) == null)
    {
      BaseConversationUI.access$702(this.AgT, AnimationUtils.loadAnimation(this.AgT, MMFragmentActivity.a.zbX));
      BaseConversationUI.access$700(this.AgT).setAnimationListener(new BaseConversationUI.6.1(this));
    }
    if (BaseConversationUI.access$1100(this.AgT))
    {
      BaseConversationUI.access$200(this.AgT).setOndispatchDraw(new BaseConversationUI.6.2(this));
      BaseConversationUI.access$1102(this.AgT, false);
    }
    for (;;)
    {
      BaseConversationUI.access$1200(this.AgT).zpz = null;
      ab.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
      AppMethodBeat.o(34054);
      return;
      BaseConversationUI.access$900(this.AgT);
      BaseConversationUI.access$1000(this.AgT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.6
 * JD-Core Version:    0.7.0.1
 */