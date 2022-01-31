package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class SnsTimeLineUI$47
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$47(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (SnsTimeLineUI.J(this.pfC).scene != 3)
    {
      if (paramInt != 0) {
        break label40;
      }
      SnsTimeLineUI.J(this.pfC).yS(3);
    }
    for (;;)
    {
      SnsTimeLineUI.b(SnsTimeLineUI.J(this.pfC));
      return;
      label40:
      SnsTimeLineUI.J(this.pfC).yS(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.47
 * JD-Core Version:    0.7.0.1
 */