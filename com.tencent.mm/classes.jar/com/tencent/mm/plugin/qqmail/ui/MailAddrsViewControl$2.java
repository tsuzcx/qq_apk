package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Button;

final class MailAddrsViewControl$2
  implements Runnable
{
  MailAddrsViewControl$2(MailAddrsViewControl paramMailAddrsViewControl, Button paramButton) {}
  
  public final void run()
  {
    this.nis.invalidate();
    this.nis.setOnTouchListener(new MailAddrsViewControl.2.1(this));
    this.nir.buk();
    this.nir.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.2
 * JD-Core Version:    0.7.0.1
 */