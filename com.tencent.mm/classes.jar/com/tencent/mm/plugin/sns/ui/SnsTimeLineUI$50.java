package com.tencent.mm.plugin.sns.ui;

final class SnsTimeLineUI$50
  implements Runnable
{
  SnsTimeLineUI$50(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    if (SnsTimeLineUI.a(this.pfC) != null) {
      SnsTimeLineUI.a(this.pfC).pgx.notifyVendingDataChange();
    }
    SnsTimeLineUI.Q(this.pfC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.50
 * JD-Core Version:    0.7.0.1
 */