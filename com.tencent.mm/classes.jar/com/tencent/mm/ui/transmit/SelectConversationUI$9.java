package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$9
  implements c.a.b
{
  SelectConversationUI$9(SelectConversationUI paramSelectConversationUI, bi.b paramb, String paramString) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35133);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 1);
    localIntent.putExtra("kwebmap_slat", this.AAs.nZV);
    localIntent.putExtra("kwebmap_lng", this.AAs.nZW);
    localIntent.putExtra("Kwebmap_locaion", this.AAt);
    localIntent.putExtra("kShowshare", false);
    d.b(this.AAp.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.9
 * JD-Core Version:    0.7.0.1
 */