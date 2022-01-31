package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

final class FacingCreateChatRoomAllInOneUI$15
  implements MMKeyBoardView.a
{
  FacingCreateChatRoomAllInOneUI$15(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void aUK()
  {
    if (FacingCreateChatRoomAllInOneUI.g(this.nbo) != null) {
      FacingCreateChatRoomAllInOneUI.g(this.nbo).aUK();
    }
  }
  
  public final void delete()
  {
    if (FacingCreateChatRoomAllInOneUI.g(this.nbo) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.nbo)) || (FacingCreateChatRoomAllInOneUI.i(this.nbo)))
      {
        FacingCreateChatRoomAllInOneUI.g(this.nbo).aUK();
        FacingCreateChatRoomAllInOneUI.a(this.nbo, FacingCreateChatRoomAllInOneUI.a.nbs);
      }
    }
    else {
      return;
    }
    MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.nbo);
    if (localMMPwdInputView.jUY > 0) {
      localMMPwdInputView.dsX.deleteCharAt(localMMPwdInputView.jUY - 1);
    }
    localMMPwdInputView.bth();
    localMMPwdInputView.btg();
  }
  
  public final void input(String paramString)
  {
    if (FacingCreateChatRoomAllInOneUI.g(this.nbo) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.nbo)) || (FacingCreateChatRoomAllInOneUI.i(this.nbo)))
      {
        MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.nbo);
        localMMPwdInputView.aUK();
        localMMPwdInputView.input(paramString);
        FacingCreateChatRoomAllInOneUI.a(this.nbo, FacingCreateChatRoomAllInOneUI.a.nbs);
      }
    }
    else {
      return;
    }
    FacingCreateChatRoomAllInOneUI.g(this.nbo).input(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.15
 * JD-Core Version:    0.7.0.1
 */