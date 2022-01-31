package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SnsMsgUI$8$1
  implements Runnable
{
  SnsMsgUI$8$1(SnsMsgUI.8 param8) {}
  
  public final void run()
  {
    synchronized (SnsMsgUI.e(this.pas.paq))
    {
      y.v("MicroMsg.SnsMsgUI", "comment notify");
      SnsMsgUI.o(this.pas.paq);
      SnsMsgUI.e(this.pas.paq).a(null, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.8.1
 * JD-Core Version:    0.7.0.1
 */