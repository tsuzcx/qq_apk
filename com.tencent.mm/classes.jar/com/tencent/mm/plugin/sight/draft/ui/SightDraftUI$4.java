package com.tencent.mm.plugin.sight.draft.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.aa;

final class SightDraftUI$4
  implements Runnable
{
  SightDraftUI$4(SightDraftUI paramSightDraftUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(291886);
    aa.makeText(this.PHU, this.PHU.getString(R.l.video_file_save_failed), 1).show();
    AppMethodBeat.o(291886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftUI.4
 * JD-Core Version:    0.7.0.1
 */