package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

final class FacingCreateChatRoomAllInOneUI$15
  implements MMKeyBoardView.a
{
  FacingCreateChatRoomAllInOneUI$15(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void aVa(String paramString)
  {
    AppMethodBeat.i(27636);
    if (FacingCreateChatRoomAllInOneUI.g(this.Hjr) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.Hjr)) || (FacingCreateChatRoomAllInOneUI.i(this.Hjr)))
      {
        MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.Hjr);
        localMMPwdInputView.bJQ();
        localMMPwdInputView.aVa(paramString);
        FacingCreateChatRoomAllInOneUI.a(this.Hjr, FacingCreateChatRoomAllInOneUI.a.Hjw);
        AppMethodBeat.o(27636);
        return;
      }
      FacingCreateChatRoomAllInOneUI.g(this.Hjr).aVa(paramString);
    }
    AppMethodBeat.o(27636);
  }
  
  public final void bJQ()
  {
    AppMethodBeat.i(27637);
    if (FacingCreateChatRoomAllInOneUI.g(this.Hjr) != null) {
      FacingCreateChatRoomAllInOneUI.g(this.Hjr).bJQ();
    }
    AppMethodBeat.o(27637);
  }
  
  public final void frW()
  {
    AppMethodBeat.i(27638);
    if (FacingCreateChatRoomAllInOneUI.g(this.Hjr) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.Hjr)) || (FacingCreateChatRoomAllInOneUI.i(this.Hjr)))
      {
        FacingCreateChatRoomAllInOneUI.g(this.Hjr).bJQ();
        FacingCreateChatRoomAllInOneUI.a(this.Hjr, FacingCreateChatRoomAllInOneUI.a.Hjw);
        AppMethodBeat.o(27638);
        return;
      }
      MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.Hjr);
      if (localMMPwdInputView.wCv > 0) {
        localMMPwdInputView.jlE.deleteCharAt(localMMPwdInputView.wCv - 1);
      }
      localMMPwdInputView.djb();
      localMMPwdInputView.frX();
    }
    AppMethodBeat.o(27638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.15
 * JD-Core Version:    0.7.0.1
 */