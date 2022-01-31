package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MailAddrsViewControl$2
  implements Runnable
{
  MailAddrsViewControl$2(MailAddrsViewControl paramMailAddrsViewControl, Button paramButton) {}
  
  public final void run()
  {
    AppMethodBeat.i(68339);
    this.pNF.invalidate();
    this.pNF.setOnTouchListener(new MailAddrsViewControl.2.1(this));
    this.pNE.cew();
    this.pNE.invalidate();
    AppMethodBeat.o(68339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2
 * JD-Core Version:    0.7.0.1
 */