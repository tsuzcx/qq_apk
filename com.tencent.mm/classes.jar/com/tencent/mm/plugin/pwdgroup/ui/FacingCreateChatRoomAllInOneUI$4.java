package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.ui.widget.MMScrollGridView;

final class FacingCreateChatRoomAllInOneUI$4
  implements Animation.AnimationListener
{
  FacingCreateChatRoomAllInOneUI$4(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(23987);
    FacingCreateChatRoomAllInOneUI.n(this.pGF).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.g(this.pGF).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.o(this.pGF).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.p(this.pGF).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.m(this.pGF).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.q(this.pGF).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.r(this.pGF).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.g(this.pGF).clearAnimation();
    FacingCreateChatRoomAllInOneUI.o(this.pGF).clearAnimation();
    FacingCreateChatRoomAllInOneUI.m(this.pGF).clearAnimation();
    AppMethodBeat.o(23987);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(23986);
    FacingCreateChatRoomAllInOneUI.m(this.pGF).setVisibility(4);
    AppMethodBeat.o(23986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.4
 * JD-Core Version:    0.7.0.1
 */