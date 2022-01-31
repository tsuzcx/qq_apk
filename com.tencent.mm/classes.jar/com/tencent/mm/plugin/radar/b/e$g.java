package com.tencent.mm.plugin.radar.b;

import android.os.Message;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.sdk.platformtools.ah;

public final class e$g
  extends ah
{
  public final void handleMessage(Message paramMessage)
  {
    a.d.b.g.k(paramMessage, "msg");
    int i = paramMessage.what;
    paramMessage = e.nlp;
    if (i == e.buC()) {
      com.tencent.mm.kernel.g.Dk().d((m)new b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.g
 * JD-Core Version:    0.7.0.1
 */