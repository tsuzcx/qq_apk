package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.am.a;

final class ReadMailUI$4
  implements am.a
{
  ReadMailUI$4(ReadMailUI paramReadMailUI) {}
  
  public final boolean tC()
  {
    if (!ReadMailUI.l(this.njK).isConnected()) {
      return false;
    }
    double d = ((Double)new ReadMailProxy(ReadMailUI.l(this.njK), null).REMOTE_CALL("getMailAppDownloadProgress", new Object[] { Long.valueOf(ReadMailUI.B(this.njK)) })).doubleValue();
    if (d == 1.0D)
    {
      ReadMailUI.t(this.njK);
      return false;
    }
    if (ReadMailUI.N(this.njK) == 0) {
      ReadMailUI.c(this.njK, ReadMailUI.O(this.njK).getWidth());
    }
    for (int i = 0;; i = (int)(ReadMailUI.N(this.njK) * d))
    {
      ReadMailUI.b(this.njK, i);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.4
 * JD-Core Version:    0.7.0.1
 */