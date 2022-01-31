package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceResultNewUI$8
  implements Runnable
{
  RemittanceResultNewUI$8(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(45122);
    if ((RemittanceResultNewUI.k(this.qru) == 33) || (RemittanceResultNewUI.k(this.qru) == 32) || (RemittanceResultNewUI.k(this.qru) == 48))
    {
      this.qru.finish();
      AppMethodBeat.o(45122);
      return;
    }
    if ((!bo.isNullOrNil(RemittanceResultNewUI.l(this.qru))) && (!RemittanceResultNewUI.m(this.qru)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Chat_User", RemittanceResultNewUI.l(this.qru));
      localIntent.putExtra("finish_direct", false);
      d.f(this.qru, ".ui.chatting.ChattingUI", localIntent);
      AppMethodBeat.o(45122);
      return;
    }
    this.qru.finish();
    AppMethodBeat.o(45122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.8
 * JD-Core Version:    0.7.0.1
 */