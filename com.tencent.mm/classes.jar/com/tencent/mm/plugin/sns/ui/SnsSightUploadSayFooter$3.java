package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsSightUploadSayFooter$3
  implements Runnable
{
  SnsSightUploadSayFooter$3(SnsSightUploadSayFooter paramSnsSightUploadSayFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(39287);
    SnsSightUploadSayFooter.b(this.rWa).performClick();
    SnsSightUploadSayFooter.b(this.rWa).requestFocus();
    SnsSightUploadSayFooter.c(this.rWa).showVKB();
    AppMethodBeat.o(39287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.3
 * JD-Core Version:    0.7.0.1
 */