package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class SelectConversationUI$7
  implements c.a.b
{
  SelectConversationUI$7(SelectConversationUI paramSelectConversationUI, bi.b paramb, String paramString) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 1);
    localIntent.putExtra("kwebmap_slat", this.why.lCJ);
    localIntent.putExtra("kwebmap_lng", this.why.lCK);
    localIntent.putExtra("Kwebmap_locaion", this.whz);
    localIntent.putExtra("kShowshare", false);
    d.b(this.whw.mController.uMN, "location", ".ui.RedirectUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.7
 * JD-Core Version:    0.7.0.1
 */