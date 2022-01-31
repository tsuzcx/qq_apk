package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.f.b.j.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class k$2
  implements j.a
{
  public k$2(k paramk) {}
  
  public final void onError()
  {
    y.e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
    k.a(this.rGm).stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.2
 * JD-Core Version:    0.7.0.1
 */