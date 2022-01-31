package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.a;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$15
  implements c.a.b
{
  SelectConversationUI$15(SelectConversationUI paramSelectConversationUI) {}
  
  public final void aSe()
  {
    Object localObject = l.gQ(this.whw.mController.uMN);
    localObject = g.a.gp(bk.ZQ(h.a(((nd)localObject).bWK.bWS.title, ((nd)localObject).bWK.bWS.desc, ((nd)localObject).bWK.bWm.bIw.bIy, ((nd)localObject).bWJ.bWQ)));
    if (localObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", SelectConversationUI.i(this.whw));
    localIntent.putExtra("record_xml", ((g.a)localObject).dRd);
    localIntent.putExtra("record_show_share", false);
    com.tencent.mm.br.d.b(this.whw.mController.uMN, "record", ".ui.RecordMsgDetailUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.15
 * JD-Core Version:    0.7.0.1
 */