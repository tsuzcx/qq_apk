package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.ui.widget.MMScrollGridView;

final class FacingCreateChatRoomAllInOneUI$4
  implements Animation.AnimationListener
{
  FacingCreateChatRoomAllInOneUI$4(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FacingCreateChatRoomAllInOneUI.l(this.nbo).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.g(this.nbo).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.m(this.nbo).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.n(this.nbo).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.k(this.nbo).setVisibility(0);
    FacingCreateChatRoomAllInOneUI.o(this.nbo).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.p(this.nbo).setVisibility(8);
    FacingCreateChatRoomAllInOneUI.g(this.nbo).clearAnimation();
    FacingCreateChatRoomAllInOneUI.m(this.nbo).clearAnimation();
    FacingCreateChatRoomAllInOneUI.k(this.nbo).clearAnimation();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    FacingCreateChatRoomAllInOneUI.k(this.nbo).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.4
 * JD-Core Version:    0.7.0.1
 */