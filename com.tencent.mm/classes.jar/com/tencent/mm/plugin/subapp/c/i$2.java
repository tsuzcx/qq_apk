package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.sdk.platformtools.ab;

final class i$2
  implements j.a
{
  i$2(i parami) {}
  
  public final void onError()
  {
    AppMethodBeat.i(25293);
    ab.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.a(this.sXA));
    i.adT(i.a(this.sXA));
    if (this.sXA.sXu != null) {
      this.sXA.sXu.onError();
    }
    AppMethodBeat.o(25293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i.2
 * JD-Core Version:    0.7.0.1
 */