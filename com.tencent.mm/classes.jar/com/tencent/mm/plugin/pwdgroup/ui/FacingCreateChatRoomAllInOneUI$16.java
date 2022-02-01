package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;

final class FacingCreateChatRoomAllInOneUI$16
  implements MMKeyBoardView.a
{
  FacingCreateChatRoomAllInOneUI$16(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void aSi(String paramString)
  {
    AppMethodBeat.i(27636);
    if (FacingCreateChatRoomAllInOneUI.g(this.Nhe) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.Nhe)) || (FacingCreateChatRoomAllInOneUI.i(this.Nhe)))
      {
        MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.Nhe);
        localMMPwdInputView.cju();
        localMMPwdInputView.aSi(paramString);
        FacingCreateChatRoomAllInOneUI.a(this.Nhe, FacingCreateChatRoomAllInOneUI.a.Nhj);
        AppMethodBeat.o(27636);
        return;
      }
      FacingCreateChatRoomAllInOneUI.g(this.Nhe).aSi(paramString);
    }
    AppMethodBeat.o(27636);
  }
  
  public final void cju()
  {
    AppMethodBeat.i(27637);
    if (FacingCreateChatRoomAllInOneUI.g(this.Nhe) != null) {
      FacingCreateChatRoomAllInOneUI.g(this.Nhe).cju();
    }
    AppMethodBeat.o(27637);
  }
  
  public final void gDE()
  {
    AppMethodBeat.i(27638);
    if (FacingCreateChatRoomAllInOneUI.g(this.Nhe) != null)
    {
      if ((FacingCreateChatRoomAllInOneUI.h(this.Nhe)) || (FacingCreateChatRoomAllInOneUI.i(this.Nhe)))
      {
        FacingCreateChatRoomAllInOneUI.g(this.Nhe).cju();
        FacingCreateChatRoomAllInOneUI.a(this.Nhe, FacingCreateChatRoomAllInOneUI.a.Nhj);
        AppMethodBeat.o(27638);
        return;
      }
      MMPwdInputView localMMPwdInputView = FacingCreateChatRoomAllInOneUI.g(this.Nhe);
      if (localMMPwdInputView.zYG > 0) {
        localMMPwdInputView.lOv.deleteCharAt(localMMPwdInputView.zYG - 1);
      }
      localMMPwdInputView.dPM();
      localMMPwdInputView.gDF();
    }
    AppMethodBeat.o(27638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.16
 * JD-Core Version:    0.7.0.1
 */