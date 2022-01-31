package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class i$3
  extends ak
{
  i$3(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25294);
    ab.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
    if (i.b(this.sXA))
    {
      AppMethodBeat.o(25294);
      return;
    }
    aw.aaA().b(this.sXA);
    aw.aaA().KF();
    this.sXA.gy(200);
    AppMethodBeat.o(25294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.3
 * JD-Core Version:    0.7.0.1
 */