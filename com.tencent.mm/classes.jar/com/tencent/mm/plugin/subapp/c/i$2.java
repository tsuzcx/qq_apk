package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ah.j.a;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  implements j.a
{
  i$2(i parami) {}
  
  public final void onError()
  {
    y.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.a(this.pvU));
    i.PD(i.a(this.pvU));
    if (this.pvU.pvO != null) {
      this.pvU.pvO.onError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.2
 * JD-Core Version:    0.7.0.1
 */