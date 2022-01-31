package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s;

final class SightForwardUI$1
  implements b
{
  SightForwardUI$1(SightForwardUI paramSightForwardUI) {}
  
  public final void bBH()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.wia.mController.uMN, LauncherUI.class).addFlags(67108864);
    this.wia.startActivity(localIntent);
    this.wia.finish();
  }
  
  public final void startChattingUI(String paramString)
  {
    Intent localIntent = new Intent(this.wia.mController.uMN, ChattingUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("Chat_User", paramString);
    this.wia.startActivity(localIntent);
    this.wia.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI.1
 * JD-Core Version:    0.7.0.1
 */