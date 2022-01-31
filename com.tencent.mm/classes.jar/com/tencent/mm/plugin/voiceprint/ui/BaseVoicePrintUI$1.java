package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseVoicePrintUI$1
  implements p.a
{
  BaseVoicePrintUI$1(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void cLj()
  {
    AppMethodBeat.i(26130);
    p localp = BaseVoicePrintUI.a(this.trX);
    if (localp.caR != null)
    {
      localp.caR.Et();
      ab.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
    }
    localp.fileName = "";
    localp.trD = null;
    localp.sXy = 0;
    localp.lvI = 0L;
    if (localp.gaP != null) {
      localp.gaP.Mh();
    }
    ab.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
    BaseVoicePrintUI.a(this.trX, null);
    BaseVoicePrintUI.b(this.trX);
    AppMethodBeat.o(26130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.1
 * JD-Core Version:    0.7.0.1
 */