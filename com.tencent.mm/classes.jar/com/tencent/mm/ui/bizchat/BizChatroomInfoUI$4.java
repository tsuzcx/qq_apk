package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.s;

final class BizChatroomInfoUI$4
  implements Runnable
{
  BizChatroomInfoUI$4(BizChatroomInfoUI paramBizChatroomInfoUI, int paramInt) {}
  
  public final void run()
  {
    View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(this.vfX)).a(this.doB, this.vfX.lwE);
    if (localView != null) {
      com.tencent.mm.ui.g.a.a(this.vfX.mController.uMN, localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.4
 * JD-Core Version:    0.7.0.1
 */