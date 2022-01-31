package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;

final class ReadMailUI$1
  implements Runnable
{
  ReadMailUI$1(ReadMailUI paramReadMailUI) {}
  
  public final void run()
  {
    ReadMailUI.q(this.njK);
    if (ReadMailUI.r(this.njK) == 0)
    {
      ReadMailUI.s(this.njK);
      if (!ReadMailUI.t(this.njK)) {
        ReadMailUI.u(this.njK);
      }
      ReadMailUI.a(this.njK, new ReadMailProxy(ReadMailUI.l(this.njK), null, new ReadMailUI.b(this.njK), new ReadMailUI.c(this.njK)));
      ReadMailUI.v(this.njK).REMOTE_CALL("addDownloadCallback", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.1
 * JD-Core Version:    0.7.0.1
 */