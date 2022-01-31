package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$26
  implements Runnable
{
  SnsTimeLineUI$26(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.C(this.pfC));
    if (SnsTimeLineUI.C(this.pfC))
    {
      SnsTimeLineUI.D(this.pfC);
      SnsTimeLineUI.E(this.pfC).bJL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.26
 * JD-Core Version:    0.7.0.1
 */