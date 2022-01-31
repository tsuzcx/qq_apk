package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

final class FacingCreateChatRoomAllInOneUI$15
  implements MMKeyBoardView.a
{
  FacingCreateChatRoomAllInOneUI$15(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void axH()
  {
    AppMethodBeat.i(23998);
    if (FacingCreateChatRoomAllInOneUI.g(this.pGF) != null) {
      FacingCreateChatRoomAllInOneUI.g(this.pGF).axH();
    }
    AppMethodBeat.o(23998);
  }
  
  public final void delete()
  {
    AppMethodBeat.i(23999);
    if (FacingCreateChatRoomAllInOneUI.g(this.pGF) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.pGF)) || (FacingCreateChatRoomAllInOneUI.i(this.pGF)))
      {
        FacingCreateChatRoomAllInOneUI.g(this.pGF).axH();
        FacingCreateChatRoomAllInOneUI.a(this.pGF, FacingCreateChatRoomAllInOneUI.a.pGK);
        AppMethodBeat.o(23999);
        return;
      }
      MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.pGF);
      if (localMMPwdInputView.mpr > 0) {
        localMMPwdInputView.ekE.deleteCharAt(localMMPwdInputView.mpr - 1);
      }
      localMMPwdInputView.bvD();
      localMMPwdInputView.cdo();
    }
    AppMethodBeat.o(23999);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(23997);
    if (FacingCreateChatRoomAllInOneUI.g(this.pGF) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.pGF)) || (FacingCreateChatRoomAllInOneUI.i(this.pGF)))
      {
        MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.pGF);
        localMMPwdInputView.axH();
        localMMPwdInputView.input(paramString);
        FacingCreateChatRoomAllInOneUI.a(this.pGF, FacingCreateChatRoomAllInOneUI.a.pGK);
        AppMethodBeat.o(23997);
        return;
      }
      FacingCreateChatRoomAllInOneUI.g(this.pGF).input(paramString);
    }
    AppMethodBeat.o(23997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.15
 * JD-Core Version:    0.7.0.1
 */