package com.tencent.mm.plugin.record.ui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class RecordMsgFileUI$3
  implements Runnable
{
  RecordMsgFileUI$3(RecordMsgFileUI paramRecordMsgFileUI, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(24255);
    RecordMsgFileUI.n(this.pZN).setProgress(this.gQj);
    RecordMsgFileUI.o(this.pZN).setText(this.pZN.getString(2131299700, new Object[] { bo.aJ(this.fzv), bo.aJ(this.pZP) }));
    AppMethodBeat.o(24255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.3
 * JD-Core Version:    0.7.0.1
 */