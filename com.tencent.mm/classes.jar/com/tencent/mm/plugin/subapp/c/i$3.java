package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class i$3
  extends ah
{
  i$3(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    y.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
    if (i.b(this.pvU)) {
      return;
    }
    au.Hy().b(this.pvU);
    au.Hy().yl();
    this.pvU.ew(200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.3
 * JD-Core Version:    0.7.0.1
 */