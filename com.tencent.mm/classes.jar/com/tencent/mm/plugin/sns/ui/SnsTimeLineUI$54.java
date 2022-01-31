package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsTimeLineUI$54
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$54(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155762);
    if (SnsTimeLineUI.P(this.rYv).scene != 3)
    {
      if (paramInt != 0) {
        break label50;
      }
      SnsTimeLineUI.P(this.rYv).Fb(3);
    }
    for (;;)
    {
      SnsTimeLineUI.b(SnsTimeLineUI.P(this.rYv));
      AppMethodBeat.o(155762);
      return;
      label50:
      SnsTimeLineUI.P(this.rYv).Fb(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.54
 * JD-Core Version:    0.7.0.1
 */