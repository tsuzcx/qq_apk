package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class RecordMsgDetailUI$3$2$1
  implements DialogInterface.OnClickListener
{
  RecordMsgDetailUI$3$2$1(RecordMsgDetailUI.3.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153608);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 10);
    localIntent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(this.pZJ.pZI.pZH));
    d.b(this.pZJ.pZI.pZH, ".ui.transmit.SelectConversationUI", localIntent, 1001);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(153608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3.2.1
 * JD-Core Version:    0.7.0.1
 */