package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$7
  implements c.a.b
{
  SelectConversationUI$7(SelectConversationUI paramSelectConversationUI) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35131);
    Intent localIntent = new Intent(this.AAp.getContext(), RetransmitPreviewUI.class);
    localIntent.putExtra("Retr_Msg_content", SelectConversationUI.h(this.AAp));
    this.AAp.startActivity(localIntent);
    b.jdMethod_if(this.AAp.getContext());
    AppMethodBeat.o(35131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.7
 * JD-Core Version:    0.7.0.1
 */