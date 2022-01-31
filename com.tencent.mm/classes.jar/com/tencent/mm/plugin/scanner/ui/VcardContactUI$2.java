package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$2
  implements h.c
{
  VcardContactUI$2(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(81346);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81346);
      return;
      Intent localIntent = new Intent();
      String str = this.qBM + " " + this.qBM;
      localIntent.putExtra("composeType", 4);
      localIntent.putExtra("toList", new String[] { str });
      d.b(this.qBL, "qqmail", ".ui.ComposeUI", localIntent);
      AppMethodBeat.o(81346);
      return;
      localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { this.qBM });
      this.qBL.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.2
 * JD-Core Version:    0.7.0.1
 */