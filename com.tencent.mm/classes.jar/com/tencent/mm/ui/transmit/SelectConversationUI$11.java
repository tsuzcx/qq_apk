package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$11
  implements c.a.b
{
  SelectConversationUI$11(SelectConversationUI paramSelectConversationUI, g.a parama) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", SelectConversationUI.i(this.whw));
    localIntent.putExtra("record_xml", this.gBQ.dRd);
    localIntent.putExtra("record_show_share", false);
    d.b(this.whw.mController.uMN, "record", ".ui.RecordMsgDetailUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.11
 * JD-Core Version:    0.7.0.1
 */