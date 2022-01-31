package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.e.c;

final class RemittanceDetailUI$17$1
  implements e.c
{
  RemittanceDetailUI$17$1(RemittanceDetailUI.17 param17) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(45015);
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("transaction_id", this.qqi.qpY.qpN);
      paramString.putExtra("transfer_id", this.qqi.qpY.qlT);
      paramString.putExtra("receiver_name", RemittanceDetailUI.b(this.qqi.qpY));
      paramString.putExtra("resend_msg_from_flag", 3);
      this.qqi.qpY.am(paramString);
    }
    AppMethodBeat.o(45015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.17.1
 * JD-Core Version:    0.7.0.1
 */