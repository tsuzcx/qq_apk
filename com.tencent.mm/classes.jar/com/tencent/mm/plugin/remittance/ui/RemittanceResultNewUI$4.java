package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;

final class RemittanceResultNewUI$4
  implements Runnable
{
  RemittanceResultNewUI$4(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final void run()
  {
    if ((RemittanceResultNewUI.c(this.nEw) == 33) || (RemittanceResultNewUI.c(this.nEw) == 32) || (RemittanceResultNewUI.c(this.nEw) == 48))
    {
      this.nEw.finish();
      return;
    }
    if ((!bk.bl(RemittanceResultNewUI.d(this.nEw))) && (!RemittanceResultNewUI.e(this.nEw)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Chat_User", RemittanceResultNewUI.d(this.nEw));
      localIntent.putExtra("finish_direct", false);
      d.e(this.nEw, ".ui.chatting.ChattingUI", localIntent);
      return;
    }
    this.nEw.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.4
 * JD-Core Version:    0.7.0.1
 */