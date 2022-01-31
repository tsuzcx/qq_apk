package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class BaseConversationUI$9
  implements Animation.AnimationListener
{
  BaseConversationUI$9(BaseConversationUI paramBaseConversationUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(34061);
    aw.RO().dtd();
    al.Nf(0);
    BaseConversationUI.access$600(this.AgT);
    ab.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
    AppMethodBeat.o(34061);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(34060);
    aw.RO().dtb();
    al.Nf(-8);
    ab.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
    this.AgT.onSettle(true, 0);
    AppMethodBeat.o(34060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.9
 * JD-Core Version:    0.7.0.1
 */