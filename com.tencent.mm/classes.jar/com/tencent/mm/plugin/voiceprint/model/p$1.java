package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class p$1
  extends ah
{
  public p$1(p paramp) {}
  
  public final void handleMessage(Message paramMessage)
  {
    y.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
    if (p.a(this.pLL)) {
      return;
    }
    au.Hy().b(this.pLL);
    au.Hy().yl();
    this.pLL.ew(200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.p.1
 * JD-Core Version:    0.7.0.1
 */