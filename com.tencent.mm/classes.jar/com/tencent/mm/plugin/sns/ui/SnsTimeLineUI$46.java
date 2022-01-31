package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class SnsTimeLineUI$46
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$46(SnsTimeLineUI paramSnsTimeLineUI, SnsTimeLineUI.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SnsTimeLineUI.J(this.pfC).yS(1);
    SnsTimeLineUI.b(SnsTimeLineUI.J(this.pfC));
    switch (this.pfN.type)
    {
    case 1: 
    default: 
      return;
    case 2: 
      SnsTimeLineUI.M(this.pfC);
      return;
    }
    SnsTimeLineUI.N(this.pfC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.46
 * JD-Core Version:    0.7.0.1
 */