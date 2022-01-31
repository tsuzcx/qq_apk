package com.tencent.mm.plugin.webview.modeltools;

import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.ui.widget.MMWebView;

final class h$1
  implements ah.a
{
  h$1(h paramh) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = this.riL.riH.getBitmap();
      if (paramMessage != null)
      {
        e.post(new h.b(this.riL, paramMessage), "ViewCaptureHelper_SaveBitmap");
        this.riL.riH = null;
        continue;
        if (this.riL.riJ != null) {
          this.riL.riJ.uL(this.riL.riI);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.1
 * JD-Core Version:    0.7.0.1
 */