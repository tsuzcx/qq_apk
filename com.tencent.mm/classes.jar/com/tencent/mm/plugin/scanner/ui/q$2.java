package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class q$2
  extends ak
{
  q$2(q paramq) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(81240);
    if (q.h(this.qAv) != null)
    {
      this.qAv.qzg.kA(true);
      q.h(this.qAv).setText(2131302942);
      q.h(this.qAv).setVisibility(0);
    }
    AppMethodBeat.o(81240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q.2
 * JD-Core Version:    0.7.0.1
 */