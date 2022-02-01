package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

final class FacingCreateChatRoomAllInOneUI$9
  implements Animation.AnimationListener
{
  FacingCreateChatRoomAllInOneUI$9(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI, Animation paramAnimation) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(27630);
    FacingCreateChatRoomAllInOneUI.g(this.Nhe).cju();
    FacingCreateChatRoomAllInOneUI.g(this.Nhe).startAnimation(this.Nhg);
    AppMethodBeat.o(27630);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.9
 * JD-Core Version:    0.7.0.1
 */