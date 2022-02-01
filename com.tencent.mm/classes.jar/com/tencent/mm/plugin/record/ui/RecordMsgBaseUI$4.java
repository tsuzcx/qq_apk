package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

final class RecordMsgBaseUI$4
  implements Runnable
{
  RecordMsgBaseUI$4(RecordMsgBaseUI paramRecordMsgBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(27875);
    View localView = this.BHY.krb.getChildAt(this.BHY.krb.getLastVisiblePosition());
    if ((localView != null) && (RecordMsgBaseUI.a(this.BHY) != null) && (RecordMsgBaseUI.a(this.BHY).getVisibility() == 0))
    {
      int j = localView.getBottom();
      int k = this.BHY.krb.getBottom();
      Log.d("MicroMsg.RecordMsgBaseUI", "footerBotm %d, listBotm %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      int i = a.fromDPToPix(this.BHY.getContext(), 64);
      if (k - j > 0)
      {
        j = k - j + a.fromDPToPix(this.BHY.getContext(), 15);
        Log.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[] { Integer.valueOf(j) });
        if (j > i) {
          RecordMsgBaseUI.a(this.BHY).setPadding(0, j, 0, 0);
        }
      }
    }
    AppMethodBeat.o(27875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgBaseUI.4
 * JD-Core Version:    0.7.0.1
 */