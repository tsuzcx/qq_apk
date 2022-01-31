package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RecordMsgBaseUI$3
  implements Runnable
{
  RecordMsgBaseUI$3(RecordMsgBaseUI paramRecordMsgBaseUI, View paramView) {}
  
  public final void run()
  {
    View localView = this.ntT.fry.getChildAt(this.ntT.fry.getLastVisiblePosition());
    if (localView != null)
    {
      int i = localView.getBottom();
      int j = this.ntT.fry.getBottom();
      int k = a.fromDPToPix(this.ntT.mController.uMN, 64);
      y.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i < j - k)
      {
        i = j - i - k;
        y.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(i) });
        this.ntU.setPadding(0, i, 0, 0);
      }
    }
    this.ntT.fry.addFooterView(this.ntU, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.3
 * JD-Core Version:    0.7.0.1
 */