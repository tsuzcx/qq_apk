package com.tencent.mm.plugin.record.ui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;

final class RecordMsgFileUI$3
  implements Runnable
{
  RecordMsgFileUI$3(RecordMsgFileUI paramRecordMsgFileUI, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    RecordMsgFileUI.n(this.nue).setProgress(this.fyT);
    RecordMsgFileUI.o(this.nue).setText(this.nue.getString(R.l.favorite_downloading, new Object[] { bk.ar(this.ejr), bk.ar(this.nug) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.3
 * JD-Core Version:    0.7.0.1
 */