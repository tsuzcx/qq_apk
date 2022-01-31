package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceResultOldUI$3
  implements Runnable
{
  RemittanceResultOldUI$3(RemittanceResultOldUI paramRemittanceResultOldUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45147);
    if ((RemittanceResultOldUI.c(this.qrw) == 33) || (RemittanceResultOldUI.c(this.qrw) == 32))
    {
      this.qrw.finish();
      AppMethodBeat.o(45147);
      return;
    }
    if ((!bo.isNullOrNil(RemittanceResultOldUI.d(this.qrw))) && (!RemittanceResultOldUI.e(this.qrw)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Chat_User", RemittanceResultOldUI.d(this.qrw));
      localIntent.putExtra("finish_direct", false);
      d.f(this.qrw, ".ui.chatting.ChattingUI", localIntent);
      AppMethodBeat.o(45147);
      return;
    }
    this.qrw.finish();
    AppMethodBeat.o(45147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultOldUI.3
 * JD-Core Version:    0.7.0.1
 */