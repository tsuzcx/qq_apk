package com.tencent.mm.plugin.sns.ui;

final class SnsMsgUI$9
  implements Runnable
{
  SnsMsgUI$9(SnsMsgUI paramSnsMsgUI) {}
  
  public final void run()
  {
    if (SnsMsgUI.e(this.paq) == null) {
      return;
    }
    synchronized (SnsMsgUI.e(this.paq))
    {
      SnsMsgUI.e(this.paq).a(null, null);
      SnsMsgUI.t(this.paq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.9
 * JD-Core Version:    0.7.0.1
 */