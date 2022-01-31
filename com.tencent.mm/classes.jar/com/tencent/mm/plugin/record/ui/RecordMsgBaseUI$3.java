package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

final class RecordMsgBaseUI$3
  implements Runnable
{
  RecordMsgBaseUI$3(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(24233);
    View localView = this.pZB.gJa.getChildAt(this.pZB.gJa.getLastVisiblePosition());
    if ((localView != null) && (RecordMsgBaseUI.a(this.pZB) != null) && (RecordMsgBaseUI.a(this.pZB).getVisibility() == 0))
    {
      int j = localView.getBottom();
      int k = this.pZB.gJa.getBottom();
      ab.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      int i = a.fromDPToPix(this.pZB.getContext(), 64);
      if (k - j > 0)
      {
        j = k - j + a.fromDPToPix(this.pZB.getContext(), 15);
        ab.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
        if (j > i) {
          RecordMsgBaseUI.a(this.pZB).setPadding(0, j, 0, 0);
        }
      }
    }
    AppMethodBeat.o(24233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.3
 * JD-Core Version:    0.7.0.1
 */