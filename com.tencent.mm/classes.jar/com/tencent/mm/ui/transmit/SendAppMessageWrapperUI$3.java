package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SendAppMessageWrapperUI$3
  implements c.a.b
{
  SendAppMessageWrapperUI$3(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, j.b paramb) {}
  
  public final void byw()
  {
    AppMethodBeat.i(154015);
    Intent localIntent = new Intent();
    localIntent.putExtra("record_xml", this.iaj.fhc);
    localIntent.putExtra("record_show_share", false);
    localIntent.putExtra("record_app_id", SendAppMessageWrapperUI.d(this.AAH).field_appId);
    d.b(this.AAH.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
    AppMethodBeat.o(154015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.3
 * JD-Core Version:    0.7.0.1
 */