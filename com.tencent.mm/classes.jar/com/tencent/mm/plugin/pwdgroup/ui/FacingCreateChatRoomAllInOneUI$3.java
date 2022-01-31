package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.View;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a;

final class FacingCreateChatRoomAllInOneUI$3
  implements MMCallBackScrollView.a
{
  FacingCreateChatRoomAllInOneUI$3(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void bR(int paramInt)
  {
    if (FacingCreateChatRoomAllInOneUI.j(this.nbo) != null)
    {
      if (paramInt == 0) {
        FacingCreateChatRoomAllInOneUI.j(this.nbo).setVisibility(4);
      }
    }
    else {
      return;
    }
    FacingCreateChatRoomAllInOneUI.j(this.nbo).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.3
 * JD-Core Version:    0.7.0.1
 */