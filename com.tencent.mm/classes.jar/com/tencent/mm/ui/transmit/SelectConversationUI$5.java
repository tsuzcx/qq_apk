package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$5
  implements c.a.b
{
  SelectConversationUI$5(SelectConversationUI paramSelectConversationUI) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent(this.whw.mController.uMN, RetransmitPreviewUI.class);
    localIntent.putExtra("Retr_Msg_content", SelectConversationUI.h(this.whw));
    this.whw.startActivity(localIntent);
    b.gJ(this.whw.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.5
 * JD-Core Version:    0.7.0.1
 */