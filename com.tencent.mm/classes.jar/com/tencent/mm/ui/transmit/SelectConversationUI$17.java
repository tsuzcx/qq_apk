package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.a;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$17
  implements c.a.b
{
  SelectConversationUI$17(SelectConversationUI paramSelectConversationUI) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35140);
    Object localObject = k.il(this.AAp.getContext());
    localObject = j.b.mY(bo.apU(n.a(((oa)localObject).cEA.cEI.title, ((oa)localObject).cEA.cEI.desc, ((oa)localObject).cEA.cDZ.cpR.cpT, ((oa)localObject).cEz.cEG, SelectConversationUI.i(this.AAp))));
    if (localObject == null)
    {
      AppMethodBeat.o(35140);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("message_id", SelectConversationUI.i(this.AAp));
    localIntent.putExtra("record_xml", ((j.b)localObject).fhc);
    localIntent.putExtra("record_show_share", false);
    com.tencent.mm.bq.d.b(this.AAp.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(35140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.17
 * JD-Core Version:    0.7.0.1
 */