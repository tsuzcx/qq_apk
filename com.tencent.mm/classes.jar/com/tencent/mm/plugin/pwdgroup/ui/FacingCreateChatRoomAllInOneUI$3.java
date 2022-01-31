package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a;

final class FacingCreateChatRoomAllInOneUI$3
  implements MMCallBackScrollView.a
{
  FacingCreateChatRoomAllInOneUI$3(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void bX(int paramInt)
  {
    AppMethodBeat.i(23985);
    if (FacingCreateChatRoomAllInOneUI.l(this.pGF) != null)
    {
      if (paramInt == 0)
      {
        FacingCreateChatRoomAllInOneUI.l(this.pGF).setVisibility(4);
        AppMethodBeat.o(23985);
        return;
      }
      FacingCreateChatRoomAllInOneUI.l(this.pGF).setVisibility(0);
    }
    AppMethodBeat.o(23985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.3
 * JD-Core Version:    0.7.0.1
 */