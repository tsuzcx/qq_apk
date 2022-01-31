package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.y;

final class BaseVoicePrintUI$1
  implements p.a
{
  BaseVoicePrintUI$1(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void bPd()
  {
    p localp = BaseVoicePrintUI.a(this.pMb);
    if (localp.byP != null)
    {
      localp.byP.uh();
      y.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
    }
    localp.fileName = "";
    localp.pLH = null;
    localp.pvS = 0;
    localp.jlU = 0L;
    if (localp.eLi != null) {
      localp.eLi.zE();
    }
    y.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
    BaseVoicePrintUI.a(this.pMb, null);
    BaseVoicePrintUI.b(this.pMb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.1
 * JD-Core Version:    0.7.0.1
 */