package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;

final class RemittanceResultOldUI$3
  implements Runnable
{
  RemittanceResultOldUI$3(RemittanceResultOldUI paramRemittanceResultOldUI) {}
  
  public final void run()
  {
    if ((RemittanceResultOldUI.c(this.nEx) == 33) || (RemittanceResultOldUI.c(this.nEx) == 32))
    {
      this.nEx.finish();
      return;
    }
    if ((!bk.bl(RemittanceResultOldUI.d(this.nEx))) && (!RemittanceResultOldUI.e(this.nEx)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Chat_User", RemittanceResultOldUI.d(this.nEx));
      localIntent.putExtra("finish_direct", false);
      d.e(this.nEx, ".ui.chatting.ChattingUI", localIntent);
      return;
    }
    this.nEx.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.3
 * JD-Core Version:    0.7.0.1
 */