package com.tencent.mm.plugin.sns.ui;

final class SnsTimeLineUI$1
  implements Runnable
{
  SnsTimeLineUI$1(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    aw localaw = SnsTimeLineUI.a(this.pfC);
    if (localaw != null)
    {
      localaw.pgx.bJj();
      localaw.pgx.notifyVendingDataChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.1
 * JD-Core Version:    0.7.0.1
 */