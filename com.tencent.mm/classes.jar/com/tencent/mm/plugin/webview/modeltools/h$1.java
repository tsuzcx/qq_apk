package com.tencent.mm.plugin.webview.modeltools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.widget.MMWebView;

final class h$1
  implements ak.a
{
  h$1(h paramh) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(7007);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7007);
      return false;
      paramMessage = this.uYl.uYh.getBitmap();
      if (paramMessage != null)
      {
        d.post(new h.b(this.uYl, paramMessage), "ViewCaptureHelper_SaveBitmap");
        this.uYl.uYh = null;
        continue;
        if (this.uYl.uYj != null) {
          this.uYl.uYj.Dd(this.uYl.uYi);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.1
 * JD-Core Version:    0.7.0.1
 */