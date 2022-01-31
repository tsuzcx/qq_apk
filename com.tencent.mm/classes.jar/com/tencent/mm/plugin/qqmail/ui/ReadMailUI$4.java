package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ReadMailUI$4
  implements ap.a
{
  ReadMailUI$4(ReadMailUI paramReadMailUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(68423);
    if (!ReadMailUI.l(this.pOX).isConnected())
    {
      AppMethodBeat.o(68423);
      return false;
    }
    double d = ((Double)new ReadMailProxy(ReadMailUI.l(this.pOX), null).REMOTE_CALL("getMailAppDownloadProgress", new Object[] { Long.valueOf(ReadMailUI.B(this.pOX)) })).doubleValue();
    if (d == 1.0D)
    {
      ReadMailUI.t(this.pOX);
      AppMethodBeat.o(68423);
      return false;
    }
    if (ReadMailUI.N(this.pOX) == 0) {
      ReadMailUI.c(this.pOX, ReadMailUI.O(this.pOX).getWidth());
    }
    for (int i = 0;; i = (int)(ReadMailUI.N(this.pOX) * d))
    {
      ReadMailUI.b(this.pOX, i);
      AppMethodBeat.o(68423);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.4
 * JD-Core Version:    0.7.0.1
 */